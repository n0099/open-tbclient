package d.a.n0.t2.f0.b;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public boolean f61065a;

    /* renamed from: b  reason: collision with root package name */
    public double f61066b;

    /* renamed from: c  reason: collision with root package name */
    public List<String> f61067c;

    /* renamed from: d  reason: collision with root package name */
    public int f61068d;

    /* renamed from: e  reason: collision with root package name */
    public int f61069e;

    public static c a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        c cVar = new c();
        cVar.f61065a = jSONObject.optInt("label_measure") == 2;
        cVar.f61066b = jSONObject.optDouble("show_width_scale", 1.0d);
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("thread_pic_list");
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                if (optJSONObject != null) {
                    d.a.n0.k1.o.k.a.a(arrayList, optJSONObject.optString("pic"));
                }
            }
        }
        cVar.f61067c = arrayList;
        cVar.f61068d = jSONObject.optInt("width");
        cVar.f61069e = jSONObject.optInt("height");
        return cVar;
    }
}
