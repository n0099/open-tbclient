package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class e extends a<Float> {
    public e(String str, float f) {
        super(str, Float.valueOf(f));
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(@NonNull SharedPreferences.Editor editor) {
        editor.putFloat(a(), b().floatValue());
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(@NonNull SharedPreferences sharedPreferences) {
        a((e) Float.valueOf(sharedPreferences.getFloat(a(), c().floatValue())));
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(JSONObject jSONObject) {
        a((e) (jSONObject != null ? Float.valueOf((float) jSONObject.optDouble(a(), c().floatValue())) : c()));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.config.item.b
    @NonNull
    /* renamed from: d */
    public final Float b() {
        return (Float) super.b();
    }
}
