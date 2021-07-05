package d.a.s0.v3;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes9.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            d.a.r0.r.d0.b.j().v("key_video_guide_count", d.a.r0.r.d0.b.j().k("key_video_guide_count", 0) + 1);
        }
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            d.a.r0.r.d0.b.j().v("key_no_behavior_count", d.a.r0.r.d0.b.j().k("key_no_behavior_count", 0) + 1);
        }
    }

    public static void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            d.a.r0.r.d0.b.j().v("key_no_behavior_count", 0);
        }
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? d.a.r0.r.d0.b.j().k("key_video_guide_count", 0) < d.a.r0.r.d0.b.j().k("key_video_guide_max_count", 0) && d.a.r0.r.d0.b.j().k("key_no_behavior_count", 0) >= 2 : invokeV.booleanValue;
    }
}
