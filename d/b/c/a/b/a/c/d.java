package d.b.c.a.b.a.c;

import java.util.LinkedHashSet;
import java.util.Set;
/* loaded from: classes5.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final Set<d.b.c.a.b.e> f64503a = new LinkedHashSet();

    public synchronized void a(d.b.c.a.b.e eVar) {
        this.f64503a.add(eVar);
    }

    public synchronized void b(d.b.c.a.b.e eVar) {
        this.f64503a.remove(eVar);
    }

    public synchronized boolean c(d.b.c.a.b.e eVar) {
        return this.f64503a.contains(eVar);
    }
}
