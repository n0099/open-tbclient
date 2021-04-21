package d.b.h0.d.j.a.a;

import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.v8engine.JsObject;
import d.b.h0.a.p.c.v0;
import d.b.h0.e.a.r.n;
import org.json.JSONObject;
@Singleton
@Service
/* loaded from: classes3.dex */
public class d implements v0 {
    @Override // d.b.h0.a.p.c.v0
    public d.b.h0.g.a.b a(d.b.h0.g.i.b bVar, JsObject jsObject) {
        return new d.b.h0.e.a.r.c(bVar, jsObject);
    }

    @Override // d.b.h0.a.p.c.v0
    public d.b.h0.a.o.b b(JSONObject jSONObject, d.b.h0.a.o.d dVar, d.b.h0.a.o.c cVar) {
        return null;
    }

    @Override // d.b.h0.a.p.c.v0
    public d.b.h0.g.a.c c(d.b.h0.g.i.b bVar, JsObject jsObject) {
        return new n(bVar, jsObject);
    }
}
