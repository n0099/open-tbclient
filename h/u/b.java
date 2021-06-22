package h.u;

import h.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes8.dex */
public final class b implements k {

    /* renamed from: e  reason: collision with root package name */
    public Set<k> f72119e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f72120f;

    public static void c(Collection<k> collection) {
        if (collection == null) {
            return;
        }
        ArrayList arrayList = null;
        for (k kVar : collection) {
            try {
                kVar.unsubscribe();
            } catch (Throwable th) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(th);
            }
        }
        h.m.a.d(arrayList);
    }

    public void a(k kVar) {
        if (kVar.isUnsubscribed()) {
            return;
        }
        if (!this.f72120f) {
            synchronized (this) {
                if (!this.f72120f) {
                    if (this.f72119e == null) {
                        this.f72119e = new HashSet(4);
                    }
                    this.f72119e.add(kVar);
                    return;
                }
            }
        }
        kVar.unsubscribe();
    }

    public void b(k kVar) {
        if (this.f72120f) {
            return;
        }
        synchronized (this) {
            if (!this.f72120f && this.f72119e != null) {
                boolean remove = this.f72119e.remove(kVar);
                if (remove) {
                    kVar.unsubscribe();
                }
            }
        }
    }

    @Override // h.k
    public boolean isUnsubscribed() {
        return this.f72120f;
    }

    @Override // h.k
    public void unsubscribe() {
        if (this.f72120f) {
            return;
        }
        synchronized (this) {
            if (this.f72120f) {
                return;
            }
            this.f72120f = true;
            Set<k> set = this.f72119e;
            this.f72119e = null;
            c(set);
        }
    }
}
