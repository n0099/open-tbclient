package d.l.a.e.a.h;

import android.text.TextUtils;
import android.util.Base64;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return new String(Base64.decode(d.l.a.e.b.l.f.j(str), 0));
        }
        return (String) invokeL.objValue;
    }

    public static String b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return null;
            }
            byte[] decode = Base64.decode(d.l.a.e.b.l.f.j(str), 0);
            int length = str2.length();
            StringBuilder sb = new StringBuilder();
            int i2 = 0;
            for (byte b2 : decode) {
                if (i2 >= length) {
                    i2 %= length;
                }
                sb.append((char) (b2 ^ str2.charAt(i2)));
                i2++;
            }
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }
}
