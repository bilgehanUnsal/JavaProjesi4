import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class UyeManager extends Veritabani {
    static Scanner scan = new Scanner(System.in);

    public static void uyeMenu() throws InterruptedException {
        String tercih = "";

        do { //TODO Kullanıcı Çıkış Yapmadığı Sürece, Menüyü Görmeye Devam Etsin...

            System.out.println(
                    "\n========== TECHNO STUDY CONFLUENCE =========\n" +
                            "================= UYE MENU =================\n" +
                            "\n" +
                            "\t   1- Uye Listesi Yazdir\t\n" +
                            "\t   2- Soyisimden Uye Bulma\n" +
                            "\t   3- Sehire Gore Uye Bulma\n" +
                            "\t   4- Bilgilerini Girerek Uye Ekleme\n" +
                            "\t   5- Kimlik No Ile Kayit Silme \t\n" +
                            "\t   A- ANAMENU\n" +
                            "\t   Q- CIKIS\n");

            System.out.print("Lütfen yapmak istediğiniz işlemi seçin: ");
            tercih = scan.nextLine();
            //TODO Kullanıcıdan alacağınız tercihe göre ilgili menü metodlarına yönlendirmeler yapın...
            switch (tercih.toLowerCase()){
                case "1":
                // Uye Listesi Yazdir
                uyeListesiYazdir();
                break;
                case "2":
                // Soyisimden Uye Bulma
                soyisimdenUyeBulma();
                break;
                case "3":
                // Sehre Gore Uye Bulma
                sehreGoreUyeBulma();
                break;
                case "4":
                // Bilgilerini Girerek Uye Ekleme
                uyeEkleme();
                break;
                case "5":
                // Kimlik No Ile Kayit Silme
                tcNoIleUyeSil();
                break;
                case "a":
                Helper.anaMenu();
                break;
                case "q":
                    Helper.projeDurdur();
                    break;
                default:
                System.out.println("Lutfen gecerli tercih yapiniz: ");
                break;
            }

        } while (!tercih.equalsIgnoreCase("q"));
        Helper.projeDurdur();
    }

    public static void tcNoIleUyeSil() throws InterruptedException {

        //TODO Kullanıcıdan alacağınız kimlik no ile ilgili üyeyi kayıtlardan siliniz...
        System.out.print("Silinecek uyeye ait kimlik no giriniz: ");
        String tcNo = scan.nextLine();

        for (Map.Entry<String, String> tc : uyelerMap.entrySet()){
            if (tc.getKey().contains(tcNo)){
                uyelerMap.remove(tc.getKey(), tc.getValue());
            }
        }

        //TODO Gerekli atamaları yapınız. Aşağıdaki try-catch bloğu yardımcı olabilir...

        System.out.print("silinecekUye" + " Siliniyor...");
        for (int i = 0; i < 20; i++) {
            Thread.sleep(100);
            System.out.print(">");
        }

        //try {
        //    boolean sonuc = sonucValue.equals(silinecekValue);
        //} catch (Exception e) {
        //    System.out.println("Istediginiz Tc numarasi ile uye bulunamadi.");
        //}
    }

    public static void uyeEkleme() {

        System.out.print("Lütfen eklemek istediğiniz TC No' sunu giriniz: ");
        String tcNo = scan.nextLine();

        System.out.print("Lütfen isim, soyisim, şehir ve doğum yılınızı giriniz: ");
        String value = scan.nextLine();

        uyelerMap.put(tcNo, value);


        //TODO Kullanıcıdan Tc no , Isim, Soyisim, Sehir, Dogum Yili alınız...
        //TODO Aldığınız değeri UyelerMap mapine uygun şekilde ekleyiniz...

    }

    public static void sehreGoreUyeBulma() throws InterruptedException {

        //TODO Kullanıcıdan aldığınız girdiyle, UyelerMap'inde şehir araması yapın;
        //TODO Girilen şehire sahip tüm üyeleri map veya liste olarak döndürünüz...
        System.out.println("Aradiginiz Uyenin Sehrini Giriniz:");
        String sehir = scan.nextLine();

        System.out.println(
                "\n============= TECHNO STUDY CONFLUENCE =============\n" +
                        "=============== SEHIR ILE UYE ARAMA ===============\n" +
                        "TcNo : Isim , Soyisim , Sehir, D.Yili");
        // Daha düzgün bi görünüm için printf veya String.format kullanılabilir... Zorunlu değil...

        for (Map.Entry<String, String> su : uyelerMap.entrySet()){
            if (su.getValue().toLowerCase().contains(sehir.toLowerCase())){
                System.out.println(su.getKey() + " : " + su.getValue());
            }
        }

    }

    public static void soyisimdenUyeBulma() throws InterruptedException {
        //TODO Kullanıcıdan aldığınız girdiyle, UyelerMap'inde soyisim araması yapın;
        //TODO Girilen soyismine sahip tüm üyeleri map veya liste olarak döndürünüz...
        System.out.println("Aradiginiz uyenin soyisminin tamamini ya da birkismini giriniz: ");
        String soyisim = scan.nextLine();


        System.out.println(
                "\n========== TECHNO STUDY BOOTCAMP ===========\n" +
                        "=========== SOYISIM ILE UYE ARAMA ==========\n" +
                        "TcNo : Isim , Soyisim , Sehir , D.Yili");
        // printf veya String.format metodları kullanılarak daha düzgün bi çıktı elde edilebilir. Şart değil, isteğe bağlı.

        //TODO Syisminin bir kısmı girilse bile bulunan üyeler listelensin...

        for (Map.Entry<String, String> su : uyelerMap.entrySet()){
            if (su.getValue().toLowerCase().contains(soyisim.toLowerCase())){
                System.out.println(su.getKey() + " : " + su.getValue());
            }
        }

    }

    public static void uyeListesiYazdir() throws InterruptedException {
        //İPUCU METODU: Bu metodu değiştirmenize gerek yok...

        Set<Map.Entry<String, String>> uyelerEntrySet = uyelerMap.entrySet();

        System.out.print("Uye Listesi yazdiriliyor...");
        for (int i = 0; i < 20; i++) {
            Thread.sleep(100);
            System.out.print(">");
        }

        System.out.println(
                "\n========== TECHNO STUDY CONFLUENCE =========\n" +
                        "=============== UYE LISTESI ================\n" +
                        "TcNo : Isim , Soyisim , Sehir , D.Yili");

        // Daha düzgün bi görünüm için printf veya String.format kullanılabilir...
        for (Map.Entry<String, String> each : uyelerEntrySet) {
            String eachKey = each.getKey();
            String eachValue = each.getValue();

            System.out.println(eachKey + " : " + eachValue + " | ");
        }
    }
}
