package d.c.c.b.b;

import androidx.annotation.Nullable;
import d.c.c.b.d.k;
import d.c.c.b.d.o;
import java.io.UnsupportedEncodingException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class h extends g<String> {
    public h(int i, String str, @Nullable JSONObject jSONObject, @Nullable o.a<String> aVar) {
        super(i, str, jSONObject == null ? null : jSONObject.toString(), aVar);
    }

    @Override // d.c.c.b.b.g, com.bytedance.sdk.adnet.core.Request
    public o<String> a(k kVar) {
        try {
            return o.c(new String(kVar.f65723b, d.c.c.b.e.c.e(kVar.f65724c, "utf-8")), d.c.c.b.e.c.b(kVar));
        } catch (UnsupportedEncodingException e2) {
            return o.b(new com.bytedance.sdk.adnet.err.e(e2, 604));
        }
    }
}
