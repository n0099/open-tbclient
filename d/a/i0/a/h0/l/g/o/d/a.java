package d.a.i0.a.h0.l.g.o.d;

import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import d.a.i0.a.a2.e;
import d.a.i0.a.u.c.b;
import d.a.i0.a.u.c.d;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends d {
    public a(@NonNull b bVar) {
        super(bVar);
    }

    public d.a.i0.a.u.h.b r(String str) {
        if (d.f44636c) {
            Log.d("Api-preloadStatus", "start get preloadStatus - " + str);
        }
        if (e.Q() == null) {
            return new d.a.i0.a.u.h.b(1001, "SwanApp is null");
        }
        Pair<d.a.i0.a.u.h.b, JSONObject> b2 = d.a.i0.a.u.i.b.b("Api-preloadStatus", str);
        d.a.i0.a.u.h.b bVar = (d.a.i0.a.u.h.b) b2.first;
        if (!bVar.a()) {
            if (d.f44636c) {
                Log.e("Api-preloadStatus", "parse fail");
            }
            return bVar;
        }
        d.a.i0.a.h0.l.g.o.a.c().j((JSONObject) b2.second);
        return new d.a.i0.a.u.h.b(0);
    }
}
