package com.kwad.framework.filedownloader.b;

import android.util.SparseArray;
import com.kwad.framework.filedownloader.b.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes10.dex */
public final class b implements com.kwad.framework.filedownloader.b.a {
    public final SparseArray<com.kwad.framework.filedownloader.d.c> aeY = new SparseArray<>();
    public final SparseArray<List<com.kwad.framework.filedownloader.d.a>> aeZ = new SparseArray<>();

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i, long j, String str, String str2) {
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i, String str, long j, long j2, int i2) {
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i, Throwable th) {
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i, Throwable th, long j) {
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void be(int i) {
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void bj(int i) {
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void c(int i, long j) {
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void e(int i, long j) {
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void u(int i, int i2) {
    }

    /* loaded from: classes10.dex */
    public class a implements a.InterfaceC0678a {
        @Override // com.kwad.framework.filedownloader.b.a.InterfaceC0678a
        public final void a(int i, com.kwad.framework.filedownloader.d.c cVar) {
        }

        @Override // com.kwad.framework.filedownloader.b.a.InterfaceC0678a
        public final void c(com.kwad.framework.filedownloader.d.c cVar) {
        }

        @Override // com.kwad.framework.filedownloader.b.a.InterfaceC0678a
        public final void uW() {
        }

        public a() {
        }

        @Override // java.lang.Iterable
        public final Iterator<com.kwad.framework.filedownloader.d.c> iterator() {
            return new C0679b();
        }
    }

    /* renamed from: com.kwad.framework.filedownloader.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class C0679b implements Iterator<com.kwad.framework.filedownloader.d.c> {
        @Override // java.util.Iterator
        public final boolean hasNext() {
            return false;
        }

        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.Iterator
        public final /* bridge */ /* synthetic */ com.kwad.framework.filedownloader.d.c next() {
            return null;
        }

        @Override // java.util.Iterator
        public final void remove() {
        }

        public C0679b() {
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void clear() {
        synchronized (this.aeY) {
            this.aeY.clear();
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final a.InterfaceC0678a uV() {
        return new a();
    }

    private void d(com.kwad.framework.filedownloader.d.c cVar) {
        synchronized (this.aeY) {
            this.aeY.put(cVar.getId(), cVar);
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(com.kwad.framework.filedownloader.d.a aVar) {
        List<com.kwad.framework.filedownloader.d.a> list;
        try {
            int id = aVar.getId();
            synchronized (this.aeZ) {
                list = this.aeZ.get(id);
                if (list == null) {
                    list = new ArrayList<>();
                    this.aeZ.put(id, list);
                }
            }
            list.add(aVar);
        } catch (Exception unused) {
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final com.kwad.framework.filedownloader.d.c bf(int i) {
        com.kwad.framework.filedownloader.d.c cVar;
        synchronized (this.aeY) {
            cVar = this.aeY.get(i);
        }
        return cVar;
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final List<com.kwad.framework.filedownloader.d.a> bg(int i) {
        List<com.kwad.framework.filedownloader.d.a> list;
        try {
            ArrayList arrayList = new ArrayList();
            synchronized (this.aeZ) {
                list = this.aeZ.get(i);
            }
            if (list != null) {
                arrayList.addAll(list);
            }
            return arrayList;
        } catch (Exception unused) {
            return new ArrayList();
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void bh(int i) {
        try {
            synchronized (this.aeZ) {
                this.aeZ.remove(i);
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final boolean bi(int i) {
        synchronized (this.aeY) {
            this.aeY.remove(i);
        }
        return true;
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i, int i2, long j) {
        List<com.kwad.framework.filedownloader.d.a> list;
        synchronized (this.aeZ) {
            list = this.aeZ.get(i);
        }
        if (list == null) {
            return;
        }
        for (com.kwad.framework.filedownloader.d.a aVar : list) {
            if (aVar.getIndex() == i2) {
                aVar.M(j);
                return;
            }
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void b(com.kwad.framework.filedownloader.d.c cVar) {
        if (cVar == null) {
            com.kwad.framework.filedownloader.f.d.d(this, "update but model == null!", new Object[0]);
        } else if (bf(cVar.getId()) != null) {
            synchronized (this.aeY) {
                this.aeY.remove(cVar.getId());
                this.aeY.put(cVar.getId(), cVar);
            }
        } else {
            d(cVar);
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void d(int i, long j) {
        bi(i);
    }
}
