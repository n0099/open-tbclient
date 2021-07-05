package com.ksad.lottie.d;

import android.view.Choreographer;
import androidx.annotation.FloatRange;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class c extends a implements Choreographer.FrameCallback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @VisibleForTesting

    /* renamed from: a  reason: collision with root package name */
    public boolean f33747a;

    /* renamed from: b  reason: collision with root package name */
    public float f33748b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f33749c;

    /* renamed from: d  reason: collision with root package name */
    public long f33750d;

    /* renamed from: e  reason: collision with root package name */
    public float f33751e;

    /* renamed from: f  reason: collision with root package name */
    public int f33752f;

    /* renamed from: g  reason: collision with root package name */
    public float f33753g;

    /* renamed from: h  reason: collision with root package name */
    public float f33754h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public com.ksad.lottie.d f33755i;

    public c() {
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
        this.f33748b = 1.0f;
        this.f33749c = false;
        this.f33750d = 0L;
        this.f33751e = 0.0f;
        this.f33752f = 0;
        this.f33753g = -2.1474836E9f;
        this.f33754h = 2.1474836E9f;
        this.f33747a = false;
    }

    private float o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            com.ksad.lottie.d dVar = this.f33755i;
            if (dVar == null) {
                return Float.MAX_VALUE;
            }
            return (1.0E9f / dVar.f()) / Math.abs(this.f33748b);
        }
        return invokeV.floatValue;
    }

    private boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) ? h() < 0.0f : invokeV.booleanValue;
    }

    private void q() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65539, this) == null) || this.f33755i == null) {
            return;
        }
        float f2 = this.f33751e;
        if (f2 < this.f33753g || f2 > this.f33754h) {
            throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", Float.valueOf(this.f33753g), Float.valueOf(this.f33754h), Float.valueOf(this.f33751e)));
        }
    }

    public void a(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048576, this, f2) == null) {
            this.f33748b = f2;
        }
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            float f2 = i2;
            if (this.f33751e == f2) {
                return;
            }
            this.f33751e = e.b(f2, k(), l());
            this.f33750d = System.nanoTime();
            c();
        }
    }

    public void a(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            com.ksad.lottie.d dVar = this.f33755i;
            float d2 = dVar == null ? -3.4028235E38f : dVar.d();
            com.ksad.lottie.d dVar2 = this.f33755i;
            float e2 = dVar2 == null ? Float.MAX_VALUE : dVar2.e();
            float f2 = i2;
            this.f33753g = e.b(f2, d2, e2);
            float f3 = i3;
            this.f33754h = e.b(f3, d2, e2);
            a((int) e.b(this.f33751e, f2, f3));
        }
    }

    public void a(com.ksad.lottie.d dVar) {
        int d2;
        float e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, dVar) == null) {
            boolean z = this.f33755i == null;
            this.f33755i = dVar;
            if (z) {
                d2 = (int) Math.max(this.f33753g, dVar.d());
                e2 = Math.min(this.f33754h, dVar.e());
            } else {
                d2 = (int) dVar.d();
                e2 = dVar.e();
            }
            a(d2, (int) e2);
            a((int) this.f33751e);
            this.f33750d = System.nanoTime();
        }
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            a(i2, (int) this.f33754h);
        }
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            a((int) this.f33753g, i2);
        }
    }

    @MainThread
    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            Choreographer.getInstance().removeFrameCallback(this);
            if (z) {
                this.f33747a = false;
            }
        }
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    @MainThread
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            b();
            n();
        }
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            com.ksad.lottie.d dVar = this.f33755i;
            if (dVar == null) {
                return 0.0f;
            }
            return (this.f33751e - dVar.d()) / (this.f33755i.e() - this.f33755i.d());
        }
        return invokeV.floatValue;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048585, this, j) == null) {
            m();
            if (this.f33755i == null || !isRunning()) {
                return;
            }
            long nanoTime = System.nanoTime();
            float o = ((float) (nanoTime - this.f33750d)) / o();
            float f2 = this.f33751e;
            if (p()) {
                o = -o;
            }
            float f3 = f2 + o;
            this.f33751e = f3;
            boolean z = !e.c(f3, k(), l());
            this.f33751e = e.b(this.f33751e, k(), l());
            this.f33750d = nanoTime;
            c();
            if (z) {
                if (getRepeatCount() == -1 || this.f33752f < getRepeatCount()) {
                    a();
                    this.f33752f++;
                    if (getRepeatMode() == 2) {
                        this.f33749c = !this.f33749c;
                        g();
                    } else {
                        this.f33751e = p() ? l() : k();
                    }
                    this.f33750d = nanoTime;
                } else {
                    this.f33751e = l();
                    n();
                    b(p());
                }
            }
            q();
        }
    }

    public float e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f33751e : invokeV.floatValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f33755i = null;
            this.f33753g = -2.1474836E9f;
            this.f33754h = 2.1474836E9f;
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            a(-h());
        }
    }

    @Override // android.animation.ValueAnimator
    @FloatRange(from = 0.0d, to = 1.0d)
    public float getAnimatedFraction() {
        InterceptResult invokeV;
        float f2;
        float k;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (this.f33755i == null) {
                return 0.0f;
            }
            if (p()) {
                f2 = l();
                k = this.f33751e;
            } else {
                f2 = this.f33751e;
                k = k();
            }
            return (f2 - k) / (l() - k());
        }
        return invokeV.floatValue;
    }

    @Override // android.animation.ValueAnimator
    public Object getAnimatedValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? Float.valueOf(d()) : invokeV.objValue;
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            com.ksad.lottie.d dVar = this.f33755i;
            if (dVar == null) {
                return 0L;
            }
            return dVar.c();
        }
        return invokeV.longValue;
    }

    public float h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f33748b : invokeV.floatValue;
    }

    @MainThread
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.f33747a = true;
            a(p());
            a((int) (p() ? l() : k()));
            this.f33750d = System.nanoTime();
            this.f33752f = 0;
            m();
        }
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public boolean isRunning() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f33747a : invokeV.booleanValue;
    }

    @MainThread
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            n();
            b(p());
        }
    }

    public float k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            com.ksad.lottie.d dVar = this.f33755i;
            if (dVar == null) {
                return 0.0f;
            }
            float f2 = this.f33753g;
            return f2 == -2.1474836E9f ? dVar.d() : f2;
        }
        return invokeV.floatValue;
    }

    public float l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            com.ksad.lottie.d dVar = this.f33755i;
            if (dVar == null) {
                return 0.0f;
            }
            float f2 = this.f33754h;
            return f2 == 2.1474836E9f ? dVar.e() : f2;
        }
        return invokeV.floatValue;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && isRunning()) {
            c(false);
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    @MainThread
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            c(true);
        }
    }

    @Override // android.animation.ValueAnimator
    public void setRepeatMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            super.setRepeatMode(i2);
            if (i2 == 2 || !this.f33749c) {
                return;
            }
            this.f33749c = false;
            g();
        }
    }
}
