package com.kwad.sdk.crash.report.request;

import com.kwad.sdk.core.network.d;
import java.util.List;
/* loaded from: classes7.dex */
public final class a extends d {
    public a(List list) {
        putBody("eventList", list);
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public final String getUrl() {
        return com.kwad.sdk.b.qR();
    }
}
