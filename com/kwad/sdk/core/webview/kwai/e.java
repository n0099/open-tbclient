package com.kwad.sdk.core.webview.kwai;

import androidx.annotation.Nullable;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import com.kwad.sdk.utils.r;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class e implements com.kwad.sdk.core.b {
    public final int a;
    public final String b;

    public e(int i, String str) {
        this.a = i;
        this.b = str;
    }

    @Override // com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        r.a(jSONObject, "result", this.a);
        r.a(jSONObject, GameCodeGetResponseMsg.PARAM_ERROR_MSG, this.b);
        return jSONObject;
    }
}
