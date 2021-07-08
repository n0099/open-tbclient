package d.a.n0.a.h0.i;

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
import d.a.n0.a.h0.i.a;
import d.a.n0.a.h0.i.g;
import d.a.n0.a.k;
import d.a.n0.a.v2.q0;
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
    public static final boolean f44809a;

    /* renamed from: b  reason: collision with root package name */
    public static c f44810b;

    /* renamed from: c  reason: collision with root package name */
    public static LinkedHashMap<String, String> f44811c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g.a f44812a;

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
            this.f44812a = aVar;
        }

        @Override // d.a.n0.a.h0.i.g.a
        public void a(@NonNull g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, gVar) == null) {
                this.f44812a.a(gVar);
                i.r(gVar);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.v2.e1.b f44813a;

        public b(d.a.n0.a.v2.e1.b bVar) {
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
            this.f44813a = bVar;
        }

        @Override // d.a.n0.a.h0.i.g.a
        public void a(@NonNull g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, gVar) == null) {
                if (TextUtils.isEmpty(i.f44810b.f44819f)) {
                    i.f44810b.f44819f = d.a.n0.a.h0.i.c.b("", gVar);
                }
                d.a.n0.a.v2.e1.b bVar = this.f44813a;
                if (bVar != null) {
                    bVar.onCallback(i.f44810b.r(i.f44810b.f44819f));
                }
                if (i.f44809a) {
                    Log.d("SwanAppLaunchTips", String.format("getLaunchInfo by click, consume time: %d ms，detail:%s", Long.valueOf(System.currentTimeMillis() - i.f44810b.s()), i.f44810b.f44819f));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f44832a;

        /* renamed from: b  reason: collision with root package name */
        public long f44833b;

        /* renamed from: c  reason: collision with root package name */
        public int f44834c;

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
            this.f44832a = str;
            this.f44833b = j2;
            this.f44834c = i2;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(318228873, "Ld/a/n0/a/h0/i/i;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(318228873, "Ld/a/n0/a/h0/i/i;");
                return;
            }
        }
        f44809a = k.f45831a;
    }

    public static void c() {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65539, null) == null) || (cVar = f44810b) == null) {
            return;
        }
        cVar.o();
    }

    public static void d(g.a aVar) {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, aVar) == null) || (cVar = f44810b) == null) {
            return;
        }
        cVar.q(aVar);
    }

    public static synchronized void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null) == null) {
            synchronized (i.class) {
                if (f44810b != null) {
                    e.e();
                    f44810b.n();
                }
                f44810b = new c(null);
                if (f44811c != null) {
                    for (Map.Entry<String, String> entry : f44811c.entrySet()) {
                        f44810b.w(entry.getKey(), entry.getValue());
                    }
                    f44810b.K(true);
                    f44811c = null;
                }
            }
        }
    }

    public static void f(d.a.n0.a.v2.e1.b<String> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, bVar) == null) {
            c cVar = f44810b;
            if (cVar == null) {
                if (bVar != null) {
                    bVar.onCallback("");
                }
            } else if (cVar.v() && !TextUtils.isEmpty(f44810b.f44819f)) {
                if (bVar != null) {
                    c cVar2 = f44810b;
                    bVar.onCallback(cVar2.r(cVar2.f44819f));
                }
            } else if (!f44810b.u() || TextUtils.isEmpty(f44810b.f44819f)) {
                f44810b.q(new b(bVar));
            } else if (bVar != null) {
                c cVar3 = f44810b;
                bVar.onCallback(cVar3.r(cVar3.f44819f));
            }
        }
    }

    public static boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            c cVar = f44810b;
            if (cVar == null) {
                return false;
            }
            return cVar.t();
        }
        return invokeV.booleanValue;
    }

    public static void h(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65544, null, z) == null) || d.a.n0.a.a2.d.g().l() == 1) {
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
            j(str, d.a.n0.a.v2.k.g(System.currentTimeMillis(), "【HH:mm:ss】"));
        }
    }

    public static void j(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, str, str2) == null) {
            c cVar = f44810b;
            if (cVar != null) {
                cVar.w(str, str2);
                return;
            }
            if (f44811c == null) {
                f44811c = new LinkedHashMap<>();
            }
            f44811c.put(str, str2);
        }
    }

    public static void k() {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65547, null) == null) || (cVar = f44810b) == null) {
            return;
        }
        cVar.x();
    }

    public static void l(long j) {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(65548, null, j) == null) || (cVar = f44810b) == null) {
            return;
        }
        cVar.y(j);
    }

    public static void m(a.C0734a c0734a) {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65549, null, c0734a) == null) || (cVar = f44810b) == null) {
            return;
        }
        cVar.z(c0734a);
    }

    public static void n(String str, int i2) {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65550, null, str, i2) == null) || (cVar = f44810b) == null) {
            return;
        }
        cVar.A(str, i2);
    }

    public static void o(String str) {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65551, null, str) == null) || (cVar = f44810b) == null) {
            return;
        }
        cVar.B(str);
    }

    public static void p(String str, long j) {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(65552, null, str, j) == null) || (cVar = f44810b) == null) {
            return;
        }
        cVar.C(str, j);
    }

    public static void q(int i2) {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65553, null, i2) == null) || (cVar = f44810b) == null) {
            return;
        }
        cVar.J(i2);
    }

    public static void r(g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65554, null, gVar) == null) || gVar == null) {
            return;
        }
        int i2 = d.a.n0.a.h.swanapp_tip_request_default;
        int d2 = gVar.d();
        d.a.n0.a.h0.i.a c2 = gVar.c();
        if (c2 != null && c2.c()) {
            i2 = d.a.n0.a.h.swanapp_tip_show_js_error;
        } else if (d2 != 1 && d2 != 2) {
            int f2 = gVar.f();
            if (f2 == 4) {
                i2 = d.a.n0.a.h.swanapp_tip_request_fail;
            } else if (f2 == 8) {
                i2 = d.a.n0.a.h.swanapp_tip_request_slow;
            }
        } else {
            i2 = d.a.n0.a.h.swanapp_tip_request_bad_network;
        }
        e.f(i2);
    }

    public static void s(g.a aVar) {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65555, null, aVar) == null) || (cVar = f44810b) == null) {
            return;
        }
        cVar.q(new a(aVar));
    }

    public static void t() {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65556, null) == null) || (cVar = f44810b) == null) {
            return;
        }
        cVar.L();
    }

    public static void u() {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65557, null) == null) || (cVar = f44810b) == null) {
            return;
        }
        cVar.M();
    }

    public static synchronized void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65558, null) == null) {
            synchronized (i.class) {
                if (f44810b != null) {
                    f44810b.N();
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
        public long f44814a;

        /* renamed from: b  reason: collision with root package name */
        public List<d> f44815b;

        /* renamed from: c  reason: collision with root package name */
        public List<d> f44816c;

        /* renamed from: d  reason: collision with root package name */
        public List<d> f44817d;

        /* renamed from: e  reason: collision with root package name */
        public volatile boolean f44818e;

        /* renamed from: f  reason: collision with root package name */
        public String f44819f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f44820g;

        /* renamed from: h  reason: collision with root package name */
        public Timer f44821h;

        /* renamed from: i  reason: collision with root package name */
        public Timer f44822i;
        public Timer j;
        public long k;
        public int l;
        public d.a.n0.a.h0.i.a m;
        public boolean n;
        public long o;

        /* loaded from: classes7.dex */
        public class a extends TimerTask {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f44823e;

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
                this.f44823e = cVar;
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f44823e.f44818e = false;
                    this.f44823e.H();
                }
            }
        }

        /* loaded from: classes7.dex */
        public class b extends d.a.n0.a.t0.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ SwanAppActivity f44824a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ c f44825b;

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
                this.f44825b = cVar;
                this.f44824a = swanAppActivity;
            }

            @Override // d.a.n0.a.t0.a, d.a.n0.a.t0.b
            public void f() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f44825b.I()) {
                    this.f44824a.unregisterCallback(this);
                }
            }
        }

        /* renamed from: d.a.n0.a.h0.i.i$c$c  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0736c implements SwanAppNetworkUtils.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ g f44826a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ g.a f44827b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ c f44828c;

            public C0736c(c cVar, g gVar, g.a aVar) {
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
                this.f44828c = cVar;
                this.f44826a = gVar;
                this.f44827b = aVar;
            }

            @Override // com.baidu.swan.apps.network.SwanAppNetworkUtils.b
            public void onResult(int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                    if (i2 == 1) {
                        this.f44826a.j(0);
                    } else if (i2 == 2) {
                        this.f44826a.j(1);
                    } else if (i2 != 3) {
                        this.f44826a.j(3);
                    } else {
                        this.f44826a.j(2);
                    }
                    if (this.f44828c.f44816c.size() + this.f44828c.f44815b.size() + this.f44828c.f44817d.size() > 2 && System.currentTimeMillis() - this.f44828c.k >= 3000) {
                        if (!this.f44828c.E(this.f44826a)) {
                            if (this.f44828c.F(this.f44826a)) {
                                this.f44826a.k(8);
                                this.f44827b.a(this.f44826a);
                                return;
                            }
                            this.f44827b.a(this.f44826a);
                            return;
                        }
                        this.f44826a.k(4);
                        this.f44827b.a(this.f44826a);
                        return;
                    }
                    this.f44826a.k(12);
                    this.f44827b.a(this.f44826a);
                }
            }
        }

        /* loaded from: classes7.dex */
        public class d extends TimerTask {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f44829e;

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

                @Override // d.a.n0.a.h0.i.g.a
                public void a(@NonNull g gVar) {
                    Interceptable interceptable = $ic;
                    if ((interceptable == null || interceptable.invokeL(1048576, this, gVar) == null) && q0.H()) {
                        f.c("fcp_timeout", gVar);
                        int d2 = gVar.d();
                        if (d2 == 1) {
                            i.i(d.a.n0.a.h0.i.c.b(d.a.n0.a.h0.i.c.f44794a, gVar));
                            d.a.n0.a.h0.i.e.f(d.a.n0.a.h.swanapp_tip_net_unavailable);
                        } else if (d2 != 2) {
                            i.i(d.a.n0.a.h0.i.c.b(d.a.n0.a.h0.i.c.f44794a, gVar));
                        } else {
                            i.i(d.a.n0.a.h0.i.c.b(d.a.n0.a.h0.i.c.f44794a, gVar));
                            d.a.n0.a.h0.i.e.f(d.a.n0.a.h.swanapp_tip_net_unavailable);
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
                this.f44829e = cVar;
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f44829e.f44814a == 0 && d.a.n0.a.m1.g.f().e() == 0) {
                    this.f44829e.q(new a(this));
                }
            }
        }

        /* loaded from: classes7.dex */
        public class e extends TimerTask {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f44830e;

            /* loaded from: classes7.dex */
            public class a implements g.a {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ e f44831a;

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
                    this.f44831a = eVar;
                }

                @Override // d.a.n0.a.h0.i.g.a
                public void a(@NonNull g gVar) {
                    Interceptable interceptable = $ic;
                    if ((interceptable == null || interceptable.invokeL(1048576, this, gVar) == null) && TextUtils.isEmpty(this.f44831a.f44830e.f44819f)) {
                        this.f44831a.f44830e.f44819f = d.a.n0.a.h0.i.c.b("", gVar);
                        if (i.f44809a) {
                            Log.d("SwanAppLaunchTips", String.format("%d ms countdown end，collect launchInfo：%s", 6000L, this.f44831a.f44830e.f44819f));
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
                this.f44830e = cVar;
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !this.f44830e.u() && TextUtils.isEmpty(this.f44830e.f44819f)) {
                    this.f44830e.q(new a(this));
                }
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(875249962, "Ld/a/n0/a/h0/i/i$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(875249962, "Ld/a/n0/a/h0/i/i$c;");
                    return;
                }
            }
            p = d.a.n0.a.c1.a.Z().o();
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
            this.f44814a = 0L;
            this.f44815b = new ArrayList();
            this.f44816c = new ArrayList();
            this.f44817d = new ArrayList();
            this.f44818e = true;
            this.f44819f = "";
            this.f44820g = false;
            this.k = 0L;
            this.l = 0;
            this.m = new d.a.n0.a.h0.i.a();
            this.n = false;
            this.o = s();
        }

        public synchronized void A(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) {
                synchronized (this) {
                    if (this.f44818e) {
                        this.f44817d.add(new d(str, 0L, 0L, i2));
                        D(str);
                    }
                }
            }
        }

        public synchronized void B(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                synchronized (this) {
                    if (this.f44818e) {
                        this.f44815b.add(new d(str, System.currentTimeMillis(), 0L));
                    }
                }
            }
        }

        public synchronized void C(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, str, j) == null) {
                synchronized (this) {
                    if (this.f44818e) {
                        this.f44816c.add(new d(str, 0L, j));
                        D(str);
                    }
                }
            }
        }

        public final void D(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                for (int i2 = 0; i2 < this.f44815b.size(); i2++) {
                    if (TextUtils.equals(this.f44815b.get(i2).f44832a, str)) {
                        List<d> list = this.f44815b;
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
                int size = this.f44817d.size();
                int i3 = 0;
                for (int i4 = 0; i4 < size; i4++) {
                    d dVar = this.f44817d.get(i4);
                    if (dVar != null && (i2 = dVar.f44834c) >= 400 && i2 < 600) {
                        i3++;
                        arrayList.add(dVar.f44832a);
                    }
                }
                int size2 = this.f44816c.size() + i3 + this.f44815b.size();
                gVar.f44805c = arrayList;
                gVar.f44804b = size2;
                return ((double) i3) / ((double) size2) >= 0.5d;
            }
            return invokeL.booleanValue;
        }

        public final boolean F(g gVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, gVar)) == null) {
                TreeMap treeMap = new TreeMap();
                int size = this.f44816c.size();
                int i2 = 0;
                for (int i3 = 0; i3 < size; i3++) {
                    d dVar = this.f44816c.get(i3);
                    long j = dVar.f44833b;
                    if (j > 3000) {
                        i2++;
                        treeMap.put(dVar.f44832a, Integer.valueOf((int) j));
                    }
                }
                gVar.f44806d = treeMap;
                return i2 >= 2;
            }
            return invokeL.booleanValue;
        }

        public void G() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                Timer timer = this.f44821h;
                if (timer != null) {
                    timer.cancel();
                    this.f44821h = null;
                }
                this.f44814a = 0L;
            }
        }

        public final void H() {
            Timer timer;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (timer = this.f44822i) == null) {
                return;
            }
            timer.cancel();
            this.f44822i = null;
        }

        public final boolean I() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                if (!this.f44820g || TextUtils.isEmpty(this.f44819f)) {
                    return false;
                }
                d.a.n0.a.h0.i.b.h(s(), this.f44819f);
                this.f44820g = false;
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
                this.f44820g = z;
            }
        }

        public void L() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
                G();
                Timer timer = new Timer();
                this.f44821h = timer;
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
            if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && this.f44818e) {
                this.k = System.currentTimeMillis();
                Timer timer = new Timer();
                this.f44822i = timer;
                timer.schedule(new a(this), 6000L);
                SwanAppActivity activity = d.a.n0.a.g1.f.V().getActivity();
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
                if (!TextUtils.equals(d.a.n0.a.g1.f.V().U(), d.a.n0.a.h0.i.d.a())) {
                    if (i.f44809a) {
                        Log.d("SwanAppLaunchTips", "current page is not skeleton error first page");
                        Log.d("SwanAppLaunchTips", "current page: " + d.a.n0.a.g1.f.V().U());
                        String a2 = d.a.n0.a.h0.i.d.a();
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
                String D = d.a.n0.a.g1.f.V().D();
                if (TextUtils.isEmpty(D)) {
                    return;
                }
                d.a.n0.a.g1.f.V().m(D, new d.a.n0.a.o0.d.b("check-skeleton-status"));
            }
        }

        public void p(SwanAppNetworkUtils.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048592, this, bVar) == null) {
                this.f44820g = true;
                SwanAppNetworkUtils.b(bVar);
            }
        }

        public void q(g.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048593, this, aVar) == null) {
                g gVar = new g();
                gVar.h(System.currentTimeMillis() - this.k);
                gVar.i(this.m);
                p(new C0736c(this, gVar, aVar));
            }
        }

        public String r(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, str)) == null) {
                StringBuilder sb = new StringBuilder(d.a.n0.a.c1.a.b().getText(d.a.n0.a.h.swanapp_tip_cur_title));
                sb.append(str);
                String e2 = d.a.n0.a.h0.i.b.e();
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
                d.a.n0.a.a2.e Q = d.a.n0.a.a2.e.Q();
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
                    d.a.n0.a.e0.d.h("SwanAppLaunchTips", "the log has expired, content=" + str2 + str);
                    return;
                }
                String str3 = "\n" + str2 + str;
                if (!TextUtils.isEmpty(this.f44819f)) {
                    str3 = this.f44819f + str3;
                }
                this.f44819f = str3;
                if (i.f44809a) {
                    Log.d("SwanAppLaunchTips", str);
                }
                d.a.n0.a.e0.d.h("SwanAppLaunchTips", str2 + str);
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
            if ((interceptable == null || interceptable.invokeJ(1048601, this, j) == null) && this.f44814a == 0) {
                this.f44814a = j;
            }
        }

        public void z(@NonNull a.C0734a c0734a) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048602, this, c0734a) == null) {
                boolean z = u() || v();
                if (i.f44809a) {
                    Log.d("SwanAppLaunchTips", String.format("onJsError needFilter ?: %s, content:%s", Boolean.valueOf(z), c0734a.toString()));
                }
                if (z) {
                    return;
                }
                this.m.a(c0734a);
            }
        }

        public /* synthetic */ c(h hVar) {
            this();
        }
    }
}
