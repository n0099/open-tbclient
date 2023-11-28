package com.kwad.components.core.webview.tachikoma.a;

import androidx.annotation.NonNull;
import com.baidu.android.ext.manage.PopItemMethodConstant;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class s implements com.kwad.sdk.core.webview.c.a {
    public a ZB;

    /* loaded from: classes10.dex */
    public interface a {
        void a(com.kwad.components.core.webview.tachikoma.b.s sVar);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return PopItemMethodConstant.showToast;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.ZB = null;
    }

    public final void a(a aVar) {
        this.ZB = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        if (this.ZB != null) {
            com.kwad.components.core.webview.tachikoma.b.s sVar = new com.kwad.components.core.webview.tachikoma.b.s();
            try {
                sVar.parseJson(new JSONObject(str));
                this.ZB.a(sVar);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
