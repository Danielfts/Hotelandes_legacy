plugins {
    java
    id("org.springframework.boot") version "3.1.5"
    id("io.spring.dependency-management") version "1.1.3"
    id("com.diffplug.spotless") version "6.22.0"
}

group = "edu.uniandes"
version = "0.0.1"

repositories {
    mavenCentral()
}

dependencies {
  implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
  implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
  implementation("org.springframework.boot:spring-boot-starter-jdbc")
  implementation("org.springframework.boot:spring-boot-starter-web")
  developmentOnly("org.springframework.boot:spring-boot-devtools")
  runtimeOnly("com.oracle.database.jdbc:ojdbc11")
  testImplementation("org.springframework.boot:spring-boot-starter-test")
  implementation("net.datafaker:datafaker:2.0.2")
  implementation("uk.co.jemos.podam:podam:8.0.0.RELEASE")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
        vendor.set(JvmVendorSpec.ADOPTIUM)
    }
}

tasks.compileJava {
    options.encoding = "UTF-8"
    options.compilerArgs.add("-Xlint:unchecked")
    options.compilerArgs.add("-Xlint:deprecation")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

spotless {
    encoding("UTF-8")
    java {
        googleJavaFormat().reflowLongStrings()
        formatAnnotations()
    }
    kotlinGradle {

    }
}
