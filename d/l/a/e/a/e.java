package d.l.a.e.a;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
import com.baidu.tieba.service.AsInstallService;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.appdownloader.DownloadReceiver;
import com.ss.android.socialbase.appdownloader.RetryJobSchedulerService;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.l.a.e.a.c;
import d.l.a.e.a.d;
import d.l.a.e.b.f.h;
import d.l.a.e.b.f.r;
import d.l.a.e.b.g.m;
import d.l.a.e.b.m.q;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class e {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String m = "e";
    public static volatile e n;
    public static boolean o;
    public static boolean p;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f71608a;

    /* renamed from: b  reason: collision with root package name */
    public String f71609b;

    /* renamed from: c  reason: collision with root package name */
    public DownloadReceiver f71610c;

    /* renamed from: d  reason: collision with root package name */
    public d.e f71611d;

    /* renamed from: e  reason: collision with root package name */
    public d.f f71612e;

    /* renamed from: f  reason: collision with root package name */
    public d.j f71613f;

    /* renamed from: g  reason: collision with root package name */
    public d.i f71614g;

    /* renamed from: h  reason: collision with root package name */
    public d.o f71615h;

    /* renamed from: i  reason: collision with root package name */
    public d.h f71616i;
    public d.l j;
    public h k;
    public d.l.a.e.b.f.j l;

    /* loaded from: classes8.dex */
    public class a implements q.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // d.l.a.e.b.m.q.e
        public void a(DownloadInfo downloadInfo, long j, boolean z, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{downloadInfo, Long.valueOf(j), Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
                RetryJobSchedulerService.a(downloadInfo, j, z, i2);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements r {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f71617a;

        public b(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f71617a = eVar;
        }

        @Override // d.l.a.e.b.f.r
        public void a(DownloadInfo downloadInfo, BaseException baseException, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLI(1048576, this, downloadInfo, baseException, i2) == null) || this.f71617a.f71613f == null) {
                return;
            }
            this.f71617a.f71613f.a(downloadInfo, baseException, i2);
        }
    }

    /* loaded from: classes8.dex */
    public class c implements d.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f71618a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.l.a.e.b.n.a f71619b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f71620c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ boolean f71621d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f71622e;

        public c(e eVar, String str, d.l.a.e.b.n.a aVar, int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str, aVar, Integer.valueOf(i2), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f71622e = eVar;
            this.f71618a = str;
            this.f71619b = aVar;
            this.f71620c = i2;
            this.f71621d = z;
        }

        @Override // d.l.a.e.a.d.p
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String str = e.m;
                d.l.a.e.b.c.a.g(str, "notification permission granted, start download :" + this.f71618a);
                this.f71622e.r(this.f71619b, this.f71620c, this.f71621d);
            }
        }

        @Override // d.l.a.e.a.d.p
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                String str = e.m;
                d.l.a.e.b.c.a.g(str, "notification permission denied, start download :" + this.f71618a);
                this.f71622e.r(this.f71619b, this.f71620c, this.f71621d);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements m {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public List<Integer> f71626a;

        /* renamed from: b  reason: collision with root package name */
        public BroadcastReceiver f71627b;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ List f71628e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f71629f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ f f71630g;

            public a(f fVar, List list, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar, list, Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f71630g = fVar;
                this.f71628e = list;
                this.f71629f = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    try {
                        this.f71630g.i(this.f71628e, this.f71629f);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }

        /* loaded from: classes8.dex */
        public class b extends BroadcastReceiver {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ f f71631a;

            /* loaded from: classes8.dex */
            public class a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Context f71632e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ b f71633f;

                public a(b bVar, Context context) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bVar, context};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f71633f = bVar;
                    this.f71632e = context;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        try {
                            if (this.f71633f.f71631a.f71626a != null && !this.f71633f.f71631a.f71626a.isEmpty()) {
                                int size = this.f71633f.f71631a.f71626a.size();
                                Integer[] numArr = new Integer[size];
                                this.f71633f.f71631a.f71626a.toArray(numArr);
                                this.f71633f.f71631a.f71626a.clear();
                                for (int i2 = 0; i2 < size; i2++) {
                                    DownloadInfo f2 = d.l.a.e.b.g.a.H(this.f71632e).f(numArr[i2].intValue());
                                    if (f2 != null && (f2.getRealStatus() == -5 || (f2.getRealStatus() == -2 && f2.isPauseReserveOnWifi()))) {
                                        this.f71633f.f71631a.c(this.f71632e, f2, true, 2);
                                    }
                                }
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            }

            public b(f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f71631a = fVar;
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) {
                    Context applicationContext = context.getApplicationContext();
                    if (d.l.a.e.b.l.f.g0(applicationContext)) {
                        d.l.a.e.b.c.a.g("LaunchResume", "onReceive : wifi connected !!!");
                        d.l.a.e.b.g.e.A0().execute(new a(this, applicationContext));
                        try {
                            applicationContext.unregisterReceiver(this.f71631a.f71627b);
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                        this.f71631a.f71627b = null;
                    }
                }
            }
        }

        public f() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:105:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:107:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:29:0x008f  */
        /* JADX WARN: Removed duplicated region for block: B:57:0x013e  */
        /* JADX WARN: Removed duplicated region for block: B:76:0x01c3  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void c(Context context, DownloadInfo downloadInfo, boolean z, int i2) {
            String str;
            boolean z2;
            int i3;
            String str2;
            String str3;
            boolean z3;
            boolean z4;
            d.i I;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, downloadInfo, Boolean.valueOf(z), Integer.valueOf(i2)}) != null) || downloadInfo == null || !downloadInfo.isShowNotification()) {
                return;
            }
            int realStatus = downloadInfo.getRealStatus();
            if (realStatus == -5 && ("application/ttpatch".equalsIgnoreCase(downloadInfo.getMimeType()) || !downloadInfo.isDownloaded())) {
                d.l.a.e.b.j.a d2 = d.l.a.e.b.j.a.d(downloadInfo.getId());
                int b2 = d2.b("failed_resume_max_count", 0);
                double a2 = d2.a("failed_resume_max_hours", 72.0d);
                double a3 = d2.a("failed_resume_min_hours", 12.0d);
                long currentTimeMillis = System.currentTimeMillis();
                if (downloadInfo.getFailedResumeCount() < b2) {
                    str2 = ", canShowNotification = ";
                    str3 = "LaunchResume";
                    if (currentTimeMillis - downloadInfo.getLastDownloadTime() < a2 * 3600000.0d && currentTimeMillis - downloadInfo.getLastFailedResumeTime() > a3 * 3600000.0d) {
                        z3 = true;
                        if (downloadInfo.isPauseReserveOnWifi() && z) {
                            z3 = true;
                        }
                        if (z3) {
                            boolean z5 = d2.b("failed_resume_need_wifi", 1) == 1;
                            boolean z6 = d2.b("failed_resume_need_wait_wifi", 0) == 1;
                            if (!z && z5 && z6) {
                                if (this.f71626a == null) {
                                    this.f71626a = new ArrayList();
                                }
                                int id = downloadInfo.getId();
                                if (!this.f71626a.contains(Integer.valueOf(id))) {
                                    this.f71626a.add(Integer.valueOf(id));
                                }
                                downloadInfo.setOnlyWifi(true);
                                q.d().k(downloadInfo);
                            } else {
                                z4 = true;
                                d.l.a.e.a.d.s(downloadInfo, true, z5);
                                downloadInfo.setLastFailedResumeTime(currentTimeMillis);
                                downloadInfo.setFailedResumeCount(downloadInfo.getFailedResumeCount() + 1);
                                downloadInfo.updateSpData();
                                if (downloadInfo.isPauseReserveOnWifi() && z) {
                                    downloadInfo.setDownloadFromReserveWifi(true);
                                    d.l.a.e.b.g.r J = e.G().J();
                                    if (J != null) {
                                        J.a(downloadInfo, 5, i2);
                                    }
                                }
                                d.l.a.e.b.c.a.i(str3, "launchResume, name = " + downloadInfo.getTitle() + str2 + z3 + ", downloadResumed = " + z4);
                                I = e.G().I();
                                if (I != null) {
                                    I.a(downloadInfo, z4);
                                    return;
                                }
                                return;
                            }
                        }
                        z4 = false;
                        d.l.a.e.b.c.a.i(str3, "launchResume, name = " + downloadInfo.getTitle() + str2 + z3 + ", downloadResumed = " + z4);
                        I = e.G().I();
                        if (I != null) {
                        }
                    }
                } else {
                    str2 = ", canShowNotification = ";
                    str3 = "LaunchResume";
                }
                z3 = false;
                if (downloadInfo.isPauseReserveOnWifi()) {
                    z3 = true;
                }
                if (z3) {
                }
                z4 = false;
                d.l.a.e.b.c.a.i(str3, "launchResume, name = " + downloadInfo.getTitle() + str2 + z3 + ", downloadResumed = " + z4);
                I = e.G().I();
                if (I != null) {
                }
            } else if (realStatus != -3 || !g(downloadInfo)) {
                if (realStatus == -2) {
                    if (!downloadInfo.isPauseReserveOnWifi()) {
                        f(downloadInfo, context);
                    } else if (z) {
                        d.l.a.e.a.d.s(downloadInfo, true, true);
                        downloadInfo.updateSpData();
                        downloadInfo.setDownloadFromReserveWifi(true);
                        d.i I2 = e.G().I();
                        if (I2 != null) {
                            I2.a(downloadInfo, true);
                        }
                        d.l.a.e.b.g.r J2 = e.G().J();
                        if (J2 != null) {
                            J2.a(downloadInfo, 5, i2);
                        }
                    } else {
                        if (this.f71626a == null) {
                            this.f71626a = new ArrayList();
                        }
                        int id2 = downloadInfo.getId();
                        if (!this.f71626a.contains(Integer.valueOf(id2))) {
                            this.f71626a.add(Integer.valueOf(id2));
                        }
                        q.d().k(downloadInfo);
                        f(downloadInfo, context);
                    }
                }
            } else {
                d.l.a.e.b.j.a d3 = d.l.a.e.b.j.a.d(downloadInfo.getId());
                if (d.l.a.e.a.d.v(context, downloadInfo)) {
                    return;
                }
                int b3 = d3.b("uninstall_resume_max_count", 0);
                double a4 = d3.a("uninstall_resume_max_hours", 72.0d);
                double a5 = d3.a("uninstall_resume_min_hours", 12.0d);
                long currentTimeMillis2 = System.currentTimeMillis();
                if (downloadInfo.getUninstallResumeCount() < b3) {
                    str = "LaunchResume";
                    if (currentTimeMillis2 - downloadInfo.getLastDownloadTime() < a4 * 3600000.0d && currentTimeMillis2 - downloadInfo.getLastUninstallResumeTime() > a5 * 3600000.0d) {
                        z2 = true;
                        d.l.a.e.b.c.a.i(str, "uninstallResume, name = " + downloadInfo.getTitle() + ", canShowNotification = " + z2);
                        if (z2) {
                            return;
                        }
                        d.l.a.e.b.p.a l = d.l.a.e.b.p.b.a().l(downloadInfo.getId());
                        if (l == null) {
                            i3 = 1;
                            d.l.a.e.a.f.a aVar = new d.l.a.e.a.f.a(context, downloadInfo.getId(), downloadInfo.getTitle(), downloadInfo.getSavePath(), downloadInfo.getName(), downloadInfo.getExtra());
                            d.l.a.e.b.p.b.a().e(aVar);
                            l = aVar;
                        } else {
                            i3 = 1;
                            l.h(downloadInfo);
                        }
                        l.k(downloadInfo.getTotalBytes());
                        l.d(downloadInfo.getTotalBytes());
                        l.c(downloadInfo.getStatus(), null, false, false);
                        downloadInfo.setLastUninstallResumeTime(currentTimeMillis2);
                        downloadInfo.setUninstallResumeCount(downloadInfo.getUninstallResumeCount() + i3);
                        downloadInfo.updateSpData();
                        return;
                    }
                } else {
                    str = "LaunchResume";
                }
                z2 = false;
                d.l.a.e.b.c.a.i(str, "uninstallResume, name = " + downloadInfo.getTitle() + ", canShowNotification = " + z2);
                if (z2) {
                }
            }
        }

        public final void f(DownloadInfo downloadInfo, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, downloadInfo, context) == null) {
                d.l.a.e.b.j.a d2 = d.l.a.e.b.j.a.d(downloadInfo.getId());
                int b2 = d2.b("paused_resume_max_count", 0);
                double a2 = d2.a("paused_resume_max_hours", 72.0d);
                int pausedResumeCount = downloadInfo.getPausedResumeCount();
                if (pausedResumeCount < b2 && ((double) (System.currentTimeMillis() - downloadInfo.getLastDownloadTime())) < a2 * 3600000.0d) {
                    d.l.a.e.b.p.a l = d.l.a.e.b.p.b.a().l(downloadInfo.getId());
                    if (l == null) {
                        l = new d.l.a.e.a.f.a(context, downloadInfo.getId(), downloadInfo.getTitle(), downloadInfo.getSavePath(), downloadInfo.getName(), downloadInfo.getExtra());
                        d.l.a.e.b.p.b.a().e(l);
                    } else {
                        l.h(downloadInfo);
                    }
                    l.k(downloadInfo.getTotalBytes());
                    l.d(downloadInfo.getCurBytes());
                    l.c(downloadInfo.getStatus(), null, false, false);
                    downloadInfo.setPausedResumeCount(pausedResumeCount + 1);
                    downloadInfo.updateSpData();
                }
            }
        }

        public final boolean g(DownloadInfo downloadInfo) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, downloadInfo)) == null) {
                if (d.l.a.e.b.j.a.d(downloadInfo.getId()).q("uninstall_can_not_resume_for_force_task", false)) {
                    return d.l.a.e.b.l.f.M(downloadInfo, false, downloadInfo.getMd5());
                }
                return downloadInfo.isDownloaded();
            }
            return invokeL.booleanValue;
        }

        public final void i(List<DownloadInfo> list, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048581, this, list, i2) == null) || list == null || list.isEmpty()) {
                return;
            }
            d.i I = e.G().I();
            if (I != null) {
                I.a(list);
            }
            Context n = d.l.a.e.b.g.e.n();
            if (n == null) {
                return;
            }
            boolean g0 = d.l.a.e.b.l.f.g0(n);
            for (DownloadInfo downloadInfo : list) {
                c(n, downloadInfo, g0, i2);
            }
            List<Integer> list2 = this.f71626a;
            if (list2 == null || list2.isEmpty() || this.f71627b != null) {
                return;
            }
            this.f71627b = new b(this);
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                n.registerReceiver(this.f71627b, intentFilter);
            } catch (Throwable th) {
                th.printStackTrace();
                this.f71627b = null;
            }
        }

        @Override // d.l.a.e.b.g.m
        public List<String> a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? d.l.a.e.a.d.M() : (List) invokeV.objValue;
        }

        @Override // d.l.a.e.b.g.m
        public void a(List<DownloadInfo> list, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, i2) == null) {
                if (d.l.a.e.b.l.f.B0()) {
                    d.l.a.e.b.g.e.A0().execute(new a(this, list, i2));
                } else {
                    i(list, i2);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(797372630, "Ld/l/a/e/a/e;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(797372630, "Ld/l/a/e/a/e;");
        }
    }

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static e G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (n == null) {
                synchronized (e.class) {
                    if (n == null) {
                        n = new e();
                    }
                }
            }
            return n;
        }
        return (e) invokeV.objValue;
    }

    public static boolean t(Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(AdIconUtil.BAIDU_LOGO_ID, null, context, i2)) == null) ? d.l.a.e.a.d.d(context, i2, true) == 1 : invokeLI.booleanValue;
    }

    public String A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f71609b : (String) invokeV.objValue;
    }

    public d.h B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f71616i : (d.h) invokeV.objValue;
    }

    public boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? d.l.a.e.b.j.a.o().optInt("package_flag_config", 1) == 1 : invokeV.booleanValue;
    }

    public d.l D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.j : (d.l) invokeV.objValue;
    }

    public File E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? d.l.a.e.b.g.a.H(d.l.a.e.b.g.e.n()).k() : (File) invokeV.objValue;
    }

    public String F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f71608a : (String) invokeV.objValue;
    }

    public d.o H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f71615h : (d.o) invokeV.objValue;
    }

    public d.i I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f71614g : (d.i) invokeV.objValue;
    }

    public d.l.a.e.b.g.r J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? d.l.a.e.b.g.a.H(d.l.a.e.b.g.e.n()).n() : (d.l.a.e.b.g.r) invokeV.objValue;
    }

    public h K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.k : (h) invokeV.objValue;
    }

    public d.l.a.e.b.f.j L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.l : (d.l.a.e.b.f.j) invokeV.objValue;
    }

    public final void N() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || p) {
            return;
        }
        if (this.f71610c == null) {
            this.f71610c = new DownloadReceiver();
        }
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            intentFilter.addAction("android.intent.action.BOOT_COMPLETED");
            intentFilter.addAction("android.ss.intent.action.DOWNLOAD_COMPLETE");
            IntentFilter intentFilter2 = new IntentFilter();
            intentFilter2.addAction(PackageChangedReceiver.ACTION_INSTALL);
            intentFilter2.addAction("android.intent.action.PACKAGE_REPLACED");
            intentFilter2.addDataScheme(AsInstallService.SCHEME_PACKAGE_ADDED);
            IntentFilter intentFilter3 = new IntentFilter();
            intentFilter3.addAction("android.intent.action.MEDIA_MOUNTED");
            intentFilter3.addDataScheme("file");
            d.l.a.e.b.g.e.n().registerReceiver(this.f71610c, intentFilter);
            d.l.a.e.b.g.e.n().registerReceiver(this.f71610c, intentFilter2);
            d.l.a.e.b.g.e.n().registerReceiver(this.f71610c, intentFilter3);
            p = true;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void O() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || Build.VERSION.SDK_INT < 21) {
            return;
        }
        q.h(new a(this));
    }

    /* JADX WARN: Can't wrap try/catch for region: R(25:39|(2:43|44)|47|(1:115)(1:54)|55|(2:61|(1:63)(19:64|65|(1:67)|68|(3:70|(2:73|71)|74)|75|76|77|(1:79)(1:112)|80|81|(6:86|(1:109)(1:90)|91|(1:95)|(1:(1:107)(1:106))|108)|110|(1:88)|109|91|(2:93|95)|(0)|108))|114|65|(0)|68|(0)|75|76|77|(0)(0)|80|81|(8:83|86|(0)|109|91|(0)|(0)|108)|110|(0)|109|91|(0)|(0)|108) */
    /* JADX WARN: Removed duplicated region for block: B:66:0x013b A[Catch: all -> 0x035b, TryCatch #2 {all -> 0x035b, blocks: (B:10:0x0014, B:13:0x0027, B:17:0x0030, B:19:0x003e, B:20:0x0046, B:22:0x004e, B:23:0x0057, B:26:0x005e, B:28:0x006a, B:31:0x0076, B:33:0x0084, B:34:0x0088, B:36:0x008f, B:39:0x0097, B:41:0x00ab, B:44:0x00c5, B:47:0x00de, B:49:0x00e4, B:53:0x00f5, B:55:0x00fb, B:57:0x0101, B:59:0x0107, B:61:0x010d, B:63:0x011b, B:64:0x0135, B:66:0x013b, B:67:0x0140, B:69:0x014a, B:70:0x014e, B:72:0x0154, B:73:0x015e, B:79:0x0189, B:81:0x018f, B:87:0x019b, B:89:0x01a8, B:91:0x01b8, B:93:0x02fa, B:95:0x0304, B:98:0x030f, B:100:0x0315, B:102:0x031b, B:104:0x0325, B:106:0x032b, B:107:0x033c), top: B:126:0x0014 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x014a A[Catch: all -> 0x035b, TryCatch #2 {all -> 0x035b, blocks: (B:10:0x0014, B:13:0x0027, B:17:0x0030, B:19:0x003e, B:20:0x0046, B:22:0x004e, B:23:0x0057, B:26:0x005e, B:28:0x006a, B:31:0x0076, B:33:0x0084, B:34:0x0088, B:36:0x008f, B:39:0x0097, B:41:0x00ab, B:44:0x00c5, B:47:0x00de, B:49:0x00e4, B:53:0x00f5, B:55:0x00fb, B:57:0x0101, B:59:0x0107, B:61:0x010d, B:63:0x011b, B:64:0x0135, B:66:0x013b, B:67:0x0140, B:69:0x014a, B:70:0x014e, B:72:0x0154, B:73:0x015e, B:79:0x0189, B:81:0x018f, B:87:0x019b, B:89:0x01a8, B:91:0x01b8, B:93:0x02fa, B:95:0x0304, B:98:0x030f, B:100:0x0315, B:102:0x031b, B:104:0x0325, B:106:0x032b, B:107:0x033c), top: B:126:0x0014 }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0168 A[Catch: all -> 0x0189, TryCatch #1 {all -> 0x0189, blocks: (B:74:0x0162, B:76:0x0168, B:78:0x0173, B:77:0x016e), top: B:124:0x0162 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x016e A[Catch: all -> 0x0189, TryCatch #1 {all -> 0x0189, blocks: (B:74:0x0162, B:76:0x0168, B:78:0x0173, B:77:0x016e), top: B:124:0x0162 }] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x019b A[Catch: all -> 0x035b, TryCatch #2 {all -> 0x035b, blocks: (B:10:0x0014, B:13:0x0027, B:17:0x0030, B:19:0x003e, B:20:0x0046, B:22:0x004e, B:23:0x0057, B:26:0x005e, B:28:0x006a, B:31:0x0076, B:33:0x0084, B:34:0x0088, B:36:0x008f, B:39:0x0097, B:41:0x00ab, B:44:0x00c5, B:47:0x00de, B:49:0x00e4, B:53:0x00f5, B:55:0x00fb, B:57:0x0101, B:59:0x0107, B:61:0x010d, B:63:0x011b, B:64:0x0135, B:66:0x013b, B:67:0x0140, B:69:0x014a, B:70:0x014e, B:72:0x0154, B:73:0x015e, B:79:0x0189, B:81:0x018f, B:87:0x019b, B:89:0x01a8, B:91:0x01b8, B:93:0x02fa, B:95:0x0304, B:98:0x030f, B:100:0x0315, B:102:0x031b, B:104:0x0325, B:106:0x032b, B:107:0x033c), top: B:126:0x0014 }] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x02fa A[Catch: all -> 0x035b, TryCatch #2 {all -> 0x035b, blocks: (B:10:0x0014, B:13:0x0027, B:17:0x0030, B:19:0x003e, B:20:0x0046, B:22:0x004e, B:23:0x0057, B:26:0x005e, B:28:0x006a, B:31:0x0076, B:33:0x0084, B:34:0x0088, B:36:0x008f, B:39:0x0097, B:41:0x00ab, B:44:0x00c5, B:47:0x00de, B:49:0x00e4, B:53:0x00f5, B:55:0x00fb, B:57:0x0101, B:59:0x0107, B:61:0x010d, B:63:0x011b, B:64:0x0135, B:66:0x013b, B:67:0x0140, B:69:0x014a, B:70:0x014e, B:72:0x0154, B:73:0x015e, B:79:0x0189, B:81:0x018f, B:87:0x019b, B:89:0x01a8, B:91:0x01b8, B:93:0x02fa, B:95:0x0304, B:98:0x030f, B:100:0x0315, B:102:0x031b, B:104:0x0325, B:106:0x032b, B:107:0x033c), top: B:126:0x0014 }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x030d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int a(i iVar) {
        InterceptResult invokeL;
        int i2;
        String str;
        r p2;
        List<d.l.a.e.b.f.q> a2;
        String E0;
        boolean z;
        int i3;
        d.l.a.e.b.n.a G;
        JSONObject jSONObject;
        DownloadInfo f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, iVar)) == null) {
            if (iVar == null || iVar.S() == null) {
                return 0;
            }
            try {
                List<com.ss.android.socialbase.downloader.model.c> i4 = i(iVar.m0());
                String a0 = iVar.a0();
                if (TextUtils.isEmpty(a0)) {
                    return 0;
                }
                int P0 = iVar.P0();
                boolean z2 = P0 == 0;
                String n2 = iVar.n();
                String e0 = iVar.e0();
                if (TextUtils.isEmpty(n2)) {
                    n2 = d.l.a.e.a.d.p(a0, e0, iVar.G0(), z2);
                }
                if (n2.length() > 255) {
                    n2 = n2.substring(n2.length() - 255);
                }
                if (TextUtils.isEmpty(e0)) {
                    e0 = n2;
                }
                String G0 = iVar.G0();
                if (n2.endsWith(".apk") && !d.l.a.e.a.d.O(iVar.G0())) {
                    G0 = "application/vnd.android.package-archive";
                }
                String i0 = iVar.i0();
                if (TextUtils.isEmpty(iVar.i0())) {
                    i0 = d.l.a.e.a.d.F();
                }
                String str2 = i0;
                if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(n2)) {
                    int w = d.l.a.e.b.g.e.w(a0, str2);
                    if (d.l.a.e.b.j.a.g(iVar.R()).l("resume_task_override_settings") && (f2 = d.l.a.e.b.g.a.H(d.l.a.e.b.g.e.n()).f(w)) != null) {
                        try {
                            iVar.J(new JSONObject(f2.getDownloadSettingString()));
                        } catch (Throwable unused) {
                        }
                    }
                    d.l.a.e.b.j.a.j(w, iVar.R());
                    boolean m2 = iVar.m();
                    boolean z3 = (d.l.a.e.b.j.a.d(w).b("modify_force", 1) == 1 && !m2 && d.l.a.e.b.l.f.E0(str2, n2) && d.l.a.e.b.g.a.H(iVar.S()).f(w) == null) ? true : m2;
                    d.l.a.e.a.f.b C0 = iVar.C0();
                    if (C0 == null && (iVar.p0() || iVar.s0())) {
                        if (iVar.K0() != null) {
                            C0 = new d.l.a.e.a.f.b(iVar.K0());
                        } else {
                            i2 = w;
                            str = str2;
                            C0 = new d.l.a.e.a.f.b(iVar.S(), w, e0, str, n2, iVar.E0());
                            p2 = iVar.p();
                            if (p2 == null) {
                                p2 = new b(this);
                            }
                            a2 = d.l.a.e.b.g.e.a();
                            if (!a2.isEmpty()) {
                                for (d.l.a.e.b.f.q qVar : a2) {
                                    iVar.E(qVar);
                                }
                            }
                            E0 = iVar.E0();
                            if (TextUtils.isEmpty(E0)) {
                                jSONObject = new JSONObject(E0);
                            } else {
                                jSONObject = new JSONObject();
                            }
                            jSONObject.put("auto_install_with_notification", iVar.v0());
                            jSONObject.put("auto_install_without_notification", iVar.s0());
                            String jSONObject2 = jSONObject.toString();
                            if (!iVar.p0() && !iVar.s0()) {
                                z = false;
                                if (z || d.l.a.e.b.j.a.d(i2).m("enable_notification_ui") < 1) {
                                    i3 = i2;
                                } else {
                                    i3 = i2;
                                    com.ss.android.socialbase.appdownloader.e.c.d().f(i3, iVar.O());
                                }
                                G = d.l.a.e.b.g.d.G(iVar.S());
                                G.P0(a0);
                                G.i(iVar.P());
                                G.j0(n2);
                                G.O0(e0);
                                G.D0(str);
                                G.w0(iVar.y0());
                                G.x(i4);
                                G.o(p2);
                                G.A0(iVar.T0());
                                G.h(iVar.U0());
                                G.K0(z);
                                G.w(jSONObject2);
                                G.f0(G0);
                                G.g0(iVar.f());
                                G.d0(iVar.g());
                                G.b0(iVar.A0());
                                G.u0(C0);
                                G.t0(d(iVar.q()));
                                G.B(z3);
                                G.g(iVar.N0());
                                G.L0(iVar.O0());
                                G.l(iVar.L0());
                                G.k(iVar.M0());
                                G.m0(iVar.I0());
                                G.x0(iVar.Q0());
                                G.e0(iVar.R0());
                                G.v(iVar.S0());
                                G.o0(iVar.a());
                                G.B0(iVar.b());
                                G.l0(iVar.c());
                                G.q0(iVar.d());
                                G.p0(iVar.h());
                                G.n0(iVar.i());
                                G.t(iVar.l());
                                G.h0(iVar.o());
                                G.C0(iVar.e());
                                G.W(iVar.j());
                                G.z(iVar.r());
                                G.p(iVar.Q());
                                G.k0(iVar.k());
                                G.s0(iVar.s());
                                G.s(iVar.R());
                                G.X(iVar.O());
                                G.r0(iVar.x());
                                G.i0(iVar.y());
                                G.y(iVar.z());
                                G.u(iVar.v());
                                G.N0(iVar.w());
                                G.q(iVar.M());
                                G.E0(iVar.N());
                                if (G != null && !iVar.t().isEmpty()) {
                                    G.G0(iVar.t());
                                }
                                if (G != null) {
                                    if (z && iVar.u() && iVar.A() != null && !iVar.A().isFinishing() && !d.l.a.e.a.f.c.d()) {
                                        d.l.a.e.a.f.c.b(iVar.A(), new c(this, e0, G, P0, z2));
                                    } else {
                                        String str3 = m;
                                        d.l.a.e.b.c.a.g(str3, "notification permission need not request, start download :" + e0);
                                        r(G, P0, z2);
                                        G.J();
                                    }
                                }
                                return i3;
                            }
                            z = true;
                            if (z) {
                            }
                            i3 = i2;
                            G = d.l.a.e.b.g.d.G(iVar.S());
                            G.P0(a0);
                            G.i(iVar.P());
                            G.j0(n2);
                            G.O0(e0);
                            G.D0(str);
                            G.w0(iVar.y0());
                            G.x(i4);
                            G.o(p2);
                            G.A0(iVar.T0());
                            G.h(iVar.U0());
                            G.K0(z);
                            G.w(jSONObject2);
                            G.f0(G0);
                            G.g0(iVar.f());
                            G.d0(iVar.g());
                            G.b0(iVar.A0());
                            G.u0(C0);
                            G.t0(d(iVar.q()));
                            G.B(z3);
                            G.g(iVar.N0());
                            G.L0(iVar.O0());
                            G.l(iVar.L0());
                            G.k(iVar.M0());
                            G.m0(iVar.I0());
                            G.x0(iVar.Q0());
                            G.e0(iVar.R0());
                            G.v(iVar.S0());
                            G.o0(iVar.a());
                            G.B0(iVar.b());
                            G.l0(iVar.c());
                            G.q0(iVar.d());
                            G.p0(iVar.h());
                            G.n0(iVar.i());
                            G.t(iVar.l());
                            G.h0(iVar.o());
                            G.C0(iVar.e());
                            G.W(iVar.j());
                            G.z(iVar.r());
                            G.p(iVar.Q());
                            G.k0(iVar.k());
                            G.s0(iVar.s());
                            G.s(iVar.R());
                            G.X(iVar.O());
                            G.r0(iVar.x());
                            G.i0(iVar.y());
                            G.y(iVar.z());
                            G.u(iVar.v());
                            G.N0(iVar.w());
                            G.q(iVar.M());
                            G.E0(iVar.N());
                            if (G != null) {
                                G.G0(iVar.t());
                            }
                            if (G != null) {
                            }
                            return i3;
                        }
                    }
                    i2 = w;
                    str = str2;
                    p2 = iVar.p();
                    if (p2 == null) {
                    }
                    a2 = d.l.a.e.b.g.e.a();
                    if (!a2.isEmpty()) {
                    }
                    E0 = iVar.E0();
                    if (TextUtils.isEmpty(E0)) {
                    }
                    jSONObject.put("auto_install_with_notification", iVar.v0());
                    jSONObject.put("auto_install_without_notification", iVar.s0());
                    String jSONObject22 = jSONObject.toString();
                    if (!iVar.p0()) {
                        z = false;
                        if (z) {
                        }
                        i3 = i2;
                        G = d.l.a.e.b.g.d.G(iVar.S());
                        G.P0(a0);
                        G.i(iVar.P());
                        G.j0(n2);
                        G.O0(e0);
                        G.D0(str);
                        G.w0(iVar.y0());
                        G.x(i4);
                        G.o(p2);
                        G.A0(iVar.T0());
                        G.h(iVar.U0());
                        G.K0(z);
                        G.w(jSONObject22);
                        G.f0(G0);
                        G.g0(iVar.f());
                        G.d0(iVar.g());
                        G.b0(iVar.A0());
                        G.u0(C0);
                        G.t0(d(iVar.q()));
                        G.B(z3);
                        G.g(iVar.N0());
                        G.L0(iVar.O0());
                        G.l(iVar.L0());
                        G.k(iVar.M0());
                        G.m0(iVar.I0());
                        G.x0(iVar.Q0());
                        G.e0(iVar.R0());
                        G.v(iVar.S0());
                        G.o0(iVar.a());
                        G.B0(iVar.b());
                        G.l0(iVar.c());
                        G.q0(iVar.d());
                        G.p0(iVar.h());
                        G.n0(iVar.i());
                        G.t(iVar.l());
                        G.h0(iVar.o());
                        G.C0(iVar.e());
                        G.W(iVar.j());
                        G.z(iVar.r());
                        G.p(iVar.Q());
                        G.k0(iVar.k());
                        G.s0(iVar.s());
                        G.s(iVar.R());
                        G.X(iVar.O());
                        G.r0(iVar.x());
                        G.i0(iVar.y());
                        G.y(iVar.z());
                        G.u(iVar.v());
                        G.N0(iVar.w());
                        G.q(iVar.M());
                        G.E0(iVar.N());
                        if (G != null) {
                        }
                        if (G != null) {
                        }
                        return i3;
                    }
                    z = true;
                    if (z) {
                    }
                    i3 = i2;
                    G = d.l.a.e.b.g.d.G(iVar.S());
                    G.P0(a0);
                    G.i(iVar.P());
                    G.j0(n2);
                    G.O0(e0);
                    G.D0(str);
                    G.w0(iVar.y0());
                    G.x(i4);
                    G.o(p2);
                    G.A0(iVar.T0());
                    G.h(iVar.U0());
                    G.K0(z);
                    G.w(jSONObject22);
                    G.f0(G0);
                    G.g0(iVar.f());
                    G.d0(iVar.g());
                    G.b0(iVar.A0());
                    G.u0(C0);
                    G.t0(d(iVar.q()));
                    G.B(z3);
                    G.g(iVar.N0());
                    G.L0(iVar.O0());
                    G.l(iVar.L0());
                    G.k(iVar.M0());
                    G.m0(iVar.I0());
                    G.x0(iVar.Q0());
                    G.e0(iVar.R0());
                    G.v(iVar.S0());
                    G.o0(iVar.a());
                    G.B0(iVar.b());
                    G.l0(iVar.c());
                    G.q0(iVar.d());
                    G.p0(iVar.h());
                    G.n0(iVar.i());
                    G.t(iVar.l());
                    G.h0(iVar.o());
                    G.C0(iVar.e());
                    G.W(iVar.j());
                    G.z(iVar.r());
                    G.p(iVar.Q());
                    G.k0(iVar.k());
                    G.s0(iVar.s());
                    G.s(iVar.R());
                    G.X(iVar.O());
                    G.r0(iVar.x());
                    G.i0(iVar.y());
                    G.y(iVar.z());
                    G.u(iVar.v());
                    G.N0(iVar.w());
                    G.q(iVar.M());
                    G.E0(iVar.N());
                    if (G != null) {
                    }
                    if (G != null) {
                    }
                    return i3;
                }
                return 0;
            } catch (Throwable th) {
                d.l.a.e.b.e.a.e(iVar.o(), null, new BaseException(1003, d.l.a.e.b.l.f.a0(th, "addDownloadTask")), 0);
                d.l.a.e.b.c.a.k(m, String.format("add download task error:%s", th));
                return 0;
            }
        }
        return invokeL.intValue;
    }

    public d.e b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f71611d : (d.e) invokeV.objValue;
    }

    public final d.l.a.e.b.f.d d(d.g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, gVar)) == null) {
            if (gVar == null) {
                return null;
            }
            return new d(this, gVar);
        }
        return (d.l.a.e.b.f.d) invokeL.objValue;
    }

    public DownloadInfo e(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048592, this, context, str)) == null) {
            if (!TextUtils.isEmpty(str) && context != null) {
                try {
                    DownloadInfo f2 = f(context, str, E());
                    if (f2 == null) {
                        f2 = f(context, str, context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS));
                    }
                    if (f2 == null) {
                        f2 = f(context, str, Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS));
                    }
                    if (f2 == null) {
                        f2 = f(context, str, context.getFilesDir());
                    }
                    return (f2 == null && d.l.a.e.b.j.a.r().l("get_download_info_by_list")) ? v(context, str) : f2;
                } catch (Throwable th) {
                    d.l.a.e.b.c.a.g(m, String.format("getAppDownloadInfo error:%s", th.getMessage()));
                }
            }
            return null;
        }
        return (DownloadInfo) invokeLL.objValue;
    }

    public final DownloadInfo f(Context context, String str, File file) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048593, this, context, str, file)) == null) {
            if (context == null || TextUtils.isEmpty(str) || file == null) {
                return null;
            }
            return d.l.a.e.b.g.a.H(context).g(str, file.getAbsolutePath());
        }
        return (DownloadInfo) invokeLLL.objValue;
    }

    public String g(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048594, this, str, str2)) == null) ? (TextUtils.isEmpty(str) || !str.endsWith(".apk") || d.l.a.e.a.d.O(str2)) ? str2 : "application/vnd.android.package-archive" : (String) invokeLL.objValue;
    }

    public List<DownloadInfo> h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, context)) == null) ? d.l.a.e.b.g.a.H(context).q("application/vnd.android.package-archive") : (List) invokeL.objValue;
    }

    public final List<com.ss.android.socialbase.downloader.model.c> i(List<com.ss.android.socialbase.downloader.model.c> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, list)) == null) {
            ArrayList arrayList = new ArrayList();
            boolean z = false;
            if (list != null && list.size() > 0) {
                for (com.ss.android.socialbase.downloader.model.c cVar : list) {
                    if (cVar != null && !TextUtils.isEmpty(cVar.a()) && !TextUtils.isEmpty(cVar.b())) {
                        if (cVar.a().equals("User-Agent")) {
                            z = true;
                        }
                        arrayList.add(new com.ss.android.socialbase.downloader.model.c(cVar.a(), cVar.b()));
                    }
                }
            }
            if (!z) {
                arrayList.add(new com.ss.android.socialbase.downloader.model.c("User-Agent", c.h.f71597a));
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public void j(Context context, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048597, this, context, i2, i3) == null) {
            try {
                switch (i3) {
                    case -4:
                    case -1:
                        d.l.a.e.b.g.a.H(context).y(i2);
                        break;
                    case -3:
                        d.l.a.e.a.d.d(context, i2, true);
                        break;
                    case -2:
                        d.l.a.e.b.g.a.H(context).B(i2);
                        break;
                    case 0:
                    case 6:
                    default:
                        return;
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 7:
                    case 8:
                        d.l.a.e.b.g.a.H(context).u(i2);
                        break;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Deprecated
    public void k(Context context, String str, d.e eVar, d.f fVar, d.j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048598, this, context, str, eVar, fVar, jVar) == null) {
            if (eVar != null) {
                this.f71611d = eVar;
            }
            if (fVar != null) {
                this.f71612e = fVar;
            }
            if (jVar != null) {
                this.f71613f = jVar;
            }
            z(context);
        }
    }

    public void l(d.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, iVar) == null) {
            this.f71614g = iVar;
        }
    }

    public void m(d.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, lVar) == null) {
            this.j = lVar;
        }
    }

    public void o(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, hVar) == null) {
            this.k = hVar;
        }
    }

    public void p(d.l.a.e.b.f.j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, jVar) == null) {
            this.l = jVar;
        }
    }

    public void q(d.l.a.e.b.g.r rVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, rVar) == null) {
            d.l.a.e.b.g.a.H(d.l.a.e.b.g.e.n()).F(rVar);
        }
    }

    public final void r(d.l.a.e.b.n.a aVar, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048604, this, new Object[]{aVar, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || aVar == null) {
            return;
        }
        aVar.r();
        DownloadInfo J = aVar.J();
        if (J != null) {
            J.setAntiHijackErrorCode(i2);
        }
        if (J == null || !z) {
            return;
        }
        J.setSavePathRedirected(z);
    }

    public void s(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048605, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.f71609b = str;
    }

    public d.f u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.f71612e : (d.f) invokeV.objValue;
    }

    public final DownloadInfo v(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048607, this, context, str)) == null) {
            List<DownloadInfo> h2 = d.l.a.e.b.g.a.H(context).h(str);
            if (h2 != null) {
                for (DownloadInfo downloadInfo : h2) {
                    if (downloadInfo != null && downloadInfo.isSavePathRedirected()) {
                        return downloadInfo;
                    }
                }
                return null;
            }
            return null;
        }
        return (DownloadInfo) invokeLL.objValue;
    }

    public List<DownloadInfo> w(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, context)) == null) ? d.l.a.e.b.g.a.H(context).j("application/vnd.android.package-archive") : (List) invokeL.objValue;
    }

    public void x(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, str) == null) {
            d.l.a.e.b.g.a.H(d.l.a.e.b.g.e.n()).C(str);
        }
    }

    public d.j y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.f71613f : (d.j) invokeV.objValue;
    }

    public final void z(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048611, this, context) == null) || context == null || o) {
            return;
        }
        d.l.a.e.b.d.c.a("application/vnd.android.package-archive");
        d.l.a.e.b.g.e.C(context);
        d.l.a.e.b.g.e.Q(new f());
        N();
        O();
        o = true;
    }

    /* renamed from: d.l.a.e.a.e$e  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C2037e extends d.AbstractC2036d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public AlertDialog.Builder f71624a;

        /* renamed from: d.l.a.e.a.e$e$a */
        /* loaded from: classes8.dex */
        public static class a implements d.m {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public AlertDialog f71625a;

            public a(AlertDialog.Builder builder) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {builder};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                if (builder != null) {
                    this.f71625a = builder.show();
                }
            }

            @Override // d.l.a.e.a.d.m
            public void a() {
                AlertDialog alertDialog;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (alertDialog = this.f71625a) == null) {
                    return;
                }
                alertDialog.show();
            }

            @Override // d.l.a.e.a.d.m
            public boolean b() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    AlertDialog alertDialog = this.f71625a;
                    if (alertDialog != null) {
                        return alertDialog.isShowing();
                    }
                    return false;
                }
                return invokeV.booleanValue;
            }
        }

        public C2037e(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f71624a = new AlertDialog.Builder(context);
        }

        @Override // d.l.a.e.a.d.n
        public d.n a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
                AlertDialog.Builder builder = this.f71624a;
                if (builder != null) {
                    builder.setTitle(i2);
                }
                return this;
            }
            return (d.n) invokeI.objValue;
        }

        @Override // d.l.a.e.a.d.n
        public d.n b(int i2, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048580, this, i2, onClickListener)) == null) {
                AlertDialog.Builder builder = this.f71624a;
                if (builder != null) {
                    builder.setPositiveButton(i2, onClickListener);
                }
                return this;
            }
            return (d.n) invokeIL.objValue;
        }

        @Override // d.l.a.e.a.d.n
        public d.n c(DialogInterface.OnCancelListener onCancelListener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, onCancelListener)) == null) {
                AlertDialog.Builder builder = this.f71624a;
                if (builder != null) {
                    builder.setOnCancelListener(onCancelListener);
                }
                return this;
            }
            return (d.n) invokeL.objValue;
        }

        @Override // d.l.a.e.a.d.n
        public d.n a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                AlertDialog.Builder builder = this.f71624a;
                if (builder != null) {
                    builder.setMessage(str);
                }
                return this;
            }
            return (d.n) invokeL.objValue;
        }

        @Override // d.l.a.e.a.d.n
        public d.n a(int i2, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, onClickListener)) == null) {
                AlertDialog.Builder builder = this.f71624a;
                if (builder != null) {
                    builder.setNegativeButton(i2, onClickListener);
                }
                return this;
            }
            return (d.n) invokeIL.objValue;
        }

        @Override // d.l.a.e.a.d.n
        public d.m a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new a(this.f71624a) : (d.m) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class d implements d.l.a.e.b.f.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.g f71623a;

        public d(e eVar, d.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f71623a = gVar;
        }

        @Override // d.l.a.e.b.f.d
        public void a(int i2, DownloadInfo downloadInfo, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), downloadInfo, str, str2}) == null) {
                if (i2 != 1 && i2 != 3) {
                    switch (i2) {
                        case 5:
                        case 6:
                        case 7:
                            break;
                        case 8:
                            this.f71623a.b(i2, downloadInfo.getPackageName(), str, str2);
                            return;
                        case 9:
                            this.f71623a.a(d.l.a.e.b.g.e.n(), str);
                            return;
                        case 10:
                            this.f71623a.a(downloadInfo);
                            return;
                        default:
                            return;
                    }
                }
                this.f71623a.a(i2, str, downloadInfo.getStatus(), downloadInfo.getDownloadTime());
            }
        }

        @Override // d.l.a.e.b.f.d
        public boolean a(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) ? this.f71623a.a(z) : invokeZ.booleanValue;
        }

        @Override // d.l.a.e.b.f.d
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f71623a.a() : (String) invokeV.objValue;
        }
    }
}
