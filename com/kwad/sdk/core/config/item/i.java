package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class i extends a<Integer> {
    public i(String str, Integer num) {
        super(str, num);
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(@NonNull SharedPreferences.Editor editor) {
        editor.putInt(a(), b().intValue());
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(@NonNull SharedPreferences sharedPreferences) {
        a((i) Integer.valueOf(sharedPreferences.getInt(a(), c().intValue())));
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(JSONObject jSONObject) {
        a((i) (jSONObject != null ? Integer.valueOf(jSONObject.optInt(a(), c().intValue())) : c()));
    }

    public final boolean d() {
        return b().intValue() == 1;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.config.item.b
    @NonNull
    /* renamed from: e */
    public final Integer b() {
        return (Integer) super.b();
    }
}
