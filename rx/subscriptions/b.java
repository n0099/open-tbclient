package rx.subscriptions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import rx.k;
/* loaded from: classes2.dex */
public final class b implements k {
    private volatile boolean iBn;
    private Set<k> iOz;

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.iBn;
    }

    public void add(k kVar) {
        if (!kVar.isUnsubscribed()) {
            if (!this.iBn) {
                synchronized (this) {
                    if (!this.iBn) {
                        if (this.iOz == null) {
                            this.iOz = new HashSet(4);
                        }
                        this.iOz.add(kVar);
                        return;
                    }
                }
            }
            kVar.unsubscribe();
        }
    }

    public void b(k kVar) {
        if (!this.iBn) {
            synchronized (this) {
                if (!this.iBn && this.iOz != null) {
                    boolean remove = this.iOz.remove(kVar);
                    if (remove) {
                        kVar.unsubscribe();
                    }
                }
            }
        }
    }

    @Override // rx.k
    public void unsubscribe() {
        if (!this.iBn) {
            synchronized (this) {
                if (!this.iBn) {
                    this.iBn = true;
                    Set<k> set = this.iOz;
                    this.iOz = null;
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
            rx.exceptions.a.ez(arrayList);
        }
    }
}
