package com.repackage;

import android.content.Context;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class n34 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(View view2, ar2 ar2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, view2, ar2Var)) == null) {
            li1 X = hm2.U().X();
            return X != null && X.c(view2, ar2Var);
        }
        return invokeLL.booleanValue;
    }

    public static Context b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            li1 X = hm2.U().X();
            if (X != null) {
                return X.getContext();
            }
            return null;
        }
        return (Context) invokeV.objValue;
    }

    public static void c(tf3 tf3Var) {
        li1 X;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, tf3Var) == null) || (X = hm2.U().X()) == null) {
            return;
        }
        X.e(tf3Var);
    }

    public static boolean d(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, view2)) == null) {
            li1 X = hm2.U().X();
            return X != null && X.removeView(view2);
        }
        return invokeL.booleanValue;
    }

    public static void e(tf3 tf3Var) {
        li1 X;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, tf3Var) == null) || (X = hm2.U().X()) == null) {
            return;
        }
        X.f(tf3Var);
    }

    public static boolean f(View view2, ar2 ar2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, view2, ar2Var)) == null) {
            li1 X = hm2.U().X();
            return X != null && X.a(view2, ar2Var);
        }
        return invokeLL.booleanValue;
    }
}
