package com.kwad.sdk.splashscreen;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.contentalliance.detail.video.DetailVideoView;
import com.kwad.sdk.core.download.b.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.fullscreen.KsFullScreenVideoActivityProxy;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.splashscreen.a.d;
import com.kwad.sdk.splashscreen.a.e;
import com.kwad.sdk.splashscreen.a.f;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class KsSplashScreenFragment extends com.kwad.sdk.contentalliance.a<c> {

    /* renamed from: d  reason: collision with root package name */
    public KsSplashScreenAd.SplashScreenAdInteractionListener f34735d;

    /* renamed from: e  reason: collision with root package name */
    public KsVideoPlayConfig f34736e;

    /* renamed from: f  reason: collision with root package name */
    public AdBaseFrameLayout f34737f;

    /* renamed from: g  reason: collision with root package name */
    public DetailVideoView f34738g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f34739h;

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.core.i.a f34740i;
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

    private void f() {
        if (getArguments() == null) {
            return;
        }
        Serializable serializable = getArguments().getSerializable("KsSplashScreenFragment");
        if (!(serializable instanceof AdTemplate)) {
            com.kwad.sdk.core.d.a.e(KsFullScreenVideoActivityProxy.TAG, "data is not instanceof AdTemplate:" + serializable);
            this.f34735d.onAdShowError(0, "返回数据格式错误");
            return;
        }
        Serializable serializable2 = getArguments().getSerializable("adScene");
        if (!(serializable2 instanceof KsScene)) {
            com.kwad.sdk.core.d.a.e(KsFullScreenVideoActivityProxy.TAG, "data is not instanceof AdScene" + serializable);
            this.f34735d.onAdShowError(0, "AdScene 数据错误");
            return;
        }
        AdTemplate adTemplate = (AdTemplate) serializable;
        this.j = adTemplate;
        this.k = (KsScene) serializable2;
        this.l = com.kwad.sdk.core.response.b.c.g(adTemplate);
        KsVideoPlayConfig build = new KsVideoPlayConfig.Builder().videoSoundEnable(this.l.adSplashInfo.mute != 1).skipThirtySecond(true).build();
        this.f34736e = build;
        this.j.mInitVoiceStatus = build.isVideoSoundEnable() ? 2 : 1;
        this.f34739h = new com.kwad.sdk.core.download.b.b(this.j);
    }

    private void g() {
        this.f34737f = (AdBaseFrameLayout) this.f32742c.findViewById(R.id.ksad_splash_root_container);
        DetailVideoView detailVideoView = (DetailVideoView) this.f32742c.findViewById(R.id.ksad_splash_video_player);
        this.f34738g = detailVideoView;
        detailVideoView.setAd(true);
        this.f34738g.setVisibility(8);
        this.f34737f.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.splashscreen.KsSplashScreenFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.kwad.sdk.core.config.c.E()) {
                    com.kwad.sdk.core.download.b.a.a(view.getContext(), KsSplashScreenFragment.this.j, new a.InterfaceC0376a() { // from class: com.kwad.sdk.splashscreen.KsSplashScreenFragment.1.1
                        @Override // com.kwad.sdk.core.download.b.a.InterfaceC0376a
                        public void a() {
                            if (KsSplashScreenFragment.this.f34735d != null) {
                                KsSplashScreenFragment.this.f34735d.onAdClicked();
                            }
                            JSONObject jSONObject = new JSONObject();
                            try {
                                if (KsSplashScreenFragment.this.f32741b != null && ((c) KsSplashScreenFragment.this.f32741b).f34815e != null) {
                                    jSONObject.put("duration", ((c) KsSplashScreenFragment.this.f32741b).f34815e.a());
                                }
                            } catch (JSONException e2) {
                                com.kwad.sdk.core.d.a.a(e2);
                            }
                            com.kwad.sdk.core.report.b.a(KsSplashScreenFragment.this.j, jSONObject, KsSplashScreenFragment.this.f34737f.getTouchCoords(), (String) null);
                        }
                    }, KsSplashScreenFragment.this.f34739h, false);
                }
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
        T t = this.f32741b;
        if (((c) t).f34815e != null) {
            ((c) t).f34815e.f();
        }
    }

    public void a(KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener) {
        this.f34735d = splashScreenAdInteractionListener;
        T t = this.f32741b;
        if (t != 0) {
            ((c) t).f34811a = splashScreenAdInteractionListener;
        }
    }

    @Override // com.kwad.sdk.contentalliance.a
    public int b() {
        return R.layout.ksad_splash_screen;
    }

    @Override // com.kwad.sdk.contentalliance.a
    @NonNull
    public Presenter d() {
        e eVar;
        Presenter presenter = new Presenter();
        presenter.a((Presenter) new com.kwad.sdk.splashscreen.a.a());
        presenter.a((Presenter) new com.kwad.sdk.splashscreen.a.b());
        presenter.a((Presenter) new d());
        if (!com.kwad.sdk.core.response.b.a.F(this.l)) {
            presenter.a((Presenter) new com.kwad.sdk.splashscreen.a.c());
            if (!com.kwad.sdk.core.config.c.E()) {
                eVar = new e();
            }
            return presenter;
        }
        presenter.a((Presenter) new f());
        eVar = new e();
        presenter.a((Presenter) eVar);
        return presenter;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.contentalliance.a
    /* renamed from: e */
    public c c() {
        com.kwad.sdk.core.i.a aVar = new com.kwad.sdk.core.i.a(this, this.f32742c, 70);
        this.f34740i = aVar;
        aVar.a();
        if (this.f34736e == null) {
            this.f34736e = new KsVideoPlayConfig.Builder().videoSoundEnable(this.l.adSplashInfo.mute != 1).skipThirtySecond(true).build();
        }
        c cVar = new c();
        cVar.f34811a = this.f34735d;
        cVar.f34814d = this.f34737f;
        cVar.f34813c = this.j;
        cVar.f34817g = this.k;
        cVar.f34812b = this.f34736e;
        cVar.f34818h = this.f34740i;
        cVar.f34816f = this.f34739h;
        if (com.kwad.sdk.core.response.b.a.F(this.l)) {
            com.kwad.sdk.splashscreen.b.a aVar2 = new com.kwad.sdk.splashscreen.b.a(this.j, this.f34738g, this.f34736e);
            cVar.f34815e = aVar2;
            cVar.f34818h.a(aVar2);
        }
        return cVar;
    }

    @Override // com.kwad.sdk.contentalliance.a, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        T t = this.f32741b;
        if (((c) t).f34815e != null) {
            ((c) t).f34815e.g();
        }
    }

    @Override // com.kwad.sdk.b.d, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onDestroy() {
        super.onDestroy();
        h();
    }

    @Override // com.kwad.sdk.contentalliance.a, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onDestroyView() {
        super.onDestroyView();
        this.f34740i.b();
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onPause() {
        super.onPause();
        this.f34740i.d();
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onResume() {
        super.onResume();
        this.f34740i.c();
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
        this.f34740i.a(z);
    }
}
