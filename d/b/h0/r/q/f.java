package d.b.h0.r.q;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public String f50776a;

    /* renamed from: b  reason: collision with root package name */
    public String f50777b;

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        jSONObject.optInt("label_id");
        this.f50776a = jSONObject.optString("label_name");
        this.f50777b = jSONObject.optString("label_rgb");
    }
}
