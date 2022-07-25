package com.repackage;

import androidx.annotation.Nullable;
import com.baidu.swan.apps.canvas.view.CanvasView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class jw1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Nullable
    public static CanvasView a(fv1 fv1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, fv1Var)) == null) {
            iw1 iw1Var = (iw1) vw1.a(fv1Var);
            if (iw1Var == null) {
                ix1.c("Component-Canvas-Utils", "get canvas view fail: find a null component");
                return null;
            }
            return iw1Var.i;
        }
        return (CanvasView) invokeL.objValue;
    }
}
