package com.kwad.components.offline.c.a;

import com.kwad.components.offline.api.tk.IOfflineTKRenderListener;
import com.kwad.sdk.components.o;
/* loaded from: classes10.dex */
public final class h implements IOfflineTKRenderListener {
    public final o ade;

    public h(o oVar) {
        this.ade = oVar;
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineTKRenderListener
    public final void onFailed(Throwable th) {
        o oVar = this.ade;
        if (oVar != null) {
            oVar.onFailed(th);
        }
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineTKRenderListener
    public final void onSuccess() {
        o oVar = this.ade;
        if (oVar != null) {
            oVar.onSuccess();
        }
    }
}
