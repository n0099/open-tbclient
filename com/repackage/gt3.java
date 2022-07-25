package com.repackage;

import android.annotation.SuppressLint;
import android.view.View;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class gt3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(View view2, oq2 oq2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, view2, oq2Var)) == null) {
            zh1 W = vl2.U().W();
            return W != null && W.c(view2, oq2Var);
        }
        return invokeLL.booleanValue;
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            zh1 W = vl2.U().W();
            return (W == null || !W.b() || W.h()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public static boolean c(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, view2)) == null) {
            zh1 W = vl2.U().W();
            return W != null && W.d(view2);
        }
        return invokeL.booleanValue;
    }

    @SuppressLint({"SourceLockedOrientationActivity"})
    public static boolean d(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, view2)) == null) {
            zh1 W = vl2.U().W();
            if (W == null) {
                return false;
            }
            if (W.h()) {
                SwanAppActivity activity = vl2.U().getActivity();
                if (activity != null) {
                    activity.setRequestedOrientation(0);
                }
                W.g(false);
            }
            return W.removeView(view2);
        }
        return invokeL.booleanValue;
    }
}
