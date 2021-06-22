package d.a.n0.s.c;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public String f54229a;

    /* renamed from: b  reason: collision with root package name */
    public String f54230b;

    /* renamed from: c  reason: collision with root package name */
    public String f54231c;

    /* renamed from: d  reason: collision with root package name */
    public String f54232d;

    public String a() {
        return this.f54230b;
    }

    public String b() {
        return this.f54229a;
    }

    public String c() {
        return this.f54232d;
    }

    public String d() {
        return this.f54231c;
    }

    public void e(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("homepage");
        if (optJSONObject != null) {
            this.f54229a = optJSONObject.optString("url");
            this.f54230b = optJSONObject.optString("icon_url");
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("pb");
        if (optJSONObject2 != null) {
            this.f54231c = optJSONObject2.optString("url");
            this.f54232d = optJSONObject2.optString("icon_url");
        }
    }
}
