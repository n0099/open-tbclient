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
import com.repackage.j43;
import com.repackage.qj2;
import com.repackage.rl2;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class em2 extends dm2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean l;
    public transient /* synthetic */ FieldHolder $fh;
    public Runnable k;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;

        public a(em2 em2Var, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {em2Var, Long.valueOf(j)};
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
                ne3.g(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements oj2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rl2 a;
        public final /* synthetic */ em2 b;

        /* loaded from: classes6.dex */
        public class a implements j43.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ qj2.g b;
            public final /* synthetic */ b c;

            public a(b bVar, int i, qj2.g gVar) {
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

            @Override // com.repackage.j43.e
            public void b(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    ux1.i("SwanApp", "download subpackage success");
                    b bVar = this.c;
                    bVar.b.X(this.a, bVar.a, this.b);
                }
            }

            @Override // com.repackage.j43.e
            public void c(int i, nc3 nc3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, nc3Var) == null) {
                    ux1.o("SwanApp", "download subpackage fail: " + i);
                    this.c.a.R0(null);
                    b bVar = this.c;
                    bVar.b.X(this.a, bVar.a, this.b);
                    nc3 nc3Var2 = new nc3();
                    nc3Var2.k(5L);
                    nc3Var2.i(38L);
                    nc3Var2.f("download subpackage fail, errcode=" + i);
                    v73 v73Var = new v73();
                    v73Var.q(n73.n(this.c.a.G()));
                    v73Var.p(nc3Var2);
                    v73Var.r(this.c.a);
                    n73.R(v73Var);
                }
            }
        }

        public b(em2 em2Var, rl2 rl2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {em2Var, rl2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = em2Var;
            this.a = rl2Var;
        }

        @Override // com.repackage.oj2
        public void a(int i, nj2 nj2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, nj2Var) == null) {
                qj2.g gVar = (qj2.g) nj2Var;
                if (j43.p(this.a, gVar)) {
                    if (u03.L() != null && !TextUtils.isEmpty(gVar.a)) {
                        String f = me3.f(this.a.e0());
                        if (!TextUtils.isEmpty(f) && f.startsWith(File.separator)) {
                            f = f.substring(1);
                        }
                        String str = gVar.b.c.c.get(m43.b(f));
                        j43.m(this.a.H(), this.a.v1(), "3", str, gVar.b.d.a.get(str), this.b.C(), new a(this, i, gVar));
                        return;
                    }
                    ux1.o("SwanApp", "subpackage is invalid");
                }
                this.b.X(i, this.a, gVar);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rl2 a;

        public c(em2 em2Var, rl2 rl2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {em2Var, rl2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rl2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                qj2.e.c(this.a.H(), this.a.v1());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rl2 a;
        public final /* synthetic */ qj2.g b;
        public final /* synthetic */ em2 c;

        public d(em2 em2Var, rl2 rl2Var, qj2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {em2Var, rl2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = em2Var;
            this.a = rl2Var;
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
        public final /* synthetic */ rl2 a;

        public e(em2 em2Var, rl2 rl2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {em2Var, rl2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rl2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String n = this.a.n("fromHost");
                String n2 = this.a.n("spuId");
                String n3 = this.a.n("contentId");
                if (TextUtils.isEmpty(n) || TextUtils.isEmpty(n2) || TextUtils.isEmpty(n3) || !bk2.s0().a(n, n2, n3)) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755732889, "Lcom/repackage/em2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755732889, "Lcom/repackage/em2;");
                return;
            }
        }
        l = eh1.a;
    }

    public em2() {
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

    @Override // com.repackage.dm2, com.repackage.fm2
    @Nullable
    public u03 D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? u03.L() : (u03) invokeV.objValue;
    }

    @Override // com.repackage.dm2, com.repackage.fm2
    public void E(rl2 rl2Var, oj2 oj2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rl2Var, oj2Var) == null) {
            super.E(rl2Var, oj2Var);
            if (l) {
                Log.d("AppsControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + rl2Var.j0());
            }
            qj2.c(rl2Var, new b(this, rl2Var));
            o72.U().d1(rl2Var);
            o72.U().c1(rl2Var);
            o72.U().H0(null);
        }
    }

    @Override // com.repackage.dm2, com.repackage.fm2
    public SwanCoreVersion M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? o72.U().d0() : (SwanCoreVersion) invokeV.objValue;
    }

    @Override // com.repackage.dm2, com.repackage.fm2
    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.O();
            z62.d();
            o72.N0(false);
            if (this.a != null) {
                this.a = null;
            }
            hd3.j();
            tn2.b();
            kp2.y();
            rb3.u();
            PaymentPanelManager.F();
            ta3.n();
            ga3.d();
            cb3.k();
            ae2.d();
            xc4.f();
            ir2.e().o();
            k33.h();
            ma3.h();
            hr2.k();
            if (bk2.I() != null) {
                bk2.I().e();
            }
            lr1.e().n();
            dt1.b().f();
            h33.b().k();
            lf2.d();
            gs1.d().h();
            zq2.g().f();
            j72.b();
            nl2.c().a();
            ov2.g().b();
            SwanPrefetchImageRes.b().e();
            t42.g().d();
            uy1.c().n();
            mg3.c().i();
        }
    }

    public final void X(int i, rl2 rl2Var, qj2.g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeILL(1048580, this, i, rl2Var, gVar) == null) || i != 0 || rl2Var == null || gVar == null) {
            return;
        }
        zt2.o().F(new UbcFlowEvent("na_post_to_main_start"));
        oe3.d0(this.k);
        d dVar = new d(this, rl2Var, gVar);
        this.k = dVar;
        oe3.g0(dVar);
    }

    public final void Y(rl2 rl2Var, qj2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, rl2Var, gVar) == null) {
            zt2.o().F(new UbcFlowEvent("na_post_to_main_end"));
            u63.d().i("na_post_to_main_end");
            if (l) {
                Log.d("AppsControllerImpl", "onLoaded loadedInfo: " + gVar);
            }
            if (this.i) {
                if (l) {
                    Log.e("AppsControllerImpl", Log.getStackTraceString(new Exception("object is released. bundlePath:" + gVar.a + ", baseUrl:" + hm2.U().z())));
                    return;
                }
                return;
            }
            this.c = gVar.a;
            a0(gVar.b);
            if (rl2Var.m0()) {
                n(this.d).setVisibility(0);
                rx1.b(true);
                ux1.i("AppsControllerImpl", "init sConsole for devHook");
            }
            ux1.i("AppsControllerImpl", "handleLoadSwanApp: start MiniApp first page.");
            o72.U().Z0(rl2Var, gVar);
        }
    }

    public final void Z(rl2 rl2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, rl2Var) == null) || TextUtils.isEmpty(rl2Var.n("fromHost")) || TextUtils.isEmpty(rl2Var.n("spuId")) || TextUtils.isEmpty(rl2Var.n("contentId"))) {
            return;
        }
        oe3.b0(new e(this, rl2Var), 2000L);
    }

    public final void a0(SwanAppConfigData swanAppConfigData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, swanAppConfigData) == null) {
            t03 J = t03.J();
            if (J.D()) {
                J.r().F0(swanAppConfigData);
            }
        }
    }

    @Override // com.repackage.dm2, com.repackage.fm2
    public void d(rl2 rl2Var, oj2 oj2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, rl2Var, oj2Var) == null) {
            super.d(rl2Var, oj2Var);
            if (l) {
                Log.d("AppsControllerImpl", "syncLoadSwanApp swanCoreVersion: " + rl2Var.j0());
            }
            o72.U().d1(rl2Var);
            o72.U().H0(null);
            SwanAppConfigData P = t03.J().r().P();
            if (P != null) {
                qj2.g gVar = new qj2.g();
                nu2.e().d(new c(this, rl2Var), "deleteLowerVersionFolder", true);
                gVar.b = P;
                gVar.a = qj2.e.i(rl2Var.H(), rl2Var.v1()).getPath() + File.separator;
                zt2.o().F(new UbcFlowEvent("na_post_to_main_start"));
                u63.d().i("na_post_to_main_start");
                Y(rl2Var, gVar);
            }
        }
    }

    @Override // com.repackage.fm2
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            long S = hm2.U().S();
            if (l) {
                Log.i("AppsControllerImpl", "onAppBackground: background alive thread count:" + S);
            }
            return this.h && S <= 0;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.dm2, com.repackage.fm2
    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.v();
            ux1.i("SwanApp", "onAppForeground");
            String f0 = u03.f0();
            if (TextUtils.isEmpty(f0)) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onAppShow");
            hashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, f0);
            hashMap.put("launchId", uu2.b());
            SwanAppActivity swanAppActivity = this.d;
            if (swanAppActivity != null && swanAppActivity.getLaunchInfo() != null) {
                hashMap.put("clkid", this.d.getLaunchInfo().L());
                hashMap.put("scene", this.d.getLaunchInfo().T());
                rl2.a launchInfo = this.d.getLaunchInfo();
                e73.v(launchInfo);
                Z(launchInfo);
            }
            u(new wa2(hashMap));
            ux1.i("SwanApp", "onAppShow");
            dt1.b().g(false);
            tn2.h(true);
            kp2.r(false);
            ir2.e().h(false);
            lr1.e().j();
            hr2.i();
            if (bk2.I() != null) {
                bk2.I().a();
            }
            a aVar = new a(this, System.currentTimeMillis());
            if (vu2.h()) {
                nu2.e().d(aVar, "saveSwanAppForeGroundTime", false);
            } else {
                od3.k(aVar, "saveSwanAppForeGroundTime");
            }
        }
    }

    @Override // com.repackage.dm2, com.repackage.fm2
    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.w();
            ux1.i("SwanApp", "onAppBackground");
            String f0 = u03.f0();
            if (TextUtils.isEmpty(f0)) {
                return;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("lcType", "onAppHide");
            contentValues.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, f0);
            contentValues.put("hiddenType", Integer.valueOf(we3.b().a()));
            u(new wa2(contentValues));
            ux1.i("SwanApp", "onAppHide");
            we3.b().d();
            dt1.b().g(true);
            tn2.h(false);
            kp2.r(true);
            ir2.e().h(true);
            hr2.j(false);
            if (bk2.I() != null) {
                bk2.I().c();
            }
            ne3.h();
            sq2.i();
        }
    }
}
