package com.repackage;

import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class zf3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull yf3 yf3Var, @NonNull pq2 pq2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, yf3Var, pq2Var) == null) {
            yf3Var.f(pq2Var.d());
            yf3Var.g(pq2Var.e());
            if (pq2Var.g()) {
                yf3Var.a(1);
            } else {
                yf3Var.e(1);
            }
        }
    }

    public static FrameLayout.LayoutParams b(@NonNull qm1 qm1Var, @NonNull pq2 pq2Var) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, qm1Var, pq2Var)) == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(pq2Var.f(), pq2Var.c());
            int i2 = 0;
            if (pq2Var.g()) {
                i2 = qm1Var.getWebViewScrollX();
                i = qm1Var.getWebViewScrollY();
            } else {
                i = 0;
            }
            layoutParams.leftMargin = pq2Var.d() + i2;
            layoutParams.topMargin = pq2Var.e() + i;
            return layoutParams;
        }
        return (FrameLayout.LayoutParams) invokeLL.objValue;
    }
}
