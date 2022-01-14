package com.ss.android.socialbase.downloader.impls;

import android.database.sqlite.SQLiteException;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.constants.EnqueueType;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.af;
import com.ss.android.socialbase.downloader.depend.x;
import com.ss.android.socialbase.downloader.depend.z;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.h.h;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
/* loaded from: classes3.dex */
public abstract class a implements h.a {

    /* renamed from: b  reason: collision with root package name */
    public final SparseArray<DownloadTask> f60130b = new SparseArray<>();

    /* renamed from: c  reason: collision with root package name */
    public final SparseArray<DownloadTask> f60131c = new SparseArray<>();

    /* renamed from: d  reason: collision with root package name */
    public final SparseArray<DownloadTask> f60132d = new SparseArray<>();

    /* renamed from: e  reason: collision with root package name */
    public final SparseArray<DownloadTask> f60133e = new SparseArray<>();

    /* renamed from: f  reason: collision with root package name */
    public final SparseArray<DownloadTask> f60134f = new SparseArray<>();

    /* renamed from: g  reason: collision with root package name */
    public final SparseArray<SparseArray<DownloadTask>> f60135g = new SparseArray<>();

    /* renamed from: h  reason: collision with root package name */
    public final com.ss.android.socialbase.downloader.i.h<Integer, DownloadTask> f60136h = new com.ss.android.socialbase.downloader.i.h<>();

    /* renamed from: i  reason: collision with root package name */
    public final SparseArray<Long> f60137i = new SparseArray<>();

    /* renamed from: j  reason: collision with root package name */
    public final LinkedBlockingDeque<DownloadTask> f60138j = new LinkedBlockingDeque<>();
    public final com.ss.android.socialbase.downloader.h.h a = new com.ss.android.socialbase.downloader.h.h(Looper.getMainLooper(), this);
    public final com.ss.android.socialbase.downloader.downloader.j k = com.ss.android.socialbase.downloader.downloader.c.x();

    private void c(DownloadTask downloadTask) {
        DownloadInfo downloadInfo;
        if (downloadTask == null || (downloadInfo = downloadTask.getDownloadInfo()) == null) {
            return;
        }
        try {
            if (this.f60138j.isEmpty()) {
                a(downloadTask, true);
                this.f60138j.put(downloadTask);
            } else if (downloadInfo.getEnqueueType() == EnqueueType.ENQUEUE_TAIL) {
                if (this.f60138j.getFirst().getDownloadId() == downloadTask.getDownloadId() && a(downloadTask.getDownloadId())) {
                    return;
                }
                Iterator<DownloadTask> it = this.f60138j.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    DownloadTask next = it.next();
                    if (next != null && next.getDownloadId() == downloadTask.getDownloadId()) {
                        it.remove();
                        break;
                    }
                }
                this.f60138j.put(downloadTask);
                new com.ss.android.socialbase.downloader.downloader.f(downloadTask, this.a).a();
            } else {
                DownloadTask first = this.f60138j.getFirst();
                if (first.getDownloadId() == downloadTask.getDownloadId() && a(downloadTask.getDownloadId())) {
                    return;
                }
                e(first.getDownloadId());
                a(downloadTask, true);
                if (first.getDownloadId() != downloadTask.getDownloadId()) {
                    this.f60138j.putFirst(downloadTask);
                }
            }
        } catch (InterruptedException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadTask o(int i2) {
        DownloadTask downloadTask = this.f60130b.get(i2);
        if (downloadTask == null) {
            DownloadTask downloadTask2 = this.f60132d.get(i2);
            if (downloadTask2 == null) {
                DownloadTask downloadTask3 = this.f60131c.get(i2);
                if (downloadTask3 == null) {
                    DownloadTask downloadTask4 = this.f60133e.get(i2);
                    return downloadTask4 == null ? this.f60134f.get(i2) : downloadTask4;
                }
                return downloadTask3;
            }
            return downloadTask2;
        }
        return downloadTask;
    }

    private void p(int i2) {
        DownloadTask first;
        if (this.f60138j.isEmpty()) {
            return;
        }
        DownloadTask first2 = this.f60138j.getFirst();
        if (first2 != null && first2.getDownloadId() == i2) {
            this.f60138j.poll();
        }
        if (this.f60138j.isEmpty() || (first = this.f60138j.getFirst()) == null) {
            return;
        }
        a(first, true);
    }

    public abstract List<Integer> a();

    public abstract void a(int i2, long j2);

    public abstract void a(int i2, DownloadTask downloadTask);

    public abstract void a(com.ss.android.socialbase.downloader.h.c cVar);

    public abstract boolean a(int i2);

    public abstract void b(int i2);

    public abstract com.ss.android.socialbase.downloader.h.c c(int i2);

    public synchronized DownloadInfo d(int i2) {
        DownloadInfo b2;
        DownloadTask downloadTask;
        b2 = this.k.b(i2);
        if (b2 == null && (downloadTask = this.f60130b.get(i2)) != null) {
            b2 = downloadTask.getDownloadInfo();
        }
        return b2;
    }

    public synchronized boolean e(int i2) {
        com.ss.android.socialbase.downloader.c.a.b("AbsDownloadEngine", "pause id=" + i2);
        DownloadInfo b2 = this.k.b(i2);
        if (b2 == null || b2.getStatus() != 11) {
            synchronized (this.f60130b) {
                b(i2);
            }
            if (b2 == null) {
                DownloadTask downloadTask = this.f60130b.get(i2);
                if (downloadTask != null) {
                    new com.ss.android.socialbase.downloader.downloader.f(downloadTask, this.a).d();
                    return true;
                }
            } else {
                a(b2);
                if (b2.getStatus() == 1) {
                    DownloadTask downloadTask2 = this.f60130b.get(i2);
                    if (downloadTask2 != null) {
                        new com.ss.android.socialbase.downloader.downloader.f(downloadTask2, this.a).d();
                        return true;
                    }
                } else if (DownloadStatus.isDownloading(b2.getStatus())) {
                    b2.setStatus(-2);
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public synchronized boolean f(int i2) {
        DownloadTask downloadTask = this.f60130b.get(i2);
        if (downloadTask != null) {
            DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
            if (downloadInfo != null) {
                downloadInfo.setDownloadFromReserveWifi(false);
            }
            a(downloadTask);
        } else {
            g(i2);
        }
        return true;
    }

    public synchronized boolean g(int i2) {
        DownloadTask downloadTask = this.f60132d.get(i2);
        if (downloadTask == null) {
            downloadTask = this.f60133e.get(i2);
        }
        if (downloadTask != null) {
            DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
            if (downloadInfo != null) {
                downloadInfo.setDownloadFromReserveWifi(false);
            }
            a(downloadTask);
            return true;
        }
        return false;
    }

    public synchronized af h(int i2) {
        DownloadTask downloadTask = this.f60130b.get(i2);
        if (downloadTask != null) {
            return downloadTask.getNotificationClickCallback();
        }
        DownloadTask downloadTask2 = this.f60131c.get(i2);
        if (downloadTask2 != null) {
            return downloadTask2.getNotificationClickCallback();
        }
        DownloadTask downloadTask3 = this.f60132d.get(i2);
        if (downloadTask3 != null) {
            return downloadTask3.getNotificationClickCallback();
        }
        DownloadTask downloadTask4 = this.f60133e.get(i2);
        if (downloadTask4 != null) {
            return downloadTask4.getNotificationClickCallback();
        }
        DownloadTask downloadTask5 = this.f60134f.get(i2);
        if (downloadTask5 != null) {
            return downloadTask5.getNotificationClickCallback();
        }
        return null;
    }

    public synchronized z i(int i2) {
        DownloadTask downloadTask = this.f60130b.get(i2);
        if (downloadTask != null) {
            return downloadTask.getNotificationEventListener();
        }
        DownloadTask downloadTask2 = this.f60131c.get(i2);
        if (downloadTask2 != null) {
            return downloadTask2.getNotificationEventListener();
        }
        DownloadTask downloadTask3 = this.f60132d.get(i2);
        if (downloadTask3 != null) {
            return downloadTask3.getNotificationEventListener();
        }
        DownloadTask downloadTask4 = this.f60133e.get(i2);
        if (downloadTask4 != null) {
            return downloadTask4.getNotificationEventListener();
        }
        DownloadTask downloadTask5 = this.f60134f.get(i2);
        if (downloadTask5 != null) {
            return downloadTask5.getNotificationEventListener();
        }
        return null;
    }

    public synchronized IDownloadFileUriProvider j(int i2) {
        DownloadTask downloadTask = this.f60130b.get(i2);
        if (downloadTask != null) {
            return downloadTask.getFileUriProvider();
        }
        DownloadTask downloadTask2 = this.f60131c.get(i2);
        if (downloadTask2 != null) {
            return downloadTask2.getFileUriProvider();
        }
        DownloadTask downloadTask3 = this.f60132d.get(i2);
        if (downloadTask3 != null) {
            return downloadTask3.getFileUriProvider();
        }
        DownloadTask downloadTask4 = this.f60133e.get(i2);
        if (downloadTask4 != null) {
            return downloadTask4.getFileUriProvider();
        }
        DownloadTask downloadTask5 = this.f60134f.get(i2);
        if (downloadTask5 != null) {
            return downloadTask5.getFileUriProvider();
        }
        return null;
    }

    public synchronized boolean k(int i2) {
        DownloadInfo downloadInfo;
        DownloadTask downloadTask = this.f60133e.get(i2);
        if (downloadTask != null && (downloadInfo = downloadTask.getDownloadInfo()) != null) {
            if (downloadInfo.canStartRetryDelayTask()) {
                a(downloadTask, false);
            }
            return true;
        }
        DownloadInfo b2 = this.k.b(i2);
        if (b2 != null && b2.canStartRetryDelayTask()) {
            a(new DownloadTask(b2), false);
        }
        return false;
    }

    public synchronized boolean l(int i2) {
        DownloadInfo downloadInfo;
        DownloadTask downloadTask = this.f60134f.get(i2);
        if (downloadTask == null || (downloadInfo = downloadTask.getDownloadInfo()) == null) {
            return false;
        }
        if (downloadInfo.canReStartAsyncTask()) {
            a(downloadTask);
        }
        return true;
    }

    public synchronized void m(int i2) {
        DownloadInfo downloadInfo;
        DownloadTask downloadTask = this.f60130b.get(i2);
        if (downloadTask != null && (downloadInfo = downloadTask.getDownloadInfo()) != null) {
            downloadInfo.setForceIgnoreRecommendSize(true);
            a(downloadTask);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0011, code lost:
        if (r1.f60132d.get(r2) != null) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized boolean n(int i2) {
        boolean z;
        if (i2 != 0) {
            if (this.f60130b.get(i2) == null) {
            }
            z = true;
        }
        z = false;
        return z;
    }

    private void b(DownloadTask downloadTask) {
        int hashCodeForSameTask = downloadTask.getHashCodeForSameTask();
        if (hashCodeForSameTask == 0 && downloadTask.isAutoSetHashCodeForSameTask()) {
            hashCodeForSameTask = downloadTask.autoCalAndGetHashCodeForSameTask();
        }
        if (hashCodeForSameTask == 0) {
            return;
        }
        SparseArray<DownloadTask> sparseArray = this.f60135g.get(downloadTask.getDownloadId());
        if (sparseArray == null) {
            sparseArray = new SparseArray<>();
            this.f60135g.put(downloadTask.getDownloadId(), sparseArray);
        }
        com.ss.android.socialbase.downloader.c.a.b("AbsDownloadEngine", "tryCacheSameTaskWithListenerHashCode id:" + downloadTask.getDownloadId() + " listener hasCode:" + hashCodeForSameTask);
        sparseArray.put(hashCodeForSameTask, downloadTask);
    }

    private void a(DownloadTask downloadTask, boolean z) {
        DownloadInfo downloadInfo;
        int i2;
        DownloadInfo downloadInfo2;
        DownloadTask remove;
        if (downloadTask == null || (downloadInfo = downloadTask.getDownloadInfo()) == null) {
            return;
        }
        if (downloadInfo.isEntityInvalid()) {
            x monitorDepend = downloadTask.getMonitorDepend();
            com.ss.android.socialbase.downloader.d.a.a(monitorDepend, downloadInfo, new BaseException(1003, "downloadInfo is Invalid, url is " + downloadInfo.getUrl() + " name is " + downloadInfo.getName() + " savePath is " + downloadInfo.getSavePath()), downloadInfo.getStatus());
            return;
        }
        boolean z2 = false;
        if (com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).a("no_net_opt", 0) == 1 && !com.ss.android.socialbase.downloader.i.f.c(com.ss.android.socialbase.downloader.downloader.c.N()) && !downloadInfo.isFirstDownload()) {
            new com.ss.android.socialbase.downloader.downloader.f(downloadTask, this.a).a(new BaseException(1049, "network_not_available"));
            return;
        }
        int id = downloadInfo.getId();
        if (z) {
            a(downloadInfo);
        }
        if (this.f60132d.get(id) != null) {
            this.f60132d.remove(id);
        }
        if (this.f60131c.get(id) != null) {
            this.f60131c.remove(id);
        }
        if (this.f60133e.get(id) != null) {
            this.f60133e.remove(id);
        }
        if (this.f60134f.get(id) != null) {
            this.f60134f.remove(id);
        }
        if (a(id) && !downloadInfo.canReStartAsyncTask()) {
            com.ss.android.socialbase.downloader.c.a.b("AbsDownloadEngine", "another task with same id is downloading when tryDownload");
            downloadTask.addListenerToDownloadingSameTask();
            com.ss.android.socialbase.downloader.d.a.a(downloadTask.getMonitorDepend(), downloadInfo, new BaseException(1003, "downloadInfo is isDownloading and addListenerToSameTask is false"), downloadInfo.getStatus());
            return;
        }
        com.ss.android.socialbase.downloader.c.a.b("AbsDownloadEngine", "no downloading task :" + id);
        if (downloadInfo.canReStartAsyncTask()) {
            downloadInfo.setAsyncHandleStatus(com.ss.android.socialbase.downloader.constants.a.ASYNC_HANDLE_RESTART);
        }
        if (com.ss.android.socialbase.downloader.i.a.a(32768) && (remove = this.f60136h.remove(Integer.valueOf(id))) != null) {
            downloadTask.copyListenerFromPendingTask(remove);
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        DownloadTask downloadTask2 = this.f60130b.get(id);
        if (downloadTask2 == null || (downloadInfo2 = downloadTask2.getDownloadInfo()) == null) {
            i2 = 0;
        } else {
            i2 = downloadInfo2.getStatus();
            if (DownloadStatus.isDownloading(i2)) {
                z2 = true;
            }
        }
        com.ss.android.socialbase.downloader.c.a.b("AbsDownloadEngine", "can add listener " + z2 + " , oldTaskStatus is :" + i2);
        if (z2) {
            downloadTask.addListenerToDownloadingSameTask();
            return;
        }
        b(downloadTask);
        this.f60130b.put(id, downloadTask);
        this.f60137i.put(id, Long.valueOf(uptimeMillis));
        a(id, downloadTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void d(int i2, boolean z) {
        com.ss.android.socialbase.downloader.c.a.b("AbsDownloadEngine", "clearDownloadDataInSubThread::id=" + i2 + " deleteTargetFile=" + z);
        DownloadInfo b2 = this.k.b(i2);
        if (b2 != null) {
            if (z) {
                com.ss.android.socialbase.downloader.i.f.a(b2);
            } else {
                com.ss.android.socialbase.downloader.i.f.c(b2.getTempPath(), b2.getTempName());
            }
            b2.erase();
        }
        try {
            this.k.f(i2);
        } catch (SQLiteException e2) {
            e2.printStackTrace();
        }
        a(i2, 0, -4);
        if (this.f60132d.get(i2) != null) {
            this.f60132d.remove(i2);
        }
        if (this.f60131c.get(i2) != null) {
            this.f60131c.remove(i2);
        }
        this.f60136h.remove(Integer.valueOf(i2));
        com.ss.android.socialbase.downloader.g.a.b(i2);
    }

    public synchronized void b(List<String> list) {
        DownloadInfo downloadInfo;
        try {
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (com.ss.android.socialbase.downloader.i.f.b(com.ss.android.socialbase.downloader.downloader.c.N())) {
            for (int i2 = 0; i2 < this.f60130b.size(); i2++) {
                DownloadTask downloadTask = this.f60130b.get(this.f60130b.keyAt(i2));
                if (downloadTask != null && (downloadInfo = downloadTask.getDownloadInfo()) != null && downloadInfo.getMimeType() != null && list.contains(downloadInfo.getMimeType()) && b(downloadInfo)) {
                    downloadInfo.setAutoResumed(true);
                    downloadInfo.setShowNotificationForNetworkResumed(true);
                    a(downloadTask);
                    downloadInfo.setDownloadFromReserveWifi(true);
                    com.ss.android.socialbase.downloader.downloader.r reserveWifiStatusListener = Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.c.N()).getReserveWifiStatusListener();
                    if (reserveWifiStatusListener != null) {
                        reserveWifiStatusListener.a(downloadInfo, 5, 2);
                    }
                }
            }
        }
    }

    public void c(final int i2, final boolean z) {
        DownloadInfo b2 = this.k.b(i2);
        if (b2 != null) {
            a(b2);
        }
        this.a.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.a.4
            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.downloader.notification.b.a().f(i2);
            }
        });
        com.ss.android.socialbase.downloader.downloader.c.a(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.a.5
            @Override // java.lang.Runnable
            public void run() {
                a.this.c(i2);
                a.this.e(i2, z);
            }
        }, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(int i2, boolean z) {
        try {
            DownloadInfo b2 = this.k.b(i2);
            if (b2 != null) {
                com.ss.android.socialbase.downloader.i.f.a(b2, z);
                b2.erase();
            }
            try {
                this.k.d(i2);
                this.k.a(b2);
            } catch (SQLiteException e2) {
                e2.printStackTrace();
            }
            if (this.f60132d.get(i2) != null) {
                this.f60132d.remove(i2);
            }
            if (this.f60131c.get(i2) != null) {
                this.f60131c.remove(i2);
            }
            this.f60136h.remove(Integer.valueOf(i2));
            com.ss.android.socialbase.downloader.g.a.b(i2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private boolean b(DownloadInfo downloadInfo) {
        if (downloadInfo != null && downloadInfo.statusInPause()) {
            return downloadInfo.isPauseReserveOnWifi();
        }
        return false;
    }

    public void b() {
        List<Integer> a = a();
        if (a == null) {
            return;
        }
        for (Integer num : a) {
            e(num.intValue());
        }
    }

    public void b(final int i2, final boolean z) {
        DownloadInfo b2 = this.k.b(i2);
        if (b2 != null) {
            a(b2);
        }
        this.a.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.a.2
            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.downloader.notification.b.a().f(i2);
            }
        });
        com.ss.android.socialbase.downloader.downloader.c.a(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.a.3
            @Override // java.lang.Runnable
            public void run() {
                DownloadTask o;
                if (a.this.c(i2) == null && (o = a.this.o(i2)) != null) {
                    DownloadInfo downloadInfo = o.getDownloadInfo();
                    SparseArray<IDownloadListener> downloadListeners = o.getDownloadListeners(com.ss.android.socialbase.downloader.constants.f.SUB);
                    if (downloadListeners != null) {
                        synchronized (downloadListeners) {
                            for (int i3 = 0; i3 < downloadListeners.size(); i3++) {
                                IDownloadListener iDownloadListener = downloadListeners.get(downloadListeners.keyAt(i3));
                                if (iDownloadListener != null) {
                                    iDownloadListener.onCanceled(downloadInfo);
                                }
                            }
                        }
                    }
                }
                a.this.d(i2, z);
            }
        }, false);
    }

    public synchronized void b(int i2, int i3, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.f fVar, boolean z) {
        a(i2, i3, iDownloadListener, fVar, z, true);
    }

    public List<DownloadInfo> b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Integer num : a()) {
            DownloadInfo d2 = d(num.intValue());
            if (d2 != null && str.equals(d2.getMimeType())) {
                arrayList.add(d2);
            }
        }
        return arrayList;
    }

    public synchronized void a(DownloadTask downloadTask) {
        if (downloadTask == null) {
            return;
        }
        DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
        if (downloadInfo == null) {
            return;
        }
        downloadInfo.setDownloadFromReserveWifi(false);
        if (downloadInfo.getEnqueueType() != EnqueueType.ENQUEUE_NONE) {
            c(downloadTask);
        } else {
            a(downloadTask, true);
        }
    }

    public void b(int i2, long j2) {
        DownloadInfo b2 = this.k.b(i2);
        if (b2 != null) {
            b2.setThrottleNetSpeed(j2);
        }
        a(i2, j2);
    }

    public synchronized List<DownloadInfo> a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        List<DownloadInfo> a = this.k.a(str);
        if (a == null || a.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            int size = this.f60130b.size();
            for (int i2 = 0; i2 < size; i2++) {
                DownloadTask valueAt = this.f60130b.valueAt(i2);
                if (valueAt != null && valueAt.getDownloadInfo() != null && str.equals(valueAt.getDownloadInfo().getUrl())) {
                    arrayList.add(valueAt.getDownloadInfo());
                }
            }
            return arrayList;
        }
        return a;
    }

    public synchronized boolean a(int i2, boolean z) {
        DownloadTask downloadTask = this.f60130b.get(i2);
        if (downloadTask == null && com.ss.android.socialbase.downloader.i.a.a(65536)) {
            downloadTask = o(i2);
        }
        if (downloadTask != null) {
            if (!com.ss.android.socialbase.downloader.g.a.a(i2).b("fix_on_cancel_call_twice", true)) {
                new com.ss.android.socialbase.downloader.downloader.f(downloadTask, this.a).c();
            }
            final DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
            final SparseArray<IDownloadListener> downloadListeners = downloadTask.getDownloadListeners(com.ss.android.socialbase.downloader.constants.f.MAIN);
            final SparseArray<IDownloadListener> downloadListeners2 = downloadTask.getDownloadListeners(com.ss.android.socialbase.downloader.constants.f.NOTIFICATION);
            this.a.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.a.1
                @Override // java.lang.Runnable
                public void run() {
                    SparseArray sparseArray;
                    SparseArray sparseArray2 = downloadListeners;
                    if (sparseArray2 != null) {
                        synchronized (sparseArray2) {
                            for (int i3 = 0; i3 < downloadListeners.size(); i3++) {
                                IDownloadListener iDownloadListener = (IDownloadListener) downloadListeners.get(downloadListeners.keyAt(i3));
                                if (iDownloadListener != null) {
                                    iDownloadListener.onCanceled(downloadInfo);
                                }
                            }
                        }
                    }
                    DownloadInfo downloadInfo2 = downloadInfo;
                    if (downloadInfo2 == null || !downloadInfo2.canShowNotification() || (sparseArray = downloadListeners2) == null) {
                        return;
                    }
                    synchronized (sparseArray) {
                        for (int i4 = 0; i4 < downloadListeners2.size(); i4++) {
                            IDownloadListener iDownloadListener2 = (IDownloadListener) downloadListeners2.get(downloadListeners2.keyAt(i4));
                            if (iDownloadListener2 != null) {
                                iDownloadListener2.onCanceled(downloadInfo);
                            }
                        }
                    }
                }
            });
        }
        DownloadInfo b2 = this.k.b(i2);
        if (com.ss.android.socialbase.downloader.i.a.a(65536)) {
            if (b2 != null) {
                b2.setStatus(-4);
            }
        } else if (b2 != null && DownloadStatus.isDownloading(b2.getStatus())) {
            b2.setStatus(-4);
        }
        b(i2, z);
        return true;
    }

    private void a(DownloadInfo downloadInfo) {
        if (downloadInfo != null) {
            try {
                if (downloadInfo.getStatus() == 7 || downloadInfo.getRetryDelayStatus() != com.ss.android.socialbase.downloader.constants.g.DELAY_RETRY_NONE) {
                    downloadInfo.setStatus(5);
                    downloadInfo.setRetryDelayStatus(com.ss.android.socialbase.downloader.constants.g.DELAY_RETRY_NONE);
                    com.ss.android.socialbase.downloader.c.a.b("AbsDownloadEngine", "cancelAlarm");
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public synchronized void a(int i2, z zVar) {
        DownloadTask downloadTask = this.f60130b.get(i2);
        if (downloadTask != null) {
            downloadTask.setNotificationEventListener(zVar);
        }
    }

    public synchronized void a(List<String> list) {
        DownloadInfo downloadInfo;
        try {
            boolean b2 = com.ss.android.socialbase.downloader.i.a.a(1048576) ? com.ss.android.socialbase.downloader.i.f.b(com.ss.android.socialbase.downloader.downloader.c.N()) : true;
            for (int i2 = 0; i2 < this.f60132d.size(); i2++) {
                DownloadTask downloadTask = this.f60132d.get(this.f60132d.keyAt(i2));
                if (downloadTask != null && (downloadInfo = downloadTask.getDownloadInfo()) != null && downloadInfo.getMimeType() != null && list.contains(downloadInfo.getMimeType()) && (!downloadInfo.isOnlyWifi() || b2)) {
                    downloadInfo.setAutoResumed(true);
                    downloadInfo.setShowNotificationForNetworkResumed(true);
                    a(downloadTask);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public synchronized void a(int i2, int i3, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.f fVar, boolean z) {
        DownloadTask o = o(i2);
        if (o == null) {
            o = this.f60136h.get(Integer.valueOf(i2));
        }
        if (o != null) {
            o.removeDownloadListener(i3, iDownloadListener, fVar, z);
        }
    }

    public synchronized void a(int i2, int i3, final IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.f fVar, boolean z, boolean z2) {
        DownloadInfo b2;
        DownloadTask o = o(i2);
        if (o != null) {
            o.addDownloadListener(i3, iDownloadListener, fVar, z);
            final DownloadInfo downloadInfo = o.getDownloadInfo();
            if (z2 && downloadInfo != null && !a(i2) && (fVar == com.ss.android.socialbase.downloader.constants.f.MAIN || fVar == com.ss.android.socialbase.downloader.constants.f.NOTIFICATION)) {
                boolean z3 = true;
                if (fVar == com.ss.android.socialbase.downloader.constants.f.NOTIFICATION && !downloadInfo.canShowNotification()) {
                    z3 = false;
                }
                if (z3) {
                    this.a.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.a.6
                        @Override // java.lang.Runnable
                        public void run() {
                            if (iDownloadListener != null) {
                                if (downloadInfo.getStatus() == -3) {
                                    iDownloadListener.onSuccessed(downloadInfo);
                                } else if (downloadInfo.getStatus() == -1) {
                                    iDownloadListener.onFailed(downloadInfo, new BaseException(1000, "try add listener for failed task"));
                                }
                            }
                        }
                    });
                }
            }
        } else if (com.ss.android.socialbase.downloader.i.a.a(32768) && (b2 = this.k.b(i2)) != null && b2.getStatus() != -3) {
            DownloadTask downloadTask = this.f60136h.get(Integer.valueOf(i2));
            if (downloadTask == null) {
                downloadTask = new DownloadTask(b2);
                this.f60136h.put(Integer.valueOf(i2), downloadTask);
            }
            downloadTask.addDownloadListener(i3, iDownloadListener, fVar, z);
        }
    }

    private void a(int i2, BaseException baseException, DownloadTask downloadTask) {
        if (downloadTask != null) {
            DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
            SparseArray<IDownloadListener> downloadListeners = downloadTask.getDownloadListeners(com.ss.android.socialbase.downloader.constants.f.MAIN);
            SparseArray<IDownloadListener> downloadListeners2 = downloadTask.getDownloadListeners(com.ss.android.socialbase.downloader.constants.f.NOTIFICATION);
            boolean z = downloadTask.canShowNotification() || downloadInfo.isAutoInstallWithoutNotification();
            com.ss.android.socialbase.downloader.i.c.a(i2, downloadListeners, true, downloadInfo, baseException);
            com.ss.android.socialbase.downloader.i.c.a(i2, downloadListeners2, z, downloadInfo, baseException);
        }
    }

    private void a(int i2, int i3) {
        com.ss.android.socialbase.downloader.c.a.b("AbsDownloadEngine", "removeTask id: " + i2 + " listener hasCode: " + i3);
        if (i3 == 0) {
            this.f60130b.remove(i2);
            this.f60135g.remove(i2);
            return;
        }
        SparseArray<DownloadTask> sparseArray = this.f60135g.get(i2);
        if (sparseArray != null) {
            sparseArray.remove(i3);
            com.ss.android.socialbase.downloader.c.a.b("AbsDownloadEngine", "after downloadTaskWithListenerMap removeTask taskArray.size: " + sparseArray.size());
            if (sparseArray.size() == 0) {
                this.f60130b.remove(i2);
                this.f60135g.remove(i2);
                return;
            }
            return;
        }
        this.f60130b.remove(i2);
    }

    public synchronized void a(int i2, int i3, int i4) {
        if (i4 != -7) {
            if (i4 == -6) {
                this.f60131c.put(i2, this.f60130b.get(i2));
                a(i2, i3);
            } else if (i4 == -4) {
                a(i2, i3);
                p(i2);
            } else if (i4 == -3) {
                this.f60131c.put(i2, this.f60130b.get(i2));
                a(i2, i3);
                p(i2);
            } else if (i4 != -1) {
                if (i4 == 7) {
                    DownloadTask downloadTask = this.f60130b.get(i2);
                    if (downloadTask != null) {
                        if (this.f60133e.get(i2) == null) {
                            this.f60133e.put(i2, downloadTask);
                        }
                        a(i2, i3);
                    }
                    p(i2);
                } else if (i4 == 8) {
                    DownloadTask downloadTask2 = this.f60130b.get(i2);
                    if (downloadTask2 != null && this.f60134f.get(i2) == null) {
                        this.f60134f.put(i2, downloadTask2);
                    }
                    p(i2);
                }
            }
        }
        DownloadTask downloadTask3 = this.f60130b.get(i2);
        if (downloadTask3 != null) {
            if (this.f60132d.get(i2) == null) {
                this.f60132d.put(i2, downloadTask3);
            }
            a(i2, i3);
        }
        p(i2);
    }

    @Override // com.ss.android.socialbase.downloader.h.h.a
    public void a(Message message) {
        int i2 = message.arg1;
        int i3 = message.arg2;
        com.ss.android.socialbase.downloader.c.a.b("AbsDownloadEngine", "handleMsg id: " + i2 + " listener hasCode: " + i3);
        Object obj = message.obj;
        DownloadTask downloadTask = null;
        BaseException baseException = obj instanceof Exception ? (BaseException) obj : null;
        synchronized (this) {
            if (i3 == 0) {
                downloadTask = this.f60130b.get(i2);
            } else {
                SparseArray<DownloadTask> sparseArray = this.f60135g.get(i2);
                if (sparseArray != null) {
                    downloadTask = sparseArray.get(i3);
                }
            }
            if (downloadTask == null) {
                return;
            }
            a(message.what, baseException, downloadTask);
            a(i2, i3, message.what);
        }
    }
}
