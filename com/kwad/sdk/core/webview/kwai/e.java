package com.kwad.sdk.core.webview.kwai;

import androidx.annotation.Nullable;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import com.kwad.sdk.utils.t;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class e implements com.kwad.sdk.core.b {
    public final int a;

    /* renamed from: b  reason: collision with root package name */
    public final String f40114b;

    public e(int i, String str) {
        this.a = i;
        this.f40114b = str;
    }

    @Override // com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        t.a(jSONObject, "result", this.a);
        t.a(jSONObject, GameCodeGetResponseMsg.PARAM_ERROR_MSG, this.f40114b);
        return jSONObject;
    }
}
