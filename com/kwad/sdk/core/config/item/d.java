package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class d extends a<Boolean> {
    public d(String str, boolean z) {
        super(str, Boolean.valueOf(z));
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(@NonNull SharedPreferences.Editor editor) {
        editor.putBoolean(a(), b().booleanValue());
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(@NonNull SharedPreferences sharedPreferences) {
        a((d) Boolean.valueOf(sharedPreferences.getBoolean(a(), c().booleanValue())));
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(JSONObject jSONObject) {
        a((d) (jSONObject != null ? Boolean.valueOf(jSONObject.optBoolean(a(), c().booleanValue())) : c()));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.config.item.b
    @NonNull
    /* renamed from: d */
    public final Boolean b() {
        return (Boolean) super.b();
    }
}
