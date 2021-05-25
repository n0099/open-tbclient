package d.a.l0.a.h1.c;

import android.text.TextUtils;
import d.a.l0.a.v2.n0;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends c {
    public ArrayList<d.a.l0.a.h1.c.h.c> D;
    public int[] E = {0, 0, 0, 0};

    @Override // d.a.l0.a.h1.c.c, d.a.l0.a.c0.b.b, d.a.l0.a.l1.a
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
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject jSONObject2 = jSONArray2.getJSONObject(i2);
                if (jSONObject2 != null) {
                    d.a.l0.a.h1.c.h.c cVar = new d.a.l0.a.h1.c.h.c();
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
        for (int i3 = 0; i3 < min; i3++) {
            this.E[i3] = n0.g(jSONArray.optInt(i3));
        }
    }

    @Override // d.a.l0.a.c0.b.b, d.a.l0.a.l1.a
    public boolean isValid() {
        ArrayList<d.a.l0.a.h1.c.h.c> arrayList;
        return (TextUtils.isEmpty(this.f40846g) || TextUtils.isEmpty(this.f40845f) || (arrayList = this.D) == null || arrayList.size() <= 0) ? false : true;
    }
}
