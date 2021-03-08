package com.kwad.sdk.contentalliance.profile.home.c;

import com.kwad.sdk.internal.api.SceneImpl;
/* loaded from: classes3.dex */
public class d extends com.kwad.sdk.contentalliance.profile.home.b.a {
    private boolean b;
    private long c;
    private String d;
    private SceneImpl e;
    private com.kwad.sdk.core.i.a f;
    private com.kwad.sdk.core.i.c g = new com.kwad.sdk.core.i.c() { // from class: com.kwad.sdk.contentalliance.profile.home.c.d.1
        @Override // com.kwad.sdk.core.i.c
        public void b() {
            if (d.this.c > 0) {
                com.kwad.sdk.core.report.e.a(d.this.e, System.currentTimeMillis() - d.this.c);
                d.this.c = 0L;
            }
        }

        @Override // com.kwad.sdk.core.i.c
        public void c_() {
            if (d.this.b) {
                com.kwad.sdk.core.report.e.c(d.this.e);
            } else {
                d.this.b = true;
                com.kwad.sdk.core.report.e.b(d.this.e);
            }
            d.this.c = System.currentTimeMillis();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.contentalliance.profile.home.b.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f = this.f5850a.e;
        if (this.f == null) {
            return;
        }
        this.f.a(this.g);
        this.e = this.f5850a.b;
        this.d = String.valueOf(this.f5850a.f5851a.hashCode());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        if (this.f != null) {
            this.f.b(this.g);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        super.d();
        com.kwad.sdk.core.scene.a.a().c(this.d);
    }
}
