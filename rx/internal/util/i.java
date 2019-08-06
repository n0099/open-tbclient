package rx.internal.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import rx.k;
/* loaded from: classes2.dex */
public final class i implements k {
    private List<k> kBz;
    private volatile boolean kvO;

    public i() {
    }

    public i(k... kVarArr) {
        this.kBz = new LinkedList(Arrays.asList(kVarArr));
    }

    public i(k kVar) {
        this.kBz = new LinkedList();
        this.kBz.add(kVar);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.kvO;
    }

    public void add(k kVar) {
        if (!kVar.isUnsubscribed()) {
            if (!this.kvO) {
                synchronized (this) {
                    if (!this.kvO) {
                        List list = this.kBz;
                        if (list == null) {
                            list = new LinkedList();
                            this.kBz = list;
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
        if (!this.kvO) {
            synchronized (this) {
                List<k> list = this.kBz;
                if (!this.kvO && list != null) {
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
        if (!this.kvO) {
            synchronized (this) {
                if (!this.kvO) {
                    this.kvO = true;
                    List<k> list = this.kBz;
                    this.kBz = null;
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
