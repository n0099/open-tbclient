package rx.subscriptions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import rx.k;
/* loaded from: classes6.dex */
public final class b implements k {
    private volatile boolean nPz;
    private Set<k> nWg;

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.nPz;
    }

    public void add(k kVar) {
        if (!kVar.isUnsubscribed()) {
            if (!this.nPz) {
                synchronized (this) {
                    if (!this.nPz) {
                        if (this.nWg == null) {
                            this.nWg = new HashSet(4);
                        }
                        this.nWg.add(kVar);
                        return;
                    }
                }
            }
            kVar.unsubscribe();
        }
    }

    public void a(k kVar) {
        if (!this.nPz) {
            synchronized (this) {
                if (!this.nPz && this.nWg != null) {
                    boolean remove = this.nWg.remove(kVar);
                    if (remove) {
                        kVar.unsubscribe();
                    }
                }
            }
        }
    }

    @Override // rx.k
    public void unsubscribe() {
        if (!this.nPz) {
            synchronized (this) {
                if (!this.nPz) {
                    this.nPz = true;
                    Set<k> set = this.nWg;
                    this.nWg = null;
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
            rx.exceptions.a.fA(arrayList);
        }
    }
}
