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
import com.kwad.sdk.R;
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
/* loaded from: classes4.dex */
public class DrawCardApp extends FrameLayout implements View.OnClickListener {
    public AdTemplate a;

    /* renamed from: b  reason: collision with root package name */
    public AdInfo f56958b;

    /* renamed from: c  reason: collision with root package name */
    public b f56959c;

    /* renamed from: d  reason: collision with root package name */
    public KsAppDownloadListener f56960d;

    /* renamed from: e  reason: collision with root package name */
    public a f56961e;

    /* renamed from: f  reason: collision with root package name */
    public int f56962f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f56963g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f56964h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f56965i;

    /* renamed from: j  reason: collision with root package name */
    public ViewGroup f56966j;
    public AppScoreView k;
    public TextView l;
    public TextView m;
    public KsLogoView n;
    public DrawDownloadProgressBar o;
    public ValueAnimator p;

    /* loaded from: classes4.dex */
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

    public DrawCardApp(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context);
    }

    private void a(int i2, int i3) {
        d();
        ValueAnimator a2 = az.a(this, i2, i3);
        this.p = a2;
        a2.setInterpolator(new DecelerateInterpolator(2.0f));
        this.p.setDuration(300L);
        this.p.start();
    }

    private void a(Context context) {
        FrameLayout.inflate(context, R.layout.ksad_draw_card_app, this);
        this.f56963g = (ImageView) findViewById(R.id.ksad_card_app_close);
        this.f56964h = (ImageView) findViewById(R.id.ksad_card_app_icon);
        this.f56965i = (TextView) findViewById(R.id.ksad_card_app_name);
        this.f56966j = (ViewGroup) findViewById(R.id.ksad_card_app_score_container);
        this.k = (AppScoreView) findViewById(R.id.ksad_card_app_score);
        this.l = (TextView) findViewById(R.id.ksad_card_app_download_count);
        this.m = (TextView) findViewById(R.id.ksad_card_app_desc);
        this.n = (KsLogoView) findViewById(R.id.ksad_card_logo);
        DrawDownloadProgressBar drawDownloadProgressBar = (DrawDownloadProgressBar) findViewById(R.id.ksad_card_app_download_btn);
        this.o = drawDownloadProgressBar;
        drawDownloadProgressBar.setTextSize(16);
        this.f56962f = com.kwad.sdk.a.kwai.a.a(context, 156.0f);
    }

    private void d() {
        ValueAnimator valueAnimator = this.p;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.p.cancel();
        }
    }

    private KsAppDownloadListener getAppDownloadListener() {
        if (this.f56960d == null) {
            this.f56960d = new c() { // from class: com.kwad.sdk.draw.view.playcard.DrawCardApp.1
                @Override // com.kwad.sdk.core.download.a.c
                public void a(int i2) {
                    super.a(i2);
                    DrawCardApp.this.o.a(com.kwad.sdk.core.response.a.a.a(), i2);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFailed() {
                    DrawCardApp.this.o.a(com.kwad.sdk.core.response.a.a.A(DrawCardApp.this.f56958b), DrawCardApp.this.o.getMax());
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFinished() {
                    DrawCardApp.this.o.a(com.kwad.sdk.core.response.a.a.a(DrawCardApp.this.a), DrawCardApp.this.o.getMax());
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onIdle() {
                    DrawCardApp.this.o.a(com.kwad.sdk.core.response.a.a.A(DrawCardApp.this.f56958b), DrawCardApp.this.o.getMax());
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onInstalled() {
                    DrawCardApp.this.o.a(com.kwad.sdk.core.response.a.a.m(DrawCardApp.this.f56958b), DrawCardApp.this.o.getMax());
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onProgressUpdate(int i2) {
                    DrawDownloadProgressBar drawDownloadProgressBar = DrawCardApp.this.o;
                    drawDownloadProgressBar.a(i2 + "%", i2);
                }
            };
        }
        return this.f56960d;
    }

    public void a() {
        d();
        this.f56959c = null;
    }

    public void a(@NonNull AdTemplate adTemplate, a aVar) {
        this.a = adTemplate;
        this.f56958b = d.j(adTemplate);
        this.f56961e = aVar;
        this.f56959c = new b(this.a, getAppDownloadListener());
        KSImageLoader.loadAppIcon(this.f56964h, com.kwad.sdk.core.response.a.a.au(this.f56958b), adTemplate, 11);
        this.f56965i.setText(com.kwad.sdk.core.response.a.a.t(this.f56958b));
        String w = com.kwad.sdk.core.response.a.a.w(this.f56958b);
        float x = com.kwad.sdk.core.response.a.a.x(this.f56958b);
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
            this.f56966j.setVisibility(0);
        } else {
            this.f56966j.setVisibility(8);
        }
        this.n.a(this.a);
        this.m.setText(com.kwad.sdk.core.response.a.a.s(this.f56958b));
        this.f56963g.setOnClickListener(this);
        this.o.setOnClickListener(this);
        setOnClickListener(this);
    }

    public void b() {
        a(0, this.f56962f);
    }

    public void c() {
        a(this.f56962f, 0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != this.f56963g) {
            com.kwad.sdk.core.download.a.a.a(new a.C2116a(getContext()).a(this.a).a(this.f56959c).a(view == this.o).a(view == this.o ? 1 : 2).a(new a.b() { // from class: com.kwad.sdk.draw.view.playcard.DrawCardApp.2
                @Override // com.kwad.sdk.core.download.a.a.b
                public void a() {
                    if (DrawCardApp.this.f56961e != null) {
                        DrawCardApp.this.f56961e.b();
                    }
                }
            }));
            return;
        }
        c();
        a aVar = this.f56961e;
        if (aVar != null) {
            aVar.a();
        }
    }
}
