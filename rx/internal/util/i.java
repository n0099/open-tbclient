package rx.internal.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import rx.k;
/* loaded from: classes5.dex */
public final class i implements k {
    private List<k> qDk;
    private volatile boolean qyh;

    public i() {
    }

    public i(k... kVarArr) {
        this.qDk = new LinkedList(Arrays.asList(kVarArr));
    }

    public i(k kVar) {
        this.qDk = new LinkedList();
        this.qDk.add(kVar);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.qyh;
    }

    public void add(k kVar) {
        if (!kVar.isUnsubscribed()) {
            if (!this.qyh) {
                synchronized (this) {
                    if (!this.qyh) {
                        List list = this.qDk;
                        if (list == null) {
                            list = new LinkedList();
                            this.qDk = list;
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
        if (!this.qyh) {
            synchronized (this) {
                List<k> list = this.qDk;
                if (!this.qyh && list != null) {
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
        if (!this.qyh) {
            synchronized (this) {
                if (!this.qyh) {
                    this.qyh = true;
                    List<k> list = this.qDk;
                    this.qDk = null;
                    u(list);
                }
            }
        }
    }

    private static void u(Collection<k> collection) {
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
            rx.exceptions.a.hk(arrayList);
        }
    }
}
