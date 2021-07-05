package com.ksad.lottie.d;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
/* loaded from: classes7.dex */
public abstract class a extends ValueAnimator {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Set<ValueAnimator.AnimatorUpdateListener> f33745a;

    /* renamed from: b  reason: collision with root package name */
    public final Set<Animator.AnimatorListener> f33746b;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f33745a = new CopyOnWriteArraySet();
        this.f33746b = new CopyOnWriteArraySet();
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            for (Animator.AnimatorListener animatorListener : this.f33746b) {
                animatorListener.onAnimationRepeat(this);
            }
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            for (Animator.AnimatorListener animatorListener : this.f33746b) {
                if (Build.VERSION.SDK_INT >= 26) {
                    animatorListener.onAnimationStart(this, z);
                } else {
                    animatorListener.onAnimationStart(this);
                }
            }
        }
    }

    @Override // android.animation.Animator
    public void addListener(Animator.AnimatorListener animatorListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animatorListener) == null) {
            this.f33746b.add(animatorListener);
        }
    }

    @Override // android.animation.ValueAnimator
    public void addUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, animatorUpdateListener) == null) {
            this.f33745a.add(animatorUpdateListener);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            for (Animator.AnimatorListener animatorListener : this.f33746b) {
                animatorListener.onAnimationCancel(this);
            }
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            for (Animator.AnimatorListener animatorListener : this.f33746b) {
                if (Build.VERSION.SDK_INT >= 26) {
                    animatorListener.onAnimationEnd(this, z);
                } else {
                    animatorListener.onAnimationEnd(this);
                }
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            for (ValueAnimator.AnimatorUpdateListener animatorUpdateListener : this.f33745a) {
                animatorUpdateListener.onAnimationUpdate(this);
            }
        }
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getStartDelay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            throw new UnsupportedOperationException("LottieAnimator does not support getStartDelay.");
        }
        return invokeV.longValue;
    }

    @Override // android.animation.Animator
    public void removeAllListeners() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f33746b.clear();
        }
    }

    @Override // android.animation.ValueAnimator
    public void removeAllUpdateListeners() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f33745a.clear();
        }
    }

    @Override // android.animation.Animator
    public void removeListener(Animator.AnimatorListener animatorListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, animatorListener) == null) {
            this.f33746b.remove(animatorListener);
        }
    }

    @Override // android.animation.ValueAnimator
    public void removeUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, animatorUpdateListener) == null) {
            this.f33745a.remove(animatorUpdateListener);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.animation.ValueAnimator, android.animation.Animator
    public ValueAnimator setDuration(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048589, this, j)) == null) {
            throw new UnsupportedOperationException("LottieAnimator does not support setDuration.");
        }
        return (ValueAnimator) invokeJ.objValue;
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public void setInterpolator(TimeInterpolator timeInterpolator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, timeInterpolator) == null) {
            throw new UnsupportedOperationException("LottieAnimator does not support setInterpolator.");
        }
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public void setStartDelay(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048591, this, j) == null) {
            throw new UnsupportedOperationException("LottieAnimator does not support setStartDelay.");
        }
    }
}
