package com.ss.android.socialbase.appdownloader;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.baidu.nps.utils.Constant;
import com.baidu.searchbox.ui.animview.praise.NetworkMonitor;
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
import com.ss.android.socialbase.appdownloader.c.j;
import com.ss.android.socialbase.appdownloader.c.m;
import com.ss.android.socialbase.downloader.depend.ad;
import com.ss.android.socialbase.downloader.depend.ag;
import com.ss.android.socialbase.downloader.depend.n;
import com.ss.android.socialbase.downloader.depend.z;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.impls.r;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class d {
    public static final String a = "d";
    public static volatile d b;
    public static boolean f;
    public static boolean g;
    public String c;
    public String d;
    public DownloadReceiver e;
    public boolean h = false;
    public com.ss.android.socialbase.appdownloader.c.c i;
    public com.ss.android.socialbase.appdownloader.c.d j;
    public com.ss.android.socialbase.appdownloader.c.h k;
    public com.ss.android.socialbase.appdownloader.c.g l;
    public m m;
    public com.ss.android.socialbase.appdownloader.c.f n;
    public j o;
    public ad p;
    public ag q;

    public static d j() {
        if (b == null) {
            synchronized (d.class) {
                if (b == null) {
                    b = new d();
                }
            }
        }
        return b;
    }

    private void r() {
        if (Build.VERSION.SDK_INT >= 21) {
            r.a(new r.b() { // from class: com.ss.android.socialbase.appdownloader.d.1
                @Override // com.ss.android.socialbase.downloader.impls.r.b
                public void a(DownloadInfo downloadInfo, long j, boolean z, int i) {
                    RetryJobSchedulerService.a(downloadInfo, j, z, i);
                }
            });
        }
    }

    public com.ss.android.socialbase.appdownloader.c.c a() {
        return this.i;
    }

    public com.ss.android.socialbase.appdownloader.c.d b() {
        return this.j;
    }

    public com.ss.android.socialbase.appdownloader.c.h c() {
        return this.k;
    }

    public String d() {
        return this.d;
    }

    public com.ss.android.socialbase.appdownloader.c.f e() {
        return this.n;
    }

    public boolean f() {
        if (com.ss.android.socialbase.downloader.g.a.b().optInt("package_flag_config", 1) == 1) {
            return true;
        }
        return false;
    }

    public j g() {
        return this.o;
    }

    public File h() {
        return Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.c.N()).getGlobalSaveDir();
    }

    public String i() {
        return this.c;
    }

    public m k() {
        return this.m;
    }

    public com.ss.android.socialbase.appdownloader.c.g l() {
        return this.l;
    }

    public com.ss.android.socialbase.downloader.downloader.r m() {
        return Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.c.N()).getReserveWifiStatusListener();
    }

    public ad n() {
        return this.p;
    }

    public ag o() {
        return this.q;
    }

    private void c(Context context) {
        if (context != null && !f) {
            com.ss.android.socialbase.downloader.constants.e.a("application/vnd.android.package-archive");
            com.ss.android.socialbase.downloader.downloader.c.a(context);
            com.ss.android.socialbase.downloader.downloader.c.a(new com.ss.android.socialbase.appdownloader.d.b());
            q();
            r();
            f = true;
        }
    }

    public List<DownloadInfo> b(Context context) {
        return Downloader.getInstance(context).getDownloadingDownloadInfosWithMimeType("application/vnd.android.package-archive");
    }

    private z a(final com.ss.android.socialbase.appdownloader.c.e eVar) {
        if (eVar == null) {
            return null;
        }
        return new z() { // from class: com.ss.android.socialbase.appdownloader.d.4
            @Override // com.ss.android.socialbase.downloader.depend.z
            public String a() {
                return eVar.a();
            }

            @Override // com.ss.android.socialbase.downloader.depend.z
            public void a(int i, DownloadInfo downloadInfo, String str, String str2) {
                if (i != 1 && i != 3) {
                    switch (i) {
                        case 5:
                        case 6:
                        case 7:
                            break;
                        case 8:
                            eVar.a(i, downloadInfo.getPackageName(), str, str2);
                            return;
                        case 9:
                            eVar.a(com.ss.android.socialbase.downloader.downloader.c.N(), str);
                            return;
                        case 10:
                            eVar.a(downloadInfo);
                            return;
                        default:
                            return;
                    }
                }
                eVar.a(i, str, downloadInfo.getStatus(), downloadInfo.getDownloadTime());
            }

            @Override // com.ss.android.socialbase.downloader.depend.z
            public boolean a(boolean z) {
                return eVar.a(z);
            }
        };
    }

    public void b(String str) {
        Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.c.N()).setDefaultSavePath(str);
    }

    private DownloadInfo a(Context context, String str, File file) {
        if (context != null && !TextUtils.isEmpty(str) && file != null) {
            return Downloader.getInstance(context).getDownloadInfo(str, file.getAbsolutePath());
        }
        return null;
    }

    private List<com.ss.android.socialbase.downloader.model.c> a(List<com.ss.android.socialbase.downloader.model.c> list) {
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
            arrayList.add(new com.ss.android.socialbase.downloader.model.c("User-Agent", com.ss.android.socialbase.appdownloader.b.a.a));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DownloadTask downloadTask, int i, boolean z) {
        if (downloadTask == null) {
            return;
        }
        downloadTask.download();
        DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
        if (downloadInfo != null) {
            downloadInfo.setAntiHijackErrorCode(i);
        }
        if (downloadInfo != null && z) {
            downloadInfo.setSavePathRedirected(z);
        }
    }

    public static boolean a(Context context, int i) {
        if (c.a(context, i, true) == 1) {
            return true;
        }
        return false;
    }

    private DownloadInfo b(Context context, String str) {
        List<DownloadInfo> downloadInfoList = Downloader.getInstance(context).getDownloadInfoList(str);
        if (downloadInfoList != null) {
            for (DownloadInfo downloadInfo : downloadInfoList) {
                if (downloadInfo != null && downloadInfo.isSavePathRedirected()) {
                    return downloadInfo;
                }
            }
            return null;
        }
        return null;
    }

    private void q() {
        if (g) {
            return;
        }
        if (this.e == null) {
            this.e = new DownloadReceiver();
        }
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(NetworkMonitor.NET_CHANGE_ACTION);
            intentFilter.addAction("android.intent.action.BOOT_COMPLETED");
            intentFilter.addAction("android.ss.intent.action.DOWNLOAD_COMPLETE");
            IntentFilter intentFilter2 = new IntentFilter();
            intentFilter2.addAction(PackageChangedReceiver.ACTION_INSTALL);
            intentFilter2.addAction("android.intent.action.PACKAGE_REPLACED");
            intentFilter2.addDataScheme("package");
            IntentFilter intentFilter3 = new IntentFilter();
            intentFilter3.addAction("android.intent.action.MEDIA_MOUNTED");
            intentFilter3.addDataScheme("file");
            com.ss.android.socialbase.downloader.downloader.c.N().registerReceiver(this.e, intentFilter);
            com.ss.android.socialbase.downloader.downloader.c.N().registerReceiver(this.e, intentFilter2);
            com.ss.android.socialbase.downloader.downloader.c.N().registerReceiver(this.e, intentFilter3);
            g = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(25:37|(2:41|42)|45|(1:113)(1:52)|53|(2:59|(1:61)(19:62|63|(1:65)|66|(3:68|(2:71|69)|72)|73|74|75|(1:77)(1:110)|78|79|(6:84|(1:107)(1:88)|89|(1:93)|(1:(1:105)(1:104))|106)|108|(1:86)|107|89|(2:91|93)|(0)|106))|112|63|(0)|66|(0)|73|74|75|(0)(0)|78|79|(8:81|84|(0)|107|89|(0)|(0)|106)|108|(0)|107|89|(0)|(0)|106) */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0137 A[Catch: all -> 0x0388, TryCatch #2 {all -> 0x0388, blocks: (B:8:0x0010, B:11:0x0023, B:15:0x002c, B:17:0x003a, B:18:0x0042, B:20:0x004a, B:21:0x0053, B:24:0x005a, B:26:0x0066, B:29:0x0072, B:31:0x0080, B:32:0x0084, B:34:0x008b, B:37:0x0093, B:39:0x00a7, B:42:0x00c1, B:45:0x00da, B:47:0x00e0, B:51:0x00f1, B:53:0x00f7, B:55:0x00fd, B:57:0x0103, B:59:0x0109, B:61:0x0117, B:62:0x0131, B:64:0x0137, B:65:0x013c, B:67:0x0146, B:68:0x014a, B:70:0x0150, B:71:0x015a, B:77:0x0185, B:79:0x018b, B:85:0x0197, B:87:0x01a4, B:89:0x01b4, B:91:0x0328, B:93:0x0332, B:96:0x033d, B:98:0x0343, B:100:0x0349, B:102:0x0353, B:104:0x0359, B:105:0x0369), top: B:120:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0146 A[Catch: all -> 0x0388, TryCatch #2 {all -> 0x0388, blocks: (B:8:0x0010, B:11:0x0023, B:15:0x002c, B:17:0x003a, B:18:0x0042, B:20:0x004a, B:21:0x0053, B:24:0x005a, B:26:0x0066, B:29:0x0072, B:31:0x0080, B:32:0x0084, B:34:0x008b, B:37:0x0093, B:39:0x00a7, B:42:0x00c1, B:45:0x00da, B:47:0x00e0, B:51:0x00f1, B:53:0x00f7, B:55:0x00fd, B:57:0x0103, B:59:0x0109, B:61:0x0117, B:62:0x0131, B:64:0x0137, B:65:0x013c, B:67:0x0146, B:68:0x014a, B:70:0x0150, B:71:0x015a, B:77:0x0185, B:79:0x018b, B:85:0x0197, B:87:0x01a4, B:89:0x01b4, B:91:0x0328, B:93:0x0332, B:96:0x033d, B:98:0x0343, B:100:0x0349, B:102:0x0353, B:104:0x0359, B:105:0x0369), top: B:120:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0164 A[Catch: all -> 0x0185, TryCatch #1 {all -> 0x0185, blocks: (B:72:0x015e, B:74:0x0164, B:76:0x016f, B:75:0x016a), top: B:118:0x015e }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x016a A[Catch: all -> 0x0185, TryCatch #1 {all -> 0x0185, blocks: (B:72:0x015e, B:74:0x0164, B:76:0x016f, B:75:0x016a), top: B:118:0x015e }] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0197 A[Catch: all -> 0x0388, TryCatch #2 {all -> 0x0388, blocks: (B:8:0x0010, B:11:0x0023, B:15:0x002c, B:17:0x003a, B:18:0x0042, B:20:0x004a, B:21:0x0053, B:24:0x005a, B:26:0x0066, B:29:0x0072, B:31:0x0080, B:32:0x0084, B:34:0x008b, B:37:0x0093, B:39:0x00a7, B:42:0x00c1, B:45:0x00da, B:47:0x00e0, B:51:0x00f1, B:53:0x00f7, B:55:0x00fd, B:57:0x0103, B:59:0x0109, B:61:0x0117, B:62:0x0131, B:64:0x0137, B:65:0x013c, B:67:0x0146, B:68:0x014a, B:70:0x0150, B:71:0x015a, B:77:0x0185, B:79:0x018b, B:85:0x0197, B:87:0x01a4, B:89:0x01b4, B:91:0x0328, B:93:0x0332, B:96:0x033d, B:98:0x0343, B:100:0x0349, B:102:0x0353, B:104:0x0359, B:105:0x0369), top: B:120:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0328 A[Catch: all -> 0x0388, TryCatch #2 {all -> 0x0388, blocks: (B:8:0x0010, B:11:0x0023, B:15:0x002c, B:17:0x003a, B:18:0x0042, B:20:0x004a, B:21:0x0053, B:24:0x005a, B:26:0x0066, B:29:0x0072, B:31:0x0080, B:32:0x0084, B:34:0x008b, B:37:0x0093, B:39:0x00a7, B:42:0x00c1, B:45:0x00da, B:47:0x00e0, B:51:0x00f1, B:53:0x00f7, B:55:0x00fd, B:57:0x0103, B:59:0x0109, B:61:0x0117, B:62:0x0131, B:64:0x0137, B:65:0x013c, B:67:0x0146, B:68:0x014a, B:70:0x0150, B:71:0x015a, B:77:0x0185, B:79:0x018b, B:85:0x0197, B:87:0x01a4, B:89:0x01b4, B:91:0x0328, B:93:0x0332, B:96:0x033d, B:98:0x0343, B:100:0x0349, B:102:0x0353, B:104:0x0359, B:105:0x0369), top: B:120:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x033b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int a(f fVar) {
        final boolean z;
        boolean z2;
        int i;
        String str;
        n N;
        List<com.ss.android.socialbase.downloader.depend.m> A;
        String k;
        boolean z3;
        int i2;
        final DownloadTask autoInstall;
        JSONObject jSONObject;
        DownloadInfo downloadInfo;
        if (fVar != null && fVar.getContext() != null) {
            try {
                List<com.ss.android.socialbase.downloader.model.c> a2 = a(fVar.d());
                String a3 = fVar.a();
                if (TextUtils.isEmpty(a3)) {
                    return 0;
                }
                final int s = fVar.s();
                if (s == 0) {
                    z = true;
                } else {
                    z = false;
                }
                String L = fVar.L();
                final String b2 = fVar.b();
                if (TextUtils.isEmpty(L)) {
                    L = c.a(a3, b2, fVar.l(), z);
                }
                if (L.length() > 255) {
                    L = L.substring(L.length() - 255);
                }
                if (TextUtils.isEmpty(b2)) {
                    b2 = L;
                }
                String l = fVar.l();
                if (L.endsWith(Constant.FILE.SUFFIX.BUNDLE_SUFFIX) && !c.c(fVar.l())) {
                    l = "application/vnd.android.package-archive";
                }
                String c = fVar.c();
                if (TextUtils.isEmpty(fVar.c())) {
                    c = c.b();
                }
                String str2 = c;
                if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(L)) {
                    int a4 = com.ss.android.socialbase.downloader.downloader.c.a(a3, str2);
                    if (com.ss.android.socialbase.downloader.g.a.a(fVar.ad()).a("resume_task_override_settings") && (downloadInfo = Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.c.N()).getDownloadInfo(a4)) != null) {
                        try {
                            fVar.a(new JSONObject(downloadInfo.getDownloadSettingString()));
                        } catch (Throwable unused) {
                        }
                    }
                    com.ss.android.socialbase.downloader.g.a.a(a4, fVar.ad());
                    boolean K = fVar.K();
                    if (com.ss.android.socialbase.downloader.g.a.a(a4).a("modify_force", 1) == 1 && !K && com.ss.android.socialbase.downloader.i.f.d(str2, L) && Downloader.getInstance(fVar.getContext()).getDownloadInfo(a4) == null) {
                        z2 = true;
                    } else {
                        z2 = K;
                    }
                    com.ss.android.socialbase.appdownloader.e.b j = fVar.j();
                    if (j == null && (fVar.e() || fVar.f())) {
                        if (fVar.n() != null) {
                            j = new com.ss.android.socialbase.appdownloader.e.b(fVar.n());
                        } else {
                            i = a4;
                            str = str2;
                            j = new com.ss.android.socialbase.appdownloader.e.b(fVar.getContext(), a4, b2, str, L, fVar.k());
                            N = fVar.N();
                            if (N == null) {
                                N = new n() { // from class: com.ss.android.socialbase.appdownloader.d.2
                                    @Override // com.ss.android.socialbase.downloader.depend.n
                                    public void a(DownloadInfo downloadInfo2, BaseException baseException, int i3) {
                                        if (d.this.k != null) {
                                            d.this.k.a(downloadInfo2, baseException, i3);
                                        }
                                    }
                                };
                            }
                            A = com.ss.android.socialbase.downloader.downloader.c.A();
                            if (!A.isEmpty()) {
                                for (com.ss.android.socialbase.downloader.depend.m mVar : A) {
                                    fVar.a(mVar);
                                }
                            }
                            k = fVar.k();
                            if (TextUtils.isEmpty(k)) {
                                jSONObject = new JSONObject(k);
                            } else {
                                jSONObject = new JSONObject();
                            }
                            jSONObject.put("auto_install_with_notification", fVar.g());
                            jSONObject.put("auto_install_without_notification", fVar.f());
                            String jSONObject2 = jSONObject.toString();
                            if (!fVar.e() && !fVar.f()) {
                                z3 = false;
                                if (!z3 && com.ss.android.socialbase.downloader.g.a.a(i).b("enable_notification_ui") >= 1) {
                                    i2 = i;
                                    com.ss.android.socialbase.appdownloader.e.c.a().a(i2, fVar.aa());
                                } else {
                                    i2 = i;
                                }
                                autoInstall = com.ss.android.socialbase.downloader.downloader.b.with(fVar.getContext()).url(a3).backUpUrls(fVar.ab()).name(L).title(b2).savePath(str).onlyWifi(fVar.h()).extraHeaders(a2).depend(N).retryCount(fVar.w()).backUpUrlRetryCount(fVar.x()).showNotification(z3).extra(jSONObject2).mimeType(l).minProgressTimeMsInterval(fVar.D()).maxProgressCount(fVar.E()).mainThreadListener(fVar.i()).notificationListener(j).notificationEventListener(a(fVar.O())).force(z2).autoResumed(fVar.q()).showNotificationForAutoResumed(fVar.r()).chunkStategy(fVar.o()).chunkAdjustCalculator(fVar.p()).needHttpsToHttpRetry(fVar.m()).packageName(fVar.t()).md5(fVar.u()).expectFileLength(fVar.v()).needRetryDelay(fVar.y()).retryDelayTimeArray(fVar.z()).needDefaultHttpServiceBackUp(fVar.A()).needReuseFirstConnection(fVar.B()).needReuseChunkRunnable(fVar.F()).needIndependentProcess(fVar.G()).enqueueType(fVar.J()).monitorDepend(fVar.M()).retryDelayTimeCalculator(fVar.C()).headConnectionAvailable(fVar.H()).fileUriProvider(fVar.P()).diskSpaceHandler(fVar.ac()).needChunkDowngradeRetry(fVar.I()).notificationClickCallback(fVar.Q()).downloadSetting(fVar.ad()).iconUrl(fVar.aa()).needSDKMonitor(fVar.V()).monitorScene(fVar.W()).extraMonitorStatus(fVar.X()).executorGroup(fVar.T()).throttleNetSpeed(fVar.U()).distinctDirectory(fVar.Y()).setAutoInstall(fVar.Z());
                                if (autoInstall != null && !fVar.R().isEmpty()) {
                                    autoInstall.setDownloadCompleteHandlers(fVar.R());
                                }
                                if (autoInstall != null) {
                                    if (z3 && fVar.S() && fVar.getActivity() != null && !fVar.getActivity().isFinishing() && !com.ss.android.socialbase.appdownloader.e.d.a()) {
                                        com.ss.android.socialbase.appdownloader.e.d.a(fVar.getActivity(), new com.ss.android.socialbase.appdownloader.c.n() { // from class: com.ss.android.socialbase.appdownloader.d.3
                                            @Override // com.ss.android.socialbase.appdownloader.c.n
                                            public void a() {
                                                String str3 = d.a;
                                                com.ss.android.socialbase.downloader.c.a.b(str3, "notification permission granted, start download :" + b2);
                                                d.this.a(autoInstall, s, z);
                                            }

                                            @Override // com.ss.android.socialbase.appdownloader.c.n
                                            public void b() {
                                                String str3 = d.a;
                                                com.ss.android.socialbase.downloader.c.a.b(str3, "notification permission denied, start download :" + b2);
                                                d.this.a(autoInstall, s, z);
                                            }
                                        });
                                    } else {
                                        String str3 = a;
                                        com.ss.android.socialbase.downloader.c.a.b(str3, "notification permission need not request, start download :" + b2);
                                        a(autoInstall, s, z);
                                        autoInstall.getDownloadInfo();
                                    }
                                }
                                return i2;
                            }
                            z3 = true;
                            if (!z3) {
                            }
                            i2 = i;
                            autoInstall = com.ss.android.socialbase.downloader.downloader.b.with(fVar.getContext()).url(a3).backUpUrls(fVar.ab()).name(L).title(b2).savePath(str).onlyWifi(fVar.h()).extraHeaders(a2).depend(N).retryCount(fVar.w()).backUpUrlRetryCount(fVar.x()).showNotification(z3).extra(jSONObject2).mimeType(l).minProgressTimeMsInterval(fVar.D()).maxProgressCount(fVar.E()).mainThreadListener(fVar.i()).notificationListener(j).notificationEventListener(a(fVar.O())).force(z2).autoResumed(fVar.q()).showNotificationForAutoResumed(fVar.r()).chunkStategy(fVar.o()).chunkAdjustCalculator(fVar.p()).needHttpsToHttpRetry(fVar.m()).packageName(fVar.t()).md5(fVar.u()).expectFileLength(fVar.v()).needRetryDelay(fVar.y()).retryDelayTimeArray(fVar.z()).needDefaultHttpServiceBackUp(fVar.A()).needReuseFirstConnection(fVar.B()).needReuseChunkRunnable(fVar.F()).needIndependentProcess(fVar.G()).enqueueType(fVar.J()).monitorDepend(fVar.M()).retryDelayTimeCalculator(fVar.C()).headConnectionAvailable(fVar.H()).fileUriProvider(fVar.P()).diskSpaceHandler(fVar.ac()).needChunkDowngradeRetry(fVar.I()).notificationClickCallback(fVar.Q()).downloadSetting(fVar.ad()).iconUrl(fVar.aa()).needSDKMonitor(fVar.V()).monitorScene(fVar.W()).extraMonitorStatus(fVar.X()).executorGroup(fVar.T()).throttleNetSpeed(fVar.U()).distinctDirectory(fVar.Y()).setAutoInstall(fVar.Z());
                            if (autoInstall != null) {
                                autoInstall.setDownloadCompleteHandlers(fVar.R());
                            }
                            if (autoInstall != null) {
                            }
                            return i2;
                        }
                    }
                    i = a4;
                    str = str2;
                    N = fVar.N();
                    if (N == null) {
                    }
                    A = com.ss.android.socialbase.downloader.downloader.c.A();
                    if (!A.isEmpty()) {
                    }
                    k = fVar.k();
                    if (TextUtils.isEmpty(k)) {
                    }
                    jSONObject.put("auto_install_with_notification", fVar.g());
                    jSONObject.put("auto_install_without_notification", fVar.f());
                    String jSONObject22 = jSONObject.toString();
                    if (!fVar.e()) {
                        z3 = false;
                        if (!z3) {
                        }
                        i2 = i;
                        autoInstall = com.ss.android.socialbase.downloader.downloader.b.with(fVar.getContext()).url(a3).backUpUrls(fVar.ab()).name(L).title(b2).savePath(str).onlyWifi(fVar.h()).extraHeaders(a2).depend(N).retryCount(fVar.w()).backUpUrlRetryCount(fVar.x()).showNotification(z3).extra(jSONObject22).mimeType(l).minProgressTimeMsInterval(fVar.D()).maxProgressCount(fVar.E()).mainThreadListener(fVar.i()).notificationListener(j).notificationEventListener(a(fVar.O())).force(z2).autoResumed(fVar.q()).showNotificationForAutoResumed(fVar.r()).chunkStategy(fVar.o()).chunkAdjustCalculator(fVar.p()).needHttpsToHttpRetry(fVar.m()).packageName(fVar.t()).md5(fVar.u()).expectFileLength(fVar.v()).needRetryDelay(fVar.y()).retryDelayTimeArray(fVar.z()).needDefaultHttpServiceBackUp(fVar.A()).needReuseFirstConnection(fVar.B()).needReuseChunkRunnable(fVar.F()).needIndependentProcess(fVar.G()).enqueueType(fVar.J()).monitorDepend(fVar.M()).retryDelayTimeCalculator(fVar.C()).headConnectionAvailable(fVar.H()).fileUriProvider(fVar.P()).diskSpaceHandler(fVar.ac()).needChunkDowngradeRetry(fVar.I()).notificationClickCallback(fVar.Q()).downloadSetting(fVar.ad()).iconUrl(fVar.aa()).needSDKMonitor(fVar.V()).monitorScene(fVar.W()).extraMonitorStatus(fVar.X()).executorGroup(fVar.T()).throttleNetSpeed(fVar.U()).distinctDirectory(fVar.Y()).setAutoInstall(fVar.Z());
                        if (autoInstall != null) {
                        }
                        if (autoInstall != null) {
                        }
                        return i2;
                    }
                    z3 = true;
                    if (!z3) {
                    }
                    i2 = i;
                    autoInstall = com.ss.android.socialbase.downloader.downloader.b.with(fVar.getContext()).url(a3).backUpUrls(fVar.ab()).name(L).title(b2).savePath(str).onlyWifi(fVar.h()).extraHeaders(a2).depend(N).retryCount(fVar.w()).backUpUrlRetryCount(fVar.x()).showNotification(z3).extra(jSONObject22).mimeType(l).minProgressTimeMsInterval(fVar.D()).maxProgressCount(fVar.E()).mainThreadListener(fVar.i()).notificationListener(j).notificationEventListener(a(fVar.O())).force(z2).autoResumed(fVar.q()).showNotificationForAutoResumed(fVar.r()).chunkStategy(fVar.o()).chunkAdjustCalculator(fVar.p()).needHttpsToHttpRetry(fVar.m()).packageName(fVar.t()).md5(fVar.u()).expectFileLength(fVar.v()).needRetryDelay(fVar.y()).retryDelayTimeArray(fVar.z()).needDefaultHttpServiceBackUp(fVar.A()).needReuseFirstConnection(fVar.B()).needReuseChunkRunnable(fVar.F()).needIndependentProcess(fVar.G()).enqueueType(fVar.J()).monitorDepend(fVar.M()).retryDelayTimeCalculator(fVar.C()).headConnectionAvailable(fVar.H()).fileUriProvider(fVar.P()).diskSpaceHandler(fVar.ac()).needChunkDowngradeRetry(fVar.I()).notificationClickCallback(fVar.Q()).downloadSetting(fVar.ad()).iconUrl(fVar.aa()).needSDKMonitor(fVar.V()).monitorScene(fVar.W()).extraMonitorStatus(fVar.X()).executorGroup(fVar.T()).throttleNetSpeed(fVar.U()).distinctDirectory(fVar.Y()).setAutoInstall(fVar.Z());
                    if (autoInstall != null) {
                    }
                    if (autoInstall != null) {
                    }
                    return i2;
                }
                return 0;
            } catch (Throwable th) {
                com.ss.android.socialbase.downloader.d.a.a(fVar.M(), (DownloadInfo) null, new BaseException(1003, com.ss.android.socialbase.downloader.i.f.b(th, "addDownloadTask")), 0);
                com.ss.android.socialbase.downloader.c.a.e(a, String.format("add download task error:%s", th));
                return 0;
            }
        }
        return 0;
    }

    public DownloadInfo a(Context context, String str) {
        if (!TextUtils.isEmpty(str) && context != null) {
            try {
                DownloadInfo a2 = a(context, str, h());
                if (a2 == null) {
                    a2 = a(context, str, context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS));
                }
                if (a2 == null) {
                    a2 = a(context, str, Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS));
                }
                if (a2 == null) {
                    a2 = a(context, str, context.getFilesDir());
                }
                boolean a3 = com.ss.android.socialbase.downloader.g.a.c().a("get_download_info_by_list");
                if (a2 == null && a3) {
                    return b(context, str);
                }
                return a2;
            } catch (Throwable th) {
                com.ss.android.socialbase.downloader.c.a.b(a, String.format("getAppDownloadInfo error:%s", th.getMessage()));
            }
        }
        return null;
    }

    public String a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && str.endsWith(Constant.FILE.SUFFIX.BUNDLE_SUFFIX) && !c.c(str2)) {
            return "application/vnd.android.package-archive";
        }
        return str2;
    }

    public List<DownloadInfo> a(Context context) {
        return Downloader.getInstance(context).getUnCompletedDownloadInfosWithMimeType("application/vnd.android.package-archive");
    }

    public void a(Context context, int i, int i2) {
        try {
            switch (i2) {
                case -4:
                case -1:
                    Downloader.getInstance(context).restart(i);
                    break;
                case -3:
                    c.a(context, i, true);
                    break;
                case -2:
                    Downloader.getInstance(context).resume(i);
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
                    Downloader.getInstance(context).pause(i);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Deprecated
    public void a(Context context, String str, com.ss.android.socialbase.appdownloader.c.c cVar, com.ss.android.socialbase.appdownloader.c.d dVar, com.ss.android.socialbase.appdownloader.c.h hVar) {
        if (cVar != null) {
            this.i = cVar;
        }
        if (dVar != null) {
            this.j = dVar;
        }
        if (hVar != null) {
            this.k = hVar;
        }
        c(context);
    }

    public void a(com.ss.android.socialbase.appdownloader.c.g gVar) {
        this.l = gVar;
    }

    public void a(j jVar) {
        this.o = jVar;
    }

    public void a(ad adVar) {
        this.p = adVar;
    }

    public void a(ag agVar) {
        this.q = agVar;
    }

    public void a(com.ss.android.socialbase.downloader.downloader.r rVar) {
        Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.c.N()).setReserveWifiStatusListener(rVar);
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.d = str;
    }
}
