package com.kwad.sdk.core.b;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.yy.hiidostatis.inner.util.cipher.RsaCipher;
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
/* loaded from: classes6.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(KeyFactory keyFactory, Key key) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, keyFactory, key)) == null) {
            try {
                return (((RSAPublicKeySpec) keyFactory.getKeySpec(key, RSAPublicKeySpec.class)).getModulus().bitLength() / 8) - 11;
            } catch (Exception unused) {
                return 117;
            }
        }
        return invokeLL.intValue;
    }

    public static byte[] a(byte[] bArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, bArr, str)) == null) ? a(bArr, str, RsaCipher.RSA_PADDING) : (byte[]) invokeLL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x0061 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] a(byte[] bArr, String str, String str2) {
        InterceptResult invokeLLL;
        ByteArrayOutputStream byteArrayOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, bArr, str, str2)) == null) {
            X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(c.b().a(str));
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PublicKey generatePublic = keyFactory.generatePublic(x509EncodedKeySpec);
            Cipher cipher = Cipher.getInstance(str2);
            cipher.init(1, generatePublic);
            int a2 = a(keyFactory, generatePublic);
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
                            for (int i2 = 0; i2 < bArr.length; i2 += a2) {
                                int i3 = length - i2;
                                if (i3 >= a2) {
                                    i3 = a2;
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
        return (byte[]) invokeLLL.objValue;
    }

    public static int b(KeyFactory keyFactory, Key key) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, keyFactory, key)) == null) {
            try {
                return ((RSAPrivateKeySpec) keyFactory.getKeySpec(key, RSAPrivateKeySpec.class)).getModulus().bitLength() / 8;
            } catch (Exception unused) {
                return 128;
            }
        }
        return invokeLL.intValue;
    }

    public static String b(byte[] bArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, bArr, str)) == null) ? new String(b(bArr, str, RsaCipher.RSA_PADDING), "UTF-8") : (String) invokeLL.objValue;
    }

    public static byte[] b(byte[] bArr, String str, String str2) {
        InterceptResult invokeLLL;
        ByteArrayOutputStream byteArrayOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, null, bArr, str, str2)) == null) {
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
        return (byte[]) invokeLLL.objValue;
    }
}
