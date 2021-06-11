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
    public String f34258a;

    /* renamed from: b  reason: collision with root package name */
    public String f34259b;

    /* renamed from: c  reason: collision with root package name */
    public String f34260c;

    /* renamed from: d  reason: collision with root package name */
    public String f34261d;

    public static b a() {
        b bVar = new b();
        bVar.f34258a = KsAdSDKImpl.get().getAppId();
        bVar.f34259b = KsAdSDKImpl.get().getAppName();
        Context context = KsAdSDKImpl.get().getContext();
        if (context != null) {
            bVar.f34260c = context.getPackageName();
            bVar.f34261d = ah.l(context);
        }
        return bVar;
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.f34258a);
        o.a(jSONObject, "name", this.f34259b);
        o.a(jSONObject, "packageName", this.f34260c);
        o.a(jSONObject, "version", this.f34261d);
        return jSONObject;
    }
}
