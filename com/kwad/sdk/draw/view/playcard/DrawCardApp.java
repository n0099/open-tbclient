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
/* loaded from: classes6.dex */
public class DrawCardApp extends FrameLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public AdTemplate f34607a;

    /* renamed from: b  reason: collision with root package name */
    public AdInfo f34608b;

    /* renamed from: c  reason: collision with root package name */
    public b f34609c;

    /* renamed from: d  reason: collision with root package name */
    public KsAppDownloadListener f34610d;

    /* renamed from: e  reason: collision with root package name */
    public a f34611e;

    /* renamed from: f  reason: collision with root package name */
    public int f34612f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f34613g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f34614h;
    public TextView i;
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

    public DrawCardApp(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private void a(int i, int i2) {
        d();
        ValueAnimator a2 = am.a(this, i, i2);
        this.p = a2;
        a2.setInterpolator(new DecelerateInterpolator(2.0f));
        this.p.setDuration(300L);
        this.p.start();
    }

    private void a(Context context) {
        FrameLayout.inflate(context, R.layout.ksad_draw_card_app, this);
        this.f34613g = (ImageView) findViewById(R.id.ksad_card_app_close);
        this.f34614h = (ImageView) findViewById(R.id.ksad_card_app_icon);
        this.i = (TextView) findViewById(R.id.ksad_card_app_name);
        this.j = (ViewGroup) findViewById(R.id.ksad_card_app_score_container);
        this.k = (AppScoreView) findViewById(R.id.ksad_card_app_score);
        this.l = (TextView) findViewById(R.id.ksad_card_app_download_count);
        this.m = (TextView) findViewById(R.id.ksad_card_app_desc);
        this.n = (KsLogoView) findViewById(R.id.ksad_card_logo);
        DrawDownloadProgressBar drawDownloadProgressBar = (DrawDownloadProgressBar) findViewById(R.id.ksad_card_app_download_btn);
        this.o = drawDownloadProgressBar;
        drawDownloadProgressBar.setTextSize(16);
        this.f34612f = ao.a(context, 156.0f);
    }

    private void d() {
        ValueAnimator valueAnimator = this.p;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.p.cancel();
        }
    }

    private KsAppDownloadListener getAppDownloadListener() {
        if (this.f34610d == null) {
            this.f34610d = new c() { // from class: com.kwad.sdk.draw.view.playcard.DrawCardApp.1
                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFailed() {
                    DrawCardApp.this.o.a(com.kwad.sdk.core.response.b.a.w(DrawCardApp.this.f34608b), DrawCardApp.this.o.getMax());
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFinished() {
                    DrawCardApp.this.o.a(com.kwad.sdk.core.response.b.a.a(DrawCardApp.this.f34607a), DrawCardApp.this.o.getMax());
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onIdle() {
                    DrawCardApp.this.o.a(com.kwad.sdk.core.response.b.a.w(DrawCardApp.this.f34608b), DrawCardApp.this.o.getMax());
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onInstalled() {
                    DrawCardApp.this.o.a(com.kwad.sdk.core.response.b.a.b(), DrawCardApp.this.o.getMax());
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onProgressUpdate(int i) {
                    DrawDownloadProgressBar drawDownloadProgressBar = DrawCardApp.this.o;
                    drawDownloadProgressBar.a(i + "%", i);
                }
            };
        }
        return this.f34610d;
    }

    public void a() {
        d();
        this.f34609c = null;
    }

    public void a(@NonNull AdTemplate adTemplate, a aVar) {
        this.f34607a = adTemplate;
        this.f34608b = com.kwad.sdk.core.response.b.c.j(adTemplate);
        this.f34611e = aVar;
        this.f34609c = new b(this.f34607a, getAppDownloadListener());
        KSImageLoader.loadAppIcon(this.f34614h, com.kwad.sdk.core.response.b.a.o(this.f34608b), adTemplate, 11);
        this.i.setText(com.kwad.sdk.core.response.b.a.q(this.f34608b));
        String t = com.kwad.sdk.core.response.b.a.t(this.f34608b);
        float u = com.kwad.sdk.core.response.b.a.u(this.f34608b);
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
        this.n.a(this.f34607a);
        this.m.setText(com.kwad.sdk.core.response.b.a.n(this.f34608b));
        this.f34613g.setOnClickListener(this);
        this.o.setOnClickListener(this);
        setOnClickListener(this);
    }

    public void b() {
        a(0, this.f34612f);
    }

    public void c() {
        a(this.f34612f, 0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != this.f34613g) {
            com.kwad.sdk.core.download.b.a.a(getContext(), this.f34607a, new a.InterfaceC0379a() { // from class: com.kwad.sdk.draw.view.playcard.DrawCardApp.2
                @Override // com.kwad.sdk.core.download.b.a.InterfaceC0379a
                public void a() {
                    if (DrawCardApp.this.f34611e != null) {
                        DrawCardApp.this.f34611e.b();
                    }
                }
            }, this.f34609c);
            return;
        }
        c();
        a aVar = this.f34611e;
        if (aVar != null) {
            aVar.a();
        }
    }
}
