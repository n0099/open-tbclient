package d.b.h0.q.d;

import android.text.TextUtils;
import java.io.ByteArrayInputStream;
import java.io.CharArrayWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/* loaded from: classes3.dex */
public class a {
    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static long b(InputStream inputStream, OutputStream outputStream) {
        if (inputStream != null && outputStream != null) {
            try {
                byte[] bArr = new byte[3072];
                long j = 0;
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read > 0) {
                        outputStream.write(bArr, 0, read);
                        j += read;
                    } else {
                        outputStream.flush();
                        return j;
                    }
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        return 0L;
    }

    public static String c(File file) {
        FileReader fileReader;
        FileReader fileReader2 = null;
        if (file != null && file.exists()) {
            try {
                fileReader = new FileReader(file);
                try {
                    char[] cArr = new char[256];
                    CharArrayWriter charArrayWriter = new CharArrayWriter();
                    while (true) {
                        int read = fileReader.read(cArr);
                        if (read > 0) {
                            charArrayWriter.write(cArr, 0, read);
                        } else {
                            String charArrayWriter2 = charArrayWriter.toString();
                            a(fileReader);
                            return charArrayWriter2;
                        }
                    }
                } catch (Exception unused) {
                    a(fileReader);
                    return null;
                } catch (Throwable th) {
                    th = th;
                    fileReader2 = fileReader;
                    a(fileReader2);
                    throw th;
                }
            } catch (Exception unused2) {
                fileReader = null;
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return null;
    }

    public static boolean d(String str, File file) {
        File parentFile;
        if (TextUtils.isEmpty(str) || (parentFile = file.getParentFile()) == null || !parentFile.isDirectory()) {
            return false;
        }
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        e(str.getBytes(), file);
        return true;
    }

    public static void e(byte[] bArr, File file) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        f(byteArrayInputStream, file);
        a(byteArrayInputStream);
    }

    public static void f(InputStream inputStream, File file) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(file);
            } catch (Throwable th) {
                th = th;
            }
        } catch (FileNotFoundException e2) {
            e = e2;
        }
        try {
            b(inputStream, fileOutputStream);
            a(fileOutputStream);
        } catch (FileNotFoundException e3) {
            e = e3;
            fileOutputStream2 = fileOutputStream;
            e.printStackTrace();
            a(fileOutputStream2);
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            a(fileOutputStream2);
            throw th;
        }
    }
}
