package d.a.i0.a.h1.c;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends c {
    public String D = "";

    @Override // d.a.i0.a.h1.c.c, d.a.i0.a.c0.b.b, d.a.i0.a.l1.a
    public void a(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return;
        }
        super.a(jSONObject);
        this.D = jSONObject.optString("cb");
        jSONObject.optDouble("latitude");
        jSONObject.optDouble("longitude");
    }

    @Override // d.a.i0.a.c0.b.b, d.a.i0.a.l1.a
    public boolean isValid() {
        return !TextUtils.isEmpty(this.D);
    }
}
