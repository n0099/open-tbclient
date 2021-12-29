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
    public String f58345b;

    /* renamed from: c  reason: collision with root package name */
    public String f58346c;

    /* renamed from: d  reason: collision with root package name */
    public String f58347d;

    /* renamed from: e  reason: collision with root package name */
    public String f58348e;

    /* renamed from: f  reason: collision with root package name */
    public String f58349f;

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
        bVar.f58345b = KsAdSDKImpl.get().getAppId();
        bVar.f58346c = KsAdSDKImpl.get().getAppName();
        Context context = KsAdSDKImpl.get().getContext();
        if (context != null) {
            bVar.f58347d = context.getPackageName();
            bVar.f58348e = av.w(context);
        }
        bVar.f58349f = com.kwad.sdk.utils.g.a(context);
        return bVar;
    }

    @Override // com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        t.a(jSONObject, BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.f58345b);
        t.a(jSONObject, "name", this.f58346c);
        t.a(jSONObject, "packageName", this.f58347d);
        t.a(jSONObject, "version", this.f58348e);
        t.a(jSONObject, "sha1", this.f58349f);
        return jSONObject;
    }
}
