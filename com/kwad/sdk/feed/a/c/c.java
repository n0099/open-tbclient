package com.kwad.sdk.feed.a.c;

import com.kwad.sdk.core.report.e;
import com.kwad.sdk.internal.api.SceneImpl;
/* loaded from: classes3.dex */
public class c extends com.kwad.sdk.feed.a.b.a {
    private boolean c;
    private long d;
    private String e;
    private SceneImpl f;
    private com.kwad.sdk.core.i.a g;
    private com.kwad.sdk.core.i.c h = new com.kwad.sdk.core.i.c() { // from class: com.kwad.sdk.feed.a.c.c.1
        @Override // com.kwad.sdk.core.i.c
        public void b() {
            if (c.this.d > 0) {
                e.a(c.this.f, System.currentTimeMillis() - c.this.d);
                c.this.d = 0L;
            }
        }

        @Override // com.kwad.sdk.core.i.c
        public void c_() {
            if (c.this.c) {
                e.c(c.this.f);
            } else {
                c.this.c = true;
                e.b(c.this.f);
            }
            c.this.d = System.currentTimeMillis();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.feed.a.b.a, com.kwad.sdk.lib.a.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.g = this.f6505a.b;
        if (this.g == null) {
            return;
        }
        this.g.a(this.h);
        this.f = this.f6505a.f6506a;
        this.e = String.valueOf(this.f6505a.e.hashCode());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        if (this.g != null) {
            this.g.b(this.h);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        super.d();
        com.kwad.sdk.core.scene.a.a().c(this.e);
    }
}
