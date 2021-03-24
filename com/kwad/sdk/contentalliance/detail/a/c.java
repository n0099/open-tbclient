package com.kwad.sdk.contentalliance.detail.a;

import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsContentPage;
import com.kwad.sdk.contentalliance.detail.video.f;
import com.kwad.sdk.contentalliance.home.h;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.t;
/* loaded from: classes6.dex */
public class c extends com.kwad.sdk.contentalliance.detail.b {

    /* renamed from: b  reason: collision with root package name */
    public static boolean f31981b = false;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.i.a f31982c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public KsContentPage.PageListener f31983d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public KsContentPage.VideoListener f31984e;

    /* renamed from: f  reason: collision with root package name */
    public KsContentPage.ContentItem f31985f;

    /* renamed from: g  reason: collision with root package name */
    public int f31986g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.b f31987h;
    public boolean i = false;
    public boolean j = false;
    public boolean k = false;
    public com.kwad.sdk.contentalliance.a.a l = new com.kwad.sdk.contentalliance.a.b() { // from class: com.kwad.sdk.contentalliance.detail.a.c.1
        @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
        public void j() {
            c.this.i = false;
            c.this.j = false;
            c.this.k = false;
            c.this.f31982c.a(c.this.m);
            if (c.this.f31987h != null) {
                c.this.f31987h.a(c.this.n);
            }
        }

        @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
        public void k() {
            if (c.this.j) {
                c.this.h();
            }
            c.this.f();
            c.this.f31982c.b(c.this.m);
            if (c.this.f31987h != null) {
                c.this.f31987h.b(c.this.n);
            }
        }
    };
    public com.kwad.sdk.core.i.c m = new com.kwad.sdk.core.i.c() { // from class: com.kwad.sdk.contentalliance.detail.a.c.2
        @Override // com.kwad.sdk.core.i.c
        public void b() {
            c.this.h();
        }

        @Override // com.kwad.sdk.core.i.c
        public void c_() {
            c.this.e();
            c.this.g();
        }
    };
    public com.kwad.sdk.contentalliance.detail.video.e n = new f() { // from class: com.kwad.sdk.contentalliance.detail.a.c.3
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a() {
            c.this.s();
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a(int i, int i2) {
            c.this.a(i, i2);
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void b() {
            c.this.e();
            c.this.g();
            c.this.p();
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void c() {
            if (!c.this.f31982c.e()) {
                c.this.h();
            }
            c.this.q();
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void d() {
            if (c.this.f31982c.e()) {
                c.this.g();
            }
            c.this.r();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2) {
        if (f31981b) {
            com.kwad.sdk.core.d.a.a("DetailOpenListener", "position: " + this.f31986g + " onVideoPlayError");
        }
        KsContentPage.VideoListener videoListener = this.f31984e;
        if (videoListener != null) {
            videoListener.onVideoPlayError(this.f31985f, i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.i) {
            return;
        }
        this.i = true;
        if (f31981b) {
            com.kwad.sdk.core.d.a.a("DetailOpenListener", "position: " + this.f31986g + " onPageEnter");
        }
        KsContentPage.PageListener pageListener = this.f31983d;
        if (pageListener != null) {
            pageListener.onPageEnter(this.f31985f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (this.i) {
            if (f31981b) {
                com.kwad.sdk.core.d.a.a("DetailOpenListener", "position: " + this.f31986g + " onPageLeave");
            }
            KsContentPage.PageListener pageListener = this.f31983d;
            if (pageListener != null) {
                pageListener.onPageLeave(this.f31985f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (!this.j) {
            if (f31981b) {
                com.kwad.sdk.core.d.a.a("DetailOpenListener", "position: " + this.f31986g + " onPageResume");
            }
            KsContentPage.PageListener pageListener = this.f31983d;
            if (pageListener != null) {
                pageListener.onPageResume(this.f31985f);
            }
        }
        this.j = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (this.j) {
            if (f31981b) {
                com.kwad.sdk.core.d.a.a("DetailOpenListener", "position: " + this.f31986g + " onPagePause");
            }
            KsContentPage.PageListener pageListener = this.f31983d;
            if (pageListener != null) {
                pageListener.onPagePause(this.f31985f);
            }
        }
        this.j = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        if (f31981b) {
            com.kwad.sdk.core.d.a.a("DetailOpenListener", "position: " + this.f31986g + " onVideoPlayStart");
        }
        KsContentPage.VideoListener videoListener = this.f31984e;
        if (videoListener != null) {
            videoListener.onVideoPlayStart(this.f31985f);
        }
        this.k = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        if (f31981b) {
            com.kwad.sdk.core.d.a.a("DetailOpenListener", "position: " + this.f31986g + " onVideoPlayPaused");
        }
        this.k = true;
        KsContentPage.VideoListener videoListener = this.f31984e;
        if (videoListener != null) {
            videoListener.onVideoPlayPaused(this.f31985f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        if (this.k) {
            if (f31981b) {
                com.kwad.sdk.core.d.a.a("DetailOpenListener", "position: " + this.f31986g + " onVideoPlayResume");
            }
            KsContentPage.VideoListener videoListener = this.f31984e;
            if (videoListener != null) {
                videoListener.onVideoPlayResume(this.f31985f);
            }
        }
        this.k = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        if (f31981b) {
            com.kwad.sdk.core.d.a.a("DetailOpenListener", "position: " + this.f31986g + " onVideoPlayCompleted");
        }
        KsContentPage.VideoListener videoListener = this.f31984e;
        if (videoListener != null) {
            videoListener.onVideoPlayCompleted(this.f31985f);
        }
    }

    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        KsContentPage.ContentItem contentItem;
        int i;
        super.a();
        com.kwad.sdk.contentalliance.detail.c cVar = ((com.kwad.sdk.contentalliance.detail.b) this).f32132a;
        h hVar = cVar.f32151a;
        if (hVar == null) {
            com.kwad.sdk.core.d.a.c("DetailOpenListener", "homePageHelper is null");
            return;
        }
        this.f31982c = hVar.f32788a;
        this.f31983d = hVar.f32789b;
        this.f31984e = hVar.f32790c;
        AdTemplate adTemplate = cVar.j;
        this.f31986g = cVar.i;
        KsContentPage.ContentItem contentItem2 = new KsContentPage.ContentItem();
        this.f31985f = contentItem2;
        contentItem2.id = t.a(String.valueOf(com.kwad.sdk.core.response.b.c.z(adTemplate)));
        this.f31985f.position = this.f31986g;
        if (com.kwad.sdk.core.response.b.c.b(adTemplate)) {
            contentItem = this.f31985f;
            i = 1;
        } else if (com.kwad.sdk.core.response.b.c.c(adTemplate)) {
            contentItem = this.f31985f;
            i = 2;
        } else if (!com.kwad.sdk.core.response.b.c.d(adTemplate)) {
            this.f31985f.materialType = 0;
            ((com.kwad.sdk.contentalliance.detail.b) this).f32132a.f32152b.add(0, this.l);
            this.f31987h = ((com.kwad.sdk.contentalliance.detail.b) this).f32132a.m;
        } else {
            contentItem = this.f31985f;
            i = 3;
        }
        contentItem.materialType = i;
        ((com.kwad.sdk.contentalliance.detail.b) this).f32132a.f32152b.add(0, this.l);
        this.f31987h = ((com.kwad.sdk.contentalliance.detail.b) this).f32132a.m;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        com.kwad.sdk.contentalliance.detail.c cVar = ((com.kwad.sdk.contentalliance.detail.b) this).f32132a;
        if (cVar.f32151a == null) {
            return;
        }
        cVar.f32152b.remove(this.l);
    }
}
