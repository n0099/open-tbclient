package com.kwad.sdk.glide.load.engine;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.glide.g.a.a;
/* loaded from: classes7.dex */
public final class r<Z> implements a.c, s<Z> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Pools.Pool<r<?>> f38152a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final com.kwad.sdk.glide.g.a.c f38153b;

    /* renamed from: c  reason: collision with root package name */
    public s<Z> f38154c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f38155d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f38156e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-469692910, "Lcom/kwad/sdk/glide/load/engine/r;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-469692910, "Lcom/kwad/sdk/glide/load/engine/r;");
                return;
            }
        }
        f38152a = com.kwad.sdk.glide.g.a.a.a(20, new a.InterfaceC0457a<r<?>>() { // from class: com.kwad.sdk.glide.load.engine.r.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.glide.g.a.a.InterfaceC0457a
            /* renamed from: a */
            public r<?> b() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? new r<>() : (r) invokeV.objValue;
            }
        });
    }

    public r() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f38153b = com.kwad.sdk.glide.g.a.c.a();
    }

    @NonNull
    public static <Z> r<Z> a(s<Z> sVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, sVar)) == null) {
            r<Z> rVar = (r) com.kwad.sdk.glide.g.j.a(f38152a.acquire());
            rVar.b(sVar);
            return rVar;
        }
        return (r) invokeL.objValue;
    }

    private void b(s<Z> sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, sVar) == null) {
            this.f38156e = false;
            this.f38155d = true;
            this.f38154c = sVar;
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65540, this) == null) {
            this.f38154c = null;
            f38152a.release(this);
        }
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    @NonNull
    public Class<Z> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f38154c.a() : (Class) invokeV.objValue;
    }

    public synchronized void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                this.f38153b.b();
                if (!this.f38155d) {
                    throw new IllegalStateException("Already unlocked");
                }
                this.f38155d = false;
                if (this.f38156e) {
                    d_();
                }
            }
        }
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f38154c.c() : invokeV.intValue;
    }

    @Override // com.kwad.sdk.glide.g.a.a.c
    @NonNull
    public com.kwad.sdk.glide.g.a.c d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f38153b : (com.kwad.sdk.glide.g.a.c) invokeV.objValue;
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    public synchronized void d_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this) {
                this.f38153b.b();
                this.f38156e = true;
                if (!this.f38155d) {
                    this.f38154c.d_();
                    f();
                }
            }
        }
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    @NonNull
    public Z e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f38154c.e() : (Z) invokeV.objValue;
    }
}
