package com.kwad.sdk.core.download.a;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.URLUtil;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.diskcache.ApkCacheManager;
import com.kwad.sdk.core.download.DownloadParams;
import com.kwad.sdk.core.download.DownloadStatusManager;
import com.kwad.sdk.core.download.a.a;
import com.kwad.sdk.core.page.AdWebViewActivityProxy;
import com.kwad.sdk.core.page.AdWebViewLandPageActivityProxy;
import com.kwad.sdk.core.page.AdWebViewVideoActivityProxy;
import com.kwad.sdk.core.report.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.export.proxy.AdDownloadProxy;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.i;
import com.kwad.sdk.utils.u;
import com.kwad.sdk.utils.v;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b implements com.kwad.sdk.core.download.c {
    public Handler a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public AdTemplate f39439b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public AdInfo f39440c;

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f39441d;

    /* renamed from: e  reason: collision with root package name */
    public long f39442e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f39443f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f39444g;

    /* renamed from: h  reason: collision with root package name */
    public a f39445h;
    public DialogInterface.OnShowListener i;
    public DialogInterface.OnDismissListener j;
    public List<KsAppDownloadListener> k;

    /* loaded from: classes7.dex */
    public interface a {
        boolean a(DialogInterface.OnClickListener onClickListener);
    }

    public b(@NonNull AdTemplate adTemplate) {
        this(adTemplate, null, null);
    }

    public b(@NonNull AdTemplate adTemplate, @NonNull KsAppDownloadListener ksAppDownloadListener) {
        this(adTemplate, null, ksAppDownloadListener);
    }

    public b(@NonNull AdTemplate adTemplate, KsAppDownloadListener ksAppDownloadListener, String str, String str2) {
        this(adTemplate, null, ksAppDownloadListener);
        AdInfo adInfo = this.f39440c;
        adInfo.adConversionInfo.appDownloadUrl = str;
        adInfo.adBaseInfo.appPackageName = str2;
        adInfo.downloadId = aa.a(str);
    }

    public b(@NonNull AdTemplate adTemplate, JSONObject jSONObject) {
        this(adTemplate, jSONObject, null);
    }

    public b(@NonNull AdTemplate adTemplate, JSONObject jSONObject, KsAppDownloadListener ksAppDownloadListener) {
        this.a = new Handler(Looper.getMainLooper());
        this.k = new ArrayList();
        this.f39439b = adTemplate;
        this.f39440c = com.kwad.sdk.core.response.a.d.j(adTemplate);
        this.f39441d = jSONObject;
        if (ksAppDownloadListener != null) {
            a(ksAppDownloadListener);
        }
        DownloadStatusManager.a().a(this, this.f39439b);
        DownloadStatusManager.a().a(this.f39439b);
        this.f39444g = com.kwad.sdk.core.response.a.a.ax(com.kwad.sdk.core.response.a.d.j(this.f39439b));
    }

    public static void a(Context context, AdTemplate adTemplate) {
        if (context == null || adTemplate == null) {
            return;
        }
        AdWebViewLandPageActivityProxy.launch(context, adTemplate);
    }

    public static boolean b(a.C1956a c1956a) {
        AdInfo j = com.kwad.sdk.core.response.a.d.j(c1956a.b());
        if (com.kwad.sdk.core.response.a.a.ad(j) && (AdWebViewLandPageActivityProxy.showingAdWebViewLandPage || AdWebViewVideoActivityProxy.showingAdWebViewVideoActivity || c1956a.b().isWebViewDownload)) {
            return true;
        }
        return com.kwad.sdk.core.response.a.a.ae(j) && !com.ksad.download.c.b.b(c1956a.a());
    }

    public static int c(a.C1956a c1956a) {
        AdInfo j = com.kwad.sdk.core.response.a.d.j(c1956a.b());
        if (j.downloadSafeInfo.complianceInfo != null) {
            int g2 = c1956a.g();
            return g2 != 2 ? g2 != 3 ? j.downloadSafeInfo.complianceInfo.actionBarType : j.downloadSafeInfo.complianceInfo.materialJumpType : j.downloadSafeInfo.complianceInfo.describeBarType;
        }
        return 0;
    }

    private int d(a.C1956a c1956a) {
        Context a2 = c1956a.a();
        String aL = com.kwad.sdk.core.response.a.a.aL(this.f39440c);
        if (com.kwad.sdk.utils.f.a(a2, aL, this.f39439b)) {
            return 0;
        }
        if (com.kwad.sdk.utils.f.a(a2, aL, com.kwad.sdk.core.response.a.a.v(this.f39440c))) {
            com.kwad.sdk.core.report.a.k(this.f39439b);
            return 0;
        } else if (o()) {
            return 0;
        } else {
            if (!com.ksad.download.c.b.a(a2)) {
                u.a(a2, v.a(a2));
                return 0;
            } else if (c1956a.i()) {
                return e(c1956a);
            } else {
                if (f(c1956a)) {
                    return 0;
                }
                q();
                return 1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(@NonNull KsAppDownloadListener ksAppDownloadListener) {
        AdInfo adInfo = this.f39440c;
        int i = adInfo.progress;
        int i2 = adInfo.status;
        if (i2 == 0) {
            ksAppDownloadListener.onIdle();
        } else if (i2 == 1) {
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
        } else if (i2 == 2 || i2 == 3) {
            ksAppDownloadListener.onProgressUpdate(i);
        } else if (i2 == 4) {
            if (ksAppDownloadListener instanceof c) {
                ((c) ksAppDownloadListener).a(i);
            }
        } else if (i2 == 7) {
            ksAppDownloadListener.onDownloadFailed();
        } else if (i2 == 8 || i2 == 9) {
            ksAppDownloadListener.onDownloadFinished();
        } else if (i2 != 12) {
        } else {
            ksAppDownloadListener.onInstalled();
        }
    }

    private int e(a.C1956a c1956a) {
        int c2 = c(c1956a);
        if (c2 == 1) {
            com.kwad.sdk.core.download.kwai.b.a(c1956a.a(), c1956a.b(), null, this.i, this.j);
            return 0;
        } else if (c2 == 2) {
            a(c1956a.a(), c1956a.b());
            return 0;
        } else if (c2 == 3 || f(c1956a)) {
            return 0;
        } else {
            q();
            return 1;
        }
    }

    private boolean f(a.C1956a c1956a) {
        String b2 = com.kwad.sdk.core.config.b.b();
        if (!URLUtil.isNetworkUrl(b2) || c1956a.f() || com.kwad.sdk.core.download.kwai.b.a() || this.f39440c.status == 4 || !b(c1956a)) {
            return false;
        }
        return com.kwad.sdk.core.download.kwai.b.a(c1956a.a(), this.f39439b, b2, this.i, this.j);
    }

    private boolean k() {
        boolean z = false;
        if (Build.VERSION.SDK_INT < 29) {
            if (this.f39439b.mIsFromContent && com.kwad.sdk.core.config.b.K()) {
                z = p();
                if (z) {
                    com.kwad.sdk.core.report.a.f(this.f39439b);
                }
            } else if (!this.f39439b.mIsFromContent && com.kwad.sdk.core.config.b.au() && (z = p())) {
                com.kwad.sdk.core.report.a.g(this.f39439b);
            }
        }
        return z;
    }

    private void l() {
        this.a.post(new Runnable() { // from class: com.kwad.sdk.core.download.a.b.3
            @Override // java.lang.Runnable
            public void run() {
                ArrayList<KsAppDownloadListener> arrayList = new ArrayList(b.this.k.size());
                arrayList.addAll(b.this.k);
                for (KsAppDownloadListener ksAppDownloadListener : arrayList) {
                    if (ksAppDownloadListener != null) {
                        b.this.d(ksAppDownloadListener);
                    }
                }
            }
        });
    }

    private void m() {
        AdDownloadProxy proxyForDownload;
        String str = this.f39440c.adBaseInfo.appPackageName;
        Context context = KsAdSDKImpl.get().getContext();
        if (context == null) {
            return;
        }
        if (ag.a(context, str)) {
            this.f39440c.status = 12;
            return;
        }
        AdInfo adInfo = this.f39440c;
        if (adInfo.status == 12) {
            adInfo.status = 0;
            adInfo.progress = 0;
        }
        AdInfo adInfo2 = this.f39440c;
        if (adInfo2.status == 8) {
            String str2 = adInfo2.downloadFilePath;
            if (TextUtils.isEmpty(str2) || !new File(str2).exists()) {
                AdInfo adInfo3 = this.f39440c;
                adInfo3.status = 0;
                adInfo3.progress = 0;
            }
        }
        if (this.f39440c.status != 0 || (proxyForDownload = KsAdSDKImpl.get().getProxyForDownload()) == null) {
            return;
        }
        String downloadFilePath = proxyForDownload.getDownloadFilePath(DownloadParams.transform(this.f39440c));
        if (TextUtils.isEmpty(downloadFilePath) || !new File(downloadFilePath).exists()) {
            return;
        }
        AdInfo adInfo4 = this.f39440c;
        adInfo4.downloadFilePath = downloadFilePath;
        adInfo4.status = 8;
    }

    private boolean n() {
        String str = this.f39440c.adConversionInfo.marketUrl;
        com.kwad.sdk.core.d.a.c("ApkDownloadHelper", "isMarKet URL Schema=" + str);
        boolean a2 = !TextUtils.isEmpty(str) ? com.kwad.sdk.utils.f.a(KsAdSDKImpl.get().getContext(), str, this.f39440c.adBaseInfo.appPackageName) : false;
        if (a2) {
            com.kwad.sdk.core.report.a.k(this.f39439b);
        }
        return a2;
    }

    private boolean o() {
        a aVar = this.f39445h;
        if (aVar != null) {
            return aVar.a(new DialogInterface.OnClickListener() { // from class: com.kwad.sdk.core.download.a.b.4
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (i == -1) {
                        switch (b.this.f39440c.status) {
                            case 0:
                            case 1:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                                b.this.q();
                                return;
                            case 2:
                            case 3:
                            case 10:
                            default:
                                return;
                            case 8:
                            case 9:
                            case 11:
                                b.this.h();
                                return;
                            case 12:
                                b.this.g();
                                return;
                        }
                    }
                }
            });
        }
        return false;
    }

    private boolean p() {
        Context context = KsAdSDKImpl.get().getContext();
        if (d.a(context, this.f39439b, 1) == 1) {
            return true;
        }
        boolean c2 = ag.c(context, com.kwad.sdk.core.response.a.a.v(this.f39440c));
        if (c2) {
            com.kwad.sdk.core.report.a.e(this.f39439b);
        }
        return c2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        Context context = KsAdSDKImpl.get().getContext();
        if (context == null) {
            return;
        }
        if (com.ksad.download.c.b.a(context)) {
            com.kwad.sdk.core.download.d.a(context, this.f39440c);
        } else {
            com.kwad.sdk.core.d.a.e("ApkDownloadHelper", "no network while download app");
        }
    }

    private void r() {
        Context context = KsAdSDKImpl.get().getContext();
        if (context == null) {
            return;
        }
        com.kwad.sdk.core.download.d.a(context, this.f39440c.downloadId);
    }

    public int a(Context context, boolean z) {
        return a(new a.C1956a(context).a(z).b(false).d(false));
    }

    public int a(a.C1956a c1956a) {
        this.f39443f = false;
        m();
        switch (this.f39440c.status) {
            case 0:
            case 1:
            case 5:
            case 6:
            case 7:
                return d(c1956a);
            case 2:
            case 3:
                if (c1956a.e() && this.f39444g) {
                    r();
                    return 0;
                }
                return 1;
            case 4:
                q();
                return 0;
            case 8:
            case 9:
            case 11:
                h();
                return 0;
            case 10:
            default:
                return 0;
            case 12:
                g();
                return 0;
        }
    }

    @Override // com.kwad.sdk.core.download.c
    public String a() {
        return this.f39440c.downloadId;
    }

    public void a(int i) {
        this.f39439b.downloadSource = i;
    }

    public void a(DialogInterface.OnDismissListener onDismissListener) {
        this.j = onDismissListener;
    }

    public void a(DialogInterface.OnShowListener onShowListener) {
        this.i = onShowListener;
    }

    @UiThread
    public void a(final KsAppDownloadListener ksAppDownloadListener) {
        if (ksAppDownloadListener == null) {
            return;
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.a.post(new Runnable() { // from class: com.kwad.sdk.core.download.a.b.6
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.k.contains(ksAppDownloadListener)) {
                        return;
                    }
                    b.this.k.add(0, ksAppDownloadListener);
                }
            });
        } else if (!this.k.contains(ksAppDownloadListener)) {
            this.k.add(0, ksAppDownloadListener);
        }
        m();
        d(ksAppDownloadListener);
    }

    public void a(a aVar) {
        this.f39445h = aVar;
    }

    @Override // com.kwad.sdk.core.download.c
    public void a(String str, int i, int i2, int i3) {
        if (this.f39440c.downloadId.equals(str)) {
            AdInfo adInfo = this.f39440c;
            adInfo.status = 3;
            adInfo.progress = i;
            adInfo.soFarBytes = i2;
            adInfo.totalBytes = i3;
            l();
        }
    }

    @Override // com.kwad.sdk.core.download.c
    public void a(String str, int i, com.kwad.sdk.core.download.f fVar) {
        final boolean z;
        AdInfo j = com.kwad.sdk.core.response.a.d.j(this.f39439b);
        if (fVar.b()) {
            com.kwad.sdk.core.report.a.c(this.f39439b);
            fVar.a();
            z = k();
            com.kwad.sdk.core.download.e.a().b(j, this.f39439b);
        } else {
            z = false;
        }
        i.a(new Runnable() { // from class: com.kwad.sdk.core.download.a.b.2
            @Override // java.lang.Runnable
            public void run() {
                com.kwad.sdk.home.download.a.a().b(b.this.f39439b);
                if (z) {
                    return;
                }
                com.kwad.sdk.home.download.a.a().c(b.this.f39439b);
            }
        });
        com.kwad.sdk.core.a.a().d(j.downloadId);
        this.f39440c.status = 12;
        l();
    }

    @Override // com.kwad.sdk.core.download.c
    public void a(String str, int i, String str2, com.kwad.sdk.core.download.f fVar) {
        if (this.f39440c.downloadId.equals(str)) {
            this.f39440c.status = 7;
            l();
            if (fVar.b()) {
                a.C1966a c1966a = new a.C1966a(i, str2);
                com.kwad.sdk.core.report.a.a(this.f39439b, c1966a);
                com.kwad.sdk.core.report.d.b(this.f39439b, this.f39440c.adConversionInfo.appDownloadUrl, c1966a.toJson().toString());
                fVar.a();
            }
            if (this.f39440c.adConversionInfo.retryH5TimeStep <= 0 || this.f39443f) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis() - this.f39442e;
            AdInfo adInfo = this.f39440c;
            if (currentTimeMillis >= adInfo.adConversionInfo.retryH5TimeStep || TextUtils.isEmpty(com.kwad.sdk.core.response.a.a.G(adInfo))) {
                return;
            }
            AdWebViewActivityProxy.launch(KsAdSDKImpl.get().getContext(), this.f39439b);
            this.f39443f = true;
        }
    }

    @Override // com.kwad.sdk.core.download.c
    public void a(String str, com.kwad.sdk.core.download.f fVar) {
        if (this.f39440c.downloadId.equals(str)) {
            if (this.f39440c.status != 1) {
                if (fVar.b()) {
                    com.kwad.sdk.core.report.a.b(this.f39439b);
                    fVar.a();
                }
                this.f39442e = System.currentTimeMillis();
            }
            this.f39440c.status = 1;
            l();
        }
    }

    @Override // com.kwad.sdk.core.download.c
    public void a(String str, String str2, com.kwad.sdk.core.download.f fVar) {
        if (this.f39440c.downloadId.equals(str)) {
            AdInfo adInfo = this.f39440c;
            adInfo.downloadFilePath = str2;
            adInfo.progress = 100;
            if (adInfo.status != 8 && !this.f39439b.mDownloadFinishReported) {
                i.a(new Runnable() { // from class: com.kwad.sdk.core.download.a.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.kwad.sdk.home.download.a.a().a(b.this.f39439b);
                    }
                });
                if (fVar.b()) {
                    com.kwad.sdk.core.report.a.e(this.f39439b, this.f39441d);
                    fVar.a();
                }
                com.kwad.sdk.core.download.e.a().a(this.f39440c, this.f39439b);
                this.f39439b.mDownloadFinishReported = true;
            }
            this.f39440c.status = 8;
            l();
            ApkCacheManager.a().b();
        }
    }

    @Override // com.kwad.sdk.core.download.c
    public String b() {
        return this.f39440c.adBaseInfo.appPackageName;
    }

    public void b(final KsAppDownloadListener ksAppDownloadListener) {
        if (ksAppDownloadListener == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.k.remove(ksAppDownloadListener);
        } else {
            this.a.post(new Runnable() { // from class: com.kwad.sdk.core.download.a.b.7
                @Override // java.lang.Runnable
                public void run() {
                    b.this.k.remove(ksAppDownloadListener);
                }
            });
        }
    }

    @Override // com.kwad.sdk.core.download.c
    public void b(String str, com.kwad.sdk.core.download.f fVar) {
        if (this.f39440c.downloadId.equals(str)) {
            if (this.f39440c.status != 4 && fVar.b()) {
                com.kwad.sdk.core.report.a.c(this.f39439b, this.f39441d);
                fVar.a();
            }
            this.f39440c.status = 4;
            l();
        }
    }

    public int c() {
        m();
        int i = this.f39440c.status;
        if (i == 3) {
            return 2;
        }
        return i;
    }

    public void c(KsAppDownloadListener ksAppDownloadListener) {
        if (ksAppDownloadListener == null) {
            return;
        }
        m();
        d(ksAppDownloadListener);
    }

    @Override // com.kwad.sdk.core.download.c
    public void c(String str, com.kwad.sdk.core.download.f fVar) {
        if (this.f39440c.downloadId.equals(str)) {
            if (this.f39440c.status != 2 && fVar.b()) {
                com.kwad.sdk.core.report.a.d(this.f39439b, this.f39441d);
                fVar.a();
            }
            this.f39440c.status = 2;
            l();
        }
    }

    @Override // com.kwad.sdk.core.download.c
    public void d(String str, com.kwad.sdk.core.download.f fVar) {
        if (this.f39440c.downloadId.equals(str)) {
            if (this.f39440c.status != 5 && fVar.b()) {
                com.kwad.sdk.core.report.a.f(this.f39439b, this.f39441d);
                fVar.a();
            }
            this.f39440c.status = 5;
            l();
        }
    }

    public boolean d() {
        switch (this.f39440c.status) {
            case 0:
            case 1:
            case 4:
            case 5:
            case 6:
            case 7:
                return n();
            case 2:
            case 3:
            case 10:
            default:
                return false;
            case 8:
            case 9:
            case 11:
                h();
                return true;
            case 12:
                g();
                return true;
        }
    }

    @NonNull
    public AdTemplate e() {
        return this.f39439b;
    }

    @Override // com.kwad.sdk.core.download.c
    public void e(String str, com.kwad.sdk.core.download.f fVar) {
        if (this.f39440c.downloadId.equals(str)) {
            com.kwad.sdk.core.report.a.d(this.f39439b);
        }
    }

    public boolean f() {
        if (this.f39440c.status == 0) {
            return n();
        }
        return false;
    }

    public void g() {
        i.a(new Runnable() { // from class: com.kwad.sdk.core.download.a.b.5
            @Override // java.lang.Runnable
            public void run() {
                com.kwad.sdk.home.download.a.a().d(b.this.f39439b);
            }
        });
        if (ag.c(KsAdSDKImpl.get().getContext(), com.kwad.sdk.core.response.a.a.v(this.f39440c))) {
            com.kwad.sdk.core.report.a.e(this.f39439b);
        }
    }

    public void h() {
        String str = this.f39440c.downloadFilePath;
        Context context = KsAdSDKImpl.get().getContext();
        if (context != null && !TextUtils.isEmpty(str)) {
            com.kwad.sdk.core.report.a.h(this.f39439b);
            KsAdSDKImpl.get().getProxyForAdInstall().installApp(context, str);
            return;
        }
        com.kwad.sdk.core.d.a.e("ApkDownloadHelper", "openApp fail appContext:" + context + "--filePath:" + str);
    }

    public void i() {
        j();
        DownloadStatusManager.a().a(this);
    }

    public void j() {
        List<KsAppDownloadListener> list = this.k;
        if (list != null) {
            list.clear();
        }
    }
}
