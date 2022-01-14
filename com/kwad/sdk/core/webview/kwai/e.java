package com.kwad.sdk.core.webview.kwai;

import androidx.annotation.Nullable;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import com.kwad.sdk.utils.t;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e implements com.kwad.sdk.core.b {
    public final int a;

    /* renamed from: b  reason: collision with root package name */
    public final String f56467b;

    public e(int i2, String str) {
        this.a = i2;
        this.f56467b = str;
    }

    @Override // com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        t.a(jSONObject, "result", this.a);
        t.a(jSONObject, GameCodeGetResponseMsg.PARAM_ERROR_MSG, this.f56467b);
        return jSONObject;
    }
}
