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
    public MarqueeView f32501b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.b f32502c;

    /* renamed from: d  reason: collision with root package name */
    public AdBaseFrameLayout f32503d;

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f32504e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f32505f;

    /* renamed from: g  reason: collision with root package name */
    public a f32506g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.a.a f32507h = new com.kwad.sdk.contentalliance.a.b() { // from class: com.kwad.sdk.contentalliance.detail.a.a.c.1
        @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
        public void k() {
            c.this.f();
        }
    };

    /* renamed from: i  reason: collision with root package name */
    public e f32508i = new f() { // from class: com.kwad.sdk.contentalliance.detail.a.a.c.2
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
        public WeakReference<MarqueeView> f32512a;

        public a(MarqueeView marqueeView) {
            this.f32512a = new WeakReference<>(marqueeView);
        }

        @Override // java.lang.Runnable
        public void run() {
            MarqueeView marqueeView = this.f32512a.get();
            if (marqueeView != null) {
                marqueeView.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        a aVar = this.f32506g;
        if (aVar != null) {
            this.f32501b.removeCallbacks(aVar);
            this.f32501b.postDelayed(this.f32506g, 200L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.f32501b.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        com.kwad.sdk.core.report.b.a(this.f32504e, 25, this.f32503d.getTouchCoords());
    }

    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.contentalliance.detail.c cVar = ((com.kwad.sdk.contentalliance.detail.b) this).f32692a;
        AdTemplate adTemplate = cVar.j;
        this.f32504e = adTemplate;
        this.f32505f = cVar.o;
        String y = com.kwad.sdk.core.response.b.c.y(adTemplate);
        if (ag.a(y) && com.kwad.sdk.core.response.b.c.c(this.f32504e)) {
            y = o().getString(R.string.ksad_ad_default_author);
        }
        if (ag.a(y)) {
            this.f32501b.setVisibility(8);
        } else {
            this.f32501b.setContent(y);
            this.f32501b.setVisibility(0);
            this.f32501b.setSelected(true);
            this.f32501b.setOnClickListener(this);
        }
        com.kwad.sdk.contentalliance.detail.video.b bVar = ((com.kwad.sdk.contentalliance.detail.b) this).f32692a.m;
        this.f32502c = bVar;
        if (bVar != null) {
            bVar.a(this.f32508i);
        }
        ((com.kwad.sdk.contentalliance.detail.b) this).f32692a.f32714b.add(this.f32507h);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f32501b.removeCallbacks(this.f32506g);
        com.kwad.sdk.contentalliance.detail.video.b bVar = this.f32502c;
        if (bVar != null) {
            bVar.b(this.f32508i);
        }
        ((com.kwad.sdk.contentalliance.detail.b) this).f32692a.f32714b.remove(this.f32507h);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f32503d = (AdBaseFrameLayout) b(R.id.ksad_root_container);
        MarqueeView marqueeView = (MarqueeView) b(R.id.ksad_bottom_marquee_tip);
        this.f32501b = marqueeView;
        marqueeView.setSelected(true);
        this.f32501b.setTextDistance(10);
        this.f32501b.setTextColor(-65538);
        this.f32501b.setTextSpeed(3.0f);
        this.f32501b.setTextSize(14.0f);
        this.f32501b.setRepetType(2);
        this.f32501b.setStartLocationDistance(0.0f);
        this.f32506g = new a(this.f32501b);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (com.kwad.sdk.core.response.b.c.c(this.f32504e)) {
            com.kwad.sdk.core.download.b.a.a(this.f32501b.getContext(), this.f32504e, new a.InterfaceC0379a() { // from class: com.kwad.sdk.contentalliance.detail.a.a.c.3
                @Override // com.kwad.sdk.core.download.b.a.InterfaceC0379a
                public void a() {
                    c.this.g();
                }
            }, this.f32505f);
        }
    }
}
