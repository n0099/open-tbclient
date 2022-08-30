package com.google.android.material.ripple;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.util.Log;
import android.util.StateSet;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes7.dex */
public class RippleUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int[] ENABLED_PRESSED_STATE_SET;
    public static final int[] FOCUSED_STATE_SET;
    public static final int[] HOVERED_FOCUSED_STATE_SET;
    public static final int[] HOVERED_STATE_SET;
    @VisibleForTesting
    public static final String LOG_TAG;
    public static final int[] PRESSED_STATE_SET;
    public static final int[] SELECTED_FOCUSED_STATE_SET;
    public static final int[] SELECTED_HOVERED_FOCUSED_STATE_SET;
    public static final int[] SELECTED_HOVERED_STATE_SET;
    public static final int[] SELECTED_PRESSED_STATE_SET;
    public static final int[] SELECTED_STATE_SET;
    @VisibleForTesting
    public static final String TRANSPARENT_DEFAULT_COLOR_WARNING = "Use a non-transparent color for the default color as it will be used to finish ripple animations.";
    public static final boolean USE_FRAMEWORK_RIPPLE;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-854413043, "Lcom/google/android/material/ripple/RippleUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-854413043, "Lcom/google/android/material/ripple/RippleUtils;");
                return;
            }
        }
        USE_FRAMEWORK_RIPPLE = Build.VERSION.SDK_INT >= 21;
        PRESSED_STATE_SET = new int[]{16842919};
        HOVERED_FOCUSED_STATE_SET = new int[]{16843623, 16842908};
        FOCUSED_STATE_SET = new int[]{16842908};
        HOVERED_STATE_SET = new int[]{16843623};
        SELECTED_PRESSED_STATE_SET = new int[]{16842913, 16842919};
        SELECTED_HOVERED_FOCUSED_STATE_SET = new int[]{16842913, 16843623, 16842908};
        SELECTED_FOCUSED_STATE_SET = new int[]{16842913, 16842908};
        SELECTED_HOVERED_STATE_SET = new int[]{16842913, 16843623};
        SELECTED_STATE_SET = new int[]{16842913};
        ENABLED_PRESSED_STATE_SET = new int[]{16842910, 16842919};
        LOG_TAG = RippleUtils.class.getSimpleName();
    }

    public RippleUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @NonNull
    public static ColorStateList convertToRippleDrawableColor(@Nullable ColorStateList colorStateList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, colorStateList)) == null) {
            if (USE_FRAMEWORK_RIPPLE) {
                return new ColorStateList(new int[][]{SELECTED_STATE_SET, StateSet.NOTHING}, new int[]{getColorForState(colorStateList, SELECTED_PRESSED_STATE_SET), getColorForState(colorStateList, PRESSED_STATE_SET)});
            }
            int[] iArr = SELECTED_PRESSED_STATE_SET;
            int[] iArr2 = SELECTED_HOVERED_FOCUSED_STATE_SET;
            int[] iArr3 = SELECTED_FOCUSED_STATE_SET;
            int[] iArr4 = SELECTED_HOVERED_STATE_SET;
            int[] iArr5 = PRESSED_STATE_SET;
            int[] iArr6 = HOVERED_FOCUSED_STATE_SET;
            int[] iArr7 = FOCUSED_STATE_SET;
            int[] iArr8 = HOVERED_STATE_SET;
            return new ColorStateList(new int[][]{iArr, iArr2, iArr3, iArr4, SELECTED_STATE_SET, iArr5, iArr6, iArr7, iArr8, StateSet.NOTHING}, new int[]{getColorForState(colorStateList, iArr), getColorForState(colorStateList, iArr2), getColorForState(colorStateList, iArr3), getColorForState(colorStateList, iArr4), 0, getColorForState(colorStateList, iArr5), getColorForState(colorStateList, iArr6), getColorForState(colorStateList, iArr7), getColorForState(colorStateList, iArr8), 0});
        }
        return (ColorStateList) invokeL.objValue;
    }

    @ColorInt
    @TargetApi(21)
    public static int doubleAlpha(@ColorInt int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) ? ColorUtils.setAlphaComponent(i, Math.min(Color.alpha(i) * 2, 255)) : invokeI.intValue;
    }

    @ColorInt
    public static int getColorForState(@Nullable ColorStateList colorStateList, int[] iArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, colorStateList, iArr)) == null) {
            int colorForState = colorStateList != null ? colorStateList.getColorForState(iArr, colorStateList.getDefaultColor()) : 0;
            return USE_FRAMEWORK_RIPPLE ? doubleAlpha(colorForState) : colorForState;
        }
        return invokeLL.intValue;
    }

    @NonNull
    public static ColorStateList sanitizeRippleDrawableColor(@Nullable ColorStateList colorStateList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, colorStateList)) == null) {
            if (colorStateList != null) {
                int i = Build.VERSION.SDK_INT;
                if (i >= 22 && i <= 27 && Color.alpha(colorStateList.getDefaultColor()) == 0 && Color.alpha(colorStateList.getColorForState(ENABLED_PRESSED_STATE_SET, 0)) != 0) {
                    Log.w(LOG_TAG, TRANSPARENT_DEFAULT_COLOR_WARNING);
                }
                return colorStateList;
            }
            return ColorStateList.valueOf(0);
        }
        return (ColorStateList) invokeL.objValue;
    }

    public static boolean shouldDrawRippleCompat(@NonNull int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, iArr)) == null) {
            boolean z = false;
            boolean z2 = false;
            for (int i : iArr) {
                if (i == 16842910) {
                    z = true;
                } else if (i == 16842908 || i == 16842919 || i == 16843623) {
                    z2 = true;
                }
            }
            return z && z2;
        }
        return invokeL.booleanValue;
    }
}
