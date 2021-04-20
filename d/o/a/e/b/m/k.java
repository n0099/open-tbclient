package d.o.a.e.b.m;

import android.text.TextUtils;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class k implements d.o.a.e.b.g.j {

    /* renamed from: e  reason: collision with root package name */
    public final SparseArray<DownloadInfo> f68151e = new SparseArray<>();

    /* renamed from: f  reason: collision with root package name */
    public final SparseArray<List<com.ss.android.socialbase.downloader.model.b>> f68152f = new SparseArray<>();

    /* renamed from: g  reason: collision with root package name */
    public final SparseArray<Map<Long, d.o.a.e.b.i.i>> f68153g = new SparseArray<>();

    public SparseArray<DownloadInfo> a() {
        return this.f68151e;
    }

    @Override // d.o.a.e.b.g.j
    public void a(int i, int i2, int i3, int i4) {
    }

    @Override // d.o.a.e.b.g.j
    public DownloadInfo b(int i) {
        DownloadInfo downloadInfo;
        synchronized (this.f68151e) {
            try {
                downloadInfo = this.f68151e.get(i);
            } catch (Exception e2) {
                e2.printStackTrace();
                downloadInfo = null;
            }
        }
        return downloadInfo;
    }

    @Override // d.o.a.e.b.g.j
    public void b(int i, List<com.ss.android.socialbase.downloader.model.b> list) {
    }

    @Override // d.o.a.e.b.g.j
    public void b(com.ss.android.socialbase.downloader.model.b bVar) {
    }

    @Override // d.o.a.e.b.g.j
    public List<DownloadInfo> c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.f68151e) {
            if (this.f68151e.size() == 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.f68151e.size(); i++) {
                DownloadInfo downloadInfo = this.f68151e.get(this.f68151e.keyAt(i));
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
        synchronized (this.f68151e) {
            if (this.f68151e.size() == 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.f68151e.size(); i++) {
                DownloadInfo downloadInfo = this.f68151e.get(this.f68151e.keyAt(i));
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
        return this.f68152f;
    }

    @Override // d.o.a.e.b.g.j
    public boolean f(int i) {
        e(i);
        d(i);
        m(i);
        return true;
    }

    @Override // d.o.a.e.b.g.j
    public DownloadInfo g(int i) {
        DownloadInfo b2 = b(i);
        if (b2 != null) {
            b2.a3(2);
        }
        return b2;
    }

    @Override // d.o.a.e.b.g.j
    public DownloadInfo h(int i) {
        DownloadInfo b2 = b(i);
        if (b2 != null) {
            b2.a3(5);
            b2.t2(false);
        }
        return b2;
    }

    @Override // d.o.a.e.b.g.j
    public DownloadInfo i(int i) {
        DownloadInfo b2 = b(i);
        if (b2 != null) {
            b2.a3(1);
        }
        return b2;
    }

    @Override // d.o.a.e.b.g.j
    public DownloadInfo j(int i) {
        DownloadInfo b2 = b(i);
        if (b2 != null) {
            b2.a3(-7);
        }
        return b2;
    }

    @Override // d.o.a.e.b.g.j
    public Map<Long, d.o.a.e.b.i.i> l(int i) {
        return this.f68153g.get(i);
    }

    @Override // d.o.a.e.b.g.j
    public void m(int i) {
        this.f68153g.remove(i);
    }

    @Override // d.o.a.e.b.g.j
    public List<d.o.a.e.b.i.i> n(int i) {
        Map<Long, d.o.a.e.b.i.i> map = this.f68153g.get(i);
        if (map == null || map.isEmpty()) {
            return null;
        }
        return new ArrayList(map.values());
    }

    @Override // d.o.a.e.b.g.j
    public List<DownloadInfo> a(String str) {
        ArrayList arrayList = new ArrayList();
        synchronized (this.f68151e) {
            try {
                int size = this.f68151e.size();
                for (int i = 0; i < size; i++) {
                    DownloadInfo valueAt = this.f68151e.valueAt(i);
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
    public boolean e(int i) {
        synchronized (this.f68151e) {
            this.f68151e.remove(i);
        }
        return true;
    }

    @Override // d.o.a.e.b.g.j
    public List<DownloadInfo> b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.f68151e) {
            if (this.f68151e.size() == 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.f68151e.size(); i++) {
                DownloadInfo downloadInfo = this.f68151e.get(this.f68151e.keyAt(i));
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
        List<com.ss.android.socialbase.downloader.model.b> list = this.f68152f.get(x);
        if (list == null) {
            list = new ArrayList<>();
            this.f68152f.put(x, list);
        }
        list.add(bVar);
    }

    @Override // d.o.a.e.b.g.j
    public List<com.ss.android.socialbase.downloader.model.b> c(int i) {
        return this.f68152f.get(i);
    }

    @Override // d.o.a.e.b.g.j
    public synchronized void d(int i) {
        this.f68152f.remove(i);
    }

    @Override // d.o.a.e.b.g.j
    public void a(int i, int i2, long j) {
        List<com.ss.android.socialbase.downloader.model.b> c2 = c(i);
        if (c2 == null) {
            return;
        }
        for (com.ss.android.socialbase.downloader.model.b bVar : c2) {
            if (bVar != null && bVar.F() == i2) {
                bVar.l(j);
                return;
            }
        }
    }

    @Override // d.o.a.e.b.g.j
    public DownloadInfo c(int i, long j) {
        DownloadInfo b2 = b(i);
        if (b2 != null) {
            b2.o2(j, false);
            b2.a3(-3);
            b2.t2(false);
            b2.v2(false);
        }
        return b2;
    }

    @Override // d.o.a.e.b.g.j
    public DownloadInfo d(int i, long j) {
        DownloadInfo b2 = b(i);
        if (b2 != null) {
            b2.o2(j, false);
            b2.a3(-2);
        }
        return b2;
    }

    @Override // d.o.a.e.b.g.j
    public void a(int i, int i2, int i3, long j) {
        List<com.ss.android.socialbase.downloader.model.b> c2 = c(i);
        if (c2 == null) {
            return;
        }
        for (com.ss.android.socialbase.downloader.model.b bVar : c2) {
            if (bVar != null && bVar.F() == i3 && !bVar.s()) {
                if (bVar.t() == null) {
                    return;
                }
                for (com.ss.android.socialbase.downloader.model.b bVar2 : bVar.t()) {
                    if (bVar2 != null && bVar2.F() == i2) {
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
        synchronized (this.f68151e) {
            this.f68151e.clear();
            this.f68152f.clear();
        }
    }

    @Override // d.o.a.e.b.g.j
    public DownloadInfo b(int i, long j) {
        DownloadInfo b2 = b(i);
        if (b2 != null) {
            b2.o2(j, false);
            b2.a3(-1);
            b2.t2(false);
        }
        return b2;
    }

    @Override // d.o.a.e.b.g.j
    public DownloadInfo a(int i, int i2) {
        DownloadInfo b2 = b(i);
        if (b2 != null) {
            b2.l2(i2);
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
        synchronized (this.f68151e) {
            if (this.f68151e.get(downloadInfo.c0()) == null) {
                z = false;
            }
            this.f68151e.put(downloadInfo.c0(), downloadInfo);
        }
        return z;
    }

    @Override // d.o.a.e.b.g.j
    public DownloadInfo a(int i, long j, String str, String str2) {
        DownloadInfo b2 = b(i);
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
    public DownloadInfo a(int i, long j) {
        DownloadInfo b2 = b(i);
        if (b2 != null) {
            b2.o2(j, false);
            if (b2.H0() != -3 && b2.H0() != -2 && !d.o.a.e.b.d.a.c(b2.H0()) && b2.H0() != -4) {
                b2.a3(4);
            }
        }
        return b2;
    }

    @Override // d.o.a.e.b.g.j
    public void a(int i, List<com.ss.android.socialbase.downloader.model.b> list) {
        if (list == null) {
            return;
        }
        d(i);
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
    public boolean a(int i, Map<Long, d.o.a.e.b.i.i> map) {
        this.f68153g.put(i, map);
        return false;
    }
}
