package com.kwad.sdk.glide.g.a;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.util.pool.FactoryPools;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final d<Object> f37747a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.kwad.sdk.glide.g.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0457a<T> {
        T b();
    }

    /* loaded from: classes7.dex */
    public static final class b<T> implements Pools.Pool<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final InterfaceC0457a<T> f37748a;

        /* renamed from: b  reason: collision with root package name */
        public final d<T> f37749b;

        /* renamed from: c  reason: collision with root package name */
        public final Pools.Pool<T> f37750c;

        public b(@NonNull Pools.Pool<T> pool, @NonNull InterfaceC0457a<T> interfaceC0457a, @NonNull d<T> dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pool, interfaceC0457a, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f37750c = pool;
            this.f37748a = interfaceC0457a;
            this.f37749b = dVar;
        }

        @Override // androidx.core.util.Pools.Pool
        public T acquire() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                T acquire = this.f37750c.acquire();
                if (acquire == null) {
                    acquire = this.f37748a.b();
                    if (Log.isLoggable(FactoryPools.TAG, 2)) {
                        Log.v(FactoryPools.TAG, "Created new " + acquire.getClass());
                    }
                }
                if (acquire instanceof c) {
                    ((c) acquire).d().a(false);
                }
                return acquire;
            }
            return (T) invokeV.objValue;
        }

        @Override // androidx.core.util.Pools.Pool
        public boolean release(@NonNull T t) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t)) == null) {
                if (t instanceof c) {
                    ((c) t).d().a(true);
                }
                this.f37749b.a(t);
                return this.f37750c.release(t);
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public interface c {
        @NonNull
        com.kwad.sdk.glide.g.a.c d();
    }

    /* loaded from: classes7.dex */
    public interface d<T> {
        void a(@NonNull T t);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1176598251, "Lcom/kwad/sdk/glide/g/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1176598251, "Lcom/kwad/sdk/glide/g/a/a;");
                return;
            }
        }
        f37747a = new d<Object>() { // from class: com.kwad.sdk.glide.g.a.a.1
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

            @Override // com.kwad.sdk.glide.g.a.a.d
            public void a(@NonNull Object obj) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                }
            }
        };
    }

    @NonNull
    public static <T> Pools.Pool<List<T>> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? a(20) : (Pools.Pool) invokeV.objValue;
    }

    @NonNull
    public static <T> Pools.Pool<List<T>> a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) ? a(new Pools.SynchronizedPool(i2), new InterfaceC0457a<List<T>>() { // from class: com.kwad.sdk.glide.g.a.a.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.glide.g.a.a.InterfaceC0457a
            @NonNull
            /* renamed from: a */
            public List<T> b() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? new ArrayList() : (List) invokeV.objValue;
            }
        }, new d<List<T>>() { // from class: com.kwad.sdk.glide.g.a.a.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.glide.g.a.a.d
            public void a(@NonNull List<T> list) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                    list.clear();
                }
            }
        }) : (Pools.Pool) invokeI.objValue;
    }

    @NonNull
    public static <T extends c> Pools.Pool<T> a(int i2, @NonNull InterfaceC0457a<T> interfaceC0457a) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(65539, null, i2, interfaceC0457a)) == null) ? a(new Pools.SynchronizedPool(i2), interfaceC0457a) : (Pools.Pool) invokeIL.objValue;
    }

    @NonNull
    public static <T extends c> Pools.Pool<T> a(@NonNull Pools.Pool<T> pool, @NonNull InterfaceC0457a<T> interfaceC0457a) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65540, null, pool, interfaceC0457a)) == null) ? a(pool, interfaceC0457a, b()) : (Pools.Pool) invokeLL.objValue;
    }

    @NonNull
    public static <T> Pools.Pool<T> a(@NonNull Pools.Pool<T> pool, @NonNull InterfaceC0457a<T> interfaceC0457a, @NonNull d<T> dVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, null, pool, interfaceC0457a, dVar)) == null) ? new b(pool, interfaceC0457a, dVar) : (Pools.Pool) invokeLLL.objValue;
    }

    @NonNull
    public static <T> d<T> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? (d<T>) f37747a : (d) invokeV.objValue;
    }
}
