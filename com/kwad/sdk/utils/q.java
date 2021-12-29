package com.kwad.sdk.utils;

import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.charset.Charset;
/* loaded from: classes3.dex */
public class q {
    public static int a(Reader reader, Writer writer) {
        long b2 = b(reader, writer);
        if (b2 > 2147483647L) {
            return -1;
        }
        return (int) b2;
    }

    public static long a(Reader reader, Writer writer, char[] cArr) {
        long j2 = 0;
        while (true) {
            int read = reader.read(cArr);
            if (-1 == read) {
                return j2;
            }
            writer.write(cArr, 0, read);
            j2 += read;
        }
    }

    public static FileInputStream a(File file) {
        if (file.exists() && !file.isDirectory() && file.canRead()) {
            return new FileInputStream(file);
        }
        return null;
    }

    @Nullable
    public static FileOutputStream a(File file, boolean z) {
        if (!file.exists()) {
            File parentFile = file.getParentFile();
            if (parentFile != null && !parentFile.mkdirs() && !parentFile.isDirectory()) {
                return null;
            }
        } else if (file.isDirectory() || !file.canWrite()) {
            return null;
        }
        return new FileOutputStream(file, z);
    }

    @Nullable
    public static String a(File file, Charset charset) {
        FileInputStream fileInputStream = null;
        try {
            FileInputStream a = a(file);
            if (a == null) {
                a(a);
                return null;
            }
            try {
                String a2 = a(a, a(charset));
                a(a);
                return a2;
            } catch (Throwable th) {
                th = th;
                fileInputStream = a;
                a(fileInputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Nullable
    public static String a(InputStream inputStream, Charset charset) {
        if (inputStream == null) {
            return null;
        }
        StringWriter stringWriter = new StringWriter();
        a(inputStream, stringWriter, charset);
        return stringWriter.toString();
    }

    public static String a(String str) {
        if (Build.VERSION.SDK_INT >= 19) {
            return new String(com.kwad.sdk.core.a.c.a().a(o.a(b(new File(str)))));
        }
        return null;
    }

    public static Charset a(Charset charset) {
        return charset == null ? Charset.defaultCharset() : charset;
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    public static void a(File file, String str, Charset charset, boolean z) {
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = a(file, z);
            if (fileOutputStream != null) {
                try {
                    a(str, fileOutputStream, charset);
                } catch (Throwable th) {
                    th = th;
                    a(fileOutputStream);
                    throw th;
                }
            }
            a(fileOutputStream);
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
        }
    }

    public static void a(InputStream inputStream, Writer writer, Charset charset) {
        a(new InputStreamReader(inputStream, a(charset)), writer);
    }

    public static void a(String str, OutputStream outputStream, Charset charset) {
        if (outputStream == null || str == null) {
            return;
        }
        outputStream.write(str.getBytes(a(charset)));
    }

    public static long b(Reader reader, Writer writer) {
        return a(reader, writer, new char[4096]);
    }

    public static InputStream b(String str) {
        FileInputStream fileInputStream;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        if (file.exists() && !file.isDirectory()) {
            try {
                fileInputStream = new FileInputStream(file);
            } catch (Exception unused) {
                b((Closeable) null);
                fileInputStream = null;
            }
            if (fileInputStream == null) {
                return null;
            }
            return new BufferedInputStream(fileInputStream);
        }
        return null;
    }

    public static void b(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static byte[] b(File file) {
        byte[] bArr = new byte[(int) file.length()];
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                fileInputStream2.read(bArr);
                com.kwad.sdk.crash.utils.b.a((InputStream) fileInputStream2);
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                try {
                    com.kwad.sdk.core.d.a.a(th);
                    return bArr;
                } finally {
                    com.kwad.sdk.crash.utils.b.a((InputStream) fileInputStream);
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
        return bArr;
    }

    public static void c(File file) {
        File[] listFiles;
        if (!file.isFile() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                c(file2);
            }
        }
        file.delete();
    }
}
