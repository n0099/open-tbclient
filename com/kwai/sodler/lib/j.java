package com.kwai.sodler.lib;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.sodler.lib.k;
import com.kwai.sodler.lib.kwai.g;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public final class j extends k {
    public static /* synthetic */ Interceptable $ic;
    public static volatile j a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f41822b;

    /* renamed from: c  reason: collision with root package name */
    public k f41823c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwai.sodler.lib.ext.a f41824d;

    /* renamed from: e  reason: collision with root package name */
    public ExecutorService f41825e;

    /* renamed from: f  reason: collision with root package name */
    public Map<String, b> f41826f;

    /* renamed from: g  reason: collision with root package name */
    public a f41827g;

    /* renamed from: h  reason: collision with root package name */
    public g.a f41828h;

    /* loaded from: classes7.dex */
    public interface a {
        void a(String str, String str2);
    }

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final com.kwai.sodler.lib.kwai.f a;

        /* renamed from: b  reason: collision with root package name */
        public final Future<com.kwai.sodler.lib.kwai.f> f41831b;

        public b(com.kwai.sodler.lib.kwai.f fVar, Future<com.kwai.sodler.lib.kwai.f> future) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, future};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fVar;
            this.f41831b = future;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.e();
                this.f41831b.cancel(true);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j() {
        super(null, null, null, null, null, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                super((com.kwai.sodler.lib.kwai.d) objArr[0], (com.kwai.sodler.lib.kwai.g) objArr[1], (com.kwai.sodler.lib.kwai.c) objArr[2], (com.kwai.sodler.lib.kwai.b) objArr[3], (com.kwai.sodler.lib.ext.c) objArr[4], (com.kwai.sodler.lib.ext.a) objArr[5]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f41822b = false;
    }

    public static j a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (j.class) {
                    if (a == null) {
                        a = new j();
                    }
                }
            }
            return a;
        }
        return (j) invokeV.objValue;
    }

    public static ExecutorService j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new ThreadPoolExecutor(0, 2, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.kwai.sodler.lib.j.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final AtomicInteger a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = new AtomicInteger(1);
            }

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, runnable)) == null) {
                    return new Thread(runnable, "ksad-Sodler-" + this.a.getAndIncrement());
                }
                return (Thread) invokeL.objValue;
            }
        }) : (ExecutorService) invokeV.objValue;
    }

    private void k() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65539, this) == null) && !this.f41822b) {
            throw new RuntimeException("Sodler has not yet been init.");
        }
    }

    public b a(@NonNull com.kwai.sodler.lib.kwai.f fVar, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, fVar, i)) == null) ? b(fVar, k.a.a(this, i)) : (b) invokeLI.objValue;
    }

    @Override // com.kwai.sodler.lib.k
    public com.kwai.sodler.lib.kwai.f a(@NonNull com.kwai.sodler.lib.kwai.f fVar, @NonNull k.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar, aVar)) == null) {
            if (this.f41822b) {
                com.kwai.sodler.lib.kwai.e b2 = fVar.b();
                k kVar = this.f41823c;
                if (b2 == null) {
                    b2 = kVar;
                }
                return kVar.a(fVar.a(b2), aVar);
            }
            throw new RuntimeException("Sodler has not yet been init.");
        }
        return (com.kwai.sodler.lib.kwai.f) invokeLL.objValue;
    }

    public synchronized void a(Context context, @NonNull com.kwai.sodler.lib.ext.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, cVar) == null) {
            synchronized (this) {
                if (!this.f41822b) {
                    d dVar = new d(context);
                    e eVar = new e(context);
                    c cVar2 = new c(context, cVar);
                    com.kwai.sodler.lib.b bVar = new com.kwai.sodler.lib.b();
                    this.f41824d = new com.kwai.sodler.lib.ext.a();
                    this.f41825e = j();
                    this.f41823c = new k(dVar, eVar, cVar2, bVar, cVar, new com.kwai.sodler.lib.ext.a());
                    this.f41822b = true;
                    k();
                }
            }
        }
    }

    public void a(g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            this.f41828h = aVar;
        }
    }

    @Override // com.kwai.sodler.lib.k, com.kwai.sodler.lib.kwai.e
    public com.kwai.sodler.lib.ext.c b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f41822b) {
                return this.f41823c.b();
            }
            throw new RuntimeException("Sodler has not yet been init.");
        }
        return (com.kwai.sodler.lib.ext.c) invokeV.objValue;
    }

    public b b(@NonNull com.kwai.sodler.lib.kwai.f fVar, @NonNull k.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, fVar, aVar)) == null) {
            if (this.f41822b) {
                Map<String, b> a2 = a(this.f41826f);
                this.f41826f = a2;
                b bVar = a2.get(fVar.i());
                if (bVar != null) {
                    bVar.a();
                }
                fVar.a(this);
                b bVar2 = new b(fVar, this.f41825e.submit(new Callable<com.kwai.sodler.lib.kwai.f>(this, fVar, aVar) { // from class: com.kwai.sodler.lib.j.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ com.kwai.sodler.lib.kwai.f a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ k.a f41829b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ j f41830c;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, fVar, aVar};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f41830c = this;
                        this.a = fVar;
                        this.f41829b = aVar;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // java.util.concurrent.Callable
                    /* renamed from: a */
                    public com.kwai.sodler.lib.kwai.f call() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? this.f41830c.a(this.a, this.f41829b) : (com.kwai.sodler.lib.kwai.f) invokeV.objValue;
                    }
                }));
                if (fVar.i() != null) {
                    this.f41826f.put(fVar.i(), bVar2);
                }
                return bVar2;
            }
            throw new RuntimeException("Sodler has not yet been init.");
        }
        return (b) invokeLL.objValue;
    }

    @Override // com.kwai.sodler.lib.k, com.kwai.sodler.lib.kwai.e
    public com.kwai.sodler.lib.kwai.d c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.f41822b) {
                return this.f41823c.c();
            }
            throw new RuntimeException("Sodler has not yet been init.");
        }
        return (com.kwai.sodler.lib.kwai.d) invokeV.objValue;
    }

    @Override // com.kwai.sodler.lib.k, com.kwai.sodler.lib.kwai.e
    public com.kwai.sodler.lib.kwai.g d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.f41822b) {
                return this.f41823c.d();
            }
            throw new RuntimeException("Sodler has not yet been init.");
        }
        return (com.kwai.sodler.lib.kwai.g) invokeV.objValue;
    }

    @Override // com.kwai.sodler.lib.k, com.kwai.sodler.lib.kwai.e
    public com.kwai.sodler.lib.kwai.c e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.f41822b) {
                return this.f41823c.e();
            }
            throw new RuntimeException("Sodler has not yet been init.");
        }
        return (com.kwai.sodler.lib.kwai.c) invokeV.objValue;
    }

    @Override // com.kwai.sodler.lib.k, com.kwai.sodler.lib.kwai.e
    public com.kwai.sodler.lib.kwai.b f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.f41822b) {
                return this.f41823c.f();
            }
            throw new RuntimeException("Sodler has not yet been init.");
        }
        return (com.kwai.sodler.lib.kwai.b) invokeV.objValue;
    }

    @Override // com.kwai.sodler.lib.k, com.kwai.sodler.lib.kwai.e
    public com.kwai.sodler.lib.ext.a g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.f41822b) {
                return this.f41824d;
            }
            throw new RuntimeException("Sodler has not yet been init.");
        }
        return (com.kwai.sodler.lib.ext.a) invokeV.objValue;
    }

    public a h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f41827g : (a) invokeV.objValue;
    }

    public g.a i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f41828h : (g.a) invokeV.objValue;
    }
}
