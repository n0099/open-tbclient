package io.flutter.view;

import android.content.Context;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import io.flutter.embedding.engine.loader.FlutterLoader;
/* loaded from: classes.dex */
public class FlutterMain {
    public static boolean isRunningInRobolectricTest = false;

    /* loaded from: classes7.dex */
    public static class Settings {
        public String logTag;

        @Nullable
        public String getLogTag() {
            return this.logTag;
        }

        public void setLogTag(String str) {
            this.logTag = str;
        }
    }

    public static void ensureInitializationComplete(@NonNull Context context, @Nullable String[] strArr) {
        if (isRunningInRobolectricTest) {
            return;
        }
        FlutterLoader.getInstance().ensureInitializationComplete(context, strArr);
    }

    public static void ensureInitializationCompleteAsync(@NonNull Context context, @Nullable String[] strArr, @NonNull Handler handler, @NonNull Runnable runnable) {
        if (isRunningInRobolectricTest) {
            return;
        }
        FlutterLoader.getInstance().ensureInitializationCompleteAsync(context, strArr, handler, runnable);
    }

    @NonNull
    public static String findAppBundlePath() {
        return FlutterLoader.getInstance().findAppBundlePath();
    }

    @NonNull
    public static String getLookupKeyForAsset(@NonNull String str) {
        return FlutterLoader.getInstance().getLookupKeyForAsset(str);
    }

    @VisibleForTesting
    @Deprecated
    public static void setIsRunningInRobolectricTest(boolean z) {
        isRunningInRobolectricTest = z;
    }

    public static void startInitialization(@NonNull Context context) {
        if (isRunningInRobolectricTest) {
            return;
        }
        FlutterLoader.getInstance().startInitialization(context);
    }

    @Nullable
    @Deprecated
    public static String findAppBundlePath(@NonNull Context context) {
        return FlutterLoader.getInstance().findAppBundlePath();
    }

    @NonNull
    public static String getLookupKeyForAsset(@NonNull String str, @NonNull String str2) {
        return FlutterLoader.getInstance().getLookupKeyForAsset(str, str2);
    }

    public static void startInitialization(@NonNull Context context, @NonNull Settings settings) {
        if (isRunningInRobolectricTest) {
            return;
        }
        FlutterLoader.Settings settings2 = new FlutterLoader.Settings();
        settings2.setLogTag(settings.getLogTag());
        FlutterLoader.getInstance().startInitialization(context, settings2);
    }
}
