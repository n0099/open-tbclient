package rx.internal.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import rx.k;
/* loaded from: classes14.dex */
public final class i implements k {
    private volatile boolean qfr;
    private List<k> qkx;

    public i() {
    }

    public i(k... kVarArr) {
        this.qkx = new LinkedList(Arrays.asList(kVarArr));
    }

    public i(k kVar) {
        this.qkx = new LinkedList();
        this.qkx.add(kVar);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.qfr;
    }

    public void add(k kVar) {
        if (!kVar.isUnsubscribed()) {
            if (!this.qfr) {
                synchronized (this) {
                    if (!this.qfr) {
                        List list = this.qkx;
                        if (list == null) {
                            list = new LinkedList();
                            this.qkx = list;
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
        if (!this.qfr) {
            synchronized (this) {
                List<k> list = this.qkx;
                if (!this.qfr && list != null) {
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
        if (!this.qfr) {
            synchronized (this) {
                if (!this.qfr) {
                    this.qfr = true;
                    List<k> list = this.qkx;
                    this.qkx = null;
                    v(list);
                }
            }
        }
    }

    private static void v(Collection<k> collection) {
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
            rx.exceptions.a.gT(arrayList);
        }
    }
}
