package rx.internal.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import rx.k;
/* loaded from: classes2.dex */
public final class i implements k {
    private volatile boolean jVw;
    private List<k> kbi;

    public i() {
    }

    public i(k... kVarArr) {
        this.kbi = new LinkedList(Arrays.asList(kVarArr));
    }

    public i(k kVar) {
        this.kbi = new LinkedList();
        this.kbi.add(kVar);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.jVw;
    }

    public void add(k kVar) {
        if (!kVar.isUnsubscribed()) {
            if (!this.jVw) {
                synchronized (this) {
                    if (!this.jVw) {
                        List list = this.kbi;
                        if (list == null) {
                            list = new LinkedList();
                            this.kbi = list;
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
        if (!this.jVw) {
            synchronized (this) {
                List<k> list = this.kbi;
                if (!this.jVw && list != null) {
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
        if (!this.jVw) {
            synchronized (this) {
                if (!this.jVw) {
                    this.jVw = true;
                    List<k> list = this.kbi;
                    this.kbi = null;
                    n(list);
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
            rx.exceptions.a.eF(arrayList);
        }
    }
}
