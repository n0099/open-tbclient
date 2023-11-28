package com.kwad.components.ad.splashscreen.c;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.os.SystemClock;
import android.os.Vibrator;
import android.view.View;
import android.view.ViewGroup;
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
import com.kwad.sdk.utils.bn;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class m extends i implements View.OnClickListener, com.kwad.components.ad.splashscreen.g, com.kwad.sdk.core.g.b, com.kwad.sdk.widget.c {
    public boolean CV;
    public com.kwad.components.ad.splashscreen.d DA;
    public ViewGroup DD;
    public KsShakeView DE;
    public TextView DF;
    public com.kwad.sdk.core.g.d eg;
    public Vibrator eh;
    public long mStartTime;

    @Override // com.kwad.components.ad.splashscreen.g
    public final void W(int i) {
    }

    @Override // com.kwad.sdk.core.g.b
    public final void aV() {
        com.kwad.sdk.core.report.a.bQ(this.Df.mAdTemplate);
    }

    @Override // com.kwad.components.ad.splashscreen.g
    public final void ky() {
        com.kwad.sdk.core.g.d dVar = this.eg;
        if (dVar != null) {
            dVar.bj(getContext());
        }
    }

    @Override // com.kwad.components.ad.splashscreen.c.i
    public final void ld() {
        ViewGroup viewGroup = this.DD;
        if (viewGroup != null && this.Df != null) {
            viewGroup.setVisibility(0);
            com.kwad.sdk.core.report.a.b(this.Df.mAdTemplate, (int) Constants.METHOD_IM_SEND_MCAST_MSG, (JSONObject) null);
            com.kwad.components.core.webview.tachikoma.d.a.sO().aR(Constants.METHOD_IM_SEND_MCAST_MSG);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.c.i
    public final void le() {
        float cS = com.kwad.sdk.core.response.b.b.cS(this.Df.mAdTemplate);
        com.kwad.sdk.core.g.d dVar = this.eg;
        if (dVar == null) {
            com.kwad.sdk.core.g.d dVar2 = new com.kwad.sdk.core.g.d(cS);
            this.eg = dVar2;
            dVar2.a(this);
            return;
        }
        dVar.e(cS);
    }

    @Override // com.kwad.components.ad.splashscreen.c.i
    public final void lf() {
        com.kwad.sdk.core.g.d dVar = this.eg;
        if (dVar != null) {
            dVar.bi(getContext());
        }
    }

    @Override // com.kwad.components.ad.splashscreen.c.i
    public final void lg() {
        com.kwad.sdk.core.g.d dVar = this.eg;
        if (dVar != null) {
            dVar.bj(getContext());
        }
    }

    @Override // com.kwad.components.ad.splashscreen.c.i
    public final void lh() {
        this.DE.post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.c.m.2
            @Override // java.lang.Runnable
            public final void run() {
                m.this.DE.lO();
            }
        });
    }

    @Override // com.kwad.components.ad.splashscreen.c.i, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.sdk.core.e.c.d("SplashShakePresenter", "onUnbind");
        com.kwad.components.ad.splashscreen.h hVar = this.Df;
        if (hVar != null) {
            hVar.b(this);
        }
        KsShakeView ksShakeView = this.DE;
        if (ksShakeView != null) {
            ksShakeView.lP();
        }
    }

    @Override // com.kwad.sdk.core.g.b
    public final void a(final double d) {
        boolean nj = com.kwad.components.core.e.c.b.nj();
        if (this.Df.Cr.tp() && !nj) {
            this.DE.b(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.splashscreen.c.m.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    m mVar = m.this;
                    com.kwad.components.ad.splashscreen.h hVar = mVar.Df;
                    if (hVar != null) {
                        hVar.a(1, mVar.getContext(), Cea708Decoder.COMMAND_DF5, 2, new h.a() { // from class: com.kwad.components.ad.splashscreen.c.m.3.1
                            @Override // com.kwad.components.ad.splashscreen.h.a
                            public final void b(@NonNull com.kwad.sdk.core.report.j jVar) {
                                jVar.l(d);
                            }
                        });
                    }
                    m.this.DE.lO();
                }
            });
            bn.a(getContext(), this.eh);
            lg();
        }
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view2) {
        com.kwad.components.ad.splashscreen.h hVar;
        com.kwad.sdk.core.e.c.d("SplashShakePresenter", "onSlide: enableSlickClick: " + this.CV);
        if (this.CV && (hVar = this.Df) != null) {
            hVar.c(1, view2.getContext(), 153, 1);
        }
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view2) {
        com.kwad.components.ad.splashscreen.h hVar;
        com.kwad.sdk.core.e.c.d("SplashShakePresenter", "onSingleTap: " + view2);
        if (com.kwad.sdk.core.response.b.b.dC(com.kwad.sdk.core.response.b.e.dP(this.Df.mAdTemplate)) && (hVar = this.Df) != null) {
            hVar.c(1, getContext(), Cea708Decoder.COMMAND_DF6, 1);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.c.i
    public final void initView() {
        this.mStartTime = SystemClock.elapsedRealtime();
        getRootView().post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.c.m.1
            @Override // java.lang.Runnable
            public final void run() {
                m.this.Df.CH = SystemClock.elapsedRealtime() - m.this.mStartTime;
            }
        });
        Context context = getContext();
        if (context != null) {
            this.eh = (Vibrator) context.getSystemService("vibrator");
        }
        ViewStub viewStub = (ViewStub) findViewById(R.id.obfuscated_res_0x7f0914a2);
        if (viewStub != null) {
            this.DD = (ViewGroup) viewStub.inflate();
        } else {
            this.DD = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f0914a3);
        }
        this.DF = (TextView) this.DD.findViewById(R.id.obfuscated_res_0x7f09149b);
        KsShakeView ksShakeView = (KsShakeView) this.DD.findViewById(R.id.obfuscated_res_0x7f0914a6);
        this.DE = ksShakeView;
        ksShakeView.setOnClickListener(this);
    }

    @Override // com.kwad.components.ad.splashscreen.c.i
    public final void lc() {
        AdInfo dP = com.kwad.sdk.core.response.b.e.dP(this.Df.mAdTemplate);
        com.kwad.components.ad.splashscreen.h hVar = this.Df;
        this.DA = com.kwad.components.ad.splashscreen.d.a(hVar.mAdTemplate, dP, hVar.mApkDownloadHelper, 2);
        this.CV = com.kwad.sdk.core.response.b.d.dE(this.Df.mAdTemplate);
        new com.kwad.sdk.widget.f(this.DE.getContext(), this.DE, this);
        this.Df.a(this);
        TextView textView = this.DF;
        if (textView != null) {
            textView.setText(this.DA.ks());
        }
        KsShakeView ksShakeView = this.DE;
        if (ksShakeView != null) {
            ksShakeView.ac(this.DA.kt());
        }
    }

    @Override // com.kwad.components.ad.splashscreen.c.i
    public final void j(int i, String str) {
        TextView textView = this.DF;
        if (textView != null) {
            if (i == 2) {
                textView.setText(str);
                return;
            }
            textView.setText("或点击" + str);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        com.kwad.components.ad.splashscreen.h hVar;
        AdTemplate adTemplate;
        com.kwad.sdk.core.e.c.d("SplashShakePresenter", "onClick: " + view2);
        if (view2.equals(this.DE) && (hVar = this.Df) != null && (adTemplate = hVar.mAdTemplate) != null && com.kwad.sdk.core.response.b.b.dC(com.kwad.sdk.core.response.b.e.dP(adTemplate))) {
            this.Df.c(1, getContext(), Cea708Decoder.COMMAND_DF6, 1);
        }
    }
}
