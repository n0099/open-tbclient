package rx.internal.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import rx.k;
/* loaded from: classes2.dex */
public final class i implements k {
    private volatile boolean jUP;
    private List<k> kaB;

    public i() {
    }

    public i(k... kVarArr) {
        this.kaB = new LinkedList(Arrays.asList(kVarArr));
    }

    public i(k kVar) {
        this.kaB = new LinkedList();
        this.kaB.add(kVar);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.jUP;
    }

    public void add(k kVar) {
        if (!kVar.isUnsubscribed()) {
            if (!this.jUP) {
                synchronized (this) {
                    if (!this.jUP) {
                        List list = this.kaB;
                        if (list == null) {
                            list = new LinkedList();
                            this.kaB = list;
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
        if (!this.jUP) {
            synchronized (this) {
                List<k> list = this.kaB;
                if (!this.jUP && list != null) {
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
        if (!this.jUP) {
            synchronized (this) {
                if (!this.jUP) {
                    this.jUP = true;
                    List<k> list = this.kaB;
                    this.kaB = null;
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
