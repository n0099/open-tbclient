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
import com.repackage.fj2;
import com.repackage.gl2;
import com.repackage.y33;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class tl2 extends sl2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean l;
    public transient /* synthetic */ FieldHolder $fh;
    public Runnable k;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;

        public a(tl2 tl2Var, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tl2Var, Long.valueOf(j)};
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
                ce3.g(this.a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements dj2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gl2 a;
        public final /* synthetic */ tl2 b;

        /* loaded from: classes7.dex */
        public class a implements y33.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ fj2.g b;
            public final /* synthetic */ b c;

            public a(b bVar, int i, fj2.g gVar) {
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

            @Override // com.repackage.y33.e
            public void b(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    jx1.i("SwanApp", "download subpackage success");
                    b bVar = this.c;
                    bVar.b.X(this.a, bVar.a, this.b);
                }
            }

            @Override // com.repackage.y33.e
            public void c(int i, cc3 cc3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, cc3Var) == null) {
                    jx1.o("SwanApp", "download subpackage fail: " + i);
                    this.c.a.R0(null);
                    b bVar = this.c;
                    bVar.b.X(this.a, bVar.a, this.b);
                    cc3 cc3Var2 = new cc3();
                    cc3Var2.k(5L);
                    cc3Var2.i(38L);
                    cc3Var2.f("download subpackage fail, errcode=" + i);
                    k73 k73Var = new k73();
                    k73Var.q(c73.n(this.c.a.G()));
                    k73Var.p(cc3Var2);
                    k73Var.r(this.c.a);
                    c73.R(k73Var);
                }
            }
        }

        public b(tl2 tl2Var, gl2 gl2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tl2Var, gl2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = tl2Var;
            this.a = gl2Var;
        }

        @Override // com.repackage.dj2
        public void a(int i, cj2 cj2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, cj2Var) == null) {
                fj2.g gVar = (fj2.g) cj2Var;
                if (y33.p(this.a, gVar)) {
                    if (j03.L() != null && !TextUtils.isEmpty(gVar.a)) {
                        String f = be3.f(this.a.e0());
                        if (!TextUtils.isEmpty(f) && f.startsWith(File.separator)) {
                            f = f.substring(1);
                        }
                        String str = gVar.b.c.c.get(b43.b(f));
                        y33.m(this.a.H(), this.a.v1(), "3", str, gVar.b.d.a.get(str), this.b.C(), new a(this, i, gVar));
                        return;
                    }
                    jx1.o("SwanApp", "subpackage is invalid");
                }
                this.b.X(i, this.a, gVar);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gl2 a;

        public c(tl2 tl2Var, gl2 gl2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tl2Var, gl2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gl2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                fj2.e.c(this.a.H(), this.a.v1());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gl2 a;
        public final /* synthetic */ fj2.g b;
        public final /* synthetic */ tl2 c;

        public d(tl2 tl2Var, gl2 gl2Var, fj2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tl2Var, gl2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = tl2Var;
            this.a = gl2Var;
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
        public final /* synthetic */ gl2 a;

        public e(tl2 tl2Var, gl2 gl2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tl2Var, gl2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gl2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String n = this.a.n("fromHost");
                String n2 = this.a.n("spuId");
                String n3 = this.a.n("contentId");
                if (TextUtils.isEmpty(n) || TextUtils.isEmpty(n2) || TextUtils.isEmpty(n3) || !qj2.s0().a(n, n2, n3)) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755286985, "Lcom/repackage/tl2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755286985, "Lcom/repackage/tl2;");
                return;
            }
        }
        l = tg1.a;
    }

    public tl2() {
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

    @Override // com.repackage.sl2, com.repackage.ul2
    @Nullable
    public j03 D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? j03.L() : (j03) invokeV.objValue;
    }

    @Override // com.repackage.sl2, com.repackage.ul2
    public void E(gl2 gl2Var, dj2 dj2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gl2Var, dj2Var) == null) {
            super.E(gl2Var, dj2Var);
            if (l) {
                Log.d("AppsControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + gl2Var.j0());
            }
            fj2.c(gl2Var, new b(this, gl2Var));
            d72.U().d1(gl2Var);
            d72.U().c1(gl2Var);
            d72.U().H0(null);
        }
    }

    @Override // com.repackage.sl2, com.repackage.ul2
    public SwanCoreVersion M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? d72.U().d0() : (SwanCoreVersion) invokeV.objValue;
    }

    @Override // com.repackage.sl2, com.repackage.ul2
    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.O();
            o62.d();
            d72.N0(false);
            if (this.a != null) {
                this.a = null;
            }
            wc3.j();
            in2.b();
            zo2.y();
            gb3.u();
            PaymentPanelManager.F();
            ia3.n();
            v93.d();
            ra3.k();
            pd2.d();
            mc4.f();
            xq2.e().o();
            z23.h();
            ba3.h();
            wq2.k();
            if (qj2.I() != null) {
                qj2.I().e();
            }
            ar1.e().n();
            ss1.b().f();
            w23.b().k();
            af2.d();
            vr1.d().h();
            oq2.g().f();
            y62.b();
            cl2.c().a();
            dv2.g().b();
            SwanPrefetchImageRes.b().e();
            i42.g().d();
            jy1.c().n();
            bg3.c().i();
        }
    }

    public final void X(int i, gl2 gl2Var, fj2.g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeILL(1048580, this, i, gl2Var, gVar) == null) || i != 0 || gl2Var == null || gVar == null) {
            return;
        }
        ot2.o().F(new UbcFlowEvent("na_post_to_main_start"));
        de3.d0(this.k);
        d dVar = new d(this, gl2Var, gVar);
        this.k = dVar;
        de3.g0(dVar);
    }

    public final void Y(gl2 gl2Var, fj2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, gl2Var, gVar) == null) {
            ot2.o().F(new UbcFlowEvent("na_post_to_main_end"));
            j63.d().i("na_post_to_main_end");
            if (l) {
                Log.d("AppsControllerImpl", "onLoaded loadedInfo: " + gVar);
            }
            if (this.i) {
                if (l) {
                    Log.e("AppsControllerImpl", Log.getStackTraceString(new Exception("object is released. bundlePath:" + gVar.a + ", baseUrl:" + wl2.U().z())));
                    return;
                }
                return;
            }
            this.c = gVar.a;
            a0(gVar.b);
            if (gl2Var.m0()) {
                n(this.d).setVisibility(0);
                gx1.b(true);
                jx1.i("AppsControllerImpl", "init sConsole for devHook");
            }
            jx1.i("AppsControllerImpl", "handleLoadSwanApp: start MiniApp first page.");
            d72.U().Z0(gl2Var, gVar);
        }
    }

    public final void Z(gl2 gl2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, gl2Var) == null) || TextUtils.isEmpty(gl2Var.n("fromHost")) || TextUtils.isEmpty(gl2Var.n("spuId")) || TextUtils.isEmpty(gl2Var.n("contentId"))) {
            return;
        }
        de3.b0(new e(this, gl2Var), 2000L);
    }

    public final void a0(SwanAppConfigData swanAppConfigData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, swanAppConfigData) == null) {
            i03 J = i03.J();
            if (J.D()) {
                J.r().F0(swanAppConfigData);
            }
        }
    }

    @Override // com.repackage.sl2, com.repackage.ul2
    public void d(gl2 gl2Var, dj2 dj2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, gl2Var, dj2Var) == null) {
            super.d(gl2Var, dj2Var);
            if (l) {
                Log.d("AppsControllerImpl", "syncLoadSwanApp swanCoreVersion: " + gl2Var.j0());
            }
            d72.U().d1(gl2Var);
            d72.U().H0(null);
            SwanAppConfigData P = i03.J().r().P();
            if (P != null) {
                fj2.g gVar = new fj2.g();
                cu2.e().d(new c(this, gl2Var), "deleteLowerVersionFolder", true);
                gVar.b = P;
                gVar.a = fj2.e.i(gl2Var.H(), gl2Var.v1()).getPath() + File.separator;
                ot2.o().F(new UbcFlowEvent("na_post_to_main_start"));
                j63.d().i("na_post_to_main_start");
                Y(gl2Var, gVar);
            }
        }
    }

    @Override // com.repackage.ul2
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            long S = wl2.U().S();
            if (l) {
                Log.i("AppsControllerImpl", "onAppBackground: background alive thread count:" + S);
            }
            return this.h && S <= 0;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.sl2, com.repackage.ul2
    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.v();
            jx1.i("SwanApp", "onAppForeground");
            String f0 = j03.f0();
            if (TextUtils.isEmpty(f0)) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onAppShow");
            hashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, f0);
            hashMap.put("launchId", ju2.b());
            SwanAppActivity swanAppActivity = this.d;
            if (swanAppActivity != null && swanAppActivity.getLaunchInfo() != null) {
                hashMap.put("clkid", this.d.getLaunchInfo().L());
                hashMap.put("scene", this.d.getLaunchInfo().T());
                gl2.a launchInfo = this.d.getLaunchInfo();
                t63.v(launchInfo);
                Z(launchInfo);
            }
            u(new la2(hashMap));
            jx1.i("SwanApp", "onAppShow");
            ss1.b().g(false);
            in2.h(true);
            zo2.r(false);
            xq2.e().h(false);
            ar1.e().j();
            wq2.i();
            if (qj2.I() != null) {
                qj2.I().a();
            }
            a aVar = new a(this, System.currentTimeMillis());
            if (ku2.h()) {
                cu2.e().d(aVar, "saveSwanAppForeGroundTime", false);
            } else {
                dd3.k(aVar, "saveSwanAppForeGroundTime");
            }
        }
    }

    @Override // com.repackage.sl2, com.repackage.ul2
    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.w();
            jx1.i("SwanApp", "onAppBackground");
            String f0 = j03.f0();
            if (TextUtils.isEmpty(f0)) {
                return;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("lcType", "onAppHide");
            contentValues.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, f0);
            contentValues.put("hiddenType", Integer.valueOf(le3.b().a()));
            u(new la2(contentValues));
            jx1.i("SwanApp", "onAppHide");
            le3.b().d();
            ss1.b().g(true);
            in2.h(false);
            zo2.r(true);
            xq2.e().h(true);
            wq2.j(false);
            if (qj2.I() != null) {
                qj2.I().c();
            }
            ce3.h();
            hq2.i();
        }
    }
}
