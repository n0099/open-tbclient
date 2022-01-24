package com.kwad.sdk.collector.a;

import com.heytap.mcssdk.mode.CommandMessage;
import com.kwad.sdk.core.network.d;
import com.kwad.sdk.utils.t;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends d {

    /* renamed from: b  reason: collision with root package name */
    public C2097a f55528b;

    /* renamed from: com.kwad.sdk.collector.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C2097a {
        public List<String> a;

        public C2097a(List<String> list) {
            this.a = list;
        }

        public JSONObject a() {
            JSONObject jSONObject = new JSONObject();
            t.a(jSONObject, "packageName", this.a);
            return jSONObject;
        }
    }

    public a(List<String> list) {
        C2097a c2097a = new C2097a(list);
        this.f55528b = c2097a;
        a("targetAppInfo", c2097a.a());
        b(CommandMessage.SDK_VERSION, "3.3.17.4");
        a("sdkVersionCode", 3031704);
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public String a() {
        return com.kwad.sdk.d.l();
    }
}
