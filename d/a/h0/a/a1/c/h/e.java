package d.a.h0.a.a1.c.h;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e implements d.a.h0.a.e1.a {

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<c> f41192e;

    /* renamed from: f  reason: collision with root package name */
    public int f41193f = 1;

    /* renamed from: g  reason: collision with root package name */
    public int f41194g = -16777216;

    /* renamed from: h  reason: collision with root package name */
    public int f41195h = 0;

    /* renamed from: i  reason: collision with root package name */
    public int f41196i = 0;

    @Override // d.a.h0.a.e1.a
    public void a(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null && jSONObject.has("points")) {
            JSONArray optJSONArray = jSONObject.optJSONArray("points");
            int length = optJSONArray == null ? 0 : optJSONArray.length();
            if (length > 0) {
                this.f41192e = new ArrayList<>(length);
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                    if (optJSONObject != null) {
                        c cVar = new c();
                        cVar.a(optJSONObject);
                        if (cVar.isValid()) {
                            this.f41192e.add(cVar);
                        }
                    }
                }
            }
            ArrayList<c> arrayList = this.f41192e;
            if (arrayList == null || arrayList.size() <= 0) {
                return;
            }
            this.f41193f = (int) Math.abs(d.a.h0.a.a1.c.d.b(jSONObject.optInt("strokeWidth", 1)));
            this.f41194g = d.a.h0.a.a1.c.d.a(jSONObject.optString("strokeColor"), -16777216);
            this.f41195h = d.a.h0.a.a1.c.d.a(jSONObject.optString("fillColor"), 0);
            this.f41196i = jSONObject.optInt("zIndex", 0);
        }
    }

    @Override // d.a.h0.a.e1.a
    public boolean isValid() {
        ArrayList<c> arrayList = this.f41192e;
        return (arrayList == null || arrayList.isEmpty()) ? false : true;
    }
}
