package com.kwad.sdk.contentalliance.detail.a;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
/* loaded from: classes5.dex */
public class e extends com.kwad.sdk.contentalliance.detail.b {
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private com.kwad.sdk.contentalliance.detail.video.b f8640b;
    private AdTemplate c;
    private boolean d;
    private com.kwad.sdk.contentalliance.a.a e = new com.kwad.sdk.contentalliance.a.b() { // from class: com.kwad.sdk.contentalliance.detail.a.e.1
        @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
        public void j() {
            super.j();
            if (e.this.d) {
                float q = com.kwad.sdk.core.config.c.q();
                if (q > 0.0f) {
                    e.this.f8640b.a(q);
                }
            }
        }

        @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
        public void k() {
            super.k();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f8640b = this.f8693a.m;
        this.c = this.f8693a.j;
        this.d = false;
        if (this.f8640b == null || this.c == null) {
            return;
        }
        long b2 = com.kwad.sdk.core.response.b.c.c(this.c) ? com.kwad.sdk.core.response.b.a.b(com.kwad.sdk.core.response.b.c.j(this.c)) : com.kwad.sdk.core.response.b.d.c(com.kwad.sdk.core.response.b.c.k(this.c)).longValue() / 1000;
        SceneImpl sceneImpl = this.c.mAdScene;
        if (sceneImpl != null && sceneImpl.getPageScene() == 1 && b2 >= com.kwad.sdk.core.config.c.r()) {
            this.d = true;
        }
        if (this.d) {
            this.f8693a.f8703b.add(this.e);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        if (this.f8693a != null) {
            this.f8693a.f8703b.remove(this.e);
        }
    }
}
