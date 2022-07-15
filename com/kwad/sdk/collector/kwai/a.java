package com.kwad.sdk.collector.kwai;

import com.heytap.mcssdk.mode.CommandMessage;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.core.network.d;
import com.kwad.sdk.utils.r;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class a extends d {
    public C0535a a;

    /* renamed from: com.kwad.sdk.collector.kwai.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0535a {
        public List<String> a;

        public C0535a(List<String> list) {
            this.a = list;
        }

        public final JSONObject a() {
            JSONObject jSONObject = new JSONObject();
            r.a(jSONObject, "packageName", this.a);
            return jSONObject;
        }
    }

    public a(List<String> list) {
        C0535a c0535a = new C0535a(list);
        this.a = c0535a;
        putBody("targetAppInfo", c0535a.a());
        putBody(CommandMessage.SDK_VERSION, BuildConfig.VERSION_NAME);
        putBody("sdkVersionCode", BuildConfig.VERSION_CODE);
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public final String getUrl() {
        return com.kwad.sdk.b.k();
    }
}
