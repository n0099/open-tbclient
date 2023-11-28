package com.kwad.components.ad.reward.c;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
/* loaded from: classes10.dex */
public final class e implements com.kwad.sdk.core.webview.c.a {
    public String TAG;
    public com.kwad.sdk.core.webview.c.c nr;

    @KsJson
    /* loaded from: classes10.dex */
    public static class a extends com.kwad.sdk.core.response.a.a {
        public String rp;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "registerExtraDialogListener";
    }

    public e() {
        String str = "ExtraDialogListener" + hashCode();
        this.TAG = str;
        com.kwad.sdk.core.e.c.d(str, "create: ");
    }

    public final void gO() {
        com.kwad.sdk.core.e.c.d(this.TAG, "notifyDialogClose: ");
        E("close");
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        com.kwad.sdk.core.e.c.d(this.TAG, "onDestroy: ");
        this.nr = null;
    }

    private void E(String str) {
        if (!TextUtils.isEmpty(str) && this.nr != null) {
            a aVar = new a();
            aVar.rp = str;
            this.nr.a(aVar);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        String str2 = this.TAG;
        com.kwad.sdk.core.e.c.d(str2, "handleJsCall: " + cVar);
        this.nr = cVar;
    }
}
