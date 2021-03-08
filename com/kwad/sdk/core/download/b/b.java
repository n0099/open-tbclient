package com.kwad.sdk.core.download.b;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.diskcache.ApkCacheManager;
import com.kwad.sdk.core.download.DOWNLOADSTAUS;
import com.kwad.sdk.core.download.DownloadParams;
import com.kwad.sdk.core.download.DownloadStatusManager;
import com.kwad.sdk.core.download.f;
import com.kwad.sdk.core.page.AdWebViewActivityProxy;
import com.kwad.sdk.core.report.b;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.export.proxy.AdDownloadProxy;
import com.kwad.sdk.utils.y;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b implements com.kwad.sdk.core.download.d {

    /* renamed from: a  reason: collision with root package name */
    private Handler f6058a;
    @NonNull
    private AdTemplate b;
    @NonNull
    private AdInfo c;
    private JSONObject d;
    private long e;
    private boolean f;
    private boolean g;
    private boolean h;
    private HashSet<KsAppDownloadListener> i;

    public b(@NonNull AdTemplate adTemplate) {
        this(adTemplate, null, null);
    }

    public b(@NonNull AdTemplate adTemplate, @NonNull KsAppDownloadListener ksAppDownloadListener) {
        this(adTemplate, null, ksAppDownloadListener);
    }

    public b(@NonNull AdTemplate adTemplate, JSONObject jSONObject) {
        this(adTemplate, jSONObject, null);
    }

    public b(@NonNull AdTemplate adTemplate, JSONObject jSONObject, KsAppDownloadListener ksAppDownloadListener) {
        this.f6058a = new Handler(Looper.getMainLooper());
        this.i = new HashSet<>();
        this.b = adTemplate;
        this.c = com.kwad.sdk.core.response.b.c.j(adTemplate);
        this.d = jSONObject;
        if (ksAppDownloadListener != null) {
            a(ksAppDownloadListener);
        }
        DownloadStatusManager.a().a(this, this.b);
        DownloadStatusManager.a().a(this.b);
        this.h = com.kwad.sdk.core.response.b.c.j(this.b).downloadSafeInfo.downloadPauseEnable;
    }

    public static void a(b bVar, boolean z) {
        if (bVar != null) {
            bVar.a(z);
        }
    }

    private void a(boolean z) {
        this.g = z;
    }

    private void b(Context context) {
        String str = this.c.adConversionInfo.marketUrl;
        com.kwad.sdk.core.d.a.b("ApkDownloadHelper", "Market URL Schema=" + str);
        if (TextUtils.isEmpty(str) ? false : com.kwad.sdk.utils.e.a(KsAdSDKImpl.get().getContext(), str, this.c.adBaseInfo.appPackageName)) {
            com.kwad.sdk.core.report.b.j(this.b);
        } else if (c(context)) {
        } else {
            j();
        }
    }

    private boolean c(Context context) {
        if (context == null || com.kwad.sdk.core.download.a.b.a() || this.c.status == DOWNLOADSTAUS.PAUSED || !com.kwad.sdk.core.download.a.b.b(context, this.b)) {
            return false;
        }
        return com.kwad.sdk.core.download.a.b.a(context, this.b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(@NonNull KsAppDownloadListener ksAppDownloadListener) {
        int i = this.c.progress;
        switch (this.c.status) {
            case UNKNOWN:
                ksAppDownloadListener.onIdle();
                return;
            case START:
                ksAppDownloadListener.onProgressUpdate(0);
                try {
                    ksAppDownloadListener.onDownloadStarted();
                    return;
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.a.b(th);
                    return;
                }
            case DOWNLOADING:
            case PROGRESS:
                ksAppDownloadListener.onProgressUpdate(i);
                return;
            case PAUSED:
                if (ksAppDownloadListener instanceof c) {
                    ((c) ksAppDownloadListener).a(i);
                    return;
                }
                return;
            case FAILED:
                ksAppDownloadListener.onDownloadFailed();
                return;
            case FINISHED:
            case INSTALL:
                ksAppDownloadListener.onDownloadFinished();
                return;
            case INSTALL_FINSHED:
                ksAppDownloadListener.onInstalled();
                return;
            default:
                return;
        }
    }

    private void g() {
        this.f6058a.post(new Runnable() { // from class: com.kwad.sdk.core.download.b.b.3
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = b.this.i.iterator();
                while (it.hasNext()) {
                    KsAppDownloadListener ksAppDownloadListener = (KsAppDownloadListener) it.next();
                    if (ksAppDownloadListener != null) {
                        b.this.d(ksAppDownloadListener);
                    }
                }
            }
        });
    }

    private void h() {
        AdDownloadProxy proxyForDownload;
        String str = this.c.adBaseInfo.appPackageName;
        Context context = KsAdSDKImpl.get().getContext();
        if (context == null) {
            return;
        }
        if (y.a(context, str)) {
            this.c.status = DOWNLOADSTAUS.INSTALL_FINSHED;
            return;
        }
        if (this.c.status == DOWNLOADSTAUS.INSTALL_FINSHED) {
            this.c.status = DOWNLOADSTAUS.UNKNOWN;
            this.c.progress = 0;
        }
        if (this.c.status == DOWNLOADSTAUS.FINISHED) {
            String str2 = this.c.downloadFilePath;
            if (TextUtils.isEmpty(str2) || !new File(str2).exists()) {
                this.c.status = DOWNLOADSTAUS.UNKNOWN;
                this.c.progress = 0;
            }
        }
        if (this.c.status != DOWNLOADSTAUS.UNKNOWN || (proxyForDownload = KsAdSDKImpl.get().getProxyForDownload()) == null) {
            return;
        }
        String downloadFilePath = proxyForDownload.getDownloadFilePath(DownloadParams.transfrom(this.c));
        if (TextUtils.isEmpty(downloadFilePath) || !new File(downloadFilePath).exists()) {
            return;
        }
        this.c.downloadFilePath = downloadFilePath;
        this.c.status = DOWNLOADSTAUS.FINISHED;
    }

    private boolean i() {
        String str = this.c.adConversionInfo.marketUrl;
        com.kwad.sdk.core.d.a.b("ApkDownloadHelper", "isMarKet URL Schema=" + str);
        boolean a2 = TextUtils.isEmpty(str) ? false : com.kwad.sdk.utils.e.a(KsAdSDKImpl.get().getContext(), str, this.c.adBaseInfo.appPackageName);
        if (a2) {
            com.kwad.sdk.core.report.b.j(this.b);
        }
        return a2;
    }

    private void j() {
        Context context = KsAdSDKImpl.get().getContext();
        if (context == null) {
            return;
        }
        if (com.ksad.download.d.b.a(context)) {
            com.kwad.sdk.core.download.e.a(context, this.c);
        } else {
            com.kwad.sdk.core.d.a.d("ApkDownloadHelper", "no network while download app");
        }
    }

    private void k() {
        Context context = KsAdSDKImpl.get().getContext();
        if (context == null) {
            return;
        }
        com.kwad.sdk.core.download.e.a(context, this.c.downloadId);
    }

    @Override // com.kwad.sdk.core.download.d
    public String a() {
        return this.c.downloadId;
    }

    public void a(int i) {
        this.b.downloadSource = i;
    }

    public void a(Context context) {
        this.f = false;
        h();
        switch (this.c.status) {
            case UNKNOWN:
            case START:
            case PAUSED:
            case FAILED:
            case CANCELLED:
            case DELETED:
                b(context);
                break;
            case DOWNLOADING:
            case PROGRESS:
                if (this.g && this.h) {
                    k();
                    break;
                }
                break;
            case FINISHED:
            case INSTALL:
            case INSTALL_FAILED:
                e();
                break;
            case INSTALL_FINSHED:
                d();
                break;
        }
        this.g = false;
    }

    @UiThread
    public void a(KsAppDownloadListener ksAppDownloadListener) {
        if (ksAppDownloadListener == null) {
            return;
        }
        this.i.add(ksAppDownloadListener);
        h();
        d(ksAppDownloadListener);
    }

    @Override // com.kwad.sdk.core.download.d
    public void a(String str) {
        this.c.status = DOWNLOADSTAUS.INSTALLING;
        g();
    }

    @Override // com.kwad.sdk.core.download.d
    public void a(String str, int i, int i2, int i3) {
        if (this.c.downloadId.equals(str)) {
            this.c.status = DOWNLOADSTAUS.PROGRESS;
            this.c.progress = i;
            this.c.soFarBytes = i2;
            this.c.totalBytes = i3;
            g();
        }
    }

    @Override // com.kwad.sdk.core.download.d
    public void a(String str, int i, f fVar) {
        if (fVar.b()) {
            com.kwad.sdk.core.report.b.d(this.b);
            fVar.a();
        }
        com.kwad.sdk.utils.f.a(new Runnable() { // from class: com.kwad.sdk.core.download.b.b.2
            @Override // java.lang.Runnable
            public void run() {
                com.kwad.sdk.home.download.a.a().b(b.this.b);
                com.kwad.sdk.home.download.a.a().c(b.this.b);
            }
        });
        com.kwad.sdk.core.a.a().d(com.kwad.sdk.core.response.b.c.j(this.b).downloadId);
        this.c.status = DOWNLOADSTAUS.INSTALL_FINSHED;
        g();
    }

    @Override // com.kwad.sdk.core.download.d
    public void a(String str, int i, String str2, f fVar) {
        if (this.c.downloadId.equals(str)) {
            this.c.status = DOWNLOADSTAUS.FAILED;
            g();
            if (fVar.b()) {
                b.a aVar = new b.a(i, str2);
                com.kwad.sdk.core.report.b.a(this.b, aVar);
                com.kwad.sdk.core.report.e.d(this.b, this.c.adConversionInfo.appDownloadUrl, aVar.toJson().toString());
                fVar.a();
            }
            if (this.c.adConversionInfo.retryH5TimeStep <= 0 || this.f || System.currentTimeMillis() - this.e >= this.c.adConversionInfo.retryH5TimeStep || TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.B(this.c))) {
                return;
            }
            AdWebViewActivityProxy.launch(KsAdSDKImpl.get().getContext(), this.b);
            this.f = true;
        }
    }

    @Override // com.kwad.sdk.core.download.d
    public void a(String str, f fVar) {
        if (this.c.downloadId.equals(str)) {
            if (this.c.status != DOWNLOADSTAUS.START) {
                if (fVar.b()) {
                    com.kwad.sdk.core.report.b.b(this.b);
                    fVar.a();
                }
                this.e = System.currentTimeMillis();
            }
            this.c.status = DOWNLOADSTAUS.START;
            g();
        }
    }

    @Override // com.kwad.sdk.core.download.d
    public void a(String str, String str2, f fVar) {
        if (this.c.downloadId.equals(str)) {
            this.c.downloadFilePath = str2;
            this.c.progress = 100;
            if (this.c.status != DOWNLOADSTAUS.FINISHED && !this.b.mDownloadFinishReported) {
                com.kwad.sdk.utils.f.a(new Runnable() { // from class: com.kwad.sdk.core.download.b.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.kwad.sdk.home.download.a.a().a(b.this.b);
                    }
                });
                if (fVar.b()) {
                    com.kwad.sdk.core.report.b.e(this.b, this.d);
                    fVar.a();
                }
                this.b.mDownloadFinishReported = true;
            }
            this.c.status = DOWNLOADSTAUS.FINISHED;
            g();
            ApkCacheManager.a().b();
        }
    }

    @Override // com.kwad.sdk.core.download.d
    public String b() {
        return this.c.adBaseInfo.appPackageName;
    }

    public void b(KsAppDownloadListener ksAppDownloadListener) {
        if (ksAppDownloadListener == null) {
            return;
        }
        this.i.remove(ksAppDownloadListener);
    }

    @Override // com.kwad.sdk.core.download.d
    public void b(String str) {
        if (this.c.downloadId.equals(str)) {
            this.c.status = DOWNLOADSTAUS.INSTALL_FAILED;
            g();
        }
    }

    @Override // com.kwad.sdk.core.download.d
    public void b(String str, f fVar) {
        if (this.c.downloadId.equals(str)) {
            if (this.c.status != DOWNLOADSTAUS.PAUSED && fVar.b()) {
                com.kwad.sdk.core.report.b.c(this.b, this.d);
                fVar.a();
            }
            this.c.status = DOWNLOADSTAUS.PAUSED;
            g();
        }
    }

    public void c(KsAppDownloadListener ksAppDownloadListener) {
        if (ksAppDownloadListener == null) {
            return;
        }
        h();
        d(ksAppDownloadListener);
    }

    @Override // com.kwad.sdk.core.download.d
    public void c(String str, f fVar) {
        if (this.c.downloadId.equals(str)) {
            if (this.c.status != DOWNLOADSTAUS.DOWNLOADING && fVar.b()) {
                com.kwad.sdk.core.report.b.d(this.b, this.d);
                fVar.a();
            }
            this.c.status = DOWNLOADSTAUS.DOWNLOADING;
            g();
        }
    }

    public boolean c() {
        switch (this.c.status) {
            case UNKNOWN:
            case START:
            case PAUSED:
            case FAILED:
            case CANCELLED:
            case DELETED:
                return i();
            case DOWNLOADING:
            case PROGRESS:
            default:
                return false;
            case FINISHED:
            case INSTALL:
            case INSTALL_FAILED:
                e();
                return true;
            case INSTALL_FINSHED:
                d();
                return true;
        }
    }

    public void d() {
        String str = this.c.adBaseInfo.appPackageName;
        Context context = KsAdSDKImpl.get().getContext();
        if (context == null || TextUtils.isEmpty(str)) {
            com.kwad.sdk.core.d.a.d("ApkDownloadHelper", "openApp fail appContext:" + context + "--appPkgName:" + str);
            return;
        }
        com.kwad.sdk.utils.f.a(new Runnable() { // from class: com.kwad.sdk.core.download.b.b.4
            @Override // java.lang.Runnable
            public void run() {
                com.kwad.sdk.home.download.a.a().d(b.this.b);
            }
        });
        com.kwad.sdk.core.report.b.f(this.b);
        y.b(context, str);
    }

    @Override // com.kwad.sdk.core.download.d
    public void d(String str, f fVar) {
        if (this.c.downloadId.equals(str)) {
            if (this.c.status != DOWNLOADSTAUS.CANCELLED && fVar.b()) {
                com.kwad.sdk.core.report.b.f(this.b, this.d);
                fVar.a();
            }
            this.c.status = DOWNLOADSTAUS.CANCELLED;
            g();
        }
    }

    public void e() {
        String str = this.c.downloadFilePath;
        Context context = KsAdSDKImpl.get().getContext();
        if (context == null || TextUtils.isEmpty(str)) {
            com.kwad.sdk.core.d.a.d("ApkDownloadHelper", "openApp fail appContext:" + context + "--filePath:" + str);
            return;
        }
        com.kwad.sdk.core.report.b.g(this.b);
        KsAdSDKImpl.get().getProxyForAdInstall().installApp(context, str);
    }

    @Override // com.kwad.sdk.core.download.d
    public void e(String str, f fVar) {
        if (this.c.downloadId.equals(str)) {
            if (fVar.b()) {
                com.kwad.sdk.core.report.b.g(this.b);
                fVar.a();
            }
            this.c.status = DOWNLOADSTAUS.INSTALL;
            g();
        }
    }

    public void f() {
        if (this.i != null) {
            this.i.clear();
        }
        DownloadStatusManager.a().a(this);
    }

    @Override // com.kwad.sdk.core.download.d
    public void f(String str, f fVar) {
        if (this.c.downloadId.equals(str)) {
            com.kwad.sdk.core.report.b.e(this.b);
        }
    }
}
