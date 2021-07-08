package d.a.n0.n.i.i.e;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.n.i.i.g.f;
import d.a.n0.n.i.i.g.g;
import d.a.n0.n.i.i.g.l;
import d.a.n0.n.i.l.a;
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
    public c f50657a;

    /* renamed from: b  reason: collision with root package name */
    public BlockingQueue<Runnable> f50658b;

    /* renamed from: c  reason: collision with root package name */
    public ThreadPoolExecutor f50659c;

    /* renamed from: d  reason: collision with root package name */
    public f f50660d;

    /* renamed from: e  reason: collision with root package name */
    public final AtomicBoolean f50661e;
    @SuppressLint({"SyntheticAccessor"})

    /* renamed from: f  reason: collision with root package name */
    public final d.a.n0.n.i.i.g.b f50662f;

    /* renamed from: g  reason: collision with root package name */
    public final l f50663g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.n0.n.i.i.g.a f50664h;

    /* loaded from: classes7.dex */
    public class a implements d.a.n0.n.i.i.g.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f50665a;

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
            this.f50665a = bVar;
        }

        @Override // d.a.n0.n.i.i.g.b
        public <T> void a(f<T> fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                this.f50665a.f50660d = fVar;
            }
        }

        @Override // d.a.n0.n.i.i.g.b
        public <T> void b(f<T> fVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar) == null) && this.f50665a.f50660d == fVar) {
                this.f50665a.f50660d = null;
            }
        }
    }

    /* renamed from: d.a.n0.n.i.i.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1145b implements d.a.n0.n.i.i.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f50666a;

        public C1145b(b bVar) {
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
            this.f50666a = bVar;
        }

        @Override // d.a.n0.n.i.i.g.a
        public Runnable a(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) ? this.f50666a.d(z) : (Runnable) invokeZ.objValue;
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
        this.f50661e = new AtomicBoolean(false);
        a aVar = new a(this);
        this.f50662f = aVar;
        this.f50663g = new l(aVar);
        this.f50664h = new C1145b(this);
        this.f50657a = new c();
        this.f50658b = new LinkedBlockingQueue();
        this.f50659c = new ThreadPoolExecutor(1, 1, 1L, TimeUnit.SECONDS, this.f50658b);
        c(this.f50657a);
    }

    public void c(d.a.n0.n.i.i.g.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.f50663g.c(bVar);
        }
    }

    public synchronized Runnable d(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
            synchronized (this) {
                if (this.f50657a != null) {
                    if (z) {
                        return this.f50657a.g();
                    }
                    return this.f50657a.i();
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
                if (this.f50660d == null) {
                    return false;
                }
                Object f2 = this.f50660d.f();
                if (f2 instanceof d.a.n0.n.h.f) {
                    d.a.n0.n.h.f fVar = (d.a.n0.n.h.f) f2;
                    if (d.a.n0.n.c.f50608a) {
                        Log.v("PMSThreadQueue", "Current PMSPkgMain appId: " + fVar.f50636g + ", checking id: " + str);
                    }
                    return TextUtils.equals(fVar.f50636g, str);
                } else if (f2 instanceof a.C1146a) {
                    a.C1146a c1146a = (a.C1146a) f2;
                    if (d.a.n0.n.c.f50608a) {
                        Log.v("PMSThreadQueue", "Current Item appId: " + c1146a.f50706b + ", checking id: " + str);
                    }
                    return TextUtils.equals(c1146a.f50706b, str);
                } else {
                    if (d.a.n0.n.c.f50608a) {
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
                Iterator<f> f2 = this.f50657a.f();
                while (f2.hasNext()) {
                    f next = f2.next();
                    if (next != null) {
                        Object f3 = next.f();
                        if (f3 instanceof d.a.n0.n.h.f) {
                            d.a.n0.n.h.f fVar = (d.a.n0.n.h.f) f3;
                            if (d.a.n0.n.c.f50608a) {
                                Log.v("PMSThreadQueue", "Queue PMSPkgMain appId: " + fVar.f50636g + ", checking id: " + str);
                            }
                            if (TextUtils.equals(fVar.f50636g, str)) {
                                return true;
                            }
                        } else if (f3 instanceof a.C1146a) {
                            a.C1146a c1146a = (a.C1146a) f3;
                            if (d.a.n0.n.c.f50608a) {
                                Log.v("PMSThreadQueue", "Queue Item appId: " + c1146a.f50706b + ", checking id: " + str);
                            }
                            if (TextUtils.equals(c1146a.f50706b, str)) {
                                return true;
                            }
                        } else if (d.a.n0.n.c.f50608a) {
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
                this.f50657a.h(fVar);
                if (d.a.n0.n.c.f50608a) {
                    Log.d("PMSThreadQueue", "put Task:" + fVar);
                    Log.d("PMSThreadQueue", "current WaitingQueue===>" + this.f50657a);
                    Log.d("PMSThreadQueue", "current WorkingQueue===>" + this.f50658b);
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

    public void i(d.a.n0.n.i.i.g.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            this.f50663g.d(bVar);
        }
    }

    public synchronized void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            synchronized (this) {
                if (this.f50658b.size() < 1) {
                    this.f50659c.execute(new g(this.f50661e, this.f50663g, this.f50664h));
                }
            }
        }
    }
}
