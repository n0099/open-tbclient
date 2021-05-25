package d.a.m0.s.c;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    public int f50501a;

    /* renamed from: b  reason: collision with root package name */
    public p f50502b;

    public int a() {
        return this.f50501a;
    }

    public p b() {
        return this.f50502b;
    }

    public void c(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("common");
        if (optJSONObject != null) {
            this.f50501a = optJSONObject.optInt("version");
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("special");
        if (optJSONObject2 != null) {
            p pVar = new p();
            this.f50502b = pVar;
            pVar.f(optJSONObject2);
        }
    }
}
