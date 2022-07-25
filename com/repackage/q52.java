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
import com.repackage.ej2;
import java.io.File;
/* loaded from: classes7.dex */
public final class q52 {
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
        public static final q52 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-118019675, "Lcom/repackage/q52$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-118019675, "Lcom/repackage/q52$b;");
                    return;
                }
            }
            a = new q52(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755429213, "Lcom/repackage/q52;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755429213, "Lcom/repackage/q52;");
                return;
            }
        }
        b = sg1.a;
    }

    public /* synthetic */ q52(a aVar) {
        this();
    }

    public static q52 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? b.a : (q52) invokeV.objValue;
    }

    public final void a(@NonNull SwanAppConfigData swanAppConfigData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, swanAppConfigData) == null) {
            if (b) {
                Log.d("AppLaunchMessenger", "afterLaunchEventSent: start");
            }
            sp1.k(swanAppConfigData);
            s52.k().x(h03.K().getAppId(), false);
            e93.l().t();
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
    /* JADX WARN: Type inference failed for: r3v15, types: [com.repackage.pm1] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void b(@NonNull e22 e22Var, @NonNull om1 om1Var, @NonNull fl2 fl2Var, @NonNull SwanAppConfigData swanAppConfigData, @Nullable ej2.g gVar, boolean z) {
        boolean z2;
        PMSAppInfo f0;
        boolean H;
        Bundle P;
        boolean F;
        z62 z62Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{e22Var, om1Var, fl2Var, swanAppConfigData, gVar, Boolean.valueOf(z)}) == null) {
            synchronized (this) {
                if (b) {
                    Log.d("AppLaunchMessenger", "dispatchLaunchEvent");
                    Log.d("SwanPrelink", "start dispatch launch event");
                }
                if (this.a) {
                    if (z) {
                        x62.c(14);
                    }
                    return;
                }
                if (z) {
                    x62.c(1);
                }
                String d = t33.d(vl2.U(), fl2Var, swanAppConfigData);
                String h = swanAppConfigData.h(d);
                w62 w62Var = new w62();
                w62Var.a = swanAppConfigData.n;
                if (gVar != null && !TextUtils.isEmpty(gVar.a)) {
                    w62Var.b = gVar.a;
                } else {
                    w62Var.b = ej2.e.i(fl2Var.H(), fl2Var.v1()).getPath() + File.separator;
                }
                w62Var.c = om1Var.b();
                w62Var.d = d;
                w62Var.f = String.valueOf(fx1.a());
                w62Var.g = w62.c(i03.M(), d);
                w62Var.i = h;
                if (!b && !vl2.U().N()) {
                    z2 = false;
                    w62Var.h = z2;
                    w62Var.j = om1Var.M();
                    w62Var.l = a72.b();
                    f0 = fl2Var.f0();
                    if (f0 != null && !TextUtils.isEmpty(f0.userActionApis)) {
                        w62Var.m = f0.userActionApis;
                    }
                    H = hw2.H();
                    if (H) {
                        w62Var.k = lx1.b();
                    }
                    P = fl2Var.P();
                    if (P != null) {
                        String string = P.getString(PrefetchEvent.EVENT_DATA_EXTRA_DATA);
                        if (!TextUtils.isEmpty(string)) {
                            w62Var.e = string;
                        }
                    }
                    if (b) {
                        Log.d("AppLaunchMessenger", w62Var.toString());
                    }
                    nt2.o().F(new UbcFlowEvent("master_dispatch_start"));
                    i63.d().i("master_dispatch_start");
                    e22Var.E(w62Var);
                    c72.U().U0(w62.b(w62Var));
                    pj2.m0().a();
                    c72.U().h1(w62Var.j);
                    F = hw2.F(fl2Var.g0());
                    boolean p0 = fl2Var.p0();
                    if (!F) {
                        yx1.d();
                        yx1.g().h("appready");
                    } else if (p0) {
                        rx1.e().f("appready");
                    }
                    x03 f = vl2.U().f(a43.b(ae3.f(d)));
                    z62Var = new z62();
                    if (gVar == null && !TextUtils.isEmpty(gVar.a)) {
                        z62Var.a = gVar.a;
                    } else {
                        z62Var.a = ej2.e.i(fl2Var.H(), fl2Var.v1()).getPath() + File.separator;
                    }
                    z62Var.b = d;
                    z62Var.d = f.g;
                    z62Var.c = h;
                    z62Var.k = w62Var.g;
                    z62Var.e = String.valueOf(fl2Var.m0());
                    z62Var.g = z2;
                    z62Var.i = om1Var.M();
                    z62Var.m = true;
                    if (H) {
                        z62Var.j = lx1.d();
                    }
                    if (!F) {
                        yx1.g().h("pageready");
                    } else if (p0) {
                        rx1.e().f("pageready");
                    }
                    if (b) {
                        Log.d("AppLaunchMessenger", z62Var.toString());
                    }
                    nt2.o().F(new UbcFlowEvent("slave_dispatch_start"));
                    i63.d().i("slave_dispatch_start");
                    om1Var.N(z62Var);
                    pd3.d();
                    om1Var.t().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, d);
                    om1Var.T(d);
                    c72.U().V0(om1Var.b(), z62.a(z62Var));
                    s63.F(om1Var.b(), z62Var.b);
                    if (b) {
                        Log.d("AppLaunchMessenger", "app path: " + w62Var.b);
                        Log.d("AppLaunchMessenger", "webviewId: " + om1Var.b());
                        Log.d("AppLaunchMessenger", "pageUrl: " + d);
                        Log.d("AppLaunchMessenger", "pagePath: " + z62Var.b);
                        Log.d("AppLaunchMessenger", "onReachBottomDistance: " + z62Var.d);
                        Log.d("AppLaunchMessenger", "sConsole:" + z62Var.e);
                    }
                    a(swanAppConfigData);
                    this.a = true;
                    e();
                }
                z2 = true;
                w62Var.h = z2;
                w62Var.j = om1Var.M();
                w62Var.l = a72.b();
                f0 = fl2Var.f0();
                if (f0 != null) {
                    w62Var.m = f0.userActionApis;
                }
                H = hw2.H();
                if (H) {
                }
                P = fl2Var.P();
                if (P != null) {
                }
                if (b) {
                }
                nt2.o().F(new UbcFlowEvent("master_dispatch_start"));
                i63.d().i("master_dispatch_start");
                e22Var.E(w62Var);
                c72.U().U0(w62.b(w62Var));
                pj2.m0().a();
                c72.U().h1(w62Var.j);
                F = hw2.F(fl2Var.g0());
                boolean p02 = fl2Var.p0();
                if (!F) {
                }
                x03 f2 = vl2.U().f(a43.b(ae3.f(d)));
                z62Var = new z62();
                if (gVar == null) {
                }
                z62Var.a = ej2.e.i(fl2Var.H(), fl2Var.v1()).getPath() + File.separator;
                z62Var.b = d;
                z62Var.d = f2.g;
                z62Var.c = h;
                z62Var.k = w62Var.g;
                z62Var.e = String.valueOf(fl2Var.m0());
                z62Var.g = z2;
                z62Var.i = om1Var.M();
                z62Var.m = true;
                if (H) {
                }
                if (!F) {
                }
                if (b) {
                }
                nt2.o().F(new UbcFlowEvent("slave_dispatch_start"));
                i63.d().i("slave_dispatch_start");
                om1Var.N(z62Var);
                pd3.d();
                om1Var.t().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, d);
                om1Var.T(d);
                c72.U().V0(om1Var.b(), z62.a(z62Var));
                s63.F(om1Var.b(), z62Var.b);
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
        e22 W;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (b2 = gu2.b()) == 0 || (W = c72.U().W()) == null) {
            return;
        }
        if (b2 < 0) {
            W.q(b2);
        } else if (b2 == 1) {
            W.q(-4);
        } else {
            W.q(-2);
        }
    }

    public q52() {
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
