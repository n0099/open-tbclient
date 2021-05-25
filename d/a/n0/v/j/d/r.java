package d.a.n0.v.j.d;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class r {

    /* renamed from: a  reason: collision with root package name */
    public String f62071a;

    /* renamed from: b  reason: collision with root package name */
    public String f62072b;

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f62071a = jSONObject.optString("name");
        this.f62072b = jSONObject.optString("url");
    }
}
