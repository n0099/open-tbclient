package d.a.m0.g.i.c;

import android.content.Intent;
import android.util.Log;
import androidx.annotation.NonNull;
import d.a.m0.a.a2.e;
import d.a.m0.a.k;
import d.a.m0.a.v2.a0;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends d.a.m0.g.f.a {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f50874c = k.f46983a;

    public a() {
        super("StartAppUsagePage");
    }

    @Override // d.a.m0.g.f.a
    public d.a.m0.a.u.h.b a(@NonNull JSONObject jSONObject, @NonNull d.a.m0.a.u0.b bVar) {
        e Q = e.Q();
        if (Q != null && Q.x() != null) {
            try {
                Q.x().startActivity(new Intent("android.settings.USAGE_ACCESS_SETTINGS"));
            } catch (Exception e2) {
                if (f50874c) {
                    e2.printStackTrace();
                }
                a0.f(Q.x());
            }
            bVar.a(null);
        } else {
            bVar.onFail(100, "swan or activity is null");
            if (f50874c) {
                Log.d("StartAppUsagePage", "swan or activity is null");
            }
        }
        return null;
    }
}
