package com.kwad.sdk.pngencrypt.chunk;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.zip.InflaterInputStream;
/* loaded from: classes5.dex */
public final class b {
    public static final byte[] a = a("IHDR");
    public static final byte[] b = a("PLTE");
    public static final byte[] c = a("IDAT");
    public static final byte[] d = a("IEND");
    public static byte[] f = new byte[4096];
    public static Pattern e = Pattern.compile("[a-zA-Z][a-zA-Z][A-Z][a-zA-Z]");

    public static String a(byte[] bArr) {
        return new String(bArr, com.kwad.sdk.pngencrypt.n.a);
    }

    public static String a(byte[] bArr, int i) {
        return (bArr == null || bArr.length < 8) ? "?" : a(bArr, 4, 4);
    }

    public static String a(byte[] bArr, int i, int i2) {
        return new String(bArr, i, i2, com.kwad.sdk.pngencrypt.n.a);
    }

    public static List<PngChunk> a(List<PngChunk> list, c cVar) {
        ArrayList arrayList = new ArrayList();
        for (PngChunk pngChunk : list) {
            if (cVar.a(pngChunk)) {
                arrayList.add(pngChunk);
            }
        }
        return arrayList;
    }

    public static void a(InputStream inputStream, OutputStream outputStream) {
        synchronized (f) {
            while (true) {
                int read = inputStream.read(f);
                if (read > 0) {
                    outputStream.write(f, 0, read);
                }
            }
        }
    }

    public static byte[] a(String str) {
        return str.getBytes(com.kwad.sdk.pngencrypt.n.a);
    }

    public static byte[] a(byte[] bArr, int i, int i2, boolean z) {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        ByteArrayInputStream byteArrayInputStream;
        InflaterInputStream inflaterInputStream;
        InflaterInputStream inflaterInputStream2 = null;
        try {
            byteArrayInputStream = new ByteArrayInputStream(bArr, i, i2);
            try {
                inflaterInputStream = new InflaterInputStream(byteArrayInputStream);
                try {
                    byteArrayOutputStream2 = new ByteArrayOutputStream();
                } catch (Exception e2) {
                    e = e2;
                    byteArrayOutputStream2 = null;
                } catch (Throwable th) {
                    th = th;
                    byteArrayOutputStream2 = null;
                }
            } catch (Exception e3) {
                e = e3;
                byteArrayOutputStream = null;
                byteArrayOutputStream2 = null;
            } catch (Throwable th2) {
                th = th2;
                byteArrayOutputStream = null;
                byteArrayOutputStream2 = null;
            }
        } catch (Exception e4) {
            e = e4;
            byteArrayOutputStream = null;
            byteArrayOutputStream2 = null;
            byteArrayInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream = null;
            byteArrayOutputStream2 = null;
            byteArrayInputStream = null;
        }
        try {
            a(inflaterInputStream, byteArrayOutputStream2);
            byte[] byteArray = byteArrayOutputStream2.toByteArray();
            com.kwad.sdk.crash.utils.b.a(inflaterInputStream);
            com.kwad.sdk.crash.utils.b.a(byteArrayInputStream);
            com.kwad.sdk.crash.utils.b.a(byteArrayOutputStream2);
            com.kwad.sdk.crash.utils.b.a(byteArrayOutputStream2);
            return byteArray;
        } catch (Exception e5) {
            e = e5;
            inflaterInputStream2 = inflaterInputStream;
            byteArrayOutputStream = byteArrayOutputStream2;
            try {
                com.kwad.sdk.core.d.b.a(e);
                com.kwad.sdk.crash.utils.b.a(inflaterInputStream2);
                com.kwad.sdk.crash.utils.b.a(byteArrayInputStream);
                com.kwad.sdk.crash.utils.b.a(byteArrayOutputStream2);
                com.kwad.sdk.crash.utils.b.a(byteArrayOutputStream);
                return new byte[0];
            } catch (Throwable th4) {
                th = th4;
                com.kwad.sdk.crash.utils.b.a(inflaterInputStream2);
                com.kwad.sdk.crash.utils.b.a(byteArrayInputStream);
                com.kwad.sdk.crash.utils.b.a(byteArrayOutputStream2);
                com.kwad.sdk.crash.utils.b.a(byteArrayOutputStream);
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
            inflaterInputStream2 = inflaterInputStream;
            byteArrayOutputStream = byteArrayOutputStream2;
            com.kwad.sdk.crash.utils.b.a(inflaterInputStream2);
            com.kwad.sdk.crash.utils.b.a(byteArrayInputStream);
            com.kwad.sdk.crash.utils.b.a(byteArrayOutputStream2);
            com.kwad.sdk.crash.utils.b.a(byteArrayOutputStream);
            throw th;
        }
    }

    public static String b(byte[] bArr) {
        return new String(bArr, com.kwad.sdk.pngencrypt.n.b);
    }

    public static String b(byte[] bArr, int i, int i2) {
        return new String(bArr, i, i2, com.kwad.sdk.pngencrypt.n.b);
    }

    public static boolean b(String str) {
        return Character.isUpperCase(str.charAt(0));
    }

    public static boolean c(String str) {
        return Character.isUpperCase(str.charAt(1));
    }

    public static boolean d(String str) {
        return !Character.isUpperCase(str.charAt(3));
    }
}
