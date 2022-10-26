package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class e extends a {
    public e(String str, Double d) {
        super(str, d);
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(SharedPreferences sharedPreferences) {
        setValue(Double.valueOf(Double.parseDouble(sharedPreferences.getString(getKey(), ((Double) sx()).toString()))));
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void b(SharedPreferences.Editor editor) {
        editor.putString(getKey(), getValue().toString());
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void e(JSONObject jSONObject) {
        setValue(jSONObject != null ? Double.valueOf(jSONObject.optDouble(getKey(), ((Double) sx()).doubleValue())) : sx());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.config.item.b
    /* renamed from: sz */
    public final Double getValue() {
        return (Double) super.getValue();
    }
}
