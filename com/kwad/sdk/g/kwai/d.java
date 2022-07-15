package com.kwad.sdk.g.kwai;

import android.content.Context;
import android.provider.Settings;
import androidx.annotation.Nullable;
import com.kwad.sdk.utils.r;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class d extends com.kwad.sdk.core.response.kwai.a implements com.kwad.sdk.core.b {
    public int a = 0;
    public int b = 0;
    public int c = 0;
    public int d = 0;
    public int e = 0;
    public int f = 0;
    public int g = 0;

    public d(Context context) {
        if (context != null) {
            f(Settings.Secure.getInt(context.getContentResolver(), "adb_enabled", 0) > 0);
        }
    }

    private void a(d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        dVar.a = jSONObject.optInt("isRoot");
        dVar.b = jSONObject.optInt("isXPosed");
        dVar.c = jSONObject.optInt("isFrameworkHooked");
        dVar.d = jSONObject.optInt("isVirtual");
        dVar.e = jSONObject.optInt("isAdbEnabled");
        dVar.f = jSONObject.optInt("isEmulator");
        dVar.g = jSONObject.optInt("isGroupControl");
        super.afterParseJson(jSONObject);
    }

    public static JSONObject b(d dVar, JSONObject jSONObject) {
        r.a(jSONObject, "isRoot", dVar.a);
        r.a(jSONObject, "isXPosed", dVar.b);
        r.a(jSONObject, "isFrameworkHooked", dVar.c);
        r.a(jSONObject, "isVirtual", dVar.d);
        r.a(jSONObject, "isAdbEnabled", dVar.e);
        r.a(jSONObject, "isEmulator", dVar.f);
        r.a(jSONObject, "isGroupControl", dVar.g);
        return jSONObject;
    }

    private void f(boolean z) {
        this.e = g(z);
    }

    public static int g(boolean z) {
        return z ? 1 : 2;
    }

    public final void a(boolean z) {
        this.a = g(z);
    }

    public final void b(boolean z) {
        this.b = g(z);
    }

    public final void c(boolean z) {
        this.c = g(z);
    }

    public final void d(boolean z) {
        this.f = g(z);
    }

    public final void e(boolean z) {
        this.g = g(z);
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
