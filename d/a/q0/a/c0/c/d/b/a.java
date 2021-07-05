package d.a.q0.a.c0.c.d.b;

import androidx.annotation.Nullable;
import com.baidu.swan.apps.canvas.view.CanvasView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.q0.a.e0.d;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Nullable
    public static CanvasView a(d.a.q0.a.a0.b.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, aVar)) == null) {
            d.a.q0.a.c0.c.d.a aVar2 = (d.a.q0.a.c0.c.d.a) d.a.q0.a.c0.d.a.a(aVar);
            if (aVar2 == null) {
                d.b("Component-Canvas-Utils", "get canvas view fail: find a null component");
                return null;
            }
            return aVar2.f46790i;
        }
        return (CanvasView) invokeL.objValue;
    }
}
