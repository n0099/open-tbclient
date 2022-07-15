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
import com.repackage.dj2;
import java.io.File;
/* loaded from: classes6.dex */
public final class p52 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final p52 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-146648826, "Lcom/repackage/p52$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-146648826, "Lcom/repackage/p52$b;");
                    return;
                }
            }
            a = new p52(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755459004, "Lcom/repackage/p52;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755459004, "Lcom/repackage/p52;");
                return;
            }
        }
        b = rg1.a;
    }

    public /* synthetic */ p52(a aVar) {
        this();
    }

    public static p52 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? b.a : (p52) invokeV.objValue;
    }

    public final void a(@NonNull SwanAppConfigData swanAppConfigData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, swanAppConfigData) == null) {
            if (b) {
                Log.d("AppLaunchMessenger", "afterLaunchEventSent: start");
            }
            rp1.k(swanAppConfigData);
            r52.k().x(g03.K().getAppId(), false);
            d93.l().t();
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
    /* JADX WARN: Type inference failed for: r3v15, types: [com.repackage.om1] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void b(@NonNull d22 d22Var, @NonNull nm1 nm1Var, @NonNull el2 el2Var, @NonNull SwanAppConfigData swanAppConfigData, @Nullable dj2.g gVar, boolean z) {
        boolean z2;
        PMSAppInfo f0;
        boolean H;
        Bundle P;
        boolean F;
        y62 y62Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{d22Var, nm1Var, el2Var, swanAppConfigData, gVar, Boolean.valueOf(z)}) == null) {
            synchronized (this) {
                if (b) {
                    Log.d("AppLaunchMessenger", "dispatchLaunchEvent");
                    Log.d("SwanPrelink", "start dispatch launch event");
                }
                if (this.a) {
                    if (z) {
                        w62.c(14);
                    }
                    return;
                }
                if (z) {
                    w62.c(1);
                }
                String d = s33.d(ul2.U(), el2Var, swanAppConfigData);
                String h = swanAppConfigData.h(d);
                v62 v62Var = new v62();
                v62Var.a = swanAppConfigData.n;
                if (gVar != null && !TextUtils.isEmpty(gVar.a)) {
                    v62Var.b = gVar.a;
                } else {
                    v62Var.b = dj2.e.i(el2Var.H(), el2Var.v1()).getPath() + File.separator;
                }
                v62Var.c = nm1Var.b();
                v62Var.d = d;
                v62Var.f = String.valueOf(ex1.a());
                v62Var.g = v62.c(h03.M(), d);
                v62Var.i = h;
                if (!b && !ul2.U().N()) {
                    z2 = false;
                    v62Var.h = z2;
                    v62Var.j = nm1Var.M();
                    v62Var.l = z62.b();
                    f0 = el2Var.f0();
                    if (f0 != null && !TextUtils.isEmpty(f0.userActionApis)) {
                        v62Var.m = f0.userActionApis;
                    }
                    H = gw2.H();
                    if (H) {
                        v62Var.k = kx1.b();
                    }
                    P = el2Var.P();
                    if (P != null) {
                        String string = P.getString(PrefetchEvent.EVENT_DATA_EXTRA_DATA);
                        if (!TextUtils.isEmpty(string)) {
                            v62Var.e = string;
                        }
                    }
                    if (b) {
                        Log.d("AppLaunchMessenger", v62Var.toString());
                    }
                    mt2.o().F(new UbcFlowEvent("master_dispatch_start"));
                    h63.d().i("master_dispatch_start");
                    d22Var.E(v62Var);
                    b72.U().U0(v62.b(v62Var));
                    oj2.m0().a();
                    b72.U().h1(v62Var.j);
                    F = gw2.F(el2Var.g0());
                    boolean p0 = el2Var.p0();
                    if (!F) {
                        xx1.d();
                        xx1.g().h("appready");
                    } else if (p0) {
                        qx1.e().f("appready");
                    }
                    w03 f = ul2.U().f(z33.b(zd3.f(d)));
                    y62Var = new y62();
                    if (gVar == null && !TextUtils.isEmpty(gVar.a)) {
                        y62Var.a = gVar.a;
                    } else {
                        y62Var.a = dj2.e.i(el2Var.H(), el2Var.v1()).getPath() + File.separator;
                    }
                    y62Var.b = d;
                    y62Var.d = f.g;
                    y62Var.c = h;
                    y62Var.k = v62Var.g;
                    y62Var.e = String.valueOf(el2Var.m0());
                    y62Var.g = z2;
                    y62Var.i = nm1Var.M();
                    y62Var.m = true;
                    if (H) {
                        y62Var.j = kx1.d();
                    }
                    if (!F) {
                        xx1.g().h("pageready");
                    } else if (p0) {
                        qx1.e().f("pageready");
                    }
                    if (b) {
                        Log.d("AppLaunchMessenger", y62Var.toString());
                    }
                    mt2.o().F(new UbcFlowEvent("slave_dispatch_start"));
                    h63.d().i("slave_dispatch_start");
                    nm1Var.N(y62Var);
                    od3.d();
                    nm1Var.t().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, d);
                    nm1Var.T(d);
                    b72.U().V0(nm1Var.b(), y62.a(y62Var));
                    r63.F(nm1Var.b(), y62Var.b);
                    if (b) {
                        Log.d("AppLaunchMessenger", "app path: " + v62Var.b);
                        Log.d("AppLaunchMessenger", "webviewId: " + nm1Var.b());
                        Log.d("AppLaunchMessenger", "pageUrl: " + d);
                        Log.d("AppLaunchMessenger", "pagePath: " + y62Var.b);
                        Log.d("AppLaunchMessenger", "onReachBottomDistance: " + y62Var.d);
                        Log.d("AppLaunchMessenger", "sConsole:" + y62Var.e);
                    }
                    a(swanAppConfigData);
                    this.a = true;
                    e();
                }
                z2 = true;
                v62Var.h = z2;
                v62Var.j = nm1Var.M();
                v62Var.l = z62.b();
                f0 = el2Var.f0();
                if (f0 != null) {
                    v62Var.m = f0.userActionApis;
                }
                H = gw2.H();
                if (H) {
                }
                P = el2Var.P();
                if (P != null) {
                }
                if (b) {
                }
                mt2.o().F(new UbcFlowEvent("master_dispatch_start"));
                h63.d().i("master_dispatch_start");
                d22Var.E(v62Var);
                b72.U().U0(v62.b(v62Var));
                oj2.m0().a();
                b72.U().h1(v62Var.j);
                F = gw2.F(el2Var.g0());
                boolean p02 = el2Var.p0();
                if (!F) {
                }
                w03 f2 = ul2.U().f(z33.b(zd3.f(d)));
                y62Var = new y62();
                if (gVar == null) {
                }
                y62Var.a = dj2.e.i(el2Var.H(), el2Var.v1()).getPath() + File.separator;
                y62Var.b = d;
                y62Var.d = f2.g;
                y62Var.c = h;
                y62Var.k = v62Var.g;
                y62Var.e = String.valueOf(el2Var.m0());
                y62Var.g = z2;
                y62Var.i = nm1Var.M();
                y62Var.m = true;
                if (H) {
                }
                if (!F) {
                }
                if (b) {
                }
                mt2.o().F(new UbcFlowEvent("slave_dispatch_start"));
                h63.d().i("slave_dispatch_start");
                nm1Var.N(y62Var);
                od3.d();
                nm1Var.t().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, d);
                nm1Var.T(d);
                b72.U().V0(nm1Var.b(), y62.a(y62Var));
                r63.F(nm1Var.b(), y62Var.b);
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
        d22 W;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (b2 = fu2.b()) == 0 || (W = b72.U().W()) == null) {
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

    public p52() {
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
