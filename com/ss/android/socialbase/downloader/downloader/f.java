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
/* loaded from: classes4.dex */
public class f {
    public static final String a = "f";

    /* renamed from: b  reason: collision with root package name */
    public final boolean f60190b;

    /* renamed from: c  reason: collision with root package name */
    public DownloadInfo f60191c;

    /* renamed from: d  reason: collision with root package name */
    public final j f60192d;

    /* renamed from: e  reason: collision with root package name */
    public final Handler f60193e;

    /* renamed from: f  reason: collision with root package name */
    public DownloadTask f60194f;

    /* renamed from: g  reason: collision with root package name */
    public SparseArray<IDownloadListener> f60195g;

    /* renamed from: h  reason: collision with root package name */
    public SparseArray<IDownloadListener> f60196h;

    /* renamed from: i  reason: collision with root package name */
    public SparseArray<IDownloadListener> f60197i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f60198j = false;
    public volatile long k = 0;
    public final AtomicLong l = new AtomicLong();
    public boolean m = false;
    public int n;
    public long o;
    public com.ss.android.socialbase.downloader.depend.n p;
    public x q;

    public f(DownloadTask downloadTask, Handler handler) {
        this.f60194f = downloadTask;
        j();
        this.f60193e = handler;
        this.f60192d = c.x();
        DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
        if (downloadInfo != null) {
            this.f60190b = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).a("fix_start_with_file_exist_update_error");
        } else {
            this.f60190b = false;
        }
    }

    private void j() {
        DownloadTask downloadTask = this.f60194f;
        if (downloadTask != null) {
            this.f60191c = downloadTask.getDownloadInfo();
            this.f60195g = this.f60194f.getDownloadListeners(com.ss.android.socialbase.downloader.constants.f.MAIN);
            this.f60197i = this.f60194f.getDownloadListeners(com.ss.android.socialbase.downloader.constants.f.NOTIFICATION);
            this.f60196h = this.f60194f.getDownloadListeners(com.ss.android.socialbase.downloader.constants.f.SUB);
            this.p = this.f60194f.getDepend();
            this.q = this.f60194f.getMonitorDepend();
        }
    }

    private void k() {
        ExecutorService l = c.l();
        if (l != null) {
            l.execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.f.1
                @Override // java.lang.Runnable
                public void run() {
                    f.this.f60192d.i(f.this.f60191c.getId());
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
                this.f60191c.setFirstSuccess(false);
                this.f60191c.setSuccessByCache(false);
                a(-3, (BaseException) null);
                this.f60192d.c(this.f60191c.getId(), this.f60191c.getTotalBytes());
                this.f60192d.d(this.f60191c.getId());
                this.f60192d.m(this.f60191c.getId());
            } catch (BaseException e2) {
                a(e2);
            }
        } catch (Throwable th) {
            a(new BaseException(1008, com.ss.android.socialbase.downloader.i.f.b(th, "onCompleted")));
        }
    }

    private void m() throws BaseException {
        List<com.ss.android.socialbase.downloader.depend.m> downloadCompleteHandlers = this.f60194f.getDownloadCompleteHandlers();
        if (downloadCompleteHandlers.isEmpty()) {
            return;
        }
        DownloadInfo downloadInfo = this.f60191c;
        a(11, (BaseException) null);
        this.f60192d.a(downloadInfo);
        for (com.ss.android.socialbase.downloader.depend.m mVar : downloadCompleteHandlers) {
            try {
                if (mVar.b(downloadInfo)) {
                    mVar.a(downloadInfo);
                    this.f60192d.a(downloadInfo);
                }
            } catch (BaseException e2) {
                throw e2;
            } catch (Throwable th) {
                throw new BaseException((int) RevenueServerConst.GetBannerConfigRequest, th);
            }
        }
    }

    public void d() {
        this.f60191c.setStatus(-2);
        try {
            this.f60192d.d(this.f60191c.getId(), this.f60191c.getCurBytes());
        } catch (SQLiteException e2) {
            e2.printStackTrace();
        }
        a(-2, (BaseException) null);
    }

    public void e() {
        this.f60191c.setStatus(-7);
        try {
            this.f60192d.j(this.f60191c.getId());
        } catch (SQLiteException e2) {
            e2.printStackTrace();
        }
        a(-7, (BaseException) null);
    }

    public void f() {
        this.f60191c.setFirstDownload(false);
        if (!this.f60191c.isIgnoreDataVerify() && this.f60191c.getCurBytes() != this.f60191c.getTotalBytes()) {
            com.ss.android.socialbase.downloader.c.a.b(a, this.f60191c.getErrorBytesLog());
            a(new com.ss.android.socialbase.downloader.exception.f(ARPMessageType.MSG_TYPE_VIDEO_STOP, "current bytes is not equals to total bytes, bytes changed with process : " + this.f60191c.getByteInvalidRetryStatus()));
        } else if (this.f60191c.getCurBytes() <= 0) {
            com.ss.android.socialbase.downloader.c.a.b(a, this.f60191c.getErrorBytesLog());
            a(new com.ss.android.socialbase.downloader.exception.f(1026, "curBytes is 0, bytes changed with process : " + this.f60191c.getByteInvalidRetryStatus()));
        } else if (!this.f60191c.isIgnoreDataVerify() && this.f60191c.getTotalBytes() <= 0) {
            com.ss.android.socialbase.downloader.c.a.b(a, this.f60191c.getErrorBytesLog());
            a(new com.ss.android.socialbase.downloader.exception.f(1044, "TotalBytes is 0, bytes changed with process : " + this.f60191c.getByteInvalidRetryStatus()));
        } else {
            String str = a;
            com.ss.android.socialbase.downloader.c.a.b(str, "" + this.f60191c.getName() + " onCompleted start save file as target name");
            x xVar = this.q;
            DownloadTask downloadTask = this.f60194f;
            if (downloadTask != null) {
                xVar = downloadTask.getMonitorDepend();
            }
            com.ss.android.socialbase.downloader.i.f.a(this.f60191c, xVar, new ai() { // from class: com.ss.android.socialbase.downloader.downloader.f.2
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
        if (this.f60190b) {
            m();
            com.ss.android.socialbase.downloader.c.a.b(a, "onCompleteForFileExist");
            this.f60191c.setSuccessByCache(true);
            a(-3, (BaseException) null);
            this.f60192d.c(this.f60191c.getId(), this.f60191c.getTotalBytes());
            this.f60192d.d(this.f60191c.getId());
            this.f60192d.a(this.f60191c);
            this.f60192d.m(this.f60191c.getId());
            return;
        }
        m();
        com.ss.android.socialbase.downloader.c.a.b(a, "onCompleteForFileExist");
        this.f60191c.setSuccessByCache(true);
        a(-3, (BaseException) null);
        this.f60192d.c(this.f60191c.getId(), this.f60191c.getTotalBytes());
        this.f60192d.d(this.f60191c.getId());
        this.f60192d.m(this.f60191c.getId());
    }

    public void h() {
        this.f60191c.setStatus(8);
        this.f60191c.setAsyncHandleStatus(com.ss.android.socialbase.downloader.constants.a.ASYNC_HANDLE_WAITING);
        com.ss.android.socialbase.downloader.impls.a C = c.C();
        if (C != null) {
            C.a(this.f60191c.getId(), this.f60194f.getHashCodeForSameTask(), 8);
        }
    }

    public void b() {
        if (this.f60191c.canSkipStatusHandler()) {
            this.f60191c.changeSkipStatus();
            return;
        }
        this.f60192d.g(this.f60191c.getId());
        if (this.f60191c.isFirstDownload()) {
            a(6, (BaseException) null);
        }
        a(2, (BaseException) null);
    }

    public void c() {
        a(-4, (BaseException) null);
    }

    private BaseException c(BaseException baseException) {
        Context N;
        if (com.ss.android.socialbase.downloader.g.a.a(this.f60191c.getId()).a("download_failed_check_net", 1) != 1 || !com.ss.android.socialbase.downloader.i.f.i(baseException) || (N = c.N()) == null || com.ss.android.socialbase.downloader.i.f.c(N)) {
            return baseException;
        }
        return new BaseException(this.f60191c.isOnlyWifi() ? 1013 : 1049, baseException.getErrorMessage());
    }

    public void a() {
        if (this.f60191c.canSkipStatusHandler()) {
            return;
        }
        this.f60191c.setStatus(1);
        k();
    }

    public void a(long j2, String str, String str2) {
        this.f60191c.setTotalBytes(j2);
        this.f60191c.seteTag(str);
        if (!TextUtils.isEmpty(str2) && TextUtils.isEmpty(this.f60191c.getName())) {
            this.f60191c.setName(str2);
        }
        try {
            this.f60192d.a(this.f60191c.getId(), j2, str, str2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        a(3, (BaseException) null);
        this.o = this.f60191c.getMinByteIntervalForPostToMainThread(j2);
        this.n = this.f60191c.getMinProgressTimeMsInterval();
        this.f60198j = true;
        com.ss.android.socialbase.downloader.impls.r.a().e();
    }

    private void b(BaseException baseException) {
        String str = "handleError::" + baseException + " \r\n" + Log.getStackTraceString(new Throwable());
        if (baseException != null && baseException.getCause() != null && (baseException.getCause() instanceof SQLiteFullException)) {
            try {
                this.f60192d.f(this.f60191c.getId());
            } catch (SQLiteException e2) {
                e2.printStackTrace();
            }
        } else {
            try {
                try {
                    this.f60192d.b(this.f60191c.getId(), this.f60191c.getCurBytes());
                } catch (SQLiteException unused) {
                    this.f60192d.f(this.f60191c.getId());
                }
            } catch (SQLiteException e3) {
                e3.printStackTrace();
            }
        }
        BaseException c2 = c(baseException);
        this.f60191c.setFailedException(c2);
        a(c2 instanceof com.ss.android.socialbase.downloader.exception.e ? -2 : -1, c2);
        if (com.ss.android.socialbase.downloader.g.a.a(this.f60191c.getId()).a("retry_schedule", 0) > 0) {
            com.ss.android.socialbase.downloader.impls.r.a().a(this.f60191c);
        }
    }

    public boolean a(long j2) {
        this.l.addAndGet(j2);
        this.f60191c.increaseCurBytes(j2);
        long uptimeMillis = SystemClock.uptimeMillis();
        return a(uptimeMillis, b(uptimeMillis));
    }

    private boolean b(long j2) {
        boolean z = true;
        if (!this.m) {
            this.m = true;
            return true;
        }
        long j3 = j2 - this.k;
        if (this.l.get() < this.o && j3 < this.n) {
            z = false;
        }
        if (z) {
            this.k = j2;
            this.l.set(0L);
        }
        return z;
    }

    public void a(BaseException baseException, boolean z) {
        this.f60191c.setFirstDownload(false);
        this.l.set(0L);
        b(baseException, z);
    }

    public void a(com.ss.android.socialbase.downloader.model.b bVar, BaseException baseException, boolean z) {
        this.f60191c.setFirstDownload(false);
        this.l.set(0L);
        this.f60192d.h(this.f60191c.getId());
        a(z ? 10 : 9, baseException, true);
    }

    private void b(BaseException baseException, boolean z) {
        this.f60192d.h(this.f60191c.getId());
        a(z ? 7 : 5, baseException);
    }

    public void a(BaseException baseException) {
        this.f60191c.setFirstDownload(false);
        b(baseException);
    }

    public void a(String str) throws BaseException {
        String str2 = a;
        com.ss.android.socialbase.downloader.c.a.b(str2, "onCompleteForFileExist existTargetFileName is " + str + " but curName is " + this.f60191c.getName());
        if (this.f60190b) {
            com.ss.android.socialbase.downloader.i.f.a(this.f60191c, str);
            m();
            this.f60191c.setSuccessByCache(true);
            a(-3, (BaseException) null);
            this.f60192d.a(this.f60191c);
            return;
        }
        this.f60192d.a(this.f60191c);
        com.ss.android.socialbase.downloader.i.f.a(this.f60191c, str);
        this.f60191c.setSuccessByCache(true);
        m();
        a(-3, (BaseException) null);
    }

    private boolean a(long j2, boolean z) {
        boolean z2 = false;
        if (this.f60191c.getCurBytes() == this.f60191c.getTotalBytes()) {
            try {
                this.f60192d.a(this.f60191c.getId(), this.f60191c.getCurBytes());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return false;
        }
        if (this.f60198j) {
            this.f60198j = false;
            this.f60191c.setStatus(4);
        }
        if (this.f60191c.isNeedPostProgress() && z) {
            z2 = true;
        }
        a(4, (BaseException) null, z2);
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, BaseException baseException) {
        a(i2, baseException, true);
    }

    private void a(int i2, BaseException baseException, boolean z) {
        SparseArray<IDownloadListener> sparseArray;
        SparseArray<IDownloadListener> sparseArray2;
        int status = this.f60191c.getStatus();
        if (status == -3 && i2 == 4) {
            return;
        }
        j();
        if (i2 != 4 && DownloadStatus.isRealTimeUploadStatus(i2)) {
            this.f60191c.updateRealDownloadTime(false);
            if (DownloadStatus.isTimeUploadStatus(i2)) {
                this.f60191c.updateDownloadTime();
            }
        }
        if (!this.f60191c.isAddListenerToSameTask()) {
            com.ss.android.socialbase.downloader.d.a.a(this.f60194f, baseException, i2);
        }
        if (i2 == 6) {
            this.f60191c.setStatus(2);
        } else if (i2 == -6) {
            this.f60191c.setStatus(-3);
        } else {
            this.f60191c.setStatus(i2);
        }
        if (status == -3 || status == -1) {
            if (this.f60191c.getRetryDelayStatus() == com.ss.android.socialbase.downloader.constants.g.DELAY_RETRY_DOWNLOADING) {
                this.f60191c.setRetryDelayStatus(com.ss.android.socialbase.downloader.constants.g.DELAY_RETRY_DOWNLOADED);
            }
            if (this.f60191c.getAsyncHandleStatus() == com.ss.android.socialbase.downloader.constants.a.ASYNC_HANDLE_DOWNLOADING) {
                this.f60191c.setAsyncHandleStatus(com.ss.android.socialbase.downloader.constants.a.ASYNC_HANDLE_DOWNLOADED);
            }
            if (this.f60191c.getByteInvalidRetryStatus() == com.ss.android.socialbase.downloader.constants.b.BYTE_INVALID_RETRY_STATUS_DOWNLOADING) {
                this.f60191c.setByteInvalidRetryStatus(com.ss.android.socialbase.downloader.constants.b.BYTE_INVALID_RETRY_STATUS_DOWNLOADED);
            }
        }
        com.ss.android.socialbase.downloader.i.c.a(i2, this.f60196h, true, this.f60191c, baseException);
        if (i2 == -4) {
            return;
        }
        if (z && this.f60193e != null && (((sparseArray = this.f60195g) != null && sparseArray.size() > 0) || ((sparseArray2 = this.f60197i) != null && sparseArray2.size() > 0 && (this.f60191c.canShowNotification() || this.f60191c.isAutoInstallWithoutNotification())))) {
            this.f60193e.obtainMessage(i2, this.f60191c.getId(), this.f60194f.getHashCodeForSameTask(), baseException).sendToTarget();
            return;
        }
        com.ss.android.socialbase.downloader.impls.a C = c.C();
        if (C != null) {
            C.a(this.f60191c.getId(), this.f60194f.getHashCodeForSameTask(), i2);
        }
    }
}
