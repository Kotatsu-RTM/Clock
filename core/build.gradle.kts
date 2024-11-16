plugins {
    id("java")
}

repositories {
    maven { url = uri("https://repo.siro256.dev/repository/maven-public/") }
}

dependencies {
    implementation("org.jetbrains:annotations-java5:24.1.0")
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(7))
    }
}

tasks.test {
    useJUnitPlatform()
}
