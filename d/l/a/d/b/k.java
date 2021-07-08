package d.l.a.d.b;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.l.a.a.a.f.e;
import d.l.a.e.b.j.a;
/* loaded from: classes8.dex */
public class k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65536, null, i2, i3)) == null) ? (i3 <= 0 || i3 >= 100 || !d(i2)) ? i3 : (int) (Math.sqrt(i3) * 10.0d) : invokeII.intValue;
    }

    public static long b(int i2, long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2)})) == null) {
            if (d(i2)) {
                if (j <= 0) {
                    return 0L;
                }
                return j2 <= 0 ? j : (j2 * a(i2, (int) ((j * 100) / j2))) / 100;
            }
            return j;
        }
        return invokeCommon.longValue;
    }

    public static e c(e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, eVar)) == null) {
            if (eVar != null && d((int) eVar.f71134a)) {
                eVar.f71137d = b((int) eVar.f71134a, eVar.f71137d, eVar.f71136c);
            }
            return eVar;
        }
        return (e) invokeL.objValue;
    }

    public static boolean d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) ? a.d(i2).b("pause_optimise_pretend_download_percent_switch", 0) == 1 && a.d(i2).b("pause_optimise_switch", 0) == 1 : invokeI.booleanValue;
    }
}
