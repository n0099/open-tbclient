package com.ss.android.socialbase.downloader.impls;

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
import com.ss.android.socialbase.downloader.a.a;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.Collections;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class r implements Handler.Callback, a.InterfaceC2112a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile r a;

    /* renamed from: i  reason: collision with root package name */
    public static b f61959i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final Context f61960b;

    /* renamed from: c  reason: collision with root package name */
    public final Handler f61961c;

    /* renamed from: d  reason: collision with root package name */
    public final SparseArray<a> f61962d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f61963e;

    /* renamed from: f  reason: collision with root package name */
    public long f61964f;

    /* renamed from: g  reason: collision with root package name */
    public int f61965g;

    /* renamed from: h  reason: collision with root package name */
    public ConnectivityManager f61966h;

    /* loaded from: classes2.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int a;

        /* renamed from: b  reason: collision with root package name */
        public final int f61970b;

        /* renamed from: c  reason: collision with root package name */
        public final int f61971c;

        /* renamed from: d  reason: collision with root package name */
        public final int f61972d;

        /* renamed from: e  reason: collision with root package name */
        public final int f61973e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f61974f;

        /* renamed from: g  reason: collision with root package name */
        public final int[] f61975g;

        /* renamed from: h  reason: collision with root package name */
        public int f61976h;

        /* renamed from: i  reason: collision with root package name */
        public int f61977i;

        /* renamed from: j  reason: collision with root package name */
        public boolean f61978j;

        /* renamed from: k  reason: collision with root package name */
        public long f61979k;
        public boolean l;

        public a(int i2, int i3, int i4, int i5, int i6, boolean z, int[] iArr) {
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
            this.a = i2;
            this.f61970b = i3;
            this.f61971c = i4;
            this.f61972d = i5;
            this.f61973e = i6;
            this.f61974f = z;
            this.f61975g = iArr;
            this.f61976h = i5;
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.f61976h = this.f61972d;
            }
        }

        public int d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f61976h : invokeV.intValue;
        }

        public boolean a(long j2, int i2, int i3, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)})) == null) {
                if (!this.l) {
                    com.ss.android.socialbase.downloader.c.a.c("RetryScheduler", "canRetry: mIsWaitingRetry is false, return false!!!");
                    return false;
                } else if (this.f61970b >= i2 && this.f61977i < this.f61971c) {
                    if (!this.f61978j || i3 == 2) {
                        return z || j2 - this.f61979k >= ((long) this.f61972d);
                    }
                    return false;
                } else {
                    return false;
                }
            }
            return invokeCommon.booleanValue;
        }

        public synchronized void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                synchronized (this) {
                    this.f61977i++;
                }
            }
        }

        public synchronized void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this) {
                    this.f61976h += this.f61973e;
                }
            }
        }

        public synchronized void a(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) {
                synchronized (this) {
                    this.f61979k = j2;
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a(DownloadInfo downloadInfo, long j2, boolean z, int i2);
    }

    public r() {
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
        this.f61961c = new Handler(Looper.getMainLooper(), this);
        this.f61962d = new SparseArray<>();
        this.f61965g = 0;
        this.f61960b = com.ss.android.socialbase.downloader.downloader.c.N();
        f();
        this.f61963e = com.ss.android.socialbase.downloader.i.f.c();
        com.ss.android.socialbase.downloader.a.a.a().a(this);
    }

    private void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65557, this) == null) && com.ss.android.socialbase.downloader.g.a.c().a("use_network_callback", 0) == 1) {
            com.ss.android.socialbase.downloader.downloader.c.l().execute(new Runnable(this) { // from class: com.ss.android.socialbase.downloader.impls.r.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ r a;

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
                        try {
                            if (this.a.f61960b == null || Build.VERSION.SDK_INT < 21) {
                                return;
                            }
                            this.a.f61966h = (ConnectivityManager) this.a.f61960b.getApplicationContext().getSystemService("connectivity");
                            this.a.f61966h.registerNetworkCallback(new NetworkRequest.Builder().build(), new ConnectivityManager.NetworkCallback(this) { // from class: com.ss.android.socialbase.downloader.impls.r.1.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass1 a;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.a = this;
                                }

                                @Override // android.net.ConnectivityManager.NetworkCallback
                                public void onAvailable(Network network) {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeL(1048576, this, network) == null) {
                                        com.ss.android.socialbase.downloader.c.a.b("RetryScheduler", "network onAvailable: ");
                                        this.a.a.a(1, true);
                                    }
                                }
                            });
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65558, this)) == null) {
            try {
                if (this.f61966h == null) {
                    this.f61966h = (ConnectivityManager) this.f61960b.getApplicationContext().getSystemService("connectivity");
                }
                NetworkInfo activeNetworkInfo = this.f61966h.getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                    return activeNetworkInfo.getType() == 1 ? 2 : 1;
                }
            } catch (Exception unused) {
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, message)) == null) {
            if (message.what == 0) {
                b(message.arg1, message.arg2 == 1);
            } else {
                com.ss.android.socialbase.downloader.c.a.c("RetryScheduler", "handleMessage, doSchedulerRetry, id = " + message.what);
                a(message.what);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    private void b(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65551, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            com.ss.android.socialbase.downloader.downloader.c.l().execute(new Runnable(this, i2, z) { // from class: com.ss.android.socialbase.downloader.impls.r.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ int a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ boolean f61967b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ r f61968c;

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
                    this.f61968c = this;
                    this.a = i2;
                    this.f61967b = z;
                }

                @Override // java.lang.Runnable
                public void run() {
                    int g2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            if (this.f61968c.f61965g > 0 && (g2 = this.f61968c.g()) != 0) {
                                com.ss.android.socialbase.downloader.c.a.c("RetryScheduler", "doScheduleAllTaskRetry: mWaitingRetryTasksCount = " + this.f61968c.f61965g);
                                long currentTimeMillis = System.currentTimeMillis();
                                ArrayList<a> arrayList = new ArrayList();
                                synchronized (this.f61968c.f61962d) {
                                    for (int i3 = 0; i3 < this.f61968c.f61962d.size(); i3++) {
                                        a aVar = (a) this.f61968c.f61962d.valueAt(i3);
                                        if (aVar != null && aVar.a(currentTimeMillis, this.a, g2, this.f61967b)) {
                                            if (this.f61967b) {
                                                aVar.c();
                                            }
                                            arrayList.add(aVar);
                                        }
                                    }
                                }
                                if (arrayList.size() > 0) {
                                    for (a aVar2 : arrayList) {
                                        this.f61968c.a(aVar2.a, g2, false);
                                    }
                                }
                            }
                        } catch (Exception unused) {
                        }
                    }
                }
            });
        }
    }

    private void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65553, this, i2) == null) {
            synchronized (this.f61962d) {
                this.f61962d.remove(i2);
            }
        }
    }

    private a d(int i2) {
        InterceptResult invokeI;
        int[] iArr;
        int i3;
        int i4;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65555, this, i2)) == null) {
            com.ss.android.socialbase.downloader.g.a a2 = com.ss.android.socialbase.downloader.g.a.a(i2);
            boolean z2 = false;
            int a3 = a2.a("retry_schedule", 0);
            JSONObject d2 = a2.d("retry_schedule_config");
            int i5 = 60;
            if (d2 != null) {
                int optInt = d2.optInt("max_count", 60);
                int optInt2 = d2.optInt("interval_sec", 60);
                int optInt3 = d2.optInt("interval_sec_acceleration", 60);
                if (Build.VERSION.SDK_INT >= 21 && f61959i != null && d2.optInt("use_job_scheduler", 0) == 1) {
                    z2 = true;
                }
                iArr = a(d2.optString("allow_error_code"));
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
            return new a(i2, a3, i4, i5 * 1000, i3 * 1000, z, iArr);
        }
        return (a) invokeI.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            a(5, false);
        }
    }

    private a b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65550, this, i2)) == null) {
            a aVar = this.f61962d.get(i2);
            if (aVar == null) {
                synchronized (this.f61962d) {
                    aVar = this.f61962d.get(i2);
                    if (aVar == null) {
                        aVar = d(i2);
                    }
                    this.f61962d.put(i2, aVar);
                }
            }
            return aVar;
        }
        return (a) invokeI.objValue;
    }

    public static r a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (a == null) {
                synchronized (r.class) {
                    if (a == null) {
                        a = new r();
                    }
                }
            }
            return a;
        }
        return (r) invokeV.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.a.a.InterfaceC2112a
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            a(3, false);
        }
    }

    @Override // com.ss.android.socialbase.downloader.a.a.InterfaceC2112a
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            a(4, false);
        }
    }

    public static void a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, bVar) == null) {
            f61959i = bVar;
        }
    }

    public void a(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadInfo) == null) || downloadInfo == null || TextUtils.isEmpty(com.ss.android.socialbase.downloader.constants.e.a) || !com.ss.android.socialbase.downloader.constants.e.a.equals(downloadInfo.getMimeType())) {
            return;
        }
        a(downloadInfo, downloadInfo.isOnlyWifi() || downloadInfo.isPauseReserveOnWifi(), g());
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            a(2, true);
        }
    }

    private void a(DownloadInfo downloadInfo, boolean z, int i2) {
        BaseException failedException;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65545, this, new Object[]{downloadInfo, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) || (failedException = downloadInfo.getFailedException()) == null) {
            return;
        }
        a b2 = b(downloadInfo.getId());
        if (b2.f61977i > b2.f61971c) {
            com.ss.android.socialbase.downloader.c.a.d("RetryScheduler", "tryStartScheduleRetry, id = " + b2.a + ", mRetryCount = " + b2.f61977i + ", maxCount = " + b2.f61971c);
            return;
        }
        int errorCode = failedException.getErrorCode();
        if (!com.ss.android.socialbase.downloader.i.f.h(failedException) && !com.ss.android.socialbase.downloader.i.f.i(failedException) && (!downloadInfo.statusInPause() || !downloadInfo.isPauseReserveOnWifi())) {
            if (!a(b2, errorCode)) {
                return;
            }
            com.ss.android.socialbase.downloader.c.a.c("RetryScheduler", "allow error code, id = " + b2.a + ", error code = " + errorCode);
        }
        b2.f61978j = z;
        synchronized (this.f61962d) {
            if (!b2.l) {
                b2.l = true;
                this.f61965g++;
            }
        }
        int d2 = b2.d();
        com.ss.android.socialbase.downloader.c.a.c("RetryScheduler", "tryStartScheduleRetry: id = " + b2.a + ", delayTimeMills = " + d2 + ", mWaitingRetryTasks = " + this.f61965g);
        if (!b2.f61974f) {
            if (z) {
                return;
            }
            this.f61961c.removeMessages(downloadInfo.getId());
            this.f61961c.sendEmptyMessageDelayed(downloadInfo.getId(), d2);
            return;
        }
        if (i2 == 0) {
            b2.c();
        }
        b bVar = f61959i;
        if (bVar != null) {
            bVar.a(downloadInfo, d2, z, i2);
        }
        if (this.f61963e) {
            b2.a(System.currentTimeMillis());
            b2.b();
            b2.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65541, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || this.f61965g <= 0) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this) {
            if (!z) {
                if (currentTimeMillis - this.f61964f < 10000) {
                    return;
                }
            }
            this.f61964f = currentTimeMillis;
            com.ss.android.socialbase.downloader.c.a.c("RetryScheduler", "scheduleAllTaskRetry, level = [" + i2 + "], force = [" + z + PreferencesUtil.RIGHT_MOUNT);
            if (z) {
                this.f61961c.removeMessages(0);
            }
            Message obtain = Message.obtain();
            obtain.what = 0;
            obtain.arg1 = i2;
            obtain.arg2 = z ? 1 : 0;
            this.f61961c.sendMessageDelayed(obtain, 2000L);
        }
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            com.ss.android.socialbase.downloader.downloader.c.l().execute(new Runnable(this, i2) { // from class: com.ss.android.socialbase.downloader.impls.r.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ int a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ r f61969b;

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
                    this.f61969b = this;
                    this.a = i2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            this.f61969b.a(this.a, this.f61969b.g(), true);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, int i3, boolean z) {
        Context context;
        com.ss.android.socialbase.downloader.downloader.r reserveWifiStatusListener;
        boolean z2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)}) == null) || (context = this.f61960b) == null) {
            return;
        }
        synchronized (this.f61962d) {
            a aVar = this.f61962d.get(i2);
            if (aVar == null) {
                return;
            }
            boolean z3 = true;
            if (aVar.l) {
                aVar.l = false;
                int i4 = this.f61965g - 1;
                this.f61965g = i4;
                if (i4 < 0) {
                    this.f61965g = 0;
                }
            }
            com.ss.android.socialbase.downloader.c.a.c("RetryScheduler", "doSchedulerRetryInSubThread: downloadId = " + i2 + ", retryCount = " + aVar.f61977i + ", mWaitingRetryTasksCount = " + this.f61965g);
            DownloadInfo downloadInfo = Downloader.getInstance(context).getDownloadInfo(i2);
            if (downloadInfo == null) {
                c(i2);
                return;
            }
            com.ss.android.socialbase.downloader.c.a.e("RetryScheduler", "doSchedulerRetryInSubThread，id:" + i2);
            int realStatus = downloadInfo.getRealStatus();
            if (realStatus != -3 && realStatus != -4) {
                if (realStatus == -5 || (realStatus == -2 && downloadInfo.isPauseReserveOnWifi())) {
                    if (realStatus == -2 && (reserveWifiStatusListener = Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.c.N()).getReserveWifiStatusListener()) != null) {
                        reserveWifiStatusListener.a(downloadInfo, 4, 3);
                    }
                    com.ss.android.socialbase.downloader.downloader.l w = com.ss.android.socialbase.downloader.downloader.c.w();
                    if (w != null) {
                        w.a(Collections.singletonList(downloadInfo), 3);
                    }
                    c(i2);
                    return;
                } else if (realStatus != -1) {
                    return;
                } else {
                    if (i3 != 0) {
                        z2 = true;
                    } else if (!aVar.f61974f) {
                        return;
                    } else {
                        z2 = false;
                    }
                    BaseException failedException = downloadInfo.getFailedException();
                    if (z2 && com.ss.android.socialbase.downloader.i.f.h(failedException)) {
                        z2 = a(downloadInfo, failedException);
                    }
                    aVar.b();
                    if (z2) {
                        com.ss.android.socialbase.downloader.c.a.c("RetryScheduler", "doSchedulerRetry: restart task, ****** id = " + aVar.a);
                        aVar.a(System.currentTimeMillis());
                        if (z) {
                            aVar.a();
                        }
                        downloadInfo.setRetryScheduleCount(aVar.f61977i);
                        if (downloadInfo.getStatus() == -1) {
                            Downloader.getInstance(context).restart(downloadInfo.getId());
                            return;
                        }
                        return;
                    }
                    if (z) {
                        aVar.a();
                    }
                    if (!downloadInfo.isOnlyWifi() && !downloadInfo.isPauseReserveOnWifi()) {
                        z3 = false;
                    }
                    a(downloadInfo, z3, i3);
                    return;
                }
            }
            c(i2);
        }
    }

    private boolean a(a aVar, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65546, this, aVar, i2)) == null) {
            int[] iArr = aVar.f61975g;
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

    private int[] a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, this, str)) == null) {
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

    private boolean a(DownloadInfo downloadInfo, BaseException baseException) {
        InterceptResult invokeLL;
        long j2;
        long totalBytes;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, this, downloadInfo, baseException)) == null) {
            try {
                j2 = com.ss.android.socialbase.downloader.i.f.d(downloadInfo.getTempPath());
            } catch (BaseException e2) {
                e2.printStackTrace();
                j2 = 0;
            }
            if (baseException instanceof com.ss.android.socialbase.downloader.exception.d) {
                totalBytes = ((com.ss.android.socialbase.downloader.exception.d) baseException).b();
            } else {
                totalBytes = downloadInfo.getTotalBytes() - downloadInfo.getCurBytes();
            }
            if (j2 < totalBytes) {
                com.ss.android.socialbase.downloader.g.a a2 = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId());
                if (a2.a("space_fill_part_download", 0) == 1) {
                    if (j2 > 0) {
                        int a3 = a2.a("space_fill_min_keep_mb", 100);
                        if (a3 > 0) {
                            long j3 = j2 - (a3 * 1048576);
                            com.ss.android.socialbase.downloader.c.a.c("RetryScheduler", "retry schedule: available = " + com.ss.android.socialbase.downloader.i.f.a(j2) + "MB, minKeep = " + a3 + "MB, canDownload = " + com.ss.android.socialbase.downloader.i.f.a(j3) + "MB");
                            if (j3 <= 0) {
                                com.ss.android.socialbase.downloader.c.a.d("RetryScheduler", "doSchedulerRetryInSubThread: canDownload <= 0 , canRetry = false !!!!");
                                return false;
                            }
                        }
                    } else if (a2.a("download_when_space_negative", 0) != 1) {
                    }
                }
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }
}
