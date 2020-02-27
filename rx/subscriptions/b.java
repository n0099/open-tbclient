package rx.subscriptions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import rx.k;
/* loaded from: classes6.dex */
public final class b implements k {
    private volatile boolean nNz;
    private Set<k> nUg;

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.nNz;
    }

    public void add(k kVar) {
        if (!kVar.isUnsubscribed()) {
            if (!this.nNz) {
                synchronized (this) {
                    if (!this.nNz) {
                        if (this.nUg == null) {
                            this.nUg = new HashSet(4);
                        }
                        this.nUg.add(kVar);
                        return;
                    }
                }
            }
            kVar.unsubscribe();
        }
    }

    public void a(k kVar) {
        if (!this.nNz) {
            synchronized (this) {
                if (!this.nNz && this.nUg != null) {
                    boolean remove = this.nUg.remove(kVar);
                    if (remove) {
                        kVar.unsubscribe();
                    }
                }
            }
        }
    }

    @Override // rx.k
    public void unsubscribe() {
        if (!this.nNz) {
            synchronized (this) {
                if (!this.nNz) {
                    this.nNz = true;
                    Set<k> set = this.nUg;
                    this.nUg = null;
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
