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
    public static final boolean f50634h = k.f46875a;

    /* renamed from: i  reason: collision with root package name */
    public static volatile a f50635i;

    /* renamed from: c  reason: collision with root package name */
    public DownloadManager f50638c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.l0.g.c.d.c f50639d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f50640e;

    /* renamed from: f  reason: collision with root package name */
    public AppDownloadNetworkStateReceiver f50641f;

    /* renamed from: a  reason: collision with root package name */
    public d.a.l0.g.c.b f50636a = new d.a.l0.g.c.b();

    /* renamed from: b  reason: collision with root package name */
    public d.a.l0.g.c.b f50637b = new d.a.l0.g.c.b();

    /* renamed from: g  reason: collision with root package name */
    public long f50642g = 0;

    /* renamed from: d.a.l0.g.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1051a implements DownloadManager.OnProgressChangeListener {
        public C1051a(a aVar) {
        }

        @Override // com.baidu.down.manage.DownloadManager.OnProgressChangeListener
        public void onProgressChanged(long j, int i2, long j2) {
            if (k.f46875a) {
                Log.d("GameCenterAppManager", "onProgressChanged downloadId = " + j + ",percentage = " + i2 + ",speed = " + j2);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.a.l0.g.c.f.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f50643a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Download f50644b;

        public b(String str, Download download) {
            this.f50643a = str;
            this.f50644b = download;
        }

        @Override // d.a.l0.g.c.f.b
        public void b(d.a.l0.g.c.g.b bVar) {
            if (bVar != null) {
                if (bVar.d()) {
                    a.this.f50636a.b(this.f50643a, new d.a.l0.g.c.g.c(this.f50644b));
                } else {
                    a.this.f50636a.b(this.f50643a, bVar);
                }
            }
            a.this.C(this.f50643a);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f50646e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f50647f;

        public c(String str, String str2) {
            this.f50646e = str;
            this.f50647f = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.a.l0.a.g1.g.a().b()) {
                return;
            }
            if (a.f50634h) {
                Log.d("GameCenterAppManager", "start InstallAntiBlockingActivity");
            }
            Intent intent = new Intent(AppRuntime.getAppContext(), InstallAntiBlockingActivity.class);
            intent.putExtra("type", this.f50646e);
            intent.putExtra("packageName", this.f50647f);
            if (a.this.f50640e != null) {
                intent.putExtra("ubc_params", a.this.f50640e.toString());
            }
            intent.setFlags(276824064);
            d.a.l0.a.v2.f.g(AppRuntime.getAppContext(), intent);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements DownloadManager.OnStateChangeListener {

        /* renamed from: d.a.l0.g.c.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C1052a implements d.a.l0.g.c.f.b {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f50650a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Download f50651b;

            public C1052a(String str, Download download) {
                this.f50650a = str;
                this.f50651b = download;
            }

            @Override // d.a.l0.g.c.f.b
            public void b(d.a.l0.g.c.g.b bVar) {
                if (bVar != null) {
                    if (bVar.d()) {
                        a.this.f50636a.b(this.f50650a, new d.a.l0.g.c.g.c(this.f50651b));
                    } else {
                        a.this.f50636a.b(this.f50650a, bVar);
                    }
                }
                a.this.C(this.f50650a);
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
            if (a.f50634h) {
                Log.d("GameCenterAppManager", "onStateChanged downloadId = " + j + ",eventType:" + valueOf + ",download = " + download);
            }
            if (download.getState() == Download.DownloadState.FINISH) {
                if (!d.a.l0.h.t.a.d().a(download)) {
                    d.a.l0.g.c.i.c.a(download.getKeyByUser(), "startDownload", "success", null, new d.a.l0.g.c.i.a(a.this.f50640e));
                    d.a.l0.g.c.i.c.d(2, download.getKeyByUser(), new d.a.l0.g.c.d.a(download).c(), download.getUrl());
                }
                d.a.l0.g.c.h.a.f().m(download, true, "downloadfinish");
            }
            if (a.this.f50636a.d(valueOf)) {
                int i2 = h.f50659a[download.getState().ordinal()];
                if (i2 == 1) {
                    a.this.f50639d.f();
                    d.a.l0.h.t.a.c().b(download.getUrl(), download.getFileName(), download.getRealDownloadDir(), String.valueOf(download.getTotalbytes()), String.valueOf(download.getCurrentbytes()));
                    new d.a.l0.g.c.e.c(download, a.this.f50640e).c(new C1052a(valueOf, download));
                    if (d.a.l0.h.t.a.d().a(download)) {
                        d.a.l0.h.t.a.d().b(download);
                    }
                } else if (i2 == 2) {
                    a.this.f50636a.b(valueOf, new d.a.l0.g.c.g.a(31015, "download is canceled"));
                    a.this.C(valueOf);
                } else if (i2 != 3) {
                } else {
                    a.this.f50636a.b(valueOf, new d.a.l0.g.c.g.a(download.getFailedType().intValue(), TextUtils.isEmpty(download.getFailedReason()) ? "download is failed" : download.getFailedReason()));
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
            if (a.f50634h) {
                Log.d("GameCenterAppManager", "AddPackageReceiver packageName = " + schemeSpecificPart);
            }
            Download o = a.this.f50639d.o(schemeSpecificPart);
            if (!d.a.l0.h.t.a.d().a(o)) {
                a.this.p(schemeSpecificPart);
            } else {
                d.a.l0.h.t.a.d().c(o);
            }
            a.this.t(schemeSpecificPart);
            a.this.f50637b.b(schemeSpecificPart, new d.a.l0.g.c.g.c((String) null));
            a.this.B(schemeSpecificPart, null);
        }
    }

    /* loaded from: classes3.dex */
    public class f implements d.a.l0.g.c.f.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Download f50653a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f50654b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f50655c;

        public f(Download download, String str, String str2) {
            this.f50653a = download;
            this.f50654b = str;
            this.f50655c = str2;
        }

        @Override // d.a.l0.g.c.f.b
        public void b(d.a.l0.g.c.g.b bVar) {
            String valueOf = String.valueOf(this.f50653a.getId());
            if (bVar != null) {
                if (!bVar.d()) {
                    a.this.f50636a.b(valueOf, bVar);
                } else {
                    if (!TextUtils.isEmpty(this.f50654b)) {
                        d.a.l0.g.c.i.c.c("installSuccess", this.f50654b, this.f50655c);
                    }
                    a.this.f50636a.b(valueOf, new d.a.l0.g.c.g.c(this.f50653a));
                }
            }
            a.this.C(valueOf);
        }
    }

    /* loaded from: classes3.dex */
    public class g implements d.a.l0.g.c.f.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Download f50657a;

        public g(Download download) {
            this.f50657a = download;
        }

        @Override // d.a.l0.g.c.f.b
        public void b(d.a.l0.g.c.g.b bVar) {
            String valueOf = String.valueOf(this.f50657a.getId());
            if (bVar != null) {
                if (bVar.d()) {
                    a.this.f50636a.b(valueOf, new d.a.l0.g.c.g.c(this.f50657a));
                } else {
                    a.this.f50636a.b(valueOf, bVar);
                }
            }
            a.this.C(valueOf);
        }
    }

    /* loaded from: classes3.dex */
    public static /* synthetic */ class h {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f50659a;

        static {
            int[] iArr = new int[Download.DownloadState.values().length];
            f50659a = iArr;
            try {
                iArr[Download.DownloadState.FINISH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f50659a[Download.DownloadState.CANCEL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f50659a[Download.DownloadState.FAILED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f50659a[Download.DownloadState.WAITING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f50659a[Download.DownloadState.DOWNLOADING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f50659a[Download.DownloadState.PAUSE.ordinal()] = 6;
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
        this.f50638c = downloadManager;
        d.a.l0.g.c.d.c cVar = new d.a.l0.g.c.d.c(downloadManager);
        this.f50639d = cVar;
        cVar.e();
        this.f50639d.m();
        A();
        z();
        if (f50634h) {
            this.f50638c.registerOnProgressChangeListener(new C1051a(this));
        }
        d.a.l0.g.c.h.a.f().j();
        F();
        o();
    }

    public static a n() {
        if (f50635i == null) {
            synchronized (a.class) {
                if (f50635i == null) {
                    f50635i = new a();
                }
            }
        }
        return f50635i;
    }

    public final void A() {
        this.f50638c.registerOnStateChangeListener(new d());
    }

    public void B(String str, d.a.l0.g.c.f.b bVar) {
        this.f50637b.g(str, bVar);
    }

    public final void C(String str) {
        this.f50636a.f(str);
    }

    public void D() {
        Collection<Download> x = this.f50639d.x();
        if (x == null || x.isEmpty()) {
            return;
        }
        for (Download download : x) {
            this.f50636a.a(String.valueOf(download.getId()), new i(this));
            if (!d.a.l0.h.t.a.d().a(download)) {
                d.a.l0.g.c.i.c.a(download.getKeyByUser(), "resumeAllDownload", "success", null, new d.a.l0.g.c.i.a(this.f50640e));
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
                Download u = this.f50639d.u(optString, optString2);
                if (u == null) {
                    d.a.l0.g.c.d.d.b().e(jSONObject, bVar);
                    return;
                }
                String valueOf = String.valueOf(u.getId());
                if (!this.f50636a.d(valueOf)) {
                    this.f50636a.a(String.valueOf(u.getId()), bVar);
                }
                if (u.getState() == Download.DownloadState.FINISH) {
                    new d.a.l0.g.c.e.c(u, this.f50640e).c(new b(valueOf, u));
                    return;
                }
                d.a.l0.g.c.i.c.a(optString2, "resumeDownload", null, null, new d.a.l0.g.c.i.a(this.f50640e));
                this.f50638c.resume(u.getId().longValue());
                return;
            }
            bVar.b(new d.a.l0.g.c.g.a(31007, "invalid params"));
        }
    }

    public final void F() {
        if (this.f50641f == null) {
            this.f50641f = new AppDownloadNetworkStateReceiver();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        d.a.l0.a.c1.a.b().registerReceiver(this.f50641f, intentFilter);
    }

    public void G(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.f50640e = jSONObject;
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
                this.f50638c.start(b2);
                if (b2.getId() != null) {
                    this.f50636a.a(String.valueOf(b2.getId()), bVar);
                }
                if (d.a.l0.h.t.a.d().a(b2)) {
                    return;
                }
                d.a.l0.g.c.i.c.a(str2, "startDownload", null, null, new d.a.l0.g.c.i.a(this.f50640e));
                d.a.l0.g.c.i.c.d(1, str2, str3, str);
            }
        } else {
            bVar.b(new d.a.l0.g.c.g.a(31007, "invalid params"));
        }
    }

    public final void h(Download download, d.a.l0.g.c.f.b bVar) {
        if (download.getId() != null) {
            this.f50636a.a(String.valueOf(download.getId()), bVar);
        }
    }

    public final boolean i() {
        return !ProcessUtils.isMainProcess();
    }

    public boolean j(String str, d.a.l0.g.c.f.b bVar) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f50642g < 1000) {
            if (k.f46875a) {
                Log.d("GameCenterAppManager", "interval is " + (currentTimeMillis - this.f50642g));
            }
            return false;
        }
        this.f50642g = currentTimeMillis;
        Download v = this.f50639d.v(str);
        if (v == null) {
            return true;
        }
        Download.DownloadState state = v.getState();
        if (k.f46875a) {
            Log.d("GameCenterAppManager", "current state is " + state.name());
        }
        int i2 = h.f50659a[state.ordinal()];
        if (i2 == 1) {
            h(v, bVar);
            s(v);
            return false;
        } else if (i2 == 4 || i2 == 5) {
            h(v, bVar);
            if (k.f46875a) {
                Log.d("GameCenterAppManager", "下载中，继续下载");
            }
            return false;
        } else if (i2 != 6) {
            this.f50639d.g(str);
            return true;
        } else {
            h(v, bVar);
            this.f50638c.resume(v.getId().longValue());
            if (k.f46875a) {
                Log.d("GameCenterAppManager", "状态暂停，恢复下载下载");
            }
            return false;
        }
    }

    public synchronized void k() {
        this.f50639d.d();
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
                if (f50634h) {
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
            Collection<Download> r = this.f50639d.r(optString);
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
                d.a.l0.g.c.i.c.a(optString2, "deleteDownload", null, null, new d.a.l0.g.c.i.a(this.f50640e));
                this.f50639d.h(r);
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
        if (!this.f50639d.b(str)) {
            String i2 = this.f50639d.i(str);
            if (TextUtils.isEmpty(i2) || !this.f50639d.c(i2)) {
                return;
            }
            d.a.l0.g.c.i.c.a(str, "installHijack", null, null, new d.a.l0.g.c.i.a(this.f50640e));
            return;
        }
        d.a.l0.g.c.i.c.a(str, "installApp", "success", null, new d.a.l0.g.c.i.a(this.f50640e));
        Download o = this.f50639d.o(str);
        if (o != null) {
            d.a.l0.g.c.i.c.d(3, str, new d.a.l0.g.c.d.a(o).c(), o.getUrl());
        }
    }

    public void q(String str, String str2) {
        Download w = this.f50639d.w(str);
        if (w == null) {
            return;
        }
        d.a.l0.g.c.e.c cVar = new d.a.l0.g.c.e.c(w, this.f50640e);
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
            Download o = this.f50639d.o(str2);
            if (o == null) {
                aVar.b(new d.a.l0.g.c.g.a(31008, "download is not exist"));
                this.f50639d.g(str);
                return null;
            } else if (o.getCurrentbytes().longValue() < o.getTotalbytes().longValue()) {
                aVar.b(new d.a.l0.g.c.g.a(31017, "download is not finished"));
                this.f50639d.g(str);
                return null;
            } else {
                String realDownloadDir = o.getRealDownloadDir();
                String fileName = o.getFileName();
                if (f50634h) {
                    Log.d("GameCenterAppManager", "installApp packageName:" + str2 + ",fileDir:" + realDownloadDir + ",fileName:" + fileName);
                }
                if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(realDownloadDir) || TextUtils.isEmpty(fileName)) {
                    aVar.b(new d.a.l0.g.c.g.a(31001, "database no package or file name"));
                    this.f50639d.g(str);
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
                    this.f50637b.a(str2, aVar);
                    if (!d.a.l0.g.c.e.a.j(context, str3, false)) {
                        t(str2);
                        B(str2, aVar);
                        aVar.b(new d.a.l0.g.c.g.a(31004, "apk install fail"));
                        this.f50639d.g(str);
                    } else {
                        long length = ((file.length() / 104857600) + 1) * 1000;
                        String c2 = d.a.l0.g.c.e.a.c();
                        if (d.a.l0.g.c.e.a.k(c2)) {
                            d.a.l0.a.a2.d.i().postDelayed(new c(c2, str2), length);
                        }
                    }
                    return str2;
                }
                aVar.b(new d.a.l0.g.c.g.a(31002, "file is not exist"));
                this.f50639d.g(str);
                return null;
            }
        }
    }

    public final void s(Download download) {
        new d.a.l0.g.c.e.c(download, this.f50640e).c(new g(download));
    }

    public void t(String str) {
        for (Download download : this.f50639d.p(str)) {
            if (download != null) {
                d.a.l0.g.c.h.a.f().a(download);
            }
        }
    }

    public void u() {
        this.f50639d.m();
    }

    public void v(@NonNull JSONObject jSONObject, @NonNull d.a.l0.g.c.f.b bVar) {
        if (i()) {
            bVar.b(new d.a.l0.g.c.g.a(31006, "is not in main process"));
            return;
        }
        String optString = jSONObject.optString("url");
        String optString2 = jSONObject.optString("packageName");
        if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
            Download u = this.f50639d.u(optString, optString2);
            if (u == null) {
                d.a.l0.g.c.d.d.b().c(jSONObject, bVar);
                return;
            } else if (u.getState() != Download.DownloadState.WAITING && u.getState() != Download.DownloadState.DOWNLOADING) {
                bVar.b(new d.a.l0.g.c.g.a(31013, "download is not started"));
                return;
            } else {
                d.a.l0.g.c.i.c.a(optString2, "pauseDownload", null, null, new d.a.l0.g.c.i.a(this.f50640e));
                this.f50638c.pause(u.getId().longValue());
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
        Collection<Download> n = this.f50639d.n();
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
        Download v = this.f50639d.v(optString);
        if (v == null) {
            d.a.l0.g.c.d.d.b().d(jSONObject, bVar);
        } else {
            bVar.b(new d.a.l0.g.c.g.c(v));
        }
    }

    public Download y(String str) {
        return this.f50639d.v(str);
    }

    public final synchronized void z() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addDataScheme(AsInstallService.SCHEME_PACKAGE_ADDED);
        intentFilter.addAction(PackageChangedReceiver.ACTION_INSTALL);
        AppRuntime.getAppContext().registerReceiver(new e(), intentFilter);
    }
}
