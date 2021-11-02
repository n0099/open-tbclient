package com.ss.android.socialbase.downloader.h;

import android.database.sqlite.SQLiteException;
import android.os.Handler;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.ar.constants.DebugConstants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.mobads.container.util.SDKLogTypeConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.manager.DefaultConnectivityMonitorFactory;
import com.ss.android.socialbase.downloader.depend.IDownloadInterceptor;
import com.ss.android.socialbase.downloader.depend.q;
import com.ss.android.socialbase.downloader.depend.r;
import com.ss.android.socialbase.downloader.depend.w;
import com.ss.android.socialbase.downloader.depend.x;
import com.ss.android.socialbase.downloader.downloader.j;
import com.ss.android.socialbase.downloader.downloader.s;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.f.k;
import com.ss.android.socialbase.downloader.f.n;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.model.b;
import com.ss.android.socialbase.downloader.network.i;
import com.ss.android.socialbase.downloader.network.l;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.RevenueServerConst;
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
/* loaded from: classes2.dex */
public class c implements f, Runnable {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final String f69404a;
    public transient /* synthetic */ FieldHolder $fh;
    public r A;
    public volatile int B;
    public boolean C;
    public boolean D;
    public String E;
    public boolean F;
    public long G;
    public long H;
    public final com.ss.android.socialbase.downloader.g.a I;
    public int J;
    public volatile k K;

    /* renamed from: b  reason: collision with root package name */
    public Future f69405b;

    /* renamed from: c  reason: collision with root package name */
    public final DownloadTask f69406c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f69407d;

    /* renamed from: e  reason: collision with root package name */
    public AtomicInteger f69408e;

    /* renamed from: f  reason: collision with root package name */
    public final ArrayList<b> f69409f;

    /* renamed from: g  reason: collision with root package name */
    public volatile com.ss.android.socialbase.downloader.downloader.e f69410g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f69411h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f69412i;
    public boolean j;
    public boolean k;
    public boolean l;
    public final AtomicBoolean m;
    public volatile com.ss.android.socialbase.downloader.constants.h n;
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

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(479400541, "Lcom/ss/android/socialbase/downloader/h/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(479400541, "Lcom/ss/android/socialbase/downloader/h/c;");
                return;
            }
        }
        f69404a = c.class.getSimpleName();
    }

    public c(DownloadTask downloadTask, Handler handler) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {downloadTask, handler};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f69407d = false;
        this.f69409f = new ArrayList<>();
        this.n = com.ss.android.socialbase.downloader.constants.h.f69195a;
        this.B = 5;
        this.C = false;
        this.D = false;
        this.F = false;
        this.J = 0;
        this.K = null;
        this.f69406c = downloadTask;
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

    private long A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) ? this.u.a(this.p.getCurRetryTimeInTotal(), this.p.getTotalRetryCount()) : invokeV.longValue;
    }

    private void B() throws com.ss.android.socialbase.downloader.exception.i, BaseException {
        com.ss.android.socialbase.downloader.impls.a C;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            int id = this.p.getId();
            int a2 = com.ss.android.socialbase.downloader.downloader.c.a(this.p);
            if (this.p.isDownloaded() && !this.p.isExpiredRedownload() && !this.F) {
                throw new BaseException(1009, "file has downloaded");
            }
            DownloadInfo b2 = this.o.b(a2);
            if (b2 == null || (C = com.ss.android.socialbase.downloader.downloader.c.C()) == null || b2.getId() == id || !b2.equalsTask(this.p)) {
                return;
            }
            if (!C.a(b2.getId())) {
                List<com.ss.android.socialbase.downloader.model.b> c2 = this.o.c(a2);
                com.ss.android.socialbase.downloader.i.f.a(this.p);
                this.o.f(a2);
                if (b2 == null || !b2.isBreakpointAvailable()) {
                    return;
                }
                this.p.copyFromCacheData(b2, false);
                this.o.a(this.p);
                if (c2 != null) {
                    for (com.ss.android.socialbase.downloader.model.b bVar : c2) {
                        bVar.b(id);
                        this.o.a(bVar);
                    }
                }
                throw new com.ss.android.socialbase.downloader.exception.i("retry task because id generator changed");
            }
            this.o.f(id);
            throw new BaseException(1025, "another same task is downloading");
        }
    }

    private boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            DownloadInfo downloadInfo = this.p;
            if (downloadInfo == null || downloadInfo.isExpiredRedownload()) {
                return false;
            }
            return (!this.f69412i || this.p.getChunkCount() > 1) && !this.p.isChunkDowngradeRetryUsed() && this.j && !this.l;
        }
        return invokeV.booleanValue;
    }

    private void D() throws BaseException {
        long j;
        int a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            try {
                j = com.ss.android.socialbase.downloader.i.f.d(this.p.getTempPath());
            } catch (BaseException unused) {
                j = 0;
            }
            com.ss.android.socialbase.downloader.c.a.c(f69404a, "checkSpaceOverflowInProgress: available = " + com.ss.android.socialbase.downloader.i.f.a(j) + "MB");
            if (j > 0) {
                long totalBytes = this.p.getTotalBytes() - this.p.getCurBytes();
                if (j < totalBytes && (a2 = com.ss.android.socialbase.downloader.g.a.a(this.p.getId()).a("space_fill_min_keep_mb", 100)) > 0) {
                    long j2 = j - (a2 * 1048576);
                    com.ss.android.socialbase.downloader.c.a.c(f69404a, "checkSpaceOverflowInProgress: minKeep  = " + a2 + "MB, canDownload = " + com.ss.android.socialbase.downloader.i.f.a(j2) + "MB");
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
    }

    private void E() throws com.ss.android.socialbase.downloader.exception.f {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            if (this.p.isOnlyWifi() && !com.ss.android.socialbase.downloader.i.f.a(com.ss.android.socialbase.downloader.downloader.c.N(), DefaultConnectivityMonitorFactory.NETWORK_PERMISSION)) {
                throw new com.ss.android.socialbase.downloader.exception.f(1019, String.format("download task need permission:%s", DefaultConnectivityMonitorFactory.NETWORK_PERMISSION));
            }
            if (this.p.isDownloadWithWifiValid()) {
                if (!this.p.isPauseReserveWithWifiValid()) {
                    throw new com.ss.android.socialbase.downloader.exception.e();
                }
                return;
            }
            throw new com.ss.android.socialbase.downloader.exception.c();
        }
    }

    private void F() throws BaseException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            if (!TextUtils.isEmpty(this.p.getSavePath())) {
                if (!TextUtils.isEmpty(this.p.getName())) {
                    File file = new File(this.p.getSavePath());
                    if (!file.exists()) {
                        boolean mkdirs = file.mkdirs();
                        if (mkdirs || file.exists()) {
                            return;
                        }
                        int i2 = 0;
                        if (com.ss.android.socialbase.downloader.g.a.a(this.p.getId()).a("opt_mkdir_failed", 0) == 1) {
                            while (!mkdirs) {
                                int i3 = i2 + 1;
                                if (i2 >= 3) {
                                    break;
                                }
                                try {
                                    Thread.sleep(10L);
                                    mkdirs = file.mkdirs();
                                    i2 = i3;
                                } catch (InterruptedException unused) {
                                }
                            }
                            if (mkdirs || file.exists()) {
                                return;
                            }
                            if (com.ss.android.socialbase.downloader.i.f.d(this.p.getSavePath()) < 16384) {
                                throw new BaseException(1006, "download savePath directory can not created:" + this.p.getSavePath());
                            }
                            throw new BaseException(1030, "download savePath directory can not created:" + this.p.getSavePath());
                        }
                        throw new BaseException(1030, "download savePath directory can not created:" + this.p.getSavePath());
                    } else if (file.isDirectory()) {
                        return;
                    } else {
                        if (com.ss.android.socialbase.downloader.i.d.b(this.p)) {
                            file.delete();
                            if (file.mkdirs() || file.exists()) {
                                return;
                            }
                            throw new BaseException((int) ARPMessageType.MSG_TYPE_VIDEO_PLAY_INFO_UPDATE, "download savePath is not directory:path=" + this.p.getSavePath());
                        }
                        throw new BaseException((int) ARPMessageType.MSG_TYPE_VIDEO_PLAY_INFO_UPDATE, "download savePath is not a directory:" + this.p.getSavePath());
                    }
                }
                throw new BaseException(1029, "download name can not be empty");
            }
            throw new BaseException(1028, "download savePath can not be empty");
        }
    }

    private void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            long f2 = com.ss.android.socialbase.downloader.i.f.f(this.p);
            long curBytes = this.p.getCurBytes();
            if (f2 != curBytes) {
                String str = f69404a;
                com.ss.android.socialbase.downloader.c.a.d(str, "checkTaskCanResume: offset = " + f2 + ", curBytes = " + curBytes);
            }
            this.p.setCurBytes(f2);
            boolean z = f2 > 0;
            this.f69412i = z;
            if (z || this.F) {
                return;
            }
            com.ss.android.socialbase.downloader.c.a.c(f69404a, "checkTaskCanResume: deleteAllDownloadFiles");
            this.o.d(this.p.getId());
            this.o.m(this.p.getId());
            com.ss.android.socialbase.downloader.i.f.a(this.p);
        }
    }

    private void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            String str = f69404a;
            com.ss.android.socialbase.downloader.c.a.d(str, "clearCurrentDownloadData::" + Log.getStackTraceString(new Throwable()));
            try {
                this.o.d(this.p.getId());
                this.o.m(this.p.getId());
                com.ss.android.socialbase.downloader.i.f.a(this.p);
                this.f69412i = false;
                this.p.resetDataForEtagEndure("");
                this.o.a(this.p);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            try {
                Iterator it = ((ArrayList) this.f69409f.clone()).iterator();
                while (it.hasNext()) {
                    b bVar = (b) it.next();
                    if (bVar != null) {
                        bVar.b();
                    }
                }
            } catch (Throwable th) {
                String str = f69404a;
                com.ss.android.socialbase.downloader.c.a.c(str, "cancelAllChunkRunnable: " + th.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        com.ss.android.socialbase.downloader.impls.a C;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65547, this) == null) || v() || (C = com.ss.android.socialbase.downloader.downloader.c.C()) == null) {
            return;
        }
        C.l(this.p.getId());
    }

    private boolean K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    private void h() {
        DownloadInfo downloadInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65567, this) == null) || (downloadInfo = this.p) == null) {
            return;
        }
        int retryCount = downloadInfo.getRetryCount() - this.p.getCurRetryTime();
        if (retryCount < 0) {
            retryCount = 0;
        }
        AtomicInteger atomicInteger = this.f69408e;
        if (atomicInteger == null) {
            this.f69408e = new AtomicInteger(retryCount);
        } else {
            atomicInteger.set(retryCount);
        }
    }

    private boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65568, this)) == null) {
            int status = this.p.getStatus();
            if (status == 1 || this.p.canSkipStatusHandler()) {
                return true;
            }
            if (status == -2 || status == -4) {
                return false;
            }
            b(new BaseException(1000, "The download Task can't start, because its status is not prepare:" + status));
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:80:0x00f9, code lost:
        if (r9.I.a("fix_file_exist_update_download_info") != false) goto L89;
     */
    /* JADX WARN: Removed duplicated region for block: B:105:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00af A[Catch: all -> 0x00ee, TryCatch #10 {all -> 0x00ee, blocks: (B:58:0x00ab, B:60:0x00af, B:62:0x00b3, B:75:0x00ed), top: B:96:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00d3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void j() throws com.ss.android.socialbase.downloader.exception.a {
        Throwable th;
        com.ss.android.socialbase.downloader.exception.a e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65569, this) == null) {
            boolean z = false;
            boolean z2 = true;
            try {
                try {
                    try {
                        int id = this.p.getId();
                        if (this.o != null) {
                            if (com.ss.android.socialbase.downloader.i.a.a(2048)) {
                                this.o.e();
                            }
                            DownloadInfo b2 = this.o.b(id);
                            if (b2 != null && !b2.isNewTask()) {
                                String savePath = this.p.getSavePath();
                                String md5 = this.p.getMd5();
                                this.p.copyFromCacheData(b2, true);
                                boolean z3 = com.ss.android.socialbase.downloader.i.a.a(4096) && b2 != this.p;
                                try {
                                    if (savePath.equals(b2.getSavePath()) && com.ss.android.socialbase.downloader.i.f.a(b2, false, md5)) {
                                        try {
                                            throw new com.ss.android.socialbase.downloader.exception.a(b2.getName());
                                        } catch (com.ss.android.socialbase.downloader.exception.a e3) {
                                            throw e3;
                                        } catch (Throwable th2) {
                                            th = th2;
                                            z = z3;
                                            if (this.f69406c != null) {
                                            }
                                            if (z) {
                                            }
                                        }
                                    } else if (com.ss.android.socialbase.downloader.downloader.c.a(b2) != id) {
                                        try {
                                            this.o.f(id);
                                        } catch (SQLiteException e4) {
                                            e4.printStackTrace();
                                        }
                                    } else {
                                        z2 = z3;
                                    }
                                } catch (com.ss.android.socialbase.downloader.exception.a e5) {
                                    e2 = e5;
                                    throw e2;
                                } catch (Throwable th3) {
                                    th = th3;
                                    z = z3;
                                    z2 = false;
                                    if (this.f69406c != null) {
                                        com.ss.android.socialbase.downloader.d.a.a(this.f69406c.getMonitorDepend(), this.p, new BaseException(1003, com.ss.android.socialbase.downloader.i.f.b(th, "checkTaskCache")), this.p.getStatus());
                                    }
                                    if (z) {
                                    }
                                }
                            }
                            this.p.reset();
                        } else {
                            z2 = false;
                        }
                        try {
                            h();
                        } catch (com.ss.android.socialbase.downloader.exception.a e6) {
                            e2 = e6;
                            throw e2;
                        } catch (Throwable th4) {
                            th = th4;
                            z = z2;
                            z2 = false;
                            if (this.f69406c != null && this.p != null) {
                                com.ss.android.socialbase.downloader.d.a.a(this.f69406c.getMonitorDepend(), this.p, new BaseException(1003, com.ss.android.socialbase.downloader.i.f.b(th, "checkTaskCache")), this.p.getStatus());
                            }
                            if (z) {
                                if (!z2 || this.I.a("fix_file_exist_update_download_info")) {
                                    this.o.a(this.p);
                                }
                            }
                            return;
                        }
                    } catch (SQLiteException e7) {
                        e7.printStackTrace();
                        return;
                    }
                } catch (com.ss.android.socialbase.downloader.exception.a e8) {
                    e2 = e8;
                } catch (Throwable th5) {
                    th = th5;
                }
                if (z2) {
                    this.o.a(this.p);
                }
            } catch (Throwable th6) {
                if (0 != 0) {
                    if (1 != 0) {
                        try {
                        } catch (SQLiteException e9) {
                            e9.printStackTrace();
                        }
                    }
                    this.o.a(this.p);
                }
                throw th6;
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[MOVE_EXCEPTION, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x005e A[LOOP:0: B:26:0x005e->B:60:0x005e, LOOP_START] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void k() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(65570, this) != null) {
            return;
        }
        Process.setThreadPriority(10);
        try {
            if (this.p != null && this.H > 0) {
                this.p.increaseDownloadPrepareTime(System.currentTimeMillis() - this.H);
            }
        } catch (Throwable unused) {
        }
        try {
            IDownloadInterceptor interceptor = this.f69406c.getInterceptor();
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
            x monitorDepend = this.f69406c.getMonitorDepend();
            DownloadInfo downloadInfo = this.p;
            BaseException baseException = new BaseException(1003, "task status is invalid");
            DownloadInfo downloadInfo2 = this.p;
            com.ss.android.socialbase.downloader.d.a.a(monitorDepend, downloadInfo, baseException, downloadInfo2 != null ? downloadInfo2.getStatus() : 0);
            return;
        }
        while (true) {
            l();
            if (!this.C) {
                return;
            }
            if (this.B > 0) {
                this.B--;
            } else if (this.p.getCurBytes() != this.p.getTotalBytes()) {
                com.ss.android.socialbase.downloader.c.a.b(f69404a, this.p.getErrorBytesLog());
                this.v.a(new com.ss.android.socialbase.downloader.exception.f(1027, "current bytes is not equals to total bytes, bytes invalid retry status is : " + this.p.getByteInvalidRetryStatus()));
                return;
            } else if (this.p.getCurBytes() <= 0) {
                com.ss.android.socialbase.downloader.c.a.b(f69404a, this.p.getErrorBytesLog());
                this.v.a(new com.ss.android.socialbase.downloader.exception.f(1026, "curBytes is 0, bytes invalid retry status is : " + this.p.getByteInvalidRetryStatus()));
                return;
            } else if (this.p.getTotalBytes() <= 0) {
                com.ss.android.socialbase.downloader.c.a.b(f69404a, this.p.getErrorBytesLog());
                this.v.a(new com.ss.android.socialbase.downloader.exception.f(1044, "TotalBytes is 0, bytes invalid retry status is : " + this.p.getByteInvalidRetryStatus()));
                return;
            }
        }
    }

    private void l() {
        boolean z;
        List<com.ss.android.socialbase.downloader.model.b> c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65571, this) == null) {
            try {
                this.n = com.ss.android.socialbase.downloader.constants.h.f69195a;
                this.p.updateStartDownloadTime();
                this.p.resetRealStartDownloadTime();
                long currentTimeMillis = System.currentTimeMillis();
                this.p.setFirstSpeedTime(-1L);
                try {
                    j();
                    z = false;
                } catch (com.ss.android.socialbase.downloader.exception.a e2) {
                    String str = f69404a;
                    com.ss.android.socialbase.downloader.c.a.b(str, "file exist " + e2.a());
                    this.E = e2.a();
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
                                c2 = this.o.c(this.p.getId());
                                G();
                            } catch (BaseException e3) {
                                String str2 = f69404a;
                                com.ss.android.socialbase.downloader.c.a.d(str2, "downloadInner: baseException = " + e3);
                                if (this.n != com.ss.android.socialbase.downloader.constants.h.f69196b) {
                                    if (e3.getErrorCode() != 1025 && e3.getErrorCode() != 1009) {
                                        if (a(e3)) {
                                            if (com.ss.android.socialbase.downloader.i.f.a(e3)) {
                                                H();
                                            }
                                            if (a(e3, 0L) != com.ss.android.socialbase.downloader.exception.h.f69311a) {
                                                s();
                                            } else {
                                                s();
                                                return;
                                            }
                                        } else {
                                            b(e3);
                                        }
                                    }
                                    this.n = com.ss.android.socialbase.downloader.constants.h.f69199e;
                                    s();
                                    return;
                                }
                            }
                        } catch (com.ss.android.socialbase.downloader.exception.a unused) {
                            m();
                        }
                    } catch (com.ss.android.socialbase.downloader.exception.i e4) {
                        String str3 = f69404a;
                        com.ss.android.socialbase.downloader.c.a.d(str3, "downloadInner: retry throwable for " + e4.a());
                        if (this.n != com.ss.android.socialbase.downloader.constants.h.f69196b) {
                            if (this.f69408e != null && this.f69408e.get() > 0) {
                                this.p.updateCurRetryTime(this.f69408e.decrementAndGet());
                                this.p.setStatus(5);
                            } else if (this.f69408e != null) {
                                if (this.p.trySwitchToNextBackupUrl()) {
                                    this.p.setStatus(5);
                                    this.f69408e.set(this.p.getRetryCount());
                                    this.p.updateCurRetryTime(this.f69408e.get());
                                } else {
                                    b(new BaseException(1018, String.format("retry for Throwable, but retry Time %s all used, last error is %s", String.valueOf(this.p.getRetryCount()), e4.a())));
                                }
                            } else {
                                b(new BaseException((int) SDKLogTypeConstants.TYPE_NATIVE_CPU_CLICK, "retry for Throwable, but retain retry time is NULL, last error is" + e4.a()));
                            }
                            s();
                        }
                    } catch (Throwable th) {
                        String str4 = f69404a;
                        com.ss.android.socialbase.downloader.c.a.d(str4, "downloadInner: throwable =  " + th);
                        if (this.n != com.ss.android.socialbase.downloader.constants.h.f69196b) {
                            b(new BaseException(1045, th));
                        }
                    }
                    if (n()) {
                        com.ss.android.socialbase.downloader.c.a.c(f69404a, "downloadSegments return");
                        s();
                        return;
                    }
                    String connectionUrl = this.p.getConnectionUrl();
                    if (v()) {
                        s();
                        return;
                    }
                    long e5 = this.f69412i ? com.ss.android.socialbase.downloader.i.f.e(this.p) : 0L;
                    com.ss.android.socialbase.downloader.model.b a2 = a(this.p, e5);
                    List<com.ss.android.socialbase.downloader.model.c> a3 = a(a2);
                    com.ss.android.socialbase.downloader.i.f.a(a3, this.p);
                    com.ss.android.socialbase.downloader.i.f.b(a3, this.p);
                    this.p.setPreconnectLevel(0);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    try {
                        a(connectionUrl, a3, e5);
                        this.p.increaseAllConnectTime(System.currentTimeMillis() - currentTimeMillis2);
                        if (v()) {
                            s();
                            return;
                        }
                        long totalBytes = this.p.getTotalBytes();
                        a(totalBytes);
                        int a4 = a(totalBytes, c2);
                        if (v()) {
                            s();
                            return;
                        } else if (a4 > 0) {
                            boolean z2 = a4 == 1;
                            this.f69411h = z2;
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
                                if (this.f69412i) {
                                    a(a4, c2);
                                } else {
                                    a(totalBytes, a4);
                                }
                            }
                            s();
                            return;
                        } else {
                            throw new BaseException(1032, "chunkCount is 0");
                        }
                    } finally {
                    }
                }
            } finally {
                p();
            }
        }
    }

    private void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65572, this) == null) {
            com.ss.android.socialbase.downloader.c.a.b(f69404a, "finishWithFileExist");
            if (com.ss.android.socialbase.downloader.g.a.c().b("fix_end_for_file_exist_error", true)) {
                if (this.E.equals(this.p.getName())) {
                    this.n = com.ss.android.socialbase.downloader.constants.h.f69199e;
                } else {
                    this.n = com.ss.android.socialbase.downloader.constants.h.f69202h;
                }
            } else if (this.E.equals(this.p.getTargetFilePath())) {
                this.n = com.ss.android.socialbase.downloader.constants.h.f69199e;
            } else {
                this.n = com.ss.android.socialbase.downloader.constants.h.f69202h;
            }
        }
    }

    private boolean n() throws BaseException, InterruptedException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65573, this)) == null) {
            if (!this.p.isExpiredRedownload() && this.p.getChunkCount() == 1 && this.p.getThrottleNetSpeed() <= 0) {
                JSONObject d2 = com.ss.android.socialbase.downloader.g.a.a(this.p.getId()).d("segment_config");
                List<com.ss.android.socialbase.downloader.f.i> n = this.o.n(this.p.getId());
                if (this.p.getCurBytes() > 0) {
                    if (n == null || n.isEmpty()) {
                        return false;
                    }
                    if (d2 == null) {
                        d2 = new JSONObject();
                    }
                }
                if (d2 == null) {
                    return false;
                }
                this.K = new k(this.p, n.a(d2), this);
                if (v()) {
                    com.ss.android.socialbase.downloader.c.a.c(f69404a, "downloadSegments: is stopped by user");
                    if (this.n == com.ss.android.socialbase.downloader.constants.h.f69197c) {
                        this.K.a();
                    } else {
                        this.K.b();
                    }
                    return true;
                }
                return this.K.a(n);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private void o() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65574, this) == null) && com.ss.android.socialbase.downloader.g.a.a(this.p.getId()).a("reset_retain_retry_times", 0) == 1 && this.J < 3) {
            this.f69408e.set(this.p.isBackUpUrlUsed() ? this.p.getBackUpUrlRetryCount() : this.p.getRetryCount());
            this.J++;
        }
    }

    private void p() {
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65575, this) == null) {
            String str = f69404a;
            com.ss.android.socialbase.downloader.c.a.b(str, "endDownloadRunnable::runStatus=" + this.n);
            boolean z3 = (this.n == com.ss.android.socialbase.downloader.constants.h.f69196b || this.n == com.ss.android.socialbase.downloader.constants.h.f69197c) ? false : true;
            try {
                z = w();
                z2 = false;
            } catch (Exception e2) {
                if (e2 instanceof BaseException) {
                    this.v.a((BaseException) e2);
                } else {
                    this.v.a(new BaseException(1046, e2));
                }
                z = true;
                z2 = true;
            }
            if (!z && !z2) {
                this.C = true;
                com.ss.android.socialbase.downloader.c.a.b(f69404a, "jump to restart");
                return;
            }
            this.m.set(false);
            if (z3) {
                try {
                    com.ss.android.socialbase.downloader.impls.a C = com.ss.android.socialbase.downloader.downloader.c.C();
                    if (C != null) {
                        C.a(this);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                    x monitorDepend = this.f69406c.getMonitorDepend();
                    DownloadInfo downloadInfo = this.p;
                    BaseException baseException = new BaseException(1014, com.ss.android.socialbase.downloader.i.f.b(th, "removeDownloadRunnable"));
                    DownloadInfo downloadInfo2 = this.p;
                    com.ss.android.socialbase.downloader.d.a.a(monitorDepend, downloadInfo, baseException, downloadInfo2 != null ? downloadInfo2.getStatus() : 0);
                }
            }
        }
    }

    private void q() {
        com.ss.android.socialbase.downloader.network.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65576, this) == null) || (gVar = this.y) == null) {
            return;
        }
        gVar.c();
        this.y = null;
    }

    private void r() {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65577, this) == null) || (iVar = this.x) == null) {
            return;
        }
        iVar.d();
        this.x = null;
    }

    private void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65578, this) == null) {
            q();
            r();
        }
    }

    private void t() throws BaseException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65579, this) == null) || this.f69410g == null) {
            return;
        }
        if (this.n == com.ss.android.socialbase.downloader.constants.h.f69197c) {
            this.p.setStatus(-4);
            this.f69410g.c();
        } else if (this.n == com.ss.android.socialbase.downloader.constants.h.f69196b) {
            this.p.setStatus(-2);
            this.f69410g.b();
        } else {
            this.f69410g.d();
        }
    }

    private boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65580, this)) == null) ? this.n == com.ss.android.socialbase.downloader.constants.h.f69197c || this.n == com.ss.android.socialbase.downloader.constants.h.f69196b : invokeV.booleanValue;
    }

    private boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65581, this)) == null) {
            if (u() || this.p.getStatus() == -2) {
                if (u()) {
                    return true;
                }
                if (this.p.getStatus() == -2) {
                    this.n = com.ss.android.socialbase.downloader.constants.h.f69196b;
                    return true;
                } else if (this.p.getStatus() == -4) {
                    this.n = com.ss.android.socialbase.downloader.constants.h.f69197c;
                    return true;
                } else {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65582, this)) == null) {
            if (this.n == com.ss.android.socialbase.downloader.constants.h.f69198d) {
                this.v.a(this.w);
            } else if (this.n == com.ss.android.socialbase.downloader.constants.h.f69197c) {
                this.v.c();
            } else if (this.n == com.ss.android.socialbase.downloader.constants.h.f69196b) {
                this.v.d();
            } else if (this.n == com.ss.android.socialbase.downloader.constants.h.f69199e) {
                try {
                    this.v.g();
                } catch (BaseException e2) {
                    this.v.a(e2);
                }
            } else if (this.n == com.ss.android.socialbase.downloader.constants.h.f69202h) {
                try {
                    this.v.a(this.E);
                } catch (BaseException e3) {
                    this.v.a(e3);
                }
            } else if (this.n == com.ss.android.socialbase.downloader.constants.h.f69203i) {
                this.v.a(this.w, false);
                return false;
            } else if (this.n == com.ss.android.socialbase.downloader.constants.h.f69201g) {
                return true;
            } else {
                if (this.n == com.ss.android.socialbase.downloader.constants.h.f69200f && !x()) {
                    com.ss.android.socialbase.downloader.c.a.b(f69404a, "doTaskStatusHandle retryDelay");
                    z();
                    return this.n == com.ss.android.socialbase.downloader.constants.h.f69200f;
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
        return invokeV.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x004b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65583, this)) == null) {
            if (this.p.getChunkCount() <= 1) {
                return this.p.getCurBytes() > 0 && this.p.getCurBytes() == this.p.getTotalBytes();
            }
            List<com.ss.android.socialbase.downloader.model.b> c2 = this.o.c(this.p.getId());
            if (c2 == null || c2.size() <= 1) {
                return false;
            }
            for (com.ss.android.socialbase.downloader.model.b bVar : c2) {
                if (bVar == null || !bVar.i()) {
                    return false;
                }
                while (r0.hasNext()) {
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    private boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65584, this)) == null) {
            if (this.p.isChunked()) {
                DownloadInfo downloadInfo = this.p;
                downloadInfo.setTotalBytes(downloadInfo.getCurBytes());
            }
            String str = f69404a;
            com.ss.android.socialbase.downloader.c.a.c(str, "checkCompletedByteValid: downloadInfo.getCurBytes() = " + this.p.getCurBytes() + ",  downloadInfo.getTotalBytes() = " + this.p.getTotalBytes());
            if (this.p.getCurBytes() > 0) {
                if (this.p.isIgnoreDataVerify()) {
                    return true;
                }
                if (this.p.getTotalBytes() > 0 && this.p.getCurBytes() == this.p.getTotalBytes()) {
                    return true;
                }
            }
            this.p.setByteInvalidRetryStatus(com.ss.android.socialbase.downloader.constants.b.f69163b);
            this.p.reset();
            this.o.a(this.p);
            this.o.d(this.p.getId());
            this.o.m(this.p.getId());
            com.ss.android.socialbase.downloader.i.f.a(this.p);
            return false;
        }
        return invokeV.booleanValue;
    }

    private void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65585, this) == null) {
            this.n = com.ss.android.socialbase.downloader.constants.h.f69195a;
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.n = com.ss.android.socialbase.downloader.constants.h.f69197c;
            if (this.K != null) {
                this.K.a();
            }
            if (this.f69410g != null) {
                this.f69410g.c();
            }
            if (this.K == null && this.f69410g == null) {
                s();
                this.n = com.ss.android.socialbase.downloader.constants.h.f69197c;
                p();
            }
            I();
        }
    }

    public DownloadTask c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f69406c : (DownloadTask) invokeV.objValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.m.get() : invokeV.booleanValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            DownloadInfo downloadInfo = this.p;
            if (downloadInfo != null) {
                return downloadInfo.getId();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.H = System.currentTimeMillis();
            this.v.a();
        }
    }

    public Future g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f69405b : (Future) invokeV.objValue;
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            com.ss.android.socialbase.downloader.downloader.c.a(this.f69406c, 3);
            try {
                com.ss.android.socialbase.downloader.network.b.a().b();
                k();
                com.ss.android.socialbase.downloader.network.b.a().c();
                com.ss.android.socialbase.downloader.downloader.c.b(this.f69406c, 3);
            } catch (Throwable th) {
                com.ss.android.socialbase.downloader.network.b.a().c();
                throw th;
            }
        }
    }

    private boolean d(BaseException baseException) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65566, this, baseException)) == null) {
            AtomicInteger atomicInteger = this.f69408e;
            boolean z = true;
            if (atomicInteger != null) {
                if (atomicInteger.get() <= 0 || (baseException != null && baseException.getErrorCode() == 1070)) {
                    if (this.p.trySwitchToNextBackupUrl()) {
                        this.f69408e.set(this.p.getBackUpUrlRetryCount());
                        this.p.updateCurRetryTime(this.f69408e.get());
                    } else if (baseException != null && ((baseException.getErrorCode() == 1011 || (baseException.getCause() != null && (baseException.getCause() instanceof SSLHandshakeException))) && this.p.canReplaceHttpForRetry())) {
                        this.f69408e.set(this.p.getRetryCount());
                        this.p.updateCurRetryTime(this.f69408e.get());
                        this.p.setHttpsToHttpRetryUsed(true);
                    } else {
                        b(new BaseException(baseException.getErrorCode(), String.format("retry for exception, but current retry time : %s , retry Time %s all used, last error is %s", String.valueOf(this.f69408e), String.valueOf(this.p.getRetryCount()), baseException.getErrorMessage())));
                        return true;
                    }
                    z = false;
                }
                if (this.n != com.ss.android.socialbase.downloader.constants.h.f69200f && z) {
                    this.p.updateCurRetryTime(this.f69408e.decrementAndGet());
                }
                return false;
            }
            b(new BaseException((int) SDKLogTypeConstants.TYPE_NATIVE_CPU_CLICK, "retry for exception, but retain retry time is null, last error is :" + baseException.getErrorMessage()));
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.ss.android.socialbase.downloader.h.f
    public void c(BaseException baseException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, baseException) == null) {
            DownloadInfo downloadInfo = this.p;
            if (downloadInfo != null) {
                downloadInfo.setChunkDowngradeRetryUsed(true);
            }
            a(baseException, false);
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.n = com.ss.android.socialbase.downloader.constants.h.f69196b;
            if (this.K != null) {
                this.K.b();
            }
            if (this.f69410g != null) {
                this.f69410g.b();
            }
            if (this.K == null && this.f69410g == null) {
                s();
                this.n = com.ss.android.socialbase.downloader.constants.h.f69196b;
                p();
            }
            try {
                Iterator it = ((ArrayList) this.f69409f.clone()).iterator();
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
    }

    public void c(long j) {
        i iVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(1048591, this, j) == null) && (iVar = this.x) != null && (iVar instanceof com.ss.android.socialbase.downloader.network.a)) {
            try {
                ((com.ss.android.socialbase.downloader.network.a) iVar).a(j);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private void b(String str, List<com.ss.android.socialbase.downloader.model.c> list, long j) throws BaseException, com.ss.android.socialbase.downloader.exception.i {
        com.ss.android.socialbase.downloader.network.a.c a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65565, this, new Object[]{str, list, Long.valueOf(j)}) == null) {
            boolean z = true;
            if (this.p.getChunkCount() == 1 && (a2 = com.ss.android.socialbase.downloader.network.a.a.a().a(str, list)) != null) {
                this.y = a2;
                this.p.setPreconnectLevel(1);
            }
            if (this.y == null && !this.D && this.p.isHeadConnectionAvailable()) {
                try {
                    int b2 = this.I.b("net_lib_strategy");
                    if (this.I.a("monitor_download_connect", 0) <= 0) {
                        z = false;
                    }
                    this.y = com.ss.android.socialbase.downloader.downloader.c.a(str, list, b2, z, this.p);
                } catch (Throwable th) {
                    this.p.setHeadConnectionException(com.ss.android.socialbase.downloader.i.f.j(th));
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0060, code lost:
        if (r9 <= 0) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int a(long j, List<com.ss.android.socialbase.downloader.model.b> list) {
        InterceptResult invokeJL;
        int i2;
        int a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(65549, this, j, list)) == null) {
            if (C()) {
                if (!this.f69412i) {
                    com.ss.android.socialbase.downloader.downloader.h hVar = this.q;
                    if (hVar != null) {
                        a2 = hVar.a(j);
                    } else {
                        a2 = this.r.a(j);
                    }
                    l b2 = com.ss.android.socialbase.downloader.network.k.a().b();
                    com.ss.android.socialbase.downloader.c.a.b(f69404a, String.format("NetworkQuality is : %s", b2.name()));
                    this.p.setNetworkQuality(b2.name());
                    com.ss.android.socialbase.downloader.downloader.g gVar = this.s;
                    if (gVar != null) {
                        i2 = gVar.a(a2, b2);
                    } else {
                        i2 = this.t.a(a2, b2);
                    }
                } else if (list != null) {
                    i2 = list.size();
                } else {
                    i2 = this.p.getChunkCount();
                }
            }
            i2 = 1;
            if (com.ss.android.socialbase.downloader.c.a.a()) {
                com.ss.android.socialbase.downloader.c.a.b(f69404a, String.format("chunk count : %s for %s contentLen:%s", String.valueOf(i2), this.p.getName(), String.valueOf(j)));
            }
            return i2;
        }
        return invokeJL.intValue;
    }

    @Override // com.ss.android.socialbase.downloader.h.f
    public boolean b(long j) throws BaseException {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048589, this, j)) == null) {
            if (this.G > 0 && this.p.getCurBytes() > this.G) {
                D();
            }
            return this.v.a(j);
        }
        return invokeJ.booleanValue;
    }

    @Override // com.ss.android.socialbase.downloader.h.f
    public void b(BaseException baseException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, baseException) == null) {
            String str = f69404a;
            com.ss.android.socialbase.downloader.c.a.b(str, "onError:" + baseException.getMessage());
            this.n = com.ss.android.socialbase.downloader.constants.h.f69198d;
            this.w = baseException;
            I();
        }
    }

    private void a(String str, List<com.ss.android.socialbase.downloader.model.c> list, long j) throws BaseException, com.ss.android.socialbase.downloader.exception.i {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65561, this, new Object[]{str, list, Long.valueOf(j)}) == null) {
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
    }

    private void a(String str, List<com.ss.android.socialbase.downloader.model.c> list) throws BaseException, com.ss.android.socialbase.downloader.exception.i {
        i iVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65560, this, str, list) == null) && this.x == null) {
            com.ss.android.socialbase.downloader.network.a.d b2 = this.p.getChunkCount() == 1 ? com.ss.android.socialbase.downloader.network.a.a.a().b(str, list) : null;
            try {
                if (b2 != null) {
                    a(this.x);
                    this.p.setPreconnectLevel(2);
                    this.x = b2;
                } else {
                    try {
                        iVar = com.ss.android.socialbase.downloader.downloader.c.a(this.p.isNeedDefaultHttpServiceBackUp(), this.p.getMaxBytes(), str, null, list, this.I.b("net_lib_strategy"), this.I.a("monitor_download_connect", 0) > 0, this.p);
                        this.x = iVar;
                    } catch (BaseException e2) {
                        throw e2;
                    } catch (Throwable th) {
                        if (this.p.isExpiredRedownload() && com.ss.android.socialbase.downloader.i.f.g(th) && com.ss.android.socialbase.downloader.i.f.c(list)) {
                            com.ss.android.socialbase.downloader.c.a.b(f69404a, "dcache=execepiton responseCode=304 lastModified not changed, use local file.. old cacheControl=" + this.p.getCacheControl());
                            long i2 = com.ss.android.socialbase.downloader.i.f.i(this.p.getCacheControl());
                            if (i2 <= 0) {
                                i2 = com.ss.android.socialbase.downloader.g.a.a(this.p.getId()).a("default_304_max_age", 300);
                            }
                            this.p.setCacheExpiredTime(System.currentTimeMillis() + (i2 * 1000));
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
                if (this.x == null) {
                    throw new BaseException(1022, new IOException("download can't continue, firstConnection is null"));
                }
            } catch (Throwable th2) {
                a(this.x);
                throw th2;
            }
        }
    }

    public static com.ss.android.socialbase.downloader.model.b a(DownloadInfo downloadInfo, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLJ = interceptable.invokeLJ(65551, null, downloadInfo, j)) == null) ? new b.a(downloadInfo.getId()).a(-1).a(0L).e(j).b(j).c(0L).d(downloadInfo.getTotalBytes() - j).a() : (com.ss.android.socialbase.downloader.model.b) invokeLJ.objValue;
    }

    private List<com.ss.android.socialbase.downloader.model.c> a(com.ss.android.socialbase.downloader.model.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, this, bVar)) == null) {
            List<com.ss.android.socialbase.downloader.model.c> a2 = com.ss.android.socialbase.downloader.i.f.a(this.p.getExtraHeaders(), this.p.geteTag(), bVar);
            if (this.p.isExpiredRedownload() && this.F && this.p.getLastModified() != null) {
                a2.add(new com.ss.android.socialbase.downloader.model.c("if-modified-since", this.p.getLastModified()));
                a2.add(new com.ss.android.socialbase.downloader.model.c("download-tc21-1-15", "download-tc21-1-15"));
                String str = f69404a;
                com.ss.android.socialbase.downloader.c.a.b(str, "dcache::add head IF_MODIFIED_SINCE=" + this.p.getLastModified());
            }
            return a2;
        }
        return (List) invokeL.objValue;
    }

    private void a(int i2, List<com.ss.android.socialbase.downloader.model.b> list) throws BaseException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65554, this, i2, list) == null) {
            if (list.size() == i2) {
                a(list, this.p.getTotalBytes());
                return;
            }
            throw new BaseException((int) DebugConstants.HTTP_ERRCODE_VERSION_HIGH, new IllegalArgumentException());
        }
    }

    private void a(long j, int i2) throws BaseException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65555, this, new Object[]{Long.valueOf(j), Integer.valueOf(i2)}) == null) {
            long j2 = j / i2;
            int id = this.p.getId();
            ArrayList arrayList = new ArrayList();
            int i3 = 0;
            long j3 = 0;
            while (i3 < i2) {
                com.ss.android.socialbase.downloader.model.b a2 = new b.a(id).a(i3).a(j3).e(j3).b(j3).c(i3 == i2 + (-1) ? 0L : (j3 + j2) - 1).a();
                arrayList.add(a2);
                this.o.a(a2);
                j3 += j2;
                i3++;
            }
            this.p.setChunkCount(i2);
            this.o.a(id, i2);
            a(arrayList, j);
        }
    }

    private void a(List<com.ss.android.socialbase.downloader.model.b> list, long j) throws BaseException {
        long p;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65563, this, list, j) == null) {
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
                                this.f69409f.add(new b(bVar, this.f69406c, this.x, this));
                            } else if (bVar.s() > 0) {
                                this.f69409f.add(new b(bVar, this.f69406c, this));
                            }
                        } else {
                            this.f69409f.add(new b(bVar, this.f69406c, this));
                        }
                    }
                }
            }
            if (com.ss.android.socialbase.downloader.i.a.a(64)) {
                ArrayList arrayList = new ArrayList(this.f69409f.size());
                Iterator<b> it = this.f69409f.iterator();
                while (it.hasNext()) {
                    b next = it.next();
                    if (this.n == com.ss.android.socialbase.downloader.constants.h.f69197c) {
                        next.b();
                    } else if (this.n == com.ss.android.socialbase.downloader.constants.h.f69196b) {
                        next.a();
                    } else {
                        arrayList.add(next);
                    }
                }
                try {
                    List<Future> d2 = com.ss.android.socialbase.downloader.impls.e.d(arrayList);
                    for (Runnable runnable = (Runnable) arrayList.remove(0); runnable != null; runnable = com.ss.android.socialbase.downloader.impls.e.e(d2)) {
                        if (v()) {
                            return;
                        }
                        runnable.run();
                    }
                    if (d2 == null || d2.isEmpty()) {
                        return;
                    }
                    for (Future future : d2) {
                        if (future != null && !future.isDone()) {
                            try {
                                future.get();
                            } catch (Throwable unused) {
                            }
                        }
                    }
                    return;
                } catch (Throwable unused2) {
                    return;
                }
            }
            ArrayList arrayList2 = new ArrayList(this.f69409f.size());
            Iterator<b> it2 = this.f69409f.iterator();
            while (it2.hasNext()) {
                b next2 = it2.next();
                if (this.n == com.ss.android.socialbase.downloader.constants.h.f69197c) {
                    next2.b();
                } else if (this.n == com.ss.android.socialbase.downloader.constants.h.f69196b) {
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
            } catch (InterruptedException e2) {
                throw new BaseException(1020, e2);
            }
        }
    }

    private void a(com.ss.android.socialbase.downloader.model.b bVar, String str, i iVar) throws BaseException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65558, this, bVar, str, iVar) == null) {
            bVar.a(this.p.getTotalBytes() - bVar.n());
            this.p.setChunkCount(1);
            this.o.a(this.p.getId(), 1);
            this.f69410g = new com.ss.android.socialbase.downloader.downloader.e(this.p, str, iVar, bVar, this);
            t();
        }
    }

    @Override // com.ss.android.socialbase.downloader.h.f
    public void a(long j) throws BaseException {
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048580, this, j) == null) {
            String tempPath = this.p.getTempPath();
            String tempName = this.p.getTempName();
            if (com.ss.android.socialbase.downloader.i.f.b(j)) {
                return;
            }
            com.ss.android.socialbase.downloader.model.e a2 = com.ss.android.socialbase.downloader.i.f.a(this.p, tempPath, tempName, -1);
            try {
                long length = new File(tempPath, tempName).length();
                long j3 = j - length;
                long d2 = com.ss.android.socialbase.downloader.i.f.d(tempPath);
                com.ss.android.socialbase.downloader.g.a a3 = com.ss.android.socialbase.downloader.g.a.a(this.p.getId());
                if (a3.a("space_fill_part_download", 0) == 1) {
                    this.G = 0L;
                    if (j3 <= 0) {
                        j3 = this.p.getTotalBytes() - this.p.getCurBytes();
                    }
                    if (d2 < j3) {
                        String str = f69404a;
                        com.ss.android.socialbase.downloader.c.a.d(str, "checkSpaceOverflow: contentLength = " + com.ss.android.socialbase.downloader.i.f.a(j) + "MB, downloaded = " + com.ss.android.socialbase.downloader.i.f.a(length) + "MB, required = " + com.ss.android.socialbase.downloader.i.f.a(j3) + "MB, available = " + com.ss.android.socialbase.downloader.i.f.a(d2) + "MB");
                        int i2 = (d2 > 0L ? 1 : (d2 == 0L ? 0 : -1));
                        if (i2 > 0) {
                            int a4 = a3.a("space_fill_min_keep_mb", 100);
                            if (a4 > 0) {
                                j2 = d2 - (a4 * 1048576);
                                String str2 = f69404a;
                                com.ss.android.socialbase.downloader.c.a.d(str2, "checkSpaceOverflow: minKeep = " + a4 + "MB, canDownload = " + com.ss.android.socialbase.downloader.i.f.a(j2) + "MB");
                                if (j2 > 0) {
                                    this.G = this.p.getCurBytes() + j2;
                                } else {
                                    throw new com.ss.android.socialbase.downloader.exception.d(d2, j3);
                                }
                            } else {
                                j2 = d2;
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
                            sb.append(i2 == 0 ? "=" : "<");
                            sb.append(" 0");
                            throw new BaseException((int) RevenueServerConst.GetChargeCouponDiscountRequest, sb.toString());
                        } else {
                            a2.b(j);
                            com.ss.android.socialbase.downloader.i.f.a(a2);
                        }
                    }
                } else {
                    int i3 = (d2 > 0L ? 1 : (d2 == 0L ? 0 : -1));
                    if (i3 <= 0) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("availableSpace ");
                        sb2.append(i3 == 0 ? "=" : "<");
                        sb2.append(" 0");
                        throw new BaseException((int) RevenueServerConst.GetChargeCouponDiscountRequest, sb2.toString());
                    } else if (d2 < j3) {
                        throw new com.ss.android.socialbase.downloader.exception.d(d2, j3);
                    }
                }
                a2.b(j);
                com.ss.android.socialbase.downloader.i.f.a(a2);
            } catch (Throwable th) {
                com.ss.android.socialbase.downloader.i.f.a(a2);
                throw th;
            }
        }
    }

    private boolean a(int i2, String str, String str2) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(65564, this, i2, str, str2)) == null) {
            if (i2 == 412) {
                return true;
            }
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || str.equals(str2) || !(this.k || this.j)) {
                return (i2 == 201 || i2 == 416) && this.p.getCurBytes() > 0;
            }
            return true;
        }
        return invokeILL.booleanValue;
    }

    private void a(String str, String str2) throws com.ss.android.socialbase.downloader.exception.i {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65559, this, str, str2) == null) {
            this.o.d(this.p.getId());
            this.o.m(this.p.getId());
            com.ss.android.socialbase.downloader.i.f.a(this.p);
            this.f69412i = false;
            this.p.resetDataForEtagEndure(str);
            this.o.a(this.p);
            throw new com.ss.android.socialbase.downloader.exception.i(str2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x013f, code lost:
        com.ss.android.socialbase.downloader.i.f.a(r19.p);
     */
    @Override // com.ss.android.socialbase.downloader.h.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(String str, com.ss.android.socialbase.downloader.network.g gVar, long j) throws BaseException, com.ss.android.socialbase.downloader.exception.i {
        com.ss.android.socialbase.downloader.network.g gVar2;
        long j2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{str, gVar, Long.valueOf(j)}) == null) || gVar == null) {
            return;
        }
        try {
            com.ss.android.socialbase.downloader.model.d dVar = new com.ss.android.socialbase.downloader.model.d(str, gVar);
            int i2 = dVar.f69644c;
            String d2 = dVar.d();
            if (TextUtils.isEmpty(this.p.getMimeType()) && !TextUtils.isEmpty(d2)) {
                this.p.setMimeType(d2);
            }
            boolean b2 = dVar.b();
            this.j = b2;
            this.p.setSupportPartial(b2);
            this.k = dVar.a();
            String str2 = this.p.geteTag();
            String c2 = dVar.c();
            String f2 = dVar.f();
            String g2 = dVar.g();
            String str3 = f69404a;
            StringBuilder sb = new StringBuilder();
            sb.append("dcache=responseCode=");
            sb.append(i2);
            sb.append(" last_modified=");
            sb.append(f2);
            sb.append(" CACHE_CONTROL=");
            sb.append(g2);
            sb.append(" max-age=");
            String str4 = c2;
            sb.append(dVar.k());
            sb.append(" isDeleteCacheIfCheckFailed=");
            sb.append(this.p.isDeleteCacheIfCheckFailed());
            com.ss.android.socialbase.downloader.c.a.b(str3, sb.toString());
            String str5 = f69404a;
            com.ss.android.socialbase.downloader.c.a.b(str5, "dcache=firstOffset=" + j + " cur=" + f2 + " before=" + this.p.getLastModified() + " cur=" + dVar.j() + " before=" + this.p.getTotalBytes());
            if (!TextUtils.isEmpty(g2)) {
                this.p.setCacheControl(g2);
                if (dVar.k() > 0) {
                    this.p.setCacheExpiredTime(System.currentTimeMillis() + (dVar.k() * 1000));
                }
            }
            if (this.p.isExpiredRedownload() && this.F && !TextUtils.isEmpty(this.E)) {
                boolean z = false;
                if (i2 != 304) {
                    if ((!TextUtils.isEmpty(this.p.getLastModified()) || !this.p.isDeleteCacheIfCheckFailed()) && TextUtils.equals(f2, this.p.getLastModified())) {
                    }
                    String str6 = f69404a;
                    com.ss.android.socialbase.downloader.c.a.b(str6, "dcache=responseCode=" + i2 + " lastModified not changed, use local file  " + f2);
                    throw new com.ss.android.socialbase.downloader.exception.a(this.E);
                }
                z = true;
                String str62 = f69404a;
                com.ss.android.socialbase.downloader.c.a.b(str62, "dcache=responseCode=" + i2 + " lastModified not changed, use local file  " + f2);
                throw new com.ss.android.socialbase.downloader.exception.a(this.E);
            }
            int i3 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i3 > 0 && this.p.isExpiredRedownload() && !TextUtils.equals(f2, this.p.getLastModified())) {
                com.ss.android.socialbase.downloader.c.a.b(f69404a, "dcache cdn file change, so retry");
                a("", "cdn file changed");
            }
            if (!TextUtils.isEmpty(f2)) {
                this.p.setLastModified(f2);
            }
            if (a(i2, str2, str4)) {
                gVar2 = gVar;
                if (gVar2 instanceof i) {
                    if (!TextUtils.isEmpty(str2) && str2.equals(str4)) {
                        str4 = "";
                    }
                    a(str4, "eTag of server file changed");
                } else {
                    throw new com.ss.android.socialbase.downloader.exception.b(1002, i2, "");
                }
            } else {
                gVar2 = gVar;
            }
            if (!this.j && !this.k) {
                if (i2 == 403) {
                    throw new BaseException(1047, "response code error : 403");
                }
                throw new com.ss.android.socialbase.downloader.exception.b(1004, i2, "response code error : " + i2);
            }
            if (this.k && i3 > 0) {
                if (gVar2 instanceof i) {
                    a("", "http head request not support");
                } else {
                    throw new BaseException(1004, "isResponseFromBegin but firstOffset > 0");
                }
            }
            long h2 = dVar.h();
            if (!(gVar2 instanceof i) && h2 < 0 && com.ss.android.socialbase.downloader.i.d.a(this.p)) {
                throw new BaseException(1004, "");
            }
            String a2 = TextUtils.isEmpty(this.p.getName()) ? com.ss.android.socialbase.downloader.i.f.a(gVar2, this.p.getUrl()) : "";
            boolean i4 = dVar.i();
            this.l = i4;
            if (!i4 && h2 == 0 && !(gVar2 instanceof i)) {
                throw new BaseException(1004, "");
            }
            if (this.l) {
                j2 = -1;
            } else {
                String b3 = com.ss.android.socialbase.downloader.i.f.b(gVar2, "Content-Range");
                String str7 = f69404a;
                com.ss.android.socialbase.downloader.c.a.c(str7, "firstConnection: contentRange = " + b3);
                if (!TextUtils.isEmpty(b3) && this.I.b("fix_get_total_bytes", true)) {
                    j2 = com.ss.android.socialbase.downloader.i.f.b(b3);
                    String str8 = f69404a;
                    com.ss.android.socialbase.downloader.c.a.c(str8, "firstConnection: 1 totalLength = " + j2);
                } else {
                    j2 = j + h2;
                    String str9 = f69404a;
                    com.ss.android.socialbase.downloader.c.a.e(str9, "firstConnection: 2 totalLength = " + j2 + ", contentLength = " + h2);
                }
            }
            if (v()) {
                return;
            }
            if (this.p.getExpectFileLength() > 0 && com.ss.android.socialbase.downloader.g.a.a(this.p.getId()).b("force_check_file_length") == 1 && this.p.getExpectFileLength() != j2) {
                throw new BaseException(1070, "expectFileLength = " + this.p.getExpectFileLength() + " , totalLength = " + j2);
            }
            this.v.a(j2, str4, a2);
        } catch (BaseException e2) {
            throw e2;
        } catch (com.ss.android.socialbase.downloader.exception.i e3) {
            throw e3;
        } catch (Throwable th) {
            com.ss.android.socialbase.downloader.i.f.a(th, "HandleFirstConnection");
        }
    }

    @Override // com.ss.android.socialbase.downloader.h.f
    public void a(b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) || this.f69411h) {
            return;
        }
        synchronized (this) {
            this.f69409f.remove(bVar);
        }
    }

    @Override // com.ss.android.socialbase.downloader.h.f
    public boolean a(BaseException baseException) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, baseException)) == null) {
            if (this.K == null || !com.ss.android.socialbase.downloader.i.f.i(baseException) || this.f69408e.get() >= this.p.getRetryCount()) {
                if (com.ss.android.socialbase.downloader.i.f.b(baseException)) {
                    if (this.f69411h && !this.f69407d) {
                        com.ss.android.socialbase.downloader.i.f.a(this.p);
                        this.f69407d = true;
                    }
                    return true;
                }
                AtomicInteger atomicInteger = this.f69408e;
                if ((atomicInteger == null || atomicInteger.get() <= 0) && !this.p.hasNextBackupUrl()) {
                    if (baseException == null) {
                        return false;
                    }
                    if ((baseException.getErrorCode() != 1011 && (baseException.getCause() == null || !(baseException.getCause() instanceof SSLHandshakeException))) || !this.p.canReplaceHttpForRetry()) {
                        return false;
                    }
                }
                return !(baseException instanceof com.ss.android.socialbase.downloader.exception.f);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.ss.android.socialbase.downloader.h.f
    public void a(BaseException baseException, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048581, this, baseException, z) == null) {
            com.ss.android.socialbase.downloader.c.a.b(f69404a, "onAllChunkRetryWithReset");
            this.n = com.ss.android.socialbase.downloader.constants.h.f69203i;
            this.w = baseException;
            I();
            if (z ? d(baseException) : false) {
                return;
            }
            H();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<String> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65562, this, list) == null) || list == null || list.isEmpty()) {
            return;
        }
        this.p.setForbiddenBackupUrls(list, this.n == com.ss.android.socialbase.downloader.constants.h.f69201g);
        com.ss.android.socialbase.downloader.impls.a C = com.ss.android.socialbase.downloader.downloader.c.C();
        if (C != null) {
            C.l(this.p.getId());
        }
    }

    @Override // com.ss.android.socialbase.downloader.h.f
    public com.ss.android.socialbase.downloader.exception.h a(com.ss.android.socialbase.downloader.model.b bVar, BaseException baseException, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{bVar, baseException, Long.valueOf(j)})) == null) {
            if (u()) {
                return com.ss.android.socialbase.downloader.exception.h.f69311a;
            }
            if (baseException != null && (baseException.getErrorCode() == 1047 || com.ss.android.socialbase.downloader.i.f.h(baseException))) {
                return a(baseException, j);
            }
            this.w = baseException;
            this.p.increaseCurBytes(-j);
            this.o.a(this.p);
            if (d(baseException)) {
                return com.ss.android.socialbase.downloader.exception.h.f69311a;
            }
            this.v.a(bVar, baseException, this.n == com.ss.android.socialbase.downloader.constants.h.f69200f);
            if (this.n != com.ss.android.socialbase.downloader.constants.h.f69200f && this.p.isNeedRetryDelay()) {
                long A = A();
                if (A > 0) {
                    String str = f69404a;
                    com.ss.android.socialbase.downloader.c.a.c(str, "onSingleChunkRetry with delay time " + A);
                    try {
                        Thread.sleep(A);
                    } catch (Throwable th) {
                        String str2 = f69404a;
                        com.ss.android.socialbase.downloader.c.a.d(str2, "onSingleChunkRetry:" + th.getMessage());
                    }
                }
            }
            return com.ss.android.socialbase.downloader.exception.h.f69312b;
        }
        return (com.ss.android.socialbase.downloader.exception.h) invokeCommon.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.h.f
    public com.ss.android.socialbase.downloader.exception.h a(BaseException baseException, long j) {
        InterceptResult invokeLJ;
        long totalBytes;
        long j2;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048576, this, baseException, j)) == null) {
            this.w = baseException;
            this.p.increaseCurBytes(-j);
            this.o.a(this.p);
            if (u()) {
                return com.ss.android.socialbase.downloader.exception.h.f69311a;
            }
            if (baseException != null && baseException.getErrorCode() == 1047) {
                if (this.z != null && !this.p.isForbiddenRetryed()) {
                    com.ss.android.socialbase.downloader.depend.b bVar = new com.ss.android.socialbase.downloader.depend.b(this) { // from class: com.ss.android.socialbase.downloader.h.c.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ c f69413a;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f69413a = this;
                        }

                        @Override // com.ss.android.socialbase.downloader.depend.b, com.ss.android.socialbase.downloader.depend.v
                        public void a(List<String> list) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, list) == null) {
                                super.a(list);
                                this.f69413a.a(list);
                            }
                        }
                    };
                    boolean a2 = this.z.a(bVar);
                    this.p.setForbiddenRetryed();
                    if (a2) {
                        if (!bVar.a()) {
                            I();
                            this.v.h();
                            this.n = com.ss.android.socialbase.downloader.constants.h.f69201g;
                            return com.ss.android.socialbase.downloader.exception.h.f69311a;
                        }
                        z = true;
                    }
                } else if (d(baseException)) {
                    return com.ss.android.socialbase.downloader.exception.h.f69311a;
                }
                z = false;
            } else if (com.ss.android.socialbase.downloader.i.f.h(baseException)) {
                if (this.A == null) {
                    b(baseException);
                    return com.ss.android.socialbase.downloader.exception.h.f69311a;
                }
                AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                q qVar = new q(this, atomicBoolean) { // from class: com.ss.android.socialbase.downloader.h.c.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ AtomicBoolean f69414a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ c f69415b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, atomicBoolean};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f69415b = this;
                        this.f69414a = atomicBoolean;
                    }

                    @Override // com.ss.android.socialbase.downloader.depend.q
                    public void a() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            synchronized (this.f69415b) {
                                this.f69414a.set(true);
                                this.f69415b.J();
                            }
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
                            if (this.n != com.ss.android.socialbase.downloader.constants.h.f69201g) {
                                this.n = com.ss.android.socialbase.downloader.constants.h.f69201g;
                                I();
                                this.v.h();
                            }
                            return com.ss.android.socialbase.downloader.exception.h.f69311a;
                        }
                        if (d(baseException)) {
                            return com.ss.android.socialbase.downloader.exception.h.f69311a;
                        }
                        z = true;
                    } else if (this.n == com.ss.android.socialbase.downloader.constants.h.f69201g) {
                        return com.ss.android.socialbase.downloader.exception.h.f69311a;
                    } else {
                        b(baseException);
                        return com.ss.android.socialbase.downloader.exception.h.f69311a;
                    }
                }
            } else {
                if (d(baseException)) {
                    return com.ss.android.socialbase.downloader.exception.h.f69311a;
                }
                z = false;
            }
            if (!z && K()) {
                I();
            }
            this.v.a(baseException, this.n == com.ss.android.socialbase.downloader.constants.h.f69200f);
            return this.n == com.ss.android.socialbase.downloader.constants.h.f69200f ? com.ss.android.socialbase.downloader.exception.h.f69311a : com.ss.android.socialbase.downloader.exception.h.f69312b;
        }
        return (com.ss.android.socialbase.downloader.exception.h) invokeLJ.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.h.f
    public synchronized com.ss.android.socialbase.downloader.model.b a(int i2) {
        InterceptResult invokeI;
        com.ss.android.socialbase.downloader.model.b a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            synchronized (this) {
                if (this.p.getChunkCount() < 2) {
                    return null;
                }
                List<com.ss.android.socialbase.downloader.model.b> c2 = this.o.c(this.p.getId());
                if (c2 != null && !c2.isEmpty()) {
                    for (int i3 = 0; i3 < c2.size(); i3++) {
                        com.ss.android.socialbase.downloader.model.b bVar = c2.get(i3);
                        if (bVar != null && (a2 = a(bVar, i2)) != null) {
                            return a2;
                        }
                    }
                    return null;
                }
                return null;
            }
        }
        return (com.ss.android.socialbase.downloader.model.b) invokeI.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    @Override // com.ss.android.socialbase.downloader.h.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(com.ss.android.socialbase.downloader.network.g gVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048583, this, gVar) != null) {
            return;
        }
        if (gVar != null) {
            try {
                int b2 = gVar.b();
                this.p.setHttpStatusCode(b2);
                this.p.setHttpStatusMessage(com.ss.android.socialbase.downloader.i.b.a(b2));
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

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0070, code lost:
        if (r9.f() != false) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private com.ss.android.socialbase.downloader.model.b a(com.ss.android.socialbase.downloader.model.b bVar, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65552, this, bVar, i2)) == null) {
            com.ss.android.socialbase.downloader.model.b bVar2 = null;
            if (bVar.d()) {
                long c2 = bVar.c(true);
                String str = f69404a;
                com.ss.android.socialbase.downloader.c.a.b(str, "reuseChunk retainLen:" + c2 + " chunkIndex:" + i2);
                boolean z = false;
                if (!bVar.f() && c2 > com.ss.android.socialbase.downloader.constants.e.f69182f && this.p.isNeedReuseChunkRunnable()) {
                    List<com.ss.android.socialbase.downloader.model.b> a2 = bVar.a(this.p.getChunkCount(), this.p.getTotalBytes());
                    if (a2 != null) {
                        for (com.ss.android.socialbase.downloader.model.b bVar3 : a2) {
                            this.o.b(bVar3);
                        }
                    }
                }
                z = true;
                if (z && bVar.f()) {
                    for (int i3 = 1; i3 < bVar.g().size(); i3++) {
                        com.ss.android.socialbase.downloader.model.b bVar4 = bVar.g().get(i3);
                        if (bVar4 != null) {
                            String str2 = f69404a;
                            com.ss.android.socialbase.downloader.c.a.b(str2, "check can checkUnCompletedChunk -- chunkIndex:" + bVar4.s() + " currentOffset:" + bVar4.n() + "  startOffset:" + bVar4.l() + " contentLen:" + bVar4.q());
                            if (bVar4.s() < 0 || (!bVar4.i() && !bVar4.c())) {
                                bVar2 = bVar4;
                                break;
                            }
                        }
                    }
                    if (bVar2 != null) {
                        long n = bVar.n();
                        String str3 = f69404a;
                        com.ss.android.socialbase.downloader.c.a.b(str3, "unComplete chunk " + bVar.s() + " curOffset:" + n + " reuseChunk chunkIndex:" + i2 + " for subChunk:" + bVar2.s());
                        this.o.a(bVar2.k(), bVar2.s(), bVar2.b(), i2);
                        bVar2.c(i2);
                        bVar2.a(true);
                    }
                }
                return bVar2;
            }
            return null;
        }
        return (com.ss.android.socialbase.downloader.model.b) invokeLI.objValue;
    }

    private s a(DownloadTask downloadTask) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, this, downloadTask)) == null) {
            s retryDelayTimeCalculator = downloadTask.getRetryDelayTimeCalculator();
            if (retryDelayTimeCalculator != null) {
                return retryDelayTimeCalculator;
            }
            DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
            if (downloadInfo != null) {
                String retryDelayTimeArray = downloadInfo.getRetryDelayTimeArray();
                if (!TextUtils.isEmpty(retryDelayTimeArray)) {
                    return new com.ss.android.socialbase.downloader.impls.q(retryDelayTimeArray);
                }
            }
            return com.ss.android.socialbase.downloader.downloader.c.L();
        }
        return (s) invokeL.objValue;
    }

    public void a(Future future) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, future) == null) {
            this.f69405b = future;
        }
    }
}
