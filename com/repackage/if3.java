package com.repackage;

import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class if3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull hf3 hf3Var, @NonNull yp2 yp2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, hf3Var, yp2Var) == null) {
            hf3Var.f(yp2Var.d());
            hf3Var.g(yp2Var.e());
            if (yp2Var.g()) {
                hf3Var.a(1);
            } else {
                hf3Var.e(1);
            }
        }
    }

    public static FrameLayout.LayoutParams b(@NonNull zl1 zl1Var, @NonNull yp2 yp2Var) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, zl1Var, yp2Var)) == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(yp2Var.f(), yp2Var.c());
            int i2 = 0;
            if (yp2Var.g()) {
                i2 = zl1Var.getWebViewScrollX();
                i = zl1Var.getWebViewScrollY();
            } else {
                i = 0;
            }
            layoutParams.leftMargin = yp2Var.d() + i2;
            layoutParams.topMargin = yp2Var.e() + i;
            return layoutParams;
        }
        return (FrameLayout.LayoutParams) invokeLL.objValue;
    }
}
