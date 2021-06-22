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
    public static boolean f32630b = false;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.i.a f32631c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public KsContentPage.PageListener f32632d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public KsContentPage.VideoListener f32633e;

    /* renamed from: f  reason: collision with root package name */
    public KsContentPage.ContentItem f32634f;

    /* renamed from: g  reason: collision with root package name */
    public int f32635g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.b f32636h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f32637i = false;
    public boolean j = false;
    public boolean k = false;
    public com.kwad.sdk.contentalliance.a.a l = new com.kwad.sdk.contentalliance.a.b() { // from class: com.kwad.sdk.contentalliance.detail.a.c.1
        @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
        public void j() {
            c.this.f32637i = false;
            c.this.j = false;
            c.this.k = false;
            c.this.f32631c.a(c.this.m);
            if (c.this.f32636h != null) {
                c.this.f32636h.a(c.this.n);
            }
        }

        @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
        public void k() {
            if (c.this.j) {
                c.this.h();
            }
            c.this.f();
            c.this.f32631c.b(c.this.m);
            if (c.this.f32636h != null) {
                c.this.f32636h.b(c.this.n);
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
        public void a(int i2, int i3) {
            c.this.a(i2, i3);
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void b() {
            c.this.e();
            c.this.g();
            c.this.p();
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void c() {
            if (!c.this.f32631c.e()) {
                c.this.h();
            }
            c.this.q();
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void d() {
            if (c.this.f32631c.e()) {
                c.this.g();
            }
            c.this.r();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, int i3) {
        if (f32630b) {
            com.kwad.sdk.core.d.a.a("DetailOpenListener", "position: " + this.f32635g + " onVideoPlayError");
        }
        KsContentPage.VideoListener videoListener = this.f32633e;
        if (videoListener != null) {
            videoListener.onVideoPlayError(this.f32634f, i2, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.f32637i) {
            return;
        }
        this.f32637i = true;
        if (f32630b) {
            com.kwad.sdk.core.d.a.a("DetailOpenListener", "position: " + this.f32635g + " onPageEnter");
        }
        KsContentPage.PageListener pageListener = this.f32632d;
        if (pageListener != null) {
            pageListener.onPageEnter(this.f32634f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (this.f32637i) {
            if (f32630b) {
                com.kwad.sdk.core.d.a.a("DetailOpenListener", "position: " + this.f32635g + " onPageLeave");
            }
            KsContentPage.PageListener pageListener = this.f32632d;
            if (pageListener != null) {
                pageListener.onPageLeave(this.f32634f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (!this.j) {
            if (f32630b) {
                com.kwad.sdk.core.d.a.a("DetailOpenListener", "position: " + this.f32635g + " onPageResume");
            }
            KsContentPage.PageListener pageListener = this.f32632d;
            if (pageListener != null) {
                pageListener.onPageResume(this.f32634f);
            }
        }
        this.j = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (this.j) {
            if (f32630b) {
                com.kwad.sdk.core.d.a.a("DetailOpenListener", "position: " + this.f32635g + " onPagePause");
            }
            KsContentPage.PageListener pageListener = this.f32632d;
            if (pageListener != null) {
                pageListener.onPagePause(this.f32634f);
            }
        }
        this.j = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        if (f32630b) {
            com.kwad.sdk.core.d.a.a("DetailOpenListener", "position: " + this.f32635g + " onVideoPlayStart");
        }
        KsContentPage.VideoListener videoListener = this.f32633e;
        if (videoListener != null) {
            videoListener.onVideoPlayStart(this.f32634f);
        }
        this.k = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        if (f32630b) {
            com.kwad.sdk.core.d.a.a("DetailOpenListener", "position: " + this.f32635g + " onVideoPlayPaused");
        }
        this.k = true;
        KsContentPage.VideoListener videoListener = this.f32633e;
        if (videoListener != null) {
            videoListener.onVideoPlayPaused(this.f32634f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        if (this.k) {
            if (f32630b) {
                com.kwad.sdk.core.d.a.a("DetailOpenListener", "position: " + this.f32635g + " onVideoPlayResume");
            }
            KsContentPage.VideoListener videoListener = this.f32633e;
            if (videoListener != null) {
                videoListener.onVideoPlayResume(this.f32634f);
            }
        }
        this.k = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        if (f32630b) {
            com.kwad.sdk.core.d.a.a("DetailOpenListener", "position: " + this.f32635g + " onVideoPlayCompleted");
        }
        KsContentPage.VideoListener videoListener = this.f32633e;
        if (videoListener != null) {
            videoListener.onVideoPlayCompleted(this.f32634f);
        }
    }

    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        KsContentPage.ContentItem contentItem;
        int i2;
        super.a();
        com.kwad.sdk.contentalliance.detail.c cVar = ((com.kwad.sdk.contentalliance.detail.b) this).f32790a;
        h hVar = cVar.f32811a;
        if (hVar == null) {
            com.kwad.sdk.core.d.a.c("DetailOpenListener", "homePageHelper is null");
            return;
        }
        this.f32631c = hVar.f33477a;
        this.f32632d = hVar.f33478b;
        this.f32633e = hVar.f33479c;
        AdTemplate adTemplate = cVar.j;
        this.f32635g = cVar.f32819i;
        KsContentPage.ContentItem contentItem2 = new KsContentPage.ContentItem();
        this.f32634f = contentItem2;
        contentItem2.id = t.a(String.valueOf(com.kwad.sdk.core.response.b.c.z(adTemplate)));
        this.f32634f.position = this.f32635g;
        if (com.kwad.sdk.core.response.b.c.b(adTemplate)) {
            contentItem = this.f32634f;
            i2 = 1;
        } else if (com.kwad.sdk.core.response.b.c.c(adTemplate)) {
            contentItem = this.f32634f;
            i2 = 2;
        } else if (!com.kwad.sdk.core.response.b.c.d(adTemplate)) {
            this.f32634f.materialType = 0;
            ((com.kwad.sdk.contentalliance.detail.b) this).f32790a.f32812b.add(0, this.l);
            this.f32636h = ((com.kwad.sdk.contentalliance.detail.b) this).f32790a.m;
        } else {
            contentItem = this.f32634f;
            i2 = 3;
        }
        contentItem.materialType = i2;
        ((com.kwad.sdk.contentalliance.detail.b) this).f32790a.f32812b.add(0, this.l);
        this.f32636h = ((com.kwad.sdk.contentalliance.detail.b) this).f32790a.m;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        com.kwad.sdk.contentalliance.detail.c cVar = ((com.kwad.sdk.contentalliance.detail.b) this).f32790a;
        if (cVar.f32811a == null) {
            return;
        }
        cVar.f32812b.remove(this.l);
    }
}
