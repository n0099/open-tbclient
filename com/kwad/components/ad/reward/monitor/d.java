package com.kwad.components.ad.reward.monitor;

import android.os.SystemClock;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.AdVideoPreCacheConfig;
/* loaded from: classes10.dex */
public final class d {
    public static void a(AdTemplate adTemplate, boolean z, AdVideoPreCacheConfig adVideoPreCacheConfig) {
        adTemplate.setLoadDataTime(SystemClock.elapsedRealtime());
        adTemplate.setLoadFromCache(z);
        long adVideoPreCacheSize = adVideoPreCacheConfig.getAdVideoPreCacheSize() * 1024;
        int i = (adVideoPreCacheSize > 0L ? 1 : (adVideoPreCacheSize == 0L ? 0 : -1));
        if (i > 0) {
            adTemplate.setDownloadType(3);
            adTemplate.setDownloadSize(adVideoPreCacheSize);
        } else if (i < 0) {
            adTemplate.setDownloadType(2);
        } else {
            adTemplate.setDownloadType(1);
            adTemplate.setDownloadSize(0L);
        }
    }
}
