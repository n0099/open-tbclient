package com.google.android.material.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes10.dex */
public final class SlideDistanceProvider implements VisibilityAnimatorProvider {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_DISTANCE = -1;
    public transient /* synthetic */ FieldHolder $fh;
    @Px
    public int slideDistance;
    public int slideEdge;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes10.dex */
    public @interface GravityFlag {
    }

    public SlideDistanceProvider(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.slideDistance = -1;
        this.slideEdge = i2;
    }

    public static Animator createTranslationAppearAnimator(View view, View view2, int i2, @Px int i3) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(65537, null, view, view2, i2, i3)) == null) {
            if (i2 != 3) {
                if (i2 != 5) {
                    if (i2 != 48) {
                        if (i2 != 80) {
                            if (i2 == 8388611) {
                                return createTranslationXAnimator(view2, isRtl(view) ? i3 : -i3, 0.0f);
                            } else if (i2 == 8388613) {
                                return createTranslationXAnimator(view2, isRtl(view) ? -i3 : i3, 0.0f);
                            } else {
                                throw new IllegalArgumentException("Invalid slide direction: " + i2);
                            }
                        }
                        return createTranslationYAnimator(view2, i3, 0.0f);
                    }
                    return createTranslationYAnimator(view2, -i3, 0.0f);
                }
                return createTranslationXAnimator(view2, -i3, 0.0f);
            }
            return createTranslationXAnimator(view2, i3, 0.0f);
        }
        return (Animator) invokeLLII.objValue;
    }

    public static Animator createTranslationDisappearAnimator(View view, View view2, int i2, @Px int i3) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(65538, null, view, view2, i2, i3)) == null) {
            if (i2 != 3) {
                if (i2 != 5) {
                    if (i2 != 48) {
                        if (i2 != 80) {
                            if (i2 == 8388611) {
                                return createTranslationXAnimator(view2, 0.0f, isRtl(view) ? -i3 : i3);
                            } else if (i2 == 8388613) {
                                return createTranslationXAnimator(view2, 0.0f, isRtl(view) ? i3 : -i3);
                            } else {
                                throw new IllegalArgumentException("Invalid slide direction: " + i2);
                            }
                        }
                        return createTranslationYAnimator(view2, 0.0f, -i3);
                    }
                    return createTranslationYAnimator(view2, 0.0f, i3);
                }
                return createTranslationXAnimator(view2, 0.0f, i3);
            }
            return createTranslationXAnimator(view2, 0.0f, -i3);
        }
        return (Animator) invokeLLII.objValue;
    }

    public static Animator createTranslationXAnimator(View view, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{view, Float.valueOf(f2), Float.valueOf(f3)})) == null) ? ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat(View.TRANSLATION_X, f2, f3)) : (Animator) invokeCommon.objValue;
    }

    public static Animator createTranslationYAnimator(View view, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{view, Float.valueOf(f2), Float.valueOf(f3)})) == null) ? ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, f2, f3)) : (Animator) invokeCommon.objValue;
    }

    private int getSlideDistanceOrDefault(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, context)) == null) {
            int i2 = this.slideDistance;
            return i2 != -1 ? i2 : context.getResources().getDimensionPixelSize(R.dimen.mtrl_transition_shared_axis_slide_distance);
        }
        return invokeL.intValue;
    }

    public static boolean isRtl(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, view)) == null) ? ViewCompat.getLayoutDirection(view) == 1 : invokeL.booleanValue;
    }

    @Override // com.google.android.material.transition.VisibilityAnimatorProvider
    @Nullable
    public Animator createAppear(@NonNull ViewGroup viewGroup, @NonNull View view) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, viewGroup, view)) == null) ? createTranslationAppearAnimator(viewGroup, view, this.slideEdge, getSlideDistanceOrDefault(view.getContext())) : (Animator) invokeLL.objValue;
    }

    @Override // com.google.android.material.transition.VisibilityAnimatorProvider
    @Nullable
    public Animator createDisappear(@NonNull ViewGroup viewGroup, @NonNull View view) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, view)) == null) ? createTranslationDisappearAnimator(viewGroup, view, this.slideEdge, getSlideDistanceOrDefault(view.getContext())) : (Animator) invokeLL.objValue;
    }

    @Px
    public int getSlideDistance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.slideDistance : invokeV.intValue;
    }

    public int getSlideEdge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.slideEdge : invokeV.intValue;
    }

    public void setSlideDistance(@Px int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            if (i2 >= 0) {
                this.slideDistance = i2;
                return;
            }
            throw new IllegalArgumentException("Slide distance must be positive. If attempting to reverse the direction of the slide, use setSlideEdge(int) instead.");
        }
    }

    public void setSlideEdge(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.slideEdge = i2;
        }
    }
}
