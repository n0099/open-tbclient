package d.b.j0.s.b.l;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.swan.apps.api.SwanApi$$ModulesProvider;
import d.b.h0.a.t1.j;
import d.b.h0.b.m.a.g;
import d.b.h0.b.m.a.i;
import java.util.Map;
@Singleton
@Service
/* loaded from: classes4.dex */
public class c implements d.b.h0.d.f.b {
    @Override // d.b.h0.d.f.d
    @Nullable
    public Map<String, Object> a(@NonNull d.b.h0.a.t.b.b bVar) {
        return SwanApi$$ModulesProvider.getV8ApiModules(bVar);
    }

    @Override // d.b.h0.d.f.d
    public void b(j jVar) {
        if (jVar != null) {
            jVar.b(new e(jVar));
            jVar.b(new d.b.j0.s.b.k.a(jVar));
            jVar.b(new d.b.h0.b.m.a.c(jVar));
            jVar.b(new d.b.h0.b.m.a.e(jVar));
            jVar.b(new g(jVar));
            jVar.b(new d.b.h0.a.t1.k.h0.a(jVar));
            jVar.b(new d.b.h0.a.t1.k.h0.b(jVar));
            jVar.b(new d.b.h0.b.m.c.b(jVar));
            jVar.b(new i(jVar));
            jVar.b(new d.b.h0.a.q.a(jVar));
            jVar.b(new b(jVar));
        }
    }

    @Override // d.b.h0.d.f.d
    @Nullable
    public Map<String, Object> c(@NonNull d.b.h0.a.t.b.b bVar) {
        return SwanApi$$ModulesProvider.getWebviewApiModules(bVar);
    }
}
