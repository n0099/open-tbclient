package com.kwad.components.core.webview.b.kwai;

import androidx.annotation.NonNull;
import com.baidu.android.ext.manage.PopItemMethodConstant;
import com.kwad.components.core.webview.b.a.p;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class l implements com.kwad.sdk.core.webview.kwai.a {
    public a NG;

    /* loaded from: classes9.dex */
    public interface a {
        void a(p pVar);
    }

    public final void a(a aVar) {
        this.NG = aVar;
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        if (this.NG != null) {
            p pVar = new p();
            try {
                pVar.parseJson(new JSONObject(str));
                this.NG.a(pVar);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public final String getKey() {
        return PopItemMethodConstant.showToast;
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void onDestroy() {
        this.NG = null;
    }
}
