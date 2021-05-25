package d.a.l0.a.h0.m.n;

import d.a.l0.n.i.g;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c extends a implements g {
    public c(d.a.l0.a.a2.d dVar) {
        super(dVar);
    }

    @Override // d.a.l0.a.h0.m.n.a, d.a.l0.n.i.g
    public void a(String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, g.a aVar) {
        new d.a.l0.n.i.j.c().a(str, map, map2, jSONObject, aVar);
    }

    @Override // d.a.l0.a.h0.m.n.a, d.a.l0.n.i.g
    public void c(String str, Map<String, String> map, Map<String, String> map2, g.a aVar) {
        String a2 = d.a.l0.a.r1.l.d.a();
        if (a2 != null) {
            if (map == null) {
                map = new HashMap<>();
            }
            map.put("launchid", a2);
        }
        new d.a.l0.n.i.j.c().c(str, map, map2, aVar);
    }
}
