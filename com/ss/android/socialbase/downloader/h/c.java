package com.ss.android.socialbase.downloader.h;

import android.database.sqlite.SQLiteException;
import android.os.Handler;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.ar.constants.DebugConstants;
import com.ss.android.socialbase.downloader.depend.IDownloadInterceptor;
import com.ss.android.socialbase.downloader.depend.r;
import com.ss.android.socialbase.downloader.depend.w;
import com.ss.android.socialbase.downloader.depend.x;
import com.ss.android.socialbase.downloader.downloader.j;
import com.ss.android.socialbase.downloader.downloader.s;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.f.k;
import com.ss.android.socialbase.downloader.f.n;
import com.ss.android.socialbase.downloader.impls.q;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.model.b;
import com.ss.android.socialbase.downloader.network.i;
import com.ss.android.socialbase.downloader.network.l;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.SSLHandshakeException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class c implements f, Runnable {
    public static final String a = c.class.getSimpleName();
    public r A;
    public String E;
    public long G;
    public long H;
    public final com.ss.android.socialbase.downloader.g.a I;
    public Future b;
    public final DownloadTask c;
    public AtomicInteger e;
    public volatile com.ss.android.socialbase.downloader.downloader.e g;
    public boolean h;
    public boolean i;
    public boolean j;
    public boolean k;
    public boolean l;
    public final AtomicBoolean m;
    public final j o;
    public DownloadInfo p;
    public com.ss.android.socialbase.downloader.downloader.h q;
    public final com.ss.android.socialbase.downloader.downloader.h r;
    public com.ss.android.socialbase.downloader.downloader.g s;
    public final com.ss.android.socialbase.downloader.downloader.g t;
    public s u;
    public final com.ss.android.socialbase.downloader.downloader.f v;
    public volatile BaseException w;
    public i x;
    public com.ss.android.socialbase.downloader.network.g y;
    public w z;
    public volatile boolean d = false;
    public final ArrayList<b> f = new ArrayList<>();
    public volatile com.ss.android.socialbase.downloader.constants.h n = com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_NONE;
    public volatile int B = 5;
    public boolean C = false;
    public boolean D = false;
    public boolean F = false;
    public int J = 0;
    public volatile k K = null;

    private boolean K() {
        return false;
    }

    private long A() {
        return this.u.a(this.p.getCurRetryTimeInTotal(), this.p.getTotalRetryCount());
    }

    private boolean C() {
        DownloadInfo downloadInfo = this.p;
        if (downloadInfo == null || downloadInfo.isExpiredRedownload()) {
            return false;
        }
        if ((this.i && this.p.getChunkCount() <= 1) || this.p.isChunkDowngradeRetryUsed() || !this.j || this.l) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        com.ss.android.socialbase.downloader.impls.a C;
        if (!v() && (C = com.ss.android.socialbase.downloader.downloader.c.C()) != null) {
            C.l(this.p.getId());
        }
    }

    private void h() {
        DownloadInfo downloadInfo = this.p;
        if (downloadInfo == null) {
            return;
        }
        int retryCount = downloadInfo.getRetryCount() - this.p.getCurRetryTime();
        if (retryCount < 0) {
            retryCount = 0;
        }
        AtomicInteger atomicInteger = this.e;
        if (atomicInteger == null) {
            this.e = new AtomicInteger(retryCount);
        } else {
            atomicInteger.set(retryCount);
        }
    }

    private void q() {
        com.ss.android.socialbase.downloader.network.g gVar = this.y;
        if (gVar != null) {
            gVar.c();
            this.y = null;
        }
    }

    private void r() {
        i iVar = this.x;
        if (iVar != null) {
            iVar.d();
            this.x = null;
        }
    }

    private void s() {
        q();
        r();
    }

    private void t() throws BaseException {
        if (this.g != null) {
            if (this.n == com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_CANCELED) {
                this.p.setStatus(-4);
                this.g.c();
            } else if (this.n == com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_PAUSE) {
                this.p.setStatus(-2);
                this.g.b();
            } else {
                this.g.d();
            }
        }
    }

    private boolean u() {
        if (this.n != com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_CANCELED && this.n != com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_PAUSE) {
            return false;
        }
        return true;
    }

    private void z() {
        this.n = com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_NONE;
    }

    public void b() {
        this.n = com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_CANCELED;
        if (this.K != null) {
            this.K.a();
        }
        if (this.g != null) {
            this.g.c();
        }
        if (this.K == null && this.g == null) {
            s();
            this.n = com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_CANCELED;
            p();
        }
        I();
    }

    public DownloadTask c() {
        return this.c;
    }

    public boolean d() {
        return this.m.get();
    }

    public int e() {
        DownloadInfo downloadInfo = this.p;
        if (downloadInfo != null) {
            return downloadInfo.getId();
        }
        return 0;
    }

    public void f() {
        this.H = System.currentTimeMillis();
        this.v.a();
    }

    public Future g() {
        return this.b;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.ss.android.socialbase.downloader.downloader.c.a(this.c, 3);
        try {
            com.ss.android.socialbase.downloader.network.b.a().b();
            k();
            com.ss.android.socialbase.downloader.network.b.a().c();
            com.ss.android.socialbase.downloader.downloader.c.b(this.c, 3);
        } catch (Throwable th) {
            com.ss.android.socialbase.downloader.network.b.a().c();
            throw th;
        }
    }

    public c(DownloadTask downloadTask, Handler handler) {
        this.c = downloadTask;
        if (downloadTask != null) {
            this.p = downloadTask.getDownloadInfo();
            this.q = downloadTask.getChunkStrategy();
            this.s = downloadTask.getChunkAdjustCalculator();
            this.z = downloadTask.getForbiddenHandler();
            this.A = downloadTask.getDiskSpaceHandler();
            this.u = a(downloadTask);
            this.I = com.ss.android.socialbase.downloader.g.a.a(this.p.getId());
        } else {
            this.I = com.ss.android.socialbase.downloader.g.a.c();
        }
        h();
        this.o = com.ss.android.socialbase.downloader.downloader.c.x();
        this.r = com.ss.android.socialbase.downloader.downloader.c.I();
        this.t = com.ss.android.socialbase.downloader.downloader.c.K();
        this.v = new com.ss.android.socialbase.downloader.downloader.f(downloadTask, handler);
        this.m = new AtomicBoolean(true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x005c, code lost:
        if (r9 <= 0) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int a(long j, List<com.ss.android.socialbase.downloader.model.b> list) {
        int i;
        int a2;
        if (C()) {
            if (this.i) {
                if (list != null) {
                    i = list.size();
                } else {
                    i = this.p.getChunkCount();
                }
            } else {
                com.ss.android.socialbase.downloader.downloader.h hVar = this.q;
                if (hVar != null) {
                    a2 = hVar.a(j);
                } else {
                    a2 = this.r.a(j);
                }
                l b = com.ss.android.socialbase.downloader.network.k.a().b();
                com.ss.android.socialbase.downloader.c.a.b(a, String.format("NetworkQuality is : %s", b.name()));
                this.p.setNetworkQuality(b.name());
                com.ss.android.socialbase.downloader.downloader.g gVar = this.s;
                if (gVar != null) {
                    i = gVar.a(a2, b);
                } else {
                    i = this.t.a(a2, b);
                }
            }
        }
        i = 1;
        if (com.ss.android.socialbase.downloader.c.a.a()) {
            com.ss.android.socialbase.downloader.c.a.b(a, String.format("chunk count : %s for %s contentLen:%s", String.valueOf(i), this.p.getName(), String.valueOf(j)));
        }
        return i;
    }

    private void B() throws com.ss.android.socialbase.downloader.exception.i, BaseException {
        com.ss.android.socialbase.downloader.impls.a C;
        int id = this.p.getId();
        int a2 = com.ss.android.socialbase.downloader.downloader.c.a(this.p);
        if (this.p.isDownloaded() && !this.p.isExpiredRedownload() && !this.F) {
            throw new BaseException(1009, "file has downloaded");
        }
        DownloadInfo b = this.o.b(a2);
        if (b != null && (C = com.ss.android.socialbase.downloader.downloader.c.C()) != null && b.getId() != id && b.equalsTask(this.p)) {
            if (!C.a(b.getId())) {
                List<com.ss.android.socialbase.downloader.model.b> c = this.o.c(a2);
                com.ss.android.socialbase.downloader.i.f.a(this.p);
                this.o.f(a2);
                if (b != null && b.isBreakpointAvailable()) {
                    this.p.copyFromCacheData(b, false);
                    this.o.a(this.p);
                    if (c != null) {
                        for (com.ss.android.socialbase.downloader.model.b bVar : c) {
                            bVar.b(id);
                            this.o.a(bVar);
                        }
                    }
                    throw new com.ss.android.socialbase.downloader.exception.i("retry task because id generator changed");
                }
                return;
            }
            this.o.f(id);
            throw new BaseException(1025, "another same task is downloading");
        }
    }

    private void D() throws BaseException {
        long j;
        int a2;
        try {
            j = com.ss.android.socialbase.downloader.i.f.d(this.p.getTempPath());
        } catch (BaseException unused) {
            j = 0;
        }
        com.ss.android.socialbase.downloader.c.a.c(a, "checkSpaceOverflowInProgress: available = " + com.ss.android.socialbase.downloader.i.f.a(j) + "MB");
        if (j > 0) {
            long totalBytes = this.p.getTotalBytes() - this.p.getCurBytes();
            if (j < totalBytes && (a2 = com.ss.android.socialbase.downloader.g.a.a(this.p.getId()).a("space_fill_min_keep_mb", 100)) > 0) {
                long j2 = j - (a2 * 1048576);
                com.ss.android.socialbase.downloader.c.a.c(a, "checkSpaceOverflowInProgress: minKeep  = " + a2 + "MB, canDownload = " + com.ss.android.socialbase.downloader.i.f.a(j2) + "MB");
                if (j2 > 0) {
                    this.G = this.p.getCurBytes() + j2 + 1048576;
                    return;
                } else {
                    this.G = 0L;
                    throw new com.ss.android.socialbase.downloader.exception.d(j, totalBytes);
                }
            }
        }
        this.G = 0L;
    }

    private boolean w() {
        if (this.n == com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_ERROR) {
            this.v.a(this.w);
        } else if (this.n == com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_CANCELED) {
            this.v.c();
        } else if (this.n == com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_PAUSE) {
            this.v.d();
        } else if (this.n == com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_END_RIGHT_NOW) {
            try {
                this.v.g();
            } catch (BaseException e) {
                this.v.a(e);
            }
        } else if (this.n == com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_END_FOR_FILE_EXIST) {
            try {
                this.v.a(this.E);
            } catch (BaseException e2) {
                this.v.a(e2);
            }
        } else if (this.n == com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_ALL_CHUNK_RETRY_WITH_RESET) {
            this.v.a(this.w, false);
            return false;
        } else if (this.n == com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_WAITING_ASYNC_HANDLER) {
            return true;
        } else {
            if (this.n == com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_RETRY_DELAY && !x()) {
                com.ss.android.socialbase.downloader.c.a.b(a, "doTaskStatusHandle retryDelay");
                z();
                if (this.n == com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_RETRY_DELAY) {
                    return true;
                }
                return false;
            }
            try {
                if (!y()) {
                    return false;
                }
                this.v.f();
                com.ss.android.socialbase.downloader.impls.r.a().d();
            } catch (Throwable th) {
                b(new BaseException(1008, com.ss.android.socialbase.downloader.i.f.b(th, "doTaskStatusHandle onComplete")));
            }
        }
        return true;
    }

    private boolean y() {
        if (this.p.isChunked()) {
            DownloadInfo downloadInfo = this.p;
            downloadInfo.setTotalBytes(downloadInfo.getCurBytes());
        }
        String str = a;
        com.ss.android.socialbase.downloader.c.a.c(str, "checkCompletedByteValid: downloadInfo.getCurBytes() = " + this.p.getCurBytes() + ",  downloadInfo.getTotalBytes() = " + this.p.getTotalBytes());
        if (this.p.getCurBytes() > 0) {
            if (!this.p.isIgnoreDataVerify()) {
                if (this.p.getTotalBytes() > 0 && this.p.getCurBytes() == this.p.getTotalBytes()) {
                    return true;
                }
            } else {
                return true;
            }
        }
        this.p.setByteInvalidRetryStatus(com.ss.android.socialbase.downloader.constants.b.BYTE_INVALID_RETRY_STATUS_RESTART);
        this.p.reset();
        this.o.a(this.p);
        this.o.d(this.p.getId());
        this.o.m(this.p.getId());
        com.ss.android.socialbase.downloader.i.f.a(this.p);
        return false;
    }

    private void E() throws com.ss.android.socialbase.downloader.exception.f {
        if (this.p.isOnlyWifi() && !com.ss.android.socialbase.downloader.i.f.a(com.ss.android.socialbase.downloader.downloader.c.N(), "android.permission.ACCESS_NETWORK_STATE")) {
            throw new com.ss.android.socialbase.downloader.exception.f(1019, String.format("download task need permission:%s", "android.permission.ACCESS_NETWORK_STATE"));
        }
        if (this.p.isDownloadWithWifiValid()) {
            if (this.p.isPauseReserveWithWifiValid()) {
                return;
            }
            throw new com.ss.android.socialbase.downloader.exception.e();
        }
        throw new com.ss.android.socialbase.downloader.exception.c();
    }

    private void I() {
        try {
            Iterator it = ((ArrayList) this.f.clone()).iterator();
            while (it.hasNext()) {
                b bVar = (b) it.next();
                if (bVar != null) {
                    bVar.b();
                }
            }
        } catch (Throwable th) {
            String str = a;
            com.ss.android.socialbase.downloader.c.a.c(str, "cancelAllChunkRunnable: " + th.toString());
        }
    }

    private boolean i() {
        int status = this.p.getStatus();
        if (status == 1 || this.p.canSkipStatusHandler()) {
            return true;
        }
        if (status != -2 && status != -4) {
            b(new BaseException(1000, "The download Task can't start, because its status is not prepare:" + status));
            return false;
        }
        return false;
    }

    private void m() {
        com.ss.android.socialbase.downloader.c.a.b(a, "finishWithFileExist");
        if (com.ss.android.socialbase.downloader.g.a.c().b("fix_end_for_file_exist_error", true)) {
            if (this.E.equals(this.p.getName())) {
                this.n = com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_END_RIGHT_NOW;
            } else {
                this.n = com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_END_FOR_FILE_EXIST;
            }
        } else if (this.E.equals(this.p.getTargetFilePath())) {
            this.n = com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_END_RIGHT_NOW;
        } else {
            this.n = com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_END_FOR_FILE_EXIST;
        }
    }

    private void o() {
        int retryCount;
        if (com.ss.android.socialbase.downloader.g.a.a(this.p.getId()).a("reset_retain_retry_times", 0) == 1 && this.J < 3) {
            AtomicInteger atomicInteger = this.e;
            if (this.p.isBackUpUrlUsed()) {
                retryCount = this.p.getBackUpUrlRetryCount();
            } else {
                retryCount = this.p.getRetryCount();
            }
            atomicInteger.set(retryCount);
            this.J++;
        }
    }

    private boolean v() {
        if (!u() && this.p.getStatus() != -2) {
            return false;
        }
        if (!u()) {
            if (this.p.getStatus() == -2) {
                this.n = com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_PAUSE;
                return true;
            } else if (this.p.getStatus() == -4) {
                this.n = com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_CANCELED;
                return true;
            } else {
                return true;
            }
        }
        return true;
    }

    private void F() throws BaseException {
        if (!TextUtils.isEmpty(this.p.getSavePath())) {
            if (!TextUtils.isEmpty(this.p.getName())) {
                File file = new File(this.p.getSavePath());
                if (!file.exists()) {
                    boolean mkdirs = file.mkdirs();
                    if (!mkdirs && !file.exists()) {
                        int i = 0;
                        if (com.ss.android.socialbase.downloader.g.a.a(this.p.getId()).a("opt_mkdir_failed", 0) == 1) {
                            while (!mkdirs) {
                                int i2 = i + 1;
                                if (i >= 3) {
                                    break;
                                }
                                try {
                                    Thread.sleep(10L);
                                    mkdirs = file.mkdirs();
                                    i = i2;
                                } catch (InterruptedException unused) {
                                }
                            }
                            if (!mkdirs && !file.exists()) {
                                if (com.ss.android.socialbase.downloader.i.f.d(this.p.getSavePath()) < 16384) {
                                    throw new BaseException(1006, "download savePath directory can not created:" + this.p.getSavePath());
                                }
                                throw new BaseException(1030, "download savePath directory can not created:" + this.p.getSavePath());
                            }
                            return;
                        }
                        throw new BaseException(1030, "download savePath directory can not created:" + this.p.getSavePath());
                    }
                    return;
                } else if (!file.isDirectory()) {
                    if (com.ss.android.socialbase.downloader.i.d.b(this.p)) {
                        file.delete();
                        if (!file.mkdirs() && !file.exists()) {
                            throw new BaseException((int) ARPMessageType.MSG_TYPE_VIDEO_PLAY_INFO_UPDATE, "download savePath is not directory:path=" + this.p.getSavePath());
                        }
                        return;
                    }
                    throw new BaseException((int) ARPMessageType.MSG_TYPE_VIDEO_PLAY_INFO_UPDATE, "download savePath is not a directory:" + this.p.getSavePath());
                } else {
                    return;
                }
            }
            throw new BaseException(1029, "download name can not be empty");
        }
        throw new BaseException(1028, "download savePath can not be empty");
    }

    private void G() {
        boolean z;
        long f = com.ss.android.socialbase.downloader.i.f.f(this.p);
        long curBytes = this.p.getCurBytes();
        if (f != curBytes) {
            String str = a;
            com.ss.android.socialbase.downloader.c.a.d(str, "checkTaskCanResume: offset = " + f + ", curBytes = " + curBytes);
        }
        this.p.setCurBytes(f);
        if (f > 0) {
            z = true;
        } else {
            z = false;
        }
        this.i = z;
        if (!z && !this.F) {
            com.ss.android.socialbase.downloader.c.a.c(a, "checkTaskCanResume: deleteAllDownloadFiles");
            this.o.d(this.p.getId());
            this.o.m(this.p.getId());
            com.ss.android.socialbase.downloader.i.f.a(this.p);
        }
    }

    private boolean n() throws BaseException, InterruptedException {
        if (this.p.isExpiredRedownload() || this.p.getChunkCount() != 1 || this.p.getThrottleNetSpeed() > 0) {
            return false;
        }
        JSONObject d = com.ss.android.socialbase.downloader.g.a.a(this.p.getId()).d("segment_config");
        List<com.ss.android.socialbase.downloader.f.i> n = this.o.n(this.p.getId());
        if (this.p.getCurBytes() > 0) {
            if (n == null || n.isEmpty()) {
                return false;
            }
            if (d == null) {
                d = new JSONObject();
            }
        }
        if (d == null) {
            return false;
        }
        this.K = new k(this.p, n.a(d), this);
        if (v()) {
            com.ss.android.socialbase.downloader.c.a.c(a, "downloadSegments: is stopped by user");
            if (this.n == com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_CANCELED) {
                this.K.a();
            } else {
                this.K.b();
            }
            return true;
        }
        return this.K.a(n);
    }

    private void p() {
        boolean z;
        boolean z2;
        boolean z3;
        String str = a;
        com.ss.android.socialbase.downloader.c.a.b(str, "endDownloadRunnable::runStatus=" + this.n);
        int i = 0;
        if (this.n != com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_PAUSE && this.n != com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_CANCELED) {
            z = true;
        } else {
            z = false;
        }
        try {
            z2 = w();
            z3 = false;
        } catch (Exception e) {
            if (e instanceof BaseException) {
                this.v.a((BaseException) e);
            } else {
                this.v.a(new BaseException(1046, e));
            }
            z2 = true;
            z3 = true;
        }
        if (!z2 && !z3) {
            this.C = true;
            com.ss.android.socialbase.downloader.c.a.b(a, "jump to restart");
            return;
        }
        this.m.set(false);
        if (z) {
            try {
                com.ss.android.socialbase.downloader.impls.a C = com.ss.android.socialbase.downloader.downloader.c.C();
                if (C != null) {
                    C.a(this);
                }
            } catch (Throwable th) {
                th.printStackTrace();
                x monitorDepend = this.c.getMonitorDepend();
                DownloadInfo downloadInfo = this.p;
                BaseException baseException = new BaseException(1014, com.ss.android.socialbase.downloader.i.f.b(th, "removeDownloadRunnable"));
                DownloadInfo downloadInfo2 = this.p;
                if (downloadInfo2 != null) {
                    i = downloadInfo2.getStatus();
                }
                com.ss.android.socialbase.downloader.d.a.a(monitorDepend, downloadInfo, baseException, i);
            }
        }
    }

    private void H() {
        String str = a;
        com.ss.android.socialbase.downloader.c.a.d(str, "clearCurrentDownloadData::" + Log.getStackTraceString(new Throwable()));
        try {
            this.o.d(this.p.getId());
            this.o.m(this.p.getId());
            com.ss.android.socialbase.downloader.i.f.a(this.p);
            this.i = false;
            this.p.resetDataForEtagEndure("");
            this.o.a(this.p);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean x() {
        if (this.p.getChunkCount() <= 1) {
            if (this.p.getCurBytes() <= 0 || this.p.getCurBytes() != this.p.getTotalBytes()) {
                return false;
            }
            return true;
        }
        List<com.ss.android.socialbase.downloader.model.b> c = this.o.c(this.p.getId());
        if (c == null || c.size() <= 1) {
            return false;
        }
        for (com.ss.android.socialbase.downloader.model.b bVar : c) {
            if (bVar == null || !bVar.i()) {
                return false;
            }
            while (r0.hasNext()) {
            }
        }
        return true;
    }

    public void a() {
        this.n = com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_PAUSE;
        if (this.K != null) {
            this.K.b();
        }
        if (this.g != null) {
            this.g.b();
        }
        if (this.K == null && this.g == null) {
            s();
            this.n = com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_PAUSE;
            p();
        }
        try {
            Iterator it = ((ArrayList) this.f.clone()).iterator();
            while (it.hasNext()) {
                b bVar = (b) it.next();
                if (bVar != null) {
                    bVar.a();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private s a(DownloadTask downloadTask) {
        s retryDelayTimeCalculator = downloadTask.getRetryDelayTimeCalculator();
        if (retryDelayTimeCalculator != null) {
            return retryDelayTimeCalculator;
        }
        DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
        if (downloadInfo != null) {
            String retryDelayTimeArray = downloadInfo.getRetryDelayTimeArray();
            if (!TextUtils.isEmpty(retryDelayTimeArray)) {
                return new q(retryDelayTimeArray);
            }
        }
        return com.ss.android.socialbase.downloader.downloader.c.L();
    }

    @Override // com.ss.android.socialbase.downloader.h.f
    public void b(BaseException baseException) {
        String str = a;
        com.ss.android.socialbase.downloader.c.a.b(str, "onError:" + baseException.getMessage());
        this.n = com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_ERROR;
        this.w = baseException;
        I();
    }

    public void c(long j) {
        i iVar = this.x;
        if (iVar != null && (iVar instanceof com.ss.android.socialbase.downloader.network.a)) {
            try {
                ((com.ss.android.socialbase.downloader.network.a) iVar).a(j);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static com.ss.android.socialbase.downloader.model.b a(DownloadInfo downloadInfo, long j) {
        return new b.a(downloadInfo.getId()).a(-1).a(0L).e(j).b(j).c(0L).d(downloadInfo.getTotalBytes() - j).a();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x006c, code lost:
        if (r9.f() != false) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private com.ss.android.socialbase.downloader.model.b a(com.ss.android.socialbase.downloader.model.b bVar, int i) {
        com.ss.android.socialbase.downloader.model.b bVar2 = null;
        if (!bVar.d()) {
            return null;
        }
        long c = bVar.c(true);
        String str = a;
        com.ss.android.socialbase.downloader.c.a.b(str, "reuseChunk retainLen:" + c + " chunkIndex:" + i);
        boolean z = false;
        if (!bVar.f() && c > com.ss.android.socialbase.downloader.constants.e.f && this.p.isNeedReuseChunkRunnable()) {
            List<com.ss.android.socialbase.downloader.model.b> a2 = bVar.a(this.p.getChunkCount(), this.p.getTotalBytes());
            if (a2 != null) {
                for (com.ss.android.socialbase.downloader.model.b bVar3 : a2) {
                    this.o.b(bVar3);
                }
            }
        }
        z = true;
        if (z && bVar.f()) {
            for (int i2 = 1; i2 < bVar.g().size(); i2++) {
                com.ss.android.socialbase.downloader.model.b bVar4 = bVar.g().get(i2);
                if (bVar4 != null) {
                    String str2 = a;
                    com.ss.android.socialbase.downloader.c.a.b(str2, "check can checkUnCompletedChunk -- chunkIndex:" + bVar4.s() + " currentOffset:" + bVar4.n() + "  startOffset:" + bVar4.l() + " contentLen:" + bVar4.q());
                    if (bVar4.s() < 0 || (!bVar4.i() && !bVar4.c())) {
                        bVar2 = bVar4;
                        break;
                    }
                }
            }
            if (bVar2 != null) {
                long n = bVar.n();
                String str3 = a;
                com.ss.android.socialbase.downloader.c.a.b(str3, "unComplete chunk " + bVar.s() + " curOffset:" + n + " reuseChunk chunkIndex:" + i + " for subChunk:" + bVar2.s());
                this.o.a(bVar2.k(), bVar2.s(), bVar2.b(), i);
                bVar2.c(i);
                bVar2.a(true);
            }
        }
        return bVar2;
    }

    private List<com.ss.android.socialbase.downloader.model.c> a(com.ss.android.socialbase.downloader.model.b bVar) {
        List<com.ss.android.socialbase.downloader.model.c> a2 = com.ss.android.socialbase.downloader.i.f.a(this.p.getExtraHeaders(), this.p.geteTag(), bVar);
        if (this.p.isExpiredRedownload() && this.F && this.p.getLastModified() != null) {
            a2.add(new com.ss.android.socialbase.downloader.model.c("if-modified-since", this.p.getLastModified()));
            a2.add(new com.ss.android.socialbase.downloader.model.c("download-tc21-1-15", "download-tc21-1-15"));
            String str = a;
            com.ss.android.socialbase.downloader.c.a.b(str, "dcache::add head IF_MODIFIED_SINCE=" + this.p.getLastModified());
        }
        return a2;
    }

    private void a(int i, List<com.ss.android.socialbase.downloader.model.b> list) throws BaseException {
        if (list.size() == i) {
            a(list, this.p.getTotalBytes());
            return;
        }
        throw new BaseException((int) DebugConstants.HTTP_ERRCODE_VERSION_HIGH, new IllegalArgumentException());
    }

    private void a(long j, int i) throws BaseException {
        long j2;
        long j3 = j / i;
        int id = this.p.getId();
        ArrayList arrayList = new ArrayList();
        long j4 = 0;
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 == i - 1) {
                j2 = 0;
            } else {
                j2 = (j4 + j3) - 1;
            }
            com.ss.android.socialbase.downloader.model.b a2 = new b.a(id).a(i2).a(j4).e(j4).b(j4).c(j2).a();
            arrayList.add(a2);
            this.o.a(a2);
            j4 += j3;
        }
        this.p.setChunkCount(i);
        this.o.a(id, i);
        a(arrayList, j);
    }

    @Override // com.ss.android.socialbase.downloader.h.f
    public boolean b(long j) throws BaseException {
        if (this.G > 0 && this.p.getCurBytes() > this.G) {
            D();
        }
        return this.v.a(j);
    }

    @Override // com.ss.android.socialbase.downloader.h.f
    public void c(BaseException baseException) {
        DownloadInfo downloadInfo = this.p;
        if (downloadInfo != null) {
            downloadInfo.setChunkDowngradeRetryUsed(true);
        }
        a(baseException, false);
    }

    private void a(com.ss.android.socialbase.downloader.model.b bVar, String str, i iVar) throws BaseException {
        bVar.a(this.p.getTotalBytes() - bVar.n());
        this.p.setChunkCount(1);
        this.o.a(this.p.getId(), 1);
        this.g = new com.ss.android.socialbase.downloader.downloader.e(this.p, str, iVar, bVar, this);
        t();
    }

    private void a(String str, String str2) throws com.ss.android.socialbase.downloader.exception.i {
        this.o.d(this.p.getId());
        this.o.m(this.p.getId());
        com.ss.android.socialbase.downloader.i.f.a(this.p);
        this.i = false;
        this.p.resetDataForEtagEndure(str);
        this.o.a(this.p);
        throw new com.ss.android.socialbase.downloader.exception.i(str2);
    }

    private void a(String str, List<com.ss.android.socialbase.downloader.model.c> list) throws BaseException, com.ss.android.socialbase.downloader.exception.i {
        i iVar;
        boolean z;
        if (this.x != null) {
            return;
        }
        com.ss.android.socialbase.downloader.network.a.d dVar = null;
        if (this.p.getChunkCount() == 1) {
            dVar = com.ss.android.socialbase.downloader.network.a.a.a().b(str, list);
        }
        try {
            if (dVar != null) {
                a(this.x);
                this.p.setPreconnectLevel(2);
                this.x = dVar;
            } else {
                try {
                    boolean isNeedDefaultHttpServiceBackUp = this.p.isNeedDefaultHttpServiceBackUp();
                    int maxBytes = this.p.getMaxBytes();
                    int b = this.I.b("net_lib_strategy");
                    if (this.I.a("monitor_download_connect", 0) > 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    iVar = com.ss.android.socialbase.downloader.downloader.c.a(isNeedDefaultHttpServiceBackUp, maxBytes, str, null, list, b, z, this.p);
                    this.x = iVar;
                } catch (BaseException e) {
                    throw e;
                } catch (Throwable th) {
                    if (this.p.isExpiredRedownload() && com.ss.android.socialbase.downloader.i.f.g(th) && com.ss.android.socialbase.downloader.i.f.c(list)) {
                        com.ss.android.socialbase.downloader.c.a.b(a, "dcache=execepiton responseCode=304 lastModified not changed, use local file.. old cacheControl=" + this.p.getCacheControl());
                        long i = com.ss.android.socialbase.downloader.i.f.i(this.p.getCacheControl());
                        if (i <= 0) {
                            i = com.ss.android.socialbase.downloader.g.a.a(this.p.getId()).a("default_304_max_age", 300);
                        }
                        this.p.setCacheExpiredTime(System.currentTimeMillis() + (i * 1000));
                        throw new com.ss.android.socialbase.downloader.exception.a(this.E);
                    }
                    if (com.ss.android.socialbase.downloader.i.f.f(th)) {
                        a("", "http code 416");
                    } else if (com.ss.android.socialbase.downloader.i.f.e(th)) {
                        a("", "http code 412");
                    } else {
                        com.ss.android.socialbase.downloader.i.f.a(th, "CreateFirstConnection");
                    }
                    iVar = this.x;
                }
                a(iVar);
            }
            if (this.x != null) {
                return;
            }
            throw new BaseException(1022, new IOException("download can't continue, firstConnection is null"));
        } catch (Throwable th2) {
            a(this.x);
            throw th2;
        }
    }

    private void a(String str, List<com.ss.android.socialbase.downloader.model.c> list, long j) throws BaseException, com.ss.android.socialbase.downloader.exception.i {
        b(str, list, j);
        com.ss.android.socialbase.downloader.network.g gVar = this.y;
        if (gVar != null) {
            try {
                a(str, gVar, j);
            } catch (Throwable unused) {
                this.D = true;
            }
        }
        if (this.y == null || this.D) {
            a(str, list);
            a(str, this.x, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<String> list) {
        boolean z;
        if (list != null && !list.isEmpty()) {
            DownloadInfo downloadInfo = this.p;
            if (this.n == com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_WAITING_ASYNC_HANDLER) {
                z = true;
            } else {
                z = false;
            }
            downloadInfo.setForbiddenBackupUrls(list, z);
            com.ss.android.socialbase.downloader.impls.a C = com.ss.android.socialbase.downloader.downloader.c.C();
            if (C != null) {
                C.l(this.p.getId());
            }
        }
    }

    private void a(List<com.ss.android.socialbase.downloader.model.b> list, long j) throws BaseException {
        long p;
        for (com.ss.android.socialbase.downloader.model.b bVar : list) {
            if (bVar != null) {
                if (bVar.p() == 0) {
                    p = j - bVar.n();
                } else {
                    p = (bVar.p() - bVar.n()) + 1;
                }
                if (p > 0) {
                    bVar.a(p);
                    if (this.p.isNeedReuseFirstConnection() && this.x != null && (!this.p.isHeadConnectionAvailable() || this.D)) {
                        if (bVar.s() == 0) {
                            this.f.add(new b(bVar, this.c, this.x, this));
                        } else if (bVar.s() > 0) {
                            this.f.add(new b(bVar, this.c, this));
                        }
                    } else {
                        this.f.add(new b(bVar, this.c, this));
                    }
                }
            }
        }
        if (com.ss.android.socialbase.downloader.i.a.a(64)) {
            ArrayList arrayList = new ArrayList(this.f.size());
            Iterator<b> it = this.f.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (this.n == com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_CANCELED) {
                    next.b();
                } else if (this.n == com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_PAUSE) {
                    next.a();
                } else {
                    arrayList.add(next);
                }
            }
            try {
                List<Future> d = com.ss.android.socialbase.downloader.impls.e.d(arrayList);
                for (Runnable runnable = (Runnable) arrayList.remove(0); runnable != null; runnable = com.ss.android.socialbase.downloader.impls.e.e(d)) {
                    if (v()) {
                        return;
                    }
                    runnable.run();
                }
                if (d != null && !d.isEmpty()) {
                    for (Future future : d) {
                        if (future != null && !future.isDone()) {
                            try {
                                future.get();
                            } catch (Throwable unused) {
                            }
                        }
                    }
                    return;
                }
                return;
            } catch (Throwable unused2) {
                return;
            }
        }
        ArrayList arrayList2 = new ArrayList(this.f.size());
        Iterator<b> it2 = this.f.iterator();
        while (it2.hasNext()) {
            b next2 = it2.next();
            if (this.n == com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_CANCELED) {
                next2.b();
            } else if (this.n == com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_PAUSE) {
                next2.a();
            } else {
                arrayList2.add(Executors.callable(next2));
            }
        }
        if (v()) {
            return;
        }
        try {
            com.ss.android.socialbase.downloader.impls.e.c(arrayList2);
        } catch (InterruptedException e) {
            throw new BaseException(1020, e);
        }
    }

    private boolean a(int i, String str, String str2) {
        if (i == 412) {
            return true;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !str.equals(str2) && (this.k || this.j)) {
            return true;
        }
        if ((i == 201 || i == 416) && this.p.getCurBytes() > 0) {
            return true;
        }
        return false;
    }

    private void b(String str, List<com.ss.android.socialbase.downloader.model.c> list, long j) throws BaseException, com.ss.android.socialbase.downloader.exception.i {
        com.ss.android.socialbase.downloader.network.a.c a2;
        boolean z = true;
        if (this.p.getChunkCount() == 1 && (a2 = com.ss.android.socialbase.downloader.network.a.a.a().a(str, list)) != null) {
            this.y = a2;
            this.p.setPreconnectLevel(1);
        }
        if (this.y == null && !this.D && this.p.isHeadConnectionAvailable()) {
            try {
                int b = this.I.b("net_lib_strategy");
                if (this.I.a("monitor_download_connect", 0) <= 0) {
                    z = false;
                }
                this.y = com.ss.android.socialbase.downloader.downloader.c.a(str, list, b, z, this.p);
            } catch (Throwable th) {
                this.p.setHeadConnectionException(com.ss.android.socialbase.downloader.i.f.j(th));
            }
        }
    }

    private boolean d(BaseException baseException) {
        AtomicInteger atomicInteger = this.e;
        boolean z = true;
        if (atomicInteger != null) {
            if (atomicInteger.get() <= 0 || (baseException != null && baseException.getErrorCode() == 1070)) {
                if (this.p.trySwitchToNextBackupUrl()) {
                    this.e.set(this.p.getBackUpUrlRetryCount());
                    this.p.updateCurRetryTime(this.e.get());
                } else if (baseException != null && ((baseException.getErrorCode() == 1011 || (baseException.getCause() != null && (baseException.getCause() instanceof SSLHandshakeException))) && this.p.canReplaceHttpForRetry())) {
                    this.e.set(this.p.getRetryCount());
                    this.p.updateCurRetryTime(this.e.get());
                    this.p.setHttpsToHttpRetryUsed(true);
                } else {
                    b(new BaseException(baseException.getErrorCode(), String.format("retry for exception, but current retry time : %s , retry Time %s all used, last error is %s", String.valueOf(this.e), String.valueOf(this.p.getRetryCount()), baseException.getErrorMessage())));
                    return true;
                }
                z = false;
            }
            if (this.n != com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_RETRY_DELAY && z) {
                this.p.updateCurRetryTime(this.e.decrementAndGet());
            }
            return false;
        }
        b(new BaseException(1043, "retry for exception, but retain retry time is null, last error is :" + baseException.getErrorMessage()));
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:78:0x00f5, code lost:
        if (r9.I.a("fix_file_exist_update_download_info") != false) goto L80;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00ab A[Catch: all -> 0x00ea, TryCatch #7 {all -> 0x00ea, blocks: (B:56:0x00a7, B:58:0x00ab, B:60:0x00af, B:73:0x00e9), top: B:86:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00cf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void j() throws com.ss.android.socialbase.downloader.exception.a {
        Throwable th;
        com.ss.android.socialbase.downloader.exception.a e;
        boolean z;
        boolean z2 = false;
        boolean z3 = true;
        try {
            try {
                try {
                    int id = this.p.getId();
                    if (this.o != null) {
                        if (com.ss.android.socialbase.downloader.i.a.a(2048)) {
                            this.o.e();
                        }
                        DownloadInfo b = this.o.b(id);
                        if (b != null && !b.isNewTask()) {
                            String savePath = this.p.getSavePath();
                            String md5 = this.p.getMd5();
                            this.p.copyFromCacheData(b, true);
                            if (com.ss.android.socialbase.downloader.i.a.a(4096) && b != this.p) {
                                z = true;
                            } else {
                                z = false;
                            }
                            try {
                                if (savePath.equals(b.getSavePath()) && com.ss.android.socialbase.downloader.i.f.a(b, false, md5)) {
                                    try {
                                        throw new com.ss.android.socialbase.downloader.exception.a(b.getName());
                                    } catch (com.ss.android.socialbase.downloader.exception.a e2) {
                                        throw e2;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        z2 = z;
                                        if (this.c != null) {
                                        }
                                        if (z2) {
                                        }
                                    }
                                } else if (com.ss.android.socialbase.downloader.downloader.c.a(b) != id) {
                                    try {
                                        this.o.f(id);
                                    } catch (SQLiteException e3) {
                                        e3.printStackTrace();
                                    }
                                } else {
                                    z3 = z;
                                }
                            } catch (com.ss.android.socialbase.downloader.exception.a e4) {
                                e = e4;
                                throw e;
                            } catch (Throwable th3) {
                                th = th3;
                                z2 = z;
                                z3 = false;
                                if (this.c != null) {
                                    com.ss.android.socialbase.downloader.d.a.a(this.c.getMonitorDepend(), this.p, new BaseException(1003, com.ss.android.socialbase.downloader.i.f.b(th, "checkTaskCache")), this.p.getStatus());
                                }
                                if (z2) {
                                }
                            }
                        }
                        this.p.reset();
                    } else {
                        z3 = false;
                    }
                    try {
                        h();
                    } catch (com.ss.android.socialbase.downloader.exception.a e5) {
                        e = e5;
                        throw e;
                    } catch (Throwable th4) {
                        th = th4;
                        z2 = z3;
                        z3 = false;
                        if (this.c != null && this.p != null) {
                            com.ss.android.socialbase.downloader.d.a.a(this.c.getMonitorDepend(), this.p, new BaseException(1003, com.ss.android.socialbase.downloader.i.f.b(th, "checkTaskCache")), this.p.getStatus());
                        }
                        if (z2) {
                            if (!z3 || this.I.a("fix_file_exist_update_download_info")) {
                                this.o.a(this.p);
                            }
                        }
                        return;
                    }
                } catch (Throwable th5) {
                    if (0 != 0) {
                        if (1 != 0) {
                            try {
                            } catch (SQLiteException e6) {
                                e6.printStackTrace();
                            }
                        }
                        this.o.a(this.p);
                    }
                    throw th5;
                }
            } catch (com.ss.android.socialbase.downloader.exception.a e7) {
                e = e7;
            } catch (Throwable th6) {
                th = th6;
            }
            if (z3) {
                this.o.a(this.p);
            }
        } catch (SQLiteException e8) {
            e8.printStackTrace();
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[MOVE_EXCEPTION, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005a A[LOOP:0: B:24:0x005a->B:55:0x005a, LOOP_START] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void k() {
        int i;
        Process.setThreadPriority(10);
        try {
            if (this.p != null && this.H > 0) {
                this.p.increaseDownloadPrepareTime(System.currentTimeMillis() - this.H);
            }
        } catch (Throwable unused) {
        }
        try {
            IDownloadInterceptor interceptor = this.c.getInterceptor();
            if (interceptor != null) {
                if (interceptor.intercepte()) {
                    this.v.e();
                    return;
                }
            }
        } finally {
            if (i()) {
            }
        }
        if (i()) {
            x monitorDepend = this.c.getMonitorDepend();
            DownloadInfo downloadInfo = this.p;
            BaseException baseException = new BaseException(1003, "task status is invalid");
            DownloadInfo downloadInfo2 = this.p;
            if (downloadInfo2 != null) {
                i = downloadInfo2.getStatus();
            } else {
                i = 0;
            }
            com.ss.android.socialbase.downloader.d.a.a(monitorDepend, downloadInfo, baseException, i);
            return;
        }
        while (true) {
            l();
            if (this.C) {
                if (this.B > 0) {
                    this.B--;
                } else if (this.p.getCurBytes() != this.p.getTotalBytes()) {
                    com.ss.android.socialbase.downloader.c.a.b(a, this.p.getErrorBytesLog());
                    this.v.a(new com.ss.android.socialbase.downloader.exception.f(1027, "current bytes is not equals to total bytes, bytes invalid retry status is : " + this.p.getByteInvalidRetryStatus()));
                    return;
                } else if (this.p.getCurBytes() <= 0) {
                    com.ss.android.socialbase.downloader.c.a.b(a, this.p.getErrorBytesLog());
                    this.v.a(new com.ss.android.socialbase.downloader.exception.f(1026, "curBytes is 0, bytes invalid retry status is : " + this.p.getByteInvalidRetryStatus()));
                    return;
                } else if (this.p.getTotalBytes() <= 0) {
                    com.ss.android.socialbase.downloader.c.a.b(a, this.p.getErrorBytesLog());
                    this.v.a(new com.ss.android.socialbase.downloader.exception.f(1044, "TotalBytes is 0, bytes invalid retry status is : " + this.p.getByteInvalidRetryStatus()));
                    return;
                }
            } else {
                return;
            }
        }
    }

    private void l() {
        boolean z;
        List<com.ss.android.socialbase.downloader.model.b> c;
        long j;
        boolean z2;
        try {
            this.n = com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_NONE;
            this.p.updateStartDownloadTime();
            this.p.resetRealStartDownloadTime();
            long currentTimeMillis = System.currentTimeMillis();
            this.p.setFirstSpeedTime(-1L);
            try {
                j();
                z = false;
            } catch (com.ss.android.socialbase.downloader.exception.a e) {
                String str = a;
                com.ss.android.socialbase.downloader.c.a.b(str, "file exist " + e.a());
                this.E = e.a();
                z = true;
            }
            if (!this.C) {
                this.v.b();
            }
            this.C = false;
            if (v()) {
                return;
            }
            if (!TextUtils.isEmpty(this.E) && z) {
                if (this.p.isExpiredRedownload()) {
                    this.F = com.ss.android.socialbase.downloader.i.f.d(this.p);
                }
                if (!this.F) {
                    m();
                    return;
                }
            }
            while (!v()) {
                try {
                    try {
                        try {
                            F();
                            B();
                            E();
                            c = this.o.c(this.p.getId());
                            G();
                        } catch (com.ss.android.socialbase.downloader.exception.a unused) {
                            m();
                        }
                    } catch (BaseException e2) {
                        String str2 = a;
                        com.ss.android.socialbase.downloader.c.a.d(str2, "downloadInner: baseException = " + e2);
                        if (this.n != com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_PAUSE) {
                            if (e2.getErrorCode() != 1025 && e2.getErrorCode() != 1009) {
                                if (a(e2)) {
                                    if (com.ss.android.socialbase.downloader.i.f.a(e2)) {
                                        H();
                                    }
                                    if (a(e2, 0L) != com.ss.android.socialbase.downloader.exception.h.RETURN) {
                                        s();
                                    } else {
                                        s();
                                        return;
                                    }
                                } else {
                                    b(e2);
                                }
                            }
                            this.n = com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_END_RIGHT_NOW;
                            s();
                            return;
                        }
                    }
                } catch (com.ss.android.socialbase.downloader.exception.i e3) {
                    String str3 = a;
                    com.ss.android.socialbase.downloader.c.a.d(str3, "downloadInner: retry throwable for " + e3.a());
                    if (this.n != com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_PAUSE) {
                        if (this.e != null && this.e.get() > 0) {
                            this.p.updateCurRetryTime(this.e.decrementAndGet());
                            this.p.setStatus(5);
                        } else if (this.e != null) {
                            if (this.p.trySwitchToNextBackupUrl()) {
                                this.p.setStatus(5);
                                this.e.set(this.p.getRetryCount());
                                this.p.updateCurRetryTime(this.e.get());
                            } else {
                                b(new BaseException(1018, String.format("retry for Throwable, but retry Time %s all used, last error is %s", String.valueOf(this.p.getRetryCount()), e3.a())));
                            }
                        } else {
                            b(new BaseException(1043, "retry for Throwable, but retain retry time is NULL, last error is" + e3.a()));
                        }
                        s();
                    }
                } catch (Throwable th) {
                    String str4 = a;
                    com.ss.android.socialbase.downloader.c.a.d(str4, "downloadInner: throwable =  " + th);
                    if (this.n != com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_PAUSE) {
                        b(new BaseException(1045, th));
                    }
                }
                if (n()) {
                    com.ss.android.socialbase.downloader.c.a.c(a, "downloadSegments return");
                    s();
                    return;
                }
                String connectionUrl = this.p.getConnectionUrl();
                if (v()) {
                    s();
                    return;
                }
                if (this.i) {
                    j = com.ss.android.socialbase.downloader.i.f.e(this.p);
                } else {
                    j = 0;
                }
                com.ss.android.socialbase.downloader.model.b a2 = a(this.p, j);
                List<com.ss.android.socialbase.downloader.model.c> a3 = a(a2);
                com.ss.android.socialbase.downloader.i.f.a(a3, this.p);
                com.ss.android.socialbase.downloader.i.f.b(a3, this.p);
                this.p.setPreconnectLevel(0);
                long currentTimeMillis2 = System.currentTimeMillis();
                try {
                    a(connectionUrl, a3, j);
                    this.p.increaseAllConnectTime(System.currentTimeMillis() - currentTimeMillis2);
                    if (v()) {
                        s();
                        return;
                    }
                    long totalBytes = this.p.getTotalBytes();
                    a(totalBytes);
                    int a4 = a(totalBytes, c);
                    if (v()) {
                        s();
                        return;
                    } else if (a4 > 0) {
                        if (a4 == 1) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        this.h = z2;
                        if (z2) {
                            if (this.x == null) {
                                try {
                                    currentTimeMillis2 = System.currentTimeMillis();
                                    a(connectionUrl, a3);
                                    this.p.increaseAllConnectTime(System.currentTimeMillis() - currentTimeMillis2);
                                } finally {
                                }
                            }
                            if (v()) {
                                s();
                                return;
                            }
                            this.p.setFirstSpeedTime(System.currentTimeMillis() - currentTimeMillis);
                            o();
                            a(a2, connectionUrl, this.x);
                        } else {
                            if (!this.p.isNeedReuseFirstConnection()) {
                                r();
                            }
                            if (v()) {
                                s();
                                return;
                            }
                            o();
                            this.p.setFirstSpeedTime(System.currentTimeMillis() - currentTimeMillis);
                            if (this.i) {
                                a(a4, c);
                            } else {
                                a(totalBytes, a4);
                            }
                        }
                        s();
                        return;
                    } else {
                        throw new BaseException((int) DebugConstants.HTTP_ERRCODE_NOT_FIND, "chunkCount is 0");
                    }
                } finally {
                }
            }
        } finally {
            p();
        }
    }

    @Override // com.ss.android.socialbase.downloader.h.f
    public com.ss.android.socialbase.downloader.exception.h a(BaseException baseException, long j) {
        long totalBytes;
        long j2;
        boolean z;
        this.w = baseException;
        this.p.increaseCurBytes(-j);
        this.o.a(this.p);
        if (u()) {
            return com.ss.android.socialbase.downloader.exception.h.RETURN;
        }
        boolean z2 = true;
        if (baseException != null && baseException.getErrorCode() == 1047) {
            if (this.z != null && !this.p.isForbiddenRetryed()) {
                com.ss.android.socialbase.downloader.depend.b bVar = new com.ss.android.socialbase.downloader.depend.b() { // from class: com.ss.android.socialbase.downloader.h.c.1
                    @Override // com.ss.android.socialbase.downloader.depend.b, com.ss.android.socialbase.downloader.depend.v
                    public void a(List<String> list) {
                        super.a(list);
                        c.this.a(list);
                    }
                };
                boolean a2 = this.z.a(bVar);
                this.p.setForbiddenRetryed();
                if (a2) {
                    if (!bVar.a()) {
                        I();
                        this.v.h();
                        this.n = com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_WAITING_ASYNC_HANDLER;
                        return com.ss.android.socialbase.downloader.exception.h.RETURN;
                    }
                    z = true;
                }
            } else if (d(baseException)) {
                return com.ss.android.socialbase.downloader.exception.h.RETURN;
            }
            z = false;
        } else if (com.ss.android.socialbase.downloader.i.f.h(baseException)) {
            if (this.A == null) {
                b(baseException);
                return com.ss.android.socialbase.downloader.exception.h.RETURN;
            }
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            com.ss.android.socialbase.downloader.depend.q qVar = new com.ss.android.socialbase.downloader.depend.q() { // from class: com.ss.android.socialbase.downloader.h.c.2
                @Override // com.ss.android.socialbase.downloader.depend.q
                public void a() {
                    synchronized (c.this) {
                        atomicBoolean.set(true);
                        c.this.J();
                    }
                }
            };
            if (baseException instanceof com.ss.android.socialbase.downloader.exception.d) {
                com.ss.android.socialbase.downloader.exception.d dVar = (com.ss.android.socialbase.downloader.exception.d) baseException;
                j2 = dVar.a();
                totalBytes = dVar.b();
            } else {
                totalBytes = this.p.getTotalBytes();
                j2 = -1;
            }
            synchronized (this) {
                if (this.A.a(j2, totalBytes, qVar)) {
                    if (!com.ss.android.socialbase.downloader.g.a.a(this.p.getId()).b("not_delete_when_clean_space", false)) {
                        y();
                    }
                    if (!atomicBoolean.get()) {
                        if (this.n != com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_WAITING_ASYNC_HANDLER) {
                            this.n = com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_WAITING_ASYNC_HANDLER;
                            I();
                            this.v.h();
                        }
                        return com.ss.android.socialbase.downloader.exception.h.RETURN;
                    }
                    if (d(baseException)) {
                        return com.ss.android.socialbase.downloader.exception.h.RETURN;
                    }
                    z = true;
                } else if (this.n == com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_WAITING_ASYNC_HANDLER) {
                    return com.ss.android.socialbase.downloader.exception.h.RETURN;
                } else {
                    b(baseException);
                    return com.ss.android.socialbase.downloader.exception.h.RETURN;
                }
            }
        } else {
            if (d(baseException)) {
                return com.ss.android.socialbase.downloader.exception.h.RETURN;
            }
            z = false;
        }
        if (!z && K()) {
            I();
        }
        com.ss.android.socialbase.downloader.downloader.f fVar = this.v;
        if (this.n != com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_RETRY_DELAY) {
            z2 = false;
        }
        fVar.a(baseException, z2);
        if (this.n == com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_RETRY_DELAY) {
            return com.ss.android.socialbase.downloader.exception.h.RETURN;
        }
        return com.ss.android.socialbase.downloader.exception.h.CONTINUE;
    }

    @Override // com.ss.android.socialbase.downloader.h.f
    public com.ss.android.socialbase.downloader.exception.h a(com.ss.android.socialbase.downloader.model.b bVar, BaseException baseException, long j) {
        boolean z;
        if (u()) {
            return com.ss.android.socialbase.downloader.exception.h.RETURN;
        }
        if (baseException != null && (baseException.getErrorCode() == 1047 || com.ss.android.socialbase.downloader.i.f.h(baseException))) {
            return a(baseException, j);
        }
        this.w = baseException;
        this.p.increaseCurBytes(-j);
        this.o.a(this.p);
        if (d(baseException)) {
            return com.ss.android.socialbase.downloader.exception.h.RETURN;
        }
        com.ss.android.socialbase.downloader.downloader.f fVar = this.v;
        if (this.n == com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_RETRY_DELAY) {
            z = true;
        } else {
            z = false;
        }
        fVar.a(bVar, baseException, z);
        if (this.n != com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_RETRY_DELAY && this.p.isNeedRetryDelay()) {
            long A = A();
            if (A > 0) {
                String str = a;
                com.ss.android.socialbase.downloader.c.a.c(str, "onSingleChunkRetry with delay time " + A);
                try {
                    Thread.sleep(A);
                } catch (Throwable th) {
                    String str2 = a;
                    com.ss.android.socialbase.downloader.c.a.d(str2, "onSingleChunkRetry:" + th.getMessage());
                }
            }
        }
        return com.ss.android.socialbase.downloader.exception.h.CONTINUE;
    }

    @Override // com.ss.android.socialbase.downloader.h.f
    public synchronized com.ss.android.socialbase.downloader.model.b a(int i) {
        com.ss.android.socialbase.downloader.model.b a2;
        if (this.p.getChunkCount() < 2) {
            return null;
        }
        List<com.ss.android.socialbase.downloader.model.b> c = this.o.c(this.p.getId());
        if (c != null && !c.isEmpty()) {
            for (int i2 = 0; i2 < c.size(); i2++) {
                com.ss.android.socialbase.downloader.model.b bVar = c.get(i2);
                if (bVar != null && (a2 = a(bVar, i)) != null) {
                    return a2;
                }
            }
            return null;
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.h.f
    public void a(long j) throws BaseException {
        String str;
        String str2;
        long j2;
        String tempPath = this.p.getTempPath();
        String tempName = this.p.getTempName();
        if (com.ss.android.socialbase.downloader.i.f.b(j)) {
            return;
        }
        com.ss.android.socialbase.downloader.model.e a2 = com.ss.android.socialbase.downloader.i.f.a(this.p, tempPath, tempName, -1);
        try {
            long length = new File(tempPath, tempName).length();
            long j3 = j - length;
            long d = com.ss.android.socialbase.downloader.i.f.d(tempPath);
            com.ss.android.socialbase.downloader.g.a a3 = com.ss.android.socialbase.downloader.g.a.a(this.p.getId());
            if (a3.a("space_fill_part_download", 0) == 1) {
                this.G = 0L;
                if (j3 <= 0) {
                    j3 = this.p.getTotalBytes() - this.p.getCurBytes();
                }
                if (d < j3) {
                    String str3 = a;
                    com.ss.android.socialbase.downloader.c.a.d(str3, "checkSpaceOverflow: contentLength = " + com.ss.android.socialbase.downloader.i.f.a(j) + "MB, downloaded = " + com.ss.android.socialbase.downloader.i.f.a(length) + "MB, required = " + com.ss.android.socialbase.downloader.i.f.a(j3) + "MB, available = " + com.ss.android.socialbase.downloader.i.f.a(d) + "MB");
                    int i = (d > 0L ? 1 : (d == 0L ? 0 : -1));
                    if (i > 0) {
                        int a4 = a3.a("space_fill_min_keep_mb", 100);
                        if (a4 > 0) {
                            j2 = d - (a4 * 1048576);
                            String str4 = a;
                            com.ss.android.socialbase.downloader.c.a.d(str4, "checkSpaceOverflow: minKeep = " + a4 + "MB, canDownload = " + com.ss.android.socialbase.downloader.i.f.a(j2) + "MB");
                            if (j2 > 0) {
                                this.G = this.p.getCurBytes() + j2;
                            } else {
                                throw new com.ss.android.socialbase.downloader.exception.d(d, j3);
                            }
                        } else {
                            j2 = d;
                        }
                        if (length < j) {
                            if (j2 + length > j) {
                            }
                            a2.b(j);
                            com.ss.android.socialbase.downloader.i.f.a(a2);
                        }
                    } else if (a3.a("download_when_space_negative", 0) != 1) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("availableSpace ");
                        if (i == 0) {
                            str2 = "=";
                        } else {
                            str2 = "<";
                        }
                        sb.append(str2);
                        sb.append(" 0");
                        throw new BaseException(1052, sb.toString());
                    } else {
                        a2.b(j);
                        com.ss.android.socialbase.downloader.i.f.a(a2);
                    }
                }
            } else {
                int i2 = (d > 0L ? 1 : (d == 0L ? 0 : -1));
                if (i2 <= 0) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("availableSpace ");
                    if (i2 == 0) {
                        str = "=";
                    } else {
                        str = "<";
                    }
                    sb2.append(str);
                    sb2.append(" 0");
                    throw new BaseException(1052, sb2.toString());
                } else if (d < j3) {
                    throw new com.ss.android.socialbase.downloader.exception.d(d, j3);
                }
            }
            a2.b(j);
            com.ss.android.socialbase.downloader.i.f.a(a2);
        } catch (Throwable th) {
            com.ss.android.socialbase.downloader.i.f.a(a2);
            throw th;
        }
    }

    @Override // com.ss.android.socialbase.downloader.h.f
    public void a(BaseException baseException, boolean z) {
        boolean z2;
        com.ss.android.socialbase.downloader.c.a.b(a, "onAllChunkRetryWithReset");
        this.n = com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_ALL_CHUNK_RETRY_WITH_RESET;
        this.w = baseException;
        I();
        if (z) {
            z2 = d(baseException);
        } else {
            z2 = false;
        }
        if (!z2) {
            H();
        }
    }

    @Override // com.ss.android.socialbase.downloader.h.f
    public void a(b bVar) {
        if (!this.h) {
            synchronized (this) {
                this.f.remove(bVar);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x001d  */
    @Override // com.ss.android.socialbase.downloader.h.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(com.ss.android.socialbase.downloader.network.g gVar) {
        boolean z;
        if (gVar != null) {
            try {
                int b = gVar.b();
                this.p.setHttpStatusCode(b);
                this.p.setHttpStatusMessage(com.ss.android.socialbase.downloader.i.b.a(b));
                z = true;
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (z) {
                this.p.setHttpStatusCode(-1);
                this.p.setHttpStatusMessage("");
                return;
            }
            return;
        }
        z = false;
        if (z) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x013b, code lost:
        com.ss.android.socialbase.downloader.i.f.a(r19.p);
     */
    @Override // com.ss.android.socialbase.downloader.h.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(String str, com.ss.android.socialbase.downloader.network.g gVar, long j) throws BaseException, com.ss.android.socialbase.downloader.exception.i {
        com.ss.android.socialbase.downloader.network.g gVar2;
        String str2;
        long j2;
        if (gVar == null) {
            return;
        }
        try {
            com.ss.android.socialbase.downloader.model.d dVar = new com.ss.android.socialbase.downloader.model.d(str, gVar);
            int i = dVar.c;
            String d = dVar.d();
            if (TextUtils.isEmpty(this.p.getMimeType()) && !TextUtils.isEmpty(d)) {
                this.p.setMimeType(d);
            }
            boolean b = dVar.b();
            this.j = b;
            this.p.setSupportPartial(b);
            this.k = dVar.a();
            String str3 = this.p.geteTag();
            String c = dVar.c();
            String f = dVar.f();
            String g = dVar.g();
            String str4 = a;
            StringBuilder sb = new StringBuilder();
            sb.append("dcache=responseCode=");
            sb.append(i);
            sb.append(" last_modified=");
            sb.append(f);
            sb.append(" CACHE_CONTROL=");
            sb.append(g);
            sb.append(" max-age=");
            String str5 = c;
            sb.append(dVar.k());
            sb.append(" isDeleteCacheIfCheckFailed=");
            sb.append(this.p.isDeleteCacheIfCheckFailed());
            com.ss.android.socialbase.downloader.c.a.b(str4, sb.toString());
            String str6 = a;
            com.ss.android.socialbase.downloader.c.a.b(str6, "dcache=firstOffset=" + j + " cur=" + f + " before=" + this.p.getLastModified() + " cur=" + dVar.j() + " before=" + this.p.getTotalBytes());
            if (!TextUtils.isEmpty(g)) {
                this.p.setCacheControl(g);
                if (dVar.k() > 0) {
                    this.p.setCacheExpiredTime(System.currentTimeMillis() + (dVar.k() * 1000));
                }
            }
            if (this.p.isExpiredRedownload() && this.F && !TextUtils.isEmpty(this.E)) {
                boolean z = false;
                if (i != 304) {
                    if ((!TextUtils.isEmpty(this.p.getLastModified()) || !this.p.isDeleteCacheIfCheckFailed()) && TextUtils.equals(f, this.p.getLastModified())) {
                    }
                    String str7 = a;
                    com.ss.android.socialbase.downloader.c.a.b(str7, "dcache=responseCode=" + i + " lastModified not changed, use local file  " + f);
                    throw new com.ss.android.socialbase.downloader.exception.a(this.E);
                }
                z = true;
                String str72 = a;
                com.ss.android.socialbase.downloader.c.a.b(str72, "dcache=responseCode=" + i + " lastModified not changed, use local file  " + f);
                throw new com.ss.android.socialbase.downloader.exception.a(this.E);
            }
            int i2 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i2 > 0 && this.p.isExpiredRedownload() && !TextUtils.equals(f, this.p.getLastModified())) {
                com.ss.android.socialbase.downloader.c.a.b(a, "dcache cdn file change, so retry");
                a("", "cdn file changed");
            }
            if (!TextUtils.isEmpty(f)) {
                this.p.setLastModified(f);
            }
            if (a(i, str3, str5)) {
                gVar2 = gVar;
                if (gVar2 instanceof i) {
                    if (!TextUtils.isEmpty(str3) && str3.equals(str5)) {
                        str5 = "";
                    }
                    a(str5, "eTag of server file changed");
                } else {
                    throw new com.ss.android.socialbase.downloader.exception.b(1002, i, "");
                }
            } else {
                gVar2 = gVar;
            }
            if (!this.j && !this.k) {
                if (i == 403) {
                    throw new BaseException(1047, "response code error : 403");
                }
                throw new com.ss.android.socialbase.downloader.exception.b(1004, i, "response code error : " + i);
            }
            if (this.k && i2 > 0) {
                if (gVar2 instanceof i) {
                    a("", "http head request not support");
                } else {
                    throw new BaseException(1004, "isResponseFromBegin but firstOffset > 0");
                }
            }
            long h = dVar.h();
            if (!(gVar2 instanceof i) && h < 0 && com.ss.android.socialbase.downloader.i.d.a(this.p)) {
                throw new BaseException(1004, "");
            }
            if (!TextUtils.isEmpty(this.p.getName())) {
                str2 = "";
            } else {
                str2 = com.ss.android.socialbase.downloader.i.f.a(gVar2, this.p.getUrl());
            }
            boolean i3 = dVar.i();
            this.l = i3;
            if (!i3 && h == 0 && !(gVar2 instanceof i)) {
                throw new BaseException(1004, "");
            }
            if (!this.l) {
                String b2 = com.ss.android.socialbase.downloader.i.f.b(gVar2, "Content-Range");
                String str8 = a;
                com.ss.android.socialbase.downloader.c.a.c(str8, "firstConnection: contentRange = " + b2);
                if (!TextUtils.isEmpty(b2) && this.I.b("fix_get_total_bytes", true)) {
                    j2 = com.ss.android.socialbase.downloader.i.f.b(b2);
                    String str9 = a;
                    com.ss.android.socialbase.downloader.c.a.c(str9, "firstConnection: 1 totalLength = " + j2);
                } else {
                    j2 = j + h;
                    String str10 = a;
                    com.ss.android.socialbase.downloader.c.a.e(str10, "firstConnection: 2 totalLength = " + j2 + ", contentLength = " + h);
                }
            } else {
                j2 = -1;
            }
            if (v()) {
                return;
            }
            if (this.p.getExpectFileLength() > 0 && com.ss.android.socialbase.downloader.g.a.a(this.p.getId()).b("force_check_file_length") == 1 && this.p.getExpectFileLength() != j2) {
                throw new BaseException(1070, "expectFileLength = " + this.p.getExpectFileLength() + " , totalLength = " + j2);
            }
            this.v.a(j2, str5, str2);
        } catch (BaseException e) {
            throw e;
        } catch (com.ss.android.socialbase.downloader.exception.i e2) {
            throw e2;
        } catch (Throwable th) {
            com.ss.android.socialbase.downloader.i.f.a(th, "HandleFirstConnection");
        }
    }

    public void a(Future future) {
        this.b = future;
    }

    @Override // com.ss.android.socialbase.downloader.h.f
    public boolean a(BaseException baseException) {
        if (this.K != null && com.ss.android.socialbase.downloader.i.f.i(baseException) && this.e.get() < this.p.getRetryCount()) {
            return false;
        }
        if (com.ss.android.socialbase.downloader.i.f.b(baseException)) {
            if (this.h && !this.d) {
                com.ss.android.socialbase.downloader.i.f.a(this.p);
                this.d = true;
            }
            return true;
        }
        AtomicInteger atomicInteger = this.e;
        if ((atomicInteger == null || atomicInteger.get() <= 0) && !this.p.hasNextBackupUrl()) {
            if (baseException == null) {
                return false;
            }
            if ((baseException.getErrorCode() != 1011 && (baseException.getCause() == null || !(baseException.getCause() instanceof SSLHandshakeException))) || !this.p.canReplaceHttpForRetry()) {
                return false;
            }
        }
        if (baseException instanceof com.ss.android.socialbase.downloader.exception.f) {
            return false;
        }
        return true;
    }
}
