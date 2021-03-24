package d.b.i0.c3.l0.d;

import d.b.b.e.p.k;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public String f53501a;

    /* renamed from: b  reason: collision with root package name */
    public String f53502b;

    /* renamed from: c  reason: collision with root package name */
    public JSONObject f53503c;

    /* renamed from: d  reason: collision with root package name */
    public String f53504d;

    public String a() {
        return this.f53501a;
    }

    public String b() {
        if (k.isEmpty(this.f53502b)) {
            return this.f53501a;
        }
        return this.f53502b + "/" + this.f53501a;
    }

    public String c() {
        return this.f53502b;
    }

    public String d() {
        return this.f53504d;
    }

    public JSONObject e() {
        return this.f53503c;
    }

    public void f(String str) {
        this.f53501a = str;
    }

    public void g(String str) {
    }

    public void h(String str) {
        this.f53502b = str;
    }

    public void i(String str) {
        this.f53504d = str;
    }

    public void j(JSONObject jSONObject) {
        this.f53503c = jSONObject;
    }
}
