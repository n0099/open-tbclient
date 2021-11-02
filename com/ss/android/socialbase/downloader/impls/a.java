package com.ss.android.socialbase.downloader.impls;

import android.database.sqlite.SQLiteException;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.mobads.container.util.SDKLogTypeConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes2.dex */
public abstract class a implements h.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final com.ss.android.socialbase.downloader.h.h f69511a;

    /* renamed from: b  reason: collision with root package name */
    public final SparseArray<DownloadTask> f69512b;

    /* renamed from: c  reason: collision with root package name */
    public final SparseArray<DownloadTask> f69513c;

    /* renamed from: d  reason: collision with root package name */
    public final SparseArray<DownloadTask> f69514d;

    /* renamed from: e  reason: collision with root package name */
    public final SparseArray<DownloadTask> f69515e;

    /* renamed from: f  reason: collision with root package name */
    public final SparseArray<DownloadTask> f69516f;

    /* renamed from: g  reason: collision with root package name */
    public final SparseArray<SparseArray<DownloadTask>> f69517g;

    /* renamed from: h  reason: collision with root package name */
    public final com.ss.android.socialbase.downloader.i.h<Integer, DownloadTask> f69518h;

    /* renamed from: i  reason: collision with root package name */
    public final SparseArray<Long> f69519i;
    public final LinkedBlockingDeque<DownloadTask> j;
    public final com.ss.android.socialbase.downloader.downloader.j k;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f69512b = new SparseArray<>();
        this.f69513c = new SparseArray<>();
        this.f69514d = new SparseArray<>();
        this.f69515e = new SparseArray<>();
        this.f69516f = new SparseArray<>();
        this.f69517g = new SparseArray<>();
        this.f69518h = new com.ss.android.socialbase.downloader.i.h<>();
        this.f69519i = new SparseArray<>();
        this.j = new LinkedBlockingDeque<>();
        this.f69511a = new com.ss.android.socialbase.downloader.h.h(Looper.getMainLooper(), this);
        this.k = com.ss.android.socialbase.downloader.downloader.c.x();
    }

    private void c(DownloadTask downloadTask) {
        DownloadInfo downloadInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65546, this, downloadTask) == null) || downloadTask == null || (downloadInfo = downloadTask.getDownloadInfo()) == null) {
            return;
        }
        try {
            if (this.j.isEmpty()) {
                a(downloadTask, true);
                this.j.put(downloadTask);
            } else if (downloadInfo.getEnqueueType() == EnqueueType.ENQUEUE_TAIL) {
                if (this.j.getFirst().getDownloadId() == downloadTask.getDownloadId() && a(downloadTask.getDownloadId())) {
                    return;
                }
                Iterator<DownloadTask> it = this.j.iterator();
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
                this.j.put(downloadTask);
                new com.ss.android.socialbase.downloader.downloader.f(downloadTask, this.f69511a).a();
            } else {
                DownloadTask first = this.j.getFirst();
                if (first.getDownloadId() == downloadTask.getDownloadId() && a(downloadTask.getDownloadId())) {
                    return;
                }
                e(first.getDownloadId());
                a(downloadTask, true);
                if (first.getDownloadId() != downloadTask.getDownloadId()) {
                    this.j.putFirst(downloadTask);
                }
            }
        } catch (InterruptedException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadTask o(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65549, this, i2)) == null) {
            DownloadTask downloadTask = this.f69512b.get(i2);
            if (downloadTask == null) {
                DownloadTask downloadTask2 = this.f69514d.get(i2);
                if (downloadTask2 == null) {
                    DownloadTask downloadTask3 = this.f69513c.get(i2);
                    if (downloadTask3 == null) {
                        DownloadTask downloadTask4 = this.f69515e.get(i2);
                        return downloadTask4 == null ? this.f69516f.get(i2) : downloadTask4;
                    }
                    return downloadTask3;
                }
                return downloadTask2;
            }
            return downloadTask;
        }
        return (DownloadTask) invokeI.objValue;
    }

    private void p(int i2) {
        DownloadTask first;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65550, this, i2) == null) || this.j.isEmpty()) {
            return;
        }
        DownloadTask first2 = this.j.getFirst();
        if (first2 != null && first2.getDownloadId() == i2) {
            this.j.poll();
        }
        if (this.j.isEmpty() || (first = this.j.getFirst()) == null) {
            return;
        }
        a(first, true);
    }

    public abstract List<Integer> a();

    public abstract void a(int i2, long j);

    public abstract void a(int i2, DownloadTask downloadTask);

    public abstract void a(com.ss.android.socialbase.downloader.h.c cVar);

    public abstract boolean a(int i2);

    public abstract void b(int i2);

    public abstract com.ss.android.socialbase.downloader.h.c c(int i2);

    public synchronized DownloadInfo d(int i2) {
        InterceptResult invokeI;
        DownloadInfo b2;
        DownloadTask downloadTask;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048599, this, i2)) == null) {
            synchronized (this) {
                b2 = this.k.b(i2);
                if (b2 == null && (downloadTask = this.f69512b.get(i2)) != null) {
                    b2 = downloadTask.getDownloadInfo();
                }
            }
            return b2;
        }
        return (DownloadInfo) invokeI.objValue;
    }

    public synchronized boolean e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048600, this, i2)) == null) {
            synchronized (this) {
                com.ss.android.socialbase.downloader.c.a.b("AbsDownloadEngine", "pause id=" + i2);
                DownloadInfo b2 = this.k.b(i2);
                if (b2 == null || b2.getStatus() != 11) {
                    synchronized (this.f69512b) {
                        b(i2);
                    }
                    if (b2 == null) {
                        DownloadTask downloadTask = this.f69512b.get(i2);
                        if (downloadTask != null) {
                            new com.ss.android.socialbase.downloader.downloader.f(downloadTask, this.f69511a).d();
                            return true;
                        }
                    } else {
                        a(b2);
                        if (b2.getStatus() == 1) {
                            DownloadTask downloadTask2 = this.f69512b.get(i2);
                            if (downloadTask2 != null) {
                                new com.ss.android.socialbase.downloader.downloader.f(downloadTask2, this.f69511a).d();
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
        }
        return invokeI.booleanValue;
    }

    public synchronized boolean f(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048601, this, i2)) == null) {
            synchronized (this) {
                DownloadTask downloadTask = this.f69512b.get(i2);
                if (downloadTask != null) {
                    DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
                    if (downloadInfo != null) {
                        downloadInfo.setDownloadFromReserveWifi(false);
                    }
                    a(downloadTask);
                } else {
                    g(i2);
                }
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public synchronized boolean g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048602, this, i2)) == null) {
            synchronized (this) {
                DownloadTask downloadTask = this.f69514d.get(i2);
                if (downloadTask == null) {
                    downloadTask = this.f69515e.get(i2);
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
        }
        return invokeI.booleanValue;
    }

    public synchronized af h(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048603, this, i2)) == null) {
            synchronized (this) {
                DownloadTask downloadTask = this.f69512b.get(i2);
                if (downloadTask != null) {
                    return downloadTask.getNotificationClickCallback();
                }
                DownloadTask downloadTask2 = this.f69513c.get(i2);
                if (downloadTask2 != null) {
                    return downloadTask2.getNotificationClickCallback();
                }
                DownloadTask downloadTask3 = this.f69514d.get(i2);
                if (downloadTask3 != null) {
                    return downloadTask3.getNotificationClickCallback();
                }
                DownloadTask downloadTask4 = this.f69515e.get(i2);
                if (downloadTask4 != null) {
                    return downloadTask4.getNotificationClickCallback();
                }
                DownloadTask downloadTask5 = this.f69516f.get(i2);
                if (downloadTask5 != null) {
                    return downloadTask5.getNotificationClickCallback();
                }
                return null;
            }
        }
        return (af) invokeI.objValue;
    }

    public synchronized z i(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048604, this, i2)) == null) {
            synchronized (this) {
                DownloadTask downloadTask = this.f69512b.get(i2);
                if (downloadTask != null) {
                    return downloadTask.getNotificationEventListener();
                }
                DownloadTask downloadTask2 = this.f69513c.get(i2);
                if (downloadTask2 != null) {
                    return downloadTask2.getNotificationEventListener();
                }
                DownloadTask downloadTask3 = this.f69514d.get(i2);
                if (downloadTask3 != null) {
                    return downloadTask3.getNotificationEventListener();
                }
                DownloadTask downloadTask4 = this.f69515e.get(i2);
                if (downloadTask4 != null) {
                    return downloadTask4.getNotificationEventListener();
                }
                DownloadTask downloadTask5 = this.f69516f.get(i2);
                if (downloadTask5 != null) {
                    return downloadTask5.getNotificationEventListener();
                }
                return null;
            }
        }
        return (z) invokeI.objValue;
    }

    public synchronized IDownloadFileUriProvider j(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048605, this, i2)) == null) {
            synchronized (this) {
                DownloadTask downloadTask = this.f69512b.get(i2);
                if (downloadTask != null) {
                    return downloadTask.getFileUriProvider();
                }
                DownloadTask downloadTask2 = this.f69513c.get(i2);
                if (downloadTask2 != null) {
                    return downloadTask2.getFileUriProvider();
                }
                DownloadTask downloadTask3 = this.f69514d.get(i2);
                if (downloadTask3 != null) {
                    return downloadTask3.getFileUriProvider();
                }
                DownloadTask downloadTask4 = this.f69515e.get(i2);
                if (downloadTask4 != null) {
                    return downloadTask4.getFileUriProvider();
                }
                DownloadTask downloadTask5 = this.f69516f.get(i2);
                if (downloadTask5 != null) {
                    return downloadTask5.getFileUriProvider();
                }
                return null;
            }
        }
        return (IDownloadFileUriProvider) invokeI.objValue;
    }

    public synchronized boolean k(int i2) {
        InterceptResult invokeI;
        DownloadInfo downloadInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048606, this, i2)) == null) {
            synchronized (this) {
                DownloadTask downloadTask = this.f69515e.get(i2);
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
        }
        return invokeI.booleanValue;
    }

    public synchronized boolean l(int i2) {
        InterceptResult invokeI;
        DownloadInfo downloadInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048607, this, i2)) == null) {
            synchronized (this) {
                DownloadTask downloadTask = this.f69516f.get(i2);
                if (downloadTask == null || (downloadInfo = downloadTask.getDownloadInfo()) == null) {
                    return false;
                }
                if (downloadInfo.canReStartAsyncTask()) {
                    a(downloadTask);
                }
                return true;
            }
        }
        return invokeI.booleanValue;
    }

    public synchronized void m(int i2) {
        DownloadInfo downloadInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i2) == null) {
            synchronized (this) {
                DownloadTask downloadTask = this.f69512b.get(i2);
                if (downloadTask != null && (downloadInfo = downloadTask.getDownloadInfo()) != null) {
                    downloadInfo.setForceIgnoreRecommendSize(true);
                    a(downloadTask);
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0015, code lost:
        if (r4.f69514d.get(r5) != null) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized boolean n(int i2) {
        InterceptResult invokeI;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048609, this, i2)) == null) {
            synchronized (this) {
                if (i2 != 0) {
                    if (this.f69512b.get(i2) == null) {
                    }
                    z = true;
                }
                z = false;
            }
            return z;
        }
        return invokeI.booleanValue;
    }

    private void b(DownloadTask downloadTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, downloadTask) == null) {
            int hashCodeForSameTask = downloadTask.getHashCodeForSameTask();
            if (hashCodeForSameTask == 0 && downloadTask.isAutoSetHashCodeForSameTask()) {
                hashCodeForSameTask = downloadTask.autoCalAndGetHashCodeForSameTask();
            }
            if (hashCodeForSameTask == 0) {
                return;
            }
            SparseArray<DownloadTask> sparseArray = this.f69517g.get(downloadTask.getDownloadId());
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.f69517g.put(downloadTask.getDownloadId(), sparseArray);
            }
            com.ss.android.socialbase.downloader.c.a.b("AbsDownloadEngine", "tryCacheSameTaskWithListenerHashCode id:" + downloadTask.getDownloadId() + " listener hasCode:" + hashCodeForSameTask);
            sparseArray.put(hashCodeForSameTask, downloadTask);
        }
    }

    private void a(DownloadTask downloadTask, boolean z) {
        DownloadInfo downloadInfo;
        int i2;
        DownloadInfo downloadInfo2;
        DownloadTask remove;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(AdIconUtil.BAIDU_LOGO_ID, this, downloadTask, z) == null) || downloadTask == null || (downloadInfo = downloadTask.getDownloadInfo()) == null) {
            return;
        }
        if (downloadInfo.isEntityInvalid()) {
            x monitorDepend = downloadTask.getMonitorDepend();
            com.ss.android.socialbase.downloader.d.a.a(monitorDepend, downloadInfo, new BaseException(1003, "downloadInfo is Invalid, url is " + downloadInfo.getUrl() + " name is " + downloadInfo.getName() + " savePath is " + downloadInfo.getSavePath()), downloadInfo.getStatus());
            return;
        }
        boolean z2 = false;
        if (com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).a("no_net_opt", 0) == 1 && !com.ss.android.socialbase.downloader.i.f.c(com.ss.android.socialbase.downloader.downloader.c.N()) && !downloadInfo.isFirstDownload()) {
            new com.ss.android.socialbase.downloader.downloader.f(downloadTask, this.f69511a).a(new BaseException((int) SDKLogTypeConstants.TYPE_LP_LOAD_URL, "network_not_available"));
            return;
        }
        int id = downloadInfo.getId();
        if (z) {
            a(downloadInfo);
        }
        if (this.f69514d.get(id) != null) {
            this.f69514d.remove(id);
        }
        if (this.f69513c.get(id) != null) {
            this.f69513c.remove(id);
        }
        if (this.f69515e.get(id) != null) {
            this.f69515e.remove(id);
        }
        if (this.f69516f.get(id) != null) {
            this.f69516f.remove(id);
        }
        if (a(id) && !downloadInfo.canReStartAsyncTask()) {
            com.ss.android.socialbase.downloader.c.a.b("AbsDownloadEngine", "another task with same id is downloading when tryDownload");
            downloadTask.addListenerToDownloadingSameTask();
            com.ss.android.socialbase.downloader.d.a.a(downloadTask.getMonitorDepend(), downloadInfo, new BaseException(1003, "downloadInfo is isDownloading and addListenerToSameTask is false"), downloadInfo.getStatus());
            return;
        }
        com.ss.android.socialbase.downloader.c.a.b("AbsDownloadEngine", "no downloading task :" + id);
        if (downloadInfo.canReStartAsyncTask()) {
            downloadInfo.setAsyncHandleStatus(com.ss.android.socialbase.downloader.constants.a.f69158c);
        }
        if (com.ss.android.socialbase.downloader.i.a.a(32768) && (remove = this.f69518h.remove(Integer.valueOf(id))) != null) {
            downloadTask.copyListenerFromPendingTask(remove);
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        DownloadTask downloadTask2 = this.f69512b.get(id);
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
        this.f69512b.put(id, downloadTask);
        this.f69519i.put(id, Long.valueOf(uptimeMillis));
        a(id, downloadTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void d(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65547, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            synchronized (this) {
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
                if (this.f69514d.get(i2) != null) {
                    this.f69514d.remove(i2);
                }
                if (this.f69513c.get(i2) != null) {
                    this.f69513c.remove(i2);
                }
                this.f69518h.remove(Integer.valueOf(i2));
                com.ss.android.socialbase.downloader.g.a.b(i2);
            }
        }
    }

    public synchronized void b(List<String> list) {
        DownloadInfo downloadInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, list) == null) {
            synchronized (this) {
                try {
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                if (com.ss.android.socialbase.downloader.i.f.b(com.ss.android.socialbase.downloader.downloader.c.N())) {
                    for (int i2 = 0; i2 < this.f69512b.size(); i2++) {
                        DownloadTask downloadTask = this.f69512b.get(this.f69512b.keyAt(i2));
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
        }
    }

    public void c(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            DownloadInfo b2 = this.k.b(i2);
            if (b2 != null) {
                a(b2);
            }
            this.f69511a.post(new Runnable(this, i2) { // from class: com.ss.android.socialbase.downloader.impls.a.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ int f69529a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f69530b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(i2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f69530b = this;
                    this.f69529a = i2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.ss.android.socialbase.downloader.notification.b.a().f(this.f69529a);
                    }
                }
            });
            com.ss.android.socialbase.downloader.downloader.c.a(new Runnable(this, i2, z) { // from class: com.ss.android.socialbase.downloader.impls.a.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ int f69531a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ boolean f69532b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ a f69533c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(i2), Boolean.valueOf(z)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f69533c = this;
                    this.f69531a = i2;
                    this.f69532b = z;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f69533c.c(this.f69531a);
                        this.f69533c.e(this.f69531a, this.f69532b);
                    }
                }
            }, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65548, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
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
                if (this.f69514d.get(i2) != null) {
                    this.f69514d.remove(i2);
                }
                if (this.f69513c.get(i2) != null) {
                    this.f69513c.remove(i2);
                }
                this.f69518h.remove(Integer.valueOf(i2));
                com.ss.android.socialbase.downloader.g.a.b(i2);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private boolean b(DownloadInfo downloadInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, this, downloadInfo)) == null) {
            if (downloadInfo != null && downloadInfo.statusInPause()) {
                return downloadInfo.isPauseReserveOnWifi();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void b() {
        List<Integer> a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (a2 = a()) == null) {
            return;
        }
        for (Integer num : a2) {
            e(num.intValue());
        }
    }

    public void b(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            DownloadInfo b2 = this.k.b(i2);
            if (b2 != null) {
                a(b2);
            }
            this.f69511a.post(new Runnable(this, i2) { // from class: com.ss.android.socialbase.downloader.impls.a.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ int f69524a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f69525b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(i2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f69525b = this;
                    this.f69524a = i2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.ss.android.socialbase.downloader.notification.b.a().f(this.f69524a);
                    }
                }
            });
            com.ss.android.socialbase.downloader.downloader.c.a(new Runnable(this, i2, z) { // from class: com.ss.android.socialbase.downloader.impls.a.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ int f69526a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ boolean f69527b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ a f69528c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(i2), Boolean.valueOf(z)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f69528c = this;
                    this.f69526a = i2;
                    this.f69527b = z;
                }

                @Override // java.lang.Runnable
                public void run() {
                    DownloadTask o;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (this.f69528c.c(this.f69526a) == null && (o = this.f69528c.o(this.f69526a)) != null) {
                            DownloadInfo downloadInfo = o.getDownloadInfo();
                            SparseArray<IDownloadListener> downloadListeners = o.getDownloadListeners(com.ss.android.socialbase.downloader.constants.f.f69187b);
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
                        this.f69528c.d(this.f69526a, this.f69527b);
                    }
                }
            }, false);
        }
    }

    public synchronized void b(int i2, int i3, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.f fVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), iDownloadListener, fVar, Boolean.valueOf(z)}) == null) {
            synchronized (this) {
                a(i2, i3, iDownloadListener, fVar, z, true);
            }
        }
    }

    public List<DownloadInfo> b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
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
        return (List) invokeL.objValue;
    }

    public synchronized void a(DownloadTask downloadTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, downloadTask) == null) {
            synchronized (this) {
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
        }
    }

    public void b(int i2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j)}) == null) {
            DownloadInfo b2 = this.k.b(i2);
            if (b2 != null) {
                b2.setThrottleNetSpeed(j);
            }
            a(i2, j);
        }
    }

    public synchronized List<DownloadInfo> a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            synchronized (this) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                List<DownloadInfo> a2 = this.k.a(str);
                if (a2 == null || a2.isEmpty()) {
                    ArrayList arrayList = new ArrayList();
                    int size = this.f69512b.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        DownloadTask valueAt = this.f69512b.valueAt(i2);
                        if (valueAt != null && valueAt.getDownloadInfo() != null && str.equals(valueAt.getDownloadInfo().getUrl())) {
                            arrayList.add(valueAt.getDownloadInfo());
                        }
                    }
                    return arrayList;
                }
                return a2;
            }
        }
        return (List) invokeL.objValue;
    }

    public synchronized boolean a(int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            synchronized (this) {
                DownloadTask downloadTask = this.f69512b.get(i2);
                if (downloadTask == null && com.ss.android.socialbase.downloader.i.a.a(65536)) {
                    downloadTask = o(i2);
                }
                if (downloadTask != null) {
                    if (!com.ss.android.socialbase.downloader.g.a.a(i2).b("fix_on_cancel_call_twice", true)) {
                        new com.ss.android.socialbase.downloader.downloader.f(downloadTask, this.f69511a).c();
                    }
                    this.f69511a.post(new Runnable(this, downloadTask.getDownloadListeners(com.ss.android.socialbase.downloader.constants.f.f69186a), downloadTask.getDownloadInfo(), downloadTask.getDownloadListeners(com.ss.android.socialbase.downloader.constants.f.f69188c)) { // from class: com.ss.android.socialbase.downloader.impls.a.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ SparseArray f69520a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ DownloadInfo f69521b;

                        /* renamed from: c  reason: collision with root package name */
                        public final /* synthetic */ SparseArray f69522c;

                        /* renamed from: d  reason: collision with root package name */
                        public final /* synthetic */ a f69523d;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, r7, r8, r9};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f69523d = this;
                            this.f69520a = r7;
                            this.f69521b = r8;
                            this.f69522c = r9;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            SparseArray sparseArray;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                SparseArray sparseArray2 = this.f69520a;
                                if (sparseArray2 != null) {
                                    synchronized (sparseArray2) {
                                        for (int i3 = 0; i3 < this.f69520a.size(); i3++) {
                                            IDownloadListener iDownloadListener = (IDownloadListener) this.f69520a.get(this.f69520a.keyAt(i3));
                                            if (iDownloadListener != null) {
                                                iDownloadListener.onCanceled(this.f69521b);
                                            }
                                        }
                                    }
                                }
                                DownloadInfo downloadInfo = this.f69521b;
                                if (downloadInfo == null || !downloadInfo.canShowNotification() || (sparseArray = this.f69522c) == null) {
                                    return;
                                }
                                synchronized (sparseArray) {
                                    for (int i4 = 0; i4 < this.f69522c.size(); i4++) {
                                        IDownloadListener iDownloadListener2 = (IDownloadListener) this.f69522c.get(this.f69522c.keyAt(i4));
                                        if (iDownloadListener2 != null) {
                                            iDownloadListener2.onCanceled(this.f69521b);
                                        }
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
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    private void a(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, downloadInfo) == null) || downloadInfo == null) {
            return;
        }
        try {
            if (downloadInfo.getStatus() == 7 || downloadInfo.getRetryDelayStatus() != com.ss.android.socialbase.downloader.constants.g.f69190a) {
                downloadInfo.setStatus(5);
                downloadInfo.setRetryDelayStatus(com.ss.android.socialbase.downloader.constants.g.f69190a);
                com.ss.android.socialbase.downloader.c.a.b("AbsDownloadEngine", "cancelAlarm");
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public synchronized void a(int i2, z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048582, this, i2, zVar) == null) {
            synchronized (this) {
                DownloadTask downloadTask = this.f69512b.get(i2);
                if (downloadTask != null) {
                    downloadTask.setNotificationEventListener(zVar);
                }
            }
        }
    }

    public synchronized void a(List<String> list) {
        DownloadInfo downloadInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, list) == null) {
            synchronized (this) {
                try {
                    boolean b2 = com.ss.android.socialbase.downloader.i.a.a(1048576) ? com.ss.android.socialbase.downloader.i.f.b(com.ss.android.socialbase.downloader.downloader.c.N()) : true;
                    for (int i2 = 0; i2 < this.f69514d.size(); i2++) {
                        DownloadTask downloadTask = this.f69514d.get(this.f69514d.keyAt(i2));
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
        }
    }

    public synchronized void a(int i2, int i3, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.f fVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), iDownloadListener, fVar, Boolean.valueOf(z)}) == null) {
            synchronized (this) {
                DownloadTask o = o(i2);
                if (o == null) {
                    o = this.f69518h.get(Integer.valueOf(i2));
                }
                if (o != null) {
                    o.removeDownloadListener(i3, iDownloadListener, fVar, z);
                }
            }
        }
    }

    public synchronized void a(int i2, int i3, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.f fVar, boolean z, boolean z2) {
        DownloadInfo b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), iDownloadListener, fVar, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            synchronized (this) {
                DownloadTask o = o(i2);
                if (o != null) {
                    o.addDownloadListener(i3, iDownloadListener, fVar, z);
                    DownloadInfo downloadInfo = o.getDownloadInfo();
                    if (z2 && downloadInfo != null && !a(i2) && (fVar == com.ss.android.socialbase.downloader.constants.f.f69186a || fVar == com.ss.android.socialbase.downloader.constants.f.f69188c)) {
                        boolean z3 = true;
                        if (fVar == com.ss.android.socialbase.downloader.constants.f.f69188c && !downloadInfo.canShowNotification()) {
                            z3 = false;
                        }
                        if (z3) {
                            this.f69511a.post(new Runnable(this, iDownloadListener, downloadInfo) { // from class: com.ss.android.socialbase.downloader.impls.a.6
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ IDownloadListener f69534a;

                                /* renamed from: b  reason: collision with root package name */
                                public final /* synthetic */ DownloadInfo f69535b;

                                /* renamed from: c  reason: collision with root package name */
                                public final /* synthetic */ a f69536c;

                                {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, iDownloadListener, downloadInfo};
                                        interceptable2.invokeUnInit(65536, newInitContext);
                                        int i4 = newInitContext.flag;
                                        if ((i4 & 1) != 0) {
                                            int i5 = i4 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable2.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.f69536c = this;
                                    this.f69534a = iDownloadListener;
                                    this.f69535b = downloadInfo;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable2 = $ic;
                                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f69534a == null) {
                                        return;
                                    }
                                    if (this.f69535b.getStatus() == -3) {
                                        this.f69534a.onSuccessed(this.f69535b);
                                    } else if (this.f69535b.getStatus() == -1) {
                                        this.f69534a.onFailed(this.f69535b, new BaseException(1000, "try add listener for failed task"));
                                    }
                                }
                            });
                        }
                    }
                } else if (com.ss.android.socialbase.downloader.i.a.a(32768) && (b2 = this.k.b(i2)) != null && b2.getStatus() != -3) {
                    DownloadTask downloadTask = this.f69518h.get(Integer.valueOf(i2));
                    if (downloadTask == null) {
                        downloadTask = new DownloadTask(b2);
                        this.f69518h.put(Integer.valueOf(i2), downloadTask);
                    }
                    downloadTask.addDownloadListener(i3, iDownloadListener, fVar, z);
                }
            }
        }
    }

    private void a(int i2, BaseException baseException, DownloadTask downloadTask) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeILL(65539, this, i2, baseException, downloadTask) == null) || downloadTask == null) {
            return;
        }
        DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
        SparseArray<IDownloadListener> downloadListeners = downloadTask.getDownloadListeners(com.ss.android.socialbase.downloader.constants.f.f69186a);
        SparseArray<IDownloadListener> downloadListeners2 = downloadTask.getDownloadListeners(com.ss.android.socialbase.downloader.constants.f.f69188c);
        boolean z = downloadTask.canShowNotification() || downloadInfo.isAutoInstallWithoutNotification();
        com.ss.android.socialbase.downloader.i.c.a(i2, downloadListeners, true, downloadInfo, baseException);
        com.ss.android.socialbase.downloader.i.c.a(i2, downloadListeners2, z, downloadInfo, baseException);
    }

    private void a(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65538, this, i2, i3) == null) {
            com.ss.android.socialbase.downloader.c.a.b("AbsDownloadEngine", "removeTask id: " + i2 + " listener hasCode: " + i3);
            if (i3 == 0) {
                this.f69512b.remove(i2);
                this.f69517g.remove(i2);
                return;
            }
            SparseArray<DownloadTask> sparseArray = this.f69517g.get(i2);
            if (sparseArray != null) {
                sparseArray.remove(i3);
                com.ss.android.socialbase.downloader.c.a.b("AbsDownloadEngine", "after downloadTaskWithListenerMap removeTask taskArray.size: " + sparseArray.size());
                if (sparseArray.size() == 0) {
                    this.f69512b.remove(i2);
                    this.f69517g.remove(i2);
                    return;
                }
                return;
            }
            this.f69512b.remove(i2);
        }
    }

    public synchronized void a(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(Constants.METHOD_SEND_USER_MSG, this, i2, i3, i4) == null) {
            synchronized (this) {
                if (i4 != -7) {
                    if (i4 == -6) {
                        this.f69513c.put(i2, this.f69512b.get(i2));
                        a(i2, i3);
                    } else if (i4 == -4) {
                        a(i2, i3);
                        p(i2);
                    } else if (i4 == -3) {
                        this.f69513c.put(i2, this.f69512b.get(i2));
                        a(i2, i3);
                        p(i2);
                    } else if (i4 != -1) {
                        if (i4 == 7) {
                            DownloadTask downloadTask = this.f69512b.get(i2);
                            if (downloadTask != null) {
                                if (this.f69515e.get(i2) == null) {
                                    this.f69515e.put(i2, downloadTask);
                                }
                                a(i2, i3);
                            }
                            p(i2);
                        } else if (i4 == 8) {
                            DownloadTask downloadTask2 = this.f69512b.get(i2);
                            if (downloadTask2 != null && this.f69516f.get(i2) == null) {
                                this.f69516f.put(i2, downloadTask2);
                            }
                            p(i2);
                        }
                    }
                }
                DownloadTask downloadTask3 = this.f69512b.get(i2);
                if (downloadTask3 != null) {
                    if (this.f69514d.get(i2) == null) {
                        this.f69514d.put(i2, downloadTask3);
                    }
                    a(i2, i3);
                }
                p(i2);
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.h.h.a
    public void a(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, message) == null) {
            int i2 = message.arg1;
            int i3 = message.arg2;
            com.ss.android.socialbase.downloader.c.a.b("AbsDownloadEngine", "handleMsg id: " + i2 + " listener hasCode: " + i3);
            Object obj = message.obj;
            DownloadTask downloadTask = null;
            BaseException baseException = obj instanceof Exception ? (BaseException) obj : null;
            synchronized (this) {
                if (i3 == 0) {
                    downloadTask = this.f69512b.get(i2);
                } else {
                    SparseArray<DownloadTask> sparseArray = this.f69517g.get(i2);
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
}
