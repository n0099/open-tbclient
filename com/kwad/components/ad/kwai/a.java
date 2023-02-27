package com.kwad.components.ad.kwai;
/* loaded from: classes8.dex */
public final class a extends com.kwad.components.core.k.a {
    public a(com.kwad.components.core.k.kwai.a aVar) {
        super(aVar);
        putBody("requestTime", System.currentTimeMillis());
    }

    @Override // com.kwad.components.core.k.a, com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public final String getUrl() {
        return com.kwad.sdk.b.qM();
    }
}
