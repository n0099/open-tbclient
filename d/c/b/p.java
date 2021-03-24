package d.c.b;

import android.content.Context;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class p extends h2 {

    /* renamed from: e  reason: collision with root package name */
    public final Context f65049e;

    /* renamed from: f  reason: collision with root package name */
    public final i f65050f;

    public p(Context context, i iVar) {
        super(true, false);
        this.f65049e = context;
        this.f65050f = iVar;
    }

    @Override // d.c.b.h2
    public boolean b(JSONObject jSONObject) {
        Map<String, String> c2 = x0.c(this.f65049e, this.f65050f.A());
        if (c2 != null) {
            jSONObject.put("oaid", new JSONObject(c2));
            return true;
        }
        return false;
    }
}
