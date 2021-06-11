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
/* loaded from: classes6.dex */
public class d extends com.kwad.sdk.lib.b.b<AdTemplate, AdResultData> {

    /* renamed from: c  reason: collision with root package name */
    public SceneImpl f33532c;

    /* renamed from: d  reason: collision with root package name */
    public ProfileTabVideoParam f33533d;

    /* renamed from: e  reason: collision with root package name */
    public int f33534e;

    /* renamed from: f  reason: collision with root package name */
    public String f33535f;

    public d(SceneImpl sceneImpl, ProfileTabVideoParam profileTabVideoParam) {
        this.f33532c = sceneImpl;
        this.f33533d = profileTabVideoParam;
    }

    @Override // com.kwad.sdk.lib.b.b
    public i<g, AdResultData> a() {
        final p.a aVar = new p.a();
        aVar.f34463e = this.f33535f;
        f fVar = new f(this.f33532c);
        fVar.f34278b = this.f33532c.getPageScene();
        aVar.f34459a = fVar;
        ProfileTabVideoParam profileTabVideoParam = this.f33533d;
        aVar.f34461c = profileTabVideoParam.mAuthorId;
        aVar.f34462d = profileTabVideoParam.mTabId;
        com.kwad.sdk.core.g.a.c cVar = new com.kwad.sdk.core.g.a.c();
        cVar.f34265d = this.f33534e;
        aVar.f34460b = cVar;
        return new i<g, AdResultData>() { // from class: com.kwad.sdk.contentalliance.profile.tabvideo.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.i
            @NonNull
            /* renamed from: a */
            public AdResultData b(String str) {
                JSONObject jSONObject = new JSONObject(str);
                AdResultData adResultData = new AdResultData(aVar.f34459a.f34277a);
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
    @Override // com.kwad.sdk.lib.b.b
    public List<AdTemplate> a(AdResultData adResultData) {
        this.f33534e++;
        return adResultData.adTemplateList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.lib.b.b
    public boolean b(AdResultData adResultData) {
        String str = adResultData.pcursor;
        this.f33535f = str;
        return !"0".equals(str);
    }
}
