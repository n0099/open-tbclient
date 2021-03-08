package com.kwad.sdk.core.g.a;

import com.baidu.tbadk.core.atomData.CameraActivityConfig;
import com.kwad.sdk.utils.o;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c implements com.kwad.sdk.core.b {

    /* renamed from: a  reason: collision with root package name */
    public int f6097a = 0;
    public int b = 0;
    public int c = 0;
    public int d = 0;

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, CameraActivityConfig.KEY_CONTENT_TYPE, this.f6097a);
        o.a(jSONObject, "allowInsertThirdAd", this.b);
        o.a(jSONObject, "slideType", this.c);
        o.a(jSONObject, "requestCount", this.d);
        return jSONObject;
    }
}
