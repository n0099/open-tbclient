package rx.subscriptions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import rx.k;
/* loaded from: classes15.dex */
public final class b implements k {
    private volatile boolean qsF;
    private Set<k> qzm;

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.qsF;
    }

    public void add(k kVar) {
        if (!kVar.isUnsubscribed()) {
            if (!this.qsF) {
                synchronized (this) {
                    if (!this.qsF) {
                        if (this.qzm == null) {
                            this.qzm = new HashSet(4);
                        }
                        this.qzm.add(kVar);
                        return;
                    }
                }
            }
            kVar.unsubscribe();
        }
    }

    public void a(k kVar) {
        if (!this.qsF) {
            synchronized (this) {
                if (!this.qsF && this.qzm != null) {
                    boolean remove = this.qzm.remove(kVar);
                    if (remove) {
                        kVar.unsubscribe();
                    }
                }
            }
        }
    }

    @Override // rx.k
    public void unsubscribe() {
        if (!this.qsF) {
            synchronized (this) {
                if (!this.qsF) {
                    this.qsF = true;
                    Set<k> set = this.qzm;
                    this.qzm = null;
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
            rx.exceptions.a.ho(arrayList);
        }
    }
}
