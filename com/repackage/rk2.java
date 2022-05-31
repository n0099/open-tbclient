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
import com.repackage.di2;
import com.repackage.ek2;
import com.repackage.w23;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class rk2 extends qk2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean l;
    public transient /* synthetic */ FieldHolder $fh;
    public Runnable k;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;

        public a(rk2 rk2Var, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rk2Var, Long.valueOf(j)};
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
                ad3.g(this.a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements bi2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ek2 a;
        public final /* synthetic */ rk2 b;

        /* loaded from: classes7.dex */
        public class a implements w23.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ di2.g b;
            public final /* synthetic */ b c;

            public a(b bVar, int i, di2.g gVar) {
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

            @Override // com.repackage.w23.e
            public void b(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    hw1.i("SwanApp", "download subpackage success");
                    b bVar = this.c;
                    bVar.b.X(this.a, bVar.a, this.b);
                }
            }

            @Override // com.repackage.w23.e
            public void c(int i, ab3 ab3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, ab3Var) == null) {
                    hw1.o("SwanApp", "download subpackage fail: " + i);
                    this.c.a.R0(null);
                    b bVar = this.c;
                    bVar.b.X(this.a, bVar.a, this.b);
                    ab3 ab3Var2 = new ab3();
                    ab3Var2.k(5L);
                    ab3Var2.i(38L);
                    ab3Var2.f("download subpackage fail, errcode=" + i);
                    i63 i63Var = new i63();
                    i63Var.q(a63.n(this.c.a.G()));
                    i63Var.p(ab3Var2);
                    i63Var.r(this.c.a);
                    a63.R(i63Var);
                }
            }
        }

        public b(rk2 rk2Var, ek2 ek2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rk2Var, ek2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = rk2Var;
            this.a = ek2Var;
        }

        @Override // com.repackage.bi2
        public void a(int i, ai2 ai2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, ai2Var) == null) {
                di2.g gVar = (di2.g) ai2Var;
                if (w23.p(this.a, gVar)) {
                    if (hz2.L() != null && !TextUtils.isEmpty(gVar.a)) {
                        String f = zc3.f(this.a.e0());
                        if (!TextUtils.isEmpty(f) && f.startsWith(File.separator)) {
                            f = f.substring(1);
                        }
                        String str = gVar.b.c.c.get(z23.b(f));
                        w23.m(this.a.H(), this.a.v1(), "3", str, gVar.b.d.a.get(str), this.b.C(), new a(this, i, gVar));
                        return;
                    }
                    hw1.o("SwanApp", "subpackage is invalid");
                }
                this.b.X(i, this.a, gVar);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ek2 a;

        public c(rk2 rk2Var, ek2 ek2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rk2Var, ek2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ek2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                di2.e.c(this.a.H(), this.a.v1());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ek2 a;
        public final /* synthetic */ di2.g b;
        public final /* synthetic */ rk2 c;

        public d(rk2 rk2Var, ek2 ek2Var, di2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rk2Var, ek2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = rk2Var;
            this.a = ek2Var;
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
        public final /* synthetic */ ek2 a;

        public e(rk2 rk2Var, ek2 ek2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rk2Var, ek2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ek2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String n = this.a.n("fromHost");
                String n2 = this.a.n("spuId");
                String n3 = this.a.n("contentId");
                if (TextUtils.isEmpty(n) || TextUtils.isEmpty(n2) || TextUtils.isEmpty(n3) || !oi2.s0().a(n, n2, n3)) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755347528, "Lcom/repackage/rk2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755347528, "Lcom/repackage/rk2;");
                return;
            }
        }
        l = rf1.a;
    }

    public rk2() {
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

    @Override // com.repackage.qk2, com.repackage.sk2
    @Nullable
    public hz2 D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? hz2.L() : (hz2) invokeV.objValue;
    }

    @Override // com.repackage.qk2, com.repackage.sk2
    public void E(ek2 ek2Var, bi2 bi2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ek2Var, bi2Var) == null) {
            super.E(ek2Var, bi2Var);
            if (l) {
                Log.d("AppsControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + ek2Var.j0());
            }
            di2.c(ek2Var, new b(this, ek2Var));
            b62.U().d1(ek2Var);
            b62.U().c1(ek2Var);
            b62.U().H0(null);
        }
    }

    @Override // com.repackage.qk2, com.repackage.sk2
    public SwanCoreVersion M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? b62.U().d0() : (SwanCoreVersion) invokeV.objValue;
    }

    @Override // com.repackage.qk2, com.repackage.sk2
    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.O();
            m52.d();
            b62.N0(false);
            if (this.a != null) {
                this.a = null;
            }
            ub3.j();
            gm2.b();
            xn2.y();
            ea3.u();
            PaymentPanelManager.F();
            g93.n();
            t83.d();
            p93.k();
            nc2.d();
            kb4.f();
            vp2.e().o();
            x13.h();
            z83.h();
            up2.k();
            if (oi2.I() != null) {
                oi2.I().e();
            }
            yp1.e().n();
            qr1.b().f();
            u13.b().k();
            yd2.d();
            tq1.d().h();
            mp2.g().f();
            w52.b();
            ak2.c().a();
            bu2.g().b();
            SwanPrefetchImageRes.b().e();
            g32.g().d();
            hx1.c().n();
            ze3.c().i();
        }
    }

    public final void X(int i, ek2 ek2Var, di2.g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeILL(1048580, this, i, ek2Var, gVar) == null) || i != 0 || ek2Var == null || gVar == null) {
            return;
        }
        ms2.o().F(new UbcFlowEvent("na_post_to_main_start"));
        bd3.d0(this.k);
        d dVar = new d(this, ek2Var, gVar);
        this.k = dVar;
        bd3.g0(dVar);
    }

    public final void Y(ek2 ek2Var, di2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, ek2Var, gVar) == null) {
            ms2.o().F(new UbcFlowEvent("na_post_to_main_end"));
            h53.d().i("na_post_to_main_end");
            if (l) {
                Log.d("AppsControllerImpl", "onLoaded loadedInfo: " + gVar);
            }
            if (this.i) {
                if (l) {
                    Log.e("AppsControllerImpl", Log.getStackTraceString(new Exception("object is released. bundlePath:" + gVar.a + ", baseUrl:" + uk2.U().z())));
                    return;
                }
                return;
            }
            this.c = gVar.a;
            a0(gVar.b);
            if (ek2Var.m0()) {
                n(this.d).setVisibility(0);
                ew1.b(true);
                hw1.i("AppsControllerImpl", "init sConsole for devHook");
            }
            hw1.i("AppsControllerImpl", "handleLoadSwanApp: start MiniApp first page.");
            b62.U().Z0(ek2Var, gVar);
        }
    }

    public final void Z(ek2 ek2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, ek2Var) == null) || TextUtils.isEmpty(ek2Var.n("fromHost")) || TextUtils.isEmpty(ek2Var.n("spuId")) || TextUtils.isEmpty(ek2Var.n("contentId"))) {
            return;
        }
        bd3.b0(new e(this, ek2Var), 2000L);
    }

    public final void a0(SwanAppConfigData swanAppConfigData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, swanAppConfigData) == null) {
            gz2 J = gz2.J();
            if (J.D()) {
                J.r().F0(swanAppConfigData);
            }
        }
    }

    @Override // com.repackage.qk2, com.repackage.sk2
    public void d(ek2 ek2Var, bi2 bi2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ek2Var, bi2Var) == null) {
            super.d(ek2Var, bi2Var);
            if (l) {
                Log.d("AppsControllerImpl", "syncLoadSwanApp swanCoreVersion: " + ek2Var.j0());
            }
            b62.U().d1(ek2Var);
            b62.U().H0(null);
            SwanAppConfigData P = gz2.J().r().P();
            if (P != null) {
                di2.g gVar = new di2.g();
                at2.e().d(new c(this, ek2Var), "deleteLowerVersionFolder", true);
                gVar.b = P;
                gVar.a = di2.e.i(ek2Var.H(), ek2Var.v1()).getPath() + File.separator;
                ms2.o().F(new UbcFlowEvent("na_post_to_main_start"));
                h53.d().i("na_post_to_main_start");
                Y(ek2Var, gVar);
            }
        }
    }

    @Override // com.repackage.sk2
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            long S = uk2.U().S();
            if (l) {
                Log.i("AppsControllerImpl", "onAppBackground: background alive thread count:" + S);
            }
            return this.h && S <= 0;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.qk2, com.repackage.sk2
    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.v();
            hw1.i("SwanApp", "onAppForeground");
            String f0 = hz2.f0();
            if (TextUtils.isEmpty(f0)) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onAppShow");
            hashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, f0);
            hashMap.put("launchId", ht2.b());
            SwanAppActivity swanAppActivity = this.d;
            if (swanAppActivity != null && swanAppActivity.getLaunchInfo() != null) {
                hashMap.put("clkid", this.d.getLaunchInfo().L());
                hashMap.put("scene", this.d.getLaunchInfo().T());
                ek2.a launchInfo = this.d.getLaunchInfo();
                r53.v(launchInfo);
                Z(launchInfo);
            }
            u(new j92(hashMap));
            hw1.i("SwanApp", "onAppShow");
            qr1.b().g(false);
            gm2.h(true);
            xn2.r(false);
            vp2.e().h(false);
            yp1.e().j();
            up2.i();
            if (oi2.I() != null) {
                oi2.I().a();
            }
            a aVar = new a(this, System.currentTimeMillis());
            if (it2.h()) {
                at2.e().d(aVar, "saveSwanAppForeGroundTime", false);
            } else {
                bc3.k(aVar, "saveSwanAppForeGroundTime");
            }
        }
    }

    @Override // com.repackage.qk2, com.repackage.sk2
    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.w();
            hw1.i("SwanApp", "onAppBackground");
            String f0 = hz2.f0();
            if (TextUtils.isEmpty(f0)) {
                return;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("lcType", "onAppHide");
            contentValues.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, f0);
            contentValues.put("hiddenType", Integer.valueOf(jd3.b().a()));
            u(new j92(contentValues));
            hw1.i("SwanApp", "onAppHide");
            jd3.b().d();
            qr1.b().g(true);
            gm2.h(false);
            xn2.r(true);
            vp2.e().h(true);
            up2.j(false);
            if (oi2.I() != null) {
                oi2.I().c();
            }
            ad3.h();
            fp2.i();
        }
    }
}
