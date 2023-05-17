package com.kwad.components.core.offline.init.kwai;

import android.text.TextUtils;
import com.kwad.components.offline.api.core.api.ICache;
import com.kwad.sdk.KsAdSDKImpl;
import java.io.File;
/* loaded from: classes9.dex */
public final class b implements ICache {
    @Override // com.kwad.components.offline.api.core.api.ICache
    public final String getPreCacheUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int sc = com.kwad.sdk.core.config.d.sc();
        if (sc >= 0) {
            return sc == 0 ? str : com.kwad.sdk.core.videocache.b.a.bC(KsAdSDKImpl.get().getContext()).cA(str);
        }
        File ad = com.kwad.sdk.core.diskcache.a.a.sS().ad(str);
        if (ad == null || !ad.exists()) {
            return null;
        }
        return ad.getAbsolutePath();
    }
}
