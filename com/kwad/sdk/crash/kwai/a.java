package com.kwad.sdk.crash.kwai;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.File;
/* loaded from: classes10.dex */
public final class a {
    public static Context ab;
    public static String ahh;

    public static File getDataDir(Context context) {
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

    public static void init(@NonNull Context context, @Nullable String str) {
        ab = context;
        ahh = str;
    }

    public static File wI() {
        File file = !TextUtils.isEmpty(ahh) ? new File(ahh) : new File(getDataDir(ab), "kwad_ex");
        if (!file.exists()) {
            file.mkdir();
        }
        return file;
    }

    public static File wJ() {
        return new File(wI(), "java_crash/dump");
    }

    public static File wK() {
        return new File(wI(), "anr_log/dump");
    }

    public static File wL() {
        return new File(wI(), "native_crash_log/dump");
    }

    public static boolean x(File file) {
        if (file == null) {
            return false;
        }
        return file.exists() || file.mkdirs();
    }
}
