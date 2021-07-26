package com.sdk.base.framework.a.c;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class a<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public a<T> f38278a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f38279b;

    /* renamed from: c  reason: collision with root package name */
    public k<?> f38280c;

    public a(T t) {
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
        this.f38279b = false;
        a(t);
    }

    public final int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f38280c.f38305a : invokeV.intValue;
    }

    public final void a(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
            if (t == null) {
                this.f38280c = null;
            } else if (!(t instanceof k)) {
                this.f38280c = new k<>(b.f38281a, t);
            } else {
                this.f38280c = (k) t;
                this.f38279b = true;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [T, com.sdk.base.framework.a.c.k<?>, com.sdk.base.framework.a.c.k] */
    public final T b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ?? r0 = (T) this.f38280c;
            if (r0 == 0) {
                return null;
            }
            return this.f38279b ? r0 : (T) r0.f38306b;
        }
        return (T) invokeV.objValue;
    }
}
