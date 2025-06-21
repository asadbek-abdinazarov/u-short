# U-SHORT 🔗

*A simple, secure, and modern URL shortening web application built with Java Spring Boot, Thymeleaf, and PostgreSQL.*

![Screenshot](img-u-short.png)

---

## 📌 Dastur haqida

**U-SHORT** is an open source URL shortening web application written in Spring Boot, Thymeleaf, and PostgreSQL
technologies. It provides easy-to-use, modern interface, and secure URL generation.


<details style="color: orange">
  <summary>Important message!</summary>

Please ensure that any URLs shortened through our service are safe, lawful, and used responsibly.
Once created, shortened URLs are permanent and cannot be modified.
We do not support or condone any form of hacking, phishing, fraud, or other malicious or illegal
activities. Any user found abusing this service for such purposes will have their information
reported to the relevant authorities.
By using this service, you agree that:
<ul>
<li>You are solely responsible for the content and destination of the URLs you shorten.</li>
<li>Our service is provided "as is" with no guarantees or warranties.</li>
<li>We shall not be held liable for any misuse or damage caused by URLs created through this
platform.
</li>
</ul>
<b>Use at your own risk. Be cautious and respectful of laws and community standards.</b>
</details>

---

## ✨ Futures

- 🔐 Safe & Unique Short URLs
- 📊 Click Tracking (optional)
- 🌍 Custom Domain Support
- 🌙 Modern UI with Thymeleaf and Bootstrap
- 🗃️ PostgreSQL database integration
- 🚀 Easy deployment on Railway / Render / VPS

---

## 🛠 Tech stack

| Layer       | Technology             |
|-------------|------------------------|
| Backend     | Spring Boot (Java 17+) |
| Frontend    | Thymeleaf + Bootstrap  |
| Database    | PostgreSQL             |
| Build Tool  | Maven                  |
| Deployments | Railway / Render       |

---

## 📦 Requirements

- Java 17+
- Maven
- PostgreSQL
- Git
- HTML
- CSS

---

## 🚀 Quick Start

### 1. Clone the project

```bash
    git clone https://github.com/asadbek-abdinazarov/u-short.git
```

### 2. Go to project file

```bash
    cd u-short
```

### 3. Configure database

```yml
      datasource:
        url: jdbc:postgresql://${PGHOST}:${PGPORT}/${PGDATABASE}
        username: ${PGUSER}
        password: ${PGPASSWORD}
        driver-class-name: org.postgresql.Driver
```

### 4. Build jar file

```bash
    ./mvnw clean package
```

### 5. Run jar file

```bash
    java -jar target/u-short-0.0.1-SNAPSHOT.jar
```

---
After the application, the application will be available at the following address:
👉 http://localhost:8080