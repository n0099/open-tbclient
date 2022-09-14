package com.kwad.sdk.f.kwai;

import android.content.Context;
import android.provider.Settings;
import androidx.annotation.Nullable;
import com.kwad.sdk.utils.r;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class d extends com.kwad.sdk.core.response.kwai.a implements com.kwad.sdk.core.b {
    public int amw = 0;
    public int amx = 0;
    public int amy = 0;
    public int amz = 0;
    public int amA = 0;
    public int amB = 0;
    public int amC = 0;

    public d(Context context) {
        if (context != null) {
            bc(Settings.Secure.getInt(context.getContentResolver(), "adb_enabled", 0) > 0);
        }
    }

    private void a(d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        dVar.amw = jSONObject.optInt("isRoot");
        dVar.amx = jSONObject.optInt("isXPosed");
        dVar.amy = jSONObject.optInt("isFrameworkHooked");
        dVar.amz = jSONObject.optInt("isVirtual");
        dVar.amA = jSONObject.optInt("isAdbEnabled");
        dVar.amB = jSONObject.optInt("isEmulator");
        dVar.amC = jSONObject.optInt("isGroupControl");
        super.afterParseJson(jSONObject);
    }

    public static JSONObject b(d dVar, JSONObject jSONObject) {
        r.putValue(jSONObject, "isRoot", dVar.amw);
        r.putValue(jSONObject, "isXPosed", dVar.amx);
        r.putValue(jSONObject, "isFrameworkHooked", dVar.amy);
        r.putValue(jSONObject, "isVirtual", dVar.amz);
        r.putValue(jSONObject, "isAdbEnabled", dVar.amA);
        r.putValue(jSONObject, "isEmulator", dVar.amB);
        r.putValue(jSONObject, "isGroupControl", dVar.amC);
        return jSONObject;
    }

    private void bc(boolean z) {
        this.amA = bf(z);
    }

    public static int bf(boolean z) {
        return z ? 1 : 2;
    }

    public final void aZ(boolean z) {
        this.amw = bf(z);
    }

    public final void ba(boolean z) {
        this.amx = bf(z);
    }

    public final void bb(boolean z) {
        this.amy = bf(z);
    }

    public final void bd(boolean z) {
        this.amB = bf(z);
    }

    public final void be(boolean z) {
        this.amC = bf(z);
    }

    @Override // com.kwad.sdk.core.response.kwai.a, com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
        a(this, jSONObject);
        afterParseJson(jSONObject);
    }

    @Override // com.kwad.sdk.core.response.kwai.a, com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject b = b(this, new JSONObject());
        afterToJson(b);
        return b;
    }
}
