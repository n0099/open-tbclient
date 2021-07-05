package com.kwad.sdk.glide.request;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import androidx.annotation.DrawableRes;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pools;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.glide.Priority;
import com.kwad.sdk.glide.g.a.a;
import com.kwad.sdk.glide.g.k;
import com.kwad.sdk.glide.load.DataSource;
import com.kwad.sdk.glide.load.engine.GlideException;
import com.kwad.sdk.glide.load.engine.i;
import com.kwad.sdk.glide.load.engine.s;
import com.kwad.sdk.glide.request.a.i;
import com.kwad.sdk.glide.request.a.j;
import java.util.List;
import java.util.concurrent.Executor;
/* loaded from: classes7.dex */
public final class SingleRequest<R> implements a.c, i, c, g {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Pools.Pool<SingleRequest<?>> f38313a;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f38314c;
    public transient /* synthetic */ FieldHolder $fh;
    public Drawable A;
    public int B;
    public int C;
    @Nullable
    public RuntimeException D;

    /* renamed from: b  reason: collision with root package name */
    public boolean f38315b;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public final String f38316d;

    /* renamed from: e  reason: collision with root package name */
    public final com.kwad.sdk.glide.g.a.c f38317e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public e<R> f38318f;

    /* renamed from: g  reason: collision with root package name */
    public d f38319g;

    /* renamed from: h  reason: collision with root package name */
    public Context f38320h;

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.glide.e f38321i;
    @Nullable
    public Object j;
    public Class<R> k;
    public a<?> l;
    public int m;
    public int n;
    public Priority o;
    public j<R> p;
    @Nullable
    public List<e<R>> q;
    public com.kwad.sdk.glide.load.engine.i r;
    public com.kwad.sdk.glide.request.b.c<? super R> s;
    public Executor t;
    public s<R> u;
    public i.d v;
    public long w;
    @GuardedBy("this")
    public Status x;
    public Drawable y;
    public Drawable z;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class Status {
        public static final /* synthetic */ Status[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Status CLEARED;
        public static final Status COMPLETE;
        public static final Status FAILED;
        public static final Status PENDING;
        public static final Status RUNNING;
        public static final Status WAITING_FOR_SIZE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(889901735, "Lcom/kwad/sdk/glide/request/SingleRequest$Status;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(889901735, "Lcom/kwad/sdk/glide/request/SingleRequest$Status;");
                    return;
                }
            }
            PENDING = new Status("PENDING", 0);
            RUNNING = new Status("RUNNING", 1);
            WAITING_FOR_SIZE = new Status("WAITING_FOR_SIZE", 2);
            COMPLETE = new Status("COMPLETE", 3);
            FAILED = new Status("FAILED", 4);
            Status status = new Status("CLEARED", 5);
            CLEARED = status;
            $VALUES = new Status[]{PENDING, RUNNING, WAITING_FOR_SIZE, COMPLETE, FAILED, status};
        }

        public Status(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static Status valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (Status) Enum.valueOf(Status.class, str) : (Status) invokeL.objValue;
        }

        public static Status[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (Status[]) $VALUES.clone() : (Status[]) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(378019225, "Lcom/kwad/sdk/glide/request/SingleRequest;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(378019225, "Lcom/kwad/sdk/glide/request/SingleRequest;");
                return;
            }
        }
        f38313a = com.kwad.sdk.glide.g.a.a.a(150, new a.InterfaceC0457a<SingleRequest<?>>() { // from class: com.kwad.sdk.glide.request.SingleRequest.1
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
            public SingleRequest<?> b() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? new SingleRequest<>() : (SingleRequest) invokeV.objValue;
            }
        });
        f38314c = Log.isLoggable(com.bumptech.glide.request.SingleRequest.TAG, 2);
    }

    public SingleRequest() {
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
        this.f38316d = f38314c ? String.valueOf(super.hashCode()) : null;
        this.f38317e = com.kwad.sdk.glide.g.a.c.a();
    }

    public static int a(int i2, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)})) == null) ? i2 == Integer.MIN_VALUE ? i2 : Math.round(f2 * i2) : invokeCommon.intValue;
    }

    private Drawable a(@DrawableRes int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, this, i2)) == null) {
            return com.kwad.sdk.glide.load.resource.b.a.a(this.f38321i, i2, this.l.v() != null ? this.l.v() : this.f38320h.getTheme());
        }
        return (Drawable) invokeI.objValue;
    }

    public static <R> SingleRequest<R> a(Context context, com.kwad.sdk.glide.e eVar, Object obj, Class<R> cls, a<?> aVar, int i2, int i3, Priority priority, j<R> jVar, e<R> eVar2, @Nullable List<e<R>> list, d dVar, com.kwad.sdk.glide.load.engine.i iVar, com.kwad.sdk.glide.request.b.c<? super R> cVar, Executor executor) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65540, null, new Object[]{context, eVar, obj, cls, aVar, Integer.valueOf(i2), Integer.valueOf(i3), priority, jVar, eVar2, list, dVar, iVar, cVar, executor})) == null) {
            SingleRequest<?> acquire = f38313a.acquire();
            if (acquire == null) {
                acquire = new SingleRequest();
            }
            acquire.b(context, eVar, obj, cls, aVar, i2, i3, priority, jVar, eVar2, list, dVar, iVar, cVar, executor);
            return acquire;
        }
        return (SingleRequest) invokeCommon.objValue;
    }

    private synchronized void a(GlideException glideException, int i2) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(AdIconUtil.AD_TEXT_ID, this, glideException, i2) == null) {
            synchronized (this) {
                this.f38317e.b();
                glideException.setOrigin(this.D);
                int e2 = this.f38321i.e();
                if (e2 <= i2) {
                    Log.w("Glide", "Load failed for " + this.j + " with size [" + this.B + "x" + this.C + PreferencesUtil.RIGHT_MOUNT, glideException);
                    if (e2 <= 4) {
                        glideException.logRootCauses("Glide");
                    }
                }
                this.v = null;
                this.x = Status.FAILED;
                boolean z2 = true;
                this.f38315b = true;
                if (this.q != null) {
                    z = false;
                    for (e<R> eVar : this.q) {
                        z |= eVar.a(glideException, this.j, this.p, r());
                    }
                } else {
                    z = false;
                }
                if (this.f38318f == null || !this.f38318f.a(glideException, this.j, this.p, r())) {
                    z2 = false;
                }
                if (!(z | z2)) {
                    n();
                }
                this.f38315b = false;
                t();
            }
        }
    }

    private void a(s<?> sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, sVar) == null) {
            this.r.a(sVar);
            this.u = null;
        }
    }

    private synchronized void a(s<R> sVar, R r, DataSource dataSource) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, this, sVar, r, dataSource) == null) {
            synchronized (this) {
                boolean r2 = r();
                this.x = Status.COMPLETE;
                this.u = sVar;
                if (this.f38321i.e() <= 3) {
                    Log.d("Glide", "Finished loading " + r.getClass().getSimpleName() + " from " + dataSource + " for " + this.j + " with size [" + this.B + "x" + this.C + "] in " + com.kwad.sdk.glide.g.f.a(this.w) + " ms");
                }
                boolean z2 = true;
                this.f38315b = true;
                if (this.q != null) {
                    z = false;
                    for (e<R> eVar : this.q) {
                        z |= eVar.a(r, this.j, this.p, dataSource, r2);
                    }
                } else {
                    z = false;
                }
                if (this.f38318f == null || !this.f38318f.a(r, this.j, this.p, dataSource, r2)) {
                    z2 = false;
                }
                if (!(z2 | z)) {
                    this.p.a(r, this.s.a(dataSource, r2));
                }
                this.f38315b = false;
                s();
            }
        }
    }

    private void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, str) == null) {
            Log.v(com.bumptech.glide.request.SingleRequest.TAG, str + " this: " + this.f38316d);
        }
    }

    private synchronized boolean a(SingleRequest<?> singleRequest) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, this, singleRequest)) == null) {
            synchronized (this) {
                synchronized (singleRequest) {
                    z = (this.q == null ? 0 : this.q.size()) == (singleRequest.q == null ? 0 : singleRequest.q.size());
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    private synchronized void b(Context context, com.kwad.sdk.glide.e eVar, Object obj, Class<R> cls, a<?> aVar, int i2, int i3, Priority priority, j<R> jVar, e<R> eVar2, @Nullable List<e<R>> list, d dVar, com.kwad.sdk.glide.load.engine.i iVar, com.kwad.sdk.glide.request.b.c<? super R> cVar, Executor executor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, this, new Object[]{context, eVar, obj, cls, aVar, Integer.valueOf(i2), Integer.valueOf(i3), priority, jVar, eVar2, list, dVar, iVar, cVar, executor}) == null) {
            synchronized (this) {
                this.f38320h = context;
                this.f38321i = eVar;
                this.j = obj;
                this.k = cls;
                this.l = aVar;
                this.m = i2;
                this.n = i3;
                this.o = priority;
                this.p = jVar;
                this.f38318f = eVar2;
                this.q = list;
                this.f38319g = dVar;
                this.r = iVar;
                this.s = cVar;
                this.t = executor;
                this.x = Status.PENDING;
                if (this.D == null && eVar.g()) {
                    this.D = new RuntimeException("Glide request origin trace");
                }
            }
        }
    }

    private void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            j();
            this.f38317e.b();
            this.p.b(this);
            i.d dVar = this.v;
            if (dVar != null) {
                dVar.a();
                this.v = null;
            }
        }
    }

    private void j() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65548, this) == null) && this.f38315b) {
            throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
        }
    }

    private Drawable k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, this)) == null) {
            if (this.y == null) {
                Drawable p = this.l.p();
                this.y = p;
                if (p == null && this.l.q() > 0) {
                    this.y = a(this.l.q());
                }
            }
            return this.y;
        }
        return (Drawable) invokeV.objValue;
    }

    private Drawable l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, this)) == null) {
            if (this.z == null) {
                Drawable s = this.l.s();
                this.z = s;
                if (s == null && this.l.r() > 0) {
                    this.z = a(this.l.r());
                }
            }
            return this.z;
        }
        return (Drawable) invokeV.objValue;
    }

    private Drawable m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, this)) == null) {
            if (this.A == null) {
                Drawable u = this.l.u();
                this.A = u;
                if (u == null && this.l.t() > 0) {
                    this.A = a(this.l.t());
                }
            }
            return this.A;
        }
        return (Drawable) invokeV.objValue;
    }

    private synchronized void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
            synchronized (this) {
                if (q()) {
                    Drawable m = this.j == null ? m() : null;
                    if (m == null) {
                        m = k();
                    }
                    if (m == null) {
                        m = l();
                    }
                    this.p.c(m);
                }
            }
        }
    }

    private boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, this)) == null) {
            d dVar = this.f38319g;
            return dVar == null || dVar.b(this);
        }
        return invokeV.booleanValue;
    }

    private boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, this)) == null) {
            d dVar = this.f38319g;
            return dVar == null || dVar.d(this);
        }
        return invokeV.booleanValue;
    }

    private boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65555, this)) == null) {
            d dVar = this.f38319g;
            return dVar == null || dVar.c(this);
        }
        return invokeV.booleanValue;
    }

    private boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65556, this)) == null) {
            d dVar = this.f38319g;
            return dVar == null || !dVar.i();
        }
        return invokeV.booleanValue;
    }

    private void s() {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65557, this) == null) || (dVar = this.f38319g) == null) {
            return;
        }
        dVar.e(this);
    }

    private void t() {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65558, this) == null) || (dVar = this.f38319g) == null) {
            return;
        }
        dVar.f(this);
    }

    @Override // com.kwad.sdk.glide.request.c
    public synchronized void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                j();
                this.f38317e.b();
                this.w = com.kwad.sdk.glide.g.f.a();
                if (this.j == null) {
                    if (k.a(this.m, this.n)) {
                        this.B = this.m;
                        this.C = this.n;
                    }
                    a(new GlideException("Received null model"), m() == null ? 5 : 3);
                } else if (this.x == Status.RUNNING) {
                    throw new IllegalArgumentException("Cannot restart a running request");
                } else {
                    if (this.x == Status.COMPLETE) {
                        a((s<?>) this.u, DataSource.MEMORY_CACHE);
                        return;
                    }
                    this.x = Status.WAITING_FOR_SIZE;
                    if (k.a(this.m, this.n)) {
                        a(this.m, this.n);
                    } else {
                        this.p.a((com.kwad.sdk.glide.request.a.i) this);
                    }
                    if ((this.x == Status.RUNNING || this.x == Status.WAITING_FOR_SIZE) && q()) {
                        this.p.b(l());
                    }
                    if (f38314c) {
                        a("finished run method in " + com.kwad.sdk.glide.g.f.a(this.w));
                    }
                }
            }
        }
    }

    @Override // com.kwad.sdk.glide.request.a.i
    public synchronized void a(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) != null) {
            return;
        }
        synchronized (this) {
            try {
                this.f38317e.b();
                if (f38314c) {
                    a("Got onSizeReady in " + com.kwad.sdk.glide.g.f.a(this.w));
                }
                if (this.x != Status.WAITING_FOR_SIZE) {
                    return;
                }
                this.x = Status.RUNNING;
                float D = this.l.D();
                this.B = a(i2, D);
                this.C = a(i3, D);
                if (f38314c) {
                    a("finished setup for calling load in " + com.kwad.sdk.glide.g.f.a(this.w));
                }
                try {
                    try {
                        this.v = this.r.a(this.f38321i, this.j, this.l.x(), this.B, this.C, this.l.n(), this.k, this.o, this.l.o(), this.l.k(), this.l.l(), this.l.E(), this.l.m(), this.l.w(), this.l.F(), this.l.G(), this.l.H(), this, this.t);
                        if (this.x != Status.RUNNING) {
                            this.v = null;
                        }
                        if (f38314c) {
                            a("finished onSizeReady in " + com.kwad.sdk.glide.g.f.a(this.w));
                        }
                    } catch (Throwable th) {
                        th = th;
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
    }

    @Override // com.kwad.sdk.glide.request.g
    public synchronized void a(GlideException glideException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, glideException) == null) {
            synchronized (this) {
                a(glideException, 5);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.kwad.sdk.glide.request.SingleRequest<R> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.kwad.sdk.glide.request.g
    public synchronized void a(s<?> sVar, DataSource dataSource) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, sVar, dataSource) == null) {
            synchronized (this) {
                this.f38317e.b();
                this.v = null;
                if (sVar == null) {
                    a(new GlideException("Expected to receive a Resource<R> with an object of " + this.k + " inside, but instead got null."));
                    return;
                }
                Object e2 = sVar.e();
                if (e2 != null && this.k.isAssignableFrom(e2.getClass())) {
                    if (o()) {
                        a(sVar, e2, dataSource);
                        return;
                    }
                    a(sVar);
                    this.x = Status.COMPLETE;
                    return;
                }
                a(sVar);
                StringBuilder sb = new StringBuilder();
                sb.append("Expected to receive an object of ");
                sb.append(this.k);
                sb.append(" but instead got ");
                sb.append(e2 != null ? e2.getClass() : "");
                sb.append(StringUtil.ARRAY_START);
                sb.append(e2);
                sb.append("} inside Resource{");
                sb.append(sVar);
                sb.append("}.");
                sb.append(e2 != null ? "" : " To indicate failure return a null Resource object, rather than a Resource object containing null data.");
                a(new GlideException(sb.toString()));
            }
        }
    }

    @Override // com.kwad.sdk.glide.request.c
    public synchronized boolean a(c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, cVar)) == null) {
            synchronized (this) {
                boolean z = false;
                if (cVar instanceof SingleRequest) {
                    SingleRequest<?> singleRequest = (SingleRequest) cVar;
                    synchronized (singleRequest) {
                        if (this.m == singleRequest.m && this.n == singleRequest.n && k.b(this.j, singleRequest.j) && this.k.equals(singleRequest.k) && this.l.equals(singleRequest.l) && this.o == singleRequest.o && a(singleRequest)) {
                            z = true;
                        }
                    }
                    return z;
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // com.kwad.sdk.glide.request.c
    public synchronized void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            synchronized (this) {
                j();
                this.f38317e.b();
                if (this.x == Status.CLEARED) {
                    return;
                }
                i();
                if (this.u != null) {
                    a((s<?>) this.u);
                }
                if (p()) {
                    this.p.a(l());
                }
                this.x = Status.CLEARED;
            }
        }
    }

    @Override // com.kwad.sdk.glide.request.c
    public synchronized boolean c() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            synchronized (this) {
                if (this.x != Status.RUNNING) {
                    z = this.x == Status.WAITING_FOR_SIZE;
                }
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.glide.g.a.a.c
    @NonNull
    public com.kwad.sdk.glide.g.a.c d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f38317e : (com.kwad.sdk.glide.g.a.c) invokeV.objValue;
    }

    @Override // com.kwad.sdk.glide.request.c
    public synchronized boolean e() {
        InterceptResult invokeV;
        boolean e_;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            synchronized (this) {
                e_ = e_();
            }
            return e_;
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.glide.request.c
    public synchronized boolean e_() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            synchronized (this) {
                z = this.x == Status.COMPLETE;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.glide.request.c
    public synchronized boolean f() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            synchronized (this) {
                z = this.x == Status.CLEARED;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.glide.request.c
    public synchronized boolean g() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            synchronized (this) {
                z = this.x == Status.FAILED;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.glide.request.c
    public synchronized void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            synchronized (this) {
                j();
                this.f38320h = null;
                this.f38321i = null;
                this.j = null;
                this.k = null;
                this.l = null;
                this.m = -1;
                this.n = -1;
                this.p = null;
                this.q = null;
                this.f38318f = null;
                this.f38319g = null;
                this.s = null;
                this.v = null;
                this.y = null;
                this.z = null;
                this.A = null;
                this.B = -1;
                this.C = -1;
                this.D = null;
                f38313a.release(this);
            }
        }
    }
}
