package com.kwad.components.offline.b;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.offline.api.obiwan.IObiwanLogcat;
import com.kwad.components.offline.api.obiwan.IObiwanOfflineCompo;
/* loaded from: classes10.dex */
public class a implements com.kwad.components.core.n.a.c.a {
    public final IObiwanOfflineCompo acy;

    @Override // com.kwad.sdk.components.a
    public final void init(Context context) {
    }

    public a(@NonNull IObiwanOfflineCompo iObiwanOfflineCompo) {
        this.acy = iObiwanOfflineCompo;
    }

    @Override // com.kwad.sdk.components.a
    public final Class getComponentsType() {
        return a.class;
    }

    public final IObiwanLogcat getLog() {
        return this.acy.getLog();
    }

    @Override // com.kwad.sdk.components.a
    public final int priority() {
        return this.acy.priority();
    }

    public final void updateConfigs() {
        this.acy.updateConfigs();
    }
}
