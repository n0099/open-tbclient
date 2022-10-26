package com.kwad.sdk.collector.kwai;

import com.heytap.mcssdk.mode.CommandMessage;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.core.network.d;
import com.kwad.sdk.utils.r;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class a extends d {
    public C0595a SS;

    /* renamed from: com.kwad.sdk.collector.kwai.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public final class C0595a {
        public List ST;

        public C0595a(List list) {
            this.ST = list;
        }

        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            r.putValue(jSONObject, "packageName", this.ST);
            return jSONObject;
        }
    }

    public a(List list) {
        C0595a c0595a = new C0595a(list);
        this.SS = c0595a;
        putBody("targetAppInfo", c0595a.toJson());
        putBody(CommandMessage.SDK_VERSION, BuildConfig.VERSION_NAME);
        putBody("sdkVersionCode", BuildConfig.VERSION_CODE);
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public final String getUrl() {
        return com.kwad.sdk.b.qS();
    }
}
