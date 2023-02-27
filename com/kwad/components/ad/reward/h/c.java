package com.kwad.components.ad.reward.h;

import androidx.annotation.NonNull;
import com.kwad.components.core.webview.b.a.m;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class c implements com.kwad.sdk.core.webview.kwai.a {
    public a tL;

    /* loaded from: classes8.dex */
    public interface a {
        void a(m mVar);
    }

    public final void a(a aVar) {
        this.tL = aVar;
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        m mVar = new m();
        try {
            mVar.parseJson(new JSONObject(str));
            if (this.tL != null) {
                this.tL.a(mVar);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public final String getKey() {
        return "clickCall";
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void onDestroy() {
        this.tL = null;
    }
}
