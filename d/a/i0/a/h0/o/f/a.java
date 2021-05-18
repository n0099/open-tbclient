package d.a.i0.a.h0.o.f;

import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import d.a.i0.a.u.c.b;
import d.a.i0.a.u.c.d;
import d.a.i0.a.v2.w;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends d {
    public a(@NonNull b bVar) {
        super(bVar);
    }

    public d.a.i0.a.u.h.b r(String str) {
        if (d.a.i0.a.h0.o.g.a.f42275a) {
            Log.d("SwanPrefetch", "receive prefetchResources data = " + str);
        }
        Pair<d.a.i0.a.u.h.b, JSONObject> b2 = d.a.i0.a.u.i.b.b("Api-Base", str);
        JSONObject jSONObject = (JSONObject) b2.second;
        if (jSONObject == null) {
            return (d.a.i0.a.u.h.b) b2.first;
        }
        if (!SwanAppNetworkUtils.i(d.a.i0.a.c1.a.b())) {
            return new d.a.i0.a.u.h.b(1001, "network disconnected");
        }
        JSONArray c2 = w.c(jSONObject, "video");
        if (c2 != null && c2.length() > 0) {
            d.a.i0.a.c1.a.P().a(c2);
        }
        JSONArray c3 = w.c(jSONObject, "image");
        if (c3 != null && c3.length() > 0) {
            d.a.i0.a.c1.a.P().c(c3);
        }
        return new d.a.i0.a.u.h.b(0);
    }
}
