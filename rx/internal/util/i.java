package rx.internal.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import rx.k;
/* loaded from: classes2.dex */
public final class i implements k {
    private volatile boolean knj;
    private List<k> ksU;

    public i() {
    }

    public i(k... kVarArr) {
        this.ksU = new LinkedList(Arrays.asList(kVarArr));
    }

    public i(k kVar) {
        this.ksU = new LinkedList();
        this.ksU.add(kVar);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.knj;
    }

    public void add(k kVar) {
        if (!kVar.isUnsubscribed()) {
            if (!this.knj) {
                synchronized (this) {
                    if (!this.knj) {
                        List list = this.ksU;
                        if (list == null) {
                            list = new LinkedList();
                            this.ksU = list;
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
        if (!this.knj) {
            synchronized (this) {
                List<k> list = this.ksU;
                if (!this.knj && list != null) {
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
        if (!this.knj) {
            synchronized (this) {
                if (!this.knj) {
                    this.knj = true;
                    List<k> list = this.ksU;
                    this.ksU = null;
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
