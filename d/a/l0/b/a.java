package d.a.l0.b;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.pyramid.annotation.Service;
import com.baidu.swan.bdprivate.api.SwanApi$$ModulesProvider;
import java.util.Map;
@Service
/* loaded from: classes3.dex */
public class a implements d.a.l0.e.i.c {
    @Override // d.a.l0.e.i.d
    @Nullable
    public Map<String, Object> a(@NonNull d.a.l0.a.u.c.b bVar) {
        return SwanApi$$ModulesProvider.getV8ApiModules(bVar);
    }

    @Override // d.a.l0.e.i.d
    public void b(d.a.l0.a.c2.e eVar) {
        eVar.b(new d.a.l0.b.n.a.c(eVar));
        eVar.b(new d.a.l0.b.n.a.g(eVar));
        eVar.b(new d.a.l0.b.n.i.a.c(eVar));
        eVar.b(new d.a.l0.b.n.i.a.b(eVar));
        eVar.b(new d.a.l0.b.n.c.b(eVar));
        eVar.b(new d.a.l0.a.q.a(eVar));
        eVar.b(new d.a.l0.b.n.f.c(eVar));
        eVar.b(new d.a.l0.b.n.a.h(eVar));
        eVar.b(new d.a.l0.b.n.a.e(eVar));
        eVar.b(new d.a.l0.b.n.e.a(eVar));
        eVar.b(new d.a.l0.b.n.f.a(eVar));
        eVar.b(new d.a.l0.b.n.b.a(eVar));
        eVar.b(new d.a.l0.b.n.a.d(eVar));
        eVar.b(new d.a.l0.b.n.a.b(eVar));
        eVar.b(new d.a.l0.b.n.a.a(eVar));
        eVar.b(new d.a.l0.b.n.a.f(eVar));
    }

    @Override // d.a.l0.e.i.d
    @Nullable
    public Map<String, Object> c(@NonNull d.a.l0.a.u.c.b bVar) {
        return SwanApi$$ModulesProvider.getWebviewApiModules(bVar);
    }
}
