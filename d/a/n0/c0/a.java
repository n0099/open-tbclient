package d.a.n0.c0;

import com.baidu.adp.lib.util.StringUtils;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f55975a;

    /* renamed from: b  reason: collision with root package name */
    public long f55976b;

    /* renamed from: c  reason: collision with root package name */
    public int f55977c;

    /* renamed from: d  reason: collision with root package name */
    public long f55978d;

    /* renamed from: e  reason: collision with root package name */
    public long f55979e;

    /* renamed from: f  reason: collision with root package name */
    public String f55980f;

    /* renamed from: g  reason: collision with root package name */
    public long f55981g;

    /* renamed from: h  reason: collision with root package name */
    public String f55982h;

    /* renamed from: i  reason: collision with root package name */
    public String f55983i;
    public String j;
    public String k;
    public String l;
    public int m;
    public double n;

    public String a() {
        return this.j;
    }

    public String b() {
        return this.f55982h;
    }

    public String c() {
        return this.f55983i;
    }

    public long d() {
        return this.f55978d;
    }

    public int e() {
        return this.m;
    }

    public long f() {
        return this.f55979e;
    }

    public long g() {
        return this.f55981g;
    }

    public String h() {
        return this.f55975a;
    }

    public double i() {
        return this.n;
    }

    public String j() {
        return StringUtils.isNull(this.l) ? this.k : this.l;
    }

    public int k() {
        return this.f55977c;
    }

    public String l() {
        return this.f55980f;
    }

    public long m() {
        return this.f55976b;
    }

    public void n(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f55975a = jSONObject.optString("order_id");
        jSONObject.optLong("scene_id");
        this.f55976b = jSONObject.optLong("scores");
        this.f55977c = jSONObject.optInt("status");
        this.f55978d = jSONObject.optLong("create_time");
        this.f55979e = jSONObject.optLong("finish_time");
        this.f55980f = jSONObject.optString("title");
        this.f55981g = jSONObject.optLong("money");
        jSONObject.optString("preg_field");
        this.k = jSONObject.optString("user_name");
        this.l = jSONObject.optString("user_nickname");
        this.f55982h = jSONObject.optString("activity_desc");
        this.f55983i = jSONObject.optString("activity_url");
        this.j = jSONObject.optString("button_name");
        this.m = jSONObject.optInt("price_type", 0);
        this.n = jSONObject.optDouble("order_yy_amount", 0.0d);
        jSONObject.optDouble("order_amount", 0.0d);
    }
}
