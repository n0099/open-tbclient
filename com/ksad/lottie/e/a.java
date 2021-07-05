package com.ksad.lottie.e;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class a<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public final T f33774a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public final T f33775b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public final Interpolator f33776c;

    /* renamed from: d  reason: collision with root package name */
    public final float f33777d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public Float f33778e;

    /* renamed from: f  reason: collision with root package name */
    public PointF f33779f;

    /* renamed from: g  reason: collision with root package name */
    public PointF f33780g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public final com.ksad.lottie.d f33781h;

    /* renamed from: i  reason: collision with root package name */
    public float f33782i;
    public float j;

    public a(com.ksad.lottie.d dVar, @Nullable T t, @Nullable T t2, @Nullable Interpolator interpolator, float f2, @Nullable Float f3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dVar, t, t2, interpolator, Float.valueOf(f2), f3};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f33782i = Float.MIN_VALUE;
        this.j = Float.MIN_VALUE;
        this.f33779f = null;
        this.f33780g = null;
        this.f33781h = dVar;
        this.f33774a = t;
        this.f33775b = t2;
        this.f33776c = interpolator;
        this.f33777d = f2;
        this.f33778e = f3;
    }

    public a(T t) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {t};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f33782i = Float.MIN_VALUE;
        this.j = Float.MIN_VALUE;
        this.f33779f = null;
        this.f33780g = null;
        this.f33781h = null;
        this.f33774a = t;
        this.f33775b = t;
        this.f33776c = null;
        this.f33777d = Float.MIN_VALUE;
        this.f33778e = Float.valueOf(Float.MAX_VALUE);
    }

    public boolean a(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f2)) == null) ? f2 >= b() && f2 < c() : invokeF.booleanValue;
    }

    public float b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            com.ksad.lottie.d dVar = this.f33781h;
            if (dVar == null) {
                return 0.0f;
            }
            if (this.f33782i == Float.MIN_VALUE) {
                this.f33782i = (this.f33777d - dVar.d()) / this.f33781h.k();
            }
            return this.f33782i;
        }
        return invokeV.floatValue;
    }

    public float c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f33781h == null) {
                return 1.0f;
            }
            if (this.j == Float.MIN_VALUE) {
                if (this.f33778e == null) {
                    this.j = 1.0f;
                } else {
                    this.j = b() + ((this.f33778e.floatValue() - this.f33777d) / this.f33781h.k());
                }
            }
            return this.j;
        }
        return invokeV.floatValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f33776c == null : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return "Keyframe{startValue=" + this.f33774a + ", endValue=" + this.f33775b + ", startFrame=" + this.f33777d + ", endFrame=" + this.f33778e + ", interpolator=" + this.f33776c + '}';
        }
        return (String) invokeV.objValue;
    }
}
