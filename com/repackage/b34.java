package com.repackage;

import android.content.Context;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class b34 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(View view2, oq2 oq2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, view2, oq2Var)) == null) {
            zh1 X = vl2.U().X();
            return X != null && X.c(view2, oq2Var);
        }
        return invokeLL.booleanValue;
    }

    public static Context b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            zh1 X = vl2.U().X();
            if (X != null) {
                return X.getContext();
            }
            return null;
        }
        return (Context) invokeV.objValue;
    }

    public static void c(hf3 hf3Var) {
        zh1 X;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, hf3Var) == null) || (X = vl2.U().X()) == null) {
            return;
        }
        X.e(hf3Var);
    }

    public static boolean d(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, view2)) == null) {
            zh1 X = vl2.U().X();
            return X != null && X.removeView(view2);
        }
        return invokeL.booleanValue;
    }

    public static void e(hf3 hf3Var) {
        zh1 X;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, hf3Var) == null) || (X = vl2.U().X()) == null) {
            return;
        }
        X.f(hf3Var);
    }

    public static boolean f(View view2, oq2 oq2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, view2, oq2Var)) == null) {
            zh1 X = vl2.U().X();
            return X != null && X.a(view2, oq2Var);
        }
        return invokeLL.booleanValue;
    }
}
