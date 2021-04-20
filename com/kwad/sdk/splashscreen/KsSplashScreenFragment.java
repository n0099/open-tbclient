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
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class KsSplashScreenFragment extends com.kwad.sdk.contentalliance.b<c> {

    /* renamed from: d  reason: collision with root package name */
    public KsSplashScreenAd.SplashScreenAdInteractionListener f36879d;

    /* renamed from: e  reason: collision with root package name */
    public KsVideoPlayConfig f36880e;

    /* renamed from: f  reason: collision with root package name */
    public AdBaseFrameLayout f36881f;

    /* renamed from: g  reason: collision with root package name */
    public DetailVideoView f36882g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f36883h;
    public com.kwad.sdk.core.i.a i;
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
            com.kwad.sdk.core.d.a.d(KsFullScreenVideoActivityProxy.TAG, "data is not instanceof AdTemplate:" + serializable);
            this.f36879d.onAdShowError(0, "返回数据格式错误");
            return;
        }
        Serializable serializable2 = getArguments().getSerializable("adScene");
        if (!(serializable2 instanceof KsScene)) {
            com.kwad.sdk.core.d.a.d(KsFullScreenVideoActivityProxy.TAG, "data is not instanceof AdScene" + serializable);
            this.f36879d.onAdShowError(0, "AdScene 数据错误");
            return;
        }
        AdTemplate adTemplate = (AdTemplate) serializable;
        this.j = adTemplate;
        this.k = (KsScene) serializable2;
        this.l = com.kwad.sdk.core.response.b.c.j(adTemplate);
        KsVideoPlayConfig build = new KsVideoPlayConfig.Builder().videoSoundEnable(this.l.adSplashInfo.mute != 1).skipThirtySecond(true).build();
        this.f36880e = build;
        this.j.mInitVoiceStatus = build.isVideoSoundEnable() ? 2 : 1;
        this.f36883h = new com.kwad.sdk.core.download.b.b(this.j);
    }

    private void g() {
        this.f36881f = (AdBaseFrameLayout) this.f32175c.findViewById(R.id.ksad_splash_root_container);
        DetailVideoView detailVideoView = (DetailVideoView) this.f32175c.findViewById(R.id.ksad_splash_video_player);
        this.f36882g = detailVideoView;
        detailVideoView.setAd(true);
        this.f36882g.setVisibility(8);
        this.f36881f.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.splashscreen.KsSplashScreenFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.kwad.sdk.core.download.b.a.a(view.getContext(), KsSplashScreenFragment.this.j, new a.InterfaceC0393a() { // from class: com.kwad.sdk.splashscreen.KsSplashScreenFragment.1.1
                    @Override // com.kwad.sdk.core.download.b.a.InterfaceC0393a
                    public void a() {
                        if (KsSplashScreenFragment.this.f36879d != null) {
                            KsSplashScreenFragment.this.f36879d.onAdClicked();
                        }
                        JSONObject jSONObject = new JSONObject();
                        try {
                            if (KsSplashScreenFragment.this.f32174b != null && ((c) KsSplashScreenFragment.this.f32174b).f36951e != null) {
                                jSONObject.put("duration", ((c) KsSplashScreenFragment.this.f32174b).f36951e.c());
                            }
                        } catch (JSONException e2) {
                            com.kwad.sdk.core.d.a.a(e2);
                        }
                        com.kwad.sdk.core.report.b.a(KsSplashScreenFragment.this.j, jSONObject, KsSplashScreenFragment.this.f36881f.getTouchCoords(), (String) null);
                    }
                }, KsSplashScreenFragment.this.f36883h);
            }
        });
    }

    private void h() {
        if (this.m) {
            return;
        }
        this.m = true;
    }

    @Override // com.kwad.sdk.contentalliance.b
    public void a() {
        super.a();
        T t = this.f32174b;
        if (((c) t).f36951e != null) {
            ((c) t).f36951e.f();
        }
    }

    public void a(KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener) {
        this.f36879d = splashScreenAdInteractionListener;
        T t = this.f32174b;
        if (t != 0) {
            ((c) t).f36947a = splashScreenAdInteractionListener;
        }
    }

    @Override // com.kwad.sdk.contentalliance.b
    public int b() {
        return R.layout.ksad_splash_screen;
    }

    @Override // com.kwad.sdk.contentalliance.b
    @NonNull
    public Presenter d() {
        Presenter cVar;
        Presenter presenter = new Presenter();
        presenter.a((Presenter) new com.kwad.sdk.splashscreen.a.a());
        presenter.a((Presenter) new com.kwad.sdk.splashscreen.a.b());
        if (com.kwad.sdk.core.response.b.a.J(this.l)) {
            presenter.a((Presenter) new e());
            cVar = new d();
        } else {
            cVar = new com.kwad.sdk.splashscreen.a.c();
        }
        presenter.a(cVar);
        return presenter;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.contentalliance.b
    /* renamed from: e */
    public c c() {
        com.kwad.sdk.core.i.a aVar = new com.kwad.sdk.core.i.a(this, this.f32175c, 70);
        this.i = aVar;
        aVar.a();
        if (this.f36880e == null) {
            this.f36880e = new KsVideoPlayConfig.Builder().videoSoundEnable(this.l.adSplashInfo.mute != 1).skipThirtySecond(true).build();
        }
        c cVar = new c();
        cVar.f36947a = this.f36879d;
        cVar.f36950d = this.f36881f;
        cVar.f36949c = this.j;
        cVar.f36953g = this.k;
        cVar.f36948b = this.f36880e;
        cVar.f36954h = this.i;
        cVar.f36952f = this.f36883h;
        if (com.kwad.sdk.core.response.b.a.J(this.l)) {
            com.kwad.sdk.splashscreen.b.a aVar2 = new com.kwad.sdk.splashscreen.b.a(this.j, this.f36882g, this.f36880e);
            cVar.f36951e = aVar2;
            cVar.f36954h.a(aVar2);
        }
        return cVar;
    }

    @Override // com.kwad.sdk.contentalliance.b, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        T t = this.f32174b;
        if (((c) t).f36951e != null) {
            ((c) t).f36951e.g();
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onDestroy() {
        super.onDestroy();
        h();
    }

    @Override // com.kwad.sdk.contentalliance.b, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onDestroyView() {
        super.onDestroyView();
        this.i.b();
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onPause() {
        super.onPause();
        this.i.d();
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onResume() {
        super.onResume();
        this.i.c();
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
