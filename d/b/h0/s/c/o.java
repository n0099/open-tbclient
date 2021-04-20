package d.b.h0.s.c;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    public int f51625a;

    /* renamed from: b  reason: collision with root package name */
    public p f51626b;

    public int a() {
        return this.f51625a;
    }

    public p b() {
        return this.f51626b;
    }

    public void c(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("common");
        if (optJSONObject != null) {
            this.f51625a = optJSONObject.optInt("version");
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("special");
        if (optJSONObject2 != null) {
            p pVar = new p();
            this.f51626b = pVar;
            pVar.f(optJSONObject2);
        }
    }
}
