package com.kwad.sdk.contentalliance.tube.detail.b;

import com.kwad.sdk.internal.api.SceneImpl;
/* loaded from: classes3.dex */
public class d extends com.kwad.sdk.contentalliance.tube.detail.a.a {
    private boolean b;
    private long c;
    private String d;
    private SceneImpl e;
    private com.kwad.sdk.core.i.a f;
    private com.kwad.sdk.core.i.c g = new com.kwad.sdk.core.i.c() { // from class: com.kwad.sdk.contentalliance.tube.detail.b.d.1
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
    @Override // com.kwad.sdk.contentalliance.tube.detail.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f = this.f5945a.c;
        if (this.f == null) {
            return;
        }
        this.f.a(this.g);
        this.e = this.f5945a.f;
        this.d = String.valueOf(this.f5945a.f5946a.hashCode());
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
