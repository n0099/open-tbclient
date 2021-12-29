package com.kwad.sdk.splashscreen;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import androidx.annotation.NonNull;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.contentalliance.detail.video.DetailVideoView;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.splashscreen.a.h;
import com.kwad.sdk.splashscreen.a.i;
import com.kwad.sdk.splashscreen.a.j;
import com.kwad.sdk.utils.bb;
/* loaded from: classes3.dex */
public class d extends com.kwad.sdk.contentalliance.b<g> implements DialogInterface.OnDismissListener, DialogInterface.OnShowListener {

    /* renamed from: d  reason: collision with root package name */
    public KsSplashScreenAd.SplashScreenAdInteractionListener f60146d;

    /* renamed from: e  reason: collision with root package name */
    public KsVideoPlayConfig f60147e;

    /* renamed from: f  reason: collision with root package name */
    public AdBaseFrameLayout f60148f;

    /* renamed from: g  reason: collision with root package name */
    public DetailVideoView f60149g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.download.a.b f60150h;

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.core.j.f f60151i;

    /* renamed from: j  reason: collision with root package name */
    public AdTemplate f60152j;

    /* renamed from: k  reason: collision with root package name */
    public KsScene f60153k;
    public AdInfo l;
    public boolean m;

    public d(Context context) {
        super(context);
        f();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x005a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Presenter a(Context context, AdInfo adInfo) {
        Presenter fVar;
        Presenter iVar;
        Presenter presenter = new Presenter();
        presenter.a((Presenter) new com.kwad.sdk.splashscreen.a.b());
        presenter.a((Presenter) new com.kwad.sdk.splashscreen.a.c());
        presenter.a((Presenter) new h());
        if (com.kwad.sdk.core.response.a.a.P(adInfo)) {
            presenter.a((Presenter) new com.kwad.sdk.splashscreen.a.d());
            fVar = new j();
        } else {
            fVar = new com.kwad.sdk.splashscreen.a.f();
        }
        presenter.a(fVar);
        if (!g.a(context, adInfo)) {
            if (b(adInfo)) {
                iVar = new i();
            }
            if (com.kwad.sdk.core.response.a.a.D(adInfo)) {
                presenter.a((Presenter) new com.kwad.sdk.splashscreen.a.e());
            }
            presenter.a((Presenter) new com.kwad.sdk.splashscreen.a.a());
            return presenter;
        }
        iVar = new com.kwad.sdk.splashscreen.a.g();
        presenter.a(iVar);
        if (com.kwad.sdk.core.response.a.a.D(adInfo)) {
        }
        presenter.a((Presenter) new com.kwad.sdk.splashscreen.a.a());
        return presenter;
    }

    public static d a(Context context, @NonNull KsScene ksScene, @NonNull AdResultData adResultData) {
        AdTemplate adTemplate = new AdTemplate();
        if (!adResultData.adTemplateList.isEmpty()) {
            adTemplate = adResultData.adTemplateList.get(0);
        }
        d dVar = new d(context);
        dVar.a(ksScene, adTemplate);
        return dVar;
    }

    private void a(KsScene ksScene, AdTemplate adTemplate) {
        this.f60153k = ksScene;
        this.f60152j = adTemplate;
        e();
    }

    public static boolean a(@NonNull AdInfo adInfo) {
        AdInfo.AdSplashInfo adSplashInfo = adInfo.adSplashInfo;
        return adSplashInfo != null && adSplashInfo.fullScreenClickSwitch == 1;
    }

    public static boolean b(@NonNull AdInfo adInfo) {
        AdInfo.AdSplashInfo adSplashInfo = adInfo.adSplashInfo;
        return adSplashInfo != null && adSplashInfo.splashShowClickButtonSwitch == 1;
    }

    private void e() {
        this.l = com.kwad.sdk.core.response.a.d.j(this.f60152j);
        KsVideoPlayConfig build = new KsVideoPlayConfig.Builder().videoSoundEnable(this.l.adSplashInfo.mute != 1).skipThirtySecond(true).build();
        this.f60147e = build;
        this.f60152j.mInitVoiceStatus = build.isVideoSoundEnable() ? 2 : 1;
        com.kwad.sdk.core.download.a.b bVar = new com.kwad.sdk.core.download.a.b(this.f60152j);
        this.f60150h = bVar;
        bVar.a((DialogInterface.OnDismissListener) this);
        this.f60150h.a((DialogInterface.OnShowListener) this);
    }

    private void f() {
        this.f60148f = (AdBaseFrameLayout) this.f57739c.findViewById(R.id.ksad_splash_root_container);
        DetailVideoView detailVideoView = (DetailVideoView) this.f57739c.findViewById(R.id.ksad_splash_video_player);
        this.f60149g = detailVideoView;
        detailVideoView.setAd(true);
        this.f60149g.setVisibility(8);
        this.f60148f.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.splashscreen.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bb.a() || !d.a(d.this.l) || d.this.f57738b == null) {
                    return;
                }
                ((g) d.this.f57738b).a(view.getContext(), 2, 2);
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
        return a(getContext(), this.l);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.contentalliance.b
    /* renamed from: d */
    public g b() {
        com.kwad.sdk.core.j.f fVar = new com.kwad.sdk.core.j.f(this.f57739c, 70);
        this.f60151i = fVar;
        fVar.a();
        if (this.f60147e == null) {
            this.f60147e = new KsVideoPlayConfig.Builder().videoSoundEnable(this.l.adSplashInfo.mute != 1).skipThirtySecond(true).build();
        }
        g gVar = new g();
        gVar.a = this.f60146d;
        gVar.f60159e = this.f60148f;
        AdTemplate adTemplate = this.f60152j;
        gVar.f60158d = adTemplate;
        gVar.f60162h = this.f60153k;
        gVar.f60157c = this.f60147e;
        adTemplate.mMiniWindowId = gVar.c();
        gVar.f60163i = this.f60151i;
        gVar.f60161g = this.f60150h;
        if (com.kwad.sdk.core.response.a.a.P(this.l)) {
            com.kwad.sdk.splashscreen.b.a aVar = new com.kwad.sdk.splashscreen.b.a(this.f60152j, this.f60149g, this.f60147e);
            gVar.f60160f = aVar;
            gVar.f60163i.a(aVar);
        }
        return gVar;
    }

    @Override // com.kwad.sdk.contentalliance.b
    public int getLayoutId() {
        return R.layout.ksad_splash_screen;
    }

    @Override // com.kwad.sdk.contentalliance.b, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        T t = this.f57738b;
        if (((g) t).f60160f != null) {
            ((g) t).f60160f.j();
        }
    }

    @Override // com.kwad.sdk.contentalliance.b, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f60151i.b();
        T t = this.f57738b;
        com.kwad.sdk.splashscreen.b.a aVar = ((g) t).f60160f;
        ((g) t).a();
        g();
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        boolean b2 = dialogInterface instanceof com.kwad.sdk.core.download.kwai.b ? ((com.kwad.sdk.core.download.kwai.b) dialogInterface).b() : false;
        try {
            if (this.f60146d != null) {
                if (b2) {
                    this.f60146d.onDownloadTipsDialogDismiss();
                } else {
                    this.f60146d.onDownloadTipsDialogCancel();
                }
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.d.a.b(th);
        }
    }

    @Override // android.content.DialogInterface.OnShowListener
    public void onShow(DialogInterface dialogInterface) {
        try {
            if (this.f60146d != null) {
                this.f60146d.onDownloadTipsDialogShow();
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.d.a.b(th);
        }
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NonNull View view, int i2) {
        super.onVisibilityChanged(view, i2);
    }

    public void setSplashScreenAdListener(KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener) {
        this.f60146d = splashScreenAdInteractionListener;
        T t = this.f57738b;
        if (t != 0) {
            ((g) t).a = splashScreenAdInteractionListener;
        }
    }
}
