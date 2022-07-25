package com.repackage;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.updateprocessor.UpdateCloudControlProcessor;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestDataManager;
import com.baidu.tbadk.abtest.UsbAbTestConst;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LowFlowsActivityConfig;
import com.baidu.tbadk.core.util.CommonHelper;
import com.baidu.tbadk.core.util.UrlSchemaJumpHelper;
import com.baidu.tbadk.coreExtra.data.ABTestExtraData;
import com.baidu.tbadk.coreExtra.data.CombineDownload;
import com.baidu.tbadk.coreExtra.data.NewGodData;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tbadk.coreExtra.data.WhiteListData;
import com.baidu.tbadk.dynamicres.data.AgreeMaterial;
import com.baidu.tieba.interest.InterestPanelShowManager;
import com.baidu.tieba.interest.data.RecentClientInfo;
import com.baidu.tieba.wallet.YYLiveConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class yy4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NewGodData A;
    public rx4 B;
    public xw4 C;
    public px4 D;
    public qx4 E;
    public ex4 F;
    public VersionData a;
    public jx4 b;
    public kx4 c;
    public String d;
    public CombineDownload e;
    public wx4 f;
    public ky4 g;
    public yw4 h;
    public tw4 i;
    public vw4 j;
    public ox4 k;
    public final sw4 l;
    public yx4 m;
    public int n;
    public int o;
    public int p;
    public int q;
    public lx4 r;
    public rw4 s;
    public ABTestExtraData t;
    public JSONArray u;
    public JSONArray v;
    public JSONArray w;
    public JSONObject x;
    public YYLiveConfig y;
    public m09 z;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(yy4 yy4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yy4Var};
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
                w55.d().g();
            }
        }
    }

    public yy4() {
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
        this.b = new jx4();
        this.c = new kx4();
        this.e = new CombineDownload();
        this.f = new wx4();
        this.g = new ky4();
        this.r = new lx4();
        this.h = new yw4();
        this.i = new tw4();
        this.l = new sw4();
        this.s = new rw4();
        this.m = new yx4();
        this.t = new ABTestExtraData();
        this.A = new NewGodData();
        this.B = new rx4();
        this.j = new vw4();
        this.k = new ox4();
        this.C = new xw4();
        this.D = new px4();
        this.E = new qx4();
        this.F = new ex4();
    }

    public void A(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONObject jSONObject2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        try {
            TbSingleton.getInstance().setVoiceRoomConfig(iy4.b(jSONObject));
            TbSingleton.getInstance().setUpgradePopWindowConfig(ey4.j(jSONObject));
            TbSingleton.getInstance().setPushStrategyConfig(zx4.e(jSONObject));
            TbSingleton.getInstance().setHomePageLuckyConfig(l05.j(jSONObject));
            this.B.a(x(jSONObject, "index_tab_info"));
            this.a.parserJson(jSONObject.optJSONObject("version"));
            this.b.b(jSONObject.optJSONObject("client"));
            CommonHelper.setIp(jSONObject.optString("client_ip", null));
            bh.g(jSONObject.optString("client_ip", null));
            this.c.f(jSONObject.optJSONObject(UpdateCloudControlProcessor.CLOUD_UPDATE_ACTION_NAME));
            this.g.f0(jSONObject.optJSONObject("wl_config"));
            TbSingleton.getInstance().setWlConfigData(this.g);
            jSONObject.optJSONObject("channel_icon_config");
            this.j.c(jSONObject.optJSONObject("floating_icon"));
            TbSingleton.getInstance().setAdFloatViewData(this.j);
            this.k.d(jSONObject.optJSONObject("home_screen_ad"));
            TbSingleton.getInstance().setHomeInsertAdData(this.k);
            this.E.c(jSONObject.optJSONObject("https_switch_strategy_info"));
            TbadkCoreApplication.getInst().setHttpsWhileData(this.E);
            k05 k05Var = new k05();
            k05Var.d(jSONObject);
            if (k05Var.c()) {
                TbSingleton.getInstance().setHomeOperateData(k05Var);
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
            new wy4().c(jSONObject.optJSONObject("dis_adv_config"));
            WhiteListData whiteListData = new WhiteListData();
            whiteListData.saveJson(jSONObject.optJSONArray("whitelist"));
            TbSingleton.getInstance().setHostWhiteList(whiteListData);
            zw4.c(jSONObject.optJSONArray("scheme_whitelist"));
            UrlSchemaJumpHelper.setBlackList(x(jSONObject, UrlSchemaJumpHelper.KEY_APP_JUMP_BLACK_LIST));
            this.h.a(jSONObject.optJSONObject("app_entrance"));
            this.i.g(jSONObject.optJSONObject("ad_adsense"));
            az4.d(jSONObject.optJSONObject("video_report_config"));
            this.l.b(jSONObject.optJSONObject("activity_switch"));
            this.s.b(y(jSONObject, "abtest_config"));
            this.t.parseJson(y(jSONObject, "new_abtest_entra"));
            this.u = x(jSONObject, "new_abtest_config");
            this.v = x(jSONObject, UbsABTestDataManager.PREF_KEY_SWITCHS);
            x(jSONObject, "outside_callback_icon");
            this.w = jSONObject.optJSONArray("windowStrategyList");
            this.x = y(jSONObject, "bear_sdk_config");
            if (y(jSONObject, "advertisement_config") != null) {
                this.C.d(y(jSONObject, "advertisement_config"));
            }
            YYLiveConfig yYLiveConfig = new YYLiveConfig();
            this.y = yYLiveConfig;
            yYLiveConfig.parseJson(y(jSONObject, "yy_live_config"));
            m09 m09Var = new m09();
            this.z = m09Var;
            m09Var.b(x(jSONObject, "yy_live_tab"));
            ln4.b().f(this.w);
            this.m.d(jSONObject.optJSONObject("profile_icon"));
            TbSingleton.getInstance().setNewUser(jSONObject.optInt("recommend_userstatus", 0) == 1);
            yt4.k().u("key_live_forum_enter_switch", jSONObject.optInt("ala_channel_white", 0) == 1);
            TbSingleton.getInstance().setPcdnConfigData(jSONObject.optJSONObject("pcdn_config"));
            JSONArray x = x(jSONObject, "offpack");
            if (x != null && x.length() > 0 && (jSONObject2 = x.getJSONObject(0)) != null) {
                t88 t88Var = new t88();
                t88Var.e(jSONObject2.optString("mod_name"));
                t88Var.f(jSONObject2.optInt("upload_offline_web_cache") == 1);
                t88Var.d(jSONObject2.optInt("clear_offline_web_cache") == 1);
                if (!TextUtils.isEmpty(t88Var.a())) {
                    TbSingleton.getInstance().setUploadAndClearModule(t88Var);
                }
            }
            String optString2 = jSONObject.optString("proxy_ip");
            String optString3 = jSONObject.optString("proxy_port");
            TbadkCoreApplication.getInst().setProxyIp(optString2);
            TbadkCoreApplication.getInst().setProxyPort(optString3);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("ad_sdk_priority", jSONObject.optString("ad_sdk_priority", null));
            jSONObject3.put(UsbAbTestConst.KEY_NEW_SPLASH_POLICY, jSONObject.optString(UsbAbTestConst.KEY_NEW_SPLASH_POLICY, null));
            jSONObject3.put("ad_origin_config_switch", jSONObject.optString("ad_origin_config_switch", null));
            jSONObject3.put("bear_sid_type", jSONObject.optString("bear_sid_type", null));
            jSONObject3.put("screen_fill_data_result", jSONObject.optJSONObject("screen_fill_data_result"));
            int optInt = jSONObject.optInt("ad_num_competition_frs", 5);
            int optInt2 = jSONObject.optInt("ad_num_competition_personalize", 2);
            yt4.k().w("key_mix_frs_ad_count", optInt);
            yt4.k().w("key_mix_home_page_ad_count", optInt2);
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
            yt4.k().w("key_personalized_rec_switch", jSONObject.optInt("personalized_rec_switch"));
            JSONObject y = y(jSONObject, "homepage_interest_config");
            if (y != null && this.D != null) {
                this.D.e(y);
                TbSingleton.getInstance().setHomepageInterestConfig(this.D);
            }
            rb7 rb7Var = new rb7();
            JSONObject optJSONObject4 = jSONObject.optJSONObject("recent_client_info");
            if (optJSONObject4 != null) {
                rb7Var.d(RecentClientInfo.parseJson(optJSONObject4));
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject("new_user_interest_board_config");
            if (optJSONObject5 != null) {
                rb7Var.c(pb7.e(optJSONObject5));
            }
            InterestPanelShowManager.a().c(rb7Var);
            JSONObject optJSONObject6 = jSONObject.optJSONObject("bottom_bubble_config");
            if (optJSONObject6 != null) {
                w55.d().h(optJSONObject6);
                qg.a().post(new a(this));
            }
            yt4.k().w("key_work_video_guide_pop", jSONObject.optInt("videoup_guide_pop", -1));
            TbSingleton.getInstance().setVideoEventsConfig(hy4.e(jSONObject));
            yt4.k().y("key_sync_extra_field", jSONObject.optString("extra"));
            int optInt3 = jSONObject.optInt("icon_task_flag");
            TbSingleton.getInstance().showStampMissionDialog = optInt3 == 1;
            ub8.d().h(jSONObject.optInt("afSearch_tab", 0) == 1);
            TbSingleton.getInstance().setIsNeedRemindLiveRoom(jSONObject.optInt("is_need_remind_live_rooms") == 1);
            JSONObject optJSONObject7 = jSONObject.optJSONObject("search_guide");
            oq7.b().a();
            if (optJSONObject7 != null && (optJSONObject = optJSONObject7.optJSONObject("pb")) != null) {
                boolean z = optJSONObject.optInt("is_show", 0) == 1;
                int optInt4 = optJSONObject.optInt("pos", -1);
                or7 or7Var = new or7();
                or7Var.a = z;
                or7Var.b = optInt4;
                oq7.b().d(or7Var);
            }
            j15.g().a(AgreeMaterial.C(jSONObject.optJSONObject("agree_material")));
            JSONObject optJSONObject8 = jSONObject.optJSONObject("live_activity_guide");
            if (optJSONObject8 != null) {
                n05 n05Var = new n05();
                n05Var.f(optJSONObject8);
                TbSingleton.getInstance().mLiveActivityGuide = n05Var;
            } else {
                TbSingleton.getInstance().mLiveActivityGuide = null;
            }
            this.F.h(jSONObject.optJSONObject("bear_sid_config"));
            B();
            TbSingleton.getInstance().setColourHeaderConfig(h05.r(jSONObject));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.F == null) {
            return;
        }
        yt4.k().y("key_server_splash_bear_sid", this.F.f());
        yt4.k().y("key_server_homepage_bear_sid", this.F.b());
        yt4.k().y("key_server_frs_bear_sid", this.F.a());
        yt4.k().y("key_server_pb_banner_bear_sid", this.F.c());
        yt4.k().y("key_server_pb_comment_bear_sid", this.F.d());
        yt4.k().y("key_server_picpage_bear_sid", this.F.e());
        yt4.k().y("key_server_videoflow_bear_sid", this.F.g());
    }

    public rw4 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.s : (rw4) invokeV.objValue;
    }

    public ABTestExtraData b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.t : (ABTestExtraData) invokeV.objValue;
    }

    public JSONArray c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.u : (JSONArray) invokeV.objValue;
    }

    public sw4 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.l : (sw4) invokeV.objValue;
    }

    public tw4 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.i : (tw4) invokeV.objValue;
    }

    public vw4 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.j : (vw4) invokeV.objValue;
    }

    public xw4 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.C : (xw4) invokeV.objValue;
    }

    public yw4 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.h : (yw4) invokeV.objValue;
    }

    public jx4 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.b : (jx4) invokeV.objValue;
    }

    public CombineDownload j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.e : (CombineDownload) invokeV.objValue;
    }

    public kx4 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.c : (kx4) invokeV.objValue;
    }

    public JSONObject l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.x : (JSONObject) invokeV.objValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.p == 1 : invokeV.booleanValue;
    }

    public int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.q : invokeV.intValue;
    }

    public int o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.o : invokeV.intValue;
    }

    public NewGodData p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.A : (NewGodData) invokeV.objValue;
    }

    public yx4 q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.m : (yx4) invokeV.objValue;
    }

    public JSONArray r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.v : (JSONArray) invokeV.objValue;
    }

    public VersionData s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.a : (VersionData) invokeV.objValue;
    }

    public ky4 t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.g : (ky4) invokeV.objValue;
    }

    public YYLiveConfig u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.y : (YYLiveConfig) invokeV.objValue;
    }

    public m09 v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.z : (m09) invokeV.objValue;
    }

    public String w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.d : (String) invokeV.objValue;
    }

    public final JSONArray x(JSONObject jSONObject, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048601, this, jSONObject, str)) == null) {
            try {
                return jSONObject.optJSONArray(str);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return null;
            }
        }
        return (JSONArray) invokeLL.objValue;
    }

    public final JSONObject y(JSONObject jSONObject, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048602, this, jSONObject, str)) == null) {
            try {
                return jSONObject.optJSONObject(str);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return null;
            }
        }
        return (JSONObject) invokeLL.objValue;
    }

    public void z(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, str) == null) {
            try {
                A(new JSONObject(str));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
