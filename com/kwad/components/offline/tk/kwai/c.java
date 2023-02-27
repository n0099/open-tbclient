package com.kwad.components.offline.tk.kwai;

import com.kwad.components.offline.api.tk.IOfflineTKRenderListener;
import com.kwad.sdk.components.g;
/* loaded from: classes8.dex */
public final class c implements IOfflineTKRenderListener {
    public final g Qp;

    public c(g gVar) {
        this.Qp = gVar;
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineTKRenderListener
    public final void onFailed(Throwable th) {
        g gVar = this.Qp;
        if (gVar != null) {
            gVar.pN();
        }
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineTKRenderListener
    public final void onSuccess() {
        g gVar = this.Qp;
        if (gVar != null) {
            gVar.onSuccess();
        }
    }
}
