package d.b.i0.c3.l0.d;

import d.b.b.e.p.k;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public String f53502a;

    /* renamed from: b  reason: collision with root package name */
    public String f53503b;

    /* renamed from: c  reason: collision with root package name */
    public JSONObject f53504c;

    /* renamed from: d  reason: collision with root package name */
    public String f53505d;

    public String a() {
        return this.f53502a;
    }

    public String b() {
        if (k.isEmpty(this.f53503b)) {
            return this.f53502a;
        }
        return this.f53503b + "/" + this.f53502a;
    }

    public String c() {
        return this.f53503b;
    }

    public String d() {
        return this.f53505d;
    }

    public JSONObject e() {
        return this.f53504c;
    }

    public void f(String str) {
        this.f53502a = str;
    }

    public void g(String str) {
    }

    public void h(String str) {
        this.f53503b = str;
    }

    public void i(String str) {
        this.f53505d = str;
    }

    public void j(JSONObject jSONObject) {
        this.f53504c = jSONObject;
    }
}
