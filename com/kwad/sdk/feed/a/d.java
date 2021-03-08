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
/* loaded from: classes3.dex */
public class d extends com.kwad.sdk.lib.b.b<AdTemplate, AdResultData> {
    private SceneImpl c;

    public d(SceneImpl sceneImpl) {
        this.c = sceneImpl;
    }

    @Override // com.kwad.sdk.lib.b.b
    protected i<g, AdResultData> a() {
        final h.a aVar = new h.a();
        f fVar = new f(this.c);
        fVar.b = this.c.getPageScene();
        fVar.c = 100L;
        aVar.f6152a.add(fVar);
        aVar.b = new com.kwad.sdk.core.g.a.c();
        return new i<g, AdResultData>() { // from class: com.kwad.sdk.feed.a.d.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.kwad.sdk.core.network.i
            @NonNull
            /* renamed from: a */
            public AdResultData b(String str) {
                JSONObject jSONObject = new JSONObject(str);
                AdResultData adResultData = new AdResultData(d.this.c);
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
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.lib.b.b
    public List<AdTemplate> a(AdResultData adResultData) {
        return adResultData.adTemplateList;
    }

    @Override // com.kwad.sdk.lib.b.b
    protected boolean a(int i) {
        return i != com.kwad.sdk.core.network.f.g.k;
    }

    @Override // com.kwad.sdk.lib.b.b
    protected boolean b() {
        List<AdTemplate> d = a.a().d();
        return (d == null || d.isEmpty()) ? false : true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.lib.b.b
    /* renamed from: c */
    public AdResultData d() {
        List<AdTemplate> d = a.a().d();
        if (d == null || d.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList(d.size());
        for (AdTemplate adTemplate : d) {
            adTemplate.mAdScene = this.c;
            arrayList.add(adTemplate);
        }
        a.a().e();
        AdResultData adResultData = new AdResultData();
        adResultData.adTemplateList = arrayList;
        return adResultData;
    }
}
