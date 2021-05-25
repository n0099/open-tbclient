package d.b.b;

import android.content.Context;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class p extends h2 {

    /* renamed from: e  reason: collision with root package name */
    public final Context f65077e;

    /* renamed from: f  reason: collision with root package name */
    public final i f65078f;

    public p(Context context, i iVar) {
        super(true, false);
        this.f65077e = context;
        this.f65078f = iVar;
    }

    @Override // d.b.b.h2
    public boolean b(JSONObject jSONObject) {
        Map<String, String> c2 = x0.c(this.f65077e, this.f65078f.A());
        if (c2 != null) {
            jSONObject.put("oaid", new JSONObject(c2));
            return true;
        }
        return false;
    }
}
