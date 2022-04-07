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
import com.repackage.fj2;
import java.io.File;
/* loaded from: classes7.dex */
public final class r52 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final r52 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-89390524, "Lcom/repackage/r52$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-89390524, "Lcom/repackage/r52$b;");
                    return;
                }
            }
            a = new r52(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755399422, "Lcom/repackage/r52;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755399422, "Lcom/repackage/r52;");
                return;
            }
        }
        b = tg1.a;
    }

    public /* synthetic */ r52(a aVar) {
        this();
    }

    public static r52 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? b.a : (r52) invokeV.objValue;
    }

    public final void a(@NonNull SwanAppConfigData swanAppConfigData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, swanAppConfigData) == null) {
            if (b) {
                Log.d("AppLaunchMessenger", "afterLaunchEventSent: start");
            }
            tp1.k(swanAppConfigData);
            t52.k().x(i03.J().getAppId(), false);
            f93.l().t();
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
    /* JADX WARN: Type inference failed for: r3v15, types: [com.repackage.qm1] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void b(@NonNull f22 f22Var, @NonNull pm1 pm1Var, @NonNull gl2 gl2Var, @NonNull SwanAppConfigData swanAppConfigData, @Nullable fj2.g gVar, boolean z) {
        boolean z2;
        PMSAppInfo f0;
        boolean H;
        Bundle P;
        boolean F;
        a72 a72Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{f22Var, pm1Var, gl2Var, swanAppConfigData, gVar, Boolean.valueOf(z)}) == null) {
            synchronized (this) {
                if (b) {
                    Log.d("AppLaunchMessenger", "dispatchLaunchEvent");
                    Log.d("SwanPrelink", "start dispatch launch event");
                }
                if (this.a) {
                    if (z) {
                        y62.c(14);
                    }
                    return;
                }
                if (z) {
                    y62.c(1);
                }
                String d = u33.d(wl2.U(), gl2Var, swanAppConfigData);
                String h = swanAppConfigData.h(d);
                x62 x62Var = new x62();
                x62Var.a = swanAppConfigData.n;
                if (gVar != null && !TextUtils.isEmpty(gVar.a)) {
                    x62Var.b = gVar.a;
                } else {
                    x62Var.b = fj2.e.i(gl2Var.H(), gl2Var.v1()).getPath() + File.separator;
                }
                x62Var.c = pm1Var.c();
                x62Var.d = d;
                x62Var.f = String.valueOf(gx1.a());
                x62Var.g = x62.c(j03.L(), d);
                x62Var.i = h;
                if (!b && !wl2.U().N()) {
                    z2 = false;
                    x62Var.h = z2;
                    x62Var.j = pm1Var.M();
                    x62Var.l = b72.b();
                    f0 = gl2Var.f0();
                    if (f0 != null && !TextUtils.isEmpty(f0.userActionApis)) {
                        x62Var.m = f0.userActionApis;
                    }
                    H = iw2.H();
                    if (H) {
                        x62Var.k = mx1.b();
                    }
                    P = gl2Var.P();
                    if (P != null) {
                        String string = P.getString(PrefetchEvent.EVENT_DATA_EXTRA_DATA);
                        if (!TextUtils.isEmpty(string)) {
                            x62Var.e = string;
                        }
                    }
                    if (b) {
                        Log.d("AppLaunchMessenger", x62Var.toString());
                    }
                    ot2.o().F(new UbcFlowEvent("master_dispatch_start"));
                    j63.d().i("master_dispatch_start");
                    f22Var.F(x62Var);
                    d72.U().U0(x62.b(x62Var));
                    qj2.m0().a();
                    d72.U().h1(x62Var.j);
                    F = iw2.F(gl2Var.g0());
                    boolean p0 = gl2Var.p0();
                    if (!F) {
                        zx1.d();
                        zx1.g().h("appready");
                    } else if (p0) {
                        sx1.e().f("appready");
                    }
                    y03 f = wl2.U().f(b43.b(be3.f(d)));
                    a72Var = new a72();
                    if (gVar == null && !TextUtils.isEmpty(gVar.a)) {
                        a72Var.a = gVar.a;
                    } else {
                        a72Var.a = fj2.e.i(gl2Var.H(), gl2Var.v1()).getPath() + File.separator;
                    }
                    a72Var.b = d;
                    a72Var.d = f.g;
                    a72Var.c = h;
                    a72Var.k = x62Var.g;
                    a72Var.e = String.valueOf(gl2Var.m0());
                    a72Var.g = z2;
                    a72Var.i = pm1Var.M();
                    a72Var.m = true;
                    if (H) {
                        a72Var.j = mx1.d();
                    }
                    if (!F) {
                        zx1.g().h("pageready");
                    } else if (p0) {
                        sx1.e().f("pageready");
                    }
                    if (b) {
                        Log.d("AppLaunchMessenger", a72Var.toString());
                    }
                    ot2.o().F(new UbcFlowEvent("slave_dispatch_start"));
                    j63.d().i("slave_dispatch_start");
                    pm1Var.N(a72Var);
                    qd3.d();
                    pm1Var.u().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, d);
                    pm1Var.U(d);
                    d72.U().V0(pm1Var.c(), a72.a(a72Var));
                    t63.F(pm1Var.c(), a72Var.b);
                    if (b) {
                        Log.d("AppLaunchMessenger", "app path: " + x62Var.b);
                        Log.d("AppLaunchMessenger", "webviewId: " + pm1Var.c());
                        Log.d("AppLaunchMessenger", "pageUrl: " + d);
                        Log.d("AppLaunchMessenger", "pagePath: " + a72Var.b);
                        Log.d("AppLaunchMessenger", "onReachBottomDistance: " + a72Var.d);
                        Log.d("AppLaunchMessenger", "sConsole:" + a72Var.e);
                    }
                    a(swanAppConfigData);
                    this.a = true;
                    e();
                }
                z2 = true;
                x62Var.h = z2;
                x62Var.j = pm1Var.M();
                x62Var.l = b72.b();
                f0 = gl2Var.f0();
                if (f0 != null) {
                    x62Var.m = f0.userActionApis;
                }
                H = iw2.H();
                if (H) {
                }
                P = gl2Var.P();
                if (P != null) {
                }
                if (b) {
                }
                ot2.o().F(new UbcFlowEvent("master_dispatch_start"));
                j63.d().i("master_dispatch_start");
                f22Var.F(x62Var);
                d72.U().U0(x62.b(x62Var));
                qj2.m0().a();
                d72.U().h1(x62Var.j);
                F = iw2.F(gl2Var.g0());
                boolean p02 = gl2Var.p0();
                if (!F) {
                }
                y03 f2 = wl2.U().f(b43.b(be3.f(d)));
                a72Var = new a72();
                if (gVar == null) {
                }
                a72Var.a = fj2.e.i(gl2Var.H(), gl2Var.v1()).getPath() + File.separator;
                a72Var.b = d;
                a72Var.d = f2.g;
                a72Var.c = h;
                a72Var.k = x62Var.g;
                a72Var.e = String.valueOf(gl2Var.m0());
                a72Var.g = z2;
                a72Var.i = pm1Var.M();
                a72Var.m = true;
                if (H) {
                }
                if (!F) {
                }
                if (b) {
                }
                ot2.o().F(new UbcFlowEvent("slave_dispatch_start"));
                j63.d().i("slave_dispatch_start");
                pm1Var.N(a72Var);
                qd3.d();
                pm1Var.u().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, d);
                pm1Var.U(d);
                d72.U().V0(pm1Var.c(), a72.a(a72Var));
                t63.F(pm1Var.c(), a72Var.b);
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
        f22 W;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (b2 = hu2.b()) == 0 || (W = d72.U().W()) == null) {
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

    public r52() {
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
