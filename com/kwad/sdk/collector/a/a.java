package com.kwad.sdk.collector.a;

import com.heytap.mcssdk.mode.CommandMessage;
import com.kwad.sdk.core.network.d;
import com.kwad.sdk.utils.o;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a extends d {

    /* renamed from: b  reason: collision with root package name */
    private C1086a f8559b;

    /* renamed from: com.kwad.sdk.collector.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    static class C1086a {

        /* renamed from: a  reason: collision with root package name */
        private List<String> f8560a;

        public C1086a(List<String> list) {
            this.f8560a = list;
        }

        public JSONObject a() {
            JSONObject jSONObject = new JSONObject();
            o.a(jSONObject, "packageName", this.f8560a);
            return jSONObject;
        }
    }

    public a(List<String> list) {
        this.f8559b = new C1086a(list);
        a("targetAppInfo", this.f8559b.a());
        b(CommandMessage.SDK_VERSION, "3.3.9");
        a("sdkVersionCode", 3030900);
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public String a() {
        return com.kwad.sdk.d.t();
    }
}
