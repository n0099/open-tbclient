package d.a.m0.r.q;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public String f50009a;

    /* renamed from: b  reason: collision with root package name */
    public String f50010b;

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        jSONObject.optInt("label_id");
        this.f50009a = jSONObject.optString("label_name");
        this.f50010b = jSONObject.optString("label_rgb");
    }
}
