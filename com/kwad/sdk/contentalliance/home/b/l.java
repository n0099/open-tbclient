package com.kwad.sdk.contentalliance.home.b;

import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.entry.model.CacheTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class l extends com.kwad.sdk.contentalliance.home.e {
    @Override // com.kwad.sdk.contentalliance.home.e, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        List<AdTemplate> b2 = com.kwad.sdk.contentalliance.profile.tabvideo.detail.a.a().b();
        if (b2 == null) {
            return;
        }
        SceneImpl sceneImpl = ((com.kwad.sdk.contentalliance.home.e) this).f33357a.f33362e;
        ArrayList arrayList = new ArrayList(b2.size());
        for (AdTemplate adTemplate : b2) {
            arrayList.add(new CacheTemplate(adTemplate, sceneImpl));
        }
        com.kwad.sdk.contentalliance.home.c.a(arrayList);
        com.kwad.sdk.contentalliance.profile.tabvideo.detail.a.a().c();
        com.kwad.sdk.contentalliance.home.f fVar = ((com.kwad.sdk.contentalliance.home.e) this).f33357a;
        fVar.f33360c.setInitStartPosition(fVar.j);
    }
}
