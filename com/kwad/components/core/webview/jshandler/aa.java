package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class aa implements com.kwad.sdk.core.webview.kwai.a {
    public com.kwad.sdk.core.webview.kwai.c Lb;

    /* loaded from: classes9.dex */
    public static final class a implements com.kwad.sdk.core.b {
        public String MJ;

        @Override // com.kwad.sdk.core.b
        public final void parseJson(@Nullable JSONObject jSONObject) {
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.r.putValue(jSONObject, "lifeStatus", this.MJ);
            return jSONObject;
        }
    }

    private void aF(String str) {
        if (this.Lb != null) {
            a aVar = new a();
            aVar.MJ = str;
            this.Lb.a(aVar);
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        this.Lb = cVar;
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public final String getKey() {
        return "registerLifecycleListener";
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void onDestroy() {
        this.Lb = null;
    }

    public final void pA() {
        aF("hideStart");
    }

    public final void pB() {
        aF("hideEnd");
    }

    public final void pC() {
        aF("pageVisiable");
    }

    public final void pD() {
        aF("pageInvisiable");
    }

    public final void py() {
        aF("showStart");
    }

    public final void pz() {
        aF("showEnd");
    }
}
