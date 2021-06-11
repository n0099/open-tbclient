package com.kwad.sdk.splashscreen;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
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
import com.kwad.sdk.core.view.g;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.splashscreen.a.d;
import com.kwad.sdk.splashscreen.a.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b extends com.kwad.sdk.contentalliance.c<c> {

    /* renamed from: d  reason: collision with root package name */
    public KsSplashScreenAd.SplashScreenAdInteractionListener f37393d;

    /* renamed from: e  reason: collision with root package name */
    public KsVideoPlayConfig f37394e;

    /* renamed from: f  reason: collision with root package name */
    public AdBaseFrameLayout f37395f;

    /* renamed from: g  reason: collision with root package name */
    public DetailVideoView f37396g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f37397h;

    /* renamed from: i  reason: collision with root package name */
    public g f37398i;
    public AdTemplate j;
    public KsScene k;
    public AdInfo l;
    public boolean m;

    public b(Context context) {
        super(context);
        f();
    }

    public static b a(Context context, @NonNull KsScene ksScene, @NonNull AdResultData adResultData) {
        AdTemplate adTemplate = new AdTemplate();
        if (!adResultData.adTemplateList.isEmpty()) {
            adTemplate = adResultData.adTemplateList.get(0);
        }
        b bVar = new b(context);
        bVar.a(ksScene, adTemplate);
        return bVar;
    }

    private void a(KsScene ksScene, AdTemplate adTemplate) {
        this.k = ksScene;
        this.j = adTemplate;
        e();
    }

    private void e() {
        this.l = com.kwad.sdk.core.response.b.c.j(this.j);
        KsVideoPlayConfig build = new KsVideoPlayConfig.Builder().videoSoundEnable(this.l.adSplashInfo.mute != 1).skipThirtySecond(true).build();
        this.f37394e = build;
        this.j.mInitVoiceStatus = build.isVideoSoundEnable() ? 2 : 1;
        this.f37397h = new com.kwad.sdk.core.download.b.b(this.j);
    }

    private void f() {
        this.f37395f = (AdBaseFrameLayout) this.f32467c.findViewById(R.id.ksad_splash_root_container);
        DetailVideoView detailVideoView = (DetailVideoView) this.f32467c.findViewById(R.id.ksad_splash_video_player);
        this.f37396g = detailVideoView;
        detailVideoView.setAd(true);
        this.f37396g.setVisibility(8);
        this.f37395f.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.splashscreen.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.kwad.sdk.core.download.b.a.a(view.getContext(), b.this.j, new a.InterfaceC0379a() { // from class: com.kwad.sdk.splashscreen.b.1.1
                    @Override // com.kwad.sdk.core.download.b.a.InterfaceC0379a
                    public void a() {
                        if (b.this.f37393d != null) {
                            b.this.f37393d.onAdClicked();
                        }
                        JSONObject jSONObject = new JSONObject();
                        try {
                            if (b.this.f32466b != null && ((c) b.this.f32466b).f37417e != null) {
                                jSONObject.put("duration", ((c) b.this.f32466b).f37417e.c());
                            }
                        } catch (JSONException e2) {
                            com.kwad.sdk.core.d.a.a(e2);
                        }
                        com.kwad.sdk.core.report.b.a(b.this.j, jSONObject, b.this.f37395f.getTouchCoords(), (String) null);
                    }
                }, b.this.f37397h);
            }
        });
    }

    private void g() {
        if (this.m) {
            return;
        }
        this.m = true;
    }

    @Override // com.kwad.sdk.contentalliance.c
    @NonNull
    public Presenter c() {
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
    @Override // com.kwad.sdk.contentalliance.c
    /* renamed from: d */
    public c b() {
        g gVar = new g(this.f32467c, 70);
        this.f37398i = gVar;
        gVar.a();
        if (this.f37394e == null) {
            this.f37394e = new KsVideoPlayConfig.Builder().videoSoundEnable(this.l.adSplashInfo.mute != 1).skipThirtySecond(true).build();
        }
        c cVar = new c();
        cVar.f37413a = this.f37393d;
        cVar.f37416d = this.f37395f;
        cVar.f37415c = this.j;
        cVar.f37419g = this.k;
        cVar.f37414b = this.f37394e;
        cVar.f37420h = this.f37398i;
        cVar.f37418f = this.f37397h;
        if (com.kwad.sdk.core.response.b.a.J(this.l)) {
            com.kwad.sdk.splashscreen.b.a aVar = new com.kwad.sdk.splashscreen.b.a(this.j, this.f37396g, this.f37394e);
            cVar.f37417e = aVar;
            cVar.f37420h.a(aVar);
        }
        return cVar;
    }

    @Override // com.kwad.sdk.contentalliance.c
    public int getLayoutId() {
        return R.layout.ksad_splash_screen;
    }

    @Override // com.kwad.sdk.contentalliance.c, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        T t = this.f32466b;
        if (((c) t).f37417e != null) {
            ((c) t).f37417e.g();
        }
    }

    @Override // com.kwad.sdk.contentalliance.c, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f37398i.b();
        T t = this.f32466b;
        if (((c) t).f37417e != null) {
            ((c) t).f37417e.f();
        }
        g();
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NonNull View view, int i2) {
        super.onVisibilityChanged(view, i2);
    }

    public void setSplashScreenAdListener(KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener) {
        this.f37393d = splashScreenAdInteractionListener;
        T t = this.f32466b;
        if (t != 0) {
            ((c) t).f37413a = splashScreenAdInteractionListener;
        }
    }
}
