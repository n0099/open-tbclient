package d.a.k0.a0;

import com.baidu.adp.lib.util.StringUtils;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f51069a;

    /* renamed from: b  reason: collision with root package name */
    public long f51070b;

    /* renamed from: c  reason: collision with root package name */
    public int f51071c;

    /* renamed from: d  reason: collision with root package name */
    public long f51072d;

    /* renamed from: e  reason: collision with root package name */
    public long f51073e;

    /* renamed from: f  reason: collision with root package name */
    public String f51074f;

    /* renamed from: g  reason: collision with root package name */
    public long f51075g;

    /* renamed from: h  reason: collision with root package name */
    public String f51076h;

    /* renamed from: i  reason: collision with root package name */
    public String f51077i;
    public String j;
    public String k;
    public String l;
    public int m;
    public double n;

    public String a() {
        return this.j;
    }

    public String b() {
        return this.f51076h;
    }

    public String c() {
        return this.f51077i;
    }

    public long d() {
        return this.f51072d;
    }

    public int e() {
        return this.m;
    }

    public long f() {
        return this.f51073e;
    }

    public long g() {
        return this.f51075g;
    }

    public String h() {
        return this.f51069a;
    }

    public double i() {
        return this.n;
    }

    public String j() {
        return StringUtils.isNull(this.l) ? this.k : this.l;
    }

    public int k() {
        return this.f51071c;
    }

    public String l() {
        return this.f51074f;
    }

    public long m() {
        return this.f51070b;
    }

    public void n(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f51069a = jSONObject.optString("order_id");
        jSONObject.optLong("scene_id");
        this.f51070b = jSONObject.optLong("scores");
        this.f51071c = jSONObject.optInt("status");
        this.f51072d = jSONObject.optLong("create_time");
        this.f51073e = jSONObject.optLong("finish_time");
        this.f51074f = jSONObject.optString("title");
        this.f51075g = jSONObject.optLong("money");
        jSONObject.optString("preg_field");
        this.k = jSONObject.optString("user_name");
        this.l = jSONObject.optString("user_nickname");
        this.f51076h = jSONObject.optString("activity_desc");
        this.f51077i = jSONObject.optString("activity_url");
        this.j = jSONObject.optString("button_name");
        this.m = jSONObject.optInt("price_type", 0);
        this.n = jSONObject.optDouble("order_yy_amount", 0.0d);
        jSONObject.optDouble("order_amount", 0.0d);
    }
}
