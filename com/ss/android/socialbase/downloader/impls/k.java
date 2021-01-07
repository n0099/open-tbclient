package com.ss.android.socialbase.downloader.impls;

import android.text.TextUtils;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class k implements com.ss.android.socialbase.downloader.downloader.k {

    /* renamed from: a  reason: collision with root package name */
    private final SparseArray<com.ss.android.socialbase.downloader.g.c> f13489a = new SparseArray<>();

    /* renamed from: b  reason: collision with root package name */
    private final SparseArray<List<com.ss.android.socialbase.downloader.g.b>> f13490b = new SparseArray<>();

    public SparseArray<com.ss.android.socialbase.downloader.g.c> a() {
        return this.f13489a;
    }

    public SparseArray<List<com.ss.android.socialbase.downloader.g.b>> eJR() {
        return this.f13490b;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public com.ss.android.socialbase.downloader.g.c g(int i) {
        com.ss.android.socialbase.downloader.g.c b2 = b(i);
        if (b2 != null) {
            b2.c(2);
        }
        return b2;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public com.ss.android.socialbase.downloader.g.c b(int i) {
        com.ss.android.socialbase.downloader.g.c cVar;
        synchronized (this.f13489a) {
            try {
                cVar = this.f13489a.get(i);
            } catch (Exception e) {
                e.printStackTrace();
                cVar = null;
            }
        }
        return cVar;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public List<com.ss.android.socialbase.downloader.g.c> a(String str) {
        ArrayList arrayList = new ArrayList();
        synchronized (this.f13489a) {
            try {
                int size = this.f13489a.size();
                for (int i = 0; i < size; i++) {
                    com.ss.android.socialbase.downloader.g.c valueAt = this.f13489a.valueAt(i);
                    if (str != null && str.equals(valueAt.j())) {
                        arrayList.add(valueAt);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public List<com.ss.android.socialbase.downloader.g.c> b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.f13489a) {
            if (this.f13489a.size() == 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.f13489a.size(); i++) {
                com.ss.android.socialbase.downloader.g.c cVar = this.f13489a.get(this.f13489a.keyAt(i));
                if (cVar != null && !TextUtils.isEmpty(cVar.eIE()) && cVar.eIE().equals(str) && com.ss.android.socialbase.downloader.b.f.g(cVar.q())) {
                    arrayList.add(cVar);
                }
            }
            return arrayList;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public List<com.ss.android.socialbase.downloader.g.c> c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.f13489a) {
            if (this.f13489a.size() == 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.f13489a.size(); i++) {
                com.ss.android.socialbase.downloader.g.c cVar = this.f13489a.get(this.f13489a.keyAt(i));
                if (cVar != null && !TextUtils.isEmpty(cVar.eIE()) && cVar.eIE().equals(str) && cVar.q() == -3) {
                    arrayList.add(cVar);
                }
            }
            return arrayList;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public List<com.ss.android.socialbase.downloader.g.c> d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.f13489a) {
            if (this.f13489a.size() == 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.f13489a.size(); i++) {
                com.ss.android.socialbase.downloader.g.c cVar = this.f13489a.get(this.f13489a.keyAt(i));
                if (cVar != null && !TextUtils.isEmpty(cVar.eIE()) && cVar.eIE().equals(str) && com.ss.android.socialbase.downloader.b.f.f(cVar.q())) {
                    arrayList.add(cVar);
                }
            }
            return arrayList;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public List<com.ss.android.socialbase.downloader.g.b> c(int i) {
        return this.f13490b.get(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public synchronized void d(int i) {
        this.f13490b.remove(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public synchronized void a(com.ss.android.socialbase.downloader.g.b bVar) {
        int k = bVar.k();
        List<com.ss.android.socialbase.downloader.g.b> list = this.f13490b.get(k);
        if (list == null) {
            list = new ArrayList<>();
            this.f13490b.put(k, list);
        }
        list.add(bVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void b(com.ss.android.socialbase.downloader.g.b bVar) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void a(int i, int i2, long j) {
        List<com.ss.android.socialbase.downloader.g.b> c = c(i);
        if (c != null) {
            for (com.ss.android.socialbase.downloader.g.b bVar : c) {
                if (bVar != null && bVar.s() == i2) {
                    bVar.b(j);
                    return;
                }
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void a(int i, int i2, int i3, long j) {
        List<com.ss.android.socialbase.downloader.g.b> c = c(i);
        if (c != null) {
            for (com.ss.android.socialbase.downloader.g.b bVar : c) {
                if (bVar != null && bVar.s() == i3 && !bVar.f()) {
                    if (bVar.g() != null) {
                        for (com.ss.android.socialbase.downloader.g.b bVar2 : bVar.g()) {
                            if (bVar2 != null && bVar2.s() == i2) {
                                bVar2.b(j);
                                return;
                            }
                        }
                        return;
                    }
                    return;
                }
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void a(int i, int i2, int i3, int i4) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public com.ss.android.socialbase.downloader.g.c a(int i, int i2) {
        com.ss.android.socialbase.downloader.g.c b2 = b(i);
        if (b2 != null) {
            b2.d(i2);
        }
        return b2;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public boolean a(com.ss.android.socialbase.downloader.g.c cVar) {
        if (cVar != null) {
            synchronized (this.f13489a) {
                r0 = this.f13489a.get(cVar.g()) != null;
                this.f13489a.put(cVar.g(), cVar);
            }
        }
        return r0;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public boolean e(int i) {
        synchronized (this.f13489a) {
            this.f13489a.remove(i);
        }
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public boolean f(int i) {
        e(i);
        d(i);
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void b() {
        synchronized (this.f13489a) {
            this.f13489a.clear();
            this.f13490b.clear();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public com.ss.android.socialbase.downloader.g.c a(int i, long j, String str, String str2) {
        com.ss.android.socialbase.downloader.g.c b2 = b(i);
        if (b2 != null) {
            b2.f(j);
            b2.c(str);
            if (TextUtils.isEmpty(b2.h()) && !TextUtils.isEmpty(str2)) {
                b2.d(str2);
            }
            b2.c(3);
        }
        return b2;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public com.ss.android.socialbase.downloader.g.c a(int i, long j) {
        com.ss.android.socialbase.downloader.g.c b2 = b(i);
        if (b2 != null) {
            b2.a(j, false);
            if (b2.q() != -3 && b2.q() != -2 && !com.ss.android.socialbase.downloader.b.f.g(b2.q()) && b2.q() != -4) {
                b2.c(4);
            }
        }
        return b2;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public com.ss.android.socialbase.downloader.g.c b(int i, long j) {
        com.ss.android.socialbase.downloader.g.c b2 = b(i);
        if (b2 != null) {
            b2.a(j, false);
            b2.c(-1);
            b2.g(false);
        }
        return b2;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public com.ss.android.socialbase.downloader.g.c h(int i) {
        com.ss.android.socialbase.downloader.g.c b2 = b(i);
        if (b2 != null) {
            b2.c(5);
            b2.g(false);
        }
        return b2;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public com.ss.android.socialbase.downloader.g.c c(int i, long j) {
        com.ss.android.socialbase.downloader.g.c b2 = b(i);
        if (b2 != null) {
            b2.a(j, false);
            b2.c(-3);
            b2.g(false);
            b2.h(false);
        }
        return b2;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public com.ss.android.socialbase.downloader.g.c d(int i, long j) {
        com.ss.android.socialbase.downloader.g.c b2 = b(i);
        if (b2 != null) {
            b2.a(j, false);
            b2.c(-2);
        }
        return b2;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public com.ss.android.socialbase.downloader.g.c i(int i) {
        com.ss.android.socialbase.downloader.g.c b2 = b(i);
        if (b2 != null) {
            b2.c(1);
        }
        return b2;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public com.ss.android.socialbase.downloader.g.c j(int i) {
        com.ss.android.socialbase.downloader.g.c b2 = b(i);
        if (b2 != null) {
            b2.c(-7);
        }
        return b2;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public boolean c() {
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public boolean d() {
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void b(com.ss.android.socialbase.downloader.g.c cVar) {
        a(cVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void a(int i, List<com.ss.android.socialbase.downloader.g.b> list) {
        if (list != null) {
            d(i);
            for (com.ss.android.socialbase.downloader.g.b bVar : list) {
                if (bVar != null) {
                    a(bVar);
                    if (bVar.f()) {
                        for (com.ss.android.socialbase.downloader.g.b bVar2 : bVar.g()) {
                            a(bVar2);
                        }
                    }
                }
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void b(int i, List<com.ss.android.socialbase.downloader.g.b> list) {
    }
}
