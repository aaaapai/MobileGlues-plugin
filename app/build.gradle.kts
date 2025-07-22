plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.fcl.plugin.mobileglues.ap"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.fcl.plugin.mobileglues.ap"
        minSdk = 21
        targetSdk = 36
        versionCode = 1271
        versionName = "1.21.7 - hotfix1"

    }

    packaging {
        jniLibs {
            useLegacyPackaging = true
        }
    }

    signingConfigs {
        create("release") {
            storeFile = file("../debug-key.jks")
            storePassword = "FCL-Debug"
            keyAlias = "FCL-Debug"
            keyPassword = "FCL-Debug"
        }
    }

    buildTypes {
        release {
            signingConfig = signingConfigs.getByName("release")
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }

        configureEach {
            resValue("string","app_name","MobileG鹿es")

            manifestPlaceholders["des"] = "MobileG鹿es_ap (OpenGL 4.0, 1.17.0.0.0.0++)"
            manifestPlaceholders["renderer"] = "MobileGlues:libmobileglues.so:libEGL.so"

            manifestPlaceholders["minMCVer"] = "1.17"
            manifestPlaceholders["maxMCVer"] = "" //为空则不限制 No restriction if empty

            manifestPlaceholders["boatEnv"] = mutableMapOf<String,String>().apply {
                put("LIBGL_ES", "3")
                put("DLOPEN", "libspirv-cross-c-shared.so,libshaderconv.so,libshaderc.so")
            }.run {
                var env = ""
                forEach { (key, value) ->
                    env += "$key=$value:"
                }
                env.dropLast(1)
            }
            manifestPlaceholders["pojavEnv"] = mutableMapOf<String,String>().apply {
                put("LIBGL_ES", "3")
                put("DLOPEN", "libspirv-cross-c-shared.so,libshaderconv.so,libshaderc.so")
                put("POJAV_RENDERER", "opengles3_MobileGlues_ap")
            }.run {
                var env = ""
                forEach { (key, value) ->
                    env += "$key=$value:"
                }
                env.dropLast(1)
            }
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }

    buildFeatures {
        buildConfig = true
        viewBinding = true
        dataBinding = true
    }
}

kotlin {
    jvmToolchain(21) // 自动同步 JDK 工具链（编译、测试、运行均使用 JDK 21）
}

dependencies {
    implementation(libs.androidx.documentfile)
    implementation(libs.gson)
    implementation(libs.appcompat)
    implementation(libs.constraintlayout)
    implementation(libs.google.material)
    implementation(libs.androidx.databinding.runtime)
}
