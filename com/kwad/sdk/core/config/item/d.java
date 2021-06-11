package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class d extends a<Float> {
    public d(String str, float f2) {
        super(str, Float.valueOf(f2));
    }

    @Override // com.kwad.sdk.core.config.item.a
    public void a(@NonNull SharedPreferences.Editor editor) {
        editor.putFloat(a(), b().floatValue());
    }

    @Override // com.kwad.sdk.core.config.item.a
    public void a(@NonNull SharedPreferences sharedPreferences) {
        a((d) Float.valueOf(sharedPreferences.getFloat(a(), c().floatValue())));
    }

    @Override // com.kwad.sdk.core.config.item.a
    public void a(JSONObject jSONObject) {
        a((d) (jSONObject != null ? Float.valueOf((float) jSONObject.optDouble(a(), c().floatValue())) : c()));
    }
}
