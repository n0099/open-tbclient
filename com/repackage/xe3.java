package com.repackage;

import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class xe3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull we3 we3Var, @NonNull np2 np2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, we3Var, np2Var) == null) {
            we3Var.f(np2Var.d());
            we3Var.g(np2Var.e());
            if (np2Var.g()) {
                we3Var.a(1);
            } else {
                we3Var.e(1);
            }
        }
    }

    public static FrameLayout.LayoutParams b(@NonNull ol1 ol1Var, @NonNull np2 np2Var) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, ol1Var, np2Var)) == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(np2Var.f(), np2Var.c());
            int i2 = 0;
            if (np2Var.g()) {
                i2 = ol1Var.getWebViewScrollX();
                i = ol1Var.getWebViewScrollY();
            } else {
                i = 0;
            }
            layoutParams.leftMargin = np2Var.d() + i2;
            layoutParams.topMargin = np2Var.e() + i;
            return layoutParams;
        }
        return (FrameLayout.LayoutParams) invokeLL.objValue;
    }
}
