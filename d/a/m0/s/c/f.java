package d.a.m0.s.c;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public String f50446a;

    /* renamed from: b  reason: collision with root package name */
    public String f50447b;

    /* renamed from: c  reason: collision with root package name */
    public String f50448c;

    /* renamed from: d  reason: collision with root package name */
    public String f50449d;

    public String a() {
        return this.f50447b;
    }

    public String b() {
        return this.f50446a;
    }

    public String c() {
        return this.f50449d;
    }

    public String d() {
        return this.f50448c;
    }

    public void e(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("homepage");
        if (optJSONObject != null) {
            this.f50446a = optJSONObject.optString("url");
            this.f50447b = optJSONObject.optString("icon_url");
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("pb");
        if (optJSONObject2 != null) {
            this.f50448c = optJSONObject2.optString("url");
            this.f50449d = optJSONObject2.optString("icon_url");
        }
    }
}
