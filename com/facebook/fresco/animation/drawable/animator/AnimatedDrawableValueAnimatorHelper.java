package com.facebook.fresco.animation.drawable.animator;

import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import android.os.Build;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import javax.annotation.Nullable;
/* loaded from: classes5.dex */
public class AnimatedDrawableValueAnimatorHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public AnimatedDrawableValueAnimatorHelper() {
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

    @Nullable
    public static ValueAnimator.AnimatorUpdateListener createAnimatorUpdateListener(Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, drawable)) == null) {
            if (Build.VERSION.SDK_INT >= 11 && (drawable instanceof AnimatedDrawable2)) {
                return AnimatedDrawable2ValueAnimatorHelper.createAnimatorUpdateListener((AnimatedDrawable2) drawable);
            }
            return null;
        }
        return (ValueAnimator.AnimatorUpdateListener) invokeL.objValue;
    }

    @Nullable
    public static ValueAnimator createValueAnimator(Drawable drawable, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, drawable, i2)) == null) {
            if (Build.VERSION.SDK_INT >= 11 && (drawable instanceof AnimatedDrawable2)) {
                return AnimatedDrawable2ValueAnimatorHelper.createValueAnimator((AnimatedDrawable2) drawable, i2);
            }
            return null;
        }
        return (ValueAnimator) invokeLI.objValue;
    }

    @Nullable
    public static ValueAnimator createValueAnimator(Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, drawable)) == null) {
            if (Build.VERSION.SDK_INT >= 11 && (drawable instanceof AnimatedDrawable2)) {
                return AnimatedDrawable2ValueAnimatorHelper.createValueAnimator((AnimatedDrawable2) drawable);
            }
            return null;
        }
        return (ValueAnimator) invokeL.objValue;
    }
}
