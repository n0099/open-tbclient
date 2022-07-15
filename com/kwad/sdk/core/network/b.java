package com.kwad.sdk.core.network;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.sapi2.activity.BaseActivity;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aw;
import com.kwad.sdk.utils.r;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public abstract class b implements g {
    public final Map<String, String> mHeader = new HashMap();
    public final JSONObject mBodyParams = new JSONObject();

    public b() {
        buildBaseHeader();
        buildBaseBody();
        if (encryptDisable()) {
            addHeader("x-ksad-ignore-decrypt", "true");
        }
        addHeader("cookie", e.a().b());
        com.kwad.sdk.core.a.d.a(getHeader());
        addHeader("User-Agent", n.c());
        addHeader("BrowserUa", n.d());
        addHeader("SystemUa", n.a());
    }

    public void addHeader(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.mHeader.put(str, str2);
    }

    public abstract void buildBaseBody();

    public abstract void buildBaseHeader();

    public boolean encryptDisable() {
        com.kwad.sdk.components.c.a(DevelopMangerComponents.class);
        return false;
    }

    @Override // com.kwad.sdk.core.network.g
    public JSONObject getBody() {
        if (encryptDisable()) {
            return this.mBodyParams;
        }
        JSONObject jSONObject = new JSONObject();
        com.kwad.sdk.service.kwai.d dVar = (com.kwad.sdk.service.kwai.d) ServiceProvider.a(com.kwad.sdk.service.kwai.d.class);
        r.a(jSONObject, "version", dVar.i());
        r.a(jSONObject, BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, !TextUtils.isEmpty(aw.a()) ? aw.a() : dVar.b());
        r.a(jSONObject, "message", com.kwad.sdk.core.a.d.a(this.mBodyParams.toString()));
        com.kwad.sdk.core.a.d.a(getUrl(), getHeader(), jSONObject.toString());
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.network.g
    public Map<String, String> getBodyMap() {
        return null;
    }

    @Override // com.kwad.sdk.core.network.g
    public Map<String, String> getHeader() {
        return this.mHeader;
    }

    public String getRequestHost() {
        return com.kwad.sdk.b.a();
    }

    @Nullable
    public SceneImpl getScene() {
        return null;
    }

    @Override // com.kwad.sdk.core.network.g
    public abstract String getUrl();

    public void putBody(String str, byte b) {
        r.a(this.mBodyParams, str, b);
    }

    public void putBody(String str, double d) {
        r.a(this.mBodyParams, str, d);
    }

    public void putBody(String str, float f) {
        r.a(this.mBodyParams, str, f);
    }

    public void putBody(String str, int i) {
        r.a(this.mBodyParams, str, i);
    }

    public void putBody(String str, long j) {
        r.a(this.mBodyParams, str, j);
    }

    public void putBody(String str, com.kwad.sdk.core.b bVar) {
        r.a(this.mBodyParams, str, bVar);
    }

    public void putBody(String str, String str2) {
        r.a(this.mBodyParams, str, str2);
    }

    public void putBody(String str, List<? extends com.kwad.sdk.core.b> list) {
        r.a(this.mBodyParams, str, list);
    }

    public void putBody(String str, JSONArray jSONArray) {
        r.a(this.mBodyParams, str, jSONArray);
    }

    public void putBody(String str, JSONObject jSONObject) {
        r.a(this.mBodyParams, str, jSONObject);
    }

    public void putBody(String str, boolean z) {
        r.a(this.mBodyParams, str, z);
    }
}
