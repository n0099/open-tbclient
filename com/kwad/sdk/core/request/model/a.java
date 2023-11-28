package com.kwad.sdk.core.request.model;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.sapi2.activity.BaseActivity;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bj;
import com.kwad.sdk.utils.k;
import com.kwad.sdk.utils.t;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class a implements com.kwad.sdk.core.b {
    public static JSONObject axZ;
    public String appId;
    public String aya;
    public String name;
    public String packageName;
    public String version;

    @Override // com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
    }

    public static JSONObject DP() {
        if (!l(axZ)) {
            axZ = DQ().toJson();
        }
        return axZ;
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        t.putValue(jSONObject, BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.appId);
        t.putValue(jSONObject, "name", this.name);
        t.putValue(jSONObject, "packageName", this.packageName);
        t.putValue(jSONObject, "version", this.version);
        t.putValue(jSONObject, "sha1", this.aya);
        return jSONObject;
    }

    public static a DQ() {
        a aVar = new a();
        aVar.appId = ServiceProvider.Jo().appId;
        aVar.name = ServiceProvider.Jo().appName;
        aVar.packageName = ServiceProvider.Jn().getPackageName();
        aVar.version = k.bQ(ServiceProvider.Jn());
        aVar.aya = com.kwad.sdk.utils.e.bG(ServiceProvider.Jn());
        if (!TextUtils.isEmpty(bj.getAppId())) {
            aVar.appId = bj.getAppId();
        }
        if (!TextUtils.isEmpty(bj.getPackageName())) {
            aVar.packageName = bj.getPackageName();
        }
        return aVar;
    }

    public static boolean l(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        String optString = jSONObject.optString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
        String optString2 = jSONObject.optString("name");
        if (TextUtils.isEmpty(optString2) || TextUtils.isEmpty(optString) || !optString.equals(ServiceProvider.Jo().appId) || !optString2.equals(ServiceProvider.Jo().appName)) {
            return false;
        }
        return true;
    }
}
