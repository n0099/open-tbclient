package com.repackage;

import androidx.annotation.Nullable;
import com.baidu.swan.apps.canvas.view.CanvasView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class vw1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Nullable
    public static CanvasView a(rv1 rv1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, rv1Var)) == null) {
            uw1 uw1Var = (uw1) hx1.a(rv1Var);
            if (uw1Var == null) {
                ux1.c("Component-Canvas-Utils", "get canvas view fail: find a null component");
                return null;
            }
            return uw1Var.i;
        }
        return (CanvasView) invokeL.objValue;
    }
}
