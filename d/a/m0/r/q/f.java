package d.a.m0.r.q;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public String f53685a;

    /* renamed from: b  reason: collision with root package name */
    public String f53686b;

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        jSONObject.optInt("label_id");
        this.f53685a = jSONObject.optString("label_name");
        this.f53686b = jSONObject.optString("label_rgb");
    }
}
