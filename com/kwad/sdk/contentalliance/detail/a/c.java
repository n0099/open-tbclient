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
    public static boolean f32366b = false;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.i.a f32367c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public KsContentPage.PageListener f32368d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public KsContentPage.VideoListener f32369e;

    /* renamed from: f  reason: collision with root package name */
    public KsContentPage.ContentItem f32370f;

    /* renamed from: g  reason: collision with root package name */
    public int f32371g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.b f32372h;
    public boolean i = false;
    public boolean j = false;
    public boolean k = false;
    public com.kwad.sdk.contentalliance.a.a l = new com.kwad.sdk.contentalliance.a.b() { // from class: com.kwad.sdk.contentalliance.detail.a.c.1
        @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
        public void j() {
            c.this.i = false;
            c.this.j = false;
            c.this.k = false;
            c.this.f32367c.a(c.this.m);
            if (c.this.f32372h != null) {
                c.this.f32372h.a(c.this.n);
            }
        }

        @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
        public void k() {
            if (c.this.j) {
                c.this.h();
            }
            c.this.f();
            c.this.f32367c.b(c.this.m);
            if (c.this.f32372h != null) {
                c.this.f32372h.b(c.this.n);
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
            if (!c.this.f32367c.e()) {
                c.this.h();
            }
            c.this.q();
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void d() {
            if (c.this.f32367c.e()) {
                c.this.g();
            }
            c.this.r();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2) {
        if (f32366b) {
            com.kwad.sdk.core.d.a.a("DetailOpenListener", "position: " + this.f32371g + " onVideoPlayError");
        }
        KsContentPage.VideoListener videoListener = this.f32369e;
        if (videoListener != null) {
            videoListener.onVideoPlayError(this.f32370f, i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.i) {
            return;
        }
        this.i = true;
        if (f32366b) {
            com.kwad.sdk.core.d.a.a("DetailOpenListener", "position: " + this.f32371g + " onPageEnter");
        }
        KsContentPage.PageListener pageListener = this.f32368d;
        if (pageListener != null) {
            pageListener.onPageEnter(this.f32370f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (this.i) {
            if (f32366b) {
                com.kwad.sdk.core.d.a.a("DetailOpenListener", "position: " + this.f32371g + " onPageLeave");
            }
            KsContentPage.PageListener pageListener = this.f32368d;
            if (pageListener != null) {
                pageListener.onPageLeave(this.f32370f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (!this.j) {
            if (f32366b) {
                com.kwad.sdk.core.d.a.a("DetailOpenListener", "position: " + this.f32371g + " onPageResume");
            }
            KsContentPage.PageListener pageListener = this.f32368d;
            if (pageListener != null) {
                pageListener.onPageResume(this.f32370f);
            }
        }
        this.j = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (this.j) {
            if (f32366b) {
                com.kwad.sdk.core.d.a.a("DetailOpenListener", "position: " + this.f32371g + " onPagePause");
            }
            KsContentPage.PageListener pageListener = this.f32368d;
            if (pageListener != null) {
                pageListener.onPagePause(this.f32370f);
            }
        }
        this.j = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        if (f32366b) {
            com.kwad.sdk.core.d.a.a("DetailOpenListener", "position: " + this.f32371g + " onVideoPlayStart");
        }
        KsContentPage.VideoListener videoListener = this.f32369e;
        if (videoListener != null) {
            videoListener.onVideoPlayStart(this.f32370f);
        }
        this.k = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        if (f32366b) {
            com.kwad.sdk.core.d.a.a("DetailOpenListener", "position: " + this.f32371g + " onVideoPlayPaused");
        }
        this.k = true;
        KsContentPage.VideoListener videoListener = this.f32369e;
        if (videoListener != null) {
            videoListener.onVideoPlayPaused(this.f32370f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        if (this.k) {
            if (f32366b) {
                com.kwad.sdk.core.d.a.a("DetailOpenListener", "position: " + this.f32371g + " onVideoPlayResume");
            }
            KsContentPage.VideoListener videoListener = this.f32369e;
            if (videoListener != null) {
                videoListener.onVideoPlayResume(this.f32370f);
            }
        }
        this.k = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        if (f32366b) {
            com.kwad.sdk.core.d.a.a("DetailOpenListener", "position: " + this.f32371g + " onVideoPlayCompleted");
        }
        KsContentPage.VideoListener videoListener = this.f32369e;
        if (videoListener != null) {
            videoListener.onVideoPlayCompleted(this.f32370f);
        }
    }

    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        KsContentPage.ContentItem contentItem;
        int i;
        super.a();
        com.kwad.sdk.contentalliance.detail.c cVar = ((com.kwad.sdk.contentalliance.detail.b) this).f32517a;
        h hVar = cVar.f32536a;
        if (hVar == null) {
            com.kwad.sdk.core.d.a.c("DetailOpenListener", "homePageHelper is null");
            return;
        }
        this.f32367c = hVar.f33173a;
        this.f32368d = hVar.f33174b;
        this.f32369e = hVar.f33175c;
        AdTemplate adTemplate = cVar.j;
        this.f32371g = cVar.i;
        KsContentPage.ContentItem contentItem2 = new KsContentPage.ContentItem();
        this.f32370f = contentItem2;
        contentItem2.id = t.a(String.valueOf(com.kwad.sdk.core.response.b.c.z(adTemplate)));
        this.f32370f.position = this.f32371g;
        if (com.kwad.sdk.core.response.b.c.b(adTemplate)) {
            contentItem = this.f32370f;
            i = 1;
        } else if (com.kwad.sdk.core.response.b.c.c(adTemplate)) {
            contentItem = this.f32370f;
            i = 2;
        } else if (!com.kwad.sdk.core.response.b.c.d(adTemplate)) {
            this.f32370f.materialType = 0;
            ((com.kwad.sdk.contentalliance.detail.b) this).f32517a.f32537b.add(0, this.l);
            this.f32372h = ((com.kwad.sdk.contentalliance.detail.b) this).f32517a.m;
        } else {
            contentItem = this.f32370f;
            i = 3;
        }
        contentItem.materialType = i;
        ((com.kwad.sdk.contentalliance.detail.b) this).f32517a.f32537b.add(0, this.l);
        this.f32372h = ((com.kwad.sdk.contentalliance.detail.b) this).f32517a.m;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        com.kwad.sdk.contentalliance.detail.c cVar = ((com.kwad.sdk.contentalliance.detail.b) this).f32517a;
        if (cVar.f32536a == null) {
            return;
        }
        cVar.f32537b.remove(this.l);
    }
}
