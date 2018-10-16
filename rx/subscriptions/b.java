package rx.subscriptions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import rx.k;
/* loaded from: classes2.dex */
public final class b implements k {
    private Set<k> iFH;
    private volatile boolean ist;

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.ist;
    }

    public void add(k kVar) {
        if (!kVar.isUnsubscribed()) {
            if (!this.ist) {
                synchronized (this) {
                    if (!this.ist) {
                        if (this.iFH == null) {
                            this.iFH = new HashSet(4);
                        }
                        this.iFH.add(kVar);
                        return;
                    }
                }
            }
            kVar.unsubscribe();
        }
    }

    public void b(k kVar) {
        if (!this.ist) {
            synchronized (this) {
                if (!this.ist && this.iFH != null) {
                    boolean remove = this.iFH.remove(kVar);
                    if (remove) {
                        kVar.unsubscribe();
                    }
                }
            }
        }
    }

    @Override // rx.k
    public void unsubscribe() {
        if (!this.ist) {
            synchronized (this) {
                if (!this.ist) {
                    this.ist = true;
                    Set<k> set = this.iFH;
                    this.iFH = null;
                    k(set);
                }
            }
        }
    }

    private static void k(Collection<k> collection) {
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
            rx.exceptions.a.ex(arrayList);
        }
    }
}
