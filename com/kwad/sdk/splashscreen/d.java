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
/* loaded from: classes5.dex */
public class d extends com.kwad.sdk.contentalliance.b<g> implements DialogInterface.OnDismissListener, DialogInterface.OnShowListener {
    public KsSplashScreenAd.SplashScreenAdInteractionListener d;
    public KsVideoPlayConfig e;
    public AdBaseFrameLayout f;
    public DetailVideoView g;
    public com.kwad.sdk.core.download.a.b h;
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
        this.e = build;
        this.j.mInitVoiceStatus = build.isVideoSoundEnable() ? 2 : 1;
        com.kwad.sdk.core.download.a.b bVar = new com.kwad.sdk.core.download.a.b(this.j);
        this.h = bVar;
        bVar.a((DialogInterface.OnDismissListener) this);
        this.h.a((DialogInterface.OnShowListener) this);
    }

    private void f() {
        this.f = (AdBaseFrameLayout) this.c.findViewById(R.id.obfuscated_res_0x7f091141);
        DetailVideoView detailVideoView = (DetailVideoView) this.c.findViewById(R.id.obfuscated_res_0x7f091146);
        this.g = detailVideoView;
        detailVideoView.setAd(true);
        this.g.setVisibility(8);
        this.f.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.splashscreen.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bb.a() || !d.a(d.this.l) || d.this.b == null) {
                    return;
                }
                ((g) d.this.b).a(view2.getContext(), 2, 2);
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
        com.kwad.sdk.core.j.f fVar = new com.kwad.sdk.core.j.f(this.c, 70);
        this.i = fVar;
        fVar.a();
        if (this.e == null) {
            this.e = new KsVideoPlayConfig.Builder().videoSoundEnable(this.l.adSplashInfo.mute != 1).skipThirtySecond(true).build();
        }
        g gVar = new g();
        gVar.a = this.d;
        gVar.e = this.f;
        AdTemplate adTemplate = this.j;
        gVar.d = adTemplate;
        gVar.h = this.k;
        gVar.c = this.e;
        adTemplate.mMiniWindowId = gVar.c();
        gVar.i = this.i;
        gVar.g = this.h;
        if (com.kwad.sdk.core.response.a.a.P(this.l)) {
            com.kwad.sdk.splashscreen.b.a aVar = new com.kwad.sdk.splashscreen.b.a(this.j, this.g, this.e);
            gVar.f = aVar;
            gVar.i.a(aVar);
        }
        return gVar;
    }

    @Override // com.kwad.sdk.contentalliance.b
    public int getLayoutId() {
        return R.layout.obfuscated_res_0x7f0d0470;
    }

    @Override // com.kwad.sdk.contentalliance.b, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        T t = this.b;
        if (((g) t).f != null) {
            ((g) t).f.j();
        }
    }

    @Override // com.kwad.sdk.contentalliance.b, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.i.b();
        T t = this.b;
        com.kwad.sdk.splashscreen.b.a aVar = ((g) t).f;
        ((g) t).a();
        g();
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        boolean b = dialogInterface instanceof com.kwad.sdk.core.download.kwai.b ? ((com.kwad.sdk.core.download.kwai.b) dialogInterface).b() : false;
        try {
            if (this.d != null) {
                if (b) {
                    this.d.onDownloadTipsDialogDismiss();
                } else {
                    this.d.onDownloadTipsDialogCancel();
                }
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.d.a.b(th);
        }
    }

    @Override // android.content.DialogInterface.OnShowListener
    public void onShow(DialogInterface dialogInterface) {
        try {
            if (this.d != null) {
                this.d.onDownloadTipsDialogShow();
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.d.a.b(th);
        }
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NonNull View view2, int i) {
        super.onVisibilityChanged(view2, i);
    }

    public void setSplashScreenAdListener(KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener) {
        this.d = splashScreenAdInteractionListener;
        T t = this.b;
        if (t != 0) {
            ((g) t).a = splashScreenAdInteractionListener;
        }
    }
}
