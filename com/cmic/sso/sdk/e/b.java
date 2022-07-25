package com.cmic.sso.sdk.e;

import android.content.Context;
import android.os.Build;
import android.security.KeyPairGeneratorSpec;
import android.security.keystore.KeyGenParameterSpec;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.security.RSAUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.math.BigInteger;
import java.security.Key;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Calendar;
import java.util.HashMap;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.security.auth.x500.X500Principal;
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public static byte[] a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1436790263, "Lcom/cmic/sso/sdk/e/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1436790263, "Lcom/cmic/sso/sdk/e/b;");
        }
    }

    public static boolean a(Context context, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, context, z)) == null) {
            try {
                KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
                keyStore.load(null);
                if (keyStore.getKey("CMCC_SDK_V1", null) != null) {
                    return true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (z) {
                return a(context);
            }
            return false;
        }
        return invokeLZ.booleanValue;
    }

    public static String b(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, context, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            byte[] b = b(context);
            if (b != null) {
                return a.b(b, str, a);
            }
            a();
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? k.b("AES_IV", "") : (String) invokeV.objValue;
    }

    public static synchronized byte[] b(Context context) {
        InterceptResult invokeL;
        Cipher cipher;
        byte[] doFinal;
        Cipher cipher2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            synchronized (b.class) {
                try {
                    KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
                    keyStore.load(null);
                    if (a(context, false)) {
                        String b = b();
                        if (TextUtils.isEmpty(b)) {
                            doFinal = q.a();
                            a = q.a();
                            Key key = keyStore.getKey("CMCC_SDK_V1", null);
                            if (key instanceof SecretKey) {
                                c.b("KeystoreUtil", "随机生成aes秘钥");
                                cipher2 = Cipher.getInstance(com.kuaishou.weapon.p0.b.c);
                                cipher2.init(1, key, new IvParameterSpec(a));
                            } else if (!(key instanceof PrivateKey)) {
                                return null;
                            } else {
                                PublicKey publicKey = keyStore.getCertificate("CMCC_SDK_V1").getPublicKey();
                                Cipher cipher3 = Cipher.getInstance("RSA/ECB/OAEPWithSHA256AndMGF1Padding");
                                c.b("KeystoreUtil", "生成rsa密");
                                cipher3.init(1, publicKey);
                                cipher2 = cipher3;
                            }
                            String encodeToString = Base64.encodeToString(cipher2.doFinal(doFinal), 0);
                            String encodeToString2 = Base64.encodeToString(a, 0);
                            HashMap hashMap = new HashMap();
                            hashMap.put("AES_IV", encodeToString2);
                            hashMap.put("AES_KEY", encodeToString);
                            k.a(hashMap);
                        } else {
                            a = Base64.decode(c(), 0);
                            byte[] decode = Base64.decode(b, 0);
                            Key key2 = keyStore.getKey("CMCC_SDK_V1", null);
                            if (key2 == null) {
                                return null;
                            }
                            if (key2 instanceof SecretKey) {
                                cipher = Cipher.getInstance(com.kuaishou.weapon.p0.b.c);
                                cipher.init(2, key2, new IvParameterSpec(a));
                                c.b("KeystoreUtil", "使用aes");
                            } else if (!(key2 instanceof PrivateKey)) {
                                return null;
                            } else {
                                cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA256AndMGF1Padding");
                                cipher.init(2, key2);
                                c.b("KeystoreUtil", "使用rsa");
                            }
                            doFinal = cipher.doFinal(decode);
                            StringBuilder sb = new StringBuilder();
                            sb.append("是否解密出秘钥：");
                            sb.append(!TextUtils.isEmpty(Base64.encodeToString(doFinal, 0)));
                            c.b("KeystoreUtil", sb.toString());
                        }
                        return doFinal;
                    }
                    return null;
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
        return (byte[]) invokeL.objValue;
    }

    public static boolean a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (Build.VERSION.SDK_INT >= 23) {
                try {
                    KeyGenerator keyGenerator = KeyGenerator.getInstance("AES", "AndroidKeyStore");
                    keyGenerator.init(new KeyGenParameterSpec.Builder("CMCC_SDK_V1", 3).setDigests("SHA-256", "SHA-512").setBlockModes("CBC").setEncryptionPaddings("PKCS7Padding").setRandomizedEncryptionRequired(false).setKeySize(256).build());
                    Thread.sleep(1000L);
                    keyGenerator.generateKey();
                    return true;
                } catch (Exception e) {
                    c.a("KeystoreUtil", e.getMessage());
                    return false;
                }
            }
            Calendar calendar = Calendar.getInstance();
            Calendar calendar2 = Calendar.getInstance();
            calendar2.add(1, 30);
            try {
                if (Build.VERSION.SDK_INT >= 18) {
                    KeyPairGeneratorSpec build = new KeyPairGeneratorSpec.Builder(context).setAlias("CMCC_SDK_V1").setSubject(new X500Principal("CN=CMCC_SDK_V1")).setSerialNumber(BigInteger.TEN).setStartDate(calendar.getTime()).setEndDate(calendar2.getTime()).build();
                    KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(RSAUtil.ALGORITHM_RSA, "AndroidKeyStore");
                    keyPairGenerator.initialize(build);
                    Thread.sleep(1000L);
                    keyPairGenerator.generateKeyPair();
                    return true;
                }
                return false;
            } catch (Exception e2) {
                c.a("KeystoreUtil", e2.getMessage());
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static String a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, str)) == null) {
            a();
            byte[] b = b(context);
            if (b != null) {
                return a.a(b, str, a);
            }
            a();
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            k.a("AES_KEY");
        }
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? k.b("AES_KEY", "") : (String) invokeV.objValue;
    }
}
