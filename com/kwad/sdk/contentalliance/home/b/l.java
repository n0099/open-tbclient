package com.kwad.sdk.contentalliance.home.b;

import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.entry.model.CacheTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class l extends com.kwad.sdk.contentalliance.home.e {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.contentalliance.home.e, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        List<AdTemplate> b = com.kwad.sdk.contentalliance.profile.tabvideo.detail.a.a().b();
        if (b == null) {
            return;
        }
        SceneImpl sceneImpl = this.f5821a.e;
        ArrayList arrayList = new ArrayList(b.size());
        for (AdTemplate adTemplate : b) {
            arrayList.add(new CacheTemplate(adTemplate, sceneImpl));
        }
        com.kwad.sdk.contentalliance.home.c.a(arrayList);
        com.kwad.sdk.contentalliance.profile.tabvideo.detail.a.a().c();
        this.f5821a.c.setInitStartPosition(this.f5821a.j);
    }
}
