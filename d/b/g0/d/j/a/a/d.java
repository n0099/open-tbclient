package d.b.g0.d.j.a.a;

import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.v8engine.JsObject;
import d.b.g0.a.p.c.v0;
import d.b.g0.e.a.r.n;
import org.json.JSONObject;
@Singleton
@Service
/* loaded from: classes3.dex */
public class d implements v0 {
    @Override // d.b.g0.a.p.c.v0
    public d.b.g0.g.a.b a(d.b.g0.g.i.b bVar, JsObject jsObject) {
        return new d.b.g0.e.a.r.c(bVar, jsObject);
    }

    @Override // d.b.g0.a.p.c.v0
    public d.b.g0.a.o.b b(JSONObject jSONObject, d.b.g0.a.o.d dVar, d.b.g0.a.o.c cVar) {
        return null;
    }

    @Override // d.b.g0.a.p.c.v0
    public d.b.g0.g.a.c c(d.b.g0.g.i.b bVar, JsObject jsObject) {
        return new n(bVar, jsObject);
    }
}
