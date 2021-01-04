package com.kwad.sdk.core.g.a;

import android.content.Context;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.utils.ah;
import com.kwad.sdk.utils.o;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class b implements com.kwad.sdk.core.b {

    /* renamed from: a  reason: collision with root package name */
    private String f9456a;

    /* renamed from: b  reason: collision with root package name */
    private String f9457b;
    private String c;
    private String d;

    public static b a() {
        b bVar = new b();
        bVar.f9456a = KsAdSDKImpl.get().getAppId();
        bVar.f9457b = KsAdSDKImpl.get().getAppName();
        Context context = KsAdSDKImpl.get().getContext();
        if (context != null) {
            bVar.c = context.getPackageName();
            bVar.d = ah.l(context);
        }
        return bVar;
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, "appId", this.f9456a);
        o.a(jSONObject, "name", this.f9457b);
        o.a(jSONObject, "packageName", this.c);
        o.a(jSONObject, "version", this.d);
        return jSONObject;
    }
}
