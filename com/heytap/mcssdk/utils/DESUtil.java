package com.heytap.mcssdk.utils;

import android.util.Base64;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.inner.util.cipher.Coder;
import java.nio.charset.Charset;
import java.security.Key;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
/* loaded from: classes3.dex */
public abstract class DESUtil {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public DESUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static String decrypt(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, str2)) == null) {
            Cipher cipher = Cipher.getInstance(Coder.KEY_DES);
            cipher.init(2, getDesKey(str2));
            return new String(cipher.doFinal(Base64.decode(str, 0)), Charset.defaultCharset()).trim();
        }
        return (String) invokeLL.objValue;
    }

    public static String encrypt(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            SecureRandom secureRandom = new SecureRandom();
            Cipher cipher = Cipher.getInstance(Coder.KEY_DES);
            cipher.init(1, getDesKey(str2), secureRandom);
            return new String(Base64.encode(cipher.doFinal(str.getBytes("UTF-8")), 0), Charset.defaultCharset()).trim();
        }
        return (String) invokeLL.objValue;
    }

    public static Key getDesKey(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? SecretKeyFactory.getInstance(Coder.KEY_DES).generateSecret(new DESKeySpec(Base64.decode(str, 0))) : (Key) invokeL.objValue;
    }
}
