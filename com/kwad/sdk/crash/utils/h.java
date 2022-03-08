package com.kwad.sdk.crash.utils;

import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
/* loaded from: classes8.dex */
public class h {
    public static final char a = File.separatorChar;

    /* renamed from: b  reason: collision with root package name */
    public static final String f55135b;

    static {
        StringBuilderWriter stringBuilderWriter = new StringBuilderWriter(4);
        PrintWriter printWriter = new PrintWriter(stringBuilderWriter);
        printWriter.println();
        f55135b = stringBuilderWriter.toString();
        printWriter.close();
    }

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

    public static String a(File file) {
        return a(new InputStreamReader(new BufferedInputStream(new FileInputStream(file)), StandardCharsets.UTF_8));
    }

    public static String a(InputStream inputStream) {
        return a(inputStream, Charset.defaultCharset());
    }

    public static String a(InputStream inputStream, Charset charset) {
        StringBuilderWriter stringBuilderWriter = new StringBuilderWriter();
        a(inputStream, stringBuilderWriter, charset);
        return stringBuilderWriter.toString();
    }

    public static String a(Reader reader) {
        StringWriter stringWriter;
        Throwable th;
        StringWriter stringWriter2 = new StringWriter();
        try {
            stringWriter = new StringWriter();
            try {
                char[] cArr = new char[1024];
                while (true) {
                    int read = reader.read(cArr);
                    if (read == -1) {
                        String stringWriter3 = stringWriter.toString();
                        b.a(reader);
                        b.a((Writer) stringWriter);
                        return stringWriter3;
                    }
                    stringWriter.write(cArr, 0, read);
                }
            } catch (Throwable th2) {
                th = th2;
                b.a(reader);
                b.a((Writer) stringWriter);
                throw th;
            }
        } catch (Throwable th3) {
            stringWriter = stringWriter2;
            th = th3;
        }
    }

    public static void a(InputStream inputStream, Writer writer, Charset charset) {
        a(new InputStreamReader(inputStream, a.a(charset)), writer);
    }

    public static void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        File file = new File(str);
        if (file.exists() && file.isFile()) {
            file.delete();
        }
    }

    public static void a(String str, OutputStream outputStream, Charset charset) {
        if (str != null) {
            outputStream.write(str.getBytes(a.a(charset)));
        }
    }

    public static void a(String str, String str2, boolean z) {
        FileWriter fileWriter = null;
        try {
            try {
                File file = new File(str);
                if (!file.exists()) {
                    file.getParentFile().mkdirs();
                    file.createNewFile();
                }
                FileWriter fileWriter2 = new FileWriter(str, z);
                try {
                    fileWriter2.write(str2);
                    fileWriter2.close();
                } catch (Throwable th) {
                    th = th;
                    fileWriter = fileWriter2;
                    try {
                        com.kwad.sdk.core.d.a.b(th);
                        if (fileWriter != null) {
                            fileWriter.close();
                        }
                    } catch (Throwable th2) {
                        if (fileWriter != null) {
                            try {
                                fileWriter.close();
                            } catch (Exception unused) {
                            }
                        }
                        throw th2;
                    }
                }
            } catch (Exception unused2) {
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public static long b(Reader reader, Writer writer) {
        return a(reader, writer, new char[4096]);
    }

    public static String b(Reader reader) {
        StringBuilderWriter stringBuilderWriter = new StringBuilderWriter();
        a(reader, stringBuilderWriter);
        return stringBuilderWriter.toString();
    }

    public static void b(String str) {
        try {
            a(str);
        } catch (Throwable unused) {
        }
    }
}
