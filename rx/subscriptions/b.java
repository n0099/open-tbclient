package rx.subscriptions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import rx.k;
/* loaded from: classes14.dex */
public final class b implements k {
    private volatile boolean qod;
    private Set<k> quK;

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.qod;
    }

    public void add(k kVar) {
        if (!kVar.isUnsubscribed()) {
            if (!this.qod) {
                synchronized (this) {
                    if (!this.qod) {
                        if (this.quK == null) {
                            this.quK = new HashSet(4);
                        }
                        this.quK.add(kVar);
                        return;
                    }
                }
            }
            kVar.unsubscribe();
        }
    }

    public void a(k kVar) {
        if (!this.qod) {
            synchronized (this) {
                if (!this.qod && this.quK != null) {
                    boolean remove = this.quK.remove(kVar);
                    if (remove) {
                        kVar.unsubscribe();
                    }
                }
            }
        }
    }

    @Override // rx.k
    public void unsubscribe() {
        if (!this.qod) {
            synchronized (this) {
                if (!this.qod) {
                    this.qod = true;
                    Set<k> set = this.quK;
                    this.quK = null;
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
