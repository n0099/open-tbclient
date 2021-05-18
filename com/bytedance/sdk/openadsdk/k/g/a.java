package com.bytedance.sdk.openadsdk.k.g;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.utils.u;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static Context f29532a;

    public static void a(Context context) {
        if (context != null) {
            f29532a = context;
            return;
        }
        throw null;
    }

    public static File b(Context context) {
        File externalCacheDir = context.getExternalCacheDir();
        return externalCacheDir == null ? context.getCacheDir() : externalCacheDir;
    }

    public static boolean c() {
        try {
            String externalStorageState = Environment.getExternalStorageState();
            if (!"mounted".equals(externalStorageState)) {
                if (!"mounted_ro".equals(externalStorageState)) {
                    return false;
                }
            }
            return true;
        } catch (Exception unused) {
            return c.a().b();
        }
    }

    public static boolean d() {
        try {
            return "mounted".equals(Environment.getExternalStorageState());
        } catch (Exception unused) {
            return false;
        }
    }

    @Deprecated
    public static File a() {
        return b(f29532a);
    }

    public static File b() {
        if (c() && d()) {
            File file = new File(a(), "video");
            a(file);
            return file;
        }
        return null;
    }

    public static File a(File file, String str) {
        if (c() && d() && !TextUtils.isEmpty(str)) {
            if (file == null) {
                file = a();
            }
            File file2 = new File(file, str);
            a(file2);
            return file2;
        }
        return null;
    }

    public static void a(File file) {
        if (file.exists()) {
            return;
        }
        file.mkdirs();
    }

    public static String a(InputStream inputStream) {
        BufferedReader bufferedReader;
        try {
            StringBuilder sb = new StringBuilder();
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine);
                } catch (Throwable th) {
                    th = th;
                    try {
                        u.a("FileHelper", "readStream error", th);
                        return null;
                    } finally {
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Throwable th2) {
                                u.a("FileHelper", "br error", th2);
                            }
                        }
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable th3) {
                                u.a("FileHelper", "is error", th3);
                            }
                        }
                    }
                }
            }
            String sb2 = sb.toString();
            try {
                bufferedReader.close();
            } catch (Throwable th4) {
                u.a("FileHelper", "br error", th4);
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable th5) {
                    u.a("FileHelper", "is error", th5);
                }
            }
            return sb2;
        } catch (Throwable th6) {
            th = th6;
            bufferedReader = null;
        }
    }
}
