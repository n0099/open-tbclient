package h.u;

import h.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes7.dex */
public final class b implements k {

    /* renamed from: e  reason: collision with root package name */
    public Set<k> f69025e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f69026f;

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
        if (!this.f69026f) {
            synchronized (this) {
                if (!this.f69026f) {
                    if (this.f69025e == null) {
                        this.f69025e = new HashSet(4);
                    }
                    this.f69025e.add(kVar);
                    return;
                }
            }
        }
        kVar.unsubscribe();
    }

    public void b(k kVar) {
        if (this.f69026f) {
            return;
        }
        synchronized (this) {
            if (!this.f69026f && this.f69025e != null) {
                boolean remove = this.f69025e.remove(kVar);
                if (remove) {
                    kVar.unsubscribe();
                }
            }
        }
    }

    @Override // h.k
    public boolean isUnsubscribed() {
        return this.f69026f;
    }

    @Override // h.k
    public void unsubscribe() {
        if (this.f69026f) {
            return;
        }
        synchronized (this) {
            if (this.f69026f) {
                return;
            }
            this.f69026f = true;
            Set<k> set = this.f69025e;
            this.f69025e = null;
            c(set);
        }
    }
}
