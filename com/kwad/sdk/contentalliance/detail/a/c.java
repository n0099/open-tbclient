package com.kwad.sdk.contentalliance.detail.a;

import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsContentPage;
import com.kwad.sdk.contentalliance.detail.video.f;
import com.kwad.sdk.contentalliance.home.h;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.t;
/* loaded from: classes3.dex */
public class c extends com.kwad.sdk.contentalliance.detail.b {

    /* renamed from: b  reason: collision with root package name */
    private static boolean f8310b = false;
    @Nullable
    private com.kwad.sdk.core.i.a c;
    @Nullable
    private KsContentPage.PageListener d;
    @Nullable
    private KsContentPage.VideoListener e;
    private KsContentPage.ContentItem f;
    private int g;
    @Nullable
    private com.kwad.sdk.contentalliance.detail.video.b h;
    private boolean i = false;
    private boolean j = false;
    private boolean k = false;
    private com.kwad.sdk.contentalliance.a.a l = new com.kwad.sdk.contentalliance.a.b() { // from class: com.kwad.sdk.contentalliance.detail.a.c.1
        @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
        public void j() {
            c.this.i = false;
            c.this.j = false;
            c.this.k = false;
            c.this.c.a(c.this.m);
            if (c.this.h != null) {
                c.this.h.a(c.this.n);
            }
        }

        @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
        public void k() {
            if (c.this.j) {
                c.this.h();
            }
            c.this.f();
            c.this.c.b(c.this.m);
            if (c.this.h != null) {
                c.this.h.b(c.this.n);
            }
        }
    };
    private com.kwad.sdk.core.i.c m = new com.kwad.sdk.core.i.c() { // from class: com.kwad.sdk.contentalliance.detail.a.c.2
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
    private com.kwad.sdk.contentalliance.detail.video.e n = new f() { // from class: com.kwad.sdk.contentalliance.detail.a.c.3
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
            if (!c.this.c.e()) {
                c.this.h();
            }
            c.this.q();
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void d() {
            if (c.this.c.e()) {
                c.this.g();
            }
            c.this.r();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2) {
        if (f8310b) {
            com.kwad.sdk.core.d.a.a("DetailOpenListener", "position: " + this.g + " onVideoPlayError");
        }
        if (this.e != null) {
            this.e.onVideoPlayError(this.f, i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.i) {
            return;
        }
        this.i = true;
        if (f8310b) {
            com.kwad.sdk.core.d.a.a("DetailOpenListener", "position: " + this.g + " onPageEnter");
        }
        if (this.d != null) {
            this.d.onPageEnter(this.f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (this.i) {
            if (f8310b) {
                com.kwad.sdk.core.d.a.a("DetailOpenListener", "position: " + this.g + " onPageLeave");
            }
            if (this.d != null) {
                this.d.onPageLeave(this.f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (!this.j) {
            if (f8310b) {
                com.kwad.sdk.core.d.a.a("DetailOpenListener", "position: " + this.g + " onPageResume");
            }
            if (this.d != null) {
                this.d.onPageResume(this.f);
            }
        }
        this.j = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (this.j) {
            if (f8310b) {
                com.kwad.sdk.core.d.a.a("DetailOpenListener", "position: " + this.g + " onPagePause");
            }
            if (this.d != null) {
                this.d.onPagePause(this.f);
            }
        }
        this.j = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        if (f8310b) {
            com.kwad.sdk.core.d.a.a("DetailOpenListener", "position: " + this.g + " onVideoPlayStart");
        }
        if (this.e != null) {
            this.e.onVideoPlayStart(this.f);
        }
        this.k = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        if (f8310b) {
            com.kwad.sdk.core.d.a.a("DetailOpenListener", "position: " + this.g + " onVideoPlayPaused");
        }
        this.k = true;
        if (this.e != null) {
            this.e.onVideoPlayPaused(this.f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        if (this.k) {
            if (f8310b) {
                com.kwad.sdk.core.d.a.a("DetailOpenListener", "position: " + this.g + " onVideoPlayResume");
            }
            if (this.e != null) {
                this.e.onVideoPlayResume(this.f);
            }
        }
        this.k = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        if (f8310b) {
            com.kwad.sdk.core.d.a.a("DetailOpenListener", "position: " + this.g + " onVideoPlayCompleted");
        }
        if (this.e != null) {
            this.e.onVideoPlayCompleted(this.f);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        h hVar = this.f8395a.f8404a;
        if (hVar == null) {
            com.kwad.sdk.core.d.a.c("DetailOpenListener", "homePageHelper is null");
            return;
        }
        this.c = hVar.f8744a;
        this.d = hVar.f8745b;
        this.e = hVar.c;
        AdTemplate adTemplate = this.f8395a.j;
        this.g = this.f8395a.i;
        this.f = new KsContentPage.ContentItem();
        this.f.id = t.a(String.valueOf(com.kwad.sdk.core.response.b.c.z(adTemplate)));
        this.f.position = this.g;
        if (com.kwad.sdk.core.response.b.c.b(adTemplate)) {
            this.f.materialType = 1;
        } else if (com.kwad.sdk.core.response.b.c.c(adTemplate)) {
            this.f.materialType = 2;
        } else if (com.kwad.sdk.core.response.b.c.d(adTemplate)) {
            this.f.materialType = 3;
        } else {
            this.f.materialType = 0;
        }
        this.f8395a.f8405b.add(0, this.l);
        this.h = this.f8395a.m;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        if (this.f8395a.f8404a == null) {
            return;
        }
        this.f8395a.f8405b.remove(this.l);
    }
}
