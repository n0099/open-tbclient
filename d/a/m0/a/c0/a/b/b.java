package d.a.m0.a.c0.a.b;

import androidx.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends d.a.m0.a.c0.a.d.b {
    public String x;

    public b(String str, @NonNull String str2) {
        super(str, str2);
        this.x = "";
    }

    @Override // d.a.m0.a.c0.a.d.b, d.a.m0.a.c0.b.b, d.a.m0.a.l1.a
    public void a(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return;
        }
        super.a(jSONObject);
        this.x = jSONObject.optString("src");
    }
}
