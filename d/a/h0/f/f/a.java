package d.a.h0.f.f;

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
import d.a.h0.a.k;
import d.a.h0.a.z0.g;
import java.io.File;
import java.util.Collection;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f45933f = k.f43101a;

    /* renamed from: g  reason: collision with root package name */
    public static volatile a f45934g;

    /* renamed from: a  reason: collision with root package name */
    public d.a.h0.f.f.b f45935a = new d.a.h0.f.f.b();

    /* renamed from: b  reason: collision with root package name */
    public d.a.h0.f.f.b f45936b = new d.a.h0.f.f.b();

    /* renamed from: c  reason: collision with root package name */
    public DownloadManager f45937c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.h0.f.f.d.c f45938d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f45939e;

    /* renamed from: d.a.h0.f.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0911a implements DownloadManager.OnProgressChangeListener {
        public C0911a(a aVar) {
        }

        @Override // com.baidu.down.manage.DownloadManager.OnProgressChangeListener
        public void onProgressChanged(long j, int i2, long j2) {
            Log.d("GameCenterAppManager", "onProgressChanged downloadId = " + j + ",percentage = " + i2 + ",speed = " + j2);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f45940e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f45941f;

        public b(String str, String str2) {
            this.f45940e = str;
            this.f45941f = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (g.a().b()) {
                return;
            }
            if (a.f45933f) {
                Log.d("GameCenterAppManager", "start InstallAntiBlockingActivity");
            }
            Intent intent = new Intent(AppRuntime.getAppContext(), InstallAntiBlockingActivity.class);
            intent.putExtra("type", this.f45940e);
            intent.putExtra("packageName", this.f45941f);
            intent.putExtra(InstallAntiBlockingActivity.KEY_UBC_PARAMS, a.this.f45939e.toString());
            intent.setFlags(276824064);
            d.a.h0.a.i2.e.f(AppRuntime.getAppContext(), intent);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements DownloadManager.OnStateChangeListener {

        /* renamed from: d.a.h0.f.f.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0912a implements d.a.h0.f.f.f.b {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f45944a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Download f45945b;

            public C0912a(String str, Download download) {
                this.f45944a = str;
                this.f45945b = download;
            }

            @Override // d.a.h0.f.f.f.b
            public void b(d.a.h0.f.f.g.b bVar) {
                if (bVar != null) {
                    if (bVar.d()) {
                        a.this.f45935a.b(this.f45944a, new d.a.h0.f.f.g.c(this.f45945b));
                    } else {
                        a.this.f45935a.b(this.f45944a, bVar);
                    }
                }
                a.this.v(this.f45944a);
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
            if (a.f45933f) {
                Log.d("GameCenterAppManager", "onStateChanged downloadId = " + j + ",eventType:" + valueOf + ",download = " + download);
            }
            if (download.getState() == Download.DownloadState.FINISH) {
                d.a.h0.f.f.h.c.a(download.getKeyByUser(), "startDownload", "success", null, new d.a.h0.f.f.h.a(a.this.f45939e));
            }
            if (a.this.f45935a.d(valueOf)) {
                int i2 = e.f45947a[download.getState().ordinal()];
                if (i2 == 1) {
                    a.this.f45938d.f();
                    new d.a.h0.f.f.e.c(download, a.this.f45939e).c(new C0912a(valueOf, download));
                } else if (i2 == 2) {
                    a.this.f45935a.b(valueOf, new d.a.h0.f.f.g.a(31015, "download is canceled"));
                    a.this.v(valueOf);
                } else if (i2 != 3) {
                } else {
                    a.this.f45935a.b(valueOf, new d.a.h0.f.f.g.a(download.getFailedType().intValue(), TextUtils.isEmpty(download.getFailedReason()) ? "download is failed" : download.getFailedReason()));
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
            if (a.f45933f) {
                Log.d("GameCenterAppManager", "AddPackageReceiver packageName = " + schemeSpecificPart);
            }
            a.this.m(schemeSpecificPart);
            a.this.f45936b.b(schemeSpecificPart, new d.a.h0.f.f.g.c((String) null));
            a.this.u(schemeSpecificPart, null);
        }
    }

    /* loaded from: classes3.dex */
    public static /* synthetic */ class e {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f45947a;

        static {
            int[] iArr = new int[Download.DownloadState.values().length];
            f45947a = iArr;
            try {
                iArr[Download.DownloadState.FINISH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f45947a[Download.DownloadState.CANCEL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f45947a[Download.DownloadState.FAILED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements d.a.h0.f.f.f.b {
        public f(a aVar) {
        }

        @Override // d.a.h0.f.f.f.b
        public void b(d.a.h0.f.f.g.b bVar) {
        }
    }

    public a() {
        DownloadManager downloadManager = DownloadManager.getInstance(AppRuntime.getAppContext());
        this.f45937c = downloadManager;
        d.a.h0.f.f.d.c cVar = new d.a.h0.f.f.d.c(downloadManager);
        this.f45938d = cVar;
        cVar.e();
        this.f45938d.l();
        t();
        s();
        if (f45933f) {
            this.f45937c.registerOnProgressChangeListener(new C0911a(this));
        }
    }

    public static a l() {
        if (f45934g == null) {
            synchronized (a.class) {
                if (f45934g == null) {
                    f45934g = new a();
                }
            }
        }
        return f45934g;
    }

    public final boolean h() {
        return !ProcessUtils.isMainProcess();
    }

    public synchronized void i() {
        this.f45938d.d();
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
                if (f45933f) {
                    e2.printStackTrace();
                }
            }
        }
        return false;
    }

    public void k(String str, @NonNull d.a.h0.f.f.f.b bVar) {
        if (h()) {
            bVar.b(new d.a.h0.f.f.g.a(31006, "is not in main process"));
        } else if (TextUtils.isEmpty(str)) {
            bVar.b(new d.a.h0.f.f.g.a(31007, "invalid params"));
        } else {
            Collection<Download> o = this.f45938d.o(str);
            if (o != null && !o.isEmpty()) {
                this.f45938d.h(o);
                bVar.b(new d.a.h0.f.f.g.c(o));
                return;
            }
            bVar.b(new d.a.h0.f.f.g.a(31008, "download is not exist"));
        }
    }

    public final void m(String str) {
        if (this.f45938d.c(str)) {
            d.a.h0.f.f.h.c.a(str, "installApp", "success", null, new d.a.h0.f.f.h.a(this.f45939e));
        }
    }

    public String n(String str, @NonNull d.a.h0.f.f.f.a aVar) {
        if (h()) {
            aVar.b(new d.a.h0.f.f.g.a(31006, "is not in main process"));
            return null;
        } else if (TextUtils.isEmpty(str)) {
            aVar.b(new d.a.h0.f.f.g.a(31007, "invalid params"));
            return null;
        } else {
            Download p = this.f45938d.p(str);
            if (p == null) {
                aVar.b(new d.a.h0.f.f.g.a(31008, "download is not exist"));
                return null;
            }
            if (p.getCurrentbytes().longValue() < p.getTotalbytes().longValue()) {
                aVar.b(new d.a.h0.f.f.g.a(31017, "download is not finished"));
            }
            String realDownloadDir = p.getRealDownloadDir();
            String fileName = p.getFileName();
            String keyByUser = p.getKeyByUser();
            if (f45933f) {
                Log.d("GameCenterAppManager", "installApp packageName:" + keyByUser + ",fileDir:" + realDownloadDir + ",fileName:" + fileName);
            }
            if (TextUtils.isEmpty(keyByUser) || TextUtils.isEmpty(realDownloadDir) || TextUtils.isEmpty(fileName)) {
                aVar.b(new d.a.h0.f.f.g.a(31001, "database no package or file name"));
                this.f45938d.g(str);
            }
            String str2 = realDownloadDir + File.separator + fileName;
            if (d.a.h0.f.f.e.a.g(AppRuntime.getAppContext(), keyByUser)) {
                m(keyByUser);
                aVar.b(new d.a.h0.f.f.g.c("apk is already installed"));
                j(str2);
                return null;
            }
            File file = new File(str2);
            if (file.isFile() && file.exists()) {
                aVar.setPackageName(keyByUser);
                aVar.a(str2);
                this.f45936b.a(keyByUser, aVar);
                if (!d.a.h0.f.f.e.a.i(str2)) {
                    u(keyByUser, aVar);
                    aVar.b(new d.a.h0.f.f.g.a(31004, "apk install fail"));
                    this.f45938d.g(str);
                } else {
                    long length = ((file.length() / DownloadStrategy.FOUR_CONNECTION_UPPER_LIMIT) + 1) * 1000;
                    String c2 = d.a.h0.f.f.e.a.c();
                    if (d.a.h0.f.f.e.a.k(c2)) {
                        d.a.h0.a.r1.d.g().postDelayed(new b(c2, keyByUser), length);
                    }
                }
                return keyByUser;
            }
            aVar.b(new d.a.h0.f.f.g.a(31002, "file is not exist"));
            this.f45938d.g(str);
            return null;
        }
    }

    public void o() {
        this.f45938d.l();
    }

    public void p(String str, @NonNull d.a.h0.f.f.f.b bVar) {
        if (h()) {
            bVar.b(new d.a.h0.f.f.g.a(31006, "is not in main process"));
        } else if (TextUtils.isEmpty(str)) {
            bVar.b(new d.a.h0.f.f.g.a(31007, "invalid params"));
        } else {
            Download p = this.f45938d.p(str);
            if (p == null) {
                bVar.b(new d.a.h0.f.f.g.a(31008, "download is not exist"));
            } else if (p.getState() != Download.DownloadState.WAITING && p.getState() != Download.DownloadState.DOWNLOADING) {
                bVar.b(new d.a.h0.f.f.g.a(31013, "download is not started"));
            } else {
                this.f45937c.pause(p.getId().longValue());
                bVar.b(new d.a.h0.f.f.g.c(p));
            }
        }
    }

    public void q(@NonNull d.a.h0.f.f.f.b bVar) {
        if (h()) {
            bVar.b(new d.a.h0.f.f.g.a(31006, "is not in main process"));
            return;
        }
        Collection<Download> m = this.f45938d.m();
        if (m != null && !m.isEmpty()) {
            bVar.b(new d.a.h0.f.f.g.c(m));
        } else {
            bVar.b(new d.a.h0.f.f.g.a(31008, "download is not exist"));
        }
    }

    public void r(String str, @NonNull d.a.h0.f.f.f.b bVar) {
        if (h()) {
            bVar.b(new d.a.h0.f.f.g.a(31006, "is not in main process"));
        } else if (TextUtils.isEmpty(str)) {
            bVar.b(new d.a.h0.f.f.g.a(31007, "invalid params"));
        } else {
            Download p = this.f45938d.p(str);
            if (p == null) {
                bVar.b(new d.a.h0.f.f.g.a(31008, "download is not exist"));
            } else {
                bVar.b(new d.a.h0.f.f.g.c(p));
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
        this.f45937c.registerOnStateChangeListener(new c());
    }

    public void u(String str, d.a.h0.f.f.f.b bVar) {
        this.f45936b.g(str, bVar);
    }

    public final void v(String str) {
        this.f45935a.f(str);
    }

    public void w() {
        Collection<Download> q = this.f45938d.q();
        if (q == null || q.isEmpty()) {
            return;
        }
        for (Download download : q) {
            this.f45935a.a(String.valueOf(download.getId()), new f(this));
            d.a.h0.f.f.h.c.a(download.getKeyByUser(), "resumeAllDownload", "success", null, new d.a.h0.f.f.h.a(this.f45939e));
        }
    }

    public void x(String str, @NonNull d.a.h0.f.f.f.b bVar) {
        if (h()) {
            bVar.b(new d.a.h0.f.f.g.a(31006, "is not in main process"));
        } else if (!SwanAppNetworkUtils.h(null)) {
            bVar.b(new d.a.h0.f.f.g.a(31014, "network is not connected"));
        } else if (TextUtils.isEmpty(str)) {
            bVar.b(new d.a.h0.f.f.g.a(31007, "invalid params"));
        } else {
            Download p = this.f45938d.p(str);
            if (p == null) {
                bVar.b(new d.a.h0.f.f.g.a(31008, "download is not exist"));
            } else if (p.getState() == Download.DownloadState.FINISH) {
                bVar.b(new d.a.h0.f.f.g.a(31012, "download is finished"));
            } else {
                this.f45935a.a(String.valueOf(p.getId()), bVar);
                this.f45937c.resume(p.getId().longValue());
            }
        }
    }

    public void y(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.f45939e = jSONObject;
        }
    }

    public void z(String str, String str2, String str3, @NonNull d.a.h0.f.f.f.b bVar) {
        if (h()) {
            bVar.b(new d.a.h0.f.f.g.a(31006, "is not in main process"));
        } else if (!SwanAppNetworkUtils.h(null)) {
            bVar.b(new d.a.h0.f.f.g.a(31014, "network is not connected"));
        } else if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (d.a.h0.f.f.e.a.g(AppRuntime.getAppContext(), str2)) {
                bVar.b(new d.a.h0.f.f.g.a(31005, "apk is already installed"));
                return;
            }
            this.f45938d.g(str);
            d.a.h0.f.f.d.a aVar = new d.a.h0.f.f.d.a();
            aVar.g(str);
            aVar.f(str2);
            aVar.a(str3);
            Download b2 = aVar.b();
            this.f45937c.start(b2);
            if (b2.getId() != null) {
                this.f45935a.a(String.valueOf(b2.getId()), bVar);
            }
        } else {
            bVar.b(new d.a.h0.f.f.g.a(31007, "invalid params"));
        }
    }
}
