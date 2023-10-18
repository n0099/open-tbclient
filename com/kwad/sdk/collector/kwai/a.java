package com.kwad.sdk.collector.kwai;

import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.core.network.d;
import com.kwad.sdk.utils.r;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class a extends d {
    public C0648a SS;

    /* renamed from: com.kwad.sdk.collector.kwai.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0648a {
        public List<String> ST;

        public C0648a(List<String> list) {
            this.ST = list;
        }

        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            r.putValue(jSONObject, "packageName", this.ST);
            return jSONObject;
        }
    }

    public a(List<String> list) {
        C0648a c0648a = new C0648a(list);
        this.SS = c0648a;
        putBody("targetAppInfo", c0648a.toJson());
        putBody(com.heytap.mcssdk.constant.b.C, BuildConfig.VERSION_NAME);
        putBody("sdkVersionCode", BuildConfig.VERSION_CODE);
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public final String getUrl() {
        return com.kwad.sdk.b.qS();
    }
}
