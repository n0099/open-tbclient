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
import com.repackage.ej2;
import com.repackage.fl2;
import com.repackage.x33;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class sl2 extends rl2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean l;
    public transient /* synthetic */ FieldHolder $fh;
    public Runnable k;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;

        public a(sl2 sl2Var, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sl2Var, Long.valueOf(j)};
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
                be3.g(this.a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements cj2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fl2 a;
        public final /* synthetic */ sl2 b;

        /* loaded from: classes7.dex */
        public class a implements x33.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ ej2.g b;
            public final /* synthetic */ b c;

            public a(b bVar, int i, ej2.g gVar) {
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

            @Override // com.repackage.x33.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    ix1.i("SwanApp", "download subpackage success");
                    b bVar = this.c;
                    bVar.b.X(this.a, bVar.a, this.b);
                }
            }

            @Override // com.repackage.x33.e
            public void b(int i, bc3 bc3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bc3Var) == null) {
                    ix1.o("SwanApp", "download subpackage fail: " + i);
                    this.c.a.R0(null);
                    b bVar = this.c;
                    bVar.b.X(this.a, bVar.a, this.b);
                    bc3 bc3Var2 = new bc3();
                    bc3Var2.k(5L);
                    bc3Var2.i(38L);
                    bc3Var2.f("download subpackage fail, errcode=" + i);
                    j73 j73Var = new j73();
                    j73Var.q(b73.n(this.c.a.G()));
                    j73Var.p(bc3Var2);
                    j73Var.r(this.c.a);
                    b73.R(j73Var);
                }
            }
        }

        public b(sl2 sl2Var, fl2 fl2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sl2Var, fl2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = sl2Var;
            this.a = fl2Var;
        }

        @Override // com.repackage.cj2
        public void a(int i, bj2 bj2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, bj2Var) == null) {
                ej2.g gVar = (ej2.g) bj2Var;
                if (x33.p(this.a, gVar)) {
                    if (i03.M() != null && !TextUtils.isEmpty(gVar.a)) {
                        String f = ae3.f(this.a.e0());
                        if (!TextUtils.isEmpty(f) && f.startsWith(File.separator)) {
                            f = f.substring(1);
                        }
                        String str = gVar.b.c.c.get(a43.b(f));
                        x33.m(this.a.H(), this.a.v1(), "3", str, gVar.b.d.a.get(str), this.b.C(), new a(this, i, gVar));
                        return;
                    }
                    ix1.o("SwanApp", "subpackage is invalid");
                }
                this.b.X(i, this.a, gVar);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fl2 a;

        public c(sl2 sl2Var, fl2 fl2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sl2Var, fl2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fl2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ej2.e.c(this.a.H(), this.a.v1());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fl2 a;
        public final /* synthetic */ ej2.g b;
        public final /* synthetic */ sl2 c;

        public d(sl2 sl2Var, fl2 fl2Var, ej2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sl2Var, fl2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = sl2Var;
            this.a = fl2Var;
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
        public final /* synthetic */ fl2 a;

        public e(sl2 sl2Var, fl2 fl2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sl2Var, fl2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fl2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String n = this.a.n("fromHost");
                String n2 = this.a.n("spuId");
                String n3 = this.a.n("contentId");
                if (TextUtils.isEmpty(n) || TextUtils.isEmpty(n2) || TextUtils.isEmpty(n3) || !pj2.s0().a(n, n2, n3)) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755316776, "Lcom/repackage/sl2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755316776, "Lcom/repackage/sl2;");
                return;
            }
        }
        l = sg1.a;
    }

    public sl2() {
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

    @Override // com.repackage.rl2, com.repackage.tl2
    @Nullable
    public i03 D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? i03.M() : (i03) invokeV.objValue;
    }

    @Override // com.repackage.rl2, com.repackage.tl2
    public void E(fl2 fl2Var, cj2 cj2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fl2Var, cj2Var) == null) {
            super.E(fl2Var, cj2Var);
            if (l) {
                Log.d("AppsControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + fl2Var.j0());
            }
            ej2.c(fl2Var, new b(this, fl2Var));
            c72.U().d1(fl2Var);
            c72.U().c1(fl2Var);
            c72.U().H0(null);
        }
    }

    @Override // com.repackage.rl2, com.repackage.tl2
    public SwanCoreVersion M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? c72.U().d0() : (SwanCoreVersion) invokeV.objValue;
    }

    @Override // com.repackage.rl2, com.repackage.tl2
    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.O();
            n62.d();
            c72.N0(false);
            if (this.a != null) {
                this.a = null;
            }
            vc3.j();
            hn2.b();
            yo2.y();
            fb3.u();
            PaymentPanelManager.F();
            ha3.n();
            u93.d();
            qa3.k();
            od2.d();
            lc4.f();
            wq2.e().o();
            y23.h();
            aa3.h();
            vq2.k();
            if (pj2.I() != null) {
                pj2.I().e();
            }
            zq1.e().n();
            rs1.b().f();
            v23.b().k();
            ze2.d();
            ur1.d().h();
            nq2.g().f();
            x62.b();
            bl2.c().a();
            cv2.g().b();
            SwanPrefetchImageRes.b().e();
            h42.g().d();
            iy1.c().n();
            ag3.c().i();
        }
    }

    public final void X(int i, fl2 fl2Var, ej2.g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeILL(1048580, this, i, fl2Var, gVar) == null) || i != 0 || fl2Var == null || gVar == null) {
            return;
        }
        nt2.o().F(new UbcFlowEvent("na_post_to_main_start"));
        ce3.d0(this.k);
        d dVar = new d(this, fl2Var, gVar);
        this.k = dVar;
        ce3.g0(dVar);
    }

    public final void Y(fl2 fl2Var, ej2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, fl2Var, gVar) == null) {
            nt2.o().F(new UbcFlowEvent("na_post_to_main_end"));
            i63.d().i("na_post_to_main_end");
            if (l) {
                Log.d("AppsControllerImpl", "onLoaded loadedInfo: " + gVar);
            }
            if (this.i) {
                if (l) {
                    Log.e("AppsControllerImpl", Log.getStackTraceString(new Exception("object is released. bundlePath:" + gVar.a + ", baseUrl:" + vl2.U().z())));
                    return;
                }
                return;
            }
            this.c = gVar.a;
            a0(gVar.b);
            if (fl2Var.m0()) {
                n(this.d).setVisibility(0);
                fx1.b(true);
                ix1.i("AppsControllerImpl", "init sConsole for devHook");
            }
            ix1.i("AppsControllerImpl", "handleLoadSwanApp: start MiniApp first page.");
            c72.U().Z0(fl2Var, gVar);
        }
    }

    public final void Z(fl2 fl2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, fl2Var) == null) || TextUtils.isEmpty(fl2Var.n("fromHost")) || TextUtils.isEmpty(fl2Var.n("spuId")) || TextUtils.isEmpty(fl2Var.n("contentId"))) {
            return;
        }
        ce3.b0(new e(this, fl2Var), 2000L);
    }

    public final void a0(SwanAppConfigData swanAppConfigData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, swanAppConfigData) == null) {
            h03 K = h03.K();
            if (K.E()) {
                K.q().G0(swanAppConfigData);
            }
        }
    }

    @Override // com.repackage.rl2, com.repackage.tl2
    public void d(fl2 fl2Var, cj2 cj2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fl2Var, cj2Var) == null) {
            super.d(fl2Var, cj2Var);
            if (l) {
                Log.d("AppsControllerImpl", "syncLoadSwanApp swanCoreVersion: " + fl2Var.j0());
            }
            c72.U().d1(fl2Var);
            c72.U().H0(null);
            SwanAppConfigData Q = h03.K().q().Q();
            if (Q != null) {
                ej2.g gVar = new ej2.g();
                bu2.e().d(new c(this, fl2Var), "deleteLowerVersionFolder", true);
                gVar.b = Q;
                gVar.a = ej2.e.i(fl2Var.H(), fl2Var.v1()).getPath() + File.separator;
                nt2.o().F(new UbcFlowEvent("na_post_to_main_start"));
                i63.d().i("na_post_to_main_start");
                Y(fl2Var, gVar);
            }
        }
    }

    @Override // com.repackage.tl2
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            long S = vl2.U().S();
            if (l) {
                Log.i("AppsControllerImpl", "onAppBackground: background alive thread count:" + S);
            }
            return this.h && S <= 0;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.rl2, com.repackage.tl2
    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.v();
            ix1.i("SwanApp", "onAppForeground");
            String g0 = i03.g0();
            if (TextUtils.isEmpty(g0)) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onAppShow");
            hashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, g0);
            hashMap.put("launchId", iu2.b());
            SwanAppActivity swanAppActivity = this.d;
            if (swanAppActivity != null && swanAppActivity.S() != null) {
                hashMap.put("clkid", this.d.S().L());
                hashMap.put("scene", this.d.S().T());
                fl2.a S = this.d.S();
                s63.v(S);
                Z(S);
            }
            u(new ka2(hashMap));
            ix1.i("SwanApp", "onAppShow");
            rs1.b().g(false);
            hn2.h(true);
            yo2.r(false);
            wq2.e().h(false);
            zq1.e().j();
            vq2.i();
            if (pj2.I() != null) {
                pj2.I().a();
            }
            a aVar = new a(this, System.currentTimeMillis());
            if (ju2.h()) {
                bu2.e().d(aVar, "saveSwanAppForeGroundTime", false);
            } else {
                cd3.k(aVar, "saveSwanAppForeGroundTime");
            }
        }
    }

    @Override // com.repackage.rl2, com.repackage.tl2
    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.w();
            ix1.i("SwanApp", "onAppBackground");
            String g0 = i03.g0();
            if (TextUtils.isEmpty(g0)) {
                return;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("lcType", "onAppHide");
            contentValues.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, g0);
            contentValues.put("hiddenType", Integer.valueOf(ke3.b().a()));
            u(new ka2(contentValues));
            ix1.i("SwanApp", "onAppHide");
            ke3.b().d();
            rs1.b().g(true);
            hn2.h(false);
            yo2.r(true);
            wq2.e().h(true);
            vq2.j(false);
            if (pj2.I() != null) {
                pj2.I().c();
            }
            be3.h();
            gq2.i();
        }
    }
}
