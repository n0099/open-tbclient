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
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.splashscreen.a.d;
import com.kwad.sdk.splashscreen.a.e;
import com.kwad.sdk.splashscreen.a.f;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b extends com.kwad.sdk.contentalliance.b<c> {

    /* renamed from: d  reason: collision with root package name */
    public KsSplashScreenAd.SplashScreenAdInteractionListener f34791d;

    /* renamed from: e  reason: collision with root package name */
    public KsVideoPlayConfig f34792e;

    /* renamed from: f  reason: collision with root package name */
    public AdBaseFrameLayout f34793f;

    /* renamed from: g  reason: collision with root package name */
    public DetailVideoView f34794g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f34795h;

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.core.view.b f34796i;
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
        this.l = com.kwad.sdk.core.response.b.c.g(this.j);
        KsVideoPlayConfig build = new KsVideoPlayConfig.Builder().videoSoundEnable(this.l.adSplashInfo.mute != 1).skipThirtySecond(true).build();
        this.f34792e = build;
        this.j.mInitVoiceStatus = build.isVideoSoundEnable() ? 2 : 1;
        this.f34795h = new com.kwad.sdk.core.download.b.b(this.j);
    }

    private void f() {
        this.f34793f = (AdBaseFrameLayout) this.f32745c.findViewById(R.id.ksad_splash_root_container);
        DetailVideoView detailVideoView = (DetailVideoView) this.f32745c.findViewById(R.id.ksad_splash_video_player);
        this.f34794g = detailVideoView;
        detailVideoView.setAd(true);
        this.f34794g.setVisibility(8);
        this.f34793f.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.splashscreen.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.kwad.sdk.core.config.c.E()) {
                    com.kwad.sdk.core.download.b.a.a(view.getContext(), b.this.j, new a.InterfaceC0376a() { // from class: com.kwad.sdk.splashscreen.b.1.1
                        @Override // com.kwad.sdk.core.download.b.a.InterfaceC0376a
                        public void a() {
                            if (b.this.f34791d != null) {
                                b.this.f34791d.onAdClicked();
                            }
                            JSONObject jSONObject = new JSONObject();
                            try {
                                if (b.this.f32744b != null && ((c) b.this.f32744b).f34815e != null) {
                                    jSONObject.put("duration", ((c) b.this.f32744b).f34815e.a());
                                }
                            } catch (JSONException e2) {
                                com.kwad.sdk.core.d.a.a(e2);
                            }
                            com.kwad.sdk.core.report.b.a(b.this.j, jSONObject, b.this.f34793f.getTouchCoords(), (String) null);
                        }
                    }, b.this.f34795h, false);
                }
            }
        });
    }

    private void g() {
        if (this.m) {
            return;
        }
        this.m = true;
    }

    @Override // com.kwad.sdk.contentalliance.b
    @NonNull
    public Presenter c() {
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
    @Override // com.kwad.sdk.contentalliance.b
    /* renamed from: d */
    public c b() {
        com.kwad.sdk.core.view.b bVar = new com.kwad.sdk.core.view.b(this.f32745c, 70);
        this.f34796i = bVar;
        bVar.a();
        if (this.f34792e == null) {
            this.f34792e = new KsVideoPlayConfig.Builder().videoSoundEnable(this.l.adSplashInfo.mute != 1).skipThirtySecond(true).build();
        }
        c cVar = new c();
        cVar.f34811a = this.f34791d;
        cVar.f34814d = this.f34793f;
        cVar.f34813c = this.j;
        cVar.f34817g = this.k;
        cVar.f34812b = this.f34792e;
        cVar.f34818h = this.f34796i;
        cVar.f34816f = this.f34795h;
        if (com.kwad.sdk.core.response.b.a.F(this.l)) {
            com.kwad.sdk.splashscreen.b.a aVar = new com.kwad.sdk.splashscreen.b.a(this.j, this.f34794g, this.f34792e);
            cVar.f34815e = aVar;
            cVar.f34818h.a(aVar);
        }
        return cVar;
    }

    @Override // com.kwad.sdk.contentalliance.b
    public int getLayoutId() {
        return R.layout.ksad_splash_screen;
    }

    @Override // com.kwad.sdk.contentalliance.b, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        T t = this.f32744b;
        if (((c) t).f34815e != null) {
            ((c) t).f34815e.g();
        }
    }

    @Override // com.kwad.sdk.contentalliance.b, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f34796i.b();
        T t = this.f32744b;
        if (((c) t).f34815e != null) {
            ((c) t).f34815e.f();
        }
        g();
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NonNull View view, int i2) {
        super.onVisibilityChanged(view, i2);
    }

    public void setSplashScreenAdListener(KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener) {
        this.f34791d = splashScreenAdInteractionListener;
        T t = this.f32744b;
        if (t != 0) {
            ((c) t).f34811a = splashScreenAdInteractionListener;
        }
    }
}
