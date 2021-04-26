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
    public static JSONObject f33049a;

    /* renamed from: b  reason: collision with root package name */
    public String f33050b;

    /* renamed from: c  reason: collision with root package name */
    public String f33051c;

    /* renamed from: d  reason: collision with root package name */
    public String f33052d;

    /* renamed from: e  reason: collision with root package name */
    public String f33053e;

    public static JSONObject a() {
        if (f33049a == null) {
            f33049a = b().toJson();
        }
        return f33049a;
    }

    public static b b() {
        b bVar = new b();
        bVar.f33050b = KsAdSDKImpl.get().getAppId();
        bVar.f33051c = KsAdSDKImpl.get().getAppName();
        Context context = KsAdSDKImpl.get().getContext();
        if (context != null) {
            bVar.f33052d = context.getPackageName();
            bVar.f33053e = ai.n(context);
        }
        return bVar;
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.f33050b);
        o.a(jSONObject, "name", this.f33051c);
        o.a(jSONObject, "packageName", this.f33052d);
        o.a(jSONObject, "version", this.f33053e);
        return jSONObject;
    }
}
