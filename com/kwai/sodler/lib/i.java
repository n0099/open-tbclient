package com.kwai.sodler.lib;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.sodler.lib.j;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes5.dex */
public final class i extends j {
    public static /* synthetic */ Interceptable $ic;
    public static volatile i a;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile boolean b;
    public j c;
    public ExecutorService d;
    public Map<String, a> e;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final com.kwai.sodler.lib.a.f a;
        public final Future<com.kwai.sodler.lib.a.f> b;

        public a(com.kwai.sodler.lib.a.f fVar, Future<com.kwai.sodler.lib.a.f> future) {
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
            this.b = future;
        }

        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.e();
                this.b.cancel(true);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i() {
        super(null, null, null, null, null, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                super((com.kwai.sodler.lib.a.d) objArr[0], (com.kwai.sodler.lib.a.g) objArr[1], (com.kwai.sodler.lib.a.c) objArr[2], (com.kwai.sodler.lib.a.b) objArr[3], (com.kwai.sodler.lib.ext.c) objArr[4], (com.kwai.sodler.lib.ext.a) objArr[5]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = false;
    }

    @Nullable
    private synchronized a a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, str)) == null) {
            synchronized (this) {
                if (this.b) {
                    Map<String, a> a2 = j.a(this.e);
                    this.e = a2;
                    if (str != null) {
                        return a2.get(str);
                    }
                    return null;
                }
                throw new RuntimeException("Sodler has not yet been init.");
            }
        }
        return (a) invokeL.objValue;
    }

    public static i a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (a == null) {
                synchronized (i.class) {
                    if (a == null) {
                        a = new i();
                    }
                }
            }
            return a;
        }
        return (i) invokeV.objValue;
    }

    private synchronized void a(String str, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, this, str, aVar) == null) {
            synchronized (this) {
                if (!this.b) {
                    throw new RuntimeException("Sodler has not yet been init.");
                }
                Map<String, a> a2 = j.a(this.e);
                this.e = a2;
                if (str != null) {
                    a2.put(str, aVar);
                }
            }
        }
    }

    private a b(@NonNull com.kwai.sodler.lib.a.f fVar, @NonNull j.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, fVar, aVar)) == null) {
            if (this.b) {
                a a2 = a(fVar.i());
                if (a2 != null) {
                    a2.a();
                }
                fVar.a(this);
                a aVar2 = new a(fVar, this.d.submit(new Callable<com.kwai.sodler.lib.a.f>(this, fVar, aVar) { // from class: com.kwai.sodler.lib.i.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ com.kwai.sodler.lib.a.f a;
                    public final /* synthetic */ j.a b;
                    public final /* synthetic */ i c;

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
                        this.c = this;
                        this.a = fVar;
                        this.b = aVar;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: private */
                    @Override // java.util.concurrent.Callable
                    /* renamed from: a */
                    public com.kwai.sodler.lib.a.f call() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeV = interceptable2.invokeV(65537, this)) == null) ? this.c.a(this.a, this.b) : (com.kwai.sodler.lib.a.f) invokeV.objValue;
                    }
                }));
                a(fVar.i(), aVar2);
                return aVar2;
            }
            throw new RuntimeException("Sodler has not yet been init.");
        }
        return (a) invokeLL.objValue;
    }

    public static ExecutorService i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.kwai.sodler.lib.i.1
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
            public final Thread newThread(Runnable runnable) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, runnable)) == null) {
                    return new Thread(runnable, "ksad-Sodler-" + this.a.getAndIncrement());
                }
                return (Thread) invokeL.objValue;
            }
        }) : (ExecutorService) invokeV.objValue;
    }

    private void j() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65542, this) == null) && !this.b) {
            throw new RuntimeException("Sodler has not yet been init.");
        }
    }

    @Override // com.kwai.sodler.lib.j
    public final com.kwai.sodler.lib.a.f a(@NonNull com.kwai.sodler.lib.a.f fVar, @NonNull j.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, fVar, aVar)) == null) {
            if (this.b) {
                com.kwai.sodler.lib.a.e b = fVar.b();
                j jVar = this.c;
                if (b == null) {
                    b = jVar;
                }
                return jVar.a(fVar.a(b), aVar);
            }
            throw new RuntimeException("Sodler has not yet been init.");
        }
        return (com.kwai.sodler.lib.a.f) invokeLL.objValue;
    }

    public final a a(@NonNull com.kwai.sodler.lib.a.f fVar, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar, i)) == null) ? b(fVar, j.a.a(this, 16)) : (a) invokeLI.objValue;
    }

    public final synchronized void a(Context context, @NonNull com.kwai.sodler.lib.ext.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, cVar) == null) {
            synchronized (this) {
                if (!this.b) {
                    d dVar = new d(context);
                    e eVar = new e(context);
                    c cVar2 = new c(context, cVar);
                    b bVar = new b();
                    this.d = i();
                    this.c = new j(dVar, eVar, cVar2, bVar, cVar, new com.kwai.sodler.lib.ext.a());
                    this.b = true;
                    j();
                }
            }
        }
    }

    public final void a(@NonNull com.kwai.sodler.lib.a.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
            a a2 = a(fVar.i());
            if (a2 != null) {
                a2.a();
            }
            a(fVar.i(), (a) null);
        }
    }

    public final com.kwai.sodler.lib.a.e b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.b) {
                return this.c;
            }
            throw new RuntimeException("Sodler has not yet been init.");
        }
        return (com.kwai.sodler.lib.a.e) invokeV.objValue;
    }

    @Override // com.kwai.sodler.lib.j, com.kwai.sodler.lib.a.e
    public final com.kwai.sodler.lib.ext.c c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.b) {
                return this.c.c();
            }
            throw new RuntimeException("Sodler has not yet been init.");
        }
        return (com.kwai.sodler.lib.ext.c) invokeV.objValue;
    }

    @Override // com.kwai.sodler.lib.j, com.kwai.sodler.lib.a.e
    public final com.kwai.sodler.lib.a.d d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.b) {
                return this.c.d();
            }
            throw new RuntimeException("Sodler has not yet been init.");
        }
        return (com.kwai.sodler.lib.a.d) invokeV.objValue;
    }

    @Override // com.kwai.sodler.lib.j, com.kwai.sodler.lib.a.e
    public final com.kwai.sodler.lib.a.g e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.b) {
                return this.c.e();
            }
            throw new RuntimeException("Sodler has not yet been init.");
        }
        return (com.kwai.sodler.lib.a.g) invokeV.objValue;
    }

    @Override // com.kwai.sodler.lib.j, com.kwai.sodler.lib.a.e
    public final com.kwai.sodler.lib.a.c f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.b) {
                return this.c.f();
            }
            throw new RuntimeException("Sodler has not yet been init.");
        }
        return (com.kwai.sodler.lib.a.c) invokeV.objValue;
    }

    @Override // com.kwai.sodler.lib.j, com.kwai.sodler.lib.a.e
    public final com.kwai.sodler.lib.a.b g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.b) {
                return this.c.g();
            }
            throw new RuntimeException("Sodler has not yet been init.");
        }
        return (com.kwai.sodler.lib.a.b) invokeV.objValue;
    }

    @Override // com.kwai.sodler.lib.j, com.kwai.sodler.lib.a.e
    public final com.kwai.sodler.lib.ext.a h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.b) {
                return this.c.h();
            }
            throw new RuntimeException("Sodler has not yet been init.");
        }
        return (com.kwai.sodler.lib.ext.a) invokeV.objValue;
    }
}
