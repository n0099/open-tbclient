package d.b.c.a.b.a.c;

import java.util.LinkedHashSet;
import java.util.Set;
/* loaded from: classes6.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final Set<d.b.c.a.b.e> f69067a = new LinkedHashSet();

    public synchronized void a(d.b.c.a.b.e eVar) {
        this.f69067a.add(eVar);
    }

    public synchronized void b(d.b.c.a.b.e eVar) {
        this.f69067a.remove(eVar);
    }

    public synchronized boolean c(d.b.c.a.b.e eVar) {
        return this.f69067a.contains(eVar);
    }
}
