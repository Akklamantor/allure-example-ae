plugins {
    java
    id("io.qameta.allure") version "2.12.0"
}

group = "io.eroshenkoam"
version = version

allure {
    report {
        version.set("2.29.1")
    }
    adapter {
        autoconfigure.set(true)
        aspectjWeaver.set(true)
        frameworks {
            junit5 {
                adapterVersion.set("2.29.1")
            }
        }
    }
}

tasks.withType(JavaCompile::class) {
    sourceCompatibility = "${JavaVersion.VERSION_21}"
    targetCompatibility = "${JavaVersion.VERSION_21}"
    options.encoding = "UTF-8"
}

tasks.withType(Test::class) {
    ignoreFailures = true
    useJUnitPlatform {

    }
    systemProperty("junit.jupiter.execution.parallel.enabled", "true")
    systemProperty("junit.jupiter.execution.parallel.config.strategy", "dynamic")

    systemProperty("junit.jupiter.extensions.autodetection.enabled", "true")
}


repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    implementation("commons-io:commons-io:2.15.1")
    implementation("io.qameta.allure:allure-java-commons:2.29.1")
    implementation("org.junit.jupiter:junit-jupiter-api:5.12.2")
    implementation("org.junit.jupiter:junit-jupiter-engine:5.12.2")
    implementation("org.junit.jupiter:junit-jupiter-params:5.12.2")
}
