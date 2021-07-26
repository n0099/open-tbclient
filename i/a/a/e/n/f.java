package i.a.a.e.n;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import java.text.DecimalFormat;
/* loaded from: classes9.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{Double.valueOf(d2)})) == null) {
            long j = (long) d2;
            if (d2 == ((double) j)) {
                return String.valueOf(j);
            }
            return new DecimalFormat("#.##").format(d2);
        }
        return (String) invokeCommon.objValue;
    }

    public static double b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (str == null || str.length() == 0) {
                return 0.0d;
            }
            try {
                return Double.valueOf(str).doubleValue();
            } catch (Throwable unused) {
                RLog.error("StringUtils", "safeParseDouble " + str, new Object[0]);
                return 0.0d;
            }
        }
        return invokeL.doubleValue;
    }
}
