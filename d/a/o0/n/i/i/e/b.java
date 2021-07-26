package d.a.o0.n.i.i.e;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.n.i.i.g.f;
import d.a.o0.n.i.i.g.g;
import d.a.o0.n.i.i.g.l;
import d.a.o0.n.i.l.a;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c f51161a;

    /* renamed from: b  reason: collision with root package name */
    public BlockingQueue<Runnable> f51162b;

    /* renamed from: c  reason: collision with root package name */
    public ThreadPoolExecutor f51163c;

    /* renamed from: d  reason: collision with root package name */
    public f f51164d;

    /* renamed from: e  reason: collision with root package name */
    public final AtomicBoolean f51165e;
    @SuppressLint({"SyntheticAccessor"})

    /* renamed from: f  reason: collision with root package name */
    public final d.a.o0.n.i.i.g.b f51166f;

    /* renamed from: g  reason: collision with root package name */
    public final l f51167g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.o0.n.i.i.g.a f51168h;

    /* loaded from: classes7.dex */
    public class a implements d.a.o0.n.i.i.g.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f51169a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51169a = bVar;
        }

        @Override // d.a.o0.n.i.i.g.b
        public <T> void a(f<T> fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                this.f51169a.f51164d = fVar;
            }
        }

        @Override // d.a.o0.n.i.i.g.b
        public <T> void b(f<T> fVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar) == null) && this.f51169a.f51164d == fVar) {
                this.f51169a.f51164d = null;
            }
        }
    }

    /* renamed from: d.a.o0.n.i.i.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1154b implements d.a.o0.n.i.i.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f51170a;

        public C1154b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51170a = bVar;
        }

        @Override // d.a.o0.n.i.i.g.a
        public Runnable a(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) ? this.f51170a.d(z) : (Runnable) invokeZ.objValue;
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f51165e = new AtomicBoolean(false);
        a aVar = new a(this);
        this.f51166f = aVar;
        this.f51167g = new l(aVar);
        this.f51168h = new C1154b(this);
        this.f51161a = new c();
        this.f51162b = new LinkedBlockingQueue();
        this.f51163c = new ThreadPoolExecutor(1, 1, 1L, TimeUnit.SECONDS, this.f51162b);
        c(this.f51161a);
    }

    public void c(d.a.o0.n.i.i.g.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.f51167g.c(bVar);
        }
    }

    public synchronized Runnable d(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
            synchronized (this) {
                if (this.f51161a != null) {
                    if (z) {
                        return this.f51161a.g();
                    }
                    return this.f51161a.i();
                }
                return null;
            }
        }
        return (Runnable) invokeZ.objValue;
    }

    public synchronized boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            synchronized (this) {
                if (this.f51164d == null) {
                    return false;
                }
                Object f2 = this.f51164d.f();
                if (f2 instanceof d.a.o0.n.h.f) {
                    d.a.o0.n.h.f fVar = (d.a.o0.n.h.f) f2;
                    if (d.a.o0.n.c.f51112a) {
                        Log.v("PMSThreadQueue", "Current PMSPkgMain appId: " + fVar.f51140g + ", checking id: " + str);
                    }
                    return TextUtils.equals(fVar.f51140g, str);
                } else if (f2 instanceof a.C1155a) {
                    a.C1155a c1155a = (a.C1155a) f2;
                    if (d.a.o0.n.c.f51112a) {
                        Log.v("PMSThreadQueue", "Current Item appId: " + c1155a.f51210b + ", checking id: " + str);
                    }
                    return TextUtils.equals(c1155a.f51210b, str);
                } else {
                    if (d.a.o0.n.c.f51112a) {
                        Log.v("PMSThreadQueue", "Current model type not match: " + f2.getClass().getSimpleName());
                    }
                    return false;
                }
            }
        }
        return invokeL.booleanValue;
    }

    public synchronized boolean f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            synchronized (this) {
                Iterator<f> f2 = this.f51161a.f();
                while (f2.hasNext()) {
                    f next = f2.next();
                    if (next != null) {
                        Object f3 = next.f();
                        if (f3 instanceof d.a.o0.n.h.f) {
                            d.a.o0.n.h.f fVar = (d.a.o0.n.h.f) f3;
                            if (d.a.o0.n.c.f51112a) {
                                Log.v("PMSThreadQueue", "Queue PMSPkgMain appId: " + fVar.f51140g + ", checking id: " + str);
                            }
                            if (TextUtils.equals(fVar.f51140g, str)) {
                                return true;
                            }
                        } else if (f3 instanceof a.C1155a) {
                            a.C1155a c1155a = (a.C1155a) f3;
                            if (d.a.o0.n.c.f51112a) {
                                Log.v("PMSThreadQueue", "Queue Item appId: " + c1155a.f51210b + ", checking id: " + str);
                            }
                            if (TextUtils.equals(c1155a.f51210b, str)) {
                                return true;
                            }
                        } else if (d.a.o0.n.c.f51112a) {
                            Log.v("PMSThreadQueue", "Queue model type not match: " + f3.getClass().getSimpleName());
                        }
                    }
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public synchronized <T> void g(f<T> fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, fVar) == null) {
            synchronized (this) {
                this.f51161a.h(fVar);
                if (d.a.o0.n.c.f51112a) {
                    Log.d("PMSThreadQueue", "put Task:" + fVar);
                    Log.d("PMSThreadQueue", "current WaitingQueue===>" + this.f51161a);
                    Log.d("PMSThreadQueue", "current WorkingQueue===>" + this.f51162b);
                }
            }
        }
    }

    public synchronized <T> void h(f<T> fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fVar) == null) {
            synchronized (this) {
                g(fVar);
                j();
            }
        }
    }

    public void i(d.a.o0.n.i.i.g.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            this.f51167g.d(bVar);
        }
    }

    public synchronized void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            synchronized (this) {
                if (this.f51162b.size() < 1) {
                    this.f51163c.execute(new g(this.f51165e, this.f51167g, this.f51168h));
                }
            }
        }
    }
}
