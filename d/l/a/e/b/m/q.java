package d.l.a.e.b.m;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.l.a.e.b.a.a;
import d.l.a.e.b.g.r;
import java.util.ArrayList;
import java.util.Collections;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class q implements Handler.Callback, a.b {
    public static /* synthetic */ Interceptable $ic;
    public static volatile q l;
    public static e m;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final Context f74930e;

    /* renamed from: f  reason: collision with root package name */
    public final Handler f74931f;

    /* renamed from: g  reason: collision with root package name */
    public final SparseArray<d> f74932g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f74933h;

    /* renamed from: i  reason: collision with root package name */
    public long f74934i;
    public int j;
    public ConnectivityManager k;

    /* loaded from: classes10.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ q f74935e;

        /* renamed from: d.l.a.e.b.m.q$a$a  reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        public class C2077a extends ConnectivityManager.NetworkCallback {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f74936a;

            public C2077a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f74936a = aVar;
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onAvailable(Network network) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, network) == null) {
                    d.l.a.e.b.c.a.g("RetryScheduler", "network onAvailable: ");
                    this.f74936a.f74935e.g(1, true);
                }
            }
        }

        public a(q qVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f74935e = qVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.f74935e.f74930e == null || Build.VERSION.SDK_INT < 21) {
                        return;
                    }
                    this.f74935e.k = (ConnectivityManager) this.f74935e.f74930e.getApplicationContext().getSystemService("connectivity");
                    this.f74935e.k.registerNetworkCallback(new NetworkRequest.Builder().build(), new C2077a(this));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f74937e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f74938f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ q f74939g;

        public b(q qVar, int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qVar, Integer.valueOf(i2), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f74939g = qVar;
            this.f74937e = i2;
            this.f74938f = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            int A;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.f74939g.j > 0 && (A = this.f74939g.A()) != 0) {
                        d.l.a.e.b.c.a.i("RetryScheduler", "doScheduleAllTaskRetry: mWaitingRetryTasksCount = " + this.f74939g.j);
                        long currentTimeMillis = System.currentTimeMillis();
                        ArrayList<d> arrayList = new ArrayList();
                        synchronized (this.f74939g.f74932g) {
                            for (int i2 = 0; i2 < this.f74939g.f74932g.size(); i2++) {
                                d dVar = (d) this.f74939g.f74932g.valueAt(i2);
                                if (dVar != null && dVar.d(currentTimeMillis, this.f74937e, A, this.f74938f)) {
                                    if (this.f74938f) {
                                        dVar.i();
                                    }
                                    arrayList.add(dVar);
                                }
                            }
                        }
                        if (arrayList.size() > 0) {
                            for (d dVar2 : arrayList) {
                                this.f74939g.f(dVar2.f74942a, A, false);
                            }
                        }
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f74940e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ q f74941f;

        public c(q qVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f74941f = qVar;
            this.f74940e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.f74941f.f(this.f74940e, this.f74941f.A(), true);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final int f74942a;

        /* renamed from: b  reason: collision with root package name */
        public final int f74943b;

        /* renamed from: c  reason: collision with root package name */
        public final int f74944c;

        /* renamed from: d  reason: collision with root package name */
        public final int f74945d;

        /* renamed from: e  reason: collision with root package name */
        public final int f74946e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f74947f;

        /* renamed from: g  reason: collision with root package name */
        public final int[] f74948g;

        /* renamed from: h  reason: collision with root package name */
        public int f74949h;

        /* renamed from: i  reason: collision with root package name */
        public int f74950i;
        public boolean j;
        public long k;
        public boolean l;

        public d(int i2, int i3, int i4, int i5, int i6, boolean z, int[] iArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Boolean.valueOf(z), iArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i7 = newInitContext.flag;
                if ((i7 & 1) != 0) {
                    int i8 = i7 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            i5 = i5 < 3000 ? 3000 : i5;
            i6 = i6 < 5000 ? 5000 : i6;
            this.f74942a = i2;
            this.f74943b = i3;
            this.f74944c = i4;
            this.f74945d = i5;
            this.f74946e = i6;
            this.f74947f = z;
            this.f74948g = iArr;
            this.f74949h = i5;
        }

        public synchronized void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this) {
                    this.f74949h += this.f74946e;
                }
            }
        }

        public synchronized void c(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                synchronized (this) {
                    this.k = j;
                }
            }
        }

        public boolean d(long j, int i2, int i3, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)})) == null) {
                if (!this.l) {
                    d.l.a.e.b.c.a.i("RetryScheduler", "canRetry: mIsWaitingRetry is false, return false!!!");
                    return false;
                } else if (this.f74943b >= i2 && this.f74950i < this.f74944c) {
                    if (!this.j || i3 == 2) {
                        return z || j - this.k >= ((long) this.f74945d);
                    }
                    return false;
                } else {
                    return false;
                }
            }
            return invokeCommon.booleanValue;
        }

        public synchronized void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                synchronized (this) {
                    this.f74950i++;
                }
            }
        }

        public void i() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.f74949h = this.f74945d;
            }
        }

        public int j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f74949h : invokeV.intValue;
        }
    }

    /* loaded from: classes10.dex */
    public interface e {
        void a(DownloadInfo downloadInfo, long j, boolean z, int i2);
    }

    public q() {
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
        this.f74931f = new Handler(Looper.getMainLooper(), this);
        this.f74932g = new SparseArray<>();
        this.j = 0;
        this.f74930e = d.l.a.e.b.g.e.n();
        z();
        this.f74933h = d.l.a.e.b.l.f.p0();
        d.l.a.e.b.a.a.c().f(this);
    }

    public static q d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (l == null) {
                synchronized (q.class) {
                    if (l == null) {
                        l = new q();
                    }
                }
            }
            return l;
        }
        return (q) invokeV.objValue;
    }

    public static void h(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65540, null, eVar) == null) {
            m = eVar;
        }
    }

    public final int A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                if (this.k == null) {
                    this.k = (ConnectivityManager) this.f74930e.getApplicationContext().getSystemService("connectivity");
                }
                NetworkInfo activeNetworkInfo = this.k.getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                    return activeNetworkInfo.getType() == 1 ? 2 : 1;
                }
            } catch (Exception unused) {
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // d.l.a.e.b.a.a.b
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            g(3, false);
        }
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            d.l.a.e.b.g.e.A0().execute(new c(this, i2));
        }
    }

    public final void f(int i2, int i3, boolean z) {
        Context context;
        r n;
        boolean z2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)}) == null) || (context = this.f74930e) == null) {
            return;
        }
        synchronized (this.f74932g) {
            d dVar = this.f74932g.get(i2);
            if (dVar == null) {
                return;
            }
            boolean z3 = true;
            if (dVar.l) {
                dVar.l = false;
                int i4 = this.j - 1;
                this.j = i4;
                if (i4 < 0) {
                    this.j = 0;
                }
            }
            d.l.a.e.b.c.a.i("RetryScheduler", "doSchedulerRetryInSubThread: downloadId = " + i2 + ", retryCount = " + dVar.f74950i + ", mWaitingRetryTasksCount = " + this.j);
            DownloadInfo f2 = d.l.a.e.b.g.a.H(context).f(i2);
            if (f2 == null) {
                t(i2);
                return;
            }
            d.l.a.e.b.c.a.k("RetryScheduler", "doSchedulerRetryInSubThread，id:" + i2);
            int realStatus = f2.getRealStatus();
            if (realStatus != -3 && realStatus != -4) {
                if (realStatus == -5 || (realStatus == -2 && f2.isPauseReserveOnWifi())) {
                    if (realStatus == -2 && (n = d.l.a.e.b.g.a.H(d.l.a.e.b.g.e.n()).n()) != null) {
                        n.a(f2, 4, 3);
                    }
                    d.l.a.e.b.g.m L0 = d.l.a.e.b.g.e.L0();
                    if (L0 != null) {
                        L0.a(Collections.singletonList(f2), 3);
                    }
                    t(i2);
                    return;
                } else if (realStatus != -1) {
                    return;
                } else {
                    if (i3 != 0) {
                        z2 = true;
                    } else if (!dVar.f74947f) {
                        return;
                    } else {
                        z2 = false;
                    }
                    BaseException failedException = f2.getFailedException();
                    if (z2 && d.l.a.e.b.l.f.V0(failedException)) {
                        z2 = n(f2, failedException);
                    }
                    dVar.f();
                    if (z2) {
                        d.l.a.e.b.c.a.i("RetryScheduler", "doSchedulerRetry: restart task, ****** id = " + dVar.f74942a);
                        dVar.c(System.currentTimeMillis());
                        if (z) {
                            dVar.b();
                        }
                        f2.setRetryScheduleCount(dVar.f74950i);
                        if (f2.getStatus() == -1) {
                            d.l.a.e.b.g.a.H(context).y(f2.getId());
                            return;
                        }
                        return;
                    }
                    if (z) {
                        dVar.b();
                    }
                    if (!f2.isOnlyWifi() && !f2.isPauseReserveOnWifi()) {
                        z3 = false;
                    }
                    l(f2, z3, i3);
                    return;
                }
            }
            t(i2);
        }
    }

    public final void g(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || this.j <= 0) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this) {
            if (!z) {
                if (currentTimeMillis - this.f74934i < 10000) {
                    return;
                }
            }
            this.f74934i = currentTimeMillis;
            d.l.a.e.b.c.a.i("RetryScheduler", "scheduleAllTaskRetry, level = [" + i2 + "], force = [" + z + PreferencesUtil.RIGHT_MOUNT);
            if (z) {
                this.f74931f.removeMessages(0);
            }
            Message obtain = Message.obtain();
            obtain.what = 0;
            obtain.arg1 = i2;
            obtain.arg2 = z ? 1 : 0;
            this.f74931f.sendMessageDelayed(obtain, 2000L);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, message)) == null) {
            if (message.what == 0) {
                r(message.arg1, message.arg2 == 1);
            } else {
                d.l.a.e.b.c.a.i("RetryScheduler", "handleMessage, doSchedulerRetry, id = " + message.what);
                e(message.what);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void k(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, downloadInfo) == null) || downloadInfo == null || TextUtils.isEmpty(d.l.a.e.b.d.c.f74684a) || !d.l.a.e.b.d.c.f74684a.equals(downloadInfo.getMimeType())) {
            return;
        }
        l(downloadInfo, downloadInfo.isOnlyWifi() || downloadInfo.isPauseReserveOnWifi(), A());
    }

    public final void l(DownloadInfo downloadInfo, boolean z, int i2) {
        BaseException failedException;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{downloadInfo, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) || (failedException = downloadInfo.getFailedException()) == null) {
            return;
        }
        d q = q(downloadInfo.getId());
        if (q.f74950i > q.f74944c) {
            d.l.a.e.b.c.a.j("RetryScheduler", "tryStartScheduleRetry, id = " + q.f74942a + ", mRetryCount = " + q.f74950i + ", maxCount = " + q.f74944c);
            return;
        }
        int errorCode = failedException.getErrorCode();
        if (!d.l.a.e.b.l.f.V0(failedException) && !d.l.a.e.b.l.f.Y0(failedException) && (!downloadInfo.statusInPause() || !downloadInfo.isPauseReserveOnWifi())) {
            if (!m(q, errorCode)) {
                return;
            }
            d.l.a.e.b.c.a.i("RetryScheduler", "allow error code, id = " + q.f74942a + ", error code = " + errorCode);
        }
        q.j = z;
        synchronized (this.f74932g) {
            if (!q.l) {
                q.l = true;
                this.j++;
            }
        }
        int j = q.j();
        d.l.a.e.b.c.a.i("RetryScheduler", "tryStartScheduleRetry: id = " + q.f74942a + ", delayTimeMills = " + j + ", mWaitingRetryTasks = " + this.j);
        if (!q.f74947f) {
            if (z) {
                return;
            }
            this.f74931f.removeMessages(downloadInfo.getId());
            this.f74931f.sendEmptyMessageDelayed(downloadInfo.getId(), j);
            return;
        }
        if (i2 == 0) {
            q.i();
        }
        e eVar = m;
        if (eVar != null) {
            eVar.a(downloadInfo, j, z, i2);
        }
        if (this.f74933h) {
            q.c(System.currentTimeMillis());
            q.f();
            q.b();
        }
    }

    public final boolean m(d dVar, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048585, this, dVar, i2)) == null) {
            int[] iArr = dVar.f74948g;
            if (iArr != null && iArr.length != 0) {
                for (int i3 : iArr) {
                    if (i3 == i2) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    public final boolean n(DownloadInfo downloadInfo, BaseException baseException) {
        InterceptResult invokeLL;
        long j;
        long totalBytes;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, downloadInfo, baseException)) == null) {
            try {
                j = d.l.a.e.b.l.f.y0(downloadInfo.getTempPath());
            } catch (BaseException e2) {
                e2.printStackTrace();
                j = 0;
            }
            if (baseException instanceof com.ss.android.socialbase.downloader.exception.d) {
                totalBytes = ((com.ss.android.socialbase.downloader.exception.d) baseException).b();
            } else {
                totalBytes = downloadInfo.getTotalBytes() - downloadInfo.getCurBytes();
            }
            if (j < totalBytes) {
                d.l.a.e.b.j.a d2 = d.l.a.e.b.j.a.d(downloadInfo.getId());
                if (d2.b("space_fill_part_download", 0) == 1) {
                    if (j > 0) {
                        int b2 = d2.b("space_fill_min_keep_mb", 100);
                        if (b2 > 0) {
                            long j2 = j - (b2 * 1048576);
                            d.l.a.e.b.c.a.i("RetryScheduler", "retry schedule: available = " + d.l.a.e.b.l.f.a(j) + "MB, minKeep = " + b2 + "MB, canDownload = " + d.l.a.e.b.l.f.a(j2) + "MB");
                            if (j2 <= 0) {
                                d.l.a.e.b.c.a.j("RetryScheduler", "doSchedulerRetryInSubThread: canDownload <= 0 , canRetry = false !!!!");
                                return false;
                            }
                        }
                    } else if (d2.b("download_when_space_negative", 0) != 1) {
                    }
                }
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public final int[] o(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                String[] split = str.split(",");
                if (split.length <= 0) {
                    return null;
                }
                int[] iArr = new int[split.length];
                for (int i2 = 0; i2 < split.length; i2++) {
                    iArr[i2] = Integer.parseInt(split[i2]);
                }
                return iArr;
            } catch (Throwable unused) {
                return null;
            }
        }
        return (int[]) invokeL.objValue;
    }

    public final d q(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) {
            d dVar = this.f74932g.get(i2);
            if (dVar == null) {
                synchronized (this.f74932g) {
                    dVar = this.f74932g.get(i2);
                    if (dVar == null) {
                        dVar = v(i2);
                    }
                    this.f74932g.put(i2, dVar);
                }
            }
            return dVar;
        }
        return (d) invokeI.objValue;
    }

    public final void r(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            d.l.a.e.b.g.e.A0().execute(new b(this, i2, z));
        }
    }

    public final void t(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            synchronized (this.f74932g) {
                this.f74932g.remove(i2);
            }
        }
    }

    public final d v(int i2) {
        InterceptResult invokeI;
        int[] iArr;
        int i3;
        int i4;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i2)) == null) {
            d.l.a.e.b.j.a d2 = d.l.a.e.b.j.a.d(i2);
            boolean z2 = false;
            int b2 = d2.b("retry_schedule", 0);
            JSONObject u = d2.u("retry_schedule_config");
            int i5 = 60;
            if (u != null) {
                int optInt = u.optInt("max_count", 60);
                int optInt2 = u.optInt("interval_sec", 60);
                int optInt3 = u.optInt("interval_sec_acceleration", 60);
                if (Build.VERSION.SDK_INT >= 21 && m != null && u.optInt("use_job_scheduler", 0) == 1) {
                    z2 = true;
                }
                iArr = o(u.optString("allow_error_code"));
                i3 = optInt3;
                z = z2;
                i4 = optInt;
                i5 = optInt2;
            } else {
                iArr = null;
                i3 = 60;
                i4 = 60;
                z = false;
            }
            return new d(i2, b2, i4, i5 * 1000, i3 * 1000, z, iArr);
        }
        return (d) invokeI.objValue;
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            g(2, true);
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            g(5, false);
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && d.l.a.e.b.j.a.r().b("use_network_callback", 0) == 1) {
            d.l.a.e.b.g.e.A0().execute(new a(this));
        }
    }

    @Override // d.l.a.e.b.a.a.b
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            g(4, false);
        }
    }
}
