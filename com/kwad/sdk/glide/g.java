package com.kwad.sdk.glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.CheckResult;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.glide.c.c;
import com.kwad.sdk.glide.c.i;
import com.kwad.sdk.glide.c.l;
import com.kwad.sdk.glide.c.m;
import com.kwad.sdk.glide.c.o;
import com.kwad.sdk.glide.g.k;
import com.kwad.sdk.glide.request.a.j;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes7.dex */
public class g implements i {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final com.kwad.sdk.glide.request.f f37732d;

    /* renamed from: e  reason: collision with root package name */
    public static final com.kwad.sdk.glide.request.f f37733e;

    /* renamed from: f  reason: collision with root package name */
    public static final com.kwad.sdk.glide.request.f f37734f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final c f37735a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f37736b;

    /* renamed from: c  reason: collision with root package name */
    public final com.kwad.sdk.glide.c.h f37737c;
    @GuardedBy("this")

    /* renamed from: g  reason: collision with root package name */
    public final m f37738g;
    @GuardedBy("this")

    /* renamed from: h  reason: collision with root package name */
    public final l f37739h;
    @GuardedBy("this")

    /* renamed from: i  reason: collision with root package name */
    public final o f37740i;
    public final Runnable j;
    public final Handler k;
    public final com.kwad.sdk.glide.c.c l;
    public final CopyOnWriteArrayList<com.kwad.sdk.glide.request.e<Object>> m;
    @GuardedBy("this")
    public com.kwad.sdk.glide.request.f n;

    /* loaded from: classes7.dex */
    public class a implements c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f37742a;
        @GuardedBy("RequestManager.this")

        /* renamed from: b  reason: collision with root package name */
        public final m f37743b;

        public a(g gVar, @NonNull m mVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, mVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f37742a = gVar;
            this.f37743b = mVar;
        }

        @Override // com.kwad.sdk.glide.c.c.a
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && z) {
                synchronized (this.f37742a) {
                    this.f37743b.d();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1341723449, "Lcom/kwad/sdk/glide/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1341723449, "Lcom/kwad/sdk/glide/g;");
                return;
            }
        }
        f37732d = com.kwad.sdk.glide.request.f.b(Bitmap.class).i();
        f37733e = com.kwad.sdk.glide.request.f.b(com.kwad.sdk.glide.load.resource.d.c.class).i();
        f37734f = com.kwad.sdk.glide.request.f.b(com.kwad.sdk.glide.load.engine.h.f38087c).a(Priority.LOW).b(true);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public g(@NonNull c cVar, @NonNull com.kwad.sdk.glide.c.h hVar, @NonNull l lVar, @NonNull Context context) {
        this(cVar, hVar, lVar, new m(), cVar.d(), context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar, hVar, lVar, context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((c) objArr2[0], (com.kwad.sdk.glide.c.h) objArr2[1], (l) objArr2[2], (m) objArr2[3], (com.kwad.sdk.glide.c.d) objArr2[4], (Context) objArr2[5]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public g(c cVar, com.kwad.sdk.glide.c.h hVar, l lVar, m mVar, com.kwad.sdk.glide.c.d dVar, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar, hVar, lVar, mVar, dVar, context};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f37740i = new o();
        this.j = new Runnable(this) { // from class: com.kwad.sdk.glide.g.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ g f37741a;

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
                this.f37741a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    g gVar = this.f37741a;
                    gVar.f37737c.a(gVar);
                }
            }
        };
        this.k = new Handler(Looper.getMainLooper());
        this.f37735a = cVar;
        this.f37737c = hVar;
        this.f37739h = lVar;
        this.f37738g = mVar;
        this.f37736b = context;
        this.l = dVar.a(context.getApplicationContext(), new a(this, mVar));
        if (k.c()) {
            this.k.post(this.j);
        } else {
            hVar.a(this);
        }
        hVar.a(this.l);
        this.m = new CopyOnWriteArrayList<>(cVar.e().a());
        a(cVar.e().b());
        cVar.a(this);
    }

    private void c(@NonNull j<?> jVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, this, jVar) == null) || b(jVar) || this.f37735a.a(jVar) || jVar.b() == null) {
            return;
        }
        com.kwad.sdk.glide.request.c b2 = jVar.b();
        jVar.a((com.kwad.sdk.glide.request.c) null);
        b2.b();
    }

    @NonNull
    @CheckResult
    public <ResourceType> f<ResourceType> a(@NonNull Class<ResourceType> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cls)) == null) ? new f<>(this.f37735a, this, cls, this.f37736b) : (f) invokeL.objValue;
    }

    @NonNull
    @CheckResult
    public f<Drawable> a(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? g().a(str) : (f) invokeL.objValue;
    }

    public synchronized void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                this.f37738g.a();
            }
        }
    }

    public synchronized void a(@Nullable j<?> jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, jVar) == null) {
            synchronized (this) {
                if (jVar == null) {
                    return;
                }
                c(jVar);
            }
        }
    }

    public synchronized void a(@NonNull j<?> jVar, @NonNull com.kwad.sdk.glide.request.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, jVar, cVar) == null) {
            synchronized (this) {
                this.f37740i.a(jVar);
                this.f37738g.a(cVar);
            }
        }
    }

    public synchronized void a(@NonNull com.kwad.sdk.glide.request.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fVar) == null) {
            synchronized (this) {
                this.n = fVar.clone().j();
            }
        }
    }

    @NonNull
    public <T> h<?, T> b(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, cls)) == null) ? this.f37735a.e().a(cls) : (h) invokeL.objValue;
    }

    public synchronized void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            synchronized (this) {
                this.f37738g.b();
            }
        }
    }

    public synchronized boolean b(@NonNull j<?> jVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jVar)) == null) {
            synchronized (this) {
                com.kwad.sdk.glide.request.c b2 = jVar.b();
                if (b2 == null) {
                    return true;
                }
                if (this.f37738g.b(b2)) {
                    this.f37740i.b(jVar);
                    jVar.a((com.kwad.sdk.glide.request.c) null);
                    return true;
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // com.kwad.sdk.glide.c.i
    public synchronized void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            synchronized (this) {
                b();
                this.f37740i.c();
            }
        }
    }

    @Override // com.kwad.sdk.glide.c.i
    public synchronized void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            synchronized (this) {
                a();
                this.f37740i.d();
            }
        }
    }

    @Override // com.kwad.sdk.glide.c.i
    public synchronized void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            synchronized (this) {
                this.f37740i.e();
                for (j<?> jVar : this.f37740i.a()) {
                    a(jVar);
                }
                this.f37740i.b();
                this.f37738g.c();
                this.f37737c.b(this);
                this.f37737c.b(this.l);
                this.k.removeCallbacks(this.j);
                this.f37735a.b(this);
            }
        }
    }

    @NonNull
    @CheckResult
    public f<Bitmap> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? a(Bitmap.class).a((com.kwad.sdk.glide.request.a<?>) f37732d) : (f) invokeV.objValue;
    }

    @NonNull
    @CheckResult
    public f<Drawable> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? a(Drawable.class) : (f) invokeV.objValue;
    }

    public List<com.kwad.sdk.glide.request.e<Object>> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.m : (List) invokeV.objValue;
    }

    public synchronized com.kwad.sdk.glide.request.f i() {
        InterceptResult invokeV;
        com.kwad.sdk.glide.request.f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            synchronized (this) {
                fVar = this.n;
            }
            return fVar;
        }
        return (com.kwad.sdk.glide.request.f) invokeV.objValue;
    }

    public synchronized String toString() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            synchronized (this) {
                str = super.toString() + "{tracker=" + this.f37738g + ", treeNode=" + this.f37739h + "}";
            }
            return str;
        }
        return (String) invokeV.objValue;
    }
}
