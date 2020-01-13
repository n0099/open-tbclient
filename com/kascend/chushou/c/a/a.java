package com.kascend.chushou.c.a;

import android.support.annotation.Nullable;
import com.kascend.chushou.c.b;
import org.json.JSONObject;
import tv.chushou.basis.http.listener.JsonCallbackWrapper;
/* loaded from: classes4.dex */
public class a extends JsonCallbackWrapper {
    private b mOf;

    public a(b bVar) {
        this.mOf = bVar;
    }

    @Override // tv.chushou.basis.http.listener.JsonCallbackWrapper
    public void callStart() {
        if (this.mOf != null) {
            this.mOf.a();
        }
    }

    @Override // tv.chushou.basis.http.listener.JsonCallbackWrapper
    public void callSuccess(String str, JSONObject jSONObject) {
        if (this.mOf != null) {
            this.mOf.a(str, jSONObject);
        }
    }

    @Override // tv.chushou.basis.http.listener.JsonCallbackWrapper
    public void callFailure(int i, @Nullable String str, @Nullable String str2) {
        if (this.mOf != null) {
            this.mOf.a(i, str);
        }
    }
}
