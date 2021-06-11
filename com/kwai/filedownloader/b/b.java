package com.kwai.filedownloader.b;

import android.util.SparseArray;
import com.kwai.filedownloader.b.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes7.dex */
public class b implements com.kwai.filedownloader.b.a {

    /* renamed from: a  reason: collision with root package name */
    public final SparseArray<com.kwai.filedownloader.d.c> f37618a = new SparseArray<>();

    /* renamed from: b  reason: collision with root package name */
    public final SparseArray<List<com.kwai.filedownloader.d.a>> f37619b = new SparseArray<>();

    /* loaded from: classes7.dex */
    public class a implements a.InterfaceC0441a {
        public a() {
        }

        @Override // com.kwai.filedownloader.b.a.InterfaceC0441a
        public void a() {
        }

        @Override // com.kwai.filedownloader.b.a.InterfaceC0441a
        public void a(int i2, com.kwai.filedownloader.d.c cVar) {
        }

        @Override // com.kwai.filedownloader.b.a.InterfaceC0441a
        public void a(com.kwai.filedownloader.d.c cVar) {
        }

        @Override // com.kwai.filedownloader.b.a.InterfaceC0441a
        public void b(com.kwai.filedownloader.d.c cVar) {
        }

        @Override // java.lang.Iterable
        public Iterator<com.kwai.filedownloader.d.c> iterator() {
            return new C0442b();
        }
    }

    /* renamed from: com.kwai.filedownloader.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0442b implements Iterator<com.kwai.filedownloader.d.c> {
        public C0442b() {
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
        synchronized (this.f37618a) {
            this.f37618a.clear();
        }
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i2) {
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i2, int i3) {
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i2, int i3, long j) {
        List<com.kwai.filedownloader.d.a> list;
        synchronized (this.f37619b) {
            list = this.f37619b.get(i2);
        }
        if (list == null) {
            return;
        }
        for (com.kwai.filedownloader.d.a aVar : list) {
            if (aVar.b() == i3) {
                aVar.b(j);
                return;
            }
        }
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i2, long j) {
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i2, long j, String str, String str2) {
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i2, String str, long j, long j2, int i3) {
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i2, Throwable th) {
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i2, Throwable th, long j) {
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(com.kwai.filedownloader.d.a aVar) {
        List<com.kwai.filedownloader.d.a> list;
        try {
            int a2 = aVar.a();
            synchronized (this.f37619b) {
                list = this.f37619b.get(a2);
                if (list == null) {
                    list = new ArrayList<>();
                    this.f37619b.put(a2, list);
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
            synchronized (this.f37618a) {
                this.f37618a.remove(cVar.a());
                this.f37618a.put(cVar.a(), cVar);
            }
        }
    }

    @Override // com.kwai.filedownloader.b.a
    public a.InterfaceC0441a b() {
        return new a();
    }

    @Override // com.kwai.filedownloader.b.a
    public com.kwai.filedownloader.d.c b(int i2) {
        com.kwai.filedownloader.d.c cVar;
        synchronized (this.f37618a) {
            cVar = this.f37618a.get(i2);
        }
        return cVar;
    }

    @Override // com.kwai.filedownloader.b.a
    public void b(int i2, long j) {
        e(i2);
    }

    public void b(com.kwai.filedownloader.d.c cVar) {
        synchronized (this.f37618a) {
            this.f37618a.put(cVar.a(), cVar);
        }
    }

    @Override // com.kwai.filedownloader.b.a
    public List<com.kwai.filedownloader.d.a> c(int i2) {
        List<com.kwai.filedownloader.d.a> list;
        try {
            ArrayList arrayList = new ArrayList();
            synchronized (this.f37619b) {
                list = this.f37619b.get(i2);
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
    public void c(int i2, long j) {
    }

    @Override // com.kwai.filedownloader.b.a
    public void d(int i2) {
        try {
            synchronized (this.f37619b) {
                this.f37619b.remove(i2);
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.kwai.filedownloader.b.a
    public boolean e(int i2) {
        synchronized (this.f37618a) {
            this.f37618a.remove(i2);
        }
        return true;
    }

    @Override // com.kwai.filedownloader.b.a
    public void f(int i2) {
    }
}
