package rx.subscriptions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import rx.k;
/* loaded from: classes2.dex */
public final class b implements k {
    private volatile boolean jVw;
    private Set<k> kdc;

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.jVw;
    }

    public void add(k kVar) {
        if (!kVar.isUnsubscribed()) {
            if (!this.jVw) {
                synchronized (this) {
                    if (!this.jVw) {
                        if (this.kdc == null) {
                            this.kdc = new HashSet(4);
                        }
                        this.kdc.add(kVar);
                        return;
                    }
                }
            }
            kVar.unsubscribe();
        }
    }

    public void a(k kVar) {
        if (!this.jVw) {
            synchronized (this) {
                if (!this.jVw && this.kdc != null) {
                    boolean remove = this.kdc.remove(kVar);
                    if (remove) {
                        kVar.unsubscribe();
                    }
                }
            }
        }
    }

    @Override // rx.k
    public void unsubscribe() {
        if (!this.jVw) {
            synchronized (this) {
                if (!this.jVw) {
                    this.jVw = true;
                    Set<k> set = this.kdc;
                    this.kdc = null;
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
            rx.exceptions.a.eF(arrayList);
        }
    }
}
