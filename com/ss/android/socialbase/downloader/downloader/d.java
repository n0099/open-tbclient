package com.ss.android.socialbase.downloader.downloader;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.ac;
import com.ss.android.socialbase.downloader.depend.af;
import com.ss.android.socialbase.downloader.depend.x;
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
    public volatile SparseArray<Boolean> b = new SparseArray<>();
    public Handler c = new Handler(Looper.getMainLooper());
    public volatile List<ac> d = new ArrayList();

    public static d a() {
        if (a == null) {
            synchronized (d.class) {
                a = new d();
            }
        }
        return a;
    }

    public void b() {
        synchronized (this.d) {
            for (ac acVar : this.d) {
                if (acVar != null) {
                    acVar.a();
                }
            }
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

    public boolean d() {
        return c.O();
    }

    public List<DownloadInfo> e() {
        List<DownloadInfo> list;
        SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
        m a2 = com.ss.android.socialbase.downloader.impls.l.a(false);
        List<DownloadInfo> list2 = null;
        if (a2 != null) {
            list = a2.d();
        } else {
            list = null;
        }
        m a3 = com.ss.android.socialbase.downloader.impls.l.a(true);
        if (a3 != null) {
            list2 = a3.d();
        }
        return a(list, list2, sparseArray);
    }

    public boolean f() {
        m a2 = com.ss.android.socialbase.downloader.impls.l.a(false);
        if (a2 == null) {
            return false;
        }
        return a2.e();
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
        for (int i = 0; i < sparseArray.size(); i++) {
            arrayList.add(sparseArray.get(sparseArray.keyAt(i)));
        }
        return arrayList;
    }

    private m b(DownloadTask downloadTask) {
        DownloadInfo downloadInfo;
        boolean z;
        List<com.ss.android.socialbase.downloader.model.b> i;
        if (downloadTask == null || (downloadInfo = downloadTask.getDownloadInfo()) == null) {
            return null;
        }
        downloadInfo.isNeedIndependentProcess();
        boolean z2 = true;
        boolean z3 = (com.ss.android.socialbase.downloader.i.f.c() || !com.ss.android.socialbase.downloader.i.f.a()) ? true : true;
        int a2 = a(downloadInfo.getId());
        if (a2 >= 0 && a2 != z3) {
            try {
                if (a2 == 1) {
                    if (com.ss.android.socialbase.downloader.i.f.a()) {
                        com.ss.android.socialbase.downloader.impls.l.a(true).a(downloadInfo.getId());
                        DownloadInfo h = com.ss.android.socialbase.downloader.impls.l.a(true).h(downloadInfo.getId());
                        if (h != null) {
                            com.ss.android.socialbase.downloader.impls.l.a(false).b(h);
                        }
                        if (h.getChunkCount() > 1 && (i = com.ss.android.socialbase.downloader.impls.l.a(true).i(downloadInfo.getId())) != null) {
                            com.ss.android.socialbase.downloader.impls.l.a(false).a(downloadInfo.getId(), com.ss.android.socialbase.downloader.i.f.a(i));
                        }
                    }
                } else if (com.ss.android.socialbase.downloader.i.f.a()) {
                    com.ss.android.socialbase.downloader.impls.l.a(false).a(downloadInfo.getId());
                    List<com.ss.android.socialbase.downloader.model.b> i2 = com.ss.android.socialbase.downloader.impls.l.a(false).i(downloadInfo.getId());
                    if (i2 != null) {
                        com.ss.android.socialbase.downloader.impls.l.a(true).a(downloadInfo.getId(), com.ss.android.socialbase.downloader.i.f.a(i2));
                    }
                } else {
                    downloadTask.setNeedDelayForCacheSync(true);
                    com.ss.android.socialbase.downloader.impls.l.a(true).a(1, downloadInfo.getId());
                }
            } catch (Throwable unused) {
            }
        }
        int id = downloadInfo.getId();
        if (z3) {
            z = true;
        } else {
            z = false;
        }
        a(id, z);
        if (!z3) {
            z2 = false;
        }
        return com.ss.android.socialbase.downloader.impls.l.a(z2);
    }

    public int a(int i) {
        if (!c.S()) {
            return -1;
        }
        if (!com.ss.android.socialbase.downloader.i.f.c() && com.ss.android.socialbase.downloader.impls.l.a(true).g()) {
            return com.ss.android.socialbase.downloader.impls.l.a(true).m(i);
        }
        return b(i);
    }

    public synchronized int b(int i) {
        if (this.b.get(i) == null) {
            return -1;
        }
        return this.b.get(i).booleanValue() ? 1 : 0;
    }

    public m c(int i) {
        boolean z = true;
        return com.ss.android.socialbase.downloader.impls.l.a((a(i) != 1 || com.ss.android.socialbase.downloader.i.f.c()) ? false : false);
    }

    public List<DownloadInfo> d(String str) {
        List<DownloadInfo> list;
        SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
        m a2 = com.ss.android.socialbase.downloader.impls.l.a(false);
        List<DownloadInfo> list2 = null;
        if (a2 != null) {
            list = a2.d(str);
        } else {
            list = null;
        }
        m a3 = com.ss.android.socialbase.downloader.impls.l.a(true);
        if (a3 != null) {
            list2 = a3.d(str);
        }
        return a(list, list2, sparseArray);
    }

    public List<DownloadInfo> e(String str) {
        List<DownloadInfo> list;
        SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
        m a2 = com.ss.android.socialbase.downloader.impls.l.a(false);
        List<DownloadInfo> list2 = null;
        if (a2 != null) {
            list = a2.e(str);
        } else {
            list = null;
        }
        m a3 = com.ss.android.socialbase.downloader.impls.l.a(true);
        if (a3 != null) {
            list2 = a3.e(str);
        }
        return a(list, list2, sparseArray);
    }

    public void f(int i) {
        m c = c(i);
        if (c == null) {
            return;
        }
        c.c(i);
    }

    public void g(int i) {
        m c = c(i);
        if (c == null) {
            return;
        }
        c.d(i);
    }

    public long h(int i) {
        m c = c(i);
        if (c == null) {
            return 0L;
        }
        return c.e(i);
    }

    public int i(int i) {
        m c = c(i);
        if (c == null) {
            return 0;
        }
        return c.f(i);
    }

    public boolean j(int i) {
        m c = c(i);
        if (c == null) {
            return false;
        }
        return c.g(i);
    }

    public DownloadInfo k(int i) {
        m c = c(i);
        if (c == null) {
            return null;
        }
        return c.h(i);
    }

    public z l(int i) {
        m c = c(i);
        if (c == null) {
            return null;
        }
        return c.q(i);
    }

    public af m(int i) {
        m c = c(i);
        if (c == null) {
            return null;
        }
        return c.r(i);
    }

    public void n(int i) {
        m c = c(i);
        if (c == null) {
            return;
        }
        c.j(i);
    }

    public boolean o(int i) {
        m c = c(i);
        if (c == null) {
            return false;
        }
        return c.l(i);
    }

    public void p(int i) {
        m a2 = com.ss.android.socialbase.downloader.impls.l.a(false);
        if (a2 != null) {
            a2.k(i);
        }
        m a3 = com.ss.android.socialbase.downloader.impls.l.a(true);
        if (a3 != null) {
            a3.k(i);
        }
    }

    public void q(int i) {
        if (i == 0) {
            return;
        }
        b(i, true);
        m a2 = com.ss.android.socialbase.downloader.impls.l.a(true);
        if (a2 == null) {
            return;
        }
        a2.startService();
    }

    public IDownloadFileUriProvider r(int i) {
        m c = c(i);
        if (c == null) {
            return null;
        }
        return c.s(i);
    }

    public int a(String str, String str2) {
        return c.a(str, str2);
    }

    public DownloadInfo b(String str, String str2) {
        int a2 = a(str, str2);
        m c = c(a2);
        if (c == null) {
            return null;
        }
        return c.h(a2);
    }

    public void d(int i, boolean z) {
        m c = c(i);
        if (c == null) {
            return;
        }
        c.b(i, z);
    }

    public List<DownloadInfo> a(String str) {
        List<DownloadInfo> a2 = com.ss.android.socialbase.downloader.impls.l.a(false).a(str);
        List<DownloadInfo> a3 = com.ss.android.socialbase.downloader.impls.l.a(true).a(str);
        if (a2 == null && a3 == null) {
            return null;
        }
        if (a2 != null && a3 != null) {
            ArrayList arrayList = new ArrayList(a2);
            arrayList.addAll(a3);
            return arrayList;
        } else if (a2 == null) {
            return a3;
        } else {
            return a2;
        }
    }

    public List<DownloadInfo> b(String str) {
        List<DownloadInfo> list;
        SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
        m a2 = com.ss.android.socialbase.downloader.impls.l.a(false);
        List<DownloadInfo> list2 = null;
        if (a2 != null) {
            list = a2.b(str);
        } else {
            list = null;
        }
        m a3 = com.ss.android.socialbase.downloader.impls.l.a(true);
        if (a3 != null) {
            list2 = a3.b(str);
        }
        return a(list, list2, sparseArray);
    }

    public List<DownloadInfo> c(String str) {
        List<DownloadInfo> list;
        SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
        m a2 = com.ss.android.socialbase.downloader.impls.l.a(false);
        List<DownloadInfo> list2 = null;
        if (a2 != null) {
            list = a2.c(str);
        } else {
            list = null;
        }
        m a3 = com.ss.android.socialbase.downloader.impls.l.a(true);
        if (a3 != null) {
            list2 = a3.c(str);
        }
        return a(list, list2, sparseArray);
    }

    public void d(int i) {
        m c = c(i);
        if (c == null) {
            return;
        }
        c.a(i);
    }

    public boolean e(int i) {
        m c = c(i);
        if (c == null) {
            return false;
        }
        return c.b(i);
    }

    public void a(int i, long j) {
        m c = c(i);
        if (c == null) {
            return;
        }
        c.a(i, j);
    }

    public synchronized void b(int i, boolean z) {
        Boolean bool;
        SparseArray<Boolean> sparseArray = this.b;
        if (z) {
            bool = Boolean.TRUE;
        } else {
            bool = Boolean.FALSE;
        }
        sparseArray.put(i, bool);
    }

    public void a(int i, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.f fVar, boolean z) {
        int hashCode;
        m c = c(i);
        if (c == null) {
            return;
        }
        if (iDownloadListener == null) {
            hashCode = 0;
        } else {
            hashCode = iDownloadListener.hashCode();
        }
        c.b(i, hashCode, iDownloadListener, fVar, z);
    }

    public void b(int i, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.f fVar, boolean z) {
        m c = c(i);
        if (c == null) {
            return;
        }
        c.a(i, iDownloadListener.hashCode(), iDownloadListener, fVar, z);
    }

    public void a(int i, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.f fVar, boolean z, boolean z2) {
        m c = c(i);
        if (c == null) {
            return;
        }
        c.a(i, iDownloadListener.hashCode(), iDownloadListener, fVar, z, z2);
    }

    public void a(int i, z zVar) {
        m c = c(i);
        if (c == null) {
            return;
        }
        c.a(i, zVar);
    }

    public void a(int i, boolean z) {
        b(i, z);
        if (c.S() && !com.ss.android.socialbase.downloader.i.f.c() && com.ss.android.socialbase.downloader.impls.l.a(true).g()) {
            com.ss.android.socialbase.downloader.impls.l.a(true).c(i, z);
        }
        if (!c.c() && !com.ss.android.socialbase.downloader.i.f.c() && !com.ss.android.socialbase.downloader.i.f.a()) {
            try {
                Intent intent = new Intent(c.N(), DownloadHandleService.class);
                intent.setAction("com.ss.android.downloader.action.PROCESS_NOTIFY");
                intent.putExtra("extra_download_id", i);
                c.N().startService(intent);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void c(int i, boolean z) {
        if (com.ss.android.socialbase.downloader.i.f.a()) {
            if (com.ss.android.socialbase.downloader.i.a.a(8388608)) {
                m a2 = com.ss.android.socialbase.downloader.impls.l.a(true);
                if (a2 != null) {
                    a2.a(i, z);
                }
                m a3 = com.ss.android.socialbase.downloader.impls.l.a(false);
                if (a3 != null) {
                    a3.a(i, z);
                    return;
                }
                return;
            }
            m a4 = com.ss.android.socialbase.downloader.impls.l.a(false);
            if (a4 != null) {
                a4.a(i, z);
            }
            m a5 = com.ss.android.socialbase.downloader.impls.l.a(true);
            if (a5 != null) {
                a5.a(i, z);
                return;
            }
            return;
        }
        m c = c(i);
        if (c != null) {
            c.a(i, z);
        }
        com.ss.android.socialbase.downloader.impls.l.a(true).a(2, i);
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
        synchronized (this.d) {
            if (!this.d.contains(acVar)) {
                this.d.add(acVar);
            }
        }
    }

    public void b(ac acVar) {
        if (acVar == null) {
            return;
        }
        synchronized (this.d) {
            if (this.d.contains(acVar)) {
                this.d.remove(acVar);
            }
        }
    }

    public void a(com.ss.android.socialbase.downloader.depend.k kVar) {
        c.a(kVar);
    }

    public void b(com.ss.android.socialbase.downloader.depend.k kVar) {
        c.b(kVar);
    }

    public void a(final DownloadTask downloadTask) {
        int i;
        final m b = b(downloadTask);
        if (b == null) {
            if (downloadTask != null) {
                x monitorDepend = downloadTask.getMonitorDepend();
                DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
                BaseException baseException = new BaseException(1003, "tryDownload but getDownloadHandler failed");
                if (downloadTask.getDownloadInfo() != null) {
                    i = downloadTask.getDownloadInfo().getStatus();
                } else {
                    i = 0;
                }
                com.ss.android.socialbase.downloader.d.a.a(monitorDepend, downloadInfo, baseException, i);
            }
        } else if (downloadTask.isNeedDelayForCacheSync()) {
            this.c.postDelayed(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.d.1
                @Override // java.lang.Runnable
                public void run() {
                    b.a(downloadTask);
                }
            }, 500L);
        } else {
            b.a(downloadTask);
        }
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

    public boolean a(DownloadInfo downloadInfo) {
        m c;
        if (downloadInfo == null || (c = c(downloadInfo.getId())) == null) {
            return false;
        }
        return c.a(downloadInfo);
    }
}
