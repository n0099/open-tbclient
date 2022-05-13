package com.repackage;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.qj2;
import java.io.File;
/* loaded from: classes5.dex */
public final class c62 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final c62 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-517904268, "Lcom/repackage/c62$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-517904268, "Lcom/repackage/c62$b;");
                    return;
                }
            }
            a = new c62(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755845326, "Lcom/repackage/c62;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755845326, "Lcom/repackage/c62;");
                return;
            }
        }
        b = eh1.a;
    }

    public /* synthetic */ c62(a aVar) {
        this();
    }

    public static c62 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? b.a : (c62) invokeV.objValue;
    }

    public final void a(@NonNull SwanAppConfigData swanAppConfigData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, swanAppConfigData) == null) {
            if (b) {
                Log.d("AppLaunchMessenger", "afterLaunchEventSent: start");
            }
            eq1.k(swanAppConfigData);
            e62.k().x(t03.J().getAppId(), false);
            q93.l().t();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00d1 A[Catch: all -> 0x02c9, TryCatch #0 {, blocks: (B:6:0x000d, B:8:0x0011, B:9:0x001f, B:12:0x0025, B:17:0x002f, B:18:0x0032, B:20:0x004b, B:22:0x0053, B:24:0x007b, B:26:0x009d, B:31:0x00ab, B:33:0x00bf, B:35:0x00c7, B:36:0x00cb, B:38:0x00d1, B:39:0x00d7, B:41:0x00dd, B:43:0x00e9, B:44:0x00eb, B:46:0x00ef, B:47:0x00f8, B:49:0x013d, B:52:0x0155, B:54:0x016c, B:56:0x0174, B:58:0x019c, B:60:0x01bf, B:62:0x01c7, B:65:0x01dc, B:67:0x01e0, B:68:0x01e9, B:70:0x022e, B:71:0x02be, B:64:0x01d3, B:57:0x0179, B:51:0x014c, B:23:0x0058), top: B:80:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00dd A[Catch: all -> 0x02c9, TryCatch #0 {, blocks: (B:6:0x000d, B:8:0x0011, B:9:0x001f, B:12:0x0025, B:17:0x002f, B:18:0x0032, B:20:0x004b, B:22:0x0053, B:24:0x007b, B:26:0x009d, B:31:0x00ab, B:33:0x00bf, B:35:0x00c7, B:36:0x00cb, B:38:0x00d1, B:39:0x00d7, B:41:0x00dd, B:43:0x00e9, B:44:0x00eb, B:46:0x00ef, B:47:0x00f8, B:49:0x013d, B:52:0x0155, B:54:0x016c, B:56:0x0174, B:58:0x019c, B:60:0x01bf, B:62:0x01c7, B:65:0x01dc, B:67:0x01e0, B:68:0x01e9, B:70:0x022e, B:71:0x02be, B:64:0x01d3, B:57:0x0179, B:51:0x014c, B:23:0x0058), top: B:80:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00ef A[Catch: all -> 0x02c9, TryCatch #0 {, blocks: (B:6:0x000d, B:8:0x0011, B:9:0x001f, B:12:0x0025, B:17:0x002f, B:18:0x0032, B:20:0x004b, B:22:0x0053, B:24:0x007b, B:26:0x009d, B:31:0x00ab, B:33:0x00bf, B:35:0x00c7, B:36:0x00cb, B:38:0x00d1, B:39:0x00d7, B:41:0x00dd, B:43:0x00e9, B:44:0x00eb, B:46:0x00ef, B:47:0x00f8, B:49:0x013d, B:52:0x0155, B:54:0x016c, B:56:0x0174, B:58:0x019c, B:60:0x01bf, B:62:0x01c7, B:65:0x01dc, B:67:0x01e0, B:68:0x01e9, B:70:0x022e, B:71:0x02be, B:64:0x01d3, B:57:0x0179, B:51:0x014c, B:23:0x0058), top: B:80:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x013d A[Catch: all -> 0x02c9, TryCatch #0 {, blocks: (B:6:0x000d, B:8:0x0011, B:9:0x001f, B:12:0x0025, B:17:0x002f, B:18:0x0032, B:20:0x004b, B:22:0x0053, B:24:0x007b, B:26:0x009d, B:31:0x00ab, B:33:0x00bf, B:35:0x00c7, B:36:0x00cb, B:38:0x00d1, B:39:0x00d7, B:41:0x00dd, B:43:0x00e9, B:44:0x00eb, B:46:0x00ef, B:47:0x00f8, B:49:0x013d, B:52:0x0155, B:54:0x016c, B:56:0x0174, B:58:0x019c, B:60:0x01bf, B:62:0x01c7, B:65:0x01dc, B:67:0x01e0, B:68:0x01e9, B:70:0x022e, B:71:0x02be, B:64:0x01d3, B:57:0x0179, B:51:0x014c, B:23:0x0058), top: B:80:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01bf A[Catch: all -> 0x02c9, TryCatch #0 {, blocks: (B:6:0x000d, B:8:0x0011, B:9:0x001f, B:12:0x0025, B:17:0x002f, B:18:0x0032, B:20:0x004b, B:22:0x0053, B:24:0x007b, B:26:0x009d, B:31:0x00ab, B:33:0x00bf, B:35:0x00c7, B:36:0x00cb, B:38:0x00d1, B:39:0x00d7, B:41:0x00dd, B:43:0x00e9, B:44:0x00eb, B:46:0x00ef, B:47:0x00f8, B:49:0x013d, B:52:0x0155, B:54:0x016c, B:56:0x0174, B:58:0x019c, B:60:0x01bf, B:62:0x01c7, B:65:0x01dc, B:67:0x01e0, B:68:0x01e9, B:70:0x022e, B:71:0x02be, B:64:0x01d3, B:57:0x0179, B:51:0x014c, B:23:0x0058), top: B:80:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01c7 A[Catch: all -> 0x02c9, TryCatch #0 {, blocks: (B:6:0x000d, B:8:0x0011, B:9:0x001f, B:12:0x0025, B:17:0x002f, B:18:0x0032, B:20:0x004b, B:22:0x0053, B:24:0x007b, B:26:0x009d, B:31:0x00ab, B:33:0x00bf, B:35:0x00c7, B:36:0x00cb, B:38:0x00d1, B:39:0x00d7, B:41:0x00dd, B:43:0x00e9, B:44:0x00eb, B:46:0x00ef, B:47:0x00f8, B:49:0x013d, B:52:0x0155, B:54:0x016c, B:56:0x0174, B:58:0x019c, B:60:0x01bf, B:62:0x01c7, B:65:0x01dc, B:67:0x01e0, B:68:0x01e9, B:70:0x022e, B:71:0x02be, B:64:0x01d3, B:57:0x0179, B:51:0x014c, B:23:0x0058), top: B:80:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01e0 A[Catch: all -> 0x02c9, TryCatch #0 {, blocks: (B:6:0x000d, B:8:0x0011, B:9:0x001f, B:12:0x0025, B:17:0x002f, B:18:0x0032, B:20:0x004b, B:22:0x0053, B:24:0x007b, B:26:0x009d, B:31:0x00ab, B:33:0x00bf, B:35:0x00c7, B:36:0x00cb, B:38:0x00d1, B:39:0x00d7, B:41:0x00dd, B:43:0x00e9, B:44:0x00eb, B:46:0x00ef, B:47:0x00f8, B:49:0x013d, B:52:0x0155, B:54:0x016c, B:56:0x0174, B:58:0x019c, B:60:0x01bf, B:62:0x01c7, B:65:0x01dc, B:67:0x01e0, B:68:0x01e9, B:70:0x022e, B:71:0x02be, B:64:0x01d3, B:57:0x0179, B:51:0x014c, B:23:0x0058), top: B:80:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x022e A[Catch: all -> 0x02c9, TryCatch #0 {, blocks: (B:6:0x000d, B:8:0x0011, B:9:0x001f, B:12:0x0025, B:17:0x002f, B:18:0x0032, B:20:0x004b, B:22:0x0053, B:24:0x007b, B:26:0x009d, B:31:0x00ab, B:33:0x00bf, B:35:0x00c7, B:36:0x00cb, B:38:0x00d1, B:39:0x00d7, B:41:0x00dd, B:43:0x00e9, B:44:0x00eb, B:46:0x00ef, B:47:0x00f8, B:49:0x013d, B:52:0x0155, B:54:0x016c, B:56:0x0174, B:58:0x019c, B:60:0x01bf, B:62:0x01c7, B:65:0x01dc, B:67:0x01e0, B:68:0x01e9, B:70:0x022e, B:71:0x02be, B:64:0x01d3, B:57:0x0179, B:51:0x014c, B:23:0x0058), top: B:80:0x000d }] */
    /* JADX WARN: Type inference failed for: r3v15, types: [com.repackage.bn1] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void b(@NonNull q22 q22Var, @NonNull an1 an1Var, @NonNull rl2 rl2Var, @NonNull SwanAppConfigData swanAppConfigData, @Nullable qj2.g gVar, boolean z) {
        boolean z2;
        PMSAppInfo f0;
        boolean H;
        Bundle P;
        boolean F;
        l72 l72Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{q22Var, an1Var, rl2Var, swanAppConfigData, gVar, Boolean.valueOf(z)}) == null) {
            synchronized (this) {
                if (b) {
                    Log.d("AppLaunchMessenger", "dispatchLaunchEvent");
                    Log.d("SwanPrelink", "start dispatch launch event");
                }
                if (this.a) {
                    if (z) {
                        j72.c(14);
                    }
                    return;
                }
                if (z) {
                    j72.c(1);
                }
                String d = f43.d(hm2.U(), rl2Var, swanAppConfigData);
                String h = swanAppConfigData.h(d);
                i72 i72Var = new i72();
                i72Var.a = swanAppConfigData.n;
                if (gVar != null && !TextUtils.isEmpty(gVar.a)) {
                    i72Var.b = gVar.a;
                } else {
                    i72Var.b = qj2.e.i(rl2Var.H(), rl2Var.v1()).getPath() + File.separator;
                }
                i72Var.c = an1Var.c();
                i72Var.d = d;
                i72Var.f = String.valueOf(rx1.a());
                i72Var.g = i72.c(u03.L(), d);
                i72Var.i = h;
                if (!b && !hm2.U().N()) {
                    z2 = false;
                    i72Var.h = z2;
                    i72Var.j = an1Var.M();
                    i72Var.l = m72.b();
                    f0 = rl2Var.f0();
                    if (f0 != null && !TextUtils.isEmpty(f0.userActionApis)) {
                        i72Var.m = f0.userActionApis;
                    }
                    H = tw2.H();
                    if (H) {
                        i72Var.k = xx1.b();
                    }
                    P = rl2Var.P();
                    if (P != null) {
                        String string = P.getString(PrefetchEvent.EVENT_DATA_EXTRA_DATA);
                        if (!TextUtils.isEmpty(string)) {
                            i72Var.e = string;
                        }
                    }
                    if (b) {
                        Log.d("AppLaunchMessenger", i72Var.toString());
                    }
                    zt2.o().F(new UbcFlowEvent("master_dispatch_start"));
                    u63.d().i("master_dispatch_start");
                    q22Var.F(i72Var);
                    o72.U().U0(i72.b(i72Var));
                    bk2.m0().a();
                    o72.U().h1(i72Var.j);
                    F = tw2.F(rl2Var.g0());
                    boolean p0 = rl2Var.p0();
                    if (!F) {
                        ky1.d();
                        ky1.g().h("appready");
                    } else if (p0) {
                        dy1.e().f("appready");
                    }
                    j13 f = hm2.U().f(m43.b(me3.f(d)));
                    l72Var = new l72();
                    if (gVar == null && !TextUtils.isEmpty(gVar.a)) {
                        l72Var.a = gVar.a;
                    } else {
                        l72Var.a = qj2.e.i(rl2Var.H(), rl2Var.v1()).getPath() + File.separator;
                    }
                    l72Var.b = d;
                    l72Var.d = f.g;
                    l72Var.c = h;
                    l72Var.k = i72Var.g;
                    l72Var.e = String.valueOf(rl2Var.m0());
                    l72Var.g = z2;
                    l72Var.i = an1Var.M();
                    l72Var.m = true;
                    if (H) {
                        l72Var.j = xx1.d();
                    }
                    if (!F) {
                        ky1.g().h("pageready");
                    } else if (p0) {
                        dy1.e().f("pageready");
                    }
                    if (b) {
                        Log.d("AppLaunchMessenger", l72Var.toString());
                    }
                    zt2.o().F(new UbcFlowEvent("slave_dispatch_start"));
                    u63.d().i("slave_dispatch_start");
                    an1Var.N(l72Var);
                    be3.d();
                    an1Var.u().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, d);
                    an1Var.U(d);
                    o72.U().V0(an1Var.c(), l72.a(l72Var));
                    e73.F(an1Var.c(), l72Var.b);
                    if (b) {
                        Log.d("AppLaunchMessenger", "app path: " + i72Var.b);
                        Log.d("AppLaunchMessenger", "webviewId: " + an1Var.c());
                        Log.d("AppLaunchMessenger", "pageUrl: " + d);
                        Log.d("AppLaunchMessenger", "pagePath: " + l72Var.b);
                        Log.d("AppLaunchMessenger", "onReachBottomDistance: " + l72Var.d);
                        Log.d("AppLaunchMessenger", "sConsole:" + l72Var.e);
                    }
                    a(swanAppConfigData);
                    this.a = true;
                    e();
                }
                z2 = true;
                i72Var.h = z2;
                i72Var.j = an1Var.M();
                i72Var.l = m72.b();
                f0 = rl2Var.f0();
                if (f0 != null) {
                    i72Var.m = f0.userActionApis;
                }
                H = tw2.H();
                if (H) {
                }
                P = rl2Var.P();
                if (P != null) {
                }
                if (b) {
                }
                zt2.o().F(new UbcFlowEvent("master_dispatch_start"));
                u63.d().i("master_dispatch_start");
                q22Var.F(i72Var);
                o72.U().U0(i72.b(i72Var));
                bk2.m0().a();
                o72.U().h1(i72Var.j);
                F = tw2.F(rl2Var.g0());
                boolean p02 = rl2Var.p0();
                if (!F) {
                }
                j13 f2 = hm2.U().f(m43.b(me3.f(d)));
                l72Var = new l72();
                if (gVar == null) {
                }
                l72Var.a = qj2.e.i(rl2Var.H(), rl2Var.v1()).getPath() + File.separator;
                l72Var.b = d;
                l72Var.d = f2.g;
                l72Var.c = h;
                l72Var.k = i72Var.g;
                l72Var.e = String.valueOf(rl2Var.m0());
                l72Var.g = z2;
                l72Var.i = an1Var.M();
                l72Var.m = true;
                if (H) {
                }
                if (!F) {
                }
                if (b) {
                }
                zt2.o().F(new UbcFlowEvent("slave_dispatch_start"));
                u63.d().i("slave_dispatch_start");
                an1Var.N(l72Var);
                be3.d();
                an1Var.u().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, d);
                an1Var.U(d);
                o72.U().V0(an1Var.c(), l72.a(l72Var));
                e73.F(an1Var.c(), l72Var.b);
                if (b) {
                }
                a(swanAppConfigData);
                this.a = true;
                e();
            }
        }
    }

    public synchronized void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                this.a = false;
            }
        }
    }

    public final void e() {
        int b2;
        q22 W;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (b2 = su2.b()) == 0 || (W = o72.U().W()) == null) {
            return;
        }
        if (b2 < 0) {
            W.r(b2);
        } else if (b2 == 1) {
            W.r(-4);
        } else {
            W.r(-2);
        }
    }

    public c62() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = false;
    }
}
