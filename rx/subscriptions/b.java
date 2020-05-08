package rx.subscriptions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import rx.k;
/* loaded from: classes6.dex */
public final class b implements k {
    private volatile boolean nji;
    private Set<k> npU;

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.nji;
    }

    public void add(k kVar) {
        if (!kVar.isUnsubscribed()) {
            if (!this.nji) {
                synchronized (this) {
                    if (!this.nji) {
                        if (this.npU == null) {
                            this.npU = new HashSet(4);
                        }
                        this.npU.add(kVar);
                        return;
                    }
                }
            }
            kVar.unsubscribe();
        }
    }

    public void a(k kVar) {
        if (!this.nji) {
            synchronized (this) {
                if (!this.nji && this.npU != null) {
                    boolean remove = this.npU.remove(kVar);
                    if (remove) {
                        kVar.unsubscribe();
                    }
                }
            }
        }
    }

    @Override // rx.k
    public void unsubscribe() {
        if (!this.nji) {
            synchronized (this) {
                if (!this.nji) {
                    this.nji = true;
                    Set<k> set = this.npU;
                    this.npU = null;
                    r(set);
                }
            }
        }
    }

    private static void r(Collection<k> collection) {
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
            rx.exceptions.a.fo(arrayList);
        }
    }
}
