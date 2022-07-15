package com.kwad.sdk.crash.utils;

import android.content.Context;
import android.os.Build;
import android.os.StatFs;
import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.charset.Charset;
/* loaded from: classes5.dex */
public final class g {
    public static final char a = File.separatorChar;
    public static final String b;

    static {
        PrintWriter printWriter;
        Throwable th;
        StringBuilderWriter stringBuilderWriter;
        Exception e;
        String str;
        try {
            try {
                stringBuilderWriter = new StringBuilderWriter(4);
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                printWriter = new PrintWriter(stringBuilderWriter);
                try {
                    printWriter.println();
                    str = stringBuilderWriter.toString();
                    b.a(printWriter);
                    b.a(stringBuilderWriter);
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    b.a(printWriter);
                    b.a(stringBuilderWriter);
                    str = "\n";
                    b = str;
                }
            } catch (Exception e3) {
                printWriter = null;
                e = e3;
            } catch (Throwable th3) {
                printWriter = null;
                th = th3;
                b.a(printWriter);
                b.a(stringBuilderWriter);
                throw th;
            }
        } catch (Exception e4) {
            printWriter = null;
            e = e4;
            stringBuilderWriter = null;
        } catch (Throwable th4) {
            printWriter = null;
            th = th4;
            stringBuilderWriter = null;
        }
        b = str;
    }

    public static int a(InputStream inputStream, OutputStream outputStream) {
        long b2 = b(inputStream, outputStream);
        if (b2 > 2147483647L) {
            return -1;
        }
        return (int) b2;
    }

    public static int a(Reader reader, Writer writer) {
        long b2 = b(reader, writer);
        if (b2 > 2147483647L) {
            return -1;
        }
        return (int) b2;
    }

    public static long a(InputStream inputStream, OutputStream outputStream, byte[] bArr) {
        long j = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 == read) {
                return j;
            }
            outputStream.write(bArr, 0, read);
            j += read;
        }
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

    public static long a(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        return b(new File(str));
    }

    public static String a(Context context, String str) {
        InputStream inputStream = null;
        try {
            inputStream = context.getAssets().open(str);
            return a(inputStream, a.a(Charset.defaultCharset()));
        } finally {
            b.a(inputStream);
        }
    }

    public static String a(File file) {
        return b(new InputStreamReader(new BufferedInputStream(new FileInputStream(file)), a.b));
    }

    public static String a(InputStream inputStream) {
        InputStreamReader inputStreamReader;
        Throwable th;
        BufferedReader bufferedReader;
        try {
            inputStreamReader = new InputStreamReader(inputStream);
            try {
                bufferedReader = new BufferedReader(inputStreamReader, 1024);
                try {
                    String b2 = b(bufferedReader);
                    b.a(bufferedReader);
                    b.a(inputStreamReader);
                    return b2;
                } catch (Throwable th2) {
                    th = th2;
                    b.a(bufferedReader);
                    b.a(inputStreamReader);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
            }
        } catch (Throwable th4) {
            inputStreamReader = null;
            th = th4;
            bufferedReader = null;
        }
    }

    public static String a(InputStream inputStream, Charset charset) {
        StringBuilderWriter stringBuilderWriter = new StringBuilderWriter();
        a(inputStream, stringBuilderWriter, charset);
        return stringBuilderWriter.toString();
    }

    public static String a(Reader reader) {
        StringBuilderWriter stringBuilderWriter = new StringBuilderWriter();
        a(reader, stringBuilderWriter);
        return stringBuilderWriter.toString();
    }

    public static void a(InputStream inputStream, Writer writer, Charset charset) {
        a(new InputStreamReader(inputStream, a.a(charset)), writer);
    }

    public static void a(String str, OutputStream outputStream, Charset charset) {
        if (str != null) {
            outputStream.write(str.getBytes(a.a(charset)));
        }
    }

    public static void a(String str, String str2, boolean z) {
        FileWriter fileWriter;
        try {
            File file = new File(str);
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
            fileWriter = new FileWriter(str, false);
        } catch (Throwable unused) {
            fileWriter = null;
        }
        try {
            fileWriter.write(str2);
            fileWriter.flush();
            b.a(fileWriter);
        } catch (Throwable unused2) {
            b.a(fileWriter);
        }
    }

    public static long b(File file) {
        try {
            if (file.exists()) {
                StatFs statFs = new StatFs(file.getAbsolutePath());
                return Build.VERSION.SDK_INT < 18 ? statFs.getBlockSize() * statFs.getAvailableBlocks() : statFs.getBlockSizeLong() * statFs.getAvailableBlocksLong();
            }
            return 0L;
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static long b(InputStream inputStream, OutputStream outputStream) {
        return a(inputStream, outputStream, new byte[4096]);
    }

    public static long b(Reader reader, Writer writer) {
        return a(reader, writer, new char[4096]);
    }

    public static long b(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        return c(new File(str));
    }

    public static String b(InputStream inputStream) {
        return a(inputStream, Charset.defaultCharset());
    }

    public static String b(Reader reader) {
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
                        b.a(stringWriter);
                        return stringWriter3;
                    }
                    stringWriter.write(cArr, 0, read);
                }
            } catch (Throwable th2) {
                th = th2;
                b.a(reader);
                b.a(stringWriter);
                throw th;
            }
        } catch (Throwable th3) {
            stringWriter = stringWriter2;
            th = th3;
        }
    }

    public static long c(File file) {
        try {
            if (file.exists()) {
                StatFs statFs = new StatFs(file.getAbsolutePath());
                return Build.VERSION.SDK_INT < 18 ? statFs.getBlockSize() * statFs.getBlockCount() : statFs.getBlockSizeLong() * statFs.getBlockCountLong();
            }
            return 0L;
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static String c(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    String str = new String(byteArrayOutputStream.toByteArray());
                    b.a(inputStream);
                    b.a(byteArrayOutputStream);
                    return str;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            } catch (IOException unused) {
                b.a(inputStream);
                b.a(byteArrayOutputStream);
                return null;
            } catch (Throwable th) {
                b.a(inputStream);
                b.a(byteArrayOutputStream);
                throw th;
            }
        }
    }
}
