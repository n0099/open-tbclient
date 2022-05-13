package com.google.android.material.transition;

import android.animation.Animator;
import android.animation.ValueAnimator;
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
/* loaded from: classes4.dex */
public final class Hold extends Visibility {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public Hold() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // androidx.transition.Visibility
    @NonNull
    public Animator onAppear(@NonNull ViewGroup viewGroup, @NonNull View view2, @Nullable TransitionValues transitionValues, @Nullable TransitionValues transitionValues2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, viewGroup, view2, transitionValues, transitionValues2)) == null) ? ValueAnimator.ofFloat(0.0f) : (Animator) invokeLLLL.objValue;
    }

    @Override // androidx.transition.Visibility
    @NonNull
    public Animator onDisappear(@NonNull ViewGroup viewGroup, @NonNull View view2, @Nullable TransitionValues transitionValues, @Nullable TransitionValues transitionValues2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, view2, transitionValues, transitionValues2)) == null) ? ValueAnimator.ofFloat(0.0f) : (Animator) invokeLLLL.objValue;
    }
}
