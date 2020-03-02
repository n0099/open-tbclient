package rx.internal.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import rx.k;
/* loaded from: classes6.dex */
public final class i implements k {
    private volatile boolean nNB;
    private List<k> nSE;

    public i() {
    }

    public i(k... kVarArr) {
        this.nSE = new LinkedList(Arrays.asList(kVarArr));
    }

    public i(k kVar) {
        this.nSE = new LinkedList();
        this.nSE.add(kVar);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.nNB;
    }

    public void add(k kVar) {
        if (!kVar.isUnsubscribed()) {
            if (!this.nNB) {
                synchronized (this) {
                    if (!this.nNB) {
                        List list = this.nSE;
                        if (list == null) {
                            list = new LinkedList();
                            this.nSE = list;
                        }
                        list.add(kVar);
                        return;
                    }
                }
            }
            kVar.unsubscribe();
        }
    }

    public void a(k kVar) {
        if (!this.nNB) {
            synchronized (this) {
                List<k> list = this.nSE;
                if (!this.nNB && list != null) {
                    boolean remove = list.remove(kVar);
                    if (remove) {
                        kVar.unsubscribe();
                    }
                }
            }
        }
    }

    @Override // rx.k
    public void unsubscribe() {
        if (!this.nNB) {
            synchronized (this) {
                if (!this.nNB) {
                    this.nNB = true;
                    List<k> list = this.nSE;
                    this.nSE = null;
                    r(list);
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
            rx.exceptions.a.fA(arrayList);
        }
    }
}
