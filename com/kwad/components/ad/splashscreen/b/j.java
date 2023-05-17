package com.kwad.components.ad.splashscreen.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Vibrator;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.google.android.exoplayer2.text.cea.Cea708Decoder;
import com.kwad.components.ad.splashscreen.h;
import com.kwad.components.ad.splashscreen.widget.KsShakeView;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bd;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class j extends e implements View.OnClickListener, com.kwad.components.ad.splashscreen.g, com.kwad.sdk.core.g.b, com.kwad.sdk.widget.c {
    public static long gO = 400;
    public com.kwad.sdk.core.g.d eN;
    public Vibrator eO;
    public com.kwad.components.ad.splashscreen.d.a yM;
    public com.kwad.components.ad.splashscreen.e yT;
    public View yX;
    public KsShakeView yY;
    public TextView yZ;
    public boolean yw;

    private void km() {
        com.kwad.components.ad.splashscreen.h hVar = this.yF;
        if (hVar != null) {
            com.kwad.components.ad.splashscreen.d.a aVar = this.yM;
            if (aVar == null) {
                this.yM = new com.kwad.components.ad.splashscreen.d.a(getContext(), this.yF.mAdTemplate) { // from class: com.kwad.components.ad.splashscreen.b.j.2
                    @Override // com.kwad.components.ad.splashscreen.d.a
                    @SuppressLint({"SetTextI18n"})
                    public final void Z(String str) {
                        if (j.this.yZ != null) {
                            TextView textView = j.this.yZ;
                            textView.setText("或点击" + str);
                        }
                    }
                };
            } else {
                aVar.setAdTemplate(hVar.mAdTemplate);
            }
            com.kwad.components.core.c.a.c cVar = this.yF.mApkDownloadHelper;
            if (cVar != null) {
                cVar.b(this.yM);
            }
        }
    }

    private void kp() {
        TextView textView = this.yZ;
        if (textView != null) {
            textView.setText(this.yT.jw());
        }
        KsShakeView ksShakeView = this.yY;
        if (ksShakeView != null) {
            ksShakeView.Z(this.yT.jx());
        }
        if (com.kwad.components.ad.splashscreen.d.c.b(this.yF)) {
            com.kwad.components.ad.splashscreen.d.c.a(this.yZ, -1, 60, -1, -1);
        }
    }

    private void kq() {
        View view2 = this.yX;
        if (view2 == null || this.yF == null) {
            return;
        }
        view2.setVisibility(0);
        com.kwad.sdk.core.report.a.c(this.yF.mAdTemplate, (int) Constants.METHOD_IM_SEND_MCAST_MSG, (JSONObject) null);
    }

    @Override // com.kwad.sdk.core.g.b
    public final void a(final double d) {
        boolean mq = com.kwad.components.core.c.kwai.b.mq();
        if (!this.yF.yd.qm() || mq) {
            bd.a(new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.j.3
                @Override // java.lang.Runnable
                public final void run() {
                    j.this.eN.vb();
                }
            }, null, 500L);
            return;
        }
        this.yY.a(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.splashscreen.b.j.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                j jVar = j.this;
                com.kwad.components.ad.splashscreen.h hVar = jVar.yF;
                if (hVar != null) {
                    hVar.a(jVar.getContext(), Cea708Decoder.COMMAND_DF5, 2, new h.a() { // from class: com.kwad.components.ad.splashscreen.b.j.4.1
                        @Override // com.kwad.components.ad.splashscreen.h.a
                        public final void b(@NonNull com.kwad.sdk.core.report.f fVar) {
                            fVar.e(d);
                        }
                    });
                }
                j.this.yY.kG();
                bd.a(new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.j.4.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.kwad.sdk.core.e.b.d("SplashShakePresenter", "onShakeEvent openGate2");
                        j.this.eN.vb();
                    }
                }, null, 500L);
            }
        });
        bd.a(getContext(), this.eO);
    }

    @Override // com.kwad.components.ad.splashscreen.b.e, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        super.aq();
        com.kwad.components.ad.splashscreen.h hVar = this.yF;
        if (hVar == null) {
            return;
        }
        AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(hVar.mAdTemplate);
        getContext();
        com.kwad.components.ad.splashscreen.h hVar2 = this.yF;
        this.yT = com.kwad.components.ad.splashscreen.e.a(hVar2.mAdTemplate, bQ, hVar2.mApkDownloadHelper, 2);
        float bp = com.kwad.sdk.core.response.a.b.bp(this.yF.mAdTemplate);
        com.kwad.sdk.core.g.d dVar = this.eN;
        if (dVar == null) {
            com.kwad.sdk.core.g.d dVar2 = new com.kwad.sdk.core.g.d(bp);
            this.eN = dVar2;
            dVar2.a(this);
        } else {
            dVar.d(bp);
        }
        kp();
        if (com.kwad.sdk.core.response.a.a.am(bQ)) {
            km();
        }
        kq();
        this.eN.bz(getContext());
        this.yY.post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.j.1
            @Override // java.lang.Runnable
            public final void run() {
                j.this.yY.kG();
            }
        });
        com.kwad.components.ad.splashscreen.local.b.G(getContext());
        this.yw = com.kwad.sdk.core.response.a.c.bF(this.yF.mAdTemplate);
        new com.kwad.sdk.widget.f(this.yY.getContext(), this.yY, this);
        this.yF.a(this);
    }

    @Override // com.kwad.sdk.core.g.b
    public final void bX() {
        com.kwad.sdk.core.report.a.az(this.yF.mAdTemplate);
    }

    @Override // com.kwad.sdk.widget.c
    public final void f(View view2) {
        com.kwad.components.ad.splashscreen.h hVar;
        com.kwad.sdk.core.e.b.d("SplashShakePresenter", "onSingleTap: " + view2);
        if (com.kwad.sdk.core.response.a.b.cf(com.kwad.sdk.core.response.a.d.bQ(this.yF.mAdTemplate)) && (hVar = this.yF) != null) {
            hVar.c(getContext(), Cea708Decoder.COMMAND_DF6, 1);
        }
    }

    @Override // com.kwad.sdk.widget.c
    public final void g(View view2) {
        com.kwad.components.ad.splashscreen.h hVar;
        com.kwad.sdk.core.e.b.d("SplashShakePresenter", "onSlide: enableSlickClick: " + this.yw);
        if (this.yw && (hVar = this.yF) != null) {
            hVar.c(view2.getContext(), 153, 1);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.g
    public final void jy() {
        com.kwad.sdk.core.g.d dVar = this.eN;
        if (dVar != null) {
            dVar.bA(getContext());
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        com.kwad.components.ad.splashscreen.h hVar;
        AdTemplate adTemplate;
        com.kwad.sdk.core.e.b.d("SplashShakePresenter", "onClick: " + view2);
        if (!view2.equals(this.yY) || (hVar = this.yF) == null || (adTemplate = hVar.mAdTemplate) == null || !com.kwad.sdk.core.response.a.b.cf(com.kwad.sdk.core.response.a.d.bQ(adTemplate))) {
            return;
        }
        this.yF.c(getContext(), Cea708Decoder.COMMAND_DF6, 1);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        Context context = getContext();
        if (context != null) {
            this.eO = (Vibrator) context.getSystemService("vibrator");
        }
        this.yX = ((ViewStub) findViewById(R.id.obfuscated_res_0x7f091398)).inflate();
        this.yZ = (TextView) findViewById(R.id.obfuscated_res_0x7f091391);
        KsShakeView ksShakeView = (KsShakeView) findViewById(R.id.obfuscated_res_0x7f09139b);
        this.yY = ksShakeView;
        ksShakeView.setOnClickListener(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.sdk.core.e.b.d("SplashShakePresenter", "onUnbind");
        com.kwad.components.ad.splashscreen.h hVar = this.yF;
        if (hVar != null) {
            hVar.b(this);
        }
        com.kwad.sdk.core.g.d dVar = this.eN;
        if (dVar != null) {
            dVar.bA(getContext());
        }
        KsShakeView ksShakeView = this.yY;
        if (ksShakeView != null) {
            ksShakeView.bt();
        }
    }
}
