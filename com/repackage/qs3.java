package com.repackage;

import android.annotation.SuppressLint;
import android.view.View;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class qs3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(View view2, yp2 yp2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, view2, yp2Var)) == null) {
            jh1 W = fl2.U().W();
            return W != null && W.c(view2, yp2Var);
        }
        return invokeLL.booleanValue;
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            jh1 W = fl2.U().W();
            return (W == null || !W.b() || W.h()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public static boolean c(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, view2)) == null) {
            jh1 W = fl2.U().W();
            return W != null && W.d(view2);
        }
        return invokeL.booleanValue;
    }

    @SuppressLint({"SourceLockedOrientationActivity"})
    public static boolean d(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, view2)) == null) {
            jh1 W = fl2.U().W();
            if (W == null) {
                return false;
            }
            if (W.h()) {
                SwanAppActivity activity = fl2.U().getActivity();
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
