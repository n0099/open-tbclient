package rx.internal.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import rx.k;
/* loaded from: classes6.dex */
public final class i implements k {
    private volatile boolean nPz;
    private List<k> nUC;

    public i() {
    }

    public i(k... kVarArr) {
        this.nUC = new LinkedList(Arrays.asList(kVarArr));
    }

    public i(k kVar) {
        this.nUC = new LinkedList();
        this.nUC.add(kVar);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.nPz;
    }

    public void add(k kVar) {
        if (!kVar.isUnsubscribed()) {
            if (!this.nPz) {
                synchronized (this) {
                    if (!this.nPz) {
                        List list = this.nUC;
                        if (list == null) {
                            list = new LinkedList();
                            this.nUC = list;
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
        if (!this.nPz) {
            synchronized (this) {
                List<k> list = this.nUC;
                if (!this.nPz && list != null) {
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
        if (!this.nPz) {
            synchronized (this) {
                if (!this.nPz) {
                    this.nPz = true;
                    List<k> list = this.nUC;
                    this.nUC = null;
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
