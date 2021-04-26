package d.a.j0.s2.e0.b;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f60227a;

    public static a a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        a aVar = new a();
        jSONObject.optString("brand_name");
        aVar.f60227a = jSONObject.optString("button_text");
        jSONObject.optString("button_scheme");
        return aVar;
    }
}
