package d.b.b;

import android.content.Context;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class p extends h2 {

    /* renamed from: e  reason: collision with root package name */
    public final Context f68808e;

    /* renamed from: f  reason: collision with root package name */
    public final i f68809f;

    public p(Context context, i iVar) {
        super(true, false);
        this.f68808e = context;
        this.f68809f = iVar;
    }

    @Override // d.b.b.h2
    public boolean b(JSONObject jSONObject) {
        Map<String, String> c2 = x0.c(this.f68808e, this.f68809f.A());
        if (c2 != null) {
            jSONObject.put("oaid", new JSONObject(c2));
            return true;
        }
        return false;
    }
}
