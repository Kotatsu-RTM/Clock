plugins {
    id("java")
}

repositories {
    maven { url = uri("https://repo.siro256.dev/repository/maven-public/") }
}

dependencies {
    implementation("org.jetbrains:annotations-java5:24.1.0")
    testImplementation("junit:junit:4.13.2")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(7))
    }
}

tasks.test {
    useJUnit()
}
