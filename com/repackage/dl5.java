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
/* loaded from: classes5.dex */
public class dl5 {
    public static /* synthetic */ Interceptable $ic;
    public static dl5 i;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public boolean c;
    public boolean d;
    public long e;
    public SplashNativePolicy f;
    public yk4 g;
    public final ArrayList<el5> h;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yk4 a;
        public final /* synthetic */ el5 b;
        public final /* synthetic */ dl5 c;

        public a(dl5 dl5Var, yk4 yk4Var, el5 el5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dl5Var, yk4Var, el5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = dl5Var;
            this.a = yk4Var;
            this.b = el5Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a != null) {
                    el5 el5Var = this.b;
                    this.a.b(el5Var instanceof pk5 ? ((pk5) el5Var).k : null);
                }
                this.b.show();
                yk4 yk4Var = this.a;
                if (yk4Var != null) {
                    yk4Var.d(String.valueOf((int) this.c.f(this.b)));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(dl5 dl5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dl5Var};
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
                nq6.m().u();
            }
        }
    }

    public dl5() {
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
        this.a = ht4.k().l("splash_ad_strategy_key", 0);
        this.b = ht4.k().l("splash_origin_ad_strategy_key", 1);
        q();
    }

    public static dl5 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (i == null) {
                synchronized (dl5.class) {
                    if (i == null) {
                        i = new dl5();
                    }
                }
            }
            return i;
        }
        return (dl5) invokeV.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Iterator<el5> it = this.h.iterator();
            while (it.hasNext()) {
                el5 next = it.next();
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
            Iterator<el5> it = this.h.iterator();
            while (it.hasNext()) {
                el5 next = it.next();
                if (next instanceof ok5) {
                    ok5 ok5Var = (ok5) next;
                    boolean u = ok5Var.u();
                    if (u && BearTimeoutTryShowSwitch.isOn()) {
                        StatisticItem param = StatisticItem.make(TbadkCoreStatisticKey.SHOW_AD_TIME).param("obj_source", (int) f(next)).param("obj_type", "a064").param(TiebaStatic.Params.OBJ_DURATION, System.currentTimeMillis()).param("obj_param1", 1).param(TiebaStatic.Params.OBJ_PARAM2, this.d ? 2 : 1).param(TiebaStatic.Params.SPLASH_UNI, this.e);
                        if (!StringUtils.isNull(next.c())) {
                            param.param(TiebaStatic.Params.OBJ_TO, next.c());
                        }
                        param.eventStat();
                        ok5Var.s();
                        return;
                    }
                    StatisticItem.make("fail_splash").param("obj_param1", u ? "1" : "0").eventStat();
                }
            }
            yk4 yk4Var = this.g;
            if (yk4Var != null) {
                yk4Var.c("");
            }
        }
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a : invokeV.intValue;
    }

    public final byte f(el5 el5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, el5Var)) == null) {
            if (el5Var == null) {
                return (byte) 0;
            }
            String f = el5Var.f();
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
                    pk5 pk5Var = new pk5(this.f);
                    ok5 ok5Var = new ok5(this.f);
                    this.h.clear();
                    if (UbsABTestHelper.newSplashStrategy()) {
                        if (sb5.w()) {
                            this.h.add(pk5Var);
                        }
                    } else if (this.b != 0) {
                        this.h.add(pk5Var);
                    }
                    if (sb5.q(this.a)) {
                        this.h.add(ok5Var);
                    }
                    if (ht4.k().h("key_is_jump_splash_ad", false)) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? sb5.q(this.a) : invokeV.booleanValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            Iterator<el5> it = this.h.iterator();
            while (it.hasNext()) {
                el5 next = it.next();
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
        yk4 yk4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) || (yk4Var = this.g) == null) {
            return;
        }
        yk4Var.a(i2);
    }

    public void l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.c = false;
            g();
            Iterator<el5> it = this.h.iterator();
            while (it.hasNext()) {
                el5 next = it.next();
                if (i2 == 5 && (next instanceof pk5)) {
                    if (!jl5.h()) {
                        next.a();
                        return;
                    }
                } else if (i2 == 6 && (next instanceof ok5)) {
                    Iterator<el5> it2 = this.h.iterator();
                    while (it2.hasNext()) {
                        el5 next2 = it2.next();
                        if (next2 instanceof pk5) {
                            StatisticItem statisticItem = new StatisticItem("preload_bear");
                            pk5 pk5Var = (pk5) next2;
                            statisticItem.param("obj_param1", pk5Var.v() ? "1" : "0");
                            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, pk5Var.w() ? "1" : "0");
                            TiebaStatic.log(statisticItem);
                        }
                    }
                    next.a();
                    return;
                }
            }
        }
    }

    public synchronized void m(bl4 bl4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bl4Var) == null) {
            synchronized (this) {
                this.c = false;
                this.e = bl4Var.c();
                this.g = bl4Var.a();
                this.d = bl4Var.d();
                if (this.f != null) {
                    this.f.onSplashEvent(96);
                }
                g();
                il5.c();
                Iterator<el5> it = this.h.iterator();
                while (it.hasNext()) {
                    el5 next = it.next();
                    if (!(next instanceof pk5) || !jl5.h()) {
                        next.e(bl4Var);
                    }
                }
            }
        }
    }

    public void n(yk4 yk4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, yk4Var) == null) || UbsABTestHelper.newSplashStrategy()) {
            return;
        }
        o(yk4Var, true);
    }

    public synchronized void o(yk4 yk4Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLZ(1048588, this, yk4Var, z) != null) {
            return;
        }
        synchronized (this) {
            if (this.c) {
                return;
            }
            Iterator<el5> it = this.h.iterator();
            while (true) {
                if (!it.hasNext()) {
                    if (!z) {
                        StatisticItem.make(TbadkCoreStatisticKey.HOT_SPLASH_TIMEOUT).param("obj_type", "a064").param(TiebaStatic.Params.BEAR_CONFIG, sb5.q(this.a) ? 1 : 0).param(TiebaStatic.Params.PLG_CONFIG, this.b != 0 ? 1 : 0).param(TiebaStatic.Params.OBJ_DURATION, System.currentTimeMillis()).param(TiebaStatic.Params.SPLASH_UNI, this.e).eventStat();
                    }
                    if (yk4Var != null) {
                        yk4Var.c("");
                    }
                    return;
                }
                el5 next = it.next();
                if (next != null) {
                    if (next.d() == AdLoadState.SUCCEED) {
                        this.c = true;
                        StatisticItem param = StatisticItem.make(TbadkCoreStatisticKey.SHOW_AD_TIME).param("obj_source", (int) f(next)).param("obj_type", "a064").param(TiebaStatic.Params.OBJ_DURATION, System.currentTimeMillis()).param(TiebaStatic.Params.OBJ_PARAM2, this.d ? 2 : 1).param(TiebaStatic.Params.SPLASH_UNI, this.e);
                        if (!StringUtils.isNull(next.c())) {
                            param.param(TiebaStatic.Params.OBJ_TO, next.c());
                        }
                        param.eventStat();
                        if (AdToMainTabActivitySwitch.getIsOn()) {
                            yj8.a(MainTabScheduleStrategy.UNSCHEDULE);
                            qg.a().post(new a(this, yk4Var, next));
                        } else {
                            if (yk4Var != null) {
                                yk4Var.b(next instanceof pk5 ? ((pk5) next).k : null);
                            }
                            next.show();
                            if (yk4Var != null) {
                                yk4Var.d(String.valueOf((int) f(next)));
                            }
                        }
                        ws4.a("homePage", -1L, 0, "logo_splash", 0, "", "splashType", oi.isEmpty(next.f()) ? "bes" : next.f());
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
                Iterator<el5> it = this.h.iterator();
                while (it.hasNext()) {
                    el5 next = it.next();
                    if (next != null) {
                        if ((z ? next instanceof ok5 : next instanceof pk5) && next.d() == AdLoadState.SUCCEED) {
                            this.c = true;
                            StatisticItem param = StatisticItem.make(TbadkCoreStatisticKey.SHOW_AD_TIME).param("obj_source", (int) f(next)).param("obj_type", "a064").param(TiebaStatic.Params.OBJ_DURATION, System.currentTimeMillis()).param(TiebaStatic.Params.OBJ_PARAM2, this.d ? 2 : 1).param(TiebaStatic.Params.SPLASH_UNI, this.e);
                            if (!StringUtils.isNull(next.c())) {
                                param.param(TiebaStatic.Params.OBJ_TO, next.c());
                            }
                            param.eventStat();
                            if (AdToMainTabActivitySwitch.getIsOn()) {
                                yj8.a(MainTabScheduleStrategy.UNSCHEDULE);
                            }
                            if (this.g != null) {
                                this.g.b(next instanceof pk5 ? ((pk5) next).k : null);
                            }
                            next.show();
                            if (this.g != null) {
                                this.g.d(String.valueOf((int) f(next)));
                            }
                            il5.d(String.valueOf((int) f(next)));
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
                    boolean initSplashPolicy = splashNativePolicy2.initSplashPolicy(sb5.u(), sb5.w(), sb5.v(), sb5.k(), sb5.l());
                    PrintStream printStream = System.out;
                    printStream.println("SplashPolicy init result = " + initSplashPolicy);
                    if (initSplashPolicy) {
                        return;
                    }
                    this.f = null;
                    return;
                }
                boolean updateSplashConfig = splashNativePolicy.updateSplashConfig(sb5.u(), sb5.w(), sb5.v(), sb5.k(), sb5.l());
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
                ht4.k().w("key_splash_new_policy_bear_enable", e7);
                ht4.k().w("key_splash_new_policy_plg_enable", e8);
                ht4.k().w("key_splash_new_policy_plg_cpc_enable", e9);
                ht4.k().w("key_splash_new_policy_first_timeout", e5);
                ht4.k().w("key_splash_new_policy_second_timeout", e6);
            }
            ok5.v(e3);
            ht4.k().w("splash_ad_strategy_key", e);
            ht4.k().w("splash_origin_ad_strategy_key", e2);
            ht4.k().w("key_splash_new_policy_enable", e4);
            if (!h() && sb5.q(e)) {
                if (pi.C()) {
                    nq6.m().u();
                } else {
                    qg.a().post(new b(this));
                }
            }
            this.a = e;
            this.b = e2;
        }
    }
}
