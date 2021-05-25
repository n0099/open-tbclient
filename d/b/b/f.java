package d.b.b;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class f extends h2 {

    /* renamed from: e  reason: collision with root package name */
    public final i f65009e;

    public f(Context context, i iVar) {
        super(true, false);
        this.f65009e = iVar;
    }

    @Override // d.b.b.h2
    public boolean b(JSONObject jSONObject) {
        String a2 = x0.a(this.f65009e.A());
        if (TextUtils.isEmpty(a2)) {
            return false;
        }
        jSONObject.put("cdid", a2);
        return true;
    }
}
