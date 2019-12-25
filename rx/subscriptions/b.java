package rx.subscriptions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import rx.k;
/* loaded from: classes4.dex */
public final class b implements k {
    private volatile boolean ndG;
    private Set<k> nkq;

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.ndG;
    }

    public void add(k kVar) {
        if (!kVar.isUnsubscribed()) {
            if (!this.ndG) {
                synchronized (this) {
                    if (!this.ndG) {
                        if (this.nkq == null) {
                            this.nkq = new HashSet(4);
                        }
                        this.nkq.add(kVar);
                        return;
                    }
                }
            }
            kVar.unsubscribe();
        }
    }

    public void a(k kVar) {
        if (!this.ndG) {
            synchronized (this) {
                if (!this.ndG && this.nkq != null) {
                    boolean remove = this.nkq.remove(kVar);
                    if (remove) {
                        kVar.unsubscribe();
                    }
                }
            }
        }
    }

    @Override // rx.k
    public void unsubscribe() {
        if (!this.ndG) {
            synchronized (this) {
                if (!this.ndG) {
                    this.ndG = true;
                    Set<k> set = this.nkq;
                    this.nkq = null;
                    q(set);
                }
            }
        }
    }

    private static void q(Collection<k> collection) {
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
            rx.exceptions.a.fF(arrayList);
        }
    }
}
