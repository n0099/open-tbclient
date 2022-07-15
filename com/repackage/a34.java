package com.repackage;

import android.content.Context;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class a34 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(View view2, nq2 nq2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, view2, nq2Var)) == null) {
            yh1 X = ul2.U().X();
            return X != null && X.c(view2, nq2Var);
        }
        return invokeLL.booleanValue;
    }

    public static Context b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            yh1 X = ul2.U().X();
            if (X != null) {
                return X.getContext();
            }
            return null;
        }
        return (Context) invokeV.objValue;
    }

    public static void c(gf3 gf3Var) {
        yh1 X;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, gf3Var) == null) || (X = ul2.U().X()) == null) {
            return;
        }
        X.e(gf3Var);
    }

    public static boolean d(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, view2)) == null) {
            yh1 X = ul2.U().X();
            return X != null && X.removeView(view2);
        }
        return invokeL.booleanValue;
    }

    public static void e(gf3 gf3Var) {
        yh1 X;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, gf3Var) == null) || (X = ul2.U().X()) == null) {
            return;
        }
        X.f(gf3Var);
    }

    public static boolean f(View view2, nq2 nq2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, view2, nq2Var)) == null) {
            yh1 X = ul2.U().X();
            return X != null && X.a(view2, nq2Var);
        }
        return invokeLL.booleanValue;
    }
}
