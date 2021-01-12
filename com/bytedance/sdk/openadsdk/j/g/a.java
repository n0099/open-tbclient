package com.bytedance.sdk.openadsdk.j.g;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    static Context f7286a;

    public static void a(Context context) {
        if (context == null) {
            throw new NullPointerException();
        }
        f7286a = context;
    }

    @Deprecated
    public static File a() {
        return b(f7286a);
    }

    public static File b(Context context) {
        File externalCacheDir = context.getExternalCacheDir();
        if (externalCacheDir == null) {
            return context.getCacheDir();
        }
        return externalCacheDir;
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
        if (!c() || !d() || TextUtils.isEmpty(str)) {
            return null;
        }
        if (file == null) {
            file = a();
        }
        File file2 = new File(file, str);
        a(file2);
        return file2;
    }

    public static void a(File file) {
        if (!file.exists()) {
            file.mkdirs();
        }
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
        } catch (Exception e) {
            return c.a().b();
        }
    }

    public static boolean d() {
        try {
            return "mounted".equals(Environment.getExternalStorageState());
        } catch (Exception e) {
            return false;
        }
    }

    public static String a(InputStream inputStream) {
        try {
            StringBuilder sb = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb.append(readLine);
                } else {
                    return sb.toString();
                }
            }
        } catch (Throwable th) {
            return null;
        }
    }
}
