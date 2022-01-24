package com.kwad.sdk.core.request.model;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.sapi2.activity.BaseActivity;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.utils.av;
import com.kwad.sdk.utils.t;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b implements com.kwad.sdk.core.b {
    public static JSONObject a;

    /* renamed from: b  reason: collision with root package name */
    public String f56188b;

    /* renamed from: c  reason: collision with root package name */
    public String f56189c;

    /* renamed from: d  reason: collision with root package name */
    public String f56190d;

    /* renamed from: e  reason: collision with root package name */
    public String f56191e;

    /* renamed from: f  reason: collision with root package name */
    public String f56192f;

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
        return !TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString) && optString.equals(KsAdSDKImpl.get().getAppId()) && optString2.equals(KsAdSDKImpl.get().getAppName());
    }

    public static b b() {
        b bVar = new b();
        bVar.f56188b = KsAdSDKImpl.get().getAppId();
        bVar.f56189c = KsAdSDKImpl.get().getAppName();
        Context context = KsAdSDKImpl.get().getContext();
        if (context != null) {
            bVar.f56190d = context.getPackageName();
            bVar.f56191e = av.w(context);
        }
        bVar.f56192f = com.kwad.sdk.utils.g.a(context);
        return bVar;
    }

    @Override // com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        t.a(jSONObject, BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.f56188b);
        t.a(jSONObject, "name", this.f56189c);
        t.a(jSONObject, "packageName", this.f56190d);
        t.a(jSONObject, "version", this.f56191e);
        t.a(jSONObject, "sha1", this.f56192f);
        return jSONObject;
    }
}
