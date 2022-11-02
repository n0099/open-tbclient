package com.kwad.sdk.core.request.model;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.sapi2.activity.BaseActivity;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ba;
import com.kwad.sdk.utils.j;
import com.kwad.sdk.utils.r;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class a implements com.kwad.sdk.core.b {
    public static JSONObject acl;
    public String acm;
    public String appId;
    public String name;
    public String packageName;
    public String version;

    public static boolean j(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        String optString = jSONObject.optString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
        String optString2 = jSONObject.optString("name");
        return !TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString) && optString.equals(((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).getAppId()) && optString2.equals(((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).getAppName());
    }

    public static JSONObject uM() {
        if (!j(acl)) {
            acl = uN().toJson();
        }
        return acl;
    }

    public static a uN() {
        a aVar = new a();
        com.kwad.sdk.service.kwai.d dVar = (com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class);
        aVar.appId = dVar.getAppId();
        aVar.name = dVar.getAppName();
        Context context = dVar.getContext();
        if (context != null) {
            aVar.packageName = context.getPackageName();
            aVar.version = j.cb(context);
        }
        aVar.acm = com.kwad.sdk.utils.e.bR(context);
        if (!TextUtils.isEmpty(ba.getAppId())) {
            aVar.appId = ba.getAppId();
        }
        if (!TextUtils.isEmpty(ba.getPackageName())) {
            aVar.packageName = ba.getPackageName();
        }
        return aVar;
    }

    @Override // com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        r.putValue(jSONObject, BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.appId);
        r.putValue(jSONObject, "name", this.name);
        r.putValue(jSONObject, "packageName", this.packageName);
        r.putValue(jSONObject, "version", this.version);
        r.putValue(jSONObject, "sha1", this.acm);
        return jSONObject;
    }
}
