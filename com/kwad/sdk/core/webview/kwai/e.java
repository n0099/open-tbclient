package com.kwad.sdk.core.webview.kwai;

import androidx.annotation.Nullable;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import com.kwad.sdk.utils.t;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class e implements com.kwad.sdk.core.b {
    public final int a;
    public final String b;

    public e(int i, String str) {
        this.a = i;
        this.b = str;
    }

    @Override // com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        t.a(jSONObject, "result", this.a);
        t.a(jSONObject, GameCodeGetResponseMsg.PARAM_ERROR_MSG, this.b);
        return jSONObject;
    }
}
