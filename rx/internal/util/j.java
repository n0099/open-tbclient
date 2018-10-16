package rx.internal.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import rx.k;
/* loaded from: classes2.dex */
public final class j implements k {
    private List<k> iDq;
    private volatile boolean ist;

    public j() {
    }

    public j(k... kVarArr) {
        this.iDq = new LinkedList(Arrays.asList(kVarArr));
    }

    public j(k kVar) {
        this.iDq = new LinkedList();
        this.iDq.add(kVar);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.ist;
    }

    public void add(k kVar) {
        if (!kVar.isUnsubscribed()) {
            if (!this.ist) {
                synchronized (this) {
                    if (!this.ist) {
                        List list = this.iDq;
                        if (list == null) {
                            list = new LinkedList();
                            this.iDq = list;
                        }
                        list.add(kVar);
                        return;
                    }
                }
            }
            kVar.unsubscribe();
        }
    }

    public void b(k kVar) {
        if (!this.ist) {
            synchronized (this) {
                List<k> list = this.iDq;
                if (!this.ist && list != null) {
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
        if (!this.ist) {
            synchronized (this) {
                if (!this.ist) {
                    this.ist = true;
                    List<k> list = this.iDq;
                    this.iDq = null;
                    k(list);
                }
            }
        }
    }

    private static void k(Collection<k> collection) {
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
            rx.exceptions.a.ex(arrayList);
        }
    }
}
