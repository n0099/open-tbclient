package com.kwad.components.offline.c;

import android.content.Context;
/* loaded from: classes10.dex */
public final class a implements com.kwad.components.core.n.a.d.b {
    @Override // com.kwad.sdk.components.a
    public final void init(Context context) {
    }

    @Override // com.kwad.sdk.components.a
    public final int priority() {
        return 100;
    }

    @Override // com.kwad.sdk.components.a
    public final Class<?> getComponentsType() {
        return com.kwad.components.core.n.a.d.b.class;
    }

    @Override // com.kwad.components.core.n.a.d.b
    public final void a(com.kwad.components.core.n.a.d.a aVar) {
        c.tz().a(aVar);
    }

    @Override // com.kwad.components.core.n.a.d.b
    public final void b(com.kwad.components.core.n.a.d.a aVar) {
        c.tz().b(aVar);
    }
}
