package d.l.a.e.b.g;

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
import com.baidu.mobads.container.util.SDKLogTypeConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.RevenueServerConst;
import d.l.a.e.b.f.z;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes8.dex */
public class h {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String p = "h";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final boolean f72242a;

    /* renamed from: b  reason: collision with root package name */
    public DownloadInfo f72243b;

    /* renamed from: c  reason: collision with root package name */
    public final k f72244c;

    /* renamed from: d  reason: collision with root package name */
    public final Handler f72245d;

    /* renamed from: e  reason: collision with root package name */
    public d.l.a.e.b.n.a f72246e;

    /* renamed from: f  reason: collision with root package name */
    public SparseArray<d.l.a.e.b.f.c> f72247f;

    /* renamed from: g  reason: collision with root package name */
    public SparseArray<d.l.a.e.b.f.c> f72248g;

    /* renamed from: h  reason: collision with root package name */
    public SparseArray<d.l.a.e.b.f.c> f72249h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f72250i;
    public volatile long j;
    public final AtomicLong k;
    public boolean l;
    public int m;
    public long n;
    public z o;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f72251e;

        public a(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f72251e = hVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f72251e.f72244c.i(this.f72251e.f72243b.getId());
                this.f72251e.c(1, null);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements d.l.a.e.b.f.l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h f72252a;

        public b(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f72252a = hVar;
        }

        @Override // d.l.a.e.b.f.l
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f72252a.C();
            }
        }

        @Override // d.l.a.e.b.f.l
        public void a(BaseException baseException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, baseException) == null) {
                String str = h.p;
                StringBuilder sb = new StringBuilder();
                sb.append("saveFileAsTargetName onFailed : ");
                sb.append(baseException != null ? baseException.getErrorMessage() : "");
                d.l.a.e.b.c.a.g(str, sb.toString());
                this.f72252a.g(baseException);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1799599226, "Ld/l/a/e/b/g/h;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1799599226, "Ld/l/a/e/b/g/h;");
        }
    }

    public h(d.l.a.e.b.n.a aVar, Handler handler) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, handler};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f72250i = false;
        this.j = 0L;
        this.k = new AtomicLong();
        this.l = false;
        this.f72246e = aVar;
        A();
        this.f72245d = handler;
        this.f72244c = e.M0();
        DownloadInfo J = aVar.J();
        if (J != null) {
            this.f72242a = d.l.a.e.b.j.a.d(J.getId()).l("fix_start_with_file_exist_update_error");
        } else {
            this.f72242a = false;
        }
    }

    public final void A() {
        d.l.a.e.b.n.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (aVar = this.f72246e) == null) {
            return;
        }
        this.f72243b = aVar.J();
        this.f72247f = this.f72246e.M(com.ss.android.socialbase.downloader.constants.f.f38646a);
        this.f72249h = this.f72246e.M(com.ss.android.socialbase.downloader.constants.f.f38648c);
        this.f72248g = this.f72246e.M(com.ss.android.socialbase.downloader.constants.f.f38647b);
        this.f72246e.E();
        this.o = this.f72246e.R();
    }

    public final void B() {
        ExecutorService A0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (A0 = e.A0()) == null) {
            return;
        }
        A0.execute(new a(this));
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            try {
                d.l.a.e.b.c.a.g(p, "saveFileAsTargetName onSuccess");
                try {
                    D();
                    this.f72243b.setFirstSuccess(false);
                    this.f72243b.setSuccessByCache(false);
                    c(-3, null);
                    this.f72244c.c(this.f72243b.getId(), this.f72243b.getTotalBytes());
                    this.f72244c.d(this.f72243b.getId());
                    this.f72244c.m(this.f72243b.getId());
                } catch (BaseException e2) {
                    g(e2);
                }
            } catch (Throwable th) {
                g(new BaseException(1008, d.l.a.e.b.l.f.a0(th, "onCompleted")));
            }
        }
    }

    public final void D() throws BaseException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            List<d.l.a.e.b.f.r> H = this.f72246e.H();
            if (H.isEmpty()) {
                return;
            }
            DownloadInfo downloadInfo = this.f72243b;
            c(11, null);
            this.f72244c.a(downloadInfo);
            for (d.l.a.e.b.f.r rVar : H) {
                try {
                    if (rVar.b(downloadInfo)) {
                        rVar.a(downloadInfo);
                        this.f72244c.a(downloadInfo);
                    }
                } catch (BaseException e2) {
                    throw e2;
                } catch (Throwable th) {
                    throw new BaseException((int) RevenueServerConst.GetBannerConfigRequest, th);
                }
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f72243b.canSkipStatusHandler()) {
            return;
        }
        this.f72243b.setStatus(1);
        B();
    }

    public final void c(int i2, BaseException baseException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i2, baseException) == null) {
            d(i2, baseException, true);
        }
    }

    public final void d(int i2, BaseException baseException, boolean z) {
        SparseArray<d.l.a.e.b.f.c> sparseArray;
        SparseArray<d.l.a.e.b.f.c> sparseArray2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), baseException, Boolean.valueOf(z)}) == null) {
            int status = this.f72243b.getStatus();
            if (status == -3 && i2 == 4) {
                return;
            }
            A();
            if (i2 != 4 && d.l.a.e.b.d.a.e(i2)) {
                this.f72243b.updateRealDownloadTime(false);
                if (d.l.a.e.b.d.a.f(i2)) {
                    this.f72243b.updateDownloadTime();
                }
            }
            if (!this.f72243b.isAddListenerToSameTask()) {
                d.l.a.e.b.e.a.i(this.f72246e, baseException, i2);
            }
            if (i2 == 6) {
                this.f72243b.setStatus(2);
            } else if (i2 == -6) {
                this.f72243b.setStatus(-3);
            } else {
                this.f72243b.setStatus(i2);
            }
            if (status == -3 || status == -1) {
                if (this.f72243b.getRetryDelayStatus() == com.ss.android.socialbase.downloader.constants.g.f38652c) {
                    this.f72243b.setRetryDelayStatus(com.ss.android.socialbase.downloader.constants.g.f38653d);
                }
                if (this.f72243b.getAsyncHandleStatus() == com.ss.android.socialbase.downloader.constants.a.f38634d) {
                    this.f72243b.setAsyncHandleStatus(com.ss.android.socialbase.downloader.constants.a.f38635e);
                }
                if (this.f72243b.getByteInvalidRetryStatus() == com.ss.android.socialbase.downloader.constants.b.f38639c) {
                    this.f72243b.setByteInvalidRetryStatus(com.ss.android.socialbase.downloader.constants.b.f38640d);
                }
            }
            d.l.a.e.b.l.c.a(i2, this.f72248g, true, this.f72243b, baseException);
            if (i2 == -4) {
                return;
            }
            if (z && this.f72245d != null && (((sparseArray = this.f72247f) != null && sparseArray.size() > 0) || ((sparseArray2 = this.f72249h) != null && sparseArray2.size() > 0 && (this.f72243b.canShowNotification() || this.f72243b.isAutoInstallWithoutNotification())))) {
                this.f72245d.obtainMessage(i2, this.f72243b.getId(), this.f72246e.P(), baseException).sendToTarget();
                return;
            }
            d.l.a.e.b.m.a c2 = e.c();
            if (c2 != null) {
                c2.e(this.f72243b.getId(), this.f72246e.P(), i2);
            }
        }
    }

    public void e(long j, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Long.valueOf(j), str, str2}) == null) {
            this.f72243b.setTotalBytes(j);
            this.f72243b.seteTag(str);
            if (!TextUtils.isEmpty(str2) && TextUtils.isEmpty(this.f72243b.getName())) {
                this.f72243b.setName(str2);
            }
            try {
                this.f72244c.a(this.f72243b.getId(), j, str, str2);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            c(3, null);
            this.n = this.f72243b.getMinByteIntervalForPostToMainThread(j);
            this.m = this.f72243b.getMinProgressTimeMsInterval();
            this.f72250i = true;
            d.l.a.e.b.m.q.d().y();
        }
    }

    public void g(BaseException baseException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, baseException) == null) {
            this.f72243b.setFirstDownload(false);
            o(baseException);
        }
    }

    public void h(BaseException baseException, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048585, this, baseException, z) == null) {
            this.f72243b.setFirstDownload(false);
            this.k.set(0L);
            p(baseException, z);
        }
    }

    public void i(com.ss.android.socialbase.downloader.model.b bVar, BaseException baseException, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048586, this, bVar, baseException, z) == null) {
            this.f72243b.setFirstDownload(false);
            this.k.set(0L);
            this.f72244c.h(this.f72243b.getId());
            d(z ? 10 : 9, baseException, true);
        }
    }

    public void j(String str) throws BaseException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            String str2 = p;
            d.l.a.e.b.c.a.g(str2, "onCompleteForFileExist existTargetFileName is " + str + " but curName is " + this.f72243b.getName());
            if (this.f72242a) {
                d.l.a.e.b.l.f.y(this.f72243b, str);
                D();
                this.f72243b.setSuccessByCache(true);
                c(-3, null);
                this.f72244c.a(this.f72243b);
                return;
            }
            this.f72244c.a(this.f72243b);
            d.l.a.e.b.l.f.y(this.f72243b, str);
            this.f72243b.setSuccessByCache(true);
            D();
            c(-3, null);
        }
    }

    public boolean k(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048588, this, j)) == null) {
            this.k.addAndGet(j);
            this.f72243b.increaseCurBytes(j);
            long uptimeMillis = SystemClock.uptimeMillis();
            return l(uptimeMillis, q(uptimeMillis));
        }
        return invokeJ.booleanValue;
    }

    public final boolean l(long j, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)})) == null) {
            boolean z2 = false;
            if (this.f72243b.getCurBytes() == this.f72243b.getTotalBytes()) {
                try {
                    this.f72244c.a(this.f72243b.getId(), this.f72243b.getCurBytes());
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                return false;
            }
            if (this.f72250i) {
                this.f72250i = false;
                this.f72243b.setStatus(4);
            }
            if (this.f72243b.isNeedPostProgress() && z) {
                z2 = true;
            }
            d(4, null, z2);
            return z;
        }
        return invokeCommon.booleanValue;
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            if (this.f72243b.canSkipStatusHandler()) {
                this.f72243b.changeSkipStatus();
                return;
            }
            this.f72244c.g(this.f72243b.getId());
            if (this.f72243b.isFirstDownload()) {
                c(6, null);
            }
            c(2, null);
        }
    }

    public final void o(BaseException baseException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, baseException) == null) {
            String str = p;
            Log.d(str, "handleError::" + baseException + " \r\n" + Log.getStackTraceString(new Throwable()));
            if (baseException != null && baseException.getCause() != null && (baseException.getCause() instanceof SQLiteFullException)) {
                try {
                    this.f72244c.f(this.f72243b.getId());
                } catch (SQLiteException e2) {
                    e2.printStackTrace();
                }
            } else {
                try {
                    try {
                        this.f72244c.b(this.f72243b.getId(), this.f72243b.getCurBytes());
                    } catch (SQLiteException e3) {
                        e3.printStackTrace();
                    }
                } catch (SQLiteException unused) {
                    this.f72244c.f(this.f72243b.getId());
                }
            }
            BaseException r = r(baseException);
            this.f72243b.setFailedException(r);
            c(r instanceof com.ss.android.socialbase.downloader.exception.e ? -2 : -1, r);
            if (d.l.a.e.b.j.a.d(this.f72243b.getId()).b("retry_schedule", 0) > 0) {
                d.l.a.e.b.m.q.d().k(this.f72243b);
            }
        }
    }

    public final void p(BaseException baseException, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048592, this, baseException, z) == null) {
            this.f72244c.h(this.f72243b.getId());
            c(z ? 7 : 5, baseException);
        }
    }

    public final boolean q(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048593, this, j)) == null) {
            boolean z = true;
            if (!this.l) {
                this.l = true;
                return true;
            }
            long j2 = j - this.j;
            if (this.k.get() < this.n && j2 < this.m) {
                z = false;
            }
            if (z) {
                this.j = j;
                this.k.set(0L);
            }
            return z;
        }
        return invokeJ.booleanValue;
    }

    public final BaseException r(BaseException baseException) {
        InterceptResult invokeL;
        Context n;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, baseException)) == null) {
            if (d.l.a.e.b.j.a.d(this.f72243b.getId()).b("download_failed_check_net", 1) != 1 || !d.l.a.e.b.l.f.Y0(baseException) || (n = e.n()) == null || d.l.a.e.b.l.f.r0(n)) {
                return baseException;
            }
            return new BaseException(this.f72243b.isOnlyWifi() ? 1013 : SDKLogTypeConstants.TYPE_LP_LOAD_URL, baseException.getErrorMessage());
        }
        return (BaseException) invokeL.objValue;
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            c(-4, null);
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.f72243b.setStatus(-2);
            try {
                this.f72244c.d(this.f72243b.getId(), this.f72243b.getCurBytes());
            } catch (SQLiteException e2) {
                e2.printStackTrace();
            }
            c(-2, null);
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.f72243b.setStatus(-7);
            try {
                this.f72244c.j(this.f72243b.getId());
            } catch (SQLiteException e2) {
                e2.printStackTrace();
            }
            c(-7, null);
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.f72243b.setFirstDownload(false);
            if (!this.f72243b.isIgnoreDataVerify() && this.f72243b.getCurBytes() != this.f72243b.getTotalBytes()) {
                d.l.a.e.b.c.a.g(p, this.f72243b.getErrorBytesLog());
                g(new com.ss.android.socialbase.downloader.exception.f(1027, "current bytes is not equals to total bytes, bytes changed with process : " + this.f72243b.getByteInvalidRetryStatus()));
            } else if (this.f72243b.getCurBytes() <= 0) {
                d.l.a.e.b.c.a.g(p, this.f72243b.getErrorBytesLog());
                g(new com.ss.android.socialbase.downloader.exception.f(1026, "curBytes is 0, bytes changed with process : " + this.f72243b.getByteInvalidRetryStatus()));
            } else if (!this.f72243b.isIgnoreDataVerify() && this.f72243b.getTotalBytes() <= 0) {
                d.l.a.e.b.c.a.g(p, this.f72243b.getErrorBytesLog());
                g(new com.ss.android.socialbase.downloader.exception.f(1044, "TotalBytes is 0, bytes changed with process : " + this.f72243b.getByteInvalidRetryStatus()));
            } else {
                String str = p;
                d.l.a.e.b.c.a.g(str, "" + this.f72243b.getName() + " onCompleted start save file as target name");
                z zVar = this.o;
                d.l.a.e.b.n.a aVar = this.f72246e;
                if (aVar != null) {
                    zVar = aVar.R();
                }
                d.l.a.e.b.l.f.x(this.f72243b, zVar, new b(this));
            }
        }
    }

    public void x() throws BaseException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            if (this.f72242a) {
                D();
                d.l.a.e.b.c.a.g(p, "onCompleteForFileExist");
                this.f72243b.setSuccessByCache(true);
                c(-3, null);
                this.f72244c.c(this.f72243b.getId(), this.f72243b.getTotalBytes());
                this.f72244c.d(this.f72243b.getId());
                this.f72244c.a(this.f72243b);
                this.f72244c.m(this.f72243b.getId());
                return;
            }
            D();
            d.l.a.e.b.c.a.g(p, "onCompleteForFileExist");
            this.f72243b.setSuccessByCache(true);
            c(-3, null);
            this.f72244c.c(this.f72243b.getId(), this.f72243b.getTotalBytes());
            this.f72244c.d(this.f72243b.getId());
            this.f72244c.m(this.f72243b.getId());
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            this.f72243b.setStatus(8);
            this.f72243b.setAsyncHandleStatus(com.ss.android.socialbase.downloader.constants.a.f38632b);
            d.l.a.e.b.m.a c2 = e.c();
            if (c2 != null) {
                c2.e(this.f72243b.getId(), this.f72246e.P(), 8);
            }
        }
    }
}
