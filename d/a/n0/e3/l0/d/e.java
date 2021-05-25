package d.a.n0.e3.l0.d;

import d.a.c.e.p.k;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public String f54128a;

    /* renamed from: b  reason: collision with root package name */
    public String f54129b;

    /* renamed from: c  reason: collision with root package name */
    public JSONObject f54130c;

    /* renamed from: d  reason: collision with root package name */
    public String f54131d;

    public String a() {
        return this.f54128a;
    }

    public String b() {
        if (k.isEmpty(this.f54129b)) {
            return this.f54128a;
        }
        return this.f54129b + "/" + this.f54128a;
    }

    public String c() {
        return this.f54129b;
    }

    public String d() {
        return this.f54131d;
    }

    public JSONObject e() {
        return this.f54130c;
    }

    public void f(String str) {
        this.f54128a = str;
    }

    public void g(String str) {
    }

    public void h(String str) {
        this.f54129b = str;
    }

    public void i(String str) {
        this.f54131d = str;
    }

    public void j(JSONObject jSONObject) {
        this.f54130c = jSONObject;
    }
}
