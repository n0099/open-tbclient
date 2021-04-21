package d.b.j0.d3.l0.d;

import d.b.c.e.p.k;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public String f55367a;

    /* renamed from: b  reason: collision with root package name */
    public String f55368b;

    /* renamed from: c  reason: collision with root package name */
    public JSONObject f55369c;

    /* renamed from: d  reason: collision with root package name */
    public String f55370d;

    public String a() {
        return this.f55367a;
    }

    public String b() {
        if (k.isEmpty(this.f55368b)) {
            return this.f55367a;
        }
        return this.f55368b + "/" + this.f55367a;
    }

    public String c() {
        return this.f55368b;
    }

    public String d() {
        return this.f55370d;
    }

    public JSONObject e() {
        return this.f55369c;
    }

    public void f(String str) {
        this.f55367a = str;
    }

    public void g(String str) {
    }

    public void h(String str) {
        this.f55368b = str;
    }

    public void i(String str) {
        this.f55370d = str;
    }

    public void j(JSONObject jSONObject) {
        this.f55369c = jSONObject;
    }
}
