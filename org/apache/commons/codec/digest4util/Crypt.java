package org.apache.commons.codec.digest4util;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.commons.base.Charsets;
/* loaded from: classes10.dex */
public class Crypt {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public Crypt() {
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

    public static String crypt(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bArr)) == null) ? crypt(bArr, (String) null) : (String) invokeL.objValue;
    }

    public static String crypt(byte[] bArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65540, null, bArr, str)) == null) {
            if (str == null) {
                return Sha2Crypt.sha512Crypt(bArr);
            }
            if (str.startsWith(Sha2Crypt.SHA512_PREFIX)) {
                return Sha2Crypt.sha512Crypt(bArr, str);
            }
            if (str.startsWith(Sha2Crypt.SHA256_PREFIX)) {
                return Sha2Crypt.sha256Crypt(bArr, str);
            }
            if (str.startsWith(Md5Crypt.MD5_PREFIX)) {
                return Md5Crypt.md5Crypt(bArr, str);
            }
            return UnixCrypt.crypt(bArr, str);
        }
        return (String) invokeLL.objValue;
    }

    public static String crypt(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? crypt(str, (String) null) : (String) invokeL.objValue;
    }

    public static String crypt(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) ? crypt(str.getBytes(Charsets.UTF_8), str2) : (String) invokeLL.objValue;
    }
}
