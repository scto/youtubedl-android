plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.yausername.youtubedl_android_example"
    //compileSdk = 34

    defaultConfig {
        applicationId = "com.yausername.youtubedl_android_example"
        /*
        minSdk = 24
        targetSdk = 34
        versionName = rootProject.ext["versionName"] as String
        versionCode = rootProject.ext["versionCode"] as Int
        */

        //testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables.useSupportLibrary = true

        ndk {
            abiFilters += listOf("arm64-v8a", "armeabi-v7a", "x86", "x86_64")
        }
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

    /*
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    */

    splits.abi {
        isEnable = true
        reset()
        include("x86", "x86_64", "armeabi-v7a", "arm64-v8a")
        isUniversalApk = true
    }

    packaging {
        resources.excludes.addAll(
            arrayOf(
                "META-INF/README.md",
                "META-INF/CHANGES",
                "bundle.properties",
                "plugin.properties"
            )
        )

        jniLibs { useLegacyPackaging = true }
    }

    lint {
        abortOnError = false
        disable += listOf("MaterialDesignInsteadOrbitDesign")
    }


    /*
    externalNativeBuild {
        cmake {
            path = file("src/main/cpp/CMakeLists.txt")
            version = "3.22.1"
        }
    }
    */
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(project(":library"))
    implementation(project(":ffmpeg"))
    implementation(project(":aria2c"))
    implementation("androidx.appcompat:appcompat:${rootProject.extra["appCompatVer"]}")
    implementation("androidx.constraintlayout:constraintlayout:1.1.3")
    implementation("androidx.core:core-ktx:${rootProject.extra["coreKtxVer"]}")
    implementation("io.reactivex.rxjava2:rxandroid:2.1.0")
    implementation("com.devbrackets.android:exomedia:5.1.0")

    testImplementation("junit:junit:${rootProject.extra["junitVer"]}")
    androidTestImplementation("androidx.test.ext:junit:${rootProject.extra["androidJunitVer"]}")
    androidTestImplementation("androidx.test.espresso:espresso-core:${rootProject.extra["espressoVer"]}")
}
