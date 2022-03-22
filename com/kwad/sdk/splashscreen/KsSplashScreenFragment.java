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
/* loaded from: classes7.dex */
public class KsSplashScreenFragment extends com.kwad.sdk.contentalliance.a<g> implements DialogInterface.OnDismissListener, DialogInterface.OnShowListener {

    /* renamed from: d  reason: collision with root package name */
    public KsSplashScreenAd.SplashScreenAdInteractionListener f41225d;

    /* renamed from: e  reason: collision with root package name */
    public KsVideoPlayConfig f41226e;

    /* renamed from: f  reason: collision with root package name */
    public AdBaseFrameLayout f41227f;

    /* renamed from: g  reason: collision with root package name */
    public DetailVideoView f41228g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.download.a.b f41229h;
    public com.kwad.sdk.core.j.b i;
    public AdTemplate j;
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
            this.f41225d.onAdShowError(0, "返回数据格式错误");
            return;
        }
        Serializable serializable2 = getArguments().getSerializable("adScene");
        if (!(serializable2 instanceof KsScene)) {
            com.kwad.sdk.core.d.a.e(KsFullScreenVideoActivityProxy.TAG, "data is not instanceof AdScene" + serializable);
            this.f41225d.onAdShowError(0, "AdScene 数据错误");
            return;
        }
        AdTemplate adTemplate = (AdTemplate) serializable;
        this.j = adTemplate;
        this.k = (KsScene) serializable2;
        this.l = com.kwad.sdk.core.response.a.d.j(adTemplate);
        KsVideoPlayConfig build = new KsVideoPlayConfig.Builder().videoSoundEnable(this.l.adSplashInfo.mute != 1).skipThirtySecond(true).build();
        this.f41226e = build;
        this.j.mInitVoiceStatus = build.isVideoSoundEnable() ? 2 : 1;
        com.kwad.sdk.core.download.a.b bVar = new com.kwad.sdk.core.download.a.b(this.j);
        this.f41229h = bVar;
        bVar.a((DialogInterface.OnDismissListener) this);
        this.f41229h.a((DialogInterface.OnShowListener) this);
    }

    private void g() {
        this.f41227f = (AdBaseFrameLayout) this.f39260c.findViewById(R.id.obfuscated_res_0x7f091147);
        DetailVideoView detailVideoView = (DetailVideoView) this.f39260c.findViewById(R.id.obfuscated_res_0x7f09114c);
        this.f41228g = detailVideoView;
        detailVideoView.setAd(true);
        this.f41228g.setVisibility(8);
        this.f41227f.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.splashscreen.KsSplashScreenFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bb.a() || !KsSplashScreenFragment.a(KsSplashScreenFragment.this.l) || ((com.kwad.sdk.contentalliance.a) KsSplashScreenFragment.this).f39259b == null) {
                    return;
                }
                ((g) ((com.kwad.sdk.contentalliance.a) KsSplashScreenFragment.this).f39259b).a(view.getContext(), 2, 2);
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
        ((g) ((com.kwad.sdk.contentalliance.a) this).f39259b).a();
    }

    public void a(KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener) {
        this.f41225d = splashScreenAdInteractionListener;
        T t = ((com.kwad.sdk.contentalliance.a) this).f39259b;
        if (t != 0) {
            ((g) t).a = splashScreenAdInteractionListener;
        }
    }

    @Override // com.kwad.sdk.contentalliance.a
    public int b() {
        return R.layout.obfuscated_res_0x7f0d0475;
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
        com.kwad.sdk.core.j.b bVar = new com.kwad.sdk.core.j.b(this, this.f39260c, 70);
        this.i = bVar;
        bVar.a();
        if (this.f41226e == null) {
            this.f41226e = new KsVideoPlayConfig.Builder().videoSoundEnable(this.l.adSplashInfo.mute != 1).skipThirtySecond(true).build();
        }
        g gVar = new g();
        gVar.a = this.f41225d;
        gVar.f41331e = this.f41227f;
        gVar.f41330d = this.j;
        gVar.f41334h = this.k;
        gVar.f41329c = this.f41226e;
        gVar.i = this.i;
        gVar.f41333g = this.f41229h;
        if (com.kwad.sdk.core.response.a.a.P(this.l)) {
            com.kwad.sdk.splashscreen.b.a aVar = new com.kwad.sdk.splashscreen.b.a(this.j, this.f41228g, this.f41226e);
            gVar.f41332f = aVar;
            gVar.i.a(aVar);
        }
        return gVar;
    }

    @Override // com.kwad.sdk.contentalliance.a, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        T t = ((com.kwad.sdk.contentalliance.a) this).f39259b;
        if (((g) t).f41332f != null) {
            ((g) t).f41332f.j();
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
        this.i.b();
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        boolean b2 = dialogInterface instanceof com.kwad.sdk.core.download.kwai.b ? ((com.kwad.sdk.core.download.kwai.b) dialogInterface).b() : false;
        try {
            if (this.f41225d != null) {
                if (b2) {
                    this.f41225d.onDownloadTipsDialogDismiss();
                } else {
                    this.f41225d.onDownloadTipsDialogCancel();
                }
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.d.a.b(th);
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onPause() {
        super.onPause();
        this.i.i();
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onResume() {
        super.onResume();
        this.i.h();
    }

    @Override // android.content.DialogInterface.OnShowListener
    public void onShow(DialogInterface dialogInterface) {
        try {
            if (this.f41225d != null) {
                this.f41225d.onDownloadTipsDialogShow();
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
        this.i.a(z);
    }
}
