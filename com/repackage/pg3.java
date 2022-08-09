package com.repackage;

import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class pg3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull og3 og3Var, @NonNull fr2 fr2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, og3Var, fr2Var) == null) {
            og3Var.f(fr2Var.d());
            og3Var.g(fr2Var.e());
            if (fr2Var.g()) {
                og3Var.a(1);
            } else {
                og3Var.e(1);
            }
        }
    }

    public static FrameLayout.LayoutParams b(@NonNull gn1 gn1Var, @NonNull fr2 fr2Var) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, gn1Var, fr2Var)) == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(fr2Var.f(), fr2Var.c());
            int i2 = 0;
            if (fr2Var.g()) {
                i2 = gn1Var.getWebViewScrollX();
                i = gn1Var.getWebViewScrollY();
            } else {
                i = 0;
            }
            layoutParams.leftMargin = fr2Var.d() + i2;
            layoutParams.topMargin = fr2Var.e() + i;
            return layoutParams;
        }
        return (FrameLayout.LayoutParams) invokeLL.objValue;
    }
}
