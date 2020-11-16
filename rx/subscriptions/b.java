package rx.subscriptions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import rx.k;
/* loaded from: classes14.dex */
public final class b implements k {
    private volatile boolean qfr;
    private Set<k> qmb;

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.qfr;
    }

    public void add(k kVar) {
        if (!kVar.isUnsubscribed()) {
            if (!this.qfr) {
                synchronized (this) {
                    if (!this.qfr) {
                        if (this.qmb == null) {
                            this.qmb = new HashSet(4);
                        }
                        this.qmb.add(kVar);
                        return;
                    }
                }
            }
            kVar.unsubscribe();
        }
    }

    public void a(k kVar) {
        if (!this.qfr) {
            synchronized (this) {
                if (!this.qfr && this.qmb != null) {
                    boolean remove = this.qmb.remove(kVar);
                    if (remove) {
                        kVar.unsubscribe();
                    }
                }
            }
        }
    }

    @Override // rx.k
    public void unsubscribe() {
        if (!this.qfr) {
            synchronized (this) {
                if (!this.qfr) {
                    this.qfr = true;
                    Set<k> set = this.qmb;
                    this.qmb = null;
                    v(set);
                }
            }
        }
    }

    private static void v(Collection<k> collection) {
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
            rx.exceptions.a.gT(arrayList);
        }
    }
}
