package com.kwad.sdk.core.g.a;

import android.content.Context;
import com.baidu.sapi2.activity.BaseActivity;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.utils.ah;
import com.kwad.sdk.utils.o;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b implements com.kwad.sdk.core.b {

    /* renamed from: a  reason: collision with root package name */
    public String f33922a;

    /* renamed from: b  reason: collision with root package name */
    public String f33923b;

    /* renamed from: c  reason: collision with root package name */
    public String f33924c;

    /* renamed from: d  reason: collision with root package name */
    public String f33925d;

    public static b a() {
        b bVar = new b();
        bVar.f33922a = KsAdSDKImpl.get().getAppId();
        bVar.f33923b = KsAdSDKImpl.get().getAppName();
        Context context = KsAdSDKImpl.get().getContext();
        if (context != null) {
            bVar.f33924c = context.getPackageName();
            bVar.f33925d = ah.l(context);
        }
        return bVar;
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.f33922a);
        o.a(jSONObject, "name", this.f33923b);
        o.a(jSONObject, "packageName", this.f33924c);
        o.a(jSONObject, "version", this.f33925d);
        return jSONObject;
    }
}
