package com.kwad.sdk.core.g.a;

import com.baidu.platform.comapi.map.MapBundleKey;
import com.kwad.sdk.utils.o;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a implements com.kwad.sdk.core.b {

    /* renamed from: a  reason: collision with root package name */
    public int f9455a;

    /* renamed from: b  reason: collision with root package name */
    public String f9456b;
    public String c;

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, MapBundleKey.MapObjKey.OBJ_LEVEL, this.f9455a);
        o.a(jSONObject, "ssid", this.f9456b);
        o.a(jSONObject, "bssid", this.c);
        return jSONObject;
    }
}
