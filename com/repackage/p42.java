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
import com.repackage.di2;
import java.io.File;
/* loaded from: classes6.dex */
public final class p42 {
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
        public static final p42 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-147572347, "Lcom/repackage/p42$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-147572347, "Lcom/repackage/p42$b;");
                    return;
                }
            }
            a = new p42(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755459965, "Lcom/repackage/p42;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755459965, "Lcom/repackage/p42;");
                return;
            }
        }
        b = rf1.a;
    }

    public /* synthetic */ p42(a aVar) {
        this();
    }

    public static p42 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? b.a : (p42) invokeV.objValue;
    }

    public final void a(@NonNull SwanAppConfigData swanAppConfigData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, swanAppConfigData) == null) {
            if (b) {
                Log.d("AppLaunchMessenger", "afterLaunchEventSent: start");
            }
            ro1.k(swanAppConfigData);
            r42.k().x(gz2.J().getAppId(), false);
            d83.l().t();
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
    /* JADX WARN: Type inference failed for: r3v15, types: [com.repackage.ol1] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void b(@NonNull d12 d12Var, @NonNull nl1 nl1Var, @NonNull ek2 ek2Var, @NonNull SwanAppConfigData swanAppConfigData, @Nullable di2.g gVar, boolean z) {
        boolean z2;
        PMSAppInfo f0;
        boolean H;
        Bundle P;
        boolean F;
        y52 y52Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{d12Var, nl1Var, ek2Var, swanAppConfigData, gVar, Boolean.valueOf(z)}) == null) {
            synchronized (this) {
                if (b) {
                    Log.d("AppLaunchMessenger", "dispatchLaunchEvent");
                    Log.d("SwanPrelink", "start dispatch launch event");
                }
                if (this.a) {
                    if (z) {
                        w52.c(14);
                    }
                    return;
                }
                if (z) {
                    w52.c(1);
                }
                String d = s23.d(uk2.U(), ek2Var, swanAppConfigData);
                String h = swanAppConfigData.h(d);
                v52 v52Var = new v52();
                v52Var.a = swanAppConfigData.n;
                if (gVar != null && !TextUtils.isEmpty(gVar.a)) {
                    v52Var.b = gVar.a;
                } else {
                    v52Var.b = di2.e.i(ek2Var.H(), ek2Var.v1()).getPath() + File.separator;
                }
                v52Var.c = nl1Var.c();
                v52Var.d = d;
                v52Var.f = String.valueOf(ew1.a());
                v52Var.g = v52.c(hz2.L(), d);
                v52Var.i = h;
                if (!b && !uk2.U().N()) {
                    z2 = false;
                    v52Var.h = z2;
                    v52Var.j = nl1Var.M();
                    v52Var.l = z52.b();
                    f0 = ek2Var.f0();
                    if (f0 != null && !TextUtils.isEmpty(f0.userActionApis)) {
                        v52Var.m = f0.userActionApis;
                    }
                    H = gv2.H();
                    if (H) {
                        v52Var.k = kw1.b();
                    }
                    P = ek2Var.P();
                    if (P != null) {
                        String string = P.getString(PrefetchEvent.EVENT_DATA_EXTRA_DATA);
                        if (!TextUtils.isEmpty(string)) {
                            v52Var.e = string;
                        }
                    }
                    if (b) {
                        Log.d("AppLaunchMessenger", v52Var.toString());
                    }
                    ms2.o().F(new UbcFlowEvent("master_dispatch_start"));
                    h53.d().i("master_dispatch_start");
                    d12Var.F(v52Var);
                    b62.U().U0(v52.b(v52Var));
                    oi2.m0().a();
                    b62.U().h1(v52Var.j);
                    F = gv2.F(ek2Var.g0());
                    boolean p0 = ek2Var.p0();
                    if (!F) {
                        xw1.d();
                        xw1.g().h("appready");
                    } else if (p0) {
                        qw1.e().f("appready");
                    }
                    wz2 f = uk2.U().f(z23.b(zc3.f(d)));
                    y52Var = new y52();
                    if (gVar == null && !TextUtils.isEmpty(gVar.a)) {
                        y52Var.a = gVar.a;
                    } else {
                        y52Var.a = di2.e.i(ek2Var.H(), ek2Var.v1()).getPath() + File.separator;
                    }
                    y52Var.b = d;
                    y52Var.d = f.g;
                    y52Var.c = h;
                    y52Var.k = v52Var.g;
                    y52Var.e = String.valueOf(ek2Var.m0());
                    y52Var.g = z2;
                    y52Var.i = nl1Var.M();
                    y52Var.m = true;
                    if (H) {
                        y52Var.j = kw1.d();
                    }
                    if (!F) {
                        xw1.g().h("pageready");
                    } else if (p0) {
                        qw1.e().f("pageready");
                    }
                    if (b) {
                        Log.d("AppLaunchMessenger", y52Var.toString());
                    }
                    ms2.o().F(new UbcFlowEvent("slave_dispatch_start"));
                    h53.d().i("slave_dispatch_start");
                    nl1Var.N(y52Var);
                    oc3.d();
                    nl1Var.u().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, d);
                    nl1Var.U(d);
                    b62.U().V0(nl1Var.c(), y52.a(y52Var));
                    r53.F(nl1Var.c(), y52Var.b);
                    if (b) {
                        Log.d("AppLaunchMessenger", "app path: " + v52Var.b);
                        Log.d("AppLaunchMessenger", "webviewId: " + nl1Var.c());
                        Log.d("AppLaunchMessenger", "pageUrl: " + d);
                        Log.d("AppLaunchMessenger", "pagePath: " + y52Var.b);
                        Log.d("AppLaunchMessenger", "onReachBottomDistance: " + y52Var.d);
                        Log.d("AppLaunchMessenger", "sConsole:" + y52Var.e);
                    }
                    a(swanAppConfigData);
                    this.a = true;
                    e();
                }
                z2 = true;
                v52Var.h = z2;
                v52Var.j = nl1Var.M();
                v52Var.l = z52.b();
                f0 = ek2Var.f0();
                if (f0 != null) {
                    v52Var.m = f0.userActionApis;
                }
                H = gv2.H();
                if (H) {
                }
                P = ek2Var.P();
                if (P != null) {
                }
                if (b) {
                }
                ms2.o().F(new UbcFlowEvent("master_dispatch_start"));
                h53.d().i("master_dispatch_start");
                d12Var.F(v52Var);
                b62.U().U0(v52.b(v52Var));
                oi2.m0().a();
                b62.U().h1(v52Var.j);
                F = gv2.F(ek2Var.g0());
                boolean p02 = ek2Var.p0();
                if (!F) {
                }
                wz2 f2 = uk2.U().f(z23.b(zc3.f(d)));
                y52Var = new y52();
                if (gVar == null) {
                }
                y52Var.a = di2.e.i(ek2Var.H(), ek2Var.v1()).getPath() + File.separator;
                y52Var.b = d;
                y52Var.d = f2.g;
                y52Var.c = h;
                y52Var.k = v52Var.g;
                y52Var.e = String.valueOf(ek2Var.m0());
                y52Var.g = z2;
                y52Var.i = nl1Var.M();
                y52Var.m = true;
                if (H) {
                }
                if (!F) {
                }
                if (b) {
                }
                ms2.o().F(new UbcFlowEvent("slave_dispatch_start"));
                h53.d().i("slave_dispatch_start");
                nl1Var.N(y52Var);
                oc3.d();
                nl1Var.u().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, d);
                nl1Var.U(d);
                b62.U().V0(nl1Var.c(), y52.a(y52Var));
                r53.F(nl1Var.c(), y52Var.b);
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
        d12 W;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (b2 = ft2.b()) == 0 || (W = b62.U().W()) == null) {
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

    public p42() {
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
