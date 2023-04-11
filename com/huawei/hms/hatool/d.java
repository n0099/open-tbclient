package com.huawei.hms.hatool;

import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.owa;
import com.baidu.tieba.uwa;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.nio.charset.Charset;
/* loaded from: classes8.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public static final Charset a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(366338630, "Lcom/huawei/hms/hatool/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(366338630, "Lcom/huawei/hms/hatool/d;");
                return;
            }
        }
        a = Charset.forName("UTF-8");
    }

    public static Pair<byte[], String> a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (str == null || str.length() < 32) {
                return new Pair<>(new byte[0], str);
            }
            return new Pair<>(uwa.b(str.substring(0, 32)), str.substring(32));
        }
        return (Pair) invokeL.objValue;
    }

    public static String a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            Pair<byte[], String> a2 = a(str);
            return new String(owa.i(uwa.b((String) a2.second), uwa.b(str2), (byte[]) a2.first), a);
        }
        return (String) invokeLL.objValue;
    }

    public static String a(byte[] bArr, String str) {
        InterceptResult invokeLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, bArr, str)) == null) {
            if (bArr == null || bArr.length == 0 || str == null) {
                str2 = "cbc encrypt(byte) param is not right";
            } else {
                byte[] b = uwa.b(str);
                if (b.length >= 16) {
                    return uwa.a(owa.l(bArr, b));
                }
                str2 = "key length is not right";
            }
            y.b("AesCipher", str2);
            return "";
        }
        return (String) invokeLL.objValue;
    }

    public static String b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2)) == null) ? uwa.a(owa.l(str.getBytes(a), uwa.b(str2))) : (String) invokeLL.objValue;
    }
}
