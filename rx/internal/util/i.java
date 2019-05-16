package rx.internal.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import rx.k;
/* loaded from: classes2.dex */
public final class i implements k {
    private volatile boolean knf;
    private List<k> ksQ;

    public i() {
    }

    public i(k... kVarArr) {
        this.ksQ = new LinkedList(Arrays.asList(kVarArr));
    }

    public i(k kVar) {
        this.ksQ = new LinkedList();
        this.ksQ.add(kVar);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.knf;
    }

    public void add(k kVar) {
        if (!kVar.isUnsubscribed()) {
            if (!this.knf) {
                synchronized (this) {
                    if (!this.knf) {
                        List list = this.ksQ;
                        if (list == null) {
                            list = new LinkedList();
                            this.ksQ = list;
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
        if (!this.knf) {
            synchronized (this) {
                List<k> list = this.ksQ;
                if (!this.knf && list != null) {
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
        if (!this.knf) {
            synchronized (this) {
                if (!this.knf) {
                    this.knf = true;
                    List<k> list = this.ksQ;
                    this.ksQ = null;
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
            rx.exceptions.a.eK(arrayList);
        }
    }
}
