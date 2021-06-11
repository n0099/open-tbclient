package d.a.m0.s.c;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    public int f54177a;

    /* renamed from: b  reason: collision with root package name */
    public p f54178b;

    public int a() {
        return this.f54177a;
    }

    public p b() {
        return this.f54178b;
    }

    public void c(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("common");
        if (optJSONObject != null) {
            this.f54177a = optJSONObject.optInt("version");
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("special");
        if (optJSONObject2 != null) {
            p pVar = new p();
            this.f54178b = pVar;
            pVar.f(optJSONObject2);
        }
    }
}
