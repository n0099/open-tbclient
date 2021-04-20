package d.b.i0.t.j.d;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class r {

    /* renamed from: a  reason: collision with root package name */
    public String f62439a;

    /* renamed from: b  reason: collision with root package name */
    public String f62440b;

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f62439a = jSONObject.optString("name");
        this.f62440b = jSONObject.optString("url");
    }
}
