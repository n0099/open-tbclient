package rx.subscriptions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import rx.k;
/* loaded from: classes2.dex */
public final class b implements k {
    private Set<k> kDt;
    private volatile boolean kvO;

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.kvO;
    }

    public void add(k kVar) {
        if (!kVar.isUnsubscribed()) {
            if (!this.kvO) {
                synchronized (this) {
                    if (!this.kvO) {
                        if (this.kDt == null) {
                            this.kDt = new HashSet(4);
                        }
                        this.kDt.add(kVar);
                        return;
                    }
                }
            }
            kVar.unsubscribe();
        }
    }

    public void a(k kVar) {
        if (!this.kvO) {
            synchronized (this) {
                if (!this.kvO && this.kDt != null) {
                    boolean remove = this.kDt.remove(kVar);
                    if (remove) {
                        kVar.unsubscribe();
                    }
                }
            }
        }
    }

    @Override // rx.k
    public void unsubscribe() {
        if (!this.kvO) {
            synchronized (this) {
                if (!this.kvO) {
                    this.kvO = true;
                    Set<k> set = this.kDt;
                    this.kDt = null;
                    n(set);
                }
            }
        }
    }

    private static void n(Collection<k> collection) {
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
            rx.exceptions.a.eM(arrayList);
        }
    }
}
