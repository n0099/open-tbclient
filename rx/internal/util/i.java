package rx.internal.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import rx.k;
/* loaded from: classes2.dex */
public final class i implements k {
    private List<k> kAt;
    private volatile boolean kuI;

    public i() {
    }

    public i(k... kVarArr) {
        this.kAt = new LinkedList(Arrays.asList(kVarArr));
    }

    public i(k kVar) {
        this.kAt = new LinkedList();
        this.kAt.add(kVar);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.kuI;
    }

    public void add(k kVar) {
        if (!kVar.isUnsubscribed()) {
            if (!this.kuI) {
                synchronized (this) {
                    if (!this.kuI) {
                        List list = this.kAt;
                        if (list == null) {
                            list = new LinkedList();
                            this.kAt = list;
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
        if (!this.kuI) {
            synchronized (this) {
                List<k> list = this.kAt;
                if (!this.kuI && list != null) {
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
        if (!this.kuI) {
            synchronized (this) {
                if (!this.kuI) {
                    this.kuI = true;
                    List<k> list = this.kAt;
                    this.kAt = null;
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
            rx.exceptions.a.eN(arrayList);
        }
    }
}
