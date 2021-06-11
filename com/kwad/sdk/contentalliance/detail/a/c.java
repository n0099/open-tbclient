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
    public static boolean f32532b = false;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.i.a f32533c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public KsContentPage.PageListener f32534d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public KsContentPage.VideoListener f32535e;

    /* renamed from: f  reason: collision with root package name */
    public KsContentPage.ContentItem f32536f;

    /* renamed from: g  reason: collision with root package name */
    public int f32537g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.b f32538h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f32539i = false;
    public boolean j = false;
    public boolean k = false;
    public com.kwad.sdk.contentalliance.a.a l = new com.kwad.sdk.contentalliance.a.b() { // from class: com.kwad.sdk.contentalliance.detail.a.c.1
        @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
        public void j() {
            c.this.f32539i = false;
            c.this.j = false;
            c.this.k = false;
            c.this.f32533c.a(c.this.m);
            if (c.this.f32538h != null) {
                c.this.f32538h.a(c.this.n);
            }
        }

        @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
        public void k() {
            if (c.this.j) {
                c.this.h();
            }
            c.this.f();
            c.this.f32533c.b(c.this.m);
            if (c.this.f32538h != null) {
                c.this.f32538h.b(c.this.n);
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
            if (!c.this.f32533c.e()) {
                c.this.h();
            }
            c.this.q();
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void d() {
            if (c.this.f32533c.e()) {
                c.this.g();
            }
            c.this.r();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, int i3) {
        if (f32532b) {
            com.kwad.sdk.core.d.a.a("DetailOpenListener", "position: " + this.f32537g + " onVideoPlayError");
        }
        KsContentPage.VideoListener videoListener = this.f32535e;
        if (videoListener != null) {
            videoListener.onVideoPlayError(this.f32536f, i2, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.f32539i) {
            return;
        }
        this.f32539i = true;
        if (f32532b) {
            com.kwad.sdk.core.d.a.a("DetailOpenListener", "position: " + this.f32537g + " onPageEnter");
        }
        KsContentPage.PageListener pageListener = this.f32534d;
        if (pageListener != null) {
            pageListener.onPageEnter(this.f32536f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (this.f32539i) {
            if (f32532b) {
                com.kwad.sdk.core.d.a.a("DetailOpenListener", "position: " + this.f32537g + " onPageLeave");
            }
            KsContentPage.PageListener pageListener = this.f32534d;
            if (pageListener != null) {
                pageListener.onPageLeave(this.f32536f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (!this.j) {
            if (f32532b) {
                com.kwad.sdk.core.d.a.a("DetailOpenListener", "position: " + this.f32537g + " onPageResume");
            }
            KsContentPage.PageListener pageListener = this.f32534d;
            if (pageListener != null) {
                pageListener.onPageResume(this.f32536f);
            }
        }
        this.j = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (this.j) {
            if (f32532b) {
                com.kwad.sdk.core.d.a.a("DetailOpenListener", "position: " + this.f32537g + " onPagePause");
            }
            KsContentPage.PageListener pageListener = this.f32534d;
            if (pageListener != null) {
                pageListener.onPagePause(this.f32536f);
            }
        }
        this.j = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        if (f32532b) {
            com.kwad.sdk.core.d.a.a("DetailOpenListener", "position: " + this.f32537g + " onVideoPlayStart");
        }
        KsContentPage.VideoListener videoListener = this.f32535e;
        if (videoListener != null) {
            videoListener.onVideoPlayStart(this.f32536f);
        }
        this.k = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        if (f32532b) {
            com.kwad.sdk.core.d.a.a("DetailOpenListener", "position: " + this.f32537g + " onVideoPlayPaused");
        }
        this.k = true;
        KsContentPage.VideoListener videoListener = this.f32535e;
        if (videoListener != null) {
            videoListener.onVideoPlayPaused(this.f32536f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        if (this.k) {
            if (f32532b) {
                com.kwad.sdk.core.d.a.a("DetailOpenListener", "position: " + this.f32537g + " onVideoPlayResume");
            }
            KsContentPage.VideoListener videoListener = this.f32535e;
            if (videoListener != null) {
                videoListener.onVideoPlayResume(this.f32536f);
            }
        }
        this.k = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        if (f32532b) {
            com.kwad.sdk.core.d.a.a("DetailOpenListener", "position: " + this.f32537g + " onVideoPlayCompleted");
        }
        KsContentPage.VideoListener videoListener = this.f32535e;
        if (videoListener != null) {
            videoListener.onVideoPlayCompleted(this.f32536f);
        }
    }

    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        KsContentPage.ContentItem contentItem;
        int i2;
        super.a();
        com.kwad.sdk.contentalliance.detail.c cVar = ((com.kwad.sdk.contentalliance.detail.b) this).f32692a;
        h hVar = cVar.f32713a;
        if (hVar == null) {
            com.kwad.sdk.core.d.a.c("DetailOpenListener", "homePageHelper is null");
            return;
        }
        this.f32533c = hVar.f33379a;
        this.f32534d = hVar.f33380b;
        this.f32535e = hVar.f33381c;
        AdTemplate adTemplate = cVar.j;
        this.f32537g = cVar.f32721i;
        KsContentPage.ContentItem contentItem2 = new KsContentPage.ContentItem();
        this.f32536f = contentItem2;
        contentItem2.id = t.a(String.valueOf(com.kwad.sdk.core.response.b.c.z(adTemplate)));
        this.f32536f.position = this.f32537g;
        if (com.kwad.sdk.core.response.b.c.b(adTemplate)) {
            contentItem = this.f32536f;
            i2 = 1;
        } else if (com.kwad.sdk.core.response.b.c.c(adTemplate)) {
            contentItem = this.f32536f;
            i2 = 2;
        } else if (!com.kwad.sdk.core.response.b.c.d(adTemplate)) {
            this.f32536f.materialType = 0;
            ((com.kwad.sdk.contentalliance.detail.b) this).f32692a.f32714b.add(0, this.l);
            this.f32538h = ((com.kwad.sdk.contentalliance.detail.b) this).f32692a.m;
        } else {
            contentItem = this.f32536f;
            i2 = 3;
        }
        contentItem.materialType = i2;
        ((com.kwad.sdk.contentalliance.detail.b) this).f32692a.f32714b.add(0, this.l);
        this.f32538h = ((com.kwad.sdk.contentalliance.detail.b) this).f32692a.m;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        com.kwad.sdk.contentalliance.detail.c cVar = ((com.kwad.sdk.contentalliance.detail.b) this).f32692a;
        if (cVar.f32713a == null) {
            return;
        }
        cVar.f32714b.remove(this.l);
    }
}
