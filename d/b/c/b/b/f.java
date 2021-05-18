package d.b.c.b.b;

import androidx.annotation.Nullable;
import d.b.c.b.d.k;
import d.b.c.b.d.o;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class f extends g<JSONObject> {
    public f(int i2, String str, @Nullable JSONObject jSONObject, @Nullable o.a<JSONObject> aVar) {
        this(i2, str, jSONObject == null ? null : jSONObject.toString(), aVar);
    }

    @Override // d.b.c.b.b.g, com.bytedance.sdk.adnet.core.Request
    public o<JSONObject> a(k kVar) {
        try {
            return o.c(new JSONObject(new String(kVar.f65750b, d.b.c.b.e.c.e(kVar.f65751c, "utf-8"))), d.b.c.b.e.c.b(kVar));
        } catch (UnsupportedEncodingException e2) {
            return o.b(new com.bytedance.sdk.adnet.err.e(e2, 604));
        } catch (JSONException e3) {
            return o.b(new com.bytedance.sdk.adnet.err.e(e3, 605));
        }
    }

    public f(int i2, String str, @Nullable String str2, @Nullable o.a<JSONObject> aVar) {
        super(i2, str, str2, aVar);
    }
}
