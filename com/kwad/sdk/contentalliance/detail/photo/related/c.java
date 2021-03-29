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
/* loaded from: classes6.dex */
public class c extends com.kwad.sdk.lib.b.b<AdTemplate, AdResultData> {

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f32490c;

    /* renamed from: d  reason: collision with root package name */
    public SceneImpl f32491d;

    public c(AdTemplate adTemplate) {
        this.f32490c = adTemplate;
        this.f32491d = adTemplate.mAdScene;
    }

    @Override // com.kwad.sdk.lib.b.b
    public i<g, AdResultData> a() {
        final l.a aVar = new l.a();
        f fVar = new f(this.f32491d);
        fVar.f33652b = this.f32491d.getPageScene();
        aVar.f33810a = fVar;
        aVar.f33811b = new com.kwad.sdk.core.g.a.c();
        aVar.f33812c = String.valueOf(com.kwad.sdk.core.response.b.d.k(this.f32490c.photoInfo));
        return new i<g, AdResultData>() { // from class: com.kwad.sdk.contentalliance.detail.photo.related.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: a */
            public l b() {
                return new l(aVar);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.i
            @NonNull
            /* renamed from: a */
            public AdResultData b(String str) {
                JSONObject jSONObject = new JSONObject(str);
                AdResultData adResultData = new AdResultData(c.this.f32491d);
                adResultData.parseJson(jSONObject);
                return adResultData;
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
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
    public boolean a(int i) {
        return i != com.kwad.sdk.core.network.f.f33875g.k;
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
            adTemplate.mAdScene = this.f32491d;
            arrayList.add(adTemplate);
        }
        a.a().e();
        AdResultData adResultData = new AdResultData();
        adResultData.adTemplateList = arrayList;
        return adResultData;
    }
}
