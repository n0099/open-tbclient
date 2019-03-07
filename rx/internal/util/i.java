package rx.internal.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import rx.k;
/* loaded from: classes2.dex */
public final class i implements k {
    private volatile boolean jVl;
    private List<k> kaX;

    public i() {
    }

    public i(k... kVarArr) {
        this.kaX = new LinkedList(Arrays.asList(kVarArr));
    }

    public i(k kVar) {
        this.kaX = new LinkedList();
        this.kaX.add(kVar);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.jVl;
    }

    public void add(k kVar) {
        if (!kVar.isUnsubscribed()) {
            if (!this.jVl) {
                synchronized (this) {
                    if (!this.jVl) {
                        List list = this.kaX;
                        if (list == null) {
                            list = new LinkedList();
                            this.kaX = list;
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
        if (!this.jVl) {
            synchronized (this) {
                List<k> list = this.kaX;
                if (!this.jVl && list != null) {
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
        if (!this.jVl) {
            synchronized (this) {
                if (!this.jVl) {
                    this.jVl = true;
                    List<k> list = this.kaX;
                    this.kaX = null;
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
            rx.exceptions.a.eF(arrayList);
        }
    }
}
