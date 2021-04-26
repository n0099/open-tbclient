package d.a.c.e.j.b;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/* loaded from: classes.dex */
public class b {
    public static int a(InputStream inputStream, OutputStream outputStream) throws IOException {
        long b2 = b(inputStream, outputStream);
        if (b2 > 2147483647L) {
            return -1;
        }
        return (int) b2;
    }

    public static long b(InputStream inputStream, OutputStream outputStream) throws IOException {
        if (inputStream == null) {
            return -1L;
        }
        byte[] bArr = new byte[4096];
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

    public static boolean c(String str) {
        return str != null && str.contains("vnd.wap.wml");
    }

    public static byte[] d(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        a(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }
}
