package d.a.k0.t.j.d;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class r {

    /* renamed from: a  reason: collision with root package name */
    public String f61783a;

    /* renamed from: b  reason: collision with root package name */
    public String f61784b;

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f61783a = jSONObject.optString("name");
        this.f61784b = jSONObject.optString("url");
    }
}
