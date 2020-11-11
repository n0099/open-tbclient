package rx.subscriptions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import rx.k;
/* loaded from: classes16.dex */
public final class b implements k {
    private volatile boolean qdO;
    private Set<k> qky;

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.qdO;
    }

    public void add(k kVar) {
        if (!kVar.isUnsubscribed()) {
            if (!this.qdO) {
                synchronized (this) {
                    if (!this.qdO) {
                        if (this.qky == null) {
                            this.qky = new HashSet(4);
                        }
                        this.qky.add(kVar);
                        return;
                    }
                }
            }
            kVar.unsubscribe();
        }
    }

    public void a(k kVar) {
        if (!this.qdO) {
            synchronized (this) {
                if (!this.qdO && this.qky != null) {
                    boolean remove = this.qky.remove(kVar);
                    if (remove) {
                        kVar.unsubscribe();
                    }
                }
            }
        }
    }

    @Override // rx.k
    public void unsubscribe() {
        if (!this.qdO) {
            synchronized (this) {
                if (!this.qdO) {
                    this.qdO = true;
                    Set<k> set = this.qky;
                    this.qky = null;
                    v(set);
                }
            }
        }
    }

    private static void v(Collection<k> collection) {
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
            rx.exceptions.a.gT(arrayList);
        }
    }
}
