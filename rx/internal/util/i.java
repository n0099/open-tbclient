package rx.internal.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import rx.k;
/* loaded from: classes2.dex */
public final class i implements k {
    private List<k> kEy;
    private volatile boolean kyP;

    public i() {
    }

    public i(k... kVarArr) {
        this.kEy = new LinkedList(Arrays.asList(kVarArr));
    }

    public i(k kVar) {
        this.kEy = new LinkedList();
        this.kEy.add(kVar);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.kyP;
    }

    public void add(k kVar) {
        if (!kVar.isUnsubscribed()) {
            if (!this.kyP) {
                synchronized (this) {
                    if (!this.kyP) {
                        List list = this.kEy;
                        if (list == null) {
                            list = new LinkedList();
                            this.kEy = list;
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
        if (!this.kyP) {
            synchronized (this) {
                List<k> list = this.kEy;
                if (!this.kyP && list != null) {
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
        if (!this.kyP) {
            synchronized (this) {
                if (!this.kyP) {
                    this.kyP = true;
                    List<k> list = this.kEy;
                    this.kEy = null;
                    l(list);
                }
            }
        }
    }

    private static void l(Collection<k> collection) {
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
            rx.exceptions.a.fa(arrayList);
        }
    }
}
