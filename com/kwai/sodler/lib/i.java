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
/* loaded from: classes8.dex */
public final class i extends j {
    public static /* synthetic */ Interceptable $ic;
    public static volatile i axl;
    public transient /* synthetic */ FieldHolder $fh;
    public j axm;
    public ExecutorService axn;
    public Map<String, a> axo;
    public volatile boolean mHasInit;

    /* loaded from: classes8.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Future<com.kwai.sodler.lib.a.f> VO;
        public final com.kwai.sodler.lib.a.f axr;

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
            this.axr = fVar;
            this.VO = future;
        }

        public final void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.axr.cancel();
                this.VO.cancel(true);
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
        this.mHasInit = false;
    }

    public static i EU() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (axl == null) {
                synchronized (i.class) {
                    if (axl == null) {
                        axl = new i();
                    }
                }
            }
            return axl;
        }
        return (i) invokeV.objValue;
    }

    public static ExecutorService EV() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.kwai.sodler.lib.i.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final AtomicInteger poolNumber;

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
                this.poolNumber = new AtomicInteger(1);
            }

            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, runnable)) == null) {
                    return new Thread(runnable, "ksad-Sodler-" + this.poolNumber.getAndIncrement());
                }
                return (Thread) invokeL.objValue;
            }
        }) : (ExecutorService) invokeV.objValue;
    }

    private void Fd() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65539, this) == null) && !this.mHasInit) {
            throw new RuntimeException("Sodler has not yet been init.");
        }
    }

    private synchronized void a(String str, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, str, aVar) == null) {
            synchronized (this) {
                if (!this.mHasInit) {
                    throw new RuntimeException("Sodler has not yet been init.");
                }
                Map<String, a> e = j.e(this.axo);
                this.axo = e;
                if (str != null) {
                    e.put(str, aVar);
                }
            }
        }
    }

    private a b(@NonNull com.kwai.sodler.lib.a.f fVar, @NonNull j.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, this, fVar, aVar)) == null) {
            if (this.mHasInit) {
                a eR = eR(fVar.getId());
                if (eR != null) {
                    eR.cancel();
                }
                fVar.a(this);
                a aVar2 = new a(fVar, this.axn.submit(new Callable<com.kwai.sodler.lib.a.f>(this, fVar, aVar) { // from class: com.kwai.sodler.lib.i.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ com.kwai.sodler.lib.a.f axb;
                    public final /* synthetic */ j.a axp;
                    public final /* synthetic */ i axq;

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
                        this.axq = this;
                        this.axb = fVar;
                        this.axp = aVar;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: private */
                    @Override // java.util.concurrent.Callable
                    /* renamed from: Fe */
                    public com.kwai.sodler.lib.a.f call() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeV = interceptable2.invokeV(65537, this)) == null) ? this.axq.a(this.axb, this.axp) : (com.kwai.sodler.lib.a.f) invokeV.objValue;
                    }
                }));
                a(fVar.getId(), aVar2);
                return aVar2;
            }
            throw new RuntimeException("Sodler has not yet been init.");
        }
        return (a) invokeLL.objValue;
    }

    @Nullable
    private synchronized a eR(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, str)) == null) {
            synchronized (this) {
                if (this.mHasInit) {
                    Map<String, a> e = j.e(this.axo);
                    this.axo = e;
                    if (str != null) {
                        return e.get(str);
                    }
                    return null;
                }
                throw new RuntimeException("Sodler has not yet been init.");
            }
        }
        return (a) invokeL.objValue;
    }

    public final com.kwai.sodler.lib.a.e EW() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.mHasInit) {
                return this.axm;
            }
            throw new RuntimeException("Sodler has not yet been init.");
        }
        return (com.kwai.sodler.lib.a.e) invokeV.objValue;
    }

    @Override // com.kwai.sodler.lib.j, com.kwai.sodler.lib.a.e
    public final com.kwai.sodler.lib.ext.c EX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.mHasInit) {
                return this.axm.EX();
            }
            throw new RuntimeException("Sodler has not yet been init.");
        }
        return (com.kwai.sodler.lib.ext.c) invokeV.objValue;
    }

    @Override // com.kwai.sodler.lib.j, com.kwai.sodler.lib.a.e
    public final com.kwai.sodler.lib.a.d EY() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.mHasInit) {
                return this.axm.EY();
            }
            throw new RuntimeException("Sodler has not yet been init.");
        }
        return (com.kwai.sodler.lib.a.d) invokeV.objValue;
    }

    @Override // com.kwai.sodler.lib.j, com.kwai.sodler.lib.a.e
    public final com.kwai.sodler.lib.a.g EZ() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.mHasInit) {
                return this.axm.EZ();
            }
            throw new RuntimeException("Sodler has not yet been init.");
        }
        return (com.kwai.sodler.lib.a.g) invokeV.objValue;
    }

    @Override // com.kwai.sodler.lib.j, com.kwai.sodler.lib.a.e
    public final com.kwai.sodler.lib.a.c Fa() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.mHasInit) {
                return this.axm.Fa();
            }
            throw new RuntimeException("Sodler has not yet been init.");
        }
        return (com.kwai.sodler.lib.a.c) invokeV.objValue;
    }

    @Override // com.kwai.sodler.lib.j, com.kwai.sodler.lib.a.e
    public final com.kwai.sodler.lib.a.b Fb() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.mHasInit) {
                return this.axm.Fb();
            }
            throw new RuntimeException("Sodler has not yet been init.");
        }
        return (com.kwai.sodler.lib.a.b) invokeV.objValue;
    }

    @Override // com.kwai.sodler.lib.j, com.kwai.sodler.lib.a.e
    public final com.kwai.sodler.lib.ext.a Fc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.mHasInit) {
                return this.axm.Fc();
            }
            throw new RuntimeException("Sodler has not yet been init.");
        }
        return (com.kwai.sodler.lib.ext.a) invokeV.objValue;
    }

    @Override // com.kwai.sodler.lib.j
    public final com.kwai.sodler.lib.a.f a(@NonNull com.kwai.sodler.lib.a.f fVar, @NonNull j.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, fVar, aVar)) == null) {
            if (this.mHasInit) {
                com.kwai.sodler.lib.a.e Fk = fVar.Fk();
                j jVar = this.axm;
                if (Fk == null) {
                    Fk = jVar;
                }
                return jVar.a(fVar.a(Fk), aVar);
            }
            throw new RuntimeException("Sodler has not yet been init.");
        }
        return (com.kwai.sodler.lib.a.f) invokeLL.objValue;
    }

    public final a a(@NonNull com.kwai.sodler.lib.a.f fVar, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, fVar, i)) == null) ? b(fVar, j.a.a(this, 16)) : (a) invokeLI.objValue;
    }

    public final synchronized void a(Context context, @NonNull com.kwai.sodler.lib.ext.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, context, cVar) == null) {
            synchronized (this) {
                if (!this.mHasInit) {
                    d dVar = new d(context);
                    e eVar = new e(context);
                    c cVar2 = new c(context, cVar);
                    b bVar = new b();
                    this.axn = EV();
                    this.axm = new j(dVar, eVar, cVar2, bVar, cVar, new com.kwai.sodler.lib.ext.a());
                    this.mHasInit = true;
                    Fd();
                }
            }
        }
    }

    public final void l(@NonNull com.kwai.sodler.lib.a.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, fVar) == null) {
            a eR = eR(fVar.getId());
            if (eR != null) {
                eR.cancel();
            }
            a(fVar.getId(), (a) null);
        }
    }
}
