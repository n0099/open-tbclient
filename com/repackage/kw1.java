package com.repackage;

import androidx.annotation.Nullable;
import com.baidu.swan.apps.canvas.view.CanvasView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class kw1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Nullable
    public static CanvasView a(gv1 gv1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, gv1Var)) == null) {
            jw1 jw1Var = (jw1) ww1.a(gv1Var);
            if (jw1Var == null) {
                jx1.c("Component-Canvas-Utils", "get canvas view fail: find a null component");
                return null;
            }
            return jw1Var.i;
        }
        return (CanvasView) invokeL.objValue;
    }
}
