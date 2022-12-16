package com.kwad.sdk.core.webview.kwai;

import androidx.annotation.Nullable;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import com.kwad.sdk.utils.r;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class e implements com.kwad.sdk.core.b {
    public final String agk;
    public final int result;

    public e(int i, String str) {
        this.result = i;
        this.agk = str;
    }

    @Override // com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        r.putValue(jSONObject, "result", this.result);
        r.putValue(jSONObject, GameCodeGetResponseMsg.PARAM_ERROR_MSG, this.agk);
        return jSONObject;
    }
}
