package rx.subscriptions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import rx.k;
/* loaded from: classes4.dex */
public final class b implements k {
    private Set<k> qFQ;
    private volatile boolean qzj;

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.qzj;
    }

    public void add(k kVar) {
        if (!kVar.isUnsubscribed()) {
            if (!this.qzj) {
                synchronized (this) {
                    if (!this.qzj) {
                        if (this.qFQ == null) {
                            this.qFQ = new HashSet(4);
                        }
                        this.qFQ.add(kVar);
                        return;
                    }
                }
            }
            kVar.unsubscribe();
        }
    }

    public void a(k kVar) {
        if (!this.qzj) {
            synchronized (this) {
                if (!this.qzj && this.qFQ != null) {
                    boolean remove = this.qFQ.remove(kVar);
                    if (remove) {
                        kVar.unsubscribe();
                    }
                }
            }
        }
    }

    @Override // rx.k
    public void unsubscribe() {
        if (!this.qzj) {
            synchronized (this) {
                if (!this.qzj) {
                    this.qzj = true;
                    Set<k> set = this.qFQ;
                    this.qFQ = null;
                    u(set);
                }
            }
        }
    }

    private static void u(Collection<k> collection) {
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
            rx.exceptions.a.hj(arrayList);
        }
    }
}
