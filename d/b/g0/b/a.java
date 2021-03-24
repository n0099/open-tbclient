package d.b.g0.b;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.pyramid.annotation.Service;
import com.baidu.swan.bdprivate.api.SwanApi$$ModulesProvider;
import d.b.g0.a.t1.j;
import d.b.g0.b.m.a.i;
import java.util.Map;
@Service
/* loaded from: classes3.dex */
public class a implements d.b.g0.d.f.c {
    @Override // d.b.g0.d.f.d
    @Nullable
    public Map<String, Object> a(@NonNull d.b.g0.a.t.b.b bVar) {
        return SwanApi$$ModulesProvider.getV8ApiModules(bVar);
    }

    @Override // d.b.g0.d.f.d
    public void b(j jVar) {
        jVar.b(new d.b.g0.b.m.a.c(jVar));
        jVar.b(new d.b.g0.b.m.a.g(jVar));
        jVar.b(new d.b.g0.b.m.i.a.c(jVar));
        jVar.b(new d.b.g0.b.m.i.a.b(jVar));
        jVar.b(new d.b.g0.b.m.c.b(jVar));
        jVar.b(new d.b.g0.a.q.a(jVar));
        jVar.b(new d.b.g0.b.m.f.c(jVar));
        jVar.b(new i(jVar));
        jVar.b(new d.b.g0.b.m.a.e(jVar));
        jVar.b(new d.b.g0.b.m.a.h(jVar));
        jVar.b(new d.b.g0.b.m.e.a(jVar));
        jVar.b(new d.b.g0.b.m.f.a(jVar));
        jVar.b(new d.b.g0.b.m.b.a(jVar));
        jVar.b(new d.b.g0.b.m.a.d(jVar));
        jVar.b(new d.b.g0.b.m.a.b(jVar));
        jVar.b(new d.b.g0.b.m.a.a(jVar));
        jVar.b(new d.b.g0.b.m.a.f(jVar));
    }

    @Override // d.b.g0.d.f.d
    @Nullable
    public Map<String, Object> c(@NonNull d.b.g0.a.t.b.b bVar) {
        return SwanApi$$ModulesProvider.getWebviewApiModules(bVar);
    }
}
