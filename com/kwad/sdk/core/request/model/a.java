package com.kwad.sdk.core.request.model;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.sapi2.activity.BaseActivity;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aw;
import com.kwad.sdk.utils.j;
import com.kwad.sdk.utils.r;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class a implements com.kwad.sdk.core.b {
    public static JSONObject a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;

    public static JSONObject a() {
        if (!a(a)) {
            a = b().toJson();
        }
        return a;
    }

    public static boolean a(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        String optString = jSONObject.optString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
        String optString2 = jSONObject.optString("name");
        return !TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString) && optString.equals(((com.kwad.sdk.service.kwai.d) ServiceProvider.a(com.kwad.sdk.service.kwai.d.class)).b()) && optString2.equals(((com.kwad.sdk.service.kwai.d) ServiceProvider.a(com.kwad.sdk.service.kwai.d.class)).c());
    }

    public static a b() {
        a aVar = new a();
        com.kwad.sdk.service.kwai.d dVar = (com.kwad.sdk.service.kwai.d) ServiceProvider.a(com.kwad.sdk.service.kwai.d.class);
        aVar.b = dVar.b();
        aVar.c = dVar.c();
        Context a2 = dVar.a();
        if (a2 != null) {
            aVar.d = a2.getPackageName();
            aVar.e = j.a(a2);
        }
        aVar.f = com.kwad.sdk.utils.e.a(a2);
        if (!TextUtils.isEmpty(aw.a())) {
            aVar.b = aw.a();
        }
        if (!TextUtils.isEmpty(aw.b())) {
            aVar.d = aw.b();
        }
        return aVar;
    }

    @Override // com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        r.a(jSONObject, BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.b);
        r.a(jSONObject, "name", this.c);
        r.a(jSONObject, "packageName", this.d);
        r.a(jSONObject, "version", this.e);
        r.a(jSONObject, "sha1", this.f);
        return jSONObject;
    }
}
