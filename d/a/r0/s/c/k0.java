package d.a.r0.s.c;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class k0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    public int B;
    public int C;
    public long D;
    public boolean E;
    public long F;
    public b G;
    public c0 H;
    public String I;
    public int J;
    public int K;
    public int L;
    public String M;
    public int N;
    public String O;
    public int P;
    public long Q;
    public long R;
    public boolean S;
    public e0 T;
    public String U;
    public boolean V;
    public String W;
    public String X;
    public String Y;
    public String Z;

    /* renamed from: a  reason: collision with root package name */
    public String f56399a;
    public int a0;

    /* renamed from: b  reason: collision with root package name */
    public String f56400b;
    public String b0;

    /* renamed from: c  reason: collision with root package name */
    public String f56401c;
    public String c0;

    /* renamed from: d  reason: collision with root package name */
    public String f56402d;
    public String d0;

    /* renamed from: e  reason: collision with root package name */
    public String f56403e;
    public String e0;

    /* renamed from: f  reason: collision with root package name */
    public String f56404f;
    public String f0;

    /* renamed from: g  reason: collision with root package name */
    public String f56405g;
    public String g0;

    /* renamed from: h  reason: collision with root package name */
    public String f56406h;
    public String h0;

    /* renamed from: i  reason: collision with root package name */
    public long f56407i;
    public String i0;
    public int j;
    public int j0;
    public long k;
    public HashMap<Long, String> k0;
    public int l;
    public String l0;
    public long m;
    public String m0;
    public int n;
    public int n0;
    public int o;
    public String p;
    public long q;
    public String r;
    public String s;
    public String t;
    public String u;
    public int v;
    public int w;
    public String x;
    public String y;
    public String z;

    public k0() {
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
        this.o = 0;
        this.v = 2;
        this.x = "";
        this.J = 0;
        this.K = 0;
        this.L = 0;
        this.N = 0;
        this.S = false;
        this.k0 = new HashMap<>();
    }

    public String A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.s : (String) invokeV.objValue;
    }

    public String B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.Y : (String) invokeV.objValue;
    }

    public String C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.Z : (String) invokeV.objValue;
    }

    public String D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.X : (String) invokeV.objValue;
    }

    public c0 E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.H : (c0) invokeV.objValue;
    }

    public long F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.D : invokeV.longValue;
    }

    public int G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.l : invokeV.intValue;
    }

    public String H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.z : (String) invokeV.objValue;
    }

    public long I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.m : invokeV.longValue;
    }

    public int J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.o : invokeV.intValue;
    }

    public String K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.W : (String) invokeV.objValue;
    }

    public int L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.C : invokeV.intValue;
    }

    public String M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.m0 : (String) invokeV.objValue;
    }

    public e0 N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.T : (e0) invokeV.objValue;
    }

    public String O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.U : (String) invokeV.objValue;
    }

    public int P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.J : invokeV.intValue;
    }

    public String Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f56405g : (String) invokeV.objValue;
    }

    public String R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.y : (String) invokeV.objValue;
    }

    public String S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.A : (String) invokeV.objValue;
    }

    public long T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f56407i : invokeV.longValue;
    }

    public int U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.n0 : invokeV.intValue;
    }

    public String V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.l0 : (String) invokeV.objValue;
    }

    public int W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.j : invokeV.intValue;
    }

    public boolean X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.V : invokeV.booleanValue;
    }

    public void Y(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048600, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        try {
            this.f56399a = jSONObject.optString("drop_pic");
            this.f56400b = jSONObject.optString("drop_pic_md5");
            this.f56401c = jSONObject.optString("drop_pic_num");
            this.f56402d = jSONObject.optString("drop_bg_color_day");
            this.f56403e = jSONObject.optString("drop_bg_color_night");
            this.f56404f = jSONObject.optString("apply_vip_live_room_pid");
            this.s = jSONObject.optString("max_cache");
            this.t = jSONObject.optString("frs_max_cache");
            this.u = jSONObject.optString("frs_pn");
            this.f56405g = jSONObject.optString("tail_link");
            this.f56406h = jSONObject.optString("bubble_link");
            this.f56407i = jSONObject.optLong("use_duration");
            this.j = jSONObject.optInt("xiaoying_time");
            this.k = jSONObject.optLong(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, 0L);
            this.A = jSONObject.optString("url_analyze_text");
            this.l = jSONObject.optInt("new_resign", 0);
            this.m = jSONObject.optLong("personalized_cache_seconds", 1800L);
            this.n = jSONObject.optInt("personalized_max_count", 300);
            this.p = jSONObject.optString("info_icon_url");
            this.q = jSONObject.optLong("info_time_stamp", 0L);
            this.r = jSONObject.optString("info_target_url");
            this.v = jSONObject.optInt("localvideo_open", 2);
            this.w = jSONObject.optInt("card_show_statistic", 200);
            this.x = jSONObject.optString("clean_smart_frs_cookie");
            d.a.r0.k0.e.b().f(jSONObject.optInt("statlog_path_max", 3));
            this.o = jSONObject.optInt("photo_cache_num", 60);
            this.y = jSONObject.optString("ueg_voice_warning");
            this.z = jSONObject.optString("nickname_activity_link");
            this.B = jSONObject.optInt("android_tab_show", 55);
            this.C = jSONObject.optInt("ribao_switch", 0);
            this.D = jSONObject.optLong("android_new_log_upload_interval", 0L);
            this.F = jSONObject.optLong("android_boss_new_log_upload_interval", 0L);
            this.E = jSONObject.optInt("android_pasteboard_delaytime", 0) == 1;
            d.a.r0.r.d0.b.j().t("KEY_ANDROID_PASTE_BOARD_DELAY_TIME", this.E);
            JSONObject optJSONObject = jSONObject.optJSONObject("laxin_config");
            if (optJSONObject != null) {
                b bVar = new b();
                this.G = bVar;
                bVar.i(optJSONObject);
                d.a.r0.r.d0.b j = d.a.r0.r.d0.b.j();
                j.x("activity_prize_data" + TbadkCoreApplication.getCurrentAccount(), optJSONObject.toString());
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("nani_video");
            if (optJSONObject2 != null) {
                c0 c0Var = new c0();
                this.H = c0Var;
                c0Var.a(optJSONObject2);
            }
            d.a.s0.i1.h.n.f(jSONObject.optInt("android_max_stranger"));
            this.J = jSONObject.optInt("style_ab_switch", 0);
            this.K = jSONObject.optInt("abstract_ab_switch", 0);
            this.I = jSONObject.optString("android_splash_video");
            d.a.r0.r.d0.b.j().x("key_video_splash_config", this.I);
            this.L = jSONObject.optInt("android_smart_frs_cache_time", -1);
            String optString = jSONObject.optString("shoubai_regex", "");
            this.M = optString;
            if (!d.a.c.e.p.k.isEmpty(optString)) {
                d.a.r0.r.d0.b.j().x("key_baidu_password_re", this.M);
            }
            String optString2 = jSONObject.optString("redpacket_pop", "");
            this.O = optString2;
            if (!d.a.c.e.p.k.isEmpty(optString2)) {
                d.a.r0.r.d0.b.j().x("key_redpacket_pop", this.O);
            }
            this.P = jSONObject.optInt("android_video_slide_guide_count", 0);
            d.a.r0.r.d0.b.j().v("key_video_guide_max_count", this.P);
            this.N = jSONObject.optInt("android_show_ba_concern", 0);
            d.a.r0.r.d0.b.j().v("key_concern_tab_tips_switch", this.N);
            this.Q = jSONObject.optInt("dialog_pull_time", 60) * StringHelper.MS_TO_MIN;
            this.R = jSONObject.optInt("android_dialog_lock_show_time", 300) * 1000;
            this.S = jSONObject.optInt("android_show_lock_perm_dialog", 0) == 1;
            String optString3 = jSONObject.optString("android_spring_shake", "");
            if (!StringUtils.isNull(optString3)) {
                if (this.T == null) {
                    this.T = new e0();
                }
                this.T.parserJson(optString3);
                d.a.r0.r.d0.b.j().x("shake_data", optString3);
            }
            this.U = jSONObject.optString("share_panel_text", "");
            d.a.r0.r.d0.b.j().v("key_personalized_refresh_type", jSONObject.optInt("personalized_refresh_type", 0));
            int optInt = jSONObject.optInt("audit_package_switch", 0);
            if (optInt == 0) {
                this.V = false;
            } else if (optInt == 1) {
                this.V = true;
            }
            d.a.r0.r.d0.b.j().t("audit_package_switch", this.V);
            this.W = jSONObject.optString("profile_swan_app_key");
            d.a.r0.r.d0.b.j().x("profile_swan_app_key", this.W);
            this.X = jSONObject.optString("android_mission_system_entrance_url");
            d.a.r0.r.d0.b.j().x("index_activity_abtest_url", this.X);
            this.Y = jSONObject.optString("android_mission_system_entrance_icon");
            d.a.r0.r.d0.b.j().x("index_activity_abtest_icon_url", this.Y);
            this.Z = jSONObject.optString("obj_source");
            d.a.r0.r.d0.b.j().x("index_activity_abtest_obj_source", this.Z);
            this.l0 = jSONObject.optString("duxiaoman_sign_link");
            this.a0 = jSONObject.optInt("home_page_style_ab_test", 0);
            d.a.r0.r.d0.b.j().v("index_activity_abtest_switch_json", this.a0);
            this.m0 = jSONObject.optString(TiebaStatic.Params.SAMPLE_ID);
            d.a.r0.r.d0.b j2 = d.a.r0.r.d0.b.j();
            j2.x("key_ubs_sample_id" + TbadkCoreApplication.getCurrentAccount(), this.m0);
            z.c(jSONObject.optString("js_whitelist"));
            d.a.r0.i0.e.f().j(jSONObject.optString("stat_keys_list"));
            long optLong = jSONObject.optLong("android_plugin_wait_time", 0L);
            if (optLong > 0) {
                d.a.r0.r.d0.b.j().w("plugin_wait_time", optLong);
            }
            this.b0 = jSONObject.optString("frs_new_live_tab_video_h5", "https://tieba.baidu.com/n/interact/video/game?");
            d.a.r0.r.d0.b.j().x("ala_game_frs_live_tab_video_url", this.b0);
            this.c0 = jSONObject.optString("ala_personal_income_detail_url", "https://tieba.baidu.com/mo/q/ala/getUserLives");
            d.a.r0.r.d0.b.j().x("ala_personal_income_detail_url", this.c0);
            this.d0 = jSONObject.optString("ala_personal_privilege_detail_url", "http://lumotian.rmb.rmb.otp.baidu.com/cashliveui/privilege.html");
            d.a.r0.r.d0.b.j().x("ala_personal_privilege_detail_url", this.d0);
            this.e0 = jSONObject.optString("ala_personal_exp_detail_url", "https://sv.baidu.com/cashliveui/userLevel.html#/level");
            d.a.r0.r.d0.b.j().x("ala_personal_exp_detail_url", this.e0);
            String optString4 = jSONObject.optString("showlive_forum");
            if (!StringUtils.isNull(optString4)) {
                JSONObject jSONObject2 = new JSONObject(optString4);
                this.f0 = jSONObject2.optString("go_url", "http://tieba.baidu.com/f?kw=百度直播");
                d.a.r0.r.d0.b.j().x("show_live_forum_url", this.f0);
                this.g0 = jSONObject2.optString("forum_name", "百度直播");
                d.a.r0.r.d0.b.j().x("show_live_forum_name", this.g0);
            }
            String optString5 = jSONObject.optString("user_live_mark_page");
            if (!StringUtils.isNull(optString5)) {
                JSONObject jSONObject3 = new JSONObject(optString5);
                this.h0 = jSONObject3.optString("mark_introduce_page", "http://ufanzhib0.baiduux.com/h5/xuzhangshuoming.html");
                this.i0 = jSONObject3.optString("effect_introduce_page", "http://ufanzhib0.baiduux.com/h5/jinchangtexiaoshuoming.html");
                d.a.r0.r.d0.b.j().x("ala_my_live_privilege_mark_detail_url", this.h0);
                d.a.r0.r.d0.b.j().x("ala_my_live_privilege_effect_detail_url", this.i0);
            }
            String optString6 = jSONObject.optString("credit_conf");
            if (!StringUtils.isNull(optString6)) {
                this.j0 = new JSONObject(optString6).optInt("ucenter_display");
                d.a.r0.r.d0.b.j().v("baidu_financial_display", this.j0);
            }
            String optString7 = jSONObject.optString("live_bar");
            Z(optString7);
            d.a.r0.r.d0.b.j().x("ala_live_bar_map_str", optString7);
            d.a.r0.r.d0.b.j().v("key_home_refresh_button_test", jSONObject.optInt("homepage_refresh_test"));
            d.a.r0.r.d0.b.j().v("key_is_show_shoubai_dynamic_guide", jSONObject.optInt("is_show_shoubai_dynamic_guide"));
            d.a.r0.r.d0.b.j().v("key_show_ala_friend_tab", jSONObject.optInt("live_dating_tab_switch"));
            d.a.r0.r.d0.b.j().t("key_show_vivo_badge", jSONObject.optInt("is_vivo_test_uid") == 1);
            this.n0 = jSONObject.optInt("video_red_icon_interval");
            new e().h(jSONObject);
            f0 f0Var = new f0();
            f0Var.e(jSONObject.optJSONObject("share_panel_conf"));
            TbSingleton.getInstance().setSharePanelConfData(f0Var);
            String optString8 = jSONObject.optString("BackMechanism_sid1");
            String optString9 = jSONObject.optString("BackMechanism_sid2");
            d.a.r0.r.d0.b.j().x("key_pb_back_sid1", optString8);
            d.a.r0.r.d0.b.j().x("key_pb_back_sid2", optString9);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void Z(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            if (StringUtils.isNull(str)) {
                str = d.a.r0.r.d0.b.j().p("ala_live_bar_map_str", "");
                if (StringUtils.isNull(str)) {
                    return;
                }
            }
            JSONArray jSONArray = null;
            try {
                jSONArray = new JSONArray(str);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            if (jSONArray == null || jSONArray.length() == 0) {
                return;
            }
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                if (optJSONObject != null) {
                    long optLong = optJSONObject.optLong("id", 0L);
                    this.k0.put(Long.valueOf(optLong), optJSONObject.optString("name"));
                }
            }
        }
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.S : invokeV.booleanValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.K : invokeV.intValue;
    }

    public b c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.G : (b) invokeV.objValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.E : invokeV.booleanValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.B : invokeV.intValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.f56404f : (String) invokeV.objValue;
    }

    public long g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.F : invokeV.longValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.f56406h : (String) invokeV.objValue;
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.x : (String) invokeV.objValue;
    }

    public long j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.Q : invokeV.longValue;
    }

    public long k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.R : invokeV.longValue;
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.f56402d : (String) invokeV.objValue;
    }

    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.f56403e : (String) invokeV.objValue;
    }

    public String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.f56399a : (String) invokeV.objValue;
    }

    public String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.f56400b : (String) invokeV.objValue;
    }

    public String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? this.f56401c : (String) invokeV.objValue;
    }

    public int q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? this.L : invokeV.intValue;
    }

    public String r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? this.t : (String) invokeV.objValue;
    }

    public String s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.u : (String) invokeV.objValue;
    }

    public long t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? this.k : invokeV.longValue;
    }

    public int u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.n : invokeV.intValue;
    }

    public String v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? this.p : (String) invokeV.objValue;
    }

    public String w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? this.r : (String) invokeV.objValue;
    }

    public long x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? this.q : invokeV.longValue;
    }

    public HashMap<Long, String> y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) ? this.k0 : (HashMap) invokeV.objValue;
    }

    public boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? this.v == 1 : invokeV.booleanValue;
    }
}
