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
import com.repackage.dj2;
import com.repackage.el2;
import com.repackage.w33;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class rl2 extends ql2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean l;
    public transient /* synthetic */ FieldHolder $fh;
    public Runnable k;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;

        public a(rl2 rl2Var, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rl2Var, Long.valueOf(j)};
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
                ae3.g(this.a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements bj2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ el2 a;
        public final /* synthetic */ rl2 b;

        /* loaded from: classes7.dex */
        public class a implements w33.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ dj2.g b;
            public final /* synthetic */ b c;

            public a(b bVar, int i, dj2.g gVar) {
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

            @Override // com.repackage.w33.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    hx1.i("SwanApp", "download subpackage success");
                    b bVar = this.c;
                    bVar.b.X(this.a, bVar.a, this.b);
                }
            }

            @Override // com.repackage.w33.e
            public void b(int i, ac3 ac3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, ac3Var) == null) {
                    hx1.o("SwanApp", "download subpackage fail: " + i);
                    this.c.a.R0(null);
                    b bVar = this.c;
                    bVar.b.X(this.a, bVar.a, this.b);
                    ac3 ac3Var2 = new ac3();
                    ac3Var2.k(5L);
                    ac3Var2.i(38L);
                    ac3Var2.f("download subpackage fail, errcode=" + i);
                    i73 i73Var = new i73();
                    i73Var.q(a73.n(this.c.a.G()));
                    i73Var.p(ac3Var2);
                    i73Var.r(this.c.a);
                    a73.R(i73Var);
                }
            }
        }

        public b(rl2 rl2Var, el2 el2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rl2Var, el2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = rl2Var;
            this.a = el2Var;
        }

        @Override // com.repackage.bj2
        public void a(int i, aj2 aj2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, aj2Var) == null) {
                dj2.g gVar = (dj2.g) aj2Var;
                if (w33.p(this.a, gVar)) {
                    if (h03.M() != null && !TextUtils.isEmpty(gVar.a)) {
                        String f = zd3.f(this.a.e0());
                        if (!TextUtils.isEmpty(f) && f.startsWith(File.separator)) {
                            f = f.substring(1);
                        }
                        String str = gVar.b.c.c.get(z33.b(f));
                        w33.m(this.a.H(), this.a.v1(), "3", str, gVar.b.d.a.get(str), this.b.C(), new a(this, i, gVar));
                        return;
                    }
                    hx1.o("SwanApp", "subpackage is invalid");
                }
                this.b.X(i, this.a, gVar);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ el2 a;

        public c(rl2 rl2Var, el2 el2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rl2Var, el2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = el2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                dj2.e.c(this.a.H(), this.a.v1());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ el2 a;
        public final /* synthetic */ dj2.g b;
        public final /* synthetic */ rl2 c;

        public d(rl2 rl2Var, el2 el2Var, dj2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rl2Var, el2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = rl2Var;
            this.a = el2Var;
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

    /* loaded from: classes7.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ el2 a;

        public e(rl2 rl2Var, el2 el2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rl2Var, el2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = el2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String n = this.a.n("fromHost");
                String n2 = this.a.n("spuId");
                String n3 = this.a.n("contentId");
                if (TextUtils.isEmpty(n) || TextUtils.isEmpty(n2) || TextUtils.isEmpty(n3) || !oj2.s0().a(n, n2, n3)) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755346567, "Lcom/repackage/rl2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755346567, "Lcom/repackage/rl2;");
                return;
            }
        }
        l = rg1.a;
    }

    public rl2() {
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

    @Override // com.repackage.ql2, com.repackage.sl2
    @Nullable
    public h03 D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? h03.M() : (h03) invokeV.objValue;
    }

    @Override // com.repackage.ql2, com.repackage.sl2
    public void E(el2 el2Var, bj2 bj2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, el2Var, bj2Var) == null) {
            super.E(el2Var, bj2Var);
            if (l) {
                Log.d("AppsControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + el2Var.j0());
            }
            dj2.c(el2Var, new b(this, el2Var));
            b72.U().d1(el2Var);
            b72.U().c1(el2Var);
            b72.U().H0(null);
        }
    }

    @Override // com.repackage.ql2, com.repackage.sl2
    public SwanCoreVersion M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? b72.U().d0() : (SwanCoreVersion) invokeV.objValue;
    }

    @Override // com.repackage.ql2, com.repackage.sl2
    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.O();
            m62.d();
            b72.N0(false);
            if (this.a != null) {
                this.a = null;
            }
            uc3.j();
            gn2.b();
            xo2.y();
            eb3.u();
            PaymentPanelManager.F();
            ga3.n();
            t93.d();
            pa3.k();
            nd2.d();
            kc4.f();
            vq2.e().o();
            x23.h();
            z93.h();
            uq2.k();
            if (oj2.I() != null) {
                oj2.I().e();
            }
            yq1.e().n();
            qs1.b().f();
            u23.b().k();
            ye2.d();
            tr1.d().h();
            mq2.g().f();
            w62.b();
            al2.c().a();
            bv2.g().b();
            SwanPrefetchImageRes.b().e();
            g42.g().d();
            hy1.c().n();
            zf3.c().i();
        }
    }

    public final void X(int i, el2 el2Var, dj2.g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeILL(1048580, this, i, el2Var, gVar) == null) || i != 0 || el2Var == null || gVar == null) {
            return;
        }
        mt2.o().F(new UbcFlowEvent("na_post_to_main_start"));
        be3.d0(this.k);
        d dVar = new d(this, el2Var, gVar);
        this.k = dVar;
        be3.g0(dVar);
    }

    public final void Y(el2 el2Var, dj2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, el2Var, gVar) == null) {
            mt2.o().F(new UbcFlowEvent("na_post_to_main_end"));
            h63.d().i("na_post_to_main_end");
            if (l) {
                Log.d("AppsControllerImpl", "onLoaded loadedInfo: " + gVar);
            }
            if (this.i) {
                if (l) {
                    Log.e("AppsControllerImpl", Log.getStackTraceString(new Exception("object is released. bundlePath:" + gVar.a + ", baseUrl:" + ul2.U().z())));
                    return;
                }
                return;
            }
            this.c = gVar.a;
            a0(gVar.b);
            if (el2Var.m0()) {
                n(this.d).setVisibility(0);
                ex1.b(true);
                hx1.i("AppsControllerImpl", "init sConsole for devHook");
            }
            hx1.i("AppsControllerImpl", "handleLoadSwanApp: start MiniApp first page.");
            b72.U().Z0(el2Var, gVar);
        }
    }

    public final void Z(el2 el2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, el2Var) == null) || TextUtils.isEmpty(el2Var.n("fromHost")) || TextUtils.isEmpty(el2Var.n("spuId")) || TextUtils.isEmpty(el2Var.n("contentId"))) {
            return;
        }
        be3.b0(new e(this, el2Var), 2000L);
    }

    public final void a0(SwanAppConfigData swanAppConfigData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, swanAppConfigData) == null) {
            g03 K = g03.K();
            if (K.E()) {
                K.q().G0(swanAppConfigData);
            }
        }
    }

    @Override // com.repackage.ql2, com.repackage.sl2
    public void d(el2 el2Var, bj2 bj2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, el2Var, bj2Var) == null) {
            super.d(el2Var, bj2Var);
            if (l) {
                Log.d("AppsControllerImpl", "syncLoadSwanApp swanCoreVersion: " + el2Var.j0());
            }
            b72.U().d1(el2Var);
            b72.U().H0(null);
            SwanAppConfigData Q = g03.K().q().Q();
            if (Q != null) {
                dj2.g gVar = new dj2.g();
                au2.e().d(new c(this, el2Var), "deleteLowerVersionFolder", true);
                gVar.b = Q;
                gVar.a = dj2.e.i(el2Var.H(), el2Var.v1()).getPath() + File.separator;
                mt2.o().F(new UbcFlowEvent("na_post_to_main_start"));
                h63.d().i("na_post_to_main_start");
                Y(el2Var, gVar);
            }
        }
    }

    @Override // com.repackage.sl2
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            long S = ul2.U().S();
            if (l) {
                Log.i("AppsControllerImpl", "onAppBackground: background alive thread count:" + S);
            }
            return this.h && S <= 0;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.ql2, com.repackage.sl2
    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.v();
            hx1.i("SwanApp", "onAppForeground");
            String g0 = h03.g0();
            if (TextUtils.isEmpty(g0)) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onAppShow");
            hashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, g0);
            hashMap.put("launchId", hu2.b());
            SwanAppActivity swanAppActivity = this.d;
            if (swanAppActivity != null && swanAppActivity.S() != null) {
                hashMap.put("clkid", this.d.S().L());
                hashMap.put("scene", this.d.S().T());
                el2.a S = this.d.S();
                r63.v(S);
                Z(S);
            }
            u(new ja2(hashMap));
            hx1.i("SwanApp", "onAppShow");
            qs1.b().g(false);
            gn2.h(true);
            xo2.r(false);
            vq2.e().h(false);
            yq1.e().j();
            uq2.i();
            if (oj2.I() != null) {
                oj2.I().a();
            }
            a aVar = new a(this, System.currentTimeMillis());
            if (iu2.h()) {
                au2.e().d(aVar, "saveSwanAppForeGroundTime", false);
            } else {
                bd3.k(aVar, "saveSwanAppForeGroundTime");
            }
        }
    }

    @Override // com.repackage.ql2, com.repackage.sl2
    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.w();
            hx1.i("SwanApp", "onAppBackground");
            String g0 = h03.g0();
            if (TextUtils.isEmpty(g0)) {
                return;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("lcType", "onAppHide");
            contentValues.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, g0);
            contentValues.put("hiddenType", Integer.valueOf(je3.b().a()));
            u(new ja2(contentValues));
            hx1.i("SwanApp", "onAppHide");
            je3.b().d();
            qs1.b().g(true);
            gn2.h(false);
            xo2.r(true);
            vq2.e().h(true);
            uq2.j(false);
            if (oj2.I() != null) {
                oj2.I().c();
            }
            ae3.h();
            fq2.i();
        }
    }
}
