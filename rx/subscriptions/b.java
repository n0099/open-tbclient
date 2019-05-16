package rx.subscriptions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import rx.k;
/* loaded from: classes2.dex */
public final class b implements k {
    private volatile boolean knf;
    private Set<k> kuK;

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.knf;
    }

    public void add(k kVar) {
        if (!kVar.isUnsubscribed()) {
            if (!this.knf) {
                synchronized (this) {
                    if (!this.knf) {
                        if (this.kuK == null) {
                            this.kuK = new HashSet(4);
                        }
                        this.kuK.add(kVar);
                        return;
                    }
                }
            }
            kVar.unsubscribe();
        }
    }

    public void a(k kVar) {
        if (!this.knf) {
            synchronized (this) {
                if (!this.knf && this.kuK != null) {
                    boolean remove = this.kuK.remove(kVar);
                    if (remove) {
                        kVar.unsubscribe();
                    }
                }
            }
        }
    }

    @Override // rx.k
    public void unsubscribe() {
        if (!this.knf) {
            synchronized (this) {
                if (!this.knf) {
                    this.knf = true;
                    Set<k> set = this.kuK;
                    this.kuK = null;
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
