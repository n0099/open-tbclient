package d.b.j0.t.j.d;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class r {

    /* renamed from: a  reason: collision with root package name */
    public String f62860a;

    /* renamed from: b  reason: collision with root package name */
    public String f62861b;

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f62860a = jSONObject.optString("name");
        this.f62861b = jSONObject.optString("url");
    }
}
