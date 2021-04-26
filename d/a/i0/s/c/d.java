package d.a.i0.s.c;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: c  reason: collision with root package name */
    public int f49549c;

    /* renamed from: d  reason: collision with root package name */
    public long f49550d;

    /* renamed from: e  reason: collision with root package name */
    public long f49551e;

    /* renamed from: f  reason: collision with root package name */
    public String f49552f;
    public String m;
    public boolean q;
    public String r;
    public String s;

    /* renamed from: a  reason: collision with root package name */
    public int f49547a = 1;

    /* renamed from: g  reason: collision with root package name */
    public int f49553g = 0;

    /* renamed from: h  reason: collision with root package name */
    public int f49554h = 1;

    /* renamed from: i  reason: collision with root package name */
    public int f49555i = 0;
    public int j = 0;
    public int k = 300;
    public int l = 1;
    public int n = 4;
    public int o = 4;
    public int p = 7;

    /* renamed from: b  reason: collision with root package name */
    public j f49548b = new j();

    public j a() {
        return this.f49548b;
    }

    public int b() {
        return this.k;
    }

    public String c() {
        return this.m;
    }

    public boolean d() {
        return this.f49554h == 1;
    }

    public boolean e() {
        return this.f49547a > 0;
    }

    public boolean f() {
        return this.f49553g == 1;
    }

    public boolean g() {
        return this.f49555i == 0;
    }

    public boolean h() {
        if (this.f49549c == 1) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            return this.f49550d < currentTimeMillis && currentTimeMillis < this.f49551e;
        }
        return false;
    }

    public boolean i() {
        return this.j == 1;
    }

    public String j() {
        return this.f49552f;
    }

    public void k(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return;
        }
        this.f49547a = jSONObject.optInt("als_control", 1);
        jSONObject.optInt("not_use_lego_patch", 0);
        this.f49554h = jSONObject.optInt("ad_video_not_autoplay", 1);
        this.j = jSONObject.optInt("lp_video_not_autoplay", 0);
        this.f49548b.a(jSONObject);
        JSONObject optJSONObject = jSONObject.optJSONObject("log_feed_control");
        if (optJSONObject != null) {
            this.f49549c = optJSONObject.optInt("log_feed_switch", 0);
            this.f49550d = optJSONObject.optLong("start_time", -1L);
            this.f49551e = optJSONObject.optLong("end_time", -1L);
            this.f49552f = optJSONObject.optString("ext_info");
        }
        this.f49553g = jSONObject.optInt("ad_collect_switch", 0);
        JSONObject optJSONObject2 = jSONObject.optJSONObject("splash");
        if (optJSONObject2 != null) {
            this.k = optJSONObject2.optInt("interval", 300);
        }
        this.l = jSONObject.optInt("video_page_style", 1);
        d.a.i0.r.d0.b.j().v("video_page_style", this.l);
        this.f49555i = jSONObject.optInt("ad_download_lib", 0);
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
            d.a.i0.z0.d.i(optString);
            return;
        }
        d.a.i0.z0.d.i(null);
    }
}
