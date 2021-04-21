package d.b.h0.f.f;

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
import com.baidu.swan.gamecenter.appmanager.install.InstallAntiBlockingActivity;
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
import d.b.h0.a.k;
import d.b.h0.a.z0.g;
import java.io.File;
import java.util.Collection;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f48473f = k.f45772a;

    /* renamed from: g  reason: collision with root package name */
    public static volatile a f48474g;

    /* renamed from: a  reason: collision with root package name */
    public d.b.h0.f.f.b f48475a = new d.b.h0.f.f.b();

    /* renamed from: b  reason: collision with root package name */
    public d.b.h0.f.f.b f48476b = new d.b.h0.f.f.b();

    /* renamed from: c  reason: collision with root package name */
    public DownloadManager f48477c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.h0.f.f.d.c f48478d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f48479e;

    /* renamed from: d.b.h0.f.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0972a implements DownloadManager.OnProgressChangeListener {
        public C0972a(a aVar) {
        }

        @Override // com.baidu.down.manage.DownloadManager.OnProgressChangeListener
        public void onProgressChanged(long j, int i, long j2) {
            Log.d("GameCenterAppManager", "onProgressChanged downloadId = " + j + ",percentage = " + i + ",speed = " + j2);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48480e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f48481f;

        public b(String str, String str2) {
            this.f48480e = str;
            this.f48481f = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (g.a().b()) {
                return;
            }
            if (a.f48473f) {
                Log.d("GameCenterAppManager", "start InstallAntiBlockingActivity");
            }
            Intent intent = new Intent(AppRuntime.getAppContext(), InstallAntiBlockingActivity.class);
            intent.putExtra("type", this.f48480e);
            intent.putExtra("packageName", this.f48481f);
            intent.putExtra(InstallAntiBlockingActivity.KEY_UBC_PARAMS, a.this.f48479e.toString());
            intent.setFlags(276824064);
            d.b.h0.a.i2.e.f(AppRuntime.getAppContext(), intent);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements DownloadManager.OnStateChangeListener {

        /* renamed from: d.b.h0.f.f.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0973a implements d.b.h0.f.f.f.b {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f48484a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Download f48485b;

            public C0973a(String str, Download download) {
                this.f48484a = str;
                this.f48485b = download;
            }

            @Override // d.b.h0.f.f.f.b
            public void a(d.b.h0.f.f.g.b bVar) {
                if (bVar != null) {
                    if (bVar.d()) {
                        a.this.f48475a.b(this.f48484a, new d.b.h0.f.f.g.c(this.f48485b));
                    } else {
                        a.this.f48475a.b(this.f48484a, bVar);
                    }
                }
                a.this.v(this.f48484a);
            }
        }

        public c() {
        }

        @Override // com.baidu.down.manage.DownloadManager.OnStateChangeListener
        public void onStateChanged(long j, Download download) {
            if (download == null || download.getId() == null) {
                return;
            }
            String valueOf = String.valueOf(download.getId());
            if (a.f48473f) {
                Log.d("GameCenterAppManager", "onStateChanged downloadId = " + j + ",eventType:" + valueOf + ",download = " + download);
            }
            if (download.getState() == Download.DownloadState.FINISH) {
                d.b.h0.f.f.h.c.a(download.getKeyByUser(), "startDownload", "success", null, new d.b.h0.f.f.h.a(a.this.f48479e));
            }
            if (a.this.f48475a.d(valueOf)) {
                int i = e.f48487a[download.getState().ordinal()];
                if (i == 1) {
                    a.this.f48478d.f();
                    new d.b.h0.f.f.e.c(download, a.this.f48479e).c(new C0973a(valueOf, download));
                } else if (i == 2) {
                    a.this.f48475a.b(valueOf, new d.b.h0.f.f.g.a(31015, "download is canceled"));
                    a.this.v(valueOf);
                } else if (i != 3) {
                } else {
                    a.this.f48475a.b(valueOf, new d.b.h0.f.f.g.a(download.getFailedType().intValue(), TextUtils.isEmpty(download.getFailedReason()) ? "download is failed" : download.getFailedReason()));
                    a.this.v(valueOf);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d extends BroadcastReceiver {
        public d() {
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
            if (a.f48473f) {
                Log.d("GameCenterAppManager", "AddPackageReceiver packageName = " + schemeSpecificPart);
            }
            a.this.m(schemeSpecificPart);
            a.this.f48476b.b(schemeSpecificPart, new d.b.h0.f.f.g.c((String) null));
            a.this.u(schemeSpecificPart, null);
        }
    }

    /* loaded from: classes3.dex */
    public static /* synthetic */ class e {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f48487a;

        static {
            int[] iArr = new int[Download.DownloadState.values().length];
            f48487a = iArr;
            try {
                iArr[Download.DownloadState.FINISH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f48487a[Download.DownloadState.CANCEL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f48487a[Download.DownloadState.FAILED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements d.b.h0.f.f.f.b {
        public f(a aVar) {
        }

        @Override // d.b.h0.f.f.f.b
        public void a(d.b.h0.f.f.g.b bVar) {
        }
    }

    public a() {
        DownloadManager downloadManager = DownloadManager.getInstance(AppRuntime.getAppContext());
        this.f48477c = downloadManager;
        d.b.h0.f.f.d.c cVar = new d.b.h0.f.f.d.c(downloadManager);
        this.f48478d = cVar;
        cVar.e();
        this.f48478d.l();
        t();
        s();
        if (f48473f) {
            this.f48477c.registerOnProgressChangeListener(new C0972a(this));
        }
    }

    public static a l() {
        if (f48474g == null) {
            synchronized (a.class) {
                if (f48474g == null) {
                    f48474g = new a();
                }
            }
        }
        return f48474g;
    }

    public final boolean h() {
        return !ProcessUtils.isMainProcess();
    }

    public synchronized void i() {
        this.f48478d.d();
    }

    public boolean j(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        if (file.isFile() && file.exists()) {
            try {
                return file.delete();
            } catch (SecurityException e2) {
                if (f48473f) {
                    e2.printStackTrace();
                }
            }
        }
        return false;
    }

    public void k(String str, @NonNull d.b.h0.f.f.f.b bVar) {
        if (h()) {
            bVar.a(new d.b.h0.f.f.g.a(31006, "is not in main process"));
        } else if (TextUtils.isEmpty(str)) {
            bVar.a(new d.b.h0.f.f.g.a(31007, "invalid params"));
        } else {
            Collection<Download> o = this.f48478d.o(str);
            if (o != null && !o.isEmpty()) {
                this.f48478d.h(o);
                bVar.a(new d.b.h0.f.f.g.c(o));
                return;
            }
            bVar.a(new d.b.h0.f.f.g.a(31008, "download is not exist"));
        }
    }

    public final void m(String str) {
        if (this.f48478d.c(str)) {
            d.b.h0.f.f.h.c.a(str, "installApp", "success", null, new d.b.h0.f.f.h.a(this.f48479e));
        }
    }

    public String n(String str, @NonNull d.b.h0.f.f.f.a aVar) {
        if (h()) {
            aVar.a(new d.b.h0.f.f.g.a(31006, "is not in main process"));
            return null;
        } else if (TextUtils.isEmpty(str)) {
            aVar.a(new d.b.h0.f.f.g.a(31007, "invalid params"));
            return null;
        } else {
            Download p = this.f48478d.p(str);
            if (p == null) {
                aVar.a(new d.b.h0.f.f.g.a(31008, "download is not exist"));
                return null;
            }
            if (p.getCurrentbytes().longValue() < p.getTotalbytes().longValue()) {
                aVar.a(new d.b.h0.f.f.g.a(31017, "download is not finished"));
            }
            String realDownloadDir = p.getRealDownloadDir();
            String fileName = p.getFileName();
            String keyByUser = p.getKeyByUser();
            if (f48473f) {
                Log.d("GameCenterAppManager", "installApp packageName:" + keyByUser + ",fileDir:" + realDownloadDir + ",fileName:" + fileName);
            }
            if (TextUtils.isEmpty(keyByUser) || TextUtils.isEmpty(realDownloadDir) || TextUtils.isEmpty(fileName)) {
                aVar.a(new d.b.h0.f.f.g.a(31001, "database no package or file name"));
                this.f48478d.g(str);
            }
            String str2 = realDownloadDir + File.separator + fileName;
            if (d.b.h0.f.f.e.a.g(AppRuntime.getAppContext(), keyByUser)) {
                m(keyByUser);
                aVar.a(new d.b.h0.f.f.g.c("apk is already installed"));
                j(str2);
                return null;
            }
            File file = new File(str2);
            if (file.isFile() && file.exists()) {
                aVar.setPackageName(keyByUser);
                aVar.b(str2);
                this.f48476b.a(keyByUser, aVar);
                if (!d.b.h0.f.f.e.a.i(str2)) {
                    u(keyByUser, aVar);
                    aVar.a(new d.b.h0.f.f.g.a(31004, "apk install fail"));
                    this.f48478d.g(str);
                } else {
                    long length = ((file.length() / DownloadStrategy.FOUR_CONNECTION_UPPER_LIMIT) + 1) * 1000;
                    String c2 = d.b.h0.f.f.e.a.c();
                    if (d.b.h0.f.f.e.a.k(c2)) {
                        d.b.h0.a.r1.d.g().postDelayed(new b(c2, keyByUser), length);
                    }
                }
                return keyByUser;
            }
            aVar.a(new d.b.h0.f.f.g.a(31002, "file is not exist"));
            this.f48478d.g(str);
            return null;
        }
    }

    public void o() {
        this.f48478d.l();
    }

    public void p(String str, @NonNull d.b.h0.f.f.f.b bVar) {
        if (h()) {
            bVar.a(new d.b.h0.f.f.g.a(31006, "is not in main process"));
        } else if (TextUtils.isEmpty(str)) {
            bVar.a(new d.b.h0.f.f.g.a(31007, "invalid params"));
        } else {
            Download p = this.f48478d.p(str);
            if (p == null) {
                bVar.a(new d.b.h0.f.f.g.a(31008, "download is not exist"));
            } else if (p.getState() != Download.DownloadState.WAITING && p.getState() != Download.DownloadState.DOWNLOADING) {
                bVar.a(new d.b.h0.f.f.g.a(31013, "download is not started"));
            } else {
                this.f48477c.pause(p.getId().longValue());
                bVar.a(new d.b.h0.f.f.g.c(p));
            }
        }
    }

    public void q(@NonNull d.b.h0.f.f.f.b bVar) {
        if (h()) {
            bVar.a(new d.b.h0.f.f.g.a(31006, "is not in main process"));
            return;
        }
        Collection<Download> m = this.f48478d.m();
        if (m != null && !m.isEmpty()) {
            bVar.a(new d.b.h0.f.f.g.c(m));
        } else {
            bVar.a(new d.b.h0.f.f.g.a(31008, "download is not exist"));
        }
    }

    public void r(String str, @NonNull d.b.h0.f.f.f.b bVar) {
        if (h()) {
            bVar.a(new d.b.h0.f.f.g.a(31006, "is not in main process"));
        } else if (TextUtils.isEmpty(str)) {
            bVar.a(new d.b.h0.f.f.g.a(31007, "invalid params"));
        } else {
            Download p = this.f48478d.p(str);
            if (p == null) {
                bVar.a(new d.b.h0.f.f.g.a(31008, "download is not exist"));
            } else {
                bVar.a(new d.b.h0.f.f.g.c(p));
            }
        }
    }

    public final synchronized void s() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addDataScheme("package");
        intentFilter.addAction(PackageChangedReceiver.ACTION_INSTALL);
        AppRuntime.getAppContext().registerReceiver(new d(), intentFilter);
    }

    public final void t() {
        this.f48477c.registerOnStateChangeListener(new c());
    }

    public void u(String str, d.b.h0.f.f.f.b bVar) {
        this.f48476b.g(str, bVar);
    }

    public final void v(String str) {
        this.f48475a.f(str);
    }

    public void w() {
        Collection<Download> q = this.f48478d.q();
        if (q == null || q.isEmpty()) {
            return;
        }
        for (Download download : q) {
            this.f48475a.a(String.valueOf(download.getId()), new f(this));
            d.b.h0.f.f.h.c.a(download.getKeyByUser(), "resumeAllDownload", "success", null, new d.b.h0.f.f.h.a(this.f48479e));
        }
    }

    public void x(String str, @NonNull d.b.h0.f.f.f.b bVar) {
        if (h()) {
            bVar.a(new d.b.h0.f.f.g.a(31006, "is not in main process"));
        } else if (!SwanAppNetworkUtils.h(null)) {
            bVar.a(new d.b.h0.f.f.g.a(31014, "network is not connected"));
        } else if (TextUtils.isEmpty(str)) {
            bVar.a(new d.b.h0.f.f.g.a(31007, "invalid params"));
        } else {
            Download p = this.f48478d.p(str);
            if (p == null) {
                bVar.a(new d.b.h0.f.f.g.a(31008, "download is not exist"));
            } else if (p.getState() == Download.DownloadState.FINISH) {
                bVar.a(new d.b.h0.f.f.g.a(31012, "download is finished"));
            } else {
                this.f48475a.a(String.valueOf(p.getId()), bVar);
                this.f48477c.resume(p.getId().longValue());
            }
        }
    }

    public void y(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.f48479e = jSONObject;
        }
    }

    public void z(String str, String str2, String str3, @NonNull d.b.h0.f.f.f.b bVar) {
        if (h()) {
            bVar.a(new d.b.h0.f.f.g.a(31006, "is not in main process"));
        } else if (!SwanAppNetworkUtils.h(null)) {
            bVar.a(new d.b.h0.f.f.g.a(31014, "network is not connected"));
        } else if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (d.b.h0.f.f.e.a.g(AppRuntime.getAppContext(), str2)) {
                bVar.a(new d.b.h0.f.f.g.a(31005, "apk is already installed"));
                return;
            }
            this.f48478d.g(str);
            d.b.h0.f.f.d.a aVar = new d.b.h0.f.f.d.a();
            aVar.g(str);
            aVar.f(str2);
            aVar.a(str3);
            Download b2 = aVar.b();
            this.f48477c.start(b2);
            if (b2.getId() != null) {
                this.f48475a.a(String.valueOf(b2.getId()), bVar);
            }
        } else {
            bVar.a(new d.b.h0.f.f.g.a(31007, "invalid params"));
        }
    }
}
