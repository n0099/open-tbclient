package com.kwad.components.core.webview.jshandler;

import android.os.Vibrator;
import androidx.annotation.NonNull;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bn;
/* loaded from: classes10.dex */
public final class u implements com.kwad.sdk.core.webview.c.a {
    public Vibrator eh;

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "startVibrate";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        this.eh = (Vibrator) ServiceProvider.getContext().getSystemService("vibrator");
        bn.a(ServiceProvider.getContext(), this.eh);
        cVar.a(null);
    }
}
