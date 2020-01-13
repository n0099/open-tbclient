package rx.internal.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import rx.k;
/* loaded from: classes5.dex */
public final class i implements k {
    private volatile boolean nMF;
    private List<k> nRJ;

    public i() {
    }

    public i(k... kVarArr) {
        this.nRJ = new LinkedList(Arrays.asList(kVarArr));
    }

    public i(k kVar) {
        this.nRJ = new LinkedList();
        this.nRJ.add(kVar);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.nMF;
    }

    public void add(k kVar) {
        if (!kVar.isUnsubscribed()) {
            if (!this.nMF) {
                synchronized (this) {
                    if (!this.nMF) {
                        List list = this.nRJ;
                        if (list == null) {
                            list = new LinkedList();
                            this.nRJ = list;
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
        if (!this.nMF) {
            synchronized (this) {
                List<k> list = this.nRJ;
                if (!this.nMF && list != null) {
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
        if (!this.nMF) {
            synchronized (this) {
                if (!this.nMF) {
                    this.nMF = true;
                    List<k> list = this.nRJ;
                    this.nRJ = null;
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
            rx.exceptions.a.fG(arrayList);
        }
    }
}
