package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes2.dex */
public class f {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "f";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f61745b;

    /* renamed from: c  reason: collision with root package name */
    public DownloadInfo f61746c;

    /* renamed from: d  reason: collision with root package name */
    public final j f61747d;

    /* renamed from: e  reason: collision with root package name */
    public final Handler f61748e;

    /* renamed from: f  reason: collision with root package name */
    public DownloadTask f61749f;

    /* renamed from: g  reason: collision with root package name */
    public SparseArray<IDownloadListener> f61750g;

    /* renamed from: h  reason: collision with root package name */
    public SparseArray<IDownloadListener> f61751h;

    /* renamed from: i  reason: collision with root package name */
    public SparseArray<IDownloadListener> f61752i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f61753j;

    /* renamed from: k  reason: collision with root package name */
    public volatile long f61754k;
    public final AtomicLong l;
    public boolean m;
    public int n;
    public long o;
    public com.ss.android.socialbase.downloader.depend.n p;
    public x q;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(326251601, "Lcom/ss/android/socialbase/downloader/downloader/f;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(326251601, "Lcom/ss/android/socialbase/downloader/downloader/f;");
        }
    }

    public f(DownloadTask downloadTask, Handler handler) {
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
        this.f61753j = false;
        this.f61754k = 0L;
        this.l = new AtomicLong();
        this.m = false;
        this.f61749f = downloadTask;
        j();
        this.f61748e = handler;
        this.f61747d = c.x();
        DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
        if (downloadInfo != null) {
            this.f61745b = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).a("fix_start_with_file_exist_update_error");
        } else {
            this.f61745b = false;
        }
    }

    private void j() {
        DownloadTask downloadTask;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65550, this) == null) || (downloadTask = this.f61749f) == null) {
            return;
        }
        this.f61746c = downloadTask.getDownloadInfo();
        this.f61750g = this.f61749f.getDownloadListeners(com.ss.android.socialbase.downloader.constants.f.a);
        this.f61752i = this.f61749f.getDownloadListeners(com.ss.android.socialbase.downloader.constants.f.f61677c);
        this.f61751h = this.f61749f.getDownloadListeners(com.ss.android.socialbase.downloader.constants.f.f61676b);
        this.p = this.f61749f.getDepend();
        this.q = this.f61749f.getMonitorDepend();
    }

    private void k() {
        ExecutorService l;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65551, this) == null) || (l = c.l()) == null) {
            return;
        }
        l.execute(new Runnable(this) { // from class: com.ss.android.socialbase.downloader.downloader.f.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ f a;

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
                this.a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.a.f61747d.i(this.a.f61746c.getId());
                    this.a.a(1, (BaseException) null);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
            try {
                com.ss.android.socialbase.downloader.c.a.b(a, "saveFileAsTargetName onSuccess");
                try {
                    m();
                    this.f61746c.setFirstSuccess(false);
                    this.f61746c.setSuccessByCache(false);
                    a(-3, (BaseException) null);
                    this.f61747d.c(this.f61746c.getId(), this.f61746c.getTotalBytes());
                    this.f61747d.d(this.f61746c.getId());
                    this.f61747d.m(this.f61746c.getId());
                } catch (BaseException e2) {
                    a(e2);
                }
            } catch (Throwable th) {
                a(new BaseException(1008, com.ss.android.socialbase.downloader.i.f.b(th, "onCompleted")));
            }
        }
    }

    private void m() throws BaseException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            List<com.ss.android.socialbase.downloader.depend.m> downloadCompleteHandlers = this.f61749f.getDownloadCompleteHandlers();
            if (downloadCompleteHandlers.isEmpty()) {
                return;
            }
            DownloadInfo downloadInfo = this.f61746c;
            a(11, (BaseException) null);
            this.f61747d.a(downloadInfo);
            for (com.ss.android.socialbase.downloader.depend.m mVar : downloadCompleteHandlers) {
                try {
                    if (mVar.b(downloadInfo)) {
                        mVar.a(downloadInfo);
                        this.f61747d.a(downloadInfo);
                    }
                } catch (BaseException e2) {
                    throw e2;
                } catch (Throwable th) {
                    throw new BaseException((int) RevenueServerConst.GetBannerConfigRequest, th);
                }
            }
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f61746c.setStatus(-2);
            try {
                this.f61747d.d(this.f61746c.getId(), this.f61746c.getCurBytes());
            } catch (SQLiteException e2) {
                e2.printStackTrace();
            }
            a(-2, (BaseException) null);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f61746c.setStatus(-7);
            try {
                this.f61747d.j(this.f61746c.getId());
            } catch (SQLiteException e2) {
                e2.printStackTrace();
            }
            a(-7, (BaseException) null);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f61746c.setFirstDownload(false);
            if (!this.f61746c.isIgnoreDataVerify() && this.f61746c.getCurBytes() != this.f61746c.getTotalBytes()) {
                com.ss.android.socialbase.downloader.c.a.b(a, this.f61746c.getErrorBytesLog());
                a(new com.ss.android.socialbase.downloader.exception.f(ARPMessageType.MSG_TYPE_VIDEO_STOP, "current bytes is not equals to total bytes, bytes changed with process : " + this.f61746c.getByteInvalidRetryStatus()));
            } else if (this.f61746c.getCurBytes() <= 0) {
                com.ss.android.socialbase.downloader.c.a.b(a, this.f61746c.getErrorBytesLog());
                a(new com.ss.android.socialbase.downloader.exception.f(1026, "curBytes is 0, bytes changed with process : " + this.f61746c.getByteInvalidRetryStatus()));
            } else if (!this.f61746c.isIgnoreDataVerify() && this.f61746c.getTotalBytes() <= 0) {
                com.ss.android.socialbase.downloader.c.a.b(a, this.f61746c.getErrorBytesLog());
                a(new com.ss.android.socialbase.downloader.exception.f(1044, "TotalBytes is 0, bytes changed with process : " + this.f61746c.getByteInvalidRetryStatus()));
            } else {
                String str = a;
                com.ss.android.socialbase.downloader.c.a.b(str, "" + this.f61746c.getName() + " onCompleted start save file as target name");
                x xVar = this.q;
                DownloadTask downloadTask = this.f61749f;
                if (downloadTask != null) {
                    xVar = downloadTask.getMonitorDepend();
                }
                com.ss.android.socialbase.downloader.i.f.a(this.f61746c, xVar, new ai(this) { // from class: com.ss.android.socialbase.downloader.downloader.f.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ f a;

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
                        this.a = this;
                    }

                    @Override // com.ss.android.socialbase.downloader.depend.ai
                    public void a() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.a.l();
                        }
                    }

                    @Override // com.ss.android.socialbase.downloader.depend.ai
                    public void a(BaseException baseException) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, baseException) == null) {
                            String str2 = f.a;
                            StringBuilder sb = new StringBuilder();
                            sb.append("saveFileAsTargetName onFailed : ");
                            sb.append(baseException != null ? baseException.getErrorMessage() : "");
                            com.ss.android.socialbase.downloader.c.a.b(str2, sb.toString());
                            this.a.a(baseException);
                        }
                    }
                });
            }
        }
    }

    public void g() throws BaseException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            if (this.f61745b) {
                m();
                com.ss.android.socialbase.downloader.c.a.b(a, "onCompleteForFileExist");
                this.f61746c.setSuccessByCache(true);
                a(-3, (BaseException) null);
                this.f61747d.c(this.f61746c.getId(), this.f61746c.getTotalBytes());
                this.f61747d.d(this.f61746c.getId());
                this.f61747d.a(this.f61746c);
                this.f61747d.m(this.f61746c.getId());
                return;
            }
            m();
            com.ss.android.socialbase.downloader.c.a.b(a, "onCompleteForFileExist");
            this.f61746c.setSuccessByCache(true);
            a(-3, (BaseException) null);
            this.f61747d.c(this.f61746c.getId(), this.f61746c.getTotalBytes());
            this.f61747d.d(this.f61746c.getId());
            this.f61747d.m(this.f61746c.getId());
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f61746c.setStatus(8);
            this.f61746c.setAsyncHandleStatus(com.ss.android.socialbase.downloader.constants.a.f61651b);
            com.ss.android.socialbase.downloader.impls.a C = c.C();
            if (C != null) {
                C.a(this.f61746c.getId(), this.f61749f.getHashCodeForSameTask(), 8);
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.f61746c.canSkipStatusHandler()) {
                this.f61746c.changeSkipStatus();
                return;
            }
            this.f61747d.g(this.f61746c.getId());
            if (this.f61746c.isFirstDownload()) {
                a(6, (BaseException) null);
            }
            a(2, (BaseException) null);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            a(-4, (BaseException) null);
        }
    }

    private BaseException c(BaseException baseException) {
        InterceptResult invokeL;
        Context N;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, this, baseException)) == null) {
            if (com.ss.android.socialbase.downloader.g.a.a(this.f61746c.getId()).a("download_failed_check_net", 1) != 1 || !com.ss.android.socialbase.downloader.i.f.i(baseException) || (N = c.N()) == null || com.ss.android.socialbase.downloader.i.f.c(N)) {
                return baseException;
            }
            return new BaseException(this.f61746c.isOnlyWifi() ? 1013 : 1049, baseException.getErrorMessage());
        }
        return (BaseException) invokeL.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f61746c.canSkipStatusHandler()) {
            return;
        }
        this.f61746c.setStatus(1);
        k();
    }

    public void a(long j2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j2), str, str2}) == null) {
            this.f61746c.setTotalBytes(j2);
            this.f61746c.seteTag(str);
            if (!TextUtils.isEmpty(str2) && TextUtils.isEmpty(this.f61746c.getName())) {
                this.f61746c.setName(str2);
            }
            try {
                this.f61747d.a(this.f61746c.getId(), j2, str, str2);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            a(3, (BaseException) null);
            this.o = this.f61746c.getMinByteIntervalForPostToMainThread(j2);
            this.n = this.f61746c.getMinProgressTimeMsInterval();
            this.f61753j = true;
            com.ss.android.socialbase.downloader.impls.r.a().e();
        }
    }

    private void b(BaseException baseException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, baseException) == null) {
            String str = "handleError::" + baseException + " \r\n" + Log.getStackTraceString(new Throwable());
            if (baseException != null && baseException.getCause() != null && (baseException.getCause() instanceof SQLiteFullException)) {
                try {
                    this.f61747d.f(this.f61746c.getId());
                } catch (SQLiteException e2) {
                    e2.printStackTrace();
                }
            } else {
                try {
                    try {
                        this.f61747d.b(this.f61746c.getId(), this.f61746c.getCurBytes());
                    } catch (SQLiteException unused) {
                        this.f61747d.f(this.f61746c.getId());
                    }
                } catch (SQLiteException e3) {
                    e3.printStackTrace();
                }
            }
            BaseException c2 = c(baseException);
            this.f61746c.setFailedException(c2);
            a(c2 instanceof com.ss.android.socialbase.downloader.exception.e ? -2 : -1, c2);
            if (com.ss.android.socialbase.downloader.g.a.a(this.f61746c.getId()).a("retry_schedule", 0) > 0) {
                com.ss.android.socialbase.downloader.impls.r.a().a(this.f61746c);
            }
        }
    }

    public boolean a(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048582, this, j2)) == null) {
            this.l.addAndGet(j2);
            this.f61746c.increaseCurBytes(j2);
            long uptimeMillis = SystemClock.uptimeMillis();
            return a(uptimeMillis, b(uptimeMillis));
        }
        return invokeJ.booleanValue;
    }

    private boolean b(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65546, this, j2)) == null) {
            boolean z = true;
            if (!this.m) {
                this.m = true;
                return true;
            }
            long j3 = j2 - this.f61754k;
            if (this.l.get() < this.o && j3 < this.n) {
                z = false;
            }
            if (z) {
                this.f61754k = j2;
                this.l.set(0L);
            }
            return z;
        }
        return invokeJ.booleanValue;
    }

    public void a(BaseException baseException, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048579, this, baseException, z) == null) {
            this.f61746c.setFirstDownload(false);
            this.l.set(0L);
            b(baseException, z);
        }
    }

    public void a(com.ss.android.socialbase.downloader.model.b bVar, BaseException baseException, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048580, this, bVar, baseException, z) == null) {
            this.f61746c.setFirstDownload(false);
            this.l.set(0L);
            this.f61747d.h(this.f61746c.getId());
            a(z ? 10 : 9, baseException, true);
        }
    }

    private void b(BaseException baseException, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65545, this, baseException, z) == null) {
            this.f61747d.h(this.f61746c.getId());
            a(z ? 7 : 5, baseException);
        }
    }

    public void a(BaseException baseException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, baseException) == null) {
            this.f61746c.setFirstDownload(false);
            b(baseException);
        }
    }

    public void a(String str) throws BaseException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            String str2 = a;
            com.ss.android.socialbase.downloader.c.a.b(str2, "onCompleteForFileExist existTargetFileName is " + str + " but curName is " + this.f61746c.getName());
            if (this.f61745b) {
                com.ss.android.socialbase.downloader.i.f.a(this.f61746c, str);
                m();
                this.f61746c.setSuccessByCache(true);
                a(-3, (BaseException) null);
                this.f61747d.a(this.f61746c);
                return;
            }
            this.f61747d.a(this.f61746c);
            com.ss.android.socialbase.downloader.i.f.a(this.f61746c, str);
            this.f61746c.setSuccessByCache(true);
            m();
            a(-3, (BaseException) null);
        }
    }

    private boolean a(long j2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, this, new Object[]{Long.valueOf(j2), Boolean.valueOf(z)})) == null) {
            boolean z2 = false;
            if (this.f61746c.getCurBytes() == this.f61746c.getTotalBytes()) {
                try {
                    this.f61747d.a(this.f61746c.getId(), this.f61746c.getCurBytes());
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                return false;
            }
            if (this.f61753j) {
                this.f61753j = false;
                this.f61746c.setStatus(4);
            }
            if (this.f61746c.isNeedPostProgress() && z) {
                z2 = true;
            }
            a(4, (BaseException) null, z2);
            return z;
        }
        return invokeCommon.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, BaseException baseException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65539, this, i2, baseException) == null) {
            a(i2, baseException, true);
        }
    }

    private void a(int i2, BaseException baseException, boolean z) {
        SparseArray<IDownloadListener> sparseArray;
        SparseArray<IDownloadListener> sparseArray2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{Integer.valueOf(i2), baseException, Boolean.valueOf(z)}) == null) {
            int status = this.f61746c.getStatus();
            if (status == -3 && i2 == 4) {
                return;
            }
            j();
            if (i2 != 4 && DownloadStatus.isRealTimeUploadStatus(i2)) {
                this.f61746c.updateRealDownloadTime(false);
                if (DownloadStatus.isTimeUploadStatus(i2)) {
                    this.f61746c.updateDownloadTime();
                }
            }
            if (!this.f61746c.isAddListenerToSameTask()) {
                com.ss.android.socialbase.downloader.d.a.a(this.f61749f, baseException, i2);
            }
            if (i2 == 6) {
                this.f61746c.setStatus(2);
            } else if (i2 == -6) {
                this.f61746c.setStatus(-3);
            } else {
                this.f61746c.setStatus(i2);
            }
            if (status == -3 || status == -1) {
                if (this.f61746c.getRetryDelayStatus() == com.ss.android.socialbase.downloader.constants.g.f61680c) {
                    this.f61746c.setRetryDelayStatus(com.ss.android.socialbase.downloader.constants.g.f61681d);
                }
                if (this.f61746c.getAsyncHandleStatus() == com.ss.android.socialbase.downloader.constants.a.f61653d) {
                    this.f61746c.setAsyncHandleStatus(com.ss.android.socialbase.downloader.constants.a.f61654e);
                }
                if (this.f61746c.getByteInvalidRetryStatus() == com.ss.android.socialbase.downloader.constants.b.f61657c) {
                    this.f61746c.setByteInvalidRetryStatus(com.ss.android.socialbase.downloader.constants.b.f61658d);
                }
            }
            com.ss.android.socialbase.downloader.i.c.a(i2, this.f61751h, true, this.f61746c, baseException);
            if (i2 == -4) {
                return;
            }
            if (z && this.f61748e != null && (((sparseArray = this.f61750g) != null && sparseArray.size() > 0) || ((sparseArray2 = this.f61752i) != null && sparseArray2.size() > 0 && (this.f61746c.canShowNotification() || this.f61746c.isAutoInstallWithoutNotification())))) {
                this.f61748e.obtainMessage(i2, this.f61746c.getId(), this.f61749f.getHashCodeForSameTask(), baseException).sendToTarget();
                return;
            }
            com.ss.android.socialbase.downloader.impls.a C = c.C();
            if (C != null) {
                C.a(this.f61746c.getId(), this.f61749f.getHashCodeForSameTask(), i2);
            }
        }
    }
}
