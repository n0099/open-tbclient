package com.kwad.components.ad.reward.b;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
/* loaded from: classes10.dex */
public final class e implements com.kwad.sdk.core.webview.kwai.a {
    public String TAG;
    public com.kwad.sdk.core.webview.kwai.c kr;

    @KsJson
    /* loaded from: classes10.dex */
    public static class a extends com.kwad.sdk.core.response.kwai.a {
        public String oN;
    }

    public e() {
        String str = "ExtraDialogListener" + hashCode();
        this.TAG = str;
        com.kwad.sdk.core.e.b.d(str, "create: ");
    }

    private void R(String str) {
        if (TextUtils.isEmpty(str) || this.kr == null) {
            return;
        }
        a aVar = new a();
        aVar.oN = str;
        this.kr.a(aVar);
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        String str2 = this.TAG;
        com.kwad.sdk.core.e.b.d(str2, "handleJsCall: " + cVar);
        this.kr = cVar;
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public final String getKey() {
        return "registerExtraDialogListener";
    }

    public final void gu() {
        com.kwad.sdk.core.e.b.d(this.TAG, "notifyDialogClose: ");
        R("close");
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void onDestroy() {
        com.kwad.sdk.core.e.b.d(this.TAG, "onDestroy: ");
        this.kr = null;
    }
}
