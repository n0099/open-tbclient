package d.a.j0.s.c;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    public int f50434a;

    /* renamed from: b  reason: collision with root package name */
    public p f50435b;

    public int a() {
        return this.f50434a;
    }

    public p b() {
        return this.f50435b;
    }

    public void c(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("common");
        if (optJSONObject != null) {
            this.f50434a = optJSONObject.optInt("version");
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("special");
        if (optJSONObject2 != null) {
            p pVar = new p();
            this.f50435b = pVar;
            pVar.f(optJSONObject2);
        }
    }
}
