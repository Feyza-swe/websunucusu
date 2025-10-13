import java.io.*;
import java.net.*;

public class websunucu {
    private static final int PORT = 1989;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Web sunucusu " + PORT + " portunda başlatıldı...");

            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

                    // İstek başlığını oku
                    String requestLine = in.readLine();
                    System.out.println("İstek: " + requestLine);

                    // HTTP yanıtı gönder
                    sendHtmlResponse(out);

                } catch (IOException e) {
                    System.err.println("İstek işlenirken hata: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Sunucu başlatılamadı: " + e.getMessage());
        }
    }

    private static void sendHtmlResponse(PrintWriter out) {
        // HTML içeriği
        String htmlContent = createHtmlContent();

        // HTTP yanıt başlığı
        out.println("HTTP/1.1 200 OK");
        out.println("Content-Type: text/html; charset=UTF-8");
        out.println("Content-Length: " + htmlContent.getBytes().length);
        out.println("Connection: close");
        out.println(); // Boş satır - başlık ve içerik ayrımı
        out.println(htmlContent);
    }

    private static String createHtmlContent() {
        return "<!DOCTYPE html>" +
                "<html lang='tr'>" +
                "<head>" +
                "    <meta charset='UTF-8'>" +
                "    <meta name='viewport' content='width=device-width, initial-scale=1.0'>" +
                "    <title>Kişisel Web Sayfası</title>" +
                "    <style>" +
                "        body {" +
                "            font-family: 'Arial', sans-serif;" +
                "            background: linear-gradient(135deg, #e0b0ff 0%, #c8a2c8 100%);" + // Pastel mor gradient
                "            margin: 0;" +
                "            padding: 20px;" +
                "            min-height: 100vh;" +
                "            color: #333;" +
                "        }" +
                "        .container {" +
                "            max-width: 800px;" +
                "            margin: 0 auto;" +
                "            background: white;" +
                "            padding: 30px;" +
                "            border-radius: 15px;" +
                "            box-shadow: 0 10px 30px rgba(128, 0, 128, 0.2);" + // Mor gölge
                "        }" +
                "        h1 {" +
                "            color: #6a0dad;" + // Koyu mor
                "            text-align: center;" +
                "            border-bottom: 3px solid #9370db;" + // Orta mor
                "            padding-bottom: 10px;" +
                "            margin-bottom: 20px;" +
                "        }" +
                "        h2 {" +
                "            color: #8a2be2;" + // Mavi-mor
                "            text-align: center;" +
                "            margin-bottom: 30px;" +
                "        }" +
                "        h3 {" +
                "            color: #9400d3;" + // Koyu mor
                "            margin-top: 20px;" +
                "        }" +
                "        .bio-section {" +
                "            background: #f8f0ff;" + // Açık mor arkaplan
                "            padding: 20px;" +
                "            border-radius: 10px;" +
                "            border-left: 5px solid #ba55d3;" + // Orta mor kenarlık
                "        }" +
                "        .highlight {" +
                "            color: #000000;" + // SİYAH
                "            font-weight: bold;" + // KALIN
                "            background-color: #e6e6fa;" + // Açık mor vurgu
                "            padding: 2px 6px;" +
                "            border-radius: 4px;" +
                "        }" +
                "        .skills {" +
                "            display: flex;" +
                "            flex-wrap: wrap;" +
                "            gap: 10px;" +
                "            margin-top: 15px;" +
                "        }" +
                "        .skill-tag {" +
                "            background: linear-gradient(135deg, #9370db, #8a2be2);" + // Mor gradient
                "            color: white;" +
                "            padding: 5px 15px;" +
                "            border-radius: 20px;" +
                "            font-size: 14px;" +
                "            font-weight: bold;" +
                "        }" +
                "        .contact-info {" +
                "            margin-top: 20px;" +
                "            text-align: center;" +
                "            font-style: italic;" +
                "            color: #6a5acd;" + // Slate mavi-mor
                "            background-color: #f0e6ff;" +
                "            padding: 15px;" +
                "            border-radius: 8px;" +
                "        }" +
                "        strong {" +
                "            color: #000000;" + // SİYAH
                "            font-weight: bold;" + // KALIN
                "        }" +
                "        ul {" +
                "            background-color: #f5f0ff;" +
                "            padding: 15px 25px;" +
                "            border-radius: 8px;" +
                "        }" +
                "        li {" +
                "            margin-bottom: 8px;" +
                "        }" +
                "    </style>" +
                "</head>" +
                "<body>" +
                "    <div class='container'>" +
                "        <h1>Feyza Nur Erbaş</h1>" +
                "        <h2>Öğrenci No: 1240505044</h2>" +
                "        " +
                "        <div class='bio-section'>" +
                "            <h3>Hakkımda</h3>" +
                "            <p>Merhaba! Ben <span class='highlight'>Feyza Nur Erbaş</span>. Yazılım Mühendisliği 2. sınıf öğrencisiyim. " +
                "            Yazılım geliştirme ve web teknolojileri ile ilgileniyorum. Özellikle <span class='highlight'>Java</span> " +
                "            ve <span class='highlight'>Spring Framework</span> üzerine projeler geliştiriyorum.</p>" +
                "            " +
                "            <p>Boş zamanlarımda open-source projelere katkı sağlamaktan ve yeni teknolojiler öğrenmekten keyif alıyorum. " +
                "            Ayrıca voleybol oynamayı ve kitap okumayı seviyorum.</p>" +
                "            " +
                "            <h3>Yetenekler</h3>" +
                "            <div class='skills'>" +
                "                <span class='skill-tag'>Java</span>" +
                "                <span class='skill-tag'>Spring Boot</span>" +
                "                <span class='skill-tag'>HTML/CSS</span>" +
                "                <span class='skill-tag'>JavaScript</span>" +
                "                <span class='skill-tag'>MySQL</span>" +
                "                <span class='skill-tag'>Git</span>" +
                "                <span class='skill-tag'>Docker</span>" +
                "            </div>" +
                "            " +
                "            <h3>Eğitim</h3>" +
                "            <p><strong>Üniversite:</strong> Kırklareli Üniversitesi - Yazılım Mühendisliği (2024 - Devam)</p>" +
                "            <p><strong>Ortalama:</strong> 3.45/4.00</p>" +
                "            " +
                "            <div class='contact-info'>" +
                "                <p>İletişim: 1240505044@ogrenci.edu.tr | Tel: +90 555 123 45 67</p>" +
                "            </div>" +
                "        </div>" +
                "    </div>" +
                "</body>" +
                "</html>";
    }
}