package com.facebook.fresco.animation.backend;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.annotation.IntRange;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.fresco.animation.backend.AnimationBackend;
import javax.annotation.Nullable;
/* loaded from: classes7.dex */
public class AnimationBackendDelegate<T extends AnimationBackend> implements AnimationBackend {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ALPHA_UNSET = -1;
    public transient /* synthetic */ FieldHolder $fh;
    @IntRange(from = -1, to = 255)
    public int mAlpha;
    @Nullable
    public T mAnimationBackend;
    @Nullable
    public Rect mBounds;
    @Nullable
    public ColorFilter mColorFilter;

    public AnimationBackendDelegate(@Nullable T t) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {t};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mAlpha = -1;
        this.mAnimationBackend = t;
    }

    @SuppressLint({"Range"})
    private void applyBackendProperties(AnimationBackend animationBackend) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, animationBackend) == null) {
            Rect rect = this.mBounds;
            if (rect != null) {
                animationBackend.setBounds(rect);
            }
            int i2 = this.mAlpha;
            if (i2 >= 0 && i2 <= 255) {
                animationBackend.setAlpha(i2);
            }
            ColorFilter colorFilter = this.mColorFilter;
            if (colorFilter != null) {
                animationBackend.setColorFilter(colorFilter);
            }
        }
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public void clear() {
        T t;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (t = this.mAnimationBackend) == null) {
            return;
        }
        t.clear();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public boolean drawFrame(Drawable drawable, Canvas canvas, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, drawable, canvas, i2)) == null) {
            T t = this.mAnimationBackend;
            return t != null && t.drawFrame(drawable, canvas, i2);
        }
        return invokeLLI.booleanValue;
    }

    @Nullable
    public T getAnimationBackend() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mAnimationBackend : (T) invokeV.objValue;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationInformation
    public int getFrameCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            T t = this.mAnimationBackend;
            if (t == null) {
                return 0;
            }
            return t.getFrameCount();
        }
        return invokeV.intValue;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationInformation
    public int getFrameDurationMs(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            T t = this.mAnimationBackend;
            if (t == null) {
                return 0;
            }
            return t.getFrameDurationMs(i2);
        }
        return invokeI.intValue;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public int getIntrinsicHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            T t = this.mAnimationBackend;
            if (t == null) {
                return -1;
            }
            return t.getIntrinsicHeight();
        }
        return invokeV.intValue;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public int getIntrinsicWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            T t = this.mAnimationBackend;
            if (t == null) {
                return -1;
            }
            return t.getIntrinsicWidth();
        }
        return invokeV.intValue;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationInformation
    public int getLoopCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            T t = this.mAnimationBackend;
            if (t == null) {
                return 0;
            }
            return t.getLoopCount();
        }
        return invokeV.intValue;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public int getSizeInBytes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            T t = this.mAnimationBackend;
            if (t == null) {
                return 0;
            }
            return t.getSizeInBytes();
        }
        return invokeV.intValue;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public void setAlpha(@IntRange(from = 0, to = 255) int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            T t = this.mAnimationBackend;
            if (t != null) {
                t.setAlpha(i2);
            }
            this.mAlpha = i2;
        }
    }

    public void setAnimationBackend(@Nullable T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, t) == null) {
            this.mAnimationBackend = t;
            if (t != null) {
                applyBackendProperties(t);
            }
        }
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public void setBounds(@Nullable Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, rect) == null) {
            T t = this.mAnimationBackend;
            if (t != null) {
                t.setBounds(rect);
            }
            this.mBounds = rect;
        }
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public void setColorFilter(ColorFilter colorFilter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, colorFilter) == null) {
            T t = this.mAnimationBackend;
            if (t != null) {
                t.setColorFilter(colorFilter);
            }
            this.mColorFilter = colorFilter;
        }
    }
}
