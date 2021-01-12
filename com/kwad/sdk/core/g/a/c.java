package com.kwad.sdk.core.g.a;

import com.baidu.tbadk.core.atomData.CameraActivityConfig;
import com.kwad.sdk.utils.o;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c implements com.kwad.sdk.core.b {

    /* renamed from: a  reason: collision with root package name */
    public int f9159a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f9160b = 0;
    public int c = 0;
    public int d = 0;

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, CameraActivityConfig.KEY_CONTENT_TYPE, this.f9159a);
        o.a(jSONObject, "allowInsertThirdAd", this.f9160b);
        o.a(jSONObject, "slideType", this.c);
        o.a(jSONObject, "requestCount", this.d);
        return jSONObject;
    }
}
