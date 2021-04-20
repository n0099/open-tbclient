package d.b.i0.s2.c0.b;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {
    public static c a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        c cVar = new c();
        jSONObject.optInt("label_measure");
        jSONObject.optDouble("show_width_scale", 1.0d);
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("thread_pic_list");
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                try {
                    d.b.i0.j1.o.k.a.a(arrayList, optJSONArray.getString(i));
                } catch (JSONException unused) {
                }
            }
        }
        return cVar;
    }
}
