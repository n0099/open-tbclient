package com.google.android.material.canvas;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes11.dex */
public class CanvasCompat {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public CanvasCompat() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static int saveLayerAlpha(@NonNull Canvas canvas, @Nullable RectF rectF, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65538, null, canvas, rectF, i2)) == null) {
            if (Build.VERSION.SDK_INT > 21) {
                return canvas.saveLayerAlpha(rectF, i2);
            }
            return canvas.saveLayerAlpha(rectF, i2, 31);
        }
        return invokeLLI.intValue;
    }

    public static int saveLayerAlpha(@NonNull Canvas canvas, float f2, float f3, float f4, float f5, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{canvas, Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Integer.valueOf(i2)})) == null) {
            if (Build.VERSION.SDK_INT > 21) {
                return canvas.saveLayerAlpha(f2, f3, f4, f5, i2);
            }
            return canvas.saveLayerAlpha(f2, f3, f4, f5, i2, 31);
        }
        return invokeCommon.intValue;
    }
}
