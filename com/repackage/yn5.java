package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
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
/* loaded from: classes7.dex */
public class yn5 {
    public static /* synthetic */ Interceptable $ic;
    public static yn5 h;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public boolean b;
    public boolean c;
    public long d;
    public SplashNativePolicy e;
    public fm4 f;
    public final ArrayList<zn5> g;

    public yn5() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = false;
        this.d = -1L;
        this.f = null;
        this.g = new ArrayList<>();
        this.a = ru4.k().l("splash_ad_strategy_key", 0);
        m();
    }

    public static yn5 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (h == null) {
                synchronized (yn5.class) {
                    if (h == null) {
                        h = new yn5();
                    }
                }
            }
            return h;
        }
        return (yn5) invokeV.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Iterator<zn5> it = this.g.iterator();
            while (it.hasNext()) {
                zn5 next = it.next();
                if (next != null) {
                    next.destroy();
                }
            }
            this.g.clear();
            SplashNativePolicy splashNativePolicy = this.e;
            if (splashNativePolicy != null) {
                splashNativePolicy.releaseSplash();
                this.e = null;
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Iterator<zn5> it = this.g.iterator();
            while (it.hasNext()) {
                zn5 next = it.next();
                if (next instanceof jn5) {
                    jn5 jn5Var = (jn5) next;
                    boolean v = jn5Var.v();
                    if (v && BearTimeoutTryShowSwitch.isOn()) {
                        StatisticItem param = StatisticItem.make(TbadkCoreStatisticKey.SHOW_AD_TIME).param("obj_source", (int) e(next)).param("obj_type", "a064").param(TiebaStatic.Params.OBJ_DURATION, System.currentTimeMillis()).param("obj_param1", 1).param(TiebaStatic.Params.OBJ_PARAM2, this.c ? 2 : 1).param(TiebaStatic.Params.SPLASH_UNI, this.d);
                        if (!StringUtils.isNull(next.c())) {
                            param.param(TiebaStatic.Params.OBJ_TO, next.c());
                        }
                        param.eventStat();
                        jn5Var.t();
                        return;
                    }
                    StatisticItem.make("fail_splash").param("obj_param1", v ? "1" : "0").eventStat();
                }
            }
            fm4 fm4Var = this.f;
            if (fm4Var != null) {
                fm4Var.b("");
            }
        }
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a : invokeV.intValue;
    }

    public final byte e(zn5 zn5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, zn5Var)) == null) {
            if (zn5Var == null) {
                return (byte) 0;
            }
            String f = zn5Var.f();
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

    public final synchronized void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this) {
                if (this.g.isEmpty()) {
                    kn5 kn5Var = new kn5(this.e);
                    jn5 jn5Var = new jn5(this.e);
                    this.g.clear();
                    if (ud5.w()) {
                        this.g.add(kn5Var);
                    }
                    if (ud5.q()) {
                        this.g.add(jn5Var);
                    }
                    if (ru4.k().h("key_is_jump_splash_ad", false)) {
                        h();
                        this.g.clear();
                    }
                }
            }
        }
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            Iterator<zn5> it = this.g.iterator();
            while (it.hasNext()) {
                zn5 next = it.next();
                if (next != null && next.b()) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void h() {
        UBCManager uBCManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)) == null) {
            return;
        }
        uBCManager.onEvent("5088");
    }

    public void i(int i) {
        fm4 fm4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i) == null) || (fm4Var = this.f) == null) {
            return;
        }
        fm4Var.a(i);
    }

    public void j(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.b = false;
            f();
            Iterator<zn5> it = this.g.iterator();
            while (it.hasNext()) {
                zn5 next = it.next();
                if (i == 5 && (next instanceof kn5)) {
                    if (!eo5.g()) {
                        next.a();
                        return;
                    }
                } else if (i == 6 && (next instanceof jn5)) {
                    Iterator<zn5> it2 = this.g.iterator();
                    while (it2.hasNext()) {
                        zn5 next2 = it2.next();
                        if (next2 instanceof kn5) {
                            StatisticItem statisticItem = new StatisticItem("preload_bear");
                            kn5 kn5Var = (kn5) next2;
                            statisticItem.param("obj_param1", kn5Var.v() ? "1" : "0");
                            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, kn5Var.w() ? "1" : "0");
                            TiebaStatic.log(statisticItem);
                        }
                    }
                    next.a();
                    return;
                }
            }
        }
    }

    public synchronized void k(im4 im4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, im4Var) == null) {
            synchronized (this) {
                this.b = false;
                this.d = im4Var.c();
                this.f = im4Var.a();
                this.c = im4Var.d();
                if (this.e != null) {
                    this.e.onSplashEvent(96);
                }
                f();
                do5.c();
                Iterator<zn5> it = this.g.iterator();
                while (it.hasNext()) {
                    zn5 next = it.next();
                    if (!(next instanceof kn5) || !eo5.g()) {
                        next.e(im4Var);
                    }
                }
            }
        }
    }

    public synchronized void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            synchronized (this) {
                if (this.b) {
                    return;
                }
                Iterator<zn5> it = this.g.iterator();
                while (it.hasNext()) {
                    zn5 next = it.next();
                    if (next != null) {
                        if ((z ? next instanceof jn5 : next instanceof kn5) && next.d() == AdLoadState.SUCCEED) {
                            this.b = true;
                            StatisticItem param = StatisticItem.make(TbadkCoreStatisticKey.SHOW_AD_TIME).param("obj_source", (int) e(next)).param("obj_type", "a064").param(TiebaStatic.Params.OBJ_DURATION, System.currentTimeMillis()).param(TiebaStatic.Params.OBJ_PARAM2, this.c ? 2 : 1).param(TiebaStatic.Params.SPLASH_UNI, this.d);
                            if (!StringUtils.isNull(next.c())) {
                                param.param(TiebaStatic.Params.OBJ_TO, next.c());
                            }
                            param.eventStat();
                            hn8.a(MainTabScheduleStrategy.UNSCHEDULE);
                            if (this.f != null) {
                                this.f.c(next instanceof kn5 ? ((kn5) next).k : null);
                            }
                            next.show();
                            if (this.f != null) {
                                this.f.d(String.valueOf((int) e(next)));
                            }
                            do5.d(String.valueOf((int) e(next)));
                            return;
                        }
                    }
                }
                if (this.f != null) {
                    this.f.b("");
                }
            }
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            SplashNativePolicy splashNativePolicy = this.e;
            if (splashNativePolicy == null) {
                SplashNativePolicy splashNativePolicy2 = new SplashNativePolicy();
                this.e = splashNativePolicy2;
                boolean initSplashPolicy = splashNativePolicy2.initSplashPolicy(ud5.u(), ud5.w(), ud5.v(), ud5.k(), ud5.l());
                PrintStream printStream = System.out;
                printStream.println("SplashPolicy init result = " + initSplashPolicy);
                if (initSplashPolicy) {
                    return;
                }
                this.e = null;
                return;
            }
            boolean updateSplashConfig = splashNativePolicy.updateSplashConfig(ud5.u(), ud5.w(), ud5.v(), ud5.k(), ud5.l());
            PrintStream printStream2 = System.out;
            printStream2.println("SplashPolicy update result = " + updateSplashConfig);
            if (updateSplashConfig) {
                return;
            }
            this.e = null;
        }
    }

    public void n(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, jSONObject) == null) {
            this.a = og.e(jSONObject.optString("ad_sdk_priority"), 0);
            ru4.k().w("splash_ad_strategy_key", this.a);
            ru4.k().w("splash_origin_ad_strategy_key", og.e(jSONObject.optString("ad_origin_config_switch"), 1));
            JSONObject optJSONObject = jSONObject.optJSONObject("screen_fill_data_result");
            if (optJSONObject != null) {
                int e = og.e(optJSONObject.optString("screen_fill_advertisement_first_switch", com.tencent.connect.common.Constants.DEFAULT_UIN), 1000);
                int e2 = og.e(optJSONObject.optString("screen_fill_advertisement_second_switch", "1400"), 1400);
                int e3 = og.e(optJSONObject.optString("screen_fill_advertisement_bear_switch", "1"), 1);
                int e4 = og.e(optJSONObject.optString("screen_fill_advertisement_plj_switch", "1"), 1);
                int e5 = og.e(optJSONObject.optString("screen_fill_advertisement_plj_cpc_switch", "1"), 1);
                ru4.k().w("key_splash_new_policy_bear_enable", e3);
                ru4.k().w("key_splash_new_policy_plg_enable", e4);
                ru4.k().w("key_splash_new_policy_plg_cpc_enable", e5);
                ru4.k().w("key_splash_new_policy_first_timeout", e);
                ru4.k().w("key_splash_new_policy_second_timeout", e2);
            }
            jn5.x(og.e(jSONObject.optString("bear_sid_type"), 0));
        }
    }
}
