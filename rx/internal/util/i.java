package rx.internal.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import rx.k;
/* loaded from: classes6.dex */
public final class i implements k {
    private volatile boolean nFs;
    private List<k> nKx;

    public i() {
    }

    public i(k... kVarArr) {
        this.nKx = new LinkedList(Arrays.asList(kVarArr));
    }

    public i(k kVar) {
        this.nKx = new LinkedList();
        this.nKx.add(kVar);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.nFs;
    }

    public void add(k kVar) {
        if (!kVar.isUnsubscribed()) {
            if (!this.nFs) {
                synchronized (this) {
                    if (!this.nFs) {
                        List list = this.nKx;
                        if (list == null) {
                            list = new LinkedList();
                            this.nKx = list;
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
        if (!this.nFs) {
            synchronized (this) {
                List<k> list = this.nKx;
                if (!this.nFs && list != null) {
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
        if (!this.nFs) {
            synchronized (this) {
                if (!this.nFs) {
                    this.nFs = true;
                    List<k> list = this.nKx;
                    this.nKx = null;
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
            rx.exceptions.a.fx(arrayList);
        }
    }
}
