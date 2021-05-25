package d.a.n0.u.b.i;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.swan.apps.api.SwanApi$$ModulesProvider;
import d.a.l0.b.n.a.g;
import d.a.l0.b.n.a.h;
import java.util.Map;
@Singleton
@Service
/* loaded from: classes4.dex */
public class c implements d.a.l0.e.i.b {
    @Override // d.a.l0.e.i.d
    @Nullable
    public Map<String, Object> a(@NonNull d.a.l0.a.u.c.b bVar) {
        return SwanApi$$ModulesProvider.getV8ApiModules(bVar);
    }

    @Override // d.a.l0.e.i.d
    public void b(d.a.l0.a.c2.e eVar) {
        if (eVar != null) {
            eVar.b(new e(eVar));
            eVar.b(new d.a.n0.u.b.h.a(eVar));
            eVar.b(new d.a.l0.b.n.a.c(eVar));
            eVar.b(new d.a.l0.b.n.a.e(eVar));
            eVar.b(new g(eVar));
            eVar.b(new d.a.l0.a.c2.f.h0.a(eVar));
            eVar.b(new d.a.l0.a.c2.f.h0.b(eVar));
            eVar.b(new d.a.l0.b.n.c.b(eVar));
            eVar.b(new h(eVar));
            eVar.b(new d.a.l0.a.q.a(eVar));
            eVar.b(new b(eVar));
        }
    }

    @Override // d.a.l0.e.i.d
    @Nullable
    public Map<String, Object> c(@NonNull d.a.l0.a.u.c.b bVar) {
        return SwanApi$$ModulesProvider.getWebviewApiModules(bVar);
    }
}
