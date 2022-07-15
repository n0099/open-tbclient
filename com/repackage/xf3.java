package com.repackage;

import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class xf3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull wf3 wf3Var, @NonNull nq2 nq2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, wf3Var, nq2Var) == null) {
            wf3Var.f(nq2Var.d());
            wf3Var.g(nq2Var.e());
            if (nq2Var.g()) {
                wf3Var.a(1);
            } else {
                wf3Var.e(1);
            }
        }
    }

    public static FrameLayout.LayoutParams b(@NonNull om1 om1Var, @NonNull nq2 nq2Var) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, om1Var, nq2Var)) == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(nq2Var.f(), nq2Var.c());
            int i2 = 0;
            if (nq2Var.g()) {
                i2 = om1Var.getWebViewScrollX();
                i = om1Var.getWebViewScrollY();
            } else {
                i = 0;
            }
            layoutParams.leftMargin = nq2Var.d() + i2;
            layoutParams.topMargin = nq2Var.e() + i;
            return layoutParams;
        }
        return (FrameLayout.LayoutParams) invokeLL.objValue;
    }
}
