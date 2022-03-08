package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class f extends a<Double> {
    public f(String str, Double d2) {
        super(str, d2);
    }

    @Override // com.kwad.sdk.core.config.item.b
    public void a(@NonNull SharedPreferences.Editor editor) {
        editor.putString(b(), a().toString());
    }

    @Override // com.kwad.sdk.core.config.item.b
    public void a(@NonNull SharedPreferences sharedPreferences) {
        a((f) Double.valueOf(Double.parseDouble(sharedPreferences.getString(b(), c().toString()))));
    }

    @Override // com.kwad.sdk.core.config.item.b
    public void a(JSONObject jSONObject) {
        a((f) (jSONObject != null ? Double.valueOf(jSONObject.optDouble(b(), c().doubleValue())) : c()));
    }
}
