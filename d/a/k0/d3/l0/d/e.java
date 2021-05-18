package d.a.k0.d3.l0.d;

import d.a.c.e.p.k;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public String f53915a;

    /* renamed from: b  reason: collision with root package name */
    public String f53916b;

    /* renamed from: c  reason: collision with root package name */
    public JSONObject f53917c;

    /* renamed from: d  reason: collision with root package name */
    public String f53918d;

    public String a() {
        return this.f53915a;
    }

    public String b() {
        if (k.isEmpty(this.f53916b)) {
            return this.f53915a;
        }
        return this.f53916b + "/" + this.f53915a;
    }

    public String c() {
        return this.f53916b;
    }

    public String d() {
        return this.f53918d;
    }

    public JSONObject e() {
        return this.f53917c;
    }

    public void f(String str) {
        this.f53915a = str;
    }

    public void g(String str) {
    }

    public void h(String str) {
        this.f53916b = str;
    }

    public void i(String str) {
        this.f53918d = str;
    }

    public void j(JSONObject jSONObject) {
        this.f53917c = jSONObject;
    }
}
