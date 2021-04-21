package d.b.i0.s.c;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public String f51913a;

    /* renamed from: b  reason: collision with root package name */
    public String f51914b;

    /* renamed from: c  reason: collision with root package name */
    public String f51915c;

    /* renamed from: d  reason: collision with root package name */
    public String f51916d;

    public String a() {
        return this.f51914b;
    }

    public String b() {
        return this.f51913a;
    }

    public String c() {
        return this.f51916d;
    }

    public String d() {
        return this.f51915c;
    }

    public void e(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("homepage");
        if (optJSONObject != null) {
            this.f51913a = optJSONObject.optString("url");
            this.f51914b = optJSONObject.optString("icon_url");
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("pb");
        if (optJSONObject2 != null) {
            this.f51915c = optJSONObject2.optString("url");
            this.f51916d = optJSONObject2.optString("icon_url");
        }
    }
}
