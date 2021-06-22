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
    public KsSplashScreenAd.SplashScreenAdInteractionListener f37439d;

    /* renamed from: e  reason: collision with root package name */
    public KsVideoPlayConfig f37440e;

    /* renamed from: f  reason: collision with root package name */
    public AdBaseFrameLayout f37441f;

    /* renamed from: g  reason: collision with root package name */
    public DetailVideoView f37442g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f37443h;

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.core.i.a f37444i;
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
            this.f37439d.onAdShowError(0, "返回数据格式错误");
            return;
        }
        Serializable serializable2 = getArguments().getSerializable("adScene");
        if (!(serializable2 instanceof KsScene)) {
            com.kwad.sdk.core.d.a.d(KsFullScreenVideoActivityProxy.TAG, "data is not instanceof AdScene" + serializable);
            this.f37439d.onAdShowError(0, "AdScene 数据错误");
            return;
        }
        AdTemplate adTemplate = (AdTemplate) serializable;
        this.j = adTemplate;
        this.k = (KsScene) serializable2;
        this.l = com.kwad.sdk.core.response.b.c.j(adTemplate);
        KsVideoPlayConfig build = new KsVideoPlayConfig.Builder().videoSoundEnable(this.l.adSplashInfo.mute != 1).skipThirtySecond(true).build();
        this.f37440e = build;
        this.j.mInitVoiceStatus = build.isVideoSoundEnable() ? 2 : 1;
        this.f37443h = new com.kwad.sdk.core.download.b.b(this.j);
    }

    private void g() {
        this.f37441f = (AdBaseFrameLayout) this.f32531c.findViewById(R.id.ksad_splash_root_container);
        DetailVideoView detailVideoView = (DetailVideoView) this.f32531c.findViewById(R.id.ksad_splash_video_player);
        this.f37442g = detailVideoView;
        detailVideoView.setAd(true);
        this.f37442g.setVisibility(8);
        this.f37441f.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.splashscreen.KsSplashScreenFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.kwad.sdk.core.download.b.a.a(view.getContext(), KsSplashScreenFragment.this.j, new a.InterfaceC0382a() { // from class: com.kwad.sdk.splashscreen.KsSplashScreenFragment.1.1
                    @Override // com.kwad.sdk.core.download.b.a.InterfaceC0382a
                    public void a() {
                        if (KsSplashScreenFragment.this.f37439d != null) {
                            KsSplashScreenFragment.this.f37439d.onAdClicked();
                        }
                        JSONObject jSONObject = new JSONObject();
                        try {
                            if (KsSplashScreenFragment.this.f32530b != null && ((c) KsSplashScreenFragment.this.f32530b).f37515e != null) {
                                jSONObject.put("duration", ((c) KsSplashScreenFragment.this.f32530b).f37515e.c());
                            }
                        } catch (JSONException e2) {
                            com.kwad.sdk.core.d.a.a(e2);
                        }
                        com.kwad.sdk.core.report.b.a(KsSplashScreenFragment.this.j, jSONObject, KsSplashScreenFragment.this.f37441f.getTouchCoords(), (String) null);
                    }
                }, KsSplashScreenFragment.this.f37443h);
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
        T t = this.f32530b;
        if (((c) t).f37515e != null) {
            ((c) t).f37515e.f();
        }
    }

    public void a(KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener) {
        this.f37439d = splashScreenAdInteractionListener;
        T t = this.f32530b;
        if (t != 0) {
            ((c) t).f37511a = splashScreenAdInteractionListener;
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
        com.kwad.sdk.core.i.a aVar = new com.kwad.sdk.core.i.a(this, this.f32531c, 70);
        this.f37444i = aVar;
        aVar.a();
        if (this.f37440e == null) {
            this.f37440e = new KsVideoPlayConfig.Builder().videoSoundEnable(this.l.adSplashInfo.mute != 1).skipThirtySecond(true).build();
        }
        c cVar = new c();
        cVar.f37511a = this.f37439d;
        cVar.f37514d = this.f37441f;
        cVar.f37513c = this.j;
        cVar.f37517g = this.k;
        cVar.f37512b = this.f37440e;
        cVar.f37518h = this.f37444i;
        cVar.f37516f = this.f37443h;
        if (com.kwad.sdk.core.response.b.a.J(this.l)) {
            com.kwad.sdk.splashscreen.b.a aVar2 = new com.kwad.sdk.splashscreen.b.a(this.j, this.f37442g, this.f37440e);
            cVar.f37515e = aVar2;
            cVar.f37518h.a(aVar2);
        }
        return cVar;
    }

    @Override // com.kwad.sdk.contentalliance.b, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        T t = this.f32530b;
        if (((c) t).f37515e != null) {
            ((c) t).f37515e.g();
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
        this.f37444i.b();
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onPause() {
        super.onPause();
        this.f37444i.d();
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onResume() {
        super.onResume();
        this.f37444i.c();
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
        this.f37444i.a(z);
    }
}
