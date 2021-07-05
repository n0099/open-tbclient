package d.a.q0.n.n;

import android.content.SharedPreferences;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.q0.n.o.g;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static long a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65536, null, i2)) == null) {
            SharedPreferences a2 = g.a();
            return a2.getLong("latest_update_time" + i2, 0L);
        }
        return invokeI.longValue;
    }

    public static long b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i2)) == null) {
            SharedPreferences a2 = g.a();
            return a2.getLong("max_age" + i2, 0L);
        }
        return invokeI.longValue;
    }

    public static boolean c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
            return (System.currentTimeMillis() - a(i2)) / 1000 > b(i2);
        }
        return invokeI.booleanValue;
    }

    public static void d(int i2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{Integer.valueOf(i2), Long.valueOf(j)}) == null) {
            SharedPreferences.Editor edit = g.a().edit();
            edit.putLong("latest_update_time" + i2, j).apply();
        }
    }

    public static void e(int i2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65540, null, new Object[]{Integer.valueOf(i2), Long.valueOf(j)}) == null) {
            if (j <= 0 || j >= 259200) {
                j = 0;
            }
            g.a().edit().putLong("max_age" + i2, j).apply();
        }
    }
}
