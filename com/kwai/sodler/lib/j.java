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
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public final class j extends k {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile j f67143a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f67144b;

    /* renamed from: c  reason: collision with root package name */
    public k f67145c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwai.sodler.lib.ext.a f67146d;

    /* renamed from: e  reason: collision with root package name */
    public ExecutorService f67147e;

    /* renamed from: f  reason: collision with root package name */
    public Map<String, b> f67148f;

    /* renamed from: g  reason: collision with root package name */
    public a f67149g;

    /* loaded from: classes2.dex */
    public interface a {
        void a(String str, String str2);
    }

    /* loaded from: classes2.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final com.kwai.sodler.lib.a.f f67154a;

        /* renamed from: b  reason: collision with root package name */
        public final Future<com.kwai.sodler.lib.a.f> f67155b;

        public b(com.kwai.sodler.lib.a.f fVar, Future<com.kwai.sodler.lib.a.f> future) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, future};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f67154a = fVar;
            this.f67155b = future;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f67154a.e();
                this.f67155b.cancel(true);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                super((com.kwai.sodler.lib.a.d) objArr[0], (com.kwai.sodler.lib.a.g) objArr[1], (com.kwai.sodler.lib.a.c) objArr[2], (com.kwai.sodler.lib.a.b) objArr[3], (com.kwai.sodler.lib.ext.c) objArr[4], (com.kwai.sodler.lib.ext.a) objArr[5]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f67144b = false;
    }

    public static j a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f67143a == null) {
                synchronized (j.class) {
                    if (f67143a == null) {
                        f67143a = new j();
                    }
                }
            }
            return f67143a;
        }
        return (j) invokeV.objValue;
    }

    public static ExecutorService i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new ThreadPoolExecutor(0, 2, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.kwai.sodler.lib.j.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final AtomicInteger f67150a;

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
                        return;
                    }
                }
                this.f67150a = new AtomicInteger(1);
            }

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, runnable)) == null) {
                    return new Thread(runnable, "ksad-Sodler-" + this.f67150a.getAndIncrement());
                }
                return (Thread) invokeL.objValue;
            }
        }) : (ExecutorService) invokeV.objValue;
    }

    private void j() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65539, this) == null) && !this.f67144b) {
            throw new RuntimeException("Sodler has not yet been init.");
        }
    }

    @Override // com.kwai.sodler.lib.k
    public com.kwai.sodler.lib.a.f a(@NonNull com.kwai.sodler.lib.a.f fVar, @NonNull k.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, fVar, aVar)) == null) {
            if (this.f67144b) {
                com.kwai.sodler.lib.a.e b2 = fVar.b();
                k kVar = this.f67145c;
                if (b2 == null) {
                    b2 = kVar;
                }
                return kVar.a(fVar.a(b2), aVar);
            }
            throw new RuntimeException("Sodler has not yet been init.");
        }
        return (com.kwai.sodler.lib.a.f) invokeLL.objValue;
    }

    public b a(@NonNull com.kwai.sodler.lib.a.f fVar, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar, i2)) == null) ? b(fVar, k.a.a(this, i2)) : (b) invokeLI.objValue;
    }

    public synchronized void a(Context context, @NonNull com.kwai.sodler.lib.ext.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, cVar) == null) {
            synchronized (this) {
                if (!this.f67144b) {
                    d dVar = new d(context);
                    e eVar = new e(context);
                    c cVar2 = new c(context, cVar);
                    com.kwai.sodler.lib.b bVar = new com.kwai.sodler.lib.b();
                    this.f67146d = new com.kwai.sodler.lib.ext.a();
                    this.f67147e = i();
                    this.f67145c = new k(dVar, eVar, cVar2, bVar, cVar, new com.kwai.sodler.lib.ext.a());
                    this.f67144b = true;
                    j();
                }
            }
        }
    }

    @Override // com.kwai.sodler.lib.k, com.kwai.sodler.lib.a.e
    public com.kwai.sodler.lib.ext.c b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f67144b) {
                return this.f67145c.b();
            }
            throw new RuntimeException("Sodler has not yet been init.");
        }
        return (com.kwai.sodler.lib.ext.c) invokeV.objValue;
    }

    public b b(@NonNull com.kwai.sodler.lib.a.f fVar, @NonNull k.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, fVar, aVar)) == null) {
            if (this.f67144b) {
                Map<String, b> a2 = a(this.f67148f);
                this.f67148f = a2;
                b bVar = a2.get(fVar.i());
                if (bVar != null) {
                    bVar.a();
                }
                fVar.a(this);
                b bVar2 = new b(fVar, this.f67147e.submit(new Callable<com.kwai.sodler.lib.a.f>(this, fVar, aVar) { // from class: com.kwai.sodler.lib.j.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ com.kwai.sodler.lib.a.f f67151a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ k.a f67152b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ j f67153c;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, fVar, aVar};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f67153c = this;
                        this.f67151a = fVar;
                        this.f67152b = aVar;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // java.util.concurrent.Callable
                    /* renamed from: a */
                    public com.kwai.sodler.lib.a.f call() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? this.f67153c.a(this.f67151a, this.f67152b) : (com.kwai.sodler.lib.a.f) invokeV.objValue;
                    }
                }));
                if (fVar.i() != null) {
                    this.f67148f.put(fVar.i(), bVar2);
                }
                return bVar2;
            }
            throw new RuntimeException("Sodler has not yet been init.");
        }
        return (b) invokeLL.objValue;
    }

    @Override // com.kwai.sodler.lib.k, com.kwai.sodler.lib.a.e
    public com.kwai.sodler.lib.a.d c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.f67144b) {
                return this.f67145c.c();
            }
            throw new RuntimeException("Sodler has not yet been init.");
        }
        return (com.kwai.sodler.lib.a.d) invokeV.objValue;
    }

    @Override // com.kwai.sodler.lib.k, com.kwai.sodler.lib.a.e
    public com.kwai.sodler.lib.a.g d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.f67144b) {
                return this.f67145c.d();
            }
            throw new RuntimeException("Sodler has not yet been init.");
        }
        return (com.kwai.sodler.lib.a.g) invokeV.objValue;
    }

    @Override // com.kwai.sodler.lib.k, com.kwai.sodler.lib.a.e
    public com.kwai.sodler.lib.a.c e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.f67144b) {
                return this.f67145c.e();
            }
            throw new RuntimeException("Sodler has not yet been init.");
        }
        return (com.kwai.sodler.lib.a.c) invokeV.objValue;
    }

    @Override // com.kwai.sodler.lib.k, com.kwai.sodler.lib.a.e
    public com.kwai.sodler.lib.a.b f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.f67144b) {
                return this.f67145c.f();
            }
            throw new RuntimeException("Sodler has not yet been init.");
        }
        return (com.kwai.sodler.lib.a.b) invokeV.objValue;
    }

    @Override // com.kwai.sodler.lib.k, com.kwai.sodler.lib.a.e
    public com.kwai.sodler.lib.ext.a g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.f67144b) {
                return this.f67146d;
            }
            throw new RuntimeException("Sodler has not yet been init.");
        }
        return (com.kwai.sodler.lib.ext.a) invokeV.objValue;
    }

    public a h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f67149g : (a) invokeV.objValue;
    }
}
