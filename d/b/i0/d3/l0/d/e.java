package d.b.i0.d3.l0.d;

import d.b.c.e.p.k;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public String f54946a;

    /* renamed from: b  reason: collision with root package name */
    public String f54947b;

    /* renamed from: c  reason: collision with root package name */
    public JSONObject f54948c;

    /* renamed from: d  reason: collision with root package name */
    public String f54949d;

    public String a() {
        return this.f54946a;
    }

    public String b() {
        if (k.isEmpty(this.f54947b)) {
            return this.f54946a;
        }
        return this.f54947b + "/" + this.f54946a;
    }

    public String c() {
        return this.f54947b;
    }

    public String d() {
        return this.f54949d;
    }

    public JSONObject e() {
        return this.f54948c;
    }

    public void f(String str) {
        this.f54946a = str;
    }

    public void g(String str) {
    }

    public void h(String str) {
        this.f54947b = str;
    }

    public void i(String str) {
        this.f54949d = str;
    }

    public void j(JSONObject jSONObject) {
        this.f54948c = jSONObject;
    }
}
