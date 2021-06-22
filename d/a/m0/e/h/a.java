package d.a.m0.e.h;

import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.swan.pms.PMSConstants;
import d.a.m0.n.i.g;
import d.a.m0.n.i.h;
import d.a.m0.n.i.i.f.e;
import java.util.Map;
import org.json.JSONObject;
@Singleton
@Service
/* loaded from: classes3.dex */
public class a implements d.a.m0.n.i.j.b {
    @Override // d.a.m0.n.i.g
    public void a(String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, g.a aVar) {
        if (PMSConstants.a(d.a.m0.n.c.b())) {
            d.a.m0.n.i.a.b(str, map, map2, jSONObject, new d.a.m0.c.a.h.a(aVar));
        } else {
            d.a.m0.n.i.a.b(str, map, map2, jSONObject, new h(aVar));
        }
    }

    @Override // d.a.m0.n.i.j.b
    public e b(String str) throws Exception {
        return d.a.m0.n.i.i.f.c.a(str);
    }

    @Override // d.a.m0.n.i.g
    public void c(String str, Map<String, String> map, Map<String, String> map2, g.a aVar) {
        if (PMSConstants.a(d.a.m0.n.c.b())) {
            d.a.m0.n.i.a.a(str, map, map2, new d.a.m0.c.a.h.a(aVar));
        } else {
            d.a.m0.n.i.a.a(str, map, map2, new h(aVar));
        }
    }
}
