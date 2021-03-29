package d.b.g0.a.a1.c;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends c {
    public String D = "";

    @Override // d.b.g0.a.a1.c.c, d.b.g0.a.a0.b.b, d.b.g0.a.e1.a
    public void a(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return;
        }
        super.a(jSONObject);
        this.D = jSONObject.optString("cb");
    }

    @Override // d.b.g0.a.a0.b.b, d.b.g0.a.e1.a
    public boolean isValid() {
        return !TextUtils.isEmpty(this.D);
    }
}
