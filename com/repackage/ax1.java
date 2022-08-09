package com.repackage;

import androidx.annotation.Nullable;
import com.baidu.swan.apps.canvas.view.CanvasView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class ax1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Nullable
    public static CanvasView a(wv1 wv1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, wv1Var)) == null) {
            zw1 zw1Var = (zw1) mx1.a(wv1Var);
            if (zw1Var == null) {
                zx1.c("Component-Canvas-Utils", "get canvas view fail: find a null component");
                return null;
            }
            return zw1Var.i;
        }
        return (CanvasView) invokeL.objValue;
    }
}
