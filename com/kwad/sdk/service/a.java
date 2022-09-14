package com.kwad.sdk.service;

import com.kwad.sdk.service.kwai.c;
/* loaded from: classes8.dex */
public final class a {
    public static void gatherException(Throwable th) {
        c cVar = (c) ServiceProvider.get(c.class);
        if (cVar != null) {
            cVar.gatherException(th);
        }
    }
}
