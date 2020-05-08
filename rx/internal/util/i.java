package rx.internal.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import rx.k;
/* loaded from: classes6.dex */
public final class i implements k {
    private volatile boolean nji;
    private List<k> non;

    public i() {
    }

    public i(k... kVarArr) {
        this.non = new LinkedList(Arrays.asList(kVarArr));
    }

    public i(k kVar) {
        this.non = new LinkedList();
        this.non.add(kVar);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.nji;
    }

    public void add(k kVar) {
        if (!kVar.isUnsubscribed()) {
            if (!this.nji) {
                synchronized (this) {
                    if (!this.nji) {
                        List list = this.non;
                        if (list == null) {
                            list = new LinkedList();
                            this.non = list;
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
        if (!this.nji) {
            synchronized (this) {
                List<k> list = this.non;
                if (!this.nji && list != null) {
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
        if (!this.nji) {
            synchronized (this) {
                if (!this.nji) {
                    this.nji = true;
                    List<k> list = this.non;
                    this.non = null;
                    r(list);
                }
            }
        }
    }

    private static void r(Collection<k> collection) {
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
            rx.exceptions.a.fo(arrayList);
        }
    }
}
