package com.kwad.sdk.reward;

import androidx.annotation.Nullable;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ag;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class f {

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public boolean f34602a;

        /* renamed from: b  reason: collision with root package name */
        public String f34603b;

        public a(String str) {
            JSONObject jSONObject;
            this.f34603b = "-";
            try {
                jSONObject = new JSONObject(str);
            } catch (Throwable th) {
                th.printStackTrace();
                this.f34602a = false;
                this.f34603b = "数据解析失败";
                jSONObject = null;
            }
            a(jSONObject);
        }

        public void a(@Nullable JSONObject jSONObject) {
            if (jSONObject != null) {
                this.f34602a = jSONObject.optBoolean("isValid");
                this.f34603b = jSONObject.toString();
            }
        }

        public boolean a() {
            return this.f34602a;
        }
    }

    public static void a(final AdTemplate adTemplate, AdInfo adInfo) {
        final String ab = com.kwad.sdk.core.response.b.a.ab(adInfo);
        com.kwad.sdk.core.d.a.a("ServerCallbackHandle", "handleRewardVerify callbackUrl: " + ab);
        if (ag.a(ab)) {
            return;
        }
        com.kwad.sdk.utils.f.a(new Runnable() { // from class: com.kwad.sdk.reward.f.1
            private void a() {
                com.kwad.sdk.core.report.e.b(adTemplate, 0, "success");
            }

            private void a(String str) {
                com.kwad.sdk.core.report.e.b(adTemplate, 1, str);
            }

            @Override // java.lang.Runnable
            public void run() {
                String str;
                try {
                    com.kwad.sdk.core.network.c doGet = KsAdSDKImpl.get().getProxyForHttp().doGet(ab, null);
                    if (doGet == null) {
                        str = "Network Error: url invalid";
                    } else if (doGet.f33218a == 200) {
                        a aVar = new a(doGet.f33219b);
                        if (aVar.a()) {
                            a();
                            return;
                        }
                        str = aVar.f34603b;
                    } else {
                        str = "Network Error: " + doGet.f33219b;
                    }
                    a(str);
                } catch (Throwable th) {
                    a("Request Error: " + th.getMessage());
                }
            }
        });
    }
}
