package com.kwad.sdk.collector.b;

import com.heytap.mcssdk.mode.CommandMessage;
import com.kwad.sdk.core.network.d;
import com.kwad.sdk.utils.o;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a extends d {

    /* renamed from: c  reason: collision with root package name */
    public C0355a f31952c;

    /* renamed from: com.kwad.sdk.collector.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0355a {

        /* renamed from: a  reason: collision with root package name */
        public List<String> f31953a;

        public C0355a(List<String> list) {
            this.f31953a = list;
        }

        public JSONObject a() {
            JSONObject jSONObject = new JSONObject();
            o.a(jSONObject, "packageName", this.f31953a);
            return jSONObject;
        }
    }

    public a(List<String> list) {
        C0355a c0355a = new C0355a(list);
        this.f31952c = c0355a;
        a("targetAppInfo", c0355a.a());
        b(CommandMessage.SDK_VERSION, "3.3.8.3");
        a("sdkVersionCode", 3030803);
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public String a() {
        return com.kwad.sdk.d.g();
    }
}
