package com.bytedance.tea.crash.g;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import java.io.File;
/* loaded from: classes4.dex */
public class h {
    public static File a(@NonNull Context context) {
        return new File(c(context), "CrashLogJava");
    }

    public static File b(@NonNull Context context) {
        return new File(c(context), "crash_history");
    }

    public static String a() {
        return String.format("java_%s.npth", String.valueOf(System.nanoTime()));
    }

    public static String b() {
        return String.format("anr_%s.npth", String.valueOf(System.nanoTime()));
    }

    @SuppressLint({"SdCardPath"})
    private static String c(@NonNull Context context) {
        String str = null;
        try {
            if (context.getFilesDir() != null) {
                str = context.getFilesDir().getPath();
            } else {
                File dir = context.getDir("/data/data/" + context.getPackageName() + "/files/", 0);
                if (dir != null) {
                    str = dir.getPath();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str != null ? str : "/sdcard/";
    }
}
