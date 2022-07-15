package com.repackage;

import androidx.annotation.Nullable;
import com.baidu.swan.apps.canvas.view.CanvasView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class iw1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Nullable
    public static CanvasView a(ev1 ev1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, ev1Var)) == null) {
            hw1 hw1Var = (hw1) uw1.a(ev1Var);
            if (hw1Var == null) {
                hx1.c("Component-Canvas-Utils", "get canvas view fail: find a null component");
                return null;
            }
            return hw1Var.i;
        }
        return (CanvasView) invokeL.objValue;
    }
}
