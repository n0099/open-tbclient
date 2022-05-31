package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.abtest.UsbAbTestConst;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.switchs.AdToMainTabActivitySwitch;
import com.baidu.tieba.advert.sdk.data.AdLoadState;
import com.baidu.tieba.advert.sdk.stretagy.SplashNativePolicy;
import com.baidu.tieba.tblauncher.MainTabScheduleStrategy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubc.UBCManager;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class gk5 {
    public static /* synthetic */ Interceptable $ic;
    public static gk5 i;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public boolean c;
    public boolean d;
    public long e;
    public SplashNativePolicy f;
    public ok4 g;
    public final ArrayList<hk5> h;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ok4 a;
        public final /* synthetic */ hk5 b;
        public final /* synthetic */ gk5 c;

        public a(gk5 gk5Var, ok4 ok4Var, hk5 hk5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gk5Var, ok4Var, hk5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = gk5Var;
            this.a = ok4Var;
            this.b = hk5Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a != null) {
                    hk5 hk5Var = this.b;
                    this.a.b(hk5Var instanceof sj5 ? ((sj5) hk5Var).k : null);
                }
                this.b.show();
                ok4 ok4Var = this.a;
                if (ok4Var != null) {
                    ok4Var.d(String.valueOf((int) this.c.f(this.b)));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(gk5 gk5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gk5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                kp6.j().m();
            }
        }
    }

    public gk5() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = false;
        this.e = -1L;
        this.g = null;
        this.h = new ArrayList<>();
        this.a = ys4.k().l("splash_ad_strategy_key", 0);
        this.b = ys4.k().l("splash_origin_ad_strategy_key", 1);
        q();
    }

    public static gk5 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (i == null) {
                synchronized (gk5.class) {
                    if (i == null) {
                        i = new gk5();
                    }
                }
            }
            return i;
        }
        return (gk5) invokeV.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Iterator<hk5> it = this.h.iterator();
            while (it.hasNext()) {
                hk5 next = it.next();
                if (next != null) {
                    next.destroy();
                }
            }
            this.h.clear();
            SplashNativePolicy splashNativePolicy = this.f;
            if (splashNativePolicy != null) {
                splashNativePolicy.releaseSplash();
                this.f = null;
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Iterator<hk5> it = this.h.iterator();
            while (it.hasNext()) {
                hk5 next = it.next();
                if (next instanceof rj5) {
                    StatisticItem statisticItem = new StatisticItem("fail_splash");
                    statisticItem.param("obj_param1", ((rj5) next).s() ? "1" : "0");
                    TiebaStatic.log(statisticItem);
                }
            }
            ok4 ok4Var = this.g;
            if (ok4Var != null) {
                ok4Var.c("");
            }
        }
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a : invokeV.intValue;
    }

    public final byte f(hk5 hk5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, hk5Var)) == null) {
            if (hk5Var == null) {
                return (byte) 0;
            }
            String f = hk5Var.f();
            char c = 65535;
            int hashCode = f.hashCode();
            if (hashCode != -1348168235) {
                if (hashCode == 3019700 && f.equals("bear")) {
                    c = 0;
                }
            } else if (f.equals("prologue_gd")) {
                c = 1;
            }
            if (c != 0) {
                return c != 1 ? (byte) 0 : (byte) 5;
            }
            return (byte) 6;
        }
        return invokeL.byteValue;
    }

    public final synchronized void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this) {
                if (this.h.isEmpty()) {
                    sj5 sj5Var = new sj5(this.f);
                    rj5 rj5Var = new rj5(this.f);
                    this.h.clear();
                    if (UbsABTestHelper.newSplashStrategy()) {
                        if (fb5.w()) {
                            this.h.add(sj5Var);
                        }
                    } else if (this.b != 0) {
                        this.h.add(sj5Var);
                    }
                    if (fb5.q(this.a)) {
                        this.h.add(rj5Var);
                    }
                    if (ys4.k().h("key_is_jump_splash_ad", false)) {
                        j();
                        this.h.clear();
                    }
                }
            }
        }
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? fb5.q(this.a) : invokeV.booleanValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            Iterator<hk5> it = this.h.iterator();
            while (it.hasNext()) {
                hk5 next = it.next();
                if (next != null && next.b()) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void j() {
        UBCManager uBCManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)) == null) {
            return;
        }
        uBCManager.onEvent("5088");
    }

    public void k(int i2) {
        ok4 ok4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) || (ok4Var = this.g) == null) {
            return;
        }
        ok4Var.a(i2);
    }

    public void l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.c = false;
            g();
            Iterator<hk5> it = this.h.iterator();
            while (it.hasNext()) {
                hk5 next = it.next();
                if (i2 == 5 && (next instanceof sj5)) {
                    next.a();
                    return;
                } else if (i2 == 6 && (next instanceof rj5)) {
                    Iterator<hk5> it2 = this.h.iterator();
                    while (it2.hasNext()) {
                        hk5 next2 = it2.next();
                        if (next2 instanceof sj5) {
                            StatisticItem statisticItem = new StatisticItem("preload_bear");
                            sj5 sj5Var = (sj5) next2;
                            statisticItem.param("obj_param1", sj5Var.v() ? "1" : "0");
                            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, sj5Var.w() ? "1" : "0");
                            TiebaStatic.log(statisticItem);
                        }
                    }
                    next.a();
                    return;
                }
            }
        }
    }

    public synchronized void m(rk4 rk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, rk4Var) == null) {
            synchronized (this) {
                this.c = false;
                this.e = rk4Var.c();
                this.g = rk4Var.a();
                this.d = rk4Var.d();
                if (this.f != null) {
                    this.f.onSplashEvent(96);
                }
                g();
                lk5.c();
                Iterator<hk5> it = this.h.iterator();
                while (it.hasNext()) {
                    it.next().e(rk4Var);
                }
            }
        }
    }

    public void n(ok4 ok4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, ok4Var) == null) || UbsABTestHelper.newSplashStrategy()) {
            return;
        }
        o(ok4Var, true);
    }

    public synchronized void o(ok4 ok4Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLZ(1048588, this, ok4Var, z) != null) {
            return;
        }
        synchronized (this) {
            if (this.c) {
                return;
            }
            Iterator<hk5> it = this.h.iterator();
            while (true) {
                if (!it.hasNext()) {
                    if (!z) {
                        StatisticItem.make(TbadkCoreStatisticKey.HOT_SPLASH_TIMEOUT).param("obj_type", "a064").param(TiebaStatic.Params.BEAR_CONFIG, fb5.q(this.a) ? 1 : 0).param(TiebaStatic.Params.PLG_CONFIG, this.b != 0 ? 1 : 0).param(TiebaStatic.Params.OBJ_DURATION, System.currentTimeMillis()).param(TiebaStatic.Params.SPLASH_UNI, this.e).eventStat();
                    }
                    if (ok4Var != null) {
                        ok4Var.c("");
                    }
                    return;
                }
                hk5 next = it.next();
                if (next != null) {
                    if (next.d() == AdLoadState.SUCCEED) {
                        this.c = true;
                        StatisticItem param = StatisticItem.make(TbadkCoreStatisticKey.SHOW_AD_TIME).param("obj_source", (int) f(next)).param("obj_type", "a064").param(TiebaStatic.Params.OBJ_DURATION, System.currentTimeMillis()).param(TiebaStatic.Params.OBJ_PARAM2, this.d ? 2 : 1).param(TiebaStatic.Params.SPLASH_UNI, this.e);
                        if (!StringUtils.isNull(next.c())) {
                            param.param(TiebaStatic.Params.OBJ_TO, next.c());
                        }
                        param.eventStat();
                        if (AdToMainTabActivitySwitch.getIsOn()) {
                            pj8.a(MainTabScheduleStrategy.UNSCHEDULE);
                            mg.a().post(new a(this, ok4Var, next));
                        } else {
                            if (ok4Var != null) {
                                ok4Var.b(next instanceof sj5 ? ((sj5) next).k : null);
                            }
                            next.show();
                            if (ok4Var != null) {
                                ok4Var.d(String.valueOf((int) f(next)));
                            }
                        }
                        ns4.a("homePage", -1L, 0, "logo_splash", 0, "", "splashType", ki.isEmpty(next.f()) ? "bes" : next.f());
                        return;
                    } else if (next.d() != AdLoadState.FAILED && z) {
                        return;
                    }
                }
            }
        }
    }

    public synchronized void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            synchronized (this) {
                if (this.c) {
                    return;
                }
                Iterator<hk5> it = this.h.iterator();
                while (it.hasNext()) {
                    hk5 next = it.next();
                    if (next != null) {
                        if ((z ? next instanceof rj5 : next instanceof sj5) && next.d() == AdLoadState.SUCCEED) {
                            this.c = true;
                            StatisticItem param = StatisticItem.make(TbadkCoreStatisticKey.SHOW_AD_TIME).param("obj_source", (int) f(next)).param("obj_type", "a064").param(TiebaStatic.Params.OBJ_DURATION, System.currentTimeMillis()).param(TiebaStatic.Params.OBJ_PARAM2, this.d ? 2 : 1).param(TiebaStatic.Params.SPLASH_UNI, this.e);
                            if (!StringUtils.isNull(next.c())) {
                                param.param(TiebaStatic.Params.OBJ_TO, next.c());
                            }
                            param.eventStat();
                            if (AdToMainTabActivitySwitch.getIsOn()) {
                                pj8.a(MainTabScheduleStrategy.UNSCHEDULE);
                            }
                            if (this.g != null) {
                                this.g.b(next instanceof sj5 ? ((sj5) next).k : null);
                            }
                            next.show();
                            if (this.g != null) {
                                this.g.d(String.valueOf((int) f(next)));
                            }
                            lk5.d(String.valueOf((int) f(next)));
                            return;
                        }
                    }
                }
                if (this.g != null) {
                    this.g.c("");
                }
            }
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            if (UbsABTestHelper.newSplashStrategy()) {
                SplashNativePolicy splashNativePolicy = this.f;
                if (splashNativePolicy == null) {
                    SplashNativePolicy splashNativePolicy2 = new SplashNativePolicy();
                    this.f = splashNativePolicy2;
                    boolean initSplashPolicy = splashNativePolicy2.initSplashPolicy(fb5.u(), fb5.w(), fb5.v(), fb5.k(), fb5.l());
                    PrintStream printStream = System.out;
                    printStream.println("SplashPolicy init result = " + initSplashPolicy);
                    if (initSplashPolicy) {
                        return;
                    }
                    this.f = null;
                    return;
                }
                boolean updateSplashConfig = splashNativePolicy.updateSplashConfig(fb5.u(), fb5.w(), fb5.v(), fb5.k(), fb5.l());
                PrintStream printStream2 = System.out;
                printStream2.println("SplashPolicy update result = " + updateSplashConfig);
                if (updateSplashConfig) {
                    return;
                }
                this.f = null;
                return;
            }
            SplashNativePolicy splashNativePolicy3 = this.f;
            if (splashNativePolicy3 != null) {
                splashNativePolicy3.releaseSplash();
            }
            this.f = null;
        }
    }

    public void r(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, jSONObject) == null) {
            int e = jg.e(jSONObject.optString("ad_sdk_priority"), 0);
            int e2 = jg.e(jSONObject.optString("ad_origin_config_switch"), 1);
            int e3 = jg.e(jSONObject.optString("bear_sid_type"), 0);
            int e4 = jg.e(jSONObject.optString(UsbAbTestConst.KEY_NEW_SPLASH_POLICY, "0"), 0);
            JSONObject optJSONObject = jSONObject.optJSONObject("screen_fill_data_result");
            if (optJSONObject != null) {
                int e5 = jg.e(optJSONObject.optString("screen_fill_advertisement_first_switch", com.tencent.connect.common.Constants.DEFAULT_UIN), 1000);
                int e6 = jg.e(optJSONObject.optString("screen_fill_advertisement_second_switch", "1400"), 1400);
                int e7 = jg.e(optJSONObject.optString("screen_fill_advertisement_bear_switch", "1"), 1);
                int e8 = jg.e(optJSONObject.optString("screen_fill_advertisement_plj_switch", "1"), 1);
                int e9 = jg.e(optJSONObject.optString("screen_fill_advertisement_plj_cpc_switch", "1"), 1);
                ys4.k().w("key_splash_new_policy_bear_enable", e7);
                ys4.k().w("key_splash_new_policy_plg_enable", e8);
                ys4.k().w("key_splash_new_policy_plg_cpc_enable", e9);
                ys4.k().w("key_splash_new_policy_first_timeout", e5);
                ys4.k().w("key_splash_new_policy_second_timeout", e6);
            }
            rj5.t(e3);
            ys4.k().w("splash_ad_strategy_key", e);
            ys4.k().w("splash_origin_ad_strategy_key", e2);
            ys4.k().w("key_splash_new_policy_enable", e4);
            if (!h() && fb5.q(e)) {
                if (li.C()) {
                    kp6.j().m();
                } else {
                    mg.a().post(new b(this));
                }
            }
            this.a = e;
            this.b = e2;
        }
    }
}
