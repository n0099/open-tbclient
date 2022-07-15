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
import com.baidu.tbadk.switchs.BearTimeoutTryShowSwitch;
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
public class gm5 {
    public static /* synthetic */ Interceptable $ic;
    public static gm5 i;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public boolean c;
    public boolean d;
    public long e;
    public SplashNativePolicy f;
    public nl4 g;
    public final ArrayList<hm5> h;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nl4 a;
        public final /* synthetic */ hm5 b;
        public final /* synthetic */ gm5 c;

        public a(gm5 gm5Var, nl4 nl4Var, hm5 hm5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gm5Var, nl4Var, hm5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = gm5Var;
            this.a = nl4Var;
            this.b = hm5Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a != null) {
                    hm5 hm5Var = this.b;
                    this.a.c(hm5Var instanceof sl5 ? ((sl5) hm5Var).k : null);
                }
                this.b.show();
                nl4 nl4Var = this.a;
                if (nl4Var != null) {
                    nl4Var.d(String.valueOf((int) this.c.f(this.b)));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(gm5 gm5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gm5Var};
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
                zq6.m().u();
            }
        }
    }

    public gm5() {
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
        this.a = xt4.k().l("splash_ad_strategy_key", 0);
        this.b = xt4.k().l("splash_origin_ad_strategy_key", 1);
        q();
    }

    public static gm5 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (i == null) {
                synchronized (gm5.class) {
                    if (i == null) {
                        i = new gm5();
                    }
                }
            }
            return i;
        }
        return (gm5) invokeV.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Iterator<hm5> it = this.h.iterator();
            while (it.hasNext()) {
                hm5 next = it.next();
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
            Iterator<hm5> it = this.h.iterator();
            while (it.hasNext()) {
                hm5 next = it.next();
                if (next instanceof rl5) {
                    rl5 rl5Var = (rl5) next;
                    boolean u = rl5Var.u();
                    if (u && BearTimeoutTryShowSwitch.isOn()) {
                        StatisticItem param = StatisticItem.make(TbadkCoreStatisticKey.SHOW_AD_TIME).param("obj_source", (int) f(next)).param("obj_type", "a064").param(TiebaStatic.Params.OBJ_DURATION, System.currentTimeMillis()).param("obj_param1", 1).param(TiebaStatic.Params.OBJ_PARAM2, this.d ? 2 : 1).param(TiebaStatic.Params.SPLASH_UNI, this.e);
                        if (!StringUtils.isNull(next.c())) {
                            param.param(TiebaStatic.Params.OBJ_TO, next.c());
                        }
                        param.eventStat();
                        rl5Var.s();
                        return;
                    }
                    StatisticItem.make("fail_splash").param("obj_param1", u ? "1" : "0").eventStat();
                }
            }
            nl4 nl4Var = this.g;
            if (nl4Var != null) {
                nl4Var.b("");
            }
        }
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a : invokeV.intValue;
    }

    public final byte f(hm5 hm5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, hm5Var)) == null) {
            if (hm5Var == null) {
                return (byte) 0;
            }
            String f = hm5Var.f();
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
                    sl5 sl5Var = new sl5(this.f);
                    rl5 rl5Var = new rl5(this.f);
                    this.h.clear();
                    if (UbsABTestHelper.newSplashStrategy()) {
                        if (vc5.w()) {
                            this.h.add(sl5Var);
                        }
                    } else if (this.b != 0) {
                        this.h.add(sl5Var);
                    }
                    if (vc5.q(this.a)) {
                        this.h.add(rl5Var);
                    }
                    if (xt4.k().h("key_is_jump_splash_ad", false)) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? vc5.q(this.a) : invokeV.booleanValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            Iterator<hm5> it = this.h.iterator();
            while (it.hasNext()) {
                hm5 next = it.next();
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
        nl4 nl4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) || (nl4Var = this.g) == null) {
            return;
        }
        nl4Var.a(i2);
    }

    public void l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.c = false;
            g();
            Iterator<hm5> it = this.h.iterator();
            while (it.hasNext()) {
                hm5 next = it.next();
                if (i2 == 5 && (next instanceof sl5)) {
                    if (!mm5.g()) {
                        next.a();
                        return;
                    }
                } else if (i2 == 6 && (next instanceof rl5)) {
                    Iterator<hm5> it2 = this.h.iterator();
                    while (it2.hasNext()) {
                        hm5 next2 = it2.next();
                        if (next2 instanceof sl5) {
                            StatisticItem statisticItem = new StatisticItem("preload_bear");
                            sl5 sl5Var = (sl5) next2;
                            statisticItem.param("obj_param1", sl5Var.v() ? "1" : "0");
                            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, sl5Var.w() ? "1" : "0");
                            TiebaStatic.log(statisticItem);
                        }
                    }
                    next.a();
                    return;
                }
            }
        }
    }

    public synchronized void m(ql4 ql4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, ql4Var) == null) {
            synchronized (this) {
                this.c = false;
                this.e = ql4Var.c();
                this.g = ql4Var.a();
                this.d = ql4Var.d();
                if (this.f != null) {
                    this.f.onSplashEvent(96);
                }
                g();
                lm5.c();
                Iterator<hm5> it = this.h.iterator();
                while (it.hasNext()) {
                    hm5 next = it.next();
                    if (!(next instanceof sl5) || !mm5.g()) {
                        next.e(ql4Var);
                    }
                }
            }
        }
    }

    public void n(nl4 nl4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, nl4Var) == null) || UbsABTestHelper.newSplashStrategy()) {
            return;
        }
        o(nl4Var, true);
    }

    public synchronized void o(nl4 nl4Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLZ(1048588, this, nl4Var, z) != null) {
            return;
        }
        synchronized (this) {
            if (this.c) {
                return;
            }
            Iterator<hm5> it = this.h.iterator();
            while (true) {
                if (!it.hasNext()) {
                    if (!z) {
                        StatisticItem.make(TbadkCoreStatisticKey.HOT_SPLASH_TIMEOUT).param("obj_type", "a064").param(TiebaStatic.Params.BEAR_CONFIG, vc5.q(this.a) ? 1 : 0).param(TiebaStatic.Params.PLG_CONFIG, this.b != 0 ? 1 : 0).param(TiebaStatic.Params.OBJ_DURATION, System.currentTimeMillis()).param(TiebaStatic.Params.SPLASH_UNI, this.e).eventStat();
                    }
                    if (nl4Var != null) {
                        nl4Var.b("");
                    }
                    return;
                }
                hm5 next = it.next();
                if (next != null) {
                    if (next.d() == AdLoadState.SUCCEED) {
                        this.c = true;
                        StatisticItem param = StatisticItem.make(TbadkCoreStatisticKey.SHOW_AD_TIME).param("obj_source", (int) f(next)).param("obj_type", "a064").param(TiebaStatic.Params.OBJ_DURATION, System.currentTimeMillis()).param(TiebaStatic.Params.OBJ_PARAM2, this.d ? 2 : 1).param(TiebaStatic.Params.SPLASH_UNI, this.e);
                        if (!StringUtils.isNull(next.c())) {
                            param.param(TiebaStatic.Params.OBJ_TO, next.c());
                        }
                        param.eventStat();
                        if (AdToMainTabActivitySwitch.getIsOn()) {
                            vk8.a(MainTabScheduleStrategy.UNSCHEDULE);
                            qg.a().post(new a(this, nl4Var, next));
                        } else {
                            if (nl4Var != null) {
                                nl4Var.c(next instanceof sl5 ? ((sl5) next).k : null);
                            }
                            next.show();
                            if (nl4Var != null) {
                                nl4Var.d(String.valueOf((int) f(next)));
                            }
                        }
                        mt4.a("homePage", -1L, 0, "logo_splash", 0, "", "splashType", oi.isEmpty(next.f()) ? "bes" : next.f());
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
                Iterator<hm5> it = this.h.iterator();
                while (it.hasNext()) {
                    hm5 next = it.next();
                    if (next != null) {
                        if ((z ? next instanceof rl5 : next instanceof sl5) && next.d() == AdLoadState.SUCCEED) {
                            this.c = true;
                            StatisticItem param = StatisticItem.make(TbadkCoreStatisticKey.SHOW_AD_TIME).param("obj_source", (int) f(next)).param("obj_type", "a064").param(TiebaStatic.Params.OBJ_DURATION, System.currentTimeMillis()).param(TiebaStatic.Params.OBJ_PARAM2, this.d ? 2 : 1).param(TiebaStatic.Params.SPLASH_UNI, this.e);
                            if (!StringUtils.isNull(next.c())) {
                                param.param(TiebaStatic.Params.OBJ_TO, next.c());
                            }
                            param.eventStat();
                            if (AdToMainTabActivitySwitch.getIsOn()) {
                                vk8.a(MainTabScheduleStrategy.UNSCHEDULE);
                            }
                            if (this.g != null) {
                                this.g.c(next instanceof sl5 ? ((sl5) next).k : null);
                            }
                            next.show();
                            if (this.g != null) {
                                this.g.d(String.valueOf((int) f(next)));
                            }
                            lm5.d(String.valueOf((int) f(next)));
                            return;
                        }
                    }
                }
                if (this.g != null) {
                    this.g.b("");
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
                    boolean initSplashPolicy = splashNativePolicy2.initSplashPolicy(vc5.u(), vc5.w(), vc5.v(), vc5.k(), vc5.l());
                    PrintStream printStream = System.out;
                    printStream.println("SplashPolicy init result = " + initSplashPolicy);
                    if (initSplashPolicy) {
                        return;
                    }
                    this.f = null;
                    return;
                }
                boolean updateSplashConfig = splashNativePolicy.updateSplashConfig(vc5.u(), vc5.w(), vc5.v(), vc5.k(), vc5.l());
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
            int e = ng.e(jSONObject.optString("ad_sdk_priority"), 0);
            int e2 = ng.e(jSONObject.optString("ad_origin_config_switch"), 1);
            int e3 = ng.e(jSONObject.optString("bear_sid_type"), 0);
            int e4 = ng.e(jSONObject.optString(UsbAbTestConst.KEY_NEW_SPLASH_POLICY, "0"), 0);
            JSONObject optJSONObject = jSONObject.optJSONObject("screen_fill_data_result");
            if (optJSONObject != null) {
                int e5 = ng.e(optJSONObject.optString("screen_fill_advertisement_first_switch", com.tencent.connect.common.Constants.DEFAULT_UIN), 1000);
                int e6 = ng.e(optJSONObject.optString("screen_fill_advertisement_second_switch", "1400"), 1400);
                int e7 = ng.e(optJSONObject.optString("screen_fill_advertisement_bear_switch", "1"), 1);
                int e8 = ng.e(optJSONObject.optString("screen_fill_advertisement_plj_switch", "1"), 1);
                int e9 = ng.e(optJSONObject.optString("screen_fill_advertisement_plj_cpc_switch", "1"), 1);
                xt4.k().w("key_splash_new_policy_bear_enable", e7);
                xt4.k().w("key_splash_new_policy_plg_enable", e8);
                xt4.k().w("key_splash_new_policy_plg_cpc_enable", e9);
                xt4.k().w("key_splash_new_policy_first_timeout", e5);
                xt4.k().w("key_splash_new_policy_second_timeout", e6);
            }
            rl5.v(e3);
            xt4.k().w("splash_ad_strategy_key", e);
            xt4.k().w("splash_origin_ad_strategy_key", e2);
            xt4.k().w("key_splash_new_policy_enable", e4);
            if (!h() && vc5.q(e)) {
                if (pi.C()) {
                    zq6.m().u();
                } else {
                    qg.a().post(new b(this));
                }
            }
            this.a = e;
            this.b = e2;
        }
    }
}
