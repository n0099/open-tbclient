package d.a.o0.t2.f0.b;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public boolean f64882a;

    /* renamed from: b  reason: collision with root package name */
    public double f64883b;

    /* renamed from: c  reason: collision with root package name */
    public List<String> f64884c;

    /* renamed from: d  reason: collision with root package name */
    public int f64885d;

    /* renamed from: e  reason: collision with root package name */
    public int f64886e;

    public static c a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        c cVar = new c();
        cVar.f64882a = jSONObject.optInt("label_measure") == 2;
        cVar.f64883b = jSONObject.optDouble("show_width_scale", 1.0d);
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("thread_pic_list");
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                if (optJSONObject != null) {
                    d.a.o0.k1.o.k.a.a(arrayList, optJSONObject.optString("pic"));
                }
            }
        }
        cVar.f64884c = arrayList;
        cVar.f64885d = jSONObject.optInt("width");
        cVar.f64886e = jSONObject.optInt("height");
        return cVar;
    }
}
