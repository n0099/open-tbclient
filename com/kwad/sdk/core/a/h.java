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
/* loaded from: classes4.dex */
public class h {
    public static int a(KeyFactory keyFactory, Key key) {
        try {
            return (((RSAPublicKeySpec) keyFactory.getKeySpec(key, RSAPublicKeySpec.class)).getModulus().bitLength() / 8) - 11;
        } catch (Exception unused) {
            return 117;
        }
    }

    public static byte[] a(byte[] bArr, String str) {
        return a(bArr, str, "RSA/ECB/PKCS1Padding");
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x005d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] a(byte[] bArr, String str, String str2) {
        ByteArrayOutputStream byteArrayOutputStream;
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(c.b().a(str));
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey generatePublic = keyFactory.generatePublic(x509EncodedKeySpec);
        Cipher cipher = Cipher.getInstance(str2);
        cipher.init(1, generatePublic);
        int a = a(keyFactory, generatePublic);
        byte[] bArr2 = null;
        bArr2 = null;
        bArr2 = null;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    try {
                        int length = bArr.length;
                        for (int i2 = 0; i2 < bArr.length; i2 += a) {
                            int i3 = length - i2;
                            if (i3 >= a) {
                                i3 = a;
                            }
                            byteArrayOutputStream.write(cipher.doFinal(bArr, i2, i3));
                        }
                        bArr2 = byteArrayOutputStream.toByteArray();
                        byteArrayOutputStream.close();
                    } catch (Exception e2) {
                        e = e2;
                        com.kwad.sdk.core.d.a.a(e);
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        return bArr2;
                    }
                } catch (Throwable th) {
                    th = th;
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    if (byteArrayOutputStream2 != null) {
                        try {
                            byteArrayOutputStream2.close();
                        } catch (Exception e3) {
                            com.kwad.sdk.core.d.a.a(e3);
                        }
                    }
                    throw th;
                }
            } catch (Exception e4) {
                com.kwad.sdk.core.d.a.a(e4);
            }
        } catch (Exception e5) {
            e = e5;
            byteArrayOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            if (byteArrayOutputStream2 != null) {
            }
            throw th;
        }
        return bArr2;
    }

    public static int b(KeyFactory keyFactory, Key key) {
        try {
            return ((RSAPrivateKeySpec) keyFactory.getKeySpec(key, RSAPrivateKeySpec.class)).getModulus().bitLength() / 8;
        } catch (Exception unused) {
            return 128;
        }
    }

    public static String b(byte[] bArr, String str) {
        return new String(b(bArr, str, "RSA/ECB/PKCS1Padding"), "UTF-8");
    }

    public static byte[] b(byte[] bArr, String str, String str2) {
        ByteArrayOutputStream byteArrayOutputStream;
        PKCS8EncodedKeySpec pKCS8EncodedKeySpec = new PKCS8EncodedKeySpec(c.b().a(str));
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey generatePrivate = keyFactory.generatePrivate(pKCS8EncodedKeySpec);
        Cipher cipher = Cipher.getInstance(str2);
        cipher.init(2, generatePrivate);
        int b2 = b(keyFactory, generatePrivate);
        byte[] bArr2 = null;
        bArr2 = null;
        bArr2 = null;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.a(e2);
            }
            try {
                int length = bArr.length;
                for (int i2 = 0; i2 < length; i2 += b2) {
                    int i3 = length - i2;
                    if (i3 >= b2) {
                        i3 = b2;
                    }
                    byteArrayOutputStream.write(cipher.doFinal(bArr, i2, i3));
                }
                bArr2 = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
            } catch (Exception unused) {
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                return bArr2;
            } catch (Throwable th) {
                th = th;
                byteArrayOutputStream2 = byteArrayOutputStream;
                if (byteArrayOutputStream2 != null) {
                    try {
                        byteArrayOutputStream2.close();
                    } catch (Exception e3) {
                        com.kwad.sdk.core.d.a.a(e3);
                    }
                }
                throw th;
            }
        } catch (Exception unused2) {
            byteArrayOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
        return bArr2;
    }
}
