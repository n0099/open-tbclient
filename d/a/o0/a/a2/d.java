package d.a.o0.a.a2;

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
import d.a.o0.a.a2.i;
import d.a.o0.a.f1.e.f.c;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
/* loaded from: classes7.dex */
public abstract class d extends d.a.o0.a.a2.a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean m;
    public static volatile d n;
    public static Handler o;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public d.a.o0.a.p.a f43872e;

    /* renamed from: f  reason: collision with root package name */
    public final Set<d.a.o0.a.v2.e1.b<i.a>> f43873f;

    /* renamed from: g  reason: collision with root package name */
    public volatile int f43874g;

    /* renamed from: h  reason: collision with root package name */
    public final Queue<Runnable> f43875h;

    /* renamed from: i  reason: collision with root package name */
    public Runnable f43876i;
    public d.a.o0.n.i.g j;
    public d.a.o0.a.c2.f.g0.a k;
    public boolean l;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i.a f43877e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f43878f;

        /* renamed from: d.a.o0.a.a2.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC0642a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.o0.a.v2.e1.b f43879e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f43880f;

            public RunnableC0642a(a aVar, d.a.o0.a.v2.e1.b bVar) {
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
                this.f43880f = aVar;
                this.f43879e = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f43879e.onCallback(this.f43880f.f43877e);
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
            this.f43878f = dVar;
            this.f43877e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean z = Looper.getMainLooper() == Looper.myLooper();
                for (d.a.o0.a.v2.e1.b bVar : this.f43878f.f43873f) {
                    if (z && !this.f43877e.e("event_flag_force_post", false)) {
                        bVar.onCallback(this.f43877e);
                    } else {
                        d.i().post(new RunnableC0642a(this, bVar));
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.v2.e1.b f43881e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f43882f;

        public b(d dVar, d.a.o0.a.v2.e1.b bVar) {
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
            this.f43882f = dVar;
            this.f43881e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f43882f.f43873f.add(this.f43881e);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.v2.e1.b f43883e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f43884f;

        public c(d dVar, d.a.o0.a.v2.e1.b bVar) {
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
            this.f43884f = dVar;
            this.f43883e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f43884f.f43873f.remove(this.f43883e);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(503556894, "Ld/a/o0/a/a2/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(503556894, "Ld/a/o0/a/a2/d;");
                return;
            }
        }
        m = d.a.o0.a.k.f46335a;
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
        this.f43873f = new HashSet();
        this.f43874g = 0;
        this.f43875h = new ArrayDeque();
        this.f43876i = null;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
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
                        n = new d.a.o0.a.a2.c();
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

    @Override // d.a.o0.a.a2.h
    public void A(i.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            if (m) {
                Log.i("SwanImpl", "SwanEvent dispatchEvent: " + aVar + " mEventCallbacks:" + this.f43873f.size());
            }
            if (aVar != null) {
                E(new a(this, aVar));
            }
        }
    }

    @Override // d.a.o0.a.a2.h
    public d.a.o0.a.c2.f.g0.a B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.k == null) {
                this.k = f();
            }
            return this.k;
        }
        return (d.a.o0.a.c2.f.g0.a) invokeV.objValue;
    }

    public final void D() {
        d.a.o0.a.c2.f.g0.a B;
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
                this.f43875h.offer(runnable);
                if (this.f43876i == null) {
                    while (!this.f43875h.isEmpty()) {
                        Runnable poll = this.f43875h.poll();
                        this.f43876i = poll;
                        if (poll != null) {
                            poll.run();
                        }
                        this.f43876i = null;
                    }
                }
            }
        }
    }

    public abstract d.a.o0.n.i.g e();

    public abstract d.a.o0.a.c2.f.g0.a f();

    public d.a.o0.n.i.g j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.j == null) {
                this.j = e();
            }
            return this.j;
        }
        return (d.a.o0.n.i.g) invokeV.objValue;
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.l) {
            return;
        }
        D();
        j();
        d.a.o0.a.v1.b.c.G();
        this.l = true;
    }

    @Override // d.a.o0.a.a2.h
    public void p(d.a.o0.a.v2.e1.b<i.a> bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) || bVar == null) {
            return;
        }
        E(new c(this, bVar));
    }

    @Override // d.a.o0.a.a2.h
    public void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            w(str, null);
        }
    }

    @Override // d.a.o0.a.a2.h
    public void v(d.a.o0.a.v2.e1.b<i.a> bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, bVar) == null) || bVar == null) {
            return;
        }
        E(new b(this, bVar));
    }

    @Override // d.a.o0.a.a2.h
    public void w(String str, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, str, bundle) == null) {
            A(new i.a(str, bundle));
        }
    }

    @Override // d.a.o0.a.a2.h
    public d.a.o0.a.p.a y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (this.f43872e == null) {
                this.f43872e = new d.a.o0.a.p.a();
            }
            return this.f43872e;
        }
        return (d.a.o0.a.p.a) invokeV.objValue;
    }
}
