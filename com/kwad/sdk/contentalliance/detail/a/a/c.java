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
    public MarqueeView f32599b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.b f32600c;

    /* renamed from: d  reason: collision with root package name */
    public AdBaseFrameLayout f32601d;

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f32602e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f32603f;

    /* renamed from: g  reason: collision with root package name */
    public a f32604g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.a.a f32605h = new com.kwad.sdk.contentalliance.a.b() { // from class: com.kwad.sdk.contentalliance.detail.a.a.c.1
        @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
        public void k() {
            c.this.f();
        }
    };

    /* renamed from: i  reason: collision with root package name */
    public e f32606i = new f() { // from class: com.kwad.sdk.contentalliance.detail.a.a.c.2
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
        public WeakReference<MarqueeView> f32610a;

        public a(MarqueeView marqueeView) {
            this.f32610a = new WeakReference<>(marqueeView);
        }

        @Override // java.lang.Runnable
        public void run() {
            MarqueeView marqueeView = this.f32610a.get();
            if (marqueeView != null) {
                marqueeView.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        a aVar = this.f32604g;
        if (aVar != null) {
            this.f32599b.removeCallbacks(aVar);
            this.f32599b.postDelayed(this.f32604g, 200L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.f32599b.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        com.kwad.sdk.core.report.b.a(this.f32602e, 25, this.f32601d.getTouchCoords());
    }

    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.contentalliance.detail.c cVar = ((com.kwad.sdk.contentalliance.detail.b) this).f32790a;
        AdTemplate adTemplate = cVar.j;
        this.f32602e = adTemplate;
        this.f32603f = cVar.o;
        String y = com.kwad.sdk.core.response.b.c.y(adTemplate);
        if (ag.a(y) && com.kwad.sdk.core.response.b.c.c(this.f32602e)) {
            y = o().getString(R.string.ksad_ad_default_author);
        }
        if (ag.a(y)) {
            this.f32599b.setVisibility(8);
        } else {
            this.f32599b.setContent(y);
            this.f32599b.setVisibility(0);
            this.f32599b.setSelected(true);
            this.f32599b.setOnClickListener(this);
        }
        com.kwad.sdk.contentalliance.detail.video.b bVar = ((com.kwad.sdk.contentalliance.detail.b) this).f32790a.m;
        this.f32600c = bVar;
        if (bVar != null) {
            bVar.a(this.f32606i);
        }
        ((com.kwad.sdk.contentalliance.detail.b) this).f32790a.f32812b.add(this.f32605h);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f32599b.removeCallbacks(this.f32604g);
        com.kwad.sdk.contentalliance.detail.video.b bVar = this.f32600c;
        if (bVar != null) {
            bVar.b(this.f32606i);
        }
        ((com.kwad.sdk.contentalliance.detail.b) this).f32790a.f32812b.remove(this.f32605h);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f32601d = (AdBaseFrameLayout) b(R.id.ksad_root_container);
        MarqueeView marqueeView = (MarqueeView) b(R.id.ksad_bottom_marquee_tip);
        this.f32599b = marqueeView;
        marqueeView.setSelected(true);
        this.f32599b.setTextDistance(10);
        this.f32599b.setTextColor(-65538);
        this.f32599b.setTextSpeed(3.0f);
        this.f32599b.setTextSize(14.0f);
        this.f32599b.setRepetType(2);
        this.f32599b.setStartLocationDistance(0.0f);
        this.f32604g = new a(this.f32599b);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (com.kwad.sdk.core.response.b.c.c(this.f32602e)) {
            com.kwad.sdk.core.download.b.a.a(this.f32599b.getContext(), this.f32602e, new a.InterfaceC0382a() { // from class: com.kwad.sdk.contentalliance.detail.a.a.c.3
                @Override // com.kwad.sdk.core.download.b.a.InterfaceC0382a
                public void a() {
                    c.this.g();
                }
            }, this.f32603f);
        }
    }
}
