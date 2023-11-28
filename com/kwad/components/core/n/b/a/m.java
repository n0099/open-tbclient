package com.kwad.components.core.n.b.a;

import com.kwad.components.offline.api.core.network.IIdc;
/* loaded from: classes10.dex */
public final class m implements IIdc {
    @Override // com.kwad.components.offline.api.core.network.IIdc
    public final String hostForAPI(String str) {
        if (str.equals("api")) {
            return com.kwad.sdk.g.xK();
        }
        return "https://" + com.kwad.sdk.core.network.idc.a.CJ().U(str, null);
    }
}
