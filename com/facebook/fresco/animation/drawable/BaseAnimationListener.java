package com.facebook.fresco.animation.drawable;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class BaseAnimationListener implements AnimationListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public BaseAnimationListener() {
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

    @Override // com.facebook.fresco.animation.drawable.AnimationListener
    public void onAnimationFrame(AnimatedDrawable2 animatedDrawable2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, animatedDrawable2, i2) == null) {
        }
    }

    @Override // com.facebook.fresco.animation.drawable.AnimationListener
    public void onAnimationRepeat(AnimatedDrawable2 animatedDrawable2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animatedDrawable2) == null) {
        }
    }

    @Override // com.facebook.fresco.animation.drawable.AnimationListener
    public void onAnimationReset(AnimatedDrawable2 animatedDrawable2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animatedDrawable2) == null) {
        }
    }

    @Override // com.facebook.fresco.animation.drawable.AnimationListener
    public void onAnimationStart(AnimatedDrawable2 animatedDrawable2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, animatedDrawable2) == null) {
        }
    }

    @Override // com.facebook.fresco.animation.drawable.AnimationListener
    public void onAnimationStop(AnimatedDrawable2 animatedDrawable2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, animatedDrawable2) == null) {
        }
    }
}
