package com.kwad.sdk.pngencrypt.chunk;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f6920a = a("IHDR");
    public static final byte[] b = a("PLTE");
    public static final byte[] c = a("IDAT");
    public static final byte[] d = a("IEND");
    private static byte[] f = new byte[4096];
    public static Pattern e = Pattern.compile("[a-zA-Z][a-zA-Z][A-Z][a-zA-Z]");

    public static String a(byte[] bArr) {
        return new String(bArr, com.kwad.sdk.pngencrypt.n.f6930a);
    }

    public static String a(byte[] bArr, int i) {
        return (bArr == null || bArr.length < i + 4) ? "?" : a(bArr, i, 4);
    }

    public static String a(byte[] bArr, int i, int i2) {
        return new String(bArr, i, i2, com.kwad.sdk.pngencrypt.n.f6930a);
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

    private static void a(InputStream inputStream, OutputStream outputStream) {
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
        return str.getBytes(com.kwad.sdk.pngencrypt.n.f6930a);
    }

    public static byte[] a(byte[] bArr, int i, int i2, boolean z) {
        try {
            InputStream byteArrayInputStream = new ByteArrayInputStream(bArr, i, i2);
            InputStream inflaterInputStream = z ? byteArrayInputStream : new InflaterInputStream(byteArrayInputStream);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            OutputStream deflaterOutputStream = z ? new DeflaterOutputStream(byteArrayOutputStream) : byteArrayOutputStream;
            a(inflaterInputStream, deflaterOutputStream);
            inflaterInputStream.close();
            deflaterOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
            return new byte[0];
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

    public static int c(byte[] bArr) {
        for (int i = 0; i < bArr.length; i++) {
            if (bArr[i] == 0) {
                return i;
            }
        }
        return -1;
    }

    public static boolean c(String str) {
        return Character.isUpperCase(str.charAt(1));
    }

    public static boolean d(String str) {
        return !Character.isUpperCase(str.charAt(3));
    }
}
