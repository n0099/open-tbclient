package com.qq.e.comm.plugin.util;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.util.Md5Util;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
/* loaded from: classes3.dex */
public class ah {
    public static long a(File file) {
        File[] listFiles;
        long j = 0;
        if (file != null && file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                j += file2.isDirectory() ? a(file2) : file2.length();
            }
        }
        return j;
    }

    public static File a() {
        return GDTADManager.getInstance().getAppContext().getDir("adnet", 0);
    }

    public static File a(Context context) {
        File file = new File(context.getApplicationContext().getCacheDir(), "gdtadmobwebcache");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static String a(String str) {
        return Md5Util.encode(str);
    }

    public static void a(File file, String str) {
        if (file == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(str.getBytes(com.qq.e.comm.plugin.f.a.f11990a));
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (IOException e) {
        }
    }

    public static File b(Context context) {
        File file = new File(context.getApplicationContext().getCacheDir(), "gdtadmobwebdatabase");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File b(String str) {
        File file = new File(a().getAbsolutePath() + File.separator + str);
        file.mkdirs();
        return file;
    }

    public static void b() {
        if (a(a()) >= GDTADManager.getInstance().getSM().getInteger("adnetDirMaxSize", 50) * 1024 * 1024) {
            b(a());
            com.qq.e.comm.plugin.y.u.a(100032, 0, null);
        }
    }

    public static void b(File file) {
        File[] listFiles;
        if (file == null || !file.isDirectory()) {
            return;
        }
        for (File file2 : file.listFiles()) {
            if (file2.isDirectory()) {
                b(file2);
            } else {
                file2.delete();
            }
        }
        file.delete();
    }

    public static File c() {
        File file = new File(GDTADManager.getInstance().getAppContext().getDir("firstplay", 0).getAbsolutePath());
        file.mkdirs();
        return file;
    }

    public static File c(String str) {
        return new File(b(str).getAbsolutePath() + File.separator + "preload");
    }

    public static String c(File file) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        if (file != null && file.exists()) {
            try {
                fileInputStream = new FileInputStream(file);
            } catch (IOException e) {
                fileInputStream2 = null;
            } catch (Throwable th) {
                th = th;
                fileInputStream = null;
            }
            try {
                byte[] bArr = new byte[fileInputStream.available()];
                fileInputStream.read(bArr);
                String str = new String(bArr, com.qq.e.comm.plugin.f.a.f11990a);
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                        return str;
                    } catch (IOException e2) {
                        return str;
                    }
                }
                return str;
            } catch (IOException e3) {
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                        return null;
                    } catch (IOException e4) {
                        return null;
                    }
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e5) {
                    }
                }
                throw th;
            }
        }
        return null;
    }

    public static File d() {
        File externalCacheDir = GDTADManager.getInstance().getAppContext().getApplicationContext().getExternalCacheDir();
        return externalCacheDir != null ? externalCacheDir : GDTADManager.getInstance().getAppContext().getApplicationContext().getCacheDir();
    }

    public static File d(String str) {
        File f = f();
        if (f == null) {
            return null;
        }
        String a2 = a(str);
        if (TextUtils.isEmpty(a2)) {
            return null;
        }
        return new File(f, a2);
    }

    public static File e() {
        if (SDKStatus.getSDKVersionCode() >= 20) {
            File file = new File(d(), "com_qq_e_download");
            if (file.exists()) {
                return file;
            }
            file.mkdirs();
            return file;
        } else if ("mounted".equals(Environment.getExternalStorageState()) && Environment.getExternalStorageDirectory() != null && Environment.getExternalStorageDirectory().exists()) {
            File file2 = new File(Environment.getExternalStorageDirectory(), "GDTDOWNLOAD");
            if (file2.exists()) {
                return file2;
            }
            file2.mkdirs();
            return file2;
        } else {
            return null;
        }
    }

    public static File e(String str) {
        File g = g();
        if (g == null) {
            return null;
        }
        String a2 = a(str);
        if (TextUtils.isEmpty(a2)) {
            return null;
        }
        return new File(g, a2);
    }

    public static File f() {
        File e = e();
        if (e == null) {
            return null;
        }
        File file = new File(e, "video");
        if (file.exists()) {
            return file;
        }
        file.mkdirs();
        return file;
    }

    public static File g() {
        File file = new File(a(), "html");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File h() {
        File e = e();
        if (e == null) {
            return null;
        }
        File file = new File(e, "apk");
        if (file.exists()) {
            return file;
        }
        file.mkdirs();
        return file;
    }

    public static File i() {
        File e = e();
        if (e == null) {
            return null;
        }
        File file = new File(e, AlaStaticKeys.ALA_STATIC_VALUE_ICON);
        if (file.exists()) {
            return file;
        }
        file.mkdirs();
        return file;
    }

    public static File j() {
        File file = new File(GDTADManager.getInstance().getAppContext().getCacheDir(), "resource");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File k() {
        File file = new File(GDTADManager.getInstance().getAppContext().getCacheDir(), "template");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File l() {
        return new File(GDTADManager.getInstance().getAppContext().getCacheDir(), "GDTDOWNLOAD/image");
    }
}
