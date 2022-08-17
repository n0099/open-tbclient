package com.kwad.sdk.collector.kwai;

import com.heytap.mcssdk.mode.CommandMessage;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.core.network.d;
import com.kwad.sdk.utils.r;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class a extends d {
    public C0383a SS;

    /* renamed from: com.kwad.sdk.collector.kwai.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0383a {
        public List<String> ST;

        public C0383a(List<String> list) {
            this.ST = list;
        }

        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            r.putValue(jSONObject, "packageName", this.ST);
            return jSONObject;
        }
    }

    public a(List<String> list) {
        C0383a c0383a = new C0383a(list);
        this.SS = c0383a;
        putBody("targetAppInfo", c0383a.toJson());
        putBody(CommandMessage.SDK_VERSION, BuildConfig.VERSION_NAME);
        putBody("sdkVersionCode", BuildConfig.VERSION_CODE);
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public final String getUrl() {
        return com.kwad.sdk.b.qS();
    }
}
