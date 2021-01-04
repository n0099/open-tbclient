package com.kwad.sdk.entry.model;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public final com.kwad.sdk.core.response.model.a f10071a;

    /* renamed from: b  reason: collision with root package name */
    public int f10072b;

    public a(@NonNull com.kwad.sdk.core.response.model.a aVar) {
        this.f10071a = aVar;
    }

    public List<AdTemplate> a(SceneImpl sceneImpl) {
        List<AdTemplate> list = this.f10071a.k;
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
        if (adTemplate == null || this.f10071a.k == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f10071a.k.size()) {
                return;
            }
            if (adTemplate.equals(this.f10071a.k.get(i2))) {
                this.f10072b = i2;
                return;
            }
            i = i2 + 1;
        }
    }
}
