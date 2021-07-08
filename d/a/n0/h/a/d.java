package d.a.n0.h.a;

import android.annotation.SuppressLint;
import android.view.View;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.n0.a.g1.f;
import d.a.n0.a.p.b.a.n;
/* loaded from: classes7.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(View view, d.a.n0.a.l1.e.a.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, view, aVar)) == null) {
            n X = f.V().X();
            return X != null && X.c(view, aVar);
        }
        return invokeLL.booleanValue;
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            n X = f.V().X();
            return (X == null || !X.b() || X.h()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public static boolean c(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, view)) == null) {
            n X = f.V().X();
            return X != null && X.d(view);
        }
        return invokeL.booleanValue;
    }

    @SuppressLint({"SourceLockedOrientationActivity"})
    public static boolean d(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, view)) == null) {
            n X = f.V().X();
            if (X == null) {
                return false;
            }
            if (X.h()) {
                SwanAppActivity activity = f.V().getActivity();
                if (activity != null) {
                    activity.setRequestedOrientation(0);
                }
                X.g(false);
            }
            return X.removeView(view);
        }
        return invokeL.booleanValue;
    }
}
