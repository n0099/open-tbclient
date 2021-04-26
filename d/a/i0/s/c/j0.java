package d.a.i0.s.c;

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
public class j0 {
    public String A;
    public int B;
    public int C;
    public long D;
    public boolean E;
    public long F;
    public b G;
    public b0 H;
    public String I;
    public String M;
    public String O;
    public int P;
    public long Q;
    public long R;
    public d0 T;
    public String U;
    public boolean V;
    public String W;
    public String X;
    public String Y;
    public String Z;

    /* renamed from: a  reason: collision with root package name */
    public String f49589a;
    public int a0;

    /* renamed from: b  reason: collision with root package name */
    public String f49590b;
    public String b0;

    /* renamed from: c  reason: collision with root package name */
    public String f49591c;
    public String c0;

    /* renamed from: d  reason: collision with root package name */
    public String f49592d;
    public String d0;

    /* renamed from: e  reason: collision with root package name */
    public String f49593e;
    public String e0;

    /* renamed from: f  reason: collision with root package name */
    public String f49594f;
    public String f0;

    /* renamed from: g  reason: collision with root package name */
    public String f49595g;
    public String g0;

    /* renamed from: h  reason: collision with root package name */
    public String f49596h;
    public String h0;

    /* renamed from: i  reason: collision with root package name */
    public long f49597i;
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

    public b0 E() {
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

    public d0 N() {
        return this.T;
    }

    public String O() {
        return this.U;
    }

    public int P() {
        return this.J;
    }

    public String Q() {
        return this.f49595g;
    }

    public String R() {
        return this.y;
    }

    public String S() {
        return this.A;
    }

    public long T() {
        return this.f49597i;
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
            this.f49589a = jSONObject.optString("drop_pic");
            this.f49590b = jSONObject.optString("drop_pic_md5");
            this.f49591c = jSONObject.optString("drop_pic_num");
            this.f49592d = jSONObject.optString("drop_bg_color_day");
            this.f49593e = jSONObject.optString("drop_bg_color_night");
            this.f49594f = jSONObject.optString("apply_vip_live_room_pid");
            this.s = jSONObject.optString("max_cache");
            this.t = jSONObject.optString("frs_max_cache");
            this.u = jSONObject.optString("frs_pn");
            this.f49595g = jSONObject.optString("tail_link");
            this.f49596h = jSONObject.optString("bubble_link");
            this.f49597i = jSONObject.optLong("use_duration");
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
            d.a.i0.k0.e.b().f(jSONObject.optInt("statlog_path_max", 3));
            this.o = jSONObject.optInt("photo_cache_num", 60);
            this.y = jSONObject.optString("ueg_voice_warning");
            this.z = jSONObject.optString("nickname_activity_link");
            this.B = jSONObject.optInt("android_tab_show", 55);
            this.C = jSONObject.optInt("ribao_switch", 0);
            this.D = jSONObject.optLong("android_new_log_upload_interval", 0L);
            this.F = jSONObject.optLong("android_boss_new_log_upload_interval", 0L);
            this.E = jSONObject.optInt("android_pasteboard_delaytime", 0) == 1;
            d.a.i0.r.d0.b.j().t("KEY_ANDROID_PASTE_BOARD_DELAY_TIME", this.E);
            JSONObject optJSONObject = jSONObject.optJSONObject("laxin_config");
            if (optJSONObject != null) {
                b bVar = new b();
                this.G = bVar;
                bVar.i(optJSONObject);
                d.a.i0.r.d0.b j = d.a.i0.r.d0.b.j();
                j.x("activity_prize_data" + TbadkCoreApplication.getCurrentAccount(), optJSONObject.toString());
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("nani_video");
            if (optJSONObject2 != null) {
                b0 b0Var = new b0();
                this.H = b0Var;
                b0Var.a(optJSONObject2);
            }
            d.a.j0.e1.h.n.f(jSONObject.optInt("android_max_stranger"));
            this.J = jSONObject.optInt("style_ab_switch", 0);
            this.K = jSONObject.optInt("abstract_ab_switch", 0);
            this.I = jSONObject.optString("android_splash_video");
            d.a.i0.r.d0.b.j().x("key_video_splash_config", this.I);
            this.L = jSONObject.optInt("android_smart_frs_cache_time", -1);
            String optString = jSONObject.optString("shoubai_regex", "");
            this.M = optString;
            if (!d.a.c.e.p.k.isEmpty(optString)) {
                d.a.i0.r.d0.b.j().x("key_baidu_password_re", this.M);
            }
            String optString2 = jSONObject.optString("redpacket_pop", "");
            this.O = optString2;
            if (!d.a.c.e.p.k.isEmpty(optString2)) {
                d.a.i0.r.d0.b.j().x("key_redpacket_pop", this.O);
            }
            this.P = jSONObject.optInt("android_video_slide_guide_count", 0);
            d.a.i0.r.d0.b.j().v("key_video_guide_max_count", this.P);
            this.N = jSONObject.optInt("android_show_ba_concern", 0);
            d.a.i0.r.d0.b.j().v("key_concern_tab_tips_switch", this.N);
            this.Q = jSONObject.optInt("dialog_pull_time", 60) * StringHelper.MS_TO_MIN;
            this.R = jSONObject.optInt("android_dialog_lock_show_time", 300) * 1000;
            this.S = jSONObject.optInt("android_show_lock_perm_dialog", 0) == 1;
            String optString3 = jSONObject.optString("android_spring_shake", "");
            if (!StringUtils.isNull(optString3)) {
                if (this.T == null) {
                    this.T = new d0();
                }
                this.T.parserJson(optString3);
                d.a.i0.r.d0.b.j().x("shake_data", optString3);
            }
            this.U = jSONObject.optString("share_panel_text", "");
            d.a.i0.r.d0.b.j().v("key_personalized_refresh_type", jSONObject.optInt("personalized_refresh_type", 0));
            int optInt = jSONObject.optInt("audit_package_switch", 0);
            if (optInt == 0) {
                this.V = false;
            } else if (optInt == 1) {
                this.V = true;
            }
            d.a.i0.r.d0.b.j().t("audit_package_switch", this.V);
            this.W = jSONObject.optString("profile_swan_app_key");
            d.a.i0.r.d0.b.j().x("profile_swan_app_key", this.W);
            this.X = jSONObject.optString("android_mission_system_entrance_url");
            d.a.i0.r.d0.b.j().x("index_activity_abtest_url", this.X);
            this.Y = jSONObject.optString("android_mission_system_entrance_icon");
            d.a.i0.r.d0.b.j().x("index_activity_abtest_icon_url", this.Y);
            this.Z = jSONObject.optString("obj_source");
            d.a.i0.r.d0.b.j().x("index_activity_abtest_obj_source", this.Z);
            this.l0 = jSONObject.optString("duxiaoman_sign_link");
            this.a0 = jSONObject.optInt("home_page_style_ab_test", 0);
            d.a.i0.r.d0.b.j().v("index_activity_abtest_switch_json", this.a0);
            this.m0 = jSONObject.optString(TiebaStatic.Params.SAMPLE_ID);
            d.a.i0.r.d0.b j2 = d.a.i0.r.d0.b.j();
            j2.x("key_ubs_sample_id" + TbadkCoreApplication.getCurrentAccount(), this.m0);
            y.c(jSONObject.optString("js_whitelist"));
            d.a.i0.i0.e.f().j(jSONObject.optString("stat_keys_list"));
            long optLong = jSONObject.optLong("android_plugin_wait_time", 0L);
            if (optLong > 0) {
                d.a.i0.r.d0.b.j().w("plugin_wait_time", optLong);
            }
            this.b0 = jSONObject.optString("frs_new_live_tab_video_h5", "https://tieba.baidu.com/n/interact/video/game?");
            d.a.i0.r.d0.b.j().x("ala_game_frs_live_tab_video_url", this.b0);
            this.c0 = jSONObject.optString("ala_personal_income_detail_url", "https://tieba.baidu.com/mo/q/ala/getUserLives");
            d.a.i0.r.d0.b.j().x("ala_personal_income_detail_url", this.c0);
            this.d0 = jSONObject.optString("ala_personal_privilege_detail_url", "http://lumotian.rmb.rmb.otp.baidu.com/cashliveui/privilege.html");
            d.a.i0.r.d0.b.j().x("ala_personal_privilege_detail_url", this.d0);
            this.e0 = jSONObject.optString("ala_personal_exp_detail_url", "https://sv.baidu.com/cashliveui/userLevel.html#/level");
            d.a.i0.r.d0.b.j().x("ala_personal_exp_detail_url", this.e0);
            String optString4 = jSONObject.optString("showlive_forum");
            if (!StringUtils.isNull(optString4)) {
                JSONObject jSONObject2 = new JSONObject(optString4);
                this.f0 = jSONObject2.optString("go_url", "http://tieba.baidu.com/f?kw=百度直播");
                d.a.i0.r.d0.b.j().x("show_live_forum_url", this.f0);
                this.g0 = jSONObject2.optString("forum_name", "百度直播");
                d.a.i0.r.d0.b.j().x("show_live_forum_name", this.g0);
            }
            String optString5 = jSONObject.optString("user_live_mark_page");
            if (!StringUtils.isNull(optString5)) {
                JSONObject jSONObject3 = new JSONObject(optString5);
                this.h0 = jSONObject3.optString("mark_introduce_page", "http://ufanzhib0.baiduux.com/h5/xuzhangshuoming.html");
                this.i0 = jSONObject3.optString("effect_introduce_page", "http://ufanzhib0.baiduux.com/h5/jinchangtexiaoshuoming.html");
                d.a.i0.r.d0.b.j().x("ala_my_live_privilege_mark_detail_url", this.h0);
                d.a.i0.r.d0.b.j().x("ala_my_live_privilege_effect_detail_url", this.i0);
            }
            String optString6 = jSONObject.optString("credit_conf");
            if (!StringUtils.isNull(optString6)) {
                this.j0 = new JSONObject(optString6).optInt("ucenter_display");
                d.a.i0.r.d0.b.j().v("baidu_financial_display", this.j0);
            }
            String optString7 = jSONObject.optString("live_bar");
            Y(optString7);
            d.a.i0.r.d0.b.j().x("ala_live_bar_map_str", optString7);
            d.a.i0.r.d0.b.j().v("key_home_refresh_button_test", jSONObject.optInt("homepage_refresh_test"));
            d.a.i0.r.d0.b.j().v("key_is_show_shoubai_dynamic_guide", jSONObject.optInt("is_show_shoubai_dynamic_guide"));
            d.a.i0.r.d0.b.j().v("key_show_ala_friend_tab", jSONObject.optInt("live_dating_tab_switch"));
            d.a.i0.r.d0.b.j().t("key_show_vivo_badge", jSONObject.optInt("is_vivo_test_uid") == 1);
            new e().f(jSONObject);
            e0 e0Var = new e0();
            e0Var.e(jSONObject.optJSONObject("share_panel_conf"));
            TbSingleton.getInstance().setSharePanelConfData(e0Var);
            String optString8 = jSONObject.optString("BackMechanism_sid1");
            String optString9 = jSONObject.optString("BackMechanism_sid2");
            d.a.i0.r.d0.b.j().x("key_pb_back_sid1", optString8);
            d.a.i0.r.d0.b.j().x("key_pb_back_sid2", optString9);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void Y(String str) {
        if (StringUtils.isNull(str)) {
            str = d.a.i0.r.d0.b.j().p("ala_live_bar_map_str", "");
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
        return this.f49594f;
    }

    public long g() {
        return this.F;
    }

    public String h() {
        return this.f49596h;
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
        return this.f49592d;
    }

    public String m() {
        return this.f49593e;
    }

    public String n() {
        return this.f49589a;
    }

    public String o() {
        return this.f49590b;
    }

    public String p() {
        return this.f49591c;
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
