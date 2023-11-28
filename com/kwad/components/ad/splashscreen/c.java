package com.kwad.components.ad.splashscreen;

import android.content.Context;
import android.content.DialogInterface;
import android.os.SystemClock;
import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import com.baidu.tieba.R;
import com.kwad.components.ad.splashscreen.c.j;
import com.kwad.components.ad.splashscreen.c.k;
import com.kwad.components.ad.splashscreen.c.o;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.m.l;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.bm;
/* loaded from: classes10.dex */
public final class c extends com.kwad.components.core.l.c<h> implements DialogInterface.OnDismissListener, DialogInterface.OnShowListener {
    public KsSplashScreenAd.SplashScreenAdInteractionListener Cd;
    public com.kwad.components.ad.splashscreen.f.d Ce;
    public com.kwad.sdk.core.h.b bT;
    public AdInfo mAdInfo;
    public AdResultData mAdResultData;
    public SceneImpl mAdScene;
    public AdTemplate mAdTemplate;
    public com.kwad.components.core.e.d.c mApkDownloadHelper;
    public DetailVideoView mDetailVideoView;
    public boolean mPageDismissCalled;
    public AdBaseFrameLayout mRootContainer;
    public KsVideoPlayConfig mVideoPlayConfig;

    private int getSplashLayoutId() {
        return R.layout.obfuscated_res_0x7f0d0518;
    }

    @Override // com.kwad.components.core.l.c
    public final boolean kn() {
        return true;
    }

    public c(Context context, AdResultData adResultData) {
        super(context);
        this.mAdResultData = adResultData;
        AdTemplate m = com.kwad.sdk.core.response.b.c.m(adResultData);
        this.mAdTemplate = m;
        this.mAdScene = m.mAdScene;
        oz();
    }

    public static void a(Presenter presenter, AdInfo adInfo) {
        presenter.a(new k());
        presenter.a(new o());
        if (h.r(adInfo)) {
            presenter.a(new com.kwad.components.ad.splashscreen.c.a.f());
        }
    }

    @Override // android.view.View
    public final void onVisibilityChanged(@NonNull View view2, int i) {
        super.onVisibilityChanged(view2, i);
    }

    public static StyleTemplate S(AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate k = com.kwad.sdk.core.response.b.b.k(adTemplate, com.kwad.sdk.core.response.b.b.dq(adTemplate));
        StyleTemplate styleTemplate = new StyleTemplate();
        if (k != null) {
            styleTemplate.templateId = k.templateId;
            styleTemplate.templateMd5 = k.templateMd5;
            styleTemplate.templateUrl = k.templateUrl;
            styleTemplate.templateVersionCode = (int) k.templateVersionCode;
        }
        return styleTemplate;
    }

    public static Presenter T(AdTemplate adTemplate) {
        AdInfo dP = com.kwad.sdk.core.response.b.e.dP(adTemplate);
        Presenter presenter = new Presenter();
        a(presenter, dP);
        if (h.U(adTemplate)) {
            presenter.a(new com.kwad.components.ad.splashscreen.c.b.a());
        } else {
            presenter.a(new j());
        }
        return presenter;
    }

    private com.kwad.sdk.core.h.c a(final h hVar) {
        return new com.kwad.sdk.core.h.c() { // from class: com.kwad.components.ad.splashscreen.c.1
            @Override // com.kwad.sdk.core.h.c
            public final void aM() {
                bm bmVar = hVar.mTimerHelper;
                if (bmVar != null) {
                    bmVar.LM();
                }
            }

            @Override // com.kwad.sdk.core.h.c
            public final void aN() {
                bm bmVar = hVar.mTimerHelper;
                if (bmVar != null) {
                    bmVar.LN();
                }
            }
        };
    }

    public static boolean n(@NonNull AdInfo adInfo) {
        AdInfo.AdSplashInfo adSplashInfo = adInfo.adSplashInfo;
        if (adSplashInfo != null && adSplashInfo.fullScreenClickSwitch == 1) {
            return true;
        }
        return false;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        boolean z;
        if (dialogInterface instanceof com.kwad.components.core.e.c.b) {
            z = ((com.kwad.components.core.e.c.b) dialogInterface).nl();
        } else {
            z = false;
        }
        try {
            if (this.Cd != null) {
                if (z) {
                    this.Cd.onDownloadTipsDialogDismiss();
                } else {
                    this.Cd.onDownloadTipsDialogCancel();
                }
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(th);
        }
    }

    @Override // android.content.DialogInterface.OnShowListener
    public final void onShow(DialogInterface dialogInterface) {
        try {
            if (this.Cd != null) {
                this.Cd.onDownloadTipsDialogShow();
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(th);
        }
    }

    public final void setPageExitListener(com.kwad.sdk.core.h.b bVar) {
        this.bT = bVar;
    }

    public final void setSplashScreenAdListener(KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener) {
        this.Cd = splashScreenAdInteractionListener;
        T t = this.Mo;
        if (t != 0) {
            ((h) t).setSplashScreenAdListener(splashScreenAdInteractionListener);
        }
    }

    public static c a(Context context, @NonNull AdResultData adResultData, boolean z, com.kwad.sdk.core.h.b bVar, KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener) {
        AdTemplate m = com.kwad.sdk.core.response.b.c.m(adResultData);
        c cVar = null;
        try {
            com.kwad.sdk.i.a.ai(SpeedStatsUtils.UBC_VALUE_SPLASH, "show");
            m.showStartTime = SystemClock.elapsedRealtime();
            com.kwad.components.ad.splashscreen.monitor.b.kO();
            com.kwad.components.ad.splashscreen.monitor.b.aa(m);
            com.kwad.components.ad.splashscreen.monitor.b.kO();
            com.kwad.components.ad.splashscreen.monitor.b.a(m, KsAdSDKImpl.get().getSDKInitTime(), z);
            c cVar2 = new c(l.wrapContextIfNeed(context), adResultData);
            try {
                cVar2.setPageExitListener(bVar);
                cVar2.setSplashScreenAdListener(splashScreenAdInteractionListener);
                com.kwad.sdk.i.a.aj(SpeedStatsUtils.UBC_VALUE_SPLASH, "show");
                return cVar2;
            } catch (Throwable th) {
                th = th;
                cVar = cVar2;
                com.kwad.components.ad.splashscreen.monitor.b.kO();
                com.kwad.components.ad.splashscreen.monitor.b.a(m, th.toString(), z);
                if (KsAdSDKImpl.get().getIsExternal()) {
                    com.kwad.components.core.d.a.b(th);
                    return cVar;
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.components.core.l.c
    /* renamed from: ko */
    public h kr() {
        com.kwad.components.ad.splashscreen.f.d dVar = new com.kwad.components.ad.splashscreen.f.d(this.lC, com.kwad.sdk.core.response.b.a.cy(this.mAdInfo));
        this.Ce = dVar;
        dVar.a(this.bT);
        this.Ce.tm();
        if (this.mVideoPlayConfig == null) {
            KsVideoPlayConfig.Builder builder = new KsVideoPlayConfig.Builder();
            boolean z = true;
            if (this.mAdInfo.adSplashInfo.mute == 1) {
                z = false;
            }
            this.mVideoPlayConfig = builder.videoSoundEnable(z).build();
        }
        h hVar = new h();
        hVar.d(this.mAdResultData);
        hVar.setSplashScreenAdListener(this.Cd);
        hVar.mRootContainer = this.mRootContainer;
        hVar.mAdScene = this.mAdScene;
        hVar.mVideoPlayConfig = this.mVideoPlayConfig;
        hVar.Cr = this.Ce;
        hVar.mApkDownloadHelper = this.mApkDownloadHelper;
        hVar.Cq = S(this.mAdTemplate);
        hVar.mTimerHelper = new bm();
        if (com.kwad.sdk.core.response.b.a.bc(this.mAdInfo)) {
            com.kwad.components.ad.splashscreen.e.a aVar = new com.kwad.components.ad.splashscreen.e.a(this.mAdTemplate, this.mDetailVideoView, this.mVideoPlayConfig);
            hVar.Cp = aVar;
            hVar.Cr.a(aVar);
        }
        hVar.Cr.a(a(hVar));
        return hVar;
    }

    private void kq() {
        com.kwad.sdk.a.a.c.yT().yW();
        if (this.mPageDismissCalled) {
            return;
        }
        this.mPageDismissCalled = true;
    }

    @Override // com.kwad.components.core.l.c, com.kwad.sdk.widget.KSFrameLayout
    public final void ac() {
        super.ac();
        post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.c.3
            @Override // java.lang.Runnable
            public final void run() {
                AdTemplate adTemplate = c.this.mAdTemplate;
                AdInfo unused = c.this.mAdInfo;
                if (!h.U(adTemplate) && ((h) c.this.Mo).Cp != null) {
                    ((h) c.this.Mo).Cp.lH();
                }
            }
        });
    }

    @Override // com.kwad.components.core.l.c, com.kwad.sdk.widget.KSFrameLayout
    public final void ad() {
        super.ad();
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.setOnDismissListener(null);
            this.mApkDownloadHelper.setOnShowListener(null);
        }
        this.Ce.tn();
        kq();
    }

    @Override // com.kwad.components.core.l.c
    public final int getLayoutId() {
        return getSplashLayoutId();
    }

    @Override // com.kwad.components.core.l.c
    @NonNull
    public final Presenter onCreatePresenter() {
        getContext();
        return T(this.mAdTemplate);
    }

    @Override // com.kwad.components.core.l.c
    public final void initData() {
        boolean z;
        this.mAdInfo = com.kwad.sdk.core.response.b.e.dP(this.mAdTemplate);
        KsVideoPlayConfig.Builder builder = new KsVideoPlayConfig.Builder();
        int i = 1;
        if (this.mAdInfo.adSplashInfo.mute != 1) {
            z = true;
        } else {
            z = false;
        }
        KsVideoPlayConfig build = builder.videoSoundEnable(z).build();
        this.mVideoPlayConfig = build;
        AdTemplate adTemplate = this.mAdTemplate;
        if (build.isVideoSoundEnable()) {
            i = 2;
        }
        adTemplate.mInitVoiceStatus = i;
        com.kwad.components.core.e.d.c cVar = new com.kwad.components.core.e.d.c(this.mAdTemplate);
        this.mApkDownloadHelper = cVar;
        cVar.setOnDismissListener(this);
        this.mApkDownloadHelper.setOnShowListener(this);
    }

    @Override // com.kwad.components.core.l.c
    public final void kp() {
        this.mRootContainer = (AdBaseFrameLayout) this.lC.findViewById(R.id.obfuscated_res_0x7f0914c8);
        DetailVideoView detailVideoView = (DetailVideoView) this.lC.findViewById(R.id.obfuscated_res_0x7f0914d0);
        this.mDetailVideoView = detailVideoView;
        detailVideoView.setAd(true);
        this.mDetailVideoView.setVisibility(8);
        this.mRootContainer.findViewById(R.id.obfuscated_res_0x7f092361).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.splashscreen.c.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                if (!com.kwad.sdk.d.a.a.zz() && c.n(c.this.mAdInfo) && c.this.Mo != null) {
                    ((h) c.this.Mo).c(1, view2.getContext(), 53, 2);
                }
            }
        });
    }
}
