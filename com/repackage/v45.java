package com.repackage;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class v45 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static u45 a(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, view2)) == null) {
            if (view2 == null) {
                return null;
            }
            if (view2 instanceof LinearLayout) {
                return new w45();
            }
            if (view2 instanceof RelativeLayout) {
                return new z45();
            }
            if (view2 instanceof FrameLayout) {
                return new s45();
            }
            return null;
        }
        return (u45) invokeL.objValue;
    }

    public static u45 b(View view2, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65537, null, view2, z)) == null) {
            if (view2 == null) {
                return null;
            }
            if (view2 instanceof LinearLayout) {
                return new w45();
            }
            if (view2 instanceof RelativeLayout) {
                return new z45();
            }
            if (view2 instanceof FrameLayout) {
                return z ? new a55() : new s45();
            }
            return null;
        }
        return (u45) invokeLZ.objValue;
    }
}
