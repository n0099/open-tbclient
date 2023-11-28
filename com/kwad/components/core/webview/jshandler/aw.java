package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class aw extends com.kwad.components.core.webview.tachikoma.a.w {
    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "registerLifecycleListener";
    }

    /* loaded from: classes10.dex */
    public static final class a implements com.kwad.sdk.core.b {
        public String XD;

        @Override // com.kwad.sdk.core.b
        public final void parseJson(@Nullable JSONObject jSONObject) {
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.t.putValue(jSONObject, "lifeStatus", this.XD);
            return jSONObject;
        }
    }

    public final void sg() {
        aF("showStart");
    }

    public final void sh() {
        aF("showEnd");
    }

    public final void si() {
        aF("hideStart");
    }

    public final void sj() {
        aF("hideEnd");
    }

    public final void sk() {
        aF("pageVisiable");
    }

    public final void sl() {
        aF("pageInvisiable");
    }

    private void aF(String str) {
        a aVar = new a();
        aVar.XD = str;
        b(aVar);
    }
}
