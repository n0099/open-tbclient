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
/* loaded from: classes3.dex */
public class b extends com.kwad.sdk.contentalliance.c<c> {
    private KsSplashScreenAd.SplashScreenAdInteractionListener d;
    private KsVideoPlayConfig e;
    private AdBaseFrameLayout f;
    private DetailVideoView g;
    private com.kwad.sdk.core.download.b.b h;
    private g i;
    private AdTemplate j;
    private KsScene k;
    private AdInfo l;
    private boolean m;

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
        this.e = new KsVideoPlayConfig.Builder().videoSoundEnable(this.l.adSplashInfo.mute != 1).skipThirtySecond(true).build();
        this.j.mInitVoiceStatus = this.e.isVideoSoundEnable() ? 2 : 1;
        this.h = new com.kwad.sdk.core.download.b.b(this.j);
    }

    private void f() {
        this.f = (AdBaseFrameLayout) this.c.findViewById(R.id.ksad_splash_root_container);
        this.g = (DetailVideoView) this.c.findViewById(R.id.ksad_splash_video_player);
        this.g.setAd(true);
        this.g.setVisibility(8);
        this.f.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.splashscreen.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.kwad.sdk.core.download.b.a.a(view.getContext(), b.this.j, new a.InterfaceC1092a() { // from class: com.kwad.sdk.splashscreen.b.1.1
                    @Override // com.kwad.sdk.core.download.b.a.InterfaceC1092a
                    public void a() {
                        if (b.this.d != null) {
                            b.this.d.onAdClicked();
                        }
                        JSONObject jSONObject = new JSONObject();
                        try {
                            if (b.this.f8281b != null && ((c) b.this.f8281b).e != null) {
                                jSONObject.put("duration", ((c) b.this.f8281b).e.c());
                            }
                        } catch (JSONException e) {
                            com.kwad.sdk.core.d.a.a(e);
                        }
                        com.kwad.sdk.core.report.b.a(b.this.j, jSONObject, b.this.f.getTouchCoords(), (String) null);
                    }
                }, b.this.h);
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
        Presenter presenter = new Presenter();
        presenter.a((Presenter) new com.kwad.sdk.splashscreen.a.a());
        presenter.a((Presenter) new com.kwad.sdk.splashscreen.a.b());
        if (com.kwad.sdk.core.response.b.a.J(this.l)) {
            presenter.a((Presenter) new e());
            presenter.a((Presenter) new d());
        } else {
            presenter.a((Presenter) new com.kwad.sdk.splashscreen.a.c());
        }
        return presenter;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.contentalliance.c
    /* renamed from: d */
    public c b() {
        this.i = new g(this.c, 70);
        this.i.a();
        if (this.e == null) {
            this.e = new KsVideoPlayConfig.Builder().videoSoundEnable(this.l.adSplashInfo.mute != 1).skipThirtySecond(true).build();
        }
        c cVar = new c();
        cVar.f10749a = this.d;
        cVar.d = this.f;
        cVar.c = this.j;
        cVar.g = this.k;
        cVar.f10750b = this.e;
        cVar.h = this.i;
        cVar.f = this.h;
        if (com.kwad.sdk.core.response.b.a.J(this.l)) {
            com.kwad.sdk.splashscreen.b.a aVar = new com.kwad.sdk.splashscreen.b.a(this.j, this.g, this.e);
            cVar.e = aVar;
            cVar.h.a(aVar);
        }
        return cVar;
    }

    @Override // com.kwad.sdk.contentalliance.c
    protected int getLayoutId() {
        return R.layout.ksad_splash_screen;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.contentalliance.c, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (((c) this.f8281b).e != null) {
            ((c) this.f8281b).e.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.contentalliance.c, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.i.b();
        if (((c) this.f8281b).e != null) {
            ((c) this.f8281b).e.f();
        }
        g();
    }

    @Override // android.view.View
    protected void onVisibilityChanged(@NonNull View view, int i) {
        super.onVisibilityChanged(view, i);
    }

    public void setSplashScreenAdListener(KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener) {
        this.d = splashScreenAdInteractionListener;
        if (this.f8281b != 0) {
            ((c) this.f8281b).f10749a = splashScreenAdInteractionListener;
        }
    }
}
