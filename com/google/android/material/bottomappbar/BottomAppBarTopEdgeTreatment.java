package com.google.android.material.bottomappbar;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.shape.EdgeTreatment;
import com.google.android.material.shape.ShapePath;
/* loaded from: classes7.dex */
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

    public BottomAppBarTopEdgeTreatment(float f, float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.fabMargin = f;
        this.roundedCornerRadius = f2;
        setCradleVerticalOffset(f3);
        this.horizontalOffset = 0.0f;
    }

    public float getCradleVerticalOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.cradleVerticalOffset;
        }
        return invokeV.floatValue;
    }

    public float getFabCradleMargin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.fabMargin;
        }
        return invokeV.floatValue;
    }

    public float getFabCradleRoundedCornerRadius() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.roundedCornerRadius;
        }
        return invokeV.floatValue;
    }

    public float getFabDiameter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.fabDiameter;
        }
        return invokeV.floatValue;
    }

    public float getHorizontalOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.horizontalOffset;
        }
        return invokeV.floatValue;
    }

    @Override // com.google.android.material.shape.EdgeTreatment
    public void getEdgePath(float f, float f2, float f3, ShapePath shapePath) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), shapePath}) == null) {
            float f4 = this.fabDiameter;
            if (f4 == 0.0f) {
                shapePath.lineTo(f, 0.0f);
                return;
            }
            float f5 = ((this.fabMargin * 2.0f) + f4) / 2.0f;
            float f6 = f3 * this.roundedCornerRadius;
            float f7 = f2 + this.horizontalOffset;
            float f8 = (this.cradleVerticalOffset * f3) + ((1.0f - f3) * f5);
            if (f8 / f5 >= 1.0f) {
                shapePath.lineTo(f, 0.0f);
                return;
            }
            float f9 = f5 + f6;
            float f10 = f8 + f6;
            float sqrt = (float) Math.sqrt((f9 * f9) - (f10 * f10));
            float f11 = f7 - sqrt;
            float f12 = f7 + sqrt;
            float degrees = (float) Math.toDegrees(Math.atan(sqrt / f10));
            float f13 = 90.0f - degrees;
            shapePath.lineTo(f11, 0.0f);
            float f14 = f6 * 2.0f;
            shapePath.addArc(f11 - f6, 0.0f, f11 + f6, f14, 270.0f, degrees);
            shapePath.addArc(f7 - f5, (-f5) - f8, f7 + f5, f5 - f8, 180.0f - f13, (f13 * 2.0f) - 180.0f);
            shapePath.addArc(f12 - f6, 0.0f, f12 + f6, f14, 270.0f - degrees, degrees);
            shapePath.lineTo(f, 0.0f);
        }
    }

    public void setCradleVerticalOffset(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048582, this, f) == null) {
            if (f >= 0.0f) {
                this.cradleVerticalOffset = f;
                return;
            }
            throw new IllegalArgumentException("cradleVerticalOffset must be positive.");
        }
    }

    public void setFabCradleMargin(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048583, this, f) == null) {
            this.fabMargin = f;
        }
    }

    public void setFabCradleRoundedCornerRadius(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(InputDeviceCompat.SOURCE_TOUCHPAD, this, f) == null) {
            this.roundedCornerRadius = f;
        }
    }

    public void setFabDiameter(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048585, this, f) == null) {
            this.fabDiameter = f;
        }
    }

    public void setHorizontalOffset(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048586, this, f) == null) {
            this.horizontalOffset = f;
        }
    }
}
