package com.repackage;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestDataManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LowFlowsActivityConfig;
import com.baidu.tbadk.core.util.CommonHelper;
import com.baidu.tbadk.core.util.UrlSchemaJumpHelper;
import com.baidu.tbadk.coreExtra.data.ABTestExtraData;
import com.baidu.tbadk.coreExtra.data.CombineDownload;
import com.baidu.tbadk.coreExtra.data.NewGodData;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tbadk.coreExtra.data.WhiteListData;
import com.baidu.tbadk.data.UserGrowthTaskListData;
import com.baidu.tbadk.dynamicres.data.AgreeMaterial;
import com.baidu.tieba.interest.InterestPanelShowManager;
import com.baidu.tieba.interest.data.RecentClientInfo;
import com.baidu.tieba.wallet.YYLiveConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class tz4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NewGodData A;
    public ly4 B;
    public rx4 C;
    public jy4 D;
    public ky4 E;
    public yx4 F;
    public UserGrowthTaskListData G;
    public VersionData a;
    public dy4 b;
    public ey4 c;
    public String d;
    public CombineDownload e;
    public qy4 f;
    public ez4 g;
    public sx4 h;
    public nx4 i;
    public px4 j;
    public iy4 k;
    public final mx4 l;
    public sy4 m;
    public int n;
    public int o;
    public int p;
    public int q;
    public fy4 r;
    public lx4 s;
    public ABTestExtraData t;
    public JSONArray u;
    public JSONArray v;
    public JSONArray w;
    public JSONObject x;
    public YYLiveConfig y;
    public h39 z;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(tz4 tz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tz4Var};
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
                s65.d().g();
            }
        }
    }

    public tz4() {
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
        this.o = 0;
        this.a = new VersionData();
        this.b = new dy4();
        this.c = new ey4();
        this.e = new CombineDownload();
        this.f = new qy4();
        this.g = new ez4();
        this.r = new fy4();
        this.h = new sx4();
        this.i = new nx4();
        this.l = new mx4();
        this.s = new lx4();
        this.m = new sy4();
        this.t = new ABTestExtraData();
        this.A = new NewGodData();
        this.B = new ly4();
        this.j = new px4();
        this.k = new iy4();
        this.C = new rx4();
        this.D = new jy4();
        this.E = new ky4();
        this.F = new yx4();
    }

    public void A(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            try {
                B(new JSONObject(str));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void B(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONObject jSONObject2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        try {
            TbSingleton.getInstance().setVoiceRoomConfig(cz4.b(jSONObject));
            TbSingleton.getInstance().setUpgradePopWindowConfig(yy4.j(jSONObject));
            TbSingleton.getInstance().setPushStrategyConfig(ty4.e(jSONObject));
            TbSingleton.getInstance().setHomePageLuckyConfig(g15.j(jSONObject));
            this.B.a(y(jSONObject, "index_tab_info"));
            this.a.parserJson(jSONObject.optJSONObject("version"));
            this.b.b(jSONObject.optJSONObject("client"));
            CommonHelper.setIp(jSONObject.optString("client_ip", null));
            ch.g(jSONObject.optString("client_ip", null));
            this.c.f(jSONObject.optJSONObject("config"));
            this.g.f0(jSONObject.optJSONObject("wl_config"));
            TbSingleton.getInstance().setWlConfigData(this.g);
            jSONObject.optJSONObject("channel_icon_config");
            this.j.c(jSONObject.optJSONObject("floating_icon"));
            TbSingleton.getInstance().setAdFloatViewData(this.j);
            this.k.d(jSONObject.optJSONObject("home_screen_ad"));
            TbSingleton.getInstance().setHomeInsertAdData(this.k);
            this.E.c(jSONObject.optJSONObject("https_switch_strategy_info"));
            TbadkCoreApplication.getInst().setHttpsWhileData(this.E);
            f15 f15Var = new f15();
            f15Var.d(jSONObject);
            if (f15Var.c()) {
                TbSingleton.getInstance().setHomeOperateData(f15Var);
            }
            String optString = jSONObject.optString("new_god_data", "");
            if (!StringUtils.isNull(optString)) {
                this.A.parserJson(optString);
            }
            this.r.c(jSONObject.optJSONObject("consume_path"));
            TbadkCoreApplication.getInst().setConsumePathData(this.r);
            this.d = jSONObject.optString("config_version");
            this.o = jSONObject.optInt("is_uninterest");
            this.p = jSONObject.optInt("first_time_motivate");
            this.q = jSONObject.optInt("needNewUserLead");
            this.e.parserJson(jSONObject.optJSONObject("combine_download"));
            this.f.a(jSONObject.optJSONObject("mainbar"));
            jSONObject.optInt(TbConfig.SYNC_ACTIVE, 0);
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001141, jSONObject));
            this.n = jSONObject.optInt("faceshop_version");
            if (this.n > TbadkCoreApplication.getInst().getFaceShopVersion()) {
                TbadkCoreApplication.getInst().setTempFaceShopVersion(this.n);
                TbadkCoreApplication.getInst().setFaceShopNew(true);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("lcs_strategy");
            if (optJSONObject2 != null) {
                TbadkCoreApplication.getInst().setLcsSwitchStratgy(optJSONObject2.toString());
            }
            new rz4().c(jSONObject.optJSONObject("dis_adv_config"));
            WhiteListData whiteListData = new WhiteListData();
            whiteListData.saveJson(jSONObject.optJSONArray("whitelist"));
            TbSingleton.getInstance().setHostWhiteList(whiteListData);
            tx4.c(jSONObject.optJSONArray("scheme_whitelist"));
            UrlSchemaJumpHelper.setBlackList(y(jSONObject, UrlSchemaJumpHelper.KEY_APP_JUMP_BLACK_LIST));
            this.h.a(jSONObject.optJSONObject("app_entrance"));
            this.i.g(jSONObject.optJSONObject("ad_adsense"));
            vz4.d(jSONObject.optJSONObject("video_report_config"));
            this.l.b(jSONObject.optJSONObject("activity_switch"));
            this.s.b(z(jSONObject, "abtest_config"));
            this.t.parseJson(z(jSONObject, "new_abtest_entra"));
            this.u = y(jSONObject, "new_abtest_config");
            this.v = y(jSONObject, UbsABTestDataManager.PREF_KEY_SWITCHS);
            y(jSONObject, "outside_callback_icon");
            this.w = jSONObject.optJSONArray("windowStrategyList");
            this.x = z(jSONObject, "bear_sdk_config");
            if (z(jSONObject, "advertisement_config") != null) {
                this.C.d(z(jSONObject, "advertisement_config"));
            }
            YYLiveConfig yYLiveConfig = new YYLiveConfig();
            this.y = yYLiveConfig;
            yYLiveConfig.parseJson(z(jSONObject, "yy_live_config"));
            h39 h39Var = new h39();
            this.z = h39Var;
            h39Var.b(y(jSONObject, "yy_live_tab"));
            co4.b().f(this.w);
            this.m.d(jSONObject.optJSONObject("profile_icon"));
            TbSingleton.getInstance().setNewUser(jSONObject.optInt("recommend_userstatus", 0) == 1);
            ru4.k().u("key_live_forum_enter_switch", jSONObject.optInt("ala_channel_white", 0) == 1);
            TbSingleton.getInstance().setPcdnConfigData(jSONObject.optJSONObject("pcdn_config"));
            JSONArray y = y(jSONObject, "offpack");
            if (y != null && y.length() > 0 && (jSONObject2 = y.getJSONObject(0)) != null) {
                ab8 ab8Var = new ab8();
                ab8Var.e(jSONObject2.optString("mod_name"));
                ab8Var.f(jSONObject2.optInt("upload_offline_web_cache") == 1);
                ab8Var.d(jSONObject2.optInt("clear_offline_web_cache") == 1);
                if (!TextUtils.isEmpty(ab8Var.a())) {
                    TbSingleton.getInstance().setUploadAndClearModule(ab8Var);
                }
            }
            String optString2 = jSONObject.optString("proxy_ip");
            String optString3 = jSONObject.optString("proxy_port");
            TbadkCoreApplication.getInst().setProxyIp(optString2);
            TbadkCoreApplication.getInst().setProxyPort(optString3);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("ad_sdk_priority", jSONObject.optString("ad_sdk_priority", null));
            jSONObject3.put("12_20_0_screen_fill_Ad_experiment", jSONObject.optString("12_20_0_screen_fill_Ad_experiment", null));
            jSONObject3.put("ad_origin_config_switch", jSONObject.optString("ad_origin_config_switch", null));
            jSONObject3.put("bear_sid_type", jSONObject.optString("bear_sid_type", null));
            jSONObject3.put("screen_fill_data_result", jSONObject.optJSONObject("screen_fill_data_result"));
            int optInt = jSONObject.optInt("ad_num_competition_frs", 5);
            int optInt2 = jSONObject.optInt("ad_num_competition_personalize", 2);
            ru4.k().w("key_mix_frs_ad_count", optInt);
            ru4.k().w("key_mix_home_page_ad_count", optInt2);
            MessageManager.getInstance().runTask(2016552, null, jSONObject3);
            TbSingleton.getInstance().setSyncYYSwitch(jSONObject.optInt("is_yy_user", 1) == 1);
            JSONObject optJSONObject3 = jSONObject.optJSONObject(LowFlowsActivityConfig.LF_USER_INFO);
            if (optJSONObject3 != null) {
                String optString4 = optJSONObject3.optString(LowFlowsActivityConfig.LF_USER);
                TbSingleton.getInstance().setLFUser(optString4);
                if (!StringUtils.isNull(optString4) && "2".equals(optString4)) {
                    TbSingleton.getInstance().setLFUserTaskId(optJSONObject3.optString(LowFlowsActivityConfig.LF_USER_TASKID));
                    TbSingleton.getInstance().setBannerText(optJSONObject3.optString(LowFlowsActivityConfig.LF_BANNER_TEXT));
                }
            }
            ru4.k().w("key_personalized_rec_switch", jSONObject.optInt("personalized_rec_switch"));
            JSONObject z = z(jSONObject, "homepage_interest_config");
            if (z != null && this.D != null) {
                this.D.e(z);
                TbSingleton.getInstance().setHomepageInterestConfig(this.D);
            }
            md7 md7Var = new md7();
            JSONObject optJSONObject4 = jSONObject.optJSONObject("recent_client_info");
            if (optJSONObject4 != null) {
                md7Var.d(RecentClientInfo.parseJson(optJSONObject4));
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject("new_user_interest_board_config");
            if (optJSONObject5 != null) {
                md7Var.c(kd7.e(optJSONObject5));
            }
            InterestPanelShowManager.a().c(md7Var);
            JSONObject optJSONObject6 = jSONObject.optJSONObject("bottom_bubble_config");
            if (optJSONObject6 != null) {
                s65.d().h(optJSONObject6);
                rg.a().post(new a(this));
            }
            ru4.k().w("key_work_video_guide_pop", jSONObject.optInt("videoup_guide_pop", -1));
            TbSingleton.getInstance().setVideoEventsConfig(bz4.e(jSONObject));
            ru4.k().y("key_sync_extra_field", jSONObject.optString("extra"));
            int optInt3 = jSONObject.optInt("icon_task_flag");
            TbSingleton.getInstance().showStampMissionDialog = optInt3 == 1;
            ee8.d().h(jSONObject.optInt("afSearch_tab", 0) == 1);
            TbSingleton.getInstance().setIsNeedRemindLiveRoom(jSONObject.optInt("is_need_remind_live_rooms") == 1);
            JSONObject optJSONObject7 = jSONObject.optJSONObject("search_guide");
            js7.b().a();
            if (optJSONObject7 != null && (optJSONObject = optJSONObject7.optJSONObject("pb")) != null) {
                boolean z2 = optJSONObject.optInt("is_show", 0) == 1;
                int optInt4 = optJSONObject.optInt("pos", -1);
                kt7 kt7Var = new kt7();
                kt7Var.a = z2;
                kt7Var.b = optInt4;
                js7.b().d(kt7Var);
            }
            g25.g().a(AgreeMaterial.B(jSONObject.optJSONObject("agree_material")));
            JSONObject optJSONObject8 = jSONObject.optJSONObject("live_activity_guide");
            if (optJSONObject8 != null) {
                i15 i15Var = new i15();
                i15Var.f(optJSONObject8);
                TbSingleton.getInstance().mLiveActivityGuide = i15Var;
            } else {
                TbSingleton.getInstance().mLiveActivityGuide = null;
            }
            this.F.h(jSONObject.optJSONObject("bear_sid_config"));
            C();
            TbSingleton.getInstance().setColourHeaderConfig(c15.r(jSONObject));
            ul5.e().k(jSONObject.optJSONObject("member_guide"));
            ul5.e().j(jSONObject.optJSONObject("close_ad_tips"));
            UserGrowthTaskListData userGrowthTaskListData = (UserGrowthTaskListData) new Gson().fromJson(jSONObject.optString("user_growth_task_list"), (Class<Object>) UserGrowthTaskListData.class);
            TbSingleton.getInstance().setUserGrowthTaskListData(userGrowthTaskListData);
            this.G = userGrowthTaskListData;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.F == null) {
            return;
        }
        ru4.k().y("key_server_splash_bear_sid", this.F.f());
        ru4.k().y("key_server_homepage_bear_sid", this.F.b());
        ru4.k().y("key_server_frs_bear_sid", this.F.a());
        ru4.k().y("key_server_pb_banner_bear_sid", this.F.c());
        ru4.k().y("key_server_pb_comment_bear_sid", this.F.d());
        ru4.k().y("key_server_picpage_bear_sid", this.F.e());
        ru4.k().y("key_server_videoflow_bear_sid", this.F.g());
    }

    public lx4 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.s : (lx4) invokeV.objValue;
    }

    public ABTestExtraData b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.t : (ABTestExtraData) invokeV.objValue;
    }

    public JSONArray c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.u : (JSONArray) invokeV.objValue;
    }

    public mx4 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.l : (mx4) invokeV.objValue;
    }

    public nx4 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.i : (nx4) invokeV.objValue;
    }

    public px4 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.j : (px4) invokeV.objValue;
    }

    public rx4 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.C : (rx4) invokeV.objValue;
    }

    public sx4 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.h : (sx4) invokeV.objValue;
    }

    public dy4 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.b : (dy4) invokeV.objValue;
    }

    public CombineDownload j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.e : (CombineDownload) invokeV.objValue;
    }

    public ey4 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.c : (ey4) invokeV.objValue;
    }

    public JSONObject l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.x : (JSONObject) invokeV.objValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.p == 1 : invokeV.booleanValue;
    }

    public int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.q : invokeV.intValue;
    }

    public int o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.o : invokeV.intValue;
    }

    public NewGodData p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.A : (NewGodData) invokeV.objValue;
    }

    public sy4 q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.m : (sy4) invokeV.objValue;
    }

    public JSONArray r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.v : (JSONArray) invokeV.objValue;
    }

    public UserGrowthTaskListData s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.G : (UserGrowthTaskListData) invokeV.objValue;
    }

    public VersionData t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.a : (VersionData) invokeV.objValue;
    }

    public ez4 u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.g : (ez4) invokeV.objValue;
    }

    public YYLiveConfig v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.y : (YYLiveConfig) invokeV.objValue;
    }

    public h39 w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.z : (h39) invokeV.objValue;
    }

    public String x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.d : (String) invokeV.objValue;
    }

    public final JSONArray y(JSONObject jSONObject, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048603, this, jSONObject, str)) == null) {
            try {
                return jSONObject.optJSONArray(str);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return null;
            }
        }
        return (JSONArray) invokeLL.objValue;
    }

    public final JSONObject z(JSONObject jSONObject, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048604, this, jSONObject, str)) == null) {
            try {
                return jSONObject.optJSONObject(str);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return null;
            }
        }
        return (JSONObject) invokeLL.objValue;
    }
}
