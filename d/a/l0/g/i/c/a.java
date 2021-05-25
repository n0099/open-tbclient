package d.a.l0.g.i.c;

import android.content.Intent;
import android.util.Log;
import androidx.annotation.NonNull;
import d.a.l0.a.a2.e;
import d.a.l0.a.k;
import d.a.l0.a.v2.a0;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends d.a.l0.g.f.a {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f47092c = k.f43199a;

    public a() {
        super("StartAppUsagePage");
    }

    @Override // d.a.l0.g.f.a
    public d.a.l0.a.u.h.b a(@NonNull JSONObject jSONObject, @NonNull d.a.l0.a.u0.b bVar) {
        e Q = e.Q();
        if (Q != null && Q.x() != null) {
            try {
                Q.x().startActivity(new Intent("android.settings.USAGE_ACCESS_SETTINGS"));
            } catch (Exception e2) {
                if (f47092c) {
                    e2.printStackTrace();
                }
                a0.f(Q.x());
            }
            bVar.b(null);
        } else {
            bVar.onFail(100, "swan or activity is null");
            if (f47092c) {
                Log.d("StartAppUsagePage", "swan or activity is null");
            }
        }
        return null;
    }
}
