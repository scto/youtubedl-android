plugins {
    //id("com.yausername.youtubedl_android")
    //id("signing"
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin)
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
    implementation(libs.androidx.core.ktx)
    implementation(libs.common.commons.io)
    implementation(libs.androidx.appcompat)

    compileOnly(project(":library"))
    /*
    testImplementation("junit:junit:${rootProject.extra["junitVer"]}")
    androidTestImplementation("androidx.test.ext:junit:${rootProject.extra["androidJunitVer"]}")
    androidTestImplementation("androidx.test.espresso:espresso-core:${rootProject.extra["espressoVer"]}")
    */
}
