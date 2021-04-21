package d.b.i0.s.c;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    public int f51961a;

    /* renamed from: b  reason: collision with root package name */
    public p f51962b;

    public int a() {
        return this.f51961a;
    }

    public p b() {
        return this.f51962b;
    }

    public void c(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("common");
        if (optJSONObject != null) {
            this.f51961a = optJSONObject.optInt("version");
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("special");
        if (optJSONObject2 != null) {
            p pVar = new p();
            this.f51962b = pVar;
            pVar.f(optJSONObject2);
        }
    }
}
