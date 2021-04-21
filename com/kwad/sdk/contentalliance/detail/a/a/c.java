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
    public MarqueeView f32337b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.b f32338c;

    /* renamed from: d  reason: collision with root package name */
    public AdBaseFrameLayout f32339d;

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f32340e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f32341f;

    /* renamed from: g  reason: collision with root package name */
    public a f32342g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.a.a f32343h = new com.kwad.sdk.contentalliance.a.b() { // from class: com.kwad.sdk.contentalliance.detail.a.a.c.1
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
        public WeakReference<MarqueeView> f32347a;

        public a(MarqueeView marqueeView) {
            this.f32347a = new WeakReference<>(marqueeView);
        }

        @Override // java.lang.Runnable
        public void run() {
            MarqueeView marqueeView = this.f32347a.get();
            if (marqueeView != null) {
                marqueeView.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        a aVar = this.f32342g;
        if (aVar != null) {
            this.f32337b.removeCallbacks(aVar);
            this.f32337b.postDelayed(this.f32342g, 200L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.f32337b.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        com.kwad.sdk.core.report.b.a(this.f32340e, 25, this.f32339d.getTouchCoords());
    }

    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.contentalliance.detail.c cVar = ((com.kwad.sdk.contentalliance.detail.b) this).f32517a;
        AdTemplate adTemplate = cVar.j;
        this.f32340e = adTemplate;
        this.f32341f = cVar.o;
        String y = com.kwad.sdk.core.response.b.c.y(adTemplate);
        if (ag.a(y) && com.kwad.sdk.core.response.b.c.c(this.f32340e)) {
            y = o().getString(R.string.ksad_ad_default_author);
        }
        if (ag.a(y)) {
            this.f32337b.setVisibility(8);
        } else {
            this.f32337b.setContent(y);
            this.f32337b.setVisibility(0);
            this.f32337b.setSelected(true);
            this.f32337b.setOnClickListener(this);
        }
        com.kwad.sdk.contentalliance.detail.video.b bVar = ((com.kwad.sdk.contentalliance.detail.b) this).f32517a.m;
        this.f32338c = bVar;
        if (bVar != null) {
            bVar.a(this.i);
        }
        ((com.kwad.sdk.contentalliance.detail.b) this).f32517a.f32537b.add(this.f32343h);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f32337b.removeCallbacks(this.f32342g);
        com.kwad.sdk.contentalliance.detail.video.b bVar = this.f32338c;
        if (bVar != null) {
            bVar.b(this.i);
        }
        ((com.kwad.sdk.contentalliance.detail.b) this).f32517a.f32537b.remove(this.f32343h);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f32339d = (AdBaseFrameLayout) b(R.id.ksad_root_container);
        MarqueeView marqueeView = (MarqueeView) b(R.id.ksad_bottom_marquee_tip);
        this.f32337b = marqueeView;
        marqueeView.setSelected(true);
        this.f32337b.setTextDistance(10);
        this.f32337b.setTextColor(-65538);
        this.f32337b.setTextSpeed(3.0f);
        this.f32337b.setTextSize(14.0f);
        this.f32337b.setRepetType(2);
        this.f32337b.setStartLocationDistance(0.0f);
        this.f32342g = new a(this.f32337b);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (com.kwad.sdk.core.response.b.c.c(this.f32340e)) {
            com.kwad.sdk.core.download.b.a.a(this.f32337b.getContext(), this.f32340e, new a.InterfaceC0396a() { // from class: com.kwad.sdk.contentalliance.detail.a.a.c.3
                @Override // com.kwad.sdk.core.download.b.a.InterfaceC0396a
                public void a() {
                    c.this.g();
                }
            }, this.f32341f);
        }
    }
}
