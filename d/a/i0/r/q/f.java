package d.a.i0.r.q;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public String f49146a;

    /* renamed from: b  reason: collision with root package name */
    public String f49147b;

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        jSONObject.optInt("label_id");
        this.f49146a = jSONObject.optString("label_name");
        this.f49147b = jSONObject.optString("label_rgb");
    }
}
