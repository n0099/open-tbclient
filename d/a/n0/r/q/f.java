package d.a.n0.r.q;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public String f53792a;

    /* renamed from: b  reason: collision with root package name */
    public String f53793b;

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        jSONObject.optInt("label_id");
        this.f53792a = jSONObject.optString("label_name");
        this.f53793b = jSONObject.optString("label_rgb");
    }
}
