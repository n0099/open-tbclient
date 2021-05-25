package com.kwad.sdk.collector.b;

import com.heytap.mcssdk.mode.CommandMessage;
import com.kwad.sdk.core.network.d;
import com.kwad.sdk.utils.o;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a extends d {

    /* renamed from: c  reason: collision with root package name */
    public C0356a f31881c;

    /* renamed from: com.kwad.sdk.collector.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0356a {

        /* renamed from: a  reason: collision with root package name */
        public List<String> f31882a;

        public C0356a(List<String> list) {
            this.f31882a = list;
        }

        public JSONObject a() {
            JSONObject jSONObject = new JSONObject();
            o.a(jSONObject, "packageName", this.f31882a);
            return jSONObject;
        }
    }

    public a(List<String> list) {
        C0356a c0356a = new C0356a(list);
        this.f31881c = c0356a;
        a("targetAppInfo", c0356a.a());
        b(CommandMessage.SDK_VERSION, "3.3.8.3");
        a("sdkVersionCode", 3030803);
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public String a() {
        return com.kwad.sdk.d.g();
    }
}
