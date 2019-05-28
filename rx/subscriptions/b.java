package rx.subscriptions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import rx.k;
/* loaded from: classes2.dex */
public final class b implements k {
    private volatile boolean kng;
    private Set<k> kuL;

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.kng;
    }

    public void add(k kVar) {
        if (!kVar.isUnsubscribed()) {
            if (!this.kng) {
                synchronized (this) {
                    if (!this.kng) {
                        if (this.kuL == null) {
                            this.kuL = new HashSet(4);
                        }
                        this.kuL.add(kVar);
                        return;
                    }
                }
            }
            kVar.unsubscribe();
        }
    }

    public void a(k kVar) {
        if (!this.kng) {
            synchronized (this) {
                if (!this.kng && this.kuL != null) {
                    boolean remove = this.kuL.remove(kVar);
                    if (remove) {
                        kVar.unsubscribe();
                    }
                }
            }
        }
    }

    @Override // rx.k
    public void unsubscribe() {
        if (!this.kng) {
            synchronized (this) {
                if (!this.kng) {
                    this.kng = true;
                    Set<k> set = this.kuL;
                    this.kuL = null;
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
            rx.exceptions.a.eK(arrayList);
        }
    }
}
