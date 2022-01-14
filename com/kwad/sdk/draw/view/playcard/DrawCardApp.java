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
/* loaded from: classes3.dex */
public class DrawCardApp extends FrameLayout implements View.OnClickListener {
    public AdTemplate a;

    /* renamed from: b  reason: collision with root package name */
    public AdInfo f56746b;

    /* renamed from: c  reason: collision with root package name */
    public b f56747c;

    /* renamed from: d  reason: collision with root package name */
    public KsAppDownloadListener f56748d;

    /* renamed from: e  reason: collision with root package name */
    public a f56749e;

    /* renamed from: f  reason: collision with root package name */
    public int f56750f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f56751g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f56752h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f56753i;

    /* renamed from: j  reason: collision with root package name */
    public ViewGroup f56754j;
    public AppScoreView k;
    public TextView l;
    public TextView m;
    public KsLogoView n;
    public DrawDownloadProgressBar o;
    public ValueAnimator p;

    /* loaded from: classes3.dex */
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
        this.f56751g = (ImageView) findViewById(R.id.ksad_card_app_close);
        this.f56752h = (ImageView) findViewById(R.id.ksad_card_app_icon);
        this.f56753i = (TextView) findViewById(R.id.ksad_card_app_name);
        this.f56754j = (ViewGroup) findViewById(R.id.ksad_card_app_score_container);
        this.k = (AppScoreView) findViewById(R.id.ksad_card_app_score);
        this.l = (TextView) findViewById(R.id.ksad_card_app_download_count);
        this.m = (TextView) findViewById(R.id.ksad_card_app_desc);
        this.n = (KsLogoView) findViewById(R.id.ksad_card_logo);
        DrawDownloadProgressBar drawDownloadProgressBar = (DrawDownloadProgressBar) findViewById(R.id.ksad_card_app_download_btn);
        this.o = drawDownloadProgressBar;
        drawDownloadProgressBar.setTextSize(16);
        this.f56750f = com.kwad.sdk.a.kwai.a.a(context, 156.0f);
    }

    private void d() {
        ValueAnimator valueAnimator = this.p;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.p.cancel();
        }
    }

    private KsAppDownloadListener getAppDownloadListener() {
        if (this.f56748d == null) {
            this.f56748d = new c() { // from class: com.kwad.sdk.draw.view.playcard.DrawCardApp.1
                @Override // com.kwad.sdk.core.download.a.c
                public void a(int i2) {
                    super.a(i2);
                    DrawCardApp.this.o.a(com.kwad.sdk.core.response.a.a.a(), i2);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFailed() {
                    DrawCardApp.this.o.a(com.kwad.sdk.core.response.a.a.A(DrawCardApp.this.f56746b), DrawCardApp.this.o.getMax());
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFinished() {
                    DrawCardApp.this.o.a(com.kwad.sdk.core.response.a.a.a(DrawCardApp.this.a), DrawCardApp.this.o.getMax());
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onIdle() {
                    DrawCardApp.this.o.a(com.kwad.sdk.core.response.a.a.A(DrawCardApp.this.f56746b), DrawCardApp.this.o.getMax());
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onInstalled() {
                    DrawCardApp.this.o.a(com.kwad.sdk.core.response.a.a.m(DrawCardApp.this.f56746b), DrawCardApp.this.o.getMax());
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onProgressUpdate(int i2) {
                    DrawDownloadProgressBar drawDownloadProgressBar = DrawCardApp.this.o;
                    drawDownloadProgressBar.a(i2 + "%", i2);
                }
            };
        }
        return this.f56748d;
    }

    public void a() {
        d();
        this.f56747c = null;
    }

    public void a(@NonNull AdTemplate adTemplate, a aVar) {
        this.a = adTemplate;
        this.f56746b = d.j(adTemplate);
        this.f56749e = aVar;
        this.f56747c = new b(this.a, getAppDownloadListener());
        KSImageLoader.loadAppIcon(this.f56752h, com.kwad.sdk.core.response.a.a.au(this.f56746b), adTemplate, 11);
        this.f56753i.setText(com.kwad.sdk.core.response.a.a.t(this.f56746b));
        String w = com.kwad.sdk.core.response.a.a.w(this.f56746b);
        float x = com.kwad.sdk.core.response.a.a.x(this.f56746b);
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
            this.f56754j.setVisibility(0);
        } else {
            this.f56754j.setVisibility(8);
        }
        this.n.a(this.a);
        this.m.setText(com.kwad.sdk.core.response.a.a.s(this.f56746b));
        this.f56751g.setOnClickListener(this);
        this.o.setOnClickListener(this);
        setOnClickListener(this);
    }

    public void b() {
        a(0, this.f56750f);
    }

    public void c() {
        a(this.f56750f, 0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != this.f56751g) {
            com.kwad.sdk.core.download.a.a.a(new a.C2100a(getContext()).a(this.a).a(this.f56747c).a(view == this.o).a(view == this.o ? 1 : 2).a(new a.b() { // from class: com.kwad.sdk.draw.view.playcard.DrawCardApp.2
                @Override // com.kwad.sdk.core.download.a.a.b
                public void a() {
                    if (DrawCardApp.this.f56749e != null) {
                        DrawCardApp.this.f56749e.b();
                    }
                }
            }));
            return;
        }
        c();
        a aVar = this.f56749e;
        if (aVar != null) {
            aVar.a();
        }
    }
}
