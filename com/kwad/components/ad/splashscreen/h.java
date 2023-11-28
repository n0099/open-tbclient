package com.kwad.components.ad.splashscreen;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.splashscreen.monitor.SplashMonitorInfo;
import com.kwad.components.core.e.d.a;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.core.report.j;
import com.kwad.sdk.core.report.y;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.bm;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class h extends com.kwad.sdk.mvp.a {
    public int CA;
    public int CB;
    public long CC;
    public long CD;
    public long CE;
    public long CF;
    public long CG;
    public long CH;
    public long CI;
    public KsSplashScreenAd.SplashScreenAdInteractionListener Cd;
    @Nullable
    public com.kwad.components.ad.splashscreen.e.a Cp;
    public StyleTemplate Cq;
    public com.kwad.sdk.core.h.a Cr;
    public List<g> Cs = new CopyOnWriteArrayList();
    public List<f> Ct = new CopyOnWriteArrayList();
    public boolean Cu = false;
    public boolean Cv = false;
    public boolean Cw = false;
    public boolean Cx = false;
    public boolean Cy = false;
    public long Cz = SystemClock.elapsedRealtime();
    public boolean isWebTimeout = false;
    public AdResultData mAdResultData;
    @NonNull
    public SceneImpl mAdScene;
    public com.kwad.components.core.e.d.c mApkDownloadHelper;
    @NonNull
    public AdBaseFrameLayout mRootContainer;
    public bm mTimerHelper;
    @NonNull
    public KsVideoPlayConfig mVideoPlayConfig;

    /* loaded from: classes10.dex */
    public interface a {
        void b(@NonNull j jVar);
    }

    private void kI() {
        kJ();
        for (g gVar : this.Cs) {
            gVar.ky();
        }
    }

    private void kK() {
        for (f fVar : this.Ct) {
            fVar.ku();
        }
    }

    @MainThread
    public final void kB() {
        com.kwad.components.ad.splashscreen.monitor.a.kM().l(this.mAdTemplate);
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.Cd;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onAdShowEnd();
        }
        com.kwad.components.ad.splashscreen.monitor.a.kM().n(this.mAdTemplate);
    }

    public final void kC() {
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.Cd;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onDownloadTipsDialogShow();
        }
    }

    public final void kD() {
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.Cd;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onDownloadTipsDialogCancel();
        }
    }

    public final void kE() {
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.Cd;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onDownloadTipsDialogDismiss();
        }
    }

    @MainThread
    public final void kG() {
        com.kwad.components.ad.splashscreen.monitor.a.kM().l(this.mAdTemplate);
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.Cd;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onAdShowEnd();
        }
        com.kwad.components.ad.splashscreen.monitor.a.kM().n(this.mAdTemplate);
    }

    @MainThread
    public final void kH() {
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.Cd;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onSkippedAd();
        }
        com.kwad.components.ad.splashscreen.monitor.a.kM().n(this.mAdTemplate);
        kI();
    }

    public final void kL() {
        this.mRootContainer.post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.h.2
            @Override // java.lang.Runnable
            public final void run() {
                if (com.kwad.components.core.e.c.b.nj()) {
                    h.this.mRootContainer.postDelayed(this, 1000L);
                } else {
                    h.this.kG();
                }
            }
        });
    }

    @MainThread
    public final void kz() {
        this.mAdTemplate.converted = true;
        com.kwad.components.ad.splashscreen.monitor.a.kM().Y(this.mAdTemplate);
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.Cd;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onAdClicked();
        }
        com.kwad.components.ad.splashscreen.monitor.a.kM().W(this.mAdTemplate);
    }

    @Override // com.kwad.sdk.mvp.a
    public final void release() {
        com.kwad.components.ad.splashscreen.e.a aVar = this.Cp;
        if (aVar != null) {
            aVar.release();
        }
        com.kwad.sdk.core.h.a aVar2 = this.Cr;
        if (aVar2 != null) {
            aVar2.release();
        }
    }

    public static boolean U(AdTemplate adTemplate) {
        AdMatrixInfo.SplashPlayCardTKInfo dc;
        if (!com.kwad.sdk.core.config.d.AM() || (dc = com.kwad.sdk.core.response.b.b.dc(adTemplate)) == null || TextUtils.isEmpty(dc.templateId) || dc.renderType != 1) {
            return false;
        }
        return true;
    }

    public static boolean n(@NonNull AdInfo adInfo) {
        if (adInfo.adSplashInfo.fullScreenClickSwitch == 1) {
            return true;
        }
        return false;
    }

    public static boolean r(AdInfo adInfo) {
        if (com.kwad.sdk.core.response.b.b.db(adInfo) && com.kwad.sdk.core.response.b.a.bd(adInfo)) {
            return true;
        }
        return false;
    }

    public final void Q(Context context) {
        if (!this.mAdTemplate.mPvReported) {
            com.kwad.components.ad.splashscreen.local.a.R(context);
            com.kwad.components.core.s.b.qL().a(this.mAdTemplate, null, null);
            com.kwad.sdk.commercial.e.c.bA(this.mAdTemplate);
            kA();
        }
    }

    public final void X(int i) {
        for (g gVar : this.Cs) {
            gVar.W(i);
        }
    }

    public final void a(f fVar) {
        if (fVar == null) {
            return;
        }
        this.Ct.add(fVar);
    }

    public final void d(AdResultData adResultData) {
        this.mAdResultData = adResultData;
        this.mAdTemplate = com.kwad.sdk.core.response.b.c.m(adResultData);
    }

    public final void setSplashScreenAdListener(KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener) {
        this.Cd = splashScreenAdInteractionListener;
    }

    private void kJ() {
        long j;
        long di;
        AdInfo dP = com.kwad.sdk.core.response.b.e.dP(this.mAdTemplate);
        SplashMonitorInfo elementTypes = new SplashMonitorInfo().setStatus(8).setElementTypes(com.kwad.components.core.webview.tachikoma.d.a.sO().sP());
        bm bmVar = this.mTimerHelper;
        if (bmVar != null) {
            j = bmVar.getTime();
        } else {
            j = -1;
        }
        SplashMonitorInfo rotateComposeTimeout = elementTypes.setShowEndTime(j).setRotateComposeTimeout(this.Cy);
        if (U(this.mAdTemplate)) {
            di = com.kwad.sdk.core.response.b.b.dd(this.mAdTemplate);
        } else {
            di = com.kwad.sdk.core.response.b.b.di(com.kwad.sdk.core.response.b.e.dP(this.mAdTemplate));
        }
        com.kwad.sdk.commercial.a.k(rotateComposeTimeout.setTkDefaultTimeout(di).setSoSource(this.CA).setSoLoadTime(this.CC).setOfflineSource(this.CB).setOfflineLoadTime(this.CD).setTkFileLoadTime(this.CE).setTkInitTime(this.CF).setTkRenderTime(this.CG).setNativeLoadTime(this.CH).setWebTimeout(this.isWebTimeout).setWebLoadTime(this.CI).setInteractiveStyle(com.kwad.sdk.core.response.b.b.ds(dP)).setInteractivityDefaultStyle(com.kwad.sdk.core.response.b.b.dt(dP)).setCreativeId(com.kwad.sdk.core.response.b.a.J(dP)).setAdTemplate(this.mAdTemplate));
        com.kwad.components.core.webview.tachikoma.d.a.sO().sQ();
    }

    public final void a(int i, Context context, final int i2, int i3, final a aVar) {
        com.kwad.sdk.core.response.b.e.dP(this.mAdTemplate);
        a.C0644a an = new a.C0644a(context).aq(this.mAdTemplate).b(this.mApkDownloadHelper).an(i3);
        boolean z = true;
        if (i3 != 1) {
            z = false;
        }
        com.kwad.components.core.e.d.a.a(an.ao(z).am(i2).al(i).a(new a.b() { // from class: com.kwad.components.ad.splashscreen.h.1
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                com.kwad.components.ad.splashscreen.monitor.a.kM().Y(h.this.mAdTemplate);
                if (h.this.Cd != null) {
                    h.this.Cd.onAdClicked();
                }
                com.kwad.components.ad.splashscreen.monitor.a.kM().W(h.this.mAdTemplate);
                JSONObject jSONObject = new JSONObject();
                try {
                    if (h.this.Cp != null) {
                        jSONObject.put("duration", h.this.Cp.getCurrentPosition());
                    }
                } catch (JSONException e) {
                    com.kwad.sdk.core.e.c.printStackTrace(e);
                }
                j d = new j().cA(i2).d(h.this.mRootContainer.getTouchCoords());
                com.kwad.sdk.core.report.a.a(h.this.mAdTemplate, d, jSONObject);
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.b(d);
                }
            }
        }));
    }

    public final void a(g gVar) {
        this.Cs.add(gVar);
    }

    public final void b(f fVar) {
        if (fVar == null) {
            return;
        }
        this.Ct.remove(fVar);
    }

    public final void b(g gVar) {
        this.Cs.remove(gVar);
    }

    public final void c(int i, Context context, int i2, int i3) {
        a(i, context, i2, i3, null);
    }

    @MainThread
    public final void i(int i, String str) {
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.Cd;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onAdShowError(i, str);
        }
        com.kwad.components.ad.splashscreen.monitor.b.kO();
        com.kwad.components.ad.splashscreen.monitor.b.e(this.mAdTemplate, i, String.valueOf(str));
        kI();
    }

    @MainThread
    public final void kA() {
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.Cd;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onAdShowStart();
        }
        if (this.Cv) {
            return;
        }
        this.Cv = true;
        com.kwad.components.ad.splashscreen.monitor.b.kO();
        com.kwad.components.ad.splashscreen.monitor.b.f(this.mAdTemplate, SystemClock.elapsedRealtime() - this.mAdTemplate.showStartTime);
        com.kwad.components.ad.splashscreen.monitor.c.af(this.mAdTemplate);
        com.kwad.components.ad.splashscreen.monitor.a.kM().m(this.mAdTemplate);
        com.kwad.sdk.a.a.c.yT().bi(true);
        bm bmVar = this.mTimerHelper;
        if (bmVar != null) {
            bmVar.startTiming();
        }
    }

    @MainThread
    public final void kF() {
        if (this.Cu) {
            return;
        }
        this.Cu = true;
        if (r(com.kwad.sdk.core.response.b.e.dP(this.mAdTemplate)) && !this.mAdTemplate.converted) {
            kK();
        } else {
            y.a aVar = new y.a();
            bm bmVar = this.mTimerHelper;
            if (bmVar != null) {
                aVar.duration = bmVar.getTime();
            }
            com.kwad.sdk.core.report.a.b(this.mAdTemplate, new j().cB(14).cJ(22).a(aVar), (JSONObject) null);
            com.kwad.components.ad.splashscreen.monitor.a.kM().l(this.mAdTemplate);
            KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.Cd;
            if (splashScreenAdInteractionListener != null) {
                splashScreenAdInteractionListener.onAdShowEnd();
            }
            com.kwad.components.ad.splashscreen.monitor.a.kM().n(this.mAdTemplate);
        }
        kI();
    }
}
