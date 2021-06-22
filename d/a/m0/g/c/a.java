package d.a.m0.g.c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.down.manage.Download;
import com.baidu.down.manage.DownloadManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.gamecenter.appmanager.download.AppDownloadNetworkStateReceiver;
import com.baidu.swan.gamecenter.appmanager.install.InstallAntiBlockingActivity;
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
import com.baidu.tieba.service.AsInstallService;
import d.a.m0.a.k;
import d.a.m0.a.v2.k0;
import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f50742h = k.f46983a;

    /* renamed from: i  reason: collision with root package name */
    public static volatile a f50743i;

    /* renamed from: c  reason: collision with root package name */
    public DownloadManager f50746c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.m0.g.c.d.c f50747d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f50748e;

    /* renamed from: f  reason: collision with root package name */
    public AppDownloadNetworkStateReceiver f50749f;

    /* renamed from: a  reason: collision with root package name */
    public d.a.m0.g.c.b f50744a = new d.a.m0.g.c.b();

    /* renamed from: b  reason: collision with root package name */
    public d.a.m0.g.c.b f50745b = new d.a.m0.g.c.b();

    /* renamed from: g  reason: collision with root package name */
    public long f50750g = 0;

    /* renamed from: d.a.m0.g.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1054a implements DownloadManager.OnProgressChangeListener {
        public C1054a(a aVar) {
        }

        @Override // com.baidu.down.manage.DownloadManager.OnProgressChangeListener
        public void onProgressChanged(long j, int i2, long j2) {
            if (k.f46983a) {
                Log.d("GameCenterAppManager", "onProgressChanged downloadId = " + j + ",percentage = " + i2 + ",speed = " + j2);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.a.m0.g.c.f.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f50751a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Download f50752b;

        public b(String str, Download download) {
            this.f50751a = str;
            this.f50752b = download;
        }

        @Override // d.a.m0.g.c.f.b
        public void b(d.a.m0.g.c.g.b bVar) {
            if (bVar != null) {
                if (bVar.d()) {
                    a.this.f50744a.b(this.f50751a, new d.a.m0.g.c.g.c(this.f50752b));
                } else {
                    a.this.f50744a.b(this.f50751a, bVar);
                }
            }
            a.this.C(this.f50751a);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f50754e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f50755f;

        public c(String str, String str2) {
            this.f50754e = str;
            this.f50755f = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.a.m0.a.g1.g.a().b()) {
                return;
            }
            if (a.f50742h) {
                Log.d("GameCenterAppManager", "start InstallAntiBlockingActivity");
            }
            Intent intent = new Intent(AppRuntime.getAppContext(), InstallAntiBlockingActivity.class);
            intent.putExtra("type", this.f50754e);
            intent.putExtra("packageName", this.f50755f);
            if (a.this.f50748e != null) {
                intent.putExtra("ubc_params", a.this.f50748e.toString());
            }
            intent.setFlags(276824064);
            d.a.m0.a.v2.f.g(AppRuntime.getAppContext(), intent);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements DownloadManager.OnStateChangeListener {

        /* renamed from: d.a.m0.g.c.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C1055a implements d.a.m0.g.c.f.b {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f50758a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Download f50759b;

            public C1055a(String str, Download download) {
                this.f50758a = str;
                this.f50759b = download;
            }

            @Override // d.a.m0.g.c.f.b
            public void b(d.a.m0.g.c.g.b bVar) {
                if (bVar != null) {
                    if (bVar.d()) {
                        a.this.f50744a.b(this.f50758a, new d.a.m0.g.c.g.c(this.f50759b));
                    } else {
                        a.this.f50744a.b(this.f50758a, bVar);
                    }
                }
                a.this.C(this.f50758a);
            }
        }

        public d() {
        }

        @Override // com.baidu.down.manage.DownloadManager.OnStateChangeListener
        public void onStateChanged(long j, Download download) {
            if (download == null || download.getId() == null) {
                return;
            }
            String valueOf = String.valueOf(download.getId());
            if (a.f50742h) {
                Log.d("GameCenterAppManager", "onStateChanged downloadId = " + j + ",eventType:" + valueOf + ",download = " + download);
            }
            if (download.getState() == Download.DownloadState.FINISH) {
                if (!d.a.m0.h.t.a.d().a(download)) {
                    d.a.m0.g.c.i.c.a(download.getKeyByUser(), "startDownload", "success", null, new d.a.m0.g.c.i.a(a.this.f50748e));
                    d.a.m0.g.c.i.c.d(2, download.getKeyByUser(), new d.a.m0.g.c.d.a(download).c(), download.getUrl());
                }
                d.a.m0.g.c.h.a.f().m(download, true, "downloadfinish");
            }
            if (a.this.f50744a.d(valueOf)) {
                int i2 = h.f50767a[download.getState().ordinal()];
                if (i2 == 1) {
                    a.this.f50747d.f();
                    d.a.m0.h.t.a.c().b(download.getUrl(), download.getFileName(), download.getRealDownloadDir(), String.valueOf(download.getTotalbytes()), String.valueOf(download.getCurrentbytes()));
                    new d.a.m0.g.c.e.c(download, a.this.f50748e).c(new C1055a(valueOf, download));
                    if (d.a.m0.h.t.a.d().a(download)) {
                        d.a.m0.h.t.a.d().b(download);
                    }
                } else if (i2 == 2) {
                    a.this.f50744a.b(valueOf, new d.a.m0.g.c.g.a(31015, "download is canceled"));
                    a.this.C(valueOf);
                } else if (i2 != 3) {
                } else {
                    a.this.f50744a.b(valueOf, new d.a.m0.g.c.g.a(download.getFailedType().intValue(), TextUtils.isEmpty(download.getFailedReason()) ? "download is failed" : download.getFailedReason()));
                    a.this.C(valueOf);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e extends BroadcastReceiver {
        public e() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null || intent.getData() == null) {
                return;
            }
            String schemeSpecificPart = intent.getData().getSchemeSpecificPart();
            if (TextUtils.isEmpty(schemeSpecificPart)) {
                return;
            }
            if (a.f50742h) {
                Log.d("GameCenterAppManager", "AddPackageReceiver packageName = " + schemeSpecificPart);
            }
            Download o = a.this.f50747d.o(schemeSpecificPart);
            if (!d.a.m0.h.t.a.d().a(o)) {
                a.this.p(schemeSpecificPart);
            } else {
                d.a.m0.h.t.a.d().c(o);
            }
            a.this.t(schemeSpecificPart);
            a.this.f50745b.b(schemeSpecificPart, new d.a.m0.g.c.g.c((String) null));
            a.this.B(schemeSpecificPart, null);
        }
    }

    /* loaded from: classes3.dex */
    public class f implements d.a.m0.g.c.f.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Download f50761a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f50762b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f50763c;

        public f(Download download, String str, String str2) {
            this.f50761a = download;
            this.f50762b = str;
            this.f50763c = str2;
        }

        @Override // d.a.m0.g.c.f.b
        public void b(d.a.m0.g.c.g.b bVar) {
            String valueOf = String.valueOf(this.f50761a.getId());
            if (bVar != null) {
                if (!bVar.d()) {
                    a.this.f50744a.b(valueOf, bVar);
                } else {
                    if (!TextUtils.isEmpty(this.f50762b)) {
                        d.a.m0.g.c.i.c.c("installSuccess", this.f50762b, this.f50763c);
                    }
                    a.this.f50744a.b(valueOf, new d.a.m0.g.c.g.c(this.f50761a));
                }
            }
            a.this.C(valueOf);
        }
    }

    /* loaded from: classes3.dex */
    public class g implements d.a.m0.g.c.f.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Download f50765a;

        public g(Download download) {
            this.f50765a = download;
        }

        @Override // d.a.m0.g.c.f.b
        public void b(d.a.m0.g.c.g.b bVar) {
            String valueOf = String.valueOf(this.f50765a.getId());
            if (bVar != null) {
                if (bVar.d()) {
                    a.this.f50744a.b(valueOf, new d.a.m0.g.c.g.c(this.f50765a));
                } else {
                    a.this.f50744a.b(valueOf, bVar);
                }
            }
            a.this.C(valueOf);
        }
    }

    /* loaded from: classes3.dex */
    public static /* synthetic */ class h {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f50767a;

        static {
            int[] iArr = new int[Download.DownloadState.values().length];
            f50767a = iArr;
            try {
                iArr[Download.DownloadState.FINISH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f50767a[Download.DownloadState.CANCEL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f50767a[Download.DownloadState.FAILED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f50767a[Download.DownloadState.WAITING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f50767a[Download.DownloadState.DOWNLOADING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f50767a[Download.DownloadState.PAUSE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i implements d.a.m0.g.c.f.b {
        public i(a aVar) {
        }

        @Override // d.a.m0.g.c.f.b
        public void b(d.a.m0.g.c.g.b bVar) {
        }
    }

    public a() {
        DownloadManager downloadManager = DownloadManager.getInstance(AppRuntime.getAppContext());
        this.f50746c = downloadManager;
        d.a.m0.g.c.d.c cVar = new d.a.m0.g.c.d.c(downloadManager);
        this.f50747d = cVar;
        cVar.e();
        this.f50747d.m();
        A();
        z();
        if (f50742h) {
            this.f50746c.registerOnProgressChangeListener(new C1054a(this));
        }
        d.a.m0.g.c.h.a.f().j();
        F();
        o();
    }

    public static a n() {
        if (f50743i == null) {
            synchronized (a.class) {
                if (f50743i == null) {
                    f50743i = new a();
                }
            }
        }
        return f50743i;
    }

    public final void A() {
        this.f50746c.registerOnStateChangeListener(new d());
    }

    public void B(String str, d.a.m0.g.c.f.b bVar) {
        this.f50745b.g(str, bVar);
    }

    public final void C(String str) {
        this.f50744a.f(str);
    }

    public void D() {
        Collection<Download> x = this.f50747d.x();
        if (x == null || x.isEmpty()) {
            return;
        }
        for (Download download : x) {
            this.f50744a.a(String.valueOf(download.getId()), new i(this));
            if (!d.a.m0.h.t.a.d().a(download)) {
                d.a.m0.g.c.i.c.a(download.getKeyByUser(), "resumeAllDownload", "success", null, new d.a.m0.g.c.i.a(this.f50748e));
            }
        }
    }

    public void E(@NonNull JSONObject jSONObject, @NonNull d.a.m0.g.c.f.b bVar) {
        if (i()) {
            bVar.b(new d.a.m0.g.c.g.a(31006, "is not in main process"));
        } else if (!SwanAppNetworkUtils.i(null)) {
            bVar.b(new d.a.m0.g.c.g.a(31014, "network is not connected"));
        } else {
            String optString = jSONObject.optString("url");
            String optString2 = jSONObject.optString("packageName");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                Download u = this.f50747d.u(optString, optString2);
                if (u == null) {
                    d.a.m0.g.c.d.d.b().e(jSONObject, bVar);
                    return;
                }
                String valueOf = String.valueOf(u.getId());
                if (!this.f50744a.d(valueOf)) {
                    this.f50744a.a(String.valueOf(u.getId()), bVar);
                }
                if (u.getState() == Download.DownloadState.FINISH) {
                    new d.a.m0.g.c.e.c(u, this.f50748e).c(new b(valueOf, u));
                    return;
                }
                d.a.m0.g.c.i.c.a(optString2, "resumeDownload", null, null, new d.a.m0.g.c.i.a(this.f50748e));
                this.f50746c.resume(u.getId().longValue());
                return;
            }
            bVar.b(new d.a.m0.g.c.g.a(31007, "invalid params"));
        }
    }

    public final void F() {
        if (this.f50749f == null) {
            this.f50749f = new AppDownloadNetworkStateReceiver();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        d.a.m0.a.c1.a.b().registerReceiver(this.f50749f, intentFilter);
    }

    public void G(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.f50748e = jSONObject;
        }
    }

    public void H(String str, String str2, String str3, @NonNull d.a.m0.g.c.f.b bVar) {
        if (i()) {
            bVar.b(new d.a.m0.g.c.g.a(31006, "is not in main process"));
        } else if (!SwanAppNetworkUtils.i(null)) {
            bVar.b(new d.a.m0.g.c.g.a(31014, "network is not connected"));
        } else if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (d.a.m0.g.c.e.a.h(AppRuntime.getAppContext(), str2)) {
                bVar.b(new d.a.m0.g.c.g.a(31005, "apk is already installed"));
            } else if (j(str, bVar)) {
                d.a.m0.g.c.d.a aVar = new d.a.m0.g.c.d.a();
                aVar.g(str);
                aVar.f(str2);
                aVar.a(str3);
                Download b2 = aVar.b();
                this.f50746c.start(b2);
                if (b2.getId() != null) {
                    this.f50744a.a(String.valueOf(b2.getId()), bVar);
                }
                if (d.a.m0.h.t.a.d().a(b2)) {
                    return;
                }
                d.a.m0.g.c.i.c.a(str2, "startDownload", null, null, new d.a.m0.g.c.i.a(this.f50748e));
                d.a.m0.g.c.i.c.d(1, str2, str3, str);
            }
        } else {
            bVar.b(new d.a.m0.g.c.g.a(31007, "invalid params"));
        }
    }

    public final void h(Download download, d.a.m0.g.c.f.b bVar) {
        if (download.getId() != null) {
            this.f50744a.a(String.valueOf(download.getId()), bVar);
        }
    }

    public final boolean i() {
        return !ProcessUtils.isMainProcess();
    }

    public boolean j(String str, d.a.m0.g.c.f.b bVar) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f50750g < 1000) {
            if (k.f46983a) {
                Log.d("GameCenterAppManager", "interval is " + (currentTimeMillis - this.f50750g));
            }
            return false;
        }
        this.f50750g = currentTimeMillis;
        Download v = this.f50747d.v(str);
        if (v == null) {
            return true;
        }
        Download.DownloadState state = v.getState();
        if (k.f46983a) {
            Log.d("GameCenterAppManager", "current state is " + state.name());
        }
        int i2 = h.f50767a[state.ordinal()];
        if (i2 == 1) {
            h(v, bVar);
            s(v);
            return false;
        } else if (i2 == 4 || i2 == 5) {
            h(v, bVar);
            if (k.f46983a) {
                Log.d("GameCenterAppManager", "下载中，继续下载");
            }
            return false;
        } else if (i2 != 6) {
            this.f50747d.g(str);
            return true;
        } else {
            h(v, bVar);
            this.f50746c.resume(v.getId().longValue());
            if (k.f46983a) {
                Log.d("GameCenterAppManager", "状态暂停，恢复下载下载");
            }
            return false;
        }
    }

    public synchronized void k() {
        this.f50747d.d();
    }

    public boolean l(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        if (file.isFile() && file.exists()) {
            try {
                return file.delete();
            } catch (SecurityException e2) {
                if (f50742h) {
                    e2.printStackTrace();
                }
            }
        }
        return false;
    }

    public void m(@NonNull JSONObject jSONObject, @NonNull d.a.m0.g.c.f.b bVar) {
        if (i()) {
            bVar.b(new d.a.m0.g.c.g.a(31006, "is not in main process"));
            return;
        }
        String optString = jSONObject.optString("url");
        String optString2 = jSONObject.optString("packageName");
        if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
            Collection<Download> r = this.f50747d.r(optString);
            if (r != null && !r.isEmpty()) {
                Iterator<Download> it = r.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Download next = it.next();
                    if (next != null && next.getState() == Download.DownloadState.FINISH) {
                        d.a.m0.h.t.a.c().c(optString);
                        break;
                    }
                }
                d.a.m0.g.c.i.c.a(optString2, "deleteDownload", null, null, new d.a.m0.g.c.i.a(this.f50748e));
                this.f50747d.h(r);
                bVar.b(new d.a.m0.g.c.g.c(r));
                return;
            }
            d.a.m0.g.c.d.d.b().a(jSONObject, bVar);
            return;
        }
        bVar.b(new d.a.m0.g.c.g.a(31007, "invalid params"));
    }

    public final void o() {
        d.a.m0.g.i.d.a.c().d();
    }

    public final void p(String str) {
        if (!this.f50747d.b(str)) {
            String i2 = this.f50747d.i(str);
            if (TextUtils.isEmpty(i2) || !this.f50747d.c(i2)) {
                return;
            }
            d.a.m0.g.c.i.c.a(str, "installHijack", null, null, new d.a.m0.g.c.i.a(this.f50748e));
            return;
        }
        d.a.m0.g.c.i.c.a(str, "installApp", "success", null, new d.a.m0.g.c.i.a(this.f50748e));
        Download o = this.f50747d.o(str);
        if (o != null) {
            d.a.m0.g.c.i.c.d(3, str, new d.a.m0.g.c.d.a(o).c(), o.getUrl());
        }
    }

    public void q(String str, String str2) {
        Download w = this.f50747d.w(str);
        if (w == null) {
            return;
        }
        d.a.m0.g.c.e.c cVar = new d.a.m0.g.c.e.c(w, this.f50748e);
        if (!TextUtils.isEmpty(str2)) {
            d.a.m0.g.c.i.c.c("notifyInstall", str2, str);
        }
        cVar.c(new f(w, str2, str));
    }

    public String r(Context context, String str, String str2, @NonNull d.a.m0.g.c.f.a aVar) {
        if (i()) {
            aVar.b(new d.a.m0.g.c.g.a(31006, "is not in main process"));
            return null;
        } else if (TextUtils.isEmpty(str)) {
            aVar.b(new d.a.m0.g.c.g.a(31007, "invalid params"));
            return null;
        } else {
            Download o = this.f50747d.o(str2);
            if (o == null) {
                aVar.b(new d.a.m0.g.c.g.a(31008, "download is not exist"));
                this.f50747d.g(str);
                return null;
            } else if (o.getCurrentbytes().longValue() < o.getTotalbytes().longValue()) {
                aVar.b(new d.a.m0.g.c.g.a(31017, "download is not finished"));
                this.f50747d.g(str);
                return null;
            } else {
                String realDownloadDir = o.getRealDownloadDir();
                String fileName = o.getFileName();
                if (f50742h) {
                    Log.d("GameCenterAppManager", "installApp packageName:" + str2 + ",fileDir:" + realDownloadDir + ",fileName:" + fileName);
                }
                if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(realDownloadDir) || TextUtils.isEmpty(fileName)) {
                    aVar.b(new d.a.m0.g.c.g.a(31001, "database no package or file name"));
                    this.f50747d.g(str);
                }
                String str3 = realDownloadDir + File.separator + fileName;
                if (d.a.m0.g.c.e.a.h(AppRuntime.getAppContext(), str2)) {
                    p(str2);
                    aVar.b(new d.a.m0.g.c.g.c("apk is already installed"));
                    l(str3);
                    return null;
                }
                File file = new File(str3);
                if (file.isFile() && file.exists()) {
                    if (k0.c() <= file.length()) {
                        aVar.b(new d.a.m0.g.c.g.a(31020, "not enough space to install"));
                        return null;
                    }
                    aVar.setPackageName(str2);
                    aVar.a(str3);
                    this.f50745b.a(str2, aVar);
                    if (!d.a.m0.g.c.e.a.j(context, str3, false)) {
                        t(str2);
                        B(str2, aVar);
                        aVar.b(new d.a.m0.g.c.g.a(31004, "apk install fail"));
                        this.f50747d.g(str);
                    } else {
                        long length = ((file.length() / 104857600) + 1) * 1000;
                        String c2 = d.a.m0.g.c.e.a.c();
                        if (d.a.m0.g.c.e.a.k(c2)) {
                            d.a.m0.a.a2.d.i().postDelayed(new c(c2, str2), length);
                        }
                    }
                    return str2;
                }
                aVar.b(new d.a.m0.g.c.g.a(31002, "file is not exist"));
                this.f50747d.g(str);
                return null;
            }
        }
    }

    public final void s(Download download) {
        new d.a.m0.g.c.e.c(download, this.f50748e).c(new g(download));
    }

    public void t(String str) {
        for (Download download : this.f50747d.p(str)) {
            if (download != null) {
                d.a.m0.g.c.h.a.f().a(download);
            }
        }
    }

    public void u() {
        this.f50747d.m();
    }

    public void v(@NonNull JSONObject jSONObject, @NonNull d.a.m0.g.c.f.b bVar) {
        if (i()) {
            bVar.b(new d.a.m0.g.c.g.a(31006, "is not in main process"));
            return;
        }
        String optString = jSONObject.optString("url");
        String optString2 = jSONObject.optString("packageName");
        if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
            Download u = this.f50747d.u(optString, optString2);
            if (u == null) {
                d.a.m0.g.c.d.d.b().c(jSONObject, bVar);
                return;
            } else if (u.getState() != Download.DownloadState.WAITING && u.getState() != Download.DownloadState.DOWNLOADING) {
                bVar.b(new d.a.m0.g.c.g.a(31013, "download is not started"));
                return;
            } else {
                d.a.m0.g.c.i.c.a(optString2, "pauseDownload", null, null, new d.a.m0.g.c.i.a(this.f50748e));
                this.f50746c.pause(u.getId().longValue());
                bVar.b(new d.a.m0.g.c.g.c(u));
                return;
            }
        }
        bVar.b(new d.a.m0.g.c.g.a(31007, "invalid params"));
    }

    public void w(@NonNull d.a.m0.g.c.f.b bVar) {
        if (i()) {
            bVar.b(new d.a.m0.g.c.g.a(31006, "is not in main process"));
            return;
        }
        Collection<Download> n = this.f50747d.n();
        if (n != null && !n.isEmpty()) {
            bVar.b(new d.a.m0.g.c.g.c(n));
        } else {
            bVar.b(new d.a.m0.g.c.g.a(31008, "download is not exist"));
        }
    }

    public void x(@NonNull JSONObject jSONObject, @NonNull d.a.m0.g.c.f.b bVar) {
        if (i()) {
            bVar.b(new d.a.m0.g.c.g.a(31006, "is not in main process"));
            return;
        }
        String optString = jSONObject.optString("url");
        if (TextUtils.isEmpty(optString)) {
            bVar.b(new d.a.m0.g.c.g.a(31007, "invalid params"));
            return;
        }
        Download v = this.f50747d.v(optString);
        if (v == null) {
            d.a.m0.g.c.d.d.b().d(jSONObject, bVar);
        } else {
            bVar.b(new d.a.m0.g.c.g.c(v));
        }
    }

    public Download y(String str) {
        return this.f50747d.v(str);
    }

    public final synchronized void z() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addDataScheme(AsInstallService.SCHEME_PACKAGE_ADDED);
        intentFilter.addAction(PackageChangedReceiver.ACTION_INSTALL);
        AppRuntime.getAppContext().registerReceiver(new e(), intentFilter);
    }
}
