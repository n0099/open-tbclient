package com.kwad.sdk.core.imageloader.cache.disc.naming;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.imageloader.utils.L;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes10.dex */
public class Md5FileNameGenerator implements FileNameGenerator {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String HASH_ALGORITHM = "MD5";
    public static final int RADIX = 36;
    public transient /* synthetic */ FieldHolder $fh;

    public Md5FileNameGenerator() {
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

    private byte[] getMD5(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, bArr)) == null) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(bArr);
                return messageDigest.digest();
            } catch (NoSuchAlgorithmException e2) {
                L.e(e2);
                return null;
            }
        }
        return (byte[]) invokeL.objValue;
    }

    @Override // com.kwad.sdk.core.imageloader.cache.disc.naming.FileNameGenerator
    public String generate(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? new BigInteger(getMD5(str.getBytes())).abs().toString(36) : (String) invokeL.objValue;
    }
}
