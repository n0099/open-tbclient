package com.kwad.sdk.contentalliance.tube.a;

import com.kwad.sdk.contentalliance.home.e;
import com.kwad.sdk.contentalliance.home.f;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.entry.model.CacheTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class d extends e {
    @Override // com.kwad.sdk.contentalliance.home.e, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        List<AdTemplate> b2 = com.kwad.sdk.contentalliance.tube.episode.b.a().b();
        if (b2 == null) {
            return;
        }
        SceneImpl sceneImpl = ((e) this).f33153a.f33158e;
        ArrayList arrayList = new ArrayList(b2.size());
        for (AdTemplate adTemplate : b2) {
            if (adTemplate != null) {
                adTemplate.mIsTubeEpisodeList = true;
                arrayList.add(new CacheTemplate(adTemplate, sceneImpl));
            }
        }
        com.kwad.sdk.contentalliance.home.c.a(arrayList);
        com.kwad.sdk.contentalliance.tube.episode.b.a().c();
        f fVar = ((e) this).f33153a;
        fVar.f33156c.setInitStartPosition(fVar.j);
    }
}
