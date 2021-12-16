package com.ss.android.socialbase.appdownloader.d;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.appdownloader.c.g;
import com.ss.android.socialbase.appdownloader.d;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.c;
import com.ss.android.socialbase.downloader.downloader.l;
import com.ss.android.socialbase.downloader.i.f;
import com.ss.android.socialbase.downloader.impls.r;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b implements l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<Integer> a;

    /* renamed from: b  reason: collision with root package name */
    public BroadcastReceiver f62089b;

    public b() {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void b(List<DownloadInfo> list, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65545, this, list, i2) == null) || list == null || list.isEmpty()) {
            return;
        }
        g l = d.j().l();
        if (l != null) {
            l.a(list);
        }
        Context N = c.N();
        if (N == null) {
            return;
        }
        boolean b2 = f.b(N);
        for (DownloadInfo downloadInfo : list) {
            a(N, downloadInfo, b2, i2);
        }
        List<Integer> list2 = this.a;
        if (list2 == null || list2.isEmpty() || this.f62089b != null) {
            return;
        }
        this.f62089b = new BroadcastReceiver(this) { // from class: com.ss.android.socialbase.appdownloader.d.b.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048576, this, context, intent) == null) {
                    Context applicationContext = context.getApplicationContext();
                    if (f.b(applicationContext)) {
                        com.ss.android.socialbase.downloader.c.a.b("LaunchResume", "onReceive : wifi connected !!!");
                        c.l().execute(new Runnable(this, applicationContext) { // from class: com.ss.android.socialbase.appdownloader.d.b.2.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ Context a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass2 f62092b;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, applicationContext};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i3 = newInitContext.flag;
                                    if ((i3 & 1) != 0) {
                                        int i4 = i3 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f62092b = this;
                                this.a = applicationContext;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    try {
                                        if (this.f62092b.a.a != null && !this.f62092b.a.a.isEmpty()) {
                                            int size = this.f62092b.a.a.size();
                                            Integer[] numArr = new Integer[size];
                                            this.f62092b.a.a.toArray(numArr);
                                            this.f62092b.a.a.clear();
                                            for (int i3 = 0; i3 < size; i3++) {
                                                DownloadInfo downloadInfo2 = Downloader.getInstance(this.a).getDownloadInfo(numArr[i3].intValue());
                                                if (downloadInfo2 != null && (downloadInfo2.getRealStatus() == -5 || (downloadInfo2.getRealStatus() == -2 && downloadInfo2.isPauseReserveOnWifi()))) {
                                                    this.f62092b.a.a(this.a, downloadInfo2, true, 2);
                                                }
                                            }
                                        }
                                    } catch (Exception e2) {
                                        e2.printStackTrace();
                                    }
                                }
                            }
                        });
                        try {
                            applicationContext.unregisterReceiver(this.a.f62089b);
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                        this.a.f62089b = null;
                    }
                }
            }
        };
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            N.registerReceiver(this.f62089b, intentFilter);
        } catch (Throwable th) {
            th.printStackTrace();
            this.f62089b = null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public List<String> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? com.ss.android.socialbase.appdownloader.c.c() : (List) invokeV.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void a(List<DownloadInfo> list, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, i2) == null) {
            if (f.d()) {
                c.l().execute(new Runnable(this, list, i2) { // from class: com.ss.android.socialbase.appdownloader.d.b.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ List a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ int f62090b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ b f62091c;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, list, Integer.valueOf(i2)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f62091c = this;
                        this.a = list;
                        this.f62090b = i2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            try {
                                this.f62091c.b(this.a, this.f62090b);
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                });
            } else {
                b(list, i2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:105:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:107:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01c3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(Context context, DownloadInfo downloadInfo, boolean z, int i2) {
        String str;
        boolean z2;
        int i3;
        String str2;
        String str3;
        boolean z3;
        boolean z4;
        g l;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65539, this, new Object[]{context, downloadInfo, Boolean.valueOf(z), Integer.valueOf(i2)}) != null) || downloadInfo == null || !downloadInfo.isShowNotification()) {
            return;
        }
        int realStatus = downloadInfo.getRealStatus();
        if (realStatus == -5 && ("application/ttpatch".equalsIgnoreCase(downloadInfo.getMimeType()) || !downloadInfo.isDownloaded())) {
            com.ss.android.socialbase.downloader.g.a a = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId());
            int a2 = a.a("failed_resume_max_count", 0);
            double a3 = a.a("failed_resume_max_hours", 72.0d);
            double a4 = a.a("failed_resume_min_hours", 12.0d);
            long currentTimeMillis = System.currentTimeMillis();
            if (downloadInfo.getFailedResumeCount() < a2) {
                str2 = ", canShowNotification = ";
                str3 = "LaunchResume";
                if (currentTimeMillis - downloadInfo.getLastDownloadTime() < a3 * 3600000.0d && currentTimeMillis - downloadInfo.getLastFailedResumeTime() > a4 * 3600000.0d) {
                    z3 = true;
                    if (downloadInfo.isPauseReserveOnWifi() && z) {
                        z3 = true;
                    }
                    if (z3) {
                        boolean z5 = a.a("failed_resume_need_wifi", 1) == 1;
                        boolean z6 = a.a("failed_resume_need_wait_wifi", 0) == 1;
                        if (!z && z5 && z6) {
                            if (this.a == null) {
                                this.a = new ArrayList();
                            }
                            int id = downloadInfo.getId();
                            if (!this.a.contains(Integer.valueOf(id))) {
                                this.a.add(Integer.valueOf(id));
                            }
                            downloadInfo.setOnlyWifi(true);
                            r.a().a(downloadInfo);
                        } else {
                            z4 = true;
                            com.ss.android.socialbase.appdownloader.c.a(downloadInfo, true, z5);
                            downloadInfo.setLastFailedResumeTime(currentTimeMillis);
                            downloadInfo.setFailedResumeCount(downloadInfo.getFailedResumeCount() + 1);
                            downloadInfo.updateSpData();
                            if (downloadInfo.isPauseReserveOnWifi() && z) {
                                downloadInfo.setDownloadFromReserveWifi(true);
                                com.ss.android.socialbase.downloader.downloader.r m = d.j().m();
                                if (m != null) {
                                    m.a(downloadInfo, 5, i2);
                                }
                            }
                            com.ss.android.socialbase.downloader.c.a.c(str3, "launchResume, name = " + downloadInfo.getTitle() + str2 + z3 + ", downloadResumed = " + z4);
                            l = d.j().l();
                            if (l != null) {
                                l.a(downloadInfo, z4);
                                return;
                            }
                            return;
                        }
                    }
                    z4 = false;
                    com.ss.android.socialbase.downloader.c.a.c(str3, "launchResume, name = " + downloadInfo.getTitle() + str2 + z3 + ", downloadResumed = " + z4);
                    l = d.j().l();
                    if (l != null) {
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
            com.ss.android.socialbase.downloader.c.a.c(str3, "launchResume, name = " + downloadInfo.getTitle() + str2 + z3 + ", downloadResumed = " + z4);
            l = d.j().l();
            if (l != null) {
            }
        } else if (realStatus != -3 || !a(downloadInfo)) {
            if (realStatus == -2) {
                if (!downloadInfo.isPauseReserveOnWifi()) {
                    a(downloadInfo, context);
                } else if (z) {
                    com.ss.android.socialbase.appdownloader.c.a(downloadInfo, true, true);
                    downloadInfo.updateSpData();
                    downloadInfo.setDownloadFromReserveWifi(true);
                    g l2 = d.j().l();
                    if (l2 != null) {
                        l2.a(downloadInfo, true);
                    }
                    com.ss.android.socialbase.downloader.downloader.r m2 = d.j().m();
                    if (m2 != null) {
                        m2.a(downloadInfo, 5, i2);
                    }
                } else {
                    if (this.a == null) {
                        this.a = new ArrayList();
                    }
                    int id2 = downloadInfo.getId();
                    if (!this.a.contains(Integer.valueOf(id2))) {
                        this.a.add(Integer.valueOf(id2));
                    }
                    r.a().a(downloadInfo);
                    a(downloadInfo, context);
                }
            }
        } else {
            com.ss.android.socialbase.downloader.g.a a5 = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId());
            if (com.ss.android.socialbase.appdownloader.c.a(context, downloadInfo)) {
                return;
            }
            int a6 = a5.a("uninstall_resume_max_count", 0);
            double a7 = a5.a("uninstall_resume_max_hours", 72.0d);
            double a8 = a5.a("uninstall_resume_min_hours", 12.0d);
            long currentTimeMillis2 = System.currentTimeMillis();
            if (downloadInfo.getUninstallResumeCount() < a6) {
                str = "LaunchResume";
                if (currentTimeMillis2 - downloadInfo.getLastDownloadTime() < a7 * 3600000.0d && currentTimeMillis2 - downloadInfo.getLastUninstallResumeTime() > a8 * 3600000.0d) {
                    z2 = true;
                    com.ss.android.socialbase.downloader.c.a.c(str, "uninstallResume, name = " + downloadInfo.getTitle() + ", canShowNotification = " + z2);
                    if (z2) {
                        return;
                    }
                    com.ss.android.socialbase.downloader.notification.a e2 = com.ss.android.socialbase.downloader.notification.b.a().e(downloadInfo.getId());
                    if (e2 == null) {
                        i3 = 1;
                        com.ss.android.socialbase.appdownloader.e.a aVar = new com.ss.android.socialbase.appdownloader.e.a(context, downloadInfo.getId(), downloadInfo.getTitle(), downloadInfo.getSavePath(), downloadInfo.getName(), downloadInfo.getExtra());
                        com.ss.android.socialbase.downloader.notification.b.a().a(aVar);
                        e2 = aVar;
                    } else {
                        i3 = 1;
                        e2.a(downloadInfo);
                    }
                    e2.b(downloadInfo.getTotalBytes());
                    e2.a(downloadInfo.getTotalBytes());
                    e2.a(downloadInfo.getStatus(), null, false, false);
                    downloadInfo.setLastUninstallResumeTime(currentTimeMillis2);
                    downloadInfo.setUninstallResumeCount(downloadInfo.getUninstallResumeCount() + i3);
                    downloadInfo.updateSpData();
                    return;
                }
            } else {
                str = "LaunchResume";
            }
            z2 = false;
            com.ss.android.socialbase.downloader.c.a.c(str, "uninstallResume, name = " + downloadInfo.getTitle() + ", canShowNotification = " + z2);
            if (z2) {
            }
        }
    }

    private void a(DownloadInfo downloadInfo, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, this, downloadInfo, context) == null) {
            com.ss.android.socialbase.downloader.g.a a = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId());
            int a2 = a.a("paused_resume_max_count", 0);
            double a3 = a.a("paused_resume_max_hours", 72.0d);
            int pausedResumeCount = downloadInfo.getPausedResumeCount();
            if (pausedResumeCount < a2 && ((double) (System.currentTimeMillis() - downloadInfo.getLastDownloadTime())) < a3 * 3600000.0d) {
                com.ss.android.socialbase.downloader.notification.a e2 = com.ss.android.socialbase.downloader.notification.b.a().e(downloadInfo.getId());
                if (e2 == null) {
                    e2 = new com.ss.android.socialbase.appdownloader.e.a(context, downloadInfo.getId(), downloadInfo.getTitle(), downloadInfo.getSavePath(), downloadInfo.getName(), downloadInfo.getExtra());
                    com.ss.android.socialbase.downloader.notification.b.a().a(e2);
                } else {
                    e2.a(downloadInfo);
                }
                e2.b(downloadInfo.getTotalBytes());
                e2.a(downloadInfo.getCurBytes());
                e2.a(downloadInfo.getStatus(), null, false, false);
                downloadInfo.setPausedResumeCount(pausedResumeCount + 1);
                downloadInfo.updateSpData();
            }
        }
    }

    private boolean a(DownloadInfo downloadInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, downloadInfo)) == null) {
            if (com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).b("uninstall_can_not_resume_for_force_task", false)) {
                return f.a(downloadInfo, false, downloadInfo.getMd5());
            }
            return downloadInfo.isDownloaded();
        }
        return invokeL.booleanValue;
    }
}
