package com.cmic.sso.sdk.d;

import android.content.Context;
import android.os.Build;
import android.security.KeyPairGeneratorSpec;
import android.security.keystore.KeyGenParameterSpec;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.math.BigInteger;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.util.Calendar;
import javax.crypto.Cipher;
import javax.security.auth.x500.X500Principal;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(Context context, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65539, null, context, z)) == null) {
            try {
                KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
                keyStore.load(null);
                if (keyStore.getCertificate("CMCC_SDK") != null) {
                    return true;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (z) {
                return a(context);
            }
            return false;
        }
        return invokeLZ.booleanValue;
    }

    public static synchronized byte[] b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            synchronized (b.class) {
                byte[] bArr = null;
                try {
                    KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
                    keyStore.load(null);
                    if (TextUtils.isEmpty(b())) {
                        if (!a(context, false)) {
                            return null;
                        }
                        byte[] a = a();
                        PublicKey publicKey = keyStore.getCertificate("CMCC_SDK").getPublicKey();
                        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                        cipher.init(1, publicKey);
                        a(Base64.encodeToString(cipher.doFinal(a), 0));
                        bArr = a;
                    } else {
                        String b2 = b();
                        if (!TextUtils.isEmpty(b2)) {
                            byte[] decode = Base64.decode(b2, 0);
                            PrivateKey privateKey = (PrivateKey) keyStore.getKey("CMCC_SDK", null);
                            if (privateKey == null) {
                                return null;
                            }
                            Cipher cipher2 = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                            cipher2.init(2, privateKey);
                            bArr = cipher2.doFinal(decode);
                        }
                    }
                    return bArr;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
        }
        return (byte[]) invokeL.objValue;
    }

    public static boolean a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (Build.VERSION.SDK_INT >= 23) {
                try {
                    KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
                    keyPairGenerator.initialize(new KeyGenParameterSpec.Builder("CMCC_SDK", 3).setDigests("SHA-256", "SHA-512").setEncryptionPaddings("PKCS1Padding").setKeySize(2048).build());
                    Thread.sleep(1000L);
                    keyPairGenerator.generateKeyPair();
                    return true;
                } catch (Exception e2) {
                    c.a("KeystoreUtil", e2.getMessage());
                    return false;
                }
            }
            Calendar calendar = Calendar.getInstance();
            Calendar calendar2 = Calendar.getInstance();
            calendar2.add(1, 30);
            try {
                if (Build.VERSION.SDK_INT >= 18) {
                    KeyPairGeneratorSpec build = new KeyPairGeneratorSpec.Builder(context).setAlias("CMCC_SDK").setSubject(new X500Principal("CN=CMCC_SDK")).setSerialNumber(BigInteger.TEN).setStartDate(calendar.getTime()).setEndDate(calendar2.getTime()).build();
                    KeyPairGenerator keyPairGenerator2 = KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
                    keyPairGenerator2.initialize(build);
                    Thread.sleep(1000L);
                    keyPairGenerator2.generateKeyPair();
                    return true;
                }
                return false;
            } catch (Exception e3) {
                c.a("KeystoreUtil", e3.getMessage());
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static String b(Context context, String str) {
        InterceptResult invokeLL;
        byte[] b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, context, str)) == null) {
            if (TextUtils.isEmpty(str) || (b2 = b(context)) == null) {
                return null;
            }
            return a.b(b2, str);
        }
        return (String) invokeLL.objValue;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? k.b("AES_KEY", "") : (String) invokeV.objValue;
    }

    public static byte[] a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            byte[] bArr = new byte[16];
            new SecureRandom().nextBytes(bArr);
            return bArr;
        }
        return (byte[]) invokeV.objValue;
    }

    public static String a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, context, str)) == null) {
            byte[] b2 = b(context);
            if (b2 != null) {
                return a.a(b2, str);
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            k.a("AES_KEY", str);
        }
    }
}
