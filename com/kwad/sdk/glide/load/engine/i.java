package com.kwad.sdk.glide.load.engine;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
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
import com.bumptech.glide.load.engine.Engine;
import com.kwad.sdk.glide.Priority;
import com.kwad.sdk.glide.g.a.a;
import com.kwad.sdk.glide.load.DataSource;
import com.kwad.sdk.glide.load.engine.DecodeJob;
import com.kwad.sdk.glide.load.engine.a.a;
import com.kwad.sdk.glide.load.engine.a.h;
import com.kwad.sdk.glide.load.engine.n;
import java.util.Map;
import java.util.concurrent.Executor;
/* loaded from: classes7.dex */
public class i implements h.a, k, n.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f38090a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final p f38091b;

    /* renamed from: c  reason: collision with root package name */
    public final m f38092c;

    /* renamed from: d  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.engine.a.h f38093d;

    /* renamed from: e  reason: collision with root package name */
    public final b f38094e;

    /* renamed from: f  reason: collision with root package name */
    public final v f38095f;

    /* renamed from: g  reason: collision with root package name */
    public final c f38096g;

    /* renamed from: h  reason: collision with root package name */
    public final a f38097h;

    /* renamed from: i  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.engine.a f38098i;

    @VisibleForTesting
    /* loaded from: classes7.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final DecodeJob.d f38099a;

        /* renamed from: b  reason: collision with root package name */
        public final Pools.Pool<DecodeJob<?>> f38100b;

        /* renamed from: c  reason: collision with root package name */
        public int f38101c;

        public a(DecodeJob.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38100b = com.kwad.sdk.glide.g.a.a.a(150, new a.InterfaceC0457a<DecodeJob<?>>(this) { // from class: com.kwad.sdk.glide.load.engine.i.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f38102a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext2 = TitanRuntime.newInitContext();
                        newInitContext2.initArgs = r2;
                        Object[] objArr2 = {this};
                        interceptable2.invokeUnInit(65536, newInitContext2);
                        int i4 = newInitContext2.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext2.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext2);
                            return;
                        }
                    }
                    this.f38102a = this;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.glide.g.a.a.InterfaceC0457a
                /* renamed from: a */
                public DecodeJob<?> b() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        a aVar = this.f38102a;
                        return new DecodeJob<>(aVar.f38099a, aVar.f38100b);
                    }
                    return (DecodeJob) invokeV.objValue;
                }
            });
            this.f38099a = dVar;
        }

        public <R> DecodeJob<R> a(com.kwad.sdk.glide.e eVar, Object obj, l lVar, com.kwad.sdk.glide.load.c cVar, int i2, int i3, Class<?> cls, Class<R> cls2, Priority priority, h hVar, Map<Class<?>, com.kwad.sdk.glide.load.h<?>> map, boolean z, boolean z2, boolean z3, com.kwad.sdk.glide.load.e eVar2, DecodeJob.a<R> aVar) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{eVar, obj, lVar, cVar, Integer.valueOf(i2), Integer.valueOf(i3), cls, cls2, priority, hVar, map, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), eVar2, aVar})) == null) {
                DecodeJob decodeJob = (DecodeJob) com.kwad.sdk.glide.g.j.a(this.f38100b.acquire());
                int i4 = this.f38101c;
                this.f38101c = i4 + 1;
                return decodeJob.a(eVar, obj, lVar, cVar, i2, i3, cls, cls2, priority, hVar, map, z, z2, z3, eVar2, aVar, i4);
            }
            return (DecodeJob) invokeCommon.objValue;
        }
    }

    @VisibleForTesting
    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final com.kwad.sdk.glide.load.engine.b.a f38103a;

        /* renamed from: b  reason: collision with root package name */
        public final com.kwad.sdk.glide.load.engine.b.a f38104b;

        /* renamed from: c  reason: collision with root package name */
        public final com.kwad.sdk.glide.load.engine.b.a f38105c;

        /* renamed from: d  reason: collision with root package name */
        public final com.kwad.sdk.glide.load.engine.b.a f38106d;

        /* renamed from: e  reason: collision with root package name */
        public final k f38107e;

        /* renamed from: f  reason: collision with root package name */
        public final Pools.Pool<j<?>> f38108f;

        public b(com.kwad.sdk.glide.load.engine.b.a aVar, com.kwad.sdk.glide.load.engine.b.a aVar2, com.kwad.sdk.glide.load.engine.b.a aVar3, com.kwad.sdk.glide.load.engine.b.a aVar4, k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, aVar2, aVar3, aVar4, kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38108f = com.kwad.sdk.glide.g.a.a.a(150, new a.InterfaceC0457a<j<?>>(this) { // from class: com.kwad.sdk.glide.load.engine.i.b.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f38109a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext2 = TitanRuntime.newInitContext();
                        newInitContext2.initArgs = r2;
                        Object[] objArr2 = {this};
                        interceptable2.invokeUnInit(65536, newInitContext2);
                        int i4 = newInitContext2.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext2.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext2);
                            return;
                        }
                    }
                    this.f38109a = this;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.glide.g.a.a.InterfaceC0457a
                /* renamed from: a */
                public j<?> b() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        b bVar = this.f38109a;
                        return new j<>(bVar.f38103a, bVar.f38104b, bVar.f38105c, bVar.f38106d, bVar.f38107e, bVar.f38108f);
                    }
                    return (j) invokeV.objValue;
                }
            });
            this.f38103a = aVar;
            this.f38104b = aVar2;
            this.f38105c = aVar3;
            this.f38106d = aVar4;
            this.f38107e = kVar;
        }

        public <R> j<R> a(com.kwad.sdk.glide.load.c cVar, boolean z, boolean z2, boolean z3, boolean z4) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{cVar, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4)})) == null) ? ((j) com.kwad.sdk.glide.g.j.a(this.f38108f.acquire())).a(cVar, z, z2, z3, z4) : (j) invokeCommon.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class c implements DecodeJob.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final a.InterfaceC0464a f38110a;

        /* renamed from: b  reason: collision with root package name */
        public volatile com.kwad.sdk.glide.load.engine.a.a f38111b;

        public c(a.InterfaceC0464a interfaceC0464a) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {interfaceC0464a};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38110a = interfaceC0464a;
        }

        @Override // com.kwad.sdk.glide.load.engine.DecodeJob.d
        public com.kwad.sdk.glide.load.engine.a.a a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.f38111b == null) {
                    synchronized (this) {
                        if (this.f38111b == null) {
                            this.f38111b = this.f38110a.a();
                        }
                        if (this.f38111b == null) {
                            this.f38111b = new com.kwad.sdk.glide.load.engine.a.b();
                        }
                    }
                }
                return this.f38111b;
            }
            return (com.kwad.sdk.glide.load.engine.a.a) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f38112a;

        /* renamed from: b  reason: collision with root package name */
        public final j<?> f38113b;

        /* renamed from: c  reason: collision with root package name */
        public final com.kwad.sdk.glide.request.g f38114c;

        public d(i iVar, com.kwad.sdk.glide.request.g gVar, j<?> jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, gVar, jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38112a = iVar;
            this.f38114c = gVar;
            this.f38113b = jVar;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.f38112a) {
                    this.f38113b.c(this.f38114c);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-469693189, "Lcom/kwad/sdk/glide/load/engine/i;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-469693189, "Lcom/kwad/sdk/glide/load/engine/i;");
                return;
            }
        }
        f38090a = Log.isLoggable(Engine.TAG, 2);
    }

    @VisibleForTesting
    public i(com.kwad.sdk.glide.load.engine.a.h hVar, a.InterfaceC0464a interfaceC0464a, com.kwad.sdk.glide.load.engine.b.a aVar, com.kwad.sdk.glide.load.engine.b.a aVar2, com.kwad.sdk.glide.load.engine.b.a aVar3, com.kwad.sdk.glide.load.engine.b.a aVar4, p pVar, m mVar, com.kwad.sdk.glide.load.engine.a aVar5, b bVar, a aVar6, v vVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hVar, interfaceC0464a, aVar, aVar2, aVar3, aVar4, pVar, mVar, aVar5, bVar, aVar6, vVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f38093d = hVar;
        this.f38096g = new c(interfaceC0464a);
        com.kwad.sdk.glide.load.engine.a aVar7 = aVar5 == null ? new com.kwad.sdk.glide.load.engine.a(z) : aVar5;
        this.f38098i = aVar7;
        aVar7.a(this);
        this.f38092c = mVar == null ? new m() : mVar;
        this.f38091b = pVar == null ? new p() : pVar;
        this.f38094e = bVar == null ? new b(aVar, aVar2, aVar3, aVar4, this) : bVar;
        this.f38097h = aVar6 == null ? new a(this.f38096g) : aVar6;
        this.f38095f = vVar == null ? new v() : vVar;
        hVar.a(this);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public i(com.kwad.sdk.glide.load.engine.a.h hVar, a.InterfaceC0464a interfaceC0464a, com.kwad.sdk.glide.load.engine.b.a aVar, com.kwad.sdk.glide.load.engine.b.a aVar2, com.kwad.sdk.glide.load.engine.b.a aVar3, com.kwad.sdk.glide.load.engine.b.a aVar4, boolean z) {
        this(hVar, interfaceC0464a, aVar, aVar2, aVar3, aVar4, null, null, null, null, null, null, z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {hVar, interfaceC0464a, aVar, aVar2, aVar3, aVar4, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((com.kwad.sdk.glide.load.engine.a.h) objArr2[0], (a.InterfaceC0464a) objArr2[1], (com.kwad.sdk.glide.load.engine.b.a) objArr2[2], (com.kwad.sdk.glide.load.engine.b.a) objArr2[3], (com.kwad.sdk.glide.load.engine.b.a) objArr2[4], (com.kwad.sdk.glide.load.engine.b.a) objArr2[5], (p) objArr2[6], (m) objArr2[7], (com.kwad.sdk.glide.load.engine.a) objArr2[8], (b) objArr2[9], (a) objArr2[10], (v) objArr2[11], ((Boolean) objArr2[12]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    private n<?> a(com.kwad.sdk.glide.load.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, cVar)) == null) {
            s<?> a2 = this.f38093d.a(cVar);
            if (a2 == null) {
                return null;
            }
            return a2 instanceof n ? (n) a2 : new n<>(a2, true, true);
        }
        return (n) invokeL.objValue;
    }

    @Nullable
    private n<?> a(com.kwad.sdk.glide.load.c cVar, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65540, this, cVar, z)) == null) {
            if (z) {
                n<?> b2 = this.f38098i.b(cVar);
                if (b2 != null) {
                    b2.g();
                }
                return b2;
            }
            return null;
        }
        return (n) invokeLZ.objValue;
    }

    public static void a(String str, long j, com.kwad.sdk.glide.load.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{str, Long.valueOf(j), cVar}) == null) {
            Log.v(Engine.TAG, str + " in " + com.kwad.sdk.glide.g.f.a(j) + "ms, key: " + cVar);
        }
    }

    private n<?> b(com.kwad.sdk.glide.load.c cVar, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(AdIconUtil.BAIDU_LOGO_ID, this, cVar, z)) == null) {
            if (z) {
                n<?> a2 = a(cVar);
                if (a2 != null) {
                    a2.g();
                    this.f38098i.a(cVar, a2);
                }
                return a2;
            }
            return null;
        }
        return (n) invokeLZ.objValue;
    }

    public synchronized <R> d a(com.kwad.sdk.glide.e eVar, Object obj, com.kwad.sdk.glide.load.c cVar, int i2, int i3, Class<?> cls, Class<R> cls2, Priority priority, h hVar, Map<Class<?>, com.kwad.sdk.glide.load.h<?>> map, boolean z, boolean z2, com.kwad.sdk.glide.load.e eVar2, boolean z3, boolean z4, boolean z5, boolean z6, com.kwad.sdk.glide.request.g gVar, Executor executor) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{eVar, obj, cVar, Integer.valueOf(i2), Integer.valueOf(i3), cls, cls2, priority, hVar, map, Boolean.valueOf(z), Boolean.valueOf(z2), eVar2, Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z5), Boolean.valueOf(z6), gVar, executor})) == null) {
            synchronized (this) {
                long a2 = f38090a ? com.kwad.sdk.glide.g.f.a() : 0L;
                l a3 = this.f38092c.a(obj, cVar, i2, i3, map, cls, cls2, eVar2);
                n<?> a4 = a(a3, z3);
                if (a4 != null) {
                    gVar.a(a4, DataSource.MEMORY_CACHE);
                    if (f38090a) {
                        a("Loaded resource from active resources", a2, a3);
                    }
                    return null;
                }
                n<?> b2 = b(a3, z3);
                if (b2 != null) {
                    gVar.a(b2, DataSource.MEMORY_CACHE);
                    if (f38090a) {
                        a("Loaded resource from cache", a2, a3);
                    }
                    return null;
                }
                j<?> a5 = this.f38091b.a(a3, z6);
                if (a5 != null) {
                    a5.a(gVar, executor);
                    if (f38090a) {
                        a("Added to existing load", a2, a3);
                    }
                    return new d(this, gVar, a5);
                }
                j<R> a6 = this.f38094e.a(a3, z3, z4, z5, z6);
                DecodeJob<R> a7 = this.f38097h.a(eVar, obj, a3, cVar, i2, i3, cls, cls2, priority, hVar, map, z, z2, z6, eVar2, a6);
                this.f38091b.a((com.kwad.sdk.glide.load.c) a3, (j<?>) a6);
                a6.a(gVar, executor);
                a6.b(a7);
                if (f38090a) {
                    a("Started new load", a2, a3);
                }
                return new d(this, gVar, a6);
            }
        }
        return (d) invokeCommon.objValue;
    }

    @Override // com.kwad.sdk.glide.load.engine.n.a
    public synchronized void a(com.kwad.sdk.glide.load.c cVar, n<?> nVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar, nVar) == null) {
            synchronized (this) {
                this.f38098i.a(cVar);
                if (nVar.f()) {
                    this.f38093d.b(cVar, nVar);
                } else {
                    this.f38095f.a(nVar);
                }
            }
        }
    }

    @Override // com.kwad.sdk.glide.load.engine.k
    public synchronized void a(j<?> jVar, com.kwad.sdk.glide.load.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, jVar, cVar) == null) {
            synchronized (this) {
                this.f38091b.b(cVar, jVar);
            }
        }
    }

    @Override // com.kwad.sdk.glide.load.engine.k
    public synchronized void a(j<?> jVar, com.kwad.sdk.glide.load.c cVar, n<?> nVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, jVar, cVar, nVar) == null) {
            synchronized (this) {
                if (nVar != null) {
                    nVar.a(cVar, this);
                    if (nVar.f()) {
                        this.f38098i.a(cVar, nVar);
                    }
                }
                this.f38091b.b(cVar, jVar);
            }
        }
    }

    public void a(s<?> sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, sVar) == null) {
            if (!(sVar instanceof n)) {
                throw new IllegalArgumentException("Cannot release anything but an EngineResource");
            }
            ((n) sVar).h();
        }
    }

    @Override // com.kwad.sdk.glide.load.engine.a.h.a
    public void b(@NonNull s<?> sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, sVar) == null) {
            this.f38095f.a(sVar);
        }
    }
}
