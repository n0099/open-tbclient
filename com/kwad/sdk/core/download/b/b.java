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
/* loaded from: classes7.dex */
public class b implements com.kwad.sdk.core.download.d {

    /* renamed from: a  reason: collision with root package name */
    public Handler f34293a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public AdTemplate f34294b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public AdInfo f34295c;

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f34296d;

    /* renamed from: e  reason: collision with root package name */
    public long f34297e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f34298f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f34299g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f34300h;

    /* renamed from: i  reason: collision with root package name */
    public HashSet<KsAppDownloadListener> f34301i;

    /* renamed from: com.kwad.sdk.core.download.b.b$5  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass5 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f34306a;

        static {
            int[] iArr = new int[DOWNLOADSTAUS.values().length];
            f34306a = iArr;
            try {
                iArr[DOWNLOADSTAUS.UNKNOWN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f34306a[DOWNLOADSTAUS.START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f34306a[DOWNLOADSTAUS.DOWNLOADING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f34306a[DOWNLOADSTAUS.PROGRESS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f34306a[DOWNLOADSTAUS.PAUSED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f34306a[DOWNLOADSTAUS.FAILED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f34306a[DOWNLOADSTAUS.FINISHED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f34306a[DOWNLOADSTAUS.INSTALL.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f34306a[DOWNLOADSTAUS.INSTALL_FINSHED.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f34306a[DOWNLOADSTAUS.INSTALL_FAILED.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f34306a[DOWNLOADSTAUS.CANCELLED.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f34306a[DOWNLOADSTAUS.DELETED.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
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
        this.f34293a = new Handler(Looper.getMainLooper());
        this.f34301i = new HashSet<>();
        this.f34294b = adTemplate;
        this.f34295c = com.kwad.sdk.core.response.b.c.j(adTemplate);
        this.f34296d = jSONObject;
        if (ksAppDownloadListener != null) {
            a(ksAppDownloadListener);
        }
        DownloadStatusManager.a().a(this, this.f34294b);
        DownloadStatusManager.a().a(this.f34294b);
        this.f34300h = com.kwad.sdk.core.response.b.c.j(this.f34294b).downloadSafeInfo.downloadPauseEnable;
    }

    public static void a(b bVar, boolean z) {
        if (bVar != null) {
            bVar.a(z);
        }
    }

    private void a(boolean z) {
        this.f34299g = z;
    }

    private void b(Context context) {
        String str = this.f34295c.adConversionInfo.marketUrl;
        com.kwad.sdk.core.d.a.b("ApkDownloadHelper", "Market URL Schema=" + str);
        if (!TextUtils.isEmpty(str) ? com.kwad.sdk.utils.e.a(KsAdSDKImpl.get().getContext(), str, this.f34295c.adBaseInfo.appPackageName) : false) {
            com.kwad.sdk.core.report.b.j(this.f34294b);
        } else if (c(context)) {
        } else {
            j();
        }
    }

    private boolean c(Context context) {
        if (context == null || com.kwad.sdk.core.download.a.b.a() || this.f34295c.status == DOWNLOADSTAUS.PAUSED || !com.kwad.sdk.core.download.a.b.b(context, this.f34294b)) {
            return false;
        }
        return com.kwad.sdk.core.download.a.b.a(context, this.f34294b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(@NonNull KsAppDownloadListener ksAppDownloadListener) {
        AdInfo adInfo = this.f34295c;
        int i2 = adInfo.progress;
        switch (AnonymousClass5.f34306a[adInfo.status.ordinal()]) {
            case 1:
                ksAppDownloadListener.onIdle();
                return;
            case 2:
                ksAppDownloadListener.onProgressUpdate(0);
                try {
                    ksAppDownloadListener.onDownloadStarted();
                    return;
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.a.b(th);
                    return;
                }
            case 3:
            case 4:
                ksAppDownloadListener.onProgressUpdate(i2);
                return;
            case 5:
                if (ksAppDownloadListener instanceof c) {
                    ((c) ksAppDownloadListener).a(i2);
                    return;
                }
                return;
            case 6:
                ksAppDownloadListener.onDownloadFailed();
                return;
            case 7:
            case 8:
                ksAppDownloadListener.onDownloadFinished();
                return;
            case 9:
                ksAppDownloadListener.onInstalled();
                return;
            default:
                return;
        }
    }

    private void g() {
        this.f34293a.post(new Runnable() { // from class: com.kwad.sdk.core.download.b.b.3
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = b.this.f34301i.iterator();
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
        String str = this.f34295c.adBaseInfo.appPackageName;
        Context context = KsAdSDKImpl.get().getContext();
        if (context == null) {
            return;
        }
        if (y.a(context, str)) {
            this.f34295c.status = DOWNLOADSTAUS.INSTALL_FINSHED;
            return;
        }
        AdInfo adInfo = this.f34295c;
        if (adInfo.status == DOWNLOADSTAUS.INSTALL_FINSHED) {
            adInfo.status = DOWNLOADSTAUS.UNKNOWN;
            adInfo.progress = 0;
        }
        AdInfo adInfo2 = this.f34295c;
        if (adInfo2.status == DOWNLOADSTAUS.FINISHED) {
            String str2 = adInfo2.downloadFilePath;
            if (TextUtils.isEmpty(str2) || !new File(str2).exists()) {
                AdInfo adInfo3 = this.f34295c;
                adInfo3.status = DOWNLOADSTAUS.UNKNOWN;
                adInfo3.progress = 0;
            }
        }
        if (this.f34295c.status != DOWNLOADSTAUS.UNKNOWN || (proxyForDownload = KsAdSDKImpl.get().getProxyForDownload()) == null) {
            return;
        }
        String downloadFilePath = proxyForDownload.getDownloadFilePath(DownloadParams.transfrom(this.f34295c));
        if (TextUtils.isEmpty(downloadFilePath) || !new File(downloadFilePath).exists()) {
            return;
        }
        AdInfo adInfo4 = this.f34295c;
        adInfo4.downloadFilePath = downloadFilePath;
        adInfo4.status = DOWNLOADSTAUS.FINISHED;
    }

    private boolean i() {
        String str = this.f34295c.adConversionInfo.marketUrl;
        com.kwad.sdk.core.d.a.b("ApkDownloadHelper", "isMarKet URL Schema=" + str);
        boolean a2 = !TextUtils.isEmpty(str) ? com.kwad.sdk.utils.e.a(KsAdSDKImpl.get().getContext(), str, this.f34295c.adBaseInfo.appPackageName) : false;
        if (a2) {
            com.kwad.sdk.core.report.b.j(this.f34294b);
        }
        return a2;
    }

    private void j() {
        Context context = KsAdSDKImpl.get().getContext();
        if (context == null) {
            return;
        }
        if (com.ksad.download.d.b.a(context)) {
            com.kwad.sdk.core.download.e.a(context, this.f34295c);
        } else {
            com.kwad.sdk.core.d.a.d("ApkDownloadHelper", "no network while download app");
        }
    }

    private void k() {
        Context context = KsAdSDKImpl.get().getContext();
        if (context == null) {
            return;
        }
        com.kwad.sdk.core.download.e.a(context, this.f34295c.downloadId);
    }

    @Override // com.kwad.sdk.core.download.d
    public String a() {
        return this.f34295c.downloadId;
    }

    public void a(int i2) {
        this.f34294b.downloadSource = i2;
    }

    public void a(Context context) {
        this.f34298f = false;
        h();
        switch (AnonymousClass5.f34306a[this.f34295c.status.ordinal()]) {
            case 1:
            case 2:
            case 5:
            case 6:
            case 11:
            case 12:
                b(context);
                break;
            case 3:
            case 4:
                if (this.f34299g && this.f34300h) {
                    k();
                    break;
                }
                break;
            case 7:
            case 8:
            case 10:
                e();
                break;
            case 9:
                d();
                break;
        }
        this.f34299g = false;
    }

    @UiThread
    public void a(KsAppDownloadListener ksAppDownloadListener) {
        if (ksAppDownloadListener == null) {
            return;
        }
        this.f34301i.add(ksAppDownloadListener);
        h();
        d(ksAppDownloadListener);
    }

    @Override // com.kwad.sdk.core.download.d
    public void a(String str) {
        this.f34295c.status = DOWNLOADSTAUS.INSTALLING;
        g();
    }

    @Override // com.kwad.sdk.core.download.d
    public void a(String str, int i2, int i3, int i4) {
        if (this.f34295c.downloadId.equals(str)) {
            AdInfo adInfo = this.f34295c;
            adInfo.status = DOWNLOADSTAUS.PROGRESS;
            adInfo.progress = i2;
            adInfo.soFarBytes = i3;
            adInfo.totalBytes = i4;
            g();
        }
    }

    @Override // com.kwad.sdk.core.download.d
    public void a(String str, int i2, f fVar) {
        if (fVar.b()) {
            com.kwad.sdk.core.report.b.d(this.f34294b);
            fVar.a();
        }
        com.kwad.sdk.utils.f.a(new Runnable() { // from class: com.kwad.sdk.core.download.b.b.2
            @Override // java.lang.Runnable
            public void run() {
                com.kwad.sdk.home.download.a.a().b(b.this.f34294b);
                com.kwad.sdk.home.download.a.a().c(b.this.f34294b);
            }
        });
        com.kwad.sdk.core.a.a().d(com.kwad.sdk.core.response.b.c.j(this.f34294b).downloadId);
        this.f34295c.status = DOWNLOADSTAUS.INSTALL_FINSHED;
        g();
    }

    @Override // com.kwad.sdk.core.download.d
    public void a(String str, int i2, String str2, f fVar) {
        if (this.f34295c.downloadId.equals(str)) {
            this.f34295c.status = DOWNLOADSTAUS.FAILED;
            g();
            if (fVar.b()) {
                b.a aVar = new b.a(i2, str2);
                com.kwad.sdk.core.report.b.a(this.f34294b, aVar);
                com.kwad.sdk.core.report.e.d(this.f34294b, this.f34295c.adConversionInfo.appDownloadUrl, aVar.toJson().toString());
                fVar.a();
            }
            if (this.f34295c.adConversionInfo.retryH5TimeStep <= 0 || this.f34298f) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis() - this.f34297e;
            AdInfo adInfo = this.f34295c;
            if (currentTimeMillis >= adInfo.adConversionInfo.retryH5TimeStep || TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.B(adInfo))) {
                return;
            }
            AdWebViewActivityProxy.launch(KsAdSDKImpl.get().getContext(), this.f34294b);
            this.f34298f = true;
        }
    }

    @Override // com.kwad.sdk.core.download.d
    public void a(String str, f fVar) {
        if (this.f34295c.downloadId.equals(str)) {
            if (this.f34295c.status != DOWNLOADSTAUS.START) {
                if (fVar.b()) {
                    com.kwad.sdk.core.report.b.b(this.f34294b);
                    fVar.a();
                }
                this.f34297e = System.currentTimeMillis();
            }
            this.f34295c.status = DOWNLOADSTAUS.START;
            g();
        }
    }

    @Override // com.kwad.sdk.core.download.d
    public void a(String str, String str2, f fVar) {
        if (this.f34295c.downloadId.equals(str)) {
            AdInfo adInfo = this.f34295c;
            adInfo.downloadFilePath = str2;
            adInfo.progress = 100;
            if (adInfo.status != DOWNLOADSTAUS.FINISHED && !this.f34294b.mDownloadFinishReported) {
                com.kwad.sdk.utils.f.a(new Runnable() { // from class: com.kwad.sdk.core.download.b.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.kwad.sdk.home.download.a.a().a(b.this.f34294b);
                    }
                });
                if (fVar.b()) {
                    com.kwad.sdk.core.report.b.e(this.f34294b, this.f34296d);
                    fVar.a();
                }
                this.f34294b.mDownloadFinishReported = true;
            }
            this.f34295c.status = DOWNLOADSTAUS.FINISHED;
            g();
            ApkCacheManager.a().b();
        }
    }

    @Override // com.kwad.sdk.core.download.d
    public String b() {
        return this.f34295c.adBaseInfo.appPackageName;
    }

    public void b(KsAppDownloadListener ksAppDownloadListener) {
        if (ksAppDownloadListener == null) {
            return;
        }
        this.f34301i.remove(ksAppDownloadListener);
    }

    @Override // com.kwad.sdk.core.download.d
    public void b(String str) {
        if (this.f34295c.downloadId.equals(str)) {
            this.f34295c.status = DOWNLOADSTAUS.INSTALL_FAILED;
            g();
        }
    }

    @Override // com.kwad.sdk.core.download.d
    public void b(String str, f fVar) {
        if (this.f34295c.downloadId.equals(str)) {
            if (this.f34295c.status != DOWNLOADSTAUS.PAUSED && fVar.b()) {
                com.kwad.sdk.core.report.b.c(this.f34294b, this.f34296d);
                fVar.a();
            }
            this.f34295c.status = DOWNLOADSTAUS.PAUSED;
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
        if (this.f34295c.downloadId.equals(str)) {
            if (this.f34295c.status != DOWNLOADSTAUS.DOWNLOADING && fVar.b()) {
                com.kwad.sdk.core.report.b.d(this.f34294b, this.f34296d);
                fVar.a();
            }
            this.f34295c.status = DOWNLOADSTAUS.DOWNLOADING;
            g();
        }
    }

    public boolean c() {
        int i2 = AnonymousClass5.f34306a[this.f34295c.status.ordinal()];
        if (i2 != 1 && i2 != 2) {
            switch (i2) {
                case 5:
                case 6:
                case 11:
                case 12:
                    break;
                case 7:
                case 8:
                case 10:
                    e();
                    return true;
                case 9:
                    d();
                    return true;
                default:
                    return false;
            }
        }
        return i();
    }

    public void d() {
        String str = this.f34295c.adBaseInfo.appPackageName;
        Context context = KsAdSDKImpl.get().getContext();
        if (context != null && !TextUtils.isEmpty(str)) {
            com.kwad.sdk.utils.f.a(new Runnable() { // from class: com.kwad.sdk.core.download.b.b.4
                @Override // java.lang.Runnable
                public void run() {
                    com.kwad.sdk.home.download.a.a().d(b.this.f34294b);
                }
            });
            com.kwad.sdk.core.report.b.f(this.f34294b);
            y.b(context, str);
            return;
        }
        com.kwad.sdk.core.d.a.d("ApkDownloadHelper", "openApp fail appContext:" + context + "--appPkgName:" + str);
    }

    @Override // com.kwad.sdk.core.download.d
    public void d(String str, f fVar) {
        if (this.f34295c.downloadId.equals(str)) {
            if (this.f34295c.status != DOWNLOADSTAUS.CANCELLED && fVar.b()) {
                com.kwad.sdk.core.report.b.f(this.f34294b, this.f34296d);
                fVar.a();
            }
            this.f34295c.status = DOWNLOADSTAUS.CANCELLED;
            g();
        }
    }

    public void e() {
        String str = this.f34295c.downloadFilePath;
        Context context = KsAdSDKImpl.get().getContext();
        if (context != null && !TextUtils.isEmpty(str)) {
            com.kwad.sdk.core.report.b.g(this.f34294b);
            KsAdSDKImpl.get().getProxyForAdInstall().installApp(context, str);
            return;
        }
        com.kwad.sdk.core.d.a.d("ApkDownloadHelper", "openApp fail appContext:" + context + "--filePath:" + str);
    }

    @Override // com.kwad.sdk.core.download.d
    public void e(String str, f fVar) {
        if (this.f34295c.downloadId.equals(str)) {
            if (fVar.b()) {
                com.kwad.sdk.core.report.b.g(this.f34294b);
                fVar.a();
            }
            this.f34295c.status = DOWNLOADSTAUS.INSTALL;
            g();
        }
    }

    public void f() {
        HashSet<KsAppDownloadListener> hashSet = this.f34301i;
        if (hashSet != null) {
            hashSet.clear();
        }
        DownloadStatusManager.a().a(this);
    }

    @Override // com.kwad.sdk.core.download.d
    public void f(String str, f fVar) {
        if (this.f34295c.downloadId.equals(str)) {
            com.kwad.sdk.core.report.b.e(this.f34294b);
        }
    }
}
