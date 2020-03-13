package rx.internal.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import rx.k;
/* loaded from: classes6.dex */
public final class i implements k {
    private volatile boolean nNM;
    private List<k> nSP;

    public i() {
    }

    public i(k... kVarArr) {
        this.nSP = new LinkedList(Arrays.asList(kVarArr));
    }

    public i(k kVar) {
        this.nSP = new LinkedList();
        this.nSP.add(kVar);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.nNM;
    }

    public void add(k kVar) {
        if (!kVar.isUnsubscribed()) {
            if (!this.nNM) {
                synchronized (this) {
                    if (!this.nNM) {
                        List list = this.nSP;
                        if (list == null) {
                            list = new LinkedList();
                            this.nSP = list;
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
        if (!this.nNM) {
            synchronized (this) {
                List<k> list = this.nSP;
                if (!this.nNM && list != null) {
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
        if (!this.nNM) {
            synchronized (this) {
                if (!this.nNM) {
                    this.nNM = true;
                    List<k> list = this.nSP;
                    this.nSP = null;
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
