package com.vivo.push.c;

import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.util.p;
import java.security.KeyStore;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
/* loaded from: classes8.dex */
public final class a implements c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public KeyStore a;
    public SecretKey b;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a();
        b();
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            try {
                KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
                this.a = keyStore;
                keyStore.load(null);
            } catch (Exception e) {
                e.printStackTrace();
                p.a("AesSecurity", "initKeyStore error" + e.getMessage());
            }
        }
    }

    private SecretKey b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            try {
                if (this.b != null) {
                    return this.b;
                }
                if (!c()) {
                    KeyGenerator keyGenerator = KeyGenerator.getInstance("AES", "AndroidKeyStore");
                    if (Build.VERSION.SDK_INT >= 23) {
                        keyGenerator.init(new KeyGenParameterSpec.Builder("AesKeyAlias", 3).setBlockModes("GCM").setEncryptionPaddings("NoPadding").setKeySize(256).build());
                    }
                    this.b = keyGenerator.generateKey();
                } else {
                    this.b = d();
                }
                return this.b;
            } catch (Exception e) {
                e.printStackTrace();
                p.a("AesSecurity", "getSecretKey error" + e.getMessage());
                return null;
            }
        }
        return (SecretKey) invokeV.objValue;
    }

    private boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            try {
                if (this.a == null) {
                    a();
                }
                return this.a.containsAlias("AesKeyAlias");
            } catch (Exception e) {
                e.printStackTrace();
                p.a("AesSecurity", "hasAESKey error" + e.getMessage());
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    private SecretKey d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            try {
                return ((KeyStore.SecretKeyEntry) this.a.getEntry("AesKeyAlias", null)).getSecretKey();
            } catch (Exception e) {
                e.printStackTrace();
                p.a("AesSecurity", "getAESSecretKey error" + e.getMessage());
                return null;
            }
        }
        return (SecretKey) invokeV.objValue;
    }
}
