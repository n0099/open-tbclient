package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class l extends a<Long> {
    public l(String str) {
        this(str, 0L);
    }

    public l(String str, Long l) {
        super(str, l);
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(@NonNull SharedPreferences sharedPreferences) {
        setValue(Long.valueOf(sharedPreferences.getLong(getKey(), sx().longValue())));
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void b(@NonNull SharedPreferences.Editor editor) {
        editor.putLong(getKey(), getValue().longValue());
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void e(JSONObject jSONObject) {
        setValue(jSONObject != null ? Long.valueOf(jSONObject.optLong(getKey(), sx().longValue())) : sx());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.config.item.b
    @NonNull
    /* renamed from: sD */
    public final Long getValue() {
        return (Long) super.getValue();
    }
}
