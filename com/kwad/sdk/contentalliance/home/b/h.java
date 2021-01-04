package com.kwad.sdk.contentalliance.home.b;

import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class h extends com.kwad.sdk.contentalliance.home.e {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.contentalliance.home.e, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        List<AdTemplate> b2 = com.kwad.sdk.contentalliance.detail.photo.related.a.a().b();
        if (b2 == null) {
            return;
        }
        SceneImpl sceneImpl = this.f9033a.e;
        ArrayList arrayList = new ArrayList(b2.size());
        for (AdTemplate adTemplate : b2) {
            adTemplate.mAdScene = sceneImpl;
            arrayList.add(adTemplate);
        }
        com.kwad.sdk.contentalliance.home.c.a(arrayList);
        com.kwad.sdk.contentalliance.detail.photo.related.a.a().c();
        this.f9033a.c.setInitStartPosition(this.f9033a.j);
    }
}
