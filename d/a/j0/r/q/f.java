package d.a.j0.r.q;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public String f49965a;

    /* renamed from: b  reason: collision with root package name */
    public String f49966b;

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        jSONObject.optInt("label_id");
        this.f49965a = jSONObject.optString("label_name");
        this.f49966b = jSONObject.optString("label_rgb");
    }
}
