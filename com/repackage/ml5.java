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
public class ml5 {
    public static /* synthetic */ Interceptable $ic;
    public static ml5 i;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public boolean c;
    public boolean d;
    public long e;
    public SplashNativePolicy f;
    public bm4 g;
    public final ArrayList<nl5> h;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bm4 a;
        public final /* synthetic */ nl5 b;
        public final /* synthetic */ ml5 c;

        public a(ml5 ml5Var, bm4 bm4Var, nl5 nl5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ml5Var, bm4Var, nl5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ml5Var;
            this.a = bm4Var;
            this.b = nl5Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a != null) {
                    nl5 nl5Var = this.b;
                    this.a.b(nl5Var instanceof yk5 ? ((yk5) nl5Var).k : null);
                }
                this.b.show();
                bm4 bm4Var = this.a;
                if (bm4Var != null) {
                    bm4Var.d(String.valueOf((int) this.c.f(this.b)));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(ml5 ml5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ml5Var};
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
                er6.j().m();
            }
        }
    }

    public ml5() {
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
        this.a = iu4.k().l("splash_ad_strategy_key", 0);
        this.b = iu4.k().l("splash_origin_ad_strategy_key", 1);
        q();
    }

    public static ml5 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (i == null) {
                synchronized (ml5.class) {
                    if (i == null) {
                        i = new ml5();
                    }
                }
            }
            return i;
        }
        return (ml5) invokeV.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Iterator<nl5> it = this.h.iterator();
            while (it.hasNext()) {
                nl5 next = it.next();
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
            Iterator<nl5> it = this.h.iterator();
            while (it.hasNext()) {
                nl5 next = it.next();
                if (next instanceof xk5) {
                    StatisticItem statisticItem = new StatisticItem("fail_splash");
                    statisticItem.param("obj_param1", ((xk5) next).s() ? "1" : "0");
                    TiebaStatic.log(statisticItem);
                }
            }
            bm4 bm4Var = this.g;
            if (bm4Var != null) {
                bm4Var.c("");
            }
        }
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a : invokeV.intValue;
    }

    public final byte f(nl5 nl5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, nl5Var)) == null) {
            if (nl5Var == null) {
                return (byte) 0;
            }
            String f = nl5Var.f();
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
                    yk5 yk5Var = new yk5(this.f);
                    xk5 xk5Var = new xk5(this.f);
                    this.h.clear();
                    if (UbsABTestHelper.newSplashStrategy()) {
                        if (lc5.w()) {
                            this.h.add(yk5Var);
                        }
                    } else if (this.b != 0) {
                        this.h.add(yk5Var);
                    }
                    if (lc5.q(this.a)) {
                        this.h.add(xk5Var);
                    }
                    if (iu4.k().h("key_is_jump_splash_ad", false)) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? lc5.q(this.a) : invokeV.booleanValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            Iterator<nl5> it = this.h.iterator();
            while (it.hasNext()) {
                nl5 next = it.next();
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
        bm4 bm4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) || (bm4Var = this.g) == null) {
            return;
        }
        bm4Var.a(i2);
    }

    public void l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.c = false;
            g();
            Iterator<nl5> it = this.h.iterator();
            while (it.hasNext()) {
                nl5 next = it.next();
                if (i2 == 5 && (next instanceof yk5)) {
                    next.a();
                    return;
                } else if (i2 == 6 && (next instanceof xk5)) {
                    Iterator<nl5> it2 = this.h.iterator();
                    while (it2.hasNext()) {
                        nl5 next2 = it2.next();
                        if (next2 instanceof yk5) {
                            StatisticItem statisticItem = new StatisticItem("preload_bear");
                            yk5 yk5Var = (yk5) next2;
                            statisticItem.param("obj_param1", yk5Var.v() ? "1" : "0");
                            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, yk5Var.w() ? "1" : "0");
                            TiebaStatic.log(statisticItem);
                        }
                    }
                    next.a();
                    return;
                }
            }
        }
    }

    public synchronized void m(em4 em4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, em4Var) == null) {
            synchronized (this) {
                this.c = false;
                this.e = em4Var.c();
                this.g = em4Var.a();
                this.d = em4Var.d();
                if (this.f != null) {
                    this.f.onSplashEvent(96);
                }
                g();
                rl5.c();
                Iterator<nl5> it = this.h.iterator();
                while (it.hasNext()) {
                    it.next().e(em4Var);
                }
            }
        }
    }

    public void n(bm4 bm4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, bm4Var) == null) || UbsABTestHelper.newSplashStrategy()) {
            return;
        }
        o(bm4Var, true);
    }

    public synchronized void o(bm4 bm4Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLZ(1048588, this, bm4Var, z) != null) {
            return;
        }
        synchronized (this) {
            if (this.c) {
                return;
            }
            Iterator<nl5> it = this.h.iterator();
            while (true) {
                if (!it.hasNext()) {
                    if (!z) {
                        StatisticItem.make(TbadkCoreStatisticKey.HOT_SPLASH_TIMEOUT).param("obj_type", "a064").param("tid", lc5.q(this.a) ? 1 : 0).param("pid", this.b != 0 ? 1 : 0).param(TiebaStatic.Params.OBJ_DURATION, System.currentTimeMillis()).param("fid", this.e).eventStat();
                    }
                    if (bm4Var != null) {
                        bm4Var.c("");
                    }
                    return;
                }
                nl5 next = it.next();
                if (next != null) {
                    if (next.d() == AdLoadState.SUCCEED) {
                        this.c = true;
                        StatisticItem param = StatisticItem.make(TbadkCoreStatisticKey.SHOW_AD_TIME).param("obj_source", (int) f(next)).param("obj_type", "a064").param(TiebaStatic.Params.OBJ_DURATION, System.currentTimeMillis()).param(TiebaStatic.Params.OBJ_PARAM2, this.d ? 2 : 1).param("fid", this.e);
                        if (!StringUtils.isNull(next.c())) {
                            param.param(TiebaStatic.Params.OBJ_TO, next.c());
                        }
                        param.eventStat();
                        if (AdToMainTabActivitySwitch.getIsOn()) {
                            om8.a(MainTabScheduleStrategy.UNSCHEDULE);
                            ng.a().post(new a(this, bm4Var, next));
                        } else {
                            if (bm4Var != null) {
                                bm4Var.b(next instanceof yk5 ? ((yk5) next).k : null);
                            }
                            next.show();
                            if (bm4Var != null) {
                                bm4Var.d(String.valueOf((int) f(next)));
                            }
                        }
                        xt4.a("homePage", -1L, 0, "logo_splash", 0, "", "splashType", li.isEmpty(next.f()) ? "bes" : next.f());
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
                Iterator<nl5> it = this.h.iterator();
                while (it.hasNext()) {
                    nl5 next = it.next();
                    if (next != null) {
                        if ((z ? next instanceof xk5 : next instanceof yk5) && next.d() == AdLoadState.SUCCEED) {
                            this.c = true;
                            StatisticItem param = StatisticItem.make(TbadkCoreStatisticKey.SHOW_AD_TIME).param("obj_source", (int) f(next)).param("obj_type", "a064").param(TiebaStatic.Params.OBJ_DURATION, System.currentTimeMillis()).param(TiebaStatic.Params.OBJ_PARAM2, this.d ? 2 : 1).param("fid", this.e);
                            if (!StringUtils.isNull(next.c())) {
                                param.param(TiebaStatic.Params.OBJ_TO, next.c());
                            }
                            param.eventStat();
                            if (AdToMainTabActivitySwitch.getIsOn()) {
                                om8.a(MainTabScheduleStrategy.UNSCHEDULE);
                            }
                            if (this.g != null) {
                                this.g.b(next instanceof yk5 ? ((yk5) next).k : null);
                            }
                            next.show();
                            if (this.g != null) {
                                this.g.d(String.valueOf((int) f(next)));
                            }
                            rl5.d(String.valueOf((int) f(next)));
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
                    boolean initSplashPolicy = splashNativePolicy2.initSplashPolicy(lc5.u(), lc5.w(), lc5.v(), lc5.k(), lc5.l());
                    PrintStream printStream = System.out;
                    printStream.println("SplashPolicy init result = " + initSplashPolicy);
                    if (initSplashPolicy) {
                        return;
                    }
                    this.f = null;
                    return;
                }
                boolean updateSplashConfig = splashNativePolicy.updateSplashConfig(lc5.u(), lc5.w(), lc5.v(), lc5.k(), lc5.l());
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
            int e = kg.e(jSONObject.optString("ad_sdk_priority"), 0);
            int e2 = kg.e(jSONObject.optString("ad_origin_config_switch"), 1);
            int e3 = kg.e(jSONObject.optString("bear_sid_type"), 0);
            int e4 = kg.e(jSONObject.optString(UsbAbTestConst.KEY_NEW_SPLASH_POLICY, "0"), 0);
            JSONObject optJSONObject = jSONObject.optJSONObject("screen_fill_data_result");
            if (optJSONObject != null) {
                int e5 = kg.e(optJSONObject.optString("screen_fill_advertisement_first_switch", com.tencent.connect.common.Constants.DEFAULT_UIN), 1000);
                int e6 = kg.e(optJSONObject.optString("screen_fill_advertisement_second_switch", "1400"), 1400);
                int e7 = kg.e(optJSONObject.optString("screen_fill_advertisement_bear_switch", "1"), 1);
                int e8 = kg.e(optJSONObject.optString("screen_fill_advertisement_plj_switch", "1"), 1);
                int e9 = kg.e(optJSONObject.optString("screen_fill_advertisement_plj_cpc_switch", "1"), 1);
                iu4.k().w("key_splash_new_policy_bear_enable", e7);
                iu4.k().w("key_splash_new_policy_plg_enable", e8);
                iu4.k().w("key_splash_new_policy_plg_cpc_enable", e9);
                iu4.k().w("key_splash_new_policy_first_timeout", e5);
                iu4.k().w("key_splash_new_policy_second_timeout", e6);
            }
            xk5.t(e3);
            iu4.k().w("splash_ad_strategy_key", e);
            iu4.k().w("splash_origin_ad_strategy_key", e2);
            iu4.k().w("key_splash_new_policy_enable", e4);
            if (!h() && lc5.q(e)) {
                if (mi.B()) {
                    er6.j().m();
                } else {
                    ng.a().post(new b(this));
                }
            }
            this.a = e;
            this.b = e2;
        }
    }
}
