package com.kwad.sdk.core.webview.c;

import androidx.annotation.Nullable;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import com.kwad.sdk.utils.t;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class e implements com.kwad.sdk.core.b {
    public final String alX;
    public final int result;

    @Override // com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
    }

    public e(int i, String str) {
        this.result = i;
        this.alX = str;
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        t.putValue(jSONObject, "result", this.result);
        t.putValue(jSONObject, GameCodeGetResponseMsg.PARAM_ERROR_MSG, this.alX);
        return jSONObject;
    }
}
