package com.kwad.sdk.contentalliance;

import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes5.dex */
public class a extends com.kwad.sdk.lib.widget.recycler.a.e<AdTemplate> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.lib.widget.recycler.a.e
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public boolean b(AdTemplate adTemplate, AdTemplate adTemplate2) {
        if (adTemplate == null || adTemplate2 == null) {
            return false;
        }
        return com.kwad.sdk.core.response.b.c.a(adTemplate) ? com.kwad.sdk.core.response.b.c.a(adTemplate2) && com.kwad.sdk.live.mode.a.b(com.kwad.sdk.core.response.b.c.A(adTemplate)) == com.kwad.sdk.live.mode.a.b(com.kwad.sdk.core.response.b.c.A(adTemplate2)) : com.kwad.sdk.core.response.b.c.z(adTemplate) == com.kwad.sdk.core.response.b.c.z(adTemplate2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.lib.widget.recycler.a.e
    /* renamed from: b  reason: avoid collision after fix types in other method */
    public boolean a(AdTemplate adTemplate, AdTemplate adTemplate2) {
        return (adTemplate == null && adTemplate2 == null) || (adTemplate != null && adTemplate.equals(adTemplate2));
    }
}
