package com.kwad.components.ad.splashscreen;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.baidu.tieba.R;
import com.kwad.components.ad.splashscreen.b.i;
import com.kwad.components.ad.splashscreen.b.j;
import com.kwad.components.ad.splashscreen.b.k;
import com.kwad.components.ad.splashscreen.b.l;
import com.kwad.components.ad.splashscreen.b.m;
import com.kwad.components.ad.splashscreen.b.n;
import com.kwad.components.core.response.model.AdResultData;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.mvp.Presenter;
/* loaded from: classes10.dex */
public final class d extends com.kwad.components.core.g.c<h> implements DialogInterface.OnDismissListener, DialogInterface.OnShowListener {
    public KsScene fn;
    public AdInfo mAdInfo;
    public AdTemplate mAdTemplate;
    public com.kwad.components.core.c.a.c mApkDownloadHelper;
    public DetailVideoView mDetailVideoView;
    public boolean mPageDismissCalled;
    public AdBaseFrameLayout mRootContainer;
    public KsVideoPlayConfig mVideoPlayConfig;
    public KsSplashScreenAd.SplashScreenAdInteractionListener xT;
    public com.kwad.components.ad.splashscreen.d.d xU;
    public int xV;

    @SuppressLint({"WrongConstant"})
    public d(Context context, int i) {
        super(context);
        V(i);
    }

    private void V(int i) {
        this.xV = i;
        ViewGroup jt = jt();
        this.iB = jt;
        this.mRootContainer = (AdBaseFrameLayout) jt.findViewById(R.id.obfuscated_res_0x7f091428);
        DetailVideoView detailVideoView = (DetailVideoView) this.iB.findViewById(R.id.obfuscated_res_0x7f091431);
        this.mDetailVideoView = detailVideoView;
        detailVideoView.setAd(true);
        this.mDetailVideoView.setVisibility(8);
        this.mRootContainer.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.splashscreen.d.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                if (com.kwad.sdk.b.kwai.a.ro() || !d.n(d.this.mAdInfo) || d.this.EH == null) {
                    return;
                }
                ((h) d.this.EH).c(view2.getContext(), 53, 2);
            }
        });
    }

    public static d a(Context context, @NonNull KsScene ksScene, @NonNull AdResultData adResultData) {
        AdTemplate adTemplate = new AdTemplate();
        if (!adResultData.getAdTemplateList().isEmpty()) {
            adTemplate = adResultData.getAdTemplateList().get(0);
        }
        adTemplate.showStartTime = SystemClock.elapsedRealtime();
        com.kwad.components.splash.monitor.a.qG();
        com.kwad.components.splash.monitor.a.W(adTemplate);
        d dVar = new d(context, com.kwad.sdk.core.response.a.d.bQ(adTemplate).adSplashInfo.skipButtonPosition);
        dVar.a(ksScene, adTemplate);
        return dVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x007e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Presenter a(Context context, AdInfo adInfo, KsScene ksScene) {
        Presenter gVar;
        Presenter mVar;
        Presenter presenter = new Presenter();
        presenter.a(new com.kwad.components.ad.splashscreen.b.b());
        presenter.a(new com.kwad.components.ad.splashscreen.b.c());
        presenter.a(new l());
        if (com.kwad.sdk.core.response.a.a.aB(adInfo)) {
            presenter.a(new com.kwad.components.ad.splashscreen.b.d());
            gVar = new n();
        } else {
            gVar = new com.kwad.components.ad.splashscreen.b.g();
        }
        presenter.a(gVar);
        SceneImpl sceneImpl = new SceneImpl();
        if (ksScene instanceof SceneImpl) {
            sceneImpl = (SceneImpl) ksScene;
        }
        boolean b = com.kwad.components.ad.splashscreen.local.d.b(context, adInfo, sceneImpl);
        boolean c = com.kwad.components.ad.splashscreen.local.d.c(context, adInfo, sceneImpl);
        boolean o = com.kwad.components.ad.splashscreen.local.d.o(adInfo);
        if (com.kwad.components.ad.splashscreen.local.d.d(context, adInfo, sceneImpl)) {
            mVar = new k();
        } else if (b) {
            mVar = new j();
        } else if (!c) {
            if (o) {
                mVar = new m();
            }
            if (com.kwad.sdk.core.response.a.a.ao(adInfo)) {
                presenter.a(new com.kwad.components.ad.splashscreen.b.f());
            }
            presenter.a(new com.kwad.components.ad.splashscreen.b.a());
            return presenter;
        } else {
            mVar = new i();
        }
        presenter.a(mVar);
        if (com.kwad.sdk.core.response.a.a.ao(adInfo)) {
        }
        presenter.a(new com.kwad.components.ad.splashscreen.b.a());
        return presenter;
    }

    private void a(KsScene ksScene, AdTemplate adTemplate) {
        this.fn = ksScene;
        this.mAdTemplate = adTemplate;
        dT();
    }

    private void dT() {
        this.mAdInfo = com.kwad.sdk.core.response.a.d.bQ(this.mAdTemplate);
        KsVideoPlayConfig build = new KsVideoPlayConfig.Builder().videoSoundEnable(this.mAdInfo.adSplashInfo.mute != 1).build();
        this.mVideoPlayConfig = build;
        this.mAdTemplate.mInitVoiceStatus = build.isVideoSoundEnable() ? 2 : 1;
        com.kwad.components.core.c.a.c cVar = new com.kwad.components.core.c.a.c(this.mAdTemplate);
        this.mApkDownloadHelper = cVar;
        cVar.setOnDismissListener(this);
        this.mApkDownloadHelper.setOnShowListener(this);
    }

    private int getSplashLayoutId() {
        int i = this.xV;
        return i == 1 ? R.layout.obfuscated_res_0x7f0d04f1 : i == 0 ? R.layout.obfuscated_res_0x7f0d04f2 : i == 2 ? R.layout.obfuscated_res_0x7f0d04ef : i == 3 ? R.layout.obfuscated_res_0x7f0d04f0 : R.layout.obfuscated_res_0x7f0d04f2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.components.core.g.c
    /* renamed from: js */
    public h jv() {
        com.kwad.components.ad.splashscreen.d.d dVar = new com.kwad.components.ad.splashscreen.d.d(this.iB, 70);
        this.xU = dVar;
        dVar.qi();
        if (this.mVideoPlayConfig == null) {
            this.mVideoPlayConfig = new KsVideoPlayConfig.Builder().videoSoundEnable(this.mAdInfo.adSplashInfo.mute != 1).build();
        }
        h hVar = new h();
        hVar.setSplashScreenAdListener(this.xT);
        hVar.mRootContainer = this.mRootContainer;
        AdTemplate adTemplate = this.mAdTemplate;
        hVar.mAdTemplate = adTemplate;
        hVar.fn = this.fn;
        hVar.mVideoPlayConfig = this.mVideoPlayConfig;
        adTemplate.mMiniWindowId = hVar.jB();
        hVar.yd = this.xU;
        hVar.mApkDownloadHelper = this.mApkDownloadHelper;
        hVar.xV = this.xV;
        if (com.kwad.sdk.core.response.a.a.aB(this.mAdInfo)) {
            com.kwad.components.ad.splashscreen.c.a aVar = new com.kwad.components.ad.splashscreen.c.a(this.mAdTemplate, this.mDetailVideoView, this.mVideoPlayConfig);
            hVar.yc = aVar;
            hVar.yd.a(aVar);
        }
        return hVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ju() {
        if (com.kwad.components.ad.splashscreen.d.c.d(getContext(), getWidth(), getHeight()) && this.xV != 0) {
            if (com.kwad.components.ad.splashscreen.d.c.c((h) this.EH) == 2) {
                com.kwad.components.ad.splashscreen.d.c.a(findViewById(R.id.obfuscated_res_0x7f091426), -1, 16, 16, -1);
            } else if (com.kwad.components.ad.splashscreen.d.c.c((h) this.EH) == 3) {
                com.kwad.components.ad.splashscreen.d.c.a(findViewById(R.id.obfuscated_res_0x7f091426), -1, 16, -1, 16);
            }
        }
    }

    public static boolean n(@NonNull AdInfo adInfo) {
        AdInfo.AdSplashInfo adSplashInfo = adInfo.adSplashInfo;
        return adSplashInfo != null && adSplashInfo.fullScreenClickSwitch == 1;
    }

    private void notifyPageDismiss() {
        com.kwad.sdk.kwai.kwai.c.rd().rg();
        if (this.mPageDismissCalled) {
            return;
        }
        this.mPageDismissCalled = true;
    }

    @Override // com.kwad.components.core.g.c
    public final int getLayoutId() {
        return getSplashLayoutId();
    }

    @Override // com.kwad.components.core.g.c
    public final ViewGroup jt() {
        return (ViewGroup) FrameLayout.inflate(getContext(), getSplashLayoutId(), this);
    }

    @Override // com.kwad.components.core.g.c, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.d.2
            @Override // java.lang.Runnable
            public final void run() {
                d.this.ju();
            }
        });
        T t = this.EH;
        if (((h) t).yc != null) {
            ((h) t).yc.kA();
        }
    }

    @Override // com.kwad.components.core.g.c
    @NonNull
    public final Presenter onCreatePresenter() {
        return a(getContext(), this.mAdInfo, this.fn);
    }

    @Override // com.kwad.components.core.g.c, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.xU.qj();
        ((h) this.EH).release();
        notifyPageDismiss();
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        boolean mr = dialogInterface instanceof com.kwad.components.core.c.kwai.b ? ((com.kwad.components.core.c.kwai.b) dialogInterface).mr() : false;
        try {
            if (this.xT != null) {
                if (mr) {
                    this.xT.onDownloadTipsDialogDismiss();
                } else {
                    this.xT.onDownloadTipsDialogCancel();
                }
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.e.b.printStackTraceOnly(th);
        }
    }

    @Override // android.content.DialogInterface.OnShowListener
    public final void onShow(DialogInterface dialogInterface) {
        try {
            if (this.xT != null) {
                this.xT.onDownloadTipsDialogShow();
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.e.b.printStackTraceOnly(th);
        }
    }

    @Override // android.view.View
    public final void onVisibilityChanged(@NonNull View view2, int i) {
        super.onVisibilityChanged(view2, i);
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }

    public final void setSplashScreenAdListener(KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener) {
        this.xT = splashScreenAdInteractionListener;
        T t = this.EH;
        if (t != 0) {
            ((h) t).setSplashScreenAdListener(splashScreenAdInteractionListener);
        }
    }
}
