package d.b.h0.s.c;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    public int f51198a;

    /* renamed from: b  reason: collision with root package name */
    public n f51199b;

    public int a() {
        return this.f51198a;
    }

    public n b() {
        return this.f51199b;
    }

    public void c(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("common");
        if (optJSONObject != null) {
            this.f51198a = optJSONObject.optInt("version");
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("special");
        if (optJSONObject2 != null) {
            n nVar = new n();
            this.f51199b = nVar;
            nVar.f(optJSONObject2);
        }
    }
}
