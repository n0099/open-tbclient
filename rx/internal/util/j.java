package rx.internal.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import rx.k;
/* loaded from: classes2.dex */
public final class j implements k {
    private List<k> iDr;
    private volatile boolean isu;

    public j() {
    }

    public j(k... kVarArr) {
        this.iDr = new LinkedList(Arrays.asList(kVarArr));
    }

    public j(k kVar) {
        this.iDr = new LinkedList();
        this.iDr.add(kVar);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.isu;
    }

    public void add(k kVar) {
        if (!kVar.isUnsubscribed()) {
            if (!this.isu) {
                synchronized (this) {
                    if (!this.isu) {
                        List list = this.iDr;
                        if (list == null) {
                            list = new LinkedList();
                            this.iDr = list;
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
        if (!this.isu) {
            synchronized (this) {
                List<k> list = this.iDr;
                if (!this.isu && list != null) {
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
        if (!this.isu) {
            synchronized (this) {
                if (!this.isu) {
                    this.isu = true;
                    List<k> list = this.iDr;
                    this.iDr = null;
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
