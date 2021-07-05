package d.a.q0.a.a2;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.a2.i;
import d.a.q0.a.f1.e.f.c;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
/* loaded from: classes8.dex */
public abstract class d extends d.a.q0.a.a2.a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean m;
    public static volatile d n;
    public static Handler o;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public d.a.q0.a.p.a f46670e;

    /* renamed from: f  reason: collision with root package name */
    public final Set<d.a.q0.a.v2.e1.b<i.a>> f46671f;

    /* renamed from: g  reason: collision with root package name */
    public volatile int f46672g;

    /* renamed from: h  reason: collision with root package name */
    public final Queue<Runnable> f46673h;

    /* renamed from: i  reason: collision with root package name */
    public Runnable f46674i;
    public d.a.q0.n.i.g j;
    public d.a.q0.a.c2.f.g0.a k;
    public boolean l;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i.a f46675e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f46676f;

        /* renamed from: d.a.q0.a.a2.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC0684a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.q0.a.v2.e1.b f46677e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f46678f;

            public RunnableC0684a(a aVar, d.a.q0.a.v2.e1.b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f46678f = aVar;
                this.f46677e = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f46677e.onCallback(this.f46678f.f46675e);
                }
            }
        }

        public a(d dVar, i.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46676f = dVar;
            this.f46675e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean z = Looper.getMainLooper() == Looper.myLooper();
                for (d.a.q0.a.v2.e1.b bVar : this.f46676f.f46671f) {
                    if (z && !this.f46675e.e("event_flag_force_post", false)) {
                        bVar.onCallback(this.f46675e);
                    } else {
                        d.i().post(new RunnableC0684a(this, bVar));
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.v2.e1.b f46679e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f46680f;

        public b(d dVar, d.a.q0.a.v2.e1.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46680f = dVar;
            this.f46679e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f46680f.f46671f.add(this.f46679e);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.v2.e1.b f46681e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f46682f;

        public c(d dVar, d.a.q0.a.v2.e1.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46682f = dVar;
            this.f46681e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f46682f.f46671f.remove(this.f46681e);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(110529884, "Ld/a/q0/a/a2/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(110529884, "Ld/a/q0/a/a2/d;");
                return;
            }
        }
        m = d.a.q0.a.k.f49133a;
    }

    public d() {
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
        new c.a();
        this.f46671f = new HashSet();
        this.f46672g = 0;
        this.f46673h = new ArrayDeque();
        this.f46674i = null;
        this.l = false;
    }

    public static d g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            d h2 = h();
            if (!h2.l) {
                h2.k();
            }
            return h2;
        }
        return (d) invokeV.objValue;
    }

    public static d h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65540, null)) == null) {
            if (n instanceof j) {
                return n;
            }
            synchronized (d.class) {
                if (n instanceof j) {
                    return n;
                }
                SwanAppProcessInfo current = SwanAppProcessInfo.current();
                if (current.isSwanClient) {
                    n = new j();
                    return n;
                } else if (current.isSwanService) {
                    if (!(n instanceof l)) {
                        n = new l();
                    }
                    return n;
                } else {
                    if (n == null) {
                        n = new d.a.q0.a.a2.c();
                    }
                    return n;
                }
            }
        }
        return (d) invokeV.objValue;
    }

    public static Handler i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            if (o == null) {
                o = new Handler(Looper.getMainLooper());
            }
            return o;
        }
        return (Handler) invokeV.objValue;
    }

    @Override // d.a.q0.a.a2.h
    public void A(i.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            if (m) {
                Log.i("SwanImpl", "SwanEvent dispatchEvent: " + aVar + " mEventCallbacks:" + this.f46671f.size());
            }
            if (aVar != null) {
                E(new a(this, aVar));
            }
        }
    }

    @Override // d.a.q0.a.a2.h
    public d.a.q0.a.c2.f.g0.a B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.k == null) {
                this.k = f();
            }
            return this.k;
        }
        return (d.a.q0.a.c2.f.g0.a) invokeV.objValue;
    }

    public final void D() {
        d.a.q0.a.c2.f.g0.a B;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (B = B()) == null) {
            return;
        }
        B.f();
    }

    public final synchronized void E(@NonNull Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, runnable) == null) {
            synchronized (this) {
                this.f46673h.offer(runnable);
                if (this.f46674i == null) {
                    while (!this.f46673h.isEmpty()) {
                        Runnable poll = this.f46673h.poll();
                        this.f46674i = poll;
                        if (poll != null) {
                            poll.run();
                        }
                        this.f46674i = null;
                    }
                }
            }
        }
    }

    public abstract d.a.q0.n.i.g e();

    public abstract d.a.q0.a.c2.f.g0.a f();

    public d.a.q0.n.i.g j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.j == null) {
                this.j = e();
            }
            return this.j;
        }
        return (d.a.q0.n.i.g) invokeV.objValue;
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.l) {
            return;
        }
        D();
        j();
        d.a.q0.a.v1.b.c.G();
        this.l = true;
    }

    @Override // d.a.q0.a.a2.h
    public void p(d.a.q0.a.v2.e1.b<i.a> bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) || bVar == null) {
            return;
        }
        E(new c(this, bVar));
    }

    @Override // d.a.q0.a.a2.h
    public void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            w(str, null);
        }
    }

    @Override // d.a.q0.a.a2.h
    public void v(d.a.q0.a.v2.e1.b<i.a> bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, bVar) == null) || bVar == null) {
            return;
        }
        E(new b(this, bVar));
    }

    @Override // d.a.q0.a.a2.h
    public void w(String str, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, str, bundle) == null) {
            A(new i.a(str, bundle));
        }
    }

    @Override // d.a.q0.a.a2.h
    public d.a.q0.a.p.a y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (this.f46670e == null) {
                this.f46670e = new d.a.q0.a.p.a();
            }
            return this.f46670e;
        }
        return (d.a.q0.a.p.a) invokeV.objValue;
    }
}
