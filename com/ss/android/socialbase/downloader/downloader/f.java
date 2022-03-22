package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.ai;
import com.ss.android.socialbase.downloader.depend.x;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.RevenueServerConst;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes7.dex */
public class f {
    public static final String a = "f";

    /* renamed from: b  reason: collision with root package name */
    public final boolean f43264b;

    /* renamed from: c  reason: collision with root package name */
    public DownloadInfo f43265c;

    /* renamed from: d  reason: collision with root package name */
    public final j f43266d;

    /* renamed from: e  reason: collision with root package name */
    public final Handler f43267e;

    /* renamed from: f  reason: collision with root package name */
    public DownloadTask f43268f;

    /* renamed from: g  reason: collision with root package name */
    public SparseArray<IDownloadListener> f43269g;

    /* renamed from: h  reason: collision with root package name */
    public SparseArray<IDownloadListener> f43270h;
    public SparseArray<IDownloadListener> i;
    public boolean j = false;
    public volatile long k = 0;
    public final AtomicLong l = new AtomicLong();
    public boolean m = false;
    public int n;
    public long o;
    public com.ss.android.socialbase.downloader.depend.n p;
    public x q;

    public f(DownloadTask downloadTask, Handler handler) {
        this.f43268f = downloadTask;
        j();
        this.f43267e = handler;
        this.f43266d = c.x();
        DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
        if (downloadInfo != null) {
            this.f43264b = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).a("fix_start_with_file_exist_update_error");
        } else {
            this.f43264b = false;
        }
    }

    private void j() {
        DownloadTask downloadTask = this.f43268f;
        if (downloadTask != null) {
            this.f43265c = downloadTask.getDownloadInfo();
            this.f43269g = this.f43268f.getDownloadListeners(com.ss.android.socialbase.downloader.constants.f.MAIN);
            this.i = this.f43268f.getDownloadListeners(com.ss.android.socialbase.downloader.constants.f.NOTIFICATION);
            this.f43270h = this.f43268f.getDownloadListeners(com.ss.android.socialbase.downloader.constants.f.SUB);
            this.p = this.f43268f.getDepend();
            this.q = this.f43268f.getMonitorDepend();
        }
    }

    private void k() {
        ExecutorService l = c.l();
        if (l != null) {
            l.execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.f.1
                @Override // java.lang.Runnable
                public void run() {
                    f.this.f43266d.i(f.this.f43265c.getId());
                    f.this.a(1, (BaseException) null);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        try {
            com.ss.android.socialbase.downloader.c.a.b(a, "saveFileAsTargetName onSuccess");
            try {
                m();
                this.f43265c.setFirstSuccess(false);
                this.f43265c.setSuccessByCache(false);
                a(-3, (BaseException) null);
                this.f43266d.c(this.f43265c.getId(), this.f43265c.getTotalBytes());
                this.f43266d.d(this.f43265c.getId());
                this.f43266d.m(this.f43265c.getId());
            } catch (BaseException e2) {
                a(e2);
            }
        } catch (Throwable th) {
            a(new BaseException(1008, com.ss.android.socialbase.downloader.i.f.b(th, "onCompleted")));
        }
    }

    private void m() throws BaseException {
        List<com.ss.android.socialbase.downloader.depend.m> downloadCompleteHandlers = this.f43268f.getDownloadCompleteHandlers();
        if (downloadCompleteHandlers.isEmpty()) {
            return;
        }
        DownloadInfo downloadInfo = this.f43265c;
        a(11, (BaseException) null);
        this.f43266d.a(downloadInfo);
        for (com.ss.android.socialbase.downloader.depend.m mVar : downloadCompleteHandlers) {
            try {
                if (mVar.b(downloadInfo)) {
                    mVar.a(downloadInfo);
                    this.f43266d.a(downloadInfo);
                }
            } catch (BaseException e2) {
                throw e2;
            } catch (Throwable th) {
                throw new BaseException((int) RevenueServerConst.GetBannerConfigRequest, th);
            }
        }
    }

    public void d() {
        this.f43265c.setStatus(-2);
        try {
            this.f43266d.d(this.f43265c.getId(), this.f43265c.getCurBytes());
        } catch (SQLiteException e2) {
            e2.printStackTrace();
        }
        a(-2, (BaseException) null);
    }

    public void e() {
        this.f43265c.setStatus(-7);
        try {
            this.f43266d.j(this.f43265c.getId());
        } catch (SQLiteException e2) {
            e2.printStackTrace();
        }
        a(-7, (BaseException) null);
    }

    public void f() {
        this.f43265c.setFirstDownload(false);
        if (!this.f43265c.isIgnoreDataVerify() && this.f43265c.getCurBytes() != this.f43265c.getTotalBytes()) {
            com.ss.android.socialbase.downloader.c.a.b(a, this.f43265c.getErrorBytesLog());
            a(new com.ss.android.socialbase.downloader.exception.f(ARPMessageType.MSG_TYPE_VIDEO_STOP, "current bytes is not equals to total bytes, bytes changed with process : " + this.f43265c.getByteInvalidRetryStatus()));
        } else if (this.f43265c.getCurBytes() <= 0) {
            com.ss.android.socialbase.downloader.c.a.b(a, this.f43265c.getErrorBytesLog());
            a(new com.ss.android.socialbase.downloader.exception.f(1026, "curBytes is 0, bytes changed with process : " + this.f43265c.getByteInvalidRetryStatus()));
        } else if (!this.f43265c.isIgnoreDataVerify() && this.f43265c.getTotalBytes() <= 0) {
            com.ss.android.socialbase.downloader.c.a.b(a, this.f43265c.getErrorBytesLog());
            a(new com.ss.android.socialbase.downloader.exception.f(1044, "TotalBytes is 0, bytes changed with process : " + this.f43265c.getByteInvalidRetryStatus()));
        } else {
            String str = a;
            com.ss.android.socialbase.downloader.c.a.b(str, "" + this.f43265c.getName() + " onCompleted start save file as target name");
            x xVar = this.q;
            DownloadTask downloadTask = this.f43268f;
            if (downloadTask != null) {
                xVar = downloadTask.getMonitorDepend();
            }
            com.ss.android.socialbase.downloader.i.f.a(this.f43265c, xVar, new ai() { // from class: com.ss.android.socialbase.downloader.downloader.f.2
                @Override // com.ss.android.socialbase.downloader.depend.ai
                public void a() {
                    f.this.l();
                }

                @Override // com.ss.android.socialbase.downloader.depend.ai
                public void a(BaseException baseException) {
                    String str2 = f.a;
                    StringBuilder sb = new StringBuilder();
                    sb.append("saveFileAsTargetName onFailed : ");
                    sb.append(baseException != null ? baseException.getErrorMessage() : "");
                    com.ss.android.socialbase.downloader.c.a.b(str2, sb.toString());
                    f.this.a(baseException);
                }
            });
        }
    }

    public void g() throws BaseException {
        if (this.f43264b) {
            m();
            com.ss.android.socialbase.downloader.c.a.b(a, "onCompleteForFileExist");
            this.f43265c.setSuccessByCache(true);
            a(-3, (BaseException) null);
            this.f43266d.c(this.f43265c.getId(), this.f43265c.getTotalBytes());
            this.f43266d.d(this.f43265c.getId());
            this.f43266d.a(this.f43265c);
            this.f43266d.m(this.f43265c.getId());
            return;
        }
        m();
        com.ss.android.socialbase.downloader.c.a.b(a, "onCompleteForFileExist");
        this.f43265c.setSuccessByCache(true);
        a(-3, (BaseException) null);
        this.f43266d.c(this.f43265c.getId(), this.f43265c.getTotalBytes());
        this.f43266d.d(this.f43265c.getId());
        this.f43266d.m(this.f43265c.getId());
    }

    public void h() {
        this.f43265c.setStatus(8);
        this.f43265c.setAsyncHandleStatus(com.ss.android.socialbase.downloader.constants.a.ASYNC_HANDLE_WAITING);
        com.ss.android.socialbase.downloader.impls.a C = c.C();
        if (C != null) {
            C.a(this.f43265c.getId(), this.f43268f.getHashCodeForSameTask(), 8);
        }
    }

    public void b() {
        if (this.f43265c.canSkipStatusHandler()) {
            this.f43265c.changeSkipStatus();
            return;
        }
        this.f43266d.g(this.f43265c.getId());
        if (this.f43265c.isFirstDownload()) {
            a(6, (BaseException) null);
        }
        a(2, (BaseException) null);
    }

    public void c() {
        a(-4, (BaseException) null);
    }

    private BaseException c(BaseException baseException) {
        Context N;
        if (com.ss.android.socialbase.downloader.g.a.a(this.f43265c.getId()).a("download_failed_check_net", 1) != 1 || !com.ss.android.socialbase.downloader.i.f.i(baseException) || (N = c.N()) == null || com.ss.android.socialbase.downloader.i.f.c(N)) {
            return baseException;
        }
        return new BaseException(this.f43265c.isOnlyWifi() ? 1013 : 1049, baseException.getErrorMessage());
    }

    public void a() {
        if (this.f43265c.canSkipStatusHandler()) {
            return;
        }
        this.f43265c.setStatus(1);
        k();
    }

    public void a(long j, String str, String str2) {
        this.f43265c.setTotalBytes(j);
        this.f43265c.seteTag(str);
        if (!TextUtils.isEmpty(str2) && TextUtils.isEmpty(this.f43265c.getName())) {
            this.f43265c.setName(str2);
        }
        try {
            this.f43266d.a(this.f43265c.getId(), j, str, str2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        a(3, (BaseException) null);
        this.o = this.f43265c.getMinByteIntervalForPostToMainThread(j);
        this.n = this.f43265c.getMinProgressTimeMsInterval();
        this.j = true;
        com.ss.android.socialbase.downloader.impls.r.a().e();
    }

    private void b(BaseException baseException) {
        String str = a;
        Log.d(str, "handleError::" + baseException + " \r\n" + Log.getStackTraceString(new Throwable()));
        if (baseException != null && baseException.getCause() != null && (baseException.getCause() instanceof SQLiteFullException)) {
            try {
                this.f43266d.f(this.f43265c.getId());
            } catch (SQLiteException e2) {
                e2.printStackTrace();
            }
        } else {
            try {
                try {
                    this.f43266d.b(this.f43265c.getId(), this.f43265c.getCurBytes());
                } catch (SQLiteException unused) {
                    this.f43266d.f(this.f43265c.getId());
                }
            } catch (SQLiteException e3) {
                e3.printStackTrace();
            }
        }
        BaseException c2 = c(baseException);
        this.f43265c.setFailedException(c2);
        a(c2 instanceof com.ss.android.socialbase.downloader.exception.e ? -2 : -1, c2);
        if (com.ss.android.socialbase.downloader.g.a.a(this.f43265c.getId()).a("retry_schedule", 0) > 0) {
            com.ss.android.socialbase.downloader.impls.r.a().a(this.f43265c);
        }
    }

    public boolean a(long j) {
        this.l.addAndGet(j);
        this.f43265c.increaseCurBytes(j);
        long uptimeMillis = SystemClock.uptimeMillis();
        return a(uptimeMillis, b(uptimeMillis));
    }

    private boolean b(long j) {
        boolean z = true;
        if (!this.m) {
            this.m = true;
            return true;
        }
        long j2 = j - this.k;
        if (this.l.get() < this.o && j2 < this.n) {
            z = false;
        }
        if (z) {
            this.k = j;
            this.l.set(0L);
        }
        return z;
    }

    public void a(BaseException baseException, boolean z) {
        this.f43265c.setFirstDownload(false);
        this.l.set(0L);
        b(baseException, z);
    }

    public void a(com.ss.android.socialbase.downloader.model.b bVar, BaseException baseException, boolean z) {
        this.f43265c.setFirstDownload(false);
        this.l.set(0L);
        this.f43266d.h(this.f43265c.getId());
        a(z ? 10 : 9, baseException, true);
    }

    private void b(BaseException baseException, boolean z) {
        this.f43266d.h(this.f43265c.getId());
        a(z ? 7 : 5, baseException);
    }

    public void a(BaseException baseException) {
        this.f43265c.setFirstDownload(false);
        b(baseException);
    }

    public void a(String str) throws BaseException {
        String str2 = a;
        com.ss.android.socialbase.downloader.c.a.b(str2, "onCompleteForFileExist existTargetFileName is " + str + " but curName is " + this.f43265c.getName());
        if (this.f43264b) {
            com.ss.android.socialbase.downloader.i.f.a(this.f43265c, str);
            m();
            this.f43265c.setSuccessByCache(true);
            a(-3, (BaseException) null);
            this.f43266d.a(this.f43265c);
            return;
        }
        this.f43266d.a(this.f43265c);
        com.ss.android.socialbase.downloader.i.f.a(this.f43265c, str);
        this.f43265c.setSuccessByCache(true);
        m();
        a(-3, (BaseException) null);
    }

    private boolean a(long j, boolean z) {
        boolean z2 = false;
        if (this.f43265c.getCurBytes() == this.f43265c.getTotalBytes()) {
            try {
                this.f43266d.a(this.f43265c.getId(), this.f43265c.getCurBytes());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return false;
        }
        if (this.j) {
            this.j = false;
            this.f43265c.setStatus(4);
        }
        if (this.f43265c.isNeedPostProgress() && z) {
            z2 = true;
        }
        a(4, (BaseException) null, z2);
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, BaseException baseException) {
        a(i, baseException, true);
    }

    private void a(int i, BaseException baseException, boolean z) {
        SparseArray<IDownloadListener> sparseArray;
        SparseArray<IDownloadListener> sparseArray2;
        int status = this.f43265c.getStatus();
        if (status == -3 && i == 4) {
            return;
        }
        j();
        if (i != 4 && DownloadStatus.isRealTimeUploadStatus(i)) {
            this.f43265c.updateRealDownloadTime(false);
            if (DownloadStatus.isTimeUploadStatus(i)) {
                this.f43265c.updateDownloadTime();
            }
        }
        if (!this.f43265c.isAddListenerToSameTask()) {
            com.ss.android.socialbase.downloader.d.a.a(this.f43268f, baseException, i);
        }
        if (i == 6) {
            this.f43265c.setStatus(2);
        } else if (i == -6) {
            this.f43265c.setStatus(-3);
        } else {
            this.f43265c.setStatus(i);
        }
        if (status == -3 || status == -1) {
            if (this.f43265c.getRetryDelayStatus() == com.ss.android.socialbase.downloader.constants.g.DELAY_RETRY_DOWNLOADING) {
                this.f43265c.setRetryDelayStatus(com.ss.android.socialbase.downloader.constants.g.DELAY_RETRY_DOWNLOADED);
            }
            if (this.f43265c.getAsyncHandleStatus() == com.ss.android.socialbase.downloader.constants.a.ASYNC_HANDLE_DOWNLOADING) {
                this.f43265c.setAsyncHandleStatus(com.ss.android.socialbase.downloader.constants.a.ASYNC_HANDLE_DOWNLOADED);
            }
            if (this.f43265c.getByteInvalidRetryStatus() == com.ss.android.socialbase.downloader.constants.b.BYTE_INVALID_RETRY_STATUS_DOWNLOADING) {
                this.f43265c.setByteInvalidRetryStatus(com.ss.android.socialbase.downloader.constants.b.BYTE_INVALID_RETRY_STATUS_DOWNLOADED);
            }
        }
        com.ss.android.socialbase.downloader.i.c.a(i, this.f43270h, true, this.f43265c, baseException);
        if (i == -4) {
            return;
        }
        if (z && this.f43267e != null && (((sparseArray = this.f43269g) != null && sparseArray.size() > 0) || ((sparseArray2 = this.i) != null && sparseArray2.size() > 0 && (this.f43265c.canShowNotification() || this.f43265c.isAutoInstallWithoutNotification())))) {
            this.f43267e.obtainMessage(i, this.f43265c.getId(), this.f43268f.getHashCodeForSameTask(), baseException).sendToTarget();
            return;
        }
        com.ss.android.socialbase.downloader.impls.a C = c.C();
        if (C != null) {
            C.a(this.f43265c.getId(), this.f43268f.getHashCodeForSameTask(), i);
        }
    }
}
