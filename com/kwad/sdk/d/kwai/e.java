package com.kwad.sdk.d.kwai;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tieba.R;
import com.kuaishou.weapon.un.w0;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.videoview.a;
import com.kwad.sdk.d.kwai.c;
import com.kwad.sdk.widget.KsAutoCloseView;
/* loaded from: classes5.dex */
public class e extends b {
    public c a;
    public AdInfo b;
    public AdTemplate c;
    public boolean d = false;
    public com.kwad.sdk.core.video.videoview.b e;
    public KsAutoCloseView f;
    public boolean g;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view2, boolean z, int i, boolean z2) {
        Dialog dialog;
        this.a.a(view2, z, i, z2);
        if (!com.kwad.sdk.core.config.b.aC() || (dialog = this.a.c) == null) {
            return;
        }
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        com.kwad.sdk.core.video.videoview.b bVar = this.e;
        if (bVar != null) {
            bVar.k();
        }
        this.a.a(z, this.e);
        this.a.c.dismiss();
        KsInterstitialAd.AdInteractionListener adInteractionListener = this.a.b;
        if (adInteractionListener != null) {
            adInteractionListener.onAdClosed();
        }
    }

    public static boolean a(Context context, AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.autoCloseTime > 0 && !com.kwad.sdk.core.response.a.a.an(adInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        final com.kwad.sdk.d.a.b bVar = this.a.e;
        bVar.setAdTemplate(this.c);
        if (com.kwad.sdk.core.response.a.a.Q(this.b)) {
            bVar.a(com.kwad.sdk.core.response.a.a.I(this.b).materialUrl, this.c);
            bVar.a(true, true);
            bVar.a(false);
        } else {
            bVar.a(true);
            String a = com.kwad.sdk.core.response.a.a.aa(this.b).a();
            if (TextUtils.isEmpty(a)) {
                bVar.a(false, false);
            } else {
                bVar.a(a, this.c);
                bVar.a(true, false);
            }
            com.kwad.sdk.core.video.videoview.b bVar2 = this.a.i;
            this.e = bVar2;
            if (bVar2.getParent() != null) {
                ((ViewGroup) this.e.getParent()).removeView(this.e);
            }
            if (com.kwad.sdk.core.response.a.a.P(this.b)) {
                bVar.a(com.kwad.sdk.core.response.a.a.J(this.b).height / com.kwad.sdk.core.response.a.a.J(this.b).width, this.e);
            }
            bVar.b(this.a.g.isVideoSoundEnable());
            final int b = com.kwad.sdk.core.response.a.a.b(this.b);
            this.a.a(new a.b() { // from class: com.kwad.sdk.d.kwai.e.4
                @Override // com.kwad.sdk.core.video.videoview.a.b
                @SuppressLint({"SetTextI18n"})
                public void a(long j) {
                    int i = b - ((int) (j / 1000));
                    if (i >= 0) {
                        bVar.a(String.valueOf(i));
                    } else {
                        bVar.c();
                    }
                    if (j < com.kwad.sdk.core.config.b.aj() * 1000) {
                        return;
                    }
                    e.this.d = true;
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
                    e.this.e.setVisibility(8);
                    if (e.this.a.a(e.this.q())) {
                        return;
                    }
                    bVar.d();
                }
            });
            bVar.a(this.c, this.b);
            bVar.a(true);
        }
        this.a.a(q(), this.b, this.c, bVar.getBlurBgView());
        if (!a(q(), this.b)) {
            this.f.a(false);
            return;
        }
        this.f.a(true);
        f();
    }

    private void f() {
        AdInfo adInfo = this.b;
        int i = adInfo.adInsertScreenInfo.autoCloseTime;
        if (com.kwad.sdk.core.response.a.a.P(adInfo)) {
            i = Math.min(i, com.kwad.sdk.core.response.a.a.b(this.b));
            this.a.e.c();
        }
        this.f.a(i);
        com.kwad.sdk.core.report.a.c(this.c, w0.n0, null);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        c cVar = (c) p();
        this.a = cVar;
        AdTemplate adTemplate = cVar.a;
        this.c = adTemplate;
        this.b = com.kwad.sdk.core.response.a.d.j(adTemplate);
        this.a.e.a(this.c);
        this.a.e.setViewListener(new com.kwad.sdk.d.a.d() { // from class: com.kwad.sdk.d.kwai.e.2
            @Override // com.kwad.sdk.d.a.d
            public void a() {
                e.this.a(false);
            }

            @Override // com.kwad.sdk.d.a.d
            public void a(View view2) {
                e eVar = e.this;
                eVar.a(view2, false, 3, eVar.g);
            }

            @Override // com.kwad.sdk.d.a.d
            public void a(boolean z) {
                if (e.this.e != null) {
                    e.this.e.setVideoSoundEnable(z);
                }
            }

            @Override // com.kwad.sdk.d.a.d
            public void b() {
            }

            @Override // com.kwad.sdk.d.a.d
            public void b(View view2) {
                e eVar = e.this;
                eVar.a(view2, true, 1, eVar.g);
            }

            @Override // com.kwad.sdk.d.a.d
            public void b(boolean z) {
                e.this.g = z;
            }

            @Override // com.kwad.sdk.d.a.d
            public void c(View view2) {
                e eVar = e.this;
                eVar.a(view2, true, 1, eVar.g);
            }

            @Override // com.kwad.sdk.d.a.d
            public void d(View view2) {
                e eVar = e.this;
                eVar.a(view2, false, 3, eVar.g);
            }

            @Override // com.kwad.sdk.d.a.d
            public void e(View view2) {
                e eVar = e.this;
                eVar.a(view2, false, 3, eVar.g);
            }

            @Override // com.kwad.sdk.d.a.d
            public void f(View view2) {
                e eVar = e.this;
                eVar.a(view2, false, 2, eVar.g);
            }

            @Override // com.kwad.sdk.d.a.d
            public void g(View view2) {
                e eVar = e.this;
                eVar.a(view2, false, 2, eVar.g);
            }

            @Override // com.kwad.sdk.d.a.d
            public void h(View view2) {
                e eVar = e.this;
                eVar.a(view2, false, 2, eVar.g);
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
        KsAutoCloseView ksAutoCloseView = (KsAutoCloseView) a(R.id.obfuscated_res_0x7f09108f);
        this.f = ksAutoCloseView;
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
        this.f.setCountDownPaused(false);
    }

    @Override // com.kwad.sdk.d.kwai.b
    public void h() {
        super.h();
        this.f.setCountDownPaused(true);
    }
}
