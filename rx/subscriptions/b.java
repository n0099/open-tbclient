package rx.subscriptions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import rx.k;
/* loaded from: classes6.dex */
public final class b implements k {
    private volatile boolean nNB;
    private Set<k> nUi;

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.nNB;
    }

    public void add(k kVar) {
        if (!kVar.isUnsubscribed()) {
            if (!this.nNB) {
                synchronized (this) {
                    if (!this.nNB) {
                        if (this.nUi == null) {
                            this.nUi = new HashSet(4);
                        }
                        this.nUi.add(kVar);
                        return;
                    }
                }
            }
            kVar.unsubscribe();
        }
    }

    public void a(k kVar) {
        if (!this.nNB) {
            synchronized (this) {
                if (!this.nNB && this.nUi != null) {
                    boolean remove = this.nUi.remove(kVar);
                    if (remove) {
                        kVar.unsubscribe();
                    }
                }
            }
        }
    }

    @Override // rx.k
    public void unsubscribe() {
        if (!this.nNB) {
            synchronized (this) {
                if (!this.nNB) {
                    this.nNB = true;
                    Set<k> set = this.nUi;
                    this.nUi = null;
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
