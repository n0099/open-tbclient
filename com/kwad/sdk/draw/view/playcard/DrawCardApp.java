package com.kwad.sdk.draw.view.playcard;

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
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.download.a.a;
import com.kwad.sdk.core.download.a.b;
import com.kwad.sdk.core.download.a.c;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.draw.view.DrawDownloadProgressBar;
import com.kwad.sdk.reward.widget.AppScoreView;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.widget.KsLogoView;
/* loaded from: classes5.dex */
public class DrawCardApp extends FrameLayout implements View.OnClickListener {
    public AdTemplate a;
    public AdInfo b;
    public b c;
    public KsAppDownloadListener d;
    public a e;
    public int f;
    public ImageView g;
    public ImageView h;
    public TextView i;
    public ViewGroup j;
    public AppScoreView k;
    public TextView l;
    public TextView m;
    public KsLogoView n;
    public DrawDownloadProgressBar o;
    public ValueAnimator p;

    /* loaded from: classes5.dex */
    public interface a {
        void a();

        void b();
    }

    public DrawCardApp(Context context) {
        super(context);
        a(context);
    }

    public DrawCardApp(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public DrawCardApp(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private void a(int i, int i2) {
        d();
        ValueAnimator a2 = az.a(this, i, i2);
        this.p = a2;
        a2.setInterpolator(new DecelerateInterpolator(2.0f));
        this.p.setDuration(300L);
        this.p.start();
    }

    private void a(Context context) {
        FrameLayout.inflate(context, R.layout.obfuscated_res_0x7f0d041d, this);
        this.g = (ImageView) findViewById(R.id.obfuscated_res_0x7f091052);
        this.h = (ImageView) findViewById(R.id.obfuscated_res_0x7f091057);
        this.i = (TextView) findViewById(R.id.obfuscated_res_0x7f091058);
        this.j = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f09105a);
        this.k = (AppScoreView) findViewById(R.id.obfuscated_res_0x7f091059);
        this.l = (TextView) findViewById(R.id.obfuscated_res_0x7f091056);
        this.m = (TextView) findViewById(R.id.obfuscated_res_0x7f091054);
        this.n = (KsLogoView) findViewById(R.id.obfuscated_res_0x7f09105e);
        DrawDownloadProgressBar drawDownloadProgressBar = (DrawDownloadProgressBar) findViewById(R.id.obfuscated_res_0x7f091055);
        this.o = drawDownloadProgressBar;
        drawDownloadProgressBar.setTextSize(16);
        this.f = com.kwad.sdk.a.kwai.a.a(context, 156.0f);
    }

    private void d() {
        ValueAnimator valueAnimator = this.p;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.p.cancel();
        }
    }

    private KsAppDownloadListener getAppDownloadListener() {
        if (this.d == null) {
            this.d = new c() { // from class: com.kwad.sdk.draw.view.playcard.DrawCardApp.1
                @Override // com.kwad.sdk.core.download.a.c
                public void a(int i) {
                    super.a(i);
                    DrawCardApp.this.o.a(com.kwad.sdk.core.response.a.a.a(), i);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFailed() {
                    DrawCardApp.this.o.a(com.kwad.sdk.core.response.a.a.A(DrawCardApp.this.b), DrawCardApp.this.o.getMax());
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFinished() {
                    DrawCardApp.this.o.a(com.kwad.sdk.core.response.a.a.a(DrawCardApp.this.a), DrawCardApp.this.o.getMax());
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onIdle() {
                    DrawCardApp.this.o.a(com.kwad.sdk.core.response.a.a.A(DrawCardApp.this.b), DrawCardApp.this.o.getMax());
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onInstalled() {
                    DrawCardApp.this.o.a(com.kwad.sdk.core.response.a.a.m(DrawCardApp.this.b), DrawCardApp.this.o.getMax());
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onProgressUpdate(int i) {
                    DrawDownloadProgressBar drawDownloadProgressBar = DrawCardApp.this.o;
                    drawDownloadProgressBar.a(i + "%", i);
                }
            };
        }
        return this.d;
    }

    public void a() {
        d();
        this.c = null;
    }

    public void a(@NonNull AdTemplate adTemplate, a aVar) {
        this.a = adTemplate;
        this.b = d.j(adTemplate);
        this.e = aVar;
        this.c = new b(this.a, getAppDownloadListener());
        KSImageLoader.loadAppIcon(this.h, com.kwad.sdk.core.response.a.a.au(this.b), adTemplate, 11);
        this.i.setText(com.kwad.sdk.core.response.a.a.t(this.b));
        String w = com.kwad.sdk.core.response.a.a.w(this.b);
        float x = com.kwad.sdk.core.response.a.a.x(this.b);
        boolean z = x >= 3.0f;
        if (z) {
            this.k.setScore(x);
            this.k.setVisibility(0);
        }
        boolean z2 = !TextUtils.isEmpty(w);
        if (z2) {
            this.l.setText(w);
            this.l.setVisibility(0);
        }
        if (z || z2) {
            this.j.setVisibility(0);
        } else {
            this.j.setVisibility(8);
        }
        this.n.a(this.a);
        this.m.setText(com.kwad.sdk.core.response.a.a.s(this.b));
        this.g.setOnClickListener(this);
        this.o.setOnClickListener(this);
        setOnClickListener(this);
    }

    public void b() {
        a(0, this.f);
    }

    public void c() {
        a(this.f, 0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 != this.g) {
            com.kwad.sdk.core.download.a.a.a(new a.C0295a(getContext()).a(this.a).a(this.c).a(view2 == this.o).a(view2 == this.o ? 1 : 2).a(new a.b() { // from class: com.kwad.sdk.draw.view.playcard.DrawCardApp.2
                @Override // com.kwad.sdk.core.download.a.a.b
                public void a() {
                    if (DrawCardApp.this.e != null) {
                        DrawCardApp.this.e.b();
                    }
                }
            }));
            return;
        }
        c();
        a aVar = this.e;
        if (aVar != null) {
            aVar.a();
        }
    }
}
