package d.b.c.b.b;

import androidx.annotation.Nullable;
import d.b.c.b.d.k;
import d.b.c.b.d.o;
import java.io.UnsupportedEncodingException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class h extends g<String> {
    public h(int i2, String str, @Nullable JSONObject jSONObject, @Nullable o.a<String> aVar) {
        super(i2, str, jSONObject == null ? null : jSONObject.toString(), aVar);
    }

    @Override // d.b.c.b.b.g, com.bytedance.sdk.adnet.core.Request
    public o<String> a(k kVar) {
        try {
            return o.c(new String(kVar.f65064b, d.b.c.b.e.c.e(kVar.f65065c, "utf-8")), d.b.c.b.e.c.b(kVar));
        } catch (UnsupportedEncodingException e2) {
            return o.b(new com.bytedance.sdk.adnet.err.e(e2, 604));
        }
    }
}
