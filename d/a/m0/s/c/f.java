package d.a.m0.s.c;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public String f54122a;

    /* renamed from: b  reason: collision with root package name */
    public String f54123b;

    /* renamed from: c  reason: collision with root package name */
    public String f54124c;

    /* renamed from: d  reason: collision with root package name */
    public String f54125d;

    public String a() {
        return this.f54123b;
    }

    public String b() {
        return this.f54122a;
    }

    public String c() {
        return this.f54125d;
    }

    public String d() {
        return this.f54124c;
    }

    public void e(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("homepage");
        if (optJSONObject != null) {
            this.f54122a = optJSONObject.optString("url");
            this.f54123b = optJSONObject.optString("icon_url");
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("pb");
        if (optJSONObject2 != null) {
            this.f54124c = optJSONObject2.optString("url");
            this.f54125d = optJSONObject2.optString("icon_url");
        }
    }
}
