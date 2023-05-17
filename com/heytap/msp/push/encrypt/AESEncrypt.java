package com.heytap.msp.push.encrypt;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.heytap.mcssdk.utils.d;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes9.dex */
public class AESEncrypt {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ALGORITHM = "AES";
    public static final String IV_CONNECT = "%IV1%";
    public static final int KEY_BYTE_SIZE = 256;
    public static final String SDK_APP_SECRET = "isvrbeT7qUywVEZ1Ia0/aUVA/TcFaeV0wC8qFLc8rg4=";
    public static final String TRANSFORMATION = "AES/CTR/NoPadding";
    public transient /* synthetic */ FieldHolder $fh;

    public AESEncrypt() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static String decrypt(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, str2)) == null) {
            String[] split = str2.split(IV_CONNECT);
            byte[] b = a.b(split[0]);
            byte[] b2 = a.b(split[1]);
            SecretKeySpec secretKeySpec = new SecretKeySpec(a.b(str), "AES");
            Cipher cipher = Cipher.getInstance("AES/CTR/NoPadding");
            cipher.init(2, secretKeySpec, new IvParameterSpec(b2));
            return new String(cipher.doFinal(b));
        }
        return (String) invokeLL.objValue;
    }

    public static String encrypt(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            try {
                return encrypt(SDK_APP_SECRET, str);
            } catch (Exception e) {
                d.b(e.getLocalizedMessage());
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String encrypt(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, str2)) == null) {
            SecretKeySpec secretKeySpec = new SecretKeySpec(a.b(str), "AES");
            Cipher cipher = Cipher.getInstance("AES/CTR/NoPadding");
            cipher.init(1, secretKeySpec);
            String d = a.d(cipher.getIV());
            String d2 = a.d(cipher.doFinal(str2.getBytes()));
            return d2 + IV_CONNECT + d;
        }
        return (String) invokeLL.objValue;
    }

    public static String genKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(256);
            return a.d(keyGenerator.generateKey().getEncoded());
        }
        return (String) invokeV.objValue;
    }
}
