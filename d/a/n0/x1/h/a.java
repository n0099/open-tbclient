package d.a.n0.x1.h;

import android.text.TextUtils;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import d.a.m0.g0.b.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a implements e {
    public long n;
    public int o;
    public boolean p;

    /* renamed from: e  reason: collision with root package name */
    public String f67002e = "";

    /* renamed from: f  reason: collision with root package name */
    public String f67003f = "";

    /* renamed from: g  reason: collision with root package name */
    public String f67004g = "";

    /* renamed from: h  reason: collision with root package name */
    public long f67005h = System.currentTimeMillis();

    /* renamed from: i  reason: collision with root package name */
    public String f67006i = "";
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
        this.f67004g = str;
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
        this.f67006i = str;
    }

    public void I(boolean z) {
        this.k = z;
    }

    public void J(String str) {
        this.f67002e = str;
    }

    public void K(String str) {
        this.f67003f = str;
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
            jSONObject.put("forum_name", this.f67004g);
            jSONObject.put("thread_id", this.f67002e);
            jSONObject.put("thread_time", this.f67005h);
            jSONObject.put("thread_name", this.f67003f);
            jSONObject.put("post_id", this.f67006i);
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

    public String c() {
        return this.s;
    }

    public String d() {
        return this.f67004g;
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
                String str4 = this.f67002e;
                if (str4 != null && (str = aVar.f67002e) != null && str4.equals(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    public String f() {
        return this.q;
    }

    public String g() {
        return this.f67006i;
    }

    @Override // d.a.m0.g0.b.c
    public String getCacheKey() {
        if (this.l == 49) {
            return this.q + "_ala";
        }
        return this.f67002e;
    }

    @Override // d.a.m0.g0.b.e
    public String h() {
        return N().toString();
    }

    public int hashCode() {
        int hashCode = TextUtils.isEmpty(this.f67002e) ? 120 : 119 + this.f67002e.hashCode();
        int hashCode2 = TextUtils.isEmpty(this.f67003f) ? (hashCode * 7) + 1 : (hashCode * 7) + this.f67003f.hashCode();
        int hashCode3 = ((TextUtils.isEmpty(this.f67004g) ? (hashCode2 * 7) + 1 : (hashCode2 * 7) + this.f67004g.hashCode()) * 7) + ((int) this.f67005h);
        int hashCode4 = TextUtils.isEmpty(this.f67006i) ? (hashCode3 * 7) + 1 : (hashCode3 * 7) + this.f67006i.hashCode();
        int hashCode5 = TextUtils.isEmpty(this.q) ? (hashCode4 * 7) + 1 : (hashCode4 * 7) + this.q.hashCode();
        return ((((TextUtils.isEmpty(this.s) ? (hashCode5 * 7) + 1 : (hashCode5 * 7) + this.s.hashCode()) * 7) + (this.j ? 1 : 0)) * 7) + (this.k ? 1 : 0);
    }

    public String i() {
        return this.f67002e;
    }

    public String j() {
        return this.f67003f;
    }

    public int k() {
        return this.l;
    }

    public long m() {
        return this.f67005h;
    }

    @Override // d.a.m0.g0.b.e
    public boolean n(String str) {
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

    public String o() {
        return this.r;
    }

    public boolean p() {
        return this.j;
    }

    public boolean q() {
        return this.t;
    }

    public boolean r() {
        return this.m;
    }

    public boolean t() {
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
        this.f67006i = jSONObject.optString("post_id");
        this.j = jSONObject.optBoolean("host_only");
        this.k = jSONObject.optBoolean("squence");
        this.m = jSONObject.optBoolean("is_manga");
        this.n = jSONObject.optLong("cartoon_id");
        this.o = jSONObject.optInt(MangaBrowserActivityConfig.CHAPTER_ID);
        this.p = jSONObject.optBoolean("is_share_thread", false);
        if (!TextUtils.isEmpty(optString)) {
            this.f67004g = optString;
        }
        if (!TextUtils.isEmpty(optString2)) {
            this.f67002e = optString2;
        }
        if (!TextUtils.isEmpty(optString3)) {
            this.f67003f = optString3;
        }
        if (optLong > 2000) {
            this.f67005h = optLong;
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
