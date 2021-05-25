package d.a.l0.g.c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.down.manage.Download;
import com.baidu.down.manage.DownloadManager;
import com.baidu.searchbox.bddownload.core.download.DownloadStrategy;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.gamecenter.appmanager.download.AppDownloadNetworkStateReceiver;
import com.baidu.swan.gamecenter.appmanager.install.InstallAntiBlockingActivity;
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
import com.baidu.tieba.service.AsInstallService;
import d.a.l0.a.k;
import d.a.l0.a.v2.k0;
import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f46960h = k.f43199a;

    /* renamed from: i  reason: collision with root package name */
    public static volatile a f46961i;

    /* renamed from: c  reason: collision with root package name */
    public DownloadManager f46964c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.l0.g.c.d.c f46965d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f46966e;

    /* renamed from: f  reason: collision with root package name */
    public AppDownloadNetworkStateReceiver f46967f;

    /* renamed from: a  reason: collision with root package name */
    public d.a.l0.g.c.b f46962a = new d.a.l0.g.c.b();

    /* renamed from: b  reason: collision with root package name */
    public d.a.l0.g.c.b f46963b = new d.a.l0.g.c.b();

    /* renamed from: g  reason: collision with root package name */
    public long f46968g = 0;

    /* renamed from: d.a.l0.g.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0995a implements DownloadManager.OnProgressChangeListener {
        public C0995a(a aVar) {
        }

        @Override // com.baidu.down.manage.DownloadManager.OnProgressChangeListener
        public void onProgressChanged(long j, int i2, long j2) {
            if (k.f43199a) {
                Log.d("GameCenterAppManager", "onProgressChanged downloadId = " + j + ",percentage = " + i2 + ",speed = " + j2);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.a.l0.g.c.f.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f46969a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Download f46970b;

        public b(String str, Download download) {
            this.f46969a = str;
            this.f46970b = download;
        }

        @Override // d.a.l0.g.c.f.b
        public void b(d.a.l0.g.c.g.b bVar) {
            if (bVar != null) {
                if (bVar.d()) {
                    a.this.f46962a.b(this.f46969a, new d.a.l0.g.c.g.c(this.f46970b));
                } else {
                    a.this.f46962a.b(this.f46969a, bVar);
                }
            }
            a.this.C(this.f46969a);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f46972e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f46973f;

        public c(String str, String str2) {
            this.f46972e = str;
            this.f46973f = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.a.l0.a.g1.g.a().b()) {
                return;
            }
            if (a.f46960h) {
                Log.d("GameCenterAppManager", "start InstallAntiBlockingActivity");
            }
            Intent intent = new Intent(AppRuntime.getAppContext(), InstallAntiBlockingActivity.class);
            intent.putExtra("type", this.f46972e);
            intent.putExtra("packageName", this.f46973f);
            if (a.this.f46966e != null) {
                intent.putExtra("ubc_params", a.this.f46966e.toString());
            }
            intent.setFlags(276824064);
            d.a.l0.a.v2.f.g(AppRuntime.getAppContext(), intent);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements DownloadManager.OnStateChangeListener {

        /* renamed from: d.a.l0.g.c.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0996a implements d.a.l0.g.c.f.b {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f46976a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Download f46977b;

            public C0996a(String str, Download download) {
                this.f46976a = str;
                this.f46977b = download;
            }

            @Override // d.a.l0.g.c.f.b
            public void b(d.a.l0.g.c.g.b bVar) {
                if (bVar != null) {
                    if (bVar.d()) {
                        a.this.f46962a.b(this.f46976a, new d.a.l0.g.c.g.c(this.f46977b));
                    } else {
                        a.this.f46962a.b(this.f46976a, bVar);
                    }
                }
                a.this.C(this.f46976a);
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
            if (a.f46960h) {
                Log.d("GameCenterAppManager", "onStateChanged downloadId = " + j + ",eventType:" + valueOf + ",download = " + download);
            }
            if (download.getState() == Download.DownloadState.FINISH) {
                if (!d.a.l0.h.t.a.d().a(download)) {
                    d.a.l0.g.c.i.c.a(download.getKeyByUser(), "startDownload", "success", null, new d.a.l0.g.c.i.a(a.this.f46966e));
                    d.a.l0.g.c.i.c.d(2, download.getKeyByUser(), new d.a.l0.g.c.d.a(download).c(), download.getUrl());
                }
                d.a.l0.g.c.h.a.f().m(download, true, "downloadfinish");
            }
            if (a.this.f46962a.d(valueOf)) {
                int i2 = h.f46985a[download.getState().ordinal()];
                if (i2 == 1) {
                    a.this.f46965d.f();
                    d.a.l0.h.t.a.c().b(download.getUrl(), download.getFileName(), download.getRealDownloadDir(), String.valueOf(download.getTotalbytes()), String.valueOf(download.getCurrentbytes()));
                    new d.a.l0.g.c.e.c(download, a.this.f46966e).c(new C0996a(valueOf, download));
                    if (d.a.l0.h.t.a.d().a(download)) {
                        d.a.l0.h.t.a.d().b(download);
                    }
                } else if (i2 == 2) {
                    a.this.f46962a.b(valueOf, new d.a.l0.g.c.g.a(31015, "download is canceled"));
                    a.this.C(valueOf);
                } else if (i2 != 3) {
                } else {
                    a.this.f46962a.b(valueOf, new d.a.l0.g.c.g.a(download.getFailedType().intValue(), TextUtils.isEmpty(download.getFailedReason()) ? "download is failed" : download.getFailedReason()));
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
            if (a.f46960h) {
                Log.d("GameCenterAppManager", "AddPackageReceiver packageName = " + schemeSpecificPart);
            }
            Download o = a.this.f46965d.o(schemeSpecificPart);
            if (!d.a.l0.h.t.a.d().a(o)) {
                a.this.p(schemeSpecificPart);
            } else {
                d.a.l0.h.t.a.d().c(o);
            }
            a.this.t(schemeSpecificPart);
            a.this.f46963b.b(schemeSpecificPart, new d.a.l0.g.c.g.c((String) null));
            a.this.B(schemeSpecificPart, null);
        }
    }

    /* loaded from: classes3.dex */
    public class f implements d.a.l0.g.c.f.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Download f46979a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f46980b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f46981c;

        public f(Download download, String str, String str2) {
            this.f46979a = download;
            this.f46980b = str;
            this.f46981c = str2;
        }

        @Override // d.a.l0.g.c.f.b
        public void b(d.a.l0.g.c.g.b bVar) {
            String valueOf = String.valueOf(this.f46979a.getId());
            if (bVar != null) {
                if (!bVar.d()) {
                    a.this.f46962a.b(valueOf, bVar);
                } else {
                    if (!TextUtils.isEmpty(this.f46980b)) {
                        d.a.l0.g.c.i.c.c("installSuccess", this.f46980b, this.f46981c);
                    }
                    a.this.f46962a.b(valueOf, new d.a.l0.g.c.g.c(this.f46979a));
                }
            }
            a.this.C(valueOf);
        }
    }

    /* loaded from: classes3.dex */
    public class g implements d.a.l0.g.c.f.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Download f46983a;

        public g(Download download) {
            this.f46983a = download;
        }

        @Override // d.a.l0.g.c.f.b
        public void b(d.a.l0.g.c.g.b bVar) {
            String valueOf = String.valueOf(this.f46983a.getId());
            if (bVar != null) {
                if (bVar.d()) {
                    a.this.f46962a.b(valueOf, new d.a.l0.g.c.g.c(this.f46983a));
                } else {
                    a.this.f46962a.b(valueOf, bVar);
                }
            }
            a.this.C(valueOf);
        }
    }

    /* loaded from: classes3.dex */
    public static /* synthetic */ class h {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f46985a;

        static {
            int[] iArr = new int[Download.DownloadState.values().length];
            f46985a = iArr;
            try {
                iArr[Download.DownloadState.FINISH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f46985a[Download.DownloadState.CANCEL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f46985a[Download.DownloadState.FAILED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f46985a[Download.DownloadState.WAITING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f46985a[Download.DownloadState.DOWNLOADING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f46985a[Download.DownloadState.PAUSE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i implements d.a.l0.g.c.f.b {
        public i(a aVar) {
        }

        @Override // d.a.l0.g.c.f.b
        public void b(d.a.l0.g.c.g.b bVar) {
        }
    }

    public a() {
        DownloadManager downloadManager = DownloadManager.getInstance(AppRuntime.getAppContext());
        this.f46964c = downloadManager;
        d.a.l0.g.c.d.c cVar = new d.a.l0.g.c.d.c(downloadManager);
        this.f46965d = cVar;
        cVar.e();
        this.f46965d.m();
        A();
        z();
        if (f46960h) {
            this.f46964c.registerOnProgressChangeListener(new C0995a(this));
        }
        d.a.l0.g.c.h.a.f().j();
        F();
        o();
    }

    public static a n() {
        if (f46961i == null) {
            synchronized (a.class) {
                if (f46961i == null) {
                    f46961i = new a();
                }
            }
        }
        return f46961i;
    }

    public final void A() {
        this.f46964c.registerOnStateChangeListener(new d());
    }

    public void B(String str, d.a.l0.g.c.f.b bVar) {
        this.f46963b.g(str, bVar);
    }

    public final void C(String str) {
        this.f46962a.f(str);
    }

    public void D() {
        Collection<Download> x = this.f46965d.x();
        if (x == null || x.isEmpty()) {
            return;
        }
        for (Download download : x) {
            this.f46962a.a(String.valueOf(download.getId()), new i(this));
            if (!d.a.l0.h.t.a.d().a(download)) {
                d.a.l0.g.c.i.c.a(download.getKeyByUser(), "resumeAllDownload", "success", null, new d.a.l0.g.c.i.a(this.f46966e));
            }
        }
    }

    public void E(@NonNull JSONObject jSONObject, @NonNull d.a.l0.g.c.f.b bVar) {
        if (i()) {
            bVar.b(new d.a.l0.g.c.g.a(31006, "is not in main process"));
        } else if (!SwanAppNetworkUtils.i(null)) {
            bVar.b(new d.a.l0.g.c.g.a(31014, "network is not connected"));
        } else {
            String optString = jSONObject.optString("url");
            String optString2 = jSONObject.optString("packageName");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                Download u = this.f46965d.u(optString, optString2);
                if (u == null) {
                    d.a.l0.g.c.d.d.b().e(jSONObject, bVar);
                    return;
                }
                String valueOf = String.valueOf(u.getId());
                if (!this.f46962a.d(valueOf)) {
                    this.f46962a.a(String.valueOf(u.getId()), bVar);
                }
                if (u.getState() == Download.DownloadState.FINISH) {
                    new d.a.l0.g.c.e.c(u, this.f46966e).c(new b(valueOf, u));
                    return;
                }
                d.a.l0.g.c.i.c.a(optString2, "resumeDownload", null, null, new d.a.l0.g.c.i.a(this.f46966e));
                this.f46964c.resume(u.getId().longValue());
                return;
            }
            bVar.b(new d.a.l0.g.c.g.a(31007, "invalid params"));
        }
    }

    public final void F() {
        if (this.f46967f == null) {
            this.f46967f = new AppDownloadNetworkStateReceiver();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        d.a.l0.a.c1.a.b().registerReceiver(this.f46967f, intentFilter);
    }

    public void G(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.f46966e = jSONObject;
        }
    }

    public void H(String str, String str2, String str3, @NonNull d.a.l0.g.c.f.b bVar) {
        if (i()) {
            bVar.b(new d.a.l0.g.c.g.a(31006, "is not in main process"));
        } else if (!SwanAppNetworkUtils.i(null)) {
            bVar.b(new d.a.l0.g.c.g.a(31014, "network is not connected"));
        } else if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (d.a.l0.g.c.e.a.h(AppRuntime.getAppContext(), str2)) {
                bVar.b(new d.a.l0.g.c.g.a(31005, "apk is already installed"));
            } else if (j(str, bVar)) {
                d.a.l0.g.c.d.a aVar = new d.a.l0.g.c.d.a();
                aVar.g(str);
                aVar.f(str2);
                aVar.a(str3);
                Download b2 = aVar.b();
                this.f46964c.start(b2);
                if (b2.getId() != null) {
                    this.f46962a.a(String.valueOf(b2.getId()), bVar);
                }
                if (d.a.l0.h.t.a.d().a(b2)) {
                    return;
                }
                d.a.l0.g.c.i.c.a(str2, "startDownload", null, null, new d.a.l0.g.c.i.a(this.f46966e));
                d.a.l0.g.c.i.c.d(1, str2, str3, str);
            }
        } else {
            bVar.b(new d.a.l0.g.c.g.a(31007, "invalid params"));
        }
    }

    public final void h(Download download, d.a.l0.g.c.f.b bVar) {
        if (download.getId() != null) {
            this.f46962a.a(String.valueOf(download.getId()), bVar);
        }
    }

    public final boolean i() {
        return !ProcessUtils.isMainProcess();
    }

    public boolean j(String str, d.a.l0.g.c.f.b bVar) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f46968g < 1000) {
            if (k.f43199a) {
                Log.d("GameCenterAppManager", "interval is " + (currentTimeMillis - this.f46968g));
            }
            return false;
        }
        this.f46968g = currentTimeMillis;
        Download v = this.f46965d.v(str);
        if (v == null) {
            return true;
        }
        Download.DownloadState state = v.getState();
        if (k.f43199a) {
            Log.d("GameCenterAppManager", "current state is " + state.name());
        }
        int i2 = h.f46985a[state.ordinal()];
        if (i2 == 1) {
            h(v, bVar);
            s(v);
            return false;
        } else if (i2 == 4 || i2 == 5) {
            h(v, bVar);
            if (k.f43199a) {
                Log.d("GameCenterAppManager", "下载中，继续下载");
            }
            return false;
        } else if (i2 != 6) {
            this.f46965d.g(str);
            return true;
        } else {
            h(v, bVar);
            this.f46964c.resume(v.getId().longValue());
            if (k.f43199a) {
                Log.d("GameCenterAppManager", "状态暂停，恢复下载下载");
            }
            return false;
        }
    }

    public synchronized void k() {
        this.f46965d.d();
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
                if (f46960h) {
                    e2.printStackTrace();
                }
            }
        }
        return false;
    }

    public void m(@NonNull JSONObject jSONObject, @NonNull d.a.l0.g.c.f.b bVar) {
        if (i()) {
            bVar.b(new d.a.l0.g.c.g.a(31006, "is not in main process"));
            return;
        }
        String optString = jSONObject.optString("url");
        String optString2 = jSONObject.optString("packageName");
        if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
            Collection<Download> r = this.f46965d.r(optString);
            if (r != null && !r.isEmpty()) {
                Iterator<Download> it = r.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Download next = it.next();
                    if (next != null && next.getState() == Download.DownloadState.FINISH) {
                        d.a.l0.h.t.a.c().c(optString);
                        break;
                    }
                }
                d.a.l0.g.c.i.c.a(optString2, "deleteDownload", null, null, new d.a.l0.g.c.i.a(this.f46966e));
                this.f46965d.h(r);
                bVar.b(new d.a.l0.g.c.g.c(r));
                return;
            }
            d.a.l0.g.c.d.d.b().a(jSONObject, bVar);
            return;
        }
        bVar.b(new d.a.l0.g.c.g.a(31007, "invalid params"));
    }

    public final void o() {
        d.a.l0.g.i.d.a.c().d();
    }

    public final void p(String str) {
        if (!this.f46965d.b(str)) {
            String i2 = this.f46965d.i(str);
            if (TextUtils.isEmpty(i2) || !this.f46965d.c(i2)) {
                return;
            }
            d.a.l0.g.c.i.c.a(str, "installHijack", null, null, new d.a.l0.g.c.i.a(this.f46966e));
            return;
        }
        d.a.l0.g.c.i.c.a(str, "installApp", "success", null, new d.a.l0.g.c.i.a(this.f46966e));
        Download o = this.f46965d.o(str);
        if (o != null) {
            d.a.l0.g.c.i.c.d(3, str, new d.a.l0.g.c.d.a(o).c(), o.getUrl());
        }
    }

    public void q(String str, String str2) {
        Download w = this.f46965d.w(str);
        if (w == null) {
            return;
        }
        d.a.l0.g.c.e.c cVar = new d.a.l0.g.c.e.c(w, this.f46966e);
        if (!TextUtils.isEmpty(str2)) {
            d.a.l0.g.c.i.c.c("notifyInstall", str2, str);
        }
        cVar.c(new f(w, str2, str));
    }

    public String r(Context context, String str, String str2, @NonNull d.a.l0.g.c.f.a aVar) {
        if (i()) {
            aVar.b(new d.a.l0.g.c.g.a(31006, "is not in main process"));
            return null;
        } else if (TextUtils.isEmpty(str)) {
            aVar.b(new d.a.l0.g.c.g.a(31007, "invalid params"));
            return null;
        } else {
            Download o = this.f46965d.o(str2);
            if (o == null) {
                aVar.b(new d.a.l0.g.c.g.a(31008, "download is not exist"));
                this.f46965d.g(str);
                return null;
            } else if (o.getCurrentbytes().longValue() < o.getTotalbytes().longValue()) {
                aVar.b(new d.a.l0.g.c.g.a(31017, "download is not finished"));
                this.f46965d.g(str);
                return null;
            } else {
                String realDownloadDir = o.getRealDownloadDir();
                String fileName = o.getFileName();
                if (f46960h) {
                    Log.d("GameCenterAppManager", "installApp packageName:" + str2 + ",fileDir:" + realDownloadDir + ",fileName:" + fileName);
                }
                if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(realDownloadDir) || TextUtils.isEmpty(fileName)) {
                    aVar.b(new d.a.l0.g.c.g.a(31001, "database no package or file name"));
                    this.f46965d.g(str);
                }
                String str3 = realDownloadDir + File.separator + fileName;
                if (d.a.l0.g.c.e.a.h(AppRuntime.getAppContext(), str2)) {
                    p(str2);
                    aVar.b(new d.a.l0.g.c.g.c("apk is already installed"));
                    l(str3);
                    return null;
                }
                File file = new File(str3);
                if (file.isFile() && file.exists()) {
                    if (k0.c() <= file.length()) {
                        aVar.b(new d.a.l0.g.c.g.a(31020, "not enough space to install"));
                        return null;
                    }
                    aVar.setPackageName(str2);
                    aVar.a(str3);
                    this.f46963b.a(str2, aVar);
                    if (!d.a.l0.g.c.e.a.j(context, str3, false)) {
                        t(str2);
                        B(str2, aVar);
                        aVar.b(new d.a.l0.g.c.g.a(31004, "apk install fail"));
                        this.f46965d.g(str);
                    } else {
                        long length = ((file.length() / DownloadStrategy.FOUR_CONNECTION_UPPER_LIMIT) + 1) * 1000;
                        String c2 = d.a.l0.g.c.e.a.c();
                        if (d.a.l0.g.c.e.a.k(c2)) {
                            d.a.l0.a.a2.d.i().postDelayed(new c(c2, str2), length);
                        }
                    }
                    return str2;
                }
                aVar.b(new d.a.l0.g.c.g.a(31002, "file is not exist"));
                this.f46965d.g(str);
                return null;
            }
        }
    }

    public final void s(Download download) {
        new d.a.l0.g.c.e.c(download, this.f46966e).c(new g(download));
    }

    public void t(String str) {
        for (Download download : this.f46965d.p(str)) {
            if (download != null) {
                d.a.l0.g.c.h.a.f().a(download);
            }
        }
    }

    public void u() {
        this.f46965d.m();
    }

    public void v(@NonNull JSONObject jSONObject, @NonNull d.a.l0.g.c.f.b bVar) {
        if (i()) {
            bVar.b(new d.a.l0.g.c.g.a(31006, "is not in main process"));
            return;
        }
        String optString = jSONObject.optString("url");
        String optString2 = jSONObject.optString("packageName");
        if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
            Download u = this.f46965d.u(optString, optString2);
            if (u == null) {
                d.a.l0.g.c.d.d.b().c(jSONObject, bVar);
                return;
            } else if (u.getState() != Download.DownloadState.WAITING && u.getState() != Download.DownloadState.DOWNLOADING) {
                bVar.b(new d.a.l0.g.c.g.a(31013, "download is not started"));
                return;
            } else {
                d.a.l0.g.c.i.c.a(optString2, "pauseDownload", null, null, new d.a.l0.g.c.i.a(this.f46966e));
                this.f46964c.pause(u.getId().longValue());
                bVar.b(new d.a.l0.g.c.g.c(u));
                return;
            }
        }
        bVar.b(new d.a.l0.g.c.g.a(31007, "invalid params"));
    }

    public void w(@NonNull d.a.l0.g.c.f.b bVar) {
        if (i()) {
            bVar.b(new d.a.l0.g.c.g.a(31006, "is not in main process"));
            return;
        }
        Collection<Download> n = this.f46965d.n();
        if (n != null && !n.isEmpty()) {
            bVar.b(new d.a.l0.g.c.g.c(n));
        } else {
            bVar.b(new d.a.l0.g.c.g.a(31008, "download is not exist"));
        }
    }

    public void x(@NonNull JSONObject jSONObject, @NonNull d.a.l0.g.c.f.b bVar) {
        if (i()) {
            bVar.b(new d.a.l0.g.c.g.a(31006, "is not in main process"));
            return;
        }
        String optString = jSONObject.optString("url");
        if (TextUtils.isEmpty(optString)) {
            bVar.b(new d.a.l0.g.c.g.a(31007, "invalid params"));
            return;
        }
        Download v = this.f46965d.v(optString);
        if (v == null) {
            d.a.l0.g.c.d.d.b().d(jSONObject, bVar);
        } else {
            bVar.b(new d.a.l0.g.c.g.c(v));
        }
    }

    public Download y(String str) {
        return this.f46965d.v(str);
    }

    public final synchronized void z() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addDataScheme(AsInstallService.SCHEME_PACKAGE_ADDED);
        intentFilter.addAction(PackageChangedReceiver.ACTION_INSTALL);
        AppRuntime.getAppContext().registerReceiver(new e(), intentFilter);
    }
}
