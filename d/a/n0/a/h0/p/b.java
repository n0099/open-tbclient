package d.a.n0.a.h0.p;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.a.a1.e;
import d.a.n0.a.c2.f.p0.c;
import d.a.n0.a.c2.f.p0.j;
import d.a.n0.a.g1.f;
import d.a.n0.a.h0.u.g;
import d.a.n0.a.k;
import d.a.n0.a.r1.h;
import d.a.n0.a.u.e.j.d;
import d.a.n0.a.v2.d0;
import d.a.n0.a.v2.o0;
import java.io.File;
/* loaded from: classes7.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f45146b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f45147a;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: d.a.n0.a.h0.p.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0763b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final b f45148a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1075445451, "Ld/a/n0/a/h0/p/b$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1075445451, "Ld/a/n0/a/h0/p/b$b;");
                    return;
                }
            }
            f45148a = new b(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(318437193, "Ld/a/n0/a/h0/p/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(318437193, "Ld/a/n0/a/h0/p/b;");
                return;
            }
        }
        f45146b = k.f45831a;
    }

    public /* synthetic */ b(a aVar) {
        this();
    }

    public static b c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? C0763b.f45148a : (b) invokeV.objValue;
    }

    public final void a(@NonNull SwanAppConfigData swanAppConfigData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, swanAppConfigData) == null) {
            if (f45146b) {
                Log.d("AppLaunchMessenger", "afterLaunchEventSent: start");
            }
            d.g(swanAppConfigData);
            d.a.n0.a.h0.q.b.g().p(d.a.n0.a.a2.d.g().getAppId(), false);
            d.a.n0.a.l2.b.l().t();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00bf A[Catch: all -> 0x02b0, TryCatch #0 {, blocks: (B:6:0x000d, B:8:0x0011, B:9:0x001f, B:12:0x0025, B:17:0x002f, B:18:0x0032, B:20:0x004b, B:22:0x0053, B:24:0x007b, B:26:0x009d, B:31:0x00ab, B:33:0x00bf, B:34:0x00c5, B:36:0x00cb, B:38:0x00d7, B:39:0x00d9, B:41:0x00dd, B:42:0x00e6, B:44:0x0124, B:47:0x013c, B:49:0x0153, B:51:0x015b, B:53:0x0183, B:55:0x01a6, B:57:0x01ae, B:60:0x01c3, B:62:0x01c7, B:63:0x01d0, B:65:0x0215, B:66:0x02a5, B:59:0x01ba, B:52:0x0160, B:46:0x0133, B:23:0x0058), top: B:75:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00cb A[Catch: all -> 0x02b0, TryCatch #0 {, blocks: (B:6:0x000d, B:8:0x0011, B:9:0x001f, B:12:0x0025, B:17:0x002f, B:18:0x0032, B:20:0x004b, B:22:0x0053, B:24:0x007b, B:26:0x009d, B:31:0x00ab, B:33:0x00bf, B:34:0x00c5, B:36:0x00cb, B:38:0x00d7, B:39:0x00d9, B:41:0x00dd, B:42:0x00e6, B:44:0x0124, B:47:0x013c, B:49:0x0153, B:51:0x015b, B:53:0x0183, B:55:0x01a6, B:57:0x01ae, B:60:0x01c3, B:62:0x01c7, B:63:0x01d0, B:65:0x0215, B:66:0x02a5, B:59:0x01ba, B:52:0x0160, B:46:0x0133, B:23:0x0058), top: B:75:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00dd A[Catch: all -> 0x02b0, TryCatch #0 {, blocks: (B:6:0x000d, B:8:0x0011, B:9:0x001f, B:12:0x0025, B:17:0x002f, B:18:0x0032, B:20:0x004b, B:22:0x0053, B:24:0x007b, B:26:0x009d, B:31:0x00ab, B:33:0x00bf, B:34:0x00c5, B:36:0x00cb, B:38:0x00d7, B:39:0x00d9, B:41:0x00dd, B:42:0x00e6, B:44:0x0124, B:47:0x013c, B:49:0x0153, B:51:0x015b, B:53:0x0183, B:55:0x01a6, B:57:0x01ae, B:60:0x01c3, B:62:0x01c7, B:63:0x01d0, B:65:0x0215, B:66:0x02a5, B:59:0x01ba, B:52:0x0160, B:46:0x0133, B:23:0x0058), top: B:75:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0124 A[Catch: all -> 0x02b0, TryCatch #0 {, blocks: (B:6:0x000d, B:8:0x0011, B:9:0x001f, B:12:0x0025, B:17:0x002f, B:18:0x0032, B:20:0x004b, B:22:0x0053, B:24:0x007b, B:26:0x009d, B:31:0x00ab, B:33:0x00bf, B:34:0x00c5, B:36:0x00cb, B:38:0x00d7, B:39:0x00d9, B:41:0x00dd, B:42:0x00e6, B:44:0x0124, B:47:0x013c, B:49:0x0153, B:51:0x015b, B:53:0x0183, B:55:0x01a6, B:57:0x01ae, B:60:0x01c3, B:62:0x01c7, B:63:0x01d0, B:65:0x0215, B:66:0x02a5, B:59:0x01ba, B:52:0x0160, B:46:0x0133, B:23:0x0058), top: B:75:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01a6 A[Catch: all -> 0x02b0, TryCatch #0 {, blocks: (B:6:0x000d, B:8:0x0011, B:9:0x001f, B:12:0x0025, B:17:0x002f, B:18:0x0032, B:20:0x004b, B:22:0x0053, B:24:0x007b, B:26:0x009d, B:31:0x00ab, B:33:0x00bf, B:34:0x00c5, B:36:0x00cb, B:38:0x00d7, B:39:0x00d9, B:41:0x00dd, B:42:0x00e6, B:44:0x0124, B:47:0x013c, B:49:0x0153, B:51:0x015b, B:53:0x0183, B:55:0x01a6, B:57:0x01ae, B:60:0x01c3, B:62:0x01c7, B:63:0x01d0, B:65:0x0215, B:66:0x02a5, B:59:0x01ba, B:52:0x0160, B:46:0x0133, B:23:0x0058), top: B:75:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01ae A[Catch: all -> 0x02b0, TryCatch #0 {, blocks: (B:6:0x000d, B:8:0x0011, B:9:0x001f, B:12:0x0025, B:17:0x002f, B:18:0x0032, B:20:0x004b, B:22:0x0053, B:24:0x007b, B:26:0x009d, B:31:0x00ab, B:33:0x00bf, B:34:0x00c5, B:36:0x00cb, B:38:0x00d7, B:39:0x00d9, B:41:0x00dd, B:42:0x00e6, B:44:0x0124, B:47:0x013c, B:49:0x0153, B:51:0x015b, B:53:0x0183, B:55:0x01a6, B:57:0x01ae, B:60:0x01c3, B:62:0x01c7, B:63:0x01d0, B:65:0x0215, B:66:0x02a5, B:59:0x01ba, B:52:0x0160, B:46:0x0133, B:23:0x0058), top: B:75:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01c7 A[Catch: all -> 0x02b0, TryCatch #0 {, blocks: (B:6:0x000d, B:8:0x0011, B:9:0x001f, B:12:0x0025, B:17:0x002f, B:18:0x0032, B:20:0x004b, B:22:0x0053, B:24:0x007b, B:26:0x009d, B:31:0x00ab, B:33:0x00bf, B:34:0x00c5, B:36:0x00cb, B:38:0x00d7, B:39:0x00d9, B:41:0x00dd, B:42:0x00e6, B:44:0x0124, B:47:0x013c, B:49:0x0153, B:51:0x015b, B:53:0x0183, B:55:0x01a6, B:57:0x01ae, B:60:0x01c3, B:62:0x01c7, B:63:0x01d0, B:65:0x0215, B:66:0x02a5, B:59:0x01ba, B:52:0x0160, B:46:0x0133, B:23:0x0058), top: B:75:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0215 A[Catch: all -> 0x02b0, TryCatch #0 {, blocks: (B:6:0x000d, B:8:0x0011, B:9:0x001f, B:12:0x0025, B:17:0x002f, B:18:0x0032, B:20:0x004b, B:22:0x0053, B:24:0x007b, B:26:0x009d, B:31:0x00ab, B:33:0x00bf, B:34:0x00c5, B:36:0x00cb, B:38:0x00d7, B:39:0x00d9, B:41:0x00dd, B:42:0x00e6, B:44:0x0124, B:47:0x013c, B:49:0x0153, B:51:0x015b, B:53:0x0183, B:55:0x01a6, B:57:0x01ae, B:60:0x01c3, B:62:0x01c7, B:63:0x01d0, B:65:0x0215, B:66:0x02a5, B:59:0x01ba, B:52:0x0160, B:46:0x0133, B:23:0x0058), top: B:75:0x000d }] */
    /* JADX WARN: Type inference failed for: r3v15, types: [d.a.n0.a.p.e.c] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void b(@NonNull d.a.n0.a.h0.l.a aVar, @NonNull d.a.n0.a.p.e.b bVar, @NonNull d.a.n0.a.f1.e.b bVar2, @NonNull SwanAppConfigData swanAppConfigData, @Nullable e.g gVar, boolean z) {
        boolean z2;
        boolean G;
        Bundle P;
        boolean E;
        d.a.n0.a.h0.u.d dVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{aVar, bVar, bVar2, swanAppConfigData, gVar, Boolean.valueOf(z)}) == null) {
            synchronized (this) {
                if (f45146b) {
                    Log.d("AppLaunchMessenger", "dispatchLaunchEvent");
                    Log.d("SwanPrelink", "start dispatch launch event");
                }
                if (this.f45147a) {
                    if (z) {
                        d.a.n0.a.h0.u.b.c(14);
                    }
                    return;
                }
                if (z) {
                    d.a.n0.a.h0.u.b.c(1);
                }
                String c2 = c.c(f.V(), bVar2, swanAppConfigData);
                String g2 = swanAppConfigData.g(c2);
                d.a.n0.a.h0.u.a aVar2 = new d.a.n0.a.h0.u.a();
                aVar2.f45233a = swanAppConfigData.m;
                if (gVar != null && !TextUtils.isEmpty(gVar.f43323a)) {
                    aVar2.f45234b = gVar.f43323a;
                } else {
                    aVar2.f45234b = e.C0629e.i(bVar2.H(), bVar2.u1()).getPath() + File.separator;
                }
                aVar2.f45235c = bVar.b();
                aVar2.f45236d = c2;
                aVar2.f45238f = String.valueOf(d.a.n0.a.e0.a.a());
                aVar2.f45239g = d.a.n0.a.h0.u.a.c(d.a.n0.a.a2.e.i(), c2);
                aVar2.f45241i = g2;
                if (!f45146b && !f.V().O()) {
                    z2 = false;
                    aVar2.f45240h = z2;
                    aVar2.j = bVar.L();
                    aVar2.l = d.a.n0.a.h0.u.e.b();
                    G = d.a.n0.a.u1.a.a.G();
                    if (G) {
                        aVar2.k = d.a.n0.a.e0.f.b.b();
                    }
                    P = bVar2.P();
                    if (P != null) {
                        String string = P.getString(PrefetchEvent.EVENT_DATA_EXTRA_DATA);
                        if (!TextUtils.isEmpty(string)) {
                            aVar2.f45237e = string;
                        }
                    }
                    if (f45146b) {
                        Log.d("AppLaunchMessenger", aVar2.toString());
                    }
                    h.o().C(new UbcFlowEvent("master_dispatch_start"));
                    d.a.n0.a.i2.a.d().i("master_dispatch_start");
                    aVar.D(aVar2);
                    g.N().H0(d.a.n0.a.h0.u.a.b(aVar2));
                    g.N().S0(aVar2.j);
                    E = d.a.n0.a.u1.a.a.E(bVar2.g0());
                    boolean o0 = bVar2.o0();
                    if (!E) {
                        d.a.n0.a.e0.f.e.d.d();
                        d.a.n0.a.e0.f.e.d.g().h("appready");
                    } else if (o0) {
                        d.a.n0.a.e0.f.d.d.e().f("appready");
                    }
                    d.a.n0.a.a2.n.g e2 = f.V().e(j.b(o0.f(c2)));
                    dVar = new d.a.n0.a.h0.u.d();
                    if (gVar == null && !TextUtils.isEmpty(gVar.f43323a)) {
                        dVar.f45244a = gVar.f43323a;
                    } else {
                        dVar.f45244a = e.C0629e.i(bVar2.H(), bVar2.u1()).getPath() + File.separator;
                    }
                    dVar.f45245b = c2;
                    dVar.f45247d = e2.f43430g;
                    dVar.f45246c = g2;
                    dVar.k = aVar2.f45239g;
                    dVar.f45248e = String.valueOf(bVar2.l0());
                    dVar.f45250g = z2;
                    dVar.f45252i = bVar.L();
                    dVar.m = true;
                    if (G) {
                        dVar.j = d.a.n0.a.e0.f.b.d();
                    }
                    if (!E) {
                        d.a.n0.a.e0.f.e.d.g().h("pageready");
                    } else if (o0) {
                        d.a.n0.a.e0.f.d.d.e().f("pageready");
                    }
                    if (f45146b) {
                        Log.d("AppLaunchMessenger", dVar.toString());
                    }
                    h.o().C(new UbcFlowEvent("slave_dispatch_start"));
                    d.a.n0.a.i2.a.d().i("slave_dispatch_start");
                    bVar.M(dVar);
                    d0.d();
                    bVar.u().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, c2);
                    bVar.S(c2);
                    g.N().I0(bVar.b(), d.a.n0.a.h0.u.d.a(dVar));
                    d.a.n0.a.j2.e.F(bVar.b(), dVar.f45245b);
                    if (f45146b) {
                        Log.d("AppLaunchMessenger", "app path: " + aVar2.f45234b);
                        Log.d("AppLaunchMessenger", "webviewId: " + bVar.b());
                        Log.d("AppLaunchMessenger", "pageUrl: " + c2);
                        Log.d("AppLaunchMessenger", "pagePath: " + dVar.f45245b);
                        Log.d("AppLaunchMessenger", "onReachBottomDistance: " + dVar.f45247d);
                        Log.d("AppLaunchMessenger", "sConsole:" + dVar.f45248e);
                    }
                    a(swanAppConfigData);
                    this.f45147a = true;
                    e();
                }
                z2 = true;
                aVar2.f45240h = z2;
                aVar2.j = bVar.L();
                aVar2.l = d.a.n0.a.h0.u.e.b();
                G = d.a.n0.a.u1.a.a.G();
                if (G) {
                }
                P = bVar2.P();
                if (P != null) {
                }
                if (f45146b) {
                }
                h.o().C(new UbcFlowEvent("master_dispatch_start"));
                d.a.n0.a.i2.a.d().i("master_dispatch_start");
                aVar.D(aVar2);
                g.N().H0(d.a.n0.a.h0.u.a.b(aVar2));
                g.N().S0(aVar2.j);
                E = d.a.n0.a.u1.a.a.E(bVar2.g0());
                boolean o02 = bVar2.o0();
                if (!E) {
                }
                d.a.n0.a.a2.n.g e22 = f.V().e(j.b(o0.f(c2)));
                dVar = new d.a.n0.a.h0.u.d();
                if (gVar == null) {
                }
                dVar.f45244a = e.C0629e.i(bVar2.H(), bVar2.u1()).getPath() + File.separator;
                dVar.f45245b = c2;
                dVar.f45247d = e22.f43430g;
                dVar.f45246c = g2;
                dVar.k = aVar2.f45239g;
                dVar.f45248e = String.valueOf(bVar2.l0());
                dVar.f45250g = z2;
                dVar.f45252i = bVar.L();
                dVar.m = true;
                if (G) {
                }
                if (!E) {
                }
                if (f45146b) {
                }
                h.o().C(new UbcFlowEvent("slave_dispatch_start"));
                d.a.n0.a.i2.a.d().i("slave_dispatch_start");
                bVar.M(dVar);
                d0.d();
                bVar.u().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, c2);
                bVar.S(c2);
                g.N().I0(bVar.b(), d.a.n0.a.h0.u.d.a(dVar));
                d.a.n0.a.j2.e.F(bVar.b(), dVar.f45245b);
                if (f45146b) {
                }
                a(swanAppConfigData);
                this.f45147a = true;
                e();
            }
        }
    }

    public synchronized void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                this.f45147a = false;
            }
        }
    }

    public final void e() {
        int a2;
        d.a.n0.a.h0.l.a P;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (a2 = d.a.n0.a.r1.l.b.a()) == 0 || (P = g.N().P()) == null) {
            return;
        }
        if (a2 < 0) {
            P.r(a2);
        } else if (a2 == 1) {
            P.r(-4);
        } else {
            P.r(-2);
        }
    }

    public b() {
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
        this.f45147a = false;
    }
}
