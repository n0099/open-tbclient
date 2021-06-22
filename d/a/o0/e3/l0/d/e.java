package d.a.o0.e3.l0.d;

import d.a.c.e.p.k;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public String f57942a;

    /* renamed from: b  reason: collision with root package name */
    public String f57943b;

    /* renamed from: c  reason: collision with root package name */
    public JSONObject f57944c;

    /* renamed from: d  reason: collision with root package name */
    public String f57945d;

    public String a() {
        return this.f57942a;
    }

    public String b() {
        if (k.isEmpty(this.f57943b)) {
            return this.f57942a;
        }
        return this.f57943b + "/" + this.f57942a;
    }

    public String c() {
        return this.f57943b;
    }

    public String d() {
        return this.f57945d;
    }

    public JSONObject e() {
        return this.f57944c;
    }

    public void f(String str) {
        this.f57942a = str;
    }

    public void g(String str) {
    }

    public void h(String str) {
        this.f57943b = str;
    }

    public void i(String str) {
        this.f57945d = str;
    }

    public void j(JSONObject jSONObject) {
        this.f57944c = jSONObject;
    }
}
