package rx.subscriptions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import rx.k;
/* loaded from: classes5.dex */
public final class b implements k {
    private Set<k> qFo;
    private volatile boolean qyH;

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.qyH;
    }

    public void add(k kVar) {
        if (!kVar.isUnsubscribed()) {
            if (!this.qyH) {
                synchronized (this) {
                    if (!this.qyH) {
                        if (this.qFo == null) {
                            this.qFo = new HashSet(4);
                        }
                        this.qFo.add(kVar);
                        return;
                    }
                }
            }
            kVar.unsubscribe();
        }
    }

    public void a(k kVar) {
        if (!this.qyH) {
            synchronized (this) {
                if (!this.qyH && this.qFo != null) {
                    boolean remove = this.qFo.remove(kVar);
                    if (remove) {
                        kVar.unsubscribe();
                    }
                }
            }
        }
    }

    @Override // rx.k
    public void unsubscribe() {
        if (!this.qyH) {
            synchronized (this) {
                if (!this.qyH) {
                    this.qyH = true;
                    Set<k> set = this.qFo;
                    this.qFo = null;
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
            rx.exceptions.a.hk(arrayList);
        }
    }
}
