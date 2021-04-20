package com.kwad.sdk.contentalliance.detail.a;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
/* loaded from: classes6.dex */
public class e extends com.kwad.sdk.contentalliance.detail.b {
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.b f32329b;

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f32330c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f32331d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.a.a f32332e = new com.kwad.sdk.contentalliance.a.b() { // from class: com.kwad.sdk.contentalliance.detail.a.e.1
        @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
        public void j() {
            super.j();
            if (e.this.f32331d) {
                float q = com.kwad.sdk.core.config.c.q();
                if (q > 0.0f) {
                    e.this.f32329b.a(q);
                }
            }
        }

        @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
        public void k() {
            super.k();
        }
    };

    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.contentalliance.detail.c cVar = ((com.kwad.sdk.contentalliance.detail.b) this).f32422a;
        com.kwad.sdk.contentalliance.detail.video.b bVar = cVar.m;
        this.f32329b = bVar;
        AdTemplate adTemplate = cVar.j;
        this.f32330c = adTemplate;
        this.f32331d = false;
        if (bVar == null || adTemplate == null) {
            return;
        }
        long b2 = com.kwad.sdk.core.response.b.c.c(adTemplate) ? com.kwad.sdk.core.response.b.a.b(com.kwad.sdk.core.response.b.c.j(this.f32330c)) : com.kwad.sdk.core.response.b.d.c(com.kwad.sdk.core.response.b.c.k(this.f32330c)).longValue() / 1000;
        SceneImpl sceneImpl = this.f32330c.mAdScene;
        if (sceneImpl != null && sceneImpl.getPageScene() == 1 && b2 >= com.kwad.sdk.core.config.c.r()) {
            this.f32331d = true;
        }
        if (this.f32331d) {
            ((com.kwad.sdk.contentalliance.detail.b) this).f32422a.f32442b.add(this.f32332e);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        com.kwad.sdk.contentalliance.detail.c cVar = ((com.kwad.sdk.contentalliance.detail.b) this).f32422a;
        if (cVar != null) {
            cVar.f32442b.remove(this.f32332e);
        }
    }
}
