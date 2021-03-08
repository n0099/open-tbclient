package com.kwad.sdk.contentalliance.profile.tabvideo;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.g.a.f;
import com.kwad.sdk.core.g.p;
import com.kwad.sdk.core.network.g;
import com.kwad.sdk.core.network.i;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d extends com.kwad.sdk.lib.b.b<AdTemplate, AdResultData> {
    private SceneImpl c;
    private ProfileTabVideoParam d;
    private int e;
    private String f;

    public d(SceneImpl sceneImpl, ProfileTabVideoParam profileTabVideoParam) {
        this.c = sceneImpl;
        this.d = profileTabVideoParam;
    }

    @Override // com.kwad.sdk.lib.b.b
    protected i<g, AdResultData> a() {
        final p.a aVar = new p.a();
        aVar.e = this.f;
        f fVar = new f(this.c);
        fVar.b = this.c.getPageScene();
        aVar.f6176a = fVar;
        aVar.c = this.d.mAuthorId;
        aVar.d = this.d.mTabId;
        com.kwad.sdk.core.g.a.c cVar = new com.kwad.sdk.core.g.a.c();
        cVar.d = this.e;
        aVar.b = cVar;
        return new i<g, AdResultData>() { // from class: com.kwad.sdk.contentalliance.profile.tabvideo.d.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.kwad.sdk.core.network.i
            @NonNull
            /* renamed from: a */
            public AdResultData b(String str) {
                JSONObject jSONObject = new JSONObject(str);
                AdResultData adResultData = new AdResultData(aVar.f6176a.f6100a);
                adResultData.parseJson(jSONObject);
                if (!adResultData.adTemplateList.isEmpty()) {
                    for (AdTemplate adTemplate : adResultData.adTemplateList) {
                        adTemplate.mPcursor = adResultData.pcursor;
                    }
                }
                return adResultData;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: c */
            public p b() {
                return new p(aVar);
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.lib.b.b
    public List<AdTemplate> a(AdResultData adResultData) {
        this.e++;
        return adResultData.adTemplateList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.lib.b.b
    public boolean b(AdResultData adResultData) {
        this.f = adResultData.pcursor;
        return !"0".equals(this.f);
    }
}
