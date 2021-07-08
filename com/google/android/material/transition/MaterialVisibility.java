package com.google.android.material.transition;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.transition.TransitionValues;
import androidx.transition.Visibility;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.transition.VisibilityAnimatorProvider;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public abstract class MaterialVisibility<P extends VisibilityAnimatorProvider> extends Visibility {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final P primaryAnimatorProvider;
    @Nullable
    public VisibilityAnimatorProvider secondaryAnimatorProvider;

    public MaterialVisibility(P p, @Nullable VisibilityAnimatorProvider visibilityAnimatorProvider) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {p, visibilityAnimatorProvider};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.primaryAnimatorProvider = p;
        this.secondaryAnimatorProvider = visibilityAnimatorProvider;
        setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
    }

    private Animator createAnimator(ViewGroup viewGroup, View view, boolean z) {
        InterceptResult invokeLLZ;
        Animator createDisappear;
        Animator createDisappear2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65537, this, viewGroup, view, z)) == null) {
            AnimatorSet animatorSet = new AnimatorSet();
            ArrayList arrayList = new ArrayList();
            if (z) {
                createDisappear = this.primaryAnimatorProvider.createAppear(viewGroup, view);
            } else {
                createDisappear = this.primaryAnimatorProvider.createDisappear(viewGroup, view);
            }
            if (createDisappear != null) {
                arrayList.add(createDisappear);
            }
            VisibilityAnimatorProvider visibilityAnimatorProvider = this.secondaryAnimatorProvider;
            if (visibilityAnimatorProvider != null) {
                if (z) {
                    createDisappear2 = visibilityAnimatorProvider.createAppear(viewGroup, view);
                } else {
                    createDisappear2 = visibilityAnimatorProvider.createDisappear(viewGroup, view);
                }
                if (createDisappear2 != null) {
                    arrayList.add(createDisappear2);
                }
            }
            AnimatorSetCompat.playTogether(animatorSet, arrayList);
            return animatorSet;
        }
        return (Animator) invokeLLZ.objValue;
    }

    @NonNull
    public P getPrimaryAnimatorProvider() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.primaryAnimatorProvider : (P) invokeV.objValue;
    }

    @Nullable
    public VisibilityAnimatorProvider getSecondaryAnimatorProvider() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.secondaryAnimatorProvider : (VisibilityAnimatorProvider) invokeV.objValue;
    }

    @Override // androidx.transition.Visibility
    public Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, viewGroup, view, transitionValues, transitionValues2)) == null) ? createAnimator(viewGroup, view, true) : (Animator) invokeLLLL.objValue;
    }

    @Override // androidx.transition.Visibility
    public Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, viewGroup, view, transitionValues, transitionValues2)) == null) ? createAnimator(viewGroup, view, false) : (Animator) invokeLLLL.objValue;
    }

    public void setSecondaryAnimatorProvider(@Nullable VisibilityAnimatorProvider visibilityAnimatorProvider) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, visibilityAnimatorProvider) == null) {
            this.secondaryAnimatorProvider = visibilityAnimatorProvider;
        }
    }
}
