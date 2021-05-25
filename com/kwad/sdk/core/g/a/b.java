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
    public static JSONObject f32223a;

    /* renamed from: b  reason: collision with root package name */
    public String f32224b;

    /* renamed from: c  reason: collision with root package name */
    public String f32225c;

    /* renamed from: d  reason: collision with root package name */
    public String f32226d;

    /* renamed from: e  reason: collision with root package name */
    public String f32227e;

    public static JSONObject a() {
        if (f32223a == null) {
            f32223a = b().toJson();
        }
        return f32223a;
    }

    public static b b() {
        b bVar = new b();
        bVar.f32224b = KsAdSDKImpl.get().getAppId();
        bVar.f32225c = KsAdSDKImpl.get().getAppName();
        Context context = KsAdSDKImpl.get().getContext();
        if (context != null) {
            bVar.f32226d = context.getPackageName();
            bVar.f32227e = ai.n(context);
        }
        return bVar;
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.f32224b);
        o.a(jSONObject, "name", this.f32225c);
        o.a(jSONObject, "packageName", this.f32226d);
        o.a(jSONObject, "version", this.f32227e);
        return jSONObject;
    }
}
