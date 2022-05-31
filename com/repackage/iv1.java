package com.repackage;

import androidx.annotation.Nullable;
import com.baidu.swan.apps.canvas.view.CanvasView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class iv1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Nullable
    public static CanvasView a(eu1 eu1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, eu1Var)) == null) {
            hv1 hv1Var = (hv1) uv1.a(eu1Var);
            if (hv1Var == null) {
                hw1.c("Component-Canvas-Utils", "get canvas view fail: find a null component");
                return null;
            }
            return hv1Var.i;
        }
        return (CanvasView) invokeL.objValue;
    }
}
