package rx.subscriptions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import rx.k;
/* loaded from: classes6.dex */
public final class b implements k {
    private volatile boolean ojS;
    private Set<k> oqE;

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.ojS;
    }

    public void add(k kVar) {
        if (!kVar.isUnsubscribed()) {
            if (!this.ojS) {
                synchronized (this) {
                    if (!this.ojS) {
                        if (this.oqE == null) {
                            this.oqE = new HashSet(4);
                        }
                        this.oqE.add(kVar);
                        return;
                    }
                }
            }
            kVar.unsubscribe();
        }
    }

    public void a(k kVar) {
        if (!this.ojS) {
            synchronized (this) {
                if (!this.ojS && this.oqE != null) {
                    boolean remove = this.oqE.remove(kVar);
                    if (remove) {
                        kVar.unsubscribe();
                    }
                }
            }
        }
    }

    @Override // rx.k
    public void unsubscribe() {
        if (!this.ojS) {
            synchronized (this) {
                if (!this.ojS) {
                    this.ojS = true;
                    Set<k> set = this.oqE;
                    this.oqE = null;
                    t(set);
                }
            }
        }
    }

    private static void t(Collection<k> collection) {
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
            rx.exceptions.a.fS(arrayList);
        }
    }
}
