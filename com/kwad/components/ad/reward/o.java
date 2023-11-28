package com.kwad.components.ad.reward;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bg;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class o {

    /* loaded from: classes10.dex */
    public static class a {
        public String errorMsg;
        public boolean qr;

        public a(String str) {
            JSONObject jSONObject;
            this.errorMsg = "-";
            try {
                jSONObject = new JSONObject(str);
            } catch (Throwable th) {
                th.printStackTrace();
                this.qr = false;
                this.errorMsg = "数据解析失败";
                jSONObject = null;
            }
            parseJson(jSONObject);
        }

        private void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject != null) {
                this.qr = jSONObject.optBoolean("isValid");
                this.errorMsg = jSONObject.toString();
            }
        }

        public final boolean isValid() {
            return this.qr;
        }
    }

    public static void b(final AdTemplate adTemplate, AdInfo adInfo) {
        final String bO = com.kwad.sdk.core.response.b.a.bO(adInfo);
        com.kwad.sdk.core.e.c.d("ServerCallbackHandle", "handleRewardVerify callbackUrl: " + bO);
        if (!bg.isNullString(bO)) {
            com.kwad.sdk.utils.g.execute(new Runnable() { // from class: com.kwad.components.ad.reward.o.1
                private void D(String str) {
                    com.kwad.components.core.o.a.pX().g(adTemplate, 1, str);
                }

                private void gm() {
                    com.kwad.components.core.o.a.pX().g(adTemplate, 0, "success");
                }

                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        com.kwad.sdk.core.network.c doGet = com.kwad.sdk.f.xI().doGet(bO, null);
                        if (doGet == null) {
                            D("Network Error: url invalid");
                        } else if (doGet.code == 200) {
                            a aVar = new a(doGet.atm);
                            if (aVar.isValid()) {
                                gm();
                            } else {
                                D(aVar.errorMsg);
                            }
                        } else {
                            D("Network Error: " + doGet.atm);
                        }
                    } catch (Throwable th) {
                        D("Request Error: " + th.getMessage());
                    }
                }
            });
        }
    }
}
