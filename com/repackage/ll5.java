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
public class ll5 {
    public static /* synthetic */ Interceptable $ic;
    public static ll5 i;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public boolean c;
    public boolean d;
    public long e;
    public SplashNativePolicy f;
    public rl4 g;
    public final ArrayList<ml5> h;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rl4 a;
        public final /* synthetic */ ml5 b;
        public final /* synthetic */ ll5 c;

        public a(ll5 ll5Var, rl4 rl4Var, ml5 ml5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ll5Var, rl4Var, ml5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ll5Var;
            this.a = rl4Var;
            this.b = ml5Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                rl4 rl4Var = this.a;
                if (rl4Var != null) {
                    rl4Var.e();
                }
                this.b.show();
                rl4 rl4Var2 = this.a;
                if (rl4Var2 != null) {
                    rl4Var2.b(String.valueOf((int) this.c.f(this.b)));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(ll5 ll5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ll5Var};
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
                cs6.j().m();
            }
        }
    }

    public ll5() {
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
        this.a = wt4.k().l("splash_ad_strategy_key", 0);
        this.b = wt4.k().l("splash_origin_ad_strategy_key", 1);
        q();
    }

    public static ll5 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (i == null) {
                synchronized (ll5.class) {
                    if (i == null) {
                        i = new ll5();
                    }
                }
            }
            return i;
        }
        return (ll5) invokeV.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Iterator<ml5> it = this.h.iterator();
            while (it.hasNext()) {
                ml5 next = it.next();
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
        rl4 rl4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (rl4Var = this.g) == null) {
            return;
        }
        rl4Var.c("");
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a : invokeV.intValue;
    }

    public final byte f(ml5 ml5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, ml5Var)) == null) {
            if (ml5Var == null) {
                return (byte) 0;
            }
            String f = ml5Var.f();
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
                        if (ub5.w()) {
                            this.h.add(yk5Var);
                        }
                    } else if (this.b != 0) {
                        this.h.add(yk5Var);
                    }
                    if (ub5.q(this.a)) {
                        this.h.add(xk5Var);
                    }
                    if (wt4.k().h("key_is_jump_splash_ad", false)) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? ub5.q(this.a) : invokeV.booleanValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            Iterator<ml5> it = this.h.iterator();
            while (it.hasNext()) {
                ml5 next = it.next();
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

    public void k() {
        rl4 rl4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (rl4Var = this.g) == null) {
            return;
        }
        rl4Var.a();
    }

    public void l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.c = false;
            g();
            Iterator<ml5> it = this.h.iterator();
            while (it.hasNext()) {
                ml5 next = it.next();
                if (i2 == 5 && (next instanceof yk5)) {
                    next.a();
                    return;
                } else if (i2 == 6 && (next instanceof xk5)) {
                    next.a();
                    return;
                }
            }
        }
    }

    public synchronized void m(ul4 ul4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, ul4Var) == null) {
            synchronized (this) {
                this.c = false;
                this.e = ul4Var.c();
                this.g = ul4Var.a();
                this.d = ul4Var.d();
                if (this.f != null) {
                    this.f.onSplashEvent(96);
                }
                g();
                ql5.c();
                Iterator<ml5> it = this.h.iterator();
                while (it.hasNext()) {
                    it.next().e(ul4Var);
                }
            }
        }
    }

    public void n(rl4 rl4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, rl4Var) == null) || UbsABTestHelper.newSplashStrategy()) {
            return;
        }
        o(rl4Var, true);
    }

    public synchronized void o(rl4 rl4Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLZ(1048588, this, rl4Var, z) != null) {
            return;
        }
        synchronized (this) {
            if (this.c) {
                return;
            }
            Iterator<ml5> it = this.h.iterator();
            while (true) {
                if (!it.hasNext()) {
                    if (!z) {
                        StatisticItem.make(TbadkCoreStatisticKey.HOT_SPLASH_TIMEOUT).param("obj_type", "a064").param("tid", ub5.q(this.a) ? 1 : 0).param("pid", this.b != 0 ? 1 : 0).param(TiebaStatic.Params.OBJ_DURATION, System.currentTimeMillis()).param("fid", this.e).eventStat();
                    }
                    if (rl4Var != null) {
                        rl4Var.c("");
                    }
                    return;
                }
                ml5 next = it.next();
                if (next != null) {
                    if (next.d() == AdLoadState.SUCCEED) {
                        this.c = true;
                        StatisticItem param = StatisticItem.make(TbadkCoreStatisticKey.SHOW_AD_TIME).param("obj_source", (int) f(next)).param("obj_type", "a064").param(TiebaStatic.Params.OBJ_DURATION, System.currentTimeMillis()).param(TiebaStatic.Params.OBJ_PARAM2, this.d ? 2 : 1).param("fid", this.e);
                        if (!StringUtils.isNull(next.c())) {
                            param.param(TiebaStatic.Params.OBJ_TO, next.c());
                        }
                        param.eventStat();
                        if (AdToMainTabActivitySwitch.getIsOn()) {
                            kn8.a(MainTabScheduleStrategy.UNSCHEDULE);
                            pg.a().post(new a(this, rl4Var, next));
                        } else {
                            if (rl4Var != null) {
                                rl4Var.e();
                            }
                            next.show();
                            if (rl4Var != null) {
                                rl4Var.b(String.valueOf((int) f(next)));
                            }
                        }
                        lt4.a("homePage", -1L, 0, "logo_splash", 0, "", "splashType", ni.isEmpty(next.f()) ? "bes" : next.f());
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
                Iterator<ml5> it = this.h.iterator();
                while (it.hasNext()) {
                    ml5 next = it.next();
                    if (next != null) {
                        if ((z ? next instanceof xk5 : next instanceof yk5) && next.d() == AdLoadState.SUCCEED) {
                            this.c = true;
                            StatisticItem param = StatisticItem.make(TbadkCoreStatisticKey.SHOW_AD_TIME).param("obj_source", (int) f(next)).param("obj_type", "a064").param(TiebaStatic.Params.OBJ_DURATION, System.currentTimeMillis()).param(TiebaStatic.Params.OBJ_PARAM2, this.d ? 2 : 1).param("fid", this.e);
                            if (!StringUtils.isNull(next.c())) {
                                param.param(TiebaStatic.Params.OBJ_TO, next.c());
                            }
                            param.eventStat();
                            if (AdToMainTabActivitySwitch.getIsOn()) {
                                kn8.a(MainTabScheduleStrategy.UNSCHEDULE);
                            }
                            if (this.g != null) {
                                this.g.e();
                            }
                            next.show();
                            if (this.g != null) {
                                this.g.b(String.valueOf((int) f(next)));
                            }
                            ql5.d(String.valueOf((int) f(next)));
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
                    boolean initSplashPolicy = splashNativePolicy2.initSplashPolicy(ub5.u(), ub5.w(), ub5.v(), ub5.k(), ub5.l());
                    PrintStream printStream = System.out;
                    printStream.println("SplashPolicy init result = " + initSplashPolicy);
                    if (initSplashPolicy) {
                        return;
                    }
                    this.f = null;
                    return;
                }
                boolean updateSplashConfig = splashNativePolicy.updateSplashConfig(ub5.u(), ub5.w(), ub5.v(), ub5.k(), ub5.l());
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
            int e = mg.e(jSONObject.optString("ad_sdk_priority"), 0);
            int e2 = mg.e(jSONObject.optString("ad_origin_config_switch"), 1);
            int e3 = mg.e(jSONObject.optString("bear_sid_type"), 0);
            int e4 = mg.e(jSONObject.optString(UsbAbTestConst.KEY_NEW_SPLASH_POLICY, "0"), 0);
            JSONObject optJSONObject = jSONObject.optJSONObject("screen_fill_data_result");
            if (optJSONObject != null) {
                int e5 = mg.e(optJSONObject.optString("screen_fill_advertisement_first_switch", com.tencent.connect.common.Constants.DEFAULT_UIN), 1000);
                int e6 = mg.e(optJSONObject.optString("screen_fill_advertisement_second_switch", "1400"), 1400);
                int e7 = mg.e(optJSONObject.optString("screen_fill_advertisement_bear_switch", "1"), 1);
                int e8 = mg.e(optJSONObject.optString("screen_fill_advertisement_plj_switch", "1"), 1);
                int e9 = mg.e(optJSONObject.optString("screen_fill_advertisement_plj_cpc_switch", "1"), 1);
                wt4.k().w("key_splash_new_policy_bear_enable", e7);
                wt4.k().w("key_splash_new_policy_plg_enable", e8);
                wt4.k().w("key_splash_new_policy_plg_cpc_enable", e9);
                wt4.k().w("key_splash_new_policy_first_timeout", e5);
                wt4.k().w("key_splash_new_policy_second_timeout", e6);
            }
            xk5.s(e3);
            wt4.k().w("splash_ad_strategy_key", e);
            wt4.k().w("splash_origin_ad_strategy_key", e2);
            wt4.k().w("key_splash_new_policy_enable", e4);
            if (!h() && ub5.q(e)) {
                if (oi.B()) {
                    cs6.j().m();
                } else {
                    pg.a().post(new b(this));
                }
            }
            this.a = e;
            this.b = e2;
        }
    }
}
