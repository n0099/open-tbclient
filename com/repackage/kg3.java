package com.repackage;

import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class kg3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull jg3 jg3Var, @NonNull ar2 ar2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, jg3Var, ar2Var) == null) {
            jg3Var.f(ar2Var.d());
            jg3Var.g(ar2Var.e());
            if (ar2Var.g()) {
                jg3Var.a(1);
            } else {
                jg3Var.e(1);
            }
        }
    }

    public static FrameLayout.LayoutParams b(@NonNull bn1 bn1Var, @NonNull ar2 ar2Var) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, bn1Var, ar2Var)) == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ar2Var.f(), ar2Var.c());
            int i2 = 0;
            if (ar2Var.g()) {
                i2 = bn1Var.getWebViewScrollX();
                i = bn1Var.getWebViewScrollY();
            } else {
                i = 0;
            }
            layoutParams.leftMargin = ar2Var.d() + i2;
            layoutParams.topMargin = ar2Var.e() + i;
            return layoutParams;
        }
        return (FrameLayout.LayoutParams) invokeLL.objValue;
    }
}
