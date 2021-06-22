package com.kwad.sdk.entry.model;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public final com.kwad.sdk.core.response.model.a f35472a;

    /* renamed from: b  reason: collision with root package name */
    public int f35473b;

    public a(@NonNull com.kwad.sdk.core.response.model.a aVar) {
        this.f35472a = aVar;
    }

    public List<AdTemplate> a(SceneImpl sceneImpl) {
        List<AdTemplate> list = this.f35472a.k;
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
        if (adTemplate == null || this.f35472a.k == null) {
            return;
        }
        for (int i2 = 0; i2 < this.f35472a.k.size(); i2++) {
            if (adTemplate.equals(this.f35472a.k.get(i2))) {
                this.f35473b = i2;
                return;
            }
        }
    }
}
