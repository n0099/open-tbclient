package com.google.android.material.bottomappbar;

import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.shape.EdgeTreatment;
import com.google.android.material.shape.ShapePath;
/* loaded from: classes2.dex */
public class BottomAppBarTopEdgeTreatment extends EdgeTreatment implements Cloneable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ANGLE_LEFT = 180;
    public static final int ANGLE_UP = 270;
    public static final int ARC_HALF = 180;
    public static final int ARC_QUARTER = 90;
    public transient /* synthetic */ FieldHolder $fh;
    public float cradleVerticalOffset;
    public float fabDiameter;
    public float fabMargin;
    public float horizontalOffset;
    public float roundedCornerRadius;

    public BottomAppBarTopEdgeTreatment(float f2, float f3, float f4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.fabMargin = f2;
        this.roundedCornerRadius = f3;
        setCradleVerticalOffset(f4);
        this.horizontalOffset = 0.0f;
    }

    public float getCradleVerticalOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.cradleVerticalOffset : invokeV.floatValue;
    }

    @Override // com.google.android.material.shape.EdgeTreatment
    public void getEdgePath(float f2, float f3, float f4, @NonNull ShapePath shapePath) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), shapePath}) == null) {
            float f5 = this.fabDiameter;
            if (f5 == 0.0f) {
                shapePath.lineTo(f2, 0.0f);
                return;
            }
            float f6 = ((this.fabMargin * 2.0f) + f5) / 2.0f;
            float f7 = f4 * this.roundedCornerRadius;
            float f8 = f3 + this.horizontalOffset;
            float f9 = (this.cradleVerticalOffset * f4) + ((1.0f - f4) * f6);
            if (f9 / f6 >= 1.0f) {
                shapePath.lineTo(f2, 0.0f);
                return;
            }
            float f10 = f6 + f7;
            float f11 = f9 + f7;
            float sqrt = (float) Math.sqrt((f10 * f10) - (f11 * f11));
            float f12 = f8 - sqrt;
            float f13 = f8 + sqrt;
            float degrees = (float) Math.toDegrees(Math.atan(sqrt / f11));
            float f14 = 90.0f - degrees;
            shapePath.lineTo(f12, 0.0f);
            float f15 = f7 * 2.0f;
            shapePath.addArc(f12 - f7, 0.0f, f12 + f7, f15, 270.0f, degrees);
            shapePath.addArc(f8 - f6, (-f6) - f9, f8 + f6, f6 - f9, 180.0f - f14, (f14 * 2.0f) - 180.0f);
            shapePath.addArc(f13 - f7, 0.0f, f13 + f7, f15, 270.0f - degrees, degrees);
            shapePath.lineTo(f2, 0.0f);
        }
    }

    public float getFabCradleMargin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.fabMargin : invokeV.floatValue;
    }

    public float getFabCradleRoundedCornerRadius() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.roundedCornerRadius : invokeV.floatValue;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float getFabDiameter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.fabDiameter : invokeV.floatValue;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float getHorizontalOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.horizontalOffset : invokeV.floatValue;
    }

    public void setCradleVerticalOffset(@FloatRange(from = 0.0d) float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048582, this, f2) == null) {
            if (f2 >= 0.0f) {
                this.cradleVerticalOffset = f2;
                return;
            }
            throw new IllegalArgumentException("cradleVerticalOffset must be positive.");
        }
    }

    public void setFabCradleMargin(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048583, this, f2) == null) {
            this.fabMargin = f2;
        }
    }

    public void setFabCradleRoundedCornerRadius(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(InputDeviceCompat.SOURCE_TOUCHPAD, this, f2) == null) {
            this.roundedCornerRadius = f2;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setFabDiameter(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048585, this, f2) == null) {
            this.fabDiameter = f2;
        }
    }

    public void setHorizontalOffset(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048586, this, f2) == null) {
            this.horizontalOffset = f2;
        }
    }
}
