package com.kwad.sdk.core.imageloader;

import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.b;
/* loaded from: classes10.dex */
public class GlobalImageListener implements OnRenderResultListener<AdTemplate> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.imageloader.OnRenderResultListener
    public void onRenderResult(boolean z, AdTemplate adTemplate, String str, String str2) {
        if (!z) {
            ((b) ServiceProvider.get(b.class)).D(str, str2);
        }
        if (!z) {
            ((b) ServiceProvider.get(b.class)).aE(adTemplate);
        }
    }
}
