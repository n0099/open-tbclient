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
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f36518a = a("IHDR");

    /* renamed from: b  reason: collision with root package name */
    public static final byte[] f36519b = a("PLTE");

    /* renamed from: c  reason: collision with root package name */
    public static final byte[] f36520c = a("IDAT");

    /* renamed from: d  reason: collision with root package name */
    public static final byte[] f36521d = a("IEND");

    /* renamed from: f  reason: collision with root package name */
    public static byte[] f36523f = new byte[4096];

    /* renamed from: e  reason: collision with root package name */
    public static Pattern f36522e = Pattern.compile("[a-zA-Z][a-zA-Z][A-Z][a-zA-Z]");

    public static String a(byte[] bArr) {
        return new String(bArr, com.kwad.sdk.pngencrypt.n.f36580a);
    }

    public static String a(byte[] bArr, int i) {
        return (bArr == null || bArr.length < i + 4) ? "?" : a(bArr, i, 4);
    }

    public static String a(byte[] bArr, int i, int i2) {
        return new String(bArr, i, i2, com.kwad.sdk.pngencrypt.n.f36580a);
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
        synchronized (f36523f) {
            while (true) {
                int read = inputStream.read(f36523f);
                if (read > 0) {
                    outputStream.write(f36523f, 0, read);
                }
            }
        }
    }

    public static byte[] a(String str) {
        return str.getBytes(com.kwad.sdk.pngencrypt.n.f36580a);
    }

    public static byte[] a(byte[] bArr, int i, int i2, boolean z) {
        try {
            InputStream byteArrayInputStream = new ByteArrayInputStream(bArr, i, i2);
            if (!z) {
                byteArrayInputStream = new InflaterInputStream(byteArrayInputStream);
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            OutputStream deflaterOutputStream = z ? new DeflaterOutputStream(byteArrayOutputStream) : byteArrayOutputStream;
            a(byteArrayInputStream, deflaterOutputStream);
            byteArrayInputStream.close();
            deflaterOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
            return new byte[0];
        }
    }

    public static String b(byte[] bArr) {
        return new String(bArr, com.kwad.sdk.pngencrypt.n.f36581b);
    }

    public static String b(byte[] bArr, int i, int i2) {
        return new String(bArr, i, i2, com.kwad.sdk.pngencrypt.n.f36581b);
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
