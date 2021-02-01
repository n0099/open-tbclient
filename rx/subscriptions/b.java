package rx.subscriptions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import rx.k;
/* loaded from: classes5.dex */
public final class b implements k {
    private Set<k> qEO;
    private volatile boolean qyh;

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.qyh;
    }

    public void add(k kVar) {
        if (!kVar.isUnsubscribed()) {
            if (!this.qyh) {
                synchronized (this) {
                    if (!this.qyh) {
                        if (this.qEO == null) {
                            this.qEO = new HashSet(4);
                        }
                        this.qEO.add(kVar);
                        return;
                    }
                }
            }
            kVar.unsubscribe();
        }
    }

    public void a(k kVar) {
        if (!this.qyh) {
            synchronized (this) {
                if (!this.qyh && this.qEO != null) {
                    boolean remove = this.qEO.remove(kVar);
                    if (remove) {
                        kVar.unsubscribe();
                    }
                }
            }
        }
    }

    @Override // rx.k
    public void unsubscribe() {
        if (!this.qyh) {
            synchronized (this) {
                if (!this.qyh) {
                    this.qyh = true;
                    Set<k> set = this.qEO;
                    this.qEO = null;
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
            rx.exceptions.a.hk(arrayList);
        }
    }
}
