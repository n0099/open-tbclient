package com.kascend.chushou.c.a;

import android.support.annotation.Nullable;
import com.kascend.chushou.c.b;
import org.json.JSONObject;
import tv.chushou.basis.http.listener.JsonCallbackWrapper;
/* loaded from: classes6.dex */
public class a extends JsonCallbackWrapper {
    private b phA;

    public a(b bVar) {
        this.phA = bVar;
    }

    @Override // tv.chushou.basis.http.listener.JsonCallbackWrapper
    public void callStart() {
        if (this.phA != null) {
            this.phA.a();
        }
    }

    @Override // tv.chushou.basis.http.listener.JsonCallbackWrapper
    public void callSuccess(String str, JSONObject jSONObject) {
        if (this.phA != null) {
            this.phA.a(str, jSONObject);
        }
    }

    @Override // tv.chushou.basis.http.listener.JsonCallbackWrapper
    public void callFailure(int i, @Nullable String str, @Nullable String str2) {
        if (this.phA != null) {
            this.phA.a(i, str);
        }
    }
}
