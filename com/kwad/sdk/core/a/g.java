package com.kwad.sdk.core.a;

import java.io.ByteArrayOutputStream;
import java.security.Key;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
/* loaded from: classes9.dex */
public final class g {
    public static int a(KeyFactory keyFactory, Key key) {
        try {
            return (((RSAPublicKeySpec) keyFactory.getKeySpec(key, RSAPublicKeySpec.class)).getModulus().bitLength() / 8) - 11;
        } catch (Exception unused) {
            return 117;
        }
    }

    public static byte[] a(byte[] bArr, String str, String str2) {
        ByteArrayOutputStream byteArrayOutputStream;
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(c.th().decode(str));
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey generatePublic = keyFactory.generatePublic(x509EncodedKeySpec);
        Cipher cipher = Cipher.getInstance(str2);
        cipher.init(1, generatePublic);
        int a = a(keyFactory, generatePublic);
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        byte[] bArr2 = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                try {
                    int length = bArr.length;
                    for (int i = 0; i < bArr.length; i += a) {
                        int i2 = length - i;
                        if (i2 >= a) {
                            i2 = a;
                        }
                        byteArrayOutputStream.write(cipher.doFinal(bArr, i, i2));
                    }
                    bArr2 = byteArrayOutputStream.toByteArray();
                } catch (Exception e) {
                    e = e;
                    com.kwad.sdk.core.e.b.printStackTrace(e);
                    com.kwad.sdk.crash.utils.b.closeQuietly(byteArrayOutputStream);
                    return bArr2;
                }
            } catch (Throwable th) {
                th = th;
                byteArrayOutputStream2 = byteArrayOutputStream;
                com.kwad.sdk.crash.utils.b.closeQuietly(byteArrayOutputStream2);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            byteArrayOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            com.kwad.sdk.crash.utils.b.closeQuietly(byteArrayOutputStream2);
            throw th;
        }
        com.kwad.sdk.crash.utils.b.closeQuietly(byteArrayOutputStream);
        return bArr2;
    }

    public static int b(KeyFactory keyFactory, Key key) {
        try {
            return ((RSAPrivateKeySpec) keyFactory.getKeySpec(key, RSAPrivateKeySpec.class)).getModulus().bitLength() / 8;
        } catch (Exception unused) {
            return 128;
        }
    }

    public static byte[] b(byte[] bArr, String str, String str2) {
        ByteArrayOutputStream byteArrayOutputStream;
        PKCS8EncodedKeySpec pKCS8EncodedKeySpec = new PKCS8EncodedKeySpec(c.th().decode(str));
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey generatePrivate = keyFactory.generatePrivate(pKCS8EncodedKeySpec);
        Cipher cipher = Cipher.getInstance(str2);
        cipher.init(2, generatePrivate);
        int b = b(keyFactory, generatePrivate);
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        r0 = null;
        byte[] bArr2 = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                int length = bArr.length;
                for (int i = 0; i < length; i += b) {
                    int i2 = length - i;
                    if (i2 >= b) {
                        i2 = b;
                    }
                    byteArrayOutputStream.write(cipher.doFinal(bArr, i, i2));
                }
                bArr2 = byteArrayOutputStream.toByteArray();
            } catch (Exception unused) {
            } catch (Throwable th) {
                th = th;
                byteArrayOutputStream2 = byteArrayOutputStream;
                com.kwad.sdk.crash.utils.b.closeQuietly(byteArrayOutputStream2);
                throw th;
            }
        } catch (Exception unused2) {
            byteArrayOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
        com.kwad.sdk.crash.utils.b.closeQuietly(byteArrayOutputStream);
        return bArr2;
    }

    public static byte[] d(byte[] bArr, String str) {
        return a(bArr, str, "RSA/ECB/PKCS1Padding");
    }

    public static String e(byte[] bArr, String str) {
        return new String(b(bArr, str, "RSA/ECB/PKCS1Padding"), "UTF-8");
    }
}
