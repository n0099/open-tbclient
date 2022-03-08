package com.kwad.sdk.splashscreen;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.contentalliance.detail.video.DetailVideoView;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.fullscreen.KsFullScreenVideoActivityProxy;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.bb;
import java.io.Serializable;
/* loaded from: classes8.dex */
public class KsSplashScreenFragment extends com.kwad.sdk.contentalliance.a<g> implements DialogInterface.OnDismissListener, DialogInterface.OnShowListener {

    /* renamed from: d  reason: collision with root package name */
    public KsSplashScreenAd.SplashScreenAdInteractionListener f56315d;

    /* renamed from: e  reason: collision with root package name */
    public KsVideoPlayConfig f56316e;

    /* renamed from: f  reason: collision with root package name */
    public AdBaseFrameLayout f56317f;

    /* renamed from: g  reason: collision with root package name */
    public DetailVideoView f56318g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.download.a.b f56319h;

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.core.j.b f56320i;

    /* renamed from: j  reason: collision with root package name */
    public AdTemplate f56321j;
    public KsScene k;
    public AdInfo l;
    public boolean m;

    public static KsSplashScreenFragment a(@NonNull KsScene ksScene, @NonNull AdResultData adResultData) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("adScene", ksScene);
        if (!adResultData.adTemplateList.isEmpty()) {
            bundle.putSerializable("KsSplashScreenFragment", adResultData.adTemplateList.get(0));
        }
        KsSplashScreenFragment ksSplashScreenFragment = new KsSplashScreenFragment();
        ksSplashScreenFragment.setArguments(bundle);
        return ksSplashScreenFragment;
    }

    public static boolean a(@NonNull AdInfo adInfo) {
        AdInfo.AdSplashInfo adSplashInfo = adInfo.adSplashInfo;
        return adSplashInfo != null && adSplashInfo.fullScreenClickSwitch == 1;
    }

    private void f() {
        if (getArguments() == null) {
            return;
        }
        Serializable serializable = getArguments().getSerializable("KsSplashScreenFragment");
        if (!(serializable instanceof AdTemplate)) {
            com.kwad.sdk.core.d.a.e(KsFullScreenVideoActivityProxy.TAG, "data is not instanceof AdTemplate:" + serializable);
            this.f56315d.onAdShowError(0, "返回数据格式错误");
            return;
        }
        Serializable serializable2 = getArguments().getSerializable("adScene");
        if (!(serializable2 instanceof KsScene)) {
            com.kwad.sdk.core.d.a.e(KsFullScreenVideoActivityProxy.TAG, "data is not instanceof AdScene" + serializable);
            this.f56315d.onAdShowError(0, "AdScene 数据错误");
            return;
        }
        AdTemplate adTemplate = (AdTemplate) serializable;
        this.f56321j = adTemplate;
        this.k = (KsScene) serializable2;
        this.l = com.kwad.sdk.core.response.a.d.j(adTemplate);
        KsVideoPlayConfig build = new KsVideoPlayConfig.Builder().videoSoundEnable(this.l.adSplashInfo.mute != 1).skipThirtySecond(true).build();
        this.f56316e = build;
        this.f56321j.mInitVoiceStatus = build.isVideoSoundEnable() ? 2 : 1;
        com.kwad.sdk.core.download.a.b bVar = new com.kwad.sdk.core.download.a.b(this.f56321j);
        this.f56319h = bVar;
        bVar.a((DialogInterface.OnDismissListener) this);
        this.f56319h.a((DialogInterface.OnShowListener) this);
    }

    private void g() {
        this.f56317f = (AdBaseFrameLayout) this.f54113c.findViewById(R.id.ksad_splash_root_container);
        DetailVideoView detailVideoView = (DetailVideoView) this.f54113c.findViewById(R.id.ksad_splash_video_player);
        this.f56318g = detailVideoView;
        detailVideoView.setAd(true);
        this.f56318g.setVisibility(8);
        this.f56317f.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.splashscreen.KsSplashScreenFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bb.a() || !KsSplashScreenFragment.a(KsSplashScreenFragment.this.l) || ((com.kwad.sdk.contentalliance.a) KsSplashScreenFragment.this).f54112b == null) {
                    return;
                }
                ((g) ((com.kwad.sdk.contentalliance.a) KsSplashScreenFragment.this).f54112b).a(view.getContext(), 2, 2);
            }
        });
    }

    private void h() {
        if (this.m) {
            return;
        }
        this.m = true;
    }

    @Override // com.kwad.sdk.contentalliance.a
    public void a() {
        super.a();
        ((g) ((com.kwad.sdk.contentalliance.a) this).f54112b).a();
    }

    public void a(KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener) {
        this.f56315d = splashScreenAdInteractionListener;
        T t = ((com.kwad.sdk.contentalliance.a) this).f54112b;
        if (t != 0) {
            ((g) t).a = splashScreenAdInteractionListener;
        }
    }

    @Override // com.kwad.sdk.contentalliance.a
    public int b() {
        return R.layout.ksad_splash_screen;
    }

    @Override // com.kwad.sdk.contentalliance.a
    @NonNull
    public Presenter d() {
        return d.a(getContext(), this.l);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.contentalliance.a
    /* renamed from: e */
    public g c() {
        com.kwad.sdk.core.j.b bVar = new com.kwad.sdk.core.j.b(this, this.f54113c, 70);
        this.f56320i = bVar;
        bVar.a();
        if (this.f56316e == null) {
            this.f56316e = new KsVideoPlayConfig.Builder().videoSoundEnable(this.l.adSplashInfo.mute != 1).skipThirtySecond(true).build();
        }
        g gVar = new g();
        gVar.a = this.f56315d;
        gVar.f56438e = this.f56317f;
        gVar.f56437d = this.f56321j;
        gVar.f56441h = this.k;
        gVar.f56436c = this.f56316e;
        gVar.f56442i = this.f56320i;
        gVar.f56440g = this.f56319h;
        if (com.kwad.sdk.core.response.a.a.P(this.l)) {
            com.kwad.sdk.splashscreen.b.a aVar = new com.kwad.sdk.splashscreen.b.a(this.f56321j, this.f56318g, this.f56316e);
            gVar.f56439f = aVar;
            gVar.f56442i.a(aVar);
        }
        return gVar;
    }

    @Override // com.kwad.sdk.contentalliance.a, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        T t = ((com.kwad.sdk.contentalliance.a) this).f54112b;
        if (((g) t).f56439f != null) {
            ((g) t).f56439f.j();
        }
    }

    @Override // com.kwad.sdk.h.d, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onDestroy() {
        super.onDestroy();
        h();
    }

    @Override // com.kwad.sdk.contentalliance.a, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onDestroyView() {
        super.onDestroyView();
        this.f56320i.b();
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        boolean b2 = dialogInterface instanceof com.kwad.sdk.core.download.kwai.b ? ((com.kwad.sdk.core.download.kwai.b) dialogInterface).b() : false;
        try {
            if (this.f56315d != null) {
                if (b2) {
                    this.f56315d.onDownloadTipsDialogDismiss();
                } else {
                    this.f56315d.onDownloadTipsDialogCancel();
                }
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.d.a.b(th);
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onPause() {
        super.onPause();
        this.f56320i.i();
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onResume() {
        super.onResume();
        this.f56320i.h();
    }

    @Override // android.content.DialogInterface.OnShowListener
    public void onShow(DialogInterface dialogInterface) {
        try {
            if (this.f56315d != null) {
                this.f56315d.onDownloadTipsDialogShow();
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.d.a.b(th);
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        f();
        g();
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.IFragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        this.f56320i.a(z);
    }
}
