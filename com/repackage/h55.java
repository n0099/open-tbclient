package com.repackage;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class h55 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static g55 a(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, view2)) == null) {
            if (view2 == null) {
                return null;
            }
            if (view2 instanceof LinearLayout) {
                return new i55();
            }
            if (view2 instanceof RelativeLayout) {
                return new l55();
            }
            if (view2 instanceof FrameLayout) {
                return new e55();
            }
            return null;
        }
        return (g55) invokeL.objValue;
    }

    public static g55 b(View view2, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65537, null, view2, z)) == null) {
            if (view2 == null) {
                return null;
            }
            if (view2 instanceof LinearLayout) {
                return new i55();
            }
            if (view2 instanceof RelativeLayout) {
                return new l55();
            }
            if (view2 instanceof FrameLayout) {
                return z ? new m55() : new e55();
            }
            return null;
        }
        return (g55) invokeLZ.objValue;
    }
}
