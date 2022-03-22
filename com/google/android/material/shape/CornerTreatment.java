package com.google.android.material.shape;

import android.graphics.RectF;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class CornerTreatment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public CornerTreatment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Deprecated
    public void getCornerPath(float f2, float f3, @NonNull ShapePath shapePath) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), shapePath}) == null) {
        }
    }

    public void getCornerPath(@NonNull ShapePath shapePath, float f2, float f3, float f4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{shapePath, Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) {
            getCornerPath(f2, f3, shapePath);
        }
    }

    public void getCornerPath(@NonNull ShapePath shapePath, float f2, float f3, @NonNull RectF rectF, @NonNull CornerSize cornerSize) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{shapePath, Float.valueOf(f2), Float.valueOf(f3), rectF, cornerSize}) == null) {
            getCornerPath(shapePath, f2, f3, cornerSize.getCornerSize(rectF));
        }
    }
}
