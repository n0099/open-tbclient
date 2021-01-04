package com.kwad.sdk.api.loader;

import android.content.Context;
import com.baidu.adp.plugin.install.PluginInstallerService;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
/* loaded from: classes5.dex */
class b {
    private static void a(File file) {
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

    private static void a(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[8192];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return;
            }
            outputStream.write(bArr, 0, read);
        }
    }

    private static void a(String str, String str2) {
        b(new FileInputStream(str), new FileOutputStream(str2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Context context, String str, String str2) {
        String b2 = g.b(context, str2);
        a(new File(b2));
        String d = g.d(context, str2);
        String e = g.e(context, str2);
        String f = g.f(context, str2);
        try {
            a(str, d);
            b(context, str, f);
            return j.a(context, d, e, f).c() != null;
        } catch (Exception e2) {
            a(new File(d));
            a(new File(e));
            a(new File(f));
            a(new File(b2));
            throw e2;
        }
    }

    private static void b(Context context, String str, String str2) {
        ZipFile zipFile;
        String name;
        String str3 = s.a() ? "lib/arm64-v8a/" : "lib/armeabi-v7a/";
        try {
            ZipFile zipFile2 = new ZipFile(str);
            try {
                Enumeration<? extends ZipEntry> entries = zipFile2.entries();
                while (entries.hasMoreElements()) {
                    ZipEntry nextElement = entries.nextElement();
                    if (!nextElement.isDirectory() && (name = nextElement.getName()) != null && name.endsWith(PluginInstallerService.APK_LIB_SUFFIX) && name.startsWith(str3)) {
                        b(zipFile2.getInputStream(nextElement), new FileOutputStream(new File(str2, name.substring(str3.length()))));
                    }
                }
                if (zipFile2 != null) {
                    try {
                        zipFile2.close();
                    } catch (Exception e) {
                    }
                }
            } catch (Throwable th) {
                th = th;
                zipFile = zipFile2;
                if (zipFile != null) {
                    try {
                        zipFile.close();
                    } catch (Exception e2) {
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            zipFile = null;
        }
    }

    private static void b(InputStream inputStream, OutputStream outputStream) {
        try {
            a(inputStream, outputStream);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e) {
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Exception e2) {
                }
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e3) {
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Exception e4) {
                }
            }
            throw th;
        }
    }
}
