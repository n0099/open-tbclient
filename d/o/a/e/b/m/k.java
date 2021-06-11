package d.o.a.e.b.m;

import android.text.TextUtils;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public class k implements d.o.a.e.b.g.j {

    /* renamed from: e  reason: collision with root package name */
    public final SparseArray<DownloadInfo> f71186e = new SparseArray<>();

    /* renamed from: f  reason: collision with root package name */
    public final SparseArray<List<com.ss.android.socialbase.downloader.model.b>> f71187f = new SparseArray<>();

    /* renamed from: g  reason: collision with root package name */
    public final SparseArray<Map<Long, d.o.a.e.b.i.i>> f71188g = new SparseArray<>();

    public SparseArray<DownloadInfo> a() {
        return this.f71186e;
    }

    @Override // d.o.a.e.b.g.j
    public void a(int i2, int i3, int i4, int i5) {
    }

    @Override // d.o.a.e.b.g.j
    public DownloadInfo b(int i2) {
        DownloadInfo downloadInfo;
        synchronized (this.f71186e) {
            try {
                downloadInfo = this.f71186e.get(i2);
            } catch (Exception e2) {
                e2.printStackTrace();
                downloadInfo = null;
            }
        }
        return downloadInfo;
    }

    @Override // d.o.a.e.b.g.j
    public void b(int i2, List<com.ss.android.socialbase.downloader.model.b> list) {
    }

    @Override // d.o.a.e.b.g.j
    public void b(com.ss.android.socialbase.downloader.model.b bVar) {
    }

    @Override // d.o.a.e.b.g.j
    public List<DownloadInfo> c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.f71186e) {
            if (this.f71186e.size() == 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < this.f71186e.size(); i2++) {
                DownloadInfo downloadInfo = this.f71186e.get(this.f71186e.keyAt(i2));
                if (downloadInfo != null && !TextUtils.isEmpty(downloadInfo.m0()) && downloadInfo.m0().equals(str) && downloadInfo.H0() == -3) {
                    arrayList.add(downloadInfo);
                }
            }
            return arrayList;
        }
    }

    @Override // d.o.a.e.b.g.j
    public boolean c() {
        return false;
    }

    @Override // d.o.a.e.b.g.j
    public List<DownloadInfo> d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.f71186e) {
            if (this.f71186e.size() == 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < this.f71186e.size(); i2++) {
                DownloadInfo downloadInfo = this.f71186e.get(this.f71186e.keyAt(i2));
                if (downloadInfo != null && !TextUtils.isEmpty(downloadInfo.m0()) && downloadInfo.m0().equals(str) && d.o.a.e.b.d.a.g(downloadInfo.H0())) {
                    arrayList.add(downloadInfo);
                }
            }
            return arrayList;
        }
    }

    @Override // d.o.a.e.b.g.j
    public boolean d() {
        return false;
    }

    public SparseArray<List<com.ss.android.socialbase.downloader.model.b>> e() {
        return this.f71187f;
    }

    @Override // d.o.a.e.b.g.j
    public boolean f(int i2) {
        e(i2);
        d(i2);
        m(i2);
        return true;
    }

    @Override // d.o.a.e.b.g.j
    public DownloadInfo g(int i2) {
        DownloadInfo b2 = b(i2);
        if (b2 != null) {
            b2.a3(2);
        }
        return b2;
    }

    @Override // d.o.a.e.b.g.j
    public DownloadInfo h(int i2) {
        DownloadInfo b2 = b(i2);
        if (b2 != null) {
            b2.a3(5);
            b2.t2(false);
        }
        return b2;
    }

    @Override // d.o.a.e.b.g.j
    public DownloadInfo i(int i2) {
        DownloadInfo b2 = b(i2);
        if (b2 != null) {
            b2.a3(1);
        }
        return b2;
    }

    @Override // d.o.a.e.b.g.j
    public DownloadInfo j(int i2) {
        DownloadInfo b2 = b(i2);
        if (b2 != null) {
            b2.a3(-7);
        }
        return b2;
    }

    @Override // d.o.a.e.b.g.j
    public Map<Long, d.o.a.e.b.i.i> l(int i2) {
        return this.f71188g.get(i2);
    }

    @Override // d.o.a.e.b.g.j
    public void m(int i2) {
        this.f71188g.remove(i2);
    }

    @Override // d.o.a.e.b.g.j
    public List<d.o.a.e.b.i.i> n(int i2) {
        Map<Long, d.o.a.e.b.i.i> map = this.f71188g.get(i2);
        if (map == null || map.isEmpty()) {
            return null;
        }
        return new ArrayList(map.values());
    }

    @Override // d.o.a.e.b.g.j
    public List<DownloadInfo> a(String str) {
        ArrayList arrayList = new ArrayList();
        synchronized (this.f71186e) {
            try {
                int size = this.f71186e.size();
                for (int i2 = 0; i2 < size; i2++) {
                    DownloadInfo valueAt = this.f71186e.valueAt(i2);
                    if (str != null && str.equals(valueAt.T0())) {
                        arrayList.add(valueAt);
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return arrayList;
    }

    @Override // d.o.a.e.b.g.j
    public boolean e(int i2) {
        synchronized (this.f71186e) {
            this.f71186e.remove(i2);
        }
        return true;
    }

    @Override // d.o.a.e.b.g.j
    public List<DownloadInfo> b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.f71186e) {
            if (this.f71186e.size() == 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < this.f71186e.size(); i2++) {
                DownloadInfo downloadInfo = this.f71186e.get(this.f71186e.keyAt(i2));
                if (downloadInfo != null && !TextUtils.isEmpty(downloadInfo.m0()) && downloadInfo.m0().equals(str) && d.o.a.e.b.d.a.c(downloadInfo.H0())) {
                    arrayList.add(downloadInfo);
                }
            }
            return arrayList;
        }
    }

    @Override // d.o.a.e.b.g.j
    public synchronized void a(com.ss.android.socialbase.downloader.model.b bVar) {
        int x = bVar.x();
        List<com.ss.android.socialbase.downloader.model.b> list = this.f71187f.get(x);
        if (list == null) {
            list = new ArrayList<>();
            this.f71187f.put(x, list);
        }
        list.add(bVar);
    }

    @Override // d.o.a.e.b.g.j
    public List<com.ss.android.socialbase.downloader.model.b> c(int i2) {
        return this.f71187f.get(i2);
    }

    @Override // d.o.a.e.b.g.j
    public synchronized void d(int i2) {
        this.f71187f.remove(i2);
    }

    @Override // d.o.a.e.b.g.j
    public void a(int i2, int i3, long j) {
        List<com.ss.android.socialbase.downloader.model.b> c2 = c(i2);
        if (c2 == null) {
            return;
        }
        for (com.ss.android.socialbase.downloader.model.b bVar : c2) {
            if (bVar != null && bVar.F() == i3) {
                bVar.l(j);
                return;
            }
        }
    }

    @Override // d.o.a.e.b.g.j
    public DownloadInfo c(int i2, long j) {
        DownloadInfo b2 = b(i2);
        if (b2 != null) {
            b2.o2(j, false);
            b2.a3(-3);
            b2.t2(false);
            b2.v2(false);
        }
        return b2;
    }

    @Override // d.o.a.e.b.g.j
    public DownloadInfo d(int i2, long j) {
        DownloadInfo b2 = b(i2);
        if (b2 != null) {
            b2.o2(j, false);
            b2.a3(-2);
        }
        return b2;
    }

    @Override // d.o.a.e.b.g.j
    public void a(int i2, int i3, int i4, long j) {
        List<com.ss.android.socialbase.downloader.model.b> c2 = c(i2);
        if (c2 == null) {
            return;
        }
        for (com.ss.android.socialbase.downloader.model.b bVar : c2) {
            if (bVar != null && bVar.F() == i4 && !bVar.s()) {
                if (bVar.t() == null) {
                    return;
                }
                for (com.ss.android.socialbase.downloader.model.b bVar2 : bVar.t()) {
                    if (bVar2 != null && bVar2.F() == i3) {
                        bVar2.l(j);
                        return;
                    }
                }
                return;
            }
        }
    }

    @Override // d.o.a.e.b.g.j
    public void b() {
        synchronized (this.f71186e) {
            this.f71186e.clear();
            this.f71187f.clear();
        }
    }

    @Override // d.o.a.e.b.g.j
    public DownloadInfo b(int i2, long j) {
        DownloadInfo b2 = b(i2);
        if (b2 != null) {
            b2.o2(j, false);
            b2.a3(-1);
            b2.t2(false);
        }
        return b2;
    }

    @Override // d.o.a.e.b.g.j
    public DownloadInfo a(int i2, int i3) {
        DownloadInfo b2 = b(i2);
        if (b2 != null) {
            b2.l2(i3);
        }
        return b2;
    }

    @Override // d.o.a.e.b.g.j
    public void b(DownloadInfo downloadInfo) {
        a(downloadInfo);
    }

    @Override // d.o.a.e.b.g.j
    public boolean a(DownloadInfo downloadInfo) {
        boolean z = true;
        if (downloadInfo == null) {
            return true;
        }
        synchronized (this.f71186e) {
            if (this.f71186e.get(downloadInfo.c0()) == null) {
                z = false;
            }
            this.f71186e.put(downloadInfo.c0(), downloadInfo);
        }
        return z;
    }

    @Override // d.o.a.e.b.g.j
    public DownloadInfo a(int i2, long j, String str, String str2) {
        DownloadInfo b2 = b(i2);
        if (b2 != null) {
            b2.g3(j);
            b2.i3(str);
            if (TextUtils.isEmpty(b2.q0()) && !TextUtils.isEmpty(str2)) {
                b2.N2(str2);
            }
            b2.a3(3);
        }
        return b2;
    }

    @Override // d.o.a.e.b.g.j
    public DownloadInfo a(int i2, long j) {
        DownloadInfo b2 = b(i2);
        if (b2 != null) {
            b2.o2(j, false);
            if (b2.H0() != -3 && b2.H0() != -2 && !d.o.a.e.b.d.a.c(b2.H0()) && b2.H0() != -4) {
                b2.a3(4);
            }
        }
        return b2;
    }

    @Override // d.o.a.e.b.g.j
    public void a(int i2, List<com.ss.android.socialbase.downloader.model.b> list) {
        if (list == null) {
            return;
        }
        d(i2);
        for (com.ss.android.socialbase.downloader.model.b bVar : list) {
            if (bVar != null) {
                a(bVar);
                if (bVar.s()) {
                    for (com.ss.android.socialbase.downloader.model.b bVar2 : bVar.t()) {
                        a(bVar2);
                    }
                }
            }
        }
    }

    @Override // d.o.a.e.b.g.j
    public boolean a(int i2, Map<Long, d.o.a.e.b.i.i> map) {
        this.f71188g.put(i2, map);
        return false;
    }
}
