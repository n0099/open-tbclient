package d.b.g0.a.a1.c.h;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f implements d.b.g0.a.e1.a {

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<c> f43206e;

    /* renamed from: f  reason: collision with root package name */
    public int f43207f = 0;

    /* renamed from: g  reason: collision with root package name */
    public float f43208g = 0.0f;

    /* renamed from: h  reason: collision with root package name */
    public boolean f43209h = false;

    @Override // d.b.g0.a.e1.a
    public void a(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null && jSONObject.has("points")) {
            JSONArray optJSONArray = jSONObject.optJSONArray("points");
            int length = optJSONArray == null ? 0 : optJSONArray.length();
            if (length > 0) {
                this.f43206e = new ArrayList<>(length);
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        c cVar = new c();
                        cVar.a(optJSONObject);
                        if (cVar.isValid()) {
                            this.f43206e.add(cVar);
                        }
                    }
                }
            }
            ArrayList<c> arrayList = this.f43206e;
            if (arrayList == null || arrayList.size() <= 0) {
                return;
            }
            this.f43207f = d.b.g0.a.a1.c.d.a(jSONObject.optString("color"), 0);
            this.f43208g = Math.abs(d.b.g0.a.a1.c.d.b(jSONObject.optDouble("width", 0.0d)));
            this.f43209h = jSONObject.optBoolean("dottedLine", false);
            jSONObject.optBoolean("arrowLine", false);
            jSONObject.optString("arrowIconPath");
            d.b.g0.a.a1.c.d.a(jSONObject.optString("borderColor"), 0);
            Math.abs(d.b.g0.a.a1.c.d.b(jSONObject.optDouble("borderWidth", 0.0d)));
        }
    }

    @Override // d.b.g0.a.e1.a
    public boolean isValid() {
        ArrayList<c> arrayList = this.f43206e;
        return arrayList != null && arrayList.size() > 0;
    }
}
