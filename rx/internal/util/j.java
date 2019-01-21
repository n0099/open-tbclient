package rx.internal.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import rx.k;
/* loaded from: classes2.dex */
public final class j implements k {
    private volatile boolean iFF;
    private List<k> iQA;

    public j() {
    }

    public j(k... kVarArr) {
        this.iQA = new LinkedList(Arrays.asList(kVarArr));
    }

    public j(k kVar) {
        this.iQA = new LinkedList();
        this.iQA.add(kVar);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.iFF;
    }

    public void add(k kVar) {
        if (!kVar.isUnsubscribed()) {
            if (!this.iFF) {
                synchronized (this) {
                    if (!this.iFF) {
                        List list = this.iQA;
                        if (list == null) {
                            list = new LinkedList();
                            this.iQA = list;
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
        if (!this.iFF) {
            synchronized (this) {
                List<k> list = this.iQA;
                if (!this.iFF && list != null) {
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
        if (!this.iFF) {
            synchronized (this) {
                if (!this.iFF) {
                    this.iFF = true;
                    List<k> list = this.iQA;
                    this.iQA = null;
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
            rx.exceptions.a.eB(arrayList);
        }
    }
}
