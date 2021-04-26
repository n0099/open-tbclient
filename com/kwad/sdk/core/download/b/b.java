package com.kwad.sdk.core.download.b;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.diskcache.ApkCacheManager;
import com.kwad.sdk.core.download.DownloadParams;
import com.kwad.sdk.core.download.DownloadStatusManager;
import com.kwad.sdk.core.download.f;
import com.kwad.sdk.core.page.AdLandPageActivityProxy;
import com.kwad.sdk.core.page.AdWebViewActivityProxy;
import com.kwad.sdk.core.report.b;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.export.proxy.AdDownloadProxy;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.w;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b implements com.kwad.sdk.core.download.d {

    /* renamed from: a  reason: collision with root package name */
    public Handler f32980a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public AdTemplate f32981b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public AdInfo f32982c;

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f32983d;

    /* renamed from: e  reason: collision with root package name */
    public long f32984e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f32985f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f32986g;

    /* renamed from: h  reason: collision with root package name */
    public a f32987h;

    /* renamed from: i  reason: collision with root package name */
    public List<KsAppDownloadListener> f32988i;

    /* loaded from: classes6.dex */
    public interface a {
        boolean a(DialogInterface.OnClickListener onClickListener);
    }

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
        this.f32980a = new Handler(Looper.getMainLooper());
        this.f32988i = new ArrayList();
        this.f32981b = adTemplate;
        this.f32982c = com.kwad.sdk.core.response.b.c.g(adTemplate);
        this.f32983d = jSONObject;
        if (ksAppDownloadListener != null) {
            a(ksAppDownloadListener);
        }
        DownloadStatusManager.a().a(this, this.f32981b);
        DownloadStatusManager.a().a(this.f32981b);
        this.f32986g = com.kwad.sdk.core.response.b.c.g(this.f32981b).downloadSafeInfo.downloadPauseEnable;
    }

    private int a(Context context) {
        String str = this.f32982c.adConversionInfo.marketUrl;
        if (!TextUtils.isEmpty(str) ? com.kwad.sdk.utils.e.a(KsAdSDKImpl.get().getContext(), str, this.f32982c.adBaseInfo.appPackageName) : false) {
            com.kwad.sdk.core.report.b.j(this.f32981b);
            return 0;
        } else if (b(context)) {
            return 0;
        } else {
            l();
            return 1;
        }
    }

    private boolean b(Context context) {
        if (context == null) {
            return false;
        }
        if (k()) {
            return true;
        }
        if (!com.kwad.sdk.core.config.c.Q() || ag.a(this.f32982c.downloadSafeInfo.autoDownloadUrl)) {
            if (com.kwad.sdk.core.download.a.b.a() || this.f32982c.status == 4 || !com.kwad.sdk.core.download.a.b.b(context, this.f32981b)) {
                return false;
            }
            return com.kwad.sdk.core.download.a.b.a(context, this.f32981b);
        } else if (this.f32982c.status == 4 || !com.kwad.sdk.core.response.b.c.a(this.f32981b) || AdLandPageActivityProxy.isDownloadDialogShowing()) {
            return false;
        } else {
            AdLandPageActivityProxy.launch(context, this.f32981b, this.f32982c.downloadSafeInfo.autoDownloadUrl);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(@NonNull KsAppDownloadListener ksAppDownloadListener) {
        AdInfo adInfo = this.f32982c;
        int i2 = adInfo.progress;
        int i3 = adInfo.status;
        if (i3 == 0) {
            ksAppDownloadListener.onIdle();
        } else if (i3 == 1) {
            ksAppDownloadListener.onProgressUpdate(0);
            if (ksAppDownloadListener instanceof c) {
                ((c) ksAppDownloadListener).onDownloadStarted();
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
            if (ksAppDownloadListener instanceof c) {
                ((c) ksAppDownloadListener).a(i2);
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

    private void h() {
        this.f32980a.post(new Runnable() { // from class: com.kwad.sdk.core.download.b.b.3
            @Override // java.lang.Runnable
            public void run() {
                ArrayList<KsAppDownloadListener> arrayList = new ArrayList(b.this.f32988i.size());
                arrayList.addAll(b.this.f32988i);
                for (KsAppDownloadListener ksAppDownloadListener : arrayList) {
                    if (ksAppDownloadListener != null) {
                        b.this.d(ksAppDownloadListener);
                    }
                }
            }
        });
    }

    private void i() {
        AdDownloadProxy proxyForDownload;
        String str = this.f32982c.adBaseInfo.appPackageName;
        Context context = KsAdSDKImpl.get().getContext();
        if (context == null) {
            return;
        }
        if (w.a(context, str)) {
            this.f32982c.status = 12;
            return;
        }
        AdInfo adInfo = this.f32982c;
        if (adInfo.status == 12) {
            adInfo.status = 0;
            adInfo.progress = 0;
        }
        AdInfo adInfo2 = this.f32982c;
        if (adInfo2.status == 8) {
            String str2 = adInfo2.downloadFilePath;
            if (TextUtils.isEmpty(str2) || !new File(str2).exists()) {
                AdInfo adInfo3 = this.f32982c;
                adInfo3.status = 0;
                adInfo3.progress = 0;
            }
        }
        if (this.f32982c.status != 0 || (proxyForDownload = KsAdSDKImpl.get().getProxyForDownload()) == null) {
            return;
        }
        String downloadFilePath = proxyForDownload.getDownloadFilePath(DownloadParams.transfrom(this.f32982c));
        if (TextUtils.isEmpty(downloadFilePath) || !new File(downloadFilePath).exists()) {
            return;
        }
        AdInfo adInfo4 = this.f32982c;
        adInfo4.downloadFilePath = downloadFilePath;
        adInfo4.status = 8;
    }

    private boolean j() {
        String str = this.f32982c.adConversionInfo.marketUrl;
        com.kwad.sdk.core.d.a.c("ApkDownloadHelper", "isMarKet URL Schema=" + str);
        boolean a2 = !TextUtils.isEmpty(str) ? com.kwad.sdk.utils.e.a(KsAdSDKImpl.get().getContext(), str, this.f32982c.adBaseInfo.appPackageName) : false;
        if (a2) {
            com.kwad.sdk.core.report.b.j(this.f32981b);
        }
        return a2;
    }

    private boolean k() {
        a aVar = this.f32987h;
        if (aVar != null) {
            return aVar.a(new DialogInterface.OnClickListener() { // from class: com.kwad.sdk.core.download.b.b.4
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    if (i2 == -1) {
                        switch (b.this.f32982c.status) {
                            case 0:
                            case 1:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                                b.this.l();
                                return;
                            case 2:
                            case 3:
                            case 10:
                            default:
                                return;
                            case 8:
                            case 9:
                            case 11:
                                b.this.f();
                                return;
                            case 12:
                                b.this.d();
                                return;
                        }
                    }
                }
            });
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        Context context = KsAdSDKImpl.get().getContext();
        if (context == null) {
            return;
        }
        if (com.ksad.download.d.b.a(context)) {
            com.kwad.sdk.core.download.e.a(context, this.f32982c);
        } else {
            com.kwad.sdk.core.d.a.e("ApkDownloadHelper", "no network while download app");
        }
    }

    private void m() {
        Context context = KsAdSDKImpl.get().getContext();
        if (context == null) {
            return;
        }
        com.kwad.sdk.core.download.e.a(context, this.f32982c.downloadId);
    }

    public int a(Context context, boolean z) {
        this.f32985f = false;
        i();
        switch (this.f32982c.status) {
            case 0:
            case 1:
            case 4:
            case 5:
            case 6:
            case 7:
                return a(context);
            case 2:
            case 3:
                if (z && this.f32986g) {
                    m();
                    return 0;
                }
                return 1;
            case 8:
            case 9:
            case 11:
                f();
                return 0;
            case 10:
            default:
                return 0;
            case 12:
                d();
                return 0;
        }
    }

    @Override // com.kwad.sdk.core.download.d
    public String a() {
        return this.f32982c.downloadId;
    }

    public void a(int i2) {
        this.f32981b.downloadSource = i2;
    }

    @UiThread
    public void a(final KsAppDownloadListener ksAppDownloadListener) {
        if (ksAppDownloadListener == null) {
            return;
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.f32980a.post(new Runnable() { // from class: com.kwad.sdk.core.download.b.b.6
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.f32988i.contains(ksAppDownloadListener)) {
                        return;
                    }
                    b.this.f32988i.add(0, ksAppDownloadListener);
                }
            });
        } else if (!this.f32988i.contains(ksAppDownloadListener)) {
            this.f32988i.add(0, ksAppDownloadListener);
        }
        i();
        d(ksAppDownloadListener);
    }

    public void a(a aVar) {
        this.f32987h = aVar;
    }

    @Override // com.kwad.sdk.core.download.d
    public void a(String str) {
        this.f32982c.status = 10;
        h();
    }

    @Override // com.kwad.sdk.core.download.d
    public void a(String str, int i2, int i3, int i4) {
        if (this.f32982c.downloadId.equals(str)) {
            AdInfo adInfo = this.f32982c;
            adInfo.status = 3;
            adInfo.progress = i2;
            adInfo.soFarBytes = i3;
            adInfo.totalBytes = i4;
            h();
        }
    }

    @Override // com.kwad.sdk.core.download.d
    public void a(String str, int i2, f fVar) {
        final boolean z = false;
        if (fVar.b()) {
            com.kwad.sdk.core.report.b.c(this.f32981b);
            fVar.a();
            if (Build.VERSION.SDK_INT < 29 && com.kwad.sdk.core.config.c.D() && this.f32981b.mIsFromContent) {
                z = e();
            }
        }
        com.kwad.sdk.utils.f.a(new Runnable() { // from class: com.kwad.sdk.core.download.b.b.2
            @Override // java.lang.Runnable
            public void run() {
                com.kwad.sdk.home.download.a.a().b(b.this.f32981b);
                if (z) {
                    return;
                }
                com.kwad.sdk.home.download.a.a().c(b.this.f32981b);
            }
        });
        com.kwad.sdk.core.a.a().d(com.kwad.sdk.core.response.b.c.g(this.f32981b).downloadId);
        this.f32982c.status = 12;
        h();
    }

    @Override // com.kwad.sdk.core.download.d
    public void a(String str, int i2, String str2, f fVar) {
        if (this.f32982c.downloadId.equals(str)) {
            this.f32982c.status = 7;
            h();
            if (fVar.b()) {
                b.a aVar = new b.a(i2, str2);
                com.kwad.sdk.core.report.b.a(this.f32981b, aVar);
                com.kwad.sdk.core.report.e.b(this.f32981b, this.f32982c.adConversionInfo.appDownloadUrl, aVar.toJson().toString());
                fVar.a();
            }
            if (this.f32982c.adConversionInfo.retryH5TimeStep <= 0 || this.f32985f) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis() - this.f32984e;
            AdInfo adInfo = this.f32982c;
            if (currentTimeMillis >= adInfo.adConversionInfo.retryH5TimeStep || TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.y(adInfo))) {
                return;
            }
            AdWebViewActivityProxy.launch(KsAdSDKImpl.get().getContext(), this.f32981b);
            this.f32985f = true;
        }
    }

    @Override // com.kwad.sdk.core.download.d
    public void a(String str, f fVar) {
        if (this.f32982c.downloadId.equals(str)) {
            if (this.f32982c.status != 1) {
                if (fVar.b()) {
                    com.kwad.sdk.core.report.b.b(this.f32981b);
                    fVar.a();
                }
                this.f32984e = System.currentTimeMillis();
            }
            this.f32982c.status = 1;
            h();
        }
    }

    @Override // com.kwad.sdk.core.download.d
    public void a(String str, String str2, f fVar) {
        if (this.f32982c.downloadId.equals(str)) {
            AdInfo adInfo = this.f32982c;
            adInfo.downloadFilePath = str2;
            adInfo.progress = 100;
            if (adInfo.status != 8 && !this.f32981b.mDownloadFinishReported) {
                com.kwad.sdk.utils.f.a(new Runnable() { // from class: com.kwad.sdk.core.download.b.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.kwad.sdk.home.download.a.a().a(b.this.f32981b);
                    }
                });
                if (fVar.b()) {
                    com.kwad.sdk.core.report.b.e(this.f32981b, this.f32983d);
                    fVar.a();
                }
                this.f32981b.mDownloadFinishReported = true;
            }
            this.f32982c.status = 8;
            h();
            ApkCacheManager.a().b();
        }
    }

    @Override // com.kwad.sdk.core.download.d
    public String b() {
        return this.f32982c.adBaseInfo.appPackageName;
    }

    public void b(final KsAppDownloadListener ksAppDownloadListener) {
        if (ksAppDownloadListener == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.f32988i.remove(ksAppDownloadListener);
        } else {
            this.f32980a.post(new Runnable() { // from class: com.kwad.sdk.core.download.b.b.7
                @Override // java.lang.Runnable
                public void run() {
                    b.this.f32988i.remove(ksAppDownloadListener);
                }
            });
        }
    }

    @Override // com.kwad.sdk.core.download.d
    public void b(String str) {
        if (this.f32982c.downloadId.equals(str)) {
            this.f32982c.status = 11;
            h();
        }
    }

    @Override // com.kwad.sdk.core.download.d
    public void b(String str, f fVar) {
        if (this.f32982c.downloadId.equals(str)) {
            if (this.f32982c.status != 4 && fVar.b()) {
                com.kwad.sdk.core.report.b.c(this.f32981b, this.f32983d);
                fVar.a();
            }
            this.f32982c.status = 4;
            h();
        }
    }

    public void c(KsAppDownloadListener ksAppDownloadListener) {
        if (ksAppDownloadListener == null) {
            return;
        }
        i();
        d(ksAppDownloadListener);
    }

    @Override // com.kwad.sdk.core.download.d
    public void c(String str, f fVar) {
        if (this.f32982c.downloadId.equals(str)) {
            if (this.f32982c.status != 2 && fVar.b()) {
                com.kwad.sdk.core.report.b.d(this.f32981b, this.f32983d);
                fVar.a();
            }
            this.f32982c.status = 2;
            h();
        }
    }

    public boolean c() {
        switch (this.f32982c.status) {
            case 0:
            case 1:
            case 4:
            case 5:
            case 6:
            case 7:
                return j();
            case 2:
            case 3:
            case 10:
            default:
                return false;
            case 8:
            case 9:
            case 11:
                f();
                return true;
            case 12:
                d();
                return true;
        }
    }

    public void d() {
        String str = this.f32982c.adBaseInfo.appPackageName;
        Context context = KsAdSDKImpl.get().getContext();
        if (context != null && !TextUtils.isEmpty(str)) {
            com.kwad.sdk.utils.f.a(new Runnable() { // from class: com.kwad.sdk.core.download.b.b.5
                @Override // java.lang.Runnable
                public void run() {
                    com.kwad.sdk.home.download.a.a().d(b.this.f32981b);
                }
            });
            com.kwad.sdk.core.report.b.e(this.f32981b);
            w.b(context, str);
            return;
        }
        com.kwad.sdk.core.d.a.e("ApkDownloadHelper", "openApp fail appContext:" + context + "--appPkgName:" + str);
    }

    @Override // com.kwad.sdk.core.download.d
    public void d(String str, f fVar) {
        if (this.f32982c.downloadId.equals(str)) {
            if (this.f32982c.status != 5 && fVar.b()) {
                com.kwad.sdk.core.report.b.f(this.f32981b, this.f32983d);
                fVar.a();
            }
            this.f32982c.status = 5;
            h();
        }
    }

    @Override // com.kwad.sdk.core.download.d
    public void e(String str, f fVar) {
        if (this.f32982c.downloadId.equals(str)) {
            if (fVar.b()) {
                com.kwad.sdk.core.report.b.g(this.f32981b);
                fVar.a();
            }
            this.f32982c.status = 9;
            h();
        }
    }

    public boolean e() {
        String str = this.f32982c.adBaseInfo.appPackageName;
        Context context = KsAdSDKImpl.get().getContext();
        if (context != null && !TextUtils.isEmpty(str)) {
            boolean b2 = w.b(context, str);
            if (b2) {
                com.kwad.sdk.core.report.b.f(this.f32981b);
            }
            return b2;
        }
        com.kwad.sdk.core.d.a.e("ApkDownloadHelper", "forceOpenApp fail appContext:" + context + "--appPkgName:" + str);
        return false;
    }

    public void f() {
        String str = this.f32982c.downloadFilePath;
        Context context = KsAdSDKImpl.get().getContext();
        if (context != null && !TextUtils.isEmpty(str)) {
            com.kwad.sdk.core.report.b.g(this.f32981b);
            KsAdSDKImpl.get().getProxyForAdInstall().installApp(context, str);
            return;
        }
        com.kwad.sdk.core.d.a.e("ApkDownloadHelper", "openApp fail appContext:" + context + "--filePath:" + str);
    }

    @Override // com.kwad.sdk.core.download.d
    public void f(String str, f fVar) {
        if (this.f32982c.downloadId.equals(str)) {
            com.kwad.sdk.core.report.b.d(this.f32981b);
        }
    }

    public void g() {
        List<KsAppDownloadListener> list = this.f32988i;
        if (list != null) {
            list.clear();
        }
        DownloadStatusManager.a().a(this);
    }
}
