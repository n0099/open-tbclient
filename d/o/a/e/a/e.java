package d.o.a.e.a;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
import com.baidu.tieba.service.AsInstallService;
import com.ss.android.socialbase.appdownloader.DownloadReceiver;
import com.ss.android.socialbase.appdownloader.RetryJobSchedulerService;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.o.a.e.a.c;
import d.o.a.e.a.d;
import d.o.a.e.b.f.h;
import d.o.a.e.b.f.p;
import d.o.a.e.b.m.q;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class e {
    public static final String l = "e";
    public static volatile e m = null;
    public static boolean n = false;
    public static boolean o = false;

    /* renamed from: a  reason: collision with root package name */
    public d.e f67051a;

    /* renamed from: b  reason: collision with root package name */
    public d.f f67052b;

    /* renamed from: c  reason: collision with root package name */
    public d.j f67053c;

    /* renamed from: d  reason: collision with root package name */
    public d.i f67054d;

    /* renamed from: e  reason: collision with root package name */
    public d.o f67055e;

    /* renamed from: f  reason: collision with root package name */
    public String f67056f;

    /* renamed from: g  reason: collision with root package name */
    public String f67057g;

    /* renamed from: h  reason: collision with root package name */
    public DownloadReceiver f67058h;

    /* renamed from: i  reason: collision with root package name */
    public d.h f67059i;
    public d.l j;
    public h k;

    /* loaded from: classes7.dex */
    public class a implements q.e {
        public a(e eVar) {
        }

        @Override // d.o.a.e.b.m.q.e
        public void a(DownloadInfo downloadInfo, long j, boolean z, int i2) {
            RetryJobSchedulerService.a(downloadInfo, j, z, i2);
        }
    }

    /* loaded from: classes7.dex */
    public class b implements d.o.a.e.b.f.q {
        public b() {
        }

        @Override // d.o.a.e.b.f.q
        public void a(DownloadInfo downloadInfo, BaseException baseException, int i2) {
            if (e.this.f67053c != null) {
                e.this.f67053c.a(downloadInfo, baseException, i2);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements d.p {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f67061a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.o.a.e.b.n.a f67062b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f67063c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ boolean f67064d;

        public c(String str, d.o.a.e.b.n.a aVar, int i2, boolean z) {
            this.f67061a = str;
            this.f67062b = aVar;
            this.f67063c = i2;
            this.f67064d = z;
        }

        @Override // d.o.a.e.a.d.p
        public void a() {
            String str = e.l;
            d.o.a.e.b.c.a.g(str, "notification permission granted, start download :" + this.f67061a);
            e.this.q(this.f67062b, this.f67063c, this.f67064d);
        }

        @Override // d.o.a.e.a.d.p
        public void b() {
            String str = e.l;
            d.o.a.e.b.c.a.g(str, "notification permission denied, start download :" + this.f67061a);
            e.this.q(this.f67062b, this.f67063c, this.f67064d);
        }
    }

    /* loaded from: classes7.dex */
    public class f implements d.o.a.e.b.g.l {

        /* renamed from: a  reason: collision with root package name */
        public List<Integer> f67069a;

        /* renamed from: b  reason: collision with root package name */
        public BroadcastReceiver f67070b;

        /* loaded from: classes7.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ List f67071e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f67072f;

            public a(List list, int i2) {
                this.f67071e = list;
                this.f67072f = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    f.this.i(this.f67071e, this.f67072f);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }

        /* loaded from: classes7.dex */
        public class b extends BroadcastReceiver {

            /* loaded from: classes7.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Context f67075e;

                public a(Context context) {
                    this.f67075e = context;
                }

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (f.this.f67069a != null && !f.this.f67069a.isEmpty()) {
                            int size = f.this.f67069a.size();
                            Integer[] numArr = new Integer[size];
                            f.this.f67069a.toArray(numArr);
                            f.this.f67069a.clear();
                            for (int i2 = 0; i2 < size; i2++) {
                                DownloadInfo f2 = d.o.a.e.b.g.a.l(this.f67075e).f(numArr[i2].intValue());
                                if (f2 != null && (f2.z0() == -5 || (f2.z0() == -2 && f2.L1()))) {
                                    f.this.c(this.f67075e, f2, true, 2);
                                }
                            }
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }

            public b() {
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                Context applicationContext = context.getApplicationContext();
                if (d.o.a.e.b.l.e.d0(applicationContext)) {
                    d.o.a.e.b.c.a.g("LaunchResume", "onReceive : wifi connected !!!");
                    d.o.a.e.b.g.d.w0().execute(new a(applicationContext));
                    try {
                        applicationContext.unregisterReceiver(f.this.f67070b);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    f.this.f67070b = null;
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:100:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:102:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:27:0x008b  */
        /* JADX WARN: Removed duplicated region for block: B:55:0x013a  */
        /* JADX WARN: Removed duplicated region for block: B:74:0x01bf  */
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
            d.i H;
            if (downloadInfo == null || !downloadInfo.Q1()) {
                return;
            }
            int z0 = downloadInfo.z0();
            if (z0 == -5 && ("application/ttpatch".equalsIgnoreCase(downloadInfo.m0()) || !downloadInfo.o1())) {
                d.o.a.e.b.j.a d2 = d.o.a.e.b.j.a.d(downloadInfo.c0());
                int b2 = d2.b("failed_resume_max_count", 0);
                double a2 = d2.a("failed_resume_max_hours", 72.0d);
                double a3 = d2.a("failed_resume_min_hours", 12.0d);
                long currentTimeMillis = System.currentTimeMillis();
                if (downloadInfo.V() < b2) {
                    str2 = ", canShowNotification = ";
                    str3 = "LaunchResume";
                    if (currentTimeMillis - downloadInfo.e0() < a2 * 3600000.0d && currentTimeMillis - downloadInfo.f0() > a3 * 3600000.0d) {
                        z3 = true;
                        if (downloadInfo.L1() && z) {
                            z3 = true;
                        }
                        if (z3) {
                            boolean z5 = d2.b("failed_resume_need_wifi", 1) == 1;
                            boolean z6 = d2.b("failed_resume_need_wait_wifi", 0) == 1;
                            if (!z && z5 && z6) {
                                if (this.f67069a == null) {
                                    this.f67069a = new ArrayList();
                                }
                                int c0 = downloadInfo.c0();
                                if (!this.f67069a.contains(Integer.valueOf(c0))) {
                                    this.f67069a.add(Integer.valueOf(c0));
                                }
                                downloadInfo.Q2(true);
                                q.d().k(downloadInfo);
                            } else {
                                z4 = true;
                                d.o.a.e.a.d.s(downloadInfo, true, z5);
                                downloadInfo.G2(currentTimeMillis);
                                downloadInfo.r2(downloadInfo.V() + 1);
                                downloadInfo.s3();
                                if (downloadInfo.L1() && z) {
                                    downloadInfo.p2(true);
                                    d.o.a.e.b.g.q I = e.F().I();
                                    if (I != null) {
                                        I.a(downloadInfo, 5, i2);
                                    }
                                }
                                d.o.a.e.b.c.a.h(str3, "launchResume, name = " + downloadInfo.P0() + str2 + z3 + ", downloadResumed = " + z4);
                                H = e.F().H();
                                if (H != null) {
                                    H.a(downloadInfo, z4);
                                    return;
                                }
                                return;
                            }
                        }
                        z4 = false;
                        d.o.a.e.b.c.a.h(str3, "launchResume, name = " + downloadInfo.P0() + str2 + z3 + ", downloadResumed = " + z4);
                        H = e.F().H();
                        if (H != null) {
                        }
                    }
                } else {
                    str2 = ", canShowNotification = ";
                    str3 = "LaunchResume";
                }
                z3 = false;
                if (downloadInfo.L1()) {
                    z3 = true;
                }
                if (z3) {
                }
                z4 = false;
                d.o.a.e.b.c.a.h(str3, "launchResume, name = " + downloadInfo.P0() + str2 + z3 + ", downloadResumed = " + z4);
                H = e.F().H();
                if (H != null) {
                }
            } else if (z0 != -3 || !g(downloadInfo)) {
                if (z0 == -2) {
                    if (!downloadInfo.L1()) {
                        f(downloadInfo, context);
                    } else if (z) {
                        d.o.a.e.a.d.s(downloadInfo, true, true);
                        downloadInfo.s3();
                        downloadInfo.p2(true);
                        d.i H2 = e.F().H();
                        if (H2 != null) {
                            H2.a(downloadInfo, true);
                        }
                        d.o.a.e.b.g.q I2 = e.F().I();
                        if (I2 != null) {
                            I2.a(downloadInfo, 5, i2);
                        }
                    } else {
                        if (this.f67069a == null) {
                            this.f67069a = new ArrayList();
                        }
                        int c02 = downloadInfo.c0();
                        if (!this.f67069a.contains(Integer.valueOf(c02))) {
                            this.f67069a.add(Integer.valueOf(c02));
                        }
                        q.d().k(downloadInfo);
                        f(downloadInfo, context);
                    }
                }
            } else {
                d.o.a.e.b.j.a d3 = d.o.a.e.b.j.a.d(downloadInfo.c0());
                if (d.o.a.e.a.d.v(context, downloadInfo)) {
                    return;
                }
                int b3 = d3.b("uninstall_resume_max_count", 0);
                double a4 = d3.a("uninstall_resume_max_hours", 72.0d);
                double a5 = d3.a("uninstall_resume_min_hours", 12.0d);
                long currentTimeMillis2 = System.currentTimeMillis();
                if (downloadInfo.S0() < b3) {
                    str = "LaunchResume";
                    if (currentTimeMillis2 - downloadInfo.e0() < a4 * 3600000.0d && currentTimeMillis2 - downloadInfo.h0() > a5 * 3600000.0d) {
                        z2 = true;
                        d.o.a.e.b.c.a.h(str, "uninstallResume, name = " + downloadInfo.P0() + ", canShowNotification = " + z2);
                        if (z2) {
                            return;
                        }
                        d.o.a.e.b.p.a l = d.o.a.e.b.p.b.a().l(downloadInfo.c0());
                        if (l == null) {
                            i3 = 1;
                            d.o.a.e.a.f.a aVar = new d.o.a.e.a.f.a(context, downloadInfo.c0(), downloadInfo.P0(), downloadInfo.F0(), downloadInfo.q0(), downloadInfo.R());
                            d.o.a.e.b.p.b.a().e(aVar);
                            l = aVar;
                        } else {
                            i3 = 1;
                            l.h(downloadInfo);
                        }
                        l.k(downloadInfo.Q0());
                        l.d(downloadInfo.Q0());
                        l.c(downloadInfo.H0(), null, false, false);
                        downloadInfo.J2(currentTimeMillis2);
                        downloadInfo.h3(downloadInfo.S0() + i3);
                        downloadInfo.s3();
                        return;
                    }
                } else {
                    str = "LaunchResume";
                }
                z2 = false;
                d.o.a.e.b.c.a.h(str, "uninstallResume, name = " + downloadInfo.P0() + ", canShowNotification = " + z2);
                if (z2) {
                }
            }
        }

        public final void f(DownloadInfo downloadInfo, Context context) {
            d.o.a.e.b.j.a d2 = d.o.a.e.b.j.a.d(downloadInfo.c0());
            int b2 = d2.b("paused_resume_max_count", 0);
            double a2 = d2.a("paused_resume_max_hours", 72.0d);
            int w0 = downloadInfo.w0();
            if (w0 < b2 && ((double) (System.currentTimeMillis() - downloadInfo.e0())) < a2 * 3600000.0d) {
                d.o.a.e.b.p.a l = d.o.a.e.b.p.b.a().l(downloadInfo.c0());
                if (l == null) {
                    l = new d.o.a.e.a.f.a(context, downloadInfo.c0(), downloadInfo.P0(), downloadInfo.F0(), downloadInfo.q0(), downloadInfo.R());
                    d.o.a.e.b.p.b.a().e(l);
                } else {
                    l.h(downloadInfo);
                }
                l.k(downloadInfo.Q0());
                l.d(downloadInfo.E());
                l.c(downloadInfo.H0(), null, false, false);
                downloadInfo.T2(w0 + 1);
                downloadInfo.s3();
            }
        }

        public final boolean g(DownloadInfo downloadInfo) {
            if (d.o.a.e.b.j.a.d(downloadInfo.c0()).q("uninstall_can_not_resume_for_force_task", false)) {
                return d.o.a.e.b.l.e.K(downloadInfo, false, downloadInfo.l0());
            }
            return downloadInfo.o1();
        }

        public final void i(List<DownloadInfo> list, int i2) {
            if (list == null || list.isEmpty()) {
                return;
            }
            d.i H = e.F().H();
            if (H != null) {
                H.a(list);
            }
            Context l = d.o.a.e.b.g.d.l();
            if (l == null) {
                return;
            }
            boolean d0 = d.o.a.e.b.l.e.d0(l);
            for (DownloadInfo downloadInfo : list) {
                c(l, downloadInfo, d0, i2);
            }
            List<Integer> list2 = this.f67069a;
            if (list2 == null || list2.isEmpty() || this.f67070b != null) {
                return;
            }
            this.f67070b = new b();
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                l.registerReceiver(this.f67070b, intentFilter);
            } catch (Throwable th) {
                th.printStackTrace();
                this.f67070b = null;
            }
        }

        @Override // d.o.a.e.b.g.l
        public List<String> a() {
            return d.o.a.e.a.d.M();
        }

        @Override // d.o.a.e.b.g.l
        public void a(List<DownloadInfo> list, int i2) {
            if (d.o.a.e.b.l.e.y0()) {
                d.o.a.e.b.g.d.w0().execute(new a(list, i2));
            } else {
                i(list, i2);
            }
        }
    }

    public static e F() {
        if (m == null) {
            synchronized (e.class) {
                if (m == null) {
                    m = new e();
                }
            }
        }
        return m;
    }

    public static boolean s(Context context, int i2) {
        return d.o.a.e.a.d.d(context, i2, true) == 1;
    }

    public d.h A() {
        return this.f67059i;
    }

    public boolean B() {
        return d.o.a.e.b.j.a.o().optInt("package_flag_config", 1) == 1;
    }

    public d.l C() {
        return this.j;
    }

    public File D() {
        return d.o.a.e.b.g.a.l(d.o.a.e.b.g.d.l()).k();
    }

    public String E() {
        return this.f67056f;
    }

    public d.o G() {
        return this.f67055e;
    }

    public d.i H() {
        return this.f67054d;
    }

    public d.o.a.e.b.g.q I() {
        return d.o.a.e.b.g.a.l(d.o.a.e.b.g.d.l()).m();
    }

    public h J() {
        return this.k;
    }

    public final void L() {
        if (o) {
            return;
        }
        if (this.f67058h == null) {
            this.f67058h = new DownloadReceiver();
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
            d.o.a.e.b.g.d.l().registerReceiver(this.f67058h, intentFilter);
            d.o.a.e.b.g.d.l().registerReceiver(this.f67058h, intentFilter2);
            d.o.a.e.b.g.d.l().registerReceiver(this.f67058h, intentFilter3);
            o = true;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void M() {
        if (Build.VERSION.SDK_INT >= 21) {
            q.h(new a(this));
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(25:36|(2:40|41)|44|(1:113)(1:50)|51|(2:57|(1:59)(19:60|61|(1:63)|64|(3:68|(2:71|69)|72)|73|74|75|(1:77)(1:110)|78|79|(6:84|(1:107)(1:88)|89|(1:93)|(1:(1:105)(1:104))|106)|108|(1:86)|107|89|(2:91|93)|(0)|106))|112|61|(0)|64|(4:66|68|(1:69)|72)|73|74|75|(0)(0)|78|79|(8:81|84|(0)|107|89|(0)|(0)|106)|108|(0)|107|89|(0)|(0)|106) */
    /* JADX WARN: Removed duplicated region for block: B:62:0x012c A[Catch: all -> 0x0348, TryCatch #2 {all -> 0x0348, blocks: (B:7:0x000f, B:10:0x0022, B:14:0x002b, B:16:0x0039, B:17:0x0041, B:19:0x0049, B:20:0x0052, B:23:0x0059, B:25:0x0065, B:28:0x0071, B:30:0x007f, B:31:0x0083, B:33:0x008a, B:36:0x0092, B:38:0x00a6, B:41:0x00c0, B:43:0x00cd, B:45:0x00d3, B:49:0x00e4, B:51:0x00ea, B:53:0x00f0, B:55:0x00f6, B:57:0x00fc, B:59:0x010b, B:60:0x0126, B:62:0x012c, B:63:0x0131, B:65:0x013b, B:67:0x0145, B:68:0x0149, B:70:0x014f, B:71:0x0159, B:77:0x0184, B:79:0x018a, B:85:0x0196, B:87:0x01a3, B:89:0x01b3, B:91:0x02e7, B:93:0x02f1, B:96:0x02fc, B:98:0x0302, B:100:0x0308, B:102:0x0312, B:104:0x0318, B:105:0x0329), top: B:120:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x014f A[Catch: all -> 0x0348, LOOP:0: B:68:0x0149->B:70:0x014f, LOOP_END, TryCatch #2 {all -> 0x0348, blocks: (B:7:0x000f, B:10:0x0022, B:14:0x002b, B:16:0x0039, B:17:0x0041, B:19:0x0049, B:20:0x0052, B:23:0x0059, B:25:0x0065, B:28:0x0071, B:30:0x007f, B:31:0x0083, B:33:0x008a, B:36:0x0092, B:38:0x00a6, B:41:0x00c0, B:43:0x00cd, B:45:0x00d3, B:49:0x00e4, B:51:0x00ea, B:53:0x00f0, B:55:0x00f6, B:57:0x00fc, B:59:0x010b, B:60:0x0126, B:62:0x012c, B:63:0x0131, B:65:0x013b, B:67:0x0145, B:68:0x0149, B:70:0x014f, B:71:0x0159, B:77:0x0184, B:79:0x018a, B:85:0x0196, B:87:0x01a3, B:89:0x01b3, B:91:0x02e7, B:93:0x02f1, B:96:0x02fc, B:98:0x0302, B:100:0x0308, B:102:0x0312, B:104:0x0318, B:105:0x0329), top: B:120:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0163 A[Catch: all -> 0x0184, TryCatch #1 {all -> 0x0184, blocks: (B:72:0x015d, B:74:0x0163, B:76:0x016e, B:75:0x0169), top: B:118:0x015d }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0169 A[Catch: all -> 0x0184, TryCatch #1 {all -> 0x0184, blocks: (B:72:0x015d, B:74:0x0163, B:76:0x016e, B:75:0x0169), top: B:118:0x015d }] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0196 A[Catch: all -> 0x0348, TryCatch #2 {all -> 0x0348, blocks: (B:7:0x000f, B:10:0x0022, B:14:0x002b, B:16:0x0039, B:17:0x0041, B:19:0x0049, B:20:0x0052, B:23:0x0059, B:25:0x0065, B:28:0x0071, B:30:0x007f, B:31:0x0083, B:33:0x008a, B:36:0x0092, B:38:0x00a6, B:41:0x00c0, B:43:0x00cd, B:45:0x00d3, B:49:0x00e4, B:51:0x00ea, B:53:0x00f0, B:55:0x00f6, B:57:0x00fc, B:59:0x010b, B:60:0x0126, B:62:0x012c, B:63:0x0131, B:65:0x013b, B:67:0x0145, B:68:0x0149, B:70:0x014f, B:71:0x0159, B:77:0x0184, B:79:0x018a, B:85:0x0196, B:87:0x01a3, B:89:0x01b3, B:91:0x02e7, B:93:0x02f1, B:96:0x02fc, B:98:0x0302, B:100:0x0308, B:102:0x0312, B:104:0x0318, B:105:0x0329), top: B:120:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x02e7 A[Catch: all -> 0x0348, TryCatch #2 {all -> 0x0348, blocks: (B:7:0x000f, B:10:0x0022, B:14:0x002b, B:16:0x0039, B:17:0x0041, B:19:0x0049, B:20:0x0052, B:23:0x0059, B:25:0x0065, B:28:0x0071, B:30:0x007f, B:31:0x0083, B:33:0x008a, B:36:0x0092, B:38:0x00a6, B:41:0x00c0, B:43:0x00cd, B:45:0x00d3, B:49:0x00e4, B:51:0x00ea, B:53:0x00f0, B:55:0x00f6, B:57:0x00fc, B:59:0x010b, B:60:0x0126, B:62:0x012c, B:63:0x0131, B:65:0x013b, B:67:0x0145, B:68:0x0149, B:70:0x014f, B:71:0x0159, B:77:0x0184, B:79:0x018a, B:85:0x0196, B:87:0x01a3, B:89:0x01b3, B:91:0x02e7, B:93:0x02f1, B:96:0x02fc, B:98:0x0302, B:100:0x0308, B:102:0x0312, B:104:0x0318, B:105:0x0329), top: B:120:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x02fa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int a(i iVar) {
        boolean z;
        int i2;
        String str;
        d.o.a.e.b.f.q p;
        List<p> a2;
        String E0;
        boolean z2;
        int i3;
        d.o.a.e.b.n.a H;
        JSONObject jSONObject;
        DownloadInfo f2;
        if (iVar == null || iVar.S() == null) {
            return 0;
        }
        try {
            List<com.ss.android.socialbase.downloader.model.c> i4 = i(iVar.m0());
            String a0 = iVar.a0();
            if (TextUtils.isEmpty(a0)) {
                return 0;
            }
            int N0 = iVar.N0();
            boolean z3 = N0 == 0;
            String n2 = iVar.n();
            String e0 = iVar.e0();
            if (TextUtils.isEmpty(n2)) {
                n2 = d.o.a.e.a.d.p(a0, e0, iVar.G0(), z3);
            }
            if (n2.length() > 255) {
                n2 = n2.substring(n2.length() - 255);
            }
            if (TextUtils.isEmpty(e0)) {
                e0 = n2;
            }
            String G0 = iVar.G0();
            if (n2.endsWith(".apk") && !d.o.a.e.a.d.O(iVar.G0())) {
                G0 = "application/vnd.android.package-archive";
            }
            String i0 = iVar.i0();
            if (TextUtils.isEmpty(iVar.i0())) {
                i0 = d.o.a.e.a.d.F();
            }
            String str2 = i0;
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(n2)) {
                int s = d.o.a.e.b.g.d.s(a0, str2);
                if (d.o.a.e.b.j.a.g(iVar.R()).l("resume_task_override_settings") && (f2 = d.o.a.e.b.g.a.l(d.o.a.e.b.g.d.l()).f(s)) != null) {
                    try {
                        iVar.L(new JSONObject(f2.K()));
                    } catch (Throwable unused) {
                    }
                }
                d.o.a.e.b.j.a.j(s, iVar.R());
                boolean m2 = iVar.m();
                boolean z4 = (!m2 && d.o.a.e.b.l.e.A0(str2, n2) && d.o.a.e.b.g.a.l(iVar.S()).f(s) == null) ? true : m2;
                d.o.a.e.a.f.b C0 = iVar.C0();
                if (C0 == null && (iVar.p0() || iVar.s0())) {
                    if (iVar.I0() != null) {
                        C0 = new d.o.a.e.a.f.b(iVar.I0());
                    } else {
                        z = z4;
                        i2 = s;
                        str = str2;
                        C0 = new d.o.a.e.a.f.b(iVar.S(), s, e0, str, n2, iVar.E0());
                        p = iVar.p();
                        if (p == null) {
                            p = new b();
                        }
                        a2 = d.o.a.e.b.g.d.a();
                        if (!a2.isEmpty() && iVar.t().isEmpty()) {
                            for (p pVar : a2) {
                                iVar.E(pVar);
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
                            z2 = false;
                            if (z2 || d.o.a.e.b.j.a.d(i2).m("enable_notification_ui") < 1) {
                                i3 = i2;
                            } else {
                                i3 = i2;
                                com.ss.android.socialbase.appdownloader.e.c.d().e(i3, iVar.O());
                            }
                            H = d.o.a.e.b.g.a.H(iVar.S());
                            H.K0(a0);
                            H.h(iVar.P());
                            H.f0(n2);
                            H.J0(e0);
                            H.z0(str);
                            H.s0(iVar.y0());
                            H.v(i4);
                            H.n(p);
                            H.w0(iVar.R0());
                            H.g(iVar.S0());
                            H.F0(z2);
                            H.u(jSONObject2);
                            H.b0(G0);
                            H.c0(iVar.f());
                            H.Z(iVar.g());
                            H.X(iVar.A0());
                            H.q0(C0);
                            H.p0(d(iVar.q()));
                            H.z(z);
                            H.f(iVar.L0());
                            H.G0(iVar.M0());
                            H.k(iVar.J0());
                            H.j(iVar.K0());
                            H.i0(iVar.H0());
                            H.t0(iVar.O0());
                            H.a0(iVar.P0());
                            H.t(iVar.Q0());
                            H.k0(iVar.a());
                            H.x0(iVar.b());
                            H.h0(iVar.c());
                            H.m0(iVar.d());
                            H.l0(iVar.h());
                            H.j0(iVar.i());
                            H.r(iVar.l());
                            H.d0(iVar.o());
                            H.y0(iVar.e());
                            H.T(iVar.j());
                            H.x(iVar.r());
                            H.o(iVar.Q());
                            H.g0(iVar.k());
                            H.o0(iVar.s());
                            H.q(iVar.R());
                            H.U(iVar.O());
                            H.n0(iVar.x());
                            H.e0(iVar.y());
                            H.w(iVar.z());
                            H.s(iVar.v());
                            H.I0(iVar.w());
                            if (H != null && !iVar.t().isEmpty()) {
                                H.B0(iVar.t());
                            }
                            if (H != null) {
                                if (z2 && iVar.u() && iVar.A() != null && !iVar.A().isFinishing() && !d.o.a.e.a.f.c.d()) {
                                    d.o.a.e.a.f.c.b(iVar.A(), new c(e0, H, N0, z3));
                                } else {
                                    String str3 = l;
                                    d.o.a.e.b.c.a.g(str3, "notification permission need not request, start download :" + e0);
                                    q(H, N0, z3);
                                    H.H();
                                }
                            }
                            return i3;
                        }
                        z2 = true;
                        if (z2) {
                        }
                        i3 = i2;
                        H = d.o.a.e.b.g.a.H(iVar.S());
                        H.K0(a0);
                        H.h(iVar.P());
                        H.f0(n2);
                        H.J0(e0);
                        H.z0(str);
                        H.s0(iVar.y0());
                        H.v(i4);
                        H.n(p);
                        H.w0(iVar.R0());
                        H.g(iVar.S0());
                        H.F0(z2);
                        H.u(jSONObject2);
                        H.b0(G0);
                        H.c0(iVar.f());
                        H.Z(iVar.g());
                        H.X(iVar.A0());
                        H.q0(C0);
                        H.p0(d(iVar.q()));
                        H.z(z);
                        H.f(iVar.L0());
                        H.G0(iVar.M0());
                        H.k(iVar.J0());
                        H.j(iVar.K0());
                        H.i0(iVar.H0());
                        H.t0(iVar.O0());
                        H.a0(iVar.P0());
                        H.t(iVar.Q0());
                        H.k0(iVar.a());
                        H.x0(iVar.b());
                        H.h0(iVar.c());
                        H.m0(iVar.d());
                        H.l0(iVar.h());
                        H.j0(iVar.i());
                        H.r(iVar.l());
                        H.d0(iVar.o());
                        H.y0(iVar.e());
                        H.T(iVar.j());
                        H.x(iVar.r());
                        H.o(iVar.Q());
                        H.g0(iVar.k());
                        H.o0(iVar.s());
                        H.q(iVar.R());
                        H.U(iVar.O());
                        H.n0(iVar.x());
                        H.e0(iVar.y());
                        H.w(iVar.z());
                        H.s(iVar.v());
                        H.I0(iVar.w());
                        if (H != null) {
                            H.B0(iVar.t());
                        }
                        if (H != null) {
                        }
                        return i3;
                    }
                }
                z = z4;
                i2 = s;
                str = str2;
                p = iVar.p();
                if (p == null) {
                }
                a2 = d.o.a.e.b.g.d.a();
                if (!a2.isEmpty()) {
                    while (r13.hasNext()) {
                    }
                }
                E0 = iVar.E0();
                if (TextUtils.isEmpty(E0)) {
                }
                jSONObject.put("auto_install_with_notification", iVar.v0());
                jSONObject.put("auto_install_without_notification", iVar.s0());
                String jSONObject22 = jSONObject.toString();
                if (!iVar.p0()) {
                    z2 = false;
                    if (z2) {
                    }
                    i3 = i2;
                    H = d.o.a.e.b.g.a.H(iVar.S());
                    H.K0(a0);
                    H.h(iVar.P());
                    H.f0(n2);
                    H.J0(e0);
                    H.z0(str);
                    H.s0(iVar.y0());
                    H.v(i4);
                    H.n(p);
                    H.w0(iVar.R0());
                    H.g(iVar.S0());
                    H.F0(z2);
                    H.u(jSONObject22);
                    H.b0(G0);
                    H.c0(iVar.f());
                    H.Z(iVar.g());
                    H.X(iVar.A0());
                    H.q0(C0);
                    H.p0(d(iVar.q()));
                    H.z(z);
                    H.f(iVar.L0());
                    H.G0(iVar.M0());
                    H.k(iVar.J0());
                    H.j(iVar.K0());
                    H.i0(iVar.H0());
                    H.t0(iVar.O0());
                    H.a0(iVar.P0());
                    H.t(iVar.Q0());
                    H.k0(iVar.a());
                    H.x0(iVar.b());
                    H.h0(iVar.c());
                    H.m0(iVar.d());
                    H.l0(iVar.h());
                    H.j0(iVar.i());
                    H.r(iVar.l());
                    H.d0(iVar.o());
                    H.y0(iVar.e());
                    H.T(iVar.j());
                    H.x(iVar.r());
                    H.o(iVar.Q());
                    H.g0(iVar.k());
                    H.o0(iVar.s());
                    H.q(iVar.R());
                    H.U(iVar.O());
                    H.n0(iVar.x());
                    H.e0(iVar.y());
                    H.w(iVar.z());
                    H.s(iVar.v());
                    H.I0(iVar.w());
                    if (H != null) {
                    }
                    if (H != null) {
                    }
                    return i3;
                }
                z2 = true;
                if (z2) {
                }
                i3 = i2;
                H = d.o.a.e.b.g.a.H(iVar.S());
                H.K0(a0);
                H.h(iVar.P());
                H.f0(n2);
                H.J0(e0);
                H.z0(str);
                H.s0(iVar.y0());
                H.v(i4);
                H.n(p);
                H.w0(iVar.R0());
                H.g(iVar.S0());
                H.F0(z2);
                H.u(jSONObject22);
                H.b0(G0);
                H.c0(iVar.f());
                H.Z(iVar.g());
                H.X(iVar.A0());
                H.q0(C0);
                H.p0(d(iVar.q()));
                H.z(z);
                H.f(iVar.L0());
                H.G0(iVar.M0());
                H.k(iVar.J0());
                H.j(iVar.K0());
                H.i0(iVar.H0());
                H.t0(iVar.O0());
                H.a0(iVar.P0());
                H.t(iVar.Q0());
                H.k0(iVar.a());
                H.x0(iVar.b());
                H.h0(iVar.c());
                H.m0(iVar.d());
                H.l0(iVar.h());
                H.j0(iVar.i());
                H.r(iVar.l());
                H.d0(iVar.o());
                H.y0(iVar.e());
                H.T(iVar.j());
                H.x(iVar.r());
                H.o(iVar.Q());
                H.g0(iVar.k());
                H.o0(iVar.s());
                H.q(iVar.R());
                H.U(iVar.O());
                H.n0(iVar.x());
                H.e0(iVar.y());
                H.w(iVar.z());
                H.s(iVar.v());
                H.I0(iVar.w());
                if (H != null) {
                }
                if (H != null) {
                }
                return i3;
            }
            return 0;
        } catch (Throwable th) {
            d.o.a.e.b.e.a.e(iVar.o(), null, new BaseException(1003, d.o.a.e.b.l.e.Y(th, "addDownloadTask")), 0);
            d.o.a.e.b.c.a.j(l, String.format("add download task error:%s", th));
            return 0;
        }
    }

    public d.e b() {
        return this.f67051a;
    }

    public final d.o.a.e.b.f.d d(d.g gVar) {
        if (gVar == null) {
            return null;
        }
        return new d(this, gVar);
    }

    public DownloadInfo e(Context context, String str) {
        if (!TextUtils.isEmpty(str) && context != null) {
            try {
                DownloadInfo f2 = f(context, str, D());
                if (f2 == null) {
                    f2 = f(context, str, context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS));
                }
                if (f2 == null) {
                    f2 = f(context, str, Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS));
                }
                if (f2 == null) {
                    f2 = f(context, str, context.getFilesDir());
                }
                return (f2 == null && d.o.a.e.b.j.a.r().l("get_download_info_by_list")) ? u(context, str) : f2;
            } catch (Throwable th) {
                d.o.a.e.b.c.a.g(l, String.format("getAppDownloadInfo error:%s", th.getMessage()));
            }
        }
        return null;
    }

    public final DownloadInfo f(Context context, String str, File file) {
        if (context == null || TextUtils.isEmpty(str) || file == null) {
            return null;
        }
        return d.o.a.e.b.g.a.l(context).g(str, file.getAbsolutePath());
    }

    public String g(String str, String str2) {
        return (TextUtils.isEmpty(str) || !str.endsWith(".apk") || d.o.a.e.a.d.O(str2)) ? str2 : "application/vnd.android.package-archive";
    }

    public List<DownloadInfo> h(Context context) {
        return d.o.a.e.b.g.a.l(context).p("application/vnd.android.package-archive");
    }

    public final List<com.ss.android.socialbase.downloader.model.c> i(List<com.ss.android.socialbase.downloader.model.c> list) {
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
            arrayList.add(new com.ss.android.socialbase.downloader.model.c("User-Agent", c.h.f67040a));
        }
        return arrayList;
    }

    public void j(Context context, int i2, int i3) {
        try {
            switch (i3) {
                case -4:
                case -1:
                    d.o.a.e.b.g.a.l(context).z(i2);
                    break;
                case -3:
                    d.o.a.e.a.d.d(context, i2, true);
                    break;
                case -2:
                    d.o.a.e.b.g.a.l(context).C(i2);
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
                    d.o.a.e.b.g.a.l(context).v(i2);
                    break;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Deprecated
    public void k(Context context, String str, d.e eVar, d.f fVar, d.j jVar) {
        if (eVar != null) {
            this.f67051a = eVar;
        }
        if (fVar != null) {
            this.f67052b = fVar;
        }
        if (jVar != null) {
            this.f67053c = jVar;
        }
        y(context);
    }

    public void l(d.i iVar) {
        this.f67054d = iVar;
    }

    public void m(d.l lVar) {
        this.j = lVar;
    }

    public void o(h hVar) {
        this.k = hVar;
    }

    public void p(d.o.a.e.b.g.q qVar) {
        d.o.a.e.b.g.a.l(d.o.a.e.b.g.d.l()).G(qVar);
    }

    public final void q(d.o.a.e.b.n.a aVar, int i2, boolean z) {
        if (aVar == null) {
            return;
        }
        aVar.p();
        DownloadInfo H = aVar.H();
        if (H != null) {
            H.d2(i2);
        }
        if (H == null || !z) {
            return;
        }
        H.X2(z);
    }

    public void r(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f67057g = str;
    }

    public d.f t() {
        return this.f67052b;
    }

    public final DownloadInfo u(Context context, String str) {
        List<DownloadInfo> h2 = d.o.a.e.b.g.a.l(context).h(str);
        if (h2 != null) {
            for (DownloadInfo downloadInfo : h2) {
                if (downloadInfo != null && downloadInfo.O1()) {
                    return downloadInfo;
                }
            }
            return null;
        }
        return null;
    }

    public List<DownloadInfo> v(Context context) {
        return d.o.a.e.b.g.a.l(context).j("application/vnd.android.package-archive");
    }

    public void w(String str) {
        d.o.a.e.b.g.a.l(d.o.a.e.b.g.d.l()).D(str);
    }

    public d.j x() {
        return this.f67053c;
    }

    public final void y(Context context) {
        if (context == null || n) {
            return;
        }
        if (d.o.a.e.a.h.c.o()) {
            d.o.a.e.b.g.d.V(true);
        }
        d.o.a.e.b.d.c.a("application/vnd.android.package-archive");
        d.o.a.e.b.g.d.y(context);
        d.o.a.e.b.g.d.L(new f());
        L();
        M();
        n = true;
    }

    public String z() {
        return this.f67057g;
    }

    /* renamed from: d.o.a.e.a.e$e  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1883e extends d.AbstractC1882d {

        /* renamed from: a  reason: collision with root package name */
        public AlertDialog.Builder f67067a;

        /* renamed from: d.o.a.e.a.e$e$a */
        /* loaded from: classes7.dex */
        public static class a implements d.m {

            /* renamed from: a  reason: collision with root package name */
            public AlertDialog f67068a;

            public a(AlertDialog.Builder builder) {
                if (builder != null) {
                    this.f67068a = builder.show();
                }
            }

            @Override // d.o.a.e.a.d.m
            public void a() {
                AlertDialog alertDialog = this.f67068a;
                if (alertDialog != null) {
                    alertDialog.show();
                }
            }

            @Override // d.o.a.e.a.d.m
            public boolean b() {
                AlertDialog alertDialog = this.f67068a;
                if (alertDialog != null) {
                    return alertDialog.isShowing();
                }
                return false;
            }
        }

        public C1883e(Context context) {
            this.f67067a = new AlertDialog.Builder(context);
        }

        @Override // d.o.a.e.a.d.n
        public d.n a(int i2) {
            AlertDialog.Builder builder = this.f67067a;
            if (builder != null) {
                builder.setTitle(i2);
            }
            return this;
        }

        @Override // d.o.a.e.a.d.n
        public d.n b(int i2, DialogInterface.OnClickListener onClickListener) {
            AlertDialog.Builder builder = this.f67067a;
            if (builder != null) {
                builder.setPositiveButton(i2, onClickListener);
            }
            return this;
        }

        @Override // d.o.a.e.a.d.n
        public d.n c(DialogInterface.OnCancelListener onCancelListener) {
            AlertDialog.Builder builder = this.f67067a;
            if (builder != null) {
                builder.setOnCancelListener(onCancelListener);
            }
            return this;
        }

        @Override // d.o.a.e.a.d.n
        public d.n a(String str) {
            AlertDialog.Builder builder = this.f67067a;
            if (builder != null) {
                builder.setMessage(str);
            }
            return this;
        }

        @Override // d.o.a.e.a.d.n
        public d.n a(int i2, DialogInterface.OnClickListener onClickListener) {
            AlertDialog.Builder builder = this.f67067a;
            if (builder != null) {
                builder.setNegativeButton(i2, onClickListener);
            }
            return this;
        }

        @Override // d.o.a.e.a.d.n
        public d.m a() {
            return new a(this.f67067a);
        }
    }

    /* loaded from: classes7.dex */
    public class d implements d.o.a.e.b.f.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.g f67066a;

        public d(e eVar, d.g gVar) {
            this.f67066a = gVar;
        }

        @Override // d.o.a.e.b.f.d
        public void a(int i2, DownloadInfo downloadInfo, String str, String str2) {
            if (i2 != 1 && i2 != 3) {
                switch (i2) {
                    case 5:
                    case 6:
                    case 7:
                        break;
                    case 8:
                        this.f67066a.b(i2, downloadInfo.v0(), str, str2);
                        return;
                    case 9:
                        this.f67066a.a(d.o.a.e.b.g.d.l(), str);
                        return;
                    case 10:
                        this.f67066a.a(downloadInfo);
                        return;
                    default:
                        return;
                }
            }
            this.f67066a.a(i2, str, downloadInfo.H0(), downloadInfo.M());
        }

        @Override // d.o.a.e.b.f.d
        public boolean a(boolean z) {
            return this.f67066a.a(z);
        }

        @Override // d.o.a.e.b.f.d
        public String a() {
            return this.f67066a.a();
        }
    }
}
