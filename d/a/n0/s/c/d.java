package d.a.n0.s.c;

import com.yy.gslbsdk.db.ResultTB;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: c  reason: collision with root package name */
    public int f54215c;

    /* renamed from: d  reason: collision with root package name */
    public long f54216d;

    /* renamed from: e  reason: collision with root package name */
    public long f54217e;

    /* renamed from: f  reason: collision with root package name */
    public String f54218f;
    public String m;
    public boolean q;
    public String r;
    public String s;

    /* renamed from: a  reason: collision with root package name */
    public int f54213a = 1;

    /* renamed from: g  reason: collision with root package name */
    public int f54219g = 0;

    /* renamed from: h  reason: collision with root package name */
    public int f54220h = 1;

    /* renamed from: i  reason: collision with root package name */
    public int f54221i = 0;
    public int j = 0;
    public int k = 300;
    public int l = 1;
    public int n = 4;
    public int o = 4;
    public int p = 7;

    /* renamed from: b  reason: collision with root package name */
    public j f54214b = new j();

    public j a() {
        return this.f54214b;
    }

    public int b() {
        return this.k;
    }

    public String c() {
        return this.m;
    }

    public boolean d() {
        return this.f54220h == 1;
    }

    public boolean e() {
        return this.f54213a > 0;
    }

    public boolean f() {
        return this.f54219g == 1;
    }

    public boolean g() {
        return this.f54221i == 0;
    }

    public boolean h() {
        if (this.f54215c == 1) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            return this.f54216d < currentTimeMillis && currentTimeMillis < this.f54217e;
        }
        return false;
    }

    public boolean i() {
        return this.j == 1;
    }

    public String j() {
        return this.f54218f;
    }

    public void k(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return;
        }
        this.f54213a = jSONObject.optInt("als_control", 1);
        jSONObject.optInt("not_use_lego_patch", 0);
        this.f54220h = jSONObject.optInt("ad_video_not_autoplay", 1);
        this.j = jSONObject.optInt("lp_video_not_autoplay", 0);
        this.f54214b.a(jSONObject);
        JSONObject optJSONObject = jSONObject.optJSONObject("log_feed_control");
        if (optJSONObject != null) {
            this.f54215c = optJSONObject.optInt("log_feed_switch", 0);
            this.f54216d = optJSONObject.optLong("start_time", -1L);
            this.f54217e = optJSONObject.optLong(ResultTB.ENDTIME, -1L);
            this.f54218f = optJSONObject.optString("ext_info");
        }
        this.f54219g = jSONObject.optInt("ad_collect_switch", 0);
        JSONObject optJSONObject2 = jSONObject.optJSONObject("splash");
        if (optJSONObject2 != null) {
            this.k = optJSONObject2.optInt("interval", 300);
        }
        this.l = jSONObject.optInt("video_page_style", 1);
        d.a.n0.r.d0.b.j().v("video_page_style", this.l);
        this.f54221i = jSONObject.optInt("ad_download_lib", 0);
        JSONObject optJSONObject3 = jSONObject.optJSONObject("afd_sync_config");
        if (optJSONObject3 != null) {
            this.n = optJSONObject3.optInt("first_floor");
            this.o = optJSONObject3.optInt("prefetch_step");
            this.p = optJSONObject3.optInt("step");
        }
        JSONObject optJSONObject4 = jSONObject.optJSONObject("action_control");
        if (optJSONObject4 != null) {
            this.m = optJSONObject4.optString("url");
            optJSONObject4.optString("name");
            optJSONObject4.optString("text_color");
            optJSONObject4.optString("text_color_pressed");
        }
        this.q = jSONObject.optInt("afd_jump_pb") == 1;
        this.r = jSONObject.optString("afd_eid");
        JSONObject optJSONObject5 = jSONObject.optJSONObject("iadex_sniff_list_url");
        if (optJSONObject5 != null) {
            String optString = optJSONObject5.optString("os_type2_iadex_url");
            this.s = optString;
            d.a.n0.z0.d.i(optString);
            return;
        }
        d.a.n0.z0.d.i(null);
    }
}
