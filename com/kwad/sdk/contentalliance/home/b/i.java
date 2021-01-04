package com.kwad.sdk.contentalliance.home.b;

import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.internal.api.SceneImpl;
/* loaded from: classes5.dex */
public class i extends com.kwad.sdk.contentalliance.home.e {

    /* renamed from: b  reason: collision with root package name */
    com.kwad.sdk.core.i.a f8997b;
    private com.kwad.sdk.core.i.c c;
    private boolean d;
    private SceneImpl e;
    private KsFragment f;
    private long g;
    private String h;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.contentalliance.home.e, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.contentalliance.home.h hVar = this.f9033a.f;
        if (hVar == null) {
            return;
        }
        this.f8997b = hVar.f9041a;
        if (this.f8997b != null) {
            this.e = this.f9033a.e;
            this.f = this.f9033a.f9034a;
            this.h = String.valueOf(this.f.hashCode());
            if (this.c == null) {
                this.c = new com.kwad.sdk.core.i.c() { // from class: com.kwad.sdk.contentalliance.home.b.i.1
                    @Override // com.kwad.sdk.core.i.c
                    public void b() {
                        if (i.this.e == null || i.this.f == null || i.this.g <= 0) {
                            return;
                        }
                        com.kwad.sdk.core.report.e.a(i.this.e, System.currentTimeMillis() - i.this.g);
                        i.this.g = 0L;
                    }

                    @Override // com.kwad.sdk.core.i.c
                    public void c_() {
                        if (i.this.d) {
                            com.kwad.sdk.core.report.e.c(i.this.e);
                        } else {
                            i.this.d = true;
                            com.kwad.sdk.core.report.e.b(i.this.e);
                        }
                        i.this.g = System.currentTimeMillis();
                    }
                };
                this.f8997b.a(this.c);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        if (this.c == null || this.f8997b == null) {
            return;
        }
        this.f8997b.b(this.c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        super.d();
        com.kwad.sdk.core.scene.a.a().c(this.h);
    }
}
