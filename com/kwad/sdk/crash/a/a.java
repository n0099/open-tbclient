package com.kwad.sdk.crash.a;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.File;
/* loaded from: classes10.dex */
public final class a {
    public static String aEM;
    public static Context awX;

    public static boolean A(File file) {
        if (file == null) {
            return false;
        }
        if (!file.exists() && !file.mkdirs()) {
            return false;
        }
        return true;
    }

    public static File Gv() {
        File file;
        if (!TextUtils.isEmpty(aEM)) {
            file = new File(aEM);
        } else {
            file = new File(getDataDir(awX), "kwad_ex");
        }
        if (!file.exists()) {
            file.mkdir();
        }
        return file;
    }

    public static File Gw() {
        return new File(Gv(), "java_crash/dump");
    }

    public static File Gx() {
        return new File(Gv(), "anr_log/dump");
    }

    public static File Gy() {
        return new File(Gv(), "native_crash_log/dump");
    }

    public static File getDataDir(Context context) {
        int i = Build.VERSION.SDK_INT;
        File file = null;
        if (i >= 29) {
            return new File(context.getExternalFilesDir(null).getAbsolutePath());
        }
        if (i >= 24) {
            file = context.getDataDir();
        }
        if (file == null) {
            file = new File(Environment.getDataDirectory().getPath() + "/data/" + context.getPackageName());
            if (!file.exists()) {
                return new File("/data/data/" + context.getPackageName());
            }
        }
        return file;
    }

    public static void init(@NonNull Context context, @Nullable String str) {
        awX = context;
        aEM = str;
    }
}
