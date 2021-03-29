package d.b.g0.a.a1.c.h;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e implements d.b.g0.a.e1.a {

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<c> f43203e;

    /* renamed from: f  reason: collision with root package name */
    public int f43204f = 1;

    /* renamed from: g  reason: collision with root package name */
    public int f43205g = -16777216;

    /* renamed from: h  reason: collision with root package name */
    public int f43206h = 0;
    public int i = 0;

    @Override // d.b.g0.a.e1.a
    public void a(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null && jSONObject.has("points")) {
            JSONArray optJSONArray = jSONObject.optJSONArray("points");
            int length = optJSONArray == null ? 0 : optJSONArray.length();
            if (length > 0) {
                this.f43203e = new ArrayList<>(length);
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        c cVar = new c();
                        cVar.a(optJSONObject);
                        if (cVar.isValid()) {
                            this.f43203e.add(cVar);
                        }
                    }
                }
            }
            ArrayList<c> arrayList = this.f43203e;
            if (arrayList == null || arrayList.size() <= 0) {
                return;
            }
            this.f43204f = (int) Math.abs(d.b.g0.a.a1.c.d.b(jSONObject.optInt("strokeWidth", 1)));
            this.f43205g = d.b.g0.a.a1.c.d.a(jSONObject.optString("strokeColor"), -16777216);
            this.f43206h = d.b.g0.a.a1.c.d.a(jSONObject.optString("fillColor"), 0);
            this.i = jSONObject.optInt("zIndex", 0);
        }
    }

    @Override // d.b.g0.a.e1.a
    public boolean isValid() {
        ArrayList<c> arrayList = this.f43203e;
        return (arrayList == null || arrayList.isEmpty()) ? false : true;
    }
}
