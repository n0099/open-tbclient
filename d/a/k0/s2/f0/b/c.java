package d.a.k0.s2.f0.b;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public boolean f60963a;

    /* renamed from: b  reason: collision with root package name */
    public double f60964b;

    /* renamed from: c  reason: collision with root package name */
    public List<String> f60965c;

    /* renamed from: d  reason: collision with root package name */
    public int f60966d;

    /* renamed from: e  reason: collision with root package name */
    public int f60967e;

    public static c a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        c cVar = new c();
        cVar.f60963a = jSONObject.optInt("label_measure") == 2;
        cVar.f60964b = jSONObject.optDouble("show_width_scale", 1.0d);
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("thread_pic_list");
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                if (optJSONObject != null) {
                    d.a.k0.j1.o.k.a.a(arrayList, optJSONObject.optString("pic"));
                }
            }
        }
        cVar.f60965c = arrayList;
        cVar.f60966d = jSONObject.optInt("width");
        cVar.f60967e = jSONObject.optInt("height");
        return cVar;
    }
}
