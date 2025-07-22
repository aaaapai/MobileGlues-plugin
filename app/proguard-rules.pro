-optimizationpasses 7
-allowaccessmodification

# ===== 绝对保留 MGConfig 类 =====
-keep class com.fcl.plugin.mobileglues.settings.MGConfig { *; }  // 类名+所有成员
-keepclassmembers class com.fcl.plugin.mobileglues.settings.MGConfig { *; }  // 二次加固
# ===== 保留所有可能的调用路径 =====
-keepclassmembers class ** {
    public * com.fcl.plugin.mobileglues.settings.MGConfig.*;
}

-whyareyoukeeping class com.fcl.plugin.mobileglues.settings.MGConfig
-verbose
