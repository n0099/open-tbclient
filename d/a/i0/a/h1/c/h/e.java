package d.a.i0.a.h1.c.h;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e implements d.a.i0.a.l1.a {

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<c> f42513e;

    /* renamed from: f  reason: collision with root package name */
    public int f42514f = 1;

    /* renamed from: g  reason: collision with root package name */
    public int f42515g = -16777216;

    /* renamed from: h  reason: collision with root package name */
    public int f42516h = 0;

    /* renamed from: i  reason: collision with root package name */
    public int f42517i = 0;

    @Override // d.a.i0.a.l1.a
    public void a(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null && jSONObject.has("points")) {
            JSONArray optJSONArray = jSONObject.optJSONArray("points");
            int length = optJSONArray == null ? 0 : optJSONArray.length();
            if (length > 0) {
                this.f42513e = new ArrayList<>(length);
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                    if (optJSONObject != null) {
                        c cVar = new c();
                        cVar.a(optJSONObject);
                        if (cVar.isValid()) {
                            this.f42513e.add(cVar);
                        }
                    }
                }
            }
            ArrayList<c> arrayList = this.f42513e;
            if (arrayList == null || arrayList.size() <= 0) {
                return;
            }
            this.f42514f = (int) Math.abs(d.a.i0.a.h1.c.d.b(jSONObject.optInt("strokeWidth", 1)));
            this.f42515g = d.a.i0.a.h1.c.d.a(jSONObject.optString("strokeColor"), -16777216);
            this.f42516h = d.a.i0.a.h1.c.d.a(jSONObject.optString("fillColor"), 0);
            this.f42517i = jSONObject.optInt("zIndex", 0);
        }
    }

    @Override // d.a.i0.a.l1.a
    public boolean isValid() {
        ArrayList<c> arrayList = this.f42513e;
        return (arrayList == null || arrayList.isEmpty()) ? false : true;
    }
}
