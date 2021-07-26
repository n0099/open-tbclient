package d.a.o0.a.h0.i;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.h0.i.a;
import d.a.o0.a.h0.i.g;
import d.a.o0.a.k;
import d.a.o0.a.v2.q0;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.TreeMap;
/* loaded from: classes7.dex */
public final class i {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45313a;

    /* renamed from: b  reason: collision with root package name */
    public static c f45314b;

    /* renamed from: c  reason: collision with root package name */
    public static LinkedHashMap<String, String> f45315c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g.a f45316a;

        public a(g.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45316a = aVar;
        }

        @Override // d.a.o0.a.h0.i.g.a
        public void a(@NonNull g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, gVar) == null) {
                this.f45316a.a(gVar);
                i.r(gVar);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.v2.e1.b f45317a;

        public b(d.a.o0.a.v2.e1.b bVar) {
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
            this.f45317a = bVar;
        }

        @Override // d.a.o0.a.h0.i.g.a
        public void a(@NonNull g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, gVar) == null) {
                if (TextUtils.isEmpty(i.f45314b.f45323f)) {
                    i.f45314b.f45323f = d.a.o0.a.h0.i.c.b("", gVar);
                }
                d.a.o0.a.v2.e1.b bVar = this.f45317a;
                if (bVar != null) {
                    bVar.onCallback(i.f45314b.r(i.f45314b.f45323f));
                }
                if (i.f45313a) {
                    Log.d("SwanAppLaunchTips", String.format("getLaunchInfo by click, consume time: %d ms，detail:%s", Long.valueOf(System.currentTimeMillis() - i.f45314b.s()), i.f45314b.f45323f));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f45336a;

        /* renamed from: b  reason: collision with root package name */
        public long f45337b;

        /* renamed from: c  reason: collision with root package name */
        public int f45338c;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public d(String str, long j, long j2) {
            this(str, j, j2, 200);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r9;
                Object[] objArr = {str, Long.valueOf(j), Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((String) objArr2[0], ((Long) objArr2[1]).longValue(), ((Long) objArr2[2]).longValue(), ((Integer) objArr2[3]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public d(String str, long j, long j2, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f45336a = str;
            this.f45337b = j2;
            this.f45338c = i2;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(447311592, "Ld/a/o0/a/h0/i/i;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(447311592, "Ld/a/o0/a/h0/i/i;");
                return;
            }
        }
        f45313a = k.f46335a;
    }

    public static void c() {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65539, null) == null) || (cVar = f45314b) == null) {
            return;
        }
        cVar.o();
    }

    public static void d(g.a aVar) {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, aVar) == null) || (cVar = f45314b) == null) {
            return;
        }
        cVar.q(aVar);
    }

    public static synchronized void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null) == null) {
            synchronized (i.class) {
                if (f45314b != null) {
                    e.e();
                    f45314b.n();
                }
                f45314b = new c(null);
                if (f45315c != null) {
                    for (Map.Entry<String, String> entry : f45315c.entrySet()) {
                        f45314b.w(entry.getKey(), entry.getValue());
                    }
                    f45314b.K(true);
                    f45315c = null;
                }
            }
        }
    }

    public static void f(d.a.o0.a.v2.e1.b<String> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, bVar) == null) {
            c cVar = f45314b;
            if (cVar == null) {
                if (bVar != null) {
                    bVar.onCallback("");
                }
            } else if (cVar.v() && !TextUtils.isEmpty(f45314b.f45323f)) {
                if (bVar != null) {
                    c cVar2 = f45314b;
                    bVar.onCallback(cVar2.r(cVar2.f45323f));
                }
            } else if (!f45314b.u() || TextUtils.isEmpty(f45314b.f45323f)) {
                f45314b.q(new b(bVar));
            } else if (bVar != null) {
                c cVar3 = f45314b;
                bVar.onCallback(cVar3.r(cVar3.f45323f));
            }
        }
    }

    public static boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            c cVar = f45314b;
            if (cVar == null) {
                return false;
            }
            return cVar.t();
        }
        return invokeV.booleanValue;
    }

    public static void h(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65544, null, z) == null) || d.a.o0.a.a2.d.g().l() == 1) {
            return;
        }
        e();
        v();
        u();
        if (z) {
            t();
        }
    }

    public static void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, str) == null) {
            j(str, d.a.o0.a.v2.k.g(System.currentTimeMillis(), "【HH:mm:ss】"));
        }
    }

    public static void j(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, str, str2) == null) {
            c cVar = f45314b;
            if (cVar != null) {
                cVar.w(str, str2);
                return;
            }
            if (f45315c == null) {
                f45315c = new LinkedHashMap<>();
            }
            f45315c.put(str, str2);
        }
    }

    public static void k() {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65547, null) == null) || (cVar = f45314b) == null) {
            return;
        }
        cVar.x();
    }

    public static void l(long j) {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(65548, null, j) == null) || (cVar = f45314b) == null) {
            return;
        }
        cVar.y(j);
    }

    public static void m(a.C0743a c0743a) {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65549, null, c0743a) == null) || (cVar = f45314b) == null) {
            return;
        }
        cVar.z(c0743a);
    }

    public static void n(String str, int i2) {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65550, null, str, i2) == null) || (cVar = f45314b) == null) {
            return;
        }
        cVar.A(str, i2);
    }

    public static void o(String str) {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65551, null, str) == null) || (cVar = f45314b) == null) {
            return;
        }
        cVar.B(str);
    }

    public static void p(String str, long j) {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(65552, null, str, j) == null) || (cVar = f45314b) == null) {
            return;
        }
        cVar.C(str, j);
    }

    public static void q(int i2) {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65553, null, i2) == null) || (cVar = f45314b) == null) {
            return;
        }
        cVar.J(i2);
    }

    public static void r(g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65554, null, gVar) == null) || gVar == null) {
            return;
        }
        int i2 = d.a.o0.a.h.swanapp_tip_request_default;
        int d2 = gVar.d();
        d.a.o0.a.h0.i.a c2 = gVar.c();
        if (c2 != null && c2.c()) {
            i2 = d.a.o0.a.h.swanapp_tip_show_js_error;
        } else if (d2 != 1 && d2 != 2) {
            int f2 = gVar.f();
            if (f2 == 4) {
                i2 = d.a.o0.a.h.swanapp_tip_request_fail;
            } else if (f2 == 8) {
                i2 = d.a.o0.a.h.swanapp_tip_request_slow;
            }
        } else {
            i2 = d.a.o0.a.h.swanapp_tip_request_bad_network;
        }
        e.f(i2);
    }

    public static void s(g.a aVar) {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65555, null, aVar) == null) || (cVar = f45314b) == null) {
            return;
        }
        cVar.q(new a(aVar));
    }

    public static void t() {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65556, null) == null) || (cVar = f45314b) == null) {
            return;
        }
        cVar.L();
    }

    public static void u() {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65557, null) == null) || (cVar = f45314b) == null) {
            return;
        }
        cVar.M();
    }

    public static synchronized void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65558, null) == null) {
            synchronized (i.class) {
                if (f45314b != null) {
                    f45314b.N();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class c {
        public static /* synthetic */ Interceptable $ic;
        public static final long p;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f45318a;

        /* renamed from: b  reason: collision with root package name */
        public List<d> f45319b;

        /* renamed from: c  reason: collision with root package name */
        public List<d> f45320c;

        /* renamed from: d  reason: collision with root package name */
        public List<d> f45321d;

        /* renamed from: e  reason: collision with root package name */
        public volatile boolean f45322e;

        /* renamed from: f  reason: collision with root package name */
        public String f45323f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f45324g;

        /* renamed from: h  reason: collision with root package name */
        public Timer f45325h;

        /* renamed from: i  reason: collision with root package name */
        public Timer f45326i;
        public Timer j;
        public long k;
        public int l;
        public d.a.o0.a.h0.i.a m;
        public boolean n;
        public long o;

        /* loaded from: classes7.dex */
        public class a extends TimerTask {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f45327e;

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f45327e = cVar;
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f45327e.f45322e = false;
                    this.f45327e.H();
                }
            }
        }

        /* loaded from: classes7.dex */
        public class b extends d.a.o0.a.t0.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ SwanAppActivity f45328a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ c f45329b;

            public b(c cVar, SwanAppActivity swanAppActivity) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, swanAppActivity};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f45329b = cVar;
                this.f45328a = swanAppActivity;
            }

            @Override // d.a.o0.a.t0.a, d.a.o0.a.t0.b
            public void f() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f45329b.I()) {
                    this.f45328a.unregisterCallback(this);
                }
            }
        }

        /* renamed from: d.a.o0.a.h0.i.i$c$c  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0745c implements SwanAppNetworkUtils.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ g f45330a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ g.a f45331b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ c f45332c;

            public C0745c(c cVar, g gVar, g.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, gVar, aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f45332c = cVar;
                this.f45330a = gVar;
                this.f45331b = aVar;
            }

            @Override // com.baidu.swan.apps.network.SwanAppNetworkUtils.b
            public void onResult(int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                    if (i2 == 1) {
                        this.f45330a.j(0);
                    } else if (i2 == 2) {
                        this.f45330a.j(1);
                    } else if (i2 != 3) {
                        this.f45330a.j(3);
                    } else {
                        this.f45330a.j(2);
                    }
                    if (this.f45332c.f45320c.size() + this.f45332c.f45319b.size() + this.f45332c.f45321d.size() > 2 && System.currentTimeMillis() - this.f45332c.k >= 3000) {
                        if (!this.f45332c.E(this.f45330a)) {
                            if (this.f45332c.F(this.f45330a)) {
                                this.f45330a.k(8);
                                this.f45331b.a(this.f45330a);
                                return;
                            }
                            this.f45331b.a(this.f45330a);
                            return;
                        }
                        this.f45330a.k(4);
                        this.f45331b.a(this.f45330a);
                        return;
                    }
                    this.f45330a.k(12);
                    this.f45331b.a(this.f45330a);
                }
            }
        }

        /* loaded from: classes7.dex */
        public class d extends TimerTask {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f45333e;

            /* loaded from: classes7.dex */
            public class a implements g.a {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                public a(d dVar) {
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
                        }
                    }
                }

                @Override // d.a.o0.a.h0.i.g.a
                public void a(@NonNull g gVar) {
                    Interceptable interceptable = $ic;
                    if ((interceptable == null || interceptable.invokeL(1048576, this, gVar) == null) && q0.H()) {
                        f.c("fcp_timeout", gVar);
                        int d2 = gVar.d();
                        if (d2 == 1) {
                            i.i(d.a.o0.a.h0.i.c.b(d.a.o0.a.h0.i.c.f45298a, gVar));
                            d.a.o0.a.h0.i.e.f(d.a.o0.a.h.swanapp_tip_net_unavailable);
                        } else if (d2 != 2) {
                            i.i(d.a.o0.a.h0.i.c.b(d.a.o0.a.h0.i.c.f45298a, gVar));
                        } else {
                            i.i(d.a.o0.a.h0.i.c.b(d.a.o0.a.h0.i.c.f45298a, gVar));
                            d.a.o0.a.h0.i.e.f(d.a.o0.a.h.swanapp_tip_net_unavailable);
                        }
                    }
                }
            }

            public d(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f45333e = cVar;
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f45333e.f45318a == 0 && d.a.o0.a.m1.g.f().e() == 0) {
                    this.f45333e.q(new a(this));
                }
            }
        }

        /* loaded from: classes7.dex */
        public class e extends TimerTask {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f45334e;

            /* loaded from: classes7.dex */
            public class a implements g.a {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ e f45335a;

                public a(e eVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {eVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f45335a = eVar;
                }

                @Override // d.a.o0.a.h0.i.g.a
                public void a(@NonNull g gVar) {
                    Interceptable interceptable = $ic;
                    if ((interceptable == null || interceptable.invokeL(1048576, this, gVar) == null) && TextUtils.isEmpty(this.f45335a.f45334e.f45323f)) {
                        this.f45335a.f45334e.f45323f = d.a.o0.a.h0.i.c.b("", gVar);
                        if (i.f45313a) {
                            Log.d("SwanAppLaunchTips", String.format("%d ms countdown end，collect launchInfo：%s", 6000L, this.f45335a.f45334e.f45323f));
                        }
                    }
                }
            }

            public e(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f45334e = cVar;
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !this.f45334e.u() && TextUtils.isEmpty(this.f45334e.f45323f)) {
                    this.f45334e.q(new a(this));
                }
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(369691337, "Ld/a/o0/a/h0/i/i$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(369691337, "Ld/a/o0/a/h0/i/i$c;");
                    return;
                }
            }
            p = d.a.o0.a.c1.a.Z().o();
        }

        public c() {
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
            this.f45318a = 0L;
            this.f45319b = new ArrayList();
            this.f45320c = new ArrayList();
            this.f45321d = new ArrayList();
            this.f45322e = true;
            this.f45323f = "";
            this.f45324g = false;
            this.k = 0L;
            this.l = 0;
            this.m = new d.a.o0.a.h0.i.a();
            this.n = false;
            this.o = s();
        }

        public synchronized void A(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) {
                synchronized (this) {
                    if (this.f45322e) {
                        this.f45321d.add(new d(str, 0L, 0L, i2));
                        D(str);
                    }
                }
            }
        }

        public synchronized void B(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                synchronized (this) {
                    if (this.f45322e) {
                        this.f45319b.add(new d(str, System.currentTimeMillis(), 0L));
                    }
                }
            }
        }

        public synchronized void C(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, str, j) == null) {
                synchronized (this) {
                    if (this.f45322e) {
                        this.f45320c.add(new d(str, 0L, j));
                        D(str);
                    }
                }
            }
        }

        public final void D(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                for (int i2 = 0; i2 < this.f45319b.size(); i2++) {
                    if (TextUtils.equals(this.f45319b.get(i2).f45336a, str)) {
                        List<d> list = this.f45319b;
                        list.remove(list.get(i2));
                        return;
                    }
                }
            }
        }

        public final boolean E(g gVar) {
            InterceptResult invokeL;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, gVar)) == null) {
                ArrayList arrayList = new ArrayList();
                int size = this.f45321d.size();
                int i3 = 0;
                for (int i4 = 0; i4 < size; i4++) {
                    d dVar = this.f45321d.get(i4);
                    if (dVar != null && (i2 = dVar.f45338c) >= 400 && i2 < 600) {
                        i3++;
                        arrayList.add(dVar.f45336a);
                    }
                }
                int size2 = this.f45320c.size() + i3 + this.f45319b.size();
                gVar.f45309c = arrayList;
                gVar.f45308b = size2;
                return ((double) i3) / ((double) size2) >= 0.5d;
            }
            return invokeL.booleanValue;
        }

        public final boolean F(g gVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, gVar)) == null) {
                TreeMap treeMap = new TreeMap();
                int size = this.f45320c.size();
                int i2 = 0;
                for (int i3 = 0; i3 < size; i3++) {
                    d dVar = this.f45320c.get(i3);
                    long j = dVar.f45337b;
                    if (j > 3000) {
                        i2++;
                        treeMap.put(dVar.f45336a, Integer.valueOf((int) j));
                    }
                }
                gVar.f45310d = treeMap;
                return i2 >= 2;
            }
            return invokeL.booleanValue;
        }

        public void G() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                Timer timer = this.f45325h;
                if (timer != null) {
                    timer.cancel();
                    this.f45325h = null;
                }
                this.f45318a = 0L;
            }
        }

        public final void H() {
            Timer timer;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (timer = this.f45326i) == null) {
                return;
            }
            timer.cancel();
            this.f45326i = null;
        }

        public final boolean I() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                if (!this.f45324g || TextUtils.isEmpty(this.f45323f)) {
                    return false;
                }
                d.a.o0.a.h0.i.b.h(s(), this.f45323f);
                this.f45324g = false;
                return true;
            }
            return invokeV.booleanValue;
        }

        public void J(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
                this.l = i2;
            }
        }

        public void K(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
                this.f45324g = z;
            }
        }

        public void L() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
                G();
                Timer timer = new Timer();
                this.f45325h = timer;
                timer.schedule(new d(this), 3000L);
            }
        }

        public void M() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
                Timer timer = this.j;
                if (timer != null) {
                    timer.cancel();
                    this.j = null;
                }
                Timer timer2 = new Timer();
                this.j = timer2;
                timer2.schedule(new e(this), 6000L);
            }
        }

        public void N() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && this.f45322e) {
                this.k = System.currentTimeMillis();
                Timer timer = new Timer();
                this.f45326i = timer;
                timer.schedule(new a(this), 6000L);
                SwanAppActivity activity = d.a.o0.a.g1.f.V().getActivity();
                if (activity == null || activity.isFinishing()) {
                    return;
                }
                activity.registerCallback(new b(this, activity));
            }
        }

        public void n() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
                H();
            }
        }

        public void o() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && this.l == 1) {
                if (!TextUtils.equals(d.a.o0.a.g1.f.V().U(), d.a.o0.a.h0.i.d.a())) {
                    if (i.f45313a) {
                        Log.d("SwanAppLaunchTips", "current page is not skeleton error first page");
                        Log.d("SwanAppLaunchTips", "current page: " + d.a.o0.a.g1.f.V().U());
                        String a2 = d.a.o0.a.h0.i.d.a();
                        StringBuilder sb = new StringBuilder();
                        sb.append("skeleton error first page: ");
                        if (a2 == null) {
                            a2 = "";
                        }
                        sb.append(a2);
                        Log.d("SwanAppLaunchTips", sb.toString());
                        return;
                    }
                    return;
                }
                String D = d.a.o0.a.g1.f.V().D();
                if (TextUtils.isEmpty(D)) {
                    return;
                }
                d.a.o0.a.g1.f.V().m(D, new d.a.o0.a.o0.d.b("check-skeleton-status"));
            }
        }

        public void p(SwanAppNetworkUtils.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048592, this, bVar) == null) {
                this.f45324g = true;
                SwanAppNetworkUtils.b(bVar);
            }
        }

        public void q(g.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048593, this, aVar) == null) {
                g gVar = new g();
                gVar.h(System.currentTimeMillis() - this.k);
                gVar.i(this.m);
                p(new C0745c(this, gVar, aVar));
            }
        }

        public String r(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, str)) == null) {
                StringBuilder sb = new StringBuilder(d.a.o0.a.c1.a.b().getText(d.a.o0.a.h.swanapp_tip_cur_title));
                sb.append(str);
                String e2 = d.a.o0.a.h0.i.b.e();
                if (!TextUtils.isEmpty(e2)) {
                    sb.append(e2);
                }
                return sb.toString();
            }
            return (String) invokeL.objValue;
        }

        public final long s() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
                d.a.o0.a.a2.e Q = d.a.o0.a.a2.e.Q();
                if (Q != null) {
                    return Q.L().l("launch_time", 0L);
                }
                return 0L;
            }
            return invokeV.longValue;
        }

        public boolean t() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.m.c() : invokeV.booleanValue;
        }

        public boolean u() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.n : invokeV.booleanValue;
        }

        public boolean v() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
                return System.currentTimeMillis() - this.o > ((long) ((p > 6000L ? 1 : (p == 6000L ? 0 : -1)) >= 0 ? 10000 : 7000));
            }
            return invokeV.booleanValue;
        }

        public void w(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048599, this, str, str2) == null) {
                if (v()) {
                    d.a.o0.a.e0.d.h("SwanAppLaunchTips", "the log has expired, content=" + str2 + str);
                    return;
                }
                String str3 = "\n" + str2 + str;
                if (!TextUtils.isEmpty(this.f45323f)) {
                    str3 = this.f45323f + str3;
                }
                this.f45323f = str3;
                if (i.f45313a) {
                    Log.d("SwanAppLaunchTips", str);
                }
                d.a.o0.a.e0.d.h("SwanAppLaunchTips", str2 + str);
            }
        }

        public void x() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
                this.n = true;
            }
        }

        public void y(long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeJ(1048601, this, j) == null) && this.f45318a == 0) {
                this.f45318a = j;
            }
        }

        public void z(@NonNull a.C0743a c0743a) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048602, this, c0743a) == null) {
                boolean z = u() || v();
                if (i.f45313a) {
                    Log.d("SwanAppLaunchTips", String.format("onJsError needFilter ?: %s, content:%s", Boolean.valueOf(z), c0743a.toString()));
                }
                if (z) {
                    return;
                }
                this.m.a(c0743a);
            }
        }

        public /* synthetic */ c(h hVar) {
            this();
        }
    }
}
