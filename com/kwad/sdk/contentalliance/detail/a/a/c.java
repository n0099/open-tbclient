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
    public MarqueeView f31952b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.b f31953c;

    /* renamed from: d  reason: collision with root package name */
    public AdBaseFrameLayout f31954d;

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f31955e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f31956f;

    /* renamed from: g  reason: collision with root package name */
    public a f31957g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.a.a f31958h = new com.kwad.sdk.contentalliance.a.b() { // from class: com.kwad.sdk.contentalliance.detail.a.a.c.1
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
        public WeakReference<MarqueeView> f31962a;

        public a(MarqueeView marqueeView) {
            this.f31962a = new WeakReference<>(marqueeView);
        }

        @Override // java.lang.Runnable
        public void run() {
            MarqueeView marqueeView = this.f31962a.get();
            if (marqueeView != null) {
                marqueeView.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        a aVar = this.f31957g;
        if (aVar != null) {
            this.f31952b.removeCallbacks(aVar);
            this.f31952b.postDelayed(this.f31957g, 200L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.f31952b.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        com.kwad.sdk.core.report.b.a(this.f31955e, 25, this.f31954d.getTouchCoords());
    }

    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.contentalliance.detail.c cVar = ((com.kwad.sdk.contentalliance.detail.b) this).f32132a;
        AdTemplate adTemplate = cVar.j;
        this.f31955e = adTemplate;
        this.f31956f = cVar.o;
        String y = com.kwad.sdk.core.response.b.c.y(adTemplate);
        if (ag.a(y) && com.kwad.sdk.core.response.b.c.c(this.f31955e)) {
            y = o().getString(R.string.ksad_ad_default_author);
        }
        if (ag.a(y)) {
            this.f31952b.setVisibility(8);
        } else {
            this.f31952b.setContent(y);
            this.f31952b.setVisibility(0);
            this.f31952b.setSelected(true);
            this.f31952b.setOnClickListener(this);
        }
        com.kwad.sdk.contentalliance.detail.video.b bVar = ((com.kwad.sdk.contentalliance.detail.b) this).f32132a.m;
        this.f31953c = bVar;
        if (bVar != null) {
            bVar.a(this.i);
        }
        ((com.kwad.sdk.contentalliance.detail.b) this).f32132a.f32152b.add(this.f31958h);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f31952b.removeCallbacks(this.f31957g);
        com.kwad.sdk.contentalliance.detail.video.b bVar = this.f31953c;
        if (bVar != null) {
            bVar.b(this.i);
        }
        ((com.kwad.sdk.contentalliance.detail.b) this).f32132a.f32152b.remove(this.f31958h);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f31954d = (AdBaseFrameLayout) b(R.id.ksad_root_container);
        MarqueeView marqueeView = (MarqueeView) b(R.id.ksad_bottom_marquee_tip);
        this.f31952b = marqueeView;
        marqueeView.setSelected(true);
        this.f31952b.setTextDistance(10);
        this.f31952b.setTextColor(-65538);
        this.f31952b.setTextSpeed(3.0f);
        this.f31952b.setTextSize(14.0f);
        this.f31952b.setRepetType(2);
        this.f31952b.setStartLocationDistance(0.0f);
        this.f31957g = new a(this.f31952b);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (com.kwad.sdk.core.response.b.c.c(this.f31955e)) {
            com.kwad.sdk.core.download.b.a.a(this.f31952b.getContext(), this.f31955e, new a.InterfaceC0378a() { // from class: com.kwad.sdk.contentalliance.detail.a.a.c.3
                @Override // com.kwad.sdk.core.download.b.a.InterfaceC0378a
                public void a() {
                    c.this.g();
                }
            }, this.f31956f);
        }
    }
}
