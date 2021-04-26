package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class h extends a<Long> {
    public h(String str, Long l) {
        super(str, l);
    }

    @Override // com.kwad.sdk.core.config.item.a
    public void a(@NonNull SharedPreferences.Editor editor) {
        editor.putLong(a(), b().longValue());
    }

    @Override // com.kwad.sdk.core.config.item.a
    public void a(@NonNull SharedPreferences sharedPreferences) {
        a((h) Long.valueOf(sharedPreferences.getLong(a(), c().longValue())));
    }

    @Override // com.kwad.sdk.core.config.item.a
    public void a(JSONObject jSONObject) {
        a((h) (jSONObject != null ? Long.valueOf(jSONObject.optLong(a(), c().longValue())) : c()));
    }
}
