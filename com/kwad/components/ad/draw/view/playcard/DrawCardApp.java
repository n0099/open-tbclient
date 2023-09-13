package com.kwad.components.ad.draw.view.playcard;

import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.components.ad.draw.view.DrawDownloadProgressBar;
import com.kwad.components.ad.widget.AppScoreView;
import com.kwad.components.core.c.a.a;
import com.kwad.components.core.c.a.c;
import com.kwad.components.core.m.n;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes10.dex */
public class DrawCardApp extends FrameLayout implements View.OnClickListener {
    public KsAppDownloadListener br;
    public a cc;
    public ImageView cd;
    public ImageView ce;
    public TextView cf;
    public ViewGroup cg;
    public AppScoreView ch;
    public TextView ci;
    public TextView cj;
    public KsLogoView ck;
    public DrawDownloadProgressBar cl;
    public ValueAnimator cm;
    public AdInfo mAdInfo;
    public AdTemplate mAdTemplate;
    public c mApkDownloadHelper;
    public int mHeight;

    /* loaded from: classes10.dex */
    public interface a {
        void aC();

        void aD();
    }

    public DrawCardApp(Context context) {
        super(context);
        E(context);
    }

    public DrawCardApp(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        E(context);
    }

    public DrawCardApp(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        E(context);
    }

    private void E(Context context) {
        FrameLayout.inflate(context, R.layout.obfuscated_res_0x7f0d049d, this);
        this.cd = (ImageView) findViewById(R.id.obfuscated_res_0x7f09129b);
        this.ce = (ImageView) findViewById(R.id.obfuscated_res_0x7f0912a0);
        this.cf = (TextView) findViewById(R.id.obfuscated_res_0x7f0912a1);
        this.cg = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f0912a3);
        this.ch = (AppScoreView) findViewById(R.id.obfuscated_res_0x7f0912a2);
        this.ci = (TextView) findViewById(R.id.obfuscated_res_0x7f09129f);
        this.cj = (TextView) findViewById(R.id.obfuscated_res_0x7f09129d);
        this.ck = (KsLogoView) findViewById(R.id.obfuscated_res_0x7f0912a7);
        DrawDownloadProgressBar drawDownloadProgressBar = (DrawDownloadProgressBar) findViewById(R.id.obfuscated_res_0x7f09129e);
        this.cl = drawDownloadProgressBar;
        drawDownloadProgressBar.setTextSize(16);
        this.mHeight = com.kwad.sdk.b.kwai.a.a(context, 156.0f);
    }

    private void aL() {
        ValueAnimator valueAnimator = this.cm;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.cm.cancel();
        }
    }

    private void aU() {
        d(this.mHeight, 0);
    }

    private void d(int i, int i2) {
        aL();
        ValueAnimator b = n.b(this, i, i2);
        this.cm = b;
        b.setInterpolator(new DecelerateInterpolator(2.0f));
        this.cm.setDuration(300L);
        this.cm.start();
    }

    private KsAppDownloadListener getAppDownloadListener() {
        if (this.br == null) {
            this.br = new com.kwad.sdk.core.download.kwai.a() { // from class: com.kwad.components.ad.draw.view.playcard.DrawCardApp.1
                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFailed() {
                    DrawCardApp.this.cl.f(com.kwad.sdk.core.response.a.a.al(DrawCardApp.this.mAdInfo), DrawCardApp.this.cl.getMax());
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFinished() {
                    DrawCardApp.this.cl.f(com.kwad.sdk.core.response.a.a.aJ(DrawCardApp.this.mAdTemplate), DrawCardApp.this.cl.getMax());
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onIdle() {
                    DrawCardApp.this.cl.f(com.kwad.sdk.core.response.a.a.al(DrawCardApp.this.mAdInfo), DrawCardApp.this.cl.getMax());
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onInstalled() {
                    DrawCardApp.this.cl.f(com.kwad.sdk.core.response.a.a.P(DrawCardApp.this.mAdInfo), DrawCardApp.this.cl.getMax());
                }

                @Override // com.kwad.sdk.core.download.kwai.a
                public final void onPaused(int i) {
                    super.onPaused(i);
                    DrawCardApp.this.cl.f(com.kwad.sdk.core.response.a.a.uU(), i);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onProgressUpdate(int i) {
                    DrawDownloadProgressBar drawDownloadProgressBar = DrawCardApp.this.cl;
                    drawDownloadProgressBar.f(i + "%", i);
                }
            };
        }
        return this.br;
    }

    public final void a(@NonNull AdTemplate adTemplate, a aVar) {
        this.mAdTemplate = adTemplate;
        this.mAdInfo = d.bQ(adTemplate);
        this.cc = aVar;
        this.mApkDownloadHelper = new c(this.mAdTemplate, getAppDownloadListener());
        KSImageLoader.loadAppIcon(this.ce, com.kwad.sdk.core.response.a.a.bn(this.mAdInfo), adTemplate, 11);
        this.cf.setText(com.kwad.sdk.core.response.a.a.ae(this.mAdInfo));
        String ah = com.kwad.sdk.core.response.a.a.ah(this.mAdInfo);
        float ai = com.kwad.sdk.core.response.a.a.ai(this.mAdInfo);
        boolean z = ai >= 3.0f;
        if (z) {
            this.ch.setScore(ai);
            this.ch.setVisibility(0);
        }
        boolean z2 = !TextUtils.isEmpty(ah);
        if (z2) {
            this.ci.setText(ah);
            this.ci.setVisibility(0);
        }
        if (z || z2) {
            this.cg.setVisibility(0);
        } else {
            this.cg.setVisibility(8);
        }
        this.ck.T(this.mAdTemplate);
        this.cj.setText(com.kwad.sdk.core.response.a.a.ad(this.mAdInfo));
        this.cd.setOnClickListener(this);
        this.cl.setOnClickListener(this);
        setOnClickListener(this);
    }

    public final void aT() {
        d(0, this.mHeight);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 != this.cd) {
            com.kwad.components.core.c.a.a.a(new a.C0643a(getContext()).L(this.mAdTemplate).b(this.mApkDownloadHelper).aj(view2 == this.cl).ae(view2 == this.cl ? 1 : 2).a(new a.b() { // from class: com.kwad.components.ad.draw.view.playcard.DrawCardApp.2
                @Override // com.kwad.components.core.c.a.a.b
                public final void onAdClicked() {
                    if (DrawCardApp.this.cc != null) {
                        DrawCardApp.this.cc.aD();
                    }
                }
            }));
            return;
        }
        aU();
        a aVar = this.cc;
        if (aVar != null) {
            aVar.aC();
        }
    }

    public final void release() {
        aL();
        this.mApkDownloadHelper = null;
    }
}
