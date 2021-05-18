package d.a.i0.a.h1.c.h;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f implements d.a.i0.a.l1.a {

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<c> f42518e;

    /* renamed from: f  reason: collision with root package name */
    public int f42519f = 0;

    /* renamed from: g  reason: collision with root package name */
    public float f42520g = 0.0f;

    /* renamed from: h  reason: collision with root package name */
    public boolean f42521h = false;

    @Override // d.a.i0.a.l1.a
    public void a(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null && jSONObject.has("points")) {
            JSONArray optJSONArray = jSONObject.optJSONArray("points");
            int length = optJSONArray == null ? 0 : optJSONArray.length();
            if (length > 0) {
                this.f42518e = new ArrayList<>(length);
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                    if (optJSONObject != null) {
                        c cVar = new c();
                        cVar.a(optJSONObject);
                        if (cVar.isValid()) {
                            this.f42518e.add(cVar);
                        }
                    }
                }
            }
            ArrayList<c> arrayList = this.f42518e;
            if (arrayList == null || arrayList.size() <= 0) {
                return;
            }
            this.f42519f = d.a.i0.a.h1.c.d.a(jSONObject.optString("color"), 0);
            this.f42520g = Math.abs(d.a.i0.a.h1.c.d.b(jSONObject.optDouble("width", 0.0d)));
            this.f42521h = jSONObject.optBoolean("dottedLine", false);
            jSONObject.optBoolean("arrowLine", false);
            jSONObject.optString("arrowIconPath");
            d.a.i0.a.h1.c.d.a(jSONObject.optString("borderColor"), 0);
            Math.abs(d.a.i0.a.h1.c.d.b(jSONObject.optDouble("borderWidth", 0.0d)));
        }
    }

    @Override // d.a.i0.a.l1.a
    public boolean isValid() {
        ArrayList<c> arrayList = this.f42518e;
        return arrayList != null && arrayList.size() > 0;
    }
}
