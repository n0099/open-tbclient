package d.b.j0.s2.c0.b;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f62014a;

    public static a a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        a aVar = new a();
        jSONObject.optString("brand_name");
        aVar.f62014a = jSONObject.optString("button_text");
        jSONObject.optString("button_scheme");
        return aVar;
    }
}
