import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class KitapManager extends Veritabani {

    static Scanner scan = new Scanner(System.in);

    public static void kitapMenu() throws InterruptedException {
        String tercih = "";
        do {// TODO Kullanıcı Çıkış Yapmadığı sürece menüde kalalım...
            System.out.println(
                    "\n============ TECHNO STUDY BOOTCAMP ============\n" +
                            "================== KITAP MENU =================\n" +
                            "\t   1- Kitap Listesi Yazdir\n" +
                            "\t   2- Yazardan Kitap Bulma\n" +
                            "\t   3- Kitap Turu veya Yayin Tarihi Ile Kitap Bulma\n" +
                            "\t   4- Bilgilerini Girerek Kitap Ekleme\n" +
                            "\t   5- Kitap Ismi Ile Kayit Silme \t\n" +
                            "\t   6- Kitap Odunc Al \t\n" +
                            "\t   7- Kitap Iade Et \t\n" +
                            "\t   A- ANAMENU\n" +
                            "\t   Q- CIKIS");
            System.out.println("Lütfen seçiminizi yapınız...");
            tercih = scan.nextLine();

            //TODO Kullanıcıdan alacağınız tercihe göre ilgili menü metodlarına yönlendirmeler yapın...

            switch (tercih.toLowerCase()){
                case "1":
                kitapListesiYazdir();
                    // Yazar Ismiyle Kitap Bulma
                break;
                case "2":
                yazardanKitapBulma();
                // Kitap Turu veya Yayin Tarihi Ile Kitap Bulma
                    break;
                case "3":
                turVeyaYayinTarihiIleKitapBulma();
                // Bilgilerini Girerek Kitap Ekleme
                    break;
                case "4":
                kitapEkle();
                break;
                case "5":
                isimIleKitapSilme();
                break;
                case "6":
                kitapOduncAl();
                break;
                case "7":
                kitapIadeEt();
                break;
                case "a":
                Helper.anaMenu();
                break;
                case "q":
                Helper.projeDurdur();
                break;
                default:
                System.out.println("Lutfen gecerli bir tercih giriniz");
                break;
            }
        } while (!tercih.equalsIgnoreCase("q"));
        Helper.projeDurdur();

    }

    public static void kitapOduncAl() {
        System.out.println("Odunc almak istediginiz kitabin ismini giriniz: ");
        String kitapAdi = scan.nextLine();

        String kitapBilgileri = kitaplarMap.get(kitapAdi);
        if (kitapAdi!=null){
            if (!oduncAlinanlar.containsKey(kitapAdi)){
                oduncAlinanlar.put(kitapAdi,kitapBilgileri);
                kitaplarMap.remove(kitapAdi);
            }
        } else {
            System.out.println("Aradığınız kitap bulunamadı...");
        }
        //TODO Kullanıcıdan alacağınız kitap ismiyle (Map te var olmalı)
        //TODO kitap ödünç alma metodunu tamamlayın...
        //NOT: Veritabanı'nda ödünç almayla alakalı ikinci bir map 'i tampon gibi kullanmalısınız...
        //Ödünç alındığında kitaplarMap 'ten düşüp bu map e eklenecek...
    }


    public static void kitapIadeEt() {
        System.out.println("Iade etmek istediginiz kitabin ismini giriniz: ");
        String kitapAdi = scan.nextLine();

        for (Map.Entry<String, String> oa: oduncAlinanlar.entrySet()) {
            if (oa.getKey().equalsIgnoreCase(kitapAdi)){
                kitaplarMap.put(oa.getKey(),oa.getValue());
                oduncAlinanlar.remove(oa.getKey(),oa.getValue());
            } else {
                System.out.println("Aradığınız kitap bulunamadı...");
            }
        }
        //TODO Kullanıcıdan alacağınız kitap ismiyle (Map te var olmalı)
        //TODO kitap iade etme metodunu tamamlayın...
        //NOT: Veritabanı'nda iade etmeyle alakalı ikinci bir map 'i tampon gibi kullanmalısınız...
        //Kitap iade edildiğinde,  kitaplarMap 'e geri eklenmeli...
    }


    private static void isimIleKitapSilme() throws InterruptedException
    {//İPUCU METODU... Bu metodu değiştirmenize gerek yok.
        System.out.println("Silinecek kitabin ismini giriniz");
        String silinecekKitap = scan.nextLine();

        String silinecekValue = kitaplarMap.get(silinecekKitap);
        String sonucValue = kitaplarMap.remove(silinecekKitap);

        System.out.print(silinecekKitap + " Siliniyor...");
        for (int i = 0; i < 20; i++) {
            Thread.sleep(100);
            System.out.print(">");
        }

        //ARTIK UYGUN YERLERDE BEKLEMEDİĞİNİZ SONUÇLAR İÇİN TRY CATCH KULLANABİLİRSİNİZ...
        //////////////////////////////////////////////////////////////////////////////////////////////////
        try {
            boolean sonuc = sonucValue.equals(silinecekValue);
        } catch (Exception e) {
            System.out.println("Istediginiz kitap ismi bulunamadi");
        }/////////////////////////////////////////////////////////////////////////////////////////////////
    }

    private static void kitapEkle() {
        System.out.print("Lütfen eklemek istediğiniz kitap adını giriniz: ");
        String kitapAdi = scan.nextLine();

        System.out.print("Lütfen " + kitapAdi + " kitabın yazarını giriniz: ");
        String yazar = scan.nextLine();

        String tur = "";
        int sayi = 0;
        do {

            System.out.print("Lütfen " + kitapAdi + " kitabın türünü giriniz: ");
            tur = scan.nextLine();
            if (tur.equalsIgnoreCase("Tarih") || tur.equalsIgnoreCase("Polisiye") || tur.equalsIgnoreCase("Kurgu")
            || tur.equalsIgnoreCase("Roman") || tur.equalsIgnoreCase("Destan")){
                sayi = 1;
            } else {
                System.out.println("Hatali giris! Lutfen kitap turunu tekrar giriniz");
            }

        } while (sayi!=1);

        System.out.print("Lütfen " + kitapAdi + " kitabın yayınlanma yılını giriniz: ");
        String tarih = scan.nextLine();

        kitaplarMap.put(kitapAdi,yazar+", "+tur+", "+tarih);
        //"A Tale of Two Cities", "Charles Dickens, Tarih, 1859" >> Kitap key,value su buna benzer şekilde...

        //TODO Kitap Adını, Yazar Adını, Kitap Türünü ve Yayınlanma Yılını Kullanıcıdan alarak,
        //TODO kitaplarMap'e ekleme yapınız...

        //TODO MÜMKÜNSE, kitap türünü, Enum olarak tanımlanan KitapTuru sınıfını kullanarak alınız...
        //KİTAP TÜRLERİ >>     TARIH, POLISIYE, KURGU, ROMAN, DESTAN, TANIMLANMAMIS_TUR
        //TODO Kullanıcı kitap türünü yanlış girdiği sürece , kullanıcıya
        //TODO "Hatali giris! Lutfen kitap turunu tekrar giriniz: " mesajı verin...
        //TODO while ve try-catch kullanılabilir... Giriş başarılı olursa try-catch bloğu kırılarak konsoldan
        //TODO yayınlama yılı alıp kitap ekleme işlemine devam edilebilir...
        //Kullanıcı tarafından girilen stringi, KitapTuru sınıfında tanımlanan türlerden birine çevirmeniz gerkecek...
        // kitapTuru değişkeni artık geçerli bir değere sahipse...
        // Diğer işlemlere devam edebilirsiniz.
        //System.out.println("Yayinlanma Tarihi: ");
        //String yayinTarihi = scan.nextLine();

        //TODO Ekleme işlemini tamamlayın...


    }

    public static void turVeyaYayinTarihiIleKitapBulma() throws InterruptedException {


        //TODO kitaplar.Map'in Value larını almak için  Set<Map.Entry<String, String>> cinsinden myEntrySet tanımlayın...

        System.out.println("Istediginiz kitabin turunu yaziniz: ");
        System.out.println("(Tarih, Polisiye, Kurgu, Roman, Destan)");
        String tur = scan.nextLine();
        //TODO Metodu kullanıcıdan alacağınız girdileri kullanarak tamamlayın...

        System.out.println("Istediginiz kitabin yayın yılını yaziniz: ");
        String yayin = scan.nextLine();

        System.out.println(
                "\n============ TECHNO STUDY CONFLUENCE ==========\n" +
                        "================= KITAP LISTESI ===============\n" +
                        "Kitap Ismi    :   Yazar Ismi , Kitap Turu , Yayin Yili");

        for (Map.Entry<String, String> kb : kitaplarMap.entrySet()) {
            if (kb.getValue().toLowerCase().contains(tur.toLowerCase()) || kb.getValue().toLowerCase().contains(yayin)){
                System.out.println(kb.getKey() + " : " + kb.getValue());
            }
        }

    }


    public static void yazardanKitapBulma() throws InterruptedException {

        //TODO kitaplar.Map'in Value larını almak için  Set<Map.Entry<String, String>> cinsinden myEntrySet tanımlayın...
        System.out.println("Istediginiz yazar ismini yaziniz: ");
        String yazar = scan.nextLine();
        //TODO Metodu kullanıcıdan alacağınız girdileri kullanarak tamamlayın...

        System.out.println(
                "\n============ TECHNO STUDY CONFLUENCE ==========\n" +
                        "================= KITAP LISTESI ===============\n" +
                        "Kitap Ismi    :   Yazar Ismi , Kitap Turu , Yayin Yili");
        // printf veya String.format metodları kullanılarak daha düzgün bi çıktı elde edilebilir.
        // Şart değil, isteğe bağlı.

        for (Map.Entry<String, String> kb : kitaplarMap.entrySet()) {
            if (kb.getValue().toLowerCase().contains(yazar.toLowerCase())){
                System.out.println(kb.getKey() + " : " + kb.getValue());
            }
        }

    }

    public static void kitapListesiYazdir() throws InterruptedException { //Üye Listesi Yazdır Metodundan Faydalanabilirsiniz...

        //TODO kitaplar.Map'in Value larını almak için  Set<Map.Entry<String, String>> cinsinden myEntrySet tanımlayın...

        System.out.println(
                "\n============ TECHNO STUDY CONFLUENCE ==========\n" +
                        "================= KITAP LISTESI ===============\n" +
                        "Kitap Ismi    :   Yazar Ismi , Kitap Turu , Yayin Yili");

        for (Map.Entry<String, String> kb : kitaplarMap.entrySet()){
            System.out.println(kb.getKey() + " : " + kb.getValue());
        }
        //TODO Kitapları listeleyecek metodu oluşturun...
        //Üye Listesi Yazdır Metodundan Faydalanabilirsiniz...
    }
}
