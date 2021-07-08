package ms.bd.c;

import androidx.annotation.Keep;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bytedance.JProtect;
import kotlin.text.Typography;
@Keep
@JProtect
/* loaded from: classes9.dex */
public class a2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1737188654, "Lms/bd/c/a2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1737188654, "Lms/bd/c/a2;");
                return;
            }
        }
        String str = (String) h.a(16777217, 0, 0L, "c9efca", new byte[]{73, 103, 87, 76, 97});
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? (str == null || str.length() <= 0) ? "" : str.trim().replace('\'', ' ').replace(Typography.quote, ' ').replace('\r', ' ').replace('\n', ' ') : (String) invokeL.objValue;
    }
}
