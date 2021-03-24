package d.c.c.a.b.a.c;

import java.util.LinkedHashSet;
import java.util.Set;
/* loaded from: classes5.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final Set<d.c.c.a.b.e> f65196a = new LinkedHashSet();

    public synchronized void a(d.c.c.a.b.e eVar) {
        this.f65196a.add(eVar);
    }

    public synchronized void b(d.c.c.a.b.e eVar) {
        this.f65196a.remove(eVar);
    }

    public synchronized boolean c(d.c.c.a.b.e eVar) {
        return this.f65196a.contains(eVar);
    }
}
