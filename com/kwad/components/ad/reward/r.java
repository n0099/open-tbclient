package com.kwad.components.ad.reward;

import androidx.annotation.Nullable;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ax;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class r {

    /* loaded from: classes10.dex */
    public static class a {
        public String errorMsg;
        public boolean nQ;

        public a(String str) {
            JSONObject jSONObject;
            this.errorMsg = "-";
            try {
                jSONObject = new JSONObject(str);
            } catch (Throwable th) {
                th.printStackTrace();
                this.nQ = false;
                this.errorMsg = "数据解析失败";
                jSONObject = null;
            }
            parseJson(jSONObject);
        }

        private void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject != null) {
                this.nQ = jSONObject.optBoolean("isValid");
                this.errorMsg = jSONObject.toString();
            }
        }

        public final boolean isValid() {
            return this.nQ;
        }
    }

    public static void b(final AdTemplate adTemplate, AdInfo adInfo) {
        final String bd = com.kwad.sdk.core.response.a.a.bd(adInfo);
        com.kwad.sdk.core.e.b.d("ServerCallbackHandle", "handleRewardVerify callbackUrl: " + bd);
        if (ax.dT(bd)) {
            return;
        }
        com.kwad.sdk.utils.g.runOnDefaultExecutor(new Runnable() { // from class: com.kwad.components.ad.reward.r.1
            private void Q(String str) {
                com.kwad.components.core.j.a.og().c(adTemplate, 1, str);
            }

            private void fT() {
                com.kwad.components.core.j.a.og().c(adTemplate, 0, "success");
            }

            @Override // java.lang.Runnable
            public final void run() {
                String str;
                try {
                    com.kwad.sdk.core.network.c doGet = KsAdSDKImpl.get().getProxyForHttp().doGet(bd, null);
                    if (doGet == null) {
                        str = "Network Error: url invalid";
                    } else if (doGet.code != 200) {
                        Q("Network Error: " + doGet.XV);
                        return;
                    } else {
                        a aVar = new a(doGet.XV);
                        if (aVar.isValid()) {
                            fT();
                            return;
                        }
                        str = aVar.errorMsg;
                    }
                    Q(str);
                } catch (Throwable th) {
                    Q("Request Error: " + th.getMessage());
                }
            }
        });
    }
}
