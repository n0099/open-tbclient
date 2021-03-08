package com.kwad.sdk.contentalliance.home.b;

import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class d extends com.kwad.sdk.contentalliance.home.e {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.contentalliance.home.e, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        List<AdTemplate> b = com.kwad.sdk.feed.a.a.a().b();
        if (b == null) {
            return;
        }
        SceneImpl sceneImpl = this.f5821a.e;
        ArrayList arrayList = new ArrayList(b.size());
        for (AdTemplate adTemplate : b) {
            adTemplate.mAdScene = sceneImpl;
            arrayList.add(adTemplate);
        }
        com.kwad.sdk.contentalliance.home.c.a(arrayList);
        com.kwad.sdk.feed.a.a.a().c();
        this.f5821a.c.setInitStartPosition(this.f5821a.j);
    }
}
