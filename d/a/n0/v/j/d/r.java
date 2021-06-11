package d.a.n0.v.j.d;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class r {

    /* renamed from: a  reason: collision with root package name */
    public String f65786a;

    /* renamed from: b  reason: collision with root package name */
    public String f65787b;

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f65786a = jSONObject.optString("name");
        this.f65787b = jSONObject.optString("url");
    }
}
