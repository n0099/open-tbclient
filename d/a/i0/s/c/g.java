package d.a.i0.s.c;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public int f49572a = 20;

    /* renamed from: b  reason: collision with root package name */
    public int f49573b = 1;

    /* renamed from: c  reason: collision with root package name */
    public String f49574c;

    public int a() {
        return this.f49572a;
    }

    public int b() {
        return this.f49573b;
    }

    public String c() {
        return this.f49574c;
    }

    public void d(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            g(jSONObject.optString("advertisement_str"));
            e(jSONObject.optInt("advertisement_limit_a"));
            f(jSONObject.optInt("advertisement_limit_bc"));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void e(int i2) {
        this.f49572a = i2;
    }

    public void f(int i2) {
        this.f49573b = i2;
    }

    public void g(String str) {
        this.f49574c = str;
    }
}
