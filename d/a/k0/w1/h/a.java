package d.a.k0.w1.h;

import android.text.TextUtils;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import d.a.j0.g0.b.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a implements e {
    public long n;
    public int o;
    public boolean p;

    /* renamed from: e  reason: collision with root package name */
    public String f63102e = "";

    /* renamed from: f  reason: collision with root package name */
    public String f63103f = "";

    /* renamed from: g  reason: collision with root package name */
    public String f63104g = "";

    /* renamed from: h  reason: collision with root package name */
    public long f63105h = System.currentTimeMillis();

    /* renamed from: i  reason: collision with root package name */
    public String f63106i = "";
    public boolean j = false;
    public boolean k = false;
    public int l = 0;
    public boolean m = false;
    public String q = "";
    public String r = "";
    public String s = "";
    public boolean t = true;

    public void A(String str) {
        this.s = str;
    }

    public void B(String str) {
        this.f63104g = str;
    }

    public void C(boolean z) {
        this.j = z;
    }

    public void D(boolean z) {
        this.p = z;
    }

    public void E(boolean z) {
        this.t = z;
    }

    public void F(String str) {
        this.q = str;
    }

    public void G(boolean z) {
        this.m = z;
    }

    public void H(String str) {
        this.f63106i = str;
    }

    public void I(boolean z) {
        this.k = z;
    }

    public void J(String str) {
        this.f63102e = str;
    }

    public void K(String str) {
        this.f63103f = str;
    }

    public void L(int i2) {
        this.l = i2;
    }

    public void M(String str) {
        this.r = str;
    }

    public JSONObject N() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("forum_name", this.f63104g);
            jSONObject.put("thread_id", this.f63102e);
            jSONObject.put("thread_time", this.f63105h);
            jSONObject.put("thread_name", this.f63103f);
            jSONObject.put("post_id", this.f63106i);
            jSONObject.put("host_only", this.j);
            jSONObject.put("squence", this.k);
            jSONObject.put("thread_type", this.l);
            jSONObject.put("is_manga", this.m);
            jSONObject.put("cartoon_id", this.n);
            jSONObject.put(MangaBrowserActivityConfig.CHAPTER_ID, this.o);
            jSONObject.put("is_share_thread", this.p);
            jSONObject.put("live_id", this.q);
            jSONObject.put("user_name", this.r);
            jSONObject.put("live_description", this.s);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public long a() {
        return this.n;
    }

    public int b() {
        return this.o;
    }

    public String d() {
        return this.s;
    }

    public String e() {
        return this.f63104g;
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        if (obj != null && (obj instanceof a)) {
            a aVar = (a) obj;
            if (this.l == 49) {
                String str3 = this.q;
                if (str3 != null && (str2 = aVar.q) != null && str3.equals(str2)) {
                    return true;
                }
            } else {
                String str4 = this.f63102e;
                if (str4 != null && (str = aVar.f63102e) != null && str4.equals(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // d.a.j0.g0.b.e
    public String f() {
        return N().toString();
    }

    public String g() {
        return this.q;
    }

    @Override // d.a.j0.g0.b.c
    public String getCacheKey() {
        if (this.l == 49) {
            return this.q + "_ala";
        }
        return this.f63102e;
    }

    public String h() {
        return this.f63106i;
    }

    public int hashCode() {
        int hashCode = TextUtils.isEmpty(this.f63102e) ? 120 : 119 + this.f63102e.hashCode();
        int hashCode2 = TextUtils.isEmpty(this.f63103f) ? (hashCode * 7) + 1 : (hashCode * 7) + this.f63103f.hashCode();
        int hashCode3 = ((TextUtils.isEmpty(this.f63104g) ? (hashCode2 * 7) + 1 : (hashCode2 * 7) + this.f63104g.hashCode()) * 7) + ((int) this.f63105h);
        int hashCode4 = TextUtils.isEmpty(this.f63106i) ? (hashCode3 * 7) + 1 : (hashCode3 * 7) + this.f63106i.hashCode();
        int hashCode5 = TextUtils.isEmpty(this.q) ? (hashCode4 * 7) + 1 : (hashCode4 * 7) + this.q.hashCode();
        return ((((TextUtils.isEmpty(this.s) ? (hashCode5 * 7) + 1 : (hashCode5 * 7) + this.s.hashCode()) * 7) + (this.j ? 1 : 0)) * 7) + (this.k ? 1 : 0);
    }

    public String j() {
        return this.f63102e;
    }

    @Override // d.a.j0.g0.b.e
    public boolean k(String str) {
        if (str != null) {
            try {
                return x(new JSONObject(str));
            } catch (JSONException e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return false;
    }

    public String l() {
        return this.f63103f;
    }

    public int m() {
        return this.l;
    }

    public long n() {
        return this.f63105h;
    }

    public String p() {
        return this.r;
    }

    public boolean s() {
        return this.j;
    }

    public boolean t() {
        return this.t;
    }

    public boolean u() {
        return this.m;
    }

    public boolean v() {
        return this.p;
    }

    public boolean w() {
        return this.k;
    }

    public boolean x(JSONObject jSONObject) {
        String optString = jSONObject.optString("forum_name");
        String optString2 = jSONObject.optString("thread_id");
        String optString3 = jSONObject.optString("thread_name");
        long optLong = jSONObject.optLong("thread_time");
        this.f63106i = jSONObject.optString("post_id");
        this.j = jSONObject.optBoolean("host_only");
        this.k = jSONObject.optBoolean("squence");
        this.m = jSONObject.optBoolean("is_manga");
        this.n = jSONObject.optLong("cartoon_id");
        this.o = jSONObject.optInt(MangaBrowserActivityConfig.CHAPTER_ID);
        this.p = jSONObject.optBoolean("is_share_thread", false);
        if (!TextUtils.isEmpty(optString)) {
            this.f63104g = optString;
        }
        if (!TextUtils.isEmpty(optString2)) {
            this.f63102e = optString2;
        }
        if (!TextUtils.isEmpty(optString3)) {
            this.f63103f = optString3;
        }
        if (optLong > 2000) {
            this.f63105h = optLong;
        }
        this.l = jSONObject.optInt("thread_type");
        this.q = jSONObject.optString("live_id", "");
        this.r = jSONObject.optString("user_name", "");
        this.s = jSONObject.optString("live_description", "");
        return true;
    }

    public void y(long j) {
        this.n = j;
    }

    public void z(int i2) {
        this.o = i2;
    }
}
