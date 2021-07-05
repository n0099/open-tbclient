package e.a.q;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes10.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1589446842, "Le/a/q/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1589446842, "Le/a/q/c;");
        }
    }

    public static synchronized String a(byte[] bArr) {
        InterceptResult invokeL;
        String sb;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bArr)) == null) {
            synchronized (c.class) {
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                    messageDigest.update(bArr);
                    byte[] digest = messageDigest.digest();
                    StringBuilder sb2 = new StringBuilder();
                    for (byte b2 : digest) {
                        sb2.append(Integer.toHexString((b2 & 255) | (-256)).substring(6));
                    }
                    sb = sb2.toString();
                } catch (NoSuchAlgorithmException e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
            return sb;
        }
        return (String) invokeL.objValue;
    }

    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (str != null) {
                try {
                    return a(str.getBytes("GBK"));
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }
}
