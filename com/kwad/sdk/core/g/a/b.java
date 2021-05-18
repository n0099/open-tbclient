package com.kwad.sdk.core.g.a;

import android.content.Context;
import com.baidu.sapi2.activity.BaseActivity;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.utils.o;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b implements com.kwad.sdk.core.b {

    /* renamed from: a  reason: collision with root package name */
    public static JSONObject f32294a;

    /* renamed from: b  reason: collision with root package name */
    public String f32295b;

    /* renamed from: c  reason: collision with root package name */
    public String f32296c;

    /* renamed from: d  reason: collision with root package name */
    public String f32297d;

    /* renamed from: e  reason: collision with root package name */
    public String f32298e;

    public static JSONObject a() {
        if (f32294a == null) {
            f32294a = b().toJson();
        }
        return f32294a;
    }

    public static b b() {
        b bVar = new b();
        bVar.f32295b = KsAdSDKImpl.get().getAppId();
        bVar.f32296c = KsAdSDKImpl.get().getAppName();
        Context context = KsAdSDKImpl.get().getContext();
        if (context != null) {
            bVar.f32297d = context.getPackageName();
            bVar.f32298e = ai.n(context);
        }
        return bVar;
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.f32295b);
        o.a(jSONObject, "name", this.f32296c);
        o.a(jSONObject, "packageName", this.f32297d);
        o.a(jSONObject, "version", this.f32298e);
        return jSONObject;
    }
}
