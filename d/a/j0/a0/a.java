package d.a.j0.a0;

import com.baidu.adp.lib.util.StringUtils;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f50372a;

    /* renamed from: b  reason: collision with root package name */
    public long f50373b;

    /* renamed from: c  reason: collision with root package name */
    public int f50374c;

    /* renamed from: d  reason: collision with root package name */
    public long f50375d;

    /* renamed from: e  reason: collision with root package name */
    public long f50376e;

    /* renamed from: f  reason: collision with root package name */
    public String f50377f;

    /* renamed from: g  reason: collision with root package name */
    public long f50378g;

    /* renamed from: h  reason: collision with root package name */
    public String f50379h;

    /* renamed from: i  reason: collision with root package name */
    public String f50380i;
    public String j;
    public String k;
    public String l;
    public int m;
    public double n;

    public String a() {
        return this.j;
    }

    public String b() {
        return this.f50379h;
    }

    public String c() {
        return this.f50380i;
    }

    public long d() {
        return this.f50375d;
    }

    public int e() {
        return this.m;
    }

    public long f() {
        return this.f50376e;
    }

    public long g() {
        return this.f50378g;
    }

    public String h() {
        return this.f50372a;
    }

    public double i() {
        return this.n;
    }

    public String j() {
        return StringUtils.isNull(this.l) ? this.k : this.l;
    }

    public int k() {
        return this.f50374c;
    }

    public String l() {
        return this.f50377f;
    }

    public long m() {
        return this.f50373b;
    }

    public void n(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f50372a = jSONObject.optString("order_id");
        jSONObject.optLong("scene_id");
        this.f50373b = jSONObject.optLong("scores");
        this.f50374c = jSONObject.optInt("status");
        this.f50375d = jSONObject.optLong("create_time");
        this.f50376e = jSONObject.optLong("finish_time");
        this.f50377f = jSONObject.optString("title");
        this.f50378g = jSONObject.optLong("money");
        jSONObject.optString("preg_field");
        this.k = jSONObject.optString("user_name");
        this.l = jSONObject.optString("user_nickname");
        this.f50379h = jSONObject.optString("activity_desc");
        this.f50380i = jSONObject.optString("activity_url");
        this.j = jSONObject.optString("button_name");
        this.m = jSONObject.optInt("price_type", 0);
        this.n = jSONObject.optDouble("order_yy_amount", 0.0d);
        jSONObject.optDouble("order_amount", 0.0d);
    }
}
