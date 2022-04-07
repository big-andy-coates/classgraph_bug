plugins {
    java
    id("org.javamodularity.moduleplugin") version "1.8.10"  // https://plugins.gradle.org/plugin/org.javamodularity.moduleplugin
}

group = "io.github.big.andy.coates"

java {
    modularity.inferModulePath.set(false)

    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.2")
}

tasks.test {
    useJUnitPlatform()
}

defaultTasks("check")
