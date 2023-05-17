package com.kwad.components.core.webview.jshandler;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes9.dex */
public class ah implements com.kwad.sdk.core.webview.kwai.a {
    public a Na;
    public AdTemplate mAdTemplate;
    public Context mContext;

    /* loaded from: classes9.dex */
    public interface a {
        boolean dc();
    }

    public ah(Context context, AdTemplate adTemplate) {
        this.mContext = context;
        this.mAdTemplate = adTemplate;
    }

    public final void a(a aVar) {
        this.Na = aVar;
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        a aVar = this.Na;
        boolean dc = aVar != null ? aVar.dc() : true;
        com.kwad.sdk.core.e.b.d("WebShowPlayableHandler", "handleJsCall launch AdPlayableActivityProxy : " + dc);
        if (dc) {
            com.kwad.components.core.page.a.launch(this.mContext, this.mAdTemplate);
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public final String getKey() {
        return "showPlayable";
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void onDestroy() {
    }
}
