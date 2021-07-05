package com.ksad.lottie.e;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class c<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public T f33790a;

    /* renamed from: b  reason: collision with root package name */
    public final b<T> f33791b;

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final T a(float f2, float f3, T t, T t2, float f4, float f5, float f6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), t, t2, Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6)})) == null) ? a(this.f33791b.a(f2, f3, t, t2, f4, f5, f6)) : (T) invokeCommon.objValue;
    }

    @Nullable
    public T a(b<T> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar)) == null) ? this.f33790a : (T) invokeL.objValue;
    }
}
