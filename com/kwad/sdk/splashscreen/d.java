package com.kwad.sdk.splashscreen;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.tieba.R;
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
/* loaded from: classes7.dex */
public class d extends com.kwad.sdk.contentalliance.b<g> implements DialogInterface.OnDismissListener, DialogInterface.OnShowListener {

    /* renamed from: d  reason: collision with root package name */
    public KsSplashScreenAd.SplashScreenAdInteractionListener f41321d;

    /* renamed from: e  reason: collision with root package name */
    public KsVideoPlayConfig f41322e;

    /* renamed from: f  reason: collision with root package name */
    public AdBaseFrameLayout f41323f;

    /* renamed from: g  reason: collision with root package name */
    public DetailVideoView f41324g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.download.a.b f41325h;
    public com.kwad.sdk.core.j.f i;
    public AdTemplate j;
    public KsScene k;
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
        this.k = ksScene;
        this.j = adTemplate;
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
        this.l = com.kwad.sdk.core.response.a.d.j(this.j);
        KsVideoPlayConfig build = new KsVideoPlayConfig.Builder().videoSoundEnable(this.l.adSplashInfo.mute != 1).skipThirtySecond(true).build();
        this.f41322e = build;
        this.j.mInitVoiceStatus = build.isVideoSoundEnable() ? 2 : 1;
        com.kwad.sdk.core.download.a.b bVar = new com.kwad.sdk.core.download.a.b(this.j);
        this.f41325h = bVar;
        bVar.a((DialogInterface.OnDismissListener) this);
        this.f41325h.a((DialogInterface.OnShowListener) this);
    }

    private void f() {
        this.f41323f = (AdBaseFrameLayout) this.f39262c.findViewById(R.id.obfuscated_res_0x7f091147);
        DetailVideoView detailVideoView = (DetailVideoView) this.f39262c.findViewById(R.id.obfuscated_res_0x7f09114c);
        this.f41324g = detailVideoView;
        detailVideoView.setAd(true);
        this.f41324g.setVisibility(8);
        this.f41323f.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.splashscreen.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bb.a() || !d.a(d.this.l) || d.this.f39261b == null) {
                    return;
                }
                ((g) d.this.f39261b).a(view.getContext(), 2, 2);
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
        com.kwad.sdk.core.j.f fVar = new com.kwad.sdk.core.j.f(this.f39262c, 70);
        this.i = fVar;
        fVar.a();
        if (this.f41322e == null) {
            this.f41322e = new KsVideoPlayConfig.Builder().videoSoundEnable(this.l.adSplashInfo.mute != 1).skipThirtySecond(true).build();
        }
        g gVar = new g();
        gVar.a = this.f41321d;
        gVar.f41331e = this.f41323f;
        AdTemplate adTemplate = this.j;
        gVar.f41330d = adTemplate;
        gVar.f41334h = this.k;
        gVar.f41329c = this.f41322e;
        adTemplate.mMiniWindowId = gVar.c();
        gVar.i = this.i;
        gVar.f41333g = this.f41325h;
        if (com.kwad.sdk.core.response.a.a.P(this.l)) {
            com.kwad.sdk.splashscreen.b.a aVar = new com.kwad.sdk.splashscreen.b.a(this.j, this.f41324g, this.f41322e);
            gVar.f41332f = aVar;
            gVar.i.a(aVar);
        }
        return gVar;
    }

    @Override // com.kwad.sdk.contentalliance.b
    public int getLayoutId() {
        return R.layout.obfuscated_res_0x7f0d0475;
    }

    @Override // com.kwad.sdk.contentalliance.b, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        T t = this.f39261b;
        if (((g) t).f41332f != null) {
            ((g) t).f41332f.j();
        }
    }

    @Override // com.kwad.sdk.contentalliance.b, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.i.b();
        T t = this.f39261b;
        com.kwad.sdk.splashscreen.b.a aVar = ((g) t).f41332f;
        ((g) t).a();
        g();
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        boolean b2 = dialogInterface instanceof com.kwad.sdk.core.download.kwai.b ? ((com.kwad.sdk.core.download.kwai.b) dialogInterface).b() : false;
        try {
            if (this.f41321d != null) {
                if (b2) {
                    this.f41321d.onDownloadTipsDialogDismiss();
                } else {
                    this.f41321d.onDownloadTipsDialogCancel();
                }
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.d.a.b(th);
        }
    }

    @Override // android.content.DialogInterface.OnShowListener
    public void onShow(DialogInterface dialogInterface) {
        try {
            if (this.f41321d != null) {
                this.f41321d.onDownloadTipsDialogShow();
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.d.a.b(th);
        }
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NonNull View view, int i) {
        super.onVisibilityChanged(view, i);
    }

    public void setSplashScreenAdListener(KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener) {
        this.f41321d = splashScreenAdInteractionListener;
        T t = this.f39261b;
        if (t != 0) {
            ((g) t).a = splashScreenAdInteractionListener;
        }
    }
}
