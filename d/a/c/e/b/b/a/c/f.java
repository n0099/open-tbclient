package d.a.c.e.b.b.a.c;

import java.lang.reflect.Type;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class f implements c {

    /* renamed from: a  reason: collision with root package name */
    public Map<String, Object> f38473a;

    public f(Map<String, Object> map) {
        this.f38473a = map;
    }

    @Override // d.a.c.e.b.b.a.c.c
    public Set<String> a() {
        return this.f38473a.keySet();
    }

    @Override // d.a.c.e.b.b.a.c.c
    public void b(String str, Object obj) {
        this.f38473a.put(str, obj);
    }

    @Override // d.a.c.e.b.b.a.c.c
    public Object c(String str, Type type) {
        Object d2 = d(str);
        if (d2 != null) {
            d.a.c.e.b.b.a.e.c cVar = new d.a.c.e.b.b.a.e.c(type);
            d.a.c.e.b.b.a.d.h a2 = d.a.c.e.b.b.a.e.g.a(d2);
            return a2 != null ? a2.a(cVar) : d2;
        }
        return d2;
    }

    public Object d(String str) {
        return this.f38473a.get(str);
    }
}
