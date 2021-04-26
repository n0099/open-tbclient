package d.a.j0.d3.l0.d;

import d.a.c.e.p.k;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public String f53208a;

    /* renamed from: b  reason: collision with root package name */
    public String f53209b;

    /* renamed from: c  reason: collision with root package name */
    public JSONObject f53210c;

    /* renamed from: d  reason: collision with root package name */
    public String f53211d;

    public String a() {
        return this.f53208a;
    }

    public String b() {
        if (k.isEmpty(this.f53209b)) {
            return this.f53208a;
        }
        return this.f53209b + "/" + this.f53208a;
    }

    public String c() {
        return this.f53209b;
    }

    public String d() {
        return this.f53211d;
    }

    public JSONObject e() {
        return this.f53210c;
    }

    public void f(String str) {
        this.f53208a = str;
    }

    public void g(String str) {
    }

    public void h(String str) {
        this.f53209b = str;
    }

    public void i(String str) {
        this.f53211d = str;
    }

    public void j(JSONObject jSONObject) {
        this.f53210c = jSONObject;
    }
}
