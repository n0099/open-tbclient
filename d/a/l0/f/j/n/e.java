package d.a.l0.f.j.n;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.fastjson.asm.Label;
import com.baidu.down.manage.Download;
import com.baidu.down.manage.DownloadManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.game.ad.downloader.model.DownloadState;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.swan.game.guide.install.GameNowInstallAntiBlockingActivity;
import com.baidu.swan.game.guide.install.InstallActivity;
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
import com.baidu.tieba.service.AsInstallService;
import d.a.l0.a.k;
import d.a.l0.a.v2.w;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.zip.ZipFile;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e {
    public static volatile e l;

    /* renamed from: d  reason: collision with root package name */
    public DownloadManager f50586d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.l0.f.j.n.b f50587e;

    /* renamed from: f  reason: collision with root package name */
    public i f50588f;

    /* renamed from: g  reason: collision with root package name */
    public BroadcastReceiver f50589g;

    /* renamed from: h  reason: collision with root package name */
    public JSONObject f50590h;
    public int j;
    public static final boolean k = k.f46875a;
    public static ExecutorService m = Executors.newSingleThreadExecutor();

    /* renamed from: a  reason: collision with root package name */
    public d.a.l0.f.j.n.d f50583a = new d.a.l0.f.j.n.d();

    /* renamed from: b  reason: collision with root package name */
    public d.a.l0.f.j.n.d f50584b = new d.a.l0.f.j.n.d();

    /* renamed from: c  reason: collision with root package name */
    public d.a.l0.f.j.n.d f50585c = new d.a.l0.f.j.n.d();

    /* renamed from: i  reason: collision with root package name */
    public int f50591i = 0;

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f50592e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f50593f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f50594g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f50595h;

        public a(String str, String str2, String str3, String str4) {
            this.f50592e = str;
            this.f50593f = str2;
            this.f50594g = str3;
            this.f50595h = str4;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.l0.f.j.r.b.n().h(this.f50592e, new d.a.l0.f.j.r.a(e.this.f50590h), this.f50593f, this.f50594g, this.f50595h);
            if (d.a.l0.a.g1.g.a().b()) {
                return;
            }
            if (e.k) {
                Log.d("GameNowAppManager", "start InstallAntiBlockingActivity");
            }
            Intent intent = new Intent(AppRuntime.getAppContext(), GameNowInstallAntiBlockingActivity.class);
            intent.putExtra("type", this.f50592e);
            intent.putExtra("packageName", this.f50593f);
            if (e.this.f50590h != null) {
                intent.putExtra("ubc_params", e.this.f50590h.toString());
            }
            intent.setFlags(276824064);
            d.a.l0.a.v2.f.g(AppRuntime.getAppContext(), intent);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements DownloadManager.OnProgressChangeListener {
        public b() {
        }

        @Override // com.baidu.down.manage.DownloadManager.OnProgressChangeListener
        public void onProgressChanged(long j, int i2, long j2) {
            if (k.f46875a) {
                Log.d("GameNowAppManager", "onProgressChanged downloadId = " + j + ",percentage = " + i2 + ",speed = " + j2);
            }
            if (e.this.f50585c.d(String.valueOf(j))) {
                e.this.f50585c.b(String.valueOf(j), new h(i2));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements DownloadManager.OnStateChangeListener {
        public c() {
        }

        @Override // com.baidu.down.manage.DownloadManager.OnStateChangeListener
        public void onStateChanged(long j, Download download) {
            if (download == null || download.getId() == null) {
                return;
            }
            String valueOf = String.valueOf(download.getId());
            download.getKeyByUser();
            if (e.k) {
                Log.d("GameNowAppManager", "onStateChanged downloadId = " + j + ",eventType:" + valueOf + ",download = " + download);
            }
            if (e.this.f50583a.d(valueOf)) {
                e.this.f50583a.b(valueOf, new h(download));
                d.a.l0.f.j.n.a aVar = new d.a.l0.f.j.n.a(download);
                int i2 = C1049e.f50599a[download.getState().ordinal()];
                if (i2 == 1) {
                    d.a.l0.f.j.r.b.n().f("reallyPause", new d.a.l0.f.j.r.a(e.this.f50590h), aVar.k(), aVar.h(), aVar.j());
                } else if (i2 != 2) {
                    if (i2 != 3) {
                        return;
                    }
                    d.a.l0.f.j.r.b.n().h("reallyDownloadFail", new d.a.l0.f.j.r.a(e.this.f50590h), aVar.k(), aVar.h(), aVar.j());
                    e.this.E(valueOf);
                    e.this.D(valueOf);
                } else {
                    String h2 = aVar.h();
                    if (e.this.v(download)) {
                        e.this.J(download.getUrl(), download.getKeyByUser(), h2);
                        d.a.l0.f.j.r.b.n().f("reallyDownloaded", new d.a.l0.f.j.r.a(e.this.f50590h), aVar.k(), aVar.h(), aVar.j());
                        if (TextUtils.equals(aVar.k(), d.a.l0.f.j.m.c.f50548a)) {
                            d.a.l0.f.j.r.b.n().p(12, aVar.k(), aVar.f(), aVar.j());
                        }
                        e.this.E(valueOf);
                        e.this.D(valueOf);
                        return;
                    }
                    aVar.m("download_current_bytes", download.getCurrentbytes());
                    aVar.m("download_total_bytes", download.getTotalbytes());
                    d.a.l0.f.j.r.b.n().h("analysisFailed", new d.a.l0.f.j.r.a(e.this.f50590h), aVar.k(), aVar.h(), aVar.j());
                    String str = download.getRealDownloadDir() + File.separator + download.getFileName();
                    d.a.l0.f.j.r.b.n().q(1001, download.getKeyByUser(), download.getUrl(), e.this.j, (TextUtils.isEmpty(str) || !new File(str).exists()) ? "" : d.a.l0.t.f.b(new File(str), true), download.getCurrentbytes().longValue(), download.getTotalbytes().longValue());
                    d.a.l0.a.z1.b.f.e.g(d.a.l0.a.c1.a.b(), d.a.l0.a.c1.a.b().getString(d.a.l0.f.j.k.aiapps_gamenow_download_fail)).F();
                    e.this.r(download.getKeyByUser());
                    if (e.this.f50591i >= 2) {
                        e.this.E(valueOf);
                        e.this.D(valueOf);
                        return;
                    }
                    e.this.I(download.getUrl(), download.getKeyByUser(), download.getFromParam());
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
            if (e.k) {
                Log.d("GameNowAppManager", "AddPackageReceiver packageName = " + schemeSpecificPart);
            }
            if (e.this.f50584b.d(schemeSpecificPart)) {
                e.this.f50584b.b(schemeSpecificPart, new h(true));
                e.this.C(schemeSpecificPart, null);
            }
            Download d2 = e.this.f50587e.d(schemeSpecificPart);
            if (d2 != null) {
                d.a.l0.f.j.n.a aVar = new d.a.l0.f.j.n.a(d2);
                String f2 = aVar.f();
                if (TextUtils.equals(aVar.k(), d.a.l0.f.j.m.c.f50548a) || TextUtils.isEmpty(f2)) {
                    d.a.l0.f.j.r.b.n().h("reallyInstalled", new d.a.l0.f.j.r.a(e.this.f50590h), aVar.k(), aVar.h(), aVar.j());
                    e.this.m(d2);
                }
            }
        }
    }

    /* renamed from: d.a.l0.f.j.n.e$e  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class C1049e {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f50599a;

        static {
            int[] iArr = new int[Download.DownloadState.values().length];
            f50599a = iArr;
            try {
                iArr[Download.DownloadState.PAUSE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f50599a[Download.DownloadState.FINISH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f50599a[Download.DownloadState.FAILED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public e() {
        DownloadManager downloadManager = DownloadManager.getInstance(AppRuntime.getAppContext());
        this.f50586d = downloadManager;
        this.f50587e = new d.a.l0.f.j.n.b(downloadManager);
        A();
        B();
        z();
    }

    public static e s() {
        if (l == null) {
            synchronized (e.class) {
                if (l == null) {
                    l = new e();
                }
            }
        }
        return l;
    }

    public final void A() {
        this.f50586d.registerOnProgressChangeListener(new b());
    }

    public final void B() {
        this.f50586d.registerOnStateChangeListener(new c());
    }

    public void C(String str, d.a.l0.f.j.p.a aVar) {
        this.f50584b.g(str, aVar);
    }

    public void D(String str) {
        this.f50585c.f(str);
    }

    public final void E(String str) {
        this.f50583a.f(str);
    }

    public void F(String str, String str2, String str3) {
        if (n() || !SwanAppNetworkUtils.i(null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        Download d2 = this.f50587e.d(str2);
        if (d2 == null) {
            I(str, str2, str3);
        } else if (d2.getState() == Download.DownloadState.FINISH) {
            d.a.l0.f.j.r.b.n().h("resumeDownloadInstall", new d.a.l0.f.j.r.a(this.f50590h), str2, str3, str);
            J(str, str2, str3);
        } else {
            this.f50583a.a(String.valueOf(d2.getId()), this.f50588f);
            this.f50585c.a(String.valueOf(d2.getId()), this.f50588f);
            this.f50586d.resume(d2.getId().longValue());
        }
    }

    public void G(i iVar) {
        this.f50588f = iVar;
    }

    public void H(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.f50590h = jSONObject;
        }
    }

    public void I(String str, String str2, String str3) {
        if (n() || !SwanAppNetworkUtils.i(null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        if (d.a.l0.f.j.o.a.g(AppRuntime.getAppContext(), str2)) {
            i iVar = this.f50588f;
            if (iVar != null) {
                iVar.a(new h(true));
                return;
            }
            return;
        }
        this.f50587e.b(str2);
        d.a.l0.a.k2.g.h.a().putLong("startDownloadPackageTime", SystemClock.elapsedRealtime());
        JSONObject d2 = w.d(str3);
        String optString = d2.optString("apk_id");
        String optString2 = d2.optString("from_view");
        String optString3 = d2.optString("from_value");
        String optString4 = d2.optString(GameGuideConfigInfo.KEY_CONFIG_NAME);
        d.a.l0.f.j.n.a aVar = new d.a.l0.f.j.n.a();
        aVar.n(str);
        aVar.l(str2);
        aVar.a(optString);
        aVar.e(optString2);
        aVar.d(optString3);
        aVar.c(optString4);
        Download b2 = aVar.b();
        this.f50586d.start(b2);
        if (b2.getId() != null) {
            this.f50583a.a(String.valueOf(b2.getId()), this.f50588f);
            this.f50585c.a(String.valueOf(b2.getId()), this.f50588f);
        }
        if (TextUtils.equals(str2, d.a.l0.f.j.m.c.f50548a)) {
            d.a.l0.f.j.r.b.n().p(11, str2, optString, str);
        }
        d.a.l0.f.j.r.b.n().f("reallyBeginDownload", new d.a.l0.f.j.r.a(this.f50590h), str2, b2.getFromParam(), str);
    }

    public void J(String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        String l2 = l(str3, "download_finish_time", Long.valueOf(SystemClock.elapsedRealtime()));
        bundle.putString("key_download_url", str);
        bundle.putString("key_download_package_name", str2);
        bundle.putString("ubc_params", new d.a.l0.f.j.r.a(this.f50590h).a());
        bundle.putString("download_params", l2);
        Intent intent = new Intent(AppRuntime.getAppContext(), InstallActivity.class);
        intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        intent.putExtras(bundle);
        AppRuntime.getAppContext().startActivity(intent);
    }

    public final <T> String l(String str, String str2, T t) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                jSONObject.put(str2, t);
                return jSONObject.toString();
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return str;
    }

    public final void m(Download download) {
        String realDownloadDir = download.getRealDownloadDir();
        String fileName = download.getFileName();
        if (!TextUtils.isEmpty(realDownloadDir) && !TextUtils.isEmpty(fileName)) {
            q(realDownloadDir + File.separator + fileName);
        }
        p();
    }

    public final boolean n() {
        return !ProcessUtils.isMainProcess();
    }

    public void o(String str, String str2, long j) {
        if (n() || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        Download d2 = this.f50587e.d(str2);
        if (d2 != null) {
            d.a.l0.f.j.n.a aVar = new d.a.l0.f.j.n.a(d2);
            long i2 = aVar.i();
            aVar.m("download_status", d2.getState());
            String h2 = aVar.h();
            if (i2 != 0 && System.currentTimeMillis() - i2 > j) {
                r(str2);
                d.a.l0.f.j.r.b.n().h("package_expired", new d.a.l0.f.j.r.a(this.f50590h), str2, h2, str);
                return;
            }
            y(str2);
            return;
        }
        i iVar = this.f50588f;
        if (iVar != null) {
            iVar.a(new g(DownloadState.NOT_START.name()));
        }
    }

    public synchronized void p() {
        this.f50587e.a();
    }

    public boolean q(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        if (file.isFile() && file.exists()) {
            try {
                return file.delete();
            } catch (SecurityException e2) {
                if (k) {
                    e2.printStackTrace();
                }
            }
        }
        return false;
    }

    public void r(String str) {
        Download d2;
        if (n() || TextUtils.isEmpty(str) || (d2 = this.f50587e.d(str)) == null) {
            return;
        }
        this.f50587e.b(str);
        i iVar = this.f50588f;
        if (iVar != null) {
            iVar.a(new h(d2, true));
        }
    }

    public boolean t(Activity activity, String str, String str2, String str3) {
        if (n()) {
            d.a.l0.f.j.r.b.n().h("checkIllegalProcess", new d.a.l0.f.j.r.a(this.f50590h), str2, str3, str);
            return false;
        } else if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            Download d2 = this.f50587e.d(str2);
            if (d2 == null) {
                d.a.l0.f.j.r.b.n().h("nullDownload", new d.a.l0.f.j.r.a(this.f50590h), str2, str3, str);
                I(str, str2, str3);
                return false;
            }
            String realDownloadDir = d2.getRealDownloadDir();
            String fileName = d2.getFileName();
            if (k) {
                Log.d("GameNowAppManager", "installApp packageName:" + str2 + ",fileDir:" + realDownloadDir + ",fileName:" + fileName);
            }
            if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(realDownloadDir) || TextUtils.isEmpty(fileName)) {
                this.f50587e.b(str2);
            }
            String str4 = realDownloadDir + File.separator + fileName;
            if (d.a.l0.f.j.o.a.g(AppRuntime.getAppContext(), str2)) {
                d.a.l0.f.j.r.b.n().h("hasInstalled", new d.a.l0.f.j.r.a(this.f50590h), str2, str3, str);
                i iVar = this.f50588f;
                if (iVar != null) {
                    iVar.a(new h(true));
                }
                q(str4);
                return false;
            }
            File file = new File(str4);
            if (file.isFile() && file.exists()) {
                this.f50584b.a(str2, this.f50588f);
                if (d.a.l0.f.j.o.a.i(activity, str4, false)) {
                    new d.a.l0.f.j.n.a(d2).m("download_finish_time", Long.valueOf(SystemClock.elapsedRealtime()));
                    d.a.l0.f.j.r.b.n().h("showInstallView", new d.a.l0.f.j.r.a(this.f50590h), str2, str3, str);
                    long length = ((file.length() / 104857600) + 1) * 1000;
                    String c2 = d.a.l0.f.j.o.a.c();
                    if (d.a.l0.f.j.o.a.j(c2)) {
                        d.a.l0.a.a2.d.i().postDelayed(new a(c2, str2, str3, str), length);
                    }
                    return true;
                }
                d.a.l0.f.j.r.b.n().h("showInstallViewFailed", new d.a.l0.f.j.r.a(this.f50590h), str2, str3, str);
                C(str2, this.f50588f);
                this.f50587e.b(str2);
                return false;
            }
            d.a.l0.f.j.r.b.n().h("nullGamenowFile", new d.a.l0.f.j.r.a(this.f50590h), str2, str3, str);
            I(str, str2, str3);
            return false;
        } else {
            d.a.l0.f.j.r.b.n().h("nullPackagenameOrUrl", new d.a.l0.f.j.r.a(this.f50590h), str2, str3, str);
            return false;
        }
    }

    public boolean u(String str, long j) {
        if (new File(str).length() < j) {
            this.j = 3;
            return false;
        }
        try {
            ZipFile zipFile = new ZipFile(str);
            boolean z = zipFile.getEntry("AndroidManifest.xml") != null;
            zipFile.close();
            return z;
        } catch (Exception e2) {
            if (k) {
                Log.e("GameNowAppManager", "解析APK出错:" + e2.getMessage());
            }
            this.j = 4;
            return false;
        }
    }

    public final boolean v(Download download) {
        this.f50591i++;
        long longValue = download.getTotalbytes().longValue();
        String str = download.getRealDownloadDir() + File.separator + download.getFileName();
        if (!TextUtils.isEmpty(str) && new File(str).exists()) {
            if (((int) (longValue / 1024)) <= 10) {
                this.j = 2;
                return false;
            }
            return u(str, longValue);
        }
        if (k) {
            Log.e("GameNowAppManager", "apk文件找不到");
        }
        this.j = 1;
        return false;
    }

    public void w(String str, String str2) {
        if (n() || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        Download d2 = this.f50587e.d(str2);
        String fromParam = d2 != null ? d2.getFromParam() : "";
        if (d.a.l0.f.j.o.a.k(AppRuntime.getAppContext(), str2)) {
            d.a.l0.f.j.r.b.n().h("manualOpen", new d.a.l0.f.j.r.a(this.f50590h), str2, fromParam, str);
        }
    }

    public void x(String str) {
        Download d2;
        if (n() || TextUtils.isEmpty(str) || (d2 = this.f50587e.d(str)) == null) {
            return;
        }
        if (d2.getState() == Download.DownloadState.WAITING || d2.getState() == Download.DownloadState.DOWNLOADING) {
            this.f50586d.pause(d2.getId().longValue());
            i iVar = this.f50588f;
            if (iVar != null) {
                iVar.a(new h(d2));
            }
        }
    }

    public void y(String str) {
        Download d2;
        i iVar;
        if (n() || TextUtils.isEmpty(str) || (d2 = this.f50587e.d(str)) == null || (iVar = this.f50588f) == null) {
            return;
        }
        iVar.a(new h(d2));
    }

    public final synchronized void z() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addDataScheme(AsInstallService.SCHEME_PACKAGE_ADDED);
        intentFilter.addAction(PackageChangedReceiver.ACTION_INSTALL);
        this.f50589g = new d();
        AppRuntime.getAppContext().registerReceiver(this.f50589g, intentFilter);
    }
}
