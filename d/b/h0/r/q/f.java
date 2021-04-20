package d.b.h0.r.q;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public String f51184a;

    /* renamed from: b  reason: collision with root package name */
    public String f51185b;

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        jSONObject.optInt("label_id");
        this.f51184a = jSONObject.optString("label_name");
        this.f51185b = jSONObject.optString("label_rgb");
    }
}
