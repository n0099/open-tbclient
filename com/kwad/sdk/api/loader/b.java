package com.kwad.sdk.api.loader;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
/* loaded from: classes10.dex */
public final class b {
    public static void E(String str, String str2) {
        File file = new File(str2);
        if (file.exists()) {
            h.j(file);
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file, false);
        file.setReadOnly();
        d(new FileInputStream(str), fileOutputStream);
    }

    public static void c(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[8192];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    public static void d(InputStream inputStream, OutputStream outputStream) {
        try {
            c(inputStream, outputStream);
            try {
                outputStream.close();
            } catch (Exception unused) {
            }
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception unused2) {
                }
            }
            try {
                outputStream.close();
            } catch (Exception unused3) {
            }
        }
    }

    public static void F(String str, String str2) {
        String str3;
        if (w.is64Bit()) {
            str3 = "lib/arm64-v8a/";
        } else {
            str3 = "lib/armeabi-v7a/";
        }
        ZipFile zipFile = null;
        try {
            ZipFile zipFile2 = new ZipFile(str);
            try {
                Enumeration<? extends ZipEntry> entries = zipFile2.entries();
                while (entries.hasMoreElements()) {
                    ZipEntry nextElement = entries.nextElement();
                    if (!nextElement.isDirectory()) {
                        String name = nextElement.getName();
                        if (!TextUtils.isEmpty(name) && !name.contains("../") && name.endsWith(".so") && name.startsWith(str3)) {
                            File file = new File(str2, name.substring(str3.length()));
                            FileOutputStream fileOutputStream = new FileOutputStream(file);
                            file.setReadOnly();
                            d(zipFile2.getInputStream(nextElement), fileOutputStream);
                        }
                    }
                }
                try {
                    zipFile2.close();
                } catch (Exception unused) {
                }
            } catch (Throwable th) {
                th = th;
                zipFile = zipFile2;
                if (zipFile != null) {
                    try {
                        zipFile.close();
                    } catch (Exception unused2) {
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean a(Context context, ClassLoader classLoader, String str, String str2) {
        String q = h.q(context, str2);
        h(new File(q));
        String s = h.s(context, str2);
        String t = h.t(context, str2);
        String u = h.u(context, str2);
        try {
            E(str, s);
            F(str, u);
            if (k.b(context, classLoader, s, t, u).zk() != null) {
                return true;
            }
            return false;
        } catch (Exception e) {
            h(new File(s));
            h(new File(t));
            h(new File(u));
            h(new File(q));
            throw e;
        }
    }

    public static void h(File file) {
        if (file.isFile()) {
            file.delete();
            return;
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                h(file2);
            }
        }
    }
}
