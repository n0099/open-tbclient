package com.vivo.push.e;

import android.content.Context;
import android.os.Build;
import android.security.KeyPairGeneratorSpec;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.util.u;
import java.math.BigInteger;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.UnrecoverableEntryException;
import java.util.Calendar;
import javax.security.auth.x500.X500Principal;
import org.chromium.net.AndroidKeyStore;
/* loaded from: classes10.dex */
public final class c implements a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PrivateKey a;
    public PublicKey b;
    public KeyStore c;
    public X500Principal d;
    public Context e;

    public c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = null;
        this.e = context;
        a(context);
    }

    private synchronized void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, context) == null) {
            synchronized (this) {
                try {
                    b();
                    if (!b("PushRsaKeyAlias")) {
                        b(context);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    u.a("RsaSecurity", "init error" + e.getMessage());
                }
            }
        }
    }

    private boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                if (this.c == null) {
                    b();
                }
                return this.c.containsAlias(str);
            } catch (Exception e) {
                e.printStackTrace();
                u.a("RsaSecurity", "getPrivateKeySigin error" + e.getMessage());
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            try {
                KeyStore keyStore = KeyStore.getInstance(AndroidKeyStore.TAG);
                this.c = keyStore;
                keyStore.load(null);
                this.d = new X500Principal("CN=Push SDK, OU=VIVO, O=VIVO PUSH, C=CN");
            } catch (Exception e) {
                e.printStackTrace();
                u.a("RsaSecurity", "initKeyStore error" + e.getMessage());
            }
        }
    }

    private void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, context) == null) {
            try {
                if (context == null) {
                    u.d("RsaSecurity", " generateRSAKeyPairSign context == null ");
                    return;
                }
                Calendar calendar = Calendar.getInstance();
                Calendar calendar2 = Calendar.getInstance();
                calendar2.add(1, 999);
                if (Build.VERSION.SDK_INT >= 18) {
                    KeyPairGeneratorSpec build = new KeyPairGeneratorSpec.Builder(context.getApplicationContext()).setAlias("PushRsaKeyAlias").setSubject(this.d).setSerialNumber(BigInteger.valueOf(1337L)).setStartDate(calendar.getTime()).setEndDate(calendar2.getTime()).build();
                    KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA", AndroidKeyStore.TAG);
                    keyPairGenerator.initialize(build);
                    keyPairGenerator.generateKeyPair();
                }
            } catch (Exception e) {
                e.printStackTrace();
                u.a("RsaSecurity", "generateRSAKeyPairSign error" + e.getMessage());
            }
        }
    }

    @Override // com.vivo.push.e.a
    public final String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            try {
                if (!TextUtils.isEmpty(str) && c(this.e) != null) {
                    byte[] bytes = str.getBytes("UTF-8");
                    PrivateKey c = c(this.e);
                    Signature signature = Signature.getInstance("SHA256withRSA");
                    signature.initSign(c);
                    signature.update(bytes);
                    String encodeToString = Base64.encodeToString(signature.sign(), 2);
                    u.d("RsaSecurity", str.hashCode() + " = " + encodeToString);
                    return encodeToString;
                }
                return null;
            } catch (Exception e) {
                e.printStackTrace();
                u.a("RsaSecurity", "signClientSDK error" + e.getMessage());
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    private PrivateKey c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, context)) == null) {
            try {
            } catch (Exception e) {
                e.printStackTrace();
                u.a("RsaSecurity", "getPrivateKeySigin error" + e.getMessage());
            }
            if (this.a != null) {
                return this.a;
            }
            if (context == null) {
                u.d("RsaSecurity", " getPrivateKeySigin context == null ");
                return null;
            }
            KeyStore.Entry d = d(context);
            if (d instanceof KeyStore.PrivateKeyEntry) {
                PrivateKey privateKey = ((KeyStore.PrivateKeyEntry) d).getPrivateKey();
                this.a = privateKey;
                return privateKey;
            }
            return null;
        }
        return (PrivateKey) invokeL.objValue;
    }

    private KeyStore.Entry d(Context context) throws UnrecoverableEntryException, NoSuchAlgorithmException, KeyStoreException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, context)) == null) {
            try {
                if (context == null) {
                    u.d("RsaSecurity", " getPrivateKeySigin context == null ");
                    return null;
                }
                if (!b("PushRsaKeyAlias")) {
                    b(context);
                }
                return this.c.getEntry("PushRsaKeyAlias", null);
            } catch (Exception e) {
                b(context);
                KeyStore.Entry entry = this.c.getEntry("PushRsaKeyAlias", null);
                e.printStackTrace();
                u.a("RsaSecurity", "getPrivateKeySigin error" + e.getMessage());
                return entry;
            }
        }
        return (KeyStore.Entry) invokeL.objValue;
    }

    @Override // com.vivo.push.e.a
    public final PublicKey a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            try {
                if (this.b != null) {
                    return this.b;
                }
                KeyStore.Entry d = d(this.e);
                if (d instanceof KeyStore.PrivateKeyEntry) {
                    PublicKey publicKey = ((KeyStore.PrivateKeyEntry) d).getCertificate().getPublicKey();
                    this.b = publicKey;
                    return publicKey;
                }
                return null;
            } catch (Exception e) {
                e.printStackTrace();
                u.a("RsaSecurity", "getPublicKeySign error" + e.getMessage());
                return null;
            }
        }
        return (PublicKey) invokeV.objValue;
    }

    @Override // com.vivo.push.e.a
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
                u.a("RsaSecurity", "verifyClientSDK error" + e.getMessage());
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }
}
