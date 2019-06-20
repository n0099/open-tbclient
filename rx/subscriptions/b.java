package rx.subscriptions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import rx.k;
/* loaded from: classes2.dex */
public final class b implements k {
    private volatile boolean knj;
    private Set<k> kuO;

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.knj;
    }

    public void add(k kVar) {
        if (!kVar.isUnsubscribed()) {
            if (!this.knj) {
                synchronized (this) {
                    if (!this.knj) {
                        if (this.kuO == null) {
                            this.kuO = new HashSet(4);
                        }
                        this.kuO.add(kVar);
                        return;
                    }
                }
            }
            kVar.unsubscribe();
        }
    }

    public void a(k kVar) {
        if (!this.knj) {
            synchronized (this) {
                if (!this.knj && this.kuO != null) {
                    boolean remove = this.kuO.remove(kVar);
                    if (remove) {
                        kVar.unsubscribe();
                    }
                }
            }
        }
    }

    @Override // rx.k
    public void unsubscribe() {
        if (!this.knj) {
            synchronized (this) {
                if (!this.knj) {
                    this.knj = true;
                    Set<k> set = this.kuO;
                    this.kuO = null;
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
