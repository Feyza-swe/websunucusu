# 💻 Java Web Sunucusu

Bu proje, **Java** dilini kullanarak yazılmış bir web sunucusu uygulamasıdır. Amacı, ağ programlama temellerini göstermek ve gelen HTTP isteklerine statik bir **kişisel web sayfası** HTML içeriği ile yanıt vermektir.

## 🚀 Proje Hakkında

Bu sunucu, belirtilen bir TCP portunu dinler, gelen bağlantıları kabul eder ve her bağlantıya sabit bir HTML içeriği döndürerek basit bir web sayfası sunar.

### Ana Özellikler

* **Java IO ve Networking:** `java.io` ve `java.net` paketleri kullanılarak soket programlama ile temel ağ iletişimi kurulur.
* **HTTP/1.1 Yanıtı:** Gelen her isteğe `HTTP/1.1 200 OK` durum kodu ve `text/html` içerik türü ile yanıt verilir.
* **Statik HTML İçerik:** Sunucu, öğrenci bilgileri ve yeteneklerini içeren, mor renk temalı **stil sahibi bir kişisel sayfa** sunar.
* **Port:** Varsayılan olarak **1989** numaralı portu dinler.

## ⚙️ Kurulum ve Çalıştırma

Bu projeyi çalıştırmak için sisteminizde **Java Development Kit (JDK)** kurulu olmalıdır.

### Gereksinimler

* Java Development Kit (JDK) 8 veya üstü

### Adımlar

1.  **Kodu Kaydetme:** Yukarıdaki Java kodunu `websunucu.java` adında bir dosyaya kaydedin.
2.  **Derleme:** Komut satırında (terminal) kodu derleyin:

    ```bash
    javac websunucu.java
    ```

3.  **Çalıştırma:** Derlenen sınıf dosyasını çalıştırın:

    ```bash
    java websunucu
    ```
    Sunucu başarıyla başladığında konsolda şu mesajı göreceksiniz:
    `Web sunucusu 1989 portunda başlatıldı...`

### 🌐 Erişme

Sunucu çalışır durumdayken, bir web tarayıcısı açın ve aşağıdaki adrese gidin:
Elbette, sunduğun Java Web Sunucusu kodu için bir README.md dosyası hazırlayabilirim. Bu README, projenin ne yaptığını, nasıl kurulacağını ve çalıştırılacağını açıklar.

İşte Markdown formatında bir README dosyası:

Markdown

# 💻 Java Basit Web Sunucusu - Kişisel Sayfa

Bu proje, **Java** dilini kullanarak yazılmış basit bir web sunucusu uygulamasıdır. Amacı, ağ programlama temellerini göstermek ve gelen HTTP isteklerine statik bir **kişisel web sayfası** HTML içeriği ile yanıt vermektir.

## 🚀 Proje Hakkında

Bu sunucu, belirtilen bir TCP portunu dinler, gelen bağlantıları kabul eder ve her bağlantıya sabit bir HTML içeriği döndürerek basit bir web sayfası sunar.

### Ana Özellikler

* **Java IO ve Networking:** `java.io` ve `java.net` paketleri kullanılarak soket programlama ile temel ağ iletişimi kurulur.
* **HTTP/1.1 Yanıtı:** Gelen her isteğe `HTTP/1.1 200 OK` durum kodu ve `text/html` içerik türü ile yanıt verilir.
* **Statik HTML İçerik:** Sunucu, öğrenci bilgileri ve yeteneklerini içeren, mor renk temalı **stil sahibi bir kişisel sayfa** sunar.
* **Port:** Varsayılan olarak **1989** numaralı portu dinler.

## ⚙️ Kurulum ve Çalıştırma

Bu projeyi çalıştırmak için sisteminizde **Java Development Kit (JDK)** kurulu olmalıdır.

### Gereksinimler

* Java Development Kit (JDK) 8 veya üstü

### Adımlar

1.  **Kodu Kaydetme:** Yukarıdaki Java kodunu `websunucu.java` adında bir dosyaya kaydedin.
2.  **Derleme:** Komut satırında (terminal) kodu derleyin:

    ```bash
    javac websunucu.java
    ```

3.  **Çalıştırma:** Derlenen sınıf dosyasını çalıştırın:

    ```bash
    java websunucu
    ```
    Sunucu başarıyla başladığında konsolda şu mesajı göreceksiniz:
    `Web sunucusu 1989 portunda başlatıldı...`

### 🌐 Erişme

Sunucu çalışır durumdayken, bir web tarayıcısı açın ve aşağıdaki adrese gidin:

http://localhost:1989/
Sunucuya bir istek geldiğinde, konsolda şuna benzer bir çıktı görünecektir:
`İstek: GET / HTTP/1.1` (veya tarayıcının gönderdiği ilk istek satırı)

## 📌 Kod Detayları

| Metot Adı | Açıklama |
| :--- | :--- |
| `main(String[] args)` | Sunucuyu başlatır, **1989** portunu dinler ve sürekli olarak yeni istemci bağlantılarını (`serverSocket.accept()`) bekler. Gelen her isteği işlemek için döngüde kalır. |
| `sendHtmlResponse(PrintWriter out)` | İstemciye standart bir **HTTP yanıt başlığı** (`HTTP/1.1 200 OK`, `Content-Type: text/html`) ve ardından `createHtmlContent()` metodu ile oluşturulmuş HTML içeriğini gönderir. |
| `createHtmlContent()` | Sunulacak olan **statik HTML ve CSS içeriğini** bir `String` olarak döndürür. Bu içerik, Feyza Nur Erbaş'a ait kişisel sayfa bilgilerini içerir. |
