package d.a.l0.a.h0.m.n;

import android.os.Bundle;
import d.a.l0.a.a2.m;
import d.a.l0.n.i.g;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class a extends m implements e {
    public a(d.a.l0.a.a2.d dVar) {
        super(dVar);
    }

    public static final Map<String, String> e(Bundle bundle) {
        HashMap hashMap = new HashMap();
        if (bundle != null && !bundle.isEmpty()) {
            for (String str : bundle.keySet()) {
                hashMap.put(str, bundle.getString(str));
            }
        }
        return hashMap;
    }

    public static final Bundle f(Map<String, String> map) {
        Bundle bundle = new Bundle();
        if (map != null && !map.isEmpty()) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                bundle.putString(entry.getKey(), entry.getValue());
            }
        }
        return bundle;
    }

    @Override // d.a.l0.n.i.g
    public void a(String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, g.a aVar) {
        d.a.l0.a.c1.a.i0().a(str, map, map2, jSONObject, aVar);
    }

    @Override // d.a.l0.n.i.g
    public void c(String str, Map<String, String> map, Map<String, String> map2, g.a aVar) {
        d.a.l0.a.c1.a.i0().c(str, map, map2, aVar);
    }
}
