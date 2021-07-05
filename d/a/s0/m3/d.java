package d.a.s0.m3;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.r0.z0.m0;
/* loaded from: classes9.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            try {
                Thread.setDefaultUncaughtExceptionHandler(new m0());
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }
}
