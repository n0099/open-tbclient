package com.repackage;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class q35 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static p35 a(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, view2)) == null) {
            if (view2 == null) {
                return null;
            }
            if (view2 instanceof LinearLayout) {
                return new r35();
            }
            if (view2 instanceof RelativeLayout) {
                return new u35();
            }
            if (view2 instanceof FrameLayout) {
                return new n35();
            }
            return null;
        }
        return (p35) invokeL.objValue;
    }

    public static p35 b(View view2, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65537, null, view2, z)) == null) {
            if (view2 == null) {
                return null;
            }
            if (view2 instanceof LinearLayout) {
                return new r35();
            }
            if (view2 instanceof RelativeLayout) {
                return new u35();
            }
            if (view2 instanceof FrameLayout) {
                return z ? new v35() : new n35();
            }
            return null;
        }
        return (p35) invokeLZ.objValue;
    }
}
