package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class k extends a<Long> {
    public k(String str) {
        this(str, 0L);
    }

    public k(String str, Long l) {
        super(str, l);
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(@NonNull SharedPreferences.Editor editor) {
        editor.putLong(a(), b().longValue());
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(@NonNull SharedPreferences sharedPreferences) {
        a((k) Long.valueOf(sharedPreferences.getLong(a(), c().longValue())));
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(JSONObject jSONObject) {
        a((k) (jSONObject != null ? Long.valueOf(jSONObject.optLong(a(), c().longValue())) : c()));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.config.item.b
    @NonNull
    /* renamed from: d */
    public final Long b() {
        return (Long) super.b();
    }
}
