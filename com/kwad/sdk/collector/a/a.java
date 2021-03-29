package com.kwad.sdk.collector.a;

import com.baidu.swan.gamecenter.appmanager.install.InstallAntiBlockingActivity;
import com.heytap.mcssdk.mode.CommandMessage;
import com.kwad.sdk.core.network.d;
import com.kwad.sdk.utils.o;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a extends d {

    /* renamed from: b  reason: collision with root package name */
    public C0360a f31876b;

    /* renamed from: com.kwad.sdk.collector.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0360a {

        /* renamed from: a  reason: collision with root package name */
        public List<String> f31877a;

        public C0360a(List<String> list) {
            this.f31877a = list;
        }

        public JSONObject a() {
            JSONObject jSONObject = new JSONObject();
            o.a(jSONObject, InstallAntiBlockingActivity.PARAM_PACKAGE_NAME, this.f31877a);
            return jSONObject;
        }
    }

    public a(List<String> list) {
        C0360a c0360a = new C0360a(list);
        this.f31876b = c0360a;
        a("targetAppInfo", c0360a.a());
        b(CommandMessage.SDK_VERSION, "3.3.9");
        a("sdkVersionCode", 3030900);
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public String a() {
        return com.kwad.sdk.d.t();
    }
}
