package d.a.j0.t.j.d;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class r {

    /* renamed from: a  reason: collision with root package name */
    public String f61059a;

    /* renamed from: b  reason: collision with root package name */
    public String f61060b;

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f61059a = jSONObject.optString("name");
        this.f61060b = jSONObject.optString("url");
    }
}
