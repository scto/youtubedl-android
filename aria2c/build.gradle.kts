plugins {
    //id("com.yausername.youtubedl_android")
    //id("signing")
    id("com.android.library")
    //id("maven-publish")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.yausername.aria2c"
    //compileSdk = 34

    defaultConfig {
        minSdk = 24
        //testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

/*
configurePublishing {
    artifactId = project.name
    isPublished = true
}
*/

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    implementation(project(":common"))
    implementation("androidx.core:core-ktx:${rootProject.extra["coreKtxVer"]}")
    implementation("commons-io:commons-io:${rootProject.extra["commonsIoVer"]}")
    implementation("androidx.appcompat:appcompat:${rootProject.extra["appCompatVer"]}")
    compileOnly(project(":library"))
    /*
    testImplementation("junit:junit:${rootProject.extra["junitVer"]}")
    androidTestImplementation("androidx.test.ext:junit:${rootProject.extra["androidJunitVer"]}")
    androidTestImplementation("androidx.test.espresso:espresso-core:${rootProject.extra["espressoVer"]}")
    */
}
