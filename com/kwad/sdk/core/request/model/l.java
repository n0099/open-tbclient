package com.kwad.sdk.core.request.model;

import androidx.annotation.Nullable;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.export.proxy.AdRequestExtentParamsProxy;
import com.kwad.sdk.utils.t;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class l implements com.kwad.sdk.core.b {
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f56228b;

    /* renamed from: c  reason: collision with root package name */
    public String f56229c;

    /* renamed from: d  reason: collision with root package name */
    public String f56230d;

    /* renamed from: e  reason: collision with root package name */
    public String f56231e;

    public static l a() {
        Map<String, String> extentParams;
        l lVar = new l();
        AdRequestExtentParamsProxy requestExtentParamsProxy = KsAdSDKImpl.get().getRequestExtentParamsProxy();
        if (requestExtentParamsProxy != null && (extentParams = requestExtentParamsProxy.getExtentParams()) != null) {
            lVar.f56230d = extentParams.get("user_id");
        }
        return lVar;
    }

    public void a(String str) {
        this.f56231e = str;
    }

    @Override // com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        t.a(jSONObject, "user_id", this.f56230d);
        t.a(jSONObject, "thirdUserId", this.f56231e);
        int i2 = this.a;
        if (i2 != 0) {
            t.a(jSONObject, "thirdAge", i2);
        }
        int i3 = this.f56228b;
        if (i3 != 0) {
            t.a(jSONObject, "thirdGender", i3);
        }
        t.a(jSONObject, "thirdInterest", this.f56229c);
        return jSONObject;
    }
}
