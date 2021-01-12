package com.kwad.sdk.contentalliance.detail.b.a;

import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsContentPage;
import com.kwad.sdk.contentalliance.a.d;
import com.kwad.sdk.contentalliance.home.h;
import com.kwad.sdk.core.i.c;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes4.dex */
public class b extends com.kwad.sdk.contentalliance.detail.b {

    /* renamed from: b  reason: collision with root package name */
    private KsContentPage.SubShowItem f8396b;
    private AdTemplate c;
    private com.kwad.sdk.contentalliance.detail.b.b d;
    private int e;
    @Nullable
    private com.kwad.sdk.core.i.a f;
    private int g;
    private c h = new c() { // from class: com.kwad.sdk.contentalliance.detail.b.a.b.1
        @Override // com.kwad.sdk.core.i.c
        public void b() {
            if (b.this.g == -1) {
                return;
            }
            b.this.g = -1;
            if (b.this.f8396b != null) {
                b.this.f8396b.onPageVisibleChange(false);
            }
        }

        @Override // com.kwad.sdk.core.i.c
        public void c_() {
            if (b.this.g == 1) {
                return;
            }
            b.this.g = 1;
            if (b.this.f8396b != null) {
                b.this.f8396b.onPageVisibleChange(true);
            }
        }
    };
    private com.kwad.sdk.contentalliance.a.c i = new d() { // from class: com.kwad.sdk.contentalliance.detail.b.a.b.2
        @Override // com.kwad.sdk.contentalliance.a.d, com.kwad.sdk.contentalliance.a.c
        public void c() {
            if (b.this.f8396b != null) {
                b.this.f8396b.onPageResume();
            }
        }

        @Override // com.kwad.sdk.contentalliance.a.d, com.kwad.sdk.contentalliance.a.c
        public void d() {
            if (b.this.f8396b != null) {
                b.this.f8396b.onPagePause();
            }
        }

        @Override // com.kwad.sdk.contentalliance.a.d, com.kwad.sdk.contentalliance.a.c
        public void e() {
            if (b.this.f8396b != null) {
                b.this.f8396b.onPageCreate();
            }
        }

        @Override // com.kwad.sdk.contentalliance.a.d, com.kwad.sdk.contentalliance.a.c
        public void f() {
            if (b.this.f8396b != null) {
                b.this.f8396b.onPageDestroy();
            }
        }

        @Override // com.kwad.sdk.contentalliance.a.d, com.kwad.sdk.contentalliance.a.c
        public void g() {
        }
    };
    private com.kwad.sdk.contentalliance.a.a j = new com.kwad.sdk.contentalliance.a.b() { // from class: com.kwad.sdk.contentalliance.detail.b.a.b.3
        @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
        public void j() {
            super.j();
            if (b.this.f == null) {
                return;
            }
            b.this.f.a(b.this.h);
        }

        @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
        public void k() {
            super.k();
            if (b.this.f == null) {
                return;
            }
            b.this.h.b();
            b.this.f.b(b.this.h);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        h hVar = this.f8393a.f8402a;
        if (hVar != null) {
            this.f = hVar.f8742a;
        }
        this.g = 0;
        this.c = this.f8393a.j;
        this.d = this.f8393a.q;
        this.e = this.f8393a.i;
        if (this.d == null || this.c == null) {
            return;
        }
        this.f8396b = this.d.a(this.c);
        if (this.f8396b != null) {
            this.f8393a.c.add(this.i);
            this.f8393a.f8403b.add(this.j);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        if (this.f8393a != null) {
            this.f8393a.f8403b.remove(this.j);
        }
    }
}
