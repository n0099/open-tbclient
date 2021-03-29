package com.kwad.sdk.entry.model;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public final com.kwad.sdk.core.response.model.a f34717a;

    /* renamed from: b  reason: collision with root package name */
    public int f34718b;

    public a(@NonNull com.kwad.sdk.core.response.model.a aVar) {
        this.f34717a = aVar;
    }

    public List<AdTemplate> a(SceneImpl sceneImpl) {
        List<AdTemplate> list = this.f34717a.k;
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (AdTemplate adTemplate : list) {
            arrayList.add(new CacheTemplate(adTemplate, sceneImpl));
        }
        return arrayList;
    }

    public void a(AdTemplate adTemplate) {
        if (adTemplate == null || this.f34717a.k == null) {
            return;
        }
        for (int i = 0; i < this.f34717a.k.size(); i++) {
            if (adTemplate.equals(this.f34717a.k.get(i))) {
                this.f34718b = i;
                return;
            }
        }
    }
}
