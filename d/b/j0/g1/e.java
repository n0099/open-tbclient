package d.b.j0.g1;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class e {
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public String q;
    public String r;
    public String s;
    public AgreeData u;

    /* renamed from: a  reason: collision with root package name */
    public String f56539a = null;

    /* renamed from: b  reason: collision with root package name */
    public String f56540b = null;

    /* renamed from: c  reason: collision with root package name */
    public String f56541c = null;

    /* renamed from: d  reason: collision with root package name */
    public int f56542d = 0;

    /* renamed from: e  reason: collision with root package name */
    public int f56543e = 0;

    /* renamed from: f  reason: collision with root package name */
    public String f56544f = null;

    /* renamed from: g  reason: collision with root package name */
    public long f56545g = 0;

    /* renamed from: h  reason: collision with root package name */
    public int f56546h = 0;
    public String i = "";
    public int j = -1;
    public long k = 0;
    public String l = null;
    public String t = null;
    public JSONArray v = null;

    public AgreeData a() {
        return this.u;
    }

    public String b() {
        return this.f56541c;
    }

    public String c() {
        return this.l;
    }

    public String d() {
        return this.t;
    }

    public int e() {
        return this.f56543e;
    }

    public String f() {
        return this.f56539a;
    }

    public String g() {
        return this.f56540b;
    }

    public int h() {
        return this.j;
    }

    public String i() {
        return this.f56544f;
    }

    public long j() {
        return this.f56545g;
    }

    public long k() {
        return this.k;
    }

    public int l() {
        return this.f56546h;
    }

    public JSONArray m() {
        return this.v;
    }

    public String n() {
        return this.i;
    }

    public String o() {
        return this.q;
    }

    public String p() {
        return this.r;
    }

    public String q() {
        return this.s;
    }

    public int r() {
        return this.f56542d;
    }

    public boolean s() {
        return this.o;
    }

    public boolean t() {
        return this.m;
    }

    public boolean u() {
        return this.p;
    }

    public boolean v() {
        return this.n;
    }

    public void w(JSONObject jSONObject) {
        JSONObject optJSONObject;
        try {
            this.k = jSONObject.optLong("overall_index", 0L);
            this.l = jSONObject.optString("post_id");
            this.q = jSONObject.optString("user_id");
            this.r = jSONObject.optString("user_name");
            this.s = jSONObject.optString("nickname");
            boolean z = true;
            this.n = jSONObject.optInt("show_original_btn") == 1;
            this.o = jSONObject.optInt("is_blocked_pic") == 1;
            this.p = jSONObject.optInt("is_long_pic") == 1;
            this.j = jSONObject.optInt("index", -1);
            this.m = jSONObject.optInt("is_first_post") == 1;
            this.t = jSONObject.optString("comment_num");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("agree");
            if (optJSONObject2 != null) {
                int optInt = optJSONObject2.optInt("agree_num");
                optJSONObject2.optInt("disagree_num");
                int optInt2 = optJSONObject2.optInt("agree_type");
                if (optJSONObject2.optInt("has_agree") != 1) {
                    z = false;
                }
                if (this.u == null) {
                    this.u = new AgreeData();
                }
                this.u.agreeType = optInt2;
                this.u.hasAgree = z;
                this.u.agreeNum = optInt;
            }
            this.v = jSONObject.optJSONArray("post_content");
            JSONObject optJSONObject3 = jSONObject.optJSONObject("img");
            if (optJSONObject3 != null && (optJSONObject = optJSONObject3.optJSONObject("original")) != null) {
                this.f56539a = optJSONObject.optString("id");
                this.f56540b = optJSONObject.optString("url");
                this.f56542d = optJSONObject.optInt("width", 0);
                this.f56543e = optJSONObject.optInt("height", 0);
                this.f56541c = optJSONObject.optString("big_cdn_src", null);
                this.f56544f = optJSONObject.optString("original_src");
                this.f56545g = optJSONObject.optInt("size");
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("pic_tagname");
            if (optJSONObject4 != null) {
                this.f56546h = optJSONObject4.optInt("pic_type", 0);
                this.i = optJSONObject4.optString("tag_name");
            }
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }
}
