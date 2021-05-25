package d.a.s0.b;

import java.nio.charset.Charset;
/* loaded from: classes5.dex */
public class d {
    public static byte[] a(String str, Charset charset) {
        if (str == null) {
            return null;
        }
        return str.getBytes(charset);
    }

    public static byte[] b(String str) {
        return a(str, c.f64494a);
    }

    public static String c(byte[] bArr, Charset charset) {
        if (bArr == null) {
            return null;
        }
        return new String(bArr, charset);
    }

    public static String d(byte[] bArr) {
        return c(bArr, c.f64494a);
    }
}
