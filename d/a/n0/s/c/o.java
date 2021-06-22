package d.a.n0.s.c;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    public int f54284a;

    /* renamed from: b  reason: collision with root package name */
    public p f54285b;

    public int a() {
        return this.f54284a;
    }

    public p b() {
        return this.f54285b;
    }

    public void c(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("common");
        if (optJSONObject != null) {
            this.f54284a = optJSONObject.optInt("version");
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("special");
        if (optJSONObject2 != null) {
            p pVar = new p();
            this.f54285b = pVar;
            pVar.f(optJSONObject2);
        }
    }
}
