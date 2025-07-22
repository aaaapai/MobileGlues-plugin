-optimizationpasses 7
-allowaccessmodification

-keep class com.fcl.plugin.mobileglues.** { *; }
-keepclassmembers class com.fcl.plugin.mobileglues.** { <fields>; }

-keepclassmembers class * {
    @com.google.gson.annotations.SerializedName <fields>;
}

-keep class !com.fcl.plugin.mobileglues.** { *; }  # 其他类随便优化
-assumenosideeffects class android.util.Log { *; }  # 移除 Log 调用
-dontwarn javax.lang.model.element.Modifier.**

-whyareyoukeeping class com.fcl.plugin.mobileglues.settings.MGConfig
-verbose
