package d.c.b;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class f extends h2 {

    /* renamed from: e  reason: collision with root package name */
    public final i f64983e;

    public f(Context context, i iVar) {
        super(true, false);
        this.f64983e = iVar;
    }

    @Override // d.c.b.h2
    public boolean b(JSONObject jSONObject) {
        String a2 = x0.a(this.f64983e.A());
        if (TextUtils.isEmpty(a2)) {
            return false;
        }
        jSONObject.put("cdid", a2);
        return true;
    }
}
