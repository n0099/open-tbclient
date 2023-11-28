package com.kwad.components.core.webview.jshandler;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class ap implements com.kwad.sdk.core.webview.c.a {
    public AdTemplate mAdTemplate;
    public Context mContext;

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "openWechatMiniProgram";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    public ap(Context context, AdTemplate adTemplate) {
        this.mContext = context;
        this.mAdTemplate = adTemplate;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        AdTemplate adTemplate;
        com.kwad.components.core.webview.a.c cVar2 = new com.kwad.components.core.webview.a.c();
        if (this.mContext == null) {
            com.kwad.sdk.core.report.a.m(this.mAdTemplate, 2);
            cVar.onError(-1, "context为空");
            return;
        }
        AdTemplate adTemplate2 = null;
        try {
            cVar2.parseJson(new JSONObject(str));
            adTemplate = this.mAdTemplate;
        } catch (Exception e) {
            e = e;
        }
        try {
            if (cVar2.VA > 0) {
                adTemplate = com.kwad.sdk.core.response.b.c.a(com.kwad.components.core.n.a.d.a.a.at(cVar2.VA), cVar2.Jw);
            }
            if (adTemplate == null) {
                com.kwad.sdk.core.report.a.m(this.mAdTemplate, 2);
                cVar.onError(-1, "adTemplate为空：" + cVar2.VA);
                return;
            }
            AdInfo dP = com.kwad.sdk.core.response.b.e.dP(adTemplate);
            if (!com.kwad.sdk.core.response.b.a.S(dP) && com.kwad.components.core.e.d.e.a(this.mContext, dP.adConversionInfo.smallAppJumpInfo.mediaSmallAppId, cVar2.Vy, cVar2.Vz, adTemplate) == 1) {
                cVar.a(null);
            } else {
                cVar.onError(-1, "跳转失败");
            }
        } catch (Exception e2) {
            e = e2;
            adTemplate2 = adTemplate;
            com.kwad.sdk.core.report.a.m(adTemplate2, 2);
            cVar.onError(-1, "解析失败");
            com.kwad.sdk.core.e.c.printStackTrace(e);
        }
    }
}
