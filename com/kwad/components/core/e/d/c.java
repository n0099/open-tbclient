package com.kwad.components.core.e.d;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import com.kwad.components.core.e.c.b;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.page.AdWebViewVideoActivityProxy;
import com.kwad.components.core.page.DownloadLandPageActivity;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.KsApkDownloadListener;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.NetworkMonitor;
import com.kwad.sdk.core.diskcache.ApkCacheManager;
import com.kwad.sdk.core.report.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.m.l;
import com.kwad.sdk.utils.ad;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.ak;
import com.kwad.sdk.utils.g;
import com.kwad.sdk.utils.v;
import com.kwad.sdk.utils.w;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class c implements NetworkMonitor.a, com.kwad.sdk.core.download.c, com.kwad.sdk.core.webview.a {
    @NonNull
    public AdTemplate KN;
    public boolean KO;
    public a KP;
    public DialogInterface.OnShowListener KQ;
    public List<KsAppDownloadListener> KR;
    public boolean downloadPauseEnable;
    public Handler fS;
    @NonNull
    public AdInfo mAdInfo;
    public DialogInterface.OnDismissListener mOnDismissListener;
    public JSONObject mReportExtData;

    /* loaded from: classes10.dex */
    public interface a {
        boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener);
    }

    public c(@NonNull AdTemplate adTemplate) {
        this(adTemplate, null, null);
    }

    private int A(a.C0644a c0644a) {
        Activity m186do = l.m186do(c0644a.getContext());
        if (m186do != null && com.kwad.sdk.core.response.b.a.U(this.mAdInfo) && !c0644a.ns() && !c0644a.nx()) {
            c0644a.ak(1);
            com.kwad.components.core.e.e.e.a(m186do, c0644a);
            return 18;
        }
        return nU();
    }

    public static int B(a.C0644a c0644a) {
        AdInfo dP = com.kwad.sdk.core.response.b.e.dP(c0644a.getAdTemplate());
        if (dP.downloadSafeInfo.complianceInfo != null) {
            int cU = c0644a.cU();
            if (cU != 2) {
                if (cU != 3) {
                    return dP.downloadSafeInfo.complianceInfo.actionBarType;
                }
                return dP.downloadSafeInfo.complianceInfo.materialJumpType;
            }
            return dP.downloadSafeInfo.complianceInfo.describeBarType;
        }
        return 0;
    }

    private boolean u(a.C0644a c0644a) {
        boolean h = com.kwad.sdk.utils.d.h(c0644a.getContext(), this.KN);
        if (h) {
            com.kwad.sdk.core.report.a.n(this.KN, 0);
        }
        return h;
    }

    public final void a(a aVar) {
        this.KP = aVar;
    }

    public final void aq(int i) {
        this.KN.downloadSource = i;
    }

    @UiThread
    public final void b(final KsAppDownloadListener ksAppDownloadListener) {
        if (ksAppDownloadListener == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            if (!this.KR.contains(ksAppDownloadListener)) {
                this.KR.add(0, ksAppDownloadListener);
            }
        } else {
            this.fS.post(new Runnable() { // from class: com.kwad.components.core.e.d.c.7
                @Override // java.lang.Runnable
                public final void run() {
                    if (!c.this.KR.contains(ksAppDownloadListener)) {
                        c.this.KR.add(0, ksAppDownloadListener);
                    }
                }
            });
        }
        nR();
        a(ksAppDownloadListener);
    }

    public final void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    public final void setOnShowListener(DialogInterface.OnShowListener onShowListener) {
        this.KQ = onShowListener;
    }

    public final boolean t(a.C0644a c0644a) {
        if (this.mAdInfo.status == 0 && u(c0644a)) {
            return true;
        }
        return false;
    }

    public c(@NonNull AdTemplate adTemplate, @NonNull KsAppDownloadListener ksAppDownloadListener) {
        this(adTemplate, null, ksAppDownloadListener);
    }

    public static int c(Context context, AdTemplate adTemplate) {
        if (context != null && adTemplate != null) {
            DownloadLandPageActivity.launch(context, adTemplate, false);
            return 9;
        }
        return 9;
    }

    @Override // com.kwad.sdk.core.download.c
    public final void b(String str, com.kwad.sdk.core.download.e eVar) {
        if (!this.mAdInfo.downloadId.equals(str)) {
            return;
        }
        if (this.mAdInfo.status != 4 && eVar.BY()) {
            com.kwad.sdk.core.report.a.c(this.KN, this.mReportExtData);
            eVar.BX();
            com.kwad.sdk.commercial.b.a.aV(this.KN);
        }
        this.mAdInfo.status = 4;
        nQ();
    }

    @Override // com.kwad.sdk.core.download.c
    public final void e(String str, com.kwad.sdk.core.download.e eVar) {
        if (!this.mAdInfo.downloadId.equals(str)) {
            return;
        }
        this.mAdInfo.status = 9;
        nQ();
        if (eVar.BY()) {
            com.kwad.sdk.core.report.a.k(this.KN, 2);
            eVar.BX();
            com.kwad.sdk.commercial.b.a.aZ(this.KN);
        }
    }

    @Override // com.kwad.sdk.core.download.c
    public final void f(String str, com.kwad.sdk.core.download.e eVar) {
        if (!this.mAdInfo.downloadId.equals(str)) {
            return;
        }
        nR();
        if (eVar.BY()) {
            eVar.BX();
            com.kwad.sdk.commercial.b.a.bb(this.KN);
        }
    }

    @Override // com.kwad.sdk.core.download.c
    public final void g(String str, com.kwad.sdk.core.download.e eVar) {
        if (this.mAdInfo.downloadId.equals(str) && eVar.BY()) {
            eVar.BX();
            com.kwad.sdk.core.report.a.bJ(this.KN);
            com.kwad.sdk.commercial.b.a.aY(this.KN);
        }
    }

    public c(@NonNull AdTemplate adTemplate, KsAppDownloadListener ksAppDownloadListener, String str, String str2) {
        this(adTemplate, null, null);
        AdInfo adInfo = this.mAdInfo;
        adInfo.adConversionInfo.appDownloadUrl = str;
        adInfo.adBaseInfo.appPackageName = str2;
        adInfo.downloadId = ad.bn(str);
    }

    @Override // com.kwad.sdk.core.download.c
    public final void a(String str, int i, int i2, int i3) {
        if (!this.mAdInfo.downloadId.equals(str)) {
            return;
        }
        AdInfo adInfo = this.mAdInfo;
        adInfo.status = 3;
        adInfo.progress = i;
        adInfo.soFarBytes = i2;
        adInfo.totalBytes = i3;
        nQ();
    }

    public c(@NonNull AdTemplate adTemplate, JSONObject jSONObject) {
        this(adTemplate, jSONObject, null);
    }

    @Override // com.kwad.sdk.core.download.c
    public final void a(String str, com.kwad.sdk.core.download.e eVar) {
        if (!this.mAdInfo.downloadId.equals(str)) {
            return;
        }
        this.mAdInfo.status = 1;
        nQ();
        if (eVar.BY()) {
            this.mAdInfo.mStartDownloadTime = SystemClock.elapsedRealtime();
            com.kwad.sdk.core.report.a.bI(this.KN);
            eVar.BX();
            com.kwad.sdk.commercial.b.a.o(this.KN);
        }
    }

    @Override // com.kwad.sdk.core.download.c
    public final void c(String str, com.kwad.sdk.core.download.e eVar) {
        if (!this.mAdInfo.downloadId.equals(str)) {
            return;
        }
        if (this.mAdInfo.status != 2 && eVar.BY()) {
            com.kwad.sdk.core.report.a.d(this.KN, this.mReportExtData);
            eVar.BX();
            com.kwad.sdk.commercial.b.a.aW(this.KN);
        }
        this.mAdInfo.status = 2;
        nQ();
    }

    public c(@NonNull AdTemplate adTemplate, JSONObject jSONObject, KsAppDownloadListener ksAppDownloadListener) {
        this.fS = new Handler(Looper.getMainLooper());
        this.KR = new ArrayList();
        this.KN = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.b.e.dP(adTemplate);
        this.mReportExtData = jSONObject;
        if (ksAppDownloadListener != null) {
            b(ksAppDownloadListener);
        }
        nL();
        this.downloadPauseEnable = com.kwad.sdk.core.response.b.a.cz(com.kwad.sdk.core.response.b.e.dP(this.KN));
        nK();
        com.kwad.sdk.a.a.c.yT().aN(this.KN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull KsAppDownloadListener ksAppDownloadListener) {
        AdInfo adInfo = this.mAdInfo;
        int i = adInfo.progress;
        switch (adInfo.status) {
            case 0:
            case 5:
                ksAppDownloadListener.onIdle();
                return;
            case 1:
                ksAppDownloadListener.onProgressUpdate(0);
                if (ksAppDownloadListener instanceof com.kwad.sdk.core.download.a.a) {
                    ((com.kwad.sdk.core.download.a.a) ksAppDownloadListener).onDownloadStarted();
                    return;
                }
                try {
                    ksAppDownloadListener.onDownloadStarted();
                    return;
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.c.printStackTraceOnly(th);
                    return;
                }
            case 2:
            case 3:
                ksAppDownloadListener.onProgressUpdate(i);
                return;
            case 4:
                if (ksAppDownloadListener instanceof com.kwad.sdk.core.download.a.a) {
                    ((com.kwad.sdk.core.download.a.a) ksAppDownloadListener).onPaused(i);
                }
                try {
                    if (ksAppDownloadListener instanceof KsApkDownloadListener) {
                        ((KsApkDownloadListener) ksAppDownloadListener).onPaused(i);
                        return;
                    }
                    return;
                } catch (Throwable unused) {
                    return;
                }
            case 6:
            case 10:
            case 11:
            default:
                return;
            case 7:
                ksAppDownloadListener.onDownloadFailed();
                return;
            case 8:
            case 9:
                ksAppDownloadListener.onDownloadFinished();
                return;
            case 12:
                ksAppDownloadListener.onInstalled();
                return;
        }
    }

    private int v(a.C0644a c0644a) {
        Context context = c0644a.getContext();
        if (com.kwad.sdk.utils.d.a(context, com.kwad.sdk.core.response.b.a.cN(this.mAdInfo), this.KN)) {
            com.kwad.sdk.core.report.a.n(this.KN, 1);
            return 11;
        } else if (u(c0644a)) {
            return 11;
        } else {
            if (nT()) {
                return 10;
            }
            if (!ag.isNetworkConnected(context)) {
                v.O(context, w.bY(context));
                return 2;
            } else if (c0644a.nH() && com.kwad.sdk.core.config.d.AD()) {
                return w(c0644a);
            } else {
                if (com.kwad.sdk.core.response.b.e.ee(this.KN) && c0644a.nJ() != 2) {
                    return c(c0644a.getContext(), c0644a.getAdTemplate());
                }
                if (c0644a.nD()) {
                    return x(c0644a);
                }
                if (y(c0644a)) {
                    return 8;
                }
                return nX();
            }
        }
    }

    private void nL() {
        com.kwad.sdk.core.download.b.BU();
        int db = com.kwad.sdk.core.download.b.db(nN());
        if (db != 0) {
            this.mAdInfo.status = db;
        }
        nR();
        nQ();
    }

    private void nQ() {
        this.fS.post(new Runnable() { // from class: com.kwad.components.core.e.d.c.3
            @Override // java.lang.Runnable
            public final void run() {
                ArrayList<KsAppDownloadListener> arrayList = new ArrayList(c.this.KR.size());
                arrayList.addAll(c.this.KR);
                for (KsAppDownloadListener ksAppDownloadListener : arrayList) {
                    if (ksAppDownloadListener != null) {
                        c.this.a(ksAppDownloadListener);
                    }
                }
            }
        });
    }

    private boolean nT() {
        a aVar = this.KP;
        if (aVar != null) {
            return aVar.handleDownloadDialog(new DialogInterface.OnClickListener() { // from class: com.kwad.components.core.e.d.c.4
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
                                c.this.nX();
                                return;
                            case 2:
                            case 3:
                            case 10:
                            default:
                                return;
                            case 8:
                            case 9:
                            case 11:
                                c.this.nW();
                                return;
                            case 12:
                                c.this.nU();
                                return;
                        }
                    }
                }
            });
        }
        return false;
    }

    private boolean nV() {
        Context context = KsAdSDKImpl.get().getContext();
        if (d.a(new a.C0644a(context).aq(this.KN), 1) == 1) {
            return true;
        }
        boolean ap = ak.ap(context, com.kwad.sdk.core.response.b.a.ay(this.mAdInfo));
        if (ap) {
            com.kwad.sdk.core.report.a.bK(this.KN);
        }
        return ap;
    }

    public final void clear() {
        oa();
        com.kwad.sdk.core.download.b.BU().a(this);
        if (com.kwad.sdk.core.config.d.Ba()) {
            NetworkMonitor.getInstance().a(this);
        }
    }

    public final void nK() {
        com.kwad.sdk.core.download.b.BU().a(this, this.KN);
        if (com.kwad.sdk.core.config.d.Ba()) {
            NetworkMonitor.getInstance().a(KsAdSDKImpl.get().getContext(), this);
        }
    }

    public final int nM() {
        nR();
        int i = this.mAdInfo.status;
        if (i == 3) {
            return 2;
        }
        return i;
    }

    @Override // com.kwad.sdk.core.download.c
    public final String nN() {
        return this.mAdInfo.downloadId;
    }

    @Override // com.kwad.sdk.core.download.c
    public final String nO() {
        return this.mAdInfo.adBaseInfo.appPackageName;
    }

    @NonNull
    public final AdTemplate nS() {
        return this.KN;
    }

    public final int nU() {
        g.execute(new Runnable() { // from class: com.kwad.components.core.e.d.c.5
            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.sdk.components.c.f(com.kwad.components.a.a.a.class);
            }
        });
        if (ak.ap(KsAdSDKImpl.get().getContext(), com.kwad.sdk.core.response.b.a.ay(this.mAdInfo))) {
            com.kwad.sdk.core.report.a.bK(this.KN);
            return 6;
        }
        return 6;
    }

    public final int nW() {
        ak.a(this.mAdInfo.downloadFilePath, new ak.a() { // from class: com.kwad.components.core.e.d.c.6
            @Override // com.kwad.sdk.utils.ak.a
            public final void f(Throwable th) {
                com.kwad.sdk.commercial.b.a.j(c.this.KN, 100003, Log.getStackTraceString(th));
            }

            @Override // com.kwad.sdk.utils.ak.a
            public final void ob() {
                com.kwad.sdk.core.report.a.k(c.this.KN, 1);
                com.kwad.sdk.commercial.b.a.aZ(c.this.KN);
            }
        });
        return 7;
    }

    public final int nX() {
        com.kwad.sdk.core.download.a.H(this.mAdInfo);
        return 3;
    }

    public final int nY() {
        com.kwad.sdk.core.download.a.cY(this.mAdInfo.downloadId);
        return 4;
    }

    public final int nZ() {
        nX();
        return 5;
    }

    @Override // com.kwad.sdk.core.webview.a
    public final void oa() {
        List<KsAppDownloadListener> list = this.KR;
        if (list != null) {
            list.clear();
        }
    }

    private boolean nP() {
        boolean z = false;
        if (Build.VERSION.SDK_INT < 29) {
            if (this.KN.mIsFromContent && com.kwad.sdk.core.config.d.Al()) {
                z = nV();
                if (z) {
                    com.kwad.sdk.core.report.a.bL(this.KN);
                }
            } else if (!this.KN.mIsFromContent && com.kwad.sdk.core.config.d.AP()) {
                boolean aa = com.kwad.components.core.k.b.aa(KsAdSDKImpl.get().getContext());
                com.kwad.sdk.core.e.c.d("ApkDownloadHelper", "handleForceOpenApp enableForceOpen: " + aa);
                if (aa) {
                    z = nV();
                }
                if (z) {
                    com.kwad.sdk.core.report.a.bM(this.KN);
                }
            }
        }
        return z;
    }

    private int w(a.C0644a c0644a) {
        Context context = c0644a.getContext();
        AdTemplate adTemplate = c0644a.getAdTemplate();
        int nI = c0644a.nI();
        if (nI != 1) {
            if (nI != 2) {
                return 1;
            }
            if (com.kwad.sdk.core.response.b.b.cW(adTemplate)) {
                com.kwad.components.core.e.c.b.a(context, new b.a().ap(adTemplate).ae(com.kwad.sdk.core.response.b.b.cV(adTemplate)).a(this.KQ).c(this.mOnDismissListener).nm());
                return 8;
            }
            return 8;
        }
        return nX();
    }

    public static boolean z(a.C0644a c0644a) {
        AdInfo dP = com.kwad.sdk.core.response.b.e.dP(c0644a.getAdTemplate());
        if (com.kwad.sdk.core.response.b.a.bt(dP) && (DownloadLandPageActivity.showingAdWebViewLandPage || AdWebViewVideoActivityProxy.showingAdWebViewVideoActivity || c0644a.getAdTemplate().isWebViewDownload)) {
            return true;
        }
        if (com.kwad.sdk.core.response.b.a.bu(dP) && !ag.isWifiConnected(c0644a.getContext())) {
            return true;
        }
        return false;
    }

    public final int r(a.C0644a c0644a) {
        int i = this.mAdInfo.status;
        if (i != 0 && i != 1) {
            switch (i) {
                case 4:
                case 5:
                case 6:
                case 7:
                    break;
                case 8:
                case 9:
                case 10:
                case 11:
                    return nW();
                case 12:
                    return A(c0644a);
                default:
                    return 0;
            }
        }
        if (!u(c0644a)) {
            return 0;
        }
        return 11;
    }

    private int x(a.C0644a c0644a) {
        Context context = c0644a.getContext();
        AdTemplate adTemplate = c0644a.getAdTemplate();
        int B = B(c0644a);
        if (B != 1) {
            if (B != 2) {
                if (B == 3) {
                    return 1;
                }
                if (y(c0644a)) {
                    return 8;
                }
                return nX();
            }
            return c(c0644a.getContext(), c0644a.getAdTemplate());
        }
        if (com.kwad.sdk.core.response.b.b.cW(adTemplate)) {
            com.kwad.components.core.e.c.b.a(context, new b.a().ap(adTemplate).ae(com.kwad.sdk.core.response.b.b.cV(adTemplate)).a(this.KQ).c(this.mOnDismissListener).nm());
        }
        return 8;
    }

    private boolean y(a.C0644a c0644a) {
        if (!c0644a.nB() && this.mAdInfo.status != 4 && com.kwad.sdk.core.response.b.b.cZ(this.KN) && z(c0644a)) {
            return com.kwad.components.core.e.c.b.a(c0644a.getContext(), new b.a().ap(this.KN).ae(com.kwad.sdk.core.response.b.b.cY(this.KN)).a(this.KQ).c(this.mOnDismissListener).nm());
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final int s(a.C0644a c0644a) {
        this.KO = false;
        nR();
        switch (this.mAdInfo.status) {
            case 0:
            case 1:
            case 5:
            case 6:
            case 7:
                return v(c0644a);
            case 2:
            case 3:
                if (c0644a.nz() && this.downloadPauseEnable) {
                    return nY();
                }
                break;
            case 4:
                return nZ();
            case 8:
            case 9:
            case 11:
                return nW();
            case 12:
                return A(c0644a);
        }
        return 0;
    }

    @Override // com.kwad.sdk.core.NetworkMonitor.a
    public final void a(NetworkMonitor.NetworkState networkState) {
        if (this.mAdInfo.status == 7 && networkState == NetworkMonitor.NetworkState.NETWORK_WIFI) {
            nX();
        }
    }

    public final void c(final KsAppDownloadListener ksAppDownloadListener) {
        if (ksAppDownloadListener == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.KR.remove(ksAppDownloadListener);
        } else {
            this.fS.post(new Runnable() { // from class: com.kwad.components.core.e.d.c.8
                @Override // java.lang.Runnable
                public final void run() {
                    c.this.KR.remove(ksAppDownloadListener);
                }
            });
        }
    }

    public final void d(KsAppDownloadListener ksAppDownloadListener) {
        if (ksAppDownloadListener == null) {
            return;
        }
        nR();
        a(ksAppDownloadListener);
    }

    @Override // com.kwad.sdk.core.download.c
    public final void a(String str, int i, String str2, com.kwad.sdk.core.download.e eVar) {
        if (!this.mAdInfo.downloadId.equals(str)) {
            return;
        }
        this.mAdInfo.status = 7;
        nQ();
        if (eVar.BY()) {
            a.C0711a c0711a = new a.C0711a(i, str2);
            com.kwad.sdk.core.report.a.a(this.KN, c0711a);
            com.kwad.components.core.o.a.pX().a(this.KN, this.mAdInfo.adConversionInfo.appDownloadUrl, c0711a.toJson().toString());
            eVar.BX();
            com.kwad.sdk.commercial.b.a.i(this.KN, i, str2);
        }
        if (this.mAdInfo.adConversionInfo.retryH5TimeStep > 0 && !this.KO) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            AdInfo adInfo = this.mAdInfo;
            if (elapsedRealtime - adInfo.mStartDownloadTime < adInfo.adConversionInfo.retryH5TimeStep && !TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.aS(adInfo))) {
                AdWebViewActivityProxy.launch(KsAdSDKImpl.get().getContext(), this.KN);
                this.KO = true;
            }
        }
    }

    @Override // com.kwad.sdk.core.download.c
    public final void a(String str, String str2, com.kwad.sdk.core.download.e eVar) {
        if (!this.mAdInfo.downloadId.equals(str)) {
            return;
        }
        AdInfo adInfo = this.mAdInfo;
        adInfo.downloadFilePath = str2;
        adInfo.progress = 100;
        adInfo.status = 8;
        nQ();
        if (eVar.BY()) {
            eVar.BX();
            com.kwad.sdk.core.report.a.e(this.KN, this.mReportExtData);
            com.kwad.sdk.commercial.b.a.j(this.KN, SystemClock.elapsedRealtime() - this.mAdInfo.mStartDownloadTime);
            com.kwad.sdk.core.a.Ai().e(str, this.KN);
            g.execute(new Runnable() { // from class: com.kwad.components.core.e.d.c.1
                @Override // java.lang.Runnable
                public final void run() {
                    com.kwad.sdk.components.c.f(com.kwad.components.a.a.a.class);
                }
            });
            com.kwad.sdk.a.a.c.yT().aP(this.KN);
            com.kwad.sdk.a.a.c.yT().aN(this.KN);
            com.kwad.sdk.a.a.b.yQ().aI(this.KN);
            ApkCacheManager.getInstance().BH();
        }
    }

    @Override // com.kwad.sdk.core.download.c
    public final void a(String str, Throwable th, com.kwad.sdk.core.download.e eVar) {
        if (!this.mAdInfo.downloadId.equals(str)) {
            return;
        }
        this.mAdInfo.status = 11;
        nQ();
        if (eVar.BY()) {
            eVar.BX();
            com.kwad.sdk.commercial.b.a.j(this.KN, 100003, Log.getStackTraceString(th));
        }
    }

    @Override // com.kwad.sdk.core.download.c
    public final void b(String str, String str2, com.kwad.sdk.core.download.e eVar) {
        final boolean z;
        this.mAdInfo.status = 12;
        nQ();
        if (eVar.BY()) {
            com.kwad.sdk.core.report.a.g(this.KN, this.mReportExtData);
            eVar.BX();
            com.kwad.sdk.commercial.b.a.ba(this.KN);
            z = nP();
            com.kwad.sdk.a.a.c.yT().aQ(this.KN);
            com.kwad.sdk.a.a.c.yT().aO(this.KN);
            com.kwad.sdk.a.a.b.yQ().aJ(this.KN);
            com.kwad.components.core.e.a.e.mX().am(this.KN);
            com.kwad.sdk.core.a.Ai().cI(nN());
        } else {
            z = false;
        }
        g.execute(new Runnable() { // from class: com.kwad.components.core.e.d.c.2
            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.sdk.components.c.f(com.kwad.components.a.a.a.class);
            }
        });
    }

    @Override // com.kwad.sdk.core.download.c
    public final void d(String str, com.kwad.sdk.core.download.e eVar) {
        if (!this.mAdInfo.downloadId.equals(str)) {
            return;
        }
        if (this.mAdInfo.status != 5 && eVar.BY()) {
            com.kwad.sdk.core.report.a.f(this.KN, this.mReportExtData);
            eVar.BX();
            com.kwad.sdk.commercial.b.a.aX(this.KN);
        }
        com.kwad.sdk.a.a.c.yT().aO(this.KN);
        com.kwad.sdk.a.a.b.yQ().aJ(this.KN);
        this.mAdInfo.status = 5;
        nQ();
    }

    public final void d(JSONObject jSONObject) {
        this.mReportExtData = jSONObject;
    }

    public final void nR() {
        String str = this.mAdInfo.adBaseInfo.appPackageName;
        Context context = KsAdSDKImpl.get().getContext();
        if (context == null) {
            return;
        }
        if (ak.an(context, str)) {
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
            String G = com.kwad.sdk.core.download.a.G(adInfo3);
            if (!TextUtils.isEmpty(G) && new File(G).exists()) {
                AdInfo adInfo4 = this.mAdInfo;
                adInfo4.downloadFilePath = G;
                adInfo4.status = 8;
            }
        }
    }
}
