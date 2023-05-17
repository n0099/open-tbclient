package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
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
/* loaded from: classes10.dex */
public class f {
    public static final String a = "f";
    public final boolean b;
    public DownloadInfo c;
    public final j d;
    public final Handler e;
    public DownloadTask f;
    public SparseArray<IDownloadListener> g;
    public SparseArray<IDownloadListener> h;
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
        this.f = downloadTask;
        j();
        this.e = handler;
        this.d = c.x();
        DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
        if (downloadInfo != null) {
            this.b = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).a("fix_start_with_file_exist_update_error");
        } else {
            this.b = false;
        }
    }

    private boolean a(long j, boolean z) {
        boolean z2 = false;
        if (this.c.getCurBytes() == this.c.getTotalBytes()) {
            try {
                this.d.a(this.c.getId(), this.c.getCurBytes());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        }
        if (this.j) {
            this.j = false;
            this.c.setStatus(4);
        }
        if (this.c.isNeedPostProgress() && z) {
            z2 = true;
        }
        a(4, (BaseException) null, z2);
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, BaseException baseException) {
        a(i, baseException, true);
    }

    private void b(BaseException baseException, boolean z) {
        int i;
        this.d.h(this.c.getId());
        if (z) {
            i = 7;
        } else {
            i = 5;
        }
        a(i, baseException);
    }

    private void a(int i, BaseException baseException, boolean z) {
        SparseArray<IDownloadListener> sparseArray;
        SparseArray<IDownloadListener> sparseArray2;
        int status = this.c.getStatus();
        if (status == -3 && i == 4) {
            return;
        }
        j();
        if (i != 4 && DownloadStatus.isRealTimeUploadStatus(i)) {
            this.c.updateRealDownloadTime(false);
            if (DownloadStatus.isTimeUploadStatus(i)) {
                this.c.updateDownloadTime();
            }
        }
        if (!this.c.isAddListenerToSameTask()) {
            com.ss.android.socialbase.downloader.d.a.a(this.f, baseException, i);
        }
        if (i == 6) {
            this.c.setStatus(2);
        } else if (i == -6) {
            this.c.setStatus(-3);
        } else {
            this.c.setStatus(i);
        }
        if (status == -3 || status == -1) {
            if (this.c.getRetryDelayStatus() == com.ss.android.socialbase.downloader.constants.g.DELAY_RETRY_DOWNLOADING) {
                this.c.setRetryDelayStatus(com.ss.android.socialbase.downloader.constants.g.DELAY_RETRY_DOWNLOADED);
            }
            if (this.c.getAsyncHandleStatus() == com.ss.android.socialbase.downloader.constants.a.ASYNC_HANDLE_DOWNLOADING) {
                this.c.setAsyncHandleStatus(com.ss.android.socialbase.downloader.constants.a.ASYNC_HANDLE_DOWNLOADED);
            }
            if (this.c.getByteInvalidRetryStatus() == com.ss.android.socialbase.downloader.constants.b.BYTE_INVALID_RETRY_STATUS_DOWNLOADING) {
                this.c.setByteInvalidRetryStatus(com.ss.android.socialbase.downloader.constants.b.BYTE_INVALID_RETRY_STATUS_DOWNLOADED);
            }
        }
        com.ss.android.socialbase.downloader.i.c.a(i, this.h, true, this.c, baseException);
        if (i == -4) {
            return;
        }
        if (z && this.e != null && (((sparseArray = this.g) != null && sparseArray.size() > 0) || ((sparseArray2 = this.i) != null && sparseArray2.size() > 0 && (this.c.canShowNotification() || this.c.isAutoInstallWithoutNotification())))) {
            this.e.obtainMessage(i, this.c.getId(), this.f.getHashCodeForSameTask(), baseException).sendToTarget();
            return;
        }
        com.ss.android.socialbase.downloader.impls.a C = c.C();
        if (C != null) {
            C.a(this.c.getId(), this.f.getHashCodeForSameTask(), i);
        }
    }

    private void b(BaseException baseException) {
        int i;
        String str = a;
        Log.d(str, "handleError::" + baseException + " \r\n" + Log.getStackTraceString(new Throwable()));
        if (baseException != null && baseException.getCause() != null && (baseException.getCause() instanceof SQLiteFullException)) {
            try {
                this.d.f(this.c.getId());
            } catch (SQLiteException e) {
                e.printStackTrace();
            }
        } else {
            try {
                try {
                    this.d.b(this.c.getId(), this.c.getCurBytes());
                } catch (SQLiteException unused) {
                    this.d.f(this.c.getId());
                }
            } catch (SQLiteException e2) {
                e2.printStackTrace();
            }
        }
        BaseException c = c(baseException);
        this.c.setFailedException(c);
        if (c instanceof com.ss.android.socialbase.downloader.exception.e) {
            i = -2;
        } else {
            i = -1;
        }
        a(i, c);
        if (com.ss.android.socialbase.downloader.g.a.a(this.c.getId()).a("retry_schedule", 0) > 0) {
            com.ss.android.socialbase.downloader.impls.r.a().a(this.c);
        }
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

    public void a(BaseException baseException) {
        this.c.setFirstDownload(false);
        b(baseException);
    }

    private BaseException c(BaseException baseException) {
        Context N;
        int i;
        if (com.ss.android.socialbase.downloader.g.a.a(this.c.getId()).a("download_failed_check_net", 1) == 1 && com.ss.android.socialbase.downloader.i.f.i(baseException) && (N = c.N()) != null && !com.ss.android.socialbase.downloader.i.f.c(N)) {
            if (this.c.isOnlyWifi()) {
                i = 1013;
            } else {
                i = 1049;
            }
            return new BaseException(i, baseException.getErrorMessage());
        }
        return baseException;
    }

    private void k() {
        ExecutorService l = c.l();
        if (l != null) {
            l.execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.f.1
                @Override // java.lang.Runnable
                public void run() {
                    f.this.d.i(f.this.c.getId());
                    f.this.a(1, (BaseException) null);
                }
            });
        }
    }

    public void a() {
        if (this.c.canSkipStatusHandler()) {
            return;
        }
        this.c.setStatus(1);
        k();
    }

    public void b() {
        if (this.c.canSkipStatusHandler()) {
            this.c.changeSkipStatus();
            return;
        }
        this.d.g(this.c.getId());
        if (this.c.isFirstDownload()) {
            a(6, (BaseException) null);
        }
        a(2, (BaseException) null);
    }

    public void c() {
        a(-4, (BaseException) null);
    }

    public void d() {
        this.c.setStatus(-2);
        try {
            this.d.d(this.c.getId(), this.c.getCurBytes());
        } catch (SQLiteException e) {
            e.printStackTrace();
        }
        a(-2, (BaseException) null);
    }

    public void e() {
        this.c.setStatus(-7);
        try {
            this.d.j(this.c.getId());
        } catch (SQLiteException e) {
            e.printStackTrace();
        }
        a(-7, (BaseException) null);
    }

    public void h() {
        this.c.setStatus(8);
        this.c.setAsyncHandleStatus(com.ss.android.socialbase.downloader.constants.a.ASYNC_HANDLE_WAITING);
        com.ss.android.socialbase.downloader.impls.a C = c.C();
        if (C != null) {
            C.a(this.c.getId(), this.f.getHashCodeForSameTask(), 8);
        }
    }

    private void j() {
        DownloadTask downloadTask = this.f;
        if (downloadTask != null) {
            this.c = downloadTask.getDownloadInfo();
            this.g = this.f.getDownloadListeners(com.ss.android.socialbase.downloader.constants.f.MAIN);
            this.i = this.f.getDownloadListeners(com.ss.android.socialbase.downloader.constants.f.NOTIFICATION);
            this.h = this.f.getDownloadListeners(com.ss.android.socialbase.downloader.constants.f.SUB);
            this.p = this.f.getDepend();
            this.q = this.f.getMonitorDepend();
        }
    }

    private void m() throws BaseException {
        List<com.ss.android.socialbase.downloader.depend.m> downloadCompleteHandlers = this.f.getDownloadCompleteHandlers();
        if (!downloadCompleteHandlers.isEmpty()) {
            DownloadInfo downloadInfo = this.c;
            a(11, (BaseException) null);
            this.d.a(downloadInfo);
            for (com.ss.android.socialbase.downloader.depend.m mVar : downloadCompleteHandlers) {
                try {
                    if (mVar.b(downloadInfo)) {
                        mVar.a(downloadInfo);
                        this.d.a(downloadInfo);
                    }
                } catch (BaseException e) {
                    throw e;
                } catch (Throwable th) {
                    throw new BaseException((int) RevenueServerConst.GetBannerConfigRequest, th);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        try {
            com.ss.android.socialbase.downloader.c.a.b(a, "saveFileAsTargetName onSuccess");
            try {
                m();
                this.c.setFirstSuccess(false);
                this.c.setSuccessByCache(false);
                a(-3, (BaseException) null);
                this.d.c(this.c.getId(), this.c.getTotalBytes());
                this.d.d(this.c.getId());
                this.d.m(this.c.getId());
            } catch (BaseException e) {
                a(e);
            }
        } catch (Throwable th) {
            a(new BaseException(1008, com.ss.android.socialbase.downloader.i.f.b(th, "onCompleted")));
        }
    }

    public void a(long j, String str, String str2) {
        this.c.setTotalBytes(j);
        this.c.seteTag(str);
        if (!TextUtils.isEmpty(str2) && TextUtils.isEmpty(this.c.getName())) {
            this.c.setName(str2);
        }
        try {
            this.d.a(this.c.getId(), j, str, str2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        a(3, (BaseException) null);
        this.o = this.c.getMinByteIntervalForPostToMainThread(j);
        this.n = this.c.getMinProgressTimeMsInterval();
        this.j = true;
        com.ss.android.socialbase.downloader.impls.r.a().e();
    }

    public void a(BaseException baseException, boolean z) {
        this.c.setFirstDownload(false);
        this.l.set(0L);
        b(baseException, z);
    }

    public void a(com.ss.android.socialbase.downloader.model.b bVar, BaseException baseException, boolean z) {
        int i;
        this.c.setFirstDownload(false);
        this.l.set(0L);
        this.d.h(this.c.getId());
        if (z) {
            i = 10;
        } else {
            i = 9;
        }
        a(i, baseException, true);
    }

    public void a(String str) throws BaseException {
        String str2 = a;
        com.ss.android.socialbase.downloader.c.a.b(str2, "onCompleteForFileExist existTargetFileName is " + str + " but curName is " + this.c.getName());
        if (this.b) {
            com.ss.android.socialbase.downloader.i.f.a(this.c, str);
            m();
            this.c.setSuccessByCache(true);
            a(-3, (BaseException) null);
            this.d.a(this.c);
            return;
        }
        this.d.a(this.c);
        com.ss.android.socialbase.downloader.i.f.a(this.c, str);
        this.c.setSuccessByCache(true);
        m();
        a(-3, (BaseException) null);
    }

    public boolean a(long j) {
        this.l.addAndGet(j);
        this.c.increaseCurBytes(j);
        long uptimeMillis = SystemClock.uptimeMillis();
        return a(uptimeMillis, b(uptimeMillis));
    }

    public void f() {
        this.c.setFirstDownload(false);
        if (!this.c.isIgnoreDataVerify() && this.c.getCurBytes() != this.c.getTotalBytes()) {
            com.ss.android.socialbase.downloader.c.a.b(a, this.c.getErrorBytesLog());
            a(new com.ss.android.socialbase.downloader.exception.f(1027, "current bytes is not equals to total bytes, bytes changed with process : " + this.c.getByteInvalidRetryStatus()));
        } else if (this.c.getCurBytes() <= 0) {
            com.ss.android.socialbase.downloader.c.a.b(a, this.c.getErrorBytesLog());
            a(new com.ss.android.socialbase.downloader.exception.f(1026, "curBytes is 0, bytes changed with process : " + this.c.getByteInvalidRetryStatus()));
        } else if (!this.c.isIgnoreDataVerify() && this.c.getTotalBytes() <= 0) {
            com.ss.android.socialbase.downloader.c.a.b(a, this.c.getErrorBytesLog());
            a(new com.ss.android.socialbase.downloader.exception.f(1044, "TotalBytes is 0, bytes changed with process : " + this.c.getByteInvalidRetryStatus()));
        } else {
            String str = a;
            com.ss.android.socialbase.downloader.c.a.b(str, "" + this.c.getName() + " onCompleted start save file as target name");
            x xVar = this.q;
            DownloadTask downloadTask = this.f;
            if (downloadTask != null) {
                xVar = downloadTask.getMonitorDepend();
            }
            com.ss.android.socialbase.downloader.i.f.a(this.c, xVar, new ai() { // from class: com.ss.android.socialbase.downloader.downloader.f.2
                @Override // com.ss.android.socialbase.downloader.depend.ai
                public void a(BaseException baseException) {
                    String str2;
                    String str3 = f.a;
                    StringBuilder sb = new StringBuilder();
                    sb.append("saveFileAsTargetName onFailed : ");
                    if (baseException != null) {
                        str2 = baseException.getErrorMessage();
                    } else {
                        str2 = "";
                    }
                    sb.append(str2);
                    com.ss.android.socialbase.downloader.c.a.b(str3, sb.toString());
                    f.this.a(baseException);
                }

                @Override // com.ss.android.socialbase.downloader.depend.ai
                public void a() {
                    f.this.l();
                }
            });
        }
    }

    public void g() throws BaseException {
        if (this.b) {
            m();
            com.ss.android.socialbase.downloader.c.a.b(a, "onCompleteForFileExist");
            this.c.setSuccessByCache(true);
            a(-3, (BaseException) null);
            this.d.c(this.c.getId(), this.c.getTotalBytes());
            this.d.d(this.c.getId());
            this.d.a(this.c);
            this.d.m(this.c.getId());
            return;
        }
        m();
        com.ss.android.socialbase.downloader.c.a.b(a, "onCompleteForFileExist");
        this.c.setSuccessByCache(true);
        a(-3, (BaseException) null);
        this.d.c(this.c.getId(), this.c.getTotalBytes());
        this.d.d(this.c.getId());
        this.d.m(this.c.getId());
    }
}
