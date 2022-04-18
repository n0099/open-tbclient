package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.download.center.clearcache.DiskManagerSharedPrefsUtils;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.ActivityPrizeData;
import com.baidu.tbadk.coreExtra.data.TiebaPlusConfigData;
import com.baidu.tbadk.coreExtra.data.VideoPreloadData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class ux4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    public String B;
    public String C;
    public int D;
    public int E;
    public long F;
    public boolean G;
    public long H;
    public ActivityPrizeData I;
    public jx4 J;
    public int K;
    public int L;
    public int M;
    public String N;
    public int O;
    public String P;
    public long Q;
    public long R;
    public boolean S;
    public lx4 T;
    public String U;
    public boolean V;
    public String W;
    public String X;
    public String Y;
    public String Z;
    public int a;
    public int a0;
    public int b;
    public String b0;
    public String c;
    public String c0;
    public String d;
    public String d0;
    public String e;
    public String e0;
    public String f;
    public String f0;
    public String g;
    public String g0;
    public String h;
    public String h0;
    public String i;
    public String i0;
    public String j;
    public int j0;
    public long k;
    public HashMap<Long, String> k0;
    public long l;
    public String l0;
    public int m;
    public String m0;
    public long n;
    public int n0;
    public int o;
    public final VideoPreloadData o0;
    public int p;
    public int p0;
    public int q;
    public fx4 q0;
    public String r;
    public int r0;
    public long s;
    public int s0;
    public String t;
    public int t0;
    public String u;
    public int u0;
    public String v;
    public int v0;
    public String w;
    public int w0;
    public int x;
    public int x0;
    public int y;
    public String z;

    public ux4() {
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
        this.q = 0;
        this.x = 2;
        this.z = "";
        this.K = 0;
        this.L = 0;
        this.M = 0;
        this.O = 0;
        this.S = false;
        this.k0 = new HashMap<>();
        this.o0 = new VideoPreloadData();
    }

    public fx4 A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.q0 : (fx4) invokeV.objValue;
    }

    public HashMap<Long, String> B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.k0 : (HashMap) invokeV.objValue;
    }

    public boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.x == 1 : invokeV.booleanValue;
    }

    public String D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.u : (String) invokeV.objValue;
    }

    public String E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.Y : (String) invokeV.objValue;
    }

    public String F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.Z : (String) invokeV.objValue;
    }

    public String G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.X : (String) invokeV.objValue;
    }

    public jx4 H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.J : (jx4) invokeV.objValue;
    }

    public long I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.F : invokeV.longValue;
    }

    public int J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.m : invokeV.intValue;
    }

    public String K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.B : (String) invokeV.objValue;
    }

    public int L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.p : invokeV.intValue;
    }

    public long M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.n : invokeV.longValue;
    }

    public int N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.q : invokeV.intValue;
    }

    public String O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.W : (String) invokeV.objValue;
    }

    public int P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.E : invokeV.intValue;
    }

    public String Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.m0 : (String) invokeV.objValue;
    }

    public lx4 R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.T : (lx4) invokeV.objValue;
    }

    public String S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.U : (String) invokeV.objValue;
    }

    public int T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.b : invokeV.intValue;
    }

    public int U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.K : invokeV.intValue;
    }

    public String V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.i : (String) invokeV.objValue;
    }

    public String W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.A : (String) invokeV.objValue;
    }

    public int X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.w0 : invokeV.intValue;
    }

    public int Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.v0 : invokeV.intValue;
    }

    public int Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.t0 : invokeV.intValue;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.S : invokeV.booleanValue;
    }

    public int a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.s0 : invokeV.intValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.L : invokeV.intValue;
    }

    public int b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.u0 : invokeV.intValue;
    }

    public ActivityPrizeData c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.I : (ActivityPrizeData) invokeV.objValue;
    }

    public String c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.C : (String) invokeV.objValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.G : invokeV.booleanValue;
    }

    public long d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.k : invokeV.longValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.D : invokeV.intValue;
    }

    public VideoPreloadData e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.o0 : (VideoPreloadData) invokeV.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.h : (String) invokeV.objValue;
    }

    public int f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.n0 : invokeV.intValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.x0 : invokeV.intValue;
    }

    public String g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.l0 : (String) invokeV.objValue;
    }

    public long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.H : invokeV.longValue;
    }

    public int h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? this.r0 : invokeV.intValue;
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? this.j : (String) invokeV.objValue;
    }

    public boolean i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? this.V : invokeV.booleanValue;
    }

    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.z : (String) invokeV.objValue;
    }

    public void j0(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048621, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        try {
            this.a = jSONObject.optInt("Android_perf_fps_duration");
            this.b = jSONObject.optInt("Android_start_stat_instant_upload");
            TbSingleton.getInstance().isStartStatUploadImmediately = this.b == 1;
            this.c = jSONObject.optString("drop_pic");
            this.d = jSONObject.optString("drop_pic_md5");
            this.e = jSONObject.optString("drop_pic_num");
            this.f = jSONObject.optString("drop_bg_color_day");
            this.g = jSONObject.optString("drop_bg_color_night");
            this.h = jSONObject.optString("apply_vip_live_room_pid");
            this.u = jSONObject.optString("max_cache");
            this.v = jSONObject.optString("frs_max_cache");
            this.w = jSONObject.optString("frs_pn");
            this.i = jSONObject.optString("tail_link");
            this.j = jSONObject.optString("bubble_link");
            this.k = jSONObject.optLong("use_duration");
            jSONObject.optInt("xiaoying_time");
            this.l = jSONObject.optLong(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, 0L);
            this.C = jSONObject.optString("url_analyze_text");
            this.m = jSONObject.optInt("new_resign", 0);
            this.n = jSONObject.optLong("personalized_cache_seconds", DiskManagerSharedPrefsUtils.DISK_CHECK_DURATION_DEFAULT);
            this.o = jSONObject.optInt("personalized_max_count", 300);
            this.p = jSONObject.optInt("index_preload_not_see_thread_num", 3);
            this.r = jSONObject.optString("info_icon_url");
            this.s = jSONObject.optLong("info_time_stamp", 0L);
            this.t = jSONObject.optString("info_target_url");
            this.x = jSONObject.optInt("localvideo_open", 2);
            this.y = jSONObject.optInt("card_show_statistic", 200);
            this.z = jSONObject.optString("clean_smart_frs_cookie");
            z75.b().h(jSONObject.optInt("statlog_path_max", 3));
            this.q = jSONObject.optInt("photo_cache_num", 60);
            this.A = jSONObject.optString("ueg_voice_warning");
            this.B = jSONObject.optString("nickname_activity_link");
            this.D = jSONObject.optInt("android_tab_show", 55);
            this.E = jSONObject.optInt("ribao_switch", 0);
            this.F = jSONObject.optLong("android_new_log_upload_interval", 0L);
            this.H = jSONObject.optLong("android_boss_new_log_upload_interval", 0L);
            this.G = jSONObject.optInt("android_pasteboard_delaytime", 0) == 1;
            this.o0.parserJson(jSONObject.optString("ios_video_preload_config"));
            vt4.k().u("KEY_ANDROID_PASTE_BOARD_DELAY_TIME", this.G);
            JSONObject optJSONObject = jSONObject.optJSONObject("laxin_config");
            if (optJSONObject != null) {
                ActivityPrizeData activityPrizeData = new ActivityPrizeData();
                this.I = activityPrizeData;
                activityPrizeData.parse(optJSONObject);
                vt4 k = vt4.k();
                k.y("activity_prize_data" + TbadkCoreApplication.getCurrentAccount(), optJSONObject.toString());
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("interest_board_config");
            if (optJSONObject2 != null) {
                fx4 fx4Var = new fx4();
                this.q0 = fx4Var;
                fx4Var.a(optJSONObject2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("nani_video");
            if (optJSONObject3 != null) {
                jx4 jx4Var = new jx4();
                this.J = jx4Var;
                jx4Var.a(optJSONObject3);
            }
            q67.f(jSONObject.optInt("android_max_stranger"));
            TiebaPlusConfigData tiebaPlusConfigData = new TiebaPlusConfigData();
            tiebaPlusConfigData.setSwitchOpen(jSONObject.optInt("switch_open") == 1);
            tiebaPlusConfigData.setJumpUrl(jSONObject.optString("tiebaplus_jumpurl"));
            TbSingleton.getInstance().setTiebaPlusConfigData(tiebaPlusConfigData);
            this.K = jSONObject.optInt("style_ab_switch", 0);
            this.L = jSONObject.optInt("abstract_ab_switch", 0);
            this.x0 = jSONObject.optInt("android_baiduid_forward_switch", 0);
            this.M = jSONObject.optInt("android_smart_frs_cache_time", -1);
            String optString = jSONObject.optString("shoubai_regex", "");
            this.N = optString;
            if (!ni.isEmpty(optString)) {
                vt4.k().y("key_baidu_password_re", this.N);
            }
            String optString2 = jSONObject.optString("redpacket_pop", "");
            this.P = optString2;
            if (!ni.isEmpty(optString2)) {
                vt4.k().y("key_redpacket_pop", this.P);
            }
            this.O = jSONObject.optInt("android_show_ba_concern", 0);
            vt4.k().w("key_concern_tab_tips_switch", this.O);
            this.Q = jSONObject.optInt("dialog_pull_time", 60) * StringHelper.MS_TO_MIN;
            this.R = jSONObject.optInt("android_dialog_lock_show_time", 300) * 1000;
            this.S = jSONObject.optInt("android_show_lock_perm_dialog", 0) == 1;
            String optString3 = jSONObject.optString("android_spring_shake", "");
            if (!StringUtils.isNull(optString3)) {
                if (this.T == null) {
                    this.T = new lx4();
                }
                this.T.parserJson(optString3);
                vt4.k().y("shake_data", optString3);
            }
            this.U = jSONObject.optString("share_panel_text", "");
            vt4.k().w("key_personalized_refresh_type", jSONObject.optInt("personalized_refresh_type", 0));
            int optInt = jSONObject.optInt("audit_package_switch", 0);
            if (optInt == 0) {
                this.V = false;
            } else if (optInt == 1) {
                this.V = true;
            }
            vt4.k().u("audit_package_switch", this.V);
            this.W = jSONObject.optString("profile_swan_app_key");
            vt4.k().y("profile_swan_app_key", this.W);
            this.X = jSONObject.optString("android_mission_system_entrance_url");
            vt4.k().y("index_activity_abtest_url", this.X);
            this.Y = jSONObject.optString("android_mission_system_entrance_icon");
            vt4.k().y("index_activity_abtest_icon_url", this.Y);
            this.Z = jSONObject.optString("obj_source");
            vt4.k().y("index_activity_abtest_obj_source", this.Z);
            this.l0 = jSONObject.optString("duxiaoman_sign_link");
            this.a0 = jSONObject.optInt("home_page_style_ab_test", 0);
            vt4.k().w("index_activity_abtest_switch_json", this.a0);
            this.m0 = jSONObject.optString(TiebaStatic.Params.SAMPLE_ID);
            vt4.k().y("key_ubs_sample_id", this.m0);
            gx4.c(jSONObject.optString("js_whitelist"));
            r75.f().j(jSONObject.optString("stat_keys_list"));
            this.b0 = jSONObject.optString("frs_new_live_tab_video_h5", "https://tieba.baidu.com/n/interact/video/game?");
            vt4.k().y("ala_game_frs_live_tab_video_url", this.b0);
            this.c0 = jSONObject.optString("ala_personal_income_detail_url", "https://tieba.baidu.com/mo/q/ala/getUserLives");
            vt4.k().y("ala_personal_income_detail_url", this.c0);
            this.d0 = jSONObject.optString("ala_personal_privilege_detail_url", "http://lumotian.rmb.rmb.otp.baidu.com/cashliveui/privilege.html");
            vt4.k().y("ala_personal_privilege_detail_url", this.d0);
            this.e0 = jSONObject.optString("ala_personal_exp_detail_url", "https://sv.baidu.com/cashliveui/userLevel.html#/level");
            vt4.k().y("ala_personal_exp_detail_url", this.e0);
            String optString4 = jSONObject.optString("showlive_forum");
            if (!StringUtils.isNull(optString4)) {
                JSONObject jSONObject2 = new JSONObject(optString4);
                this.f0 = jSONObject2.optString("go_url", "http://tieba.baidu.com/f?kw=百度直播");
                vt4.k().y("show_live_forum_url", this.f0);
                this.g0 = jSONObject2.optString("forum_name", "百度直播");
                vt4.k().y("show_live_forum_name", this.g0);
            }
            String optString5 = jSONObject.optString("user_live_mark_page");
            if (!StringUtils.isNull(optString5)) {
                JSONObject jSONObject3 = new JSONObject(optString5);
                this.h0 = jSONObject3.optString("mark_introduce_page", "http://ufanzhib0.baiduux.com/h5/xuzhangshuoming.html");
                this.i0 = jSONObject3.optString("effect_introduce_page", "http://ufanzhib0.baiduux.com/h5/jinchangtexiaoshuoming.html");
                vt4.k().y("ala_my_live_privilege_mark_detail_url", this.h0);
                vt4.k().y("ala_my_live_privilege_effect_detail_url", this.i0);
            }
            String optString6 = jSONObject.optString("credit_conf");
            if (!StringUtils.isNull(optString6)) {
                this.j0 = new JSONObject(optString6).optInt("ucenter_display");
                vt4.k().w("baidu_financial_display", this.j0);
            }
            String optString7 = jSONObject.optString("live_bar");
            k0(optString7);
            vt4.k().y("ala_live_bar_map_str", optString7);
            vt4.k().w("key_home_refresh_button_test", jSONObject.optInt("homepage_refresh_test"));
            vt4.k().w("key_is_show_shoubai_dynamic_guide", jSONObject.optInt("is_show_shoubai_dynamic_guide"));
            vt4.k().w("key_show_ala_friend_tab", jSONObject.optInt("live_dating_tab_switch"));
            vt4.k().u("key_show_vivo_badge", jSONObject.optInt("is_vivo_test_uid") == 1);
            this.n0 = jSONObject.optInt("video_red_icon_interval");
            new iw4().n(jSONObject);
            mx4 mx4Var = new mx4();
            mx4Var.e(jSONObject.optJSONObject("share_panel_conf"));
            TbSingleton.getInstance().setSharePanelConfData(mx4Var);
            String optString8 = jSONObject.optString("BackMechanism_sid1");
            String optString9 = jSONObject.optString("BackMechanism_sid2");
            vt4.k().y("key_pb_back_sid1", optString8);
            vt4.k().y("key_pb_back_sid2", optString9);
            this.p0 = jSONObject.optInt("video_works_progress_bar_waiting_time");
            vt4.k().w("key_video_works_progress_bar_waiting_time", this.p0);
            this.r0 = jSONObject.optInt("works_add_topic_max_num");
            this.s0 = jSONObject.optInt("thread_image_width_limit");
            this.t0 = jSONObject.optInt("thread_image_height_limit");
            this.u0 = jSONObject.optInt("image_upload_concurrency");
            this.v0 = jSONObject.optInt("image_chunk_size");
            this.w0 = jSONObject.optInt("image_upload_retry");
            vt4.k().x("key_splash_timeout_config", jSONObject.optLong("android_splash_timeout", 2000L));
            int optInt2 = jSONObject.optInt("launch_protect_onelevel_limit");
            if (optInt2 > 0) {
                vt4.k().w("key_first_level_safe_mode_continuous_crash_time", optInt2);
            }
            int optInt3 = jSONObject.optInt("launch_protect_twolevel_limit");
            if (optInt3 > 0) {
                vt4.k().w("key_second_level_safe_mode_continuous_crash_time", optInt3);
            }
            vt4.k().y("key_sync_task_switch", jSONObject.optString("android_sync_task_switch"));
            int optInt4 = jSONObject.optInt("video_ad_play_flag", 0);
            if (optInt4 == 1 || optInt4 == 2 || optInt4 == 3) {
                vt4.k().w("auto_play_video_switch", optInt4);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public long k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.Q : invokeV.longValue;
    }

    public final void k0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, str) == null) {
            if (StringUtils.isNull(str)) {
                str = vt4.k().q("ala_live_bar_map_str", "");
                if (StringUtils.isNull(str)) {
                    return;
                }
            }
            JSONArray jSONArray = null;
            try {
                jSONArray = new JSONArray(str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (jSONArray == null || jSONArray.length() == 0) {
                return;
            }
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    long optLong = optJSONObject.optLong("id", 0L);
                    this.k0.put(Long.valueOf(optLong), optJSONObject.optString("name"));
                }
            }
        }
    }

    public long l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? this.R : invokeV.longValue;
    }

    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? this.f : (String) invokeV.objValue;
    }

    public String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) ? this.g : (String) invokeV.objValue;
    }

    public String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? this.c : (String) invokeV.objValue;
    }

    public String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) ? this.d : (String) invokeV.objValue;
    }

    public String q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) ? this.e : (String) invokeV.objValue;
    }

    public int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) ? this.a : invokeV.intValue;
    }

    public int s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) ? this.M : invokeV.intValue;
    }

    public String t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) ? this.v : (String) invokeV.objValue;
    }

    public String u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) ? this.w : (String) invokeV.objValue;
    }

    public long v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) ? this.l : invokeV.longValue;
    }

    public int w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) ? this.o : invokeV.intValue;
    }

    public String x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) ? this.r : (String) invokeV.objValue;
    }

    public String y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) ? this.t : (String) invokeV.objValue;
    }

    public long z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) ? this.s : invokeV.longValue;
    }
}
