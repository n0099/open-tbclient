package com.kwad.sdk.contentalliance.home.b;

import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d extends com.kwad.sdk.contentalliance.home.e {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.contentalliance.home.e, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        List<AdTemplate> b2 = com.kwad.sdk.feed.a.a.a().b();
        if (b2 == null) {
            return;
        }
        SceneImpl sceneImpl = this.f8734a.e;
        ArrayList arrayList = new ArrayList(b2.size());
        for (AdTemplate adTemplate : b2) {
            adTemplate.mAdScene = sceneImpl;
            arrayList.add(adTemplate);
        }
        com.kwad.sdk.contentalliance.home.c.a(arrayList);
        com.kwad.sdk.feed.a.a.a().c();
        this.f8734a.c.setInitStartPosition(this.f8734a.j);
    }
}
