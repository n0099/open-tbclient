package com.kwad.sdk.core.a;

import com.baidu.searchbox.retrieve.file.util.AESUtil;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes5.dex */
public final class b {
    public static final Charset a = Charset.forName("UTF-8");

    public static void a(InputStream inputStream, OutputStream outputStream) {
        GZIPOutputStream gZIPOutputStream = null;
        try {
            GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(outputStream);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr, 0, 1024);
                    if (read == -1) {
                        gZIPOutputStream2.finish();
                        gZIPOutputStream2.flush();
                        com.kwad.sdk.crash.utils.b.a(gZIPOutputStream2);
                        return;
                    }
                    gZIPOutputStream2.write(bArr, 0, read);
                }
            } catch (Throwable th) {
                th = th;
                gZIPOutputStream = gZIPOutputStream2;
                com.kwad.sdk.crash.utils.b.a(gZIPOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static byte[] a(String str, byte[] bArr) {
        return a(str.getBytes(a), bArr, 2);
    }

    public static byte[] a(byte[] bArr) {
        ByteArrayInputStream byteArrayInputStream;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    a(byteArrayInputStream, byteArrayOutputStream);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.flush();
                    com.kwad.sdk.crash.utils.b.a(byteArrayOutputStream);
                    com.kwad.sdk.crash.utils.b.a(byteArrayInputStream);
                    return byteArray;
                } catch (Throwable th2) {
                    th = th2;
                    com.kwad.sdk.crash.utils.b.a(byteArrayOutputStream);
                    com.kwad.sdk.crash.utils.b.a(byteArrayInputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                byteArrayOutputStream = null;
            }
        } catch (Throwable th4) {
            byteArrayInputStream = null;
            th = th4;
            byteArrayOutputStream = null;
        }
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        return a(bArr, bArr2, 1);
    }

    public static byte[] a(byte[] bArr, byte[] bArr2, int i) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            Cipher cipher = Cipher.getInstance(AESUtil.ECB_TRANSFORMATION);
            cipher.init(i, secretKeySpec);
            return cipher.doFinal(bArr2);
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.a(e);
            return new byte[0];
        }
    }

    public static void b(InputStream inputStream, OutputStream outputStream) {
        GZIPInputStream gZIPInputStream = null;
        try {
            GZIPInputStream gZIPInputStream2 = new GZIPInputStream(inputStream);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = gZIPInputStream2.read(bArr, 0, 1024);
                    if (read == -1) {
                        com.kwad.sdk.crash.utils.b.a(gZIPInputStream2);
                        return;
                    }
                    outputStream.write(bArr, 0, read);
                }
            } catch (Throwable th) {
                th = th;
                gZIPInputStream = gZIPInputStream2;
                com.kwad.sdk.crash.utils.b.a(gZIPInputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static byte[] b(byte[] bArr) {
        ByteArrayInputStream byteArrayInputStream;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    b(byteArrayInputStream, byteArrayOutputStream);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.flush();
                    com.kwad.sdk.crash.utils.b.a(byteArrayOutputStream);
                    com.kwad.sdk.crash.utils.b.a(byteArrayInputStream);
                    return byteArray;
                } catch (Throwable th2) {
                    th = th2;
                    com.kwad.sdk.crash.utils.b.a(byteArrayOutputStream);
                    com.kwad.sdk.crash.utils.b.a(byteArrayInputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                byteArrayOutputStream = null;
            }
        } catch (Throwable th4) {
            byteArrayInputStream = null;
            th = th4;
            byteArrayOutputStream = null;
        }
    }
}
