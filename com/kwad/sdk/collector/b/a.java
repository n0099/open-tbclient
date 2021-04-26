package com.kwad.sdk.collector.b;

import com.heytap.mcssdk.mode.CommandMessage;
import com.kwad.sdk.core.network.d;
import com.kwad.sdk.utils.o;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a extends d {

    /* renamed from: c  reason: collision with root package name */
    public C0368a f32707c;

    /* renamed from: com.kwad.sdk.collector.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0368a {

        /* renamed from: a  reason: collision with root package name */
        public List<String> f32708a;

        public C0368a(List<String> list) {
            this.f32708a = list;
        }

        public JSONObject a() {
            JSONObject jSONObject = new JSONObject();
            o.a(jSONObject, "packageName", this.f32708a);
            return jSONObject;
        }
    }

    public a(List<String> list) {
        C0368a c0368a = new C0368a(list);
        this.f32707c = c0368a;
        a("targetAppInfo", c0368a.a());
        b(CommandMessage.SDK_VERSION, "3.3.8.3");
        a("sdkVersionCode", 3030803);
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public String a() {
        return com.kwad.sdk.d.g();
    }
}
