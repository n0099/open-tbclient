package com.kwad.sdk.contentalliance.home.b;

import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class h extends com.kwad.sdk.contentalliance.home.e {
    @Override // com.kwad.sdk.contentalliance.home.e, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        List<AdTemplate> b2 = com.kwad.sdk.contentalliance.detail.photo.related.a.a().b();
        if (b2 == null) {
            return;
        }
        SceneImpl sceneImpl = ((com.kwad.sdk.contentalliance.home.e) this).f32768a.f32773e;
        ArrayList arrayList = new ArrayList(b2.size());
        for (AdTemplate adTemplate : b2) {
            adTemplate.mAdScene = sceneImpl;
            arrayList.add(adTemplate);
        }
        com.kwad.sdk.contentalliance.home.c.a(arrayList);
        com.kwad.sdk.contentalliance.detail.photo.related.a.a().c();
        com.kwad.sdk.contentalliance.home.f fVar = ((com.kwad.sdk.contentalliance.home.e) this).f32768a;
        fVar.f32771c.setInitStartPosition(fVar.j);
    }
}
