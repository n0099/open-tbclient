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
/* loaded from: classes5.dex */
public class c extends com.kwad.sdk.contentalliance.detail.b implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    private MarqueeView f8595b;
    private com.kwad.sdk.contentalliance.detail.video.b c;
    private AdBaseFrameLayout d;
    private AdTemplate e;
    @Nullable
    private com.kwad.sdk.core.download.b.b f;
    private a g;
    private com.kwad.sdk.contentalliance.a.a h = new com.kwad.sdk.contentalliance.a.b() { // from class: com.kwad.sdk.contentalliance.detail.a.a.c.1
        @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
        public void k() {
            c.this.f();
        }
    };
    private e i = new f() { // from class: com.kwad.sdk.contentalliance.detail.a.a.c.2
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

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<MarqueeView> f8599a;

        private a(MarqueeView marqueeView) {
            this.f8599a = new WeakReference<>(marqueeView);
        }

        @Override // java.lang.Runnable
        public void run() {
            MarqueeView marqueeView = this.f8599a.get();
            if (marqueeView != null) {
                marqueeView.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.g != null) {
            this.f8595b.removeCallbacks(this.g);
            this.f8595b.postDelayed(this.g, 200L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.f8595b.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        com.kwad.sdk.core.report.b.a(this.e, 25, this.d.getTouchCoords());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.e = this.f8693a.j;
        this.f = this.f8693a.o;
        String y = com.kwad.sdk.core.response.b.c.y(this.e);
        if (ag.a(y) && com.kwad.sdk.core.response.b.c.c(this.e)) {
            y = o().getString(R.string.ksad_ad_default_author);
        }
        if (ag.a(y)) {
            this.f8595b.setVisibility(8);
        } else {
            this.f8595b.setContent(y);
            this.f8595b.setVisibility(0);
            this.f8595b.setSelected(true);
            this.f8595b.setOnClickListener(this);
        }
        this.c = this.f8693a.m;
        if (this.c != null) {
            this.c.a(this.i);
        }
        this.f8693a.f8703b.add(this.h);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f8595b.removeCallbacks(this.g);
        if (this.c != null) {
            this.c.b(this.i);
        }
        this.f8693a.f8703b.remove(this.h);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.d = (AdBaseFrameLayout) b(R.id.ksad_root_container);
        this.f8595b = (MarqueeView) b(R.id.ksad_bottom_marquee_tip);
        this.f8595b.setSelected(true);
        this.f8595b.setTextDistance(10);
        this.f8595b.setTextColor(-65538);
        this.f8595b.setTextSpeed(3.0f);
        this.f8595b.setTextSize(14.0f);
        this.f8595b.setRepetType(2);
        this.f8595b.setStartLocationDistance(0.0f);
        this.g = new a(this.f8595b);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (com.kwad.sdk.core.response.b.c.c(this.e)) {
            com.kwad.sdk.core.download.b.a.a(this.f8595b.getContext(), this.e, new a.InterfaceC1105a() { // from class: com.kwad.sdk.contentalliance.detail.a.a.c.3
                @Override // com.kwad.sdk.core.download.b.a.InterfaceC1105a
                public void a() {
                    c.this.g();
                }
            }, this.f);
        }
    }
}
