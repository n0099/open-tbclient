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
import com.kwad.sdk.utils.an;
import com.kwad.sdk.widget.KsLogoView;
/* loaded from: classes6.dex */
public class DrawCardApp extends FrameLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public AdTemplate f33207a;

    /* renamed from: b  reason: collision with root package name */
    public AdInfo f33208b;

    /* renamed from: c  reason: collision with root package name */
    public b f33209c;

    /* renamed from: d  reason: collision with root package name */
    public KsAppDownloadListener f33210d;

    /* renamed from: e  reason: collision with root package name */
    public a f33211e;

    /* renamed from: f  reason: collision with root package name */
    public int f33212f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f33213g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f33214h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f33215i;
    public ViewGroup j;
    public AppScoreView k;
    public TextView l;
    public TextView m;
    public KsLogoView n;
    public DrawDownloadProgressBar o;
    public ValueAnimator p;

    /* loaded from: classes6.dex */
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
        this.f33213g = (ImageView) findViewById(R.id.ksad_card_app_close);
        this.f33214h = (ImageView) findViewById(R.id.ksad_card_app_icon);
        this.f33215i = (TextView) findViewById(R.id.ksad_card_app_name);
        this.j = (ViewGroup) findViewById(R.id.ksad_card_app_score_container);
        this.k = (AppScoreView) findViewById(R.id.ksad_card_app_score);
        this.l = (TextView) findViewById(R.id.ksad_card_app_download_count);
        this.m = (TextView) findViewById(R.id.ksad_card_app_desc);
        this.n = (KsLogoView) findViewById(R.id.ksad_card_logo);
        DrawDownloadProgressBar drawDownloadProgressBar = (DrawDownloadProgressBar) findViewById(R.id.ksad_card_app_download_btn);
        this.o = drawDownloadProgressBar;
        drawDownloadProgressBar.setTextSize(16);
        this.f33212f = an.a(context, 156.0f);
    }

    private void d() {
        ValueAnimator valueAnimator = this.p;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.p.cancel();
        }
    }

    private KsAppDownloadListener getAppDownloadListener() {
        if (this.f33210d == null) {
            this.f33210d = new c() { // from class: com.kwad.sdk.draw.view.playcard.DrawCardApp.1
                @Override // com.kwad.sdk.core.download.b.c
                public void a(int i2) {
                    super.a(i2);
                    DrawCardApp.this.o.a(com.kwad.sdk.core.response.b.a.a(), i2);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFailed() {
                    DrawCardApp.this.o.a(com.kwad.sdk.core.response.b.a.u(DrawCardApp.this.f33208b), DrawCardApp.this.o.getMax());
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFinished() {
                    DrawCardApp.this.o.a(com.kwad.sdk.core.response.b.a.a(DrawCardApp.this.f33207a), DrawCardApp.this.o.getMax());
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onIdle() {
                    DrawCardApp.this.o.a(com.kwad.sdk.core.response.b.a.u(DrawCardApp.this.f33208b), DrawCardApp.this.o.getMax());
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onInstalled() {
                    DrawCardApp.this.o.a(com.kwad.sdk.core.response.b.a.j(DrawCardApp.this.f33208b), DrawCardApp.this.o.getMax());
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onProgressUpdate(int i2) {
                    DrawDownloadProgressBar drawDownloadProgressBar = DrawCardApp.this.o;
                    drawDownloadProgressBar.a(i2 + "%", i2);
                }
            };
        }
        return this.f33210d;
    }

    public void a() {
        d();
        this.f33209c = null;
    }

    public void a(@NonNull AdTemplate adTemplate, a aVar) {
        this.f33207a = adTemplate;
        this.f33208b = com.kwad.sdk.core.response.b.c.g(adTemplate);
        this.f33211e = aVar;
        this.f33209c = new b(this.f33207a, getAppDownloadListener());
        KSImageLoader.loadAppIcon(this.f33214h, com.kwad.sdk.core.response.b.a.n(this.f33208b), adTemplate, 11);
        this.f33215i.setText(com.kwad.sdk.core.response.b.a.o(this.f33208b));
        String r = com.kwad.sdk.core.response.b.a.r(this.f33208b);
        float s = com.kwad.sdk.core.response.b.a.s(this.f33208b);
        boolean z = s >= 3.0f;
        if (z) {
            this.k.setScore(s);
            this.k.setVisibility(0);
        }
        boolean z2 = !TextUtils.isEmpty(r);
        if (z2) {
            this.l.setText(r);
            this.l.setVisibility(0);
        }
        if (z || z2) {
            this.j.setVisibility(0);
        } else {
            this.j.setVisibility(8);
        }
        this.n.a(this.f33207a);
        this.m.setText(com.kwad.sdk.core.response.b.a.m(this.f33208b));
        this.f33213g.setOnClickListener(this);
        this.o.setOnClickListener(this);
        setOnClickListener(this);
    }

    public void b() {
        a(0, this.f33212f);
    }

    public void c() {
        a(this.f33212f, 0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != this.f33213g) {
            com.kwad.sdk.core.download.b.a.a(getContext(), this.f33207a, new a.InterfaceC0363a() { // from class: com.kwad.sdk.draw.view.playcard.DrawCardApp.2
                @Override // com.kwad.sdk.core.download.b.a.InterfaceC0363a
                public void a() {
                    if (DrawCardApp.this.f33211e != null) {
                        DrawCardApp.this.f33211e.b();
                    }
                }
            }, this.f33209c, view == this.o);
            return;
        }
        c();
        a aVar = this.f33211e;
        if (aVar != null) {
            aVar.a();
        }
    }
}
