package d.a.i0.s.c;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    public int f49615a;

    /* renamed from: b  reason: collision with root package name */
    public p f49616b;

    public int a() {
        return this.f49615a;
    }

    public p b() {
        return this.f49616b;
    }

    public void c(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("common");
        if (optJSONObject != null) {
            this.f49615a = optJSONObject.optInt("version");
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("special");
        if (optJSONObject2 != null) {
            p pVar = new p();
            this.f49616b = pVar;
            pVar.f(optJSONObject2);
        }
    }
}
