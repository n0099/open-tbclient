package d.b.g0.a.e0.p.n;

import android.os.Bundle;
import d.b.g0.a.r1.m;
import d.b.g0.l.l.f;
import d.b.g0.l.l.g;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class a extends m implements d {
    public a(d.b.g0.a.r1.d dVar) {
        super(dVar);
    }

    public static final Map<String, String> d(Bundle bundle) {
        HashMap hashMap = new HashMap();
        if (bundle != null && !bundle.isEmpty()) {
            for (String str : bundle.keySet()) {
                hashMap.put(str, bundle.getString(str));
            }
        }
        return hashMap;
    }

    public static final Bundle e(Map<String, String> map) {
        Bundle bundle = new Bundle();
        if (map != null && !map.isEmpty()) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                bundle.putString(entry.getKey(), entry.getValue());
            }
        }
        return bundle;
    }

    @Override // d.b.g0.l.l.f
    public void a(String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, f.a aVar) {
        d.b.g0.l.l.a.b(str, map, map2, jSONObject, new g(aVar));
    }

    @Override // d.b.g0.l.l.f
    public void b(String str, Map<String, String> map, Map<String, String> map2, f.a aVar) {
        d.b.g0.l.l.a.a(str, map, map2, new g(aVar));
    }
}
