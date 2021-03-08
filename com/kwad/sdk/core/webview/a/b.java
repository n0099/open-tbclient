package com.kwad.sdk.core.webview.a;

import androidx.annotation.Nullable;
import com.baidu.live.tbadk.core.atomdata.BuyTBeanActivityConfig;
import com.kwad.sdk.utils.o;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b implements com.kwad.sdk.core.b {

    /* renamed from: a  reason: collision with root package name */
    public String f6321a;
    public String b;
    public String c;

    public void a(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f6321a = jSONObject.optString("action");
        this.b = jSONObject.optString("data");
        this.c = jSONObject.optString(BuyTBeanActivityConfig.CALLBACK);
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, "action", this.f6321a);
        o.a(jSONObject, "data", this.b);
        o.a(jSONObject, BuyTBeanActivityConfig.CALLBACK, this.c);
        return jSONObject;
    }
}
