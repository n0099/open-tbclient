package d.b.i0.s.c;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public int f51919a = 20;

    /* renamed from: b  reason: collision with root package name */
    public int f51920b = 1;

    /* renamed from: c  reason: collision with root package name */
    public String f51921c;

    public int a() {
        return this.f51919a;
    }

    public int b() {
        return this.f51920b;
    }

    public String c() {
        return this.f51921c;
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

    public void e(int i) {
        this.f51919a = i;
    }

    public void f(int i) {
        this.f51920b = i;
    }

    public void g(String str) {
        this.f51921c = str;
    }
}
