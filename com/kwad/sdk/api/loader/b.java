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
/* loaded from: classes5.dex */
public final class b {
    public static void a(File file) {
        if (file.isFile()) {
            file.delete();
            return;
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null || listFiles.length <= 0) {
            return;
        }
        for (File file2 : listFiles) {
            a(file2);
        }
    }

    public static void a(InputStream inputStream, OutputStream outputStream) {
        try {
            byte[] bArr = new byte[8192];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                outputStream.write(bArr, 0, read);
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception unused) {
                }
            }
            try {
                outputStream.close();
            } catch (Exception unused2) {
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception unused3) {
                }
            }
            try {
                outputStream.close();
            } catch (Exception unused4) {
            }
            throw th;
        }
    }

    public static void a(String str, String str2) {
        String str3 = t.a() ? "lib/arm64-v8a/" : "lib/armeabi-v7a/";
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
                            a(zipFile2.getInputStream(nextElement), new FileOutputStream(new File(str2, name.substring(str3.length()))));
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

    public static boolean a(Context context, String str, String str2) {
        String a = h.a(context, str2);
        a(new File(a));
        String c = h.c(context, str2);
        String d = h.d(context, str2);
        String e = h.e(context, str2);
        try {
            a(new FileInputStream(str), new FileOutputStream(c));
            a(str, e);
            return k.a(context, c, d, e).c != null;
        } catch (Exception e2) {
            a(new File(c));
            a(new File(d));
            a(new File(e));
            a(new File(a));
            throw e2;
        }
    }
}
