package rx.subscriptions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import rx.k;
/* loaded from: classes2.dex */
public final class b implements k {
    private Set<k> iFI;
    private volatile boolean isu;

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.isu;
    }

    public void add(k kVar) {
        if (!kVar.isUnsubscribed()) {
            if (!this.isu) {
                synchronized (this) {
                    if (!this.isu) {
                        if (this.iFI == null) {
                            this.iFI = new HashSet(4);
                        }
                        this.iFI.add(kVar);
                        return;
                    }
                }
            }
            kVar.unsubscribe();
        }
    }

    public void b(k kVar) {
        if (!this.isu) {
            synchronized (this) {
                if (!this.isu && this.iFI != null) {
                    boolean remove = this.iFI.remove(kVar);
                    if (remove) {
                        kVar.unsubscribe();
                    }
                }
            }
        }
    }

    @Override // rx.k
    public void unsubscribe() {
        if (!this.isu) {
            synchronized (this) {
                if (!this.isu) {
                    this.isu = true;
                    Set<k> set = this.iFI;
                    this.iFI = null;
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
