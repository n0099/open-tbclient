package com.kwad.sdk.utils;

import androidx.annotation.Nullable;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.charset.Charset;
/* loaded from: classes3.dex */
public class k {
    public static int a(Reader reader, Writer writer) {
        long b2 = b(reader, writer);
        if (b2 > 2147483647L) {
            return -1;
        }
        return (int) b2;
    }

    public static long a(Reader reader, Writer writer, char[] cArr) {
        long j = 0;
        while (true) {
            int read = reader.read(cArr);
            if (-1 == read) {
                return j;
            }
            writer.write(cArr, 0, read);
            j += read;
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
        FileInputStream fileInputStream;
        String str = null;
        try {
            fileInputStream = a(file);
            if (fileInputStream != null) {
                try {
                    str = a(fileInputStream, a(charset));
                    a(fileInputStream);
                } catch (Throwable th) {
                    th = th;
                    a(fileInputStream);
                    throw th;
                }
            } else {
                a(fileInputStream);
            }
            return str;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
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

    public static Charset a(Charset charset) {
        return charset == null ? Charset.defaultCharset() : charset;
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
            }
        }
    }

    public static void a(File file, String str, Charset charset, boolean z) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = a(file, z);
            if (fileOutputStream != null) {
                a(str, fileOutputStream, charset);
            }
        } finally {
            a(fileOutputStream);
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
}
