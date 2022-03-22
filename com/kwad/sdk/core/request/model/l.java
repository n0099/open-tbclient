package com.kwad.sdk.core.request.model;

import androidx.annotation.Nullable;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.export.proxy.AdRequestExtentParamsProxy;
import com.kwad.sdk.utils.t;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class l implements com.kwad.sdk.core.b {
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f39848b;

    /* renamed from: c  reason: collision with root package name */
    public String f39849c;

    /* renamed from: d  reason: collision with root package name */
    public String f39850d;

    /* renamed from: e  reason: collision with root package name */
    public String f39851e;

    public static l a() {
        Map<String, String> extentParams;
        l lVar = new l();
        AdRequestExtentParamsProxy requestExtentParamsProxy = KsAdSDKImpl.get().getRequestExtentParamsProxy();
        if (requestExtentParamsProxy != null && (extentParams = requestExtentParamsProxy.getExtentParams()) != null) {
            lVar.f39850d = extentParams.get("user_id");
        }
        return lVar;
    }

    public void a(String str) {
        this.f39851e = str;
    }

    @Override // com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        t.a(jSONObject, "user_id", this.f39850d);
        t.a(jSONObject, "thirdUserId", this.f39851e);
        int i = this.a;
        if (i != 0) {
            t.a(jSONObject, "thirdAge", i);
        }
        int i2 = this.f39848b;
        if (i2 != 0) {
            t.a(jSONObject, "thirdGender", i2);
        }
        t.a(jSONObject, "thirdInterest", this.f39849c);
        return jSONObject;
    }
}
