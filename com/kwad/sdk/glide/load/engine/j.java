package com.kwad.sdk.glide.load.engine;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pools;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.glide.g.a.a;
import com.kwad.sdk.glide.load.DataSource;
import com.kwad.sdk.glide.load.engine.DecodeJob;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public class j<R> implements a.c, DecodeJob.a<R> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final c f38115e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final e f38116a;

    /* renamed from: b  reason: collision with root package name */
    public DataSource f38117b;

    /* renamed from: c  reason: collision with root package name */
    public GlideException f38118c;

    /* renamed from: d  reason: collision with root package name */
    public n<?> f38119d;

    /* renamed from: f  reason: collision with root package name */
    public final com.kwad.sdk.glide.g.a.c f38120f;

    /* renamed from: g  reason: collision with root package name */
    public final Pools.Pool<j<?>> f38121g;

    /* renamed from: h  reason: collision with root package name */
    public final c f38122h;

    /* renamed from: i  reason: collision with root package name */
    public final k f38123i;
    public final com.kwad.sdk.glide.load.engine.b.a j;
    public final com.kwad.sdk.glide.load.engine.b.a k;
    public final com.kwad.sdk.glide.load.engine.b.a l;
    public final com.kwad.sdk.glide.load.engine.b.a m;
    public final AtomicInteger n;
    public com.kwad.sdk.glide.load.c o;
    public boolean p;
    public boolean q;
    public boolean r;
    public boolean s;
    public s<?> t;
    public boolean u;
    public boolean v;
    public DecodeJob<R> w;
    public volatile boolean x;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ j f38124a;

        /* renamed from: b  reason: collision with root package name */
        public final com.kwad.sdk.glide.request.g f38125b;

        public a(j jVar, com.kwad.sdk.glide.request.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38124a = jVar;
            this.f38125b = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.f38124a) {
                    if (this.f38124a.f38116a.b(this.f38125b)) {
                        this.f38124a.b(this.f38125b);
                    }
                    this.f38124a.e();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ j f38126a;

        /* renamed from: b  reason: collision with root package name */
        public final com.kwad.sdk.glide.request.g f38127b;

        public b(j jVar, com.kwad.sdk.glide.request.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38126a = jVar;
            this.f38127b = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.f38126a) {
                    if (this.f38126a.f38116a.b(this.f38127b)) {
                        this.f38126a.f38119d.g();
                        this.f38126a.a(this.f38127b);
                        this.f38126a.c(this.f38127b);
                    }
                    this.f38126a.e();
                }
            }
        }
    }

    @VisibleForTesting
    /* loaded from: classes7.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public <R> n<R> a(s<R> sVar, boolean z) {
            InterceptResult invokeLZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, sVar, z)) == null) ? new n<>(sVar, z, true) : (n) invokeLZ.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static final class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final com.kwad.sdk.glide.request.g f38128a;

        /* renamed from: b  reason: collision with root package name */
        public final Executor f38129b;

        public d(com.kwad.sdk.glide.request.g gVar, Executor executor) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, executor};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38128a = gVar;
            this.f38129b = executor;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if (obj instanceof d) {
                    return this.f38128a.equals(((d) obj).f38128a);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f38128a.hashCode() : invokeV.intValue;
        }
    }

    /* loaded from: classes7.dex */
    public static final class e implements Iterable<d> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final List<d> f38130a;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public e() {
            this(new ArrayList(2));
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    this((List) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public e(List<d> list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {list};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f38130a = list;
        }

        public static d c(com.kwad.sdk.glide.request.g gVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, gVar)) == null) ? new d(gVar, com.kwad.sdk.glide.g.e.b()) : (d) invokeL.objValue;
        }

        public void a(com.kwad.sdk.glide.request.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, gVar) == null) {
                this.f38130a.remove(c(gVar));
            }
        }

        public void a(com.kwad.sdk.glide.request.g gVar, Executor executor) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar, executor) == null) {
                this.f38130a.add(new d(gVar, executor));
            }
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f38130a.isEmpty() : invokeV.booleanValue;
        }

        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f38130a.size() : invokeV.intValue;
        }

        public boolean b(com.kwad.sdk.glide.request.g gVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, gVar)) == null) ? this.f38130a.contains(c(gVar)) : invokeL.booleanValue;
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.f38130a.clear();
            }
        }

        public e d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new e(new ArrayList(this.f38130a)) : (e) invokeV.objValue;
        }

        @Override // java.lang.Iterable
        @NonNull
        public Iterator<d> iterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f38130a.iterator() : (Iterator) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-469693158, "Lcom/kwad/sdk/glide/load/engine/j;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-469693158, "Lcom/kwad/sdk/glide/load/engine/j;");
                return;
            }
        }
        f38115e = new c();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public j(com.kwad.sdk.glide.load.engine.b.a aVar, com.kwad.sdk.glide.load.engine.b.a aVar2, com.kwad.sdk.glide.load.engine.b.a aVar3, com.kwad.sdk.glide.load.engine.b.a aVar4, k kVar, Pools.Pool<j<?>> pool) {
        this(aVar, aVar2, aVar3, aVar4, kVar, pool, f38115e);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, aVar2, aVar3, aVar4, kVar, pool};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((com.kwad.sdk.glide.load.engine.b.a) objArr2[0], (com.kwad.sdk.glide.load.engine.b.a) objArr2[1], (com.kwad.sdk.glide.load.engine.b.a) objArr2[2], (com.kwad.sdk.glide.load.engine.b.a) objArr2[3], (k) objArr2[4], (Pools.Pool) objArr2[5], (c) objArr2[6]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @VisibleForTesting
    public j(com.kwad.sdk.glide.load.engine.b.a aVar, com.kwad.sdk.glide.load.engine.b.a aVar2, com.kwad.sdk.glide.load.engine.b.a aVar3, com.kwad.sdk.glide.load.engine.b.a aVar4, k kVar, Pools.Pool<j<?>> pool, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, aVar2, aVar3, aVar4, kVar, pool, cVar};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f38116a = new e();
        this.f38120f = com.kwad.sdk.glide.g.a.c.a();
        this.n = new AtomicInteger();
        this.j = aVar;
        this.k = aVar2;
        this.l = aVar3;
        this.m = aVar4;
        this.f38123i = kVar;
        this.f38121g = pool;
        this.f38122h = cVar;
    }

    private com.kwad.sdk.glide.load.engine.b.a g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) ? this.q ? this.l : this.r ? this.m : this.k : (com.kwad.sdk.glide.load.engine.b.a) invokeV.objValue;
    }

    private boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65540, this)) == null) ? this.v || this.u || this.x : invokeV.booleanValue;
    }

    private synchronized void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            synchronized (this) {
                if (this.o == null) {
                    throw new IllegalArgumentException();
                }
                this.f38116a.c();
                this.o = null;
                this.f38119d = null;
                this.t = null;
                this.v = false;
                this.x = false;
                this.u = false;
                this.w.a(false);
                this.w = null;
                this.f38118c = null;
                this.f38117b = null;
                this.f38121g.release(this);
            }
        }
    }

    @VisibleForTesting
    public synchronized j<R> a(com.kwad.sdk.glide.load.c cVar, boolean z, boolean z2, boolean z3, boolean z4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{cVar, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4)})) == null) {
            synchronized (this) {
                this.o = cVar;
                this.p = z;
                this.q = z2;
                this.r = z3;
                this.s = z4;
            }
            return this;
        }
        return (j) invokeCommon.objValue;
    }

    public synchronized void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            synchronized (this) {
                com.kwad.sdk.glide.g.j.a(h(), "Not yet complete!");
                if (this.n.getAndAdd(i2) == 0 && this.f38119d != null) {
                    this.f38119d.g();
                }
            }
        }
    }

    @Override // com.kwad.sdk.glide.load.engine.DecodeJob.a
    public void a(DecodeJob<?> decodeJob) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, decodeJob) == null) {
            g().execute(decodeJob);
        }
    }

    @Override // com.kwad.sdk.glide.load.engine.DecodeJob.a
    public void a(GlideException glideException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, glideException) == null) {
            synchronized (this) {
                this.f38118c = glideException;
            }
            f();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.kwad.sdk.glide.load.engine.s<R> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.kwad.sdk.glide.load.engine.DecodeJob.a
    public void a(s<R> sVar, DataSource dataSource) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, sVar, dataSource) == null) {
            synchronized (this) {
                this.t = sVar;
                this.f38117b = dataSource;
            }
            c();
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public synchronized void a(com.kwad.sdk.glide.request.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, gVar) == null) {
            synchronized (this) {
                try {
                    gVar.a(this.f38119d, this.f38117b);
                } catch (Throwable th) {
                    throw new CallbackException(th);
                }
            }
        }
    }

    public synchronized void a(com.kwad.sdk.glide.request.g gVar, Executor executor) {
        Runnable aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, gVar, executor) == null) {
            synchronized (this) {
                this.f38120f.b();
                this.f38116a.a(gVar, executor);
                boolean z = true;
                if (this.u) {
                    a(1);
                    aVar = new b(this, gVar);
                } else if (this.v) {
                    a(1);
                    aVar = new a(this, gVar);
                } else {
                    if (this.x) {
                        z = false;
                    }
                    com.kwad.sdk.glide.g.j.a(z, "Cannot add callbacks to a cancelled EngineJob");
                }
                executor.execute(aVar);
            }
        }
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.s : invokeV.booleanValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || h()) {
            return;
        }
        this.x = true;
        this.w.b();
        this.f38123i.a(this, this.o);
    }

    public synchronized void b(DecodeJob<R> decodeJob) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, decodeJob) == null) {
            synchronized (this) {
                this.w = decodeJob;
                (decodeJob.a() ? this.j : g()).execute(decodeJob);
            }
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public synchronized void b(com.kwad.sdk.glide.request.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, gVar) == null) {
            synchronized (this) {
                try {
                    gVar.a(this.f38118c);
                } catch (Throwable th) {
                    throw new CallbackException(th);
                }
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            synchronized (this) {
                this.f38120f.b();
                if (this.x) {
                    this.t.d_();
                    i();
                } else if (this.f38116a.a()) {
                    throw new IllegalStateException("Received a resource without any callbacks to notify");
                } else {
                    if (this.u) {
                        throw new IllegalStateException("Already have resource");
                    }
                    this.f38119d = this.f38122h.a(this.t, this.p);
                    this.u = true;
                    e d2 = this.f38116a.d();
                    a(d2.b() + 1);
                    this.f38123i.a(this, this.o, this.f38119d);
                    Iterator<d> it = d2.iterator();
                    while (it.hasNext()) {
                        d next = it.next();
                        next.f38129b.execute(new b(this, next.f38128a));
                    }
                    e();
                }
            }
        }
    }

    public synchronized void c(com.kwad.sdk.glide.request.g gVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, gVar) == null) {
            synchronized (this) {
                this.f38120f.b();
                this.f38116a.a(gVar);
                if (this.f38116a.a()) {
                    b();
                    if (!this.u && !this.v) {
                        z = false;
                        if (z && this.n.get() == 0) {
                            i();
                        }
                    }
                    z = true;
                    if (z) {
                        i();
                    }
                }
            }
        }
    }

    @Override // com.kwad.sdk.glide.g.a.a.c
    @NonNull
    public com.kwad.sdk.glide.g.a.c d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f38120f : (com.kwad.sdk.glide.g.a.c) invokeV.objValue;
    }

    public synchronized void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            synchronized (this) {
                this.f38120f.b();
                com.kwad.sdk.glide.g.j.a(h(), "Not yet complete!");
                int decrementAndGet = this.n.decrementAndGet();
                com.kwad.sdk.glide.g.j.a(decrementAndGet >= 0, "Can't decrement below 0");
                if (decrementAndGet == 0) {
                    if (this.f38119d != null) {
                        this.f38119d.h();
                    }
                    i();
                }
            }
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            synchronized (this) {
                this.f38120f.b();
                if (this.x) {
                    i();
                } else if (this.f38116a.a()) {
                    throw new IllegalStateException("Received an exception without any callbacks to notify");
                } else {
                    if (this.v) {
                        throw new IllegalStateException("Already failed once");
                    }
                    this.v = true;
                    com.kwad.sdk.glide.load.c cVar = this.o;
                    e d2 = this.f38116a.d();
                    a(d2.b() + 1);
                    this.f38123i.a(this, cVar, null);
                    Iterator<d> it = d2.iterator();
                    while (it.hasNext()) {
                        d next = it.next();
                        next.f38129b.execute(new a(this, next.f38128a));
                    }
                    e();
                }
            }
        }
    }
}
