package com.kwad.components.core.c.a;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import com.kwad.components.core.c.a.a;
import com.kwad.components.core.c.kwai.b;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.page.AdWebViewVideoActivityProxy;
import com.kwad.components.core.page.DownloadLandPageActivity;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.KsApkDownloadListener;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.NetworkMonitor;
import com.kwad.sdk.core.diskcache.ApkCacheManager;
import com.kwad.sdk.core.download.f;
import com.kwad.sdk.core.download.h;
import com.kwad.sdk.core.report.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ab;
import com.kwad.sdk.utils.ae;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.utils.g;
import com.kwad.sdk.utils.t;
import com.kwad.sdk.utils.u;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class c implements NetworkMonitor.a, f, com.kwad.sdk.core.webview.a {
    @NonNull
    public AdTemplate Eg;
    public long Eh;
    public boolean Ei;
    public a Ej;
    public DialogInterface.OnShowListener Ek;
    public List<KsAppDownloadListener> El;
    public boolean downloadPauseEnable;
    @NonNull
    public AdInfo mAdInfo;
    public Handler mHandler;
    public DialogInterface.OnDismissListener mOnDismissListener;
    public JSONObject mReportExtData;

    /* loaded from: classes10.dex */
    public interface a {
        boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener);
    }

    public c(@NonNull AdTemplate adTemplate) {
        this(adTemplate, null, null);
    }

    public c(@NonNull AdTemplate adTemplate, @NonNull KsAppDownloadListener ksAppDownloadListener) {
        this(adTemplate, null, ksAppDownloadListener);
    }

    public c(@NonNull AdTemplate adTemplate, KsAppDownloadListener ksAppDownloadListener, String str, String str2) {
        this(adTemplate, null, null);
        AdInfo adInfo = this.mAdInfo;
        adInfo.adConversionInfo.appDownloadUrl = str;
        adInfo.adBaseInfo.appPackageName = str2;
        adInfo.downloadId = ab.dI(str);
    }

    public c(@NonNull AdTemplate adTemplate, JSONObject jSONObject) {
        this(adTemplate, jSONObject, null);
    }

    public c(@NonNull AdTemplate adTemplate, JSONObject jSONObject, KsAppDownloadListener ksAppDownloadListener) {
        this.mHandler = new Handler(Looper.getMainLooper());
        this.El = new ArrayList();
        this.Eg = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.a.d.bQ(adTemplate);
        this.mReportExtData = jSONObject;
        if (ksAppDownloadListener != null) {
            b(ksAppDownloadListener);
        }
        mH();
        com.kwad.sdk.core.download.e.sV().a(this, this.Eg);
        com.kwad.sdk.core.download.e.sV().am(this.Eg);
        this.downloadPauseEnable = com.kwad.sdk.core.response.a.a.bB(com.kwad.sdk.core.response.a.d.bQ(this.Eg));
        if (com.kwad.sdk.core.config.d.sj()) {
            NetworkMonitor.getInstance().a(KsAdSDKImpl.get().getContext(), this);
        }
        com.kwad.sdk.kwai.kwai.c.rd().af(this.Eg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull KsAppDownloadListener ksAppDownloadListener) {
        AdInfo adInfo = this.mAdInfo;
        int i = adInfo.progress;
        int i2 = adInfo.status;
        if (i2 == 0) {
            ksAppDownloadListener.onIdle();
        } else if (i2 == 1) {
            ksAppDownloadListener.onProgressUpdate(0);
            if (ksAppDownloadListener instanceof com.kwad.sdk.core.download.kwai.a) {
                ((com.kwad.sdk.core.download.kwai.a) ksAppDownloadListener).onDownloadStarted();
                return;
            }
            try {
                ksAppDownloadListener.onDownloadStarted();
            } catch (Throwable th) {
                com.kwad.sdk.core.e.b.printStackTraceOnly(th);
            }
        } else if (i2 == 2 || i2 == 3) {
            ksAppDownloadListener.onProgressUpdate(i);
        } else if (i2 == 4) {
            if (ksAppDownloadListener instanceof com.kwad.sdk.core.download.kwai.a) {
                ((com.kwad.sdk.core.download.kwai.a) ksAppDownloadListener).onPaused(i);
            }
            try {
                if (ksAppDownloadListener instanceof KsApkDownloadListener) {
                    ((KsApkDownloadListener) ksAppDownloadListener).onPaused(i);
                }
            } catch (Throwable unused) {
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

    public static void c(Context context, AdTemplate adTemplate) {
        if (context == null || adTemplate == null) {
            return;
        }
        DownloadLandPageActivity.launch(context, adTemplate, false);
    }

    private void mH() {
        com.kwad.sdk.core.download.e.sV();
        int bK = com.kwad.sdk.core.download.e.bK(mJ());
        if (bK != 0) {
            this.mAdInfo.status = bK;
        }
        mN();
        mM();
    }

    private boolean mL() {
        if (Build.VERSION.SDK_INT < 29) {
            if (this.Eg.mIsFromContent && com.kwad.sdk.core.config.d.rF()) {
                r1 = mU();
                if (r1) {
                    com.kwad.sdk.core.report.a.au(this.Eg);
                }
            } else if (!this.Eg.mIsFromContent && com.kwad.sdk.core.config.d.rX()) {
                boolean al = com.kwad.components.core.f.b.al(KsAdSDKImpl.get().getContext());
                com.kwad.sdk.core.e.b.d("ApkDownloadHelper", "handleForceOpenApp enableForceOpen: " + al);
                r1 = al ? mU() : false;
                if (r1) {
                    com.kwad.sdk.core.report.a.av(this.Eg);
                }
            }
        }
        return r1;
    }

    private void mM() {
        this.mHandler.post(new Runnable() { // from class: com.kwad.components.core.c.a.c.3
            @Override // java.lang.Runnable
            public final void run() {
                ArrayList<KsAppDownloadListener> arrayList = new ArrayList(c.this.El.size());
                arrayList.addAll(c.this.El);
                for (KsAppDownloadListener ksAppDownloadListener : arrayList) {
                    if (ksAppDownloadListener != null) {
                        c.this.a(ksAppDownloadListener);
                    }
                }
            }
        });
    }

    private void mN() {
        String str = this.mAdInfo.adBaseInfo.appPackageName;
        Context context = KsAdSDKImpl.get().getContext();
        if (context == null) {
            return;
        }
        if (ai.U(context, str)) {
            this.mAdInfo.status = 12;
            return;
        }
        AdInfo adInfo = this.mAdInfo;
        if (adInfo.status == 12) {
            adInfo.status = 0;
            adInfo.progress = 0;
        }
        int i = this.mAdInfo.status;
        if (i == 8 || i == 9) {
            String str2 = this.mAdInfo.downloadFilePath;
            if (TextUtils.isEmpty(str2) || !new File(str2).exists()) {
                AdInfo adInfo2 = this.mAdInfo;
                adInfo2.status = 0;
                adInfo2.progress = 0;
            }
        }
        AdInfo adInfo3 = this.mAdInfo;
        if (adInfo3.status == 0) {
            String w = com.kwad.sdk.core.download.a.w(adInfo3);
            if (TextUtils.isEmpty(w) || !new File(w).exists()) {
                return;
            }
            AdInfo adInfo4 = this.mAdInfo;
            adInfo4.downloadFilePath = w;
            adInfo4.status = 8;
        }
    }

    private boolean mP() {
        String str = this.mAdInfo.adConversionInfo.marketUrl;
        com.kwad.sdk.core.e.b.i("ApkDownloadHelper", "isMarKet URL Schema=" + str);
        boolean e = !TextUtils.isEmpty(str) ? com.kwad.sdk.utils.d.e(KsAdSDKImpl.get().getContext(), str, this.mAdInfo.adBaseInfo.appPackageName) : false;
        if (e) {
            com.kwad.sdk.core.report.a.m(this.Eg, 0);
        }
        return e;
    }

    private boolean mS() {
        a aVar = this.Ej;
        if (aVar != null) {
            return aVar.handleDownloadDialog(new DialogInterface.OnClickListener() { // from class: com.kwad.components.core.c.a.c.4
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    if (i == -1) {
                        switch (c.this.mAdInfo.status) {
                            case 0:
                            case 1:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                                c.this.mW();
                                return;
                            case 2:
                            case 3:
                            case 10:
                            default:
                                return;
                            case 8:
                            case 9:
                            case 11:
                                c.this.mV();
                                return;
                            case 12:
                                c.this.mT();
                                return;
                        }
                    }
                }
            });
        }
        return false;
    }

    private boolean mU() {
        Context context = KsAdSDKImpl.get().getContext();
        if (d.a(new a.C0625a(context).L(this.Eg), 1) == 1) {
            return true;
        }
        boolean W = ai.W(context, com.kwad.sdk.core.response.a.a.ag(this.mAdInfo));
        if (W) {
            com.kwad.sdk.core.report.a.at(this.Eg);
        }
        return W;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mW() {
        com.kwad.sdk.core.download.a.x(this.mAdInfo);
    }

    private int n(a.C0625a c0625a) {
        Context context = c0625a.getContext();
        String bO = com.kwad.sdk.core.response.a.a.bO(this.mAdInfo);
        if (com.kwad.sdk.utils.d.a(context, bO, this.Eg)) {
            com.kwad.sdk.core.report.a.m(this.Eg, 1);
            return 0;
        } else if (com.kwad.sdk.utils.d.e(context, bO, com.kwad.sdk.core.response.a.a.ag(this.mAdInfo))) {
            com.kwad.sdk.core.report.a.m(this.Eg, 0);
            return 0;
        } else if (mS()) {
            return 0;
        } else {
            if (!ae.isNetworkConnected(context)) {
                t.z(context, u.ck(context));
                return 0;
            } else if (c0625a.mE() && com.kwad.sdk.core.config.d.rO()) {
                return o(c0625a);
            } else {
                if (c0625a.mB()) {
                    return p(c0625a);
                }
                if (q(c0625a)) {
                    return 0;
                }
                mW();
                return 0;
            }
        }
    }

    private int o(a.C0625a c0625a) {
        Context context = c0625a.getContext();
        AdTemplate adTemplate = c0625a.getAdTemplate();
        int mF = c0625a.mF();
        if (mF == 1) {
            mW();
            return 0;
        }
        if (mF == 2 && com.kwad.sdk.core.response.a.b.bt(adTemplate)) {
            com.kwad.components.core.c.kwai.b.a(new b.a().ah(context).K(adTemplate).ak(com.kwad.sdk.core.response.a.b.bs(adTemplate)).a(this.Ek).c(this.mOnDismissListener).ms());
        }
        return 0;
    }

    private int p(a.C0625a c0625a) {
        Context context = c0625a.getContext();
        AdTemplate adTemplate = c0625a.getAdTemplate();
        int s = s(c0625a);
        if (s == 1) {
            if (com.kwad.sdk.core.response.a.b.bt(adTemplate)) {
                com.kwad.components.core.c.kwai.b.a(new b.a().ah(context).K(adTemplate).ak(com.kwad.sdk.core.response.a.b.bs(adTemplate)).a(this.Ek).c(this.mOnDismissListener).ms());
            }
            return 0;
        } else if (s == 2) {
            c(c0625a.getContext(), c0625a.getAdTemplate());
            return 0;
        } else if (s == 3 || q(c0625a)) {
            return 0;
        } else {
            mW();
            return 0;
        }
    }

    private boolean q(a.C0625a c0625a) {
        if (c0625a.mz() || this.mAdInfo.status == 4 || !com.kwad.sdk.core.response.a.b.bw(this.Eg) || !r(c0625a)) {
            return false;
        }
        return com.kwad.components.core.c.kwai.b.a(new b.a().ah(c0625a.getContext()).K(this.Eg).ak(com.kwad.sdk.core.response.a.b.bv(this.Eg)).a(this.Ek).c(this.mOnDismissListener).ms());
    }

    public static boolean r(a.C0625a c0625a) {
        AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(c0625a.getAdTemplate());
        if (com.kwad.sdk.core.response.a.a.aN(bQ) && (DownloadLandPageActivity.showingAdWebViewLandPage || AdWebViewVideoActivityProxy.showingAdWebViewVideoActivity || c0625a.getAdTemplate().isWebViewDownload)) {
            return true;
        }
        return com.kwad.sdk.core.response.a.a.aO(bQ) && !ae.isWifiConnected(c0625a.getContext());
    }

    public static int s(a.C0625a c0625a) {
        AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(c0625a.getAdTemplate());
        if (bQ.downloadSafeInfo.complianceInfo != null) {
            int cC = c0625a.cC();
            return cC != 2 ? cC != 3 ? bQ.downloadSafeInfo.complianceInfo.actionBarType : bQ.downloadSafeInfo.complianceInfo.materialJumpType : bQ.downloadSafeInfo.complianceInfo.describeBarType;
        }
        return 0;
    }

    public final void a(a aVar) {
        this.Ej = aVar;
    }

    @Override // com.kwad.sdk.core.NetworkMonitor.a
    public final void a(NetworkMonitor.NetworkState networkState) {
        if (this.mAdInfo.status == 7 && networkState == NetworkMonitor.NetworkState.NETWORK_WIFI) {
            mW();
        }
    }

    @Override // com.kwad.sdk.core.download.f
    public final void a(String str, int i, int i2, int i3) {
        if (this.mAdInfo.downloadId.equals(str)) {
            AdInfo adInfo = this.mAdInfo;
            adInfo.status = 3;
            adInfo.progress = i;
            adInfo.soFarBytes = i2;
            adInfo.totalBytes = i3;
            mM();
        }
    }

    @Override // com.kwad.sdk.core.download.f
    public final void a(String str, int i, h hVar) {
        final boolean z;
        AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(this.Eg);
        if (hVar.sX()) {
            com.kwad.sdk.core.report.a.ar(this.Eg);
            hVar.sW();
            z = mL();
            com.kwad.sdk.kwai.kwai.c.rd().ai(this.Eg);
            com.kwad.sdk.kwai.kwai.c.rd().ag(this.Eg);
            com.kwad.sdk.kwai.kwai.b.ra().ab(this.Eg);
        } else {
            z = false;
        }
        g.runOnDefaultExecutor(new Runnable() { // from class: com.kwad.components.core.c.a.c.2
            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.sdk.components.c.f(com.kwad.components.kwai.kwai.a.class);
            }
        });
        com.kwad.sdk.core.a.rD().bp(bQ.downloadId);
        this.mAdInfo.status = 12;
        mM();
    }

    @Override // com.kwad.sdk.core.download.f
    public final void a(String str, int i, String str2, h hVar) {
        if (this.mAdInfo.downloadId.equals(str)) {
            this.mAdInfo.status = 7;
            mM();
            if (hVar.sX()) {
                a.C0663a c0663a = new a.C0663a(i, str2);
                com.kwad.sdk.core.report.a.a(this.Eg, c0663a);
                com.kwad.components.core.j.a.og().b(this.Eg, this.mAdInfo.adConversionInfo.appDownloadUrl, c0663a.toJson().toString());
                hVar.sW();
            }
            if (this.mAdInfo.adConversionInfo.retryH5TimeStep <= 0 || this.Ei) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis() - this.Eh;
            AdInfo adInfo = this.mAdInfo;
            if (currentTimeMillis >= adInfo.adConversionInfo.retryH5TimeStep || TextUtils.isEmpty(com.kwad.sdk.core.response.a.a.ar(adInfo))) {
                return;
            }
            AdWebViewActivityProxy.launch(KsAdSDKImpl.get().getContext(), this.Eg);
            this.Ei = true;
        }
    }

    @Override // com.kwad.sdk.core.download.f
    public final void a(String str, h hVar) {
        if (this.mAdInfo.downloadId.equals(str)) {
            if (this.mAdInfo.status != 1) {
                if (hVar.sX()) {
                    com.kwad.sdk.core.report.a.aq(this.Eg);
                    hVar.sW();
                }
                this.Eh = System.currentTimeMillis();
            }
            this.mAdInfo.status = 1;
            mM();
        }
    }

    @Override // com.kwad.sdk.core.download.f
    public final void a(String str, String str2, h hVar) {
        if (this.mAdInfo.downloadId.equals(str)) {
            AdInfo adInfo = this.mAdInfo;
            adInfo.downloadFilePath = str2;
            adInfo.progress = 100;
            if (adInfo.status != 8 && !this.Eg.mDownloadFinishReported) {
                g.runOnDefaultExecutor(new Runnable() { // from class: com.kwad.components.core.c.a.c.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.kwad.sdk.components.c.f(com.kwad.components.kwai.kwai.a.class);
                    }
                });
                if (hVar.sX()) {
                    com.kwad.sdk.core.report.a.f(this.Eg, this.mReportExtData);
                    hVar.sW();
                }
                com.kwad.sdk.kwai.kwai.c.rd().ah(this.Eg);
                com.kwad.sdk.kwai.kwai.c.rd().af(this.Eg);
                com.kwad.sdk.kwai.kwai.b.ra().aa(this.Eg);
                this.Eg.mDownloadFinishReported = true;
            }
            this.mAdInfo.status = 8;
            mM();
            ApkCacheManager.getInstance().sG();
        }
    }

    public final void ah(int i) {
        this.Eg.downloadSource = i;
    }

    @Override // com.kwad.sdk.core.download.f
    public final void al(String str) {
        if (this.mAdInfo.downloadId.equals(str)) {
            com.kwad.sdk.core.report.a.as(this.Eg);
        }
    }

    @UiThread
    public final void b(final KsAppDownloadListener ksAppDownloadListener) {
        if (ksAppDownloadListener == null) {
            return;
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.mHandler.post(new Runnable() { // from class: com.kwad.components.core.c.a.c.6
                @Override // java.lang.Runnable
                public final void run() {
                    if (c.this.El.contains(ksAppDownloadListener)) {
                        return;
                    }
                    c.this.El.add(0, ksAppDownloadListener);
                }
            });
        } else if (!this.El.contains(ksAppDownloadListener)) {
            this.El.add(0, ksAppDownloadListener);
        }
        mN();
        a(ksAppDownloadListener);
    }

    @Override // com.kwad.sdk.core.download.f
    public final void b(String str, h hVar) {
        if (this.mAdInfo.downloadId.equals(str)) {
            if (this.mAdInfo.status != 4 && hVar.sX()) {
                com.kwad.sdk.core.report.a.d(this.Eg, this.mReportExtData);
                hVar.sW();
            }
            this.mAdInfo.status = 4;
            mM();
        }
    }

    public final void c(final KsAppDownloadListener ksAppDownloadListener) {
        if (ksAppDownloadListener == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.El.remove(ksAppDownloadListener);
        } else {
            this.mHandler.post(new Runnable() { // from class: com.kwad.components.core.c.a.c.7
                @Override // java.lang.Runnable
                public final void run() {
                    c.this.El.remove(ksAppDownloadListener);
                }
            });
        }
    }

    @Override // com.kwad.sdk.core.download.f
    public final void c(String str, h hVar) {
        if (this.mAdInfo.downloadId.equals(str)) {
            if (this.mAdInfo.status != 2 && hVar.sX()) {
                com.kwad.sdk.core.report.a.e(this.Eg, this.mReportExtData);
                hVar.sW();
            }
            this.mAdInfo.status = 2;
            mM();
        }
    }

    public final void clear() {
        mX();
        com.kwad.sdk.core.download.e.sV().a(this);
        if (com.kwad.sdk.core.config.d.sj()) {
            NetworkMonitor.getInstance().a(this);
        }
    }

    public final void d(KsAppDownloadListener ksAppDownloadListener) {
        if (ksAppDownloadListener == null) {
            return;
        }
        mN();
        a(ksAppDownloadListener);
    }

    @Override // com.kwad.sdk.core.download.f
    public final void d(String str, h hVar) {
        if (this.mAdInfo.downloadId.equals(str)) {
            if (this.mAdInfo.status != 5 && hVar.sX()) {
                com.kwad.sdk.core.report.a.g(this.Eg, this.mReportExtData);
                hVar.sW();
            }
            this.mAdInfo.status = 5;
            mM();
        }
    }

    @Override // com.kwad.sdk.core.download.f
    public final void e(String str, h hVar) {
        if (this.mAdInfo.downloadId.equals(str)) {
            if (hVar.sX()) {
                com.kwad.sdk.core.report.a.h(this.Eg, 2);
                hVar.sW();
            }
            this.mAdInfo.status = 9;
            mM();
        }
    }

    public final int m(a.C0625a c0625a) {
        this.Ei = false;
        mN();
        switch (this.mAdInfo.status) {
            case 0:
            case 1:
            case 5:
            case 6:
            case 7:
                return n(c0625a);
            case 2:
            case 3:
                if (c0625a.mx() && this.downloadPauseEnable) {
                    com.kwad.sdk.core.download.a.bD(this.mAdInfo.downloadId);
                    return 0;
                }
                return 0;
            case 4:
                mW();
                return 0;
            case 8:
            case 9:
            case 11:
                mV();
                return 0;
            case 10:
            default:
                return 0;
            case 12:
                mT();
                return 0;
        }
    }

    public final int mI() {
        mN();
        int i = this.mAdInfo.status;
        if (i == 3) {
            return 2;
        }
        return i;
    }

    @Override // com.kwad.sdk.core.download.f
    public final String mJ() {
        return this.mAdInfo.downloadId;
    }

    @Override // com.kwad.sdk.core.download.f
    public final String mK() {
        return this.mAdInfo.adBaseInfo.appPackageName;
    }

    public final boolean mO() {
        switch (this.mAdInfo.status) {
            case 0:
            case 1:
            case 4:
            case 5:
            case 6:
            case 7:
                return mP();
            case 2:
            case 3:
            case 10:
            default:
                return false;
            case 8:
            case 9:
            case 11:
                mV();
                return true;
            case 12:
                mT();
                return true;
        }
    }

    @NonNull
    public final AdTemplate mQ() {
        return this.Eg;
    }

    public final boolean mR() {
        if (this.mAdInfo.status == 0) {
            return mP();
        }
        return false;
    }

    public final void mT() {
        g.runOnDefaultExecutor(new Runnable() { // from class: com.kwad.components.core.c.a.c.5
            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.sdk.components.c.f(com.kwad.components.kwai.kwai.a.class);
            }
        });
        if (ai.W(KsAdSDKImpl.get().getContext(), com.kwad.sdk.core.response.a.a.ag(this.mAdInfo))) {
            com.kwad.sdk.core.report.a.at(this.Eg);
        }
    }

    public final void mV() {
        if (ai.X(KsAdSDKImpl.get().getContext(), this.mAdInfo.downloadFilePath)) {
            com.kwad.sdk.core.report.a.h(this.Eg, 1);
        }
    }

    @Override // com.kwad.sdk.core.webview.a
    public final void mX() {
        List<KsAppDownloadListener> list = this.El;
        if (list != null) {
            list.clear();
        }
    }

    public final void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    public final void setOnShowListener(DialogInterface.OnShowListener onShowListener) {
        this.Ek = onShowListener;
    }
}
