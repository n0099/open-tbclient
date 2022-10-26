package com.facebook.fresco.animation.backend;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import javax.annotation.Nullable;
/* loaded from: classes7.dex */
public class AnimationBackendDelegate implements AnimationBackend {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ALPHA_UNSET = -1;
    public transient /* synthetic */ FieldHolder $fh;
    public int mAlpha;
    @Nullable
    public AnimationBackend mAnimationBackend;
    @Nullable
    public Rect mBounds;
    @Nullable
    public ColorFilter mColorFilter;

    public AnimationBackendDelegate(@Nullable AnimationBackend animationBackend) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {animationBackend};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mAlpha = -1;
        this.mAnimationBackend = animationBackend;
    }

    private void applyBackendProperties(AnimationBackend animationBackend) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, animationBackend) == null) {
            Rect rect = this.mBounds;
            if (rect != null) {
                animationBackend.setBounds(rect);
            }
            int i = this.mAlpha;
            if (i >= 0 && i <= 255) {
                animationBackend.setAlpha(i);
            }
            ColorFilter colorFilter = this.mColorFilter;
            if (colorFilter != null) {
                animationBackend.setColorFilter(colorFilter);
            }
        }
    }

    @Override // com.facebook.fresco.animation.backend.AnimationInformation
    public int getFrameDurationMs(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            AnimationBackend animationBackend = this.mAnimationBackend;
            if (animationBackend == null) {
                return 0;
            }
            return animationBackend.getFrameDurationMs(i);
        }
        return invokeI.intValue;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public void setAlpha(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            AnimationBackend animationBackend = this.mAnimationBackend;
            if (animationBackend != null) {
                animationBackend.setAlpha(i);
            }
            this.mAlpha = i;
        }
    }

    public void setAnimationBackend(@Nullable AnimationBackend animationBackend) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, animationBackend) == null) {
            this.mAnimationBackend = animationBackend;
            if (animationBackend != null) {
                applyBackendProperties(animationBackend);
            }
        }
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public void setBounds(@Nullable Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, rect) == null) {
            AnimationBackend animationBackend = this.mAnimationBackend;
            if (animationBackend != null) {
                animationBackend.setBounds(rect);
            }
            this.mBounds = rect;
        }
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public void setColorFilter(ColorFilter colorFilter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, colorFilter) == null) {
            AnimationBackend animationBackend = this.mAnimationBackend;
            if (animationBackend != null) {
                animationBackend.setColorFilter(colorFilter);
            }
            this.mColorFilter = colorFilter;
        }
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public void clear() {
        AnimationBackend animationBackend;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (animationBackend = this.mAnimationBackend) != null) {
            animationBackend.clear();
        }
    }

    @Nullable
    public AnimationBackend getAnimationBackend() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mAnimationBackend;
        }
        return (AnimationBackend) invokeV.objValue;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationInformation
    public int getFrameCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            AnimationBackend animationBackend = this.mAnimationBackend;
            if (animationBackend == null) {
                return 0;
            }
            return animationBackend.getFrameCount();
        }
        return invokeV.intValue;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public int getIntrinsicHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            AnimationBackend animationBackend = this.mAnimationBackend;
            if (animationBackend == null) {
                return -1;
            }
            return animationBackend.getIntrinsicHeight();
        }
        return invokeV.intValue;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public int getIntrinsicWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            AnimationBackend animationBackend = this.mAnimationBackend;
            if (animationBackend == null) {
                return -1;
            }
            return animationBackend.getIntrinsicWidth();
        }
        return invokeV.intValue;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationInformation
    public int getLoopCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            AnimationBackend animationBackend = this.mAnimationBackend;
            if (animationBackend == null) {
                return 0;
            }
            return animationBackend.getLoopCount();
        }
        return invokeV.intValue;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public int getSizeInBytes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            AnimationBackend animationBackend = this.mAnimationBackend;
            if (animationBackend == null) {
                return 0;
            }
            return animationBackend.getSizeInBytes();
        }
        return invokeV.intValue;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public boolean drawFrame(Drawable drawable, Canvas canvas, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, drawable, canvas, i)) == null) {
            AnimationBackend animationBackend = this.mAnimationBackend;
            if (animationBackend != null && animationBackend.drawFrame(drawable, canvas, i)) {
                return true;
            }
            return false;
        }
        return invokeLLI.booleanValue;
    }
}
