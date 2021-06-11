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
/* loaded from: classes7.dex */
public class KsSplashScreenFragment extends com.kwad.sdk.contentalliance.b<c> {

    /* renamed from: d  reason: collision with root package name */
    public KsSplashScreenAd.SplashScreenAdInteractionListener f37341d;

    /* renamed from: e  reason: collision with root package name */
    public KsVideoPlayConfig f37342e;

    /* renamed from: f  reason: collision with root package name */
    public AdBaseFrameLayout f37343f;

    /* renamed from: g  reason: collision with root package name */
    public DetailVideoView f37344g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f37345h;

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.core.i.a f37346i;
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
            this.f37341d.onAdShowError(0, "返回数据格式错误");
            return;
        }
        Serializable serializable2 = getArguments().getSerializable("adScene");
        if (!(serializable2 instanceof KsScene)) {
            com.kwad.sdk.core.d.a.d(KsFullScreenVideoActivityProxy.TAG, "data is not instanceof AdScene" + serializable);
            this.f37341d.onAdShowError(0, "AdScene 数据错误");
            return;
        }
        AdTemplate adTemplate = (AdTemplate) serializable;
        this.j = adTemplate;
        this.k = (KsScene) serializable2;
        this.l = com.kwad.sdk.core.response.b.c.j(adTemplate);
        KsVideoPlayConfig build = new KsVideoPlayConfig.Builder().videoSoundEnable(this.l.adSplashInfo.mute != 1).skipThirtySecond(true).build();
        this.f37342e = build;
        this.j.mInitVoiceStatus = build.isVideoSoundEnable() ? 2 : 1;
        this.f37345h = new com.kwad.sdk.core.download.b.b(this.j);
    }

    private void g() {
        this.f37343f = (AdBaseFrameLayout) this.f32433c.findViewById(R.id.ksad_splash_root_container);
        DetailVideoView detailVideoView = (DetailVideoView) this.f32433c.findViewById(R.id.ksad_splash_video_player);
        this.f37344g = detailVideoView;
        detailVideoView.setAd(true);
        this.f37344g.setVisibility(8);
        this.f37343f.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.splashscreen.KsSplashScreenFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.kwad.sdk.core.download.b.a.a(view.getContext(), KsSplashScreenFragment.this.j, new a.InterfaceC0379a() { // from class: com.kwad.sdk.splashscreen.KsSplashScreenFragment.1.1
                    @Override // com.kwad.sdk.core.download.b.a.InterfaceC0379a
                    public void a() {
                        if (KsSplashScreenFragment.this.f37341d != null) {
                            KsSplashScreenFragment.this.f37341d.onAdClicked();
                        }
                        JSONObject jSONObject = new JSONObject();
                        try {
                            if (KsSplashScreenFragment.this.f32432b != null && ((c) KsSplashScreenFragment.this.f32432b).f37417e != null) {
                                jSONObject.put("duration", ((c) KsSplashScreenFragment.this.f32432b).f37417e.c());
                            }
                        } catch (JSONException e2) {
                            com.kwad.sdk.core.d.a.a(e2);
                        }
                        com.kwad.sdk.core.report.b.a(KsSplashScreenFragment.this.j, jSONObject, KsSplashScreenFragment.this.f37343f.getTouchCoords(), (String) null);
                    }
                }, KsSplashScreenFragment.this.f37345h);
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
        T t = this.f32432b;
        if (((c) t).f37417e != null) {
            ((c) t).f37417e.f();
        }
    }

    public void a(KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener) {
        this.f37341d = splashScreenAdInteractionListener;
        T t = this.f32432b;
        if (t != 0) {
            ((c) t).f37413a = splashScreenAdInteractionListener;
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
        com.kwad.sdk.core.i.a aVar = new com.kwad.sdk.core.i.a(this, this.f32433c, 70);
        this.f37346i = aVar;
        aVar.a();
        if (this.f37342e == null) {
            this.f37342e = new KsVideoPlayConfig.Builder().videoSoundEnable(this.l.adSplashInfo.mute != 1).skipThirtySecond(true).build();
        }
        c cVar = new c();
        cVar.f37413a = this.f37341d;
        cVar.f37416d = this.f37343f;
        cVar.f37415c = this.j;
        cVar.f37419g = this.k;
        cVar.f37414b = this.f37342e;
        cVar.f37420h = this.f37346i;
        cVar.f37418f = this.f37345h;
        if (com.kwad.sdk.core.response.b.a.J(this.l)) {
            com.kwad.sdk.splashscreen.b.a aVar2 = new com.kwad.sdk.splashscreen.b.a(this.j, this.f37344g, this.f37342e);
            cVar.f37417e = aVar2;
            cVar.f37420h.a(aVar2);
        }
        return cVar;
    }

    @Override // com.kwad.sdk.contentalliance.b, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        T t = this.f32432b;
        if (((c) t).f37417e != null) {
            ((c) t).f37417e.g();
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
        this.f37346i.b();
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onPause() {
        super.onPause();
        this.f37346i.d();
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onResume() {
        super.onResume();
        this.f37346i.c();
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
        this.f37346i.a(z);
    }
}
