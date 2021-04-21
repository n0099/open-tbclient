package h.o.d;

import h.k;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes7.dex */
public final class i implements k {

    /* renamed from: e  reason: collision with root package name */
    public List<k> f69103e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f69104f;

    public i() {
    }

    public static void c(Collection<k> collection) {
        if (collection == null) {
            return;
        }
        ArrayList arrayList = null;
        for (k kVar : collection) {
            try {
                kVar.unsubscribe();
            } catch (Throwable th) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(th);
            }
        }
        h.m.a.d(arrayList);
    }

    public void a(k kVar) {
        if (kVar.isUnsubscribed()) {
            return;
        }
        if (!this.f69104f) {
            synchronized (this) {
                if (!this.f69104f) {
                    List list = this.f69103e;
                    if (list == null) {
                        list = new LinkedList();
                        this.f69103e = list;
                    }
                    list.add(kVar);
                    return;
                }
            }
        }
        kVar.unsubscribe();
    }

    public void b(k kVar) {
        if (this.f69104f) {
            return;
        }
        synchronized (this) {
            List<k> list = this.f69103e;
            if (!this.f69104f && list != null) {
                boolean remove = list.remove(kVar);
                if (remove) {
                    kVar.unsubscribe();
                }
            }
        }
    }

    @Override // h.k
    public boolean isUnsubscribed() {
        return this.f69104f;
    }

    @Override // h.k
    public void unsubscribe() {
        if (this.f69104f) {
            return;
        }
        synchronized (this) {
            if (this.f69104f) {
                return;
            }
            this.f69104f = true;
            List<k> list = this.f69103e;
            this.f69103e = null;
            c(list);
        }
    }

    public i(k... kVarArr) {
        this.f69103e = new LinkedList(Arrays.asList(kVarArr));
    }

    public i(k kVar) {
        LinkedList linkedList = new LinkedList();
        this.f69103e = linkedList;
        linkedList.add(kVar);
    }
}
