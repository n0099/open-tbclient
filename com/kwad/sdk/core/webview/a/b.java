package com.kwad.sdk.core.webview.a;

import androidx.annotation.Nullable;
import com.baidu.live.tbadk.core.atomdata.BuyTBeanActivityConfig;
import com.kwad.sdk.utils.o;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b implements com.kwad.sdk.core.b {

    /* renamed from: a  reason: collision with root package name */
    public String f9540a;

    /* renamed from: b  reason: collision with root package name */
    public String f9541b;
    public String c;

    public void a(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f9540a = jSONObject.optString("action");
        this.f9541b = jSONObject.optString("data");
        this.c = jSONObject.optString(BuyTBeanActivityConfig.CALLBACK);
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, "action", this.f9540a);
        o.a(jSONObject, "data", this.f9541b);
        o.a(jSONObject, BuyTBeanActivityConfig.CALLBACK, this.c);
        return jSONObject;
    }
}
