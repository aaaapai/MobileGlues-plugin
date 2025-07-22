-optimizationpasses 7
-allowaccessmodification

# 保留 MGConfig 类及其所有子类
-keep class com.fcl.plugin.mobileglues.settings.MGConfig { *; }
-keep class com.fcl.plugin.mobileglues.settings.MGConfig$* { *; }
# 保留这些类的所有成员（包括私有）
-keepclassmembers class com.fcl.plugin.mobileglues.settings.MGConfig { *; }
-keepclassmembers class com.fcl.plugin.mobileglues.settings.MGConfig$* { *; }

-whyareyoukeeping class com.fcl.plugin.mobileglues.settings.MGConfig
-verbose
