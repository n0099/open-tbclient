package com.kwad.sdk.reward;

import androidx.annotation.Nullable;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.at;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class m {

    /* loaded from: classes3.dex */
    public static class a {
        public boolean a;

        /* renamed from: b  reason: collision with root package name */
        public String f57349b;

        public a(String str) {
            JSONObject jSONObject;
            this.f57349b = "-";
            try {
                jSONObject = new JSONObject(str);
            } catch (Throwable th) {
                th.printStackTrace();
                this.a = false;
                this.f57349b = "数据解析失败";
                jSONObject = null;
            }
            a(jSONObject);
        }

        public void a(@Nullable JSONObject jSONObject) {
            if (jSONObject != null) {
                this.a = jSONObject.optBoolean("isValid");
                this.f57349b = jSONObject.toString();
            }
        }

        public boolean a() {
            return this.a;
        }
    }

    public static void a(final AdTemplate adTemplate, AdInfo adInfo) {
        final String aq = com.kwad.sdk.core.response.a.a.aq(adInfo);
        com.kwad.sdk.core.d.a.a("ServerCallbackHandle", "handleRewardVerify callbackUrl: " + aq);
        if (at.a(aq)) {
            return;
        }
        com.kwad.sdk.utils.i.a(new Runnable() { // from class: com.kwad.sdk.reward.m.1
            private void a() {
                com.kwad.sdk.core.report.d.b(adTemplate, 0, "success");
            }

            private void a(String str) {
                com.kwad.sdk.core.report.d.b(adTemplate, 1, str);
            }

            @Override // java.lang.Runnable
            public void run() {
                String str;
                try {
                    com.kwad.sdk.core.network.c doGet = KsAdSDKImpl.get().getProxyForHttp().doGet(aq, null);
                    if (doGet == null) {
                        str = "Network Error: url invalid";
                    } else if (doGet.a == 200) {
                        a aVar = new a(doGet.f55891b);
                        if (aVar.a()) {
                            a();
                            return;
                        }
                        str = aVar.f57349b;
                    } else {
                        str = "Network Error: " + doGet.f55891b;
                    }
                    a(str);
                } catch (Throwable th) {
                    a("Request Error: " + th.getMessage());
                }
            }
        });
    }
}
