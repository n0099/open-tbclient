package com.google.android.material.animation;

import android.animation.TimeInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.annotation.RestrictTo;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public class AnimationUtils {
    public static /* synthetic */ Interceptable $ic;
    public static final TimeInterpolator DECELERATE_INTERPOLATOR;
    public static final TimeInterpolator FAST_OUT_LINEAR_IN_INTERPOLATOR;
    public static final TimeInterpolator FAST_OUT_SLOW_IN_INTERPOLATOR;
    public static final TimeInterpolator LINEAR_INTERPOLATOR;
    public static final TimeInterpolator LINEAR_OUT_SLOW_IN_INTERPOLATOR;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1057748457, "Lcom/google/android/material/animation/AnimationUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1057748457, "Lcom/google/android/material/animation/AnimationUtils;");
                return;
            }
        }
        LINEAR_INTERPOLATOR = new LinearInterpolator();
        FAST_OUT_SLOW_IN_INTERPOLATOR = new FastOutSlowInInterpolator();
        FAST_OUT_LINEAR_IN_INTERPOLATOR = new FastOutLinearInInterpolator();
        LINEAR_OUT_SLOW_IN_INTERPOLATOR = new LinearOutSlowInInterpolator();
        DECELERATE_INTERPOLATOR = new DecelerateInterpolator();
    }

    public AnimationUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static float lerp(float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) ? f2 + (f4 * (f3 - f2)) : invokeCommon.floatValue;
    }

    public static int lerp(int i2, int i3, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f2)})) == null) ? i2 + Math.round(f2 * (i3 - i2)) : invokeCommon.intValue;
    }
}
