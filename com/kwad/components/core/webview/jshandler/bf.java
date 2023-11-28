package com.kwad.components.core.webview.jshandler;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes10.dex */
public class bf implements com.kwad.sdk.core.webview.c.a {
    public a Ya;
    public AdTemplate mAdTemplate;
    public Context mContext;

    /* loaded from: classes10.dex */
    public interface a {
        boolean dK();
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "showPlayable";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    public bf(Context context, AdTemplate adTemplate) {
        this.mContext = com.kwad.sdk.m.l.wrapContextIfNeed(context);
        this.mAdTemplate = adTemplate;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        boolean z;
        a aVar = this.Ya;
        if (aVar != null) {
            z = aVar.dK();
        } else {
            z = true;
        }
        com.kwad.sdk.core.e.c.d("WebShowPlayableHandler", "handleJsCall launch AdPlayableActivityProxy : " + z);
        if (z) {
            com.kwad.components.core.page.a.launch(this.mContext, this.mAdTemplate);
        }
    }

    public final void a(a aVar) {
        this.Ya = aVar;
    }
}
