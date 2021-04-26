package d.a.i0.s.c;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public String f49566a;

    /* renamed from: b  reason: collision with root package name */
    public String f49567b;

    /* renamed from: c  reason: collision with root package name */
    public String f49568c;

    /* renamed from: d  reason: collision with root package name */
    public String f49569d;

    public String a() {
        return this.f49567b;
    }

    public String b() {
        return this.f49566a;
    }

    public String c() {
        return this.f49569d;
    }

    public String d() {
        return this.f49568c;
    }

    public void e(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("homepage");
        if (optJSONObject != null) {
            this.f49566a = optJSONObject.optString("url");
            this.f49567b = optJSONObject.optString("icon_url");
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("pb");
        if (optJSONObject2 != null) {
            this.f49568c = optJSONObject2.optString("url");
            this.f49569d = optJSONObject2.optString("icon_url");
        }
    }
}
