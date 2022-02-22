package com.kwad.sdk.d.kwai;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.videoview.a;
import com.kwad.sdk.d.kwai.c;
import com.kwad.sdk.widget.KsAutoCloseView;
/* loaded from: classes4.dex */
public class e extends b {
    public c a;

    /* renamed from: b  reason: collision with root package name */
    public AdInfo f56849b;

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f56850c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f56851d = false;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.core.video.videoview.b f56852e;

    /* renamed from: f  reason: collision with root package name */
    public KsAutoCloseView f56853f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f56854g;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, boolean z, int i2, boolean z2) {
        Dialog dialog;
        this.a.a(view, z, i2, z2);
        if (!com.kwad.sdk.core.config.b.aC() || (dialog = this.a.f56827c) == null) {
            return;
        }
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        com.kwad.sdk.core.video.videoview.b bVar = this.f56852e;
        if (bVar != null) {
            bVar.k();
        }
        this.a.a(z, this.f56852e);
        this.a.f56827c.dismiss();
        KsInterstitialAd.AdInteractionListener adInteractionListener = this.a.f56826b;
        if (adInteractionListener != null) {
            adInteractionListener.onAdClosed();
        }
    }

    public static boolean a(Context context, AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.autoCloseTime > 0 && !com.kwad.sdk.core.response.a.a.an(adInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        final com.kwad.sdk.d.a.b bVar = this.a.f56829e;
        bVar.setAdTemplate(this.f56850c);
        if (com.kwad.sdk.core.response.a.a.Q(this.f56849b)) {
            bVar.a(com.kwad.sdk.core.response.a.a.I(this.f56849b).materialUrl, this.f56850c);
            bVar.a(true, true);
            bVar.a(false);
        } else {
            bVar.a(true);
            String a = com.kwad.sdk.core.response.a.a.aa(this.f56849b).a();
            if (TextUtils.isEmpty(a)) {
                bVar.a(false, false);
            } else {
                bVar.a(a, this.f56850c);
                bVar.a(true, false);
            }
            com.kwad.sdk.core.video.videoview.b bVar2 = this.a.f56833i;
            this.f56852e = bVar2;
            if (bVar2.getParent() != null) {
                ((ViewGroup) this.f56852e.getParent()).removeView(this.f56852e);
            }
            if (com.kwad.sdk.core.response.a.a.P(this.f56849b)) {
                bVar.a(com.kwad.sdk.core.response.a.a.J(this.f56849b).height / com.kwad.sdk.core.response.a.a.J(this.f56849b).width, this.f56852e);
            }
            bVar.b(this.a.f56831g.isVideoSoundEnable());
            final int b2 = com.kwad.sdk.core.response.a.a.b(this.f56849b);
            this.a.a(new a.b() { // from class: com.kwad.sdk.d.kwai.e.4
                @Override // com.kwad.sdk.core.video.videoview.a.b
                @SuppressLint({"SetTextI18n"})
                public void a(long j2) {
                    int i2 = b2 - ((int) (j2 / 1000));
                    if (i2 >= 0) {
                        bVar.a(String.valueOf(i2));
                    } else {
                        bVar.c();
                    }
                    if (j2 < com.kwad.sdk.core.config.b.aj() * 1000) {
                        return;
                    }
                    e.this.f56851d = true;
                }

                @Override // com.kwad.sdk.core.video.videoview.a.b
                public void b_() {
                    bVar.a(true);
                }

                @Override // com.kwad.sdk.core.video.videoview.a.b
                public void e() {
                    bVar.a(false, false);
                }

                @Override // com.kwad.sdk.core.video.videoview.a.b
                public void f() {
                    e.this.f56852e.setVisibility(8);
                    if (e.this.a.a(e.this.q())) {
                        return;
                    }
                    bVar.d();
                }
            });
            bVar.a(this.f56850c, this.f56849b);
            bVar.a(true);
        }
        this.a.a(q(), this.f56849b, this.f56850c, bVar.getBlurBgView());
        if (!a(q(), this.f56849b)) {
            this.f56853f.a(false);
            return;
        }
        this.f56853f.a(true);
        f();
    }

    private void f() {
        AdInfo adInfo = this.f56849b;
        int i2 = adInfo.adInsertScreenInfo.autoCloseTime;
        if (com.kwad.sdk.core.response.a.a.P(adInfo)) {
            i2 = Math.min(i2, com.kwad.sdk.core.response.a.a.b(this.f56849b));
            this.a.f56829e.c();
        }
        this.f56853f.a(i2);
        com.kwad.sdk.core.report.a.c(this.f56850c, 165, null);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        c cVar = (c) p();
        this.a = cVar;
        AdTemplate adTemplate = cVar.a;
        this.f56850c = adTemplate;
        this.f56849b = com.kwad.sdk.core.response.a.d.j(adTemplate);
        this.a.f56829e.a(this.f56850c);
        this.a.f56829e.setViewListener(new com.kwad.sdk.d.a.d() { // from class: com.kwad.sdk.d.kwai.e.2
            @Override // com.kwad.sdk.d.a.d
            public void a() {
                e.this.a(false);
            }

            @Override // com.kwad.sdk.d.a.d
            public void a(View view) {
                e eVar = e.this;
                eVar.a(view, false, 3, eVar.f56854g);
            }

            @Override // com.kwad.sdk.d.a.d
            public void a(boolean z) {
                if (e.this.f56852e != null) {
                    e.this.f56852e.setVideoSoundEnable(z);
                }
            }

            @Override // com.kwad.sdk.d.a.d
            public void b() {
            }

            @Override // com.kwad.sdk.d.a.d
            public void b(View view) {
                e eVar = e.this;
                eVar.a(view, true, 1, eVar.f56854g);
            }

            @Override // com.kwad.sdk.d.a.d
            public void b(boolean z) {
                e.this.f56854g = z;
            }

            @Override // com.kwad.sdk.d.a.d
            public void c(View view) {
                e eVar = e.this;
                eVar.a(view, true, 1, eVar.f56854g);
            }

            @Override // com.kwad.sdk.d.a.d
            public void d(View view) {
                e eVar = e.this;
                eVar.a(view, false, 3, eVar.f56854g);
            }

            @Override // com.kwad.sdk.d.a.d
            public void e(View view) {
                e eVar = e.this;
                eVar.a(view, false, 3, eVar.f56854g);
            }

            @Override // com.kwad.sdk.d.a.d
            public void f(View view) {
                e eVar = e.this;
                eVar.a(view, false, 2, eVar.f56854g);
            }

            @Override // com.kwad.sdk.d.a.d
            public void g(View view) {
                e eVar = e.this;
                eVar.a(view, false, 2, eVar.f56854g);
            }

            @Override // com.kwad.sdk.d.a.d
            public void h(View view) {
                e eVar = e.this;
                eVar.a(view, false, 2, eVar.f56854g);
            }
        });
        this.a.a(new c.a() { // from class: com.kwad.sdk.d.kwai.e.3
            @Override // com.kwad.sdk.d.kwai.c.a
            public void a() {
                e.this.e();
            }
        });
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        KsAutoCloseView ksAutoCloseView = (KsAutoCloseView) a(R.id.ksad_interstitial_auto_close);
        this.f56853f = ksAutoCloseView;
        ksAutoCloseView.setViewListener(new KsAutoCloseView.a() { // from class: com.kwad.sdk.d.kwai.e.1
            @Override // com.kwad.sdk.widget.KsAutoCloseView.a
            public void a() {
                e.this.a(true);
            }

            @Override // com.kwad.sdk.widget.KsAutoCloseView.a
            public void b() {
                e.this.a(false);
            }
        });
    }

    @Override // com.kwad.sdk.d.kwai.b
    public void g() {
        super.g();
        this.f56853f.setCountDownPaused(false);
    }

    @Override // com.kwad.sdk.d.kwai.b
    public void h() {
        super.h();
        this.f56853f.setCountDownPaused(true);
    }
}
