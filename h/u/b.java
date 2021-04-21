package h.u;

import h.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes7.dex */
public final class b implements k {

    /* renamed from: e  reason: collision with root package name */
    public Set<k> f69172e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f69173f;

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
        if (!this.f69173f) {
            synchronized (this) {
                if (!this.f69173f) {
                    if (this.f69172e == null) {
                        this.f69172e = new HashSet(4);
                    }
                    this.f69172e.add(kVar);
                    return;
                }
            }
        }
        kVar.unsubscribe();
    }

    public void b(k kVar) {
        if (this.f69173f) {
            return;
        }
        synchronized (this) {
            if (!this.f69173f && this.f69172e != null) {
                boolean remove = this.f69172e.remove(kVar);
                if (remove) {
                    kVar.unsubscribe();
                }
            }
        }
    }

    @Override // h.k
    public boolean isUnsubscribed() {
        return this.f69173f;
    }

    @Override // h.k
    public void unsubscribe() {
        if (this.f69173f) {
            return;
        }
        synchronized (this) {
            if (this.f69173f) {
                return;
            }
            this.f69173f = true;
            Set<k> set = this.f69172e;
            this.f69172e = null;
            c(set);
        }
    }
}
