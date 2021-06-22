package d.a.o0.v.j.d;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class r {

    /* renamed from: a  reason: collision with root package name */
    public String f65911a;

    /* renamed from: b  reason: collision with root package name */
    public String f65912b;

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f65911a = jSONObject.optString("name");
        this.f65912b = jSONObject.optString("url");
    }
}
