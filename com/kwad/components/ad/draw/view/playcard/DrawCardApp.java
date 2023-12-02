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
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.e.d.c;
import com.kwad.components.core.s.n;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.m.l;
/* loaded from: classes10.dex */
public class DrawCardApp extends FrameLayout implements View.OnClickListener {
    public KsAppDownloadListener cx;
    public a dk;
    public ImageView dl;
    public ImageView dm;
    public TextView dn;

    /* renamed from: do  reason: not valid java name */
    public ViewGroup f4do;
    public AppScoreView dp;
    public TextView dq;
    public TextView dr;
    public KsLogoView ds;
    public DrawDownloadProgressBar dt;
    public ValueAnimator du;
    public AdInfo mAdInfo;
    public AdTemplate mAdTemplate;
    public c mApkDownloadHelper;
    public int mHeight;

    /* loaded from: classes10.dex */
    public interface a {
        void av();

        void aw();
    }

    public DrawCardApp(Context context) {
        super(context);
        B(context);
    }

    public DrawCardApp(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        B(context);
    }

    private void d(int i, int i2) {
        aG();
        ValueAnimator b = n.b(this, i, i2);
        this.du = b;
        b.setInterpolator(new DecelerateInterpolator(2.0f));
        this.du.setDuration(300L);
        this.du.start();
    }

    public DrawCardApp(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        B(context);
    }

    private void B(Context context) {
        l.inflate(context, R.layout.obfuscated_res_0x7f0d04c0, this);
        this.dl = (ImageView) findViewById(R.id.obfuscated_res_0x7f09131b);
        this.dm = (ImageView) findViewById(R.id.obfuscated_res_0x7f091320);
        this.dn = (TextView) findViewById(R.id.obfuscated_res_0x7f091321);
        this.f4do = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f091323);
        this.dp = (AppScoreView) findViewById(R.id.obfuscated_res_0x7f091322);
        this.dq = (TextView) findViewById(R.id.obfuscated_res_0x7f09131f);
        this.dr = (TextView) findViewById(R.id.obfuscated_res_0x7f09131d);
        this.ds = (KsLogoView) findViewById(R.id.obfuscated_res_0x7f091327);
        DrawDownloadProgressBar drawDownloadProgressBar = (DrawDownloadProgressBar) findViewById(R.id.obfuscated_res_0x7f09131e);
        this.dt = drawDownloadProgressBar;
        drawDownloadProgressBar.setTextSize(16);
        this.mHeight = com.kwad.sdk.d.a.a.a(context, 156.0f);
    }

    private void aG() {
        ValueAnimator valueAnimator = this.du;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.du.cancel();
        }
    }

    private void aP() {
        d(this.mHeight, 0);
    }

    private KsAppDownloadListener getAppDownloadListener() {
        if (this.cx == null) {
            this.cx = new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.ad.draw.view.playcard.DrawCardApp.1
                @Override // com.kwad.sdk.core.download.a.a
                public final void onPaused(int i) {
                    super.onPaused(i);
                    DrawCardApp.this.dt.e(com.kwad.sdk.core.response.b.a.DX(), i);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onProgressUpdate(int i) {
                    DrawDownloadProgressBar drawDownloadProgressBar = DrawCardApp.this.dt;
                    drawDownloadProgressBar.e(i + "%", i);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFailed() {
                    DrawCardApp.this.dt.e(com.kwad.sdk.core.response.b.a.aE(DrawCardApp.this.mAdInfo), DrawCardApp.this.dt.getMax());
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFinished() {
                    DrawCardApp.this.dt.e(com.kwad.sdk.core.response.b.a.bX(DrawCardApp.this.mAdTemplate), DrawCardApp.this.dt.getMax());
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onIdle() {
                    DrawCardApp.this.dt.e(com.kwad.sdk.core.response.b.a.aE(DrawCardApp.this.mAdInfo), DrawCardApp.this.dt.getMax());
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onInstalled() {
                    DrawCardApp.this.dt.e(com.kwad.sdk.core.response.b.a.ac(DrawCardApp.this.mAdInfo), DrawCardApp.this.dt.getMax());
                }
            };
        }
        return this.cx;
    }

    public final void aO() {
        d(0, this.mHeight);
    }

    public final void release() {
        aG();
        this.mApkDownloadHelper = null;
    }

    public final void a(@NonNull AdTemplate adTemplate, a aVar) {
        boolean z;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = e.dP(adTemplate);
        this.dk = aVar;
        this.mApkDownloadHelper = new c(this.mAdTemplate, getAppDownloadListener());
        KSImageLoader.loadAppIcon(this.dm, com.kwad.sdk.core.response.b.a.cf(this.mAdInfo), adTemplate, 11);
        this.dn.setText(com.kwad.sdk.core.response.b.a.av(this.mAdInfo));
        String az = com.kwad.sdk.core.response.b.a.az(this.mAdInfo);
        float aA = com.kwad.sdk.core.response.b.a.aA(this.mAdInfo);
        if (aA >= 3.0f) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            this.dp.setScore(aA);
            this.dp.setVisibility(0);
        }
        boolean z2 = !TextUtils.isEmpty(az);
        if (z2) {
            this.dq.setText(az);
            this.dq.setVisibility(0);
        }
        if (!z && !z2) {
            this.f4do.setVisibility(8);
        } else {
            this.f4do.setVisibility(0);
        }
        this.ds.aD(this.mAdTemplate);
        this.dr.setText(com.kwad.sdk.core.response.b.a.au(this.mAdInfo));
        this.dl.setOnClickListener(this);
        this.dt.setOnClickListener(this);
        setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        int i;
        if (view2 == this.dl) {
            aP();
            a aVar = this.dk;
            if (aVar != null) {
                aVar.av();
                return;
            }
            return;
        }
        boolean z = true;
        if (view2 == this.dt) {
            i = 1;
        } else {
            i = 2;
        }
        a.C0644a b = new a.C0644a(getContext()).aq(this.mAdTemplate).b(this.mApkDownloadHelper);
        if (view2 != this.dt) {
            z = false;
        }
        com.kwad.components.core.e.d.a.a(b.ao(z).an(i).a(new a.b() { // from class: com.kwad.components.ad.draw.view.playcard.DrawCardApp.2
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                if (DrawCardApp.this.dk != null) {
                    DrawCardApp.this.dk.aw();
                }
            }
        }));
    }
}
