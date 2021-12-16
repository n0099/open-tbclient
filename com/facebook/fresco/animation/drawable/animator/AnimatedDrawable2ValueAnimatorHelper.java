package com.facebook.fresco.animation.drawable.animator;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import javax.annotation.Nullable;
@TargetApi(11)
/* loaded from: classes2.dex */
public class AnimatedDrawable2ValueAnimatorHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public AnimatedDrawable2ValueAnimatorHelper() {
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

    public static ValueAnimator.AnimatorUpdateListener createAnimatorUpdateListener(AnimatedDrawable2 animatedDrawable2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, animatedDrawable2)) == null) ? new ValueAnimator.AnimatorUpdateListener(animatedDrawable2) { // from class: com.facebook.fresco.animation.drawable.animator.AnimatedDrawable2ValueAnimatorHelper.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AnimatedDrawable2 val$drawable;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {animatedDrawable2};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.val$drawable = animatedDrawable2;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            @TargetApi(11)
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) {
                    this.val$drawable.setLevel(((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            }
        } : (ValueAnimator.AnimatorUpdateListener) invokeL.objValue;
    }

    @Nullable
    public static ValueAnimator createValueAnimator(AnimatedDrawable2 animatedDrawable2, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, animatedDrawable2, i2)) == null) {
            ValueAnimator createValueAnimator = createValueAnimator(animatedDrawable2);
            if (createValueAnimator == null) {
                return null;
            }
            createValueAnimator.setRepeatCount((int) Math.max(i2 / animatedDrawable2.getLoopDurationMs(), 1L));
            return createValueAnimator;
        }
        return (ValueAnimator) invokeLI.objValue;
    }

    public static ValueAnimator createValueAnimator(AnimatedDrawable2 animatedDrawable2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, animatedDrawable2)) == null) {
            int loopCount = animatedDrawable2.getLoopCount();
            ValueAnimator valueAnimator = new ValueAnimator();
            valueAnimator.setIntValues(0, (int) animatedDrawable2.getLoopDurationMs());
            valueAnimator.setDuration(animatedDrawable2.getLoopDurationMs());
            if (loopCount == 0) {
                loopCount = -1;
            }
            valueAnimator.setRepeatCount(loopCount);
            valueAnimator.setRepeatMode(1);
            valueAnimator.setInterpolator(null);
            valueAnimator.addUpdateListener(createAnimatorUpdateListener(animatedDrawable2));
            return valueAnimator;
        }
        return (ValueAnimator) invokeL.objValue;
    }
}
