package com.vivo.push.c;

import android.content.Context;
import android.os.Build;
import android.security.KeyPairGeneratorSpec;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.security.RSAUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.util.p;
import java.math.BigInteger;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.util.Calendar;
import javax.security.auth.x500.X500Principal;
/* loaded from: classes8.dex */
public final class e implements b {
    public static /* synthetic */ Interceptable $ic;
    public static PrivateKey a;
    public static PublicKey b;
    public static KeyStore c;
    public static X500Principal d;
    public transient /* synthetic */ FieldHolder $fh;
    public Context e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1259179374, "Lcom/vivo/push/c/e;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1259179374, "Lcom/vivo/push/c/e;");
        }
    }

    public e(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.e = context;
        try {
            b();
            a(context);
        } catch (Exception e) {
            e.printStackTrace();
            p.a("RsaSecurity", "init error" + e.getMessage());
        }
    }

    public static PrivateKey b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            try {
            } catch (Exception e) {
                e.printStackTrace();
                p.a("RsaSecurity", "getPrivateKeySigin error" + e.getMessage());
            }
            if (a != null) {
                return a;
            }
            if (context == null) {
                p.d("RsaSecurity", " getPrivateKeySigin context == null ");
                return null;
            }
            if (!b("PushRsaKeyAlias")) {
                a(context);
            }
            KeyStore.Entry entry = c.getEntry("PushRsaKeyAlias", null);
            if (entry instanceof KeyStore.PrivateKeyEntry) {
                PrivateKey privateKey = ((KeyStore.PrivateKeyEntry) entry).getPrivateKey();
                a = privateKey;
                return privateKey;
            }
            return null;
        }
        return (PrivateKey) invokeL.objValue;
    }

    public static void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, context) == null) {
            try {
                if (context == null) {
                    p.d("RsaSecurity", " generateRSAKeyPairSign context == null ");
                } else if (!b("PushRsaKeyAlias")) {
                    Calendar calendar = Calendar.getInstance();
                    Calendar calendar2 = Calendar.getInstance();
                    calendar2.add(1, 999);
                    if (Build.VERSION.SDK_INT >= 18) {
                        KeyPairGeneratorSpec build = new KeyPairGeneratorSpec.Builder(context.getApplicationContext()).setAlias("PushRsaKeyAlias").setSubject(d).setSerialNumber(BigInteger.valueOf(1337L)).setStartDate(calendar.getTime()).setEndDate(calendar2.getTime()).build();
                        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(RSAUtil.ALGORITHM_RSA, "AndroidKeyStore");
                        keyPairGenerator.initialize(build);
                        keyPairGenerator.generateKeyPair();
                    }
                } else {
                    p.d("RsaSecurity", " generateRSAKeyPairSign this keyAlias PushRsaKeyAlias is Created ");
                }
            } catch (Exception e) {
                e.printStackTrace();
                p.a("RsaSecurity", "generateRSAKeyPairSign error" + e.getMessage());
            }
        }
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            try {
                KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
                c = keyStore;
                keyStore.load(null);
                d = new X500Principal("CN=Push SDK, OU=VIVO, O=VIVO PUSH, C=CN");
            } catch (Exception e) {
                e.printStackTrace();
                p.a("RsaSecurity", "initKeyStore error" + e.getMessage());
            }
        }
    }

    public static boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                if (c == null) {
                    b();
                }
                return c.containsAlias(str);
            } catch (Exception e) {
                e.printStackTrace();
                p.a("RsaSecurity", "getPrivateKeySigin error" + e.getMessage());
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // com.vivo.push.c.b
    public final String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            try {
                if (!TextUtils.isEmpty(str) && b(this.e) != null) {
                    byte[] bytes = str.getBytes("UTF-8");
                    PrivateKey b2 = b(this.e);
                    Signature signature = Signature.getInstance("SHA256withRSA");
                    signature.initSign(b2);
                    signature.update(bytes);
                    String encodeToString = Base64.encodeToString(signature.sign(), 2);
                    p.d("RsaSecurity", str.hashCode() + " = " + encodeToString);
                    return encodeToString;
                }
                return null;
            } catch (Exception e) {
                e.printStackTrace();
                p.a("RsaSecurity", "signClientSDK error" + e.getMessage());
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    @Override // com.vivo.push.c.b
    public final PublicKey a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            try {
            } catch (Exception e) {
                e.printStackTrace();
                p.a("RsaSecurity", "getPublicKeySign error" + e.getMessage());
            }
            if (b != null) {
                return b;
            }
            if (!b("PushRsaKeyAlias")) {
                a(this.e);
            }
            KeyStore.Entry entry = c.getEntry("PushRsaKeyAlias", null);
            if (entry instanceof KeyStore.PrivateKeyEntry) {
                PublicKey publicKey = ((KeyStore.PrivateKeyEntry) entry).getCertificate().getPublicKey();
                b = publicKey;
                return publicKey;
            }
            return null;
        }
        return (PublicKey) invokeV.objValue;
    }

    @Override // com.vivo.push.c.b
    public final boolean a(byte[] bArr, PublicKey publicKey, byte[] bArr2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, bArr, publicKey, bArr2)) == null) {
            try {
                Signature signature = Signature.getInstance("SHA256withRSA");
                signature.initVerify(publicKey);
                signature.update(bArr);
                return signature.verify(bArr2);
            } catch (Exception e) {
                e.printStackTrace();
                p.a("RsaSecurity", "verifyClientSDK error" + e.getMessage());
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }
}
