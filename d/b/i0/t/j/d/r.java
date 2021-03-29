package d.b.i0.t.j.d;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class r {

    /* renamed from: a  reason: collision with root package name */
    public String f60875a;

    /* renamed from: b  reason: collision with root package name */
    public String f60876b;

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f60875a = jSONObject.optString("name");
        this.f60876b = jSONObject.optString("url");
    }
}
