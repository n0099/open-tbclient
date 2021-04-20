package d.b.h0.s.c;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public String f51577a;

    /* renamed from: b  reason: collision with root package name */
    public String f51578b;

    /* renamed from: c  reason: collision with root package name */
    public String f51579c;

    /* renamed from: d  reason: collision with root package name */
    public String f51580d;

    public String a() {
        return this.f51578b;
    }

    public String b() {
        return this.f51577a;
    }

    public String c() {
        return this.f51580d;
    }

    public String d() {
        return this.f51579c;
    }

    public void e(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("homepage");
        if (optJSONObject != null) {
            this.f51577a = optJSONObject.optString("url");
            this.f51578b = optJSONObject.optString("icon_url");
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("pb");
        if (optJSONObject2 != null) {
            this.f51579c = optJSONObject2.optString("url");
            this.f51580d = optJSONObject2.optString("icon_url");
        }
    }
}
