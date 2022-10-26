package com.google.android.material.elevation;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialAttributes;
/* loaded from: classes7.dex */
public class ElevationOverlayProvider {
    public static /* synthetic */ Interceptable $ic = null;
    public static final float FORMULA_MULTIPLIER = 4.5f;
    public static final float FORMULA_OFFSET = 2.0f;
    public transient /* synthetic */ FieldHolder $fh;
    public final int colorSurface;
    public final float displayDensity;
    public final int elevationOverlayColor;
    public final boolean elevationOverlayEnabled;

    public ElevationOverlayProvider(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.elevationOverlayEnabled = MaterialAttributes.resolveBoolean(context, R.attr.obfuscated_res_0x7f040270, false);
        this.elevationOverlayColor = MaterialColors.getColor(context, (int) R.attr.obfuscated_res_0x7f04026f, 0);
        this.colorSurface = MaterialColors.getColor(context, (int) R.attr.obfuscated_res_0x7f04017e, 0);
        this.displayDensity = context.getResources().getDisplayMetrics().density;
    }

    private boolean isThemeSurfaceColor(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, this, i)) == null) {
            if (ColorUtils.setAlphaComponent(i, 255) == this.colorSurface) {
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public int calculateOverlayAlpha(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f)) == null) {
            return Math.round(calculateOverlayAlphaFraction(f) * 255.0f);
        }
        return invokeF.intValue;
    }

    public int compositeOverlayWithThemeSurfaceColorIfNeeded(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048582, this, f)) == null) {
            return compositeOverlayIfNeeded(this.colorSurface, f);
        }
        return invokeF.intValue;
    }

    public float getParentAbsoluteElevation(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2)) == null) {
            return ViewUtils.getParentAbsoluteElevation(view2);
        }
        return invokeL.floatValue;
    }

    public float calculateOverlayAlphaFraction(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f)) == null) {
            float f2 = this.displayDensity;
            if (f2 <= 0.0f || f <= 0.0f) {
                return 0.0f;
            }
            return Math.min(((((float) Math.log1p(f / f2)) * 4.5f) + 2.0f) / 100.0f, 1.0f);
        }
        return invokeF.floatValue;
    }

    public int compositeOverlay(int i, float f) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)})) == null) {
            return ColorUtils.setAlphaComponent(MaterialColors.layer(ColorUtils.setAlphaComponent(i, 255), this.elevationOverlayColor, calculateOverlayAlphaFraction(f)), Color.alpha(i));
        }
        return invokeCommon.intValue;
    }

    public int compositeOverlayIfNeeded(int i, float f) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)})) == null) {
            if (this.elevationOverlayEnabled && isThemeSurfaceColor(i)) {
                return compositeOverlay(i, f);
            }
            return i;
        }
        return invokeCommon.intValue;
    }

    public int compositeOverlay(int i, float f, View view2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), view2})) == null) {
            return compositeOverlay(i, f + getParentAbsoluteElevation(view2));
        }
        return invokeCommon.intValue;
    }

    public int compositeOverlayIfNeeded(int i, float f, View view2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), view2})) == null) {
            return compositeOverlayIfNeeded(i, f + getParentAbsoluteElevation(view2));
        }
        return invokeCommon.intValue;
    }

    public int compositeOverlayWithThemeSurfaceColorIfNeeded(float f, View view2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Float.valueOf(f), view2})) == null) {
            return compositeOverlayWithThemeSurfaceColorIfNeeded(f + getParentAbsoluteElevation(view2));
        }
        return invokeCommon.intValue;
    }

    public int getThemeElevationOverlayColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.elevationOverlayColor;
        }
        return invokeV.intValue;
    }

    public int getThemeSurfaceColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.colorSurface;
        }
        return invokeV.intValue;
    }

    public boolean isThemeElevationOverlayEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.elevationOverlayEnabled;
        }
        return invokeV.booleanValue;
    }
}
