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
/* loaded from: classes3.dex */
public class DrawCardApp extends FrameLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private AdTemplate f9718a;

    /* renamed from: b  reason: collision with root package name */
    private AdInfo f9719b;
    private b c;
    private KsAppDownloadListener d;
    private a e;
    private int f;
    private ImageView g;
    private ImageView h;
    private TextView i;
    private ViewGroup j;
    private AppScoreView k;
    private TextView l;
    private TextView m;
    private KsLogoView n;
    private DrawDownloadProgressBar o;
    private ValueAnimator p;

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

    public DrawCardApp(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private void a(int i, int i2) {
        d();
        this.p = am.a(this, i, i2);
        this.p.setInterpolator(new DecelerateInterpolator(2.0f));
        this.p.setDuration(300L);
        this.p.start();
    }

    private void a(Context context) {
        inflate(context, R.layout.ksad_draw_card_app, this);
        this.g = (ImageView) findViewById(R.id.ksad_card_app_close);
        this.h = (ImageView) findViewById(R.id.ksad_card_app_icon);
        this.i = (TextView) findViewById(R.id.ksad_card_app_name);
        this.j = (ViewGroup) findViewById(R.id.ksad_card_app_score_container);
        this.k = (AppScoreView) findViewById(R.id.ksad_card_app_score);
        this.l = (TextView) findViewById(R.id.ksad_card_app_download_count);
        this.m = (TextView) findViewById(R.id.ksad_card_app_desc);
        this.n = (KsLogoView) findViewById(R.id.ksad_card_logo);
        this.o = (DrawDownloadProgressBar) findViewById(R.id.ksad_card_app_download_btn);
        this.o.setTextSize(16);
        this.f = ao.a(context, 156.0f);
    }

    private void d() {
        if (this.p != null) {
            this.p.removeAllListeners();
            this.p.cancel();
        }
    }

    private KsAppDownloadListener getAppDownloadListener() {
        if (this.d == null) {
            this.d = new c() { // from class: com.kwad.sdk.draw.view.playcard.DrawCardApp.1
                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFailed() {
                    DrawCardApp.this.o.a(com.kwad.sdk.core.response.b.a.w(DrawCardApp.this.f9719b), DrawCardApp.this.o.getMax());
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFinished() {
                    DrawCardApp.this.o.a(com.kwad.sdk.core.response.b.a.a(DrawCardApp.this.f9718a), DrawCardApp.this.o.getMax());
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onIdle() {
                    DrawCardApp.this.o.a(com.kwad.sdk.core.response.b.a.w(DrawCardApp.this.f9719b), DrawCardApp.this.o.getMax());
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onInstalled() {
                    DrawCardApp.this.o.a(com.kwad.sdk.core.response.b.a.b(), DrawCardApp.this.o.getMax());
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onProgressUpdate(int i) {
                    DrawCardApp.this.o.a(i + "%", i);
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
        this.f9718a = adTemplate;
        this.f9719b = com.kwad.sdk.core.response.b.c.j(this.f9718a);
        this.e = aVar;
        this.c = new b(this.f9718a, getAppDownloadListener());
        KSImageLoader.loadAppIcon(this.h, com.kwad.sdk.core.response.b.a.o(this.f9719b), adTemplate, 11);
        this.i.setText(com.kwad.sdk.core.response.b.a.q(this.f9719b));
        String t = com.kwad.sdk.core.response.b.a.t(this.f9719b);
        float u = com.kwad.sdk.core.response.b.a.u(this.f9719b);
        boolean z = u >= 3.0f;
        if (z) {
            this.k.setScore(u);
            this.k.setVisibility(0);
        }
        boolean z2 = TextUtils.isEmpty(t) ? false : true;
        if (z2) {
            this.l.setText(t);
            this.l.setVisibility(0);
        }
        if (z || z2) {
            this.j.setVisibility(0);
        } else {
            this.j.setVisibility(8);
        }
        this.n.a(this.f9718a);
        this.m.setText(com.kwad.sdk.core.response.b.a.n(this.f9719b));
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
    public void onClick(View view) {
        if (view != this.g) {
            com.kwad.sdk.core.download.b.a.a(getContext(), this.f9718a, new a.InterfaceC1094a() { // from class: com.kwad.sdk.draw.view.playcard.DrawCardApp.2
                @Override // com.kwad.sdk.core.download.b.a.InterfaceC1094a
                public void a() {
                    if (DrawCardApp.this.e != null) {
                        DrawCardApp.this.e.b();
                    }
                }
            }, this.c);
            return;
        }
        c();
        if (this.e != null) {
            this.e.a();
        }
    }
}
