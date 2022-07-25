package com.repackage;

import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class yf3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull xf3 xf3Var, @NonNull oq2 oq2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, xf3Var, oq2Var) == null) {
            xf3Var.f(oq2Var.d());
            xf3Var.g(oq2Var.e());
            if (oq2Var.g()) {
                xf3Var.a(1);
            } else {
                xf3Var.e(1);
            }
        }
    }

    public static FrameLayout.LayoutParams b(@NonNull pm1 pm1Var, @NonNull oq2 oq2Var) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, pm1Var, oq2Var)) == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(oq2Var.f(), oq2Var.c());
            int i2 = 0;
            if (oq2Var.g()) {
                i2 = pm1Var.getWebViewScrollX();
                i = pm1Var.getWebViewScrollY();
            } else {
                i = 0;
            }
            layoutParams.leftMargin = oq2Var.d() + i2;
            layoutParams.topMargin = oq2Var.e() + i;
            return layoutParams;
        }
        return (FrameLayout.LayoutParams) invokeLL.objValue;
    }
}
