package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class c extends a<Boolean> {
    public c(String str, boolean z) {
        super(str, Boolean.valueOf(z));
    }

    @Override // com.kwad.sdk.core.config.item.a
    public void a(@NonNull SharedPreferences.Editor editor) {
        editor.putBoolean(a(), b().booleanValue());
    }

    @Override // com.kwad.sdk.core.config.item.a
    public void a(@NonNull SharedPreferences sharedPreferences) {
        a((c) Boolean.valueOf(sharedPreferences.getBoolean(a(), c().booleanValue())));
    }

    @Override // com.kwad.sdk.core.config.item.a
    public void a(JSONObject jSONObject) {
        a((c) (jSONObject != null ? Boolean.valueOf(jSONObject.optBoolean(a(), c().booleanValue())) : c()));
    }
}
