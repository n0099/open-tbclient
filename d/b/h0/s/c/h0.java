package d.b.h0.s.c;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class h0 {
    public String A;
    public int B;
    public int C;
    public long D;
    public boolean E;
    public long F;
    public b G;
    public z H;
    public String I;
    public String M;
    public String O;
    public int P;
    public long Q;
    public long R;
    public b0 T;
    public String U;
    public boolean V;
    public String W;
    public String X;
    public String Y;
    public String Z;

    /* renamed from: a  reason: collision with root package name */
    public String f51174a;
    public int a0;

    /* renamed from: b  reason: collision with root package name */
    public String f51175b;
    public String b0;

    /* renamed from: c  reason: collision with root package name */
    public String f51176c;
    public String c0;

    /* renamed from: d  reason: collision with root package name */
    public String f51177d;
    public String d0;

    /* renamed from: e  reason: collision with root package name */
    public String f51178e;
    public String e0;

    /* renamed from: f  reason: collision with root package name */
    public String f51179f;
    public String f0;

    /* renamed from: g  reason: collision with root package name */
    public String f51180g;
    public String g0;

    /* renamed from: h  reason: collision with root package name */
    public String f51181h;
    public String h0;
    public long i;
    public String i0;
    public int j;
    public int j0;
    public long k;
    public int l;
    public String l0;
    public long m;
    public String m0;
    public int n;
    public String p;
    public long q;
    public String r;
    public String s;
    public String t;
    public String u;
    public int w;
    public String y;
    public String z;
    public int o = 0;
    public int v = 2;
    public String x = "";
    public int J = 0;
    public int K = 0;
    public int L = 0;
    public int N = 0;
    public boolean S = false;
    public HashMap<Long, String> k0 = new HashMap<>();

    public String A() {
        return this.s;
    }

    public String B() {
        return this.Y;
    }

    public String C() {
        return this.Z;
    }

    public String D() {
        return this.X;
    }

    public z E() {
        return this.H;
    }

    public long F() {
        return this.D;
    }

    public int G() {
        return this.l;
    }

    public String H() {
        return this.z;
    }

    public long I() {
        return this.m;
    }

    public int J() {
        return this.o;
    }

    public String K() {
        return this.W;
    }

    public int L() {
        return this.C;
    }

    public String M() {
        return this.m0;
    }

    public b0 N() {
        return this.T;
    }

    public String O() {
        return this.U;
    }

    public int P() {
        return this.J;
    }

    public String Q() {
        return this.f51180g;
    }

    public String R() {
        return this.y;
    }

    public String S() {
        return this.A;
    }

    public long T() {
        return this.i;
    }

    public String U() {
        return this.l0;
    }

    public int V() {
        return this.j;
    }

    public boolean W() {
        return this.V;
    }

    public void X(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.f51174a = jSONObject.optString("drop_pic");
            this.f51175b = jSONObject.optString("drop_pic_md5");
            this.f51176c = jSONObject.optString("drop_pic_num");
            this.f51177d = jSONObject.optString("drop_bg_color_day");
            this.f51178e = jSONObject.optString("drop_bg_color_night");
            this.f51179f = jSONObject.optString("apply_vip_live_room_pid");
            this.s = jSONObject.optString("max_cache");
            this.t = jSONObject.optString("frs_max_cache");
            this.u = jSONObject.optString("frs_pn");
            this.f51180g = jSONObject.optString("tail_link");
            this.f51181h = jSONObject.optString("bubble_link");
            this.i = jSONObject.optLong("use_duration");
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
            d.b.h0.k0.e.b().f(jSONObject.optInt("statlog_path_max", 3));
            this.o = jSONObject.optInt("photo_cache_num", 60);
            this.y = jSONObject.optString("ueg_voice_warning");
            this.z = jSONObject.optString("nickname_activity_link");
            this.B = jSONObject.optInt("android_tab_show", 55);
            this.C = jSONObject.optInt("ribao_switch", 0);
            this.D = jSONObject.optLong("android_new_log_upload_interval", 0L);
            this.F = jSONObject.optLong("android_boss_new_log_upload_interval", 0L);
            this.E = jSONObject.optInt("android_pasteboard_delaytime", 0) == 1;
            d.b.h0.r.d0.b.i().s("KEY_ANDROID_PASTE_BOARD_DELAY_TIME", this.E);
            JSONObject optJSONObject = jSONObject.optJSONObject("laxin_config");
            if (optJSONObject != null) {
                b bVar = new b();
                this.G = bVar;
                bVar.i(optJSONObject);
                d.b.h0.r.d0.b i = d.b.h0.r.d0.b.i();
                i.w("activity_prize_data" + TbadkCoreApplication.getCurrentAccount(), optJSONObject.toString());
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("nani_video");
            if (optJSONObject2 != null) {
                z zVar = new z();
                this.H = zVar;
                zVar.a(optJSONObject2);
            }
            d.b.i0.d1.h.n.f(jSONObject.optInt("android_max_stranger"));
            this.J = jSONObject.optInt("style_ab_switch", 0);
            this.K = jSONObject.optInt("abstract_ab_switch", 0);
            this.I = jSONObject.optString("android_splash_video");
            d.b.h0.r.d0.b.i().w("key_video_splash_config", this.I);
            this.L = jSONObject.optInt("android_smart_frs_cache_time", -1);
            String optString = jSONObject.optString("shoubai_regex", "");
            this.M = optString;
            if (!d.b.b.e.p.k.isEmpty(optString)) {
                d.b.h0.r.d0.b.i().w("key_baidu_password_re", this.M);
            }
            String optString2 = jSONObject.optString("redpacket_pop", "");
            this.O = optString2;
            if (!d.b.b.e.p.k.isEmpty(optString2)) {
                d.b.h0.r.d0.b.i().w("key_redpacket_pop", this.O);
            }
            this.P = jSONObject.optInt("android_video_slide_guide_count", 0);
            d.b.h0.r.d0.b.i().u("key_video_guide_max_count", this.P);
            this.N = jSONObject.optInt("android_show_ba_concern", 0);
            d.b.h0.r.d0.b.i().u("key_concern_tab_tips_switch", this.N);
            this.Q = jSONObject.optInt("dialog_pull_time", 60) * StringHelper.MS_TO_MIN;
            this.R = jSONObject.optInt("android_dialog_lock_show_time", 300) * 1000;
            this.S = jSONObject.optInt("android_show_lock_perm_dialog", 0) == 1;
            String optString3 = jSONObject.optString("android_spring_shake", "");
            if (!StringUtils.isNull(optString3)) {
                if (this.T == null) {
                    this.T = new b0();
                }
                this.T.parserJson(optString3);
                d.b.h0.r.d0.b.i().w("shake_data", optString3);
            }
            this.U = jSONObject.optString("share_panel_text", "");
            d.b.h0.r.d0.b.i().u("key_personalized_refresh_type", jSONObject.optInt("personalized_refresh_type", 0));
            int optInt = jSONObject.optInt("audit_package_switch", 1);
            if (optInt == 0) {
                this.V = false;
            } else if (optInt == 1) {
                this.V = true;
            }
            d.b.h0.r.d0.b.i().s("person_center_show_lite_game", this.V);
            this.W = jSONObject.optString("profile_swan_app_key");
            d.b.h0.r.d0.b.i().w("profile_swan_app_key", this.W);
            this.X = jSONObject.optString("android_mission_system_entrance_url");
            d.b.h0.r.d0.b.i().w("index_activity_abtest_url", this.X);
            this.Y = jSONObject.optString("android_mission_system_entrance_icon");
            d.b.h0.r.d0.b.i().w("index_activity_abtest_icon_url", this.Y);
            this.Z = jSONObject.optString("obj_source");
            d.b.h0.r.d0.b.i().w("index_activity_abtest_obj_source", this.Z);
            this.l0 = jSONObject.optString("duxiaoman_sign_link");
            this.a0 = jSONObject.optInt("home_page_style_ab_test", 0);
            d.b.h0.r.d0.b.i().u("index_activity_abtest_switch_json", this.a0);
            this.m0 = jSONObject.optString(TiebaStatic.Params.SAMPLE_ID);
            d.b.h0.r.d0.b i2 = d.b.h0.r.d0.b.i();
            i2.w("key_ubs_sample_id" + TbadkCoreApplication.getCurrentAccount(), this.m0);
            w.c(jSONObject.optString("js_whitelist"));
            d.b.h0.i0.e.f().j(jSONObject.optString("stat_keys_list"));
            long optLong = jSONObject.optLong("android_plugin_wait_time", 0L);
            if (optLong > 0) {
                d.b.h0.r.d0.b.i().v("plugin_wait_time", optLong);
            }
            this.b0 = jSONObject.optString("frs_new_live_tab_video_h5", "https://tieba.baidu.com/n/interact/video/game?");
            d.b.h0.r.d0.b.i().w("ala_game_frs_live_tab_video_url", this.b0);
            this.c0 = jSONObject.optString("ala_personal_income_detail_url", "https://tieba.baidu.com/mo/q/ala/getUserLives");
            d.b.h0.r.d0.b.i().w("ala_personal_income_detail_url", this.c0);
            this.d0 = jSONObject.optString("ala_personal_privilege_detail_url", "http://lumotian.rmb.rmb.otp.baidu.com/cashliveui/privilege.html");
            d.b.h0.r.d0.b.i().w("ala_personal_privilege_detail_url", this.d0);
            this.e0 = jSONObject.optString("ala_personal_exp_detail_url", "https://sv.baidu.com/cashliveui/userLevel.html#/level");
            d.b.h0.r.d0.b.i().w("ala_personal_exp_detail_url", this.e0);
            String optString4 = jSONObject.optString("showlive_forum");
            if (!StringUtils.isNull(optString4)) {
                JSONObject jSONObject2 = new JSONObject(optString4);
                this.f0 = jSONObject2.optString("go_url", "http://tieba.baidu.com/f?kw=百度直播");
                d.b.h0.r.d0.b.i().w("show_live_forum_url", this.f0);
                this.g0 = jSONObject2.optString("forum_name", "百度直播");
                d.b.h0.r.d0.b.i().w("show_live_forum_name", this.g0);
            }
            String optString5 = jSONObject.optString("user_live_mark_page");
            if (!StringUtils.isNull(optString5)) {
                JSONObject jSONObject3 = new JSONObject(optString5);
                this.h0 = jSONObject3.optString("mark_introduce_page", "http://ufanzhib0.baiduux.com/h5/xuzhangshuoming.html");
                this.i0 = jSONObject3.optString("effect_introduce_page", "http://ufanzhib0.baiduux.com/h5/jinchangtexiaoshuoming.html");
                d.b.h0.r.d0.b.i().w("ala_my_live_privilege_mark_detail_url", this.h0);
                d.b.h0.r.d0.b.i().w("ala_my_live_privilege_effect_detail_url", this.i0);
            }
            String optString6 = jSONObject.optString("credit_conf");
            if (!StringUtils.isNull(optString6)) {
                this.j0 = new JSONObject(optString6).optInt("ucenter_display");
                d.b.h0.r.d0.b.i().u("baidu_financial_display", this.j0);
            }
            String optString7 = jSONObject.optString("live_bar");
            Y(optString7);
            d.b.h0.r.d0.b.i().w("ala_live_bar_map_str", optString7);
            d.b.h0.r.d0.b.i().u("key_home_refresh_button_test", jSONObject.optInt("homepage_refresh_test"));
            d.b.h0.r.d0.b.i().u("key_is_show_shoubai_dynamic_guide", jSONObject.optInt("is_show_shoubai_dynamic_guide"));
            d.b.h0.r.d0.b.i().u("chushou_game_tab", jSONObject.optInt("chushou_game_tab_new"));
            d.b.h0.r.d0.b.i().u("key_show_ala_friend_tab", jSONObject.optInt("live_dating_tab_switch"));
            d.b.h0.r.d0.b.i().s("key_show_vivo_badge", jSONObject.optInt("is_vivo_test_uid") == 1);
            new e().c(jSONObject);
            c0 c0Var = new c0();
            c0Var.e(jSONObject.optJSONObject("share_panel_conf"));
            TbSingleton.getInstance().setSharePanelConfData(c0Var);
            String optString8 = jSONObject.optString("BackMechanism_sid1");
            String optString9 = jSONObject.optString("BackMechanism_sid2");
            d.b.h0.r.d0.b.i().w("key_pb_back_sid1", optString8);
            d.b.h0.r.d0.b.i().w("key_pb_back_sid2", optString9);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void Y(String str) {
        if (StringUtils.isNull(str)) {
            str = d.b.h0.r.d0.b.i().o("ala_live_bar_map_str", "");
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
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                long optLong = optJSONObject.optLong("id", 0L);
                this.k0.put(Long.valueOf(optLong), optJSONObject.optString("name"));
            }
        }
    }

    public boolean a() {
        return this.S;
    }

    public int b() {
        return this.K;
    }

    public b c() {
        return this.G;
    }

    public boolean d() {
        return this.E;
    }

    public int e() {
        return this.B;
    }

    public String f() {
        return this.f51179f;
    }

    public long g() {
        return this.F;
    }

    public String h() {
        return this.f51181h;
    }

    public String i() {
        return this.x;
    }

    public long j() {
        return this.Q;
    }

    public long k() {
        return this.R;
    }

    public String l() {
        return this.f51177d;
    }

    public String m() {
        return this.f51178e;
    }

    public String n() {
        return this.f51174a;
    }

    public String o() {
        return this.f51175b;
    }

    public String p() {
        return this.f51176c;
    }

    public int q() {
        return this.L;
    }

    public String r() {
        return this.t;
    }

    public String s() {
        return this.u;
    }

    public long t() {
        return this.k;
    }

    public int u() {
        return this.n;
    }

    public String v() {
        return this.p;
    }

    public String w() {
        return this.r;
    }

    public long x() {
        return this.q;
    }

    public HashMap<Long, String> y() {
        return this.k0;
    }

    public boolean z() {
        return this.v == 1;
    }
}
