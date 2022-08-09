package com.repackage;

import android.content.ContentValues;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.core.prefetch.image.res.SwanPrefetchImageRes;
import com.baidu.swan.apps.pay.panel.PaymentPanelManager;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.o43;
import com.repackage.vj2;
import com.repackage.wl2;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class jm2 extends im2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean l;
    public transient /* synthetic */ FieldHolder $fh;
    public Runnable k;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;

        public a(jm2 jm2Var, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jm2Var, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                se3.g(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements tj2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wl2 a;
        public final /* synthetic */ jm2 b;

        /* loaded from: classes6.dex */
        public class a implements o43.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ vj2.g b;
            public final /* synthetic */ b c;

            public a(b bVar, int i, vj2.g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, Integer.valueOf(i), gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = bVar;
                this.a = i;
                this.b = gVar;
            }

            @Override // com.repackage.o43.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    zx1.i("SwanApp", "download subpackage success");
                    b bVar = this.c;
                    bVar.b.X(this.a, bVar.a, this.b);
                }
            }

            @Override // com.repackage.o43.e
            public void b(int i, sc3 sc3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, sc3Var) == null) {
                    zx1.o("SwanApp", "download subpackage fail: " + i);
                    this.c.a.R0(null);
                    b bVar = this.c;
                    bVar.b.X(this.a, bVar.a, this.b);
                    sc3 sc3Var2 = new sc3();
                    sc3Var2.k(5L);
                    sc3Var2.i(38L);
                    sc3Var2.f("download subpackage fail, errcode=" + i);
                    a83 a83Var = new a83();
                    a83Var.q(s73.n(this.c.a.G()));
                    a83Var.p(sc3Var2);
                    a83Var.r(this.c.a);
                    s73.R(a83Var);
                }
            }
        }

        public b(jm2 jm2Var, wl2 wl2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jm2Var, wl2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = jm2Var;
            this.a = wl2Var;
        }

        @Override // com.repackage.tj2
        public void a(int i, sj2 sj2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, sj2Var) == null) {
                vj2.g gVar = (vj2.g) sj2Var;
                if (o43.p(this.a, gVar)) {
                    if (z03.M() != null && !TextUtils.isEmpty(gVar.a)) {
                        String f = re3.f(this.a.e0());
                        if (!TextUtils.isEmpty(f) && f.startsWith(File.separator)) {
                            f = f.substring(1);
                        }
                        String str = gVar.b.c.c.get(r43.b(f));
                        o43.m(this.a.H(), this.a.v1(), "3", str, gVar.b.d.a.get(str), this.b.C(), new a(this, i, gVar));
                        return;
                    }
                    zx1.o("SwanApp", "subpackage is invalid");
                }
                this.b.X(i, this.a, gVar);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wl2 a;

        public c(jm2 jm2Var, wl2 wl2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jm2Var, wl2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wl2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                vj2.e.c(this.a.H(), this.a.v1());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wl2 a;
        public final /* synthetic */ vj2.g b;
        public final /* synthetic */ jm2 c;

        public d(jm2 jm2Var, wl2 wl2Var, vj2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jm2Var, wl2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = jm2Var;
            this.a = wl2Var;
            this.b = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.Y(this.a, this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wl2 a;

        public e(jm2 jm2Var, wl2 wl2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jm2Var, wl2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wl2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String n = this.a.n("fromHost");
                String n2 = this.a.n("spuId");
                String n3 = this.a.n("contentId");
                if (TextUtils.isEmpty(n) || TextUtils.isEmpty(n2) || TextUtils.isEmpty(n3) || !gk2.s0().a(n, n2, n3)) {
                    return;
                }
                this.a.z("fromHost", null);
                this.a.z("spuId", null);
                this.a.z("contentId", null);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755583934, "Lcom/repackage/jm2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755583934, "Lcom/repackage/jm2;");
                return;
            }
        }
        l = jh1.a;
    }

    public jm2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // com.repackage.im2, com.repackage.km2
    @Nullable
    public z03 D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? z03.M() : (z03) invokeV.objValue;
    }

    @Override // com.repackage.im2, com.repackage.km2
    public void E(wl2 wl2Var, tj2 tj2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wl2Var, tj2Var) == null) {
            super.E(wl2Var, tj2Var);
            if (l) {
                Log.d("AppsControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + wl2Var.j0());
            }
            vj2.c(wl2Var, new b(this, wl2Var));
            t72.U().d1(wl2Var);
            t72.U().c1(wl2Var);
            t72.U().H0(null);
        }
    }

    @Override // com.repackage.im2, com.repackage.km2
    public SwanCoreVersion M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? t72.U().d0() : (SwanCoreVersion) invokeV.objValue;
    }

    @Override // com.repackage.im2, com.repackage.km2
    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.O();
            e72.d();
            t72.N0(false);
            if (this.a != null) {
                this.a = null;
            }
            md3.j();
            yn2.b();
            pp2.y();
            wb3.u();
            PaymentPanelManager.F();
            ya3.n();
            la3.d();
            hb3.k();
            fe2.d();
            cd4.f();
            nr2.e().o();
            p33.h();
            ra3.h();
            mr2.k();
            if (gk2.I() != null) {
                gk2.I().e();
            }
            qr1.e().n();
            it1.b().f();
            m33.b().k();
            qf2.d();
            ls1.d().h();
            er2.g().f();
            o72.b();
            sl2.c().a();
            tv2.g().b();
            SwanPrefetchImageRes.b().e();
            y42.g().d();
            zy1.c().n();
            rg3.c().i();
        }
    }

    public final void X(int i, wl2 wl2Var, vj2.g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeILL(1048580, this, i, wl2Var, gVar) == null) || i != 0 || wl2Var == null || gVar == null) {
            return;
        }
        eu2.o().F(new UbcFlowEvent("na_post_to_main_start"));
        te3.d0(this.k);
        d dVar = new d(this, wl2Var, gVar);
        this.k = dVar;
        te3.g0(dVar);
    }

    public final void Y(wl2 wl2Var, vj2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, wl2Var, gVar) == null) {
            eu2.o().F(new UbcFlowEvent("na_post_to_main_end"));
            z63.d().i("na_post_to_main_end");
            if (l) {
                Log.d("AppsControllerImpl", "onLoaded loadedInfo: " + gVar);
            }
            if (this.i) {
                if (l) {
                    Log.e("AppsControllerImpl", Log.getStackTraceString(new Exception("object is released. bundlePath:" + gVar.a + ", baseUrl:" + mm2.U().z())));
                    return;
                }
                return;
            }
            this.c = gVar.a;
            a0(gVar.b);
            if (wl2Var.m0()) {
                n(this.d).setVisibility(0);
                wx1.b(true);
                zx1.i("AppsControllerImpl", "init sConsole for devHook");
            }
            zx1.i("AppsControllerImpl", "handleLoadSwanApp: start MiniApp first page.");
            t72.U().Z0(wl2Var, gVar);
        }
    }

    public final void Z(wl2 wl2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, wl2Var) == null) || TextUtils.isEmpty(wl2Var.n("fromHost")) || TextUtils.isEmpty(wl2Var.n("spuId")) || TextUtils.isEmpty(wl2Var.n("contentId"))) {
            return;
        }
        te3.b0(new e(this, wl2Var), 2000L);
    }

    public final void a0(SwanAppConfigData swanAppConfigData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, swanAppConfigData) == null) {
            y03 K = y03.K();
            if (K.E()) {
                K.q().G0(swanAppConfigData);
            }
        }
    }

    @Override // com.repackage.im2, com.repackage.km2
    public void d(wl2 wl2Var, tj2 tj2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, wl2Var, tj2Var) == null) {
            super.d(wl2Var, tj2Var);
            if (l) {
                Log.d("AppsControllerImpl", "syncLoadSwanApp swanCoreVersion: " + wl2Var.j0());
            }
            t72.U().d1(wl2Var);
            t72.U().H0(null);
            SwanAppConfigData Q = y03.K().q().Q();
            if (Q != null) {
                vj2.g gVar = new vj2.g();
                su2.e().d(new c(this, wl2Var), "deleteLowerVersionFolder", true);
                gVar.b = Q;
                gVar.a = vj2.e.i(wl2Var.H(), wl2Var.v1()).getPath() + File.separator;
                eu2.o().F(new UbcFlowEvent("na_post_to_main_start"));
                z63.d().i("na_post_to_main_start");
                Y(wl2Var, gVar);
            }
        }
    }

    @Override // com.repackage.km2
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            long S = mm2.U().S();
            if (l) {
                Log.i("AppsControllerImpl", "onAppBackground: background alive thread count:" + S);
            }
            return this.h && S <= 0;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.im2, com.repackage.km2
    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.v();
            zx1.i("SwanApp", "onAppForeground");
            String g0 = z03.g0();
            if (TextUtils.isEmpty(g0)) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onAppShow");
            hashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, g0);
            hashMap.put("launchId", zu2.b());
            SwanAppActivity swanAppActivity = this.d;
            if (swanAppActivity != null && swanAppActivity.S() != null) {
                hashMap.put("clkid", this.d.S().L());
                hashMap.put("scene", this.d.S().T());
                wl2.a S = this.d.S();
                j73.v(S);
                Z(S);
            }
            u(new bb2(hashMap));
            zx1.i("SwanApp", "onAppShow");
            it1.b().g(false);
            yn2.h(true);
            pp2.r(false);
            nr2.e().h(false);
            qr1.e().j();
            mr2.i();
            if (gk2.I() != null) {
                gk2.I().a();
            }
            a aVar = new a(this, System.currentTimeMillis());
            if (av2.h()) {
                su2.e().d(aVar, "saveSwanAppForeGroundTime", false);
            } else {
                td3.k(aVar, "saveSwanAppForeGroundTime");
            }
        }
    }

    @Override // com.repackage.im2, com.repackage.km2
    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.w();
            zx1.i("SwanApp", "onAppBackground");
            String g0 = z03.g0();
            if (TextUtils.isEmpty(g0)) {
                return;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("lcType", "onAppHide");
            contentValues.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, g0);
            contentValues.put("hiddenType", Integer.valueOf(bf3.b().a()));
            u(new bb2(contentValues));
            zx1.i("SwanApp", "onAppHide");
            bf3.b().d();
            it1.b().g(true);
            yn2.h(false);
            pp2.r(true);
            nr2.e().h(true);
            mr2.j(false);
            if (gk2.I() != null) {
                gk2.I().c();
            }
            se3.h();
            xq2.i();
        }
    }
}
