package com.repackage;

import androidx.annotation.Nullable;
import com.baidu.swan.apps.canvas.view.CanvasView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class tv1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Nullable
    public static CanvasView a(pu1 pu1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, pu1Var)) == null) {
            sv1 sv1Var = (sv1) fw1.a(pu1Var);
            if (sv1Var == null) {
                sw1.c("Component-Canvas-Utils", "get canvas view fail: find a null component");
                return null;
            }
            return sv1Var.i;
        }
        return (CanvasView) invokeL.objValue;
    }
}
