package com.kwad.sdk.core.g.a;

import android.content.Context;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.swan.gamecenter.appmanager.install.InstallAntiBlockingActivity;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.utils.ah;
import com.kwad.sdk.utils.o;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b implements com.kwad.sdk.core.b {

    /* renamed from: a  reason: collision with root package name */
    public String f33632a;

    /* renamed from: b  reason: collision with root package name */
    public String f33633b;

    /* renamed from: c  reason: collision with root package name */
    public String f33634c;

    /* renamed from: d  reason: collision with root package name */
    public String f33635d;

    public static b a() {
        b bVar = new b();
        bVar.f33632a = KsAdSDKImpl.get().getAppId();
        bVar.f33633b = KsAdSDKImpl.get().getAppName();
        Context context = KsAdSDKImpl.get().getContext();
        if (context != null) {
            bVar.f33634c = context.getPackageName();
            bVar.f33635d = ah.l(context);
        }
        return bVar;
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.f33632a);
        o.a(jSONObject, "name", this.f33633b);
        o.a(jSONObject, InstallAntiBlockingActivity.PARAM_PACKAGE_NAME, this.f33634c);
        o.a(jSONObject, "version", this.f33635d);
        return jSONObject;
    }
}
