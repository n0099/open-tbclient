package com.kwad.sdk.k.a;

import android.content.Context;
import android.provider.Settings;
import androidx.annotation.Nullable;
import com.kwad.sdk.utils.t;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class d extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {
    public int aLl = 0;
    public int aLm = 0;
    public int aLn = 0;
    public int aLo = 0;
    public int aLp = 0;
    public int aLq = 0;
    public int aLr = 0;

    public static int bM(boolean z) {
        return z ? 1 : 2;
    }

    public d(Context context) {
        if (context != null) {
            bJ(Settings.Secure.getInt(context.getContentResolver(), "adb_enabled", 0) > 0);
        }
    }

    private void bJ(boolean z) {
        this.aLp = bM(z);
    }

    public final void bG(boolean z) {
        this.aLl = bM(z);
    }

    public final void bH(boolean z) {
        this.aLm = bM(z);
    }

    public final void bI(boolean z) {
        this.aLn = bM(z);
    }

    public final void bK(boolean z) {
        this.aLq = bM(z);
    }

    public final void bL(boolean z) {
        this.aLr = bM(z);
    }

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
        a(this, jSONObject);
        afterParseJson(jSONObject);
    }

    private void a(d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        dVar.aLl = jSONObject.optInt("isRoot");
        dVar.aLm = jSONObject.optInt("isXPosed");
        dVar.aLn = jSONObject.optInt("isFrameworkHooked");
        dVar.aLo = jSONObject.optInt("isVirtual");
        dVar.aLp = jSONObject.optInt("isAdbEnabled");
        dVar.aLq = jSONObject.optInt("isEmulator");
        dVar.aLr = jSONObject.optInt("isGroupControl");
        super.afterParseJson(jSONObject);
    }

    public static JSONObject b(d dVar, JSONObject jSONObject) {
        t.putValue(jSONObject, "isRoot", dVar.aLl);
        t.putValue(jSONObject, "isXPosed", dVar.aLm);
        t.putValue(jSONObject, "isFrameworkHooked", dVar.aLn);
        t.putValue(jSONObject, "isVirtual", dVar.aLo);
        t.putValue(jSONObject, "isAdbEnabled", dVar.aLp);
        t.putValue(jSONObject, "isEmulator", dVar.aLq);
        t.putValue(jSONObject, "isGroupControl", dVar.aLr);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject b = b(this, new JSONObject());
        afterToJson(b);
        return b;
    }
}
