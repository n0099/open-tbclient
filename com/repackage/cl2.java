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
import com.repackage.h33;
import com.repackage.oi2;
import com.repackage.pk2;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class cl2 extends bl2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean l;
    public transient /* synthetic */ FieldHolder $fh;
    public Runnable k;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;

        public a(cl2 cl2Var, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cl2Var, Long.valueOf(j)};
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
                ld3.g(this.a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements mi2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pk2 a;
        public final /* synthetic */ cl2 b;

        /* loaded from: classes5.dex */
        public class a implements h33.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ oi2.g b;
            public final /* synthetic */ b c;

            public a(b bVar, int i, oi2.g gVar) {
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

            @Override // com.repackage.h33.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    sw1.i("SwanApp", "download subpackage success");
                    b bVar = this.c;
                    bVar.b.X(this.a, bVar.a, this.b);
                }
            }

            @Override // com.repackage.h33.e
            public void b(int i, lb3 lb3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, lb3Var) == null) {
                    sw1.o("SwanApp", "download subpackage fail: " + i);
                    this.c.a.R0(null);
                    b bVar = this.c;
                    bVar.b.X(this.a, bVar.a, this.b);
                    lb3 lb3Var2 = new lb3();
                    lb3Var2.k(5L);
                    lb3Var2.i(38L);
                    lb3Var2.f("download subpackage fail, errcode=" + i);
                    t63 t63Var = new t63();
                    t63Var.q(l63.n(this.c.a.G()));
                    t63Var.p(lb3Var2);
                    t63Var.r(this.c.a);
                    l63.R(t63Var);
                }
            }
        }

        public b(cl2 cl2Var, pk2 pk2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cl2Var, pk2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = cl2Var;
            this.a = pk2Var;
        }

        @Override // com.repackage.mi2
        public void a(int i, li2 li2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, li2Var) == null) {
                oi2.g gVar = (oi2.g) li2Var;
                if (h33.p(this.a, gVar)) {
                    if (sz2.M() != null && !TextUtils.isEmpty(gVar.a)) {
                        String f = kd3.f(this.a.e0());
                        if (!TextUtils.isEmpty(f) && f.startsWith(File.separator)) {
                            f = f.substring(1);
                        }
                        String str = gVar.b.c.c.get(k33.b(f));
                        h33.m(this.a.H(), this.a.v1(), "3", str, gVar.b.d.a.get(str), this.b.C(), new a(this, i, gVar));
                        return;
                    }
                    sw1.o("SwanApp", "subpackage is invalid");
                }
                this.b.X(i, this.a, gVar);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pk2 a;

        public c(cl2 cl2Var, pk2 pk2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cl2Var, pk2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pk2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                oi2.e.c(this.a.H(), this.a.v1());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pk2 a;
        public final /* synthetic */ oi2.g b;
        public final /* synthetic */ cl2 c;

        public d(cl2 cl2Var, pk2 pk2Var, oi2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cl2Var, pk2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = cl2Var;
            this.a = pk2Var;
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

    /* loaded from: classes5.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pk2 a;

        public e(cl2 cl2Var, pk2 pk2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cl2Var, pk2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pk2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String n = this.a.n("fromHost");
                String n2 = this.a.n("spuId");
                String n3 = this.a.n("contentId");
                if (TextUtils.isEmpty(n) || TextUtils.isEmpty(n2) || TextUtils.isEmpty(n3) || !zi2.s0().a(n, n2, n3)) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755793432, "Lcom/repackage/cl2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755793432, "Lcom/repackage/cl2;");
                return;
            }
        }
        l = cg1.a;
    }

    public cl2() {
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

    @Override // com.repackage.bl2, com.repackage.dl2
    @Nullable
    public sz2 D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? sz2.M() : (sz2) invokeV.objValue;
    }

    @Override // com.repackage.bl2, com.repackage.dl2
    public void E(pk2 pk2Var, mi2 mi2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pk2Var, mi2Var) == null) {
            super.E(pk2Var, mi2Var);
            if (l) {
                Log.d("AppsControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + pk2Var.j0());
            }
            oi2.c(pk2Var, new b(this, pk2Var));
            m62.U().d1(pk2Var);
            m62.U().c1(pk2Var);
            m62.U().H0(null);
        }
    }

    @Override // com.repackage.bl2, com.repackage.dl2
    public SwanCoreVersion M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? m62.U().d0() : (SwanCoreVersion) invokeV.objValue;
    }

    @Override // com.repackage.bl2, com.repackage.dl2
    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.O();
            x52.d();
            m62.N0(false);
            if (this.a != null) {
                this.a = null;
            }
            fc3.j();
            rm2.b();
            io2.y();
            pa3.u();
            PaymentPanelManager.F();
            r93.n();
            e93.d();
            aa3.k();
            yc2.d();
            vb4.f();
            gq2.e().o();
            i23.h();
            k93.h();
            fq2.k();
            if (zi2.I() != null) {
                zi2.I().e();
            }
            jq1.e().n();
            bs1.b().f();
            f23.b().k();
            je2.d();
            er1.d().h();
            xp2.g().f();
            h62.b();
            lk2.c().a();
            mu2.g().b();
            SwanPrefetchImageRes.b().e();
            r32.g().d();
            sx1.c().n();
            kf3.c().i();
        }
    }

    public final void X(int i, pk2 pk2Var, oi2.g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeILL(1048580, this, i, pk2Var, gVar) == null) || i != 0 || pk2Var == null || gVar == null) {
            return;
        }
        xs2.o().F(new UbcFlowEvent("na_post_to_main_start"));
        md3.d0(this.k);
        d dVar = new d(this, pk2Var, gVar);
        this.k = dVar;
        md3.g0(dVar);
    }

    public final void Y(pk2 pk2Var, oi2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, pk2Var, gVar) == null) {
            xs2.o().F(new UbcFlowEvent("na_post_to_main_end"));
            s53.d().i("na_post_to_main_end");
            if (l) {
                Log.d("AppsControllerImpl", "onLoaded loadedInfo: " + gVar);
            }
            if (this.i) {
                if (l) {
                    Log.e("AppsControllerImpl", Log.getStackTraceString(new Exception("object is released. bundlePath:" + gVar.a + ", baseUrl:" + fl2.U().z())));
                    return;
                }
                return;
            }
            this.c = gVar.a;
            a0(gVar.b);
            if (pk2Var.m0()) {
                n(this.d).setVisibility(0);
                pw1.b(true);
                sw1.i("AppsControllerImpl", "init sConsole for devHook");
            }
            sw1.i("AppsControllerImpl", "handleLoadSwanApp: start MiniApp first page.");
            m62.U().Z0(pk2Var, gVar);
        }
    }

    public final void Z(pk2 pk2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, pk2Var) == null) || TextUtils.isEmpty(pk2Var.n("fromHost")) || TextUtils.isEmpty(pk2Var.n("spuId")) || TextUtils.isEmpty(pk2Var.n("contentId"))) {
            return;
        }
        md3.b0(new e(this, pk2Var), 2000L);
    }

    public final void a0(SwanAppConfigData swanAppConfigData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, swanAppConfigData) == null) {
            rz2 K = rz2.K();
            if (K.E()) {
                K.r().G0(swanAppConfigData);
            }
        }
    }

    @Override // com.repackage.bl2, com.repackage.dl2
    public void d(pk2 pk2Var, mi2 mi2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, pk2Var, mi2Var) == null) {
            super.d(pk2Var, mi2Var);
            if (l) {
                Log.d("AppsControllerImpl", "syncLoadSwanApp swanCoreVersion: " + pk2Var.j0());
            }
            m62.U().d1(pk2Var);
            m62.U().H0(null);
            SwanAppConfigData Q = rz2.K().r().Q();
            if (Q != null) {
                oi2.g gVar = new oi2.g();
                lt2.e().d(new c(this, pk2Var), "deleteLowerVersionFolder", true);
                gVar.b = Q;
                gVar.a = oi2.e.i(pk2Var.H(), pk2Var.v1()).getPath() + File.separator;
                xs2.o().F(new UbcFlowEvent("na_post_to_main_start"));
                s53.d().i("na_post_to_main_start");
                Y(pk2Var, gVar);
            }
        }
    }

    @Override // com.repackage.dl2
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            long S = fl2.U().S();
            if (l) {
                Log.i("AppsControllerImpl", "onAppBackground: background alive thread count:" + S);
            }
            return this.h && S <= 0;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.bl2, com.repackage.dl2
    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.v();
            sw1.i("SwanApp", "onAppForeground");
            String g0 = sz2.g0();
            if (TextUtils.isEmpty(g0)) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onAppShow");
            hashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, g0);
            hashMap.put("launchId", st2.b());
            SwanAppActivity swanAppActivity = this.d;
            if (swanAppActivity != null && swanAppActivity.S() != null) {
                hashMap.put("clkid", this.d.S().L());
                hashMap.put("scene", this.d.S().T());
                pk2.a S = this.d.S();
                c63.v(S);
                Z(S);
            }
            u(new u92(hashMap));
            sw1.i("SwanApp", "onAppShow");
            bs1.b().g(false);
            rm2.h(true);
            io2.r(false);
            gq2.e().h(false);
            jq1.e().j();
            fq2.i();
            if (zi2.I() != null) {
                zi2.I().a();
            }
            a aVar = new a(this, System.currentTimeMillis());
            if (tt2.h()) {
                lt2.e().d(aVar, "saveSwanAppForeGroundTime", false);
            } else {
                mc3.k(aVar, "saveSwanAppForeGroundTime");
            }
        }
    }

    @Override // com.repackage.bl2, com.repackage.dl2
    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.w();
            sw1.i("SwanApp", "onAppBackground");
            String g0 = sz2.g0();
            if (TextUtils.isEmpty(g0)) {
                return;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("lcType", "onAppHide");
            contentValues.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, g0);
            contentValues.put("hiddenType", Integer.valueOf(ud3.b().a()));
            u(new u92(contentValues));
            sw1.i("SwanApp", "onAppHide");
            ud3.b().d();
            bs1.b().g(true);
            rm2.h(false);
            io2.r(true);
            gq2.e().h(true);
            fq2.j(false);
            if (zi2.I() != null) {
                zi2.I().c();
            }
            ld3.h();
            qp2.i();
        }
    }
}
