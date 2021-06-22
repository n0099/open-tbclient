package com.kwad.sdk.feed.a;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.g.a.f;
import com.kwad.sdk.core.g.h;
import com.kwad.sdk.core.network.g;
import com.kwad.sdk.core.network.i;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class d extends com.kwad.sdk.lib.b.b<AdTemplate, AdResultData> {

    /* renamed from: c  reason: collision with root package name */
    public SceneImpl f35641c;

    public d(SceneImpl sceneImpl) {
        this.f35641c = sceneImpl;
    }

    @Override // com.kwad.sdk.lib.b.b
    public i<g, AdResultData> a() {
        final h.a aVar = new h.a();
        f fVar = new f(this.f35641c);
        fVar.f34376b = this.f35641c.getPageScene();
        fVar.f34377c = 100L;
        aVar.f34510a.add(fVar);
        aVar.f34511b = new com.kwad.sdk.core.g.a.c();
        return new i<g, AdResultData>() { // from class: com.kwad.sdk.feed.a.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.i
            @NonNull
            /* renamed from: a */
            public AdResultData b(String str) {
                JSONObject jSONObject = new JSONObject(str);
                AdResultData adResultData = new AdResultData(d.this.f35641c);
                adResultData.parseJson(jSONObject);
                return adResultData;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: c */
            public h b() {
                return new h(aVar);
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.lib.b.b
    public List<AdTemplate> a(AdResultData adResultData) {
        return adResultData.adTemplateList;
    }

    @Override // com.kwad.sdk.lib.b.b
    public boolean a(int i2) {
        return i2 != com.kwad.sdk.core.network.f.f34601g.k;
    }

    @Override // com.kwad.sdk.lib.b.b
    public boolean b() {
        List<AdTemplate> d2 = a.a().d();
        return (d2 == null || d2.isEmpty()) ? false : true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.lib.b.b
    /* renamed from: c */
    public AdResultData d() {
        List<AdTemplate> d2 = a.a().d();
        if (d2 == null || d2.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList(d2.size());
        for (AdTemplate adTemplate : d2) {
            adTemplate.mAdScene = this.f35641c;
            arrayList.add(adTemplate);
        }
        a.a().e();
        AdResultData adResultData = new AdResultData();
        adResultData.adTemplateList = arrayList;
        return adResultData;
    }
}
