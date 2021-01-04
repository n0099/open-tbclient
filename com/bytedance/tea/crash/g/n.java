package com.bytedance.tea.crash.g;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class n {
    public static JSONObject a(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("inner_app_used", b(context));
            jSONObject.put("inner_free", b());
            jSONObject.put("inner_total", c());
            jSONObject.put("sdcard_app_used", c(context));
            jSONObject.put("sdcard_free", d());
            jSONObject.put("sdcard_total", e());
        } catch (Exception e) {
        }
        return jSONObject;
    }

    private static long b(Context context) {
        try {
            return am(context.getFilesDir().getParentFile());
        } catch (Exception e) {
            return 0L;
        }
    }

    private static long b() {
        try {
            return b(Environment.getRootDirectory());
        } catch (Exception e) {
            return 0L;
        }
    }

    private static long c() {
        try {
            return a(Environment.getRootDirectory());
        } catch (Exception e) {
            return 0L;
        }
    }

    private static long c(Context context) {
        File externalFilesDir;
        try {
            if (a() && (externalFilesDir = context.getExternalFilesDir(null)) != null) {
                return am(externalFilesDir.getParentFile());
            }
        } catch (Exception e) {
        }
        return 0L;
    }

    private static long d() {
        try {
            if (a()) {
                return Environment.getExternalStorageDirectory().getFreeSpace();
            }
        } catch (Exception e) {
        }
        return 0L;
    }

    private static long e() {
        try {
            if (a()) {
                return Environment.getExternalStorageDirectory().getTotalSpace();
            }
        } catch (Exception e) {
        }
        return 0L;
    }

    public static boolean a() {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    public static long a(File file) {
        long blockCount;
        try {
            StatFs statFs = new StatFs(file.getPath());
            if (Build.VERSION.SDK_INT >= 18) {
                blockCount = statFs.getTotalBytes();
            } else {
                blockCount = statFs.getBlockCount() * statFs.getBlockSize();
            }
            return blockCount;
        } catch (Throwable th) {
            return 0L;
        }
    }

    public static long b(File file) {
        long availableBlocks;
        try {
            StatFs statFs = new StatFs(file.getPath());
            if (Build.VERSION.SDK_INT >= 18) {
                availableBlocks = statFs.getFreeBytes();
            } else {
                availableBlocks = statFs.getAvailableBlocks() * statFs.getBlockSize();
            }
            return availableBlocks;
        } catch (Throwable th) {
            return 0L;
        }
    }

    public static long am(File file) {
        long length;
        long j = 0;
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    length = am(file2);
                } else {
                    length = file2.length();
                }
                j += length;
            }
        }
        return j;
    }
}
