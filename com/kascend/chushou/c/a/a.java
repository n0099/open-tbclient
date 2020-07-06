package com.kascend.chushou.c.a;

import android.support.annotation.Nullable;
import com.kascend.chushou.c.b;
import org.json.JSONObject;
import tv.chushou.basis.http.listener.JsonCallbackWrapper;
/* loaded from: classes5.dex */
public class a extends JsonCallbackWrapper {
    private b neJ;

    public a(b bVar) {
        this.neJ = bVar;
    }

    @Override // tv.chushou.basis.http.listener.JsonCallbackWrapper
    public void callStart() {
        if (this.neJ != null) {
            this.neJ.a();
        }
    }

    @Override // tv.chushou.basis.http.listener.JsonCallbackWrapper
    public void callSuccess(String str, JSONObject jSONObject) {
        if (this.neJ != null) {
            this.neJ.a(str, jSONObject);
        }
    }

    @Override // tv.chushou.basis.http.listener.JsonCallbackWrapper
    public void callFailure(int i, @Nullable String str, @Nullable String str2) {
        if (this.neJ != null) {
            this.neJ.a(i, str);
        }
    }
}
