package rx.internal.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import rx.k;
/* loaded from: classes15.dex */
public final class i implements k {
    private volatile boolean qqX;
    private List<k> qwa;

    public i() {
    }

    public i(k... kVarArr) {
        this.qwa = new LinkedList(Arrays.asList(kVarArr));
    }

    public i(k kVar) {
        this.qwa = new LinkedList();
        this.qwa.add(kVar);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.qqX;
    }

    public void add(k kVar) {
        if (!kVar.isUnsubscribed()) {
            if (!this.qqX) {
                synchronized (this) {
                    if (!this.qqX) {
                        List list = this.qwa;
                        if (list == null) {
                            list = new LinkedList();
                            this.qwa = list;
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
        if (!this.qqX) {
            synchronized (this) {
                List<k> list = this.qwa;
                if (!this.qqX && list != null) {
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
        if (!this.qqX) {
            synchronized (this) {
                if (!this.qqX) {
                    this.qqX = true;
                    List<k> list = this.qwa;
                    this.qwa = null;
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
            rx.exceptions.a.hn(arrayList);
        }
    }
}
