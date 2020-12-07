package io.flutter.util;

import android.content.Context;
import android.os.Build;
/* loaded from: classes9.dex */
public final class PathUtils {
    public static String getFilesDir(Context context) {
        return context.getFilesDir().getPath();
    }

    public static String getDataDirectory(Context context) {
        return context.getDir("flutter", 0).getPath();
    }

    public static String getCacheDirectory(Context context) {
        return Build.VERSION.SDK_INT >= 21 ? context.getCodeCacheDir().getPath() : context.getCacheDir().getPath();
    }
}
