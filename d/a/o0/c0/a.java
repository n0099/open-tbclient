package d.a.o0.c0;

import com.baidu.adp.lib.util.StringUtils;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f56100a;

    /* renamed from: b  reason: collision with root package name */
    public long f56101b;

    /* renamed from: c  reason: collision with root package name */
    public int f56102c;

    /* renamed from: d  reason: collision with root package name */
    public long f56103d;

    /* renamed from: e  reason: collision with root package name */
    public long f56104e;

    /* renamed from: f  reason: collision with root package name */
    public String f56105f;

    /* renamed from: g  reason: collision with root package name */
    public long f56106g;

    /* renamed from: h  reason: collision with root package name */
    public String f56107h;

    /* renamed from: i  reason: collision with root package name */
    public String f56108i;
    public String j;
    public String k;
    public String l;
    public int m;
    public double n;

    public String a() {
        return this.j;
    }

    public String b() {
        return this.f56107h;
    }

    public String c() {
        return this.f56108i;
    }

    public long d() {
        return this.f56103d;
    }

    public int e() {
        return this.m;
    }

    public long f() {
        return this.f56104e;
    }

    public long g() {
        return this.f56106g;
    }

    public String h() {
        return this.f56100a;
    }

    public double i() {
        return this.n;
    }

    public String j() {
        return StringUtils.isNull(this.l) ? this.k : this.l;
    }

    public int k() {
        return this.f56102c;
    }

    public String l() {
        return this.f56105f;
    }

    public long m() {
        return this.f56101b;
    }

    public void n(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f56100a = jSONObject.optString("order_id");
        jSONObject.optLong("scene_id");
        this.f56101b = jSONObject.optLong("scores");
        this.f56102c = jSONObject.optInt("status");
        this.f56103d = jSONObject.optLong("create_time");
        this.f56104e = jSONObject.optLong("finish_time");
        this.f56105f = jSONObject.optString("title");
        this.f56106g = jSONObject.optLong("money");
        jSONObject.optString("preg_field");
        this.k = jSONObject.optString("user_name");
        this.l = jSONObject.optString("user_nickname");
        this.f56107h = jSONObject.optString("activity_desc");
        this.f56108i = jSONObject.optString("activity_url");
        this.j = jSONObject.optString("button_name");
        this.m = jSONObject.optInt("price_type", 0);
        this.n = jSONObject.optDouble("order_yy_amount", 0.0d);
        jSONObject.optDouble("order_amount", 0.0d);
    }
}
