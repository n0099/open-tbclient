package rx.internal.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import rx.k;
/* loaded from: classes6.dex */
public final class i implements k {
    private volatile boolean nNz;
    private List<k> nSC;

    public i() {
    }

    public i(k... kVarArr) {
        this.nSC = new LinkedList(Arrays.asList(kVarArr));
    }

    public i(k kVar) {
        this.nSC = new LinkedList();
        this.nSC.add(kVar);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.nNz;
    }

    public void add(k kVar) {
        if (!kVar.isUnsubscribed()) {
            if (!this.nNz) {
                synchronized (this) {
                    if (!this.nNz) {
                        List list = this.nSC;
                        if (list == null) {
                            list = new LinkedList();
                            this.nSC = list;
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
        if (!this.nNz) {
            synchronized (this) {
                List<k> list = this.nSC;
                if (!this.nNz && list != null) {
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
        if (!this.nNz) {
            synchronized (this) {
                if (!this.nNz) {
                    this.nNz = true;
                    List<k> list = this.nSC;
                    this.nSC = null;
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
