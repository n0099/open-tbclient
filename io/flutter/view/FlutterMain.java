package io.flutter.view;

import android.content.Context;
import android.os.Handler;
import io.flutter.embedding.engine.loader.FlutterLoader;
/* loaded from: classes9.dex */
public class FlutterMain {
    private static boolean isRunningInRobolectricTest = false;

    /* loaded from: classes9.dex */
    public static class Settings {
        private String logTag;

        public String getLogTag() {
            return this.logTag;
        }

        public void setLogTag(String str) {
            this.logTag = str;
        }
    }

    public static void startInitialization(Context context) {
        if (!isRunningInRobolectricTest) {
            FlutterLoader.getInstance().startInitialization(context);
        }
    }

    public static void startInitialization(Context context, Settings settings) {
        if (!isRunningInRobolectricTest) {
            FlutterLoader.Settings settings2 = new FlutterLoader.Settings();
            settings2.setLogTag(settings.getLogTag());
            FlutterLoader.getInstance().startInitialization(context, settings2);
        }
    }

    public static void ensureInitializationComplete(Context context, String[] strArr) {
        if (!isRunningInRobolectricTest) {
            FlutterLoader.getInstance().ensureInitializationComplete(context, strArr);
        }
    }

    public static void ensureInitializationCompleteAsync(Context context, String[] strArr, Handler handler, Runnable runnable) {
        if (!isRunningInRobolectricTest) {
            FlutterLoader.getInstance().ensureInitializationCompleteAsync(context, strArr, handler, runnable);
        }
    }

    public static String findAppBundlePath() {
        return FlutterLoader.getInstance().findAppBundlePath();
    }

    @Deprecated
    public static String findAppBundlePath(Context context) {
        return FlutterLoader.getInstance().findAppBundlePath();
    }

    public static String getLookupKeyForAsset(String str) {
        return FlutterLoader.getInstance().getLookupKeyForAsset(str);
    }

    public static String getLookupKeyForAsset(String str, String str2) {
        return FlutterLoader.getInstance().getLookupKeyForAsset(str, str2);
    }

    @Deprecated
    public static void setIsRunningInRobolectricTest(boolean z) {
        isRunningInRobolectricTest = z;
    }
}
