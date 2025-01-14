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

-keep class com.ekoapp.ekosdk.** { *; }
-keep interface com.ekoapp.ekosdk.** { *; }
-keep enum com.ekoapp.ekosdk.** { *; }
-keep class com.amity.socialcloud.** { *; }
-keep interface com.amity.socialcloud.** { *; }
-keep enum com.amity.socialcloud.** { *; }
-keep class co.amity.rxupload.** { *; }

# For SDK versions below 5.33.11 and 6.9.0
-keepclassmembers class * implements java.io.Serializable {
    private static final java.io.ObjectStreamField[] serialPersistentFields;
    private void writeObject(java.io.ObjectOutputStream);
    private void readObject(java.io.ObjectInputStream);
    java.lang.Object writeReplace();
    java.lang.Object readResolve();
}
