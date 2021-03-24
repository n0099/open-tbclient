package d.b.g0.a.a1.c;

import android.text.TextUtils;
import d.b.g0.a.i2.h0;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends c {
    public ArrayList<d.b.g0.a.a1.c.h.c> D;
    public int[] E = {0, 0, 0, 0};

    @Override // d.b.g0.a.a1.c.c, d.b.g0.a.a0.b.b, d.b.g0.a.e1.a
    public void a(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArray;
        JSONArray jSONArray2;
        if (jSONObject == null) {
            return;
        }
        super.a(jSONObject);
        if (jSONObject.has("points") && (jSONArray2 = jSONObject.getJSONArray("points")) != null && jSONArray2.length() > 0) {
            int length = jSONArray2.length();
            this.D = new ArrayList<>(length);
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject2 = jSONArray2.getJSONObject(i);
                if (jSONObject2 != null) {
                    d.b.g0.a.a1.c.h.c cVar = new d.b.g0.a.a1.c.h.c();
                    cVar.a(jSONObject2);
                    if (cVar.isValid()) {
                        this.D.add(cVar);
                    }
                }
            }
        }
        if (!jSONObject.has("padding") || (jSONArray = jSONObject.getJSONArray("padding")) == null || jSONArray.length() <= 0) {
            return;
        }
        int min = Math.min(jSONArray.length(), 4);
        for (int i2 = 0; i2 < min; i2++) {
            this.E[i2] = h0.f(jSONArray.optInt(i2));
        }
    }

    @Override // d.b.g0.a.a0.b.b, d.b.g0.a.e1.a
    public boolean isValid() {
        ArrayList<d.b.g0.a.a1.c.h.c> arrayList;
        return (TextUtils.isEmpty(this.f43113g) || TextUtils.isEmpty(this.f43112f) || (arrayList = this.D) == null || arrayList.size() <= 0) ? false : true;
    }
}
