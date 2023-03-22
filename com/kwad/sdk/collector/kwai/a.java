package com.kwad.sdk.collector.kwai;

import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.core.network.d;
import com.kwad.sdk.utils.r;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class a extends d {
    public C0622a SS;

    /* renamed from: com.kwad.sdk.collector.kwai.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0622a {
        public List<String> ST;

        public C0622a(List<String> list) {
            this.ST = list;
        }

        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            r.putValue(jSONObject, "packageName", this.ST);
            return jSONObject;
        }
    }

    public a(List<String> list) {
        C0622a c0622a = new C0622a(list);
        this.SS = c0622a;
        putBody("targetAppInfo", c0622a.toJson());
        putBody(com.heytap.mcssdk.constant.b.C, BuildConfig.VERSION_NAME);
        putBody("sdkVersionCode", BuildConfig.VERSION_CODE);
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public final String getUrl() {
        return com.kwad.sdk.b.qS();
    }
}
