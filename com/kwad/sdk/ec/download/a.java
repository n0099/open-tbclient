package com.kwad.sdk.ec.download;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ksad.download.c.b;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.diskcache.ApkCacheManager;
import com.kwad.sdk.core.download.DownloadParams;
import com.kwad.sdk.core.download.DownloadStatusManager;
import com.kwad.sdk.core.download.c;
import com.kwad.sdk.core.download.f;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.export.proxy.AdDownloadProxy;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.an;
import com.kwad.sdk.utils.i;
import java.io.File;
/* loaded from: classes8.dex */
public class a implements c {
    public String a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final AdTemplate f55339b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final AdInfo f55340c;

    /* renamed from: d  reason: collision with root package name */
    public KsAppDownloadListener f55341d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f55342e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f55343f;

    public a(@NonNull AdTemplate adTemplate, KsAppDownloadListener ksAppDownloadListener) {
        this.f55339b = adTemplate;
        this.f55340c = d.j(adTemplate);
        DownloadStatusManager.a().a(this, this.f55339b);
        DownloadStatusManager.a().a(this.f55339b);
        this.f55343f = d.j(this.f55339b).downloadSafeInfo.downloadPauseEnable;
        this.f55341d = ksAppDownloadListener;
    }

    private int b(Context context) {
        h();
        return 1;
    }

    private void f() {
        KsAppDownloadListener ksAppDownloadListener = this.f55341d;
        if (ksAppDownloadListener == null) {
            return;
        }
        AdInfo adInfo = this.f55340c;
        int i2 = adInfo.progress;
        int i3 = adInfo.status;
        if (i3 == 0) {
            ksAppDownloadListener.onIdle();
        } else if (i3 == 1) {
            ksAppDownloadListener.onProgressUpdate(0);
            if (ksAppDownloadListener instanceof com.kwad.sdk.core.download.a.c) {
                ((com.kwad.sdk.core.download.a.c) ksAppDownloadListener).onDownloadStarted();
                return;
            }
            try {
                ksAppDownloadListener.onDownloadStarted();
            } catch (Throwable th) {
                com.kwad.sdk.core.d.a.b(th);
            }
        } else if (i3 == 2 || i3 == 3) {
            ksAppDownloadListener.onProgressUpdate(i2);
        } else if (i3 == 4) {
            if (ksAppDownloadListener instanceof com.kwad.sdk.core.download.a.c) {
                ((com.kwad.sdk.core.download.a.c) ksAppDownloadListener).a(i2);
            }
        } else if (i3 == 7) {
            ksAppDownloadListener.onDownloadFailed();
        } else if (i3 == 8 || i3 == 9) {
            ksAppDownloadListener.onDownloadFinished();
        } else if (i3 != 12) {
        } else {
            ksAppDownloadListener.onInstalled();
        }
    }

    private void g() {
        AdDownloadProxy proxyForDownload;
        String str = this.f55340c.adBaseInfo.appPackageName;
        Context context = KsAdSDKImpl.get().getContext();
        if (context == null) {
            return;
        }
        if (ag.a(context, str)) {
            this.f55340c.status = 12;
            return;
        }
        AdInfo adInfo = this.f55340c;
        if (adInfo.status == 12) {
            adInfo.status = 0;
            adInfo.progress = 0;
        }
        AdInfo adInfo2 = this.f55340c;
        if (adInfo2.status == 8) {
            String str2 = adInfo2.downloadFilePath;
            if (TextUtils.isEmpty(str2) || !new File(str2).exists()) {
                AdInfo adInfo3 = this.f55340c;
                adInfo3.status = 0;
                adInfo3.progress = 0;
            }
        }
        if (this.f55340c.status != 0 || (proxyForDownload = KsAdSDKImpl.get().getProxyForDownload()) == null) {
            return;
        }
        String downloadFilePath = proxyForDownload.getDownloadFilePath(DownloadParams.transform(this.f55340c));
        if (TextUtils.isEmpty(downloadFilePath) || !new File(downloadFilePath).exists()) {
            return;
        }
        AdInfo adInfo4 = this.f55340c;
        adInfo4.downloadFilePath = downloadFilePath;
        adInfo4.status = 8;
    }

    private void h() {
        Context context = KsAdSDKImpl.get().getContext();
        if (context == null) {
            return;
        }
        if (b.a(context)) {
            com.kwad.sdk.core.download.d.a(context, this.f55340c, Build.VERSION.SDK_INT >= 26 && an.a());
        } else {
            com.kwad.sdk.core.d.a.e("ApkDownloadHelper", "no network while download app");
        }
    }

    private void i() {
        Context context = KsAdSDKImpl.get().getContext();
        if (context == null) {
            return;
        }
        com.kwad.sdk.core.download.d.a(context, this.f55340c.downloadId);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public int a(Context context) {
        int i2;
        g();
        switch (this.f55340c.status) {
            case 0:
            case 1:
            case 4:
            case 5:
            case 6:
            case 7:
                i2 = b(context);
                break;
            case 2:
            case 3:
                if (!this.f55342e || !this.f55343f) {
                    i2 = 1;
                    break;
                } else {
                    i();
                    i2 = 0;
                    break;
                }
                break;
            case 8:
            case 9:
            case 11:
                d();
                i2 = 0;
                break;
            case 10:
            default:
                i2 = 0;
                break;
            case 12:
                c();
                i2 = 0;
                break;
        }
        this.f55342e = false;
        return i2;
    }

    @Override // com.kwad.sdk.core.download.c
    public String a() {
        return this.f55340c.downloadId;
    }

    @Override // com.kwad.sdk.core.download.c
    public void a(String str, int i2, int i3, int i4) {
        if (this.f55340c.downloadId.equals(str)) {
            AdInfo adInfo = this.f55340c;
            adInfo.status = 3;
            adInfo.progress = i2;
            adInfo.soFarBytes = i3;
            adInfo.totalBytes = i4;
            f();
        }
    }

    @Override // com.kwad.sdk.core.download.c
    public void a(String str, int i2, f fVar) {
        i.a(new Runnable() { // from class: com.kwad.sdk.ec.download.a.1
            @Override // java.lang.Runnable
            public void run() {
                com.kwad.sdk.home.download.a.a().b(a.this.f55339b);
                com.kwad.sdk.home.download.a.a().c(a.this.f55339b);
            }
        });
        com.kwad.sdk.core.a.a().d(d.j(this.f55339b).downloadId);
        this.f55340c.status = 12;
        f();
    }

    @Override // com.kwad.sdk.core.download.c
    public void a(String str, int i2, String str2, f fVar) {
        if (this.f55340c.downloadId.equals(str)) {
            this.f55340c.status = 7;
            this.a = str2;
            f();
        }
    }

    @Override // com.kwad.sdk.core.download.c
    public void a(String str, f fVar) {
        if (this.f55340c.downloadId.equals(str)) {
            AdInfo adInfo = this.f55340c;
            if (adInfo.status != 1) {
                adInfo.status = 1;
            }
            f();
        }
    }

    @Override // com.kwad.sdk.core.download.c
    public void a(String str, String str2, f fVar) {
        if (this.f55340c.downloadId.equals(str)) {
            AdInfo adInfo = this.f55340c;
            adInfo.downloadFilePath = str2;
            adInfo.progress = 100;
            adInfo.status = 8;
            ApkCacheManager.a().b();
            f();
        }
    }

    public boolean a(Context context, String str) {
        if (Build.VERSION.SDK_INT >= 26) {
            boolean canRequestPackageInstalls = context.getPackageManager().canRequestPackageInstalls();
            if (KsAdSDKImpl.get().isEnableInstallPermission() && !canRequestPackageInstalls && an.a()) {
                Intent intent = new Intent("intent.action.requestInstallPermission");
                intent.putExtra("needAllowDialog", true);
                intent.putExtra("filePath", str);
                intent.addFlags(268435456);
                context.startActivity(intent);
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // com.kwad.sdk.core.download.c
    public String b() {
        return this.f55340c.adBaseInfo.appPackageName;
    }

    @Override // com.kwad.sdk.core.download.c
    public void b(String str, f fVar) {
        if (this.f55340c.downloadId.equals(str)) {
            this.f55340c.status = 4;
            f();
        }
    }

    public void c() {
        i.a(new Runnable() { // from class: com.kwad.sdk.ec.download.a.2
            @Override // java.lang.Runnable
            public void run() {
                com.kwad.sdk.home.download.a.a().d(a.this.f55339b);
            }
        });
        if (ag.c(KsAdSDKImpl.get().getContext(), com.kwad.sdk.core.response.a.a.v(this.f55340c))) {
            com.kwad.sdk.core.report.a.e(this.f55339b);
        }
    }

    @Override // com.kwad.sdk.core.download.c
    public void c(String str, f fVar) {
        if (this.f55340c.downloadId.equals(str)) {
            this.f55340c.status = 2;
            f();
        }
    }

    public void d() {
        String str = this.f55340c.downloadFilePath;
        Context context = KsAdSDKImpl.get().getContext();
        if (context != null && !TextUtils.isEmpty(str)) {
            if (a(context, str)) {
                return;
            }
            KsAdSDKImpl.get().getProxyForAdInstall().installApp(context, str);
            return;
        }
        com.kwad.sdk.core.d.a.e("ApkDownloadHelper", "openApp fail appContext:" + context + "--filePath:" + str);
    }

    @Override // com.kwad.sdk.core.download.c
    public void d(String str, f fVar) {
        if (this.f55340c.downloadId.equals(str)) {
            this.f55340c.status = 5;
            f();
        }
    }

    public void e() {
        this.f55341d = null;
        DownloadStatusManager.a().a(this);
    }

    @Override // com.kwad.sdk.core.download.c
    public void e(String str, f fVar) {
    }
}
