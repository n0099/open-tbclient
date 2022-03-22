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
/* loaded from: classes7.dex */
public class e extends b {
    public c a;

    /* renamed from: b  reason: collision with root package name */
    public AdInfo f40266b;

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f40267c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f40268d = false;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.core.video.videoview.b f40269e;

    /* renamed from: f  reason: collision with root package name */
    public KsAutoCloseView f40270f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f40271g;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, boolean z, int i, boolean z2) {
        Dialog dialog;
        this.a.a(view, z, i, z2);
        if (!com.kwad.sdk.core.config.b.aC() || (dialog = this.a.f40248c) == null) {
            return;
        }
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        com.kwad.sdk.core.video.videoview.b bVar = this.f40269e;
        if (bVar != null) {
            bVar.k();
        }
        this.a.a(z, this.f40269e);
        this.a.f40248c.dismiss();
        KsInterstitialAd.AdInteractionListener adInteractionListener = this.a.f40247b;
        if (adInteractionListener != null) {
            adInteractionListener.onAdClosed();
        }
    }

    public static boolean a(Context context, AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.autoCloseTime > 0 && !com.kwad.sdk.core.response.a.a.an(adInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        final com.kwad.sdk.d.a.b bVar = this.a.f40250e;
        bVar.setAdTemplate(this.f40267c);
        if (com.kwad.sdk.core.response.a.a.Q(this.f40266b)) {
            bVar.a(com.kwad.sdk.core.response.a.a.I(this.f40266b).materialUrl, this.f40267c);
            bVar.a(true, true);
            bVar.a(false);
        } else {
            bVar.a(true);
            String a = com.kwad.sdk.core.response.a.a.aa(this.f40266b).a();
            if (TextUtils.isEmpty(a)) {
                bVar.a(false, false);
            } else {
                bVar.a(a, this.f40267c);
                bVar.a(true, false);
            }
            com.kwad.sdk.core.video.videoview.b bVar2 = this.a.i;
            this.f40269e = bVar2;
            if (bVar2.getParent() != null) {
                ((ViewGroup) this.f40269e.getParent()).removeView(this.f40269e);
            }
            if (com.kwad.sdk.core.response.a.a.P(this.f40266b)) {
                bVar.a(com.kwad.sdk.core.response.a.a.J(this.f40266b).height / com.kwad.sdk.core.response.a.a.J(this.f40266b).width, this.f40269e);
            }
            bVar.b(this.a.f40252g.isVideoSoundEnable());
            final int b2 = com.kwad.sdk.core.response.a.a.b(this.f40266b);
            this.a.a(new a.b() { // from class: com.kwad.sdk.d.kwai.e.4
                @Override // com.kwad.sdk.core.video.videoview.a.b
                @SuppressLint({"SetTextI18n"})
                public void a(long j) {
                    int i = b2 - ((int) (j / 1000));
                    if (i >= 0) {
                        bVar.a(String.valueOf(i));
                    } else {
                        bVar.c();
                    }
                    if (j < com.kwad.sdk.core.config.b.aj() * 1000) {
                        return;
                    }
                    e.this.f40268d = true;
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
                    e.this.f40269e.setVisibility(8);
                    if (e.this.a.a(e.this.q())) {
                        return;
                    }
                    bVar.d();
                }
            });
            bVar.a(this.f40267c, this.f40266b);
            bVar.a(true);
        }
        this.a.a(q(), this.f40266b, this.f40267c, bVar.getBlurBgView());
        if (!a(q(), this.f40266b)) {
            this.f40270f.a(false);
            return;
        }
        this.f40270f.a(true);
        f();
    }

    private void f() {
        AdInfo adInfo = this.f40266b;
        int i = adInfo.adInsertScreenInfo.autoCloseTime;
        if (com.kwad.sdk.core.response.a.a.P(adInfo)) {
            i = Math.min(i, com.kwad.sdk.core.response.a.a.b(this.f40266b));
            this.a.f40250e.c();
        }
        this.f40270f.a(i);
        com.kwad.sdk.core.report.a.c(this.f40267c, w0.n0, null);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        c cVar = (c) p();
        this.a = cVar;
        AdTemplate adTemplate = cVar.a;
        this.f40267c = adTemplate;
        this.f40266b = com.kwad.sdk.core.response.a.d.j(adTemplate);
        this.a.f40250e.a(this.f40267c);
        this.a.f40250e.setViewListener(new com.kwad.sdk.d.a.d() { // from class: com.kwad.sdk.d.kwai.e.2
            @Override // com.kwad.sdk.d.a.d
            public void a() {
                e.this.a(false);
            }

            @Override // com.kwad.sdk.d.a.d
            public void a(View view) {
                e eVar = e.this;
                eVar.a(view, false, 3, eVar.f40271g);
            }

            @Override // com.kwad.sdk.d.a.d
            public void a(boolean z) {
                if (e.this.f40269e != null) {
                    e.this.f40269e.setVideoSoundEnable(z);
                }
            }

            @Override // com.kwad.sdk.d.a.d
            public void b() {
            }

            @Override // com.kwad.sdk.d.a.d
            public void b(View view) {
                e eVar = e.this;
                eVar.a(view, true, 1, eVar.f40271g);
            }

            @Override // com.kwad.sdk.d.a.d
            public void b(boolean z) {
                e.this.f40271g = z;
            }

            @Override // com.kwad.sdk.d.a.d
            public void c(View view) {
                e eVar = e.this;
                eVar.a(view, true, 1, eVar.f40271g);
            }

            @Override // com.kwad.sdk.d.a.d
            public void d(View view) {
                e eVar = e.this;
                eVar.a(view, false, 3, eVar.f40271g);
            }

            @Override // com.kwad.sdk.d.a.d
            public void e(View view) {
                e eVar = e.this;
                eVar.a(view, false, 3, eVar.f40271g);
            }

            @Override // com.kwad.sdk.d.a.d
            public void f(View view) {
                e eVar = e.this;
                eVar.a(view, false, 2, eVar.f40271g);
            }

            @Override // com.kwad.sdk.d.a.d
            public void g(View view) {
                e eVar = e.this;
                eVar.a(view, false, 2, eVar.f40271g);
            }

            @Override // com.kwad.sdk.d.a.d
            public void h(View view) {
                e eVar = e.this;
                eVar.a(view, false, 2, eVar.f40271g);
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
        KsAutoCloseView ksAutoCloseView = (KsAutoCloseView) a(R.id.obfuscated_res_0x7f091096);
        this.f40270f = ksAutoCloseView;
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
        this.f40270f.setCountDownPaused(false);
    }

    @Override // com.kwad.sdk.d.kwai.b
    public void h() {
        super.h();
        this.f40270f.setCountDownPaused(true);
    }
}
