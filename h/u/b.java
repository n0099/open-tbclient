package h.u;

import h.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes7.dex */
public final class b implements k {

    /* renamed from: e  reason: collision with root package name */
    public Set<k> f68716e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f68717f;

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
        if (!this.f68717f) {
            synchronized (this) {
                if (!this.f68717f) {
                    if (this.f68716e == null) {
                        this.f68716e = new HashSet(4);
                    }
                    this.f68716e.add(kVar);
                    return;
                }
            }
        }
        kVar.unsubscribe();
    }

    public void b(k kVar) {
        if (this.f68717f) {
            return;
        }
        synchronized (this) {
            if (!this.f68717f && this.f68716e != null) {
                boolean remove = this.f68716e.remove(kVar);
                if (remove) {
                    kVar.unsubscribe();
                }
            }
        }
    }

    @Override // h.k
    public boolean isUnsubscribed() {
        return this.f68717f;
    }

    @Override // h.k
    public void unsubscribe() {
        if (this.f68717f) {
            return;
        }
        synchronized (this) {
            if (this.f68717f) {
                return;
            }
            this.f68717f = true;
            Set<k> set = this.f68716e;
            this.f68716e = null;
            c(set);
        }
    }
}
