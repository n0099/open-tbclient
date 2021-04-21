package com.kwad.sdk.contentalliance.detail.a;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
/* loaded from: classes6.dex */
public class e extends com.kwad.sdk.contentalliance.detail.b {
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.b f32424b;

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f32425c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f32426d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.a.a f32427e = new com.kwad.sdk.contentalliance.a.b() { // from class: com.kwad.sdk.contentalliance.detail.a.e.1
        @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
        public void j() {
            super.j();
            if (e.this.f32426d) {
                float q = com.kwad.sdk.core.config.c.q();
                if (q > 0.0f) {
                    e.this.f32424b.a(q);
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
        com.kwad.sdk.contentalliance.detail.c cVar = ((com.kwad.sdk.contentalliance.detail.b) this).f32517a;
        com.kwad.sdk.contentalliance.detail.video.b bVar = cVar.m;
        this.f32424b = bVar;
        AdTemplate adTemplate = cVar.j;
        this.f32425c = adTemplate;
        this.f32426d = false;
        if (bVar == null || adTemplate == null) {
            return;
        }
        long b2 = com.kwad.sdk.core.response.b.c.c(adTemplate) ? com.kwad.sdk.core.response.b.a.b(com.kwad.sdk.core.response.b.c.j(this.f32425c)) : com.kwad.sdk.core.response.b.d.c(com.kwad.sdk.core.response.b.c.k(this.f32425c)).longValue() / 1000;
        SceneImpl sceneImpl = this.f32425c.mAdScene;
        if (sceneImpl != null && sceneImpl.getPageScene() == 1 && b2 >= com.kwad.sdk.core.config.c.r()) {
            this.f32426d = true;
        }
        if (this.f32426d) {
            ((com.kwad.sdk.contentalliance.detail.b) this).f32517a.f32537b.add(this.f32427e);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        com.kwad.sdk.contentalliance.detail.c cVar = ((com.kwad.sdk.contentalliance.detail.b) this).f32517a;
        if (cVar != null) {
            cVar.f32537b.remove(this.f32427e);
        }
    }
}
