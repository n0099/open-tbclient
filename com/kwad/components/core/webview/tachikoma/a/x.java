package com.kwad.components.core.webview.tachikoma.a;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener;
import com.kwad.sdk.service.ServiceProvider;
/* loaded from: classes10.dex */
public final class x implements com.kwad.sdk.core.webview.c.a {
    public com.kwad.sdk.core.webview.c.c Wl;
    public OfflineOnAudioConflictListener xP = new OfflineOnAudioConflictListener() { // from class: com.kwad.components.core.webview.tachikoma.a.x.1
        @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
        public final void onAudioBeOccupied() {
            x.this.aP(2);
        }

        @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
        public final void onAudioBeReleased() {
            x.this.aP(3);
        }
    };

    @KsJson
    /* loaded from: classes10.dex */
    public static class a extends com.kwad.sdk.core.response.a.a {
        public boolean ZK;
        public int ZL;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "registerAudioFocusListener";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        com.kwad.components.core.s.a.ah(ServiceProvider.getContext()).b(this.xP);
        this.Wl = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aP(int i) {
        a aVar = new a();
        aVar.ZK = com.kwad.components.core.s.a.ah(ServiceProvider.getContext()).qJ();
        aVar.ZL = i;
        com.kwad.sdk.core.webview.c.c cVar = this.Wl;
        if (cVar != null) {
            cVar.a(aVar);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        this.Wl = cVar;
        com.kwad.components.core.s.a.ah(ServiceProvider.getContext()).a(this.xP);
        aP(1);
    }
}
