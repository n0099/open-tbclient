package com.kwad.components.offline.c.a;

import com.kwad.components.offline.api.tk.IOfflineApkLoader;
import com.kwad.components.offline.api.tk.IOfflineApkLoaderHolder;
/* loaded from: classes10.dex */
public final class e implements IOfflineApkLoaderHolder {
    public com.kwad.sdk.components.i YW;

    public e(com.kwad.sdk.components.i iVar) {
        this.YW = iVar;
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineApkLoaderHolder
    public final IOfflineApkLoader getApkLoader(int i) {
        return new d(this.YW.aN(i));
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineApkLoaderHolder
    public final IOfflineApkLoader getApkLoader(String str) {
        return new d(this.YW.aM(str));
    }
}
