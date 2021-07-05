package com.ksad.lottie.e;

import androidx.annotation.RestrictTo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class b<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public float f33783a;

    /* renamed from: b  reason: collision with root package name */
    public float f33784b;

    /* renamed from: c  reason: collision with root package name */
    public T f33785c;

    /* renamed from: d  reason: collision with root package name */
    public T f33786d;

    /* renamed from: e  reason: collision with root package name */
    public float f33787e;

    /* renamed from: f  reason: collision with root package name */
    public float f33788f;

    /* renamed from: g  reason: collision with root package name */
    public float f33789g;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public b<T> a(float f2, float f3, T t, T t2, float f4, float f5, float f6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), t, t2, Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6)})) == null) {
            this.f33783a = f2;
            this.f33784b = f3;
            this.f33785c = t;
            this.f33786d = t2;
            this.f33787e = f4;
            this.f33788f = f5;
            this.f33789g = f6;
            return this;
        }
        return (b) invokeCommon.objValue;
    }
}
