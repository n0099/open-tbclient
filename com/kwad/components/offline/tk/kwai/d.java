package com.kwad.components.offline.tk.kwai;

import android.view.View;
import androidx.annotation.NonNull;
import com.kwad.components.offline.api.tk.IOfflineCompoTachikomaView;
import com.kwad.sdk.components.g;
import com.kwad.sdk.components.h;
import com.kwad.sdk.utils.am;
/* loaded from: classes10.dex */
public final class d implements h {
    public final IOfflineCompoTachikomaView Qq;

    public d(@NonNull IOfflineCompoTachikomaView iOfflineCompoTachikomaView) {
        am.checkNotNull(iOfflineCompoTachikomaView);
        this.Qq = iOfflineCompoTachikomaView;
    }

    @Override // com.kwad.sdk.components.h
    public final void a(String str, String str2, g gVar) {
        this.Qq.execute(str, str2, new c(gVar));
    }

    @Override // com.kwad.sdk.components.h
    public final void c(com.kwad.sdk.core.webview.kwai.a aVar) {
        if (aVar == null) {
            return;
        }
        this.Qq.registerJsBridge(new b(aVar));
    }

    @Override // com.kwad.sdk.components.h
    public final View getView() {
        return this.Qq.getView();
    }

    @Override // com.kwad.sdk.components.h
    public final void onDestroy() {
        this.Qq.onDestroy();
    }
}
