package d.a.k0.s.b.i;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.swan.apps.api.SwanApi$$ModulesProvider;
import d.a.i0.b.n.a.h;
import java.util.Map;
@Singleton
@Service
/* loaded from: classes4.dex */
public class e implements d.a.i0.e.i.b {
    @Override // d.a.i0.e.i.d
    @Nullable
    public Map<String, Object> a(@NonNull d.a.i0.a.u.c.b bVar) {
        return SwanApi$$ModulesProvider.getV8ApiModules(bVar);
    }

    @Override // d.a.i0.e.i.d
    public void b(d.a.i0.a.c2.e eVar) {
        if (eVar != null) {
            eVar.b(new g(eVar));
            eVar.b(new d.a.k0.s.b.h.a(eVar));
            eVar.b(new d.a.i0.b.n.a.c(eVar));
            eVar.b(new d.a.i0.b.n.a.e(eVar));
            eVar.b(new d.a.i0.b.n.a.g(eVar));
            eVar.b(new d.a.i0.a.c2.f.h0.a(eVar));
            eVar.b(new d.a.i0.a.c2.f.h0.b(eVar));
            eVar.b(new d.a.i0.b.n.c.b(eVar));
            eVar.b(new h(eVar));
            eVar.b(new d.a.i0.a.q.a(eVar));
            eVar.b(new d(eVar));
        }
    }

    @Override // d.a.i0.e.i.d
    @Nullable
    public Map<String, Object> c(@NonNull d.a.i0.a.u.c.b bVar) {
        return SwanApi$$ModulesProvider.getWebviewApiModules(bVar);
    }
}
