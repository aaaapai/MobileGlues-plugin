-optimizationpasses 7
-allowaccessmodification

-keep class com.fcl.plugin.mobileglues.** { *; }
-keepclassmembers class com.fcl.plugin.mobileglues.** { <fields>; }

-keepclassmembers class * {
    @com.google.gson.annotations.SerializedName <fields>;
}

-keep class !com.fcl.plugin.mobileglues.** { *; }  # 其他类随便优化

-whyareyoukeeping class com.fcl.plugin.mobileglues.settings.MGConfig
-verbose
