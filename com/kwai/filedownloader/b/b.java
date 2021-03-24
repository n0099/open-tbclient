package com.kwai.filedownloader.b;

import android.util.SparseArray;
import com.kwai.filedownloader.b.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class b implements com.kwai.filedownloader.b.a {

    /* renamed from: a  reason: collision with root package name */
    public final SparseArray<com.kwai.filedownloader.d.c> f36859a = new SparseArray<>();

    /* renamed from: b  reason: collision with root package name */
    public final SparseArray<List<com.kwai.filedownloader.d.a>> f36860b = new SparseArray<>();

    /* loaded from: classes6.dex */
    public class a implements a.InterfaceC0440a {
        public a() {
        }

        @Override // com.kwai.filedownloader.b.a.InterfaceC0440a
        public void a() {
        }

        @Override // com.kwai.filedownloader.b.a.InterfaceC0440a
        public void a(int i, com.kwai.filedownloader.d.c cVar) {
        }

        @Override // com.kwai.filedownloader.b.a.InterfaceC0440a
        public void a(com.kwai.filedownloader.d.c cVar) {
        }

        @Override // com.kwai.filedownloader.b.a.InterfaceC0440a
        public void b(com.kwai.filedownloader.d.c cVar) {
        }

        @Override // java.lang.Iterable
        public Iterator<com.kwai.filedownloader.d.c> iterator() {
            return new C0441b();
        }
    }

    /* renamed from: com.kwai.filedownloader.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0441b implements Iterator<com.kwai.filedownloader.d.c> {
        public C0441b() {
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
        synchronized (this.f36859a) {
            this.f36859a.clear();
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
        synchronized (this.f36860b) {
            list = this.f36860b.get(i);
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
            synchronized (this.f36860b) {
                list = this.f36860b.get(a2);
                if (list == null) {
                    list = new ArrayList<>();
                    this.f36860b.put(a2, list);
                }
            }
            list.add(aVar);
        } catch (Exception unused) {
        }
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(com.kwai.filedownloader.d.c cVar) {
        if (cVar == null) {
            com.kwai.filedownloader.f.d.d(this, "update but model == null!", new Object[0]);
        } else if (b(cVar.a()) == null) {
            b(cVar);
        } else {
            synchronized (this.f36859a) {
                this.f36859a.remove(cVar.a());
                this.f36859a.put(cVar.a(), cVar);
            }
        }
    }

    @Override // com.kwai.filedownloader.b.a
    public a.InterfaceC0440a b() {
        return new a();
    }

    @Override // com.kwai.filedownloader.b.a
    public com.kwai.filedownloader.d.c b(int i) {
        com.kwai.filedownloader.d.c cVar;
        synchronized (this.f36859a) {
            cVar = this.f36859a.get(i);
        }
        return cVar;
    }

    @Override // com.kwai.filedownloader.b.a
    public void b(int i, long j) {
        e(i);
    }

    public void b(com.kwai.filedownloader.d.c cVar) {
        synchronized (this.f36859a) {
            this.f36859a.put(cVar.a(), cVar);
        }
    }

    @Override // com.kwai.filedownloader.b.a
    public List<com.kwai.filedownloader.d.a> c(int i) {
        List<com.kwai.filedownloader.d.a> list;
        try {
            ArrayList arrayList = new ArrayList();
            synchronized (this.f36860b) {
                list = this.f36860b.get(i);
            }
            if (list != null) {
                arrayList.addAll(list);
            }
            return arrayList;
        } catch (Exception unused) {
            return new ArrayList();
        }
    }

    @Override // com.kwai.filedownloader.b.a
    public void c(int i, long j) {
    }

    @Override // com.kwai.filedownloader.b.a
    public void d(int i) {
        try {
            synchronized (this.f36860b) {
                this.f36860b.remove(i);
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.kwai.filedownloader.b.a
    public boolean e(int i) {
        synchronized (this.f36859a) {
            this.f36859a.remove(i);
        }
        return true;
    }

    @Override // com.kwai.filedownloader.b.a
    public void f(int i) {
    }
}
