package d.b.h0.d.f;

import androidx.annotation.NonNull;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import d.b.h0.a.t1.j;
import java.util.HashMap;
import java.util.Map;
@Singleton
@Service
/* loaded from: classes3.dex */
public class e implements d.b.h0.a.w0.c.c {
    @Override // d.b.h0.a.w0.c.c
    public Map<String, Object> a(@NonNull d.b.h0.a.t.b.b bVar) {
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

    @Override // d.b.h0.a.w0.c.c
    public void b(j jVar) {
        a.b().b(jVar);
        a.a().b(jVar);
    }

    @Override // d.b.h0.a.w0.c.c
    public Map<String, Object> c(@NonNull d.b.h0.a.t.b.b bVar) {
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
}
