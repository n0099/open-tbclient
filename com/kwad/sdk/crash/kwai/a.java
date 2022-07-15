package com.kwad.sdk.crash.kwai;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.File;
/* loaded from: classes5.dex */
public final class a {
    public static Context a;
    public static String b;

    public static File a() {
        File file = !TextUtils.isEmpty(b) ? new File(b) : new File(a(a), "kwad_ex");
        if (!file.exists()) {
            file.mkdir();
        }
        return file;
    }

    public static File a(Context context) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            return new File(context.getExternalFilesDir(null).getAbsolutePath());
        }
        File dataDir = i >= 24 ? context.getDataDir() : null;
        if (dataDir == null) {
            dataDir = new File(Environment.getDataDirectory().getPath() + "/data/" + context.getPackageName());
            if (!dataDir.exists()) {
                return new File("/data/data/" + context.getPackageName());
            }
        }
        return dataDir;
    }

    public static void a(@NonNull Context context, @Nullable String str) {
        a = context;
        b = str;
    }

    public static boolean a(File file) {
        if (file == null) {
            return false;
        }
        return file.exists() || file.mkdirs();
    }

    public static File b() {
        return new File(a(), "java_crash/dump");
    }

    public static File c() {
        return new File(a(), "anr_log/dump");
    }

    public static File d() {
        return new File(a(), "native_crash_log/dump");
    }
}
