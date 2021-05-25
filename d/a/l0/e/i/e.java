package d.a.l0.e.i;

import androidx.annotation.NonNull;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import java.util.HashMap;
import java.util.Map;
@Singleton
@Service
/* loaded from: classes3.dex */
public class e implements d.a.l0.a.c1.d.c {
    @Override // d.a.l0.a.c1.d.c
    public Map<String, Object> a(@NonNull d.a.l0.a.u.c.b bVar) {
        Map<String, Object> a2 = a.b().a(bVar);
        Map<String, Object> a3 = a.a().a(bVar);
        HashMap hashMap = new HashMap();
        if (a2 != null) {
            hashMap.putAll(a2);
        }
        if (a3 != null) {
            hashMap.putAll(a3);
        }
        return hashMap;
    }

    @Override // d.a.l0.a.c1.d.c
    public void b(d.a.l0.a.c2.e eVar) {
        a.b().b(eVar);
        a.a().b(eVar);
    }

    @Override // d.a.l0.a.c1.d.c
    public Map<String, Object> c(@NonNull d.a.l0.a.u.c.b bVar) {
        Map<String, Object> c2 = a.b().c(bVar);
        Map<String, Object> c3 = a.a().c(bVar);
        HashMap hashMap = new HashMap();
        if (c2 != null) {
            hashMap.putAll(c2);
        }
        if (c3 != null) {
            hashMap.putAll(c3);
        }
        return hashMap;
    }

    @Override // d.a.l0.a.c1.d.c
    public Map<Class, Object> d() {
        return null;
    }
}
