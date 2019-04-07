package rx.internal.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import rx.k;
/* loaded from: classes2.dex */
public final class i implements k {
    private volatile boolean jUO;
    private List<k> kaA;

    public i() {
    }

    public i(k... kVarArr) {
        this.kaA = new LinkedList(Arrays.asList(kVarArr));
    }

    public i(k kVar) {
        this.kaA = new LinkedList();
        this.kaA.add(kVar);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.jUO;
    }

    public void add(k kVar) {
        if (!kVar.isUnsubscribed()) {
            if (!this.jUO) {
                synchronized (this) {
                    if (!this.jUO) {
                        List list = this.kaA;
                        if (list == null) {
                            list = new LinkedList();
                            this.kaA = list;
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
        if (!this.jUO) {
            synchronized (this) {
                List<k> list = this.kaA;
                if (!this.jUO && list != null) {
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
        if (!this.jUO) {
            synchronized (this) {
                if (!this.jUO) {
                    this.jUO = true;
                    List<k> list = this.kaA;
                    this.kaA = null;
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
            rx.exceptions.a.eC(arrayList);
        }
    }
}
