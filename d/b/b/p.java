package d.b.b;

import android.content.Context;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class p extends h2 {

    /* renamed from: e  reason: collision with root package name */
    public final Context f68912e;

    /* renamed from: f  reason: collision with root package name */
    public final i f68913f;

    public p(Context context, i iVar) {
        super(true, false);
        this.f68912e = context;
        this.f68913f = iVar;
    }

    @Override // d.b.b.h2
    public boolean b(JSONObject jSONObject) {
        Map<String, String> c2 = x0.c(this.f68912e, this.f68913f.A());
        if (c2 != null) {
            jSONObject.put("oaid", new JSONObject(c2));
            return true;
        }
        return false;
    }
}
