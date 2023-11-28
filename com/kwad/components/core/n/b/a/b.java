package com.kwad.components.core.n.b.a;

import android.text.TextUtils;
import com.kwad.components.offline.api.core.api.ICache;
import com.kwad.sdk.KsAdSDKImpl;
/* loaded from: classes10.dex */
public final class b implements ICache {
    @Override // com.kwad.components.offline.api.core.api.ICache
    public final String getPreCacheUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return com.kwad.components.core.video.j.f(KsAdSDKImpl.get().getContext(), str);
    }
}
