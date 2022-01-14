package com.kwad.sdk.core.network;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.sapi2.activity.BaseActivity;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.plugin.DevelopMangerPlugin;
import com.kwad.sdk.utils.t;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class b implements g {

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, String> f55890b = new HashMap();
    public final JSONObject a = new JSONObject();

    public b() {
        g();
        h();
        DevelopMangerPlugin.DevelopValue a = ((DevelopMangerPlugin) com.kwad.sdk.plugin.f.a(DevelopMangerPlugin.class)).a("KEY_HOST_ENCRYPT_DISABLE");
        if (a != null && ((Boolean) a.getValue()).booleanValue()) {
            a("x-ksad-ignore-decrypt", String.valueOf(true));
        }
        String b2 = e.a().b();
        if (!TextUtils.isEmpty(b2)) {
            a("cookie", b2);
        }
        com.kwad.sdk.core.a.d.a(c());
    }

    @Override // com.kwad.sdk.core.network.g
    public abstract String a();

    public void a(String str, double d2) {
        t.a(this.a, str, d2);
    }

    public void a(String str, int i2) {
        t.a(this.a, str, i2);
    }

    public void a(String str, long j2) {
        t.a(this.a, str, j2);
    }

    public void a(String str, com.kwad.sdk.core.b bVar) {
        t.a(this.a, str, bVar);
    }

    public void a(String str, String str2) {
        this.f55890b.put(str, str2);
    }

    public void a(String str, List<? extends com.kwad.sdk.core.b> list) {
        t.a(this.a, str, list);
    }

    public void a(String str, JSONArray jSONArray) {
        t.a(this.a, str, jSONArray);
    }

    public void a(String str, JSONObject jSONObject) {
        t.a(this.a, str, jSONObject);
    }

    public void a(String str, boolean z) {
        t.a(this.a, str, z);
    }

    @Override // com.kwad.sdk.core.network.g
    @Nullable
    public SceneImpl b() {
        return null;
    }

    public void b(String str, String str2) {
        t.a(this.a, str, str2);
    }

    @Override // com.kwad.sdk.core.network.g
    public Map<String, String> c() {
        return this.f55890b;
    }

    @Override // com.kwad.sdk.core.network.g
    public Map<String, String> d() {
        return null;
    }

    @Override // com.kwad.sdk.core.network.g
    public JSONObject e() {
        DevelopMangerPlugin.DevelopValue a = ((DevelopMangerPlugin) com.kwad.sdk.plugin.f.a(DevelopMangerPlugin.class)).a("KEY_HOST_ENCRYPT_DISABLE");
        if (a == null || !((Boolean) a.getValue()).booleanValue()) {
            JSONObject jSONObject = new JSONObject();
            t.a(jSONObject, "version", KsAdSDKImpl.get().getSDKVersion());
            t.a(jSONObject, BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, KsAdSDKImpl.get().getAppId());
            t.a(jSONObject, "message", com.kwad.sdk.core.a.d.a(this.a.toString()));
            com.kwad.sdk.core.a.d.a(a().replace(f(), ""), c(), jSONObject.toString());
            return jSONObject;
        }
        return this.a;
    }

    public String f() {
        return com.kwad.sdk.d.a();
    }

    public abstract void g();

    public abstract void h();
}
