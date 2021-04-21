package d.b.h0.a.a1.c;

import android.text.TextUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e extends c {
    public String D = "";
    public String E = "";
    public ArrayList<String> F;

    @Override // d.b.h0.a.a1.c.c, d.b.h0.a.a0.b.b, d.b.h0.a.e1.a
    public void a(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray;
        if (jSONObject == null) {
            return;
        }
        super.a(jSONObject);
        if (jSONObject.has("scale")) {
            this.o = jSONObject.optDouble("scale", 18.0d);
        }
        if (jSONObject.has("name")) {
            this.D = jSONObject.optString("name");
        }
        if (jSONObject.has("address")) {
            this.E = jSONObject.optString("address");
        }
        if (!jSONObject.has("ignoredApps") || (optJSONArray = jSONObject.optJSONArray("ignoredApps")) == null) {
            return;
        }
        int length = optJSONArray.length();
        this.F = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            this.F.add(optJSONArray.optString(i));
        }
    }

    @Override // d.b.h0.a.a0.b.b, d.b.h0.a.e1.a
    public boolean isValid() {
        d.b.h0.a.a1.c.h.c cVar;
        return (TextUtils.isEmpty(this.f43835g) || (cVar = this.n) == null || !cVar.isValid()) ? false : true;
    }
}
