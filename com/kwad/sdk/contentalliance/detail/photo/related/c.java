package com.kwad.sdk.contentalliance.detail.photo.related;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.g.a.f;
import com.kwad.sdk.core.g.l;
import com.kwad.sdk.core.network.g;
import com.kwad.sdk.core.network.i;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c extends com.kwad.sdk.lib.b.b<AdTemplate, AdResultData> {
    private AdTemplate c;
    private SceneImpl d;

    public c(AdTemplate adTemplate) {
        this.c = adTemplate;
        this.d = adTemplate.mAdScene;
    }

    @Override // com.kwad.sdk.lib.b.b
    protected i<g, AdResultData> a() {
        final l.a aVar = new l.a();
        f fVar = new f(this.d);
        fVar.f9166b = this.d.getPageScene();
        aVar.f9282a = fVar;
        aVar.f9283b = new com.kwad.sdk.core.g.a.c();
        aVar.c = String.valueOf(com.kwad.sdk.core.response.b.d.k(this.c.photoInfo));
        return new i<g, AdResultData>() { // from class: com.kwad.sdk.contentalliance.detail.photo.related.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: a */
            public l b() {
                return new l(aVar);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.kwad.sdk.core.network.i
            @NonNull
            /* renamed from: a */
            public AdResultData b(String str) {
                JSONObject jSONObject = new JSONObject(str);
                AdResultData adResultData = new AdResultData(c.this.d);
                adResultData.parseJson(jSONObject);
                return adResultData;
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.lib.b.b
    public List<AdTemplate> a(AdResultData adResultData) {
        if (adResultData == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (AdTemplate adTemplate : adResultData.adTemplateList) {
            if (com.kwad.sdk.core.response.b.c.b(adTemplate)) {
                arrayList.add(adTemplate);
            }
        }
        return arrayList;
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
            adTemplate.mAdScene = this.d;
            arrayList.add(adTemplate);
        }
        a.a().e();
        AdResultData adResultData = new AdResultData();
        adResultData.adTemplateList = arrayList;
        return adResultData;
    }
}
