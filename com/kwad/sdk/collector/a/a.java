package com.kwad.sdk.collector.a;

import com.heytap.mcssdk.mode.CommandMessage;
import com.kwad.sdk.core.network.d;
import com.kwad.sdk.utils.o;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a extends d {

    /* renamed from: b  reason: collision with root package name */
    public C0377a f32260b;

    /* renamed from: com.kwad.sdk.collector.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0377a {

        /* renamed from: a  reason: collision with root package name */
        public List<String> f32261a;

        public C0377a(List<String> list) {
            this.f32261a = list;
        }

        public JSONObject a() {
            JSONObject jSONObject = new JSONObject();
            o.a(jSONObject, "packageName", this.f32261a);
            return jSONObject;
        }
    }

    public a(List<String> list) {
        C0377a c0377a = new C0377a(list);
        this.f32260b = c0377a;
        a("targetAppInfo", c0377a.a());
        b(CommandMessage.SDK_VERSION, "3.3.9");
        a("sdkVersionCode", 3030900);
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public String a() {
        return com.kwad.sdk.d.t();
    }
}
