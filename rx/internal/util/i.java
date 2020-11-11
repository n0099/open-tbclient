package rx.internal.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import rx.k;
/* loaded from: classes16.dex */
public final class i implements k {
    private volatile boolean qdO;
    private List<k> qiU;

    public i() {
    }

    public i(k... kVarArr) {
        this.qiU = new LinkedList(Arrays.asList(kVarArr));
    }

    public i(k kVar) {
        this.qiU = new LinkedList();
        this.qiU.add(kVar);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.qdO;
    }

    public void add(k kVar) {
        if (!kVar.isUnsubscribed()) {
            if (!this.qdO) {
                synchronized (this) {
                    if (!this.qdO) {
                        List list = this.qiU;
                        if (list == null) {
                            list = new LinkedList();
                            this.qiU = list;
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
        if (!this.qdO) {
            synchronized (this) {
                List<k> list = this.qiU;
                if (!this.qdO && list != null) {
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
        if (!this.qdO) {
            synchronized (this) {
                if (!this.qdO) {
                    this.qdO = true;
                    List<k> list = this.qiU;
                    this.qiU = null;
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
