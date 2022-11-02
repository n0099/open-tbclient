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
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes7.dex */
public final class SlideDistanceProvider implements VisibilityAnimatorProvider {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_DISTANCE = -1;
    public transient /* synthetic */ FieldHolder $fh;
    @Px
    public int slideDistance;
    public int slideEdge;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes7.dex */
    public @interface GravityFlag {
    }

    public SlideDistanceProvider(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.slideDistance = -1;
        this.slideEdge = i;
    }

    public static Animator createTranslationAppearAnimator(View view2, View view3, int i, @Px int i2) {
        InterceptResult invokeLLII;
        float f;
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(65537, null, view2, view3, i, i2)) == null) {
            if (i != 3) {
                if (i != 5) {
                    if (i != 48) {
                        if (i != 80) {
                            if (i != 8388611) {
                                if (i == 8388613) {
                                    if (isRtl(view2)) {
                                        f2 = -i2;
                                    } else {
                                        f2 = i2;
                                    }
                                    return createTranslationXAnimator(view3, f2, 0.0f);
                                }
                                throw new IllegalArgumentException("Invalid slide direction: " + i);
                            }
                            if (isRtl(view2)) {
                                f = i2;
                            } else {
                                f = -i2;
                            }
                            return createTranslationXAnimator(view3, f, 0.0f);
                        }
                        return createTranslationYAnimator(view3, i2, 0.0f);
                    }
                    return createTranslationYAnimator(view3, -i2, 0.0f);
                }
                return createTranslationXAnimator(view3, -i2, 0.0f);
            }
            return createTranslationXAnimator(view3, i2, 0.0f);
        }
        return (Animator) invokeLLII.objValue;
    }

    public static Animator createTranslationDisappearAnimator(View view2, View view3, int i, @Px int i2) {
        InterceptResult invokeLLII;
        float f;
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(65538, null, view2, view3, i, i2)) == null) {
            if (i != 3) {
                if (i != 5) {
                    if (i != 48) {
                        if (i != 80) {
                            if (i != 8388611) {
                                if (i == 8388613) {
                                    if (isRtl(view2)) {
                                        f2 = i2;
                                    } else {
                                        f2 = -i2;
                                    }
                                    return createTranslationXAnimator(view3, 0.0f, f2);
                                }
                                throw new IllegalArgumentException("Invalid slide direction: " + i);
                            }
                            if (isRtl(view2)) {
                                f = -i2;
                            } else {
                                f = i2;
                            }
                            return createTranslationXAnimator(view3, 0.0f, f);
                        }
                        return createTranslationYAnimator(view3, 0.0f, -i2);
                    }
                    return createTranslationYAnimator(view3, 0.0f, i2);
                }
                return createTranslationXAnimator(view3, 0.0f, i2);
            }
            return createTranslationXAnimator(view3, 0.0f, -i2);
        }
        return (Animator) invokeLLII.objValue;
    }

    public static Animator createTranslationXAnimator(View view2, float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{view2, Float.valueOf(f), Float.valueOf(f2)})) == null) {
            return ObjectAnimator.ofPropertyValuesHolder(view2, PropertyValuesHolder.ofFloat(View.TRANSLATION_X, f, f2));
        }
        return (Animator) invokeCommon.objValue;
    }

    public static Animator createTranslationYAnimator(View view2, float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{view2, Float.valueOf(f), Float.valueOf(f2)})) == null) {
            return ObjectAnimator.ofPropertyValuesHolder(view2, PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, f, f2));
        }
        return (Animator) invokeCommon.objValue;
    }

    private int getSlideDistanceOrDefault(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, context)) == null) {
            int i = this.slideDistance;
            if (i != -1) {
                return i;
            }
            return context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0704e6);
        }
        return invokeL.intValue;
    }

    public static boolean isRtl(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, view2)) == null) {
            if (ViewCompat.getLayoutDirection(view2) == 1) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void setSlideDistance(@Px int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            if (i >= 0) {
                this.slideDistance = i;
                return;
            }
            throw new IllegalArgumentException("Slide distance must be positive. If attempting to reverse the direction of the slide, use setSlideEdge(int) instead.");
        }
    }

    public void setSlideEdge(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.slideEdge = i;
        }
    }

    @Override // com.google.android.material.transition.VisibilityAnimatorProvider
    @Nullable
    public Animator createAppear(@NonNull ViewGroup viewGroup, @NonNull View view2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, viewGroup, view2)) == null) {
            return createTranslationAppearAnimator(viewGroup, view2, this.slideEdge, getSlideDistanceOrDefault(view2.getContext()));
        }
        return (Animator) invokeLL.objValue;
    }

    @Override // com.google.android.material.transition.VisibilityAnimatorProvider
    @Nullable
    public Animator createDisappear(@NonNull ViewGroup viewGroup, @NonNull View view2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, view2)) == null) {
            return createTranslationDisappearAnimator(viewGroup, view2, this.slideEdge, getSlideDistanceOrDefault(view2.getContext()));
        }
        return (Animator) invokeLL.objValue;
    }

    @Px
    public int getSlideDistance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.slideDistance;
        }
        return invokeV.intValue;
    }

    public int getSlideEdge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.slideEdge;
        }
        return invokeV.intValue;
    }
}
