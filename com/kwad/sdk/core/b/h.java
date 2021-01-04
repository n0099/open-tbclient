package com.kwad.sdk.core.b;

import com.baidu.android.common.security.RSAUtil;
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
/* loaded from: classes5.dex */
public class h {
    private static int a(KeyFactory keyFactory, Key key) {
        try {
            return (((RSAPublicKeySpec) keyFactory.getKeySpec(key, RSAPublicKeySpec.class)).getModulus().bitLength() / 8) - 11;
        } catch (Exception e) {
            return 117;
        }
    }

    public static byte[] a(byte[] bArr, String str) {
        return a(bArr, str, "RSA/ECB/PKCS1Padding");
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0066 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] a(byte[] bArr, String str, String str2) {
        ByteArrayOutputStream byteArrayOutputStream;
        byte[] bArr2 = null;
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(c.b().a(str));
        KeyFactory keyFactory = KeyFactory.getInstance(RSAUtil.ALGORITHM_RSA);
        PublicKey generatePublic = keyFactory.generatePublic(x509EncodedKeySpec);
        Cipher cipher = Cipher.getInstance(str2);
        cipher.init(1, generatePublic);
        int a2 = a(keyFactory, generatePublic);
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                try {
                    int length = bArr.length;
                    for (int i = 0; i < bArr.length; i += a2) {
                        byteArrayOutputStream.write(cipher.doFinal(bArr, i, length - i < a2 ? length - i : a2));
                    }
                    bArr2 = byteArrayOutputStream.toByteArray();
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Exception e) {
                            com.kwad.sdk.core.d.a.a(e);
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    com.kwad.sdk.core.d.a.a(e);
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Exception e3) {
                            com.kwad.sdk.core.d.a.a(e3);
                        }
                    }
                    return bArr2;
                }
            } catch (Throwable th) {
                th = th;
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Exception e4) {
                        com.kwad.sdk.core.d.a.a(e4);
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
            byteArrayOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            byteArrayOutputStream = null;
            if (byteArrayOutputStream != null) {
            }
            throw th;
        }
        return bArr2;
    }

    private static int b(KeyFactory keyFactory, Key key) {
        try {
            return ((RSAPrivateKeySpec) keyFactory.getKeySpec(key, RSAPrivateKeySpec.class)).getModulus().bitLength() / 8;
        } catch (Exception e) {
            return 128;
        }
    }

    public static String b(byte[] bArr, String str) {
        return new String(b(bArr, str, "RSA/ECB/PKCS1Padding"), "UTF-8");
    }

    public static byte[] b(byte[] bArr, String str, String str2) {
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        byte[] bArr2 = null;
        PKCS8EncodedKeySpec pKCS8EncodedKeySpec = new PKCS8EncodedKeySpec(c.b().a(str));
        KeyFactory keyFactory = KeyFactory.getInstance(RSAUtil.ALGORITHM_RSA);
        PrivateKey generatePrivate = keyFactory.generatePrivate(pKCS8EncodedKeySpec);
        Cipher cipher = Cipher.getInstance(str2);
        cipher.init(2, generatePrivate);
        int b2 = b(keyFactory, generatePrivate);
        try {
            byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                int length = bArr.length;
                for (int i = 0; i < length; i += b2) {
                    byteArrayOutputStream2.write(cipher.doFinal(bArr, i, length - i < b2 ? length - i : b2));
                }
                bArr2 = byteArrayOutputStream2.toByteArray();
                if (byteArrayOutputStream2 != null) {
                    try {
                        byteArrayOutputStream2.close();
                    } catch (Exception e) {
                        com.kwad.sdk.core.d.a.a(e);
                    }
                }
            } catch (Exception e2) {
                if (byteArrayOutputStream2 != null) {
                    try {
                        byteArrayOutputStream2.close();
                    } catch (Exception e3) {
                        com.kwad.sdk.core.d.a.a(e3);
                    }
                }
                return bArr2;
            } catch (Throwable th2) {
                th = th2;
                byteArrayOutputStream = byteArrayOutputStream2;
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Exception e4) {
                        com.kwad.sdk.core.d.a.a(e4);
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
            byteArrayOutputStream2 = null;
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream = null;
        }
        return bArr2;
    }
}
