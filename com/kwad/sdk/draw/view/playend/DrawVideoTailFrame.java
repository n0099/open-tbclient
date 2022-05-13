package com.kwad.sdk.draw.view.playend;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.core.download.a.a;
import com.kwad.sdk.core.download.a.b;
import com.kwad.sdk.core.download.a.c;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.a.a;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.draw.view.DrawDownloadProgressBar;
import com.kwad.sdk.reward.widget.AppScoreView;
import com.kwad.sdk.widget.KsLogoView;
/* loaded from: classes5.dex */
public class DrawVideoTailFrame extends FrameLayout implements View.OnClickListener {
    public AdBaseFrameLayout a;
    public AdTemplate b;
    public AdInfo c;
    @Nullable
    public b d;
    @Nullable
    public KsAppDownloadListener e;
    public ImageView f;
    public ViewGroup g;
    public ImageView h;
    public TextView i;
    public AppScoreView j;
    public TextView k;
    public TextView l;
    public DrawDownloadProgressBar m;
    public ViewGroup n;
    public TextView o;
    public TextView p;
    public KsDrawAd.AdInteractionListener q;
    public KsLogoView r;

    public DrawVideoTailFrame(@NonNull Context context) {
        super(context);
        a(context);
    }

    public DrawVideoTailFrame(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public DrawVideoTailFrame(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private void a(Context context) {
        FrameLayout.inflate(context, R.layout.obfuscated_res_0x7f0d0421, this);
        this.f = (ImageView) findViewById(R.id.obfuscated_res_0x7f091172);
        this.g = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f091039);
        this.h = (ImageView) findViewById(R.id.obfuscated_res_0x7f09103f);
        this.i = (TextView) findViewById(R.id.obfuscated_res_0x7f091041);
        this.j = (AppScoreView) findViewById(R.id.obfuscated_res_0x7f091042);
        this.k = (TextView) findViewById(R.id.obfuscated_res_0x7f09103e);
        this.l = (TextView) findViewById(R.id.obfuscated_res_0x7f091038);
        DrawDownloadProgressBar drawDownloadProgressBar = (DrawDownloadProgressBar) findViewById(R.id.obfuscated_res_0x7f09103c);
        this.m = drawDownloadProgressBar;
        drawDownloadProgressBar.setTextSize(15);
        this.n = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f091093);
        this.o = (TextView) findViewById(R.id.obfuscated_res_0x7f091092);
        this.p = (TextView) findViewById(R.id.obfuscated_res_0x7f091096);
        this.r = (KsLogoView) findViewById(R.id.obfuscated_res_0x7f091083);
    }

    private KsAppDownloadListener getAppDownloadListener() {
        return new c() { // from class: com.kwad.sdk.draw.view.playend.DrawVideoTailFrame.1
            @Override // com.kwad.sdk.core.download.a.c
            public void a(int i) {
                super.a(i);
                DrawVideoTailFrame.this.m.a(a.a(), i);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFailed() {
                DrawVideoTailFrame.this.m.a(a.A(DrawVideoTailFrame.this.c), DrawVideoTailFrame.this.m.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFinished() {
                DrawVideoTailFrame.this.m.a(a.a(DrawVideoTailFrame.this.b), DrawVideoTailFrame.this.m.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onIdle() {
                DrawVideoTailFrame.this.m.a(a.A(DrawVideoTailFrame.this.c), DrawVideoTailFrame.this.m.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onInstalled() {
                DrawVideoTailFrame.this.m.a(a.m(DrawVideoTailFrame.this.c), DrawVideoTailFrame.this.m.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onProgressUpdate(int i) {
                DrawDownloadProgressBar drawDownloadProgressBar = DrawVideoTailFrame.this.m;
                drawDownloadProgressBar.a(i + "%", i);
            }
        };
    }

    public void a() {
        b bVar = this.d;
        if (bVar != null) {
            KsAppDownloadListener ksAppDownloadListener = this.e;
            if (ksAppDownloadListener != null) {
                bVar.c(ksAppDownloadListener);
                return;
            }
            KsAppDownloadListener appDownloadListener = getAppDownloadListener();
            this.e = appDownloadListener;
            this.d.a(appDownloadListener);
        }
    }

    public void a(AdTemplate adTemplate) {
        this.b = adTemplate;
        AdInfo j = d.j(adTemplate);
        this.c = j;
        AdInfo.AdMaterialInfo.MaterialFeature J = a.J(j);
        String str = J.coverUrl;
        this.r.a(adTemplate);
        if (!TextUtils.isEmpty(str)) {
            int i = J.width;
            int i2 = J.height;
            if (i > 0 && i > i2) {
                int c = com.kwad.sdk.a.kwai.a.c(getContext());
                if (getWidth() != 0) {
                    c = getWidth();
                }
                ViewGroup.LayoutParams layoutParams = this.f.getLayoutParams();
                layoutParams.width = c;
                layoutParams.height = (int) (c * (i2 / i));
            }
            KSImageLoader.loadImage(this.f, str, this.b);
        }
        if (a.B(this.c)) {
            KSImageLoader.loadAppIcon(this.h, a.au(this.c), this.b, 11);
            this.i.setText(a.t(this.c));
            float x = a.x(this.c);
            if (x >= 3.0f) {
                this.j.setScore(x);
                this.j.setVisibility(0);
            }
            this.k.setText(a.w(this.c));
            this.l.setText(a.s(this.c));
            this.g.setVisibility(0);
            this.n.setVisibility(8);
        } else {
            this.o.setText(a.s(this.c));
            this.p.setText(a.A(this.c));
            this.g.setVisibility(8);
            this.n.setVisibility(0);
        }
        this.m.setOnClickListener(this);
        setOnClickListener(this);
    }

    public void b() {
        KsAppDownloadListener ksAppDownloadListener;
        b bVar = this.d;
        if (bVar == null || (ksAppDownloadListener = this.e) == null) {
            return;
        }
        bVar.b(ksAppDownloadListener);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        com.kwad.sdk.core.download.a.a.a(new a.C0295a(getContext()).a(this.b).a(this.d).a(view2 == this.m ? 1 : 2).a(view2 == this.m).a(new a.b() { // from class: com.kwad.sdk.draw.view.playend.DrawVideoTailFrame.2
            @Override // com.kwad.sdk.core.download.a.a.b
            public void a() {
                if (DrawVideoTailFrame.this.q != null) {
                    DrawVideoTailFrame.this.q.onAdClicked();
                }
                com.kwad.sdk.core.report.a.a(DrawVideoTailFrame.this.b, 2, DrawVideoTailFrame.this.a.getTouchCoords());
            }
        }));
    }

    public void setAdBaseFrameLayout(AdBaseFrameLayout adBaseFrameLayout) {
        this.a = adBaseFrameLayout;
    }

    public void setAdInteractionListener(KsDrawAd.AdInteractionListener adInteractionListener) {
        this.q = adInteractionListener;
    }

    public void setApkDownloadHelper(@Nullable b bVar) {
        this.d = bVar;
    }
}
