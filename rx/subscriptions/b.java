package rx.subscriptions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import rx.k;
/* loaded from: classes2.dex */
public final class b implements k {
    private Set<k> kCn;
    private volatile boolean kuI;

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.kuI;
    }

    public void add(k kVar) {
        if (!kVar.isUnsubscribed()) {
            if (!this.kuI) {
                synchronized (this) {
                    if (!this.kuI) {
                        if (this.kCn == null) {
                            this.kCn = new HashSet(4);
                        }
                        this.kCn.add(kVar);
                        return;
                    }
                }
            }
            kVar.unsubscribe();
        }
    }

    public void a(k kVar) {
        if (!this.kuI) {
            synchronized (this) {
                if (!this.kuI && this.kCn != null) {
                    boolean remove = this.kCn.remove(kVar);
                    if (remove) {
                        kVar.unsubscribe();
                    }
                }
            }
        }
    }

    @Override // rx.k
    public void unsubscribe() {
        if (!this.kuI) {
            synchronized (this) {
                if (!this.kuI) {
                    this.kuI = true;
                    Set<k> set = this.kCn;
                    this.kCn = null;
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
            rx.exceptions.a.eN(arrayList);
        }
    }
}
