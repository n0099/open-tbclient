package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.view.View;
import androidx.core.util.Preconditions;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.animation.MotionSpec;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public abstract class BaseMotionStrategy implements MotionStrategy {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context context;
    public MotionSpec defaultMotionSpec;
    public final ExtendedFloatingActionButton fab;
    public final ArrayList listeners;
    public MotionSpec motionSpec;
    public final AnimatorTracker tracker;

    public BaseMotionStrategy(ExtendedFloatingActionButton extendedFloatingActionButton, AnimatorTracker animatorTracker) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {extendedFloatingActionButton, animatorTracker};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.listeners = new ArrayList();
        this.fab = extendedFloatingActionButton;
        this.context = extendedFloatingActionButton.getContext();
        this.tracker = animatorTracker;
    }

    @Override // com.google.android.material.floatingactionbutton.MotionStrategy
    public final void addAnimationListener(Animator.AnimatorListener animatorListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, animatorListener) == null) {
            this.listeners.add(animatorListener);
        }
    }

    @Override // com.google.android.material.floatingactionbutton.MotionStrategy
    public void onAnimationStart(Animator animator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, animator) == null) {
            this.tracker.onNextAnimationStart(animator);
        }
    }

    @Override // com.google.android.material.floatingactionbutton.MotionStrategy
    public final void removeAnimationListener(Animator.AnimatorListener animatorListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, animatorListener) == null) {
            this.listeners.remove(animatorListener);
        }
    }

    @Override // com.google.android.material.floatingactionbutton.MotionStrategy
    public final void setMotionSpec(MotionSpec motionSpec) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, motionSpec) == null) {
            this.motionSpec = motionSpec;
        }
    }

    @Override // com.google.android.material.floatingactionbutton.MotionStrategy
    public AnimatorSet createAnimator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return createAnimator(getCurrentMotionSpec());
        }
        return (AnimatorSet) invokeV.objValue;
    }

    @Override // com.google.android.material.floatingactionbutton.MotionStrategy
    public final MotionSpec getCurrentMotionSpec() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            MotionSpec motionSpec = this.motionSpec;
            if (motionSpec != null) {
                return motionSpec;
            }
            if (this.defaultMotionSpec == null) {
                this.defaultMotionSpec = MotionSpec.createFromResource(this.context, getDefaultMotionSpecResource());
            }
            return (MotionSpec) Preconditions.checkNotNull(this.defaultMotionSpec);
        }
        return (MotionSpec) invokeV.objValue;
    }

    @Override // com.google.android.material.floatingactionbutton.MotionStrategy
    public final List getListeners() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.listeners;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.google.android.material.floatingactionbutton.MotionStrategy
    public MotionSpec getMotionSpec() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.motionSpec;
        }
        return (MotionSpec) invokeV.objValue;
    }

    @Override // com.google.android.material.floatingactionbutton.MotionStrategy
    public void onAnimationCancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.tracker.clear();
        }
    }

    @Override // com.google.android.material.floatingactionbutton.MotionStrategy
    public void onAnimationEnd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.tracker.clear();
        }
    }

    public AnimatorSet createAnimator(MotionSpec motionSpec) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionSpec)) == null) {
            ArrayList arrayList = new ArrayList();
            if (motionSpec.hasPropertyValues(NativeConstants.OPACITY)) {
                arrayList.add(motionSpec.getAnimator(NativeConstants.OPACITY, this.fab, View.ALPHA));
            }
            if (motionSpec.hasPropertyValues("scale")) {
                arrayList.add(motionSpec.getAnimator("scale", this.fab, View.SCALE_Y));
                arrayList.add(motionSpec.getAnimator("scale", this.fab, View.SCALE_X));
            }
            if (motionSpec.hasPropertyValues("width")) {
                arrayList.add(motionSpec.getAnimator("width", this.fab, ExtendedFloatingActionButton.WIDTH));
            }
            if (motionSpec.hasPropertyValues("height")) {
                arrayList.add(motionSpec.getAnimator("height", this.fab, ExtendedFloatingActionButton.HEIGHT));
            }
            AnimatorSet animatorSet = new AnimatorSet();
            AnimatorSetCompat.playTogether(animatorSet, arrayList);
            return animatorSet;
        }
        return (AnimatorSet) invokeL.objValue;
    }
}
