package com.kwad.sdk.contentalliance.detail.a.a;

import android.view.View;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.photo.newui.MarqueeView;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.contentalliance.detail.video.f;
import com.kwad.sdk.core.download.b.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.utils.ag;
import java.lang.ref.WeakReference;
/* loaded from: classes6.dex */
public class c extends com.kwad.sdk.contentalliance.detail.b implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public MarqueeView f32242b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.b f32243c;

    /* renamed from: d  reason: collision with root package name */
    public AdBaseFrameLayout f32244d;

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f32245e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f32246f;

    /* renamed from: g  reason: collision with root package name */
    public a f32247g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.a.a f32248h = new com.kwad.sdk.contentalliance.a.b() { // from class: com.kwad.sdk.contentalliance.detail.a.a.c.1
        @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
        public void k() {
            c.this.f();
        }
    };
    public e i = new f() { // from class: com.kwad.sdk.contentalliance.detail.a.a.c.2
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void b() {
            c.this.e();
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void c() {
            c.this.f();
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void d() {
            c.this.e();
        }
    };

    /* loaded from: classes6.dex */
    public static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<MarqueeView> f32252a;

        public a(MarqueeView marqueeView) {
            this.f32252a = new WeakReference<>(marqueeView);
        }

        @Override // java.lang.Runnable
        public void run() {
            MarqueeView marqueeView = this.f32252a.get();
            if (marqueeView != null) {
                marqueeView.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        a aVar = this.f32247g;
        if (aVar != null) {
            this.f32242b.removeCallbacks(aVar);
            this.f32242b.postDelayed(this.f32247g, 200L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.f32242b.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        com.kwad.sdk.core.report.b.a(this.f32245e, 25, this.f32244d.getTouchCoords());
    }

    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.contentalliance.detail.c cVar = ((com.kwad.sdk.contentalliance.detail.b) this).f32422a;
        AdTemplate adTemplate = cVar.j;
        this.f32245e = adTemplate;
        this.f32246f = cVar.o;
        String y = com.kwad.sdk.core.response.b.c.y(adTemplate);
        if (ag.a(y) && com.kwad.sdk.core.response.b.c.c(this.f32245e)) {
            y = o().getString(R.string.ksad_ad_default_author);
        }
        if (ag.a(y)) {
            this.f32242b.setVisibility(8);
        } else {
            this.f32242b.setContent(y);
            this.f32242b.setVisibility(0);
            this.f32242b.setSelected(true);
            this.f32242b.setOnClickListener(this);
        }
        com.kwad.sdk.contentalliance.detail.video.b bVar = ((com.kwad.sdk.contentalliance.detail.b) this).f32422a.m;
        this.f32243c = bVar;
        if (bVar != null) {
            bVar.a(this.i);
        }
        ((com.kwad.sdk.contentalliance.detail.b) this).f32422a.f32442b.add(this.f32248h);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f32242b.removeCallbacks(this.f32247g);
        com.kwad.sdk.contentalliance.detail.video.b bVar = this.f32243c;
        if (bVar != null) {
            bVar.b(this.i);
        }
        ((com.kwad.sdk.contentalliance.detail.b) this).f32422a.f32442b.remove(this.f32248h);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f32244d = (AdBaseFrameLayout) b(R.id.ksad_root_container);
        MarqueeView marqueeView = (MarqueeView) b(R.id.ksad_bottom_marquee_tip);
        this.f32242b = marqueeView;
        marqueeView.setSelected(true);
        this.f32242b.setTextDistance(10);
        this.f32242b.setTextColor(-65538);
        this.f32242b.setTextSpeed(3.0f);
        this.f32242b.setTextSize(14.0f);
        this.f32242b.setRepetType(2);
        this.f32242b.setStartLocationDistance(0.0f);
        this.f32247g = new a(this.f32242b);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (com.kwad.sdk.core.response.b.c.c(this.f32245e)) {
            com.kwad.sdk.core.download.b.a.a(this.f32242b.getContext(), this.f32245e, new a.InterfaceC0393a() { // from class: com.kwad.sdk.contentalliance.detail.a.a.c.3
                @Override // com.kwad.sdk.core.download.b.a.InterfaceC0393a
                public void a() {
                    c.this.g();
                }
            }, this.f32246f);
        }
    }
}
