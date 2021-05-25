package d.a.l0.a.u.e.a;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import d.a.l0.a.a2.e;
import d.a.l0.a.p.c.j;
import d.a.l0.a.p.d.n;
import d.a.l0.a.s.a.f;
import d.a.l0.a.v2.w;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends d.a.l0.a.u.c.d {
    public a(@NonNull d.a.l0.a.u.c.b bVar) {
        super(bVar);
    }

    public static boolean s(Context context) {
        boolean h2 = f.f44582d.h();
        if (h2) {
            return h2;
        }
        n a0 = d.a.l0.a.c1.a.a0();
        return a0 instanceof j ? ((j) a0).k(context) : h2;
    }

    public d.a.l0.a.u.h.b r() {
        if (d.a.l0.a.u.c.d.f44812c) {
            Log.d("Api-BaiduAccount", "handle isBaiduAccountSync");
        }
        if (e.Q() == null) {
            return new d.a.l0.a.u.h.b(1001, "SwanApp is null");
        }
        boolean s = s(i());
        JSONObject jSONObject = new JSONObject();
        w.f(jSONObject, "isBaiduAccount", Boolean.valueOf(s));
        return new d.a.l0.a.u.h.b(0, jSONObject);
    }
}
