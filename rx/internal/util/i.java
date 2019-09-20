package rx.internal.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import rx.k;
/* loaded from: classes2.dex */
public final class i implements k {
    private List<k> kDR;
    private volatile boolean kyh;

    public i() {
    }

    public i(k... kVarArr) {
        this.kDR = new LinkedList(Arrays.asList(kVarArr));
    }

    public i(k kVar) {
        this.kDR = new LinkedList();
        this.kDR.add(kVar);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.kyh;
    }

    public void add(k kVar) {
        if (!kVar.isUnsubscribed()) {
            if (!this.kyh) {
                synchronized (this) {
                    if (!this.kyh) {
                        List list = this.kDR;
                        if (list == null) {
                            list = new LinkedList();
                            this.kDR = list;
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
        if (!this.kyh) {
            synchronized (this) {
                List<k> list = this.kDR;
                if (!this.kyh && list != null) {
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
        if (!this.kyh) {
            synchronized (this) {
                if (!this.kyh) {
                    this.kyh = true;
                    List<k> list = this.kDR;
                    this.kDR = null;
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
            rx.exceptions.a.eM(arrayList);
        }
    }
}
