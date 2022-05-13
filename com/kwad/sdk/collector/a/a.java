package com.kwad.sdk.collector.a;

import com.heytap.mcssdk.mode.CommandMessage;
import com.kwad.sdk.core.network.d;
import com.kwad.sdk.utils.t;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a extends d {
    public C0286a b;

    /* renamed from: com.kwad.sdk.collector.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0286a {
        public List<String> a;

        public C0286a(List<String> list) {
            this.a = list;
        }

        public JSONObject a() {
            JSONObject jSONObject = new JSONObject();
            t.a(jSONObject, "packageName", this.a);
            return jSONObject;
        }
    }

    public a(List<String> list) {
        C0286a c0286a = new C0286a(list);
        this.b = c0286a;
        a("targetAppInfo", c0286a.a());
        b(CommandMessage.SDK_VERSION, "3.3.17.4");
        a("sdkVersionCode", 3031704);
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public String a() {
        return com.kwad.sdk.d.l();
    }
}
