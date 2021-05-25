package d.a.n0.c0;

import com.baidu.adp.lib.util.StringUtils;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f52286a;

    /* renamed from: b  reason: collision with root package name */
    public long f52287b;

    /* renamed from: c  reason: collision with root package name */
    public int f52288c;

    /* renamed from: d  reason: collision with root package name */
    public long f52289d;

    /* renamed from: e  reason: collision with root package name */
    public long f52290e;

    /* renamed from: f  reason: collision with root package name */
    public String f52291f;

    /* renamed from: g  reason: collision with root package name */
    public long f52292g;

    /* renamed from: h  reason: collision with root package name */
    public String f52293h;

    /* renamed from: i  reason: collision with root package name */
    public String f52294i;
    public String j;
    public String k;
    public String l;
    public int m;
    public double n;

    public String a() {
        return this.j;
    }

    public String b() {
        return this.f52293h;
    }

    public String c() {
        return this.f52294i;
    }

    public long d() {
        return this.f52289d;
    }

    public int e() {
        return this.m;
    }

    public long f() {
        return this.f52290e;
    }

    public long g() {
        return this.f52292g;
    }

    public String h() {
        return this.f52286a;
    }

    public double i() {
        return this.n;
    }

    public String j() {
        return StringUtils.isNull(this.l) ? this.k : this.l;
    }

    public int k() {
        return this.f52288c;
    }

    public String l() {
        return this.f52291f;
    }

    public long m() {
        return this.f52287b;
    }

    public void n(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f52286a = jSONObject.optString("order_id");
        jSONObject.optLong("scene_id");
        this.f52287b = jSONObject.optLong("scores");
        this.f52288c = jSONObject.optInt("status");
        this.f52289d = jSONObject.optLong("create_time");
        this.f52290e = jSONObject.optLong("finish_time");
        this.f52291f = jSONObject.optString("title");
        this.f52292g = jSONObject.optLong("money");
        jSONObject.optString("preg_field");
        this.k = jSONObject.optString("user_name");
        this.l = jSONObject.optString("user_nickname");
        this.f52293h = jSONObject.optString("activity_desc");
        this.f52294i = jSONObject.optString("activity_url");
        this.j = jSONObject.optString("button_name");
        this.m = jSONObject.optInt("price_type", 0);
        this.n = jSONObject.optDouble("order_yy_amount", 0.0d);
        jSONObject.optDouble("order_amount", 0.0d);
    }
}
