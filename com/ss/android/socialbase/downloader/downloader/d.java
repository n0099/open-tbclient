package com.ss.android.socialbase.downloader.downloader;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.ac;
import com.ss.android.socialbase.downloader.depend.af;
import com.ss.android.socialbase.downloader.depend.z;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.impls.DownloadHandleService;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class d {
    public static volatile d a;

    /* renamed from: b  reason: collision with root package name */
    public volatile SparseArray<Boolean> f58526b = new SparseArray<>();

    /* renamed from: c  reason: collision with root package name */
    public Handler f58527c = new Handler(Looper.getMainLooper());

    /* renamed from: d  reason: collision with root package name */
    public volatile List<ac> f58528d = new ArrayList();

    public static d a() {
        if (a == null) {
            synchronized (d.class) {
                a = new d();
            }
        }
        return a;
    }

    public void b(ac acVar) {
        if (acVar == null) {
            return;
        }
        synchronized (this.f58528d) {
            if (this.f58528d.contains(acVar)) {
                this.f58528d.remove(acVar);
            }
        }
    }

    public m c(int i2) {
        boolean z = true;
        return com.ss.android.socialbase.downloader.impls.l.a((a(i2) != 1 || com.ss.android.socialbase.downloader.i.f.c()) ? false : false);
    }

    public void d(int i2) {
        m c2 = c(i2);
        if (c2 == null) {
            return;
        }
        c2.a(i2);
    }

    public boolean e(int i2) {
        m c2 = c(i2);
        if (c2 == null) {
            return false;
        }
        return c2.b(i2);
    }

    public void f(int i2) {
        m c2 = c(i2);
        if (c2 == null) {
            return;
        }
        c2.c(i2);
    }

    public void g(int i2) {
        m c2 = c(i2);
        if (c2 == null) {
            return;
        }
        c2.d(i2);
    }

    public long h(int i2) {
        m c2 = c(i2);
        if (c2 == null) {
            return 0L;
        }
        return c2.e(i2);
    }

    public int i(int i2) {
        m c2 = c(i2);
        if (c2 == null) {
            return 0;
        }
        return c2.f(i2);
    }

    public boolean j(int i2) {
        m c2 = c(i2);
        if (c2 == null) {
            return false;
        }
        return c2.g(i2);
    }

    public DownloadInfo k(int i2) {
        m c2 = c(i2);
        if (c2 == null) {
            return null;
        }
        return c2.h(i2);
    }

    public z l(int i2) {
        m c2 = c(i2);
        if (c2 == null) {
            return null;
        }
        return c2.q(i2);
    }

    public af m(int i2) {
        m c2 = c(i2);
        if (c2 == null) {
            return null;
        }
        return c2.r(i2);
    }

    public void n(int i2) {
        m c2 = c(i2);
        if (c2 == null) {
            return;
        }
        c2.j(i2);
    }

    public boolean o(int i2) {
        m c2 = c(i2);
        if (c2 == null) {
            return false;
        }
        return c2.l(i2);
    }

    public void p(int i2) {
        m a2 = com.ss.android.socialbase.downloader.impls.l.a(false);
        if (a2 != null) {
            a2.k(i2);
        }
        m a3 = com.ss.android.socialbase.downloader.impls.l.a(true);
        if (a3 != null) {
            a3.k(i2);
        }
    }

    public void q(int i2) {
        if (i2 == 0) {
            return;
        }
        b(i2, true);
        m a2 = com.ss.android.socialbase.downloader.impls.l.a(true);
        if (a2 == null) {
            return;
        }
        a2.startService();
    }

    public IDownloadFileUriProvider r(int i2) {
        m c2 = c(i2);
        if (c2 == null) {
            return null;
        }
        return c2.s(i2);
    }

    public void c(int i2, boolean z) {
        if (com.ss.android.socialbase.downloader.i.f.a()) {
            if (com.ss.android.socialbase.downloader.i.a.a(8388608)) {
                m a2 = com.ss.android.socialbase.downloader.impls.l.a(true);
                if (a2 != null) {
                    a2.a(i2, z);
                }
                m a3 = com.ss.android.socialbase.downloader.impls.l.a(false);
                if (a3 != null) {
                    a3.a(i2, z);
                    return;
                }
                return;
            }
            m a4 = com.ss.android.socialbase.downloader.impls.l.a(false);
            if (a4 != null) {
                a4.a(i2, z);
            }
            m a5 = com.ss.android.socialbase.downloader.impls.l.a(true);
            if (a5 != null) {
                a5.a(i2, z);
                return;
            }
            return;
        }
        m c2 = c(i2);
        if (c2 != null) {
            c2.a(i2, z);
        }
        com.ss.android.socialbase.downloader.impls.l.a(true).a(2, i2);
    }

    public void d(int i2, boolean z) {
        m c2 = c(i2);
        if (c2 == null) {
            return;
        }
        c2.b(i2, z);
    }

    public List<DownloadInfo> e(String str) {
        SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
        m a2 = com.ss.android.socialbase.downloader.impls.l.a(false);
        List<DownloadInfo> e2 = a2 != null ? a2.e(str) : null;
        m a3 = com.ss.android.socialbase.downloader.impls.l.a(true);
        return a(e2, a3 != null ? a3.e(str) : null, sparseArray);
    }

    public boolean f() {
        m a2 = com.ss.android.socialbase.downloader.impls.l.a(false);
        if (a2 != null) {
            return a2.e();
        }
        return false;
    }

    public void b() {
        synchronized (this.f58528d) {
            for (ac acVar : this.f58528d) {
                if (acVar != null) {
                    acVar.a();
                }
            }
        }
    }

    public boolean d() {
        return c.O();
    }

    public void a(ac acVar) {
        if (acVar == null) {
            return;
        }
        if (com.ss.android.socialbase.downloader.i.f.c()) {
            acVar.a();
            return;
        }
        if (com.ss.android.socialbase.downloader.impls.l.a(true).g()) {
            acVar.a();
        }
        synchronized (this.f58528d) {
            if (!this.f58528d.contains(acVar)) {
                this.f58528d.add(acVar);
            }
        }
    }

    public List<DownloadInfo> d(String str) {
        SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
        m a2 = com.ss.android.socialbase.downloader.impls.l.a(false);
        List<DownloadInfo> d2 = a2 != null ? a2.d(str) : null;
        m a3 = com.ss.android.socialbase.downloader.impls.l.a(true);
        return a(d2, a3 != null ? a3.d(str) : null, sparseArray);
    }

    public List<DownloadInfo> e() {
        SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
        m a2 = com.ss.android.socialbase.downloader.impls.l.a(false);
        List<DownloadInfo> d2 = a2 != null ? a2.d() : null;
        m a3 = com.ss.android.socialbase.downloader.impls.l.a(true);
        return a(d2, a3 != null ? a3.d() : null, sparseArray);
    }

    public synchronized void b(int i2, boolean z) {
        this.f58526b.put(i2, z ? Boolean.TRUE : Boolean.FALSE);
    }

    public synchronized int b(int i2) {
        if (this.f58526b.get(i2) == null) {
            return -1;
        }
        return this.f58526b.get(i2).booleanValue() ? 1 : 0;
    }

    public void a(int i2, boolean z) {
        b(i2, z);
        if (c.S() && !com.ss.android.socialbase.downloader.i.f.c() && com.ss.android.socialbase.downloader.impls.l.a(true).g()) {
            com.ss.android.socialbase.downloader.impls.l.a(true).c(i2, z);
        }
        if (c.c() || com.ss.android.socialbase.downloader.i.f.c() || com.ss.android.socialbase.downloader.i.f.a()) {
            return;
        }
        try {
            Intent intent = new Intent(c.N(), DownloadHandleService.class);
            intent.setAction("com.ss.android.downloader.action.PROCESS_NOTIFY");
            intent.putExtra("extra_download_id", i2);
            c.N().startService(intent);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void c() {
        m a2 = com.ss.android.socialbase.downloader.impls.l.a(false);
        if (a2 != null) {
            a2.a();
        }
        m a3 = com.ss.android.socialbase.downloader.impls.l.a(true);
        if (a3 != null) {
            a3.a();
        }
    }

    private m b(DownloadTask downloadTask) {
        DownloadInfo downloadInfo;
        List<com.ss.android.socialbase.downloader.model.b> i2;
        if (downloadTask == null || (downloadInfo = downloadTask.getDownloadInfo()) == null) {
            return null;
        }
        downloadInfo.isNeedIndependentProcess();
        boolean z = (com.ss.android.socialbase.downloader.i.f.c() || !com.ss.android.socialbase.downloader.i.f.a()) ? true : true;
        int a2 = a(downloadInfo.getId());
        if (a2 >= 0 && a2 != z) {
            try {
                if (a2 == 1) {
                    if (com.ss.android.socialbase.downloader.i.f.a()) {
                        com.ss.android.socialbase.downloader.impls.l.a(true).a(downloadInfo.getId());
                        DownloadInfo h2 = com.ss.android.socialbase.downloader.impls.l.a(true).h(downloadInfo.getId());
                        if (h2 != null) {
                            com.ss.android.socialbase.downloader.impls.l.a(false).b(h2);
                        }
                        if (h2.getChunkCount() > 1 && (i2 = com.ss.android.socialbase.downloader.impls.l.a(true).i(downloadInfo.getId())) != null) {
                            com.ss.android.socialbase.downloader.impls.l.a(false).a(downloadInfo.getId(), com.ss.android.socialbase.downloader.i.f.a(i2));
                        }
                    }
                } else if (com.ss.android.socialbase.downloader.i.f.a()) {
                    com.ss.android.socialbase.downloader.impls.l.a(false).a(downloadInfo.getId());
                    List<com.ss.android.socialbase.downloader.model.b> i3 = com.ss.android.socialbase.downloader.impls.l.a(false).i(downloadInfo.getId());
                    if (i3 != null) {
                        com.ss.android.socialbase.downloader.impls.l.a(true).a(downloadInfo.getId(), com.ss.android.socialbase.downloader.i.f.a(i3));
                    }
                } else {
                    downloadTask.setNeedDelayForCacheSync(true);
                    com.ss.android.socialbase.downloader.impls.l.a(true).a(1, downloadInfo.getId());
                }
            } catch (Throwable unused) {
            }
        }
        a(downloadInfo.getId(), z);
        return com.ss.android.socialbase.downloader.impls.l.a(z);
    }

    public List<DownloadInfo> c(String str) {
        SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
        m a2 = com.ss.android.socialbase.downloader.impls.l.a(false);
        List<DownloadInfo> c2 = a2 != null ? a2.c(str) : null;
        m a3 = com.ss.android.socialbase.downloader.impls.l.a(true);
        return a(c2, a3 != null ? a3.c(str) : null, sparseArray);
    }

    public int a(int i2) {
        if (c.S()) {
            if (!com.ss.android.socialbase.downloader.i.f.c() && com.ss.android.socialbase.downloader.impls.l.a(true).g()) {
                return com.ss.android.socialbase.downloader.impls.l.a(true).m(i2);
            }
            return b(i2);
        }
        return -1;
    }

    public int a(String str, String str2) {
        return c.a(str, str2);
    }

    public List<DownloadInfo> a(String str) {
        List<DownloadInfo> a2 = com.ss.android.socialbase.downloader.impls.l.a(false).a(str);
        List<DownloadInfo> a3 = com.ss.android.socialbase.downloader.impls.l.a(true).a(str);
        if (a2 == null && a3 == null) {
            return null;
        }
        if (a2 == null || a3 == null) {
            return a2 != null ? a2 : a3;
        }
        ArrayList arrayList = new ArrayList(a2);
        arrayList.addAll(a3);
        return arrayList;
    }

    public void a(int i2, z zVar) {
        m c2 = c(i2);
        if (c2 == null) {
            return;
        }
        c2.a(i2, zVar);
    }

    private List<DownloadInfo> a(List<DownloadInfo> list, List<DownloadInfo> list2, SparseArray<DownloadInfo> sparseArray) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (DownloadInfo downloadInfo : list) {
                if (downloadInfo != null && sparseArray.get(downloadInfo.getId()) == null) {
                    sparseArray.put(downloadInfo.getId(), downloadInfo);
                }
            }
        }
        if (list2 != null) {
            for (DownloadInfo downloadInfo2 : list2) {
                if (downloadInfo2 != null && sparseArray.get(downloadInfo2.getId()) == null) {
                    sparseArray.put(downloadInfo2.getId(), downloadInfo2);
                }
            }
        }
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            arrayList.add(sparseArray.get(sparseArray.keyAt(i2)));
        }
        return arrayList;
    }

    public DownloadInfo b(String str, String str2) {
        int a2 = a(str, str2);
        m c2 = c(a2);
        if (c2 == null) {
            return null;
        }
        return c2.h(a2);
    }

    public List<DownloadInfo> b(String str) {
        SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
        m a2 = com.ss.android.socialbase.downloader.impls.l.a(false);
        List<DownloadInfo> b2 = a2 != null ? a2.b(str) : null;
        m a3 = com.ss.android.socialbase.downloader.impls.l.a(true);
        return a(b2, a3 != null ? a3.b(str) : null, sparseArray);
    }

    public void a(List<String> list) {
        m a2 = com.ss.android.socialbase.downloader.impls.l.a(false);
        if (a2 != null) {
            a2.a(list);
        }
        m a3 = com.ss.android.socialbase.downloader.impls.l.a(true);
        if (a3 != null) {
            a3.a(list);
        }
    }

    public void b(List<String> list) {
        m a2 = com.ss.android.socialbase.downloader.impls.l.a(false);
        if (a2 != null) {
            a2.b(list);
        }
        m a3 = com.ss.android.socialbase.downloader.impls.l.a(true);
        if (a3 != null) {
            a3.b(list);
        }
    }

    public void a(int i2, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.f fVar, boolean z) {
        m c2 = c(i2);
        if (c2 == null) {
            return;
        }
        c2.b(i2, iDownloadListener == null ? 0 : iDownloadListener.hashCode(), iDownloadListener, fVar, z);
    }

    public void b(int i2, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.f fVar, boolean z) {
        m c2 = c(i2);
        if (c2 == null) {
            return;
        }
        c2.a(i2, iDownloadListener.hashCode(), iDownloadListener, fVar, z);
    }

    public void a(int i2, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.f fVar, boolean z, boolean z2) {
        m c2 = c(i2);
        if (c2 == null) {
            return;
        }
        c2.a(i2, iDownloadListener.hashCode(), iDownloadListener, fVar, z, z2);
    }

    public void b(com.ss.android.socialbase.downloader.depend.k kVar) {
        c.b(kVar);
    }

    public boolean a(DownloadInfo downloadInfo) {
        m c2;
        if (downloadInfo == null || (c2 = c(downloadInfo.getId())) == null) {
            return false;
        }
        return c2.a(downloadInfo);
    }

    public void a(final DownloadTask downloadTask) {
        final m b2 = b(downloadTask);
        if (b2 == null) {
            if (downloadTask != null) {
                com.ss.android.socialbase.downloader.d.a.a(downloadTask.getMonitorDepend(), downloadTask.getDownloadInfo(), new BaseException(1003, "tryDownload but getDownloadHandler failed"), downloadTask.getDownloadInfo() != null ? downloadTask.getDownloadInfo().getStatus() : 0);
            }
        } else if (downloadTask.isNeedDelayForCacheSync()) {
            this.f58527c.postDelayed(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.d.1
                @Override // java.lang.Runnable
                public void run() {
                    b2.a(downloadTask);
                }
            }, 500L);
        } else {
            b2.a(downloadTask);
        }
    }

    public void a(com.ss.android.socialbase.downloader.depend.k kVar) {
        c.a(kVar);
    }

    public void a(int i2, long j2) {
        m c2 = c(i2);
        if (c2 == null) {
            return;
        }
        c2.a(i2, j2);
    }
}
