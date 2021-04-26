package d.a.h0.d.j.a.a;

import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.v8engine.JsObject;
import d.a.h0.a.p.c.v0;
import d.a.h0.e.a.r.n;
import org.json.JSONObject;
@Singleton
@Service
/* loaded from: classes3.dex */
public class d implements v0 {
    @Override // d.a.h0.a.p.c.v0
    public d.a.h0.a.o.b a(JSONObject jSONObject, d.a.h0.a.o.d dVar, d.a.h0.a.o.c cVar) {
        return null;
    }

    @Override // d.a.h0.a.p.c.v0
    public d.a.h0.g.a.c b(d.a.h0.g.i.b bVar, JsObject jsObject) {
        return new n(bVar, jsObject);
    }

    @Override // d.a.h0.a.p.c.v0
    public d.a.h0.g.a.b c(d.a.h0.g.i.b bVar, JsObject jsObject) {
        return new d.a.h0.e.a.r.c(bVar, jsObject);
    }
}
