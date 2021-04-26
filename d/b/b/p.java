package d.b.b;

import android.content.Context;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class p extends h2 {

    /* renamed from: e  reason: collision with root package name */
    public final Context f64348e;

    /* renamed from: f  reason: collision with root package name */
    public final i f64349f;

    public p(Context context, i iVar) {
        super(true, false);
        this.f64348e = context;
        this.f64349f = iVar;
    }

    @Override // d.b.b.h2
    public boolean b(JSONObject jSONObject) {
        Map<String, String> c2 = x0.c(this.f64348e, this.f64349f.A());
        if (c2 != null) {
            jSONObject.put("oaid", new JSONObject(c2));
            return true;
        }
        return false;
    }
}
