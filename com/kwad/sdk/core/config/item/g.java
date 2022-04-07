package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class g extends a<Float> {
    public g(String str, float f) {
        super(str, Float.valueOf(f));
    }

    @Override // com.kwad.sdk.core.config.item.b
    public void a(@NonNull SharedPreferences.Editor editor) {
        editor.putFloat(b(), a().floatValue());
    }

    @Override // com.kwad.sdk.core.config.item.b
    public void a(@NonNull SharedPreferences sharedPreferences) {
        a((g) Float.valueOf(sharedPreferences.getFloat(b(), c().floatValue())));
    }

    @Override // com.kwad.sdk.core.config.item.b
    public void a(JSONObject jSONObject) {
        a((g) (jSONObject != null ? Float.valueOf((float) jSONObject.optDouble(b(), c().floatValue())) : c()));
    }
}
