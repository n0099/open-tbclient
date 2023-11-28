package com.kwad.components.offline.a;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.offline.api.adLive.IAdLiveOfflineCompo;
import com.kwad.components.offline.api.core.adlive.IAdLiveEndRequest;
import com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView;
import com.kwad.components.offline.api.core.adlive.IAdLivePlayModule;
/* loaded from: classes10.dex */
public class a implements com.kwad.components.core.n.a.a.a {
    public final IAdLiveOfflineCompo acm;

    @Override // com.kwad.sdk.components.a
    public final void init(Context context) {
    }

    public a(@NonNull IAdLiveOfflineCompo iAdLiveOfflineCompo) {
        this.acm = iAdLiveOfflineCompo;
    }

    @Override // com.kwad.components.core.n.a.a.a
    public final IAdLiveEndRequest getAdLiveEndRequest(String str) {
        return this.acm.getAdLiveEndRequest(str);
    }

    @Override // com.kwad.components.core.n.a.a.a
    public final IAdLivePlayModule getAdLivePlayModule(IAdLiveOfflineView iAdLiveOfflineView, String str, String str2) {
        return this.acm.getAdLivePlayModule(iAdLiveOfflineView, str, str2);
    }

    @Override // com.kwad.sdk.components.a
    public final Class<a> getComponentsType() {
        return a.class;
    }

    @Override // com.kwad.components.core.n.a.a.a
    public final boolean oA() {
        if (this.acm.getState() == IAdLiveOfflineCompo.AdLiveState.READY) {
            return true;
        }
        return false;
    }

    @Override // com.kwad.sdk.components.a
    public final int priority() {
        return this.acm.priority();
    }

    @Override // com.kwad.components.core.n.a.a.a
    public final IAdLiveOfflineView getView(Context context, int i) {
        return this.acm.getView(context, i);
    }
}
