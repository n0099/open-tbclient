package com.kwai.filedownloader.b;

import android.util.SparseArray;
import com.kwai.filedownloader.b.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class b implements com.kwai.filedownloader.b.a {

    /* renamed from: a  reason: collision with root package name */
    final SparseArray<com.kwai.filedownloader.d.c> f11166a = new SparseArray<>();

    /* renamed from: b  reason: collision with root package name */
    final SparseArray<List<com.kwai.filedownloader.d.a>> f11167b = new SparseArray<>();

    /* loaded from: classes5.dex */
    class a implements a.InterfaceC1167a {
        a() {
        }

        @Override // com.kwai.filedownloader.b.a.InterfaceC1167a
        public void a() {
        }

        @Override // com.kwai.filedownloader.b.a.InterfaceC1167a
        public void a(int i, com.kwai.filedownloader.d.c cVar) {
        }

        @Override // com.kwai.filedownloader.b.a.InterfaceC1167a
        public void a(com.kwai.filedownloader.d.c cVar) {
        }

        @Override // com.kwai.filedownloader.b.a.InterfaceC1167a
        public void b(com.kwai.filedownloader.d.c cVar) {
        }

        @Override // java.lang.Iterable
        public Iterator<com.kwai.filedownloader.d.c> iterator() {
            return new C1168b();
        }
    }

    /* renamed from: com.kwai.filedownloader.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    class C1168b implements Iterator<com.kwai.filedownloader.d.c> {
        C1168b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Iterator
        /* renamed from: a */
        public com.kwai.filedownloader.d.c next() {
            return null;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator
        public void remove() {
        }
    }

    @Override // com.kwai.filedownloader.b.a
    public void a() {
        synchronized (this.f11166a) {
            this.f11166a.clear();
        }
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i) {
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i, int i2) {
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i, int i2, long j) {
        List<com.kwai.filedownloader.d.a> list;
        synchronized (this.f11167b) {
            list = this.f11167b.get(i);
        }
        if (list == null) {
            return;
        }
        for (com.kwai.filedownloader.d.a aVar : list) {
            if (aVar.b() == i2) {
                aVar.b(j);
                return;
            }
        }
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i, long j) {
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i, long j, String str, String str2) {
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i, String str, long j, long j2, int i2) {
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i, Throwable th) {
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i, Throwable th, long j) {
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(com.kwai.filedownloader.d.a aVar) {
        List<com.kwai.filedownloader.d.a> list;
        try {
            int a2 = aVar.a();
            synchronized (this.f11167b) {
                list = this.f11167b.get(a2);
                if (list == null) {
                    list = new ArrayList<>();
                    this.f11167b.put(a2, list);
                }
            }
            list.add(aVar);
        } catch (Exception e) {
        }
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(com.kwai.filedownloader.d.c cVar) {
        if (cVar == null) {
            com.kwai.filedownloader.f.d.d(this, "update but model == null!", new Object[0]);
        } else if (b(cVar.a()) == null) {
            b(cVar);
        } else {
            synchronized (this.f11166a) {
                this.f11166a.remove(cVar.a());
                this.f11166a.put(cVar.a(), cVar);
            }
        }
    }

    @Override // com.kwai.filedownloader.b.a
    public a.InterfaceC1167a b() {
        return new a();
    }

    @Override // com.kwai.filedownloader.b.a
    public com.kwai.filedownloader.d.c b(int i) {
        com.kwai.filedownloader.d.c cVar;
        synchronized (this.f11166a) {
            cVar = this.f11166a.get(i);
        }
        return cVar;
    }

    @Override // com.kwai.filedownloader.b.a
    public void b(int i, long j) {
        e(i);
    }

    public void b(com.kwai.filedownloader.d.c cVar) {
        synchronized (this.f11166a) {
            this.f11166a.put(cVar.a(), cVar);
        }
    }

    @Override // com.kwai.filedownloader.b.a
    public List<com.kwai.filedownloader.d.a> c(int i) {
        List<com.kwai.filedownloader.d.a> list;
        try {
            ArrayList arrayList = new ArrayList();
            synchronized (this.f11167b) {
                list = this.f11167b.get(i);
            }
            if (list != null) {
                arrayList.addAll(list);
            }
            return arrayList;
        } catch (Exception e) {
            return new ArrayList();
        }
    }

    @Override // com.kwai.filedownloader.b.a
    public void c(int i, long j) {
    }

    @Override // com.kwai.filedownloader.b.a
    public void d(int i) {
        try {
            synchronized (this.f11167b) {
                this.f11167b.remove(i);
            }
        } catch (Exception e) {
        }
    }

    @Override // com.kwai.filedownloader.b.a
    public boolean e(int i) {
        synchronized (this.f11166a) {
            this.f11166a.remove(i);
        }
        return true;
    }

    @Override // com.kwai.filedownloader.b.a
    public void f(int i) {
    }
}
