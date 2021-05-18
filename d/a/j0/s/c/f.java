package d.a.j0.s.c;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public String f50385a;

    /* renamed from: b  reason: collision with root package name */
    public String f50386b;

    /* renamed from: c  reason: collision with root package name */
    public String f50387c;

    /* renamed from: d  reason: collision with root package name */
    public String f50388d;

    public String a() {
        return this.f50386b;
    }

    public String b() {
        return this.f50385a;
    }

    public String c() {
        return this.f50388d;
    }

    public String d() {
        return this.f50387c;
    }

    public void e(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("homepage");
        if (optJSONObject != null) {
            this.f50385a = optJSONObject.optString("url");
            this.f50386b = optJSONObject.optString("icon_url");
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("pb");
        if (optJSONObject2 != null) {
            this.f50387c = optJSONObject2.optString("url");
            this.f50388d = optJSONObject2.optString("icon_url");
        }
    }
}
