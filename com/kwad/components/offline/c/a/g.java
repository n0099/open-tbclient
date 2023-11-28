package com.kwad.components.offline.c.a;

import com.kwad.components.offline.api.tk.IOfflineTKCallHandler;
import com.kwad.sdk.components.m;
/* loaded from: classes10.dex */
public final class g implements IOfflineTKCallHandler {
    public final m add;

    public g(m mVar) {
        this.add = mVar;
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineTKCallHandler
    public final void callJS(String str) {
        m mVar = this.add;
        if (mVar != null) {
            mVar.callJS(str);
        }
    }
}
