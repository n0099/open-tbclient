package com.kwad.sdk.collector.a;

import com.heytap.mcssdk.mode.CommandMessage;
import com.kwad.sdk.core.network.d;
import com.kwad.sdk.utils.o;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends d {
    private C1092a b;

    /* renamed from: com.kwad.sdk.collector.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    static class C1092a {

        /* renamed from: a  reason: collision with root package name */
        private List<String> f5499a;

        public C1092a(List<String> list) {
            this.f5499a = list;
        }

        public JSONObject a() {
            JSONObject jSONObject = new JSONObject();
            o.a(jSONObject, "packageName", this.f5499a);
            return jSONObject;
        }
    }

    public a(List<String> list) {
        this.b = new C1092a(list);
        a("targetAppInfo", this.b.a());
        b(CommandMessage.SDK_VERSION, "3.3.9");
        a("sdkVersionCode", 3030900);
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public String a() {
        return com.kwad.sdk.d.t();
    }
}
