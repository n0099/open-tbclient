package com.google.android.material.transition;

import android.animation.Animator;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.transition.TransitionValues;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public final class MaterialElevationScale extends MaterialVisibility<ScaleProvider> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final float DEFAULT_SCALE = 0.85f;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean growing;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaterialElevationScale(boolean z) {
        super(createPrimaryAnimatorProvider(z), createSecondaryAnimatorProvider());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((VisibilityAnimatorProvider) objArr2[0], (VisibilityAnimatorProvider) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.growing = z;
    }

    public static ScaleProvider createPrimaryAnimatorProvider(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65537, null, z)) == null) {
            ScaleProvider scaleProvider = new ScaleProvider(z);
            scaleProvider.setOutgoingEndScale(0.85f);
            scaleProvider.setIncomingStartScale(0.85f);
            return scaleProvider;
        }
        return (ScaleProvider) invokeZ.objValue;
    }

    @Override // com.google.android.material.transition.MaterialVisibility
    public /* bridge */ /* synthetic */ void setSecondaryAnimatorProvider(@Nullable VisibilityAnimatorProvider visibilityAnimatorProvider) {
        super.setSecondaryAnimatorProvider(visibilityAnimatorProvider);
    }

    public static VisibilityAnimatorProvider createSecondaryAnimatorProvider() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return new FadeProvider();
        }
        return (VisibilityAnimatorProvider) invokeV.objValue;
    }

    @Override // com.google.android.material.transition.MaterialVisibility
    @Nullable
    public /* bridge */ /* synthetic */ VisibilityAnimatorProvider getSecondaryAnimatorProvider() {
        return super.getSecondaryAnimatorProvider();
    }

    public boolean isGrowing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.growing;
        }
        return invokeV.booleanValue;
    }

    @Override // com.google.android.material.transition.MaterialVisibility, androidx.transition.Visibility
    public /* bridge */ /* synthetic */ Animator onAppear(ViewGroup viewGroup, View view2, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return super.onAppear(viewGroup, view2, transitionValues, transitionValues2);
    }

    @Override // com.google.android.material.transition.MaterialVisibility, androidx.transition.Visibility
    public /* bridge */ /* synthetic */ Animator onDisappear(ViewGroup viewGroup, View view2, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return super.onDisappear(viewGroup, view2, transitionValues, transitionValues2);
    }
}
