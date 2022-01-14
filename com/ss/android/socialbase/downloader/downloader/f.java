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
/* loaded from: classes3.dex */
public class f {
    public static final String a = "f";

    /* renamed from: b  reason: collision with root package name */
    public final boolean f59978b;

    /* renamed from: c  reason: collision with root package name */
    public DownloadInfo f59979c;

    /* renamed from: d  reason: collision with root package name */
    public final j f59980d;

    /* renamed from: e  reason: collision with root package name */
    public final Handler f59981e;

    /* renamed from: f  reason: collision with root package name */
    public DownloadTask f59982f;

    /* renamed from: g  reason: collision with root package name */
    public SparseArray<IDownloadListener> f59983g;

    /* renamed from: h  reason: collision with root package name */
    public SparseArray<IDownloadListener> f59984h;

    /* renamed from: i  reason: collision with root package name */
    public SparseArray<IDownloadListener> f59985i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f59986j = false;
    public volatile long k = 0;
    public final AtomicLong l = new AtomicLong();
    public boolean m = false;
    public int n;
    public long o;
    public com.ss.android.socialbase.downloader.depend.n p;
    public x q;

    public f(DownloadTask downloadTask, Handler handler) {
        this.f59982f = downloadTask;
        j();
        this.f59981e = handler;
        this.f59980d = c.x();
        DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
        if (downloadInfo != null) {
            this.f59978b = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).a("fix_start_with_file_exist_update_error");
        } else {
            this.f59978b = false;
        }
    }

    private void j() {
        DownloadTask downloadTask = this.f59982f;
        if (downloadTask != null) {
            this.f59979c = downloadTask.getDownloadInfo();
            this.f59983g = this.f59982f.getDownloadListeners(com.ss.android.socialbase.downloader.constants.f.MAIN);
            this.f59985i = this.f59982f.getDownloadListeners(com.ss.android.socialbase.downloader.constants.f.NOTIFICATION);
            this.f59984h = this.f59982f.getDownloadListeners(com.ss.android.socialbase.downloader.constants.f.SUB);
            this.p = this.f59982f.getDepend();
            this.q = this.f59982f.getMonitorDepend();
        }
    }

    private void k() {
        ExecutorService l = c.l();
        if (l != null) {
            l.execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.f.1
                @Override // java.lang.Runnable
                public void run() {
                    f.this.f59980d.i(f.this.f59979c.getId());
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
                this.f59979c.setFirstSuccess(false);
                this.f59979c.setSuccessByCache(false);
                a(-3, (BaseException) null);
                this.f59980d.c(this.f59979c.getId(), this.f59979c.getTotalBytes());
                this.f59980d.d(this.f59979c.getId());
                this.f59980d.m(this.f59979c.getId());
            } catch (BaseException e2) {
                a(e2);
            }
        } catch (Throwable th) {
            a(new BaseException(1008, com.ss.android.socialbase.downloader.i.f.b(th, "onCompleted")));
        }
    }

    private void m() throws BaseException {
        List<com.ss.android.socialbase.downloader.depend.m> downloadCompleteHandlers = this.f59982f.getDownloadCompleteHandlers();
        if (downloadCompleteHandlers.isEmpty()) {
            return;
        }
        DownloadInfo downloadInfo = this.f59979c;
        a(11, (BaseException) null);
        this.f59980d.a(downloadInfo);
        for (com.ss.android.socialbase.downloader.depend.m mVar : downloadCompleteHandlers) {
            try {
                if (mVar.b(downloadInfo)) {
                    mVar.a(downloadInfo);
                    this.f59980d.a(downloadInfo);
                }
            } catch (BaseException e2) {
                throw e2;
            } catch (Throwable th) {
                throw new BaseException((int) RevenueServerConst.GetBannerConfigRequest, th);
            }
        }
    }

    public void d() {
        this.f59979c.setStatus(-2);
        try {
            this.f59980d.d(this.f59979c.getId(), this.f59979c.getCurBytes());
        } catch (SQLiteException e2) {
            e2.printStackTrace();
        }
        a(-2, (BaseException) null);
    }

    public void e() {
        this.f59979c.setStatus(-7);
        try {
            this.f59980d.j(this.f59979c.getId());
        } catch (SQLiteException e2) {
            e2.printStackTrace();
        }
        a(-7, (BaseException) null);
    }

    public void f() {
        this.f59979c.setFirstDownload(false);
        if (!this.f59979c.isIgnoreDataVerify() && this.f59979c.getCurBytes() != this.f59979c.getTotalBytes()) {
            com.ss.android.socialbase.downloader.c.a.b(a, this.f59979c.getErrorBytesLog());
            a(new com.ss.android.socialbase.downloader.exception.f(ARPMessageType.MSG_TYPE_VIDEO_STOP, "current bytes is not equals to total bytes, bytes changed with process : " + this.f59979c.getByteInvalidRetryStatus()));
        } else if (this.f59979c.getCurBytes() <= 0) {
            com.ss.android.socialbase.downloader.c.a.b(a, this.f59979c.getErrorBytesLog());
            a(new com.ss.android.socialbase.downloader.exception.f(1026, "curBytes is 0, bytes changed with process : " + this.f59979c.getByteInvalidRetryStatus()));
        } else if (!this.f59979c.isIgnoreDataVerify() && this.f59979c.getTotalBytes() <= 0) {
            com.ss.android.socialbase.downloader.c.a.b(a, this.f59979c.getErrorBytesLog());
            a(new com.ss.android.socialbase.downloader.exception.f(1044, "TotalBytes is 0, bytes changed with process : " + this.f59979c.getByteInvalidRetryStatus()));
        } else {
            String str = a;
            com.ss.android.socialbase.downloader.c.a.b(str, "" + this.f59979c.getName() + " onCompleted start save file as target name");
            x xVar = this.q;
            DownloadTask downloadTask = this.f59982f;
            if (downloadTask != null) {
                xVar = downloadTask.getMonitorDepend();
            }
            com.ss.android.socialbase.downloader.i.f.a(this.f59979c, xVar, new ai() { // from class: com.ss.android.socialbase.downloader.downloader.f.2
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
        if (this.f59978b) {
            m();
            com.ss.android.socialbase.downloader.c.a.b(a, "onCompleteForFileExist");
            this.f59979c.setSuccessByCache(true);
            a(-3, (BaseException) null);
            this.f59980d.c(this.f59979c.getId(), this.f59979c.getTotalBytes());
            this.f59980d.d(this.f59979c.getId());
            this.f59980d.a(this.f59979c);
            this.f59980d.m(this.f59979c.getId());
            return;
        }
        m();
        com.ss.android.socialbase.downloader.c.a.b(a, "onCompleteForFileExist");
        this.f59979c.setSuccessByCache(true);
        a(-3, (BaseException) null);
        this.f59980d.c(this.f59979c.getId(), this.f59979c.getTotalBytes());
        this.f59980d.d(this.f59979c.getId());
        this.f59980d.m(this.f59979c.getId());
    }

    public void h() {
        this.f59979c.setStatus(8);
        this.f59979c.setAsyncHandleStatus(com.ss.android.socialbase.downloader.constants.a.ASYNC_HANDLE_WAITING);
        com.ss.android.socialbase.downloader.impls.a C = c.C();
        if (C != null) {
            C.a(this.f59979c.getId(), this.f59982f.getHashCodeForSameTask(), 8);
        }
    }

    public void b() {
        if (this.f59979c.canSkipStatusHandler()) {
            this.f59979c.changeSkipStatus();
            return;
        }
        this.f59980d.g(this.f59979c.getId());
        if (this.f59979c.isFirstDownload()) {
            a(6, (BaseException) null);
        }
        a(2, (BaseException) null);
    }

    public void c() {
        a(-4, (BaseException) null);
    }

    private BaseException c(BaseException baseException) {
        Context N;
        if (com.ss.android.socialbase.downloader.g.a.a(this.f59979c.getId()).a("download_failed_check_net", 1) != 1 || !com.ss.android.socialbase.downloader.i.f.i(baseException) || (N = c.N()) == null || com.ss.android.socialbase.downloader.i.f.c(N)) {
            return baseException;
        }
        return new BaseException(this.f59979c.isOnlyWifi() ? 1013 : 1049, baseException.getErrorMessage());
    }

    public void a() {
        if (this.f59979c.canSkipStatusHandler()) {
            return;
        }
        this.f59979c.setStatus(1);
        k();
    }

    public void a(long j2, String str, String str2) {
        this.f59979c.setTotalBytes(j2);
        this.f59979c.seteTag(str);
        if (!TextUtils.isEmpty(str2) && TextUtils.isEmpty(this.f59979c.getName())) {
            this.f59979c.setName(str2);
        }
        try {
            this.f59980d.a(this.f59979c.getId(), j2, str, str2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        a(3, (BaseException) null);
        this.o = this.f59979c.getMinByteIntervalForPostToMainThread(j2);
        this.n = this.f59979c.getMinProgressTimeMsInterval();
        this.f59986j = true;
        com.ss.android.socialbase.downloader.impls.r.a().e();
    }

    private void b(BaseException baseException) {
        String str = "handleError::" + baseException + " \r\n" + Log.getStackTraceString(new Throwable());
        if (baseException != null && baseException.getCause() != null && (baseException.getCause() instanceof SQLiteFullException)) {
            try {
                this.f59980d.f(this.f59979c.getId());
            } catch (SQLiteException e2) {
                e2.printStackTrace();
            }
        } else {
            try {
                try {
                    this.f59980d.b(this.f59979c.getId(), this.f59979c.getCurBytes());
                } catch (SQLiteException unused) {
                    this.f59980d.f(this.f59979c.getId());
                }
            } catch (SQLiteException e3) {
                e3.printStackTrace();
            }
        }
        BaseException c2 = c(baseException);
        this.f59979c.setFailedException(c2);
        a(c2 instanceof com.ss.android.socialbase.downloader.exception.e ? -2 : -1, c2);
        if (com.ss.android.socialbase.downloader.g.a.a(this.f59979c.getId()).a("retry_schedule", 0) > 0) {
            com.ss.android.socialbase.downloader.impls.r.a().a(this.f59979c);
        }
    }

    public boolean a(long j2) {
        this.l.addAndGet(j2);
        this.f59979c.increaseCurBytes(j2);
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
        this.f59979c.setFirstDownload(false);
        this.l.set(0L);
        b(baseException, z);
    }

    public void a(com.ss.android.socialbase.downloader.model.b bVar, BaseException baseException, boolean z) {
        this.f59979c.setFirstDownload(false);
        this.l.set(0L);
        this.f59980d.h(this.f59979c.getId());
        a(z ? 10 : 9, baseException, true);
    }

    private void b(BaseException baseException, boolean z) {
        this.f59980d.h(this.f59979c.getId());
        a(z ? 7 : 5, baseException);
    }

    public void a(BaseException baseException) {
        this.f59979c.setFirstDownload(false);
        b(baseException);
    }

    public void a(String str) throws BaseException {
        String str2 = a;
        com.ss.android.socialbase.downloader.c.a.b(str2, "onCompleteForFileExist existTargetFileName is " + str + " but curName is " + this.f59979c.getName());
        if (this.f59978b) {
            com.ss.android.socialbase.downloader.i.f.a(this.f59979c, str);
            m();
            this.f59979c.setSuccessByCache(true);
            a(-3, (BaseException) null);
            this.f59980d.a(this.f59979c);
            return;
        }
        this.f59980d.a(this.f59979c);
        com.ss.android.socialbase.downloader.i.f.a(this.f59979c, str);
        this.f59979c.setSuccessByCache(true);
        m();
        a(-3, (BaseException) null);
    }

    private boolean a(long j2, boolean z) {
        boolean z2 = false;
        if (this.f59979c.getCurBytes() == this.f59979c.getTotalBytes()) {
            try {
                this.f59980d.a(this.f59979c.getId(), this.f59979c.getCurBytes());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return false;
        }
        if (this.f59986j) {
            this.f59986j = false;
            this.f59979c.setStatus(4);
        }
        if (this.f59979c.isNeedPostProgress() && z) {
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
        int status = this.f59979c.getStatus();
        if (status == -3 && i2 == 4) {
            return;
        }
        j();
        if (i2 != 4 && DownloadStatus.isRealTimeUploadStatus(i2)) {
            this.f59979c.updateRealDownloadTime(false);
            if (DownloadStatus.isTimeUploadStatus(i2)) {
                this.f59979c.updateDownloadTime();
            }
        }
        if (!this.f59979c.isAddListenerToSameTask()) {
            com.ss.android.socialbase.downloader.d.a.a(this.f59982f, baseException, i2);
        }
        if (i2 == 6) {
            this.f59979c.setStatus(2);
        } else if (i2 == -6) {
            this.f59979c.setStatus(-3);
        } else {
            this.f59979c.setStatus(i2);
        }
        if (status == -3 || status == -1) {
            if (this.f59979c.getRetryDelayStatus() == com.ss.android.socialbase.downloader.constants.g.DELAY_RETRY_DOWNLOADING) {
                this.f59979c.setRetryDelayStatus(com.ss.android.socialbase.downloader.constants.g.DELAY_RETRY_DOWNLOADED);
            }
            if (this.f59979c.getAsyncHandleStatus() == com.ss.android.socialbase.downloader.constants.a.ASYNC_HANDLE_DOWNLOADING) {
                this.f59979c.setAsyncHandleStatus(com.ss.android.socialbase.downloader.constants.a.ASYNC_HANDLE_DOWNLOADED);
            }
            if (this.f59979c.getByteInvalidRetryStatus() == com.ss.android.socialbase.downloader.constants.b.BYTE_INVALID_RETRY_STATUS_DOWNLOADING) {
                this.f59979c.setByteInvalidRetryStatus(com.ss.android.socialbase.downloader.constants.b.BYTE_INVALID_RETRY_STATUS_DOWNLOADED);
            }
        }
        com.ss.android.socialbase.downloader.i.c.a(i2, this.f59984h, true, this.f59979c, baseException);
        if (i2 == -4) {
            return;
        }
        if (z && this.f59981e != null && (((sparseArray = this.f59983g) != null && sparseArray.size() > 0) || ((sparseArray2 = this.f59985i) != null && sparseArray2.size() > 0 && (this.f59979c.canShowNotification() || this.f59979c.isAutoInstallWithoutNotification())))) {
            this.f59981e.obtainMessage(i2, this.f59979c.getId(), this.f59982f.getHashCodeForSameTask(), baseException).sendToTarget();
            return;
        }
        com.ss.android.socialbase.downloader.impls.a C = c.C();
        if (C != null) {
            C.a(this.f59979c.getId(), this.f59982f.getHashCodeForSameTask(), i2);
        }
    }
}
