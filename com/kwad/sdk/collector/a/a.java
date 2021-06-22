package com.kwad.sdk.collector.a;

import com.heytap.mcssdk.mode.CommandMessage;
import com.kwad.sdk.core.network.d;
import com.kwad.sdk.utils.o;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a extends d {

    /* renamed from: b  reason: collision with root package name */
    public C0363a f32521b;

    /* renamed from: com.kwad.sdk.collector.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0363a {

        /* renamed from: a  reason: collision with root package name */
        public List<String> f32522a;

        public C0363a(List<String> list) {
            this.f32522a = list;
        }

        public JSONObject a() {
            JSONObject jSONObject = new JSONObject();
            o.a(jSONObject, "packageName", this.f32522a);
            return jSONObject;
        }
    }

    public a(List<String> list) {
        C0363a c0363a = new C0363a(list);
        this.f32521b = c0363a;
        a("targetAppInfo", c0363a.a());
        b(CommandMessage.SDK_VERSION, "3.3.9");
        a("sdkVersionCode", 3030900);
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public String a() {
        return com.kwad.sdk.d.t();
    }
}
