package rx.subscriptions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import rx.k;
/* loaded from: classes5.dex */
public final class b implements k {
    private volatile boolean nMF;
    private Set<k> nTn;

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.nMF;
    }

    public void add(k kVar) {
        if (!kVar.isUnsubscribed()) {
            if (!this.nMF) {
                synchronized (this) {
                    if (!this.nMF) {
                        if (this.nTn == null) {
                            this.nTn = new HashSet(4);
                        }
                        this.nTn.add(kVar);
                        return;
                    }
                }
            }
            kVar.unsubscribe();
        }
    }

    public void a(k kVar) {
        if (!this.nMF) {
            synchronized (this) {
                if (!this.nMF && this.nTn != null) {
                    boolean remove = this.nTn.remove(kVar);
                    if (remove) {
                        kVar.unsubscribe();
                    }
                }
            }
        }
    }

    @Override // rx.k
    public void unsubscribe() {
        if (!this.nMF) {
            synchronized (this) {
                if (!this.nMF) {
                    this.nMF = true;
                    Set<k> set = this.nTn;
                    this.nTn = null;
                    r(set);
                }
            }
        }
    }

    private static void r(Collection<k> collection) {
        if (collection != null) {
            ArrayList arrayList = null;
            for (k kVar : collection) {
                try {
                    kVar.unsubscribe();
                } catch (Throwable th) {
                    ArrayList arrayList2 = arrayList == null ? new ArrayList() : arrayList;
                    arrayList2.add(th);
                    arrayList = arrayList2;
                }
            }
            rx.exceptions.a.fG(arrayList);
        }
    }
}
