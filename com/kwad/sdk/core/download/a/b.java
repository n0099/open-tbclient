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
/* loaded from: classes5.dex */
public class b implements com.kwad.sdk.core.download.c {
    public Handler a;
    @NonNull
    public AdTemplate b;
    @NonNull
    public AdInfo c;
    public JSONObject d;
    public long e;
    public boolean f;
    public boolean g;
    public a h;
    public DialogInterface.OnShowListener i;
    public DialogInterface.OnDismissListener j;
    public List<KsAppDownloadListener> k;

    /* loaded from: classes5.dex */
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
        AdInfo adInfo = this.c;
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
        this.b = adTemplate;
        this.c = com.kwad.sdk.core.response.a.d.j(adTemplate);
        this.d = jSONObject;
        if (ksAppDownloadListener != null) {
            a(ksAppDownloadListener);
        }
        DownloadStatusManager.a().a(this, this.b);
        DownloadStatusManager.a().a(this.b);
        this.g = com.kwad.sdk.core.response.a.a.ax(com.kwad.sdk.core.response.a.d.j(this.b));
    }

    public static void a(Context context, AdTemplate adTemplate) {
        if (context == null || adTemplate == null) {
            return;
        }
        AdWebViewLandPageActivityProxy.launch(context, adTemplate);
    }

    public static boolean b(a.C0295a c0295a) {
        AdInfo j = com.kwad.sdk.core.response.a.d.j(c0295a.b());
        if (com.kwad.sdk.core.response.a.a.ad(j) && (AdWebViewLandPageActivityProxy.showingAdWebViewLandPage || AdWebViewVideoActivityProxy.showingAdWebViewVideoActivity || c0295a.b().isWebViewDownload)) {
            return true;
        }
        return com.kwad.sdk.core.response.a.a.ae(j) && !com.ksad.download.c.b.b(c0295a.a());
    }

    public static int c(a.C0295a c0295a) {
        AdInfo j = com.kwad.sdk.core.response.a.d.j(c0295a.b());
        if (j.downloadSafeInfo.complianceInfo != null) {
            int g = c0295a.g();
            return g != 2 ? g != 3 ? j.downloadSafeInfo.complianceInfo.actionBarType : j.downloadSafeInfo.complianceInfo.materialJumpType : j.downloadSafeInfo.complianceInfo.describeBarType;
        }
        return 0;
    }

    private int d(a.C0295a c0295a) {
        Context a2 = c0295a.a();
        String aL = com.kwad.sdk.core.response.a.a.aL(this.c);
        if (com.kwad.sdk.utils.f.a(a2, aL, this.b)) {
            return 0;
        }
        if (com.kwad.sdk.utils.f.a(a2, aL, com.kwad.sdk.core.response.a.a.v(this.c))) {
            com.kwad.sdk.core.report.a.k(this.b);
            return 0;
        } else if (o()) {
            return 0;
        } else {
            if (!com.ksad.download.c.b.a(a2)) {
                u.a(a2, v.a(a2));
                return 0;
            } else if (c0295a.i()) {
                return e(c0295a);
            } else {
                if (f(c0295a)) {
                    return 0;
                }
                q();
                return 1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(@NonNull KsAppDownloadListener ksAppDownloadListener) {
        AdInfo adInfo = this.c;
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

    private int e(a.C0295a c0295a) {
        int c = c(c0295a);
        if (c == 1) {
            com.kwad.sdk.core.download.kwai.b.a(c0295a.a(), c0295a.b(), null, this.i, this.j);
            return 0;
        } else if (c == 2) {
            a(c0295a.a(), c0295a.b());
            return 0;
        } else if (c == 3 || f(c0295a)) {
            return 0;
        } else {
            q();
            return 1;
        }
    }

    private boolean f(a.C0295a c0295a) {
        String b = com.kwad.sdk.core.config.b.b();
        if (!URLUtil.isNetworkUrl(b) || c0295a.f() || com.kwad.sdk.core.download.kwai.b.a() || this.c.status == 4 || !b(c0295a)) {
            return false;
        }
        return com.kwad.sdk.core.download.kwai.b.a(c0295a.a(), this.b, b, this.i, this.j);
    }

    private boolean k() {
        boolean z = false;
        if (Build.VERSION.SDK_INT < 29) {
            if (this.b.mIsFromContent && com.kwad.sdk.core.config.b.K()) {
                z = p();
                if (z) {
                    com.kwad.sdk.core.report.a.f(this.b);
                }
            } else if (!this.b.mIsFromContent && com.kwad.sdk.core.config.b.au() && (z = p())) {
                com.kwad.sdk.core.report.a.g(this.b);
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
        String str = this.c.adBaseInfo.appPackageName;
        Context context = KsAdSDKImpl.get().getContext();
        if (context == null) {
            return;
        }
        if (ag.a(context, str)) {
            this.c.status = 12;
            return;
        }
        AdInfo adInfo = this.c;
        if (adInfo.status == 12) {
            adInfo.status = 0;
            adInfo.progress = 0;
        }
        AdInfo adInfo2 = this.c;
        if (adInfo2.status == 8) {
            String str2 = adInfo2.downloadFilePath;
            if (TextUtils.isEmpty(str2) || !new File(str2).exists()) {
                AdInfo adInfo3 = this.c;
                adInfo3.status = 0;
                adInfo3.progress = 0;
            }
        }
        if (this.c.status != 0 || (proxyForDownload = KsAdSDKImpl.get().getProxyForDownload()) == null) {
            return;
        }
        String downloadFilePath = proxyForDownload.getDownloadFilePath(DownloadParams.transform(this.c));
        if (TextUtils.isEmpty(downloadFilePath) || !new File(downloadFilePath).exists()) {
            return;
        }
        AdInfo adInfo4 = this.c;
        adInfo4.downloadFilePath = downloadFilePath;
        adInfo4.status = 8;
    }

    private boolean n() {
        String str = this.c.adConversionInfo.marketUrl;
        com.kwad.sdk.core.d.a.c("ApkDownloadHelper", "isMarKet URL Schema=" + str);
        boolean a2 = !TextUtils.isEmpty(str) ? com.kwad.sdk.utils.f.a(KsAdSDKImpl.get().getContext(), str, this.c.adBaseInfo.appPackageName) : false;
        if (a2) {
            com.kwad.sdk.core.report.a.k(this.b);
        }
        return a2;
    }

    private boolean o() {
        a aVar = this.h;
        if (aVar != null) {
            return aVar.a(new DialogInterface.OnClickListener() { // from class: com.kwad.sdk.core.download.a.b.4
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (i == -1) {
                        switch (b.this.c.status) {
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
        if (d.a(context, this.b, 1) == 1) {
            return true;
        }
        boolean c = ag.c(context, com.kwad.sdk.core.response.a.a.v(this.c));
        if (c) {
            com.kwad.sdk.core.report.a.e(this.b);
        }
        return c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        Context context = KsAdSDKImpl.get().getContext();
        if (context == null) {
            return;
        }
        if (com.ksad.download.c.b.a(context)) {
            com.kwad.sdk.core.download.d.a(context, this.c);
        } else {
            com.kwad.sdk.core.d.a.e("ApkDownloadHelper", "no network while download app");
        }
    }

    private void r() {
        Context context = KsAdSDKImpl.get().getContext();
        if (context == null) {
            return;
        }
        com.kwad.sdk.core.download.d.a(context, this.c.downloadId);
    }

    public int a(Context context, boolean z) {
        return a(new a.C0295a(context).a(z).b(false).d(false));
    }

    public int a(a.C0295a c0295a) {
        this.f = false;
        m();
        switch (this.c.status) {
            case 0:
            case 1:
            case 5:
            case 6:
            case 7:
                return d(c0295a);
            case 2:
            case 3:
                if (c0295a.e() && this.g) {
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
        return this.c.downloadId;
    }

    public void a(int i) {
        this.b.downloadSource = i;
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
        this.h = aVar;
    }

    @Override // com.kwad.sdk.core.download.c
    public void a(String str, int i, int i2, int i3) {
        if (this.c.downloadId.equals(str)) {
            AdInfo adInfo = this.c;
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
        AdInfo j = com.kwad.sdk.core.response.a.d.j(this.b);
        if (fVar.b()) {
            com.kwad.sdk.core.report.a.c(this.b);
            fVar.a();
            z = k();
            com.kwad.sdk.core.download.e.a().b(j, this.b);
        } else {
            z = false;
        }
        i.a(new Runnable() { // from class: com.kwad.sdk.core.download.a.b.2
            @Override // java.lang.Runnable
            public void run() {
                com.kwad.sdk.home.download.a.a().b(b.this.b);
                if (z) {
                    return;
                }
                com.kwad.sdk.home.download.a.a().c(b.this.b);
            }
        });
        com.kwad.sdk.core.a.a().d(j.downloadId);
        this.c.status = 12;
        l();
    }

    @Override // com.kwad.sdk.core.download.c
    public void a(String str, int i, String str2, com.kwad.sdk.core.download.f fVar) {
        if (this.c.downloadId.equals(str)) {
            this.c.status = 7;
            l();
            if (fVar.b()) {
                a.C0305a c0305a = new a.C0305a(i, str2);
                com.kwad.sdk.core.report.a.a(this.b, c0305a);
                com.kwad.sdk.core.report.d.b(this.b, this.c.adConversionInfo.appDownloadUrl, c0305a.toJson().toString());
                fVar.a();
            }
            if (this.c.adConversionInfo.retryH5TimeStep <= 0 || this.f) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis() - this.e;
            AdInfo adInfo = this.c;
            if (currentTimeMillis >= adInfo.adConversionInfo.retryH5TimeStep || TextUtils.isEmpty(com.kwad.sdk.core.response.a.a.G(adInfo))) {
                return;
            }
            AdWebViewActivityProxy.launch(KsAdSDKImpl.get().getContext(), this.b);
            this.f = true;
        }
    }

    @Override // com.kwad.sdk.core.download.c
    public void a(String str, com.kwad.sdk.core.download.f fVar) {
        if (this.c.downloadId.equals(str)) {
            if (this.c.status != 1) {
                if (fVar.b()) {
                    com.kwad.sdk.core.report.a.b(this.b);
                    fVar.a();
                }
                this.e = System.currentTimeMillis();
            }
            this.c.status = 1;
            l();
        }
    }

    @Override // com.kwad.sdk.core.download.c
    public void a(String str, String str2, com.kwad.sdk.core.download.f fVar) {
        if (this.c.downloadId.equals(str)) {
            AdInfo adInfo = this.c;
            adInfo.downloadFilePath = str2;
            adInfo.progress = 100;
            if (adInfo.status != 8 && !this.b.mDownloadFinishReported) {
                i.a(new Runnable() { // from class: com.kwad.sdk.core.download.a.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.kwad.sdk.home.download.a.a().a(b.this.b);
                    }
                });
                if (fVar.b()) {
                    com.kwad.sdk.core.report.a.e(this.b, this.d);
                    fVar.a();
                }
                com.kwad.sdk.core.download.e.a().a(this.c, this.b);
                this.b.mDownloadFinishReported = true;
            }
            this.c.status = 8;
            l();
            ApkCacheManager.a().b();
        }
    }

    @Override // com.kwad.sdk.core.download.c
    public String b() {
        return this.c.adBaseInfo.appPackageName;
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
        if (this.c.downloadId.equals(str)) {
            if (this.c.status != 4 && fVar.b()) {
                com.kwad.sdk.core.report.a.c(this.b, this.d);
                fVar.a();
            }
            this.c.status = 4;
            l();
        }
    }

    public int c() {
        m();
        int i = this.c.status;
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
        if (this.c.downloadId.equals(str)) {
            if (this.c.status != 2 && fVar.b()) {
                com.kwad.sdk.core.report.a.d(this.b, this.d);
                fVar.a();
            }
            this.c.status = 2;
            l();
        }
    }

    @Override // com.kwad.sdk.core.download.c
    public void d(String str, com.kwad.sdk.core.download.f fVar) {
        if (this.c.downloadId.equals(str)) {
            if (this.c.status != 5 && fVar.b()) {
                com.kwad.sdk.core.report.a.f(this.b, this.d);
                fVar.a();
            }
            this.c.status = 5;
            l();
        }
    }

    public boolean d() {
        switch (this.c.status) {
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
        return this.b;
    }

    @Override // com.kwad.sdk.core.download.c
    public void e(String str, com.kwad.sdk.core.download.f fVar) {
        if (this.c.downloadId.equals(str)) {
            com.kwad.sdk.core.report.a.d(this.b);
        }
    }

    public boolean f() {
        if (this.c.status == 0) {
            return n();
        }
        return false;
    }

    public void g() {
        i.a(new Runnable() { // from class: com.kwad.sdk.core.download.a.b.5
            @Override // java.lang.Runnable
            public void run() {
                com.kwad.sdk.home.download.a.a().d(b.this.b);
            }
        });
        if (ag.c(KsAdSDKImpl.get().getContext(), com.kwad.sdk.core.response.a.a.v(this.c))) {
            com.kwad.sdk.core.report.a.e(this.b);
        }
    }

    public void h() {
        String str = this.c.downloadFilePath;
        Context context = KsAdSDKImpl.get().getContext();
        if (context != null && !TextUtils.isEmpty(str)) {
            com.kwad.sdk.core.report.a.h(this.b);
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
