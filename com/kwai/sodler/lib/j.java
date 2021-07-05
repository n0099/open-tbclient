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
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public final class j extends k {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile j f39806a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f39807b;

    /* renamed from: c  reason: collision with root package name */
    public k f39808c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwai.sodler.lib.ext.a f39809d;

    /* renamed from: e  reason: collision with root package name */
    public ExecutorService f39810e;

    /* renamed from: f  reason: collision with root package name */
    public Map<String, b> f39811f;

    /* renamed from: g  reason: collision with root package name */
    public a f39812g;

    /* loaded from: classes7.dex */
    public interface a {
        void a(String str, String str2);
    }

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final com.kwai.sodler.lib.a.f f39816a;

        /* renamed from: b  reason: collision with root package name */
        public final Future<com.kwai.sodler.lib.a.f> f39817b;

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
            this.f39816a = fVar;
            this.f39817b = future;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f39816a.e();
                this.f39817b.cancel(true);
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
        this.f39807b = false;
    }

    public static j a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f39806a == null) {
                synchronized (j.class) {
                    if (f39806a == null) {
                        f39806a = new j();
                    }
                }
            }
            return f39806a;
        }
        return (j) invokeV.objValue;
    }

    public static ExecutorService i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new ThreadPoolExecutor(1, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue()) : (ExecutorService) invokeV.objValue;
    }

    private void j() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65539, this) == null) && !this.f39807b) {
            throw new RuntimeException("Sodler has not yet been init.");
        }
    }

    @Override // com.kwai.sodler.lib.k
    public com.kwai.sodler.lib.a.f a(@NonNull com.kwai.sodler.lib.a.f fVar, @NonNull k.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, fVar, aVar)) == null) {
            if (this.f39807b) {
                com.kwai.sodler.lib.a.e b2 = fVar.b();
                k kVar = this.f39808c;
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
                if (!this.f39807b) {
                    d dVar = new d(context);
                    e eVar = new e(context);
                    c cVar2 = new c(context, cVar);
                    com.kwai.sodler.lib.b bVar = new com.kwai.sodler.lib.b();
                    this.f39809d = new com.kwai.sodler.lib.ext.a();
                    this.f39810e = i();
                    this.f39808c = new k(dVar, eVar, cVar2, bVar, cVar, new com.kwai.sodler.lib.ext.a());
                    this.f39807b = true;
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
            if (this.f39807b) {
                return this.f39808c.b();
            }
            throw new RuntimeException("Sodler has not yet been init.");
        }
        return (com.kwai.sodler.lib.ext.c) invokeV.objValue;
    }

    public b b(@NonNull com.kwai.sodler.lib.a.f fVar, @NonNull k.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, fVar, aVar)) == null) {
            if (this.f39807b) {
                Map<String, b> a2 = a(this.f39811f);
                this.f39811f = a2;
                b bVar = a2.get(fVar.i());
                if (bVar != null) {
                    bVar.a();
                }
                fVar.a(this);
                b bVar2 = new b(fVar, this.f39810e.submit(new Callable<com.kwai.sodler.lib.a.f>(this, fVar, aVar) { // from class: com.kwai.sodler.lib.j.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ com.kwai.sodler.lib.a.f f39813a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ k.a f39814b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ j f39815c;

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
                        this.f39815c = this;
                        this.f39813a = fVar;
                        this.f39814b = aVar;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // java.util.concurrent.Callable
                    /* renamed from: a */
                    public com.kwai.sodler.lib.a.f call() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? this.f39815c.a(this.f39813a, this.f39814b) : (com.kwai.sodler.lib.a.f) invokeV.objValue;
                    }
                }));
                if (fVar.i() != null) {
                    this.f39811f.put(fVar.i(), bVar2);
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
            if (this.f39807b) {
                return this.f39808c.c();
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
            if (this.f39807b) {
                return this.f39808c.d();
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
            if (this.f39807b) {
                return this.f39808c.e();
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
            if (this.f39807b) {
                return this.f39808c.f();
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
            if (this.f39807b) {
                return this.f39809d;
            }
            throw new RuntimeException("Sodler has not yet been init.");
        }
        return (com.kwai.sodler.lib.ext.a) invokeV.objValue;
    }

    public a h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f39812g : (a) invokeV.objValue;
    }
}
