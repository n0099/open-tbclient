package com.kwad.sdk.core.network;

import android.text.TextUtils;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.plugin.DevelopMangerPlugin;
import com.kwad.sdk.utils.o;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public abstract class b implements g {

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, String> f9617b = new HashMap();

    /* renamed from: a  reason: collision with root package name */
    protected final JSONObject f9616a = new JSONObject();

    /* JADX INFO: Access modifiers changed from: protected */
    public b() {
        e();
        f();
        DevelopMangerPlugin.DevelopValue a2 = ((DevelopMangerPlugin) com.kwad.sdk.plugin.g.a(DevelopMangerPlugin.class)).a("KEY_HOST_ENCRYPT_DISABLE");
        if (a2 != null && ((Boolean) a2.getValue()).booleanValue()) {
            a("x-ksad-ignore-decrypt", String.valueOf(true));
        }
        String b2 = e.a().b();
        if (!TextUtils.isEmpty(b2)) {
            a("cookie", b2);
        }
        com.kwad.sdk.core.b.d.a(b());
    }

    @Override // com.kwad.sdk.core.network.g
    public abstract String a();

    public void a(String str, int i) {
        o.a(this.f9616a, str, i);
    }

    public void a(String str, long j) {
        o.a(this.f9616a, str, j);
    }

    public void a(String str, com.kwad.sdk.core.b bVar) {
        o.a(this.f9616a, str, bVar);
    }

    public void a(String str, String str2) {
        this.f9617b.put(str, str2);
    }

    public void a(String str, List<? extends com.kwad.sdk.core.b> list) {
        o.a(this.f9616a, str, list);
    }

    public void a(String str, JSONArray jSONArray) {
        o.a(this.f9616a, str, jSONArray);
    }

    public void a(String str, JSONObject jSONObject) {
        o.a(this.f9616a, str, jSONObject);
    }

    public void a(String str, boolean z) {
        o.a(this.f9616a, str, z);
    }

    @Override // com.kwad.sdk.core.network.g
    public Map<String, String> b() {
        return this.f9617b;
    }

    public void b(String str, String str2) {
        o.a(this.f9616a, str, str2);
    }

    @Override // com.kwad.sdk.core.network.g
    public Map<String, String> c() {
        return null;
    }

    @Override // com.kwad.sdk.core.network.g
    public JSONObject d() {
        DevelopMangerPlugin.DevelopValue a2 = ((DevelopMangerPlugin) com.kwad.sdk.plugin.g.a(DevelopMangerPlugin.class)).a("KEY_HOST_ENCRYPT_DISABLE");
        if (a2 == null || !((Boolean) a2.getValue()).booleanValue()) {
            JSONObject jSONObject = new JSONObject();
            o.a(jSONObject, "version", KsAdSDKImpl.get().getSDKVersion());
            o.a(jSONObject, "appId", KsAdSDKImpl.get().getAppId());
            o.a(jSONObject, "message", com.kwad.sdk.core.b.d.a(this.f9616a.toString()));
            com.kwad.sdk.core.b.d.a(a().replace(com.kwad.sdk.d.a(), ""), b(), jSONObject);
            return jSONObject;
        }
        return this.f9616a;
    }

    protected abstract void e();

    protected abstract void f();
}
