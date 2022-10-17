# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

-obfuscationdictionary rules.txt
-classobfuscationdictionary rules.txt
-packageobfuscationdictionary rules.txt

-optimizationpasses 5

-dontusemixedcaseclassnames

-dontskipnonpubliclibraryclasses

-verbose
-ignorewarnings

-dontskipnonpubliclibraryclassmembers

-dontpreverify

-keepattributes *Annotation*,InnerClasses

-keepattributes Signature

-keepattributes SourceFile,LineNumberTable
-dump proguard/class_files.txt
-optimizations !code/simplification/cast,!field/*,!class/merging/*

-keep class **.R$* {*;}

-keepclasseswithmembernames class * {
    native <methods>;
}

-keepattributes EnclosingMethod
-keepattributes Exceptions

-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

-keep public class * extends android.view.View{
    *** get*();
    void set*(***);
    public <init>(android.content.Context);
    public <init>(android.content.Context, android.util.AttributeSet);
    public <init>(android.content.Context, android.util.AttributeSet, int);
}


-keepclassmembers class * {
    void *(**On*Event);
    void *(**On*Listener);
}

-keepclassmembers class fqcn.of.javascript.interface.for.webview {
    public *;
}
-keepclassmembers class * extends android.webkit.webViewClient {
    public void *(android.webkit.WebView, java.lang.String, android.graphics.Bitmap);
    public boolean *(android.webkit.WebView, java.lang.String);
}
-keepclassmembers class * extends android.webkit.webViewClient {
    public void *(android.webkit.webView, jav.lang.String);
}

#--------------------------------- OkHttp3------------------------------------
-dontwarn okhttp3.logging.**
-keep class okhttp3.internal.**{*;}
-dontwarn okio.**

#--------------------------------- Retrofit------------------------------------
-dontwarn retrofit2.**
-keep class retrofit2.** { *; }
#---------------------------------glide https://github.com/bumptech/glide------------------------------------
-keep public class * implements com.bumptech.glide.module.GlideModule
-keep public class * extends com.bumptech.glide.module.AppGlideModule
-keep public enum com.bumptech.glide.load.ImageHeaderParser$** {
  **[] $VALUES;
  public *;
}

-keepattributes EnclosingMethod
-keepattributes Exceptions

#af
-dontwarn com.android.installreferrer
-keep public class com.android.installreferrer.** { *; }
-keep class com.appsflyer.** { *; }

-keep class kotlinx.coroutines.** {*;}

#accu sdk
-dontwarn com.dfsdk.**
-keep class com.dfsdk.** { *; }