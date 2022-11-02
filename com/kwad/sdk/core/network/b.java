package com.kwad.sdk.core.network;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.sapi2.activity.BaseActivity;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ba;
import com.kwad.sdk.utils.r;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public abstract class b implements g {
    public final Map<String, String> mHeader = new HashMap();
    public final JSONObject mBodyParams = new JSONObject();

    public b() {
        buildBaseHeader();
        buildBaseBody();
        if (encryptDisable()) {
            addHeader("x-ksad-ignore-decrypt", "true");
        }
        addHeader("cookie", e.ty().tz());
        com.kwad.sdk.core.a.d.c(getHeader());
        addHeader("User-Agent", o.getUserAgent());
        addHeader("BrowserUa", o.tD());
        addHeader("SystemUa", o.tC());
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
        com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
        return false;
    }

    @Override // com.kwad.sdk.core.network.g
    public JSONObject getBody() {
        if (encryptDisable()) {
            return this.mBodyParams;
        }
        JSONObject jSONObject = new JSONObject();
        com.kwad.sdk.service.kwai.d dVar = (com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class);
        r.putValue(jSONObject, "version", dVar.getSDKVersion());
        r.putValue(jSONObject, BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, !TextUtils.isEmpty(ba.getAppId()) ? ba.getAppId() : dVar.getAppId());
        r.putValue(jSONObject, "message", com.kwad.sdk.core.a.d.bM(this.mBodyParams.toString()));
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
        return com.kwad.sdk.b.qJ();
    }

    @Override // com.kwad.sdk.core.network.g
    @Nullable
    public SceneImpl getScene() {
        return null;
    }

    @Override // com.kwad.sdk.core.network.g
    public abstract String getUrl();

    public void putBody(String str, byte b) {
        r.putValue(this.mBodyParams, str, b);
    }

    public void putBody(String str, double d) {
        r.putValue(this.mBodyParams, str, d);
    }

    public void putBody(String str, float f) {
        r.putValue(this.mBodyParams, str, f);
    }

    public void putBody(String str, int i) {
        r.putValue(this.mBodyParams, str, i);
    }

    public void putBody(String str, long j) {
        r.putValue(this.mBodyParams, str, j);
    }

    public void putBody(String str, com.kwad.sdk.core.b bVar) {
        r.a(this.mBodyParams, str, bVar);
    }

    public void putBody(String str, String str2) {
        r.putValue(this.mBodyParams, str, str2);
    }

    public void putBody(String str, List<? extends com.kwad.sdk.core.b> list) {
        r.putValue(this.mBodyParams, str, list);
    }

    public void putBody(String str, JSONArray jSONArray) {
        r.putValue(this.mBodyParams, str, jSONArray);
    }

    public void putBody(String str, JSONObject jSONObject) {
        r.putValue(this.mBodyParams, str, jSONObject);
    }

    public void putBody(String str, boolean z) {
        r.putValue(this.mBodyParams, str, z);
    }
}
