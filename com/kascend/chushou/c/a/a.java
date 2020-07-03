package com.kascend.chushou.c.a;

import android.support.annotation.Nullable;
import com.kascend.chushou.c.b;
import org.json.JSONObject;
import tv.chushou.basis.http.listener.JsonCallbackWrapper;
/* loaded from: classes5.dex */
public class a extends JsonCallbackWrapper {
    private b neG;

    public a(b bVar) {
        this.neG = bVar;
    }

    @Override // tv.chushou.basis.http.listener.JsonCallbackWrapper
    public void callStart() {
        if (this.neG != null) {
            this.neG.a();
        }
    }

    @Override // tv.chushou.basis.http.listener.JsonCallbackWrapper
    public void callSuccess(String str, JSONObject jSONObject) {
        if (this.neG != null) {
            this.neG.a(str, jSONObject);
        }
    }

    @Override // tv.chushou.basis.http.listener.JsonCallbackWrapper
    public void callFailure(int i, @Nullable String str, @Nullable String str2) {
        if (this.neG != null) {
            this.neG.a(i, str);
        }
    }
}
