package rx.internal.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import rx.k;
/* loaded from: classes6.dex */
public final class i implements k {
    private volatile boolean nEi;
    private List<k> nJn;

    public i() {
    }

    public i(k... kVarArr) {
        this.nJn = new LinkedList(Arrays.asList(kVarArr));
    }

    public i(k kVar) {
        this.nJn = new LinkedList();
        this.nJn.add(kVar);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.nEi;
    }

    public void add(k kVar) {
        if (!kVar.isUnsubscribed()) {
            if (!this.nEi) {
                synchronized (this) {
                    if (!this.nEi) {
                        List list = this.nJn;
                        if (list == null) {
                            list = new LinkedList();
                            this.nJn = list;
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
        if (!this.nEi) {
            synchronized (this) {
                List<k> list = this.nJn;
                if (!this.nEi && list != null) {
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
        if (!this.nEi) {
            synchronized (this) {
                if (!this.nEi) {
                    this.nEi = true;
                    List<k> list = this.nJn;
                    this.nJn = null;
                    t(list);
                }
            }
        }
    }

    private static void t(Collection<k> collection) {
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
            rx.exceptions.a.fv(arrayList);
        }
    }
}
