package d.b.g0.f.f;

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
import d.b.g0.a.k;
import d.b.g0.a.z0.g;
import java.io.File;
import java.util.Collection;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f48144f = k.f45443a;

    /* renamed from: g  reason: collision with root package name */
    public static volatile a f48145g;

    /* renamed from: a  reason: collision with root package name */
    public d.b.g0.f.f.b f48146a = new d.b.g0.f.f.b();

    /* renamed from: b  reason: collision with root package name */
    public d.b.g0.f.f.b f48147b = new d.b.g0.f.f.b();

    /* renamed from: c  reason: collision with root package name */
    public DownloadManager f48148c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.g0.f.f.d.c f48149d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f48150e;

    /* renamed from: d.b.g0.f.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0952a implements DownloadManager.OnProgressChangeListener {
        public C0952a(a aVar) {
        }

        @Override // com.baidu.down.manage.DownloadManager.OnProgressChangeListener
        public void onProgressChanged(long j, int i, long j2) {
            Log.d("GameCenterAppManager", "onProgressChanged downloadId = " + j + ",percentage = " + i + ",speed = " + j2);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48151e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f48152f;

        public b(String str, String str2) {
            this.f48151e = str;
            this.f48152f = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (g.a().b()) {
                return;
            }
            if (a.f48144f) {
                Log.d("GameCenterAppManager", "start InstallAntiBlockingActivity");
            }
            Intent intent = new Intent(AppRuntime.getAppContext(), InstallAntiBlockingActivity.class);
            intent.putExtra("type", this.f48151e);
            intent.putExtra("packageName", this.f48152f);
            intent.putExtra(InstallAntiBlockingActivity.KEY_UBC_PARAMS, a.this.f48150e.toString());
            intent.setFlags(276824064);
            d.b.g0.a.i2.e.f(AppRuntime.getAppContext(), intent);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements DownloadManager.OnStateChangeListener {

        /* renamed from: d.b.g0.f.f.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0953a implements d.b.g0.f.f.f.b {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f48155a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Download f48156b;

            public C0953a(String str, Download download) {
                this.f48155a = str;
                this.f48156b = download;
            }

            @Override // d.b.g0.f.f.f.b
            public void a(d.b.g0.f.f.g.b bVar) {
                if (bVar != null) {
                    if (bVar.d()) {
                        a.this.f48146a.b(this.f48155a, new d.b.g0.f.f.g.c(this.f48156b));
                    } else {
                        a.this.f48146a.b(this.f48155a, bVar);
                    }
                }
                a.this.v(this.f48155a);
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
            if (a.f48144f) {
                Log.d("GameCenterAppManager", "onStateChanged downloadId = " + j + ",eventType:" + valueOf + ",download = " + download);
            }
            if (download.getState() == Download.DownloadState.FINISH) {
                d.b.g0.f.f.h.c.a(download.getKeyByUser(), "startDownload", "success", null, new d.b.g0.f.f.h.a(a.this.f48150e));
            }
            if (a.this.f48146a.d(valueOf)) {
                int i = e.f48158a[download.getState().ordinal()];
                if (i == 1) {
                    a.this.f48149d.f();
                    new d.b.g0.f.f.e.c(download, a.this.f48150e).c(new C0953a(valueOf, download));
                } else if (i == 2) {
                    a.this.f48146a.b(valueOf, new d.b.g0.f.f.g.a(31015, "download is canceled"));
                    a.this.v(valueOf);
                } else if (i != 3) {
                } else {
                    a.this.f48146a.b(valueOf, new d.b.g0.f.f.g.a(download.getFailedType().intValue(), TextUtils.isEmpty(download.getFailedReason()) ? "download is failed" : download.getFailedReason()));
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
            if (a.f48144f) {
                Log.d("GameCenterAppManager", "AddPackageReceiver packageName = " + schemeSpecificPart);
            }
            a.this.m(schemeSpecificPart);
            a.this.f48147b.b(schemeSpecificPart, new d.b.g0.f.f.g.c((String) null));
            a.this.u(schemeSpecificPart, null);
        }
    }

    /* loaded from: classes3.dex */
    public static /* synthetic */ class e {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f48158a;

        static {
            int[] iArr = new int[Download.DownloadState.values().length];
            f48158a = iArr;
            try {
                iArr[Download.DownloadState.FINISH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f48158a[Download.DownloadState.CANCEL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f48158a[Download.DownloadState.FAILED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements d.b.g0.f.f.f.b {
        public f(a aVar) {
        }

        @Override // d.b.g0.f.f.f.b
        public void a(d.b.g0.f.f.g.b bVar) {
        }
    }

    public a() {
        DownloadManager downloadManager = DownloadManager.getInstance(AppRuntime.getAppContext());
        this.f48148c = downloadManager;
        d.b.g0.f.f.d.c cVar = new d.b.g0.f.f.d.c(downloadManager);
        this.f48149d = cVar;
        cVar.e();
        this.f48149d.l();
        t();
        s();
        if (f48144f) {
            this.f48148c.registerOnProgressChangeListener(new C0952a(this));
        }
    }

    public static a l() {
        if (f48145g == null) {
            synchronized (a.class) {
                if (f48145g == null) {
                    f48145g = new a();
                }
            }
        }
        return f48145g;
    }

    public final boolean h() {
        return !ProcessUtils.isMainProcess();
    }

    public synchronized void i() {
        this.f48149d.d();
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
                if (f48144f) {
                    e2.printStackTrace();
                }
            }
        }
        return false;
    }

    public void k(String str, @NonNull d.b.g0.f.f.f.b bVar) {
        if (h()) {
            bVar.a(new d.b.g0.f.f.g.a(31006, "is not in main process"));
        } else if (TextUtils.isEmpty(str)) {
            bVar.a(new d.b.g0.f.f.g.a(31007, "invalid params"));
        } else {
            Collection<Download> o = this.f48149d.o(str);
            if (o != null && !o.isEmpty()) {
                this.f48149d.h(o);
                bVar.a(new d.b.g0.f.f.g.c(o));
                return;
            }
            bVar.a(new d.b.g0.f.f.g.a(31008, "download is not exist"));
        }
    }

    public final void m(String str) {
        if (this.f48149d.c(str)) {
            d.b.g0.f.f.h.c.a(str, "installApp", "success", null, new d.b.g0.f.f.h.a(this.f48150e));
        }
    }

    public String n(String str, @NonNull d.b.g0.f.f.f.a aVar) {
        if (h()) {
            aVar.a(new d.b.g0.f.f.g.a(31006, "is not in main process"));
            return null;
        } else if (TextUtils.isEmpty(str)) {
            aVar.a(new d.b.g0.f.f.g.a(31007, "invalid params"));
            return null;
        } else {
            Download p = this.f48149d.p(str);
            if (p == null) {
                aVar.a(new d.b.g0.f.f.g.a(31008, "download is not exist"));
                return null;
            }
            if (p.getCurrentbytes().longValue() < p.getTotalbytes().longValue()) {
                aVar.a(new d.b.g0.f.f.g.a(31017, "download is not finished"));
            }
            String realDownloadDir = p.getRealDownloadDir();
            String fileName = p.getFileName();
            String keyByUser = p.getKeyByUser();
            if (f48144f) {
                Log.d("GameCenterAppManager", "installApp packageName:" + keyByUser + ",fileDir:" + realDownloadDir + ",fileName:" + fileName);
            }
            if (TextUtils.isEmpty(keyByUser) || TextUtils.isEmpty(realDownloadDir) || TextUtils.isEmpty(fileName)) {
                aVar.a(new d.b.g0.f.f.g.a(31001, "database no package or file name"));
                this.f48149d.g(str);
            }
            String str2 = realDownloadDir + File.separator + fileName;
            if (d.b.g0.f.f.e.a.g(AppRuntime.getAppContext(), keyByUser)) {
                m(keyByUser);
                aVar.a(new d.b.g0.f.f.g.c("apk is already installed"));
                j(str2);
                return null;
            }
            File file = new File(str2);
            if (file.isFile() && file.exists()) {
                aVar.setPackageName(keyByUser);
                aVar.b(str2);
                this.f48147b.a(keyByUser, aVar);
                if (!d.b.g0.f.f.e.a.i(str2)) {
                    u(keyByUser, aVar);
                    aVar.a(new d.b.g0.f.f.g.a(31004, "apk install fail"));
                    this.f48149d.g(str);
                } else {
                    long length = ((file.length() / DownloadStrategy.FOUR_CONNECTION_UPPER_LIMIT) + 1) * 1000;
                    String c2 = d.b.g0.f.f.e.a.c();
                    if (d.b.g0.f.f.e.a.k(c2)) {
                        d.b.g0.a.r1.d.g().postDelayed(new b(c2, keyByUser), length);
                    }
                }
                return keyByUser;
            }
            aVar.a(new d.b.g0.f.f.g.a(31002, "file is not exist"));
            this.f48149d.g(str);
            return null;
        }
    }

    public void o() {
        this.f48149d.l();
    }

    public void p(String str, @NonNull d.b.g0.f.f.f.b bVar) {
        if (h()) {
            bVar.a(new d.b.g0.f.f.g.a(31006, "is not in main process"));
        } else if (TextUtils.isEmpty(str)) {
            bVar.a(new d.b.g0.f.f.g.a(31007, "invalid params"));
        } else {
            Download p = this.f48149d.p(str);
            if (p == null) {
                bVar.a(new d.b.g0.f.f.g.a(31008, "download is not exist"));
            } else if (p.getState() != Download.DownloadState.WAITING && p.getState() != Download.DownloadState.DOWNLOADING) {
                bVar.a(new d.b.g0.f.f.g.a(31013, "download is not started"));
            } else {
                this.f48148c.pause(p.getId().longValue());
                bVar.a(new d.b.g0.f.f.g.c(p));
            }
        }
    }

    public void q(@NonNull d.b.g0.f.f.f.b bVar) {
        if (h()) {
            bVar.a(new d.b.g0.f.f.g.a(31006, "is not in main process"));
            return;
        }
        Collection<Download> m = this.f48149d.m();
        if (m != null && !m.isEmpty()) {
            bVar.a(new d.b.g0.f.f.g.c(m));
        } else {
            bVar.a(new d.b.g0.f.f.g.a(31008, "download is not exist"));
        }
    }

    public void r(String str, @NonNull d.b.g0.f.f.f.b bVar) {
        if (h()) {
            bVar.a(new d.b.g0.f.f.g.a(31006, "is not in main process"));
        } else if (TextUtils.isEmpty(str)) {
            bVar.a(new d.b.g0.f.f.g.a(31007, "invalid params"));
        } else {
            Download p = this.f48149d.p(str);
            if (p == null) {
                bVar.a(new d.b.g0.f.f.g.a(31008, "download is not exist"));
            } else {
                bVar.a(new d.b.g0.f.f.g.c(p));
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
        this.f48148c.registerOnStateChangeListener(new c());
    }

    public void u(String str, d.b.g0.f.f.f.b bVar) {
        this.f48147b.g(str, bVar);
    }

    public final void v(String str) {
        this.f48146a.f(str);
    }

    public void w() {
        Collection<Download> q = this.f48149d.q();
        if (q == null || q.isEmpty()) {
            return;
        }
        for (Download download : q) {
            this.f48146a.a(String.valueOf(download.getId()), new f(this));
            d.b.g0.f.f.h.c.a(download.getKeyByUser(), "resumeAllDownload", "success", null, new d.b.g0.f.f.h.a(this.f48150e));
        }
    }

    public void x(String str, @NonNull d.b.g0.f.f.f.b bVar) {
        if (h()) {
            bVar.a(new d.b.g0.f.f.g.a(31006, "is not in main process"));
        } else if (!SwanAppNetworkUtils.h(null)) {
            bVar.a(new d.b.g0.f.f.g.a(31014, "network is not connected"));
        } else if (TextUtils.isEmpty(str)) {
            bVar.a(new d.b.g0.f.f.g.a(31007, "invalid params"));
        } else {
            Download p = this.f48149d.p(str);
            if (p == null) {
                bVar.a(new d.b.g0.f.f.g.a(31008, "download is not exist"));
            } else if (p.getState() == Download.DownloadState.FINISH) {
                bVar.a(new d.b.g0.f.f.g.a(31012, "download is finished"));
            } else {
                this.f48146a.a(String.valueOf(p.getId()), bVar);
                this.f48148c.resume(p.getId().longValue());
            }
        }
    }

    public void y(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.f48150e = jSONObject;
        }
    }

    public void z(String str, String str2, String str3, @NonNull d.b.g0.f.f.f.b bVar) {
        if (h()) {
            bVar.a(new d.b.g0.f.f.g.a(31006, "is not in main process"));
        } else if (!SwanAppNetworkUtils.h(null)) {
            bVar.a(new d.b.g0.f.f.g.a(31014, "network is not connected"));
        } else if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (d.b.g0.f.f.e.a.g(AppRuntime.getAppContext(), str2)) {
                bVar.a(new d.b.g0.f.f.g.a(31005, "apk is already installed"));
                return;
            }
            this.f48149d.g(str);
            d.b.g0.f.f.d.a aVar = new d.b.g0.f.f.d.a();
            aVar.g(str);
            aVar.f(str2);
            aVar.a(str3);
            Download b2 = aVar.b();
            this.f48148c.start(b2);
            if (b2.getId() != null) {
                this.f48146a.a(String.valueOf(b2.getId()), bVar);
            }
        } else {
            bVar.a(new d.b.g0.f.f.g.a(31007, "invalid params"));
        }
    }
}
