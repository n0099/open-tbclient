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
import com.kwad.sdk.core.download.b.a;
import com.kwad.sdk.core.download.b.b;
import com.kwad.sdk.core.download.b.c;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.draw.view.DrawDownloadProgressBar;
import com.kwad.sdk.reward.widget.AppScoreView;
import com.kwad.sdk.utils.am;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.widget.KsLogoView;
/* loaded from: classes7.dex */
public class DrawCardApp extends FrameLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public AdTemplate f35260a;

    /* renamed from: b  reason: collision with root package name */
    public AdInfo f35261b;

    /* renamed from: c  reason: collision with root package name */
    public b f35262c;

    /* renamed from: d  reason: collision with root package name */
    public KsAppDownloadListener f35263d;

    /* renamed from: e  reason: collision with root package name */
    public a f35264e;

    /* renamed from: f  reason: collision with root package name */
    public int f35265f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f35266g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f35267h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f35268i;
    public ViewGroup j;
    public AppScoreView k;
    public TextView l;
    public TextView m;
    public KsLogoView n;
    public DrawDownloadProgressBar o;
    public ValueAnimator p;

    /* loaded from: classes7.dex */
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
        ValueAnimator a2 = am.a(this, i2, i3);
        this.p = a2;
        a2.setInterpolator(new DecelerateInterpolator(2.0f));
        this.p.setDuration(300L);
        this.p.start();
    }

    private void a(Context context) {
        FrameLayout.inflate(context, R.layout.ksad_draw_card_app, this);
        this.f35266g = (ImageView) findViewById(R.id.ksad_card_app_close);
        this.f35267h = (ImageView) findViewById(R.id.ksad_card_app_icon);
        this.f35268i = (TextView) findViewById(R.id.ksad_card_app_name);
        this.j = (ViewGroup) findViewById(R.id.ksad_card_app_score_container);
        this.k = (AppScoreView) findViewById(R.id.ksad_card_app_score);
        this.l = (TextView) findViewById(R.id.ksad_card_app_download_count);
        this.m = (TextView) findViewById(R.id.ksad_card_app_desc);
        this.n = (KsLogoView) findViewById(R.id.ksad_card_logo);
        DrawDownloadProgressBar drawDownloadProgressBar = (DrawDownloadProgressBar) findViewById(R.id.ksad_card_app_download_btn);
        this.o = drawDownloadProgressBar;
        drawDownloadProgressBar.setTextSize(16);
        this.f35265f = ao.a(context, 156.0f);
    }

    private void d() {
        ValueAnimator valueAnimator = this.p;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.p.cancel();
        }
    }

    private KsAppDownloadListener getAppDownloadListener() {
        if (this.f35263d == null) {
            this.f35263d = new c() { // from class: com.kwad.sdk.draw.view.playcard.DrawCardApp.1
                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFailed() {
                    DrawCardApp.this.o.a(com.kwad.sdk.core.response.b.a.w(DrawCardApp.this.f35261b), DrawCardApp.this.o.getMax());
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFinished() {
                    DrawCardApp.this.o.a(com.kwad.sdk.core.response.b.a.a(DrawCardApp.this.f35260a), DrawCardApp.this.o.getMax());
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onIdle() {
                    DrawCardApp.this.o.a(com.kwad.sdk.core.response.b.a.w(DrawCardApp.this.f35261b), DrawCardApp.this.o.getMax());
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onInstalled() {
                    DrawCardApp.this.o.a(com.kwad.sdk.core.response.b.a.b(), DrawCardApp.this.o.getMax());
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onProgressUpdate(int i2) {
                    DrawDownloadProgressBar drawDownloadProgressBar = DrawCardApp.this.o;
                    drawDownloadProgressBar.a(i2 + "%", i2);
                }
            };
        }
        return this.f35263d;
    }

    public void a() {
        d();
        this.f35262c = null;
    }

    public void a(@NonNull AdTemplate adTemplate, a aVar) {
        this.f35260a = adTemplate;
        this.f35261b = com.kwad.sdk.core.response.b.c.j(adTemplate);
        this.f35264e = aVar;
        this.f35262c = new b(this.f35260a, getAppDownloadListener());
        KSImageLoader.loadAppIcon(this.f35267h, com.kwad.sdk.core.response.b.a.o(this.f35261b), adTemplate, 11);
        this.f35268i.setText(com.kwad.sdk.core.response.b.a.q(this.f35261b));
        String t = com.kwad.sdk.core.response.b.a.t(this.f35261b);
        float u = com.kwad.sdk.core.response.b.a.u(this.f35261b);
        boolean z = u >= 3.0f;
        if (z) {
            this.k.setScore(u);
            this.k.setVisibility(0);
        }
        boolean z2 = !TextUtils.isEmpty(t);
        if (z2) {
            this.l.setText(t);
            this.l.setVisibility(0);
        }
        if (z || z2) {
            this.j.setVisibility(0);
        } else {
            this.j.setVisibility(8);
        }
        this.n.a(this.f35260a);
        this.m.setText(com.kwad.sdk.core.response.b.a.n(this.f35261b));
        this.f35266g.setOnClickListener(this);
        this.o.setOnClickListener(this);
        setOnClickListener(this);
    }

    public void b() {
        a(0, this.f35265f);
    }

    public void c() {
        a(this.f35265f, 0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != this.f35266g) {
            com.kwad.sdk.core.download.b.a.a(getContext(), this.f35260a, new a.InterfaceC0379a() { // from class: com.kwad.sdk.draw.view.playcard.DrawCardApp.2
                @Override // com.kwad.sdk.core.download.b.a.InterfaceC0379a
                public void a() {
                    if (DrawCardApp.this.f35264e != null) {
                        DrawCardApp.this.f35264e.b();
                    }
                }
            }, this.f35262c);
            return;
        }
        c();
        a aVar = this.f35264e;
        if (aVar != null) {
            aVar.a();
        }
    }
}
