package d.a.n0.e3.l0.d;

import d.a.c.e.p.k;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public String f57817a;

    /* renamed from: b  reason: collision with root package name */
    public String f57818b;

    /* renamed from: c  reason: collision with root package name */
    public JSONObject f57819c;

    /* renamed from: d  reason: collision with root package name */
    public String f57820d;

    public String a() {
        return this.f57817a;
    }

    public String b() {
        if (k.isEmpty(this.f57818b)) {
            return this.f57817a;
        }
        return this.f57818b + "/" + this.f57817a;
    }

    public String c() {
        return this.f57818b;
    }

    public String d() {
        return this.f57820d;
    }

    public JSONObject e() {
        return this.f57819c;
    }

    public void f(String str) {
        this.f57817a = str;
    }

    public void g(String str) {
    }

    public void h(String str) {
        this.f57818b = str;
    }

    public void i(String str) {
        this.f57820d = str;
    }

    public void j(JSONObject jSONObject) {
        this.f57819c = jSONObject;
    }
}
